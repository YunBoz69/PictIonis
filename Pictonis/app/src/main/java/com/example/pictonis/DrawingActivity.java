package com.example.pictonis;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class DrawingActivity extends Activity implements ColorPickerDialog.OnColorChangedListener {

    // TODO: change this to your own Firebase URL
    private static final String FIREBASE_URL = "https://pictonis-73871.firebaseio.com/";

    private static final int COLOR_MENU_ID = Menu.FIRST;

    private DrawingView drawingView;
    private Firebase ref;
    private ValueEventListener connectedListener;

    /**
     * appeler quand l'actibité est créé
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        ref = new Firebase(FIREBASE_URL);
        drawingView = new DrawingView(this, ref);
        setContentView(drawingView);
    }



    @Override
    public void onStart() {
        super.onStart();
        // notifier quand on  esr connecte au firebase
        connectedListener = ref.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String connected = dataSnapshot.getKey();
                if (connected.equals("connected")) {
                } else {
                    Toast.makeText(DrawingActivity.this, "Disconnected from Firebase", Toast.LENGTH_SHORT).show();
                }
            }

            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        // suppr le listener pour qu'il ne soit pas deux fois affecrté
        ref.getRoot().child(".info/connected").removeEventListener(connectedListener);
        drawingView.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, COLOR_MENU_ID, 0, "Color").setShortcut('3', 'c');
        getMenuInflater().inflate(R.menu.drawing,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == COLOR_MENU_ID) {
            new ColorPickerDialog(this, this, 0xFFFF0000).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void colorChanged(int newColor) {
        drawingView.setColor(newColor);
    }


}

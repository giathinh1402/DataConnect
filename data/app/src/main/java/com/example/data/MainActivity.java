package com.example.data;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.text_user);
        final UserDatabase db = Room.databaseBuilder(getApplicationContext(),
                UserDatabase.class, "database-name").build();

        new AsyncTask<Void,Void,Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                User user = new User("nam");
                db.userDao().insert(user);

                List<User> users = db.userDao().getAll();
                Log.i("TAGss", "size" + users.size());

                displayUser(users);
                return null;
            }
        }.execute();
    }

    void displayUser(List<User> users){
        User user = users.get(0);
        txtUser.setText(user.name);
    }
}

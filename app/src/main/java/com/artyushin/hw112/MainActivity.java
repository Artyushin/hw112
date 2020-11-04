package com.artyushin.hw112;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Toolbar toolbar = findViewById (R.id.my_toolbar);
        toolbar.inflateMenu (R.menu.main_menu);
        setSupportActionBar (toolbar);

        listView = findViewById (R.id.list);

        final List<Information> data = DataManager.retrieveInformation ( );

        adapter = new CustomAdapter (data);
        listView.setAdapter (adapter);

        listView.setOnItemLongClickListener (new AdapterView.OnItemLongClickListener ( ) {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String mainTitle = data.get (position).getMainTitle ();
                Toast.makeText(MainActivity.this, mainTitle, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ( ).inflate (R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId ( )) {
            case R.id.main_menu_settings: {
                startActivity (new Intent (Settings.ACTION_SETTINGS));
                return true;
            }
            case R.id.main_menu_note: {
                Intent intent = new Intent (MainActivity.this, NoteActivity.class);
                startActivity (intent);
                return true;
            }
            case R.id.main_menu_login: {
                Intent intent = new Intent (MainActivity.this, LoginActivity.class);
                startActivity (intent);
                return true;
            }
            case R.id.main_menu_payment: {
                Intent intent = new Intent (MainActivity.this, PaymentActivity.class);
                startActivity (intent);
                return true;
            }
        }
        return false;
    }
}
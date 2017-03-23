package com.ruizvilla.frontino_para_explorar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

Intent intent;
    String username, correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras(); // Extrae cosas desde el inten en login, tambien se copia en el perfil
        username = extras.getString("username",username);//
        correo = extras.getString("correo", correo);
    }

    //Esta parte es** la que relaciona un activity con el menu OVERFLOW
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mCerrar:
                intent = new Intent (MainActivity.this, LoginActivity.class);

                startActivity(intent);
                finish();
                break;
            case R.id.mMiPerfil:
                intent = new Intent (MainActivity.this, PerfilActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("correo", correo);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item); //
    }
}


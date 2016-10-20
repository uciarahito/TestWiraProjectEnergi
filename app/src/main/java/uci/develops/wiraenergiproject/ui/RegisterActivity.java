package uci.develops.wiraenergiproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uci.develops.wiraenergiproject.R;
import uci.develops.wiraenergiproject.response.RegisterResponse;
import uci.develops.wiraenergiproject.service.Rest_Client;

public class RegisterActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.txtName)
    protected TextView mName;

    @Bind(R.id.txtEmail)
    protected TextView mEmail;

    @Bind(R.id.txtPassword)
    protected TextView mPassword;

    @Bind(R.id.btn_signup)
    protected Button mRegister;

    @Bind(R.id.btn_signin)
    protected Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = mName.getText().toString();
                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();

                if (name.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Ada field yang kosong!", Toast.LENGTH_SHORT).show();
                } else {
                    Call<RegisterResponse> registerResponseCall = Rest_Client.getRestClient().Register(name, email, password);
                    registerResponseCall.enqueue(new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                            if (response.isSuccessful()) {
//                                Log.e("Test Register", name+"nnnnnnn");
//                                Log.e("Test Register", email+"eeeeeeee");
//                                Log.e("Test Register", password+"ppppppp");
                                Toast.makeText(RegisterActivity.this, "Verifikasi email anda terlebih dahulu!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Log.d("error message", "Error");
                                Toast.makeText(RegisterActivity.this, "Data yang anda isi tidak valid!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Gagal", Toast.LENGTH_SHORT).show();
                            Log.e("RegisterActivity", t.getMessage());
                        }
                    });
                }
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}

package uci.develops.wiraenergiproject.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
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
import uci.develops.wiraenergiproject.helper.SessionApps;
import uci.develops.wiraenergiproject.response.LoginResponse;
import uci.develops.wiraenergiproject.service.Rest_Client;

public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.txtEmail)
    protected TextView mEmail;
    @Bind(R.id.txtPassword)
    protected TextView mPassword;
    @Bind(R.id.btnLogin)
    protected Button mLogin;
    @Bind(R.id.txtRegister)
    protected TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEmail.getText().toString().equals("") || mPassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Username or password is empty!", Toast.LENGTH_SHORT).show();
                } else{
                    final String email = mEmail.getText().toString();
                    final String password = mPassword.getText().toString();
                    Call<LoginResponse> loginResponseCall = Rest_Client.getRestClient().Login(email, password);
                    loginResponseCall.enqueue(new Callback<LoginResponse>() {
                        @Override
                        public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                            String id = "";
                            id = response.body().getId();
                            if (id.equals("0")){
                                Toast.makeText(LoginActivity.this, "Data tidak vaid!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Data valid!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                SessionApps.id_email_login = Integer.parseInt(id);
                                SessionApps.isLogin = true;
                                SessionApps.email_login = email;
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginResponse> call, Throwable t) {
                            Log.e("LoginActivity", "Retrofit Error");
                        }
                    });
                }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id==R.id.nav_profile){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_master_setup){
            if (!SessionApps.isLogin){
                final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Warning!");
                builder.setMessage("Silahkan login terlebih dahulu!");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            } else {
                Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        } else if (id == R.id.nav_purchasing){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_inventory){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_sales_customer){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_reporting){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_utility){
            Intent intent = new Intent(LoginActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

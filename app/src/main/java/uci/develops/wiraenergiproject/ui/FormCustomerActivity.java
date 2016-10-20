package uci.develops.wiraenergiproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import uci.develops.wiraenergiproject.R;

public class FormCustomerActivity extends AppCompatActivity {

    @Bind(R.id.txtID)
    protected TextView mID;

    @Bind(R.id.txtFirstName)
    protected TextView mFirstName;

    @Bind(R.id.txtAddress)
    protected TextView mAddress;

    @Bind(R.id.txtCity)
    protected TextView mCity;

    @Bind(R.id.txtProvince)
    protected TextView mProvince;

    @Bind(R.id.txtZipCode)
    protected TextView mZip;

    @Bind(R.id.txtPhone)
    protected TextView mPhone;

    @Bind(R.id.txtMobile)
    protected TextView mMobile;

    @Bind(R.id.txtFax)
    protected TextView mFax;

    @Bind(R.id.txtTerm)
    protected TextView mTerm;

    @Bind(R.id.spnValuta)
    protected Spinner mValuta;

    @Bind(R.id.txtNPWP)
    protected TextView mNPWP;

    @Bind(R.id.spnTax)
    protected Spinner mTax;

    @Bind(R.id.spnActive)
    protected Spinner mActive;

    @Bind(R.id.txtEmail)
    protected TextView mEmail;

    @Bind(R.id.txtWebsite)
    protected TextView mIWebsite;

    @Bind(R.id.txtNote)
    protected TextView mNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_customer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);


    }

}

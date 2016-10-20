package uci.develops.wiraenergiproject.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import uci.develops.wiraenergiproject.R;

public class CustomerFormActivity extends AppCompatActivity {

    private LinearLayout linearLayout_button_back, linearLayout_button_save, linearLayout_button_cancel, linearLayout_button_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeComponent();
    }

    private void initializeComponent(){
        linearLayout_button_back = (LinearLayout)findViewById(R.id.layout_button_back);
        linearLayout_button_save = (LinearLayout)findViewById(R.id.layout_button_save);
        linearLayout_button_cancel = (LinearLayout)findViewById(R.id.layout_button_cancel);
        linearLayout_button_next = (LinearLayout)findViewById(R.id.layout_button_next);
    }

}

package uci.develops.wiraenergiproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uci.develops.wiraenergiproject.R;

public class FragmentFormCustomerShippingTo extends Fragment {
    public FragmentFormCustomerShippingTo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_form_customer_shipping_to, container, false);

        return view;
    }
}

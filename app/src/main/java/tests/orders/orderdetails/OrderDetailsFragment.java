package tests.orders.orderdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import tests.orders.R;
import tests.orders.authentication.AuthFragment;

public class OrderDetailsFragment extends Fragment {

    public static OrderDetailsFragment newInstance() {
        return new OrderDetailsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_order, container, false);

        TextView tv = (TextView) v.findViewById(R.id.ORDER_NUMBER);
        tv.setText(getActivity().getTitle());

        return v;
    }
}

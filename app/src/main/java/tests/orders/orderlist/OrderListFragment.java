package tests.orders.orderlist;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import tests.orders.R;
import tests.orders.orderdetails.OrderDetailsActivity;

public class OrderListFragment extends Fragment {

    private static final String TAG = OrderListFragment.class.getSimpleName();
    private static final String KEY_LOGIN = TAG + "login";

    @BindView(R.id.txtLogin)
    TextView login;

    @BindView(R.id.list)
    ListView list;

    public static OrderListFragment newInstance(String login) {
        OrderListFragment fragment = new OrderListFragment();

        Bundle arguments = new Bundle();
        arguments.putString(KEY_LOGIN, login);

        fragment.setArguments(arguments);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_orderlist, container, false);

        ButterKnife.bind(this, view);

        initViews();

        return view;
    }

    private void initViews() {
        if (getArguments().getString(KEY_LOGIN) != null)
            login.setText(getArguments().getString(KEY_LOGIN));

        list.setAdapter(new OrderListAdapter(getActivity(), getOrders()));
    }

    private ArrayList<String> getOrders() {
        ArrayList<String> orders = new ArrayList();

        for (int i = 1; i < 26; i++) {
            orders.add("Заказ №" + i);
        }

        return orders;
    }

    @OnItemClick(R.id.list)
    public void onOrderListItemClick(int position) {
        Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}

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

    @BindView(R.id.txtLogin)
    TextView txtLogin;

    @BindView(R.id.lvMain)
    ListView lvMain;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_orderlist, container, false);
        ButterKnife.bind(this, v);
        initViews();
        return v;
        }

    private void initViews() {

        if (getActivity().getIntent().getStringExtra(OrderListActivity.KEY_LOGIN) != null)
            txtLogin.setText(getActivity().getIntent().getStringExtra(OrderListActivity.KEY_LOGIN));

        lvMain.setAdapter(new CustomAdapterBase(getActivity(), getOrders()));
    }

    private ArrayList<String> getOrders() {
        ArrayList<String> orders = new ArrayList();
        for (int i = 1; i < 26; i++) {
            orders.add("Заказ №" + i);
        }
        return orders;
    }

    @OnItemClick(R.id.lvMain)
    public void onOrderListItemClick(int position) {
        Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}

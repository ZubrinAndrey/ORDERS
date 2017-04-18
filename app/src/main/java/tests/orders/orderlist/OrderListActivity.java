package tests.orders.orderlist;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import tests.orders.orderdetails.OrderDetailsActivity;
import tests.orders.R;

public class OrderListActivity extends AppCompatActivity {

    private static final String KEY_LOGIN = "login";

    @BindView(R.id.txtLogin)
    TextView txtLogin;

    @BindView(R.id.lvMain)
    ListView lvMain;

    public static Intent newInstance(Context context, String login) {
        Intent intent = new Intent(context, OrderListActivity.class);
        intent.putExtra(KEY_LOGIN, login);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oderslist);

        ButterKnife.bind(this);

        initViews();

        setTitle(R.string.order_list_title);
    }

    private void initViews() {
        if (getIntent().getStringExtra(KEY_LOGIN) != null)
            txtLogin.setText(getIntent().getStringExtra(KEY_LOGIN));

        lvMain.setAdapter(new CustomAdapterBase(this, getOrders()));
    }

    private ArrayList<String> getOrders() {
        ArrayList<String> orders = new ArrayList();
        for (int i = 1; i < 26 ; i++) {
            orders.add("Заказ №" + i);
        }

        return orders;
    }

    @OnItemClick(R.id.lvMain)
    public void onOrderListItemClick(int position) {
        Intent intent = new Intent(this, OrderDetailsActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        openQuitDialog();
    }

    private void openQuitDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Выход: Вы уверены?")
                .setPositiveButton("Да!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Нет!", null)
                .show();
    }
}

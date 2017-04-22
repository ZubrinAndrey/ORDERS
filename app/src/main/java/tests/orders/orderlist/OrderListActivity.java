package tests.orders.orderlist;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import tests.orders.R;

public class OrderListActivity extends AppCompatActivity {

    public static final String KEY_LOGIN = "login";

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public static Intent newInstance(Context context, String login) {
        Intent intent = new Intent(context, OrderListActivity.class);
        intent.putExtra(KEY_LOGIN, login);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oderslist);

        setTitle(R.string.order_list_title);

        mFragmentManager = getFragmentManager();
        OrderListFragment orderListFragment = new OrderListFragment();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container2, orderListFragment);
        mFragmentTransaction.commit();
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
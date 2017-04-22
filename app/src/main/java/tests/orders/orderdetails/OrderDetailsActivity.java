package tests.orders.orderdetails;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import tests.orders.R;

public class OrderDetailsActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        int position = getIntent().getIntExtra("position", 1);
        position++;
        setTitle("Заказ номер " + position);

        mFragmentManager = getFragmentManager();
        OrderDetailsFragment orderDetailsFragment = new OrderDetailsFragment();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container3, orderDetailsFragment);
        mFragmentTransaction.commit();
    }
}


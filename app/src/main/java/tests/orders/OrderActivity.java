package tests.orders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderActivity extends AppCompatActivity {

    @BindView(R.id.ORDER_NUMBER) TextView txtNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);

        int position = getIntent().getIntExtra("position", 1);
        position++;
        txtNumber.setText("Заказ номер " + String.valueOf(position));

        setTitle("Заказ номер " + position);
    }
}


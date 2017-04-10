package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ThirdActivity extends AppCompatActivity {

    @BindView(R.id.button3)  Button button3;

    private TextView txtNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);

        txtNumber = (TextView) findViewById(R.id.ORDER_NUMBER);
        int position = getIntent().getIntExtra("position", 1);
        position++;
        txtNumber.setText("Заказ номер " + String.valueOf(position));

        setTitle("Заказ номер " + position);
    }

        @OnClick(R.id.button3)
    public void back2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}


package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class ThirdActivity extends AppCompatActivity {

    private TextView txtNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtNumber = (TextView) findViewById(R.id.ORDER_NUMBER);
        int position = getIntent().getIntExtra("position", 1);
        position++;
        txtNumber.setText("Заказ номер " + String.valueOf(position));

        setTitle("Заказ номер " + position);
    }

    public void back2(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}


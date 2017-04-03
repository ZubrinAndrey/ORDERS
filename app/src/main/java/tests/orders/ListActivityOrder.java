package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ListActivityOrder extends AppCompatActivity {

    private TextView txtNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listorder);

        txtNumber = (TextView) findViewById(R.id.order_number);
        txtNumber.setText(getIntent().getStringExtra("order_number"));
        String title = String.valueOf((getIntent().getStringExtra("order_number")));
        setTitle(title);
    }

    public void back3(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
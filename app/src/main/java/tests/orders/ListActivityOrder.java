package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ANDREY on 31.03.2017.
 */

public class ListActivityOrder extends AppCompatActivity {

    private TextView txtNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listorder);

        txtNumber = (TextView) findViewById(R.id.ORDER_NUMBER);
        txtNumber.setText(getIntent().getStringExtra("ORDER_NUMBER"));
        String title = txtNumber.toString();
        setTitle(title);
    }

    public void back3(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }
}
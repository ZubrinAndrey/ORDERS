package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ANDREY on 31.03.2017.
 */

public class SecondActivity extends AppCompatActivity {

    private TextView txtLogin;

    String[] names = {"Заказ1","Заказ2","Заказ3","Заказ4","Заказ5","Заказ6","Заказ7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        txtLogin.setText(getIntent().getStringExtra("login"));


        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        lvMain.setAdapter(adapter);
    }

    public void back (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by ANDREY on 31.03.2017.
 */

public class ListActivity extends android.app.ListActivity {

    final String[] OrdersArray = new String[] { "Заказ1","Заказ2","Заказ3","Заказ4","Заказ5","Заказ6","Заказ7","Заказ8","Заказ9","Заказ10","Заказ11","Заказ12","Заказ13","Заказ14","Заказ15","Заказ16","Заказ17" };

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OrdersArray);
        setListAdapter(mAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
      //  super.onListItemClick(l, v, position, id);
        String orderNumber = getListView().getItemAtPosition(position).toString();

        Intent intent = new Intent(this, ListActivityOrder.class);
        intent.putExtra("ORDER_NUMBER", orderNumber);
        startActivity(intent);
    }
}



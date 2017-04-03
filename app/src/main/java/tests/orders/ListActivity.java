package tests.orders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends android.app.ListActivity {

    final String[] OrdersArray = new String[]{"Заказ 1", "Заказ 2", "Заказ 3", "Заказ 4", "Заказ 5", "Заказ 6", "Заказ 7", "Заказ 8", "Заказ 9", "Заказ 10", "Заказ 11", "Заказ 12", "Заказ 13", "Заказ 14", "Заказ 15", "Заказ 16", "Заказ 17"};

    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, OrdersArray);
        setListAdapter(mAdapter);
        setTitle("Заказы");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String orderNumber = getListView().getItemAtPosition(position).toString();
        Intent intent = new Intent(this, ListActivityOrder.class);
        intent.putExtra("order_number", orderNumber);
        startActivity(intent);
    }
}



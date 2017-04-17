package tests.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterBase extends BaseAdapter {

    ArrayList<String> orders;
    LayoutInflater lInflater;

    public CustomAdapterBase(Context context, ArrayList<String>products){

        orders=products;   // почему нельзя просто orders?
        lInflater = (LayoutInflater) context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        String p = getProduct(position);
        ((TextView) view.findViewById(R.id.tvDescr)).setText(p);
        ((TextView) view.findViewById(R.id.tvPrice)).setText("Стоимость 4500$");
        ((TextView) view.findViewById(R.id.tvSize)).setText("Обьем 3м куб");
        return view;
    }

    String getProduct(int position) {
        return ((String) getItem(position));
    }
}

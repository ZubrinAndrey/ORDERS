package tests.orders.orderlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import tests.orders.R;

public class CustomAdapterBase extends BaseAdapter {

    private ArrayList<String> orders;
    private Context context;

    public CustomAdapterBase(Context context, ArrayList<String> orders){
        this.orders = orders;
        this.context = context;
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, parent, false);
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

package tests.orders.orderlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import tests.orders.R;

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, ArrayList<String> orders) {
        super(context, R.layout.item, orders);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.item, parent, false);

        String singleOrderItem = getItem(position);

        TextView tvDescr = (TextView) customView.findViewById(R.id.tvDescr);
        TextView tvPrice = (TextView) customView.findViewById(R.id.tvPrice);
        TextView tvSize = (TextView) customView.findViewById(R.id.tvSize);

        tvDescr.setText(singleOrderItem);
        tvPrice.setText("Стоимость 4500$");
        tvSize.setText("Обьем 3м куб");

        return customView;
    }
}

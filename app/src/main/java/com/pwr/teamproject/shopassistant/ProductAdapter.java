package com.pwr.teamproject.shopassistant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mokry on 08-May-17.
 */

public class ProductAdapter extends ArrayAdapter<String> {

    private static String DEFAULT_CURRENCY = "zł";
    private static String DEFAULT_DISTANCE = "km";

    private Activity context;
    private Integer[] images;
    private String[] productNames;
    private Double[] productPrices;
    private Double[] closestShopDistance;

    public ProductAdapter(Activity context, Integer[] images, String[] productNames, Double[] productPrices, Double[] closestShopDistance) {
        super(context, R.layout.product, productNames);
        this.context = context;
        this.images = images;
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.closestShopDistance = closestShopDistance;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View rowView= inflater.inflate(R.layout.product, null, true);

        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        TextView productName = (TextView) rowView.findViewById(R.id.productName);
        TextView price = (TextView) rowView.findViewById(R.id.price);
        TextView closestShop = (TextView) rowView.findViewById(R.id.closestShop);

        image.setImageResource(images[position]);
        productName.setText(productNames[position]);
        price.setText(Double.toString(productPrices[position]) + " " + DEFAULT_CURRENCY);
        closestShop.setText(Double.toString(closestShopDistance[position]) + " " + DEFAULT_DISTANCE);

        return rowView;
    }
}

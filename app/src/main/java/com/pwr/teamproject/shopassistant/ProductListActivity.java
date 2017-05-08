package com.pwr.teamproject.shopassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ProductListActivity extends AppCompatActivity {

    // sample data
    ListView list;
    String[] productNames ={
            "Product1",
            "Product2",
            "Product3",
            "Product4",
            "Product5",
            "Product6",
            "Product7"
    };

    Double[] productPrices={
            12.13,
            15.11,
            10.99,
            12.13,
            15.11,
            10.99,
            12.13,
    };

    Double[] closestShops={
            7.3,
            9.2,
            7.3,
            9.2,
            7.3,
            9.2,
            7.3,
    };

    Integer[] images={
            R.drawable.cebula,
            R.drawable.tatra,
            R.drawable.woda,
            R.drawable.cebula,
            R.drawable.tatra,
            R.drawable.woda,
            R.drawable.tatra,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // add back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ProductAdapter productAdapter = new ProductAdapter(this, images, productNames, productPrices, closestShops);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(productAdapter);



    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action Home button
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

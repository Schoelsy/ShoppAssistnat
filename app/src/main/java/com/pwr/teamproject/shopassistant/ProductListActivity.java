package com.pwr.teamproject.shopassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;
import static android.view.ViewGroup.FOCUS_BLOCK_DESCENDANTS;

public class ProductListActivity extends AppCompatActivity {

    // sample data
    ListView myListView;

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
        myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(productAdapter);


        // on product click
        myListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Toast toast = Toast.makeText(getBaseContext(),  "PRODUCT " + id + " CLICKED", Toast.LENGTH_SHORT);
                toast.show();
                openOptionsMenu();

            }
        });


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

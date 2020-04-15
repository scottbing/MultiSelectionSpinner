package com.android.androidcanvasexample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

public class AndroidCanvasExample extends AppCompatActivity implements OnItemSelectedListener {

    private CanvasView customCanvas;
    //private Spinner spinner;
    private MultiSelectionSpinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
        LinearLayout linearLayout = new LinearLayout (this);
        linearLayout.setOrientation (LinearLayout. VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setBackgroundColor(Color.WHITE);

        // Spinner element
        //spinner = (Spinner) findViewById(R.id.spinner);
        //spinner = new Spinner(this);
        spinner = new MultiSelectionSpinner(this);

        ArrayList<Item> items = new ArrayList<>();
        items.add(Item.builder().name("Autumn Oak").value(false).build());
        items.add(Item.builder().name("Douglas Fir").value(false).build());
        items.add(Item.builder().name("Sycamore").value(false).build());
        items.add(Item.builder().name("Elm").value(false).build());
        items.add(Item.builder().name("Red Maple").value(false).build());
        spinner.setItems(items);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        int i = 0;

        /*// Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Tree Species");
        categories.add("Autumn Oak");
        categories.add("Douglas Fir");
        categories.add("Sycamore");
        categories.add("Cherry");
        categories.add("Elm");*/

        // Creating adapter for spinner
        /*ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.R.id.spn_items, items);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
*/
        linearLayout.addView(spinner);

        setContentView(linearLayout);

        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        ArrayList<Item> selectedItems = spinner.getSelectedItems();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        // TODO Auto-generated method stub

    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }

}
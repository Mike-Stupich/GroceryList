package com.personal.mikestupich.grocerylist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GroceryActivity extends AppCompatActivity {
    private FirebaseListAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        ListView groceryList = (ListView) findViewById(R.id.groceryListDisplay);
        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        mAdapter = new FirebaseListAdapter<GroceryItem>(this,GroceryItem.class, android.R.layout.two_line_list_item, ref) {
            @Override
            protected void populateView(View view, GroceryItem item, int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(item.getItemName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(item.getItemCount());
            }
        };
        groceryList.setAdapter(mAdapter);

        final EditText itemName = (EditText) findViewById(R.id.groceryItem);
        final NumberPicker num = (NumberPicker) findViewById(R.id.groceryItemCount);
        findViewById(R.id.AddToList).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ref.push().setValue(new GroceryItem(itemName.getText().toString(),num.getValue()));
                itemName.setText("");
                num.setValue(1);
            }
        });
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.cleanup();
    }
}

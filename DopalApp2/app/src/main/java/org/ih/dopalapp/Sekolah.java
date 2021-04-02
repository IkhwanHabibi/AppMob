package org.ih.dopalapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Sekolah extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[] {"SMAN 8 Pekanbaru", "SMAN Plus Riau", "SMAN 1 Pekanbaru"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listRS));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Object o = this.getListAdapter().getItem(position);
        String pilihan = o.toString();
        tampilpilihan(pilihan);
    }

    private void tampilpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("SMAN 8 Pekanbaru")) {
                a = new Intent(this,sman8.class);
            } else if (pilihan.equals("SMAN Plus Riau")) {
                a = new Intent(this,smanplus.class);
            } else if (pilihan.equals("SMAN 1 Pekanbaru")) {
                a = new Intent(this,sman1.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

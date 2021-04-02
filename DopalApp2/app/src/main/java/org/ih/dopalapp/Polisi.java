package org.ih.dopalapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Polisi extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[] {"Polda Pekanbaru", "Polresta Pekanbaru", "Polsek Sukajadi", "Polsek Tampan"};
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
            if (pilihan.equals("Polresta Pekanbaru")) {
                a = new Intent(this,PolresPku.class);
            } else if (pilihan.equals("Polsek Sukajadi")) {
                a = new Intent(this,PolsekSkd.class);
            } else if (pilihan.equals("Polsek Tampan")) {
                a = new Intent(this,PolsekTmp.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package org.ih.dopalapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RS extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listRS = new String[] {"RS Awal Bros", "RS Eka Hospital", "RS Arifin Achmad", "RS Tabrani"};
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
            if (pilihan.equals("RS Awal Bros")) {
                a = new Intent(this,RSAwalBros.class);
            } else if (pilihan.equals("RS Eka Hospital")) {
                a = new Intent(this,RSEkaHospital.class);
            } else if (pilihan.equals("RS Arifin Achmad")) {
                a = new Intent(this, RSArifinAchmad.class);
            } else if (pilihan.equals("RS Tabrani")) {
                a = new Intent(this,RSTabrani.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

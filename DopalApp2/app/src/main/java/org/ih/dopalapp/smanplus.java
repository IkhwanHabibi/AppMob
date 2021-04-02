package org.ih.dopalapp;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class smanplus extends ListActivity {
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] listAct = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info Google", "Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAct));
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
            if (pilihan.equals("Call Center")) {
                String notel = "tel:+6276141700";
                a = new Intent(Intent.ACTION_DIAL, Uri.parse(notel));
            } else if (pilihan.equals("SMS Center")) {
                String smsText = "Ikhwan Habibi/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:081244444444"));
                a.putExtra("sms_body", smsText );
            } else if (pilihan.equals("Driving Direction")) {
                String lokasirs = "https://goo.gl/maps/HsrRxuHBZmfReAX46";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));
            } else if (pilihan.equals("Website")) {
                String website = "https://smanplus-provriau.sch.id/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));
            } else if (pilihan.equals("Info Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"SMAN Plus Provinsi Riau");
            } else {
                a = new Intent(this,Sekolah.class);
            }
            startActivity(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

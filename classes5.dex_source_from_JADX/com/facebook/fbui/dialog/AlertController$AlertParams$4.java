package com.facebook.fbui.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.fbui.dialog.AlertController.AlertParams;

/* compiled from: reshare_education_info */
class AlertController$AlertParams$4 implements OnItemClickListener {
    final /* synthetic */ ListView f3083a;
    final /* synthetic */ AlertController f3084b;
    final /* synthetic */ AlertParams f3085c;

    AlertController$AlertParams$4(AlertParams alertParams, ListView listView, AlertController alertController) {
        this.f3085c = alertParams;
        this.f3083a = listView;
        this.f3084b = alertController;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.f3085c.E != null) {
            this.f3085c.E[i] = this.f3083a.isItemChecked(i);
        }
        this.f3085c.I.onClick(this.f3084b.f3102b, i, this.f3083a.isItemChecked(i));
    }
}

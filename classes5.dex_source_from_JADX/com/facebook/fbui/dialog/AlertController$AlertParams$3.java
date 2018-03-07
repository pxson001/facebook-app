package com.facebook.fbui.dialog;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.fbui.dialog.AlertController.AlertParams;

/* compiled from: reshare_education_info */
class AlertController$AlertParams$3 implements OnItemClickListener {
    final /* synthetic */ AlertController f3081a;
    final /* synthetic */ AlertParams f3082b;

    AlertController$AlertParams$3(AlertParams alertParams, AlertController alertController) {
        this.f3082b = alertParams;
        this.f3081a = alertController;
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.f3082b.w.onClick(this.f3081a.f3102b, i);
        if (!this.f3082b.G) {
            this.f3081a.f3102b.dismiss();
        }
    }
}

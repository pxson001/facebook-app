package com.facebook.fbui.dialog;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.facebook.fbui.dialog.AlertController.AlertParams;

/* compiled from: reshare_education_info */
class AlertController$AlertParams$1 extends ArrayAdapter<CharSequence> {
    final /* synthetic */ ListView f3074a;
    final /* synthetic */ AlertParams f3075b;

    AlertController$AlertParams$1(AlertParams alertParams, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        this.f3075b = alertParams;
        this.f3074a = listView;
        super(context, i, i2, charSequenceArr);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f3075b.E != null && this.f3075b.E[i]) {
            this.f3074a.setItemChecked(i, true);
        }
        return view2;
    }
}

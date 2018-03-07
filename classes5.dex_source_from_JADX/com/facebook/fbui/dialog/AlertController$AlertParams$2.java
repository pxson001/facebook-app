package com.facebook.fbui.dialog;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import com.facebook.fbui.dialog.AlertController.AlertParams;

/* compiled from: reshare_education_info */
class AlertController$AlertParams$2 extends CursorAdapter {
    final /* synthetic */ ListView f3076a;
    final /* synthetic */ AlertController f3077b;
    final /* synthetic */ AlertParams f3078c;
    private final int f3079d;
    private final int f3080e;

    AlertController$AlertParams$2(AlertParams alertParams, Context context, Cursor cursor, boolean z, ListView listView, AlertController alertController) {
        this.f3078c = alertParams;
        this.f3076a = listView;
        this.f3077b = alertController;
        super(context, cursor, z);
        Cursor cursor2 = getCursor();
        this.f3079d = cursor2.getColumnIndexOrThrow(this.f3078c.K);
        this.f3080e = cursor2.getColumnIndexOrThrow(this.f3078c.L);
    }

    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(2131561855)).setText(cursor.getString(this.f3079d));
        this.f3076a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f3080e) == 1);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3078c.b.inflate(this.f3077b.f3095I, viewGroup, false);
    }
}

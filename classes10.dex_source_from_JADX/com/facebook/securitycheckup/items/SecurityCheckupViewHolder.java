package com.facebook.securitycheckup.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

/* compiled from: id_backed_privacy_checkup_react */
public class SecurityCheckupViewHolder extends ViewHolder {
    public SecurityCheckupItem f9800l;
    public Context f9801m;
    public int f9802n = -1;

    public SecurityCheckupViewHolder(View view, Context context) {
        super(view);
        this.f9801m = context;
    }

    public void mo452a(SecurityCheckupItem securityCheckupItem, int i) {
        this.f9800l = securityCheckupItem;
        this.f9802n = i;
    }
}

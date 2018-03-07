package com.facebook.groups.widget.infoview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;

/* compiled from: THEME_PICKER */
public class InfoTitleRowView extends FbRelativeLayout {
    public TextView f23257a = ((TextView) findViewById(2131563131));
    public TextView f23258b = ((TextView) findViewById(2131563132));

    public InfoTitleRowView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate(2130904897, this, true);
    }

    public final void m24595a(String str) {
        this.f23257a.setText(str);
        this.f23258b.setVisibility(8);
    }

    public final void m24596a(String str, String str2) {
        this.f23257a.setText(str);
        if (!StringUtil.a(str2)) {
            this.f23258b.setVisibility(0);
            this.f23258b.setText(str2);
        }
    }
}

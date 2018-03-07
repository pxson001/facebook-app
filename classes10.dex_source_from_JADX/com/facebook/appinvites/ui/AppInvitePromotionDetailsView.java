package com.facebook.appinvites.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomViewGroup;

/* compiled from: downloading audio failed! */
public class AppInvitePromotionDetailsView extends CustomViewGroup {
    private TextView f14697a;
    private TextView f14698b;
    private String f14699c = "This will be applied automatically.";

    public AppInvitePromotionDetailsView(Context context) {
        super(context);
        m15095a();
    }

    public AppInvitePromotionDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15095a();
    }

    private void m15095a() {
        setContentView(2130903281);
        this.f14697a = (TextView) getView(2131559677);
        this.f14698b = (TextView) getView(2131559678);
    }

    public void setPromotionText(String str) {
        this.f14697a.setText(str);
    }

    public void setPromotionCodeLine(String str) {
        this.f14698b.setText(str);
    }
}

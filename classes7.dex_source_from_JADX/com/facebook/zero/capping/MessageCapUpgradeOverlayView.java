package com.facebook.zero.capping;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;
import java.util.Locale;

/* compiled from: ्इ */
public class MessageCapUpgradeOverlayView extends CustomFrameLayout {
    private View f72a;
    private LinearLayout f73b;
    private TextView f74c;
    private Button f75d;
    private TextView f76e;
    private LinearLayout f77f;
    private TextView f78g;
    private TextView f79h;
    private String f80i;
    private String f81j;
    private OnClickListener f82k;

    public MessageCapUpgradeOverlayView(Context context) {
        super(context);
        m61a();
    }

    public MessageCapUpgradeOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m61a();
    }

    public MessageCapUpgradeOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m61a();
    }

    private void m61a() {
        setContentView(2130905224);
        setBackgroundColor(getResources().getColor(2131362676));
        this.f72a = c(2131563812);
        this.f73b = (LinearLayout) c(2131563816);
        this.f74c = (TextView) c(2131563817);
        this.f75d = (Button) c(2131563818);
        this.f76e = (TextView) c(2131563819);
        this.f77f = (LinearLayout) c(2131563813);
        this.f78g = (TextView) c(2131563814);
        this.f79h = (TextView) c(2131563815);
    }

    public final void m62a(Locale locale, int i, String str, OnClickListener onClickListener, OnClickListener onClickListener2) {
        String string;
        if (i > 0) {
            string = getResources().getString(2131232877, new Object[]{Integer.valueOf(i), str});
        } else {
            string = getResources().getString(2131232876);
        }
        this.f80i = string;
        if (i > 0) {
            string = getResources().getString(2131232879, new Object[]{str.toUpperCase(locale)});
        } else {
            string = getResources().getString(2131232880, new Object[]{str.toUpperCase(locale)});
        }
        this.f81j = string;
        this.f82k = onClickListener;
        this.f76e.setOnClickListener(onClickListener2);
    }

    public final void m63a(boolean z, boolean z2) {
        if (z) {
            this.f73b.setVisibility(8);
            this.f77f.setVisibility(0);
            this.f78g.setText(this.f80i);
            this.f79h.setText(this.f81j);
            this.f79h.setOnClickListener(this.f82k);
        } else {
            this.f77f.setVisibility(8);
            this.f73b.setVisibility(0);
            this.f74c.setText(this.f80i);
            this.f75d.setText(this.f81j);
            this.f75d.setOnClickListener(this.f82k);
        }
        if (z2) {
            this.f72a.setVisibility(0);
        } else {
            this.f72a.setVisibility(8);
        }
    }
}

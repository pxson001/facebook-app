package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: V2_PEOPLE_YOU_MAY_MESSAGE_USER */
public class AdInterfacesInsightsSummaryView extends CustomLinearLayout {
    private BetterTextView f22748a;
    private BetterTextView f22749b;
    private BetterTextView f22750c;
    private BetterTextView f22751d;
    private BetterTextView f22752e;
    private BetterTextView f22753f;

    public AdInterfacesInsightsSummaryView(Context context) {
        super(context);
        m24664b();
    }

    public AdInterfacesInsightsSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24664b();
    }

    public AdInterfacesInsightsSummaryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24664b();
    }

    private void m24664b() {
        setContentView(2130903124);
        this.f22748a = (BetterTextView) a(2131559294);
        this.f22749b = (BetterTextView) a(2131559296);
        this.f22750c = (BetterTextView) a(2131559299);
        this.f22751d = (BetterTextView) a(2131559295);
        this.f22752e = (BetterTextView) a(2131559297);
        this.f22753f = (BetterTextView) a(2131559300);
    }

    public void setFirstDataValue(String str) {
        this.f22748a.setText(str);
    }

    public void setSecondDataValue(String str) {
        this.f22749b.setText(str);
    }

    public void setThirdDataValue(String str) {
        this.f22750c.setText(str);
    }

    public void setFirstDataLabel(String str) {
        this.f22751d.setText(str);
    }

    public void setSecondDataLabel(String str) {
        this.f22752e.setText(str);
    }

    public void setThirdDataLabel(String str) {
        this.f22753f.setText(str);
    }

    public final void m24665a() {
        ((CustomLinearLayout) a(2131559293)).setVisibility(8);
        ((BetterTextView) a(2131559292)).setVisibility(0);
    }
}

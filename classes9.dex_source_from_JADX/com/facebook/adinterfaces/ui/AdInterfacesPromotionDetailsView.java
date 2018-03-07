package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: UsersAfterTimeQuery */
public class AdInterfacesPromotionDetailsView extends CustomLinearLayout {
    private BetterTextView f22877a;
    private BetterTextView f22878b;
    private BetterTextView f22879c;
    private BetterTextView f22880d;
    private FbButton f22881e;
    private LinearLayout f22882f;
    private View f22883g;

    public AdInterfacesPromotionDetailsView(Context context) {
        super(context);
        m24842a();
    }

    public AdInterfacesPromotionDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24842a();
    }

    public AdInterfacesPromotionDetailsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24842a();
    }

    private void m24842a() {
        setContentView(2130903133);
        this.f22877a = (BetterTextView) a(2131559317);
        this.f22879c = (BetterTextView) a(2131559318);
        this.f22878b = (BetterTextView) a(2131559319);
        this.f22883g = a(2131559316);
        this.f22880d = (BetterTextView) a(2131559320);
        this.f22881e = (FbButton) a(2131559198);
        this.f22882f = (LinearLayout) a(2131559321);
    }

    public void setSpentText(String str) {
        this.f22877a.setText(str);
    }

    public void setPaidReach(String str) {
        this.f22878b.setText(str);
    }

    public final void m24843a(String str, String str2) {
        this.f22877a.setText(str);
        this.f22879c.setText(str2);
    }

    public final void m24845b(String str, String str2) {
        this.f22878b.setText(str);
        this.f22880d.setText(str2);
    }

    public final AdInterfacesPromotionDetailsRowView m24846c(String str, String str2) {
        AdInterfacesPromotionDetailsRowView adInterfacesPromotionDetailsRowView = new AdInterfacesPromotionDetailsRowView(getContext(), str, str2);
        this.f22882f.addView(adInterfacesPromotionDetailsRowView);
        return adInterfacesPromotionDetailsRowView;
    }

    public final void m24844a(String str, String str2, OnClickListener onClickListener) {
        m24846c(str, str2).setOnClickListener(onClickListener);
    }

    public void setActionButtonVisibility(int i) {
        this.f22881e.setVisibility(i);
    }

    public void setActionButtonText(String str) {
        this.f22881e.setText(str);
    }

    public void setActionButtonListener(OnClickListener onClickListener) {
        this.f22881e.setOnClickListener(onClickListener);
    }

    public void setColumnsActive(boolean z) {
        this.f22883g.setVisibility(z ? 0 : 8);
    }
}

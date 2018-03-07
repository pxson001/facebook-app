package com.facebook.crowdsourcing.suggestedits.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: click_xout_button_after_submit */
public class SuggestEditsHoursForSingleDayView extends CustomLinearLayout {
    private TextView f17691a;
    private TextView f17692b;

    public SuggestEditsHoursForSingleDayView(Context context) {
        super(context);
        m21555b();
    }

    public SuggestEditsHoursForSingleDayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21555b();
    }

    public SuggestEditsHoursForSingleDayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21555b();
    }

    private void m21555b() {
        setContentView(2130907316);
        this.f17691a = (TextView) a(2131567765);
        this.f17692b = (TextView) a(2131567764);
    }

    public void setDayLabel(String str) {
        this.f17692b.setText(str);
    }

    public void setHours(String str) {
        this.f17691a.setText(str);
        this.f17691a.setTextColor(getResources().getColor(2131361973));
    }

    public final void m21556a() {
        this.f17691a.setText(getResources().getString(2131239148));
        this.f17691a.setTextColor(getResources().getColor(2131361918));
    }
}

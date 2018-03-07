package com.facebook.reaction.feed.rows.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: android.settings.WIFI_SETTINGS */
public class ReactionTitleAndLabelView extends CustomLinearLayout {
    private BetterTextView f19496a;
    private BetterTextView f19497b;

    public ReactionTitleAndLabelView(Context context) {
        super(context);
        m23443a();
    }

    public ReactionTitleAndLabelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m23443a();
    }

    protected ReactionTitleAndLabelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m23443a();
    }

    public void setTitle(String str) {
        this.f19496a.setText(str);
    }

    public void setLabel(String str) {
        this.f19497b.setText(str);
    }

    public void setTitleTextAppearance(int i) {
        this.f19496a.setTextAppearance(this.f19496a.getContext(), i);
    }

    public void setLabelTextAppearance(int i) {
        this.f19497b.setTextAppearance(this.f19497b.getContext(), i);
    }

    private void m23443a() {
        setContentView(2130906720);
        this.f19496a = (BetterTextView) a(2131566788);
        this.f19497b = (BetterTextView) a(2131566789);
    }
}

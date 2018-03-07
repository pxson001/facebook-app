package com.facebook.feedplugins.researchpoll.views;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: bytecode_cache_reads */
public class ResearchPollResultItemView extends CustomLinearLayout {
    private TextView f9139a;
    private TextView f9140b;
    private ProgressBar f9141c;

    public ResearchPollResultItemView(Context context) {
        super(context);
        m9825a();
    }

    public ResearchPollResultItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9825a();
    }

    private final void m9825a() {
        setContentView(2130906833);
        this.f9140b = (TextView) a(2131566974);
        this.f9139a = (TextView) a(2131566975);
        this.f9141c = (ProgressBar) a(2131566976);
    }

    public void setProgress(int i) {
        this.f9140b.setText(i + "%");
        m9826c(i);
    }

    private void m9826c(int i) {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f9141c, "progress", new int[]{i});
        ofInt.setDuration(500);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.start();
    }

    public void setText(String str) {
        this.f9139a.setText(str);
    }
}

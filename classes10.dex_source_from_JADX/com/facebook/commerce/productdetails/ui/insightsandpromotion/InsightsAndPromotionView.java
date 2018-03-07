package com.facebook.commerce.productdetails.ui.insightsandpromotion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: default_option_sent */
public class InsightsAndPromotionView extends CustomFrameLayout {
    private BetterTextView f15257a;
    private BetterTextView f15258b;
    private BetterTextView f15259c;
    private BetterTextView f15260d;
    private FbButton f15261e;
    private FrameLayout f15262f;

    public InsightsAndPromotionView(Context context) {
        super(context);
        m15907a();
    }

    public InsightsAndPromotionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15907a();
    }

    public InsightsAndPromotionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15907a();
    }

    private void m15907a() {
        setContentView(2130906416);
        this.f15257a = (BetterTextView) c(2131559294);
        this.f15258b = (BetterTextView) c(2131559296);
        this.f15259c = (BetterTextView) c(2131559295);
        this.f15260d = (BetterTextView) c(2131559297);
        this.f15261e = (FbButton) c(2131559198);
        this.f15262f = (FrameLayout) c(2131562178);
    }

    public void setFirstDataValue(String str) {
        this.f15257a.setText(str);
    }

    public void setSecondDataValue(String str) {
        this.f15258b.setText(str);
    }

    public void setFirstDataLabel(String str) {
        this.f15259c.setText(str);
    }

    public void setSecondDataLabel(String str) {
        this.f15260d.setText(str);
    }

    public final void m15908a(String str, OnClickListener onClickListener) {
        this.f15262f.setVisibility(0);
        this.f15261e.setVisibility(0);
        this.f15261e.setText(str);
        this.f15261e.setOnClickListener(onClickListener);
    }
}

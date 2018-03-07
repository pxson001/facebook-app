package com.facebook.payments.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.facebook.R;
import com.facebook.resources.utils.ResourceUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: subscribe_menu */
public class FloatingLabelTextView extends CustomLinearLayout {
    private BetterTextView f1971a;
    private BetterTextView f1972b;
    private ProgressBar f1973c;

    public FloatingLabelTextView(Context context) {
        super(context);
        m2206a(context, null);
    }

    public FloatingLabelTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2206a(context, attributeSet);
    }

    protected FloatingLabelTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2206a(context, attributeSet);
    }

    private void m2206a(Context context, @Nullable AttributeSet attributeSet) {
        setContentView(2130904381);
        setOrientation(1);
        this.f1971a = (BetterTextView) a(2131562083);
        this.f1972b = (BetterTextView) a(2131558966);
        this.f1973c = (ProgressBar) a(2131559418);
        m2207b(context, attributeSet);
    }

    private void m2207b(Context context, @Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLabelTextView);
            this.f1972b.setSingleLine(obtainStyledAttributes.getBoolean(0, false));
            setHint(ResourceUtils.a(getContext(), obtainStyledAttributes, 1));
            this.f1971a.setTextSize(0, obtainStyledAttributes.getDimension(2, getResources().getDimension(2131427400)));
            obtainStyledAttributes.recycle();
        }
    }

    public void setHint(int i) {
        this.f1971a.setText(i);
    }

    public void setHint(CharSequence charSequence) {
        this.f1971a.setText(charSequence);
    }

    public void setText(int i) {
        this.f1972b.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.f1972b.setText(charSequence);
    }

    public float getTextSize() {
        return this.f1972b.getTextSize();
    }

    public final void m2208a() {
        this.f1972b.setVisibility(8);
        this.f1973c.setVisibility(0);
    }

    public final void m2209b() {
        this.f1973c.setVisibility(8);
        this.f1972b.setVisibility(0);
    }
}

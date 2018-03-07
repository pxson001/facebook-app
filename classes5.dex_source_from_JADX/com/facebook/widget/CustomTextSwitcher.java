package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;
import com.facebook.R;

/* compiled from: com.google.android.gms.signin.internal.serverClientId */
public class CustomTextSwitcher extends TextSwitcher {
    public boolean f5595a;
    public int f5596b;
    public boolean f5597c;
    public int f5598d;
    public boolean f5599e;
    public float f5600f;

    /* compiled from: com.google.android.gms.signin.internal.serverClientId */
    class C05201 implements ViewFactory {
        final /* synthetic */ CustomTextSwitcher f5594a;

        C05201(CustomTextSwitcher customTextSwitcher) {
            this.f5594a = customTextSwitcher;
        }

        public View makeView() {
            View textView = new TextView(this.f5594a.getContext());
            if (this.f5594a.f5597c) {
                textView.setTextColor(this.f5594a.f5598d);
            }
            if (this.f5594a.f5599e) {
                textView.setTextSize(0, this.f5594a.f5600f);
            }
            if (this.f5594a.f5595a) {
                textView.setTypeface(Typeface.create(Typeface.DEFAULT, this.f5594a.f5596b));
            }
            textView.setGravity(16);
            return textView;
        }
    }

    public CustomTextSwitcher(Context context) {
        super(context);
        m10404a(null);
    }

    public CustomTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10404a(attributeSet);
    }

    private void m10404a(AttributeSet attributeSet) {
        if (getInAnimation() == null) {
            setInAnimation(getContext(), 2130968607);
        }
        if (getOutAnimation() == null) {
            setOutAnimation(getContext(), 2130968608);
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTextSwitcher);
            this.f5597c = obtainStyledAttributes.hasValue(0);
            this.f5598d = obtainStyledAttributes.getColor(0, 0);
            this.f5599e = obtainStyledAttributes.hasValue(2);
            this.f5600f = (float) obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.f5595a = obtainStyledAttributes.hasValue(1);
            this.f5596b = obtainStyledAttributes.getInt(1, 0);
            obtainStyledAttributes.recycle();
        }
        super.setFactory(new C05201(this));
    }
}

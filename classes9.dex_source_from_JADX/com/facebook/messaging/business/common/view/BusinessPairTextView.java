package com.facebook.messaging.business.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.R;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: native_sign_up_secure_intent */
public class BusinessPairTextView extends CustomRelativeLayout {
    private final Context f8801a;
    private final BetterTextView f8802b;
    private final BetterTextView f8803c;
    private Orientation f8804d;
    private boolean f8805e;
    private boolean f8806f;
    private int f8807g;
    private int f8808h;
    private int f8809i;

    /* compiled from: native_sign_up_secure_intent */
    enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    public BusinessPairTextView(Context context) {
        this(context, null, 0);
    }

    public BusinessPairTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected BusinessPairTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903471);
        this.f8801a = context;
        this.f8802b = (BetterTextView) a(2131560106);
        this.f8803c = (BetterTextView) a(2131560107);
        Preconditions.checkNotNull(attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BusinessView);
        setTitle(obtainStyledAttributes.getString(1));
        this.f8804d = Orientation.values()[obtainStyledAttributes.getInt(3, 0)];
        this.f8807g = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f8805e = obtainStyledAttributes.getBoolean(0, false);
        this.f8806f = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        m9033b();
    }

    private void m9033b() {
        this.f8808h = !this.f8805e ? 2131625712 : 2131625714;
        this.f8809i = !this.f8805e ? 2131625713 : 2131625715;
        if (this.f8804d == Orientation.VERTICAL) {
            m9035d();
            this.f8803c.setPadding(0, this.f8807g, 0, 0);
            return;
        }
        m9036e();
        this.f8803c.setPadding(this.f8807g, 0, 0, 0);
    }

    public void setTitle(String str) {
        this.f8802b.setText(str);
    }

    public void setText(@Nullable String str) {
        BetterTextView betterTextView = this.f8803c;
        if (Strings.isNullOrEmpty(str)) {
            str = "-";
        }
        betterTextView.setText(str);
    }

    public void setTitleStyle(int i) {
        this.f8802b.setTextAppearance(this.f8801a, i);
    }

    public void setTextStyle(int i) {
        this.f8803c.setTextAppearance(this.f8801a, i);
    }

    private void m9034c() {
        LayoutParams layoutParams = (LayoutParams) this.f8803c.getLayoutParams();
        ((LayoutParams) this.f8802b.getLayoutParams()).addRule(11);
        layoutParams.addRule(11);
    }

    public final void m9037a() {
        setTitleStyle(2131625714);
        setTextStyle(2131625715);
    }

    private void m9035d() {
        this.f8802b.setTextAppearance(this.f8801a, this.f8808h);
        this.f8803c.setTextAppearance(this.f8801a, this.f8809i);
        ((LayoutParams) this.f8803c.getLayoutParams()).addRule(3, 2131560106);
        if (this.f8806f) {
            m9034c();
        }
    }

    private void m9036e() {
        this.f8802b.setTextAppearance(this.f8801a, this.f8809i);
        this.f8803c.setTextAppearance(this.f8801a, this.f8809i);
        ((LayoutParams) this.f8803c.getLayoutParams()).addRule(11);
    }
}

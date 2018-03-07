package com.facebook.orca.threadview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.FacebookProgressCircleView;

/* compiled from: maybeShowQuickPromotionBanner */
public class ThreadViewVideoStateButton extends CustomFrameLayout {
    private FacebookProgressCircleView f8125a;
    private ImageView f8126b;
    private ImageView f8127c;

    public ThreadViewVideoStateButton(Context context) {
        super(context);
        m8049h();
    }

    public ThreadViewVideoStateButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8049h();
    }

    public ThreadViewVideoStateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8049h();
    }

    private void m8049h() {
        setContentView(2130905923);
        this.f8125a = (FacebookProgressCircleView) c(2131565273);
        this.f8126b = (ImageView) c(2131565272);
        this.f8127c = (ImageView) c(2131565271);
    }

    public final void m8051a() {
        m8050i();
    }

    public final void m8052b() {
        this.f8125a.setProgress(100);
        m8048a(2130842365, 2131231722);
    }

    public final void m8053e() {
        this.f8125a.setProgress(100);
        m8048a(2130842364, 2131231723);
    }

    public final void m8054f() {
        this.f8125a.setProgress(0);
        m8048a(2130842363, 2131231724);
    }

    public final void m8055g() {
        m8050i();
    }

    public void setUploadProgress(double d) {
        this.f8125a.setProgress(90.0d * d);
    }

    private void m8048a(int i, int i2) {
        this.f8126b.setImageResource(i);
        this.f8127c.setContentDescription(getResources().getString(i2));
    }

    private void m8050i() {
        this.f8126b.setImageDrawable(null);
        this.f8127c.setContentDescription(null);
    }
}

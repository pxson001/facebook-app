package com.facebook.feedplugins.pyml.rows.ui;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: notif not from friend for nux */
public class PageYouMayLikeHeaderView extends PagerItemWrapperLayout implements CanShowHeaderOptionsMenu, RecyclableView {
    private LinearLayout f6971a;
    private TextView f6972b;
    private View f6973c;
    private ImageView f6974d;
    private boolean f6975e;

    public PageYouMayLikeHeaderView(Context context) {
        super(context);
        m7264e();
    }

    public PageYouMayLikeHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7264e();
    }

    private void m7264e() {
        setContentView(2130906090);
        this.f6971a = (LinearLayout) c(2131565660);
        this.f6972b = (TextView) c(2131565661);
        this.f6974d = (ImageView) c(2131560877);
        this.f6973c = c(2131565662);
        this.f6972b.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setMenuButtonActive(boolean z) {
        this.f6974d.setVisibility(z ? 0 : 8);
    }

    private boolean m7265f() {
        return this.f6974d.getVisibility() == 0;
    }

    public final boolean hk_() {
        return m7265f();
    }

    public final void m7266a(Tooltip tooltip) {
    }

    public void setHeaderTitle(CharSequence charSequence) {
        m7263a(this.f6972b, charSequence);
        this.f6973c.setVisibility(charSequence != null ? 0 : 8);
    }

    private static void m7263a(TextView textView, CharSequence charSequence) {
        int i = (charSequence == null || charSequence.length() <= 0) ? 8 : 0;
        textView.setText(charSequence);
        textView.setVisibility(i);
    }

    public void setBackgroundResource(int i) {
        this.f6971a.setBackgroundResource(i);
    }

    public void setHasBeenAttached(boolean z) {
        this.f6975e = z;
    }

    public final boolean mo569a() {
        return this.f6975e;
    }
}

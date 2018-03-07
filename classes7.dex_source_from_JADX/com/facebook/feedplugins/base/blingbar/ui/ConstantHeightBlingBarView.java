package com.facebook.feedplugins.base.blingbar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.feedback.ui.BlingBar;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: TAP_X */
public class ConstantHeightBlingBarView extends CustomFrameLayout implements BlingBar {
    int f22905a;
    int f22906b;
    int f22907c;
    private final TextView f22908d;
    private final TextView f22909e;
    private final TextView f22910f;
    private final View f22911g;
    private String f22912h;
    private String f22913i;
    private String f22914j;
    private String f22915k;
    private String f22916l;
    private String f22917m;

    public ConstantHeightBlingBarView(Context context) {
        this(context, null);
    }

    public ConstantHeightBlingBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903391);
        this.f22908d = (TextView) c(2131559915);
        this.f22909e = (TextView) c(2131559916);
        this.f22911g = c(2131559918);
        this.f22910f = (TextView) c(2131559917);
        Resources resources = getResources();
        this.f22912h = resources.getString(2131233554);
        this.f22913i = resources.getString(2131233555);
        this.f22914j = resources.getString(2131233556);
        this.f22915k = resources.getString(2131233557);
        this.f22916l = resources.getString(2131233558);
        this.f22917m = resources.getString(2131233559);
    }

    public void setLikes(int i) {
        m25439a(i, this.f22906b, this.f22907c);
    }

    public void setComments(int i) {
        m25439a(this.f22905a, i, this.f22907c);
    }

    public void setShares(int i) {
        m25439a(this.f22905a, this.f22906b, i);
    }

    public void setIsExpanded(boolean z) {
    }

    public View getLikersCountView() {
        return this.f22908d;
    }

    public View getContainerView() {
        return this.f22911g;
    }

    private void m25439a(int i, int i2, int i3) {
        if (i == 0 && i2 == 0 && i3 == 0) {
            m25438a();
        } else {
            BlingBarUtil.m25437a(this.f22908d, i, this.f22912h, this.f22913i);
            BlingBarUtil.m25437a(this.f22909e, i2, this.f22914j, this.f22915k);
            BlingBarUtil.m25437a(this.f22910f, i3, this.f22916l, this.f22917m);
        }
        this.f22905a = i;
        this.f22906b = i2;
    }

    private void m25438a() {
        this.f22908d.setText(getResources().getString(2131233265));
        this.f22908d.setVisibility(0);
        this.f22909e.setVisibility(8);
    }

    public void setHeight(int i) {
    }
}

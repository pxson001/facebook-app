package com.facebook.feedplugins.base.blingbar.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.feedback.ui.BlingBar;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: TAP_VIDEO */
public class DefaultBlingBarView extends CustomFrameLayout implements BlingBar {
    public static final ViewType f22918a = new C19831();
    private final TextView f22919b;
    private final TextView f22920c;
    private final Optional<TextView> f22921d;
    private final View f22922e;
    private String f22923f;
    private String f22924g;
    private String f22925h;
    private String f22926i;
    private String f22927j;
    private String f22928k;

    /* compiled from: TAP_VIDEO */
    final class C19831 extends ViewType {
        C19831() {
        }

        public final View m25440a(Context context) {
            return new DefaultBlingBarView(context);
        }
    }

    public DefaultBlingBarView(Context context) {
        this(context, null, 2130903391);
    }

    public DefaultBlingBarView(Context context, int i) {
        this(context, null, i);
    }

    public DefaultBlingBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130903391);
    }

    public DefaultBlingBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(i);
        this.f22919b = (TextView) c(2131559915);
        this.f22920c = (TextView) c(2131559916);
        this.f22921d = d(2131559917);
        this.f22922e = c(2131559918);
        Resources resources = getResources();
        this.f22923f = resources.getString(2131233554);
        this.f22924g = resources.getString(2131233555);
        this.f22925h = resources.getString(2131233556);
        this.f22926i = resources.getString(2131233557);
        this.f22927j = resources.getString(2131233558);
        this.f22928k = resources.getString(2131233559);
    }

    public void setLikes(int i) {
        BlingBarUtil.m25437a(this.f22919b, i, this.f22923f, this.f22924g);
    }

    public void setComments(int i) {
        BlingBarUtil.m25437a(this.f22920c, i, this.f22925h, this.f22926i);
    }

    public void setShares(int i) {
        if (this.f22921d.isPresent()) {
            BlingBarUtil.m25437a((TextView) this.f22921d.get(), i, this.f22927j, this.f22928k);
        }
    }

    public void setIsExpanded(boolean z) {
        this.f22922e.setVisibility(z ? 0 : 8);
    }

    public final boolean m25441a() {
        return this.f22922e.getVisibility() == 0;
    }

    public View getLikersCountView() {
        return this.f22919b;
    }

    public View getContainerView() {
        return this.f22922e;
    }

    public void setHeight(int i) {
        View containerView = getContainerView();
        if (containerView.getLayoutParams().height != i) {
            containerView.getLayoutParams().height = i;
            containerView.requestLayout();
        }
    }
}

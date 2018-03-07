package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.BaseMenuPresenter;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.facebook.R;

/* compiled from: unlink */
public abstract class AbsActionBarView extends ViewGroup {
    private static final Interpolator f935j = new DecelerateInterpolator();
    protected final VisibilityAnimListener f936a;
    protected final Context f937b;
    protected ActionMenuView f938c;
    protected ActionMenuPresenter f939d;
    protected ViewGroup f940e;
    protected boolean f941f;
    protected boolean f942g;
    protected int f943h;
    protected ViewPropertyAnimatorCompat f944i;

    /* compiled from: unlink */
    public class VisibilityAnimListener implements ViewPropertyAnimatorListener {
        int f932a;
        final /* synthetic */ AbsActionBarView f933b;
        private boolean f934c = false;

        protected VisibilityAnimListener(AbsActionBarView absActionBarView) {
            this.f933b = absActionBarView;
        }

        public final VisibilityAnimListener m1484a(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, int i) {
            this.f933b.f944i = viewPropertyAnimatorCompat;
            this.f932a = i;
            return this;
        }

        public final void mo87a(View view) {
            this.f933b.setVisibility(0);
            this.f934c = false;
        }

        public final void mo88b(View view) {
            if (!this.f934c) {
                this.f933b.f944i = null;
                this.f933b.setVisibility(this.f932a);
                if (this.f933b.f940e != null && this.f933b.f938c != null) {
                    this.f933b.f938c.setVisibility(this.f932a);
                }
            }
        }

        public final void mo89c(View view) {
            this.f934c = true;
        }
    }

    AbsActionBarView(Context context) {
        this(context, null);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbsActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f936a = new VisibilityAnimListener(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(2130771983, typedValue, true) || typedValue.resourceId == 0) {
            this.f937b = context;
        } else {
            this.f937b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, 2130771984, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(0, 0));
        obtainStyledAttributes.recycle();
        if (this.f939d != null) {
            BaseMenuPresenter baseMenuPresenter = this.f939d;
            if (!baseMenuPresenter.f1281o) {
                baseMenuPresenter.f1280n = baseMenuPresenter.f805b.getResources().getInteger(2131492866);
            }
            if (baseMenuPresenter.f806c != null) {
                baseMenuPresenter.f806c.m1410b(true);
            }
        }
    }

    public void setSplitToolbar(boolean z) {
        this.f941f = z;
    }

    public void setSplitWhenNarrow(boolean z) {
        this.f942g = z;
    }

    public void setContentHeight(int i) {
        this.f943h = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f943h;
    }

    public void setSplitView(ViewGroup viewGroup) {
        this.f940e = viewGroup;
    }

    public int getAnimatedVisibility() {
        if (this.f944i != null) {
            return this.f936a.f932a;
        }
        return getVisibility();
    }

    public void m1491a(int i) {
        if (this.f944i != null) {
            this.f944i.m492a();
        }
        ViewPropertyAnimatorCompat a;
        if (i == 0) {
            if (getVisibility() != 0) {
                ViewCompat.c(this, 0.0f);
                if (!(this.f940e == null || this.f938c == null)) {
                    ViewCompat.c(this.f938c, 0.0f);
                }
            }
            a = ViewCompat.t(this).m487a(1.0f);
            a.m488a(200);
            a.m491a(f935j);
            if (this.f940e == null || this.f938c == null) {
                a.m489a(this.f936a.m1484a(a, i));
                a.m495b();
                return;
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat a2 = ViewCompat.t(this.f938c).m487a(1.0f);
            a2.m488a(200);
            viewPropertyAnimatorCompatSet.m1317a(this.f936a.m1484a(a, i));
            viewPropertyAnimatorCompatSet.m1316a(a).m1316a(a2);
            viewPropertyAnimatorCompatSet.m1319a();
            return;
        }
        a = ViewCompat.t(this).m487a(0.0f);
        a.m488a(200);
        a.m491a(f935j);
        if (this.f940e == null || this.f938c == null) {
            a.m489a(this.f936a.m1484a(a, i));
            a.m495b();
            return;
        }
        viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        a2 = ViewCompat.t(this.f938c).m487a(0.0f);
        a2.m488a(200);
        viewPropertyAnimatorCompatSet.m1317a(this.f936a.m1484a(a, i));
        viewPropertyAnimatorCompatSet.m1316a(a).m1316a(a2);
        viewPropertyAnimatorCompatSet.m1319a();
    }

    public boolean mo344a() {
        if (this.f939d != null) {
            return this.f939d.m1780d();
        }
        return false;
    }

    protected static int m1489a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m1488a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected static int m1490a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}

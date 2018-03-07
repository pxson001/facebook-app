package android.support.v7.internal.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.internal.view.ViewPropertyAnimatorCompatSet;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: unit_type_token */
public class ActionBarContextView extends AbsActionBarView implements ViewPropertyAnimatorListener {
    public CharSequence f998j;
    public CharSequence f999k;
    private View f1000l;
    private View f1001m;
    private LinearLayout f1002n;
    private TextView f1003o;
    private TextView f1004p;
    private int f1005q;
    private int f1006r;
    private Drawable f1007s;
    public boolean f1008t;
    private int f1009u;
    private ViewPropertyAnimatorCompatSet f1010v;
    private boolean f1011w;
    private int f1012x;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130771993);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray a = TintTypedArray.m1693a(context, attributeSet, R.styleable.ActionMode, i, 0);
        setBackgroundDrawable(a.m1695a(3));
        this.f1005q = a.m1704f(1, 0);
        this.f1006r = a.m1704f(2, 0);
        this.h = a.m1703e(0, 0);
        this.f1007s = a.m1695a(4);
        this.f1009u = a.m1704f(5, 2130903046);
        a.m1698b();
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1666665137);
        super.onDetachedFromWindow();
        if (this.f939d != null) {
            this.f939d.m1781e();
            this.f939d.m1783g();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -296923115, a);
    }

    public void setSplitToolbar(boolean z) {
        if (this.f941f != z) {
            if (this.f939d != null) {
                LayoutParams layoutParams = new LayoutParams(-2, -1);
                ViewGroup viewGroup;
                if (z) {
                    this.f939d.m1767a(getContext().getResources().getDisplayMetrics().widthPixels, true);
                    this.f939d.m1776b(Integer.MAX_VALUE);
                    layoutParams.width = -1;
                    layoutParams.height = this.f943h;
                    this.c = (ActionMenuView) this.f939d.mo419a((ViewGroup) this);
                    this.f938c.setBackgroundDrawable(this.f1007s);
                    viewGroup = (ViewGroup) this.f938c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f938c);
                    }
                    this.f940e.addView(this.f938c, layoutParams);
                } else {
                    this.c = (ActionMenuView) this.f939d.mo419a((ViewGroup) this);
                    this.f938c.setBackgroundDrawable(null);
                    viewGroup = (ViewGroup) this.f938c.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(this.f938c);
                    }
                    addView(this.f938c, layoutParams);
                }
            }
            super.setSplitToolbar(z);
        }
    }

    public void setContentHeight(int i) {
        this.h = i;
    }

    public void setCustomView(View view) {
        if (this.f1001m != null) {
            removeView(this.f1001m);
        }
        this.f1001m = view;
        if (this.f1002n != null) {
            removeView(this.f1002n);
            this.f1002n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f998j = charSequence;
        m1514e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f999k = charSequence;
        m1514e();
    }

    public CharSequence getTitle() {
        return this.f998j;
    }

    public CharSequence getSubtitle() {
        return this.f999k;
    }

    private void m1514e() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f1002n == null) {
            LayoutInflater.from(getContext()).inflate(2130903040, this);
            this.f1002n = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1003o = (TextView) this.f1002n.findViewById(2131559114);
            this.f1004p = (TextView) this.f1002n.findViewById(2131559115);
            if (this.f1005q != 0) {
                this.f1003o.setTextAppearance(getContext(), this.f1005q);
            }
            if (this.f1006r != 0) {
                this.f1004p.setTextAppearance(getContext(), this.f1006r);
            }
        }
        this.f1003o.setText(this.f998j);
        this.f1004p.setText(this.f999k);
        Object obj2 = !TextUtils.isEmpty(this.f998j) ? 1 : null;
        if (TextUtils.isEmpty(this.f999k)) {
            obj = null;
        }
        TextView textView = this.f1004p;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f1002n;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f1002n.getParent() == null) {
            addView(this.f1002n);
        }
    }

    public final void m1518a(final ActionMode actionMode) {
        if (this.f1000l == null) {
            this.f1000l = LayoutInflater.from(getContext()).inflate(this.f1009u, this, false);
            addView(this.f1000l);
        } else if (this.f1000l.getParent() == null) {
            addView(this.f1000l);
        }
        this.f1000l.findViewById(2131559116).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f997b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -594989464);
                actionMode.mo250c();
                Logger.a(2, EntryType.UI_INPUT_END, -501084747, a);
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.mo247b();
        if (this.f939d != null) {
            this.f939d.m1782f();
        }
        this.d = new ActionMenuPresenter(getContext());
        this.f939d.m1779c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        if (this.f941f) {
            this.f939d.m1767a(getContext().getResources().getDisplayMetrics().widthPixels, true);
            this.f939d.m1776b(Integer.MAX_VALUE);
            layoutParams.width = -1;
            layoutParams.height = this.f943h;
            menuBuilder.m1402a(this.f939d, this.f937b);
            this.c = (ActionMenuView) this.f939d.mo419a((ViewGroup) this);
            this.f938c.setBackgroundDrawable(this.f1007s);
            this.f940e.addView(this.f938c, layoutParams);
        } else {
            menuBuilder.m1402a(this.f939d, this.f937b);
            this.c = (ActionMenuView) this.f939d.mo419a((ViewGroup) this);
            this.f938c.setBackgroundDrawable(null);
            addView(this.f938c, layoutParams);
        }
        this.f1011w = true;
    }

    public final void m1521b() {
        if (this.f1012x != 2) {
            if (this.f1000l == null) {
                m1523c();
                return;
            }
            m1515f();
            this.f1012x = 2;
            this.f1010v = m1517h();
            this.f1010v.m1319a();
        }
    }

    private void m1515f() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.f1010v;
        if (viewPropertyAnimatorCompatSet != null) {
            this.f1010v = null;
            viewPropertyAnimatorCompatSet.m1320b();
        }
    }

    public final void m1523c() {
        m1515f();
        removeAllViews();
        if (this.f940e != null) {
            this.f940e.removeView(this.f938c);
        }
        this.f1001m = null;
        this.c = null;
        this.f1011w = false;
    }

    public final boolean mo344a() {
        if (this.f939d != null) {
            return this.f939d.m1780d();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.f943h > 0 ? this.f943h : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1000l != null) {
                a = AbsActionBarView.m1489a(this.f1000l, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1000l.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.f938c != null && this.f938c.getParent() == this) {
                paddingLeft = AbsActionBarView.m1489a(this.f938c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1002n != null && this.f1001m == null) {
                if (this.f1008t) {
                    this.f1002n.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1002n.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1002n.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = AbsActionBarView.m1489a(this.f1002n, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1001m != null) {
                int min;
                LayoutParams layoutParams = this.f1001m.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.f1001m.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.f943h <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    private ViewPropertyAnimatorCompatSet m1516g() {
        ViewCompat.a(this.f1000l, (float) ((-this.f1000l.getWidth()) - ((MarginLayoutParams) this.f1000l.getLayoutParams()).leftMargin));
        ViewPropertyAnimatorCompat b = ViewCompat.t(this.f1000l).m493b(0.0f);
        b.m488a(200);
        b.m489a((ViewPropertyAnimatorListener) this);
        b.m491a(new DecelerateInterpolator());
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.m1316a(b);
        if (this.f938c != null) {
            int childCount = this.f938c.getChildCount();
            if (childCount > 0) {
                for (childCount--; childCount >= 0; childCount--) {
                    View childAt = this.f938c.getChildAt(childCount);
                    ViewCompat.f(childAt, 0.0f);
                    ViewPropertyAnimatorCompat f = ViewCompat.t(childAt).m499f(1.0f);
                    f.m488a(300);
                    viewPropertyAnimatorCompatSet.m1316a(f);
                }
            }
        }
        return viewPropertyAnimatorCompatSet;
    }

    private ViewPropertyAnimatorCompatSet m1517h() {
        ViewPropertyAnimatorCompat b = ViewCompat.t(this.f1000l).m493b((float) ((-this.f1000l.getWidth()) - ((MarginLayoutParams) this.f1000l.getLayoutParams()).leftMargin));
        b.m488a(200);
        b.m489a((ViewPropertyAnimatorListener) this);
        b.m491a(new DecelerateInterpolator());
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        viewPropertyAnimatorCompatSet.m1316a(b);
        if (this.f938c != null) {
            this.f938c.getChildCount();
        }
        return viewPropertyAnimatorCompatSet;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = ViewUtils.m1756a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (!(this.f1000l == null || this.f1000l.getVisibility() == 8)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1000l.getLayoutParams();
            int i6 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            i5 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            paddingRight = AbsActionBarView.m1488a(paddingRight, i6, a);
            paddingRight = AbsActionBarView.m1488a(paddingRight + AbsActionBarView.m1490a(this.f1000l, paddingRight, paddingTop, paddingTop2, a), i5, a);
            if (this.f1011w) {
                this.f1012x = 1;
                this.f1010v = m1516g();
                this.f1010v.m1319a();
                this.f1011w = false;
            }
        }
        if (!(this.f1002n == null || this.f1001m != null || this.f1002n.getVisibility() == 8)) {
            paddingRight += AbsActionBarView.m1490a(this.f1002n, paddingRight, paddingTop, paddingTop2, a);
        }
        if (this.f1001m != null) {
            AbsActionBarView.m1490a(this.f1001m, paddingRight, paddingTop, paddingTop2, a);
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f938c != null) {
            boolean z2;
            View view = this.f938c;
            if (a) {
                z2 = false;
            } else {
                z2 = true;
            }
            AbsActionBarView.m1490a(view, i5, paddingTop, paddingTop2, z2);
        }
    }

    public final void mo87a(View view) {
    }

    public final void mo88b(View view) {
        if (this.f1012x == 2) {
            m1523c();
        }
        this.f1012x = 0;
    }

    public final void mo89c(View view) {
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f998j);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1008t) {
            requestLayout();
        }
        this.f1008t = z;
    }

    public final boolean m1525d() {
        return this.f1008t;
    }
}

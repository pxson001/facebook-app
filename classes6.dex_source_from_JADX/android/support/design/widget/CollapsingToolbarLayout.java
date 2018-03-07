package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: purchase_button_text */
public class CollapsingToolbarLayout extends FrameLayout {
    private boolean f6956a;
    private int f6957b;
    private Toolbar f6958c;
    private View f6959d;
    private int f6960e;
    private int f6961f;
    private int f6962g;
    private int f6963h;
    private final Rect f6964i;
    public final CollapsingTextHelper f6965j;
    private boolean f6966k;
    private boolean f6967l;
    public Drawable f6968m;
    public Drawable f6969n;
    private int f6970o;
    private boolean f6971p;
    private ValueAnimatorCompat f6972q;
    private OnOffsetChangedListener f6973r;
    public int f6974s;
    public WindowInsetsCompat f6975t;

    /* compiled from: purchase_button_text */
    class C03952 implements AnimatorUpdateListener {
        final /* synthetic */ CollapsingToolbarLayout f6952a;

        C03952(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f6952a = collapsingToolbarLayout;
        }

        public final void mo847a(ValueAnimatorCompat valueAnimatorCompat) {
            CollapsingToolbarLayout.setScrimAlpha(this.f6952a, valueAnimatorCompat.m10242c());
        }
    }

    /* compiled from: purchase_button_text */
    public class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int f6953a = 0;
        public float f6954b = 0.5f;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: purchase_button_text */
        @interface CollapseMode {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingAppBarLayout_LayoutParams);
            this.f6953a = obtainStyledAttributes.getInt(0, 0);
            this.f6954b = obtainStyledAttributes.getFloat(1, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.widget.FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* compiled from: purchase_button_text */
    class OffsetUpdateListener implements OnOffsetChangedListener {
        final /* synthetic */ CollapsingToolbarLayout f6955a;

        public OffsetUpdateListener(CollapsingToolbarLayout collapsingToolbarLayout) {
            this.f6955a = collapsingToolbarLayout;
        }

        public final void mo872a(AppBarLayout appBarLayout, int i) {
            int b;
            boolean z = false;
            this.f6955a.f6974s = i;
            if (this.f6955a.f6975t != null) {
                b = this.f6955a.f6975t.b();
            } else {
                b = 0;
            }
            int totalScrollRange = appBarLayout.getTotalScrollRange();
            int childCount = this.f6955a.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.f6955a.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper b2 = CollapsingToolbarLayout.m10069b(childAt);
                switch (layoutParams.f6953a) {
                    case 1:
                        if ((this.f6955a.getHeight() - b) + i < childAt.getHeight()) {
                            break;
                        }
                        b2.m10273a(-i);
                        break;
                    case 2:
                        b2.m10273a(Math.round(layoutParams.f6954b * ((float) (-i))));
                        break;
                    default:
                        break;
                }
            }
            if (!(this.f6955a.f6968m == null && this.f6955a.f6969n == null)) {
                CollapsingToolbarLayout collapsingToolbarLayout = this.f6955a;
                if (this.f6955a.getHeight() + i < (ViewCompat.s(this.f6955a) * 2) + b) {
                    z = true;
                }
                collapsingToolbarLayout.setScrimsShown(z);
            }
            if (this.f6955a.f6969n != null && b > 0) {
                ViewCompat.d(this.f6955a);
            }
            this.f6955a.f6965j.m10054b(((float) Math.abs(i)) / ((float) ((this.f6955a.getHeight() - ViewCompat.s(this.f6955a)) - b)));
            if (Math.abs(i) == totalScrollRange) {
                ViewCompat.g(appBarLayout, appBarLayout.f6888e);
            } else {
                ViewCompat.g(appBarLayout, 0.0f);
            }
        }
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return m10071c();
    }

    protected /* synthetic */ android.widget.FrameLayout.LayoutParams m28961generateDefaultLayoutParams() {
        return m10071c();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1706431090);
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            if (this.f6973r == null) {
                this.f6973r = new OffsetUpdateListener(this);
            }
            ((AppBarLayout) parent).m10029a(this.f6973r);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1108310924, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1177776761);
        ViewParent parent = getParent();
        if (this.f6973r != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).m10030b(this.f6973r);
        }
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -225214343, a);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m10066a();
        if (this.f6958c == null && this.f6968m != null && this.f6970o > 0) {
            this.f6968m.mutate().setAlpha(this.f6970o);
            this.f6968m.draw(canvas);
        }
        if (this.f6966k && this.f6967l) {
            this.f6965j.m10052a(canvas);
        }
        if (this.f6969n != null && this.f6970o > 0) {
            int b = this.f6975t != null ? this.f6975t.b() : 0;
            if (b > 0) {
                this.f6969n.setBounds(0, -this.f6974s, getWidth(), b - this.f6974s);
                this.f6969n.mutate().setAlpha(this.f6970o);
                this.f6969n.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m10066a();
        if (view == this.f6958c && this.f6968m != null && this.f6970o > 0) {
            this.f6968m.mutate().setAlpha(this.f6970o);
            this.f6968m.draw(canvas);
        }
        return super.drawChild(canvas, view, j);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 675919718);
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f6968m != null) {
            this.f6968m.setBounds(0, 0, i, i2);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -224050359, a);
    }

    private void m10066a() {
        if (this.f6956a) {
            Toolbar toolbar;
            int childCount = getChildCount();
            int i = 0;
            Toolbar toolbar2 = null;
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (childAt instanceof Toolbar) {
                    if (this.f6957b == -1) {
                        toolbar = (Toolbar) childAt;
                        break;
                    } else if (this.f6957b == childAt.getId()) {
                        toolbar = (Toolbar) childAt;
                        break;
                    } else if (toolbar2 == null) {
                        toolbar = (Toolbar) childAt;
                        i++;
                        toolbar2 = toolbar;
                    }
                }
                toolbar = toolbar2;
                i++;
                toolbar2 = toolbar;
            }
            toolbar = null;
            if (toolbar != null) {
                toolbar2 = toolbar;
            }
            this.f6958c = toolbar2;
            m10070b();
            this.f6956a = false;
        }
    }

    private void m10070b() {
        if (!(this.f6966k || this.f6959d == null)) {
            ViewParent parent = this.f6959d.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f6959d);
            }
        }
        if (this.f6966k && this.f6958c != null) {
            if (this.f6959d == null) {
                this.f6959d = new View(getContext());
            }
            if (this.f6959d.getParent() == null) {
                this.f6958c.addView(this.f6959d, -1, -1);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        m10066a();
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        int i6 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f6966k && this.f6959d != null) {
            this.f6967l = this.f6959d.isShown();
            if (this.f6967l) {
                ViewGroupUtils.m10268a(this, this.f6959d, this.f6964i);
                this.f6965j.m10056b(this.f6964i.left, i4 - this.f6964i.height(), this.f6964i.right, i4);
                if (ViewCompat.h(this) != 1) {
                    i5 = 0;
                }
                CollapsingTextHelper collapsingTextHelper = this.f6965j;
                int i7 = i5 != 0 ? this.f6962g : this.f6960e;
                int i8 = this.f6964i.bottom + this.f6961f;
                int i9 = i3 - i;
                if (i5 != 0) {
                    i5 = this.f6960e;
                } else {
                    i5 = this.f6962g;
                }
                collapsingTextHelper.m10051a(i7, i8, i9 - i5, (i4 - i2) - this.f6963h);
                this.f6965j.m10063g();
            }
        }
        i5 = getChildCount();
        while (i6 < i5) {
            View childAt = getChildAt(i6);
            if (!(this.f6975t == null || ViewCompat.A(childAt))) {
                int b = this.f6975t.b();
                if (childAt.getTop() < b) {
                    childAt.offsetTopAndBottom(b);
                }
            }
            m10069b(childAt).m10272a();
            i6++;
        }
        if (this.f6958c != null) {
            if (this.f6966k && TextUtils.isEmpty(this.f6965j.f6949x)) {
                this.f6965j.m10053a(this.f6958c.v);
            }
            setMinimumHeight(this.f6958c.getHeight());
        }
    }

    public static ViewOffsetHelper m10069b(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(2131558411);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        viewOffsetHelper = new ViewOffsetHelper(view);
        view.setTag(2131558411, viewOffsetHelper);
        return viewOffsetHelper;
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.f6965j.m10053a(charSequence);
    }

    @Nullable
    public CharSequence getTitle() {
        return this.f6966k ? this.f6965j.f6949x : null;
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.f6966k) {
            this.f6966k = z;
            m10070b();
            requestLayout();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = ViewCompat.E(this) && !isInEditMode();
        m10068a(z, z2);
    }

    private void m10068a(boolean z, boolean z2) {
        int i = 255;
        if (this.f6971p != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                m10067a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(this, i);
            }
            this.f6971p = z;
        }
    }

    private void m10067a(int i) {
        m10066a();
        if (this.f6972q == null) {
            this.f6972q = ViewUtils.m10279a();
            this.f6972q.m10237a(600);
            this.f6972q.m10240a(i > this.f6970o ? AnimationUtils.f6856c : AnimationUtils.f6857d);
            this.f6972q.m10239a(new C03952(this));
        } else if (this.f6972q.m10241b()) {
            this.f6972q.m10244e();
        }
        this.f6972q.m10238a(this.f6970o, i);
        this.f6972q.m10235a();
    }

    public static void setScrimAlpha(CollapsingToolbarLayout collapsingToolbarLayout, int i) {
        if (i != collapsingToolbarLayout.f6970o) {
            if (!(collapsingToolbarLayout.f6968m == null || collapsingToolbarLayout.f6958c == null)) {
                ViewCompat.d(collapsingToolbarLayout.f6958c);
            }
            collapsingToolbarLayout.f6970o = i;
            ViewCompat.d(collapsingToolbarLayout);
        }
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        if (this.f6968m != drawable) {
            if (this.f6968m != null) {
                this.f6968m.setCallback(null);
            }
            if (drawable != null) {
                this.f6968m = drawable.mutate();
                drawable.setBounds(0, 0, getWidth(), getHeight());
                drawable.setCallback(this);
                drawable.setAlpha(this.f6970o);
            } else {
                this.f6968m = null;
            }
            ViewCompat.d(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(ContextCompat.a(getContext(), i));
    }

    public Drawable getContentScrim() {
        return this.f6968m;
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        if (this.f6969n != drawable) {
            if (this.f6969n != null) {
                this.f6969n.setCallback(null);
            }
            this.f6969n = drawable;
            drawable.setCallback(this);
            drawable.mutate().setAlpha(this.f6970o);
            ViewCompat.d(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(ContextCompat.a(getContext(), i));
    }

    public Drawable getStatusBarScrim() {
        return this.f6969n;
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.f6965j.m10061e(i);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        this.f6965j.m10050a(i);
    }

    public void setCollapsedTitleGravity(int i) {
        this.f6965j.m10060d(i);
    }

    public int getCollapsedTitleGravity() {
        return this.f6965j.f6935j;
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.f6965j.m10062f(i);
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        this.f6965j.m10055b(i);
    }

    public void setExpandedTitleGravity(int i) {
        this.f6965j.m10058c(i);
    }

    public int getExpandedTitleGravity() {
        return this.f6965j.f6934i;
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f6965j;
        if (collapsingTextHelper.f6946u != typeface) {
            collapsingTextHelper.f6946u = typeface;
            collapsingTextHelper.m10063g();
        }
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.f6965j.m10057c();
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        CollapsingTextHelper collapsingTextHelper = this.f6965j;
        if (collapsingTextHelper.f6947v != typeface) {
            collapsingTextHelper.f6947v = typeface;
            collapsingTextHelper.m10063g();
        }
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        CollapsingTextHelper collapsingTextHelper = this.f6965j;
        return collapsingTextHelper.f6947v != null ? collapsingTextHelper.f6947v : Typeface.DEFAULT;
    }

    public int getExpandedTitleMarginStart() {
        return this.f6960e;
    }

    public void setExpandedTitleMarginStart(int i) {
        this.f6960e = i;
        requestLayout();
    }

    public int getExpandedTitleMarginTop() {
        return this.f6961f;
    }

    public void setExpandedTitleMarginTop(int i) {
        this.f6961f = i;
        requestLayout();
    }

    public int getExpandedTitleMarginEnd() {
        return this.f6962g;
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.f6962g = i;
        requestLayout();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f6963h;
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.f6963h = i;
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private LayoutParams m10071c() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}

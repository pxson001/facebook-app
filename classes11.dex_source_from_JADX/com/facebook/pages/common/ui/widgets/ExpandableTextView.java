package com.facebook.pages.common.ui.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.ui.animation.ExpandAnimation;
import com.facebook.pages.identity.fragments.moreinformation.PageInformationFragment;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: records */
public class ExpandableTextView extends FbTextView {
    private float f2718a;
    private float f2719b;
    public boolean f2720c;
    private boolean f2721d;
    public boolean f2722e;
    private final boolean f2723f;
    private final boolean f2724g;
    private int f2725h;
    public int f2726i;
    private int f2727j;
    private int f2728k;
    private int f2729l;
    private final Rect f2730m;
    public OnExpandCollapseListener f2731n;
    private SparseIntArray f2732o;
    private SparseIntArray f2733p;
    private final AnimationListener f2734q;
    private final AnimationListener f2735r;

    /* compiled from: records */
    class C03611 implements AnimationListener {
        final /* synthetic */ ExpandableTextView f2713a;

        C03611(ExpandableTextView expandableTextView) {
            this.f2713a = expandableTextView;
        }

        public void onAnimationStart(Animation animation) {
            this.f2713a.f2720c = true;
            this.f2713a.setMaxLines(Integer.MAX_VALUE);
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: records */
    class C03622 implements AnimationListener {
        final /* synthetic */ ExpandableTextView f2714a;

        C03622(ExpandableTextView expandableTextView) {
            this.f2714a = expandableTextView;
        }

        public void onAnimationStart(Animation animation) {
            this.f2714a.f2720c = false;
            ExpandableTextView.setFadingGradient(this.f2714a, this.f2714a.getHeight());
        }

        public void onAnimationEnd(Animation animation) {
            this.f2714a.setMaxLines(this.f2714a.f2726i);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: records */
    class ExpandableTextViewCollapseAnimation extends ExpandAnimation {
        final /* synthetic */ ExpandableTextView f2715a;

        public ExpandableTextViewCollapseAnimation(ExpandableTextView expandableTextView, View view, int i, int i2) {
            this.f2715a = expandableTextView;
            super(view, i, i2);
        }

        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            ExpandableTextView.setFadingGradient(this.f2715a, this.f2715a.getLayoutParams().height);
        }
    }

    /* compiled from: records */
    class ExpandableTextViewExpandAnimation extends ExpandAnimation {
        final /* synthetic */ ExpandableTextView f2716a;
        private boolean f2717b = false;

        public ExpandableTextViewExpandAnimation(ExpandableTextView expandableTextView, View view, int i, int i2) {
            this.f2716a = expandableTextView;
            super(view, i, i2);
        }

        protected void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            if (!this.f2717b) {
                if (((double) f) >= 1.0d) {
                    this.f2717b = true;
                    ExpandableTextView.m3657d(this.f2716a);
                    return;
                }
                ExpandableTextView.setFadingGradient(this.f2716a, this.f2716a.getLayoutParams().height);
            }
        }
    }

    /* compiled from: records */
    public interface OnExpandCollapseListener {
        void mo82a();
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2718a = 1.0f;
        this.f2719b = 0.0f;
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableText);
        this.f2728k = obtainStyledAttributes.getColor(1, resources.getColor(2131362990));
        this.f2727j = obtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(2131429810));
        this.f2724g = obtainStyledAttributes.getBoolean(2, false);
        this.f2722e = obtainStyledAttributes.getBoolean(3, false);
        this.f2726i = obtainStyledAttributes.getInteger(4, Integer.MAX_VALUE);
        setMaxLines(this.f2726i);
        this.f2721d = true;
        this.f2720c = false;
        this.f2723f = getContext() instanceof PageInformationFragment;
        this.f2730m = new Rect();
        this.f2733p = new SparseIntArray();
        this.f2732o = new SparseIntArray();
        this.f2729l = getResources().getConfiguration().orientation;
        if (this.f2724g) {
            this.f2734q = new C03611(this);
            this.f2735r = new C03622(this);
        } else {
            this.f2734q = null;
            this.f2735r = null;
        }
        setFocusable(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -917745467);
        if (motionEvent.getAction() != 1) {
            Logger.a(2, EntryType.UI_INPUT_END, 1779552611, a);
        } else if (this.f2720c && (getText() instanceof Spannable) && getMovementMethod().onTouchEvent(this, (Spannable) getText(), motionEvent)) {
            LogUtils.a(1753833182, a);
        } else {
            if (this.f2724g) {
                m3654b();
            } else {
                m3656c();
            }
            LogUtils.a(-847392686, a);
        }
        return true;
    }

    public void setOnExpandCollapseListener(OnExpandCollapseListener onExpandCollapseListener) {
        this.f2731n = onExpandCollapseListener;
    }

    private void m3654b() {
        Animation expandableTextViewExpandAnimation;
        if (!this.f2720c) {
            if (this.f2725h < this.f2726i) {
                this.f2726i = this.f2725h;
            }
            expandableTextViewExpandAnimation = new ExpandableTextViewExpandAnimation(this, this, getHeight(), getExpandedStateHeight());
            expandableTextViewExpandAnimation.setDuration(300);
            expandableTextViewExpandAnimation.setAnimationListener(this.f2734q);
            startAnimation(expandableTextViewExpandAnimation);
            if (this.f2731n != null) {
                this.f2731n.mo82a();
            }
        } else if (this.f2722e) {
            getLocalVisibleRect(this.f2730m);
            if (this.f2723f && this.f2730m.top > 0) {
                ((PageInformationFragment) getContext()).m4943c(-this.f2730m.top);
            }
            expandableTextViewExpandAnimation = new ExpandableTextViewCollapseAnimation(this, this, getHeight(), getCollapsedStateHeight());
            expandableTextViewExpandAnimation.setDuration(300);
            expandableTextViewExpandAnimation.setAnimationListener(this.f2735r);
            startAnimation(expandableTextViewExpandAnimation);
        }
    }

    private void m3656c() {
        if (!this.f2720c) {
            if (this.f2725h < this.f2726i) {
                this.f2726i = this.f2725h;
            }
            this.f2720c = true;
            setMaxLines(Integer.MAX_VALUE);
            m3657d(this);
            if (this.f2731n != null) {
                this.f2731n.mo82a();
            }
        } else if (this.f2722e) {
            getLocalVisibleRect(this.f2730m);
            if (this.f2723f && this.f2730m.top > 0) {
                ((PageInformationFragment) getContext()).m4943c(-this.f2730m.top);
            }
            this.f2720c = false;
            setMaxLines(this.f2726i);
            setFadingGradient(this, getCollapsedStateHeight());
        }
    }

    public static void setFadingGradient(ExpandableTextView expandableTextView, int i) {
        expandableTextView.getPaint().setShader(new LinearGradient(0.0f, (float) (i - expandableTextView.f2727j), 0.0f, (float) i, expandableTextView.getCurrentTextColor(), expandableTextView.f2728k, TileMode.CLAMP));
    }

    public static void m3657d(ExpandableTextView expandableTextView) {
        expandableTextView.getPaint().setShader(null);
    }

    public void setIsExpanded(boolean z) {
        this.f2720c = z;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f2721d) {
            if (!this.f2720c && getLineCount() <= this.f2725h) {
                this.f2720c = true;
                this.f2722e = false;
                m3657d(this);
            } else if (getLineCount() > this.f2725h) {
                this.f2720c = false;
                setFadingGradient(this, getHeight());
            }
            this.f2721d = false;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2721d = true;
        if (getLayoutParams() != null) {
            getLayoutParams().height = -2;
        }
        if (this.f2732o != null) {
            this.f2732o.clear();
        }
        if (this.f2733p != null) {
            this.f2733p.clear();
        }
        super.onTextChanged(charSequence, i, i2, i3);
    }

    public void setMaxLines(int i) {
        this.f2725h = i;
        super.setMaxLines(i);
    }

    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.f2718a = f2;
        this.f2719b = f;
    }

    private boolean m3658e() {
        return this.f2722e;
    }

    public void setCanCollapse(boolean z) {
        this.f2722e = z;
    }

    public int getGradientLength() {
        return this.f2727j;
    }

    public void setGradientLength(int i) {
        this.f2727j = i;
    }

    public int getGradientEndColor() {
        return this.f2728k;
    }

    public void setGradientEndColor(int i) {
        this.f2728k = i;
    }

    public final void m3660a() {
        setMovementMethod(LinkMovementMethod.getInstance());
        setFocusable(false);
    }

    private void m3659f() {
        if (this.f2733p.indexOfKey(this.f2729l) <= 0 || this.f2732o.indexOfKey(this.f2729l) <= 0) {
            StaticLayout staticLayout = new StaticLayout(getText(), getPaint(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), Alignment.ALIGN_NORMAL, this.f2718a, this.f2719b, true);
            this.f2732o.put(this.f2729l, (staticLayout.getHeight() + getCompoundPaddingBottom()) + getCompoundPaddingTop());
            this.f2733p.put(this.f2729l, (staticLayout.getLineTop(this.f2726i) + getCompoundPaddingTop()) + getCompoundPaddingBottom());
        }
    }

    private int getExpandedStateHeight() {
        m3659f();
        return this.f2732o.get(this.f2729l);
    }

    private int getCollapsedStateHeight() {
        m3659f();
        return this.f2733p.get(this.f2729l);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (this.f2729l != configuration.orientation) {
            this.f2729l = configuration.orientation;
            getLayoutParams().height = -2;
        }
    }
}

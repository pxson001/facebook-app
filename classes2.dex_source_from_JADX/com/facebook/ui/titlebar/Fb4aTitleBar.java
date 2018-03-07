package com.facebook.ui.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.apptab.ui.BadgableGlyphView;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.statusbar.StatusBarUtil;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.AllCapsTransformationMethod;
import com.facebook.widget.titlebar.CanDisplaySearchButton;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rewrite_enabled */
public class Fb4aTitleBar extends CustomLinearLayout implements CanDisplaySearchButton, FbTitleBar {
    private static final boolean f6597m = (VERSION.SDK_INT >= 21);
    @Inject
    RTLUtil f6598a;
    @Inject
    AnalyticsTagger f6599b;
    @Inject
    ViewAccessibilityHelper f6600c;
    @Inject
    StatusBarUtil f6601d;
    protected final TextView f6602e;
    protected final ViewGroup f6603f;
    protected final LinearLayout f6604g;
    @Nullable
    protected ImageView f6605h;
    protected TitleBarState f6606i;
    public OnClickListener f6607j;
    protected OnSizeChangedListener f6608k;
    protected FrameLayout f6609l;
    private boolean f6610n;
    public final TitleBarActionButton f6611o;
    private final TitleBarActionButton f6612p;
    private ImageView f6613q;
    private RestoreStateForModalDoneAction f6614r;
    public final AllCapsTransformationMethod f6615s;

    /* compiled from: rewrite_enabled */
    public enum TitleBarState {
        TEXT,
        SEARCH_TITLES_APP,
        CUSTOM
    }

    /* compiled from: rewrite_enabled */
    public class TitleBarActionButton {
        final /* synthetic */ Fb4aTitleBar f6940a;
        public View f6941b;
        public ImageWithTextView f6942c;
        private final int f6943d;
        private final int f6944e;
        public TitleBarButtonSpec f6945f;
        public OnToolbarButtonListener f6946g;
        public OnActionButtonClickListener f6947h;
        private final OnClickListener f6948i;

        public TitleBarActionButton(final Fb4aTitleBar fb4aTitleBar, int i, int i2) {
            this.f6940a = fb4aTitleBar;
            this.f6943d = i;
            this.f6944e = i2;
            this.f6948i = new OnClickListener(this) {
                final /* synthetic */ TitleBarActionButton f6950b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1786468191);
                    if (this.f6950b.f6946g != null) {
                        if (this.f6950b.f6945f != null) {
                            this.f6950b.f6946g.a(view, this.f6950b.f6945f);
                        }
                    } else if (this.f6950b.f6947h != null) {
                        this.f6950b.f6947h.mo1673a(view);
                    }
                    LogUtils.a(1106025023, a);
                }
            };
        }

        @Nullable
        public final View m11531a() {
            return this.f6941b;
        }

        public final void m11533a(@Nullable OnToolbarButtonListener onToolbarButtonListener) {
            this.f6946g = onToolbarButtonListener;
        }

        public final void m11532a(OnActionButtonClickListener onActionButtonClickListener) {
            this.f6947h = onActionButtonClickListener;
        }

        private void m11529d() {
            if (this.f6941b != null) {
                this.f6941b.setVisibility(8);
            }
            if (this.f6942c != null) {
                this.f6942c.setVisibility(8);
            }
        }

        public final TitleBarButtonSpec m11534b() {
            return this.f6945f;
        }

        public final OnActionButtonClickListener m11535c() {
            return this.f6947h;
        }

        private void m11525a(@Nullable TitleBarButtonSpec titleBarButtonSpec) {
            this.f6940a.f6602e.requestLayout();
            if (titleBarButtonSpec == null || titleBarButtonSpec == TitleBarButtonSpec.f7575b) {
                this.f6945f = null;
                m11529d();
                return;
            }
            if (this.f6941b != null) {
                this.f6940a.f6604g.removeView(this.f6941b);
                this.f6941b = null;
            }
            if (this.f6942c != null) {
                this.f6940a.f6604g.removeView(this.f6942c);
                this.f6942c = null;
            }
            this.f6945f = titleBarButtonSpec;
            int c = ContextUtils.m2503c(this.f6940a.getContext(), 2130772518, 0);
            if (titleBarButtonSpec.f7581h != -1) {
                this.f6941b = LayoutInflater.from(this.f6940a.getContext()).inflate(this.f6943d, this.f6940a.f6604g, false);
                if (this.f6941b instanceof BadgableGlyphView) {
                    ((BadgableGlyphView) this.f6941b).m11628a(this.f6940a.getResources().getDrawable(titleBarButtonSpec.f7581h), c);
                } else {
                    ((ImageButton) this.f6941b).setImageResource(titleBarButtonSpec.f7581h);
                }
                this.f6941b.setVisibility(0);
                this.f6940a.f6604g.addView(this.f6941b);
            } else if (titleBarButtonSpec.f7577d != null) {
                this.f6941b = LayoutInflater.from(this.f6940a.getContext()).inflate(this.f6943d, this.f6940a.f6604g, false);
                if (this.f6941b instanceof BadgableGlyphView) {
                    Drawable drawable = titleBarButtonSpec.f7577d;
                    if (titleBarButtonSpec.f7589p) {
                        ((BadgableGlyphView) this.f6941b).m11628a(drawable, c);
                    } else {
                        ((BadgableGlyphView) this.f6941b).setGlyphImage(drawable);
                    }
                } else if (this.f6941b instanceof ImageButton) {
                    ((ImageButton) this.f6941b).setImageDrawable(titleBarButtonSpec.f7577d);
                }
                this.f6941b.setVisibility(0);
                this.f6940a.f6604g.addView(this.f6941b);
            } else if (titleBarButtonSpec.f7582i != null) {
                CharSequence transformation;
                this.f6942c = (ImageWithTextView) LayoutInflater.from(this.f6940a.getContext()).inflate(this.f6944e, this.f6940a.f6604g, false);
                ImageWithTextView imageWithTextView = this.f6942c;
                if (titleBarButtonSpec.f7590q) {
                    transformation = this.f6940a.f6615s.getTransformation(titleBarButtonSpec.f7582i, this.f6940a);
                } else {
                    Object obj = titleBarButtonSpec.f7582i;
                }
                imageWithTextView.setText(transformation);
                this.f6942c.setVisibility(0);
                this.f6940a.f6604g.addView(this.f6942c);
            }
            if (this.f6941b != null) {
                this.f6941b.setSelected(titleBarButtonSpec.f7592s);
            }
            if (this.f6942c != null) {
                this.f6942c.setEnabled(titleBarButtonSpec.f7593t);
            }
            String str = titleBarButtonSpec.f7584k;
            if (str != null) {
                if (this.f6941b != null) {
                    this.f6941b.setContentDescription(str);
                }
                if (this.f6942c != null) {
                    this.f6942c.setContentDescription(str);
                }
            }
            if (this.f6941b != null) {
                this.f6941b.setOnClickListener(this.f6948i);
            }
            if (this.f6942c != null) {
                this.f6942c.setOnClickListener(this.f6948i);
            }
        }
    }

    /* compiled from: rewrite_enabled */
    public interface OnSizeChangedListener {
        void mo1641a();
    }

    /* compiled from: rewrite_enabled */
    /* synthetic */ class C03123 {
        static final /* synthetic */ int[] f7430a = new int[TitleBarState.values().length];

        static {
            try {
                f7430a[TitleBarState.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7430a[TitleBarState.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: rewrite_enabled */
    public interface OnActionButtonClickListener {
        void mo1673a(View view);
    }

    private static <T extends View> void m11443a(Class<T> cls, T t) {
        m11444a((Object) t, t.getContext());
    }

    private static void m11444a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((Fb4aTitleBar) obj).m11442a(RTLUtil.m6553a(injectorLike), AnalyticsTagger.m11473a(injectorLike), ViewAccessibilityHelper.m8774a(injectorLike), StatusBarUtil.m11479a(injectorLike));
    }

    private void m11442a(RTLUtil rTLUtil, AnalyticsTagger analyticsTagger, ViewAccessibilityHelper viewAccessibilityHelper, StatusBarUtil statusBarUtil) {
        this.f6598a = rTLUtil;
        this.f6599b = analyticsTagger;
        this.f6600c = viewAccessibilityHelper;
        this.f6601d = statusBarUtil;
    }

    public Fb4aTitleBar(Context context) {
        this(context, null);
    }

    public Fb4aTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Fb4aTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6610n = false;
        this.f6606i = TitleBarState.TEXT;
        this.f6614r = null;
        this.f6615s = new AllCapsTransformationMethod(getContext());
        m11443a(Fb4aTitleBar.class, (View) this);
        this.f6599b.m11478a((View) this, "titlebar", getClass());
        LayoutInflater.from(context).inflate(2130907486, this);
        this.f6602e = (TextView) m8506a(2131558927);
        this.f6603f = (ViewGroup) m8506a(2131567988);
        this.f6604g = (LinearLayout) m8506a(2131567990);
        this.f6611o = new TitleBarActionButton(this, 2130907488, 2130907490);
        this.f6612p = new TitleBarActionButton(this, 2130907492, 2130907494);
        this.f6605h = (ImageView) m8506a(2131567986);
        this.f6609l = (FrameLayout) m8506a(2131567987);
        this.f6600c.m8778a(this.f6605h, 2);
        mo1611h();
        setTitleBarState(TitleBarState.TEXT);
    }

    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec((this.f6610n ? getHeightSupportTransparentStatusBar() : 0) + getResources().getDimensionPixelSize(2131428150), 1073741824));
    }

    protected int getButtonWidths() {
        return this.f6604g.getWidth();
    }

    public void setPrimaryButton(@Nullable TitleBarButtonSpec titleBarButtonSpec) {
        this.f6611o.m11525a(titleBarButtonSpec);
        this.f6612p.m11525a(null);
        this.f6604g.requestLayout();
    }

    public void setSecondaryButton(@Nullable TitleBarButtonSpec titleBarButtonSpec) {
        this.f6612p.m11525a(titleBarButtonSpec);
        this.f6604g.requestLayout();
    }

    public TitleBarButtonSpec getPrimaryButtonSpec() {
        return this.f6611o.f6945f;
    }

    public TitleBarButtonSpec getSecondaryButtonSpec() {
        return this.f6612p.f6945f;
    }

    public void setActionButtonOnClickListener(OnActionButtonClickListener onActionButtonClickListener) {
        this.f6611o.f6947h = onActionButtonClickListener;
    }

    public void setSecondaryActionButtonOnClickListener(OnActionButtonClickListener onActionButtonClickListener) {
        this.f6612p.f6947h = onActionButtonClickListener;
    }

    public OnActionButtonClickListener getSecondaryActionButtonOnClickListener() {
        return this.f6612p.f6947h;
    }

    public final void m11452a(OnActionButtonClickListener onActionButtonClickListener, OnActionButtonClickListener onActionButtonClickListener2) {
        this.f6611o.f6947h = onActionButtonClickListener;
        this.f6612p.f6947h = onActionButtonClickListener2;
    }

    protected void setTitleBarState(TitleBarState titleBarState) {
        if (this.f6606i != titleBarState) {
            this.f6603f.setVisibility(8);
            this.f6602e.setVisibility(8);
            switch (C03123.f7430a[titleBarState.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    this.f6602e.setVisibility(0);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    this.f6603f.setVisibility(0);
                    break;
            }
            this.f6606i = titleBarState;
        }
    }

    public void setButtonSpecs(List<TitleBarButtonSpec> list) {
        TitleBarButtonSpec titleBarButtonSpec;
        TitleBarButtonSpec titleBarButtonSpec2 = null;
        if (list == null || list.size() <= 1) {
            titleBarButtonSpec = (list == null || list.isEmpty()) ? null : (TitleBarButtonSpec) list.get(0);
        } else {
            titleBarButtonSpec = (TitleBarButtonSpec) list.get(0);
            titleBarButtonSpec2 = (TitleBarButtonSpec) list.get(1);
        }
        this.f6611o.m11525a(titleBarButtonSpec);
        this.f6612p.m11525a(titleBarButtonSpec2);
        this.f6604g.requestLayout();
    }

    public void setShowDividers(boolean z) {
    }

    public void setOnToolbarButtonListener(@Nullable OnToolbarButtonListener onToolbarButtonListener) {
        this.f6611o.f6946g = onToolbarButtonListener;
        this.f6612p.f6946g = onToolbarButtonListener;
    }

    public void setTitle(String str) {
        this.f6602e.setText(str);
        setTitleBarState(TitleBarState.TEXT);
    }

    public String getTitle() {
        return this.f6602e.getText().toString();
    }

    public void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    public final View f_(int i) {
        View inflate = LayoutInflater.from(getContext()).inflate(i, this.f6603f, false);
        setCustomTitleView(inflate);
        return inflate;
    }

    public void setCustomTitleView(@Nullable View view) {
        if (mo1618a()) {
            this.f6603f.removeAllViews();
            if (view == null) {
                setTitleBarState(TitleBarState.TEXT);
                return;
            }
            setTitleBarState(TitleBarState.CUSTOM);
            this.f6603f.addView(view);
        }
    }

    public final boolean mo1618a() {
        return true;
    }

    public void setHasBackButton(boolean z) {
    }

    public void setHasFbLogo(boolean z) {
        if (z) {
            mo1243g();
        } else {
            m11457d();
        }
    }

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
    }

    public void setSearchButtonVisible(boolean z) {
        if (z) {
            if (this.f6613q == null || this.f6613q.getVisibility() != 0) {
                this.f6613q = (ImageView) LayoutInflater.from(getContext()).inflate(2130907491, this.f6604g, false);
                this.f6613q.setOnClickListener(this.f6607j);
                this.f6604g.addView(this.f6613q);
                this.f6613q.setVisibility(0);
            }
        } else if (this.f6613q != null) {
            this.f6604g.removeView(this.f6613q);
            this.f6613q = null;
        }
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f6607j = onClickListener;
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f6608k = onSizeChangedListener;
    }

    private boolean mo1610f() {
        return this.f6613q != null && this.f6613q.getVisibility() == 0;
    }

    public final void mo1242b() {
        if (this.f6614r == null) {
            this.f6614r = new RestoreStateForModalDoneAction(this);
            this.f6614r.a = getTitle();
            this.f6614r.b = mo1610f();
        }
    }

    public final void m11456c() {
        if (this.f6614r != null) {
            setTitle(this.f6614r.a);
            setSearchButtonVisible(this.f6614r.b);
            this.f6614r = null;
        }
    }

    private void mo1243g() {
        mo1611h();
        this.f6605h.setOnClickListener(null);
        this.f6605h.setBackgroundResource(0);
    }

    public final void mo1617a(@Nullable OnClickListener onClickListener) {
        if (this.f6605h != null) {
            m11446b(onClickListener);
            this.f6605h.setImageDrawable(this.f6598a.m6556a(2130838002));
        }
    }

    public void setTitlebarAsModal(@Nullable OnClickListener onClickListener) {
        setHasBackButton(false);
        if (this.f6605h != null) {
            m11446b(onClickListener);
            this.f6605h.setImageDrawable(this.f6598a.m6556a(2130837997));
        }
    }

    private void m11446b(@Nullable OnClickListener onClickListener) {
        this.f6605h.setBackgroundResource(2130843659);
        this.f6605h.setMinimumWidth((int) getResources().getDimension(2131429226));
        this.f6600c.m8778a(this.f6605h, 1);
        this.f6605h.setOnClickListener(onClickListener);
        this.f6605h.setVisibility(0);
    }

    public final void m11457d() {
        this.f6605h.setImageDrawable(null);
        this.f6605h.setMinimumWidth(getResources().getDimensionPixelOffset(2131429234));
        this.f6605h.setVisibility(4);
        this.f6600c.m8778a(this.f6605h, 2);
        this.f6605h.setOnClickListener(null);
        this.f6605h.setBackgroundResource(0);
    }

    private void mo1611h() {
        this.f6605h.setVisibility(0);
        this.f6605h.setImageResource(0);
        this.f6605h.setMinimumWidth((int) getResources().getDimension(2131429227));
    }

    public final void m11458e() {
        if (this.f6605h != null) {
            this.f6605h.setMinimumWidth(getResources().getDimensionPixelOffset(2131429227));
            this.f6605h.setVisibility(4);
            this.f6600c.m8778a(this.f6605h, 2);
            this.f6605h.setOnClickListener(null);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.f6608k != null) {
            this.f6608k.mo1641a();
        }
    }

    @Nullable
    public BadgableGlyphView getBadgablePrimaryActionButtonView() {
        return this.f6611o.f6941b instanceof BadgableGlyphView ? (BadgableGlyphView) this.f6611o.f6941b : null;
    }

    @Nullable
    public BadgableGlyphView getBadgableSecondaryActionButtonView() {
        return (this.f6612p == null || !(this.f6612p.f6941b instanceof BadgableGlyphView)) ? null : (BadgableGlyphView) this.f6612p.f6941b;
    }

    public final void m11451a(Tooltip tooltip) {
        if (this.f6611o.f6941b != null) {
            this.f6611o.f6941b.post(new 2(this, tooltip));
        }
    }

    @Nullable
    public View getPrimaryActionButtonTextView() {
        return this.f6611o.f6942c;
    }

    @Nullable
    protected View getPrimaryActionButton() {
        if (this.f6611o.f6942c != null) {
            return this.f6611o.f6942c;
        }
        return this.f6611o.f6941b;
    }

    @Nullable
    protected View getSecondaryActionButton() {
        if (this.f6612p.f6942c != null) {
            return this.f6612p.f6942c;
        }
        return this.f6612p.f6941b;
    }

    public final void m11453a(boolean z) {
        if (!f6597m) {
            return;
        }
        if (z && !this.f6610n) {
            this.f6610n = true;
            setPadding(0, getHeightSupportTransparentStatusBar(), 0, 0);
        } else if (!z && this.f6610n) {
            this.f6610n = false;
            setPadding(0, 0, 0, 0);
        }
    }

    private int getHeightSupportTransparentStatusBar() {
        if (f6597m) {
            return this.f6601d.m11481a(null);
        }
        return 0;
    }
}

package com.facebook.adinterfaces.ui;

import android.animation.ArgbEvaluator;
import android.animation.LayoutTransition;
import android.animation.LayoutTransition.TransitionListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.ColorUtils;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView.BufferType;
import com.facebook.R;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScrollEventSubscriber;
import com.facebook.adinterfaces.external.events.AdInterfacesEventSubscriber;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentValidationMessageModel;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil.ScrollEndedCallback;
import com.facebook.adinterfaces.walkthrough.AdInterfacesWalkThrough;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLBoostedComponentMessageType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.text.BetterTextView;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VALID */
public class AdInterfacesCardLayout extends CustomLinearLayout implements TransitionListener {
    private BetterTextView f22643a;
    private BetterTextView f22644b;
    private View f22645c;
    private BetterTextView f22646d;
    public BetterTextView f22647e;
    public BetterTextView f22648f;
    private View f22649g;
    public View f22650h;
    private GlyphButton f22651i;
    public GlyphButton f22652j;
    private View f22653k;
    private boolean f22654l = false;
    private boolean f22655m = false;
    private View f22656n;
    private boolean f22657o = false;
    public ValueAnimator f22658p;
    @Inject
    public FbSharedPreferences f22659q;
    @Inject
    public QeAccessor f22660r;
    @Inject
    public AdInterfacesWalkThrough f22661s;

    /* compiled from: VALID */
    class C25991 implements OnClickListener {
        final /* synthetic */ AdInterfacesCardLayout f22628a;

        C25991(AdInterfacesCardLayout adInterfacesCardLayout) {
            this.f22628a = adInterfacesCardLayout;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -477779163);
            view.setVisibility(8);
            this.f22628a.f22650h.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, 555522236, a);
        }
    }

    /* compiled from: VALID */
    class C26002 implements OnClickListener {
        final /* synthetic */ AdInterfacesCardLayout f22629a;

        C26002(AdInterfacesCardLayout adInterfacesCardLayout) {
            this.f22629a = adInterfacesCardLayout;
        }

        public void onClick(View view) {
            int i = 0;
            int a = Logger.a(2, EntryType.UI_INPUT_START, -193922030);
            this.f22629a.f22660r.a(ExperimentsForAdInterfacesModule.f21614k, false);
            if (this.f22629a.f22647e.getVisibility() == 0) {
                i = 8;
            }
            this.f22629a.f22647e.setVisibility(i);
            this.f22629a.f22650h.setVisibility(i);
            LogUtils.a(-1388394051, a);
        }
    }

    /* compiled from: VALID */
    class C26064 extends ScrollEventSubscriber {
        final /* synthetic */ AdInterfacesCardLayout f22637a;
        private Timer f22638b;

        /* compiled from: VALID */
        class C26051 extends TimerTask {
            final /* synthetic */ C26064 f22636a;

            /* compiled from: VALID */
            class C26041 implements Runnable {
                final /* synthetic */ C26051 f22635a;

                /* compiled from: VALID */
                class C26031 implements AnimatorUpdateListener {
                    final /* synthetic */ C26041 f22634a;

                    C26031(C26041 c26041) {
                        this.f22634a = c26041;
                    }

                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ((GradientDrawable) this.f22634a.f22635a.f22636a.f22637a.f22652j.getBackground()).setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                }

                C26041(C26051 c26051) {
                    this.f22635a = c26051;
                }

                public void run() {
                    int color = this.f22635a.f22636a.f22637a.getResources().getColor(2131361871);
                    int color2 = this.f22635a.f22636a.f22637a.getResources().getColor(2131362872);
                    this.f22635a.f22636a.f22637a.f22658p = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(color2)});
                    this.f22635a.f22636a.f22637a.f22658p.setDuration(2000);
                    this.f22635a.f22636a.f22637a.f22658p.addUpdateListener(new C26031(this));
                    this.f22635a.f22636a.f22637a.f22658p.setRepeatMode(2);
                    this.f22635a.f22636a.f22637a.f22658p.setRepeatCount(-1);
                    this.f22635a.f22636a.f22637a.f22658p.start();
                }
            }

            C26051(C26064 c26064) {
                this.f22636a = c26064;
            }

            public void run() {
                if (this.f22636a.f22637a.f22658p == null) {
                    this.f22636a.f22637a.post(new C26041(this));
                }
            }
        }

        C26064(AdInterfacesCardLayout adInterfacesCardLayout) {
            this.f22637a = adInterfacesCardLayout;
        }

        public final void m24563b(FbEvent fbEvent) {
            if (this.f22638b != null) {
                this.f22638b.cancel();
            }
            this.f22638b = new Timer();
            this.f22638b.schedule(new C26051(this), 3000);
        }
    }

    /* compiled from: VALID */
    /* synthetic */ class C26086 {
        static final /* synthetic */ int[] f22642a = new int[GraphQLBoostedComponentMessageType.values().length];

        static {
            try {
                f22642a[GraphQLBoostedComponentMessageType.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22642a[GraphQLBoostedComponentMessageType.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22642a[GraphQLBoostedComponentMessageType.TIP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m24572a(Class<T> cls, T t) {
        m24573a((Object) t, t.getContext());
    }

    private static void m24573a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AdInterfacesCardLayout adInterfacesCardLayout = (AdInterfacesCardLayout) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        AdInterfacesWalkThrough adInterfacesWalkThrough = new AdInterfacesWalkThrough(BoostedComponentLogger.m22753a(injectorLike));
        adInterfacesWalkThrough.f23389p = BoostedComponentLogger.m22753a(injectorLike);
        adInterfacesCardLayout.m24571a(fbSharedPreferences, qeAccessor, adInterfacesWalkThrough);
    }

    private void m24571a(FbSharedPreferences fbSharedPreferences, QeAccessor qeAccessor, AdInterfacesWalkThrough adInterfacesWalkThrough) {
        this.f22659q = fbSharedPreferences;
        this.f22660r = qeAccessor;
        this.f22661s = adInterfacesWalkThrough;
    }

    public AdInterfacesCardLayout(Context context) {
        super(context);
        m24569a(context, null);
    }

    public AdInterfacesCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24569a(context, attributeSet);
    }

    private void m24569a(Context context, AttributeSet attributeSet) {
        setContentView(2130903503);
        m24572a(AdInterfacesCardLayout.class, (View) this);
        setOrientation(1);
        this.f22643a = (BetterTextView) a(2131560209);
        this.f22656n = a(2131560208);
        this.f22644b = (BetterTextView) a(2131560221);
        this.f22645c = a(2131560220);
        this.f22646d = (BetterTextView) a(2131560219);
        if (VERSION.SDK_INT >= 19) {
            Drawable[] compoundDrawablesRelative = this.f22646d.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative[2] != null) {
                compoundDrawablesRelative[2].setAutoMirrored(true);
            }
            this.f22646d.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
        this.f22649g = a(2131560218);
        this.f22651i = (GlyphButton) a(2131560210);
        this.f22652j = (GlyphButton) a(2131560211);
        this.f22647e = (BetterTextView) a(2131560214);
        this.f22650h = a(2131560215);
        this.f22648f = (BetterTextView) a(2131560216);
        this.f22653k = a(2131560217);
        m24576b(context, attributeSet);
    }

    private void m24576b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CardLayout, 0, 0);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            CharSequence charSequence = null;
            if (resourceId != 0) {
                charSequence = getResources().getString(resourceId);
                setHeaderTitle(charSequence);
                this.f22643a.setText(charSequence);
            }
            resourceId = obtainStyledAttributes.getResourceId(1, 0);
            int color = obtainStyledAttributes.getColor(2, 0);
            if (resourceId != 0) {
                m24567a(resourceId, color);
            }
            if (charSequence == null && resourceId == 0) {
                this.f22643a.setVisibility(8);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId2 != 0) {
                setCallToActionText(getResources().getString(resourceId2));
            }
            resourceId2 = obtainStyledAttributes.getResourceId(3, 0);
            if (resourceId2 != 0) {
                setFooterText(getResources().getString(resourceId2));
            }
            m24568a(context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }

    private void m24568a(Context context, TypedArray typedArray) {
        int resourceId = typedArray.getResourceId(5, 0);
        int resourceId2 = typedArray.getResourceId(6, 0);
        if (resourceId != 0 && resourceId2 != 0) {
            m24585a(context.getString(resourceId), resourceId2);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1094109160);
        super.onAttachedToWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 526218188, a);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 9 && i == -1) {
            i = getChildCount() - 4;
        }
        super.addView(view, i, layoutParams);
    }

    public void setHeaderIconResource(int i) {
        this.f22643a.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i), null, null, null);
    }

    private void m24567a(int i, int i2) {
        if (i2 == 0) {
            setHeaderIconResource(i);
            return;
        }
        GlyphColorizer glyphColorizer = new GlyphColorizer(getResources());
        if (VERSION.SDK_INT >= 17) {
            this.f22643a.setCompoundDrawablesRelativeWithIntrinsicBounds(glyphColorizer.a(i, i2), null, null, null);
        } else {
            this.f22643a.setCompoundDrawablesWithIntrinsicBounds(glyphColorizer.a(i, i2), null, null, null);
        }
    }

    public void setHeaderTitleResource(int i) {
        this.f22643a.setText(i);
    }

    public void setHeaderTitle(String str) {
        this.f22643a.setText(str);
    }

    public String getHeaderTitle() {
        return this.f22643a.getText().toString();
    }

    public void setFooterTextResource(int i) {
        this.f22644b.setText(i);
    }

    public void setFooterText(String str) {
        int i;
        int i2 = 0;
        BetterTextView betterTextView = this.f22644b;
        if (str != null) {
            i = 0;
        } else {
            i = 8;
        }
        betterTextView.setVisibility(i);
        View view = this.f22645c;
        if (str == null) {
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f22644b.setText(str);
    }

    public final boolean m24587a() {
        return this.f22644b.getVisibility() == 0;
    }

    public void setFooterSpannableText(Spanned spanned) {
        int i;
        int i2 = 0;
        BetterTextView betterTextView = this.f22644b;
        if (spanned != null) {
            i = 0;
        } else {
            i = 8;
        }
        betterTextView.setVisibility(i);
        View view = this.f22645c;
        if (spanned == null) {
            i2 = 8;
        }
        view.setVisibility(i2);
        this.f22644b.setText(spanned, BufferType.SPANNABLE);
    }

    public void setCallToActionText(String str) {
        this.f22646d.setText(str);
        setCallToActionVisibility(str == null ? 8 : 0);
    }

    public void setCallToActionText(int i) {
        setCallToActionText(getResources().getString(i));
    }

    public void setCallToActionClickListener(OnClickListener onClickListener) {
        this.f22646d.setOnClickListener(onClickListener);
    }

    public void setPencilOnClickListener(OnClickListener onClickListener) {
        this.f22651i.setOnClickListener(onClickListener);
    }

    public void setCallToActionVisibility(int i) {
        this.f22646d.setVisibility(i);
        this.f22649g.setVisibility(i);
    }

    public final void m24586a(boolean z) {
        int i = 0;
        if (this.f22654l) {
            m24588b(!z);
        }
        if (this.f22655m) {
            int i2;
            GlyphButton glyphButton = this.f22652j;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            glyphButton.setVisibility(i2);
        }
        View a = a(2131560212);
        if (!z) {
            i = 8;
        }
        a.setVisibility(i);
    }

    public final void m24588b(boolean z) {
        if (!this.f22654l) {
            this.f22654l = true;
        }
        this.f22651i.setVisibility(z ? 0 : 8);
    }

    public void setHeaderVisibility(int i) {
        this.f22656n.setVisibility(i);
    }

    public final void m24585a(String str, int i) {
        Drawable drawable = getResources().getDrawable(i);
        this.f22647e.setText(str);
        this.f22647e.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        this.f22647e.setOnClickListener(new C25991(this));
        this.f22652j.setVisibility(0);
        this.f22652j.setOnClickListener(new C26002(this));
        AdInterfacesUiUtil.m25238a((ViewGroup) this, (TransitionListener) this);
        this.f22655m = true;
    }

    public final AdInterfacesEventSubscriber m24583a(final List<Pair<Integer, Integer>> list, final String str) {
        AdInterfacesEventSubscriber b = m24574b();
        this.f22652j.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AdInterfacesCardLayout f22633c;

            /* compiled from: VALID */
            class C26011 implements ScrollEndedCallback {
                final /* synthetic */ C26023 f22630a;

                C26011(C26023 c26023) {
                    this.f22630a = c26023;
                }

                public final void mo1007a() {
                    this.f22630a.f22633c.f22661s.m25326a((ViewGroup) this.f22630a.f22633c.getRootView().findViewById(2131564318), this.f22630a.f22633c, list, str);
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 813788209);
                if (this.f22633c.f22658p != null && this.f22633c.f22658p.isRunning()) {
                    this.f22633c.f22658p.end();
                }
                this.f22633c.f22660r.a(ExperimentsForAdInterfacesModule.f21614k, false);
                Editor edit = this.f22633c.f22659q.edit();
                edit.putBoolean(new PrefKey(SharedPrefKeys.h, "adinterfaces_walkthrough_nux"), true);
                edit.commit();
                AdInterfacesUiUtil.m25235a(this.f22633c, new C26011(this));
                Logger.a(2, EntryType.UI_INPUT_END, 949810023, a);
            }
        });
        this.f22652j.setVisibility(0);
        this.f22655m = true;
        return b;
    }

    private AdInterfacesEventSubscriber m24574b() {
        if (this.f22659q.a(new PrefKey(SharedPrefKeys.h, "adinterfaces_walkthrough_nux"), false)) {
            return null;
        }
        C26064 c26064 = new C26064(this);
        c26064.b(null);
        return c26064;
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2015910615);
        super.onDetachedFromWindow();
        if (this.f22658p != null && this.f22658p.isRunning()) {
            this.f22658p.end();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -199333946, a);
    }

    public final void m24584a(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel) {
        m24570a(boostedComponentValidationMessageModel, null);
    }

    private void m24570a(BoostedComponentValidationMessageModel boostedComponentValidationMessageModel, @Nullable OnClickListener onClickListener) {
        if (boostedComponentValidationMessageModel == null) {
            this.f22653k.setVisibility(8);
            this.f22648f.setVisibility(8);
            return;
        }
        int a;
        int a2;
        int a3;
        Drawable a4;
        this.f22648f.setText(boostedComponentValidationMessageModel.m23363k().a());
        Resources resources = getResources();
        GlyphColorizer glyphColorizer = new GlyphColorizer(resources);
        Context context = getContext();
        switch (C26086.f22642a[boostedComponentValidationMessageModel.m23360a().ordinal()]) {
            case 1:
                a = AdInterfacesUiUtil.m25233a(context, 2131362864);
                a2 = AdInterfacesUiUtil.m25233a(context, 2131362866);
                a3 = AdInterfacesUiUtil.m25233a(context, 2131362865);
                a4 = glyphColorizer.a(2130843853, a);
                break;
            case 2:
                a = AdInterfacesUiUtil.m25233a(context, 2131362867);
                a2 = AdInterfacesUiUtil.m25233a(context, 2131362869);
                a3 = AdInterfacesUiUtil.m25233a(context, 2131362868);
                a4 = glyphColorizer.a(2130843853, a);
                break;
            case 3:
                a = AdInterfacesUiUtil.m25233a(context, 2131362870);
                a2 = AdInterfacesUiUtil.m25233a(context, 2131362872);
                a3 = AdInterfacesUiUtil.m25233a(context, 2131362871);
                a4 = glyphColorizer.a(2130843854, a);
                break;
            default:
                a4 = null;
                a3 = 0;
                a2 = 0;
                a = 0;
                break;
        }
        CustomViewUtils.b(this.f22653k, new ColorDrawable(a));
        CustomViewUtils.b(this.f22648f, new ColorDrawable(a2));
        this.f22648f.setTextColor(a3);
        this.f22648f.setCompoundDrawablesWithIntrinsicBounds(a4, null, null, null);
        this.f22657o = true;
        AdInterfacesUiUtil.m25238a((ViewGroup) this, (TransitionListener) this);
        this.f22653k.setVisibility(0);
        this.f22648f.setVisibility(0);
        if (onClickListener != null) {
            String string = resources.getString(2131234099);
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(resources);
            styledStringBuilder.a(this.f22648f.getText()).a(" ").a(string);
            styledStringBuilder.a(string, string, m24565a(onClickListener, ColorUtils.b(a3, Color.alpha(a3) / 2)), 33);
            this.f22648f.setText(styledStringBuilder.b());
            this.f22648f.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.f22648f.setOnClickListener(onClickListener);
    }

    private ClickableSpan m24565a(final OnClickListener onClickListener, final int i) {
        return new ClickableSpan(this) {
            final /* synthetic */ AdInterfacesCardLayout f22641c;

            public void onClick(View view) {
                onClickListener.onClick(this.f22641c.f22648f);
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
                textPaint.setColor(i);
            }
        };
    }

    public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
    }

    public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view, int i) {
        if (this.f22657o) {
            AdInterfacesUiUtil.m25234a((View) this);
        }
        this.f22657o = false;
    }
}

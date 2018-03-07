package com.facebook.privacy.spinner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.R;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.ui.PrivacyOptionView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fax_other */
public class AudienceSpinner extends CustomFrameLayout {
    public AudienceSpinnerAdapterProvider f15278a;
    public PrivacyOptionView f15279b;
    public PopoverListViewWindow f15280c;
    public AudienceSpinnerAdapter f15281d;
    private float f15282e;
    private int f15283f;
    private boolean f15284g;
    private AudienceExplanationDisplayMode f15285h;
    private final OnItemClickListener f15286i = new C10641(this);
    private final OnClickListener f15287j = new C10652(this);
    private final OnDismissListener f15288k = new C10663(this);
    public WeakReference<PrivacyChangeListener> f15289l;
    public WeakReference<SelectorOpenedListener> f15290m;

    /* compiled from: fax_other */
    class C10641 implements OnItemClickListener {
        final /* synthetic */ AudienceSpinner f15275a;

        C10641(AudienceSpinner audienceSpinner) {
            this.f15275a = audienceSpinner;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f15275a.f15281d != null) {
                PrivacyOptionFieldsWithExplanation a = this.f15275a.f15281d.m22939a(i);
                if (!PrivacyOptionHelper.b(this.f15275a.f15281d.f15296f, a)) {
                    this.f15275a.m22920a(a);
                    if (this.f15275a.f15289l != null) {
                        PrivacyChangeListener privacyChangeListener = (PrivacyChangeListener) this.f15275a.f15289l.get();
                        if (privacyChangeListener != null) {
                            privacyChangeListener.m22916a(a, this.f15275a.f15281d.f15297g);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: fax_other */
    class C10652 implements OnClickListener {
        final /* synthetic */ AudienceSpinner f15276a;

        C10652(AudienceSpinner audienceSpinner) {
            this.f15276a = audienceSpinner;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -710629052);
            if (!this.f15276a.f15280c.r) {
                this.f15276a.f15280c.f(this.f15276a.f15279b);
                if (this.f15276a.f15290m != null) {
                    SelectorOpenedListener selectorOpenedListener = (SelectorOpenedListener) this.f15276a.f15290m.get();
                    if (selectorOpenedListener != null) {
                        selectorOpenedListener.m22917a(true);
                    }
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 566710459, a);
        }
    }

    /* compiled from: fax_other */
    class C10663 implements OnDismissListener {
        final /* synthetic */ AudienceSpinner f15277a;

        C10663(AudienceSpinner audienceSpinner) {
            this.f15277a = audienceSpinner;
        }

        public final boolean m22915a(PopoverWindow popoverWindow) {
            if (this.f15277a.f15290m != null) {
                SelectorOpenedListener selectorOpenedListener = (SelectorOpenedListener) this.f15277a.f15290m.get();
                if (selectorOpenedListener != null) {
                    selectorOpenedListener.m22917a(false);
                }
            }
            return false;
        }
    }

    /* compiled from: fax_other */
    public enum AudienceExplanationDisplayMode {
        AUDIENCE_SHOW_ALL,
        AUDIENCE_SHOW_PUBLIC_FRIENDS_AND_CUSTOM,
        AUDIENCE_SHOW_NONE
    }

    /* compiled from: fax_other */
    public interface PrivacyChangeListener {
        void m22916a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation, @Nullable String str);
    }

    /* compiled from: fax_other */
    public interface SelectorOpenedListener {
        void m22917a(boolean z);
    }

    private static <T extends View> void m22923a(Class<T> cls, T t) {
        m22924a((Object) t, t.getContext());
    }

    private static void m22924a(Object obj, Context context) {
        ((AudienceSpinner) obj).f15278a = (AudienceSpinnerAdapterProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(AudienceSpinnerAdapterProvider.class);
    }

    public AudienceSpinner(Context context) {
        super(context);
        m22919a(context, null);
    }

    public AudienceSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22919a(context, attributeSet);
    }

    public AudienceSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22919a(context, attributeSet);
    }

    @Inject
    private void m22922a(AudienceSpinnerAdapterProvider audienceSpinnerAdapterProvider) {
        this.f15278a = audienceSpinnerAdapterProvider;
    }

    private void m22919a(Context context, AttributeSet attributeSet) {
        m22923a(AudienceSpinner.class, (View) this);
        View.inflate(getContext(), 2130903317, this);
        this.f15279b = (PrivacyOptionView) findViewById(2131559748);
        this.f15280c = new PopoverListViewWindow(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AudienceSpinner);
            this.f15282e = obtainStyledAttributes.getFloat(1, 8.0f);
            this.f15283f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f15284g = obtainStyledAttributes.getBoolean(2, true);
            this.f15285h = AudienceExplanationDisplayMode.values()[obtainStyledAttributes.getInt(3, AudienceExplanationDisplayMode.AUDIENCE_SHOW_NONE.ordinal())];
            obtainStyledAttributes.recycle();
        } else {
            this.f15282e = 8.0f;
            this.f15283f = 0;
            this.f15284g = true;
            this.f15285h = AudienceExplanationDisplayMode.AUDIENCE_SHOW_NONE;
        }
        this.f15279b.f15335c = this.f15284g;
        if (this.f15283f > 0) {
            this.f15279b.setMaxWidth(this.f15283f);
        }
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -826061900);
        super.onDetachedFromWindow();
        if (this.f15280c.r) {
            this.f15280c.l();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -459542962, a);
    }

    public final void m22931a(AudienceSpinnerData audienceSpinnerData, @Nullable String str) {
        Preconditions.checkArgument(audienceSpinnerData.m22946a(audienceSpinnerData.m22948b()) != -1, "Selected privacy option must be in the list of options.");
        this.f15281d = this.f15278a.m22944a(audienceSpinnerData, this.f15285h, str);
        setupViewAndPopover(true);
    }

    public final void m22930a(AudienceSpinnerAdapter audienceSpinnerAdapter, boolean z) {
        this.f15281d = audienceSpinnerAdapter;
        setupViewAndPopover(z);
    }

    public final void m22929a() {
        this.f15280c.m = null;
        this.f15281d = null;
        this.f15279b.setOnClickListener(null);
        this.f15280c.p = null;
    }

    public void setAudienceExplanationDisplayMode(AudienceExplanationDisplayMode audienceExplanationDisplayMode) {
        this.f15285h = audienceExplanationDisplayMode;
    }

    public void setPrivacyChangeListener(PrivacyChangeListener privacyChangeListener) {
        this.f15289l = new WeakReference(privacyChangeListener);
    }

    public void setSelectorOpenedListener(SelectorOpenedListener selectorOpenedListener) {
        this.f15290m = new WeakReference(selectorOpenedListener);
    }

    public void setMaxRows(float f) {
        this.f15282e = f;
        this.f15280c.o = f;
    }

    private void m22920a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.f15281d.f15296f = privacyOptionFieldsWithExplanation;
        this.f15279b.setPrivacyOption(privacyOptionFieldsWithExplanation);
    }

    private void setupViewAndPopover(boolean z) {
        this.f15280c.m = this.f15281d;
        this.f15280c.n = this.f15281d.m22942b();
        this.f15280c.o = this.f15282e;
        this.f15280c.b(0.5f);
        this.f15280c.a(true);
        this.f15280c.e = true;
        this.f15280c.p = this.f15286i;
        this.f15280c.H = this.f15288k;
        if (z) {
            this.f15279b.setOnClickListener(this.f15287j);
            this.f15279b.f15335c = this.f15284g;
        } else {
            this.f15279b.setOnClickListener(null);
            this.f15279b.f15335c = false;
        }
        this.f15279b.setPrivacyOption(this.f15281d.f15296f);
    }
}

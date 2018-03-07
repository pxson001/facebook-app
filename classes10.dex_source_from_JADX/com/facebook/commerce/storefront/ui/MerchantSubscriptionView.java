package com.facebook.commerce.storefront.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.storefront.ui.MerchantSubscriptionViewController.OnViewModelUpdateListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: could not construct request body */
public class MerchantSubscriptionView extends CustomFrameLayout implements OnViewModelUpdateListener {
    @Inject
    public GlyphColorizer f15794a;
    public MerchantSubscriptionViewController f15795b;
    private BetterTextView f15796c;

    /* compiled from: could not construct request body */
    class C21981 implements OnClickListener {
        final /* synthetic */ MerchantSubscriptionView f15793a;

        C21981(MerchantSubscriptionView merchantSubscriptionView) {
            this.f15793a = merchantSubscriptionView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1793167051);
            if (this.f15793a.f15795b != null) {
                this.f15793a.f15795b.m16283d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1270188385, a);
        }
    }

    private static <T extends View> void m16268a(Class<T> cls, T t) {
        m16269a((Object) t, t.getContext());
    }

    private static void m16269a(Object obj, Context context) {
        ((MerchantSubscriptionView) obj).f15794a = GlyphColorizer.a(FbInjector.get(context));
    }

    private void m16267a(GlyphColorizer glyphColorizer) {
        this.f15794a = glyphColorizer;
    }

    public MerchantSubscriptionView(Context context) {
        super(context);
        m16270b();
    }

    public MerchantSubscriptionView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m16270b();
    }

    public MerchantSubscriptionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16270b();
    }

    private void m16270b() {
        setContentView(2130905222);
        m16268a(MerchantSubscriptionView.class, (View) this);
        this.f15796c = (BetterTextView) c(2131563811);
        this.f15796c.setOnClickListener(new C21981(this));
    }

    public void setViewController(MerchantSubscriptionViewController merchantSubscriptionViewController) {
        if (this.f15795b != null) {
            this.f15795b.f15804f = null;
        }
        this.f15795b = (MerchantSubscriptionViewController) Preconditions.checkNotNull(merchantSubscriptionViewController);
        this.f15795b.f15804f = this;
        m16271e();
    }

    public final void mo770a() {
        m16271e();
    }

    private void m16271e() {
        boolean z;
        boolean c = this.f15795b != null ? this.f15795b.m16282c() : false;
        int i = c ? 2130839774 : 2130839868;
        int color = getResources().getColor(c ? 2131361917 : 2131361937);
        if (this.f15795b != null) {
            z = this.f15795b.f15803e;
        } else {
            z = false;
        }
        int i2 = z ? c ? 2131234810 : 2131234811 : c ? 2131234812 : 2131234813;
        this.f15796c.setCompoundDrawablesWithIntrinsicBounds(this.f15794a.a(i, color), null, null, null);
        this.f15796c.setText(getResources().getString(i2));
        this.f15796c.setTextColor(color);
    }
}

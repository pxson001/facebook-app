package com.facebook.payments.ui.titlebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.ui.util.ViewReplacementUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.ToolbarBasedFbTitleBar;
import javax.inject.Inject;

/* compiled from: str/ */
public class PaymentsTitleBarViewStub extends View {
    @Inject
    public GatekeeperStoreImpl f2005a;
    @Inject
    public FbActionBarUtil f2006b;
    public FbTitleBar f2007c;
    public OnBackPressedListener f2008d;

    /* compiled from: str/ */
    class C02271 implements OnClickListener {
        final /* synthetic */ PaymentsTitleBarViewStub f2002a;

        C02271(PaymentsTitleBarViewStub paymentsTitleBarViewStub) {
            this.f2002a = paymentsTitleBarViewStub;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1169462183);
            this.f2002a.f2008d.a();
            Logger.a(2, EntryType.UI_INPUT_END, 170713515, a);
        }
    }

    /* compiled from: str/ */
    class C02282 implements OnClickListener {
        final /* synthetic */ PaymentsTitleBarViewStub f2003a;

        C02282(PaymentsTitleBarViewStub paymentsTitleBarViewStub) {
            this.f2003a = paymentsTitleBarViewStub;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1033514950);
            this.f2003a.f2008d.a();
            Logger.a(2, EntryType.UI_INPUT_END, 1534839678, a);
        }
    }

    private static <T extends View> void m2235a(Class<T> cls, T t) {
        m2236a((Object) t, t.getContext());
    }

    private static void m2236a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        FbActionBarUtil a2 = FbActionBarUtil.a(fbInjector);
        paymentsTitleBarViewStub.f2005a = a;
        paymentsTitleBarViewStub.f2006b = a2;
    }

    public PaymentsTitleBarViewStub(Context context) {
        super(context);
        m2233a();
    }

    public PaymentsTitleBarViewStub(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2233a();
    }

    public PaymentsTitleBarViewStub(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2233a();
    }

    @TargetApi(21)
    public PaymentsTitleBarViewStub(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2233a();
    }

    private void m2233a() {
        m2235a(PaymentsTitleBarViewStub.class, (View) this);
    }

    public FbTitleBar getFbTitleBar() {
        return this.f2007c;
    }

    public final void m2240a(ViewGroup viewGroup, OnBackPressedListener onBackPressedListener) {
        m2241a(viewGroup, onBackPressedListener, PaymentsTitleBarStyle.DEFAULT, PaymentsTitleBarNavIconStyle.BACK_ARROW);
    }

    public final void m2241a(ViewGroup viewGroup, OnBackPressedListener onBackPressedListener, PaymentsTitleBarStyle paymentsTitleBarStyle, PaymentsTitleBarNavIconStyle paymentsTitleBarNavIconStyle) {
        this.f2008d = onBackPressedListener;
        m2234a(viewGroup, paymentsTitleBarStyle);
        switch (paymentsTitleBarNavIconStyle) {
            case CROSS:
                m2237b();
                return;
            case BACK_ARROW:
                m2238c();
                return;
            case NO_NAV_ICON:
                m2239d();
                return;
            default:
                return;
        }
    }

    private void m2234a(ViewGroup viewGroup, PaymentsTitleBarStyle paymentsTitleBarStyle) {
        View view;
        LayoutInflater from = LayoutInflater.from(getContext());
        if (this.f2005a.a(403, false) && paymentsTitleBarStyle == PaymentsTitleBarStyle.PAYMENTS_WHITE) {
            view = (Toolbar) from.inflate(2130906162, viewGroup, false);
            this.f2007c = new ToolbarBasedFbTitleBar(view);
        } else if (this.f2006b.a()) {
            Toolbar toolbar = (Toolbar) from.inflate(2130903073, viewGroup, false);
            this.f2007c = new ToolbarBasedFbTitleBar(toolbar);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) from.inflate(2130907487, viewGroup, false);
            FbTitleBarUtil.a(viewGroup2);
            this.f2007c = (FbTitleBar) viewGroup2.findViewById(2131558563);
        }
        ViewReplacementUtil.a(viewGroup, this, view);
    }

    private void m2237b() {
        this.f2007c.setTitlebarAsModal(new C02271(this));
    }

    private void m2238c() {
        if (this.f2007c instanceof ToolbarBasedFbTitleBar) {
            this.f2007c.setHasBackButton(true);
            this.f2007c.setOnBackPressedListener(this.f2008d);
            return;
        }
        this.f2007c.a(new C02282(this));
    }

    private void m2239d() {
        this.f2007c.setHasBackButton(false);
    }
}

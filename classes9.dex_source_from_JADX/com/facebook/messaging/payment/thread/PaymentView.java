package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.animatablelistview.AnimatingItemInfo;
import javax.inject.Inject;

/* compiled from: failed_fetch_threads_communication */
public class PaymentView extends CustomViewGroup {
    @Inject
    CompositeThemePaymentBubbleViewController f15003a;
    @Inject
    CompositeHeaderPaymentBubbleViewController f15004b;
    @Inject
    CompositeDollarAmountPaymentBubbleViewController f15005c;
    @Inject
    CompositeRecipientNamePaymentBubbleViewController f15006d;
    @Inject
    CompositeLoadingPaymentBubbleViewController f15007e;
    @Inject
    CompositeDetailsPaymentBubbleViewController f15008f;
    @Inject
    CompositeSupplementaryPaymentBubbleViewController f15009g;
    @Inject
    CompositeActionButtonsPaymentBubbleViewController f15010h;
    @Inject
    AnalyticsLogger f15011i;
    private final ViewStubHolder<PaymentBubbleThemeView> f15012j;
    private final ViewStubHolder<PaymentBubbleHeaderView> f15013k;
    private final ViewStubHolder<CustomLinearLayout> f15014l;
    private final ViewStubHolder<PaymentBubbleRecipientNameView> f15015m;
    private final ViewStubHolder<View> f15016n;
    private final ViewStubHolder<PaymentBubbleDetailsView> f15017o;
    private final ViewStubHolder<PaymentBubbleSupplementaryView> f15018p;
    private final ViewStubHolder<PaymentBubbleActionButtonsView> f15019q;

    /* compiled from: failed_fetch_threads_communication */
    public interface Listener {
        void m15384a();

        void m15385b();

        void m15386c();

        void m15387d();

        void m15388e();

        void m15389f();
    }

    private static <T extends View> void m15392a(Class<T> cls, T t) {
        m15393a((Object) t, t.getContext());
    }

    private static void m15393a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PaymentView) obj).m15390a(new CompositeThemePaymentBubbleViewController(IdBasedLazy.a(injectorLike, 8191), IdBasedLazy.a(injectorLike, 8199)), CompositeHeaderPaymentBubbleViewController.m15346b(injectorLike), CompositeDollarAmountPaymentBubbleViewController.m15344b(injectorLike), CompositeRecipientNamePaymentBubbleViewController.m15350b(injectorLike), CompositeLoadingPaymentBubbleViewController.m15348b(injectorLike), CompositeDetailsPaymentBubbleViewController.m15342b(injectorLike), CompositeSupplementaryPaymentBubbleViewController.m15352b(injectorLike), CompositeActionButtonsPaymentBubbleViewController.m15340b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    private void m15390a(CompositeThemePaymentBubbleViewController compositeThemePaymentBubbleViewController, CompositeHeaderPaymentBubbleViewController compositeHeaderPaymentBubbleViewController, CompositeDollarAmountPaymentBubbleViewController compositeDollarAmountPaymentBubbleViewController, CompositeRecipientNamePaymentBubbleViewController compositeRecipientNamePaymentBubbleViewController, CompositeLoadingPaymentBubbleViewController compositeLoadingPaymentBubbleViewController, CompositeDetailsPaymentBubbleViewController compositeDetailsPaymentBubbleViewController, CompositeSupplementaryPaymentBubbleViewController compositeSupplementaryPaymentBubbleViewController, CompositeActionButtonsPaymentBubbleViewController compositeActionButtonsPaymentBubbleViewController, AnalyticsLogger analyticsLogger) {
        this.f15003a = compositeThemePaymentBubbleViewController;
        this.f15004b = compositeHeaderPaymentBubbleViewController;
        this.f15005c = compositeDollarAmountPaymentBubbleViewController;
        this.f15006d = compositeRecipientNamePaymentBubbleViewController;
        this.f15007e = compositeLoadingPaymentBubbleViewController;
        this.f15008f = compositeDetailsPaymentBubbleViewController;
        this.f15009g = compositeSupplementaryPaymentBubbleViewController;
        this.f15010h = compositeActionButtonsPaymentBubbleViewController;
        this.f15011i = analyticsLogger;
    }

    public PaymentView(Context context) {
        this(context, null);
    }

    public PaymentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15392a(PaymentView.class, (View) this);
        setContentView(2130905801);
        this.f15011i.a(P2pPaymentsLogEvent.c("p2p_receive", "p2p_payment_bubble_rendered"));
        this.f15012j = ViewStubHolder.a((ViewStubCompat) getView(2131565021));
        this.f15013k = ViewStubHolder.a((ViewStubCompat) getView(2131565022));
        this.f15014l = ViewStubHolder.a((ViewStubCompat) getView(2131565023));
        this.f15015m = ViewStubHolder.a((ViewStubCompat) getView(2131565024));
        this.f15016n = ViewStubHolder.a((ViewStubCompat) getView(2131565025));
        this.f15017o = ViewStubHolder.a((ViewStubCompat) getView(2131565026));
        this.f15018p = ViewStubHolder.a((ViewStubCompat) getView(2131565027));
        this.f15019q = ViewStubHolder.a((ViewStubCompat) getView(2131565028));
    }

    public final void m15395a(PaymentViewParams paymentViewParams, final Listener listener) {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PaymentView f15002b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 373196462);
                listener.m15384a();
                Logger.a(2, EntryType.UI_INPUT_END, 1733513175, a);
            }
        });
        m15394b(paymentViewParams, listener);
    }

    public void setPaymentsAnimatingItemInfo(AnimatingItemInfo animatingItemInfo) {
        if (this.f15017o.d()) {
            ((PaymentBubbleDetailsView) this.f15017o.a()).setItemInfo(animatingItemInfo);
        }
    }

    private void m15394b(PaymentViewParams paymentViewParams, Listener listener) {
        m15391a(this.f15003a, this.f15012j, paymentViewParams, listener);
        m15391a(this.f15004b, this.f15013k, paymentViewParams, listener);
        m15391a(this.f15005c, this.f15014l, paymentViewParams, listener);
        m15391a(this.f15006d, this.f15015m, paymentViewParams, listener);
        m15391a(this.f15007e, this.f15016n, paymentViewParams, listener);
        m15391a(this.f15008f, this.f15017o, paymentViewParams, listener);
        m15391a(this.f15009g, this.f15018p, paymentViewParams, listener);
        m15391a(this.f15010h, this.f15019q, paymentViewParams, listener);
    }

    private static void m15391a(PaymentBubbleViewController paymentBubbleViewController, ViewStubHolder viewStubHolder, PaymentViewParams paymentViewParams, Listener listener) {
        if (paymentBubbleViewController.mo601a(paymentViewParams)) {
            viewStubHolder.f();
            paymentBubbleViewController.mo600a(viewStubHolder.a(), paymentViewParams, listener);
            return;
        }
        viewStubHolder.e();
    }
}

package com.facebook.messaging.payment.thread.banner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.enums.GraphQLProductAvailability;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.dialog.PaymentDialogsBuilder;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerManager.C17452;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerManager.C17463;
import com.facebook.messaging.payment.thread.banner.PaymentPlatformContextBannerView.Listener;
import com.facebook.orca.threadview.ThreadViewMessagesFragmentBannerNotificationController.2;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed in retrieving  */
public class PaymentPlatformContextBannerNotification extends AbstractBannerNotification {
    private final Context f15092a;
    private final AbstractFbErrorReporter f15093b;
    private final PaymentCurrencyUtil f15094c;
    private final Provider<User> f15095d;
    private final LayoutInflater f15096e;
    @Nullable
    public 2 f15097f;
    public PaymentPlatformContextModel f15098g;

    /* compiled from: failed in retrieving  */
    class C17471 implements Listener {
        final /* synthetic */ PaymentPlatformContextBannerNotification f15089a;

        C17471(PaymentPlatformContextBannerNotification paymentPlatformContextBannerNotification) {
            this.f15089a = paymentPlatformContextBannerNotification;
        }

        public final void mo605a() {
        }

        public final void mo606b() {
            if (this.f15089a.f15097f != null) {
                this.f15089a.f15097f.e(this.f15089a.f15098g);
            }
        }

        public final void mo607c() {
            if (this.f15089a.f15097f != null) {
                2 2 = this.f15089a.f15097f;
                PaymentPlatformContextModel paymentPlatformContextModel = this.f15089a.f15098g;
                if (2.a.L != null) {
                    2.a.L.b(paymentPlatformContextModel);
                }
                2.a.y.m15457a("p2p_pay_button_clicked", paymentPlatformContextModel);
            }
        }

        public final void mo608d() {
            if (this.f15089a.f15097f != null) {
                this.f15089a.f15097f.b(this.f15089a.f15098g);
            }
        }
    }

    public static PaymentPlatformContextBannerNotification m15470a(InjectorLike injectorLike) {
        return new PaymentPlatformContextBannerNotification((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike), IdBasedProvider.a(injectorLike, 3596), LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PaymentPlatformContextBannerNotification(Context context, FbErrorReporter fbErrorReporter, PaymentCurrencyUtil paymentCurrencyUtil, Provider<User> provider, LayoutInflater layoutInflater) {
        super("PaymentPlatformContextBannerNotification");
        this.f15092a = context;
        this.f15093b = fbErrorReporter;
        this.f15094c = paymentCurrencyUtil;
        this.f15095d = provider;
        this.f15096e = layoutInflater;
    }

    public final void m15476a(2 2) {
        this.f15097f = 2;
    }

    public final View m15475a(ViewGroup viewGroup) {
        Preconditions.checkNotNull(this.f15098g);
        PaymentPlatformContextBannerView paymentPlatformContextBannerView = (PaymentPlatformContextBannerView) this.f15096e.cloneInContext(new ContextThemeWrapper(this.f15092a, 2131624676)).inflate(2130906153, viewGroup, false);
        if (this.f15095d.get() == null) {
            this.f15093b.b("PaymentPlatformContextBannerNotification", "null ViewerContextUser found when populating the banner for payment platform context.");
        } else if (((User) this.f15095d.get()).a.equals(this.f15098g.m13754b().m13879c())) {
            m15472a(paymentPlatformContextBannerView);
        } else {
            m15474b(paymentPlatformContextBannerView);
        }
        return paymentPlatformContextBannerView;
    }

    private void m15472a(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
        PaymentPlatformItemModel g = this.f15098g.m13757g();
        paymentPlatformContextBannerView.setTitle(m15471a(g));
        paymentPlatformContextBannerView.setDescription(m15473b(g));
        paymentPlatformContextBannerView.setSecondaryAction(2131240534);
        if (this.f15098g.m13761m()) {
            paymentPlatformContextBannerView.setPrimaryAction(2131240535);
        }
        paymentPlatformContextBannerView.setListener(new C17471(this));
    }

    private void m15474b(PaymentPlatformContextBannerView paymentPlatformContextBannerView) {
        final PaymentPlatformItemModel g = this.f15098g.m13757g();
        paymentPlatformContextBannerView.setTitle(m15471a(g));
        paymentPlatformContextBannerView.setDescription(m15473b(g));
        if (g.m13780c() == GraphQLProductAvailability.OUT_OF_STOCK) {
            paymentPlatformContextBannerView.setPrimaryAction(2131240534);
        } else {
            paymentPlatformContextBannerView.setPrimaryAction(2131240536);
            paymentPlatformContextBannerView.setSecondaryAction(2131240537);
        }
        paymentPlatformContextBannerView.setListener(new Listener(this) {
            final /* synthetic */ PaymentPlatformContextBannerNotification f15091b;

            public final void mo605a() {
                if (this.f15091b.f15097f != null && g.m13780c() != GraphQLProductAvailability.OUT_OF_STOCK) {
                    this.f15091b.f15097f.b(this.f15091b.f15098g);
                }
            }

            public final void mo606b() {
                if (this.f15091b.f15097f != null) {
                    this.f15091b.f15097f.e(this.f15091b.f15098g);
                }
            }

            public final void mo607c() {
                if (this.f15091b.f15097f != null) {
                    if (g.m13780c() == GraphQLProductAvailability.OUT_OF_STOCK) {
                        this.f15091b.f15097f.b(this.f15091b.f15098g);
                        return;
                    }
                    2 2 = this.f15091b.f15097f;
                    PaymentPlatformContextModel paymentPlatformContextModel = this.f15091b.f15098g;
                    PaymentPlatformContextBannerManager paymentPlatformContextBannerManager = 2.a.y;
                    PaymentDialogsBuilder.m13300a(paymentPlatformContextBannerManager.f15082c, paymentPlatformContextBannerManager.f15082c.getString(2131240541), paymentPlatformContextBannerManager.f15082c.getString(2131240542), paymentPlatformContextBannerManager.f15082c.getString(2131230726), new C17452(paymentPlatformContextBannerManager, paymentPlatformContextModel), paymentPlatformContextBannerManager.f15082c.getString(2131230727), new C17463(paymentPlatformContextBannerManager)).show();
                }
            }

            public final void mo608d() {
                if (this.f15091b.f15097f != null) {
                    2 2 = this.f15091b.f15097f;
                    PaymentPlatformContextModel paymentPlatformContextModel = this.f15091b.f15098g;
                    if (2.a.L != null) {
                        2.a.L.a(paymentPlatformContextModel);
                    }
                    2.a.y.m15457a("p2p_request_payment_button_clicked", paymentPlatformContextModel);
                }
            }
        });
    }

    private String m15471a(PaymentPlatformItemModel paymentPlatformItemModel) {
        if (paymentPlatformItemModel.m13780c() != GraphQLProductAvailability.OUT_OF_STOCK) {
            return paymentPlatformItemModel.m13782g();
        }
        return StringFormatUtil.a("(%s) %s", new Object[]{this.f15092a.getString(2131240539), paymentPlatformItemModel.m13782g()});
    }

    private String m15473b(PaymentPlatformItemModel paymentPlatformItemModel) {
        String a = this.f15094c.m13199a(CurrencyFormatType.NO_EMPTY_DECIMALS, paymentPlatformItemModel.lu_().m13691a(), paymentPlatformItemModel.lu_().m13695b());
        return this.f15092a.getString(2131240540, new Object[]{a});
    }
}

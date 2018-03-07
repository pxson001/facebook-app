package com.facebook.messaging.payment.thread.banner;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent;
import com.facebook.messaging.payment.analytics.P2pPaymentsLogEvent.Builder;
import com.facebook.messaging.payment.analytics.PaymentFlowType;
import com.facebook.messaging.payment.cache.PaymentPlatformContextsCache;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentPlatformContext;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformContextModel;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentPlatformItemModel;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.transactions.MutatePaymentPlatformContextParams.Mutation;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: failed to close Google picture destination file output stream */
public class PaymentPlatformContextBannerManager {
    public final Provider<Boolean> f15080a;
    public final PaymentPlatformContextsCache f15081b;
    public final Context f15082c;
    public final SecureContextHelper f15083d;
    private final AnalyticsLogger f15084e;
    private final PaymentCurrencyUtil f15085f;
    public final PaymentProtocolUtil f15086g;
    public final Comparator<PaymentPlatformContext> f15087h = new C17441(this);
    public PaymentPlatformContextModel f15088i;

    /* compiled from: failed to close Google picture destination file output stream */
    class C17441 implements Comparator<PaymentPlatformContext> {
        final /* synthetic */ PaymentPlatformContextBannerManager f15076a;

        C17441(PaymentPlatformContextBannerManager paymentPlatformContextBannerManager) {
            this.f15076a = paymentPlatformContextBannerManager;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((PaymentPlatformContextModel) obj2).lq_() - ((PaymentPlatformContextModel) obj).lq_());
        }
    }

    /* compiled from: failed to close Google picture destination file output stream */
    public class C17452 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextModel f15077a;
        final /* synthetic */ PaymentPlatformContextBannerManager f15078b;

        public C17452(PaymentPlatformContextBannerManager paymentPlatformContextBannerManager, PaymentPlatformContextModel paymentPlatformContextModel) {
            this.f15078b = paymentPlatformContextBannerManager;
            this.f15077a = paymentPlatformContextModel;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f15078b.f15086g.m14952a(Mutation.MARK_AS_SOLD, this.f15077a.m13756d());
            this.f15078b.m15457a("p2p_mark_sold_button_clicked", this.f15077a);
        }
    }

    /* compiled from: failed to close Google picture destination file output stream */
    public class C17463 implements OnClickListener {
        final /* synthetic */ PaymentPlatformContextBannerManager f15079a;

        public C17463(PaymentPlatformContextBannerManager paymentPlatformContextBannerManager) {
            this.f15079a = paymentPlatformContextBannerManager;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static PaymentPlatformContextBannerManager m15455a(InjectorLike injectorLike) {
        return new PaymentPlatformContextBannerManager(IdBasedProvider.a(injectorLike, 4181), PaymentPlatformContextsCache.m13170a(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), PaymentCurrencyUtil.m13192a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike));
    }

    @Inject
    public PaymentPlatformContextBannerManager(Provider<Boolean> provider, PaymentPlatformContextsCache paymentPlatformContextsCache, Context context, SecureContextHelper secureContextHelper, PaymentCurrencyUtil paymentCurrencyUtil, AnalyticsLogger analyticsLogger, PaymentProtocolUtil paymentProtocolUtil) {
        this.f15080a = provider;
        this.f15081b = paymentPlatformContextsCache;
        this.f15082c = context;
        this.f15083d = secureContextHelper;
        this.f15085f = paymentCurrencyUtil;
        this.f15084e = analyticsLogger;
        this.f15086g = paymentProtocolUtil;
    }

    public final void m15457a(String str, PaymentPlatformContextModel paymentPlatformContextModel) {
        PaymentPlatformItemModel g = paymentPlatformContextModel.m13757g();
        Preconditions.checkNotNull(g);
        String a = this.f15085f.m13199a(CurrencyFormatType.NO_CURRENCY_SYMBOL_OR_EMPTY_DECIMALS, g.lu_().m13691a(), g.lu_().m13695b());
        AnalyticsLogger analyticsLogger = this.f15084e;
        Builder d = P2pPaymentsLogEvent.d(str, PaymentFlowType.GROUP_COMMERCE.analyticsModule);
        d.a.b("platform_context_id", paymentPlatformContextModel.m13756d());
        d = d;
        d.a.b("item_id", paymentPlatformContextModel.m13757g().m13779b());
        d = d;
        d.a.b("listed_amount", a);
        Builder builder = d;
        builder.a.b("group_id", m15456a(g.m13783j(), 1));
        builder = builder;
        builder.a.b("post_id", m15456a(g.m13783j(), 2));
        builder = builder;
        builder.a.b("receiver_id", g.m13784k().m13879c());
        analyticsLogger.a(builder.a);
    }

    @Nullable
    private static String m15456a(String str, int i) {
        Matcher matcher = Pattern.compile("^.+/([0-9]+)/.+/([0-9]+).*$").matcher(str);
        if (matcher.find()) {
            return matcher.group(i);
        }
        return null;
    }
}

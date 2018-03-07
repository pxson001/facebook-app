package com.facebook.messaging.payment.thread.banner;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.banner.AbstractBannerNotification;
import com.facebook.common.banner.BasicBannerNotificationView;
import com.facebook.common.banner.BasicBannerNotificationView.Params.Builder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.currency.CurrencyFormatType;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.value.input.EnterPaymentValueActivity;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: failed to close Google picture temp file input stream */
public class IncomingPaymentRequestBannerNotification extends AbstractBannerNotification {
    private static final Class<?> f15070a = IncomingPaymentRequestBannerNotification.class;
    private final PaymentCurrencyUtil f15071b;
    public final Context f15072c;
    public final SecureContextHelper f15073d;
    private final LayoutInflater f15074e;
    public PaymentRequestModel f15075f;

    /* compiled from: failed to close Google picture temp file input stream */
    class C17431 implements OnClickListener {
        final /* synthetic */ IncomingPaymentRequestBannerNotification f15069a;

        C17431(IncomingPaymentRequestBannerNotification incomingPaymentRequestBannerNotification) {
            this.f15069a = incomingPaymentRequestBannerNotification;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2036322298);
            this.f15069a.f15073d.a(EnterPaymentValueActivity.m15589b(this.f15069a.f15072c, this.f15069a.f15075f.lw_()), this.f15069a.f15072c);
            Logger.a(2, EntryType.UI_INPUT_END, -268275675, a);
        }
    }

    public static IncomingPaymentRequestBannerNotification m15453a(InjectorLike injectorLike) {
        return new IncomingPaymentRequestBannerNotification(PaymentCurrencyUtil.m13192a(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public IncomingPaymentRequestBannerNotification(PaymentCurrencyUtil paymentCurrencyUtil, Context context, SecureContextHelper secureContextHelper, LayoutInflater layoutInflater) {
        super(f15070a.getSimpleName());
        this.f15071b = paymentCurrencyUtil;
        this.f15072c = context;
        this.f15073d = secureContextHelper;
        this.f15074e = layoutInflater;
    }

    public final View m15454a(ViewGroup viewGroup) {
        Preconditions.checkNotNull(this.f15075f);
        BasicBannerNotificationView basicBannerNotificationView = (BasicBannerNotificationView) this.f15074e.inflate(2130903387, viewGroup, false);
        String a = this.f15071b.m13199a(CurrencyFormatType.NO_EMPTY_DECIMALS, this.f15075f.m13811b().m13703a(), this.f15075f.m13811b().m13707b());
        Builder builder = new Builder();
        builder.a = this.f15072c.getString(2131240577, new Object[]{this.f15075f.m13816k().lE_(), a});
        Builder builder2 = builder;
        builder2.c = new ColorDrawable(this.f15072c.getResources().getColor(2131362401));
        builder2 = builder2;
        builder2.d = true;
        builder2 = builder2;
        builder2.e = this.f15072c.getString(2131240576);
        basicBannerNotificationView.setParams(builder2.a());
        basicBannerNotificationView.setOnBannerButtonClickListener(new C17431(this));
        return basicBannerNotificationView;
    }
}

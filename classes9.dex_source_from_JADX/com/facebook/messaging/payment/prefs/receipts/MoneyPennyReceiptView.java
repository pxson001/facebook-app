package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ErrorCodeUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.CommerceOrder;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.ReceiptCardFetcher.ReceiptCardFetcherListener;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptAmountViewController;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoView;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoViewParams;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoViewParamsBuilder;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderView;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParams;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParamsBuilder;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.utils.PaymentViewUtil;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: groupID */
public class MoneyPennyReceiptView extends CustomLinearLayout implements ReceiptView<PaymentTransaction> {
    private static final ImmutableList<Pair<Integer, String>> f13909d = ImmutableList.of(Pair.a(Integer.valueOf(2131240375), "https://m.facebook.com/legal/m"), Pair.a(Integer.valueOf(2131240374), "https://m.facebook.com/help/messenger-app/870471599656315"));
    @Inject
    ReceiptAmountViewController f13910a;
    @Inject
    PaymentViewUtil f13911b;
    @Inject
    ReceiptCardFetcher f13912c;
    private ReceiptHeaderView f13913e;
    private DollarIconEditText f13914f;
    private FloatingLabelTextView f13915g;
    private FloatingLabelTextView f13916h;
    private ReceiptFooterInfoView f13917i;
    private SingleItemInfoView f13918j;

    /* compiled from: groupID */
    class C15851 implements ReceiptCardFetcherListener {
        final /* synthetic */ MoneyPennyReceiptView f13908a;

        C15851(MoneyPennyReceiptView moneyPennyReceiptView) {
            this.f13908a = moneyPennyReceiptView;
        }

        public final void mo550a(Throwable th) {
            this.f13908a.m14449a(th);
        }

        public final void mo549a(@Nullable PaymentCard paymentCard) {
            this.f13908a.m14442a(paymentCard);
        }
    }

    private static <T extends View> void m14446a(Class<T> cls, T t) {
        m14447a((Object) t, t.getContext());
    }

    private static void m14447a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MoneyPennyReceiptView) obj).m14445a(ReceiptAmountViewController.m14529a(injectorLike), PaymentViewUtil.m15542b(injectorLike), ReceiptCardFetcher.m14511b(injectorLike));
    }

    public final void mo554b(Object obj, ReceiptFragment receiptFragment) {
        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        m14450b(paymentTransaction);
        m14452c(paymentTransaction);
        m14441a(paymentTransaction.f13241n);
        m14448a(paymentTransaction.f13233f);
        m14451b(paymentTransaction.f13229b);
        m14453c(paymentTransaction.f13229b);
    }

    private void m14445a(ReceiptAmountViewController receiptAmountViewController, PaymentViewUtil paymentViewUtil, ReceiptCardFetcher receiptCardFetcher) {
        this.f13910a = receiptAmountViewController;
        this.f13911b = paymentViewUtil;
        this.f13912c = receiptCardFetcher;
    }

    public MoneyPennyReceiptView(Context context) {
        this(context, null);
    }

    public MoneyPennyReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoneyPennyReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14446a(MoneyPennyReceiptView.class, (View) this);
        setContentView(2130905301);
        this.f13913e = (ReceiptHeaderView) a(2131563922);
        this.f13914f = (DollarIconEditText) a(2131563921);
        this.f13915g = (FloatingLabelTextView) a(2131563919);
        this.f13916h = (FloatingLabelTextView) a(2131560466);
        this.f13917i = (ReceiptFooterInfoView) a(2131563920);
        this.f13918j = (SingleItemInfoView) a(2131563670);
    }

    public final void mo551a() {
        this.f13912c.m14512a();
    }

    public final void mo552a(int i, int i2, Intent intent) {
    }

    private void m14450b(PaymentTransaction paymentTransaction) {
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = paymentTransaction.f13232e;
        newBuilder = newBuilder;
        newBuilder.f14154c = getResources().getString(2131240532);
        newBuilder = newBuilder;
        newBuilder.f14153b = getResources().getString(2131240533, new Object[]{paymentTransaction.f13241n.m13473a(), paymentTransaction.f13232e.mo527c()});
        newBuilder = newBuilder;
        newBuilder.f14155d = true;
        this.f13913e.setReceiptHeaderViewParams(newBuilder.m14627e());
    }

    private void m14452c(PaymentTransaction paymentTransaction) {
        this.f13910a.f14039e = this.f13914f;
        this.f13910a.m14534a((Object) paymentTransaction);
    }

    private void m14441a(CommerceOrder commerceOrder) {
        SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
        newBuilder.a = commerceOrder.m13475c();
        newBuilder = newBuilder;
        newBuilder.b = getResources().getDimension(2131429256);
        newBuilder = newBuilder;
        newBuilder.c = commerceOrder.m13473a();
        newBuilder = newBuilder;
        newBuilder.d = commerceOrder.m13474b();
        this.f13918j.setViewParams(newBuilder.f());
    }

    private void m14448a(String str) {
        this.f13911b.m15545a(this.f13915g, 2131240531, Long.parseLong(str) * 1000);
    }

    private void m14451b(String str) {
        this.f13912c.f14010e = new C15851(this);
        this.f13916h.a();
        this.f13912c.m14513a(str);
    }

    private void m14453c(String str) {
        ReceiptFooterInfoView receiptFooterInfoView = this.f13917i;
        ReceiptFooterInfoViewParamsBuilder newBuilder = ReceiptFooterInfoViewParams.newBuilder();
        newBuilder.f14093a = str;
        newBuilder = newBuilder;
        newBuilder.f14094b = f13909d;
        receiptFooterInfoView.setViewParams(newBuilder.m14573c());
    }

    private void m14449a(Throwable th) {
        this.f13916h.b();
        if (ErrorCodeUtil.a(th) == ErrorCode.CONNECTION_FAILURE) {
            this.f13916h.setText(2131240488);
        } else {
            this.f13916h.setText(2131240489);
        }
    }

    private void m14442a(@Nullable PaymentCard paymentCard) {
        if (paymentCard == null) {
            this.f13916h.setVisibility(8);
            return;
        }
        this.f13916h.b();
        this.f13916h.setText(StringFormatUtil.formatStrLocaleSafe("%s •%s", paymentCard.f13207f, paymentCard.m13503e()));
    }
}

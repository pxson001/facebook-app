package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentUser;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.PaymentRequest;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptAmountViewController;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptThirdPartyStatusViewController;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderView;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParams;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParamsBuilder;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.util.PaymentRequestUtil;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: grid_view_scroll_offset */
public class OrionRequestThirdPartyReceiptView extends CustomLinearLayout implements ReceiptView<PaymentRequest> {
    @Inject
    ReceiptAmountViewController f13967a;
    @Inject
    ReceiptThirdPartyStatusViewController f13968b;
    @Inject
    Resources f13969c;
    @Inject
    PaymentsTextViewLinkHelper f13970d;
    private ReceiptHeaderView f13971e;
    private ReceiptHeaderView f13972f;
    private DollarIconEditText f13973g;
    private BetterTextView f13974h;
    private BetterTextView f13975i;

    private static <T extends View> void m14481a(Class<T> cls, T t) {
        m14482a((Object) t, t.getContext());
    }

    private static void m14482a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OrionRequestThirdPartyReceiptView) obj).m14480a(ReceiptAmountViewController.m14529a(injectorLike), ReceiptThirdPartyStatusViewController.m14549a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), PaymentsTextViewLinkHelper.b(injectorLike));
    }

    public final void mo553a(Object obj, ReceiptFragment receiptFragment) {
        obj = (PaymentRequestModel) obj;
        m14484c(obj);
        this.f13967a.m14534a(obj);
        this.f13968b.m14553a(obj);
    }

    public final void mo554b(Object obj, ReceiptFragment receiptFragment) {
        obj = (PaymentRequestModel) obj;
        m14484c(obj);
        this.f13967a.f14039e = this.f13973g;
        this.f13967a.m14534a(obj);
        this.f13968b.f14072b = this.f13974h;
        this.f13968b.m14553a(obj);
        this.f13970d.a(2131240578, "[[learn_more_link]]", this.f13969c.getString(2131240377), this.f13975i, "https://m.facebook.com/help/android-app/376510072539297");
    }

    public OrionRequestThirdPartyReceiptView(Context context) {
        super(context);
        m14483b();
    }

    public OrionRequestThirdPartyReceiptView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m14483b();
    }

    protected OrionRequestThirdPartyReceiptView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14483b();
    }

    private void m14480a(ReceiptAmountViewController receiptAmountViewController, ReceiptThirdPartyStatusViewController receiptThirdPartyStatusViewController, Resources resources, PaymentsTextViewLinkHelper paymentsTextViewLinkHelper) {
        this.f13967a = receiptAmountViewController;
        this.f13968b = receiptThirdPartyStatusViewController;
        this.f13969c = resources;
        this.f13970d = paymentsTextViewLinkHelper;
    }

    private void m14483b() {
        m14481a(OrionRequestThirdPartyReceiptView.class, (View) this);
        setContentView(2130905939);
        this.f13971e = (ReceiptHeaderView) findViewById(2131565290);
        this.f13972f = (ReceiptHeaderView) findViewById(2131565291);
        this.f13973g = (DollarIconEditText) findViewById(2131563921);
        this.f13974h = (BetterTextView) findViewById(2131565292);
        this.f13975i = (BetterTextView) findViewById(2131565293);
    }

    public final void mo551a() {
    }

    public final void mo552a(int i, int i2, Intent intent) {
    }

    private void m14484c(PaymentRequestModel paymentRequestModel) {
        PaymentUser a = PaymentRequestUtil.a(paymentRequestModel.m13816k());
        PaymentUser a2 = PaymentRequestUtil.a(paymentRequestModel.m13815j());
        ReceiptHeaderView receiptHeaderView = this.f13971e;
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = a;
        newBuilder = newBuilder;
        newBuilder.f14153b = a.mo527c();
        ReceiptHeaderViewParamsBuilder receiptHeaderViewParamsBuilder = newBuilder;
        receiptHeaderViewParamsBuilder.f14154c = this.f13969c.getString(2131240335);
        receiptHeaderViewParamsBuilder = receiptHeaderViewParamsBuilder;
        receiptHeaderViewParamsBuilder.f14155d = true;
        receiptHeaderView.setReceiptHeaderViewParams(receiptHeaderViewParamsBuilder.m14627e());
        ReceiptHeaderView receiptHeaderView2 = this.f13972f;
        ReceiptHeaderViewParamsBuilder newBuilder2 = ReceiptHeaderViewParams.newBuilder();
        newBuilder2.f14152a = a2;
        newBuilder2 = newBuilder2;
        newBuilder2.f14153b = a2.mo527c();
        ReceiptHeaderViewParamsBuilder receiptHeaderViewParamsBuilder2 = newBuilder2;
        receiptHeaderViewParamsBuilder2.f14154c = this.f13969c.getString(2131240333);
        receiptHeaderViewParamsBuilder2 = receiptHeaderViewParamsBuilder2;
        receiptHeaderViewParamsBuilder2.f14155d = false;
        receiptHeaderView2.setReceiptHeaderViewParams(receiptHeaderViewParamsBuilder2.m14627e());
    }
}

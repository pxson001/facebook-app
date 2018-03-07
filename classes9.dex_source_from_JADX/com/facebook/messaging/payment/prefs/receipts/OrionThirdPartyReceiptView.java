package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptAmountViewController;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptThirdPartyStatusViewController;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderView;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParams;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewParamsBuilder;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: graphql_video_type_null */
public class OrionThirdPartyReceiptView extends CustomLinearLayout implements ReceiptView<PaymentTransaction> {
    @Inject
    ReceiptAmountViewController f13976a;
    @Inject
    ReceiptThirdPartyStatusViewController f13977b;
    @Inject
    Resources f13978c;
    @Inject
    PaymentsTextViewLinkHelper f13979d;
    private ReceiptHeaderView f13980e;
    private ReceiptHeaderView f13981f;
    private DollarIconEditText f13982g;
    private BetterTextView f13983h;
    private BetterTextView f13984i;

    private static <T extends View> void m14490a(Class<T> cls, T t) {
        m14491a((Object) t, t.getContext());
    }

    private static void m14491a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OrionThirdPartyReceiptView) obj).m14489a(ReceiptAmountViewController.m14529a(injectorLike), ReceiptThirdPartyStatusViewController.m14549a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), PaymentsTextViewLinkHelper.b(injectorLike));
    }

    public final void mo553a(Object obj, ReceiptFragment receiptFragment) {
        obj = (PaymentTransaction) obj;
        m14492c(obj);
        this.f13976a.m14534a(obj);
        this.f13977b.m14553a(obj);
    }

    public final void mo554b(Object obj, ReceiptFragment receiptFragment) {
        obj = (PaymentTransaction) obj;
        m14492c(obj);
        this.f13976a.f14039e = this.f13982g;
        this.f13976a.m14534a(obj);
        this.f13977b.f14072b = this.f13983h;
        this.f13977b.m14553a(obj);
        this.f13979d.a(2131240381, "[[learn_more_link]]", this.f13978c.getString(2131240377), this.f13984i, "https://m.facebook.com/help/android-app/919479321397007");
    }

    public OrionThirdPartyReceiptView(Context context) {
        this(context, null);
    }

    public OrionThirdPartyReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrionThirdPartyReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14490a(OrionThirdPartyReceiptView.class, (View) this);
        setContentView(2130905939);
        this.f13980e = (ReceiptHeaderView) findViewById(2131565290);
        this.f13981f = (ReceiptHeaderView) findViewById(2131565291);
        this.f13982g = (DollarIconEditText) findViewById(2131563921);
        this.f13983h = (BetterTextView) findViewById(2131565292);
        this.f13984i = (BetterTextView) findViewById(2131565293);
    }

    private void m14489a(ReceiptAmountViewController receiptAmountViewController, ReceiptThirdPartyStatusViewController receiptThirdPartyStatusViewController, Resources resources, PaymentsTextViewLinkHelper paymentsTextViewLinkHelper) {
        this.f13976a = receiptAmountViewController;
        this.f13977b = receiptThirdPartyStatusViewController;
        this.f13978c = resources;
        this.f13979d = paymentsTextViewLinkHelper;
    }

    public final void mo551a() {
    }

    public final void mo552a(int i, int i2, Intent intent) {
    }

    private void m14492c(PaymentTransaction paymentTransaction) {
        ReceiptHeaderView receiptHeaderView = this.f13980e;
        ReceiptHeaderViewParamsBuilder newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = paymentTransaction.f13231d;
        newBuilder = newBuilder;
        newBuilder.f14153b = paymentTransaction.f13231d.mo527c();
        newBuilder = newBuilder;
        newBuilder.f14154c = this.f13978c.getString(2131240337);
        newBuilder = newBuilder;
        newBuilder.f14155d = true;
        receiptHeaderView.setReceiptHeaderViewParams(newBuilder.m14627e());
        receiptHeaderView = this.f13981f;
        newBuilder = ReceiptHeaderViewParams.newBuilder();
        newBuilder.f14152a = paymentTransaction.f13232e;
        newBuilder = newBuilder;
        newBuilder.f14153b = paymentTransaction.f13232e.mo527c();
        newBuilder = newBuilder;
        newBuilder.f14154c = this.f13978c.getString(2131240336);
        newBuilder = newBuilder;
        newBuilder.f14155d = false;
        receiptHeaderView.setReceiptHeaderViewParams(newBuilder.m14627e());
    }
}

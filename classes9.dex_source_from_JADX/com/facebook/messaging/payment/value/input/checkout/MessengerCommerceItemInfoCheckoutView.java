package com.facebook.messaging.payment.value.input.checkout;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import javax.annotation.Nullable;

/* compiled from: encodedCredentialId */
public class MessengerCommerceItemInfoCheckoutView extends PaymentsComponentLinearLayout {
    public static final CallerContext f15780a = CallerContext.a(MessengerCommerceItemInfoCheckoutView.class);
    public FbDraweeView f15781b;
    private SingleItemInfoView f15782c;

    public MessengerCommerceItemInfoCheckoutView(Context context) {
        super(context);
        m15967a();
    }

    public MessengerCommerceItemInfoCheckoutView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m15967a();
    }

    public MessengerCommerceItemInfoCheckoutView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15967a();
    }

    private void m15967a() {
        setContentView(2130905243);
        setOrientation(1);
        this.f15781b = (FbDraweeView) a(2131563669);
        this.f15782c = (SingleItemInfoView) a(2131563833);
    }

    public void setSingleItemInfoViewParams(SingleItemInfoViewParams singleItemInfoViewParams) {
        this.f15782c.setViewParams(singleItemInfoViewParams);
    }
}

package com.facebook.messaging.payment.prefs.cards;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.association.PaymentCardAssociationHelper.C14891;
import com.facebook.payments.paymentmethods.model.FbPaymentCardType;
import com.facebook.resources.ui.FbTextView;

/* compiled from: groupThreadFbId */
public class PaymentCardPreference extends Preference implements InjectableComponentWithoutContext {
    public final PaymentCard f13902a;
    private final FbPaymentCardType f13903b;
    public boolean f13904c = false;
    public FbTextView f13905d;
    public FbTextView f13906e;
    public Resources f13907f;

    public static void m14432a(Object obj, Context context) {
        ((PaymentCardPreference) obj).f13907f = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public PaymentCardPreference(Context context, PaymentCard paymentCard) {
        super(context);
        Class cls = PaymentCardPreference.class;
        m14432a(this, context);
        this.f13902a = paymentCard;
        this.f13903b = FbPaymentCardType.forValue(paymentCard.f13207f);
        setLayoutResource(2130906143);
    }

    protected void onBindView(View view) {
        int i;
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131565800);
        Resources resources = this.f13907f;
        switch (C14891.f13270a[this.f13903b.ordinal()]) {
            case 1:
                i = 2130838008;
                break;
            case 2:
                i = 2130838009;
                break;
            case 3:
                i = 2130838010;
                break;
            case 4:
                i = 2130838012;
                break;
            default:
                i = 2130838011;
                break;
        }
        imageView.setImageDrawable(resources.getDrawable(i));
        this.f13905d = (FbTextView) view.findViewById(2131565801);
        resources = this.f13907f;
        Object[] objArr = new Object[3];
        objArr[0] = this.f13903b.getHumanReadableName();
        objArr[1] = this.f13902a.mo522g().cardType.isPresent() ? this.f13907f.getString(((Integer) this.f13902a.mo522g().cardType.get()).intValue()) : "";
        objArr[2] = this.f13902a.m13503e();
        this.f13905d.setText(resources.getString(2131240311, objArr));
        this.f13906e = (FbTextView) view.findViewById(2131565802);
        if (!this.f13904c || this.f13905d == null) {
            this.f13906e.setVisibility(8);
        } else {
            this.f13906e.setVisibility(0);
        }
    }
}

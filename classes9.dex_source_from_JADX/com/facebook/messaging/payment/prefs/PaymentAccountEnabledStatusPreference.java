package com.facebook.messaging.payment.prefs;

import android.content.Context;
import android.content.res.Resources;
import android.preference.Preference;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.payments.util.PaymentsTextViewLinkHelper;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: group_set_as_cover */
public class PaymentAccountEnabledStatusPreference extends Preference implements InjectableComponentWithoutContext {
    @Inject
    public Resources f13782a;
    @Inject
    public PaymentsTextViewLinkHelper f13783b;

    public static void m14349a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PaymentAccountEnabledStatusPreference paymentAccountEnabledStatusPreference = (PaymentAccountEnabledStatusPreference) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        PaymentsTextViewLinkHelper b = PaymentsTextViewLinkHelper.b(fbInjector);
        paymentAccountEnabledStatusPreference.f13782a = a;
        paymentAccountEnabledStatusPreference.f13783b = b;
    }

    public PaymentAccountEnabledStatusPreference(Context context) {
        super(context);
        Class cls = PaymentAccountEnabledStatusPreference.class;
        m14349a(this, context);
        setLayoutResource(2130906142);
    }

    public void onBindView(View view) {
        super.onBindView(view);
        ((ImageView) view.findViewById(2131565798)).setColorFilter(this.f13782a.getColor(2131362299));
        this.f13783b.a(2131240315, "[[contact_us_link]]", this.f13782a.getString(2131240316), (FbTextView) view.findViewById(2131565799), "https://m.facebook.com/help/contact/223254857690713");
    }
}

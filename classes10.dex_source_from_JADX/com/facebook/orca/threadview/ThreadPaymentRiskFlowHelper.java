package com.facebook.orca.threadview;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbClock;
import com.facebook.messaging.payment.utils.PaymentRiskFlowHelper;
import javax.inject.Inject;

/* compiled from: message_capping_composer_button_enter_saved_mode */
public class ThreadPaymentRiskFlowHelper {
    private final DefaultBlueServiceOperationFactory f7432a;
    public final PaymentRiskFlowHelper f7433b;
    private Clock f7434c;
    private Resources f7435d;

    public static ThreadPaymentRiskFlowHelper m7075b(InjectorLike injectorLike) {
        return new ThreadPaymentRiskFlowHelper(DefaultBlueServiceOperationFactory.b(injectorLike), PaymentRiskFlowHelper.b(injectorLike), (Clock) DbClock.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThreadPaymentRiskFlowHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, PaymentRiskFlowHelper paymentRiskFlowHelper, Clock clock, Resources resources) {
        this.f7432a = defaultBlueServiceOperationFactory;
        this.f7433b = paymentRiskFlowHelper;
        this.f7434c = clock;
        this.f7435d = resources;
    }
}

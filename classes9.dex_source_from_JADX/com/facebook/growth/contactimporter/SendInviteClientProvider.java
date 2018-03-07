package com.facebook.growth.contactimporter;

import com.facebook.common.hardware.String_StrictPhoneIsoCountryCodeMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.katana.findfriends.CIFlow;

/* compiled from: paymentPlatformContext */
public class SendInviteClientProvider extends AbstractAssistedProvider<SendInviteClient> {
    public final SendInviteClient m7395a(CIFlow cIFlow) {
        return new SendInviteClient(cIFlow, DefaultBlueServiceOperationFactory.b(this), String_StrictPhoneIsoCountryCodeMethodAutoProvider.b(this));
    }
}

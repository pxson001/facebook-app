package com.facebook.languages.switchercommonex;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.FbBroadcastManagerType;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: total_size */
public class LocaleChangeBroadcastReceiverRegistration extends INeedInitForBroadcastReceiverRegistration<LocaleChangeController> {
    protected void onReceive(Context context, Intent intent, Object obj) {
        ((LocaleChangeController) obj).m29100a();
    }

    @Inject
    public LocaleChangeBroadcastReceiverRegistration(Lazy<LocaleChangeController> lazy) {
        super(FbBroadcastManagerType.GLOBAL, (Lazy) lazy, "android.intent.action.LOCALE_CHANGED");
    }
}

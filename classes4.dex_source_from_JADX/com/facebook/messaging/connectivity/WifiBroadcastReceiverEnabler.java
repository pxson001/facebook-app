package com.facebook.messaging.connectivity;

import android.content.ComponentName;
import android.content.Context;
import com.facebook.base.broadcast.ReceiverComponentEnabler;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: mShouldShareLock */
public class WifiBroadcastReceiverEnabler implements INeedInit {
    private final FbAppType f8553a;
    private final GatekeeperStoreImpl f8554b;
    private final ReceiverComponentEnabler f8555c;

    public static WifiBroadcastReceiverEnabler m8811b(InjectorLike injectorLike) {
        return new WifiBroadcastReceiverEnabler((FbAppType) injectorLike.getInstance(FbAppType.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), new ReceiverComponentEnabler((Context) injectorLike.getInstance(Context.class, ForAppContext.class), PackageManagerMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public WifiBroadcastReceiverEnabler(FbAppType fbAppType, GatekeeperStoreImpl gatekeeperStoreImpl, ReceiverComponentEnabler receiverComponentEnabler) {
        this.f8553a = fbAppType;
        this.f8554b = gatekeeperStoreImpl;
        this.f8555c = receiverComponentEnabler;
    }

    public void init() {
        if (this.f8553a.j == Product.MESSENGER) {
            ReceiverComponentEnabler receiverComponentEnabler;
            if (this.f8554b.a(346, false)) {
                receiverComponentEnabler = this.f8555c;
                receiverComponentEnabler.f8557b.setComponentEnabledSetting(new ComponentName(receiverComponentEnabler.f8556a, ConnectivityBroadcastReceiver.class), 1, 1);
                return;
            }
            receiverComponentEnabler = this.f8555c;
            receiverComponentEnabler.f8557b.setComponentEnabledSetting(new ComponentName(receiverComponentEnabler.f8556a, ConnectivityBroadcastReceiver.class), 2, 1);
        }
    }
}

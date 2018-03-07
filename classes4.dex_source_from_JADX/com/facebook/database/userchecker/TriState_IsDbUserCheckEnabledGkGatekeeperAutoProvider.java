package com.facebook.database.userchecker;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: messenger_floating_heart_sticker_ids */
public class TriState_IsDbUserCheckEnabledGkGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(50);
    }
}

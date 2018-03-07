package com.facebook.video.settings;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: newsfeed_db-journal */
public class Boolean_IsVideoDefaultAutoplaySettingOffGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1164, true));
    }
}

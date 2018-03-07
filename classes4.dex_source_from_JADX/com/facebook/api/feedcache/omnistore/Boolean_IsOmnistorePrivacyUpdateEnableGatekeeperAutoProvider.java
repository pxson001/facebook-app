package com.facebook.api.feedcache.omnistore;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: messenger_media_upload_phase_two_failed */
public class Boolean_IsOmnistorePrivacyUpdateEnableGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(1021, false));
    }
}

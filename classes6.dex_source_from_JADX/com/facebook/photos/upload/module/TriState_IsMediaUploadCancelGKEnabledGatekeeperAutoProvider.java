package com.facebook.photos.upload.module;

import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: grammar_type */
public class TriState_IsMediaUploadCancelGKEnabledGatekeeperAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return GatekeeperStoreImplMethodAutoProvider.a(this).a(803);
    }
}

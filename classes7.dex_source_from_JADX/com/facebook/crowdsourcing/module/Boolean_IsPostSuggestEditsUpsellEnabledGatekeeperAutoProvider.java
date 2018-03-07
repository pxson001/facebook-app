package com.facebook.crowdsourcing.module;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.webm.WebmExtractor */
public class Boolean_IsPostSuggestEditsUpsellEnabledGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(411, false));
    }
}

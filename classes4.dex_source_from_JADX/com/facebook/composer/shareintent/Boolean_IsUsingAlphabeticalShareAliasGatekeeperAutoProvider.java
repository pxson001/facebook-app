package com.facebook.composer.shareintent;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractProvider;

/* compiled from: sms_permanent_contact_search_loaded_today */
public class Boolean_IsUsingAlphabeticalShareAliasGatekeeperAutoProvider extends AbstractProvider<Boolean> {
    public Object get() {
        return Boolean.valueOf(GatekeeperStoreImplMethodAutoProvider.a(this).a(606, false));
    }
}

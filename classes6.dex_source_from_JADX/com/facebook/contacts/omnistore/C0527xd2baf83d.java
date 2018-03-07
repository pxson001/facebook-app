package com.facebook.contacts.omnistore;

import com.facebook.inject.AbstractProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.IndexerFunctionMultibindWrapper;

/* compiled from: param_key_report_directory */
public class C0527xd2baf83d extends AbstractProvider<IndexerFunctionMultibindWrapper> {
    public Object get() {
        return ContactsOmnistoreModule.a(IdBasedLazy.a(this, 8767));
    }
}

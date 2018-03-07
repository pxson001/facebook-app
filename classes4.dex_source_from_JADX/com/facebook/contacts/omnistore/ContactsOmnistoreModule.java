package com.facebook.contacts.omnistore;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Omnistore;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.CollectionIndexingFunction;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.IndexerFunctionMultibindWrapper;

@InjectorModule
/* compiled from: inline_notification_cache_id */
public class ContactsOmnistoreModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @UserScoped
    @ContactsCollection
    static CollectionName m10853a(Omnistore omnistore, String str) {
        return omnistore.createCollectionNameBuilder("messenger_contacts_android").addSegment(str).addDeviceId().build();
    }

    @ProviderMethod
    @UserScoped
    @ContactsCollection
    static CollectionIndexingFunction m10854a(CollectionName collectionName, ContactIndexerFunction contactIndexerFunction) {
        return new CollectionIndexingFunction(collectionName, contactIndexerFunction);
    }

    @ProviderMethod
    @ContactsCollection
    public static IndexerFunctionMultibindWrapper m10855a(Lazy<CollectionIndexingFunction> lazy) {
        return new IndexerFunctionMultibindWrapper(lazy);
    }

    @ProviderMethod
    public static ContactsStorageMode m10852a(Boolean bool) {
        return bool.booleanValue() ? ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION : ContactsStorageMode.CONTACTS_DATABASE;
    }
}

package com.facebook.contacts.omnistore;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.contacts.index.ContactIndexer;
import com.facebook.contacts.index.ContactIndexer.IndexWriter;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultimap;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: participant_customizations */
public class ContactCollectionIndexer {
    public final ContactIndexer f8345a;
    public final Provider<String> f8346b;

    /* compiled from: participant_customizations */
    public class C05251 implements IndexWriter {
        final /* synthetic */ HashMultimap f8343a;
        final /* synthetic */ ContactCollectionIndexer f8344b;

        public C05251(ContactCollectionIndexer contactCollectionIndexer, HashMultimap hashMultimap) {
            this.f8344b = contactCollectionIndexer;
            this.f8343a = hashMultimap;
        }

        public final void m12120a(String str, String str2) {
            this.f8343a.a(str, str2);
        }

        public final void m12119a(String str, float f) {
            Preconditions.checkArgument(f >= 0.0f, "Expected rank range violated by type %s with value %f", new Object[]{str, Float.valueOf(f)});
            this.f8343a.a(str, StringFormatUtil.formatStrLocaleSafe("%.6f", Float.valueOf(f)));
        }
    }

    @Inject
    public ContactCollectionIndexer(ContactIndexer contactIndexer, Provider<String> provider) {
        this.f8345a = contactIndexer;
        this.f8346b = provider;
    }
}

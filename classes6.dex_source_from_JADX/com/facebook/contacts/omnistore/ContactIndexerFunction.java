package com.facebook.contacts.omnistore;

import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.index.ContactIndexer;
import com.facebook.contacts.omnistore.ContactCollectionIndexer.C05251;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.module.OmnistoreIndexerRegistration.IndexEntry;
import com.google.common.collect.HashMultimap;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: participantInfo */
public class ContactIndexerFunction {
    private final ContactCollectionIndexer f8347a;

    public static ContactIndexerFunction m12121b(InjectorLike injectorLike) {
        return new ContactIndexerFunction(new ContactCollectionIndexer(ContactIndexer.b(injectorLike), IdBasedProvider.a(injectorLike, 4442)));
    }

    @Inject
    public ContactIndexerFunction(ContactCollectionIndexer contactCollectionIndexer) {
        this.f8347a = contactCollectionIndexer;
    }

    public List<IndexEntry> addIndexEntries(CollectionName collectionName, String str, String str2, ByteBuffer byteBuffer) {
        ContactCollectionIndexer contactCollectionIndexer = this.f8347a;
        Contact a = ContactTranscription.m12133a(byteBuffer);
        HashMultimap u = HashMultimap.u();
        contactCollectionIndexer.f8345a.a(a, new C05251(contactCollectionIndexer, u));
        u.a(ContactsIndexType.PROFILE_TYPE.getDbValue(), Integer.toString(a.A().getDbValue()));
        u.a(ContactsIndexType.LINK_TYPE.getDbValue(), Integer.toString(ContactLinkType.getFromContact(a, (String) contactCollectionIndexer.f8346b.get()).getDbValue()));
        u.a(ContactsIndexType.FBID.getDbValue(), a.c());
        u.a(ContactsIndexType.IS_PUSHABLE_TRISTATE.getDbValue(), Integer.toString(a.r().getDbValue()));
        u.a(ContactsIndexType.IS_MESSENGER_USER.getDbValue(), a.s() ? "1" : "0");
        u.a(ContactsIndexType.IS_IN_CONTACT_LIST.getDbValue(), a.v() ? "1" : "0");
        u.a(ContactsIndexType.IS_ZERO_COMMUNICATION_RANK.getDbValue(), a.m() == 0.0f ? "1" : "0");
        Set<Entry> t = u.t();
        List arrayList = new ArrayList(t.size());
        for (Entry entry : t) {
            arrayList.add(new IndexEntry((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}

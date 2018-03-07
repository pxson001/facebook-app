package com.facebook.contacts.iterator;

import com.facebook.common.i18n.BreakIteratorHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.index.PhoneNumberNormalizer;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.omnistore.ContactsCollectionHolder;
import com.facebook.contacts.omnistore.ContactsIndexType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Collection.SortDirection;
import com.facebook.omnistore.Cursor;
import com.facebook.omnistore.IndexQuery;
import com.facebook.omnistore.IndexQuery.QueryOperator;
import com.facebook.user.model.UserKey;
import com.facebook.user.names.NameNormalizer;
import com.facebook.user.names.Normalizer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: peerUserID */
public class ContactsOmnistoreQuery {
    private static final ImmutableMap<SearchType, ContactsIndexType> f8234a = ImmutableMap.builder().b(SearchType.PHONE_E164, ContactsIndexType.PHONE_E164).b(SearchType.PHONE_NATIONAL, ContactsIndexType.PHONE_NATIONAL).b(SearchType.PHONE_LOCAL, ContactsIndexType.PHONE_LOCAL).b(SearchType.PHONE_VERIFIED, ContactsIndexType.PHONE_VERIFIED).b();
    private static volatile ContactsOmnistoreQuery f8235f;
    private final Provider<ContactsCollectionHolder> f8236b;
    private final Provider<String> f8237c;
    private final BreakIteratorHelper f8238d;
    public final NameNormalizer f8239e;

    public static com.facebook.contacts.iterator.ContactsOmnistoreQuery m12068a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8235f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.ContactsOmnistoreQuery.class;
        monitor-enter(r1);
        r0 = f8235f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12071b(r0);	 Catch:{ all -> 0x0035 }
        f8235f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8235f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.ContactsOmnistoreQuery.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.ContactsOmnistoreQuery");
    }

    private static ContactsOmnistoreQuery m12071b(InjectorLike injectorLike) {
        return new ContactsOmnistoreQuery(IdBasedSingletonScopeProvider.a(injectorLike, 5354), IdBasedProvider.a(injectorLike, 4442), BreakIteratorHelper.a(injectorLike), NameNormalizer.b(injectorLike));
    }

    @Inject
    public ContactsOmnistoreQuery(Provider<ContactsCollectionHolder> provider, Provider<String> provider2, BreakIteratorHelper breakIteratorHelper, Normalizer normalizer) {
        this.f8236b = provider;
        this.f8237c = provider2;
        this.f8238d = breakIteratorHelper;
        this.f8239e = normalizer;
    }

    public final Cursor m12073a(ContactCursorsQuery contactCursorsQuery, Set<SearchType> set) {
        Object obj;
        Collection a = ((ContactsCollectionHolder) this.f8236b.get()).m12149a();
        java.util.Collection collection = contactCursorsQuery.a;
        java.util.Collection collection2 = contactCursorsQuery.b;
        java.util.Collection collection3 = contactCursorsQuery.c;
        if ((collection == null || !collection.isEmpty()) && ((collection2 == null || !collection2.isEmpty()) && (collection3 == null || !collection3.isEmpty()))) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return a.query("", 0, SortDirection.DESCENDING);
        }
        IndexQuery b = m12072b(contactCursorsQuery, set);
        SortKey sortKey = contactCursorsQuery.k;
        int i = contactCursorsQuery.m;
        if (sortKey == SortKey.NO_SORT_ORDER || sortKey == SortKey.ID) {
            return a.queryWithIndex(b, i);
        }
        return a.queryWithIndexSorted(b, sortKey.mOmnistoreIndexColumnName, contactCursorsQuery.l ? SortDirection.DESCENDING : SortDirection.ASCENDING, i);
    }

    private IndexQuery m12072b(ContactCursorsQuery contactCursorsQuery, Set<SearchType> set) {
        List arrayList;
        List arrayList2 = new ArrayList();
        String str = contactCursorsQuery.d;
        if (str != null) {
            arrayList2.add(IndexQuery.or(m12070a(str, (Set) set)));
        }
        java.util.Collection<ContactProfileType> collection = contactCursorsQuery.a;
        if (collection != null) {
            arrayList = new ArrayList(collection.size());
            for (ContactProfileType dbValue : collection) {
                arrayList.add(IndexQuery.predicate(ContactsIndexType.PROFILE_TYPE.getDbValue(), QueryOperator.EQUAL_TO, Integer.toString(dbValue.getDbValue())));
            }
            arrayList2.add(IndexQuery.or(arrayList));
        }
        java.util.Collection<ContactLinkType> collection2 = contactCursorsQuery.b;
        if (collection2 != null) {
            arrayList = new ArrayList(collection2.size());
            for (ContactLinkType dbValue2 : collection2) {
                arrayList.add(IndexQuery.predicate(ContactsIndexType.LINK_TYPE.getDbValue(), QueryOperator.EQUAL_TO, Integer.toString(dbValue2.getDbValue())));
            }
            arrayList2.add(IndexQuery.or(arrayList));
        }
        java.util.Collection<UserKey> collection3 = contactCursorsQuery.c;
        if (collection3 != null) {
            arrayList = new ArrayList(collection3.size());
            for (UserKey b : collection3) {
                arrayList.add(IndexQuery.predicate(ContactsIndexType.FBID.getDbValue(), QueryOperator.EQUAL_TO, b.b()));
            }
            arrayList2.add(IndexQuery.or(arrayList));
        }
        if (contactCursorsQuery.e) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.FBID.getDbValue(), QueryOperator.NOT_EQUAL, (String) this.f8237c.get()));
        }
        if (contactCursorsQuery.g) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.IS_MESSENGER_USER.getDbValue(), QueryOperator.EQUAL_TO, "0"));
        }
        if (contactCursorsQuery.h) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.IS_MESSENGER_USER.getDbValue(), QueryOperator.EQUAL_TO, "1"));
        }
        if (contactCursorsQuery.f) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.IS_PUSHABLE_TRISTATE.getDbValue(), QueryOperator.EQUAL_TO, Integer.toString(TriState.YES.getDbValue())));
        }
        if (contactCursorsQuery.i) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.IS_IN_CONTACT_LIST.getDbValue(), QueryOperator.EQUAL_TO, "1"));
        }
        if (contactCursorsQuery.j) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.IS_ZERO_COMMUNICATION_RANK.getDbValue(), QueryOperator.EQUAL_TO, "1"));
        }
        return IndexQuery.and(arrayList2);
    }

    private ArrayList<IndexQuery> m12070a(String str, Set<SearchType> set) {
        ArrayList<IndexQuery> arrayList = new ArrayList(set.size());
        if (set.contains(SearchType.NAME)) {
            arrayList.add(m12069a(str));
        }
        if (set.contains(SearchType.USERNAME)) {
            arrayList.add(IndexQuery.predicate(ContactsIndexType.USERNAME_KEY.getDbValue(), QueryOperator.GLOB, this.f8239e.a(str) + "*"));
        }
        String a = PhoneNumberNormalizer.m12038a(str);
        if (a.isEmpty()) {
            return arrayList;
        }
        for (SearchType searchType : set) {
            ContactsIndexType contactsIndexType = (ContactsIndexType) f8234a.get(searchType);
            if (contactsIndexType != null) {
                arrayList.add(IndexQuery.predicate(contactsIndexType.getDbValue(), QueryOperator.GLOB, a + "*"));
            }
        }
        return arrayList;
    }

    private IndexQuery m12069a(String str) {
        int i = 0;
        ImmutableList a = this.f8238d.a(str);
        ArrayList arrayList = new ArrayList(a.size());
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            CharSequence a2 = this.f8239e.a((String) a.get(i2));
            if (!StringUtil.a(a2)) {
                arrayList.add(a2);
            }
        }
        if (arrayList.isEmpty() || arrayList.size() > 4) {
            arrayList.clear();
            arrayList.add(this.f8239e.a(str));
        }
        List arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        while (i < size2) {
            arrayList2.add(IndexQuery.predicate(ContactsIndexType.NAME.getDbValue(), QueryOperator.GLOB, ((String) arrayList.get(i)) + "*"));
            i++;
        }
        return IndexQuery.and(arrayList2);
    }
}

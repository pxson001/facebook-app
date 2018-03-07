package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.contacts.data.FbContactsContract;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.graphql.contactprofiletype.ContactProfileType;
import com.facebook.contacts.omnistore.UserTranscription;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: emails */
public class UserIterators {
    private static final Class<?> f13175a = UserIterators.class;
    private static volatile UserIterators f13176g;
    private final Lazy<ContactCursors> f13177b;
    private final Provider<ContactsStorageMode> f13178c;
    private final Lazy<ContactsOmnistoreQuery> f13179d;
    private final Lazy<UserTranscription> f13180e;
    private final FbContactsContract f13181f;

    public static com.facebook.contacts.iterator.UserIterators m14040a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13176g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.UserIterators.class;
        monitor-enter(r1);
        r0 = f13176g;	 Catch:{ all -> 0x003a }
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
        r0 = m14041b(r0);	 Catch:{ all -> 0x0035 }
        f13176g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13176g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.UserIterators.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.UserIterators");
    }

    private static UserIterators m14041b(InjectorLike injectorLike) {
        return new UserIterators(IdBasedSingletonScopeProvider.b(injectorLike, 930), IdBasedProvider.a(injectorLike, 939), IdBasedSingletonScopeProvider.b(injectorLike, 5350), IdBasedSingletonScopeProvider.b(injectorLike, 5358), FbContactsContract.m11624a(injectorLike));
    }

    @Inject
    public UserIterators(Lazy<ContactCursors> lazy, Provider<ContactsStorageMode> provider, Lazy<ContactsOmnistoreQuery> lazy2, Lazy<UserTranscription> lazy3, FbContactsContract fbContactsContract) {
        this.f13177b = lazy;
        this.f13178c = provider;
        this.f13179d = lazy2;
        this.f13180e = lazy3;
        this.f13181f = fbContactsContract;
    }

    public final UserIterator m14042a(ContactCursorsQuery contactCursorsQuery) {
        return m14039a(contactCursorsQuery, this.f13181f.m11626a());
    }

    @Nullable
    private UserIterator m14039a(ContactCursorsQuery contactCursorsQuery, Set<SearchType> set) {
        contactCursorsQuery.f11216a = ContactProfileType.FACEBOOK_FRIENDS_TYPES;
        ContactsStorageMode contactsStorageMode = (ContactsStorageMode) this.f13178c.get();
        switch (contactsStorageMode) {
            case CONTACTS_DATABASE:
                Cursor a = ((ContactCursors) this.f13177b.get()).m11623a(contactCursorsQuery, QueryType.USER, set);
                return a != null ? new UserDatabaseIterator(a) : null;
            case OMNISTORE_CONTACTS_COLLECTION:
                return new UserOmnistoreIterator(((ContactsOmnistoreQuery) this.f13179d.get()).a(contactCursorsQuery, set), (UserTranscription) this.f13180e.get());
            default:
                throw new IllegalStateException("Unexpected contact storage mode " + contactsStorageMode);
        }
    }

    public final List<User> m14043b(ContactCursorsQuery contactCursorsQuery) {
        Object a = m14042a(contactCursorsQuery);
        try {
            List<User> a2 = Lists.a(a);
            return a2;
        } finally {
            a.close();
        }
    }
}

package com.facebook.contacts.iterator;

import android.database.Cursor;
import com.facebook.contacts.data.FbContactsContract;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.data.FbContactsContract.SearchType;
import com.facebook.contacts.database.ContactSerialization;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: retry_by_hashes */
public class ContactIterators {
    private static final Class<?> f3370a = ContactIterators.class;
    private static volatile ContactIterators f3371g;
    private final Provider<ContactsStorageMode> f3372b;
    private final Lazy<ContactSerialization> f3373c;
    private final Lazy<ContactCursors> f3374d;
    private final Lazy<ContactsOmnistoreQuery> f3375e;
    private final FbContactsContract f3376f;

    public static com.facebook.contacts.iterator.ContactIterators m3605a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3371g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.iterator.ContactIterators.class;
        monitor-enter(r1);
        r0 = f3371g;	 Catch:{ all -> 0x003a }
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
        r0 = m3606b(r0);	 Catch:{ all -> 0x0035 }
        f3371g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3371g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.iterator.ContactIterators.a(com.facebook.inject.InjectorLike):com.facebook.contacts.iterator.ContactIterators");
    }

    private static ContactIterators m3606b(InjectorLike injectorLike) {
        return new ContactIterators(IdBasedProvider.a(injectorLike, 939), IdBasedSingletonScopeProvider.b(injectorLike, 909), IdBasedSingletonScopeProvider.b(injectorLike, 930), IdBasedSingletonScopeProvider.b(injectorLike, 5350), FbContactsContract.m11624a(injectorLike));
    }

    @Inject
    public ContactIterators(Provider<ContactsStorageMode> provider, Lazy<ContactSerialization> lazy, Lazy<ContactCursors> lazy2, Lazy<ContactsOmnistoreQuery> lazy3, FbContactsContract fbContactsContract) {
        this.f3372b = provider;
        this.f3373c = lazy;
        this.f3374d = lazy2;
        this.f3375e = lazy3;
        this.f3376f = fbContactsContract;
    }

    @Nullable
    public final ContactIterator m3608a(ContactCursorsQuery contactCursorsQuery, Set<SearchType> set) {
        ContactsStorageMode contactsStorageMode = (ContactsStorageMode) this.f3372b.get();
        switch (1.a[contactsStorageMode.ordinal()]) {
            case 1:
                Cursor a = ((ContactCursors) this.f3374d.get()).m11623a(contactCursorsQuery, QueryType.CONTACT, set);
                return a != null ? new ContactDatabaseCursorIterator(a, (ContactSerialization) this.f3373c.get()) : null;
            case 2:
                return new ContactOmnistoreIterator(((ContactsOmnistoreQuery) this.f3375e.get()).a(contactCursorsQuery, set));
            default:
                throw new IllegalStateException("Unexpected contact storage mode " + contactsStorageMode);
        }
    }

    public final ContactIterator m3607a(ContactCursorsQuery contactCursorsQuery) {
        return m3608a(contactCursorsQuery, this.f3376f.m11626a());
    }
}

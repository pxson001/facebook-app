package com.facebook.contacts.handlers;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactsGraphQlParams;
import com.facebook.contacts.graphql.GraphQLContactDeserializer;
import com.facebook.contacts.handlers.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.omnistore.OmnistoreInsertContactHandler;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.protocol.methods.FetchMultipleContactsMethod;
import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.server.FetchMultipleContactsByFbidParams;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: retry */
public class FetchMultipleContactsHandler {
    private static final Object f3377i = new Object();
    private final Clock f3378a;
    private final ContactIterators f3379b;
    private final ContactsCache f3380c;
    private final FetchMultipleContactsMethod f3381d;
    private final AbstractSingleMethodRunner f3382e;
    private final Provider<ContactsStorageMode> f3383f;
    private final Lazy<DbInsertContactHandler> f3384g;
    private final Lazy<OmnistoreInsertContactHandler> f3385h;

    private static FetchMultipleContactsHandler m3612b(InjectorLike injectorLike) {
        return new FetchMultipleContactsHandler((Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactIterators.m3605a(injectorLike), ContactsCache.m3455a(injectorLike), new FetchMultipleContactsMethod(GraphQLProtocolHelper.a(injectorLike), GraphQLContactDeserializer.m3479a(injectorLike), ContactsGraphQlParams.m3484b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 939), IdBasedSingletonScopeProvider.b(injectorLike, 924), IdBasedLazy.a(injectorLike, 5357));
    }

    private FetchContactsResult m3613b(FetchMultipleContactsByFbidParams fetchMultipleContactsByFbidParams) {
        Collection collection = fetchMultipleContactsByFbidParams.a;
        HashSet hashSet = new HashSet(collection);
        Builder builder = ImmutableList.builder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            UserKey userKey = (UserKey) it.next();
            Contact a = this.f3380c.m3457a(userKey);
            if (a != null) {
                builder.c(a);
                hashSet.remove(userKey);
            }
        }
        return hashSet.isEmpty() ? new FetchContactsResult(DataFreshnessResult.FROM_CACHE_UP_TO_DATE, this.f3378a.a(), builder.b()) : m3610a(fetchMultipleContactsByFbidParams, hashSet, builder);
    }

    public final FetchContactsResult m3615a(FetchMultipleContactsByFbidParams fetchMultipleContactsByFbidParams) {
        Iterator it = fetchMultipleContactsByFbidParams.a.iterator();
        while (it.hasNext()) {
            UserKey userKey = (UserKey) it.next();
            if (userKey.a() != Type.FACEBOOK && userKey.a() != Type.FACEBOOK_CONTACT) {
                throw new FetchMultipleContactsException("Unsupported UserKey type: " + userKey.a());
            }
        }
        return fetchMultipleContactsByFbidParams.b == DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA ? m3614c(fetchMultipleContactsByFbidParams) : m3613b(fetchMultipleContactsByFbidParams);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.handlers.FetchMultipleContactsHandler m3609a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f3377i;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m3612b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3377i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.FetchMultipleContactsHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.handlers.FetchMultipleContactsHandler) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f3377i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.FetchMultipleContactsHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.FetchMultipleContactsHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.handlers.FetchMultipleContactsHandler");
    }

    @Inject
    public FetchMultipleContactsHandler(Clock clock, ContactIterators contactIterators, ContactsCache contactsCache, FetchMultipleContactsMethod fetchMultipleContactsMethod, SingleMethodRunner singleMethodRunner, Provider<ContactsStorageMode> provider, Lazy<DbInsertContactHandler> lazy, Lazy<OmnistoreInsertContactHandler> lazy2) {
        this.f3378a = clock;
        this.f3379b = contactIterators;
        this.f3380c = contactsCache;
        this.f3381d = fetchMultipleContactsMethod;
        this.f3382e = singleMethodRunner;
        this.f3383f = provider;
        this.f3384g = lazy;
        this.f3385h = lazy2;
    }

    private FetchContactsResult m3610a(FetchMultipleContactsByFbidParams fetchMultipleContactsByFbidParams, HashSet<UserKey> hashSet, Builder<Contact> builder) {
        Throwable th;
        Throwable th2;
        DataFreshnessParam b = fetchMultipleContactsByFbidParams.b();
        DataFreshnessResult dataFreshnessResult = DataFreshnessResult.FROM_CACHE_UP_TO_DATE;
        HashMap hashMap = new HashMap(hashSet.size());
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            UserKey userKey = (UserKey) it.next();
            hashMap.put(userKey.b(), userKey);
        }
        ContactIterator a = this.f3379b.m3607a(ContactCursorsQuery.m11632a((Collection) hashSet));
        while (a.hasNext()) {
            try {
                DataFreshnessResult dataFreshnessResult2;
                Contact contact = (Contact) a.next();
                boolean a2 = m3611a(contact);
                if (a2 || b != DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE) {
                    hashMap.remove(contact.m4068c());
                    builder.c(contact);
                    if (a2) {
                        this.f3380c.m3459a(contact);
                    } else {
                        dataFreshnessResult2 = DataFreshnessResult.FROM_CACHE_STALE;
                    }
                } else {
                    dataFreshnessResult2 = dataFreshnessResult;
                }
                dataFreshnessResult = dataFreshnessResult2;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        }
        FetchContactsResult fetchContactsResult = (hashMap.isEmpty() || b == DataFreshnessParam.DO_NOT_CHECK_SERVER) ? new FetchContactsResult(dataFreshnessResult, this.f3378a.a(), builder.b()) : m3614c(fetchMultipleContactsByFbidParams);
        if (a != null) {
            a.close();
        }
        return fetchContactsResult;
        if (a != null) {
            if (th22 != null) {
                try {
                    a.close();
                } catch (Throwable th4) {
                    AndroidCompat.addSuppressed(th22, th4);
                }
            } else {
                a.close();
            }
        }
        throw th;
        throw th;
    }

    private FetchContactsResult m3614c(FetchMultipleContactsByFbidParams fetchMultipleContactsByFbidParams) {
        int i;
        FetchContactsResult fetchContactsResult = (FetchContactsResult) this.f3382e.a(this.f3381d, fetchMultipleContactsByFbidParams);
        ImmutableCollection immutableCollection = fetchContactsResult.a;
        switch (1.a[((ContactsStorageMode) this.f3383f.get()).ordinal()]) {
            case 1:
                ((DbInsertContactHandler) this.f3384g.get()).m3515a(immutableCollection, InsertionType.REPLACE, fetchContactsResult.freshness);
                break;
            case 2:
                int size = immutableCollection.size();
                for (i = 0; i < size; i++) {
                    ((OmnistoreInsertContactHandler) this.f3385h.get()).a((Contact) immutableCollection.get(i));
                }
                break;
        }
        i = immutableCollection.size();
        for (int i2 = 0; i2 < i; i2++) {
            this.f3380c.m3459a((Contact) immutableCollection.get(i2));
        }
        return fetchContactsResult;
    }

    private boolean m3611a(Contact contact) {
        return this.f3383f.get() == ContactsStorageMode.OMNISTORE_CONTACTS_COLLECTION || this.f3378a.a() - contact.m4059G() < 86400000;
    }
}

package com.facebook.contacts.handlers;

import android.content.Intent;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactGraphQLShimModels.AddContactModel;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.omnistore.OmnistoreInsertContactHandler;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.server.AddContactParams;
import com.facebook.contacts.server.AddContactResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: result_action */
public class AddContactHandler {
    private static final Object f3398i = new Object();
    private final AddContactGraphQLHelper f3399a;
    private final ContactIterators f3400b;
    private final ContactsCache f3401c;
    private final BaseFbBroadcastManager f3402d;
    private final GraphQLQueryExecutor f3403e;
    private final Provider<ContactsStorageMode> f3404f;
    private final Lazy<DbInsertContactHandler> f3405g;
    private final Lazy<OmnistoreInsertContactHandler> f3406h;

    private static AddContactHandler m3624b(InjectorLike injectorLike) {
        return new AddContactHandler(AddContactGraphQLHelper.m3627b(injectorLike), ContactIterators.m3605a(injectorLike), ContactsCache.m3455a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 939), IdBasedSingletonScopeProvider.b(injectorLike, 924), IdBasedLazy.a(injectorLike, 5357));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.handlers.AddContactHandler m3623a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3398i;	 Catch:{ all -> 0x006c }
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
        r1 = m3624b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3398i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.AddContactHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.handlers.AddContactHandler) r0;	 Catch:{  }
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
        r0 = f3398i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.handlers.AddContactHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.handlers.AddContactHandler.a(com.facebook.inject.InjectorLike):com.facebook.contacts.handlers.AddContactHandler");
    }

    @Inject
    public AddContactHandler(AddContactGraphQLHelper addContactGraphQLHelper, ContactIterators contactIterators, ContactsCache contactsCache, FbBroadcastManager fbBroadcastManager, GraphQLQueryExecutor graphQLQueryExecutor, Provider<ContactsStorageMode> provider, Lazy<DbInsertContactHandler> lazy, Lazy<OmnistoreInsertContactHandler> lazy2) {
        this.f3399a = addContactGraphQLHelper;
        this.f3400b = contactIterators;
        this.f3401c = contactsCache;
        this.f3404f = provider;
        this.f3405g = lazy;
        this.f3406h = lazy2;
        this.f3402d = fbBroadcastManager;
        this.f3403e = graphQLQueryExecutor;
    }

    public final AddContactResult m3625a(AddContactParams addContactParams) {
        Throwable th;
        try {
            ContactIterator a;
            boolean z;
            Throwable th2;
            Contact a2 = this.f3399a.m3628a(((AddContactModel) ((GraphQLResult) FutureDetour.a(this.f3403e.a(GraphQLRequest.a(this.f3399a.m3629a(addContactParams))), -831985408)).d()).a());
            String c = a2.m4068c();
            if (c != null) {
                a = this.f3400b.m3607a(ContactCursorsQuery.m11631a(c));
                try {
                    z = a.hasNext() && ((Contact) a.next()).m4087v();
                    if (a != null) {
                        a.close();
                    }
                    m3626a(a2);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    th3 = th2;
                    th2 = th4;
                }
            } else {
                z = false;
            }
            return new AddContactResult(a2, z);
            throw th2;
            if (a != null) {
                if (th3 != null) {
                    try {
                        a.close();
                    } catch (Throwable th5) {
                        AndroidCompat.addSuppressed(th3, th5);
                    }
                } else {
                    a.close();
                }
            }
            throw th2;
        } catch (ExecutionException e) {
            throw ((Exception) e.getCause());
        }
    }

    public final void m3626a(Contact contact) {
        switch (1.a[((ContactsStorageMode) this.f3404f.get()).ordinal()]) {
            case 1:
                ((DbInsertContactHandler) this.f3405g.get()).m3512a(contact, DataFreshnessResult.FROM_SERVER);
                break;
            case 2:
                ((OmnistoreInsertContactHandler) this.f3406h.get()).a(contact);
                break;
        }
        this.f3401c.m3459a(contact);
        this.f3402d.a(new Intent("com.facebook.contacts.ACTION_CONTACT_ADDED"));
    }
}

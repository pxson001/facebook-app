package com.facebook.messaging.localfetch;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactIterator;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.contacts.util.ContactConverterUtil;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: mPaymentValue */
public class FetchUserHandler {
    private static final Object f11360k = new Object();
    private final DefaultAndroidThreadUtil f11361a;
    private final Clock f11362b;
    public final ContactsCache f11363c;
    private final DataCache f11364d;
    private final DbFetchThreadUsersHandler f11365e;
    private final AbstractFbErrorReporter f11366f;
    private final FetchUserUtil f11367g;
    private final Provider<Boolean> f11368h;
    private final ContactIterators f11369i;
    public final UserCache f11370j;

    private static FetchUserHandler m11958b(InjectorLike injectorLike) {
        return new FetchUserHandler(DefaultAndroidThreadUtil.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsCache.a(injectorLike), DataCache.a(injectorLike), DbFetchThreadUsersHandler.a(injectorLike), ContactIterators.a(injectorLike), new FetchUserUtil(DefaultBlueServiceOperationFactory.b(injectorLike)), IdBasedProvider.a(injectorLike, 4203), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), UserCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.localfetch.FetchUserHandler m11956a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f11360k;	 Catch:{ all -> 0x006c }
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
        r1 = m11958b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f11360k;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.localfetch.FetchUserHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.localfetch.FetchUserHandler) r0;	 Catch:{  }
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
        r0 = f11360k;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.localfetch.FetchUserHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.localfetch.FetchUserHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.localfetch.FetchUserHandler");
    }

    @Inject
    public FetchUserHandler(AndroidThreadUtil androidThreadUtil, Clock clock, ContactsCache contactsCache, DataCache dataCache, DbFetchThreadUsersHandler dbFetchThreadUsersHandler, ContactIterators contactIterators, FetchUserUtil fetchUserUtil, Provider<Boolean> provider, FbErrorReporter fbErrorReporter, UserCache userCache) {
        this.f11361a = androidThreadUtil;
        this.f11362b = clock;
        this.f11369i = contactIterators;
        this.f11363c = contactsCache;
        this.f11364d = dataCache;
        this.f11365e = dbFetchThreadUsersHandler;
        this.f11367g = fetchUserUtil;
        this.f11368h = provider;
        this.f11366f = fbErrorReporter;
        this.f11370j = userCache;
    }

    @Nullable
    public final ImmutableMap<ThreadKey, ImmutableList<User>> m11961a(Set<ThreadKey> set) {
        if (!((Boolean) this.f11368h.get()).booleanValue()) {
            return null;
        }
        Builder builder = ImmutableMap.builder();
        for (ThreadKey threadKey : set) {
            UserKey a = ThreadKey.a(threadKey);
            if (a == null) {
                return null;
            }
            ListenableFuture a2 = this.f11367g.m11962a(a);
            if (a2 == null) {
                return null;
            }
            Object obj;
            ImmutableList.Builder builder2 = ImmutableList.builder();
            try {
                obj = (User) FutureDetour.a(a2, 1, TimeUnit.SECONDS, -1147056830);
            } catch (Throwable e) {
                this.f11366f.a("FetchUserHandler", "InterruptedException raised while waiting for contact fetching futures to return.", e);
                obj = null;
            } catch (Throwable e2) {
                this.f11366f.a("FetchUserHandler", "ExecutionException raised while waiting for contact fetching futures to return.", e2);
                obj = null;
            } catch (Throwable e22) {
                this.f11366f.a("FetchUserHandler", "TimeoutException raised while waiting for contact fetching futures to return.", e22);
                obj = null;
            }
            if (obj == null) {
                return null;
            }
            builder2.c(obj);
            builder.b(threadKey, builder2.b());
        }
        return builder.b();
    }

    @Nullable
    public final User m11960a(UserKey userKey) {
        if (userKey == null) {
            return null;
        }
        User a = this.f11370j.a(userKey);
        if (a != null) {
            Name name = a.e;
        } else {
            Contact a2 = this.f11363c.a(userKey);
            if (a2 != null) {
                a2.e();
                a = ContactConverterUtil.a(a2);
            }
        }
        User user = a;
        if (user == null) {
            return m11959c(userKey);
        }
        return user;
    }

    @Nullable
    private User m11959c(UserKey userKey) {
        ContactIterator a;
        Throwable e;
        ContactIterator contactIterator;
        this.f11361a.b();
        User a2 = this.f11365e.a(userKey);
        if (a2 != null) {
            a2.d();
            return a2;
        }
        try {
            a = this.f11369i.a(ContactCursorsQuery.a(userKey.b()));
            try {
                User a3;
                Contact contact = (Contact) a.next();
                if (contact != null) {
                    long a4 = this.f11362b.a() - contact.G();
                    if (a4 > 86400000) {
                        userKey.b();
                        Long.valueOf(a4);
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    }
                    a3 = ContactConverterUtil.a(contact);
                } else {
                    a3 = a2;
                }
                if (a != null) {
                    a.close();
                }
                return a3;
            } catch (Exception e2) {
                e = e2;
                contactIterator = a;
                try {
                    this.f11366f.a("FetchUserHandler", "Exception raised while fetching contact for database.", e);
                    if (contactIterator != null) {
                        contactIterator.close();
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    a = contactIterator;
                    if (a != null) {
                        a.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                if (a != null) {
                    a.close();
                }
                throw e;
            }
        } catch (Exception e3) {
            e = e3;
            contactIterator = null;
            this.f11366f.a("FetchUserHandler", "Exception raised while fetching contact for database.", e);
            if (contactIterator != null) {
                contactIterator.close();
            }
            return null;
        } catch (Throwable th3) {
            e = th3;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
    }

    public static ImmutableList<User> m11957a(User user, ImmutableList<User> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        builder.b(immutableList);
        builder.c(user);
        return builder.b();
    }
}

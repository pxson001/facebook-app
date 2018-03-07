package com.facebook.contacts.service;

import android.content.Intent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.contacts.cache.ContactsCache;
import com.facebook.contacts.graphql.ContactGraphQLModels.ContactCoefficientModel;
import com.facebook.contacts.handlers.DbInsertContactHandler;
import com.facebook.contacts.handlers.DbInsertContactHandler.InsertionType;
import com.facebook.contacts.handlers.DbUpdateContactsCoefficientHandler;
import com.facebook.contacts.properties.ContactsDbStateChecker;
import com.facebook.contacts.properties.ContactsStorageMode;
import com.facebook.contacts.properties.DbContactsProperties;
import com.facebook.contacts.properties.DbContactsPropertyUtil;
import com.facebook.contacts.protocol.methods.FetchAllContactsMethod;
import com.facebook.contacts.protocol.methods.FetchDeltaContactsMethod;
import com.facebook.contacts.server.FetchAllContactsParams;
import com.facebook.contacts.server.FetchAllContactsResult;
import com.facebook.contacts.server.FetchAllContactsResultBuilder;
import com.facebook.contacts.server.FetchDeltaContactsParams;
import com.facebook.contacts.server.FetchDeltaContactsResult;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.http.protocol.ApiErrorResult.ErrorDomain;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: reused_later_distance */
public class ContactsWebFetcher {
    private static final Class<?> f3341a;
    private static final CallerContext f3342b;
    private static final Object f3343q = new Object();
    private final Clock f3344c;
    private final ContactsCache f3345d;
    private final DbContactsPropertyUtil f3346e;
    private final DbInsertContactHandler f3347f;
    private final FetchAllContactsMethod f3348g;
    private final FetchDeltaContactsMethod f3349h;
    private final BaseFbBroadcastManager f3350i;
    private final AbstractSingleMethodRunner f3351j;
    private final Locales f3352k;
    private final ContactsDbStateChecker f3353l;
    private final AbstractFbErrorReporter f3354m;
    private final GQLContactsCoefficientQueryHelper f3355n;
    private final DbUpdateContactsCoefficientHandler f3356o;
    private final Provider<ContactsStorageMode> f3357p;

    private static ContactsWebFetcher m3581b(InjectorLike injectorLike) {
        return new ContactsWebFetcher((Clock) SystemClockMethodAutoProvider.a(injectorLike), ContactsCache.m3455a(injectorLike), DbContactsPropertyUtil.m8548b(injectorLike), DbInsertContactHandler.m3505a(injectorLike), FetchAllContactsMethod.m3589b(injectorLike), FetchDeltaContactsMethod.m3595b(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), Locales.a(injectorLike), ContactsDbStateChecker.m8582a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GQLContactsCoefficientQueryHelper.m3599b(injectorLike), DbUpdateContactsCoefficientHandler.m3601b(injectorLike), IdBasedProvider.a(injectorLike, 939));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.contacts.service.ContactsWebFetcher m3577a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3343q;	 Catch:{ all -> 0x006c }
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
        r1 = m3581b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3343q;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.contacts.service.ContactsWebFetcher) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.contacts.service.ContactsWebFetcher) r0;	 Catch:{  }
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
        r0 = f3343q;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.contacts.service.ContactsWebFetcher) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.service.ContactsWebFetcher.a(com.facebook.inject.InjectorLike):com.facebook.contacts.service.ContactsWebFetcher");
    }

    static {
        Class cls = ContactsWebFetcher.class;
        f3341a = cls;
        f3342b = CallerContext.a(cls);
    }

    @Inject
    public ContactsWebFetcher(Clock clock, ContactsCache contactsCache, DbContactsPropertyUtil dbContactsPropertyUtil, DbInsertContactHandler dbInsertContactHandler, FetchAllContactsMethod fetchAllContactsMethod, FetchDeltaContactsMethod fetchDeltaContactsMethod, FbBroadcastManager fbBroadcastManager, SingleMethodRunner singleMethodRunner, Locales locales, ContactsDbStateChecker contactsDbStateChecker, FbErrorReporter fbErrorReporter, GQLContactsCoefficientQueryHelper gQLContactsCoefficientQueryHelper, DbUpdateContactsCoefficientHandler dbUpdateContactsCoefficientHandler, Provider<ContactsStorageMode> provider) {
        this.f3344c = clock;
        this.f3345d = contactsCache;
        this.f3346e = dbContactsPropertyUtil;
        this.f3347f = dbInsertContactHandler;
        this.f3348g = fetchAllContactsMethod;
        this.f3349h = fetchDeltaContactsMethod;
        this.f3350i = fbBroadcastManager;
        this.f3351j = singleMethodRunner;
        this.f3352k = locales;
        this.f3353l = contactsDbStateChecker;
        this.f3354m = fbErrorReporter;
        this.f3355n = gQLContactsCoefficientQueryHelper;
        this.f3356o = dbUpdateContactsCoefficientHandler;
        this.f3357p = provider;
    }

    public final synchronized void m3587a() {
        m3582c();
        long a = this.f3344c.a();
        boolean z = false;
        String f = m3585f();
        if (f == null) {
            f = m3584e().m4154f();
            z = true;
        }
        m3580a(a, f, z);
    }

    public final synchronized ImmutableList<ContactCoefficientModel> m3588b() {
        m3582c();
        return m3583d();
    }

    private void m3582c() {
        Preconditions.checkState(this.f3357p.get() == ContactsStorageMode.CONTACTS_DATABASE, "Trying to download contacts with legacy contacts disabled");
    }

    private ImmutableList<ContactCoefficientModel> m3583d() {
        TracerDetour.a("syncCoefficients", 71438334);
        try {
            ImmutableList<ContactCoefficientModel> a = this.f3355n.m3600a();
            if (a.isEmpty()) {
                throw new RuntimeException("GQLContactsCoefficientQueryHelper returned an empty list");
            }
            this.f3356o.m3604a(a);
            this.f3345d.m3458a();
            this.f3350i.a(new Intent("com.facebook.contacts.ACTION_COEFFICIENTS_UPDATED"));
            return a;
        } finally {
            TracerDetour.a(1155178879);
        }
    }

    private FetchAllContactsResult m3584e() {
        String str = null;
        int i = InsertionType.REPLACE_ALL;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0:
        while (true) {
            FetchAllContactsResult fetchAllContactsResult;
            int i5 = i2 == 0 ? 20 : 50;
            TracerDetour.a("syncContactsFull (%d contacts)", Integer.valueOf(i5), -1084578849);
            String a = LoomLoggerDetour.a(-40589275);
            LoomLogger.a(a, "syncContactsFull", String.valueOf(i5));
            try {
                fetchAllContactsResult = (FetchAllContactsResult) this.f3351j.a(this.f3348g, FetchAllContactsParams.m3643a(i5, i3), f3342b);
                i3 = i4 + 1;
                if (i4 == 0) {
                    str = fetchAllContactsResult.m4155g();
                }
                ImmutableCollection c = fetchAllContactsResult.m4151c();
                this.f3347f.m3515a(c, (InsertionType) i, DataFreshnessResult.FROM_SERVER);
                a = fetchAllContactsResult.m4152d();
                Integer.valueOf(c.size());
                i = i2 + c.size();
                this.f3350i.a(new Intent("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS"));
                InsertionType insertionType = InsertionType.INSERT;
                if (!fetchAllContactsResult.m4153e()) {
                    break loop0;
                }
                i2 = i;
                i = insertionType;
                i4 = i3;
                i3 = a;
            } finally {
                str = 1462508068;
                TracerDetour.a(1462508068);
            }
        }
        this.f3353l.m8585c();
        this.f3345d.m3458a();
        this.f3350i.a(new Intent("com.facebook.contacts.CONTACTS_SYNC_DONE"));
        Integer.valueOf(i);
        if (i3 > 1) {
            return new FetchAllContactsResultBuilder().a(fetchAllContactsResult).a(str).h();
        }
        return fetchAllContactsResult;
    }

    @Nullable
    private String m3585f() {
        String str = null;
        String g = m3586g();
        if (g != null) {
            try {
                str = m3579a(g);
            } catch (Throwable e) {
                ApiErrorResult b = e.m10826b();
                if (b.m10837h() == ErrorDomain.GRAPHQL_KERROR_DOMAIN && b.m10832a() == 1702001) {
                    BLog.a(f3341a, e, "Delta sync cursor %s no longer valid, falling back to full sync.", new Object[]{g});
                } else if (b.m10832a() == 1675011) {
                    this.f3354m.a("ContactsWebFetcher", "Invalid cursor: " + g, e);
                } else {
                    throw e;
                }
            }
        }
        return str;
    }

    private String m3579a(String str) {
        int i = 0;
        loop0:
        while (true) {
            TracerDetour.a("syncContactsDelta (%d contacts)", Integer.valueOf(50), -2083860990);
            LoomLogger.a(LoomLoggerDetour.a(-999221363), "syncContactsDelta", "50");
            try {
                FetchDeltaContactsResult fetchDeltaContactsResult = (FetchDeltaContactsResult) this.f3351j.a(this.f3349h, new FetchDeltaContactsParams(50, str), f3342b);
                ImmutableCollection c = fetchDeltaContactsResult.c();
                this.f3347f.m3515a(c, InsertionType.INSERT, DataFreshnessResult.FROM_SERVER);
                i += c.size();
                Iterable d = fetchDeltaContactsResult.d();
                this.f3347f.m3514a((ImmutableCollection) d);
                this.f3345d.m3460a(m3578a(d));
                i += d.size();
                str = fetchDeltaContactsResult.e();
                this.f3350i.a(new Intent("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS"));
                if (!fetchDeltaContactsResult.f()) {
                    break loop0;
                }
            } finally {
                i = 1728895467;
                TracerDetour.a(1728895467);
            }
        }
        if (i > 0) {
            this.f3350i.a(new Intent("com.facebook.contacts.CONTACTS_SYNC_DONE"));
        }
        return str;
    }

    @Nullable
    private String m3586g() {
        if (this.f3353l.m8584a()) {
            return null;
        }
        return this.f3346e.m8551a(DbContactsProperties.f13093d);
    }

    private void m3580a(long j, String str, boolean z) {
        Preconditions.checkState(str != null);
        this.f3346e.m8557b(DbContactsProperties.f13090a, j);
        if (z) {
            this.f3346e.m8557b(DbContactsProperties.f13091b, j);
        }
        this.f3346e.m8558b(DbContactsProperties.f13092c, this.f3352k.g());
        this.f3346e.m8558b(DbContactsProperties.f13093d, str);
    }

    private static ImmutableList<UserKey> m3578a(Iterable<String> iterable) {
        Builder builder = ImmutableList.builder();
        for (String userKey : iterable) {
            builder.c(new UserKey(Type.FACEBOOK_CONTACT, userKey));
        }
        return builder.b();
    }
}

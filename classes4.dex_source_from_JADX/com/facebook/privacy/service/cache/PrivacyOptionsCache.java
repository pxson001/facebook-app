package com.facebook.privacy.service.cache;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.cache.db.DbComposerHandler;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.privacy.PrivacyPrefKeys;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionsResultFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: signature */
public class PrivacyOptionsCache implements IHaveUserData {
    private static final Class<?> f2187a = PrivacyOptionsCache.class;
    private static volatile PrivacyOptionsCache f2188k;
    private final long f2189b = 86400000;
    private final Clock f2190c;
    private final Provider<DbComposerHandler> f2191d;
    private final ObjectMapper f2192e;
    private final PrivacyOptionsResultFactory f2193f;
    private final FbSharedPreferences f2194g;
    public volatile PrivacyOptionsResult f2195h;
    public volatile Optional<GraphQLPrivacyOption> f2196i;
    public volatile long f2197j;

    public static com.facebook.privacy.service.cache.PrivacyOptionsCache m2371a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2188k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.service.cache.PrivacyOptionsCache.class;
        monitor-enter(r1);
        r0 = f2188k;	 Catch:{ all -> 0x003a }
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
        r0 = m2372b(r0);	 Catch:{ all -> 0x0035 }
        f2188k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2188k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.service.cache.PrivacyOptionsCache.a(com.facebook.inject.InjectorLike):com.facebook.privacy.service.cache.PrivacyOptionsCache");
    }

    private static PrivacyOptionsCache m2372b(InjectorLike injectorLike) {
        return new PrivacyOptionsCache((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 860), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), PrivacyOptionsResultFactory.m2331b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public PrivacyOptionsCache(Clock clock, Provider<DbComposerHandler> provider, ObjectMapper objectMapper, PrivacyOptionsResultFactory privacyOptionsResultFactory, FbSharedPreferences fbSharedPreferences) {
        this.f2190c = clock;
        this.f2191d = provider;
        this.f2192e = objectMapper;
        this.f2193f = privacyOptionsResultFactory;
        this.f2194g = fbSharedPreferences;
        this.f2196i = Absent.INSTANCE;
    }

    private synchronized void m2373c() {
        try {
            this.f2194g.edit().a(PrivacyPrefKeys.f2160b, this.f2192e.a(this.f2195h.selectedPrivacyOption)).commit();
            ((DbComposerHandler) this.f2191d.get()).m846a(this.f2192e.a(this.f2195h));
        } catch (Throwable e) {
            BLog.b(f2187a, "Unable to write privacy options result to disk.", e);
        }
    }

    public final synchronized void m2377a(PrivacyOptionsResult privacyOptionsResult) {
        Preconditions.checkNotNull(privacyOptionsResult);
        this.f2195h = PrivacyOptionsResult.m2336a(privacyOptionsResult).m2379a().m2381b();
        this.f2196i = Optional.fromNullable(this.f2195h.selectedPrivacyOption);
        this.f2197j = this.f2190c.a();
        m2373c();
    }

    public final synchronized void m2376a(GraphQLPrivacyOption graphQLPrivacyOption) {
        if (this.f2195h != null) {
            this.f2195h = PrivacyOptionsResult.m2336a(this.f2195h).m2380a(graphQLPrivacyOption).m2381b();
            this.f2196i = Optional.fromNullable(this.f2195h.selectedPrivacyOption);
            m2373c();
        }
    }

    public final synchronized PrivacyOptionsResult m2375a(boolean z) {
        PrivacyOptionsResult privacyOptionsResult;
        if (this.f2195h != null || z) {
            privacyOptionsResult = this.f2195h;
        } else {
            String a = ((DbComposerHandler) this.f2191d.get()).m845a();
            if (a == null) {
                privacyOptionsResult = this.f2195h;
            } else {
                try {
                    this.f2195h = (PrivacyOptionsResult) this.f2192e.a(a, PrivacyOptionsResult.class);
                    this.f2195h = this.f2193f.m2335a(this.f2195h);
                    this.f2196i = Optional.fromNullable(this.f2195h.selectedPrivacyOption);
                    this.f2197j = this.f2190c.a() - 86400000;
                } catch (Throwable e) {
                    BLog.b(f2187a, "Unable to read privacy options result from disk.", e);
                }
                privacyOptionsResult = this.f2195h;
            }
        }
        return privacyOptionsResult;
    }

    @Nullable
    public final synchronized GraphQLPrivacyOption m2374a() {
        GraphQLPrivacyOption graphQLPrivacyOption;
        if (this.f2196i.isPresent()) {
            graphQLPrivacyOption = (GraphQLPrivacyOption) this.f2196i.get();
        } else {
            String a = this.f2194g.a(PrivacyPrefKeys.f2160b, null);
            if (a == null) {
                graphQLPrivacyOption = null;
            } else {
                try {
                    graphQLPrivacyOption = (GraphQLPrivacyOption) this.f2192e.a(a, GraphQLPrivacyOption.class);
                    this.f2196i = Optional.fromNullable(graphQLPrivacyOption);
                } catch (Throwable e) {
                    BLog.b(f2187a, "Unable to read selected privacy option from prefs.", e);
                    graphQLPrivacyOption = null;
                }
            }
        }
        return graphQLPrivacyOption;
    }

    public final synchronized boolean m2378b() {
        return this.f2190c.a() - this.f2197j > 86400000;
    }

    public void clearUserData() {
        this.f2195h = null;
        this.f2196i = Absent.INSTANCE;
        this.f2197j = 0;
    }
}

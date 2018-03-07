package com.facebook.privacy.service;

import android.os.Bundle;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.BlueServiceHandler$Filter;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.privacy.service.cache.PrivacyOptionsCache;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: signup?provider_name=%s&provider_page_fbid=%s */
public final class PrivacyCacheServiceHandler implements BlueServiceHandler$Filter {
    private static volatile PrivacyCacheServiceHandler f2183c;
    public final Lazy<PrivacyOptionsCache> f2184a;
    public final Lazy<PrivacyAnalyticsLogger> f2185b;

    public static com.facebook.privacy.service.PrivacyCacheServiceHandler m2359a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2183c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.service.PrivacyCacheServiceHandler.class;
        monitor-enter(r1);
        r0 = f2183c;	 Catch:{ all -> 0x003a }
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
        r0 = m2360b(r0);	 Catch:{ all -> 0x0035 }
        f2183c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2183c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.service.PrivacyCacheServiceHandler.a(com.facebook.inject.InjectorLike):com.facebook.privacy.service.PrivacyCacheServiceHandler");
    }

    private static PrivacyCacheServiceHandler m2360b(InjectorLike injectorLike) {
        return new PrivacyCacheServiceHandler(IdBasedSingletonScopeProvider.b(injectorLike, 3117), IdBasedLazy.a(injectorLike, 3115));
    }

    @Inject
    public PrivacyCacheServiceHandler(Lazy<PrivacyOptionsCache> lazy, Lazy<PrivacyAnalyticsLogger> lazy2) {
        this.f2184a = lazy;
        this.f2185b = lazy2;
    }

    public final OperationResult mo57a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        if (!"fetch_privacy_options".equals(operationParams.b)) {
            return blueServiceHandler.a(operationParams);
        }
        OperationResult a;
        OperationResult operationResult;
        DataFreshnessParam a2 = m2358a(operationParams.c, DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE);
        PrivacyOptionsResult a3 = ((PrivacyOptionsCache) this.f2184a.get()).m2375a(false);
        if (a2 != DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA && (!((PrivacyOptionsCache) this.f2184a.get()).m2378b() || a2 == DataFreshnessParam.STALE_DATA_OKAY)) {
            if (a3 == null) {
                ((PrivacyAnalyticsLogger) this.f2185b.get()).m2367a(Events.BLOCK_FOR_CACHED_COMPOSER_OPTIONS);
            } else {
                a = OperationResult.a(a3);
                PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) a.k();
                if (!(privacyOptionsResult == null || privacyOptionsResult.selectedPrivacyOption == null || privacyOptionsResult.selectedPrivacyOption.c() == null)) {
                    operationResult = a;
                    return operationResult;
                }
            }
        }
        a = blueServiceHandler.a(operationParams);
        if (a.b) {
            m2362a((PrivacyOptionsResult) a.k(), a3);
        }
        operationResult = a;
        return operationResult;
    }

    public final void m2362a(PrivacyOptionsResult privacyOptionsResult, @Nullable PrivacyOptionsResult privacyOptionsResult2) {
        if (privacyOptionsResult != null) {
            ((PrivacyAnalyticsLogger) this.f2185b.get()).m2367a(Events.COMPOSER_OPTIONS_FETCHED);
            if (!(privacyOptionsResult2 == null || privacyOptionsResult2.selectedPrivacyOption == null || privacyOptionsResult.selectedPrivacyOption == null || Objects.equal(privacyOptionsResult2.selectedPrivacyOption.c(), privacyOptionsResult.selectedPrivacyOption.c()))) {
                ((PrivacyAnalyticsLogger) this.f2185b.get()).m2367a(Events.STICKY_PRIVACY_CHANGED_BY_FETCH);
            }
            ((PrivacyOptionsCache) this.f2184a.get()).m2377a(privacyOptionsResult);
        }
    }

    public static DataFreshnessParam m2358a(Bundle bundle, DataFreshnessParam dataFreshnessParam) {
        String string = bundle.getString("privacy.data_freshness");
        if (string == null) {
            return dataFreshnessParam;
        }
        DataFreshnessParam valueOf = DataFreshnessParam.valueOf(string);
        if (valueOf == null) {
            return dataFreshnessParam;
        }
        boolean z = DataFreshnessParam.STALE_DATA_OKAY.equals(valueOf) || DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA.equals(valueOf) || DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE.equals(valueOf);
        Preconditions.checkArgument(z);
        return valueOf;
    }
}

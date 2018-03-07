package com.facebook.orca.background;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.stickers.analytics.StickersStorageAnalyticsLogger;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPackIdsParams;
import com.facebook.stickers.service.FetchStickerPackIdsParamsBuilder;
import com.facebook.stickers.service.FetchStickersParams;
import com.facebook.stickers.service.FetchStickersParams.StickersUpdateOperation;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: fa_stab_ms */
public class StickerAssetFlushBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12383a;
    public static final CallerContext f12384b;
    private static volatile StickerAssetFlushBackgroundTask f12385l;
    private final Provider<Boolean> f12386c;
    private final Provider<Boolean> f12387d;
    private final Clock f12388e;
    private final FbSharedPreferences f12389f;
    public final DefaultBlueServiceOperationFactory f12390g;
    private final ListeningExecutorService f12391h;
    private final XConfigReader f12392i;
    public final StickersStorageAnalyticsLogger f12393j;
    private final RateLimiter f12394k;

    public static com.facebook.orca.background.StickerAssetFlushBackgroundTask m13089a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12385l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.StickerAssetFlushBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12385l;	 Catch:{ all -> 0x003a }
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
        r0 = m13093b(r0);	 Catch:{ all -> 0x0035 }
        f12385l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12385l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.StickerAssetFlushBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.StickerAssetFlushBackgroundTask");
    }

    private static StickerAssetFlushBackgroundTask m13093b(InjectorLike injectorLike) {
        return new StickerAssetFlushBackgroundTask(IdBasedProvider.a(injectorLike, 4333), IdBasedProvider.a(injectorLike, 4059), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike), StickersStorageAnalyticsLogger.m13077a(injectorLike));
    }

    static {
        Class cls = StickerAssetFlushBackgroundTask.class;
        f12383a = cls;
        f12384b = CallerContext.a(cls);
    }

    @Inject
    public StickerAssetFlushBackgroundTask(Provider<Boolean> provider, Provider<Boolean> provider2, Clock clock, FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, ListeningExecutorService listeningExecutorService, XConfigReader xConfigReader, StickersStorageAnalyticsLogger stickersStorageAnalyticsLogger) {
        super("STICKER_ASSET_FLUSH_BACKGROUND_TASK");
        this.f12386c = provider;
        this.f12387d = provider2;
        this.f12388e = clock;
        this.f12389f = fbSharedPreferences;
        this.f12390g = blueServiceOperationFactory;
        this.f12391h = listeningExecutorService;
        this.f12392i = xConfigReader;
        this.f12393j = stickersStorageAnalyticsLogger;
        this.f12394k = new RateLimiter(clock, 4, 14400000);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final boolean mo595i() {
        long a = this.f12389f.a(StickerPrefKeys.n, 0);
        boolean z;
        if (this.f12389f.a(FetchStickerPacksBackgroundTask.f12301a, 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (((Boolean) this.f12386c.get()).booleanValue() && r1 && this.f12388e.a() - a >= 86400000) {
            return true;
        }
        return false;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        if (!this.f12394k.a()) {
            return Futures.a(new BackgroundResult(true));
        }
        List list;
        this.f12393j.m13081a();
        m13094l();
        int a = this.f12389f.a(StickerPrefKeys.m, 0);
        int a2 = this.f12392i.a(StickerAssetFlushXConfig.f1843e, 0);
        boolean z = a2 > a;
        String a3 = this.f12392i.a(StickerAssetFlushXConfig.f1842d, "");
        if (!z || Strings.isNullOrEmpty(a3)) {
            list = RegularImmutableList.a;
        } else if ("ALL".equals(a3)) {
            list = null;
        } else {
            list = StringUtil.a(a3, ',');
        }
        if (((Boolean) this.f12387d.get()).booleanValue()) {
            long a4 = this.f12389f.a(StickerPrefKeys.o, (this.f12388e.a() - 604800000) / 1000);
            FetchStickerPackIdsParamsBuilder newBuilder = FetchStickerPackIdsParams.newBuilder();
            newBuilder.a = StickerPackType.STORE_PACKS;
            newBuilder = newBuilder;
            newBuilder.b = a4;
            newBuilder = newBuilder;
            newBuilder.c = true;
            FetchStickerPackIdsParams d = newBuilder.d();
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickerPackIdsParams", d);
            return Futures.b(BlueServiceOperationFactoryDetour.a(this.f12390g, "fetch_sticker_pack_ids", bundle, ErrorPropagation.BY_EXCEPTION, f12384b, -1820458881).a(), new 1(this, list, z, a2), this.f12391h);
        }
        return m13091a(this, list, RegularImmutableList.a, z ? a2 : -1);
    }

    public static ListenableFuture m13091a(@Nullable StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, List list, List list2, int i) {
        if (i == -1 && list2.isEmpty()) {
            m13095m(stickerAssetFlushBackgroundTask);
            stickerAssetFlushBackgroundTask.f12393j.m13086b();
            return Futures.a(new BackgroundResult(true));
        }
        ListenableFuture a;
        if (list2.isEmpty()) {
            a = Futures.a(OperationResult.a);
        } else {
            a = BlueServiceOperationFactoryDetour.a(stickerAssetFlushBackgroundTask.f12390g, "clear_sticker_cache", new Bundle(), ErrorPropagation.BY_EXCEPTION, f12384b, -1457903307).a();
        }
        return Futures.b(Futures.b(a, new 2(stickerAssetFlushBackgroundTask), stickerAssetFlushBackgroundTask.f12391h), new 3(stickerAssetFlushBackgroundTask, list, list2, i), stickerAssetFlushBackgroundTask.f12391h);
    }

    public static ListenableFuture m13090a(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, List list, int i) {
        Iterable a = Lists.a();
        for (int i2 = 0; i2 < list.size(); i2 += 100) {
            Parcelable fetchStickersParams = new FetchStickersParams(list.subList(i2, Math.min(list.size(), i2 + 100)), StickersUpdateOperation.REPLACE_FROM_NETWORK);
            Bundle bundle = new Bundle();
            bundle.putParcelable("fetchStickersParams", fetchStickersParams);
            a.add(BlueServiceOperationFactoryDetour.a(stickerAssetFlushBackgroundTask.f12390g, "fetch_stickers", bundle, ErrorPropagation.BY_EXCEPTION, f12384b, -873141440).a());
        }
        SettableFuture f = SettableFuture.f();
        Futures.a(Futures.a(a), new 4(stickerAssetFlushBackgroundTask, i, f), stickerAssetFlushBackgroundTask.f12391h);
        return f;
    }

    private void m13094l() {
        this.f12389f.edit().a(StickerPrefKeys.n, this.f12388e.a()).commit();
    }

    public static void m13095m(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask) {
        stickerAssetFlushBackgroundTask.f12389f.edit().a(StickerPrefKeys.o, stickerAssetFlushBackgroundTask.f12388e.a() / 1000).commit();
    }

    public static void m13092a(StickerAssetFlushBackgroundTask stickerAssetFlushBackgroundTask, int i) {
        stickerAssetFlushBackgroundTask.f12389f.edit().a(StickerPrefKeys.m, i).commit();
    }
}

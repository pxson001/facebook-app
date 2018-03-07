package com.facebook.orca.background;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.StickersQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: failed_count */
public class FetchStickerPacksBackgroundTask extends AbstractBackgroundTask {
    public static final PrefKey f12301a = ((PrefKey) MessagingPrefKeys.c.a("background/stickers/packmetadata"));
    public static final Class<?> f12302b;
    public static final CallerContext f12303c;
    private static volatile FetchStickerPacksBackgroundTask f12304m;
    public final DefaultBlueServiceOperationFactory f12305d;
    public final FbSharedPreferences f12306e;
    public final Clock f12307f;
    public final ExecutorService f12308g;
    private final ExecutorService f12309h;
    public final Provider<Boolean> f12310i;
    private final Provider<Boolean> f12311j;
    private final StickerAssetDownloadManagerHelper f12312k;
    private final Provider<Boolean> f12313l;

    public static com.facebook.orca.background.FetchStickerPacksBackgroundTask m12990a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12304m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.FetchStickerPacksBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12304m;	 Catch:{ all -> 0x003a }
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
        r0 = m12991b(r0);	 Catch:{ all -> 0x0035 }
        f12304m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12304m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchStickerPacksBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchStickerPacksBackgroundTask");
    }

    private static FetchStickerPacksBackgroundTask m12991b(InjectorLike injectorLike) {
        return new FetchStickerPacksBackgroundTask(DefaultBlueServiceOperationFactory.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4048), IdBasedProvider.a(injectorLike, 4045), StickerAssetDownloadManagerHelper.m12997a(injectorLike), IdBasedProvider.a(injectorLike, 4163));
    }

    static {
        Class cls = FetchStickerPacksBackgroundTask.class;
        f12302b = cls;
        f12303c = CallerContext.b(cls, "sticker_fetch_packs");
    }

    @Inject
    public FetchStickerPacksBackgroundTask(BlueServiceOperationFactory blueServiceOperationFactory, FbSharedPreferences fbSharedPreferences, Clock clock, ExecutorService executorService, ExecutorService executorService2, Provider<Boolean> provider, Provider<Boolean> provider2, StickerAssetDownloadManagerHelper stickerAssetDownloadManagerHelper, Provider<Boolean> provider3) {
        super("DELTA_STICKER_PACK_METADATA_BACKGROUND_FETCH");
        this.f12305d = blueServiceOperationFactory;
        this.f12306e = fbSharedPreferences;
        this.f12307f = clock;
        this.f12308g = executorService;
        this.f12309h = executorService2;
        this.f12310i = provider;
        this.f12311j = provider2;
        this.f12312k = stickerAssetDownloadManagerHelper;
        this.f12313l = provider3;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(StickersQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        if (((Boolean) this.f12311j.get()).booleanValue()) {
            return false;
        }
        if (((Boolean) this.f12313l.get()).booleanValue()) {
            return false;
        }
        return this.f12307f.a() - this.f12306e.a(f12301a, 0) > 86400000;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        SettableFuture f = SettableFuture.f();
        Builder builder = new Builder(StickerPackType.AUTODOWNLOADED_PACKS, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
        builder.f3917c = InterfaceInputInterface.MESSAGES;
        builder = builder;
        builder.f3921g = true;
        Parcelable a = builder.m4385a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f12305d, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, f12303c, 1797286885).a(), new 1(this, f12302b, f), this.f12308g);
        return f;
    }
}

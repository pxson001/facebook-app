package com.facebook.orca.background;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.backgroundtasks.SimpleBackgroundResultFutureCallback;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.file.FileTree;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.stickers.analytics.StickersStorageAnalyticsLogger;
import com.facebook.stickers.data.StickersFileUtil;
import com.facebook.stickers.data.StickersFileUtil.1;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPacksParams;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.stickers.service.StickersQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: push_type */
public class StickerAssetCleanupBackgroundTask extends AbstractBackgroundTask {
    public static final Class<?> f12369a;
    private static final CallerContext f12370b;
    private static volatile StickerAssetCleanupBackgroundTask f12371i;
    public final Clock f12372c;
    private final StickersFileUtil f12373d;
    public final FbSharedPreferences f12374e;
    private final StickersStorageAnalyticsLogger f12375f;
    private final DefaultBlueServiceOperationFactory f12376g;
    private final ListeningExecutorService f12377h;

    public static com.facebook.orca.background.StickerAssetCleanupBackgroundTask m13064a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12371i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.StickerAssetCleanupBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12371i;	 Catch:{ all -> 0x003a }
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
        r0 = m13067b(r0);	 Catch:{ all -> 0x0035 }
        f12371i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12371i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.StickerAssetCleanupBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.StickerAssetCleanupBackgroundTask");
    }

    private static StickerAssetCleanupBackgroundTask m13067b(InjectorLike injectorLike) {
        return new StickerAssetCleanupBackgroundTask((Clock) SystemClockMethodAutoProvider.a(injectorLike), StickersFileUtil.m13050a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), StickersStorageAnalyticsLogger.m13077a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    static {
        Class cls = StickerAssetCleanupBackgroundTask.class;
        f12369a = cls;
        f12370b = CallerContext.b(cls, "sticker_asset_cleanup");
    }

    @Inject
    public StickerAssetCleanupBackgroundTask(Clock clock, StickersFileUtil stickersFileUtil, FbSharedPreferences fbSharedPreferences, StickersStorageAnalyticsLogger stickersStorageAnalyticsLogger, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ListeningExecutorService listeningExecutorService) {
        super("STICKER_ASSET_CLEANUP_BACKGROUND_TASK");
        this.f12372c = clock;
        this.f12373d = stickersFileUtil;
        this.f12374e = fbSharedPreferences;
        this.f12375f = stickersStorageAnalyticsLogger;
        this.f12376g = defaultBlueServiceOperationFactory;
        this.f12377h = listeningExecutorService;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(StickersQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final long mo593f() {
        return this.f12374e.a(StickerPrefKeys.l, 0) + 86400000;
    }

    public final boolean mo595i() {
        return this.f12372c.a() - this.f12374e.a(StickerPrefKeys.l, 0) > 86400000;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        ImmutableList immutableList;
        StickersFileUtil stickersFileUtil = this.f12373d;
        File a = stickersFileUtil.m13054a();
        if (a == null) {
            immutableList = RegularImmutableList.a;
        } else {
            Builder builder = new Builder();
            File[] listFiles = a.listFiles(new 1(stickersFileUtil));
            if (listFiles == null) {
                immutableList = RegularImmutableList.a;
            } else {
                for (Object c : listFiles) {
                    builder.c(c);
                }
                immutableList = builder.b();
            }
        }
        final ImmutableList immutableList2 = immutableList;
        m13068c(immutableList2);
        FetchStickerPacksParams.Builder builder2 = new FetchStickerPacksParams.Builder(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.DO_NOT_CHECK_SERVER);
        builder2.f3917c = InterfaceInputInterface.MESSAGES;
        Parcelable a2 = builder2.m4385a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a2);
        OperationFuture a3 = BlueServiceOperationFactoryDetour.a(this.f12376g, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, f12370b, 1305867851).a();
        C01871 c01871 = new SimpleBackgroundResultFutureCallback(this, f12369a) {
            final /* synthetic */ StickerAssetCleanupBackgroundTask f4006b;

            public /* synthetic */ void onSuccess(Object obj) {
                mo305a((OperationResult) obj);
            }

            public final void mo305a(OperationResult operationResult) {
                try {
                    FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) operationResult.h();
                    if (fetchStickerPacksResult.m4447a().isPresent()) {
                        Set a = StickerAssetCleanupBackgroundTask.m13066a((ImmutableList) fetchStickerPacksResult.m4447a().get());
                        ImmutableList a2 = StickerAssetCleanupBackgroundTask.m13065a(a, immutableList2);
                        this.f4006b.m13069a(a);
                        this.f4006b.m13071b(a2);
                    }
                    this.f4006b.f12374e.edit().a(StickerPrefKeys.l, this.f4006b.f12372c.a()).commit();
                    super.mo305a(operationResult);
                } catch (Throwable e) {
                    super.onFailure(e);
                    BLog.b(StickerAssetCleanupBackgroundTask.f12369a, "Unable to remove unused sticker directory.", e);
                }
            }
        };
        Futures.a(a3, c01871, this.f12377h);
        return c01871;
    }

    public static Set<String> m13066a(ImmutableList<StickerPack> immutableList) {
        Set<String> a = Sets.a();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(((StickerPack) immutableList.get(i)).a);
        }
        return a;
    }

    public static ImmutableList<File> m13065a(Set<String> set, ImmutableList<File> immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            File file = (File) immutableList.get(i);
            if (!set.contains(file.getName())) {
                builder.c(file);
            }
        }
        return builder.b();
    }

    private void m13068c(ImmutableList<File> immutableList) {
        Set<PrefKey> d = this.f12374e.d(StickerPrefKeys.k);
        Set a = Sets.a();
        int length = StickerPrefKeys.k.toString().length();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            a.add(((File) immutableList.get(i)).getName());
        }
        for (PrefKey prefKey : d) {
            if (!a.contains(prefKey.toString().substring(length))) {
                this.f12374e.edit().a(prefKey).commit();
            }
        }
    }

    public final void m13071b(ImmutableList<File> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            File file = (File) immutableList.get(i);
            PrefKey prefKey = (PrefKey) StickerPrefKeys.k.a(file.getName());
            if (this.f12374e.a(prefKey)) {
                if (this.f12372c.a() - this.f12374e.a(prefKey, this.f12372c.a()) > 604800000) {
                    if (FileTree.m3118b(file)) {
                        this.f12374e.edit().a(prefKey).commit();
                        this.f12375f.m13083a(file.getName());
                    } else {
                        BLog.b(f12369a, "Unable to delete unused folder for sticker pack %s", new Object[]{file.getName()});
                    }
                }
            } else {
                this.f12374e.edit().a(prefKey, this.f12372c.a()).commit();
            }
        }
    }

    public final void m13069a(Set<String> set) {
        for (String a : set) {
            PrefKey prefKey = (PrefKey) StickerPrefKeys.k.a(a);
            if (this.f12374e.a(prefKey)) {
                this.f12374e.edit().a(prefKey).commit();
            }
        }
    }
}

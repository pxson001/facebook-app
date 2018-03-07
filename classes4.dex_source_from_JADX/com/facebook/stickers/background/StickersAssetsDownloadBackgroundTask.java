package com.facebook.stickers.background;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.ratelimiter.RateLimiter;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.device.DeviceConditionHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.stickers.abtest.ExperimentsForStickerAbTestingModule;
import com.facebook.stickers.data.StickerAssetsDownloadUtil;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.preferences.StickerPrefKeys;
import com.facebook.stickers.service.FetchStickerPacksAndStickersParams;
import com.facebook.stickers.service.FetchStickerPacksAndStickersResult;
import com.facebook.stickers.service.MessagesStickerServiceGatekeepers;
import com.facebook.stickers.service.StickersQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: reaction_unit */
public class StickersAssetsDownloadBackgroundTask extends AbstractBackgroundTask {
    @VisibleForTesting
    public static final PrefKey f12513a = ((PrefKey) StickerPrefKeys.p.a("last_partial_download_time"));
    @VisibleForTesting
    static final PrefKey f12514b = ((PrefKey) StickerPrefKeys.p.a("last_wifi_connection"));
    @VisibleForTesting
    public static final PrefKey f12515c = ((PrefKey) StickerPrefKeys.p.a("download_complete_time"));
    public static final Class<?> f12516d = StickersAssetsDownloadBackgroundTask.class;
    public static final CallerContext f12517e = CallerContext.b(StickersAssetsDownloadBackgroundTask.class, "sticker_background_fetch");
    private static volatile StickersAssetsDownloadBackgroundTask f12518r;
    public final Clock f12519f;
    private final RateLimiter f12520g;
    private final Provider<Boolean> f12521h;
    public final FbSharedPreferences f12522i;
    public final DefaultBlueServiceOperationFactory f12523j;
    private final ExecutorService f12524k;
    private final DeviceConditionHelper f12525l;
    private final StickerAssetsDownloadUtil f12526m;
    private final Provider<Boolean> f12527n;
    public final MessagesStickerServiceGatekeepers f12528o;
    private final QeAccessor f12529p;
    private final Lazy<AppStateManager> f12530q;

    /* compiled from: reaction_unit */
    class C01782 implements Function<List<OperationResult>, BackgroundResult> {
        final /* synthetic */ StickersAssetsDownloadBackgroundTask f3770a;

        C01782(StickersAssetsDownloadBackgroundTask stickersAssetsDownloadBackgroundTask) {
            this.f3770a = stickersAssetsDownloadBackgroundTask;
        }

        public Object apply(Object obj) {
            Throwable th = null;
            boolean z = true;
            for (OperationResult operationResult : (List) obj) {
                if (!operationResult.b) {
                    Throwable th2;
                    if (operationResult.e == null && th == null && operationResult.g != null) {
                        th2 = operationResult.g;
                    } else {
                        th2 = th;
                    }
                    z = false;
                    th = th2;
                }
            }
            Class cls = StickersAssetsDownloadBackgroundTask.f12516d;
            Boolean.valueOf(z);
            if (z) {
                return new BackgroundResult(true);
            }
            if (th == null) {
                return new BackgroundResult(false);
            }
            throw Throwables.propagate(th);
        }
    }

    public static com.facebook.stickers.background.StickersAssetsDownloadBackgroundTask m13262a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12518r;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.stickers.background.StickersAssetsDownloadBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12518r;	 Catch:{ all -> 0x003a }
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
        r0 = m13265b(r0);	 Catch:{ all -> 0x0035 }
        f12518r = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12518r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stickers.background.StickersAssetsDownloadBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.stickers.background.StickersAssetsDownloadBackgroundTask");
    }

    private static StickersAssetsDownloadBackgroundTask m13265b(InjectorLike injectorLike) {
        return new StickersAssetsDownloadBackgroundTask((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4342), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DeviceConditionHelper.a(injectorLike), StickerAssetsDownloadUtil.m13276a(injectorLike), IdBasedProvider.a(injectorLike, 4163), MessagesStickerServiceGatekeepers.m13278b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 476));
    }

    @Inject
    public StickersAssetsDownloadBackgroundTask(Clock clock, Provider<Boolean> provider, FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, ExecutorService executorService, DeviceConditionHelper deviceConditionHelper, StickerAssetsDownloadUtil stickerAssetsDownloadUtil, Provider<Boolean> provider2, MessagesStickerServiceGatekeepers messagesStickerServiceGatekeepers, QeAccessor qeAccessor, Lazy<AppStateManager> lazy) {
        super("STICKERS_ASSETS_DOWNLOAD_BACKGROUND_TASK");
        this.f12519f = clock;
        this.f12521h = provider;
        this.f12526m = stickerAssetsDownloadUtil;
        this.f12520g = new RateLimiter(clock, 20, 60000);
        this.f12522i = fbSharedPreferences;
        this.f12523j = blueServiceOperationFactory;
        this.f12524k = executorService;
        this.f12525l = deviceConditionHelper;
        this.f12527n = provider2;
        this.f12528o = messagesStickerServiceGatekeepers;
        this.f12529p = qeAccessor;
        this.f12530q = lazy;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(StickersQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(StickerTaskTag.class);
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final boolean mo595i() {
        if (!this.f12520g.a() || !((Boolean) this.f12521h.get()).booleanValue() || ((Boolean) this.f12527n.get()).booleanValue()) {
            return false;
        }
        long a = this.f12522i.a(f12515c, 0);
        boolean z = a == 0;
        boolean z2;
        if (this.f12519f.a() > a + 86400000) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z && !r3) {
            return false;
        }
        if (z) {
            if (this.f12519f.a() < this.f12522i.a(f12513a, 0) + 1800000) {
                return false;
            }
        }
        if (m13264a(true)) {
            return false;
        }
        return true;
    }

    public final long mo593f() {
        if (!((Boolean) this.f12521h.get()).booleanValue()) {
            return -1;
        }
        long a = this.f12522i.a(f12515c, 0);
        if (a != 0) {
            return a + 86400000;
        }
        a = this.f12522i.a(f12513a, 0);
        if (m13264a(false)) {
            return Math.max(this.f12519f.a() + 3600000, a + 1800000);
        }
        if (a != 0) {
            return a + 1800000;
        }
        return this.f12519f.a();
    }

    private boolean m13264a(boolean z) {
        boolean z2;
        if (!this.f12525l.b()) {
            if (z && !this.f12522i.a(f12514b)) {
                this.f12522i.edit().a(f12514b, this.f12519f.a()).commit();
            }
            if (this.f12519f.a() < this.f12522i.a(f12514b, this.f12519f.a()) + 86400000) {
                z2 = true;
                if (!z2 && z) {
                    this.f12522i.edit().a(f12514b, this.f12519f.a()).commit();
                }
                Boolean.valueOf(z2);
                return z2;
            }
        }
        z2 = false;
        this.f12522i.edit().a(f12514b, this.f12519f.a()).commit();
        Boolean.valueOf(z2);
        return z2;
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        int a;
        this.f12522i.edit().a(f12515c).a(f12513a, this.f12519f.a()).commit();
        if (((AppStateManager) this.f12530q.get()).j() && this.f12525l.b()) {
            a = this.f12529p.a(ExperimentsForStickerAbTestingModule.c, 1);
        } else {
            a = 1;
        }
        Integer.valueOf(a);
        Parcelable fetchStickerPacksAndStickersParams = new FetchStickerPacksAndStickersParams(StickerPackType.DOWNLOADED_PACKS, DataFreshnessParam.DO_NOT_CHECK_SERVER);
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksAndStickersParams", fetchStickerPacksAndStickersParams);
        return Futures.a(Futures.b(BlueServiceOperationFactoryDetour.a(this.f12523j, "fetch_sticker_packs_and_stickers", bundle, ErrorPropagation.BY_EXCEPTION, 704272240).a(), new AsyncFunction<OperationResult, List<OperationResult>>(this) {
            final /* synthetic */ StickersAssetsDownloadBackgroundTask f3769b;

            public final ListenableFuture m4205a(Object obj) {
                OperationResult operationResult = (OperationResult) obj;
                if (operationResult.b) {
                    StickersAssetsDownloadBackgroundTask.f12516d;
                    Iterable arrayList = new ArrayList();
                    FetchStickerPacksAndStickersResult fetchStickerPacksAndStickersResult = (FetchStickerPacksAndStickersResult) operationResult.h();
                    ImmutableList immutableList = fetchStickerPacksAndStickersResult.f4002b;
                    int size = immutableList.size();
                    for (int i = 0; i < size; i++) {
                        StickerPack stickerPack = (StickerPack) immutableList.get(i);
                        ImmutableList immutableList2 = (ImmutableList) fetchStickerPacksAndStickersResult.f4003c.get(stickerPack.a());
                        int i2 = (this.f3769b.f12528o.m13279a() && stickerPack.f() == null) ? 1 : 0;
                        if (i2 != 0 || StickersAssetsDownloadBackgroundTask.m13263a(this.f3769b, immutableList2)) {
                            StickersAssetsDownloadBackgroundTask.f12516d;
                            stickerPack.a();
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("stickerPack", stickerPack);
                            arrayList.add(BlueServiceOperationFactoryDetour.a(this.f3769b.f12523j, "download_sticker_pack_assets", bundle, ErrorPropagation.BY_EXCEPTION, StickersAssetsDownloadBackgroundTask.f12517e, -1770816722).a());
                            if (arrayList.size() == a) {
                                StickersAssetsDownloadBackgroundTask.f12516d;
                                Integer.valueOf(arrayList.size());
                                return Futures.a(arrayList);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        StickersAssetsDownloadBackgroundTask.f12516d;
                        StickersAssetsDownloadBackgroundTask.m13267n(this.f3769b);
                        return Futures.a(Lists.a(new OperationResult[]{OperationResult.a()}));
                    }
                    StickersAssetsDownloadBackgroundTask.f12516d;
                    Integer.valueOf(arrayList.size());
                    return Futures.a(arrayList);
                }
                throw Throwables.propagate(operationResult.e());
            }
        }, this.f12524k), new C01782(this), MoreExecutors.a());
    }

    public static void m13267n(StickersAssetsDownloadBackgroundTask stickersAssetsDownloadBackgroundTask) {
        stickersAssetsDownloadBackgroundTask.f12522i.edit().a(f12513a).a(f12515c, stickersAssetsDownloadBackgroundTask.f12519f.a()).commit();
    }

    public static boolean m13263a(StickersAssetsDownloadBackgroundTask stickersAssetsDownloadBackgroundTask, ImmutableList immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sticker sticker = (Sticker) immutableList.get(i);
            Object obj = null;
            if (StickerAssetsDownloadUtil.m13277b(sticker) && StickerAssetsDownloadUtil.m13274a(sticker) != TriState.NO) {
                obj = 1;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}

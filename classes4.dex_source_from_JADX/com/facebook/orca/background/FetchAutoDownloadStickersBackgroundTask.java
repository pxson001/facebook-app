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
import com.facebook.device.DeviceConditionHelper;
import com.facebook.device.DeviceConditionHelper.WifiStateChangedListener;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.calls.InterfaceInputInterface;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.background.MessagesLocalTaskTag;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger;
import com.facebook.stickers.analytics.StickersAutodownloadAnalyticsLogger.OperationStatus;
import com.facebook.stickers.model.StickerPack;
import com.facebook.stickers.model.StickerPackType;
import com.facebook.stickers.service.FetchStickerPacksParams.Builder;
import com.facebook.stickers.service.FetchStickerPacksParams.TrayPacksUpdateOperation;
import com.facebook.stickers.service.FetchStickerPacksResult;
import com.facebook.stickers.service.StickersQueue;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: push_unreg_c2dm */
public class FetchAutoDownloadStickersBackgroundTask extends AbstractBackgroundTask {
    private static final Class<?> f12232a = FetchAutoDownloadStickersBackgroundTask.class;
    public static final PrefKey f12233b = ((PrefKey) MessagingPrefKeys.c.a("background/autodownloadstickers/packdata"));
    private static final CallerContext f12234c = CallerContext.b(FetchAutoDownloadStickersBackgroundTask.class, "sticker_auto_fetch");
    private static volatile FetchAutoDownloadStickersBackgroundTask f12235o;
    public final Clock f12236d;
    private final RateLimiter f12237e;
    private final Provider<Boolean> f12238f;
    public final FbSharedPreferences f12239g;
    private final DeviceConditionHelper f12240h;
    private final DefaultBlueServiceOperationFactory f12241i;
    public final ExecutorService f12242j;
    public final AtomicReference<ListenableFuture> f12243k = new AtomicReference();
    private volatile boolean f12244l = false;
    public final StickersAutodownloadAnalyticsLogger f12245m;
    private final Provider<Boolean> f12246n;

    /* compiled from: push_unreg_c2dm */
    class C01862 implements AsyncFunction<List<OperationResult>, BackgroundResult> {
        final /* synthetic */ FetchAutoDownloadStickersBackgroundTask f4004a;

        C01862(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask) {
            this.f4004a = fetchAutoDownloadStickersBackgroundTask;
        }

        public final ListenableFuture m4498a(@Nullable Object obj) {
            List list = (List) obj;
            this.f4004a.f12245m.m12918a(OperationStatus.COMPLETED);
            FetchStickerPacksResult fetchStickerPacksResult = (FetchStickerPacksResult) ((OperationResult) list.get(0)).h();
            FetchStickerPacksResult fetchStickerPacksResult2 = (FetchStickerPacksResult) ((OperationResult) list.get(1)).h();
            if (fetchStickerPacksResult.f3955b.isPresent() && fetchStickerPacksResult2.f3955b.isPresent()) {
                int i;
                ImmutableList immutableList = (ImmutableList) fetchStickerPacksResult.f3955b.get();
                ImmutableList immutableList2 = (ImmutableList) fetchStickerPacksResult2.f3955b.get();
                Set a = Sets.a();
                int size = immutableList.size();
                for (i = 0; i < size; i++) {
                    a.add(((StickerPack) immutableList.get(i)).a);
                }
                i = immutableList2.size();
                int i2 = 0;
                while (i2 < i) {
                    StickerPack stickerPack = (StickerPack) immutableList2.get(i2);
                    if (a.contains(stickerPack.a)) {
                        i2++;
                    } else if (stickerPack.k) {
                        this.f4004a.f12245m.m12919a(stickerPack.a, OperationStatus.STARTED);
                        return FetchAutoDownloadStickersBackgroundTask.m12904a(this.f4004a, FetchAutoDownloadStickersBackgroundTask.m12907b(this.f4004a, stickerPack), "add_sticker_pack", stickerPack.a);
                    } else {
                        this.f4004a.f12245m.m12921b(stickerPack.a, OperationStatus.STARTED);
                        return FetchAutoDownloadStickersBackgroundTask.m12904a(this.f4004a, FetchAutoDownloadStickersBackgroundTask.m12903a(this.f4004a, stickerPack), "download_sticker_pack_assets", stickerPack.a);
                    }
                }
                this.f4004a.f12239g.edit().a(FetchAutoDownloadStickersBackgroundTask.f12233b, this.f4004a.f12236d.a() + 86400000).commit();
                this.f4004a.f12245m.m12920b();
                FetchAutoDownloadStickersBackgroundTask.m12908m(this.f4004a);
                return Futures.a(new BackgroundResult(true));
            }
            this.f4004a.f12239g.edit().a(FetchAutoDownloadStickersBackgroundTask.f12233b, this.f4004a.f12236d.a() + 3600000).commit();
            this.f4004a.f12245m.m12922c();
            FetchAutoDownloadStickersBackgroundTask.m12908m(this.f4004a);
            return Futures.a(new BackgroundResult(true));
        }
    }

    /* compiled from: push_unreg_c2dm */
    class C05841 implements WifiStateChangedListener {
        final /* synthetic */ FetchAutoDownloadStickersBackgroundTask f12251a;

        C05841(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask) {
            this.f12251a = fetchAutoDownloadStickersBackgroundTask;
        }

        public final void m12923a(DeviceConditionHelper deviceConditionHelper) {
            ExecutorDetour.a(this.f12251a.f12242j, new 1(this, deviceConditionHelper), -1537961320);
        }
    }

    public static com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask m12902a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12235o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask.class;
        monitor-enter(r1);
        r0 = f12235o;	 Catch:{ all -> 0x003a }
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
        r0 = m12906b(r0);	 Catch:{ all -> 0x0035 }
        f12235o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12235o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask.a(com.facebook.inject.InjectorLike):com.facebook.orca.background.FetchAutoDownloadStickersBackgroundTask");
    }

    private static FetchAutoDownloadStickersBackgroundTask m12906b(InjectorLike injectorLike) {
        return new FetchAutoDownloadStickersBackgroundTask(DeviceConditionHelper.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 4047), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), StickersAutodownloadAnalyticsLogger.m12915a(injectorLike), IdBasedProvider.a(injectorLike, 4163));
    }

    @Inject
    public FetchAutoDownloadStickersBackgroundTask(DeviceConditionHelper deviceConditionHelper, BlueServiceOperationFactory blueServiceOperationFactory, Provider<Boolean> provider, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, Clock clock, StickersAutodownloadAnalyticsLogger stickersAutodownloadAnalyticsLogger, Provider<Boolean> provider2) {
        super("AUTO_DOWNLOADED_STICKER_BACKGROUND_FETCH");
        this.f12240h = deviceConditionHelper;
        this.f12241i = blueServiceOperationFactory;
        this.f12238f = provider;
        this.f12242j = executorService;
        this.f12239g = fbSharedPreferences;
        this.f12236d = clock;
        this.f12237e = new RateLimiter(clock, 20, 60000);
        this.f12245m = stickersAutodownloadAnalyticsLogger;
        this.f12246n = provider2;
        if (!((Boolean) this.f12238f.get()).booleanValue()) {
            this.f12240h.a(new C05841(this));
        }
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.NETWORK_CONNECTIVITY, Prerequisite.USER_LOGGED_IN);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo592d() {
        return ImmutableSet.of(StickersQueue.class);
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(MessagesLocalTaskTag.class);
    }

    public final boolean mo595i() {
        boolean z;
        if (this.f12236d.a() > this.f12239g.a(f12233b, 0)) {
            z = true;
        } else {
            z = false;
        }
        return this.f12240h.b() && !this.f12244l && this.f12243k.get() == null && z && !((Boolean) this.f12246n.get()).booleanValue();
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        if (this.f12244l) {
            return null;
        }
        this.f12244l = true;
        if (((ListenableFuture) this.f12243k.get()) == null && this.f12237e.a()) {
            this.f12245m.m12917a();
            this.f12245m.m12918a(OperationStatus.STARTED);
            ListenableFuture<BackgroundResult> b = Futures.b(Futures.a(new ListenableFuture[]{m12905a(StickerPackType.OWNED_PACKS), m12905a(StickerPackType.AUTODOWNLOADED_PACKS)}), new C01862(this), this.f12242j);
            this.f12243k.set(b);
            this.f12244l = false;
            return b;
        }
        this.f12244l = false;
        return null;
    }

    public static ListenableFuture m12904a(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask, ListenableFuture listenableFuture, String str, String str2) {
        return Futures.a(listenableFuture, new 3(fetchAutoDownloadStickersBackgroundTask, str, str2), fetchAutoDownloadStickersBackgroundTask.f12242j);
    }

    private ListenableFuture<OperationResult> m12905a(StickerPackType stickerPackType) {
        stickerPackType.toString();
        Builder builder = new Builder(stickerPackType, DataFreshnessParam.DO_NOT_CHECK_SERVER);
        builder.f3922h = TrayPacksUpdateOperation.DO_NOT_UPDATE;
        builder = builder;
        builder.f3917c = InterfaceInputInterface.MESSAGES;
        Parcelable a = builder.m4385a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("fetchStickerPacksParams", a);
        return BlueServiceOperationFactoryDetour.a(this.f12241i, "fetch_sticker_packs", bundle, ErrorPropagation.BY_EXCEPTION, f12234c, 638686810).a();
    }

    public static ListenableFuture m12903a(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask, StickerPack stickerPack) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("stickerPack", stickerPack);
        return BlueServiceOperationFactoryDetour.a(fetchAutoDownloadStickersBackgroundTask.f12241i, "download_sticker_pack_assets", bundle, ErrorPropagation.BY_EXCEPTION, f12234c, -381739661).a();
    }

    public static ListenableFuture m12907b(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask, StickerPack stickerPack) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("stickerPack", stickerPack);
        return BlueServiceOperationFactoryDetour.a(fetchAutoDownloadStickersBackgroundTask.f12241i, "add_sticker_pack", bundle, ErrorPropagation.BY_EXCEPTION, f12234c, -1124814052).a();
    }

    public static void m12908m(FetchAutoDownloadStickersBackgroundTask fetchAutoDownloadStickersBackgroundTask) {
        fetchAutoDownloadStickersBackgroundTask.f12243k.set(null);
    }
}

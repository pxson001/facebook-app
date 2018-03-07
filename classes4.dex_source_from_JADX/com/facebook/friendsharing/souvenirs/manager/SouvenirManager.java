package com.facebook.friendsharing.souvenirs.manager;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Environment;
import android.os.FileObserver;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.debug.log.BLog;
import com.facebook.feed.util.event.AppiraterEvents.FeedFragmentResumedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.FeedEventSubscriber;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.converters.StoryTellerToSouvenirConverter;
import com.facebook.friendsharing.souvenirs.mediaitems.SouvenirsMediaItemsHelper;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirModelsDataAccessLayer;
import com.facebook.friendsharing.souvenirs.persistence.SouvenirPromptsDataAccessLayer;
import com.facebook.friendsharing.souvenirs.util.SouvenirModelHelper;
import com.facebook.friendsharing.souvenirs.util.SouvenirValidModelsIterator;
import com.facebook.friendsharing.souvenirs.util.TestSouvenirCreator;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.storyteller.StoryTeller;
import com.facebook.storyteller.StoryTellerConfig;
import com.facebook.storyteller.models.StoryTellerItem;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.SettableFuture;
import java.io.Closeable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: malware_transaction_exception_event */
public class SouvenirManager {
    public static final String f10708a = SouvenirManager.class.getSimpleName();
    public static final Uri f10709b = Media.EXTERNAL_CONTENT_URI;
    private static volatile SouvenirManager f10710o;
    private final DefaultAndroidThreadUtil f10711c;
    private final QeAccessor f10712d;
    private final Lazy<TestSouvenirCreator> f10713e;
    private final Provider<StoryTeller> f10714f;
    public final AtomicBoolean f10715g = new AtomicBoolean();
    private final StoryTellerToSouvenirConverter f10716h;
    public final Map<String, SouvenirModel> f10717i = Collections.synchronizedMap(new HashMap());
    private final SouvenirModelsDataAccessLayer f10718j;
    public final ScheduledExecutorService f10719k;
    private final Lazy<FbErrorReporter> f10720l;
    public final Runnable f10721m;
    @Nullable
    public SettableFuture<ImmutableList<SouvenirModel>> f10722n = SettableFuture.f();

    /* compiled from: malware_transaction_exception_event */
    public class InitOnBoot implements INeedInit {
        private final QeAccessor f8370a;
        private final Context f8371b;
        private final Lazy<SouvenirManager> f8372c;
        private final Lazy<LocalPhotoContentObserver> f8373d;
        private final Lazy<SouvenirModelsDataAccessLayer> f8374e;
        private final Lazy<SouvenirPromptsDataAccessLayer> f8375f;
        private final Lazy<Clock> f8376g;
        private final DefaultAndroidThreadUtil f8377h;
        private final Lazy<LocalPhotoFileObserver> f8378i;
        private final Lazy<FeedEventBus> f8379j;
        private final Lazy<FeedFragmentResumedSubscriber> f8380k;
        private final Lazy<StoryTellerConfig> f8381l;
        private final Lazy<RuntimePermissionsUtil> f8382m;

        public static InitOnBoot m8656b(InjectorLike injectorLike) {
            return new InitOnBoot((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class, ForAppContext.class), IdBasedSingletonScopeProvider.b(injectorLike, 2088), IdBasedSingletonScopeProvider.b(injectorLike, 2086), IdBasedSingletonScopeProvider.b(injectorLike, 2091), IdBasedSingletonScopeProvider.b(injectorLike, 2092), IdBasedSingletonScopeProvider.b(injectorLike, 609), DefaultAndroidThreadUtil.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2087), IdBasedSingletonScopeProvider.b(injectorLike, 1756), IdBasedSingletonScopeProvider.b(injectorLike, 2084), IdBasedSingletonScopeProvider.b(injectorLike, 11042), IdBasedLazy.a(injectorLike, 3364));
        }

        @Inject
        public InitOnBoot(QeAccessor qeAccessor, @ForAppContext Context context, Lazy<SouvenirManager> lazy, Lazy<LocalPhotoContentObserver> lazy2, Lazy<SouvenirModelsDataAccessLayer> lazy3, Lazy<SouvenirPromptsDataAccessLayer> lazy4, Lazy<Clock> lazy5, AndroidThreadUtil androidThreadUtil, Lazy<LocalPhotoFileObserver> lazy6, Lazy<FeedEventBus> lazy7, Lazy<FeedFragmentResumedSubscriber> lazy8, Lazy<StoryTellerConfig> lazy9, Lazy<RuntimePermissionsUtil> lazy10) {
            this.f8370a = qeAccessor;
            this.f8371b = context;
            this.f8372c = lazy;
            this.f8373d = lazy2;
            this.f8374e = lazy3;
            this.f8375f = lazy4;
            this.f8376g = lazy5;
            this.f8377h = androidThreadUtil;
            this.f8378i = lazy6;
            this.f8379j = lazy7;
            this.f8380k = lazy8;
            this.f8381l = lazy9;
            this.f8382m = lazy10;
        }

        public void init() {
            this.f8377h.b();
            if (this.f8370a.a(ExperimentsForSouvenirAbtestModule.C, false) && ((RuntimePermissionsUtil) this.f8382m.get()).a("android.permission.READ_EXTERNAL_STORAGE")) {
                SouvenirModelsDataAccessLayer souvenirModelsDataAccessLayer = (SouvenirModelsDataAccessLayer) this.f8374e.get();
                SouvenirPromptsDataAccessLayer souvenirPromptsDataAccessLayer = (SouvenirPromptsDataAccessLayer) this.f8375f.get();
                if (souvenirModelsDataAccessLayer.m11171c() != 4) {
                    SouvenirManager.f10708a;
                    Integer.valueOf(souvenirModelsDataAccessLayer.m11171c());
                    Integer.valueOf(4);
                    souvenirPromptsDataAccessLayer.b();
                    souvenirModelsDataAccessLayer.m11170b();
                    souvenirModelsDataAccessLayer.m11169a(4);
                } else {
                    long a = ((Clock) this.f8376g.get()).a() - ((StoryTellerConfig) this.f8381l.get()).b();
                    int a2 = souvenirModelsDataAccessLayer.m11166a(a);
                    int a3 = souvenirPromptsDataAccessLayer.a(a);
                    SouvenirManager.f10708a;
                    Integer.valueOf(a2);
                    SouvenirManager.f10708a;
                    Integer.valueOf(a3);
                    try {
                        SouvenirManager.m11174a((SouvenirManager) this.f8372c.get(), souvenirModelsDataAccessLayer.m11167a());
                        SouvenirManager.f10708a;
                        Integer.valueOf(((SouvenirManager) this.f8372c.get()).f10717i.size());
                    } catch (Throwable th) {
                        BLog.b(SouvenirManager.f10708a, th, "Error Reading from DB. You may have to update the model version", new Object[0]);
                        souvenirModelsDataAccessLayer.m11170b();
                        souvenirPromptsDataAccessLayer.b();
                    }
                }
                FutureDetour.a(((SouvenirManager) this.f8372c.get()).f10722n, ((SouvenirManager) this.f8372c.get()).m11178a(), 1269503354);
                FeedFragmentResumedSubscriber feedFragmentResumedSubscriber = (FeedFragmentResumedSubscriber) this.f8380k.get();
                ((FeedEventBus) this.f8379j.get()).a(feedFragmentResumedSubscriber);
                this.f8371b.getContentResolver().registerContentObserver(SouvenirManager.f10709b, false, (ContentObserver) this.f8373d.get());
                ((LocalPhotoFileObserver) this.f8378i.get()).startWatching();
                FeedFragmentResumedSubscriber.m11464a(feedFragmentResumedSubscriber, true);
            }
        }
    }

    /* compiled from: malware_transaction_exception_event */
    class C05151 implements Runnable {
        final /* synthetic */ SouvenirManager f10992a;

        C05151(SouvenirManager souvenirManager) {
            this.f10992a = souvenirManager;
        }

        public void run() {
            this.f10992a.f10715g.set(false);
            this.f10992a.m11179c();
        }
    }

    @Singleton
    /* compiled from: malware_transaction_exception_event */
    public class FeedFragmentResumedSubscriber extends FeedEventSubscriber<FeedFragmentResumedEvent> {
        private static volatile FeedFragmentResumedSubscriber f10993c;
        public boolean f10994a;
        private final Lazy<SouvenirManager> f10995b;

        public static com.facebook.friendsharing.souvenirs.manager.SouvenirManager.FeedFragmentResumedSubscriber m11463a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f10993c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.friendsharing.souvenirs.manager.SouvenirManager.FeedFragmentResumedSubscriber.class;
            monitor-enter(r1);
            r0 = f10993c;	 Catch:{ all -> 0x003a }
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
            r0 = m11465b(r0);	 Catch:{ all -> 0x0035 }
            f10993c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f10993c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.manager.SouvenirManager.FeedFragmentResumedSubscriber.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.manager.SouvenirManager$FeedFragmentResumedSubscriber");
        }

        private static FeedFragmentResumedSubscriber m11465b(InjectorLike injectorLike) {
            return new FeedFragmentResumedSubscriber(IdBasedSingletonScopeProvider.b(injectorLike, 2088));
        }

        @Inject
        public FeedFragmentResumedSubscriber(Lazy<SouvenirManager> lazy) {
            this.f10995b = lazy;
        }

        public static void m11464a(FeedFragmentResumedSubscriber feedFragmentResumedSubscriber, boolean z) {
            feedFragmentResumedSubscriber.f10994a = z;
        }

        public final void m11467b(FbEvent fbEvent) {
            if (this.f10994a) {
                SouvenirManager souvenirManager = (SouvenirManager) this.f10995b.get();
                if (souvenirManager.f10715g.compareAndSet(false, true)) {
                    ExecutorDetour.a(souvenirManager.f10719k, souvenirManager.f10721m, 1545515079);
                }
                this.f10994a = false;
            }
        }

        public final Class<FeedFragmentResumedEvent> m11466a() {
            return FeedFragmentResumedEvent.class;
        }
    }

    @Singleton
    /* compiled from: malware_transaction_exception_event */
    public class LocalPhotoContentObserver extends ContentObserver {
        private static volatile LocalPhotoContentObserver f10996c;
        private final Lazy<FeedFragmentResumedSubscriber> f10997a;
        private final DefaultAndroidThreadUtil f10998b;

        public static com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoContentObserver m11468a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f10996c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoContentObserver.class;
            monitor-enter(r1);
            r0 = f10996c;	 Catch:{ all -> 0x003a }
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
            r0 = m11469b(r0);	 Catch:{ all -> 0x0035 }
            f10996c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f10996c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoContentObserver.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.manager.SouvenirManager$LocalPhotoContentObserver");
        }

        private static LocalPhotoContentObserver m11469b(InjectorLike injectorLike) {
            return new LocalPhotoContentObserver(Handler_ForNonUiThreadMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2084), DefaultAndroidThreadUtil.b(injectorLike));
        }

        @Inject
        public LocalPhotoContentObserver(Handler handler, Lazy<FeedFragmentResumedSubscriber> lazy, AndroidThreadUtil androidThreadUtil) {
            super(handler);
            this.f10997a = lazy;
            this.f10998b = androidThreadUtil;
        }

        public void onChange(boolean z) {
            this.f10998b.b();
            ((FeedFragmentResumedSubscriber) this.f10997a.get()).f10994a = true;
        }
    }

    @Singleton
    /* compiled from: malware_transaction_exception_event */
    public class LocalPhotoFileObserver extends FileObserver {
        private static volatile LocalPhotoFileObserver f10999c;
        private final Lazy<FeedFragmentResumedSubscriber> f11000a;
        private final DefaultAndroidThreadUtil f11001b;

        public static com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoFileObserver m11470a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f10999c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoFileObserver.class;
            monitor-enter(r1);
            r0 = f10999c;	 Catch:{ all -> 0x003a }
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
            r0 = m11471b(r0);	 Catch:{ all -> 0x0035 }
            f10999c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f10999c;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.manager.SouvenirManager.LocalPhotoFileObserver.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.manager.SouvenirManager$LocalPhotoFileObserver");
        }

        private static LocalPhotoFileObserver m11471b(InjectorLike injectorLike) {
            return new LocalPhotoFileObserver(IdBasedSingletonScopeProvider.b(injectorLike, 2084), DefaultAndroidThreadUtil.b(injectorLike));
        }

        @Inject
        public LocalPhotoFileObserver(Lazy<FeedFragmentResumedSubscriber> lazy, AndroidThreadUtil androidThreadUtil) {
            super(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getPath(), 256);
            this.f11000a = lazy;
            this.f11001b = androidThreadUtil;
        }

        public void onEvent(int i, String str) {
            this.f11001b.b();
            ((FeedFragmentResumedSubscriber) this.f11000a.get()).f10994a = true;
        }
    }

    public static com.facebook.friendsharing.souvenirs.manager.SouvenirManager m11172a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10710o;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsharing.souvenirs.manager.SouvenirManager.class;
        monitor-enter(r1);
        r0 = f10710o;	 Catch:{ all -> 0x003a }
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
        r0 = m11175b(r0);	 Catch:{ all -> 0x0035 }
        f10710o = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10710o;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsharing.souvenirs.manager.SouvenirManager.a(com.facebook.inject.InjectorLike):com.facebook.friendsharing.souvenirs.manager.SouvenirManager");
    }

    private static SouvenirManager m11175b(InjectorLike injectorLike) {
        return new SouvenirManager(DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 11041), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 6729), new StoryTellerToSouvenirConverter((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), SouvenirsMediaItemsHelper.m11437b(injectorLike)), SouvenirModelsDataAccessLayer.m11162a(injectorLike), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public SouvenirManager(AndroidThreadUtil androidThreadUtil, Provider<StoryTeller> provider, QeAccessor qeAccessor, Lazy<TestSouvenirCreator> lazy, StoryTellerToSouvenirConverter storyTellerToSouvenirConverter, SouvenirModelsDataAccessLayer souvenirModelsDataAccessLayer, ScheduledExecutorService scheduledExecutorService, Lazy<FbErrorReporter> lazy2) {
        this.f10711c = androidThreadUtil;
        this.f10714f = provider;
        this.f10712d = qeAccessor;
        this.f10713e = lazy;
        this.f10716h = storyTellerToSouvenirConverter;
        this.f10718j = souvenirModelsDataAccessLayer;
        this.f10719k = scheduledExecutorService;
        this.f10720l = lazy2;
        this.f10721m = new C05151(this);
    }

    public final ImmutableList<SouvenirModel> m11178a() {
        return m11173a(this.f10717i.values());
    }

    @VisibleForTesting
    private static ImmutableList<SouvenirModel> m11173a(Collection<SouvenirModel> collection) {
        SouvenirModel[] souvenirModelArr;
        SouvenirModel[] souvenirModelArr2 = (SouvenirModel[]) collection.toArray(new SouvenirModel[collection.size()]);
        if (souvenirModelArr2.length <= 0 || souvenirModelArr2[souvenirModelArr2.length - 1] != null) {
            souvenirModelArr = souvenirModelArr2;
        } else {
            int i = 0;
            while (i < souvenirModelArr2.length && souvenirModelArr2[i] != null) {
                i++;
            }
            souvenirModelArr = (SouvenirModel[]) Arrays.copyOf(souvenirModelArr2, i);
        }
        souvenirModelArr2 = souvenirModelArr;
        if (souvenirModelArr2.length <= 1) {
            return ImmutableList.copyOf(souvenirModelArr2);
        }
        Arrays.sort(souvenirModelArr2, new 2());
        return ImmutableList.copyOf(souvenirModelArr2);
    }

    public static void m11174a(SouvenirManager souvenirManager, ImmutableSet immutableSet) {
        Preconditions.checkState(souvenirManager.f10717i.isEmpty());
        if (!immutableSet.isEmpty()) {
            souvenirManager.f10717i.putAll(Maps.a(new SouvenirValidModelsIterator(immutableSet.iterator()), new 3(souvenirManager)));
        }
    }

    @VisibleForTesting
    final void m11179c() {
        this.f10711c.b();
        CloseableReference a = CloseableReference.a((Closeable) this.f10714f.get());
        try {
            SouvenirModel a2;
            Collection hashSet = new HashSet();
            for (StoryTellerItem a3 = ((StoryTeller) a.a()).a(); ((StoryTellerItem) Preconditions.checkNotNull(a3)).m11458c() != (byte) 0; a3 = ((StoryTeller) a.a()).a()) {
                a2 = this.f10716h.m11433a(a3);
                this.f10717i.put(a2.m11461a().a(), a2);
                hashSet.add(a2);
            }
            if (!hashSet.isEmpty()) {
                Integer.valueOf(hashSet.size());
                this.f10718j.m11168a(hashSet);
            }
            m11177g();
            if (this.f10712d.a(ExperimentsForSouvenirAbtestModule.r, false)) {
                a2 = ((TestSouvenirCreator) this.f10713e.get()).a();
                if (!this.f10717i.containsKey(a2.m11461a().a())) {
                    this.f10717i.put(a2.m11461a().a(), a2);
                }
            }
            this.f10722n = null;
        } catch (Throwable th) {
            ((AbstractFbErrorReporter) this.f10720l.get()).b(f10708a, "Error running Storyteller", th);
        } finally {
            a.close();
        }
    }

    private void m11177g() {
        this.f10711c.b();
        Iterator it = this.f10717i.values().iterator();
        while (it.hasNext()) {
            if (!SouvenirModelHelper.d((SouvenirModel) it.next())) {
                it.remove();
            }
        }
    }
}

package com.facebook.composer.publish.cache.pendingstory;

import android.os.Bundle;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.analytics.PhotoUploadProgressLogger;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.composer.publish.cache.db.ComposerPublishDbCacheServiceHandler;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PendingStory.Builder;
import com.facebook.composer.publish.common.PendingStoryPersistentData;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.Futures;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timing_curves */
public class PendingStoryStore implements IHaveUserData {
    private static final CallerContext f9448a = CallerContext.m9060a(PendingStoryStore.class);
    private static volatile PendingStoryStore f9449m;
    private final DefaultBlueServiceOperationFactory f9450b;
    private final Lazy<ComposerPublishDbCacheServiceHandler> f9451c;
    private final FbSharedPreferences f9452d;
    public final Lazy<ComposerAnalyticsLogger> f9453e;
    public final AbstractFbErrorReporter f9454f;
    private final Map<String, PendingStory> f9455g = Maps.m838c();
    private final Object f9456h = new Object();
    private final QeAccessor f9457i;
    private final OptimisticStoryStateCache f9458j;
    private final PhotoUploadProgressLogger f9459k;
    private final Clock f9460l;

    @Singleton
    /* compiled from: timing_curves */
    public class PendingStoryStoreInitializer implements INeedInit {
        private static volatile PendingStoryStoreInitializer f2655c;
        private final FbSharedPreferences f2656a;
        private final Lazy<PendingStoryStore> f2657b;

        public static com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.PendingStoryStoreInitializer m4719a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
            r0 = f2655c;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.PendingStoryStoreInitializer.class;
            monitor-enter(r1);
            r0 = f2655c;	 Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000b:
            if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
        L_0x000d:
            r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
            r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
            r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
            r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
            r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
            r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
            r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
            r0 = m4720b(r0);	 Catch:{ all -> 0x0035 }
            f2655c = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.m1338a(r4);
            r2.m1505c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f2655c;
            return r0;
        L_0x0035:
            r0 = move-exception;
            com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
            throw r0;	 Catch:{ all -> 0x0035 }
        L_0x003a:
            r0 = move-exception;
            r2.m1505c(r3);	 Catch:{ all -> 0x003a }
            throw r0;	 Catch:{ all -> 0x003a }
        L_0x003f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x003a }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.PendingStoryStoreInitializer.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.cache.pendingstory.PendingStoryStore$PendingStoryStoreInitializer");
        }

        private static PendingStoryStoreInitializer m4720b(InjectorLike injectorLike) {
            return new PendingStoryStoreInitializer(FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 862));
        }

        @Inject
        public PendingStoryStoreInitializer(FbSharedPreferences fbSharedPreferences, Lazy<PendingStoryStore> lazy) {
            this.f2656a = fbSharedPreferences;
            this.f2657b = lazy;
        }

        public void init() {
            if (this.f2656a.mo286a(ComposerPrefKeys.f2663f, true)) {
                PendingStoryStore.m14445b((PendingStoryStore) this.f2657b.get());
            }
        }
    }

    public static com.facebook.composer.publish.cache.pendingstory.PendingStoryStore m14442a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9449m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.class;
        monitor-enter(r1);
        r0 = f9449m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14444b(r0);	 Catch:{ all -> 0x0035 }
        f9449m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9449m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.cache.pendingstory.PendingStoryStore");
    }

    private static PendingStoryStore m14444b(InjectorLike injectorLike) {
        return new PendingStoryStore(DefaultBlueServiceOperationFactory.m3782b(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 859), FbSharedPreferencesImpl.m1826a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 5189), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), OptimisticStoryStateCache.m9726a(injectorLike), new PhotoUploadProgressLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike)), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    @Inject
    public PendingStoryStore(BlueServiceOperationFactory blueServiceOperationFactory, Lazy<ComposerPublishDbCacheServiceHandler> lazy, FbSharedPreferences fbSharedPreferences, Lazy<ComposerAnalyticsLogger> lazy2, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, OptimisticStoryStateCache optimisticStoryStateCache, PhotoUploadProgressLogger photoUploadProgressLogger, Clock clock) {
        this.f9450b = blueServiceOperationFactory;
        this.f9451c = lazy;
        this.f9452d = fbSharedPreferences;
        this.f9453e = lazy2;
        this.f9454f = fbErrorReporter;
        this.f9457i = qeAccessor;
        this.f9458j = optimisticStoryStateCache;
        this.f9459k = photoUploadProgressLogger;
        this.f9460l = clock;
    }

    public final void m14449a(PublishPostParams publishPostParams, GraphQLStory graphQLStory) {
        m14446b(new PostParamsWrapper(publishPostParams), graphQLStory);
    }

    public final void m14448a(PostParamsWrapper postParamsWrapper, GraphQLStory graphQLStory) {
        m14446b(postParamsWrapper, graphQLStory);
    }

    private void m14446b(PostParamsWrapper postParamsWrapper, GraphQLStory graphQLStory) {
        Object obj;
        PendingStory a;
        synchronized (this.f9456h) {
            Builder a2;
            if (graphQLStory == null) {
                if (this.f9455g.containsKey(postParamsWrapper.a())) {
                    PendingStory pendingStory = (PendingStory) this.f9455g.get(postParamsWrapper.a());
                    a2 = Builder.a(pendingStory).a(new PendingStoryPersistentData(pendingStory.a(), postParamsWrapper));
                    obj = 1;
                    a = a2.a();
                    this.f9455g.put(postParamsWrapper.a(), a);
                    this.f9459k.m14454a(this.f9455g.size());
                    if (this.f9455g.size() > 500) {
                        this.f9454f.m2340a("pending_story_too_many_stories", "reached " + this.f9455g.size() + " stories");
                    }
                }
            }
            a2 = new Builder(new PendingStoryPersistentData(GraphQLStory.Builder.a(graphQLStory).a(), postParamsWrapper));
            obj = null;
            a = a2.a();
            this.f9455g.put(postParamsWrapper.a(), a);
            this.f9459k.m14454a(this.f9455g.size());
            if (this.f9455g.size() > 500) {
                this.f9454f.m2340a("pending_story_too_many_stories", "reached " + this.f9455g.size() + " stories");
            }
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("pending_story_param_key", a.c());
        Futures.m2457a(BlueServiceOperationFactoryDetour.a(this.f9450b, "save_pending_story", bundle, ErrorPropagation.BY_EXCEPTION, f9448a, 1837898325).mo3452a(), new 1(this, obj != null ? Events.COMPOSER_UPDATED_STORY_IN_DB : Events.COMPOSER_SAVED_STORY_TO_DB, a.b().a()));
    }

    public final void m14450a(String str) {
        PendingStory pendingStory;
        synchronized (this.f9456h) {
            pendingStory = (PendingStory) this.f9455g.get(str);
            this.f9455g.remove(str);
        }
        m14443a(str, pendingStory != null ? pendingStory.b().a() : null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m14451b(java.lang.String r6) {
        /*
        r5 = this;
        r1 = r5.f9456h;
        monitor-enter(r1);
        r0 = r5.f9455g;	 Catch:{ all -> 0x0040 }
        r0 = r0.containsKey(r6);	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r5.f9455g;	 Catch:{ all -> 0x0040 }
        r0 = r0.get(r6);	 Catch:{ all -> 0x0040 }
        r0 = (com.facebook.composer.publish.common.PendingStory) r0;	 Catch:{ all -> 0x0040 }
        r2 = r5.f9458j;	 Catch:{ all -> 0x0040 }
        r3 = r0.a();	 Catch:{ all -> 0x0040 }
        r4 = com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState.SUCCESS;	 Catch:{ all -> 0x0040 }
        r2.m9729a(r3, r4);	 Catch:{ all -> 0x0040 }
        monitor-exit(r1);	 Catch:{ all -> 0x0040 }
        r0 = r0.a();
        r1 = com.facebook.graphql.model.StoryAttachmentHelper.m28038k(r0);
        if (r1 != 0) goto L_0x0031;
    L_0x002b:
        r0 = com.facebook.graphql.model.StoryAttachmentHelper.m28041n(r0);
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r0 = 1;
    L_0x0032:
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r0 = r5.f9457i;
        r0 = com.facebook.photos.upload.serverprocessing.util.VideoProcessingUtil.a(r0);
        if (r0 != 0) goto L_0x000c;
    L_0x003c:
        r5.m14450a(r6);
        goto L_0x000c;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{  }
        throw r0;
    L_0x0043:
        r0 = 0;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.cache.pendingstory.PendingStoryStore.b(java.lang.String):void");
    }

    public final void m14452c(String str) {
        synchronized (this.f9456h) {
            if (this.f9455g.containsKey(str)) {
                this.f9458j.m9729a(((PendingStory) this.f9455g.get(str)).a(), GraphQLFeedOptimisticPublishState.POSTING);
                return;
            }
        }
    }

    private void m14443a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("request_id_param_key", str);
        Futures.m2457a(BlueServiceOperationFactoryDetour.a(this.f9450b, "delete_pending_story", bundle, ErrorPropagation.BY_EXCEPTION, f9448a, -1066947744).mo3452a(), new 2(this, str2));
    }

    public final ImmutableList<PendingStory> m14447a() {
        ImmutableList<PendingStory> b;
        ImmutableList.Builder builder = ImmutableList.builder();
        synchronized (this.f9456h) {
            for (PendingStory pendingStory : this.f9455g.values()) {
                builder.m1069c(Builder.a(pendingStory).a(new PendingStoryPersistentData(GraphQLStory.Builder.a(pendingStory.a()).a(), new PostParamsWrapper(pendingStory.b()))).a());
            }
            b = builder.m1068b();
        }
        return b;
    }

    public final Optional<PendingStory> m14453d(String str) {
        Optional<PendingStory> withType;
        synchronized (this.f9456h) {
            PendingStory pendingStory = (PendingStory) this.f9455g.get(str);
            if (pendingStory == null) {
                withType = Absent.withType();
            } else {
                withType = Optional.of(Builder.a(pendingStory).a(new PendingStoryPersistentData(GraphQLStory.Builder.a(pendingStory.a()).a(), new PostParamsWrapper(pendingStory.b()))).a());
            }
        }
        return withType;
    }

    public static void m14445b(PendingStoryStore pendingStoryStore) {
        int i = 0;
        ImmutableList a = ((ComposerPublishDbCacheServiceHandler) pendingStoryStore.f9451c.get()).a();
        if (a.isEmpty()) {
            pendingStoryStore.f9452d.edit().putBoolean(ComposerPrefKeys.f2663f, false).commit();
            return;
        }
        synchronized (pendingStoryStore.f9456h) {
            pendingStoryStore.f9455g.clear();
            int size = a.size();
            while (i < size) {
                PendingStoryPersistentData pendingStoryPersistentData = (PendingStoryPersistentData) a.get(i);
                if (pendingStoryPersistentData.b.a() == null) {
                    pendingStoryStore.f9454f.m2350b("pending_story_has_null_id", "story ID is null");
                } else {
                    pendingStoryStore.f9458j.m9729a(pendingStoryPersistentData.a, GraphQLFeedOptimisticPublishState.FAILED);
                    pendingStoryStore.f9455g.put(pendingStoryPersistentData.b.a(), new Builder(pendingStoryPersistentData).a());
                }
                i++;
            }
        }
    }

    public void clearUserData() {
        synchronized (this.f9456h) {
            this.f9455g.clear();
        }
    }
}

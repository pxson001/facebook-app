package com.facebook.composer.publish.compost.store;

import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.compost.publish.cache.draftstory.CompostDraftDbSchemaPart.DraftStoryTable.Columns;
import com.facebook.compost.publish.cache.draftstory.DbCompostDraftStoryHandler;
import com.facebook.database.sqlite.SqlExpression.Expression;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: photos_by_category */
public class CompostDraftStoryStore extends CompostStoryStore<CompostDraftStory> {
    private static final String f8043d = CompostDraftStoryStore.class.getSimpleName();
    private static volatile CompostDraftStoryStore f8044j;
    public final DbCompostDraftStoryHandler f8045e;
    private final ListeningExecutorService f8046f;
    public final CompostAnalyticsLogger f8047g;
    private CompostDraftFetchingState f8048h = CompostDraftFetchingState.INIT;
    private Optional<ListenableFuture<Boolean>> f8049i = Absent.INSTANCE;

    /* compiled from: photos_by_category */
    class C04831 implements Callable<Boolean> {
        final /* synthetic */ CompostDraftStoryStore f8031a;

        C04831(CompostDraftStoryStore compostDraftStoryStore) {
            this.f8031a = compostDraftStoryStore;
        }

        public Object call() {
            ImmutableList<CompostDraftStory> e = CompostDraftStoryStore.m11599e(this.f8031a);
            Collection arrayList = new ArrayList();
            synchronized (this.f8031a.f8040b) {
                for (CompostDraftStory compostDraftStory : e) {
                    if (this.f8031a.m11593d(compostDraftStory.mo934f()) == -1) {
                        arrayList.add(compostDraftStory);
                    }
                }
                this.f8031a.f8041c.addAll(arrayList);
                this.f8031a.f8049i = Absent.withType();
                this.f8031a.f8048h = CompostDraftFetchingState.FETCHED;
            }
            super.mo926a();
            return Boolean.valueOf(true);
        }
    }

    /* compiled from: photos_by_category */
    class C04842 implements FutureCallback<Boolean> {
        final /* synthetic */ CompostDraftStoryStore f8032a;

        C04842(CompostDraftStoryStore compostDraftStoryStore) {
            this.f8032a = compostDraftStoryStore;
        }

        public void onSuccess(@Nullable Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null || !bool.booleanValue()) {
                synchronized (this.f8032a.f8040b) {
                    this.f8032a.f8049i = Absent.withType();
                    this.f8032a.f8048h = CompostDraftFetchingState.INIT;
                }
            }
        }

        public void onFailure(Throwable th) {
            synchronized (this.f8032a.f8040b) {
                this.f8032a.f8049i = Absent.withType();
                this.f8032a.f8048h = CompostDraftFetchingState.INIT;
            }
        }
    }

    /* compiled from: photos_by_category */
    class C04875 implements Runnable {
        final /* synthetic */ CompostDraftStoryStore f8037a;

        C04875(CompostDraftStoryStore compostDraftStoryStore) {
            this.f8037a = compostDraftStoryStore;
        }

        public void run() {
            DbCompostDraftStoryHandler dbCompostDraftStoryHandler = this.f8037a.f8045e;
            Expression b = Columns.f8110b.b(String.valueOf(CompostDraftStoryStore.m11602g(this.f8037a)));
            this.f8037a.f8047g.m21247a(dbCompostDraftStoryHandler.f8114a.a().delete("draft_story", b.a(), b.b()));
        }
    }

    /* compiled from: photos_by_category */
    class C04886 implements AsyncFunction<Boolean, ImmutableList<CompostDraftStory>> {
        final /* synthetic */ CompostDraftStoryStore f8038a;

        C04886(CompostDraftStoryStore compostDraftStoryStore) {
            this.f8038a = compostDraftStoryStore;
        }

        public final ListenableFuture m11585a(@Nullable Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null || !bool.booleanValue()) {
                return Futures.a(RegularImmutableList.a);
            }
            return super.mo926a();
        }
    }

    /* compiled from: photos_by_category */
    enum CompostDraftFetchingState {
        INIT,
        FETCHING,
        FETCHED
    }

    public static com.facebook.composer.publish.compost.store.CompostDraftStoryStore m11595a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8044j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.publish.compost.store.CompostDraftStoryStore.class;
        monitor-enter(r1);
        r0 = f8044j;	 Catch:{ all -> 0x003a }
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
        r0 = m11597b(r0);	 Catch:{ all -> 0x0035 }
        f8044j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8044j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.publish.compost.store.CompostDraftStoryStore.a(com.facebook.inject.InjectorLike):com.facebook.composer.publish.compost.store.CompostDraftStoryStore");
    }

    private static CompostDraftStoryStore m11597b(InjectorLike injectorLike) {
        return new CompostDraftStoryStore((Clock) SystemClockMethodAutoProvider.a(injectorLike), DbCompostDraftStoryHandler.m11672a(injectorLike), ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), CompostAnalyticsLogger.m21244b(injectorLike));
    }

    @Inject
    public CompostDraftStoryStore(Clock clock, DbCompostDraftStoryHandler dbCompostDraftStoryHandler, ListeningExecutorService listeningExecutorService, CompostAnalyticsLogger compostAnalyticsLogger) {
        super(clock);
        this.f8045e = dbCompostDraftStoryHandler;
        this.f8046f = listeningExecutorService;
        this.f8047g = compostAnalyticsLogger;
    }

    private void m11598d() {
        this.f8048h = CompostDraftFetchingState.FETCHING;
        this.f8049i = Optional.of(this.f8046f.a(new C04831(this)));
        Futures.a((ListenableFuture) this.f8049i.get(), new C04842(this), this.f8046f);
    }

    public static ImmutableList m11599e(CompostDraftStoryStore compostDraftStoryStore) {
        ImmutableList of = ImmutableList.of();
        try {
            of = compostDraftStoryStore.f8045e.m11676a(m11602g(compostDraftStoryStore));
        } catch (Throwable th) {
            BLog.b(f8043d, th, "Error Reading from DB.", new Object[0]);
            compostDraftStoryStore.f8045e.m11675a();
        }
        return of;
    }

    public final ListenableFuture<Boolean> m11604a(final CompostDraftStory compostDraftStory) {
        super.mo927a((CompostStory) compostDraftStory);
        return this.f8046f.a(new Callable<Boolean>(this) {
            final /* synthetic */ CompostDraftStoryStore f8034b;

            public Object call() {
                CompostDraftStoryStore compostDraftStoryStore = this.f8034b;
                compostDraftStoryStore.f8045e.m11677a(compostDraftStory);
                return Boolean.valueOf(true);
            }
        });
    }

    public final ListenableFuture<Boolean> mo928a(final String str) {
        super.mo928a(str);
        return this.f8046f.a(new Callable<Boolean>(this) {
            final /* synthetic */ CompostDraftStoryStore f8036b;

            public Object call() {
                CompostDraftStoryStore compostDraftStoryStore = this.f8036b;
                String str = str;
                DbCompostDraftStoryHandler dbCompostDraftStoryHandler = compostDraftStoryStore.f8045e;
                Preconditions.checkArgument(!Strings.isNullOrEmpty(str));
                Expression a = Columns.f8109a.a(str);
                dbCompostDraftStoryHandler.f8114a.a().delete("draft_story", a.a(), a.b());
                return Boolean.valueOf(true);
            }
        });
    }

    public static void m11601f(CompostDraftStoryStore compostDraftStoryStore) {
        ExecutorDetour.a(compostDraftStoryStore.f8046f, new C04875(compostDraftStoryStore), 765261920);
    }

    public final ListenableFuture<ImmutableList<CompostDraftStory>> mo926a() {
        ListenableFuture<ImmutableList<CompostDraftStory>> listenableFuture = null;
        synchronized (this.f8040b) {
            if (this.f8048h == CompostDraftFetchingState.INIT) {
                m11598d();
            }
            if (this.f8049i.isPresent()) {
                listenableFuture = Futures.b((ListenableFuture) this.f8049i.get(), new C04886(this));
            }
        }
        return listenableFuture != null ? listenableFuture : super.mo926a();
    }

    public final long mo929b() {
        return 259200;
    }

    public static long m11602g(CompostDraftStoryStore compostDraftStoryStore) {
        return (compostDraftStoryStore.f8039a.a() / 1000) - compostDraftStoryStore.mo929b();
    }
}

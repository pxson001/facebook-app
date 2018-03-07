package com.facebook.backstage.consumption.reply;

import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.backstage.consumption.reply.BackstageReplyThreadViewController.LocalObserver;
import com.facebook.backstage.data.BackstageProfile.Reply;
import com.facebook.backstage.data.DataObserverMap;
import com.facebook.backstage.data.ReplyThread;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.graphql.BackstageReplyGraphQLHelper;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: scoped_continuous_upload_status */
public class ReplyDataProvider {
    private static final String f4954b = ReplyDataProvider.class.getSimpleName();
    private static volatile ReplyDataProvider f4955j;
    C05201 f4956a = new C05201(this);
    private final BackstageReplyGraphQLHelper f4957c;
    public final OptimisticReplyStore f4958d = new OptimisticReplyStore();
    public final DataObserverMap<ReplyThreadSummaryListObserver> f4959e = new DataObserverMap();
    public final DataObserverMap<ReplyThreadObserver> f4960f = new DataObserverMap();
    public final ExecutorService f4961g;
    public final FbSharedPreferences f4962h;
    public final Clock f4963i;

    /* compiled from: scoped_continuous_upload_status */
    public interface ReplyThreadSummaryListObserver {
        void mo154a(ImmutableList<ReplyThreadSummary> immutableList);
    }

    /* compiled from: scoped_continuous_upload_status */
    public class C05201 {
        public final /* synthetic */ ReplyDataProvider f4952a;

        /* compiled from: scoped_continuous_upload_status */
        public class C05181 implements Runnable {
            final /* synthetic */ List f4946a;
            final /* synthetic */ ImmutableList f4947b;
            final /* synthetic */ C05201 f4948c;

            public C05181(C05201 c05201, List list, ImmutableList immutableList) {
                this.f4948c = c05201;
                this.f4946a = list;
                this.f4947b = immutableList;
            }

            public void run() {
                for (WeakReference weakReference : this.f4946a) {
                    ReplyThreadSummaryListObserver replyThreadSummaryListObserver = (ReplyThreadSummaryListObserver) weakReference.get();
                    if (replyThreadSummaryListObserver != null) {
                        replyThreadSummaryListObserver.mo154a(this.f4947b);
                    }
                }
            }
        }

        C05201(ReplyDataProvider replyDataProvider) {
            this.f4952a = replyDataProvider;
        }

        public final void m4800a(ReplyThread replyThread) {
            ReplyDataProvider replyDataProvider = this.f4952a;
            ImmutableList immutableList = replyThread.f5138b;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Reply reply = (Reply) immutableList.get(i);
                if (replyDataProvider.f4958d.m4795a(reply.f5108b)) {
                    replyDataProvider.f4958d.m4796b(reply.f5108b);
                }
            }
            ImmutableList c = replyDataProvider.f4958d.m4797c(replyThread.f5137a);
            Iterable arrayList = new ArrayList(replyThread.f5138b.size() + c.size());
            arrayList.addAll(replyThread.f5138b);
            arrayList.addAll(c);
            Collections.sort(arrayList, new C05212(replyDataProvider));
            final ReplyThread replyThread2 = new ReplyThread(replyThread.f5137a, new Builder().b(arrayList).b());
            final List a = this.f4952a.f4960f.m4901a();
            ExecutorDetour.a(this.f4952a.f4961g, new Runnable(this) {
                final /* synthetic */ C05201 f4951c;

                public void run() {
                    for (WeakReference weakReference : a) {
                        LocalObserver localObserver = (LocalObserver) weakReference.get();
                        if (localObserver != null && localObserver.f4921b.equals(replyThread2.f5137a)) {
                            localObserver.m4774a(replyThread2);
                        }
                    }
                }
            }, 1863162920);
        }
    }

    /* compiled from: scoped_continuous_upload_status */
    public class C05212 implements Comparator<Reply> {
        final /* synthetic */ ReplyDataProvider f4953a;

        public C05212(ReplyDataProvider replyDataProvider) {
            this.f4953a = replyDataProvider;
        }

        public int compare(Object obj, Object obj2) {
            long time = ((Reply) obj).f4821e.getTime() - ((Reply) obj2).f4821e.getTime();
            if (time < 0) {
                return -1;
            }
            if (time > 0) {
                return 1;
            }
            return 0;
        }
    }

    public static com.facebook.backstage.consumption.reply.ReplyDataProvider m4801a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4955j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.consumption.reply.ReplyDataProvider.class;
        monitor-enter(r1);
        r0 = f4955j;	 Catch:{ all -> 0x003a }
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
        r0 = m4803b(r0);	 Catch:{ all -> 0x0035 }
        f4955j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4955j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.consumption.reply.ReplyDataProvider.a(com.facebook.inject.InjectorLike):com.facebook.backstage.consumption.reply.ReplyDataProvider");
    }

    private static ReplyDataProvider m4803b(InjectorLike injectorLike) {
        return new ReplyDataProvider(new BackstageReplyGraphQLHelper(IdBasedProvider.a(injectorLike, 4442), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), Locales.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), BackstageGatekeepers.m4256b(injectorLike)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ReplyDataProvider(BackstageReplyGraphQLHelper backstageReplyGraphQLHelper, ExecutorService executorService, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f4957c = backstageReplyGraphQLHelper;
        this.f4961g = executorService;
        this.f4962h = fbSharedPreferences;
        this.f4963i = clock;
    }

    public final void m4804a(ReplyThreadSummaryListObserver replyThreadSummaryListObserver) {
        this.f4959e.m4902a(replyThreadSummaryListObserver);
    }

    public final void m4807b(ReplyThreadSummaryListObserver replyThreadSummaryListObserver) {
        this.f4959e.m4903b(replyThreadSummaryListObserver);
    }

    public final void m4806a(boolean z, String str) {
        this.f4957c.m4988a(this.f4956a, z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a, str);
    }

    public final void m4805a(boolean z) {
        this.f4957c.m4987a(this.f4956a, z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a);
    }

    public static ImmutableList m4802a(ReplyDataProvider replyDataProvider, ImmutableList immutableList) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ReplyThreadSummary replyThreadSummary = (ReplyThreadSummary) immutableList.get(i);
            ReplyThreadSummary d = replyDataProvider.f4958d.m4798d(replyThreadSummary.f5139a);
            if (d == null || replyThreadSummary.f5143e.after(d.f5143e)) {
                builder.c(replyThreadSummary);
                if (d != null) {
                    replyDataProvider.f4958d.m4799e(replyThreadSummary.f5139a);
                }
            } else {
                builder.c(new ReplyThreadSummary(replyThreadSummary.f5139a, replyThreadSummary.f5142d, d.f5140b, d.f5143e, replyThreadSummary.f5141c, replyThreadSummary.f5144f));
            }
        }
        return builder.b();
    }
}

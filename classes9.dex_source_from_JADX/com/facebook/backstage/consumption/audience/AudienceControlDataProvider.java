package com.facebook.backstage.consumption.audience;

import com.facebook.backstage.data.AudienceControlData;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.graphql.AudienceControlMutationHelper;
import com.facebook.backstage.graphql.AudienceGraphqlHelper;
import com.facebook.backstage.graphql.AudienceGraphqlHelper.C05551;
import com.facebook.backstage.graphql.FBBackstageQuery.FBBackstageAllFriendsQueryString;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rtc_send_no_silence */
public class AudienceControlDataProvider {
    private static volatile AudienceControlDataProvider f4660d;
    private final AudienceGraphqlHelper f4661a;
    public final AudienceControlMutationHelper f4662b;
    public Set<String> f4663c = new HashSet();

    /* compiled from: rtc_send_no_silence */
    public interface CallBack {
        void mo155a();

        void mo156a(ImmutableList<AudienceControlData> immutableList, Set<String> set);
    }

    /* compiled from: rtc_send_no_silence */
    public class C04642 implements com.facebook.backstage.graphql.AudienceControlMutationHelper.CallBack {
        final /* synthetic */ CallBack f4658a;
        final /* synthetic */ AudienceControlDataProvider f4659b;

        public C04642(AudienceControlDataProvider audienceControlDataProvider, CallBack callBack) {
            this.f4659b = audienceControlDataProvider;
            this.f4658a = callBack;
        }

        public final void mo152a() {
            this.f4659b.m4571a(null, true);
            if (this.f4658a != null) {
                this.f4658a.mo155a();
            }
        }
    }

    public static com.facebook.backstage.consumption.audience.AudienceControlDataProvider m4568a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4660d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.consumption.audience.AudienceControlDataProvider.class;
        monitor-enter(r1);
        r0 = f4660d;	 Catch:{ all -> 0x003a }
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
        r0 = m4569b(r0);	 Catch:{ all -> 0x0035 }
        f4660d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4660d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.consumption.audience.AudienceControlDataProvider.a(com.facebook.inject.InjectorLike):com.facebook.backstage.consumption.audience.AudienceControlDataProvider");
    }

    private static AudienceControlDataProvider m4569b(InjectorLike injectorLike) {
        return new AudienceControlDataProvider(new AudienceGraphqlHelper(GraphQLQueryExecutor.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike)), AudienceControlMutationHelper.m4962b(injectorLike));
    }

    @Inject
    public AudienceControlDataProvider(AudienceGraphqlHelper audienceGraphqlHelper, AudienceControlMutationHelper audienceControlMutationHelper) {
        this.f4661a = audienceGraphqlHelper;
        this.f4662b = audienceControlMutationHelper;
    }

    public final void m4571a(final CallBack callBack, boolean z) {
        AudienceGraphqlHelper audienceGraphqlHelper = this.f4661a;
        C04631 c04631 = new Object(this) {
            public final /* synthetic */ AudienceControlDataProvider f4657b;
        };
        GraphQlQueryString fBBackstageAllFriendsQueryString = new FBBackstageAllFriendsQueryString();
        fBBackstageAllFriendsQueryString.a("2", "4");
        fBBackstageAllFriendsQueryString.a("0", "communication");
        Futures.a(audienceGraphqlHelper.f5198b.a(GraphQLRequest.a(fBBackstageAllFriendsQueryString).a(z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a)), new C05551(audienceGraphqlHelper, z, c04631), audienceGraphqlHelper.f5200d);
    }

    public final Builder<BackstageProfile> m4570a(Builder<BackstageProfile> builder) {
        Builder<BackstageProfile> builder2 = ImmutableList.builder();
        if (this.f4663c.isEmpty()) {
            return builder2;
        }
        ImmutableList b = builder.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            BackstageProfile backstageProfile = (BackstageProfile) b.get(i);
            if (this.f4663c.contains(backstageProfile.f5112a)) {
                builder2.c(backstageProfile);
            }
        }
        return builder2;
    }
}

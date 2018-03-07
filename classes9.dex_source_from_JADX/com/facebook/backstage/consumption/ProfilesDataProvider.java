package com.facebook.backstage.consumption;

import android.support.annotation.Nullable;
import com.facebook.backstage.consumption.audience.AudienceControlDataProvider;
import com.facebook.backstage.consumption.audience.AudienceControlDataProvider.CallBack;
import com.facebook.backstage.data.AudienceControlData;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.data.DataObserverMap;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.data.MediaItem;
import com.facebook.backstage.data.OptimisticMediaItemStoreHelper;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.graphql.BackstageProfilesGraphQLHelper;
import com.facebook.backstage.graphql.BackstageProfilesGraphQLHelper.C05591;
import com.facebook.backstage.graphql.FBBackstageQuery.FBBackstagePostsString;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: scrollTo */
public class ProfilesDataProvider {
    private static volatile ProfilesDataProvider f4624j;
    private final C04541 f4625a = new C04541(this);
    public final UploadingProfileOptimisticStore f4626b = new UploadingProfileOptimisticStore(this.f4625a);
    public final HaveRepliedOptimisticStore f4627c = new HaveRepliedOptimisticStore();
    public final AudienceControlOptimisticStore f4628d = new AudienceControlOptimisticStore();
    public final BackstageProfilesDataController f4629e = new BackstageProfilesDataController(this);
    public final BackstageProfilesGraphQLHelper f4630f;
    public final ExecutorService f4631g;
    public final DataObserverMap<BackstageProfileObserver> f4632h = new DataObserverMap();
    public final AudienceControlDataProvider f4633i;

    /* compiled from: scrollTo */
    public interface BackstageProfileObserver {
        void mo151a(ImmutableList<BackstageProfile> immutableList, ImmutableList<BackstageProfile> immutableList2);
    }

    /* compiled from: scrollTo */
    public class C04541 {
        final /* synthetic */ ProfilesDataProvider f4613a;

        C04541(ProfilesDataProvider profilesDataProvider) {
            this.f4613a = profilesDataProvider;
        }

        public final void m4534a() {
            this.f4613a.m4545a(false);
        }
    }

    /* compiled from: scrollTo */
    public class BackstageProfilesDataController {
        final /* synthetic */ ProfilesDataProvider f4622a;
        public final C04581 f4623b = new C04581(this);

        /* compiled from: scrollTo */
        public class C04581 {
            final /* synthetic */ BackstageProfilesDataController f4621a;

            /* compiled from: scrollTo */
            class C04561 implements Comparator<BackstageStory> {
                final /* synthetic */ C04581 f4616a;

                C04561(C04581 c04581) {
                    this.f4616a = c04581;
                }

                public int compare(Object obj, Object obj2) {
                    return (int) (((BackstageStory) obj).f4821e.getTime() - ((BackstageStory) obj2).f4821e.getTime());
                }
            }

            C04581(BackstageProfilesDataController backstageProfilesDataController) {
                this.f4621a = backstageProfilesDataController;
            }

            public final void m4539a(BackstageProfile backstageProfile, Builder<BackstageProfile> builder, Builder<BackstageProfile> builder2) {
                Builder a = this.f4621a.f4622a.f4633i.m4570a((Builder) builder);
                Builder a2 = this.f4621a.f4622a.f4633i.m4570a((Builder) builder2);
                Builder a3 = this.f4621a.f4622a.f4628d.m4453a(a);
                a2 = this.f4621a.f4622a.f4628d.m4453a(a2);
                this.f4621a.f4622a.f4627c.m4532a(a3);
                Iterable a4 = this.f4621a.f4622a.f4626b.m4566a(backstageProfile);
                Collections.sort(a4, new C04561(this));
                BackstageProfile backstageProfile2 = new BackstageProfile(backstageProfile, backstageProfile.f5118g, a4.size() != 0, new Builder().b(a4).b());
                a = new Builder();
                a.c(backstageProfile2);
                a.b(a3.b());
                final List a5 = this.f4621a.f4622a.f4632h.m4901a();
                ExecutorDetour.a(this.f4621a.f4622a.f4631g, new Runnable(this) {
                    final /* synthetic */ C04581 f4620d;

                    public void run() {
                        for (WeakReference weakReference : a5) {
                            BackstageProfileObserver backstageProfileObserver = (BackstageProfileObserver) weakReference.get();
                            if (backstageProfileObserver != null) {
                                backstageProfileObserver.mo151a(a.b(), a2.b());
                            }
                        }
                    }
                }, -1472998023);
            }
        }

        public BackstageProfilesDataController(ProfilesDataProvider profilesDataProvider) {
            this.f4622a = profilesDataProvider;
        }
    }

    public static com.facebook.backstage.consumption.ProfilesDataProvider m4540a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4624j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.consumption.ProfilesDataProvider.class;
        monitor-enter(r1);
        r0 = f4624j;	 Catch:{ all -> 0x003a }
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
        r0 = m4541b(r0);	 Catch:{ all -> 0x0035 }
        f4624j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4624j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.consumption.ProfilesDataProvider.a(com.facebook.inject.InjectorLike):com.facebook.backstage.consumption.ProfilesDataProvider");
    }

    private static ProfilesDataProvider m4541b(InjectorLike injectorLike) {
        return new ProfilesDataProvider(new BackstageProfilesGraphQLHelper(IdBasedProvider.a(injectorLike, 4442), (Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike)), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), AudienceControlDataProvider.m4568a(injectorLike));
    }

    @Inject
    public ProfilesDataProvider(BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper, ExecutorService executorService, AudienceControlDataProvider audienceControlDataProvider) {
        this.f4630f = backstageProfilesGraphQLHelper;
        this.f4631g = executorService;
        this.f4633i = audienceControlDataProvider;
    }

    public final void m4543a(UploadShot uploadShot) {
        String str;
        UploadingProfileOptimisticStore uploadingProfileOptimisticStore = this.f4626b;
        OptimisticMediaItemStoreHelper optimisticMediaItemStoreHelper = uploadingProfileOptimisticStore.f4654a;
        String str2 = "";
        String str3 = uploadShot.f5148d;
        String str4 = uploadShot.f5153i;
        if (uploadShot.f5145a == MediaType.PHOTO) {
            str = "";
        } else {
            str = uploadShot.f5148d;
        }
        optimisticMediaItemStoreHelper.m4915a(uploadShot, (MediaItem) new BackstageStory(str2, str3, str4, str, uploadShot.f5151g, false, RegularImmutableList.a));
        uploadingProfileOptimisticStore.f4655b.m4534a();
    }

    public final void m4544a(String str, String str2, @Nullable SeenByUser seenByUser) {
        HaveRepliedOptimisticStore haveRepliedOptimisticStore = this.f4627c;
        haveRepliedOptimisticStore.f4601a.add(str);
        haveRepliedOptimisticStore.f4602b.add(str2);
        if (seenByUser != null) {
            haveRepliedOptimisticStore.f4603c.put(str2, seenByUser);
        }
    }

    public final void m4542a(BackstageProfileObserver backstageProfileObserver) {
        this.f4632h.m4902a(backstageProfileObserver);
    }

    public final void m4546b(BackstageProfileObserver backstageProfileObserver) {
        this.f4632h.m4903b(backstageProfileObserver);
    }

    public final void m4545a(final boolean z) {
        this.f4633i.m4571a(new CallBack(this) {
            final /* synthetic */ ProfilesDataProvider f4615b;

            public final void mo156a(ImmutableList<AudienceControlData> immutableList, Set<String> set) {
                GraphQLCachePolicy graphQLCachePolicy;
                BackstageProfilesGraphQLHelper backstageProfilesGraphQLHelper = this.f4615b.f4630f;
                C04581 c04581 = this.f4615b.f4629e.f4623b;
                if (z) {
                    graphQLCachePolicy = GraphQLCachePolicy.d;
                } else {
                    graphQLCachePolicy = GraphQLCachePolicy.a;
                }
                GraphQlQueryString fBBackstagePostsString = new FBBackstagePostsString();
                fBBackstagePostsString.a("6", "4");
                Futures.a(backstageProfilesGraphQLHelper.f5225c.a(GraphQLRequest.a(fBBackstagePostsString).a(graphQLCachePolicy).a(7200)), new C05591(backstageProfilesGraphQLHelper, c04581), backstageProfilesGraphQLHelper.f5224b);
            }

            public final void mo155a() {
            }
        }, z);
    }
}

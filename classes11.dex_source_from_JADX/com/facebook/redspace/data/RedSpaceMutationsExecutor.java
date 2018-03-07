package com.facebook.redspace.data;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.RedspaceUserDemoteInputData;
import com.facebook.graphql.calls.RedspaceUserPromoteInputData;
import com.facebook.graphql.calls.RedspaceUserViewInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.request.MutationRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragments.RedSpaceFriendDemoteMutationString;
import com.facebook.redspace.protocol.RedSpaceMutationFragments.RedSpaceFriendPromoteMutationString;
import com.facebook.redspace.protocol.RedSpaceMutationFragments.RedSpaceFriendViewMutationString;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceFriendPromoteMutationModel;
import com.facebook.redspace.protocol.RedSpaceMutationFragmentsModels.RedSpaceFriendViewMutationModel;
import com.facebook.redspace.subscription.SubscriptionHolder;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ultralight.Inject;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.concurrent.Callable;
import javax.inject.Singleton;

@Singleton
/* compiled from: PrivacyCheckupComposerDataFetch */
public class RedSpaceMutationsExecutor {
    public static final String f11839a = RedSpaceMutationsExecutor.class.getSimpleName();
    private static volatile RedSpaceMutationsExecutor f11840f;
    @Inject
    public GraphQLQueryExecutor f11841b;
    @Inject
    public TasksManager f11842c;
    @Inject
    public RedSpaceFriendsCacheHelper f11843d;
    public final SubscriptionHolder<FriendChangedSubscriber> f11844e = new SubscriptionHolder();

    /* compiled from: PrivacyCheckupComposerDataFetch */
    public class SimpleFriendChangedSubscriber {
        public void mo335a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        }

        public void mo336a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        }

        public void mo337b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        }

        public void mo338b(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        }
    }

    /* compiled from: PrivacyCheckupComposerDataFetch */
    public class C14031 implements Callable<ListenableFuture> {
        final /* synthetic */ RedSpaceFeedProfileFragmentModel f11828a;
        final /* synthetic */ RedSpaceFeedProfileFragmentModel f11829b;
        final /* synthetic */ RedSpaceMutationsExecutor f11830c;

        public C14031(RedSpaceMutationsExecutor redSpaceMutationsExecutor, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel2) {
            this.f11830c = redSpaceMutationsExecutor;
            this.f11828a = redSpaceFeedProfileFragmentModel;
            this.f11829b = redSpaceFeedProfileFragmentModel2;
        }

        public Object call() {
            RedspaceUserViewInputData redspaceUserViewInputData = new RedspaceUserViewInputData();
            redspaceUserViewInputData.a("space_owner_id", this.f11828a.k());
            GraphQlCallInput graphQlCallInput = redspaceUserViewInputData;
            GraphQlQueryString redSpaceFriendViewMutationString = new RedSpaceFriendViewMutationString();
            redSpaceFriendViewMutationString.a("person_id", this.f11828a.k());
            redSpaceFriendViewMutationString.a("input", graphQlCallInput);
            MutationRequest a = GraphQLRequest.a(redSpaceFriendViewMutationString);
            RedSpaceMutationsExecutor redSpaceMutationsExecutor = this.f11830c;
            RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = this.f11829b;
            redSpaceMutationsExecutor.f11843d.m12210a(redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection.TOP);
            redSpaceMutationsExecutor.f11843d.m12210a(redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection.OTHERS);
            Iterator it = redSpaceMutationsExecutor.f11844e.iterator();
            while (it.hasNext()) {
                SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = (SimpleFriendChangedSubscriber) it.next();
                if (simpleFriendChangedSubscriber != null) {
                    simpleFriendChangedSubscriber.mo335a(redSpaceFeedProfileFragmentModel);
                }
            }
            return this.f11830c.f11841b.a(a);
        }
    }

    /* compiled from: PrivacyCheckupComposerDataFetch */
    public class C14042 extends AbstractDisposableFutureCallback<GraphQLResult<RedSpaceFriendViewMutationModel>> {
        final /* synthetic */ RedSpaceFeedProfileFragmentModel f11831a;
        final /* synthetic */ RedSpaceMutationsExecutor f11832b;

        public C14042(RedSpaceMutationsExecutor redSpaceMutationsExecutor, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
            this.f11832b = redSpaceMutationsExecutor;
            this.f11831a = redSpaceFeedProfileFragmentModel;
        }

        protected final void m12278a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null || ((RedSpaceFriendViewMutationModel) graphQLResult.e).a() == null || ((RedSpaceFriendViewMutationModel) graphQLResult.e).a().a() == null || ((RedSpaceFriendViewMutationModel) graphQLResult.e).a().a().a() == null) {
                m12279a(new NullPointerException("Null result"));
                return;
            }
            if (!((RedSpaceFriendViewMutationModel) graphQLResult.e).a().a().a().a().isEmpty()) {
                RedSpaceMutationsExecutor.m12283a(this.f11832b, this.f11831a, RedSpaceFriendsSection.OTHERS, RedSpaceFriendsSection.TOP);
            }
            RedSpaceMutationsExecutor redSpaceMutationsExecutor = this.f11832b;
            RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = this.f11831a;
            Iterator it = redSpaceMutationsExecutor.f11844e.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }

        protected final void m12279a(Throwable th) {
            BLog.b(RedSpaceMutationsExecutor.f11839a, "Red Space Friend view mutation failed", th);
        }
    }

    public static com.facebook.redspace.data.RedSpaceMutationsExecutor m12282a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11840f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.redspace.data.RedSpaceMutationsExecutor.class;
        monitor-enter(r1);
        r0 = f11840f;	 Catch:{ all -> 0x003a }
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
        r0 = m12284b(r0);	 Catch:{ all -> 0x0035 }
        f11840f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11840f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.data.RedSpaceMutationsExecutor.a(com.facebook.inject.InjectorLike):com.facebook.redspace.data.RedSpaceMutationsExecutor");
    }

    private static RedSpaceMutationsExecutor m12284b(InjectorLike injectorLike) {
        RedSpaceMutationsExecutor redSpaceMutationsExecutor = new RedSpaceMutationsExecutor();
        TasksManager b = TasksManager.b(injectorLike);
        RedSpaceFriendsCacheHelper a = RedSpaceFriendsCacheHelper.m12206a(injectorLike);
        redSpaceMutationsExecutor.f11841b = GraphQLQueryExecutor.a(injectorLike);
        redSpaceMutationsExecutor.f11842c = b;
        redSpaceMutationsExecutor.f11843d = a;
        return redSpaceMutationsExecutor;
    }

    public final synchronized boolean m12288a(SimpleFriendChangedSubscriber simpleFriendChangedSubscriber) {
        return this.f11844e.a(simpleFriendChangedSubscriber);
    }

    public final synchronized boolean m12289b(SimpleFriendChangedSubscriber simpleFriendChangedSubscriber) {
        return this.f11844e.b(simpleFriendChangedSubscriber);
    }

    public final void m12286a(RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        RedspaceUserDemoteInputData redspaceUserDemoteInputData = new RedspaceUserDemoteInputData();
        redspaceUserDemoteInputData.a("friend_id", redSpaceFeedProfileFragmentModel.k());
        GraphQlCallInput graphQlCallInput = redspaceUserDemoteInputData;
        GraphQlQueryString redSpaceFriendDemoteMutationString = new RedSpaceFriendDemoteMutationString();
        redSpaceFriendDemoteMutationString.a("input", graphQlCallInput);
        this.f11841b.a(GraphQLRequest.a(redSpaceFriendDemoteMutationString));
        m12283a(this, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, redSpaceFriendsSection.isOverflow() ? RedSpaceFriendsSection.OTHERS_OVERFLOW : RedSpaceFriendsSection.OTHERS);
    }

    public final void m12287a(final RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, final RedSpaceFriendsSection redSpaceFriendsSection, final boolean z) {
        if (z) {
            m12283a(this, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, redSpaceFriendsSection.isOverflow() ? RedSpaceFriendsSection.TOP_OVERFLOW : RedSpaceFriendsSection.TOP);
        }
        this.f11842c.a("friendsPromote" + redSpaceFeedProfileFragmentModel.k(), new Callable<ListenableFuture>(this) {
            final /* synthetic */ RedSpaceMutationsExecutor f11834b;

            public Object call() {
                RedspaceUserPromoteInputData redspaceUserPromoteInputData = new RedspaceUserPromoteInputData();
                redspaceUserPromoteInputData.a("friend_id", redSpaceFeedProfileFragmentModel.k());
                GraphQlCallInput graphQlCallInput = redspaceUserPromoteInputData;
                GraphQlQueryString redSpaceFriendPromoteMutationString = new RedSpaceFriendPromoteMutationString();
                redSpaceFriendPromoteMutationString.a("person_id", redSpaceFeedProfileFragmentModel.k());
                redSpaceFriendPromoteMutationString.a("input", graphQlCallInput);
                return this.f11834b.f11841b.a(GraphQLRequest.a(redSpaceFriendPromoteMutationString));
            }
        }, new AbstractDisposableFutureCallback<GraphQLResult<RedSpaceFriendPromoteMutationModel>>(this) {
            final /* synthetic */ RedSpaceMutationsExecutor f11838d;

            protected final void m12280a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (graphQLResult.e == null || ((RedSpaceFriendPromoteMutationModel) graphQLResult.e).a() == null || ((RedSpaceFriendPromoteMutationModel) graphQLResult.e).a().a() == null || ((RedSpaceFriendPromoteMutationModel) graphQLResult.e).a().a().a() == null) {
                    m12281a(new NullPointerException("Null result"));
                } else if (!z) {
                    RedSpaceFriendsSection redSpaceFriendsSection;
                    if (((RedSpaceFriendPromoteMutationModel) graphQLResult.e).a().a().a().a().isEmpty()) {
                        redSpaceFriendsSection = RedSpaceFriendsSection.TOP_OVERFLOW;
                    } else {
                        redSpaceFriendsSection = RedSpaceFriendsSection.TOP;
                    }
                    if (redSpaceFriendsSection.isOverflow()) {
                        RedSpaceMutationsExecutor.m12283a(this.f11838d, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection.getOverflowVariant(), redSpaceFriendsSection);
                        RedSpaceMutationsExecutor.m12285b(this.f11838d, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection.getNotOverflowVariant());
                        return;
                    }
                    RedSpaceMutationsExecutor.m12283a(this.f11838d, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection, redSpaceFriendsSection);
                }
            }

            protected final void m12281a(Throwable th) {
                BLog.b(RedSpaceMutationsExecutor.f11839a, "Red Space Friend view mutation failed", th);
                RedSpaceMutationsExecutor redSpaceMutationsExecutor = this.f11838d;
                RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = redSpaceFeedProfileFragmentModel;
                Iterator it = redSpaceMutationsExecutor.f11844e.iterator();
                while (it.hasNext()) {
                    SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = (SimpleFriendChangedSubscriber) it.next();
                    if (simpleFriendChangedSubscriber != null) {
                        simpleFriendChangedSubscriber.mo338b(redSpaceFeedProfileFragmentModel);
                    }
                }
            }
        });
    }

    public static void m12283a(RedSpaceMutationsExecutor redSpaceMutationsExecutor, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection, RedSpaceFriendsSection redSpaceFriendsSection2) {
        if (!redSpaceFriendsSection.isOverflow()) {
            redSpaceMutationsExecutor.f11843d.f11771a.a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection.getApiName(), redSpaceFriendsSection2.getApiName(), !redSpaceFriendsSection2.isTop());
        }
        m12285b(redSpaceMutationsExecutor, redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
        Iterator it = redSpaceMutationsExecutor.f11844e.iterator();
        while (it.hasNext()) {
            SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = (SimpleFriendChangedSubscriber) it.next();
            if (simpleFriendChangedSubscriber != null) {
                simpleFriendChangedSubscriber.mo336a(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection2);
            }
        }
    }

    public static void m12285b(RedSpaceMutationsExecutor redSpaceMutationsExecutor, RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        Iterator it = redSpaceMutationsExecutor.f11844e.iterator();
        while (it.hasNext()) {
            SimpleFriendChangedSubscriber simpleFriendChangedSubscriber = (SimpleFriendChangedSubscriber) it.next();
            if (simpleFriendChangedSubscriber != null) {
                simpleFriendChangedSubscriber.mo337b(redSpaceFeedProfileFragmentModel, redSpaceFriendsSection);
            }
        }
    }
}

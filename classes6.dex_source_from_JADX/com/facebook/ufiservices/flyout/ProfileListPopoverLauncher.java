package com.facebook.ufiservices.flyout;

import android.content.Context;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActor.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMutualFriendsConnection;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.ProfileListParamType;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLInterfaces.UFIProfileListFragmentGraphQL;
import com.facebook.ufiservices.flyout.UFIProfileListFragmentGraphQLModels.UFIProfileListFragmentGraphQLModel.ProfilePictureModel;
import com.facebook.ufiservices.ui.ProfileListFriendingControllerGraphQLModels.ProfileListFriendingControllerGraphQLModel.MutualFriendsModel;
import com.facebook.widget.popover.PopoverAnimationState;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: d4a892feca26dd97de12f51c4164a507 */
public class ProfileListPopoverLauncher {
    private static volatile ProfileListPopoverLauncher f18100c;
    private final PopoverAnimationState f18101a;
    private final UFIPopoverLauncher f18102b;

    /* compiled from: d4a892feca26dd97de12f51c4164a507 */
    class C13131 implements Function<UFIProfileListFragmentGraphQL, GraphQLActor> {
        final /* synthetic */ ProfileListPopoverLauncher f18099a;

        C13131(ProfileListPopoverLauncher profileListPopoverLauncher) {
            this.f18099a = profileListPopoverLauncher;
        }

        public Object apply(Object obj) {
            GraphQLActor graphQLActor;
            UFIProfileListFragmentGraphQL uFIProfileListFragmentGraphQL = (UFIProfileListFragmentGraphQL) obj;
            if (uFIProfileListFragmentGraphQL == null) {
                graphQLActor = null;
            } else {
                GraphQLMutualFriendsConnection graphQLMutualFriendsConnection;
                GraphQLImage graphQLImage;
                Builder builder = new Builder();
                builder.aH = uFIProfileListFragmentGraphQL.c();
                builder.a(uFIProfileListFragmentGraphQL.d());
                builder.B = uFIProfileListFragmentGraphQL.g();
                MutualFriendsModel b = uFIProfileListFragmentGraphQL.b();
                if (b == null) {
                    graphQLMutualFriendsConnection = null;
                } else {
                    GraphQLMutualFriendsConnection.Builder builder2 = new GraphQLMutualFriendsConnection.Builder();
                    builder2.d = b.m26803a();
                    graphQLMutualFriendsConnection = new GraphQLMutualFriendsConnection(builder2);
                }
                builder.U = graphQLMutualFriendsConnection;
                builder.V = uFIProfileListFragmentGraphQL.C_();
                ProfilePictureModel dF_ = uFIProfileListFragmentGraphQL.dF_();
                if (dF_ == null) {
                    graphQLImage = null;
                } else {
                    GraphQLImage.Builder builder3 = new GraphQLImage.Builder();
                    builder3.d = dF_.m26660a();
                    builder3.g = dF_.mo1385b();
                    builder3.h = dF_.m26665c();
                    graphQLImage = builder3.a();
                }
                builder.ad = graphQLImage;
                builder.at = uFIProfileListFragmentGraphQL.j();
                graphQLActor = builder.a();
            }
            return graphQLActor;
        }
    }

    public static com.facebook.ufiservices.flyout.ProfileListPopoverLauncher m26568a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f18100c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ufiservices.flyout.ProfileListPopoverLauncher.class;
        monitor-enter(r1);
        r0 = f18100c;	 Catch:{ all -> 0x003a }
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
        r0 = m26570b(r0);	 Catch:{ all -> 0x0035 }
        f18100c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f18100c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.flyout.ProfileListPopoverLauncher.a(com.facebook.inject.InjectorLike):com.facebook.ufiservices.flyout.ProfileListPopoverLauncher");
    }

    private static ProfileListPopoverLauncher m26570b(InjectorLike injectorLike) {
        return new ProfileListPopoverLauncher(PopoverAnimationState.a(injectorLike), UFIPopoverLauncher.b(injectorLike));
    }

    @Inject
    public ProfileListPopoverLauncher(PopoverAnimationState popoverAnimationState, UFIPopoverLauncher uFIPopoverLauncher) {
        this.f18101a = popoverAnimationState;
        this.f18102b = uFIPopoverLauncher;
    }

    public final void m26571a(Context context, List<String> list) {
        if (!this.f18101a.a()) {
            ProfileListParams.Builder builder = new ProfileListParams.Builder();
            builder.f18081c = list;
            builder = builder;
            builder.f18082d = ProfileListParamType.PROFILES_BY_IDS;
            builder = builder;
            builder.f18084f = true;
            builder = builder;
            builder.f18083e = false;
            m26569a(builder.m26564a(), context);
        }
    }

    public final void m26572b(Context context, List<? extends UFIProfileListFragmentGraphQL> list) {
        if (!this.f18101a.a()) {
            ProfileListParams.Builder builder = new ProfileListParams.Builder();
            builder.f18080b = Lists.a(Lists.a(list, new C13131(this)));
            builder = builder;
            builder.f18082d = ProfileListParamType.PROFILES;
            builder = builder;
            builder.f18084f = true;
            builder = builder;
            builder.f18083e = false;
            m26569a(builder.m26564a(), context);
        }
    }

    private void m26569a(ProfileListParams profileListParams, Context context) {
        UFIContentFragment uFIProfileListFragment = new UFIProfileListFragment();
        uFIProfileListFragment.g(profileListParams.m26567k());
        this.f18102b.a(uFIProfileListFragment, context);
    }
}

package com.facebook.heisman;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryFieldsModel;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQLModels.ProfileOverlayPagesByImageOverlayQueryModel;
import com.facebook.heisman.protocol.ProfileOverlayPagesByImageOverlayGraphQLModels.ProfileOverlayPagesByImageOverlayQueryModel.AssociatedPagesModel;
import com.facebook.inject.InjectorLike;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_deleted_app_provided_hashtag */
public class ProfilePictureOverlayPivotQueryExecutor {
    public static final CallerContext f765a = CallerContext.a(ProfilePictureOverlayPivotQueryExecutor.class, "timeline");
    private static volatile ProfilePictureOverlayPivotQueryExecutor f766d;
    @Inject
    public GraphQLQueryExecutor f767b;
    @Inject
    public GraphQLStoryHelper f768c;

    /* compiled from: user_deleted_app_provided_hashtag */
    public class C00951 implements Function<GraphQLResult<ProfileOverlayPagesByImageOverlayQueryModel>, ProfileOverlayCategoryFieldsModel> {
        final /* synthetic */ String f761a;
        final /* synthetic */ ProfilePictureOverlayPivotQueryExecutor f762b;

        public C00951(ProfilePictureOverlayPivotQueryExecutor profilePictureOverlayPivotQueryExecutor, String str) {
            this.f762b = profilePictureOverlayPivotQueryExecutor;
            this.f761a = str;
        }

        public Object apply(Object obj) {
            int i;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((ProfileOverlayPagesByImageOverlayQueryModel) graphQLResult.e).a().isEmpty() || ((AssociatedPagesModel) ((ProfileOverlayPagesByImageOverlayQueryModel) graphQLResult.e).a().get(0)).a() == null || ((AssociatedPagesModel) ((ProfileOverlayPagesByImageOverlayQueryModel) graphQLResult.e).a().get(0)).a().j() == null || ((AssociatedPagesModel) ((ProfileOverlayPagesByImageOverlayQueryModel) graphQLResult.e).a().get(0)).a().j().a().isEmpty()) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                return ((AssociatedPagesModel) ((ProfileOverlayPagesByImageOverlayQueryModel) graphQLResult.e).a().get(0)).a();
            }
            throw new IllegalArgumentException("Malformed result for image overlay ID: " + this.f761a);
        }
    }

    /* compiled from: user_deleted_app_provided_hashtag */
    public class C00962 implements Function<GraphQLResult<ProfileOverlayCategoryFieldsModel>, ProfileOverlayCategoryFieldsModel> {
        final /* synthetic */ String f763a;
        final /* synthetic */ ProfilePictureOverlayPivotQueryExecutor f764b;

        public C00962(ProfilePictureOverlayPivotQueryExecutor profilePictureOverlayPivotQueryExecutor, String str) {
            this.f764b = profilePictureOverlayPivotQueryExecutor;
            this.f763a = str;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult != null && graphQLResult.e != null && ((ProfileOverlayCategoryFieldsModel) graphQLResult.e).j() != null) {
                return (ProfileOverlayCategoryFieldsModel) graphQLResult.e;
            }
            throw new NullPointerException("Malformed result for category ID: " + this.f763a);
        }
    }

    public static com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor m805a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f766d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor.class;
        monitor-enter(r1);
        r0 = f766d;	 Catch:{ all -> 0x003a }
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
        r0 = m806b(r0);	 Catch:{ all -> 0x0035 }
        f766d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f766d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayPivotQueryExecutor");
    }

    private static ProfilePictureOverlayPivotQueryExecutor m806b(InjectorLike injectorLike) {
        ProfilePictureOverlayPivotQueryExecutor profilePictureOverlayPivotQueryExecutor = new ProfilePictureOverlayPivotQueryExecutor();
        GraphQLStoryHelper a = GraphQLStoryHelper.a(injectorLike);
        profilePictureOverlayPivotQueryExecutor.f767b = GraphQLQueryExecutor.a(injectorLike);
        profilePictureOverlayPivotQueryExecutor.f768c = a;
        return profilePictureOverlayPivotQueryExecutor;
    }
}

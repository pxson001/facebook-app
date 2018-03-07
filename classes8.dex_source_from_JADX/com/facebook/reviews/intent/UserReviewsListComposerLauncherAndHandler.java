package com.facebook.reviews.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.loader.UserReviewsListLoader;
import com.facebook.reviews.loader.UserReviewsListLoader.C23396;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler.PostReviewCallbackBase;
import com.facebook.reviews.util.protocol.graphql.FetchUpdatedUserReviewForPageGraphQLRequest;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviews.FetchUpdatedPageReviewQueryString;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Treating non tag expansion token as a tag expansion token */
public class UserReviewsListComposerLauncherAndHandler {
    private static volatile UserReviewsListComposerLauncherAndHandler f21642f;
    private final Resources f21643a;
    private final ReviewComposerLauncherAndHandler f21644b;
    public final ReviewEventBus f21645c;
    private final Toaster f21646d;
    public final UserReviewsListLoader f21647e;

    /* compiled from: Treating non tag expansion token as a tag expansion token */
    public class C23232 {
        public final /* synthetic */ String f21637a;
        public final /* synthetic */ ReviewWithFeedback f21638b;
        public final /* synthetic */ UserReviewsListComposerLauncherAndHandler f21639c;

        public C23232(UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler, String str, ReviewWithFeedback reviewWithFeedback) {
            this.f21639c = userReviewsListComposerLauncherAndHandler;
            this.f21637a = str;
            this.f21638b = reviewWithFeedback;
        }
    }

    /* compiled from: Treating non tag expansion token as a tag expansion token */
    public class C23243 {
        public final /* synthetic */ String f21640a;
        public final /* synthetic */ UserReviewsListComposerLauncherAndHandler f21641b;

        public C23243(UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler, String str) {
            this.f21641b = userReviewsListComposerLauncherAndHandler;
            this.f21640a = str;
        }
    }

    public static com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler m25177a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21642f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler.class;
        monitor-enter(r1);
        r0 = f21642f;	 Catch:{ all -> 0x003a }
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
        r0 = m25178b(r0);	 Catch:{ all -> 0x0035 }
        f21642f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21642f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler.a(com.facebook.inject.InjectorLike):com.facebook.reviews.intent.UserReviewsListComposerLauncherAndHandler");
    }

    private static UserReviewsListComposerLauncherAndHandler m25178b(InjectorLike injectorLike) {
        return new UserReviewsListComposerLauncherAndHandler(ResourcesMethodAutoProvider.a(injectorLike), ReviewComposerLauncherAndHandler.m4943a(injectorLike), UserReviewsListLoader.m25210a(injectorLike), ReviewEventBus.m4876a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public UserReviewsListComposerLauncherAndHandler(Resources resources, ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler, UserReviewsListLoader userReviewsListLoader, ReviewEventBus reviewEventBus, Toaster toaster) {
        this.f21647e = userReviewsListLoader;
        this.f21643a = resources;
        this.f21644b = reviewComposerLauncherAndHandler;
        this.f21645c = reviewEventBus;
        this.f21646d = toaster;
    }

    public final void m25180a(ReviewBasicFields reviewBasicFields, String str, String str2, int i, Activity activity, ComposerSourceType composerSourceType, CurationSurface curationSurface, CurationMechanism curationMechanism) {
        this.f21644b.m4945a(i, activity, composerSourceType, curationSurface, curationMechanism, ReviewsGraphQLHelper.m4909a(reviewBasicFields), Long.parseLong(str), str2, ReviewsGraphQLHelper.m4913b(reviewBasicFields), ReviewsGraphQLHelper.m4917c(reviewBasicFields), null);
    }

    public final void m25179a(Context context, int i, Intent intent, final String str, String str2) {
        C23221 c23221 = new PostReviewCallbackBase(this) {
            final /* synthetic */ UserReviewsListComposerLauncherAndHandler f21636b;

            public final void mo1173b() {
            }

            public final void mo1125a(OperationResult operationResult) {
                UserReviewsListComposerLauncherAndHandler userReviewsListComposerLauncherAndHandler = this.f21636b;
                String str = str;
                ReviewWithFeedback reviewWithFeedback = (ReviewWithFeedback) operationResult.h();
                userReviewsListComposerLauncherAndHandler.f21645c.a(ReviewEvents.m4890a(str, reviewWithFeedback));
                UserReviewsListLoader userReviewsListLoader = userReviewsListComposerLauncherAndHandler.f21647e;
                C23232 c23232 = new C23232(userReviewsListComposerLauncherAndHandler, str, reviewWithFeedback);
                TasksManager tasksManager = userReviewsListLoader.f21711f;
                String str2 = "key_load_updated_review" + str;
                FetchUpdatedUserReviewForPageGraphQLRequest fetchUpdatedUserReviewForPageGraphQLRequest = (FetchUpdatedUserReviewForPageGraphQLRequest) userReviewsListLoader.f21708c.get();
                GraphQlQueryString fetchUpdatedPageReviewQueryString = new FetchUpdatedPageReviewQueryString();
                fetchUpdatedPageReviewQueryString.a("page_id", str).a("review_profile_pic_size", fetchUpdatedUserReviewForPageGraphQLRequest.f5018b.m4924b()).a("review_cover_pic_size", fetchUpdatedUserReviewForPageGraphQLRequest.f5018b.m4925c());
                tasksManager.a(str2, fetchUpdatedUserReviewForPageGraphQLRequest.f5017a.a(GraphQLRequest.a(fetchUpdatedPageReviewQueryString)), new C23396(userReviewsListLoader, c23232));
                userReviewsListComposerLauncherAndHandler.f21647e.m25216a(str, new C23243(userReviewsListComposerLauncherAndHandler, str));
            }
        };
        this.f21644b.m4946a(i, intent, str2, Optional.of(c23221), Optional.of(context));
    }
}

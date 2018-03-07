package com.facebook.reaction.intent;

import android.content.Intent;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.ReactionQueryParams;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionCommonConstants.CardSearchType;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionQueryFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoriesModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler.PostReviewCallbackBase;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: XSyncComponent */
public class ReactionReviewUpdateHandler {
    private static volatile ReactionReviewUpdateHandler f20733h;
    private Provider<FbEventSubscriberListManager> f20734a;
    public ReactionUtil f20735b;
    private Resources f20736c;
    private ReviewComposerLauncherAndHandler f20737d;
    public ReviewEventBus f20738e;
    public FbEventSubscriberListManager f20739f = ((FbEventSubscriberListManager) this.f20734a.get());
    private Toaster f20740g;

    public static com.facebook.reaction.intent.ReactionReviewUpdateHandler m24388a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20733h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.intent.ReactionReviewUpdateHandler.class;
        monitor-enter(r1);
        r0 = f20733h;	 Catch:{ all -> 0x003a }
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
        r0 = m24389b(r0);	 Catch:{ all -> 0x0035 }
        f20733h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20733h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.intent.ReactionReviewUpdateHandler.a(com.facebook.inject.InjectorLike):com.facebook.reaction.intent.ReactionReviewUpdateHandler");
    }

    private static ReactionReviewUpdateHandler m24389b(InjectorLike injectorLike) {
        return new ReactionReviewUpdateHandler(IdBasedProvider.a(injectorLike, 973), ReactionUtil.m22637a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ReviewComposerLauncherAndHandler.m4943a(injectorLike), ReviewEventBus.m4876a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public ReactionReviewUpdateHandler(Provider<FbEventSubscriberListManager> provider, ReactionUtil reactionUtil, Resources resources, ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler, ReviewEventBus reviewEventBus, Toaster toaster) {
        this.f20734a = provider;
        this.f20735b = reactionUtil;
        this.f20736c = resources;
        this.f20737d = reviewComposerLauncherAndHandler;
        this.f20738e = reviewEventBus;
        this.f20740g = toaster;
    }

    public final void m24390a(int i, Intent intent, String str, String str2, ReactionCardContainer reactionCardContainer, @Nullable Long l, @Nullable String str3) {
        final Long l2 = l;
        final String str4 = str3;
        final String str5 = str2;
        final ReactionCardContainer reactionCardContainer2 = reactionCardContainer;
        this.f20737d.m4946a(i, intent, str, Optional.of(new PostReviewCallbackBase(this) {
            final /* synthetic */ ReactionReviewUpdateHandler f20732e;

            /* compiled from: XSyncComponent */
            class C21931 extends AbstractDisposableFutureCallback {
                final /* synthetic */ C21941 f20727a;

                C21931(C21941 c21941) {
                    this.f20727a = c21941;
                }

                protected final void m24385a(Object obj) {
                    Object obj2;
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    ReactionReviewUpdateHandler reactionReviewUpdateHandler = this.f20727a.f20732e;
                    String str = str5;
                    ReactionCardContainer reactionCardContainer = reactionCardContainer2;
                    if (graphQLResult == null || graphQLResult.e == null || ((ReactionQueryFragmentModel) graphQLResult.e).a() == null || ((ReactionQueryFragmentModel) graphQLResult.e).a().a() == null || ((ReactionQueryFragmentModel) graphQLResult.e).a().a().isEmpty()) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        ReactionUnitFragmentModel j = ((EdgesModel) ((ReactionQueryFragmentModel) graphQLResult.e).j().a().get(0)).j();
                        String d = j.d();
                        if (d != null) {
                            if (str.equals(d)) {
                                reactionCardContainer.mo728a(j, d, CardSearchType.UNIT_ID);
                                return;
                            }
                            reactionCardContainer.mo729a(str, CardSearchType.UNIT_ID);
                            reactionCardContainer.mo728a(j, d, CardSearchType.UNIT_ID);
                        }
                    }
                }

                protected final void m24386a(Throwable th) {
                }
            }

            public final void mo1125a(OperationResult operationResult) {
                ReactionQueryParams reactionQueryParams = new ReactionQueryParams();
                if (l2 != null) {
                    reactionQueryParams.f18631l = l2;
                }
                if (!Strings.isNullOrEmpty(str4)) {
                    reactionQueryParams.f18624e = str4;
                }
                this.f20732e.f20735b.m22657a(new C21931(this), reactionCardContainer2.getSessionId(), reactionCardContainer2.getSurface(), str5, reactionQueryParams);
                if (reactionCardContainer2.getInteractionTracker() != null) {
                    reactionCardContainer2.getInteractionTracker().mo984a(str5, null, null, UnitInteractionType.WRITE_REVIEW_PUBLISH);
                }
            }
        }), Optional.of(reactionCardContainer.getContext()));
    }
}

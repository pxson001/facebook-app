package com.facebook.reviews.binder;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.TextAppearanceSpan;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedback.ui.FeedbackPopoverLauncher;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.ExpandState;
import com.facebook.resources.ui.ExpandingEllipsizingTextView.OnExpandStateChangeListener;
import com.facebook.reviews.analytics.ReviewsClickEventTargets;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.controller.ReviewRowViewController;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.UserReviewsFragmentsModels.UserReviewsModel.AuthoredReviewsModel.EdgesModel;
import com.facebook.reviews.ui.ReviewFeedRowView;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsInterfaces.FetchSingleReviewQuery.RepresentedProfile;
import com.facebook.reviews.util.protocol.graphql.FetchUserReviewsModels.FetchSingleReviewQueryModel.RepresentedProfileModel;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: UNSET_BOUNCE_FROM_MSITE */
public class UserReviewFeedRowViewBinder {
    private static volatile UserReviewFeedRowViewBinder f21435d;
    public final FbUriIntentHandler f21436a;
    private final ReviewRowViewController f21437b;
    public final ReviewsLogger f21438c;

    public static com.facebook.reviews.binder.UserReviewFeedRowViewBinder m25056a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21435d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reviews.binder.UserReviewFeedRowViewBinder.class;
        monitor-enter(r1);
        r0 = f21435d;	 Catch:{ all -> 0x003a }
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
        r0 = m25059b(r0);	 Catch:{ all -> 0x0035 }
        f21435d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21435d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reviews.binder.UserReviewFeedRowViewBinder.a(com.facebook.inject.InjectorLike):com.facebook.reviews.binder.UserReviewFeedRowViewBinder");
    }

    private static UserReviewFeedRowViewBinder m25059b(InjectorLike injectorLike) {
        return new UserReviewFeedRowViewBinder(FbUriIntentHandler.a(injectorLike), new ReviewRowViewController(FbUriIntentHandler.a(injectorLike), FeedbackPopoverLauncher.a(injectorLike), IdBasedLazy.a(injectorLike, 10271), IdBasedProvider.a(injectorLike, 4442), ReviewFeedRowViewBinder.m25035a(injectorLike), ReviewComposerLauncherAndHandler.m4943a(injectorLike), ReviewsLogger.a(injectorLike)), ReviewsLogger.a(injectorLike));
    }

    @Inject
    public UserReviewFeedRowViewBinder(FbUriIntentHandler fbUriIntentHandler, ReviewRowViewController reviewRowViewController, ReviewsLogger reviewsLogger) {
        this.f21436a = fbUriIntentHandler;
        this.f21437b = reviewRowViewController;
        this.f21438c = reviewsLogger;
    }

    public final void m25061a(ReviewFeedRowView reviewFeedRowView, EdgesModel edgesModel) {
        String str;
        FeedProps feedProps;
        final String b = ReviewsGraphQLHelper.m4916b(edgesModel);
        ReviewRowViewController reviewRowViewController = this.f21437b;
        ReviewWithFeedback b2 = edgesModel.b();
        GraphQLStoryAttachment d = ReviewsGraphQLHelper.m4920d(edgesModel);
        if (d == null || d.z() == null) {
            str = null;
        } else {
            str = d.z().eP();
        }
        reviewRowViewController.m25078a(reviewFeedRowView, b2, b, str, CurationSurface.USER_SEE_ALL_REVIEWS, "user_reviews_list", m25055a(b, ReviewsGraphQLHelper.m4914b(edgesModel.b())), ExpandState.COLLAPSED);
        if (edgesModel == null || edgesModel.a() == null) {
            feedProps = null;
        } else {
            feedProps = FeedProps.c(edgesModel.a().a());
        }
        FeedProps feedProps2 = feedProps;
        reviewFeedRowView.setPageAttachmentView(feedProps2);
        if (feedProps2.a != null) {
            C22883 c22883;
            final String b3 = ReviewsGraphQLHelper.m4914b(edgesModel.b());
            if (b == null) {
                c22883 = null;
            } else {
                c22883 = new OnClickListener(this) {
                    final /* synthetic */ UserReviewFeedRowViewBinder f21434c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -747014541);
                        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, b);
                        this.f21434c.f21438c.a("user_reviews_list", b, b3, ReviewsClickEventTargets.PLACE_REVIEW_ATTACHMENT);
                        this.f21434c.f21436a.a(view.getContext(), formatStrLocaleSafe);
                        Logger.a(2, EntryType.UI_INPUT_END, -515661783, a);
                    }
                };
            }
            reviewFeedRowView.setAttachmentClickListener(c22883);
        }
    }

    public final void m25060a(ReviewFeedRowView reviewFeedRowView, Pair<ReviewWithFeedback, RepresentedProfile> pair) {
        String str;
        String b = ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) pair.first);
        String a = ReviewsGraphQLHelper.m4911a((ReviewWithCreationFields) pair.first);
        String a2 = ReviewsGraphQLHelper.m4912a((RepresentedProfileModel) pair.second);
        RepresentedProfileModel representedProfileModel = (RepresentedProfileModel) pair.second;
        if (representedProfileModel == null) {
            str = null;
        } else {
            str = representedProfileModel.m4992c();
        }
        String str2 = str;
        ReviewFeedRowView reviewFeedRowView2 = reviewFeedRowView;
        this.f21437b.m25077a(reviewFeedRowView2, (ReviewWithFeedback) pair.first, m25057a(reviewFeedRowView.getContext(), b, a, a2, str2), a2, str2, CurationSurface.USER_SEE_ALL_REVIEWS, "user_reviews_list", m25055a(a2, ReviewsGraphQLHelper.m4914b((ReviewWithCreationFields) pair.first)), ExpandState.COLLAPSED);
    }

    private CharSequence m25057a(Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        StyledStringBuilder a = new StyledStringBuilder(context.getResources()).a(context.getString(2131235340, new Object[]{"REVIEW_CREATOR", "REVIEWED_PAGE"}));
        a.a("REVIEW_CREATOR", str2, 33, new Object[]{m25053a(str, str3, str, ReviewsClickEventTargets.REVIEW_CREATOR_NAME), m25054a(context)});
        a.a("REVIEWED_PAGE", str4, 33, new Object[]{m25053a(str3, str3, str, ReviewsClickEventTargets.REVIEW_PAGE_NAME), m25054a(context)});
        return a.b();
    }

    private ClickableSpan m25053a(String str, String str2, String str3, ReviewsClickEventTargets reviewsClickEventTargets) {
        final String str4 = str2;
        final String str5 = str3;
        final ReviewsClickEventTargets reviewsClickEventTargets2 = reviewsClickEventTargets;
        final String str6 = str;
        return new ClickableSpan(this) {
            final /* synthetic */ UserReviewFeedRowViewBinder f21428e;

            public void onClick(View view) {
                this.f21428e.f21438c.a("user_reviews_list", str4, str5, reviewsClickEventTargets2);
                this.f21428e.f21436a.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str6));
            }

            public void updateDrawState(TextPaint textPaint) {
            }
        };
    }

    private static TextAppearanceSpan m25054a(Context context) {
        return new TextAppearanceSpan(context, 2131625507);
    }

    private OnExpandStateChangeListener m25055a(final String str, final String str2) {
        return new OnExpandStateChangeListener(this) {
            final /* synthetic */ UserReviewFeedRowViewBinder f21431c;

            public final void m25051a() {
                UserReviewFeedRowViewBinder.m25058a(this.f21431c, ReviewsClickEventTargets.REVIEW_TEXT_EXPAND, str, str2);
            }

            public final void m25052b() {
                UserReviewFeedRowViewBinder.m25058a(this.f21431c, ReviewsClickEventTargets.REVIEW_TEXT_COLLAPSE, str, str2);
            }
        };
    }

    public static void m25058a(UserReviewFeedRowViewBinder userReviewFeedRowViewBinder, ReviewsClickEventTargets reviewsClickEventTargets, String str, String str2) {
        userReviewFeedRowViewBinder.f21438c.a("user_reviews_list", str, str2, reviewsClickEventTargets);
    }
}

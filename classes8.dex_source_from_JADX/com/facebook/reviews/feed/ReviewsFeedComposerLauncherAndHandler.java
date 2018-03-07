package com.facebook.reviews.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.event.ReviewEvents.ViewerReviewEvent;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.util.PageReviewLoader;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler.PostReviewCallbackBase;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TutorialNuxConfiguration */
public class ReviewsFeedComposerLauncherAndHandler {
    private final AbstractFbErrorReporter f21543a;
    private final PageReviewLoader f21544b;
    private final Resources f21545c;
    private final ReviewComposerLauncherAndHandler f21546d;
    public final ReviewEventBus f21547e;
    public final ReviewsFeedLoader f21548f;
    private final Toaster f21549g;

    /* compiled from: TutorialNuxConfiguration */
    public class C23043 {
        public final /* synthetic */ String f21540a;
        public final /* synthetic */ OperationResult f21541b;
        public final /* synthetic */ ReviewsFeedComposerLauncherAndHandler f21542c;

        public C23043(ReviewsFeedComposerLauncherAndHandler reviewsFeedComposerLauncherAndHandler, String str, OperationResult operationResult) {
            this.f21542c = reviewsFeedComposerLauncherAndHandler;
            this.f21540a = str;
            this.f21541b = operationResult;
        }
    }

    public static ReviewsFeedComposerLauncherAndHandler m25112b(InjectorLike injectorLike) {
        return new ReviewsFeedComposerLauncherAndHandler((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PageReviewLoader.m4899a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ReviewComposerLauncherAndHandler.m4943a(injectorLike), ReviewEventBus.m4876a(injectorLike), ReviewsFeedLoader.m25123b(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public ReviewsFeedComposerLauncherAndHandler(AbstractFbErrorReporter abstractFbErrorReporter, PageReviewLoader pageReviewLoader, Resources resources, ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler, ReviewEventBus reviewEventBus, ReviewsFeedLoader reviewsFeedLoader, Toaster toaster) {
        this.f21543a = abstractFbErrorReporter;
        this.f21544b = pageReviewLoader;
        this.f21545c = resources;
        this.f21546d = reviewComposerLauncherAndHandler;
        this.f21547e = reviewEventBus;
        this.f21548f = reviewsFeedLoader;
        this.f21549g = toaster;
    }

    public final void m25113a(Activity activity, CurationMechanism curationMechanism, String str, String str2) {
        m25109a(activity, curationMechanism, str, str2, null);
    }

    public final void m25114a(Context context, int i, Intent intent, final String str, String str2) {
        if (i == -1) {
            C23032 c23032 = new PostReviewCallbackBase(this) {
                final /* synthetic */ ReviewsFeedComposerLauncherAndHandler f21539b;

                public final void mo1172a() {
                    ReviewsFeedComposerLauncherAndHandler.m25110a(this.f21539b, str);
                }

                public final void mo1173b() {
                    ReviewsFeedComposerLauncherAndHandler.m25110a(this.f21539b, str);
                }

                public final void mo1125a(OperationResult operationResult) {
                    ReviewsFeedComposerLauncherAndHandler reviewsFeedComposerLauncherAndHandler = this.f21539b;
                    String str = str;
                    reviewsFeedComposerLauncherAndHandler.f21548f.m25126a(str, new C23043(reviewsFeedComposerLauncherAndHandler, str, operationResult));
                }
            };
            this.f21546d.m4946a(i, intent, str2, Optional.of(c23032), Optional.of(context));
        }
    }

    public static void m25110a(ReviewsFeedComposerLauncherAndHandler reviewsFeedComposerLauncherAndHandler, String str) {
        reviewsFeedComposerLauncherAndHandler.f21547e.a(ReviewEvents.m4889a(str));
    }

    public static void m25111a(ReviewsFeedComposerLauncherAndHandler reviewsFeedComposerLauncherAndHandler, String str, OperationResult operationResult, Optional optional) {
        ViewerReviewEvent a = ReviewEvents.m4890a(str, (ReviewWithFeedback) operationResult.h());
        a.f4959c = optional;
        reviewsFeedComposerLauncherAndHandler.f21547e.a(a);
    }

    private void m25109a(Activity activity, CurationMechanism curationMechanism, String str, String str2, @Nullable ReviewBasicFields reviewBasicFields) {
        try {
            this.f21546d.m4945a(1759, activity, ComposerSourceType.REVIEWS_LIST, CurationSurface.PAGE_SEE_ALL_REVIEWS, curationMechanism, ReviewsGraphQLHelper.m4909a(reviewBasicFields), Long.parseLong(str), str2, ReviewsGraphQLHelper.m4913b(reviewBasicFields), ReviewsGraphQLHelper.m4917c(reviewBasicFields), null);
        } catch (NumberFormatException e) {
            this.f21543a.a(ReviewsFeedComposerLauncherAndHandler.class.getSimpleName(), "Trying to edit review with invalid page id. Page id: " + str);
            this.f21549g.a(new ToastBuilder(2131235356));
        }
    }
}

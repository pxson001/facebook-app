package com.facebook.pages.common.resulthandlers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.OperationResult.NoResultDataParcelableException;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.ScrollToReviewsCardEvent;
import com.facebook.pages.common.eventbus.PageEvents.UpdatePageDataEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reviews.event.ReviewEventBus;
import com.facebook.reviews.event.ReviewEvents;
import com.facebook.reviews.event.ReviewEvents.PageOverallRatingUpdatedEvent;
import com.facebook.reviews.protocol.graphql.PageReviewsFragmentsModels.PageOverallStarRatingModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.util.PageReviewLoader;
import com.facebook.reviews.util.PageReviewLoader.LoadPageOverallStarRatingCallback;
import com.facebook.reviews.util.helper.ReviewsMessagesHelper;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: sJavaBridge */
public class PostReviewHandler implements ActivityResultHandler {
    private final Context f2282a;
    private final Toaster f2283b;
    private final Resources f2284c;
    private final PagesAnalytics f2285d;
    private final ComposerPublishServiceHelper f2286e;
    private final Provider<User> f2287f;
    private final PageEventBus f2288g;
    private final ReviewsMessagesHelper f2289h;
    public final PageReviewLoader f2290i;
    public final ReviewEventBus f2291j;
    private final ViewerContextManager f2292k;
    private final Product f2293l;
    public long f2294m;
    private String f2295n;
    private int f2296o;
    private boolean f2297p;

    public static PostReviewHandler m3251b(InjectorLike injectorLike) {
        return new PostReviewHandler((Context) injectorLike.getInstance(Context.class), Toaster.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), PagesAnalytics.a(injectorLike), ComposerPublishServiceHelper.b(injectorLike), IdBasedProvider.a(injectorLike, 3595), PageEventBus.m2423a(injectorLike), ReviewsMessagesHelper.a(injectorLike), PageReviewLoader.a(injectorLike), ReviewEventBus.a(injectorLike), ViewerContextManagerProvider.b(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PostReviewHandler(Context context, Toaster toaster, Resources resources, PagesAnalytics pagesAnalytics, ComposerPublishServiceHelper composerPublishServiceHelper, Provider<User> provider, PageEventBus pageEventBus, ReviewsMessagesHelper reviewsMessagesHelper, PageReviewLoader pageReviewLoader, ReviewEventBus reviewEventBus, ViewerContextManager viewerContextManager, Product product) {
        this.f2282a = context;
        this.f2283b = toaster;
        this.f2284c = resources;
        this.f2285d = pagesAnalytics;
        this.f2286e = composerPublishServiceHelper;
        this.f2287f = provider;
        this.f2288g = pageEventBus;
        this.f2289h = reviewsMessagesHelper;
        this.f2290i = pageReviewLoader;
        this.f2291j = reviewEventBus;
        this.f2292k = viewerContextManager;
        this.f2293l = product;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2294m = j;
        PostReviewParams postReviewParams = (PostReviewParams) intent.getParcelableExtra("publishReviewParams");
        this.f2296o = postReviewParams.e;
        this.f2295n = postReviewParams.c;
        this.f2297p = i == 10108;
        return this.f2286e.a(postReviewParams, this.f2293l != Product.PAA ? this.f2292k.a() : null);
    }

    public final void mo47a(OperationResult operationResult) {
        try {
            m3252b(operationResult);
        } catch (NoResultDataParcelableException e) {
            m3250a(this.f2289h.a());
        }
    }

    public final void mo48a(ServiceException serviceException) {
        m3250a(this.f2289h.a(serviceException));
        this.f2288g.a(UpdatePageDataEvent.m2436c());
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2282a, this.f2284c.getString(2131235327));
    }

    public final boolean mo49b() {
        return false;
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(1759), Integer.valueOf(10108), Integer.valueOf(10107), Integer.valueOf(UnitInteractionType.WRITE_REVIEW_TAP.ordinal()));
    }

    private void m3250a(String str) {
        this.f2285d.a(false, this.f2294m, false);
        this.f2283b.b(new ToastBuilder(str));
    }

    private void m3252b(OperationResult operationResult) {
        if (this.f2297p) {
            this.f2285d.a(NetworkSuccessEvent.EVENT_PLACE_EDIT_REVIEW_SUCCESS, this.f2294m);
        } else {
            this.f2285d.a(true, this.f2294m, false);
        }
        ReviewWithFeedback reviewWithFeedback = (ReviewWithFeedback) operationResult.h();
        this.f2288g.a(new ScrollToReviewsCardEvent());
        this.f2288g.a(UpdatePageDataEvent.m2435b());
        this.f2291j.a(ReviewEvents.a(String.valueOf(this.f2294m), reviewWithFeedback));
        this.f2283b.b(new ToastBuilder(2131235328));
        final String valueOf = String.valueOf(this.f2294m);
        this.f2290i.a(valueOf, new LoadPageOverallStarRatingCallback(this) {
            final /* synthetic */ PostReviewHandler f2281b;

            public final void m3249a(PageOverallStarRatingModel pageOverallStarRatingModel) {
                if (pageOverallStarRatingModel != null) {
                    this.f2281b.f2291j.a(new PageOverallRatingUpdatedEvent(pageOverallStarRatingModel, valueOf));
                }
            }

            public final void m3248a() {
            }
        });
    }
}

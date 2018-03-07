package com.facebook.feed.fragment.controllercallbacks;

import android.content.Intent;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ActivityResultCallback;
import com.facebook.controllercallbacks.fragment.ActivityResultUtil;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerPersistentState;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PagerStateKey;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.util.ArrayList;
import java.util.List;

/* compiled from: platform_get_app_name */
public class ReviewComposerResultController extends BaseController implements ActivityResultCallback, AdapterCreatedCallback {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ReviewComposerLauncherAndHandler> f9706a = UltralightRuntime.f368b;
    public Holder<ListItemCollection<FeedEdge>> f9707b;
    private FeedEnvironment f9708c;

    public static ReviewComposerResultController m14717a(InjectorLike injectorLike) {
        ReviewComposerResultController reviewComposerResultController = new ReviewComposerResultController();
        reviewComposerResultController.f9706a = IdBasedLazy.m1808a(injectorLike, 10287);
        return reviewComposerResultController;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9708c = feedEnvironment;
    }

    public final void kF_() {
        this.f9708c = null;
    }

    public final void mo1941a(int i, int i2, Intent intent) {
        if (ActivityResultUtil.a(1759, i, i2, intent)) {
            int i3 = i2;
            Intent intent2 = intent;
            ((ReviewComposerLauncherAndHandler) this.f9706a.get()).a(i3, intent2, "native_newsfeed", Absent.INSTANCE, Optional.of(this.f9708c.getContext()));
            m14718a((PostReviewParams) intent.getParcelableExtra("publishReviewParams"));
        }
    }

    private void m14718a(PostReviewParams postReviewParams) {
        if (postReviewParams != null) {
            List arrayList = new ArrayList();
            int a = ((ListItemCollection) this.f9707b.f10429a).mo1374a();
            for (int i = 0; i < a; i++) {
                GraphQLFeedUnitEdge graphQLFeedUnitEdge = (GraphQLFeedUnitEdge) ((ListItemCollection) this.f9707b.f10429a).mo1375a(i);
                if (graphQLFeedUnitEdge.mo2540c() instanceof GraphQLPlaceReviewFeedUnit) {
                    GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit = (GraphQLPlaceReviewFeedUnit) graphQLFeedUnitEdge.mo2540c();
                    PagerPersistentState pagerPersistentState = (PagerPersistentState) this.f9708c.mo2424a(PagerStateKey.a(graphQLPlaceReviewFeedUnit.mo2507g()));
                    int i2 = pagerPersistentState.a;
                    if (i2 + 1 < ItemListFeedUnitImpl.m30150a(graphQLPlaceReviewFeedUnit).size()) {
                        pagerPersistentState.a = i2 + 1;
                    }
                    arrayList.add(graphQLPlaceReviewFeedUnit);
                }
            }
            this.f9708c.mo2438a(arrayList.toArray());
        }
    }
}

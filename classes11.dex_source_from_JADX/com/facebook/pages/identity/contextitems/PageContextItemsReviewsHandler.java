package com.facebook.pages.identity.contextitems;

import android.content.Context;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.reviews.intent.ReviewsListLauncher;
import javax.inject.Inject;

/* compiled from: person_list */
public class PageContextItemsReviewsHandler {
    private final PagesAnalytics f3881a;
    private final Context f3882b;
    private final ReviewsListLauncher f3883c;

    @Inject
    public PageContextItemsReviewsHandler(Context context, ReviewsListLauncher reviewsListLauncher, PagesAnalytics pagesAnalytics) {
        this.f3882b = context;
        this.f3883c = reviewsListLauncher;
        this.f3881a = pagesAnalytics;
    }

    public final void m4797a(PageContextItemHandlingData pageContextItemHandlingData) {
        this.f3881a.a(TapEvent.EVENT_TAPPED_REVIEWS_CONTEXT_ITEM, pageContextItemHandlingData.a);
        this.f3883c.a(pageContextItemHandlingData.a, null, pageContextItemHandlingData.e, pageContextItemHandlingData.e, this.f3882b);
    }
}

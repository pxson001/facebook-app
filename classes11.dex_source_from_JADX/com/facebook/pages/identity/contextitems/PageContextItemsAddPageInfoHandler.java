package com.facebook.pages.identity.contextitems;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import com.facebook.places.suggestions.PlaceSuggestionsIntentBuilder;
import javax.inject.Inject;

/* compiled from: pixel_ratio */
public class PageContextItemsAddPageInfoHandler {
    private final PlaceSuggestionsIntentBuilder f3797a;
    private final PagesAnalytics f3798b;
    private AbstractFbErrorReporter f3799c;
    private SecureContextHelper f3800d;

    @Inject
    public PageContextItemsAddPageInfoHandler(AbstractFbErrorReporter abstractFbErrorReporter, PlaceSuggestionsIntentBuilder placeSuggestionsIntentBuilder, PagesAnalytics pagesAnalytics, SecureContextHelper secureContextHelper) {
        this.f3799c = abstractFbErrorReporter;
        this.f3797a = placeSuggestionsIntentBuilder;
        this.f3798b = pagesAnalytics;
        this.f3800d = secureContextHelper;
    }

    public final void m4763a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        this.f3798b.a(TapEvent.EVENT_TAPPED_SUGGEST_EDIT, pageContextItemHandlingData.a);
        Intent a = this.f3797a.a(pageContextItemHandlingData.a, pageContextItemHandlingData.e, pageContextItemHandlingData.f, null, CrowdEntryPoint.ADD_INFO_BUTTON);
        if (a == null) {
            this.f3799c.a("page_context_rows_suggest_edit_fail", "Failed to resolve suggest edits intent!");
        } else {
            this.f3800d.a(a, 10102, (Activity) view.getContext());
        }
    }
}

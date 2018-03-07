package com.facebook.pages.identity.contextitems;

import android.content.Intent;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.content.SecureContextHelper;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

/* compiled from: person_id */
public class PageContextItemsSubscribeToNearbyEventsHandler {
    private final DefaultPageSurfaceIntentBuilder f3884a;
    private final SecureContextHelper f3885b;
    private final AbstractFbErrorReporter f3886c;

    @Inject
    public PageContextItemsSubscribeToNearbyEventsHandler(DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder, SecureContextHelper secureContextHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f3884a = defaultPageSurfaceIntentBuilder;
        this.f3885b = secureContextHelper;
        this.f3886c = abstractFbErrorReporter;
    }

    public final void m4798a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        Intent a = this.f3884a.a(pageContextItemHandlingData.a, pageContextItemHandlingData.e, "pages_identity".toString(), "page_permalink_context_row");
        if (a != null) {
            this.f3885b.a(a, view.getContext());
        } else {
            this.f3886c.a("page_context_rows_subscribe_to_nearby_events_fail", "Failed to resolve nearby events list intent!");
        }
    }
}

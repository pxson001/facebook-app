package com.facebook.pages.identity.contextitems;

import android.app.Activity;
import android.view.View;
import com.facebook.analytics.CurationMechanism;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.identity.contextitems.handler.PageContextItemHandlingData;
import javax.inject.Inject;

/* compiled from: pin_location */
public class PageContextItemsAddReviewHandler {
    private final ComposerLauncher f3805a;
    private final DefaultPageSurfaceIntentBuilder f3806b;

    @Inject
    public PageContextItemsAddReviewHandler(ComposerLauncher composerLauncher, DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder) {
        this.f3805a = composerLauncher;
        this.f3806b = defaultPageSurfaceIntentBuilder;
    }

    public final void m4768a(View view, PageContextItemHandlingData pageContextItemHandlingData) {
        this.f3805a.a(null, this.f3806b.a(pageContextItemHandlingData.a, pageContextItemHandlingData.e, null, CurationMechanism.CONTEXT_ITEM, pageContextItemHandlingData.d).a(), 10107, (Activity) view.getContext());
    }
}

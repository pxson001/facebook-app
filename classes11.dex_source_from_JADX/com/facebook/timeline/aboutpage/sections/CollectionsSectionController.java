package com.facebook.timeline.aboutpage.sections;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsCurationController;
import com.facebook.timeline.aboutpage.CollectionsExtras;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionTitleClickEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionTitleClickEventSubscriber;
import javax.inject.Inject;

/* compiled from: MINUTES */
public class CollectionsSectionController {
    public final FbUriIntentHandler f13548a;
    public final CollectionsCurationController f13549b;
    public Context f13550c;
    public ProfileViewerContext f13551d;

    /* compiled from: MINUTES */
    public class C15671 extends CollectionTitleClickEventSubscriber {
        final /* synthetic */ CollectionsSectionController f13547a;

        public C15671(CollectionsSectionController collectionsSectionController) {
            this.f13547a = collectionsSectionController;
        }

        public final void m14761b(FbEvent fbEvent) {
            CollectionTitleClickEvent collectionTitleClickEvent = (CollectionTitleClickEvent) fbEvent;
            Bundle bundle = collectionTitleClickEvent.f13141b == null ? new Bundle() : collectionTitleClickEvent.f13141b;
            CollectionsExtras.m13750a(bundle, collectionTitleClickEvent.f13142c, collectionTitleClickEvent.f13143d, collectionTitleClickEvent.f13144e, collectionTitleClickEvent.f13145f, this.f13547a.f13551d.c, this.f13547a.f13551d.d, collectionTitleClickEvent.f13146g);
            this.f13547a.f13548a.a(this.f13547a.f13550c, collectionTitleClickEvent.f13140a, bundle, null);
        }
    }

    @Inject
    public CollectionsSectionController(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, FbUriIntentHandler fbUriIntentHandler, CollectionsCurationController collectionsCurationController) {
        this.f13550c = context;
        this.f13551d = profileViewerContext;
        this.f13548a = fbUriIntentHandler;
        this.f13549b = collectionsCurationController;
    }
}

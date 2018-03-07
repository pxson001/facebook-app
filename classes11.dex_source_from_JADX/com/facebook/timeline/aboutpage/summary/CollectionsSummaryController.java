package com.facebook.timeline.aboutpage.summary;

import android.content.Context;
import android.os.Bundle;
import com.facebook.analytics.logger.ClickEventCreator;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.inject.Assisted;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.api.RelationshipType;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsCurationController;
import com.facebook.timeline.aboutpage.CollectionsExtras;
import com.facebook.timeline.aboutpage.DeleteExperienceController;
import com.facebook.timeline.aboutpage.DeleteExperienceController.C15441;
import com.facebook.timeline.aboutpage.RedirectToUriController;
import com.facebook.timeline.aboutpage.RedirectToUriController.C15521;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionTitleClickEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionTitleClickEventSubscriber;
import javax.inject.Inject;

/* compiled from: Lorg/apache/http/client/ResponseHandler */
public class CollectionsSummaryController {
    public final Context f13597a;
    public final ProfileViewerContext f13598b;
    public final CollectionsSummaryAnalyticsLogger f13599c;
    public final FbUriIntentHandler f13600d;
    private final CollectionsCurationController f13601e;
    private final RedirectToUriController f13602f;
    private final DeleteExperienceController f13603g;

    /* compiled from: Lorg/apache/http/client/ResponseHandler */
    class C15711 extends CollectionTitleClickEventSubscriber {
        final /* synthetic */ CollectionsSummaryController f13596a;

        C15711(CollectionsSummaryController collectionsSummaryController) {
            this.f13596a = collectionsSummaryController;
        }

        public final void m14801b(FbEvent fbEvent) {
            CollectionTitleClickEvent collectionTitleClickEvent = (CollectionTitleClickEvent) fbEvent;
            CollectionsAnalyticsLogger collectionsAnalyticsLogger = this.f13596a.f13599c;
            String str = this.f13596a.f13598b.a;
            RelationshipType a = CollectionsAnalyticsLogger.m13739a(this.f13596a.f13598b);
            HoneyClientEvent a2 = ClickEventCreator.a(collectionsAnalyticsLogger.mo370b(), "collection_title", collectionTitleClickEvent.f13144e.toString(), null);
            a2.b("profile_id", str);
            if (a != RelationshipType.UNDEFINED) {
                a2.a("relationship_type", a.getValue());
            }
            collectionsAnalyticsLogger.f12997a.a(a2);
            Bundle bundle = collectionTitleClickEvent.f13141b == null ? new Bundle() : collectionTitleClickEvent.f13141b;
            CollectionsExtras.m13750a(bundle, collectionTitleClickEvent.f13142c, collectionTitleClickEvent.f13143d, collectionTitleClickEvent.f13144e, collectionTitleClickEvent.f13145f, this.f13596a.f13598b.c, this.f13596a.f13598b.d, collectionTitleClickEvent.f13146g);
            this.f13596a.f13600d.a(this.f13596a.f13597a, collectionTitleClickEvent.f13140a, bundle, null);
        }
    }

    @Inject
    public CollectionsSummaryController(@Assisted Context context, @Assisted ProfileViewerContext profileViewerContext, @Assisted CollectionsSummaryAnalyticsLogger collectionsSummaryAnalyticsLogger, FbUriIntentHandler fbUriIntentHandler, CollectionsCurationController collectionsCurationController, RedirectToUriController redirectToUriController, DeleteExperienceController deleteExperienceController) {
        this.f13597a = context;
        this.f13598b = profileViewerContext;
        this.f13599c = collectionsSummaryAnalyticsLogger;
        this.f13600d = fbUriIntentHandler;
        this.f13601e = collectionsCurationController;
        this.f13602f = redirectToUriController;
        this.f13603g = deleteExperienceController;
    }

    public final void m14802a(FbEventSubscriberListManager fbEventSubscriberListManager, CollectionsSummaryFragment collectionsSummaryFragment) {
        fbEventSubscriberListManager.a(new C15711(this));
        this.f13601e.m13748a(this.f13597a, this.f13598b, fbEventSubscriberListManager);
        fbEventSubscriberListManager.a(new C15521(this.f13602f, this.f13597a));
        fbEventSubscriberListManager.a(new C15441(this.f13603g, collectionsSummaryFragment));
    }
}

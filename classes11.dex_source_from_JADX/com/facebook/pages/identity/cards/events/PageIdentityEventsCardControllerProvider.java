package com.facebook.pages.identity.cards.events;

import android.content.Context;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.mutators.SubscribeToPageEventsMutator;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLEventsCalendarSubscriptionStatus;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.collect.ImmutableList;

/* compiled from: privacy_checkup_intro_step_next */
public class PageIdentityEventsCardControllerProvider extends AbstractAssistedProvider<PageIdentityEventsCardController> {
    public final PageIdentityEventsCardController m4546a(Long l, String str, Boolean bool, GraphQLEventsCalendarSubscriptionStatus graphQLEventsCalendarSubscriptionStatus, ImmutableList<GraphQLEvent> immutableList, Context context) {
        return new PageIdentityEventsCardController(l, str, bool, graphQLEventsCalendarSubscriptionStatus, immutableList, context, FbUriIntentHandler.a(this), PagesAnalytics.a(this), TipSeenTracker.b(this), PageScopedEventBus.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(this), SubscribeToPageEventsMutator.b(this), GlyphColorizer.a(this));
    }
}

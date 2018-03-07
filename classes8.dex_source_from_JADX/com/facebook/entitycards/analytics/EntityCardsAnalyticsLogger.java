package com.facebook.entitycards.analytics;

import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardConfigDataType;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.DismissalReason;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.Events;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.TapSurfaces;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.logging.PYMKImpressionLogger;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import javax.inject.Inject;

/* compiled from: initialSlide */
public class EntityCardsAnalyticsLogger implements EntityCardConfigurationEventListener {
    private final AnalyticsLogger f10865a;
    public final Lazy<NavigationLogger> f10866b;
    private final String f10867c;
    private final String f10868d;
    private final Optional<String> f10869e;
    private final Optional<FriendingLocation> f10870f;
    private final String f10871g;
    private final WeakHashMap<EntityCardConfigurationEventListener, Boolean> f10872h;
    private final Lazy<PYMKImpressionLogger> f10873i;
    private final Set<String> f10874j;
    private final String f10875k;

    @Inject
    public EntityCardsAnalyticsLogger(AnalyticsLogger analyticsLogger, Clock clock, Lazy<NavigationLogger> lazy, Lazy<PYMKImpressionLogger> lazy2, Lazy<FbErrorReporter> lazy3, @Assisted String str, @Assisted String str2, @Assisted Optional<String> optional, @Assisted Optional<FriendingLocation> optional2) {
        boolean z;
        Preconditions.checkArgument(!StringUtil.a(str));
        if (StringUtil.a(str2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        this.f10865a = analyticsLogger;
        this.f10866b = lazy;
        this.f10867c = str;
        this.f10868d = str2;
        this.f10869e = optional;
        this.f10870f = optional2;
        this.f10871g = StringUtil.b("_", new Object[]{"entity_cards", this.f10868d});
        this.f10872h = new WeakHashMap();
        this.f10873i = lazy2;
        this.f10874j = new HashSet();
        this.f10875k = String.valueOf(clock.a());
        if (m12787b() && !optional2.isPresent()) {
            ((AbstractFbErrorReporter) lazy3.get()).b("entity_cards_missing_friending_location", "PYMK cards should have a present friending location");
        }
    }

    public static ImmutableMap<String, String> m12786a(String str, String str2, Optional<String> optional) {
        Builder builder = ImmutableMap.builder();
        builder.b("instance_id", str);
        builder.b("surface", str2);
        builder.b("surface_source_id", optional.isPresent() ? (String) optional.get() : "");
        return builder.b();
    }

    public final void m12792a(EntityCardConfigurationEventListener entityCardConfigurationEventListener) {
        this.f10872h.put(entityCardConfigurationEventListener, Boolean.TRUE);
    }

    public final void m12799b(EntityCardConfigurationEventListener entityCardConfigurationEventListener) {
        this.f10872h.remove(entityCardConfigurationEventListener);
    }

    public final void mo770a(CardSurfaceConfigEvent cardSurfaceConfigEvent, EventStatus eventStatus, String str) {
        for (EntityCardConfigurationEventListener a : this.f10872h.keySet()) {
            a.mo770a(cardSurfaceConfigEvent, eventStatus, str);
        }
    }

    public final void mo769a(CardConfigDataType cardConfigDataType) {
        for (EntityCardConfigurationEventListener a : this.f10872h.keySet()) {
            a.mo769a(cardConfigDataType);
        }
    }

    public final void m12795a(TapSurfaces tapSurfaces, String str, Optional<String> optional, Optional<Integer> optional2) {
        if (tapSurfaces == TapSurfaces.ACTION_BAR || tapSurfaces == TapSurfaces.CONTEXT_ITEM) {
            Preconditions.checkArgument(optional.isPresent());
            Preconditions.checkArgument(optional2.isPresent());
        }
        HoneyClientEvent a = m12785a(Events.TAP);
        a.b("identifier", str);
        a.b("tap_action_surface", tapSurfaces.name);
        if (optional.isPresent()) {
            a.b("target_type", (String) optional.get());
        }
        if (optional2.isPresent()) {
            a.b("position", String.valueOf(optional2.get()));
        }
        this.f10865a.a(a);
    }

    public final void m12796a(String str) {
        ((NavigationLogger) this.f10866b.get()).a("tap_entity_card");
        m12794a(Events.ENTITY_CARDS_NAVIGATED_TO_ENTITY, Optional.of(str));
    }

    public final void m12798a(boolean z, int i) {
        HoneyClientEvent a = m12785a(Events.ENTITY_CARDS_PAGE_DOWNLOAD);
        a.b("query_success", String.valueOf(z));
        a.b("entity_count", String.valueOf(i));
        this.f10865a.a(a);
    }

    public final void m12797a(String str, double d) {
        Preconditions.checkArgument(!StringUtil.a(str));
        HoneyClientEvent a = m12785a(Events.ENTITY_CARDS_IMPRESSION);
        a.b("identifier", str);
        a.a("visible_interval", d);
        this.f10865a.a(a);
        if (m12788c(str) && this.f10870f.isPresent()) {
            ((PYMKImpressionLogger) this.f10873i.get()).a(Long.parseLong(str), PeopleYouMayKnowLocation.ENTITY_CARDS, ((FriendingLocation) this.f10870f.get()).peopleYouMayKnowLocation, this.f10875k);
            this.f10874j.add(str);
        }
    }

    public final void m12793a(DismissalReason dismissalReason) {
        if (dismissalReason == DismissalReason.SWIPE_DOWN) {
            ((NavigationLogger) this.f10866b.get()).a("swipe");
        }
        HoneyClientEvent a = m12785a(Events.ENTITY_CARDS_DISMISSED);
        a.b("reason", dismissalReason.name);
        this.f10865a.a(a);
    }

    public final void m12794a(Events events, Optional<String> optional) {
        HoneyClientEvent a = m12785a(events);
        if (optional.isPresent()) {
            a.b("identifier", (String) optional.get());
        }
        this.f10865a.a(a);
    }

    public final String m12789a() {
        return this.f10871g;
    }

    private HoneyClientEvent m12785a(Events events) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(events.name);
        honeyClientEvent.c = "entity_cards";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.f = this.f10867c;
        HoneyClientEvent honeyClientEvent2 = honeyClientEvent;
        honeyClientEvent2.b("instance_id", this.f10867c);
        honeyClientEvent2.b("surface", this.f10868d);
        honeyClientEvent2.b("surface_source_id", (String) this.f10869e.orNull());
        return honeyClientEvent2;
    }

    private boolean m12788c(String str) {
        return m12787b() && !this.f10874j.contains(str);
    }

    private boolean m12787b() {
        return "pymk".equals(this.f10869e.orNull());
    }
}

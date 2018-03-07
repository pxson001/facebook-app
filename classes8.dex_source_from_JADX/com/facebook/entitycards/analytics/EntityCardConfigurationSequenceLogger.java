package com.facebook.entitycards.analytics;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.facebook.common.time.MonotonicClock;
import com.facebook.entitycards.EntityCardsAdapter;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardConfigDataType;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.intent.EntityCardsActivity;
import com.facebook.entitycards.intent.EntityCardsFragment;
import com.facebook.entitycards.model.EntityCardsPagerAdapter;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.inject.Assisted;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: initial_fetch */
public class EntityCardConfigurationSequenceLogger extends SimpleOnPageChangeListener implements EntityCardConfigurationEventListener {
    public static final EntityCardConfigured f10855a = new EntityCardConfigured();
    private static final ImmutableList<CardSurfaceConfigEvent> f10856b = ImmutableList.of(CardSurfaceConfigEvent.COVER_PHOTO, CardSurfaceConfigEvent.PROFILE_PICTURE, CardSurfaceConfigEvent.ACTION_BAR, CardSurfaceConfigEvent.CONTEXT_ROWS);
    public final EntityCardsAdapter f10857c;
    private final SequenceLogger f10858d;
    private final MonotonicClock f10859e;
    public final ImmutableMap<String, String> f10860f;
    public final ImmutableSet<String> f10861g;
    private final Map<String, Set<CardSurfaceConfigEvent>> f10862h = Maps.c();
    private String f10863i;
    private boolean f10864j = true;

    /* compiled from: initial_fetch */
    final class EntityCardConfigured extends AbstractSequenceDefinition {
        public EntityCardConfigured() {
            super(1048577, "ec_card_configuration_wait_time", false, ImmutableSet.of(EntityCardsActivity.class.getName(), EntityCardsFragment.class.getName()));
        }
    }

    /* compiled from: initial_fetch */
    public enum Outcome {
        CARD_SCROLLED_AWAY("ec_card_scrolled"),
        SUCCEEDED("ec_success");
        
        public final String name;

        private Outcome(String str) {
            this.name = str;
        }
    }

    @Inject
    public EntityCardConfigurationSequenceLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock, @Assisted EntityCardsPagerAdapter entityCardsPagerAdapter, @Assisted String str, @Assisted String str2, @Assisted Optional<String> optional, @Assisted List<String> list) {
        this.f10857c = entityCardsPagerAdapter;
        this.f10858d = sequenceLogger;
        this.f10859e = monotonicClock;
        this.f10860f = EntityCardsAnalyticsLogger.m12786a(str, str2, (Optional) optional);
        this.f10861g = ImmutableSet.copyOf(list);
    }

    public final void mo770a(CardSurfaceConfigEvent cardSurfaceConfigEvent, EventStatus eventStatus, String str) {
        if (cardSurfaceConfigEvent == CardSurfaceConfigEvent.CARD_RECYCLED) {
            this.f10862h.remove(str);
        } else if (f10856b.contains(cardSurfaceConfigEvent) && !this.f10864j) {
            Set set = (Set) this.f10862h.get(str);
            if (set == null) {
                set = Sets.a();
                this.f10862h.put(str, set);
            }
            set.add(cardSurfaceConfigEvent);
            if (this.f10863i != null && this.f10863i.equals(str)) {
                Sequence b = this.f10858d.b(f10855a, this.f10863i);
                if (b != null && b.f(cardSurfaceConfigEvent.name)) {
                    SequenceLoggerDetour.b(b, cardSurfaceConfigEvent.name, -1492899618);
                }
                if (set.size() == f10856b.size()) {
                    m12780a(this.f10863i, Outcome.SUCCEEDED);
                }
            }
        }
    }

    public final void mo769a(CardConfigDataType cardConfigDataType) {
        if (cardConfigDataType == CardConfigDataType.FINAL) {
            this.f10864j = false;
        }
    }

    public final void e_(int i) {
        String str;
        if (i >= this.f10857c.m12770b()) {
            str = null;
        } else {
            Object e = this.f10857c.m12774e(i);
            if (e == null || !(e instanceof GraphQLPersistableNode)) {
                str = null;
            } else {
                str = ((GraphQLPersistableNode) e).a();
            }
        }
        String str2 = str;
        if (str2 == null || !str2.equals(this.f10863i)) {
            m12781b(this.f10863i);
            this.f10863i = str2;
            m12779a(this.f10863i);
        }
    }

    private void m12779a(String str) {
        if (str != null) {
            this.f10858d.a(f10855a, str, this.f10860f, this.f10859e.now());
            Sequence b = this.f10858d.b(f10855a, str);
            if (b != null) {
                int size = f10856b.size();
                for (int i = 0; i < size; i++) {
                    SequenceLoggerDetour.a(b, ((CardSurfaceConfigEvent) f10856b.get(i)).name, 259009353);
                }
                Set<CardSurfaceConfigEvent> set = (Set) this.f10862h.get(str);
                if (set != null) {
                    for (CardSurfaceConfigEvent cardSurfaceConfigEvent : set) {
                        SequenceLoggerDetour.b(b, cardSurfaceConfigEvent.name, 1997191803);
                    }
                    if (set.size() == f10856b.size()) {
                        m12780a(str, Outcome.SUCCEEDED);
                    }
                }
            }
        }
    }

    private void m12780a(String str, Outcome outcome) {
        if (str != null && this.f10858d.b(f10855a, str) != null) {
            SequenceLogger sequenceLogger = this.f10858d;
            EntityCardConfigured entityCardConfigured = f10855a;
            Builder builder = ImmutableMap.builder();
            builder.a(this.f10860f);
            builder.b("reason", outcome.name);
            builder.b("fbid", str);
            Boolean bool = Boolean.TRUE;
            builder.b("initial_card", Boolean.toString(this.f10861g.contains(str)));
            sequenceLogger.b(entityCardConfigured, str, builder.b(), this.f10859e.now());
        }
    }

    private void m12781b(String str) {
        if (str != null) {
            Sequence b = this.f10858d.b(f10855a, str);
            if (b != null) {
                int size = f10856b.size();
                for (int i = 0; i < size; i++) {
                    CardSurfaceConfigEvent cardSurfaceConfigEvent = (CardSurfaceConfigEvent) f10856b.get(i);
                    if (b.f(cardSurfaceConfigEvent.name)) {
                        SequenceLoggerDetour.c(b, cardSurfaceConfigEvent.name, 1714264332);
                    }
                }
                m12780a(str, Outcome.CARD_SCROLLED_AWAY);
            }
        }
    }
}

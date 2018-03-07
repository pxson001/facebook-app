package com.facebook.entitycards.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardConfigDataType;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.CardSurfaceConfigEvent;
import com.facebook.entitycards.analytics.EntityCardConfigurationEventListener.EventStatus;
import com.facebook.entitycards.intent.EntityCardsActivity;
import com.facebook.entitycards.intent.EntityCardsFragment;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: init called more than once */
public class EntityCardsInitialCardsSequenceLogger implements EntityCardConfigurationEventListener {
    public static final EntityCardsInitialCardsLoaded f10882a = new EntityCardsInitialCardsLoaded();
    private static volatile EntityCardsInitialCardsSequenceLogger f10883h;
    private final SequenceLogger f10884b;
    private final MonotonicClock f10885c;
    public ImmutableMap<String, String> f10886d;
    public String f10887e;
    public boolean f10888f;
    public final EnumMap<CardSurfaceConfigEvent, Span> f10889g = new EnumMap(CardSurfaceConfigEvent.class);

    /* compiled from: init called more than once */
    final class EntityCardsInitialCardsLoaded extends AbstractSequenceDefinition {
        public EntityCardsInitialCardsLoaded() {
            super(1048578, "ec_initial_cards_loaded", false, ImmutableSet.of(EntityCardsActivity.class.getName(), EntityCardsFragment.class.getName()));
        }
    }

    /* compiled from: init called more than once */
    public enum Event {
        ADAPTER_UDPATED("ec_adapter_updated"),
        PREVIEW_DATA_AVAILABLE("ec_preview_data_available"),
        FINAL_DATA_AVAILABLE("ec_final_data_available"),
        INTRO_ANIMATION_END("ec_intro_animation_end");
        
        public final String name;

        private Event(String str) {
            this.name = str;
        }
    }

    /* compiled from: init called more than once */
    public enum Span {
        LAUNCH_ENTITY_CARD("ec_launch"),
        ACTIVITY_CREATE("ec_activity_create"),
        FRAGMENT_CREATE("ec_fragment_create"),
        INTRO_ANIMATION("ec_intro_animation"),
        INITIAL_ENTITIES_FETCHED("ec_initial_entities_fetched"),
        INITIAL_CARD_COVER_PHOTO("ec_initial_card_cover_photo_configured"),
        INITIAL_CARD_PROFILE_PICTURE("ec_initial_card_profile_picture_configured"),
        INITIAL_CARD_ACTION_BAR("ec_initial_card_action_bar_configured"),
        INITIAL_CARD_CONTEXT_ROWS("ec_initial_card_context_rows_configured");
        
        public final String name;

        private Span(String str) {
            this.name = str;
        }
    }

    public static com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger m12807a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10883h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.class;
        monitor-enter(r1);
        r0 = f10883h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m12809b(r0);	 Catch:{ all -> 0x0035 }
        f10883h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10883h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger");
    }

    private static EntityCardsInitialCardsSequenceLogger m12809b(InjectorLike injectorLike) {
        return new EntityCardsInitialCardsSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EntityCardsInitialCardsSequenceLogger(SequenceLogger sequenceLogger, MonotonicClock monotonicClock) {
        this.f10884b = sequenceLogger;
        this.f10885c = monotonicClock;
    }

    public final void m12818a(String str, String str2, Optional<String> optional, String str3) {
        if (m12812d() != null) {
            m12808a();
        }
        this.f10886d = EntityCardsAnalyticsLogger.m12786a(str, str2, (Optional) optional);
        this.f10887e = str3;
        this.f10888f = false;
        this.f10889g.clear();
        this.f10889g.put(CardSurfaceConfigEvent.COVER_PHOTO, Span.INITIAL_CARD_COVER_PHOTO);
        this.f10889g.put(CardSurfaceConfigEvent.PROFILE_PICTURE, Span.INITIAL_CARD_PROFILE_PICTURE);
        this.f10889g.put(CardSurfaceConfigEvent.ACTION_BAR, Span.INITIAL_CARD_ACTION_BAR);
        this.f10889g.put(CardSurfaceConfigEvent.CONTEXT_ROWS, Span.INITIAL_CARD_CONTEXT_ROWS);
        this.f10884b.a(f10882a, str, this.f10886d, this.f10885c.now());
    }

    private void m12808a() {
        String d = m12812d();
        if (d != null) {
            this.f10884b.a(f10882a, d);
            this.f10886d = null;
            this.f10887e = null;
        }
    }

    private void m12810b() {
        if (m12811c()) {
            String d = m12812d();
            Preconditions.checkNotNull(d);
            m12819b(Span.LAUNCH_ENTITY_CARD);
            this.f10884b.b(f10882a, d, this.f10886d, this.f10885c.now());
            this.f10886d = null;
            this.f10887e = null;
        }
    }

    private boolean m12811c() {
        Sequence e = m12813e();
        if (e == null || !this.f10889g.isEmpty() || e.f(Span.INITIAL_ENTITIES_FETCHED.name)) {
            return false;
        }
        return true;
    }

    public final void m12817a(Span span) {
        Sequence e = m12813e();
        if (e != null) {
            SequenceLoggerDetour.a(e, span.name, -390554575);
        }
    }

    public final void m12819b(Span span) {
        Sequence e = m12813e();
        if (e != null) {
            SequenceLoggerDetour.b(e, span.name, -1551670943);
            if (span == Span.INITIAL_ENTITIES_FETCHED) {
                m12810b();
            }
        }
    }

    public final void m12820c(Span span) {
        Sequence e = m12813e();
        if (e != null) {
            SequenceLoggerDetour.c(e, span.name, -1075362463);
            if (span == Span.INITIAL_ENTITIES_FETCHED) {
                m12808a();
            }
        }
    }

    public final void m12816a(Event event) {
        Sequence e = m12813e();
        if (e != null) {
            SequenceLoggerDetour.e(e, event.name, 66633609);
            if (event.equals(Event.FINAL_DATA_AVAILABLE)) {
                this.f10888f = true;
            }
        }
    }

    public final void mo770a(CardSurfaceConfigEvent cardSurfaceConfigEvent, EventStatus eventStatus, String str) {
        if (m12813e() != null && this.f10887e != null && this.f10887e.equals(str)) {
            if (eventStatus == EventStatus.FAILED) {
                m12808a();
            } else if (cardSurfaceConfigEvent == CardSurfaceConfigEvent.BEGIN_CARD_CONFIG) {
                for (Span a : this.f10889g.values()) {
                    m12817a(a);
                }
            } else if (cardSurfaceConfigEvent == CardSurfaceConfigEvent.CARD_RECYCLED) {
                for (Span a2 : this.f10889g.values()) {
                    m12820c(a2);
                }
                this.f10889g.clear();
                m12810b();
            } else if (this.f10888f) {
                a2 = (Span) this.f10889g.get(cardSurfaceConfigEvent);
                if (a2 != null) {
                    m12819b(a2);
                    this.f10889g.remove(cardSurfaceConfigEvent);
                    m12810b();
                }
            }
        }
    }

    public final void mo769a(CardConfigDataType cardConfigDataType) {
        if (cardConfigDataType == CardConfigDataType.PREVIEW) {
            m12816a(Event.PREVIEW_DATA_AVAILABLE);
        } else if (cardConfigDataType == CardConfigDataType.FINAL) {
            m12816a(Event.FINAL_DATA_AVAILABLE);
        }
    }

    private String m12812d() {
        return this.f10886d != null ? (String) this.f10886d.get("instance_id") : null;
    }

    private Sequence<EntityCardsInitialCardsLoaded> m12813e() {
        String d = m12812d();
        if (d == null) {
            return null;
        }
        return this.f10884b.b(f10882a, d);
    }
}

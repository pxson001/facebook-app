package com.facebook.pages.common.sequencelogger;

import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: creative_cam_result_extra */
public class PagesSequenceLoggerHelper {
    public final SequenceLogger f16603a;
    private final InteractionTTILogger f16604b;

    public static PagesSequenceLoggerHelper m19632b(InjectorLike injectorLike) {
        return new PagesSequenceLoggerHelper((SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public PagesSequenceLoggerHelper(SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger) {
        this.f16603a = sequenceLogger;
        this.f16604b = interactionTTILogger;
    }

    public final void m19635b(AbstractSequenceDefinition abstractSequenceDefinition) {
        this.f16604b.a(abstractSequenceDefinition);
    }

    public final void m19634a(String str, AbstractSequenceDefinition abstractSequenceDefinition) {
        Sequence e = this.f16603a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, -80348170);
        }
    }

    public static PagesSequenceLoggerHelper m19631a(InjectorLike injectorLike) {
        return m19632b(injectorLike);
    }

    public final void m19636b(String str, AbstractSequenceDefinition abstractSequenceDefinition) {
        Sequence e = this.f16603a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, -1449212632);
        }
    }

    public final void m19638c(String str, AbstractSequenceDefinition abstractSequenceDefinition) {
        Sequence e = this.f16603a.e(abstractSequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.d(e, str, 985138164);
        }
    }

    public final void m19633a(SequenceDefinition sequenceDefinition, @Nullable ImmutableMap<String, String> immutableMap) {
        InteractionTTILogger interactionTTILogger = this.f16604b;
        Sequence e = interactionTTILogger.g.e(sequenceDefinition);
        if (e != null) {
            SequenceLoggerDetour.b(e, "LegacyMarker", -1393542626);
            interactionTTILogger.g.b(sequenceDefinition, immutableMap);
        }
    }

    public final void m19637c(AbstractSequenceDefinition abstractSequenceDefinition) {
        if (this.f16603a.e(abstractSequenceDefinition) != null) {
            this.f16603a.d(abstractSequenceDefinition);
        }
    }
}

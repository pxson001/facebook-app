package com.facebook.video.server.prefetcher;

import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.video.analytics.PrefetchItemSequence;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

/* compiled from: TE; */
public class PrefetchItemSequenceLogger {
    public final SequenceLogger f363a;
    private final Handler f364b = new Handler(this);

    /* compiled from: TE; */
    public class Handler implements TypedHandler {
        public final /* synthetic */ PrefetchItemSequenceLogger f366a;
        public int f367b = -1;
        public Sequence<PrefetchItemSequence> f368c;
        public long f369d;

        public Handler(PrefetchItemSequenceLogger prefetchItemSequenceLogger) {
            this.f366a = prefetchItemSequenceLogger;
        }

        private boolean m329a(PrefetchEvents$BasePrefetchEvent<?> prefetchEvents$BasePrefetchEvent) {
            return this.f368c != null && this.f367b == prefetchEvents$BasePrefetchEvent.f371a;
        }

        public final void m333a(PrefetchEvents$RetrieveMetadataBeginEvent prefetchEvents$RetrieveMetadataBeginEvent) {
            if (m329a((PrefetchEvents$BasePrefetchEvent) prefetchEvents$RetrieveMetadataBeginEvent)) {
                SequenceLoggerDetour.a(this.f368c, "RetrieveMetadata", 2000574735);
            }
        }

        public final void m334a(PrefetchEvents$RetrieveMetadataEndEvent prefetchEvents$RetrieveMetadataEndEvent) {
            if (m329a((PrefetchEvents$BasePrefetchEvent) prefetchEvents$RetrieveMetadataEndEvent)) {
                SequenceLoggerDetour.b(this.f368c, "RetrieveMetadata", 1713187749);
            }
        }

        public final void m331a(PrefetchEvents$PrefetchRangeBeginEvent prefetchEvents$PrefetchRangeBeginEvent) {
            if (m329a((PrefetchEvents$BasePrefetchEvent) prefetchEvents$PrefetchRangeBeginEvent)) {
                SequenceLoggerDetour.a(this.f368c, "PrefetchRange", 1227713788);
            }
        }

        public final void m332a(PrefetchEvents$PrefetchRangeEndEvent prefetchEvents$PrefetchRangeEndEvent) {
            if (m329a((PrefetchEvents$BasePrefetchEvent) prefetchEvents$PrefetchRangeEndEvent)) {
                this.f369d += prefetchEvents$PrefetchRangeEndEvent.f373b;
                SequenceLoggerDetour.b(this.f368c, "PrefetchRange", null, m328a(prefetchEvents$PrefetchRangeEndEvent.f373b), 389931328);
            }
        }

        private static ImmutableMap<String, String> m328a(long j) {
            return ImmutableBiMap.b("bytes_written", String.valueOf(j));
        }

        public final void m330a(PrefetchEvents$PrefetchItemEndEvent prefetchEvents$PrefetchItemEndEvent) {
            if (m329a((PrefetchEvents$BasePrefetchEvent) prefetchEvents$PrefetchItemEndEvent)) {
                this.f366a.f363a.b(PrefetchItemSequence.a, m328a(this.f369d));
                this.f368c = null;
                this.f367b = -1;
            }
        }
    }

    public PrefetchItemSequenceLogger(SequenceLogger sequenceLogger) {
        this.f363a = sequenceLogger;
    }

    public final void m327a(TypedEventBus typedEventBus) {
        typedEventBus.a(PrefetchEvents$PrefetchItemBeginEvent.class, this.f364b);
        typedEventBus.a(PrefetchEvents$PrefetchItemEndEvent.class, this.f364b);
        typedEventBus.a(PrefetchEvents$PrefetchRangeBeginEvent.class, this.f364b);
        typedEventBus.a(PrefetchEvents$PrefetchRangeEndEvent.class, this.f364b);
        typedEventBus.a(PrefetchEvents$RetrieveMetadataBeginEvent.class, this.f364b);
        typedEventBus.a(PrefetchEvents$RetrieveMetadataEndEvent.class, this.f364b);
    }
}

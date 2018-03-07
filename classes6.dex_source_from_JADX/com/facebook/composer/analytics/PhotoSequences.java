package com.facebook.composer.analytics;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

/* compiled from: place_picker_minutiae_to_place_select */
public class PhotoSequences {
    public static final PhotoLoadSequence f7788a = new PhotoLoadSequence();
    public final SequenceLogger f7789b;
    public final MonotonicClock f7790c;

    /* compiled from: place_picker_minutiae_to_place_select */
    final class PhotoLoadSequence extends AbstractSequenceDefinition {
        public PhotoLoadSequence() {
            super(917506, "PhotoLoadSequence", false, ImmutableSet.of("com.facebook.composer.ui.underwood.VerticalAttachmentView", "com.facebook.composer.activity.ComposerFragment"));
        }
    }

    public static PhotoSequences m11165b(InjectorLike injectorLike) {
        return new PhotoSequences((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoSequences(SequenceLogger sequenceLogger, MonotonicClock monotonicClock) {
        this.f7789b = sequenceLogger;
        this.f7790c = monotonicClock;
    }

    public static PhotoSequences m11164a(InjectorLike injectorLike) {
        return m11165b(injectorLike);
    }

    public final void m11166a(String str, long j, int i, int i2, int i3, boolean z) {
        Optional fromNullable = Optional.fromNullable(this.f7789b.b(f7788a, str));
        if (fromNullable.isPresent()) {
            SequenceLoggerDetour.a((Sequence) fromNullable.get(), "loadPhoto", String.valueOf(j), ImmutableMap.of("index", String.valueOf(i), "bm_width", String.valueOf(i2), "bm_height", String.valueOf(i3), "is_video", String.valueOf(z)), this.f7790c.now(), -308112773);
        }
    }

    public final void m11167b(String str, long j) {
        Optional fromNullable = Optional.fromNullable(this.f7789b.b(f7788a, str));
        if (fromNullable.isPresent()) {
            SequenceLoggerDetour.a((Sequence) fromNullable.get(), "loadTopPhoto", String.valueOf(j), ImmutableBiMap.b("media_id", String.valueOf(j)), this.f7790c.now(), -426007653);
        }
    }

    public final void m11168c(String str, long j) {
        Optional fromNullable = Optional.fromNullable(this.f7789b.b(f7788a, str));
        if (fromNullable.isPresent()) {
            SequenceLoggerDetour.b((Sequence) fromNullable.get(), "loadTopPhoto", String.valueOf(j), null, this.f7790c.now(), -1721183998);
        }
    }
}

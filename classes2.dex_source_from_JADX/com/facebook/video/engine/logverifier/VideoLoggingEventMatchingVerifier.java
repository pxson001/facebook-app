package com.facebook.video.engine.logverifier;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: isGetterVisibility */
public class VideoLoggingEventMatchingVerifier {
    private final MonotonicClock f19387a;
    private final Map<String, PlayEventEntry> f19388b = Maps.m838c();
    private boolean f19389c;

    public static VideoLoggingEventMatchingVerifier m27099a(InjectorLike injectorLike) {
        return new VideoLoggingEventMatchingVerifier(AwakeTimeSinceBootClockMethodAutoProvider.m1697a(injectorLike));
    }

    @Inject
    public VideoLoggingEventMatchingVerifier(MonotonicClock monotonicClock) {
        this.f19387a = monotonicClock;
        this.f19389c = false;
    }

    public final boolean m27101a(String str, String str2, String str3, String str4) {
        if (this.f19389c) {
            return false;
        }
        boolean z;
        PlayEventEntry playEventEntry = (PlayEventEntry) this.f19388b.get(str);
        this.f19388b.put(str, new PlayEventEntry(str, str2, str3, str4, Long.valueOf(this.f19387a.now())));
        if (this.f19388b.size() >= 25) {
            z = true;
        } else {
            z = false;
        }
        this.f19389c = z;
        if (playEventEntry == null) {
            return true;
        }
        return false;
    }

    public final boolean m27100a(String str) {
        PlayEventEntry playEventEntry = (PlayEventEntry) this.f19388b.remove(str);
        if (this.f19388b.size() == 0) {
            this.f19389c = false;
        }
        return playEventEntry != null;
    }

    public final void m27102b(String str) {
        this.f19388b.remove(str);
    }

    public final boolean m27103c(String str) {
        return this.f19388b.containsKey(str);
    }
}

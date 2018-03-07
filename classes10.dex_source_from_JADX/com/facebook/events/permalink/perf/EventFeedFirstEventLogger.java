package com.facebook.events.permalink.perf;

import com.facebook.events.permalink.perf.EventPermalinkSequenceLogger.LoadingState;

/* compiled from: com.facebook.common.errorreporting.memory.MemoryDumpHandler.uncaughtException */
public class EventFeedFirstEventLogger {
    public final EventPermalinkSequenceLogger f17342a;
    public final LoadingState f17343b;
    private boolean f17344c;
    public boolean f17345d;

    public EventFeedFirstEventLogger(EventPermalinkSequenceLogger eventPermalinkSequenceLogger, LoadingState loadingState) {
        this.f17342a = eventPermalinkSequenceLogger;
        this.f17343b = loadingState;
    }

    public final void m17664a() {
        if (!this.f17344c) {
            this.f17344c = true;
            this.f17342a.m19076a(this.f17343b);
        }
    }

    public final void m17665b() {
        if (!this.f17345d) {
            this.f17345d = true;
            this.f17342a.m19083c(this.f17343b);
        }
    }
}

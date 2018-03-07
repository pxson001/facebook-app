package com.facebook.proxygen;

/* compiled from: node_id */
public class RequestStatsObserver implements TraceEventObserver {
    private TraceEvent[] mEvents;

    public void traceEventAvailable(TraceEvent[] traceEventArr) {
        this.mEvents = traceEventArr;
    }

    public RequestStats getRequestStats() {
        if (this.mEvents == null || this.mEvents.length == 0) {
            return null;
        }
        return new RequestStats(this.mEvents);
    }
}

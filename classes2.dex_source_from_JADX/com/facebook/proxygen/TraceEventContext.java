package com.facebook.proxygen;

import java.util.Random;

/* compiled from: publishEditPostParamsKey */
public class TraceEventContext {
    private static final Random RAND = new Random();
    private TraceEventObserver[] mObservers;
    private int mParentID;
    private final SamplePolicy mSamplePolicy;

    public TraceEventContext(TraceEventObserver[] traceEventObserverArr) {
        this(traceEventObserverArr, new 1());
    }

    public TraceEventContext(SamplePolicy samplePolicy) {
        this(new TraceEventObserver[0], samplePolicy);
    }

    public TraceEventContext(TraceEventObserver[] traceEventObserverArr, SamplePolicy samplePolicy) {
        this.mParentID = RAND.nextInt();
        this.mObservers = traceEventObserverArr;
        this.mSamplePolicy = samplePolicy;
    }

    public int getParentID() {
        return this.mParentID;
    }

    public void informAllObservers(TraceEvent[] traceEventArr) {
        for (TraceEventObserver traceEventAvailable : this.mObservers) {
            traceEventAvailable.traceEventAvailable(traceEventArr);
        }
    }

    public boolean needPublishEvent() {
        return this.mSamplePolicy.isSampled();
    }
}

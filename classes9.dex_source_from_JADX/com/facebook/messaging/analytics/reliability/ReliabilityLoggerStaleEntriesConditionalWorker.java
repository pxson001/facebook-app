package com.facebook.messaging.analytics.reliability;

import com.facebook.conditionalworker.ConditionalWorker;
import com.facebook.conditionalworker.ConditionalWorkerRunner;
import javax.inject.Inject;

/* compiled from: p2p_history_get_fail */
public class ReliabilityLoggerStaleEntriesConditionalWorker implements ConditionalWorker {
    private final AggregatedReliabilityLogger f7660a;

    @Inject
    public ReliabilityLoggerStaleEntriesConditionalWorker(AggregatedReliabilityLogger aggregatedReliabilityLogger) {
        this.f7660a = aggregatedReliabilityLogger;
    }

    public final boolean m7959a(ConditionalWorkerRunner conditionalWorkerRunner) {
        this.f7660a.a();
        return true;
    }
}

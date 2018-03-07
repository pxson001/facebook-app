package com.facebook.messaging.analytics.reliability;

import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;

@VisibleForTesting
/* compiled from: p2p_history_get_request */
public class AggregatedReliabilityLogger$ReliabilityInfo implements Serializable {
    public int graphAttempts = 0;
    final String messageType;
    public int mqttAttempts = 0;
    public Outcome outcome = Outcome.UNKNOWN;
    final long sendAttemptTimestamp;
    long timeSinceFirstSendAttempt = -1;

    /* compiled from: p2p_history_get_request */
    public enum Outcome {
        UNKNOWN("u"),
        SUCCESS_MQTT("m"),
        SUCCESS_GRAPH("g"),
        FAILURE_RETRYABLE("f"),
        FAILURE_PERMANENT("p");
        
        public final String rawValue;

        private Outcome(String str) {
            this.rawValue = str;
        }
    }

    AggregatedReliabilityLogger$ReliabilityInfo(long j, String str) {
        this.sendAttemptTimestamp = j;
        this.messageType = str;
    }
}

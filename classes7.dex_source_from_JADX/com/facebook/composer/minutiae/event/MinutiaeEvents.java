package com.facebook.composer.minutiae.event;

import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.content.event.FbEvent;
import com.google.common.collect.ImmutableList;

/* compiled from: tooltipTitle */
public class MinutiaeEvents {

    /* compiled from: tooltipTitle */
    public abstract class MinutiaeEvent implements FbEvent {
    }

    /* compiled from: tooltipTitle */
    public class RidgeDisabledEvent extends MinutiaeEvent {
    }

    /* compiled from: tooltipTitle */
    public class RidgeEnabledEvent extends MinutiaeEvent {
    }

    /* compiled from: tooltipTitle */
    public class RidgeFailedEvent extends MinutiaeEvent {
        public final ErrorCode f1522a;

        public RidgeFailedEvent(ErrorCode errorCode) {
            this.f1522a = errorCode;
        }
    }

    /* compiled from: tooltipTitle */
    public class RidgeRefreshEvent extends MinutiaeEvent {
    }

    /* compiled from: tooltipTitle */
    public class RidgeResultsFoundEvent extends MinutiaeEvent {
        public final ImmutableList<? extends MinutiaeTaggableSuggestions> f1523a;

        public RidgeResultsFoundEvent(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList) {
            this.f1523a = immutableList;
        }
    }
}

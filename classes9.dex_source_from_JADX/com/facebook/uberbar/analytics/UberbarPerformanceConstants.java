package com.facebook.uberbar.analytics;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: transaction_payment_card_id */
public class UberbarPerformanceConstants {
    public static final UberbarNetworkFetchSequence f1400a = new UberbarNetworkFetchSequence();
    public static final UberbarLocalFetchSequence f1401b = new UberbarLocalFetchSequence();

    /* compiled from: transaction_payment_card_id */
    class UberbarLocalFetchSequence extends AbstractSequenceDefinition {
        public UberbarLocalFetchSequence() {
            super(1769474, "UberbarLocalResultsFetch", false, RegularImmutableSet.a);
        }
    }

    /* compiled from: transaction_payment_card_id */
    class UberbarNetworkFetchSequence extends AbstractSequenceDefinition {
        public UberbarNetworkFetchSequence() {
            super(1769473, "UberbarNetworkResultFetch", false, RegularImmutableSet.a);
        }
    }
}

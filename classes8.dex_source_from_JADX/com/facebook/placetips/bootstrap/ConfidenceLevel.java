package com.facebook.placetips.bootstrap;

import com.facebook.graphql.enums.GraphQLBeaconScanResultConfidenceLevel;
import com.facebook.graphql.enums.GraphQLPlaceSuggestionConfidenceLevel;
import javax.annotation.Nullable;

/* compiled from: search_semantic */
public enum ConfidenceLevel {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    UNKNOWN(-1);
    
    private final int mLevel;

    /* compiled from: search_semantic */
    /* synthetic */ class C04901 {
        static final /* synthetic */ int[] f3820a = null;
        static final /* synthetic */ int[] f3821b = null;

        static {
            f3821b = new int[GraphQLPlaceSuggestionConfidenceLevel.values().length];
            try {
                f3821b[GraphQLPlaceSuggestionConfidenceLevel.CONFIDENCE_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3821b[GraphQLPlaceSuggestionConfidenceLevel.CONFIDENCE_MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3821b[GraphQLPlaceSuggestionConfidenceLevel.CONFIDENCE_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f3820a = new int[GraphQLBeaconScanResultConfidenceLevel.values().length];
            try {
                f3820a[GraphQLBeaconScanResultConfidenceLevel.CONFIDENCE_LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3820a[GraphQLBeaconScanResultConfidenceLevel.CONFIDENCE_MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3820a[GraphQLBeaconScanResultConfidenceLevel.CONFIDENCE_HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static ConfidenceLevel from(@Nullable GraphQLBeaconScanResultConfidenceLevel graphQLBeaconScanResultConfidenceLevel) {
        if (graphQLBeaconScanResultConfidenceLevel == null) {
            return UNKNOWN;
        }
        switch (C04901.f3820a[graphQLBeaconScanResultConfidenceLevel.ordinal()]) {
            case 1:
                return LOW;
            case 2:
                return MEDIUM;
            case 3:
                return HIGH;
            default:
                return UNKNOWN;
        }
    }

    public static ConfidenceLevel from(@Nullable GraphQLPlaceSuggestionConfidenceLevel graphQLPlaceSuggestionConfidenceLevel) {
        if (graphQLPlaceSuggestionConfidenceLevel == null) {
            return UNKNOWN;
        }
        switch (C04901.f3821b[graphQLPlaceSuggestionConfidenceLevel.ordinal()]) {
            case 1:
                return LOW;
            case 2:
                return MEDIUM;
            case 3:
                return HIGH;
            default:
                return UNKNOWN;
        }
    }

    private ConfidenceLevel(int i) {
        this.mLevel = i;
    }

    public final boolean isEqualOrGreaterThan(ConfidenceLevel confidenceLevel) {
        return this.mLevel >= confidenceLevel.mLevel;
    }
}

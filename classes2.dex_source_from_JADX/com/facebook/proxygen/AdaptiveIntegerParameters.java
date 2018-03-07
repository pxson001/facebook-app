package com.facebook.proxygen;

/* compiled from: psym_imp */
public class AdaptiveIntegerParameters {
    public final LatencyBasedParameter latencyBasedParameter;
    public final NetworkTypeBasedParameter networkTypeBasedParameter;

    /* compiled from: psym_imp */
    public class LatencyBasedParameter {
        public final int excellentValue;
        public final int goodValue;
        public final int moderateValue;
        public final int poorValue;
        public final int unknownValue;

        public LatencyBasedParameter(int i, int i2, int i3, int i4, int i5) {
            this.excellentValue = i;
            this.goodValue = i2;
            this.moderateValue = i3;
            this.poorValue = i4;
            this.unknownValue = i5;
        }
    }

    /* compiled from: psym_imp */
    public class NetworkTypeBasedParameter {
        public final int g2Value;
        public final int g3Value;
        public final int g4Value;
        public final int otherValue;
        public final int wifiValue;

        public NetworkTypeBasedParameter(int i, int i2, int i3, int i4, int i5) {
            this.wifiValue = i;
            this.g4Value = i2;
            this.g3Value = i3;
            this.g2Value = i4;
            this.otherValue = i5;
        }
    }

    public AdaptiveIntegerParameters(LatencyBasedParameter latencyBasedParameter) {
        this.latencyBasedParameter = latencyBasedParameter;
        this.networkTypeBasedParameter = null;
    }

    public AdaptiveIntegerParameters(NetworkTypeBasedParameter networkTypeBasedParameter) {
        this.latencyBasedParameter = null;
        this.networkTypeBasedParameter = networkTypeBasedParameter;
    }
}

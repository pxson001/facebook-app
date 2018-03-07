package com.facebook.audiofingerprinting.graphql;

import com.google.common.base.Preconditions;

/* compiled from: updatePrivacyData */
public class GraphQLFingerprintingParams {
    public final int f1084a;
    public final int f1085b;
    public final double f1086c;
    public final String f1087d;
    public final String f1088e;

    /* compiled from: updatePrivacyData */
    public class Builder {
        private int f1079a;
        private int f1080b;
        private double f1081c;
        private String f1082d;
        private String f1083e;

        public final Builder m1038a(int i) {
            this.f1079a = i;
            return this;
        }

        public final Builder m1041b(int i) {
            this.f1080b = i;
            return this;
        }

        public final Builder m1039a(String str) {
            this.f1082d = str;
            return this;
        }

        public final Builder m1037a(double d) {
            this.f1081c = d;
            return this;
        }

        public final Builder m1042b(String str) {
            this.f1083e = str;
            return this;
        }

        public final GraphQLFingerprintingParams m1040a() {
            return new GraphQLFingerprintingParams(this.f1079a, this.f1080b, this.f1081c, (String) Preconditions.checkNotNull(this.f1082d), (String) Preconditions.checkNotNull(this.f1083e));
        }
    }

    private GraphQLFingerprintingParams(int i, int i2, double d, String str, String str2) {
        this.f1084a = i;
        this.f1085b = i2;
        this.f1087d = str;
        this.f1086c = d;
        this.f1088e = str2;
    }

    public static Builder m1043a() {
        return new Builder();
    }
}

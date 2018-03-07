package com.facebook.composer.privacy.common;

import android.support.annotation.Nullable;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.google.common.base.Strings;

/* compiled from: tapped_unsave_place */
public class ComposerFixedPrivacyData {
    public final GraphQLPrivacyOptionType f1976a;
    public final String f1977b;
    public final String f1978c;
    @Nullable
    public final String f1979d;

    /* compiled from: tapped_unsave_place */
    public class Builder {
        public GraphQLPrivacyOptionType f1972a = null;
        public String f1973b = null;
        public String f1974c = null;
        public String f1975d = null;

        public Builder(ComposerFixedPrivacyData composerFixedPrivacyData) {
            this.f1972a = composerFixedPrivacyData.f1976a;
            this.f1973b = composerFixedPrivacyData.f1977b;
            this.f1974c = composerFixedPrivacyData.f1978c;
            this.f1975d = composerFixedPrivacyData.f1979d;
        }

        public final ComposerFixedPrivacyData m1926a() {
            return new ComposerFixedPrivacyData(this);
        }
    }

    public ComposerFixedPrivacyData(Builder builder) {
        this.f1976a = builder.f1972a;
        this.f1977b = builder.f1973b;
        this.f1978c = builder.f1974c;
        this.f1979d = Strings.isNullOrEmpty(builder.f1975d) ? "" : builder.f1975d;
    }
}

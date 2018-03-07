package com.facebook.privacy.spinner;

import com.facebook.privacy.model.ContentPrivacyOptionsResult;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: favicon_image */
public class AudienceSpinnerData {
    public final ImmutableList<? extends PrivacyOptionFieldsWithExplanation> f15299a;
    private int f15300b;

    @Deprecated
    public static AudienceSpinnerData m22945a(ContentPrivacyOptionsResult contentPrivacyOptionsResult) {
        return new AudienceSpinnerData(new Builder().b(contentPrivacyOptionsResult.f15071a).b(contentPrivacyOptionsResult.f15072b).b(), contentPrivacyOptionsResult.f15073c);
    }

    public AudienceSpinnerData(ImmutableList<? extends PrivacyOptionFieldsWithExplanation> immutableList, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        this.f15299a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        m22949b(privacyOptionFieldsWithExplanation);
    }

    public final int m22946a(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        for (int i = 0; i < this.f15299a.size(); i++) {
            if (PrivacyOptionHelper.a(privacyOptionFieldsWithExplanation, (PrivacyOptionFields) this.f15299a.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public final ImmutableList<? extends PrivacyOptionFieldsWithExplanation> m22947a() {
        return this.f15299a;
    }

    public final PrivacyOptionFieldsWithExplanation m22948b() {
        return (PrivacyOptionFieldsWithExplanation) this.f15299a.get(this.f15300b);
    }

    public final void m22949b(PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
        int a = m22946a(privacyOptionFieldsWithExplanation);
        Preconditions.checkArgument(a >= 0);
        this.f15300b = a;
    }
}

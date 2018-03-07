package com.facebook.universalfeedback;

import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.DeliveryType;
import com.facebook.graphql.calls.UniversalFeedbackGiveFeedbackInputData.ExperienceType;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: ego_page_like_fail */
public class UniversalFeedbackContextBuilder {
    public final ExperienceType f15341a;
    public final DeliveryType f15342b;
    @Nullable
    public String f15343c;

    public UniversalFeedbackContextBuilder(ExperienceType experienceType, DeliveryType deliveryType) {
        boolean z = true;
        Preconditions.checkArgument(experienceType != null);
        if (deliveryType == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f15341a = experienceType;
        this.f15342b = deliveryType;
    }
}

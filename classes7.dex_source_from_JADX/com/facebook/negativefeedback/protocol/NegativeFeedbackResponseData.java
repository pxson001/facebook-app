package com.facebook.negativefeedback.protocol;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;

/* compiled from: notificationSeenStatesList */
public class NegativeFeedbackResponseData {
    public String f8006a;
    public long f8007b;
    public GraphQLNegativeFeedbackActionType f8008c;
    public String f8009d;
    public String f8010e;
    public String f8011f;
    public boolean f8012g;

    public NegativeFeedbackResponseData(String str, long j, GraphQLNegativeFeedbackActionType graphQLNegativeFeedbackActionType, String str2, String str3, String str4, boolean z) {
        this.f8006a = str;
        this.f8007b = j;
        this.f8008c = graphQLNegativeFeedbackActionType;
        this.f8009d = str2;
        this.f8010e = str3;
        this.f8011f = str4;
        this.f8012g = z;
    }

    public NegativeFeedbackResponseData(NegativeFeedbackResponseData negativeFeedbackResponseData) {
        this.f8006a = negativeFeedbackResponseData.f8006a;
        this.f8007b = negativeFeedbackResponseData.f8007b;
        this.f8008c = negativeFeedbackResponseData.f8008c;
        this.f8009d = negativeFeedbackResponseData.f8009d;
        this.f8010e = negativeFeedbackResponseData.f8010e;
        this.f8011f = negativeFeedbackResponseData.f8011f;
        this.f8012g = negativeFeedbackResponseData.f8012g;
    }
}

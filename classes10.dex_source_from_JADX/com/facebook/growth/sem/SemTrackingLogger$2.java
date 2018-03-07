package com.facebook.growth.sem;

import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.UserSemClickTrackingInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.growth.sem.graphql.UserSemClickTrackingMutations.UserSemClickTrackingMutationString;

/* compiled from: voip_presence */
class SemTrackingLogger$2 implements Runnable {
    final /* synthetic */ String f356a;
    final /* synthetic */ String f357b;
    final /* synthetic */ SemTrackingLogger f358c;

    SemTrackingLogger$2(SemTrackingLogger semTrackingLogger, String str, String str2) {
        this.f358c = semTrackingLogger;
        this.f356a = str;
        this.f357b = str2;
    }

    public void run() {
        SemTrackingLogger semTrackingLogger = this.f358c;
        String str = this.f356a;
        String str2 = this.f357b;
        UserSemClickTrackingInputData userSemClickTrackingInputData = new UserSemClickTrackingInputData();
        userSemClickTrackingInputData.a("campaign_id", str);
        GraphQlCallInput graphQlCallInput = userSemClickTrackingInputData;
        graphQlCallInput.a("ad_click_time", str2);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("advertising_id", semTrackingLogger.a(true));
        graphQlCallInput = graphQlCallInput;
        GraphQlQueryString userSemClickTrackingMutationString = new UserSemClickTrackingMutationString();
        userSemClickTrackingMutationString.a("input", graphQlCallInput);
        semTrackingLogger.b.a(GraphQLRequest.a(userSemClickTrackingMutationString));
    }
}

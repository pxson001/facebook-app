package com.facebook.megaphone.fetcher;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData;
import javax.inject.Inject;

/* compiled from: turn_on_notifications_ls */
public class MegaphoneExtraDataFetcher {
    public ProfileQuestionFetcher f1302a;
    public IdentityGrowthMegaphoneStoryData f1303b;

    @Inject
    public MegaphoneExtraDataFetcher(ProfileQuestionFetcher profileQuestionFetcher, IdentityGrowthMegaphoneStoryData identityGrowthMegaphoneStoryData) {
        this.f1302a = profileQuestionFetcher;
        this.f1303b = identityGrowthMegaphoneStoryData;
    }

    public final void m1531a(String str, Object obj) {
        if (str.equals("2322")) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f1303b.f1286a = ((ProfileQuestionQueryModel) graphQLResult.e).j();
        }
    }
}

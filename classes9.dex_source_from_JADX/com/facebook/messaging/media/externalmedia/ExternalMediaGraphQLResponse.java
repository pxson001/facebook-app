package com.facebook.messaging.media.externalmedia;

import com.facebook.messaging.media.externalmedia.graphql.ExternalMediaQueryFragmentModels.ExternalMediaQueryFragmentModel.AppInfoModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mCountString */
public class ExternalMediaGraphQLResponse {
    public final ImmutableList<ExternalMediaGraphQLResult> f11606a;
    public final ImmutableList<AppInfoModel> f11607b;

    public ExternalMediaGraphQLResponse(ImmutableList<ExternalMediaGraphQLResult> immutableList, ImmutableList<AppInfoModel> immutableList2) {
        this.f11606a = immutableList;
        this.f11607b = immutableList2;
    }
}

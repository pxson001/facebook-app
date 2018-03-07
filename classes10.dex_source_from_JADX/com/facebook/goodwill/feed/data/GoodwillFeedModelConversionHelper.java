package com.facebook.goodwill.feed.data;

import com.facebook.goodwill.feed.protocol.ThrowbackFeedUnitsModels.ThrowbackShareableModel;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntity.Builder;

/* compiled from: View not registered with this NativeAd */
public final class GoodwillFeedModelConversionHelper {
    public static GraphQLEntity m22026a(ThrowbackShareableModel throwbackShareableModel) {
        if (throwbackShareableModel == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.S = throwbackShareableModel.b();
        builder.m = throwbackShareableModel.c();
        return builder.a();
    }
}

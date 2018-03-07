package com.facebook.richdocument.presenter;

import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.api.ufiservices.common.TogglePageLikeParams;
import com.facebook.controller.mutation.util.ModernFeedbackGraphQLGenerator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.RichDocumentInfo;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: permissions_niem */
public class PageLikeActionHelper {
    private final ModernFeedbackGraphQLGenerator f6435a;
    private final GraphQLActorCacheImpl f6436b;
    private final RichDocumentInfo f6437c;

    public static PageLikeActionHelper m6819b(InjectorLike injectorLike) {
        return new PageLikeActionHelper(ModernFeedbackGraphQLGenerator.b(injectorLike), GraphQLActorCacheImpl.a(injectorLike), RichDocumentInfo.m5102a(injectorLike));
    }

    @Inject
    public PageLikeActionHelper(ModernFeedbackGraphQLGenerator modernFeedbackGraphQLGenerator, GraphQLActorCacheImpl graphQLActorCacheImpl, RichDocumentInfo richDocumentInfo) {
        this.f6435a = modernFeedbackGraphQLGenerator;
        this.f6436b = graphQLActorCacheImpl;
        this.f6437c = richDocumentInfo;
    }

    public final ListenableFuture<OperationResult> m6820a(boolean z, String str) {
        ArrayNode arrayNode = null;
        if (this.f6437c.f5116d instanceof ArrayNode) {
            arrayNode = (ArrayNode) this.f6437c.f5116d;
        }
        Builder builder = new Builder();
        builder.c = "native_article_story";
        builder = builder;
        builder.a = arrayNode;
        FeedbackLoggingParams a = builder.a();
        TogglePageLikeParams.Builder a2 = TogglePageLikeParams.a();
        a2.b = z;
        a2 = a2;
        a2.a = str;
        a2 = a2;
        a2.c = this.f6436b.a();
        a2 = a2;
        a2.d = a;
        return this.f6435a.a(a2.a());
    }
}

package com.facebook.controller.mutation;

import com.facebook.api.ufiservices.common.TogglePostLikeParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.model.GraphQLFeedback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* compiled from: tap_photo_button */
class RawLikeHelper$3 implements Callable<ListenableFuture<OperationResult>> {
    final /* synthetic */ GraphQLFeedback f2278a;
    final /* synthetic */ TogglePostLikeParams f2279b;
    final /* synthetic */ RawLikeHelper f2280c;

    RawLikeHelper$3(RawLikeHelper rawLikeHelper, GraphQLFeedback graphQLFeedback, TogglePostLikeParams togglePostLikeParams) {
        this.f2280c = rawLikeHelper;
        this.f2278a = graphQLFeedback;
        this.f2279b = togglePostLikeParams;
    }

    public Object call() {
        if (this.f2278a == null) {
            return this.f2280c.e.b(this.f2279b);
        }
        return this.f2280c.f.a(this.f2279b);
    }
}

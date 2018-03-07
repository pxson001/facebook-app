package com.facebook.timeline.profilemedia.sync;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLModels.FetchProfilePicGraphQLModel;
import com.facebook.timeline.profilemedia.sync.protocol.FetchProfilePicGraphQLModels.FetchProfilePicGraphQLModel.ActorModel;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;

/* compiled from: mTaggedProfiles */
class ProfilePicFetcher$1 implements Function<GraphQLResult<FetchProfilePicGraphQLModel>, DefaultImageFieldsModel> {
    final /* synthetic */ ProfilePicFetcher f9185a;

    ProfilePicFetcher$1(ProfilePicFetcher profilePicFetcher) {
        this.f9185a = profilePicFetcher;
    }

    @Nullable
    public Object apply(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((FetchProfilePicGraphQLModel) graphQLResult.e).m10977a() == null) {
            return null;
        }
        ActorModel a = ((FetchProfilePicGraphQLModel) graphQLResult.e).m10977a();
        ProfilePicFetcher profilePicFetcher = this.f9185a;
        DefaultImageFieldsModel a2 = a.m10966a();
        Builder builder = ImmutableList.builder();
        if (a.m10972l() != null) {
            builder.c(new PicSquareUrlWithSize(a.m10972l().c(), a.m10972l().b()));
        }
        if (a.m10970j() != null) {
            builder.c(new PicSquareUrlWithSize(a.m10970j().c(), a.m10970j().b()));
        }
        if (a.m10971k() != null) {
            builder.c(new PicSquareUrlWithSize(a.m10971k().c(), a.m10971k().b()));
        }
        PicSquare picSquare = new PicSquare(builder.b());
        User c = profilePicFetcher.b.c();
        if (c != null) {
            UserBuilder userBuilder = new UserBuilder();
            userBuilder.a(c);
            if (a2 != null) {
                userBuilder.n = a2.b();
            }
            userBuilder.p = picSquare;
            profilePicFetcher.b.c(userBuilder.aa());
        }
        return a.m10966a();
    }
}

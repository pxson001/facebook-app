package com.facebook.linkify;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.linkify.LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel;
import com.facebook.linkify.LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.ProfilePictureModel.Builder;
import javax.annotation.Nullable;

/* compiled from: grey */
public class LinkifyTargetBuilder {
    private static LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL m29538a(@Nullable String str, String str2, int i, @Nullable String str3, @Nullable String str4) {
        ProfilePictureModel profilePictureModel = null;
        if (str4 != null) {
            Builder builder = new Builder();
            builder.f21804a = str4;
            profilePictureModel = builder.m29539a();
        }
        LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.Builder builder2 = new LinkifyTargetGraphQLModels$LinkifyTargetGraphQLModel.Builder();
        builder2.f21807b = str2;
        builder2 = builder2;
        builder2.f21808c = str;
        builder2 = builder2;
        builder2.f21806a = new GraphQLObjectType(i);
        builder2 = builder2;
        builder2.f21810e = str3;
        builder2 = builder2;
        builder2.f21809d = profilePictureModel;
        return builder2.m29545a();
    }

    @Nullable
    public static LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL m29537a(GraphQLProfile graphQLProfile) {
        String str = null;
        if (graphQLProfile == null) {
            return null;
        }
        GraphQLObjectType j = graphQLProfile.m23000j();
        int g = j != null ? j.m22301g() : graphQLProfile.jK_();
        String U = graphQLProfile.m22987U();
        String b = graphQLProfile.m22999b();
        String ax = graphQLProfile.ax();
        if (graphQLProfile.ai() != null) {
            str = graphQLProfile.ai().mo2924b();
        }
        return m29538a(U, b, g, ax, str);
    }

    @Nullable
    public static LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL m29535a(GraphQLPage graphQLPage) {
        String str = null;
        if (graphQLPage == null) {
            return null;
        }
        int jK_ = graphQLPage.jK_();
        String aG = graphQLPage.aG();
        String ae = graphQLPage.ae();
        String ck = graphQLPage.ck();
        if (graphQLPage.bs() != null) {
            str = graphQLPage.bs().mo2924b();
        }
        return m29538a(aG, ae, jK_, ck, str);
    }

    @Nullable
    public static LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL m29536a(GraphQLPlace graphQLPlace) {
        String str = null;
        if (graphQLPlace == null) {
            return null;
        }
        GraphQLObjectType j = graphQLPlace.m24157j();
        int g = j != null ? j.m22301g() : graphQLPlace.jK_();
        String B = graphQLPlace.m24126B();
        String x = graphQLPlace.m24171x();
        String X = graphQLPlace.m24148X();
        if (graphQLPlace.m24138N() != null) {
            str = graphQLPlace.m24138N().mo2924b();
        }
        return m29538a(B, x, g, X, str);
    }

    @Nullable
    public static LinkifyTargetGraphQLInterfaces$LinkifyTargetGraphQL m29534a(GraphQLActor graphQLActor) {
        String str = null;
        if (graphQLActor == null) {
            return null;
        }
        GraphQLObjectType b = graphQLActor.m23790b();
        int g = b != null ? b.m22301g() : graphQLActor.jK_();
        String aa = graphQLActor.aa();
        String H = graphQLActor.m23765H();
        String aw = graphQLActor.aw();
        if (graphQLActor.ai() != null) {
            str = graphQLActor.ai().mo2924b();
        }
        return m29538a(aa, H, g, aw, str);
    }
}

package com.facebook.checkin.socialsearch.graphql;

import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.CityModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.OverallStarRatingModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.PageVisitsModel;
import com.facebook.api.graphql.place.NewsFeedExplicitPlaceFieldsGraphQLModels.NewsFeedDefaultsPlaceFieldsWithoutMediaModel.ViewerVisitsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.NewItemDefaultPrivacy;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel.AddItemActionInfoModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel.AddedItemStateInfoModel;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel.SavedDashboardSectionModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoPageFieldsModel;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.CommentPlaceInfoPageFieldsModel.AddressModel;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPageVisitsConnection;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLRating;
import com.facebook.graphql.model.GraphQLSavedDashboardSection;
import com.facebook.graphql.model.GraphQLStreetAddress;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.graphql.model.GraphQLTimelineAppCollection;
import com.facebook.graphql.model.GraphQLTimelineAppCollectionMembershipStateInfo;
import com.facebook.graphql.model.GraphQLViewerVisitsConnection;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesWithAggregatedRangesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesWithAggregatedRangesFields.AggregatedRanges;
import com.google.common.collect.ImmutableList;

/* compiled from: uninstall */
public final class PlaceRecommendationPageConversionHelper {
    public static GraphQLTextWithEntities m1089a(DefaultTextWithEntitiesWithAggregatedRangesFields defaultTextWithEntitiesWithAggregatedRangesFields) {
        int i = 0;
        if (defaultTextWithEntitiesWithAggregatedRangesFields == null) {
            return null;
        }
        Builder builder = new Builder();
        if (defaultTextWithEntitiesWithAggregatedRangesFields.c() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < defaultTextWithEntitiesWithAggregatedRangesFields.c().size(); i2++) {
                GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange;
                AggregatedRanges aggregatedRanges = (AggregatedRanges) defaultTextWithEntitiesWithAggregatedRangesFields.c().get(i2);
                if (aggregatedRanges == null) {
                    graphQLAggregatedEntitiesAtRange = null;
                } else {
                    GraphQLAggregatedEntitiesAtRange.Builder builder3 = new GraphQLAggregatedEntitiesAtRange.Builder();
                    builder3.d = aggregatedRanges.a();
                    builder3.e = aggregatedRanges.b();
                    builder3.f = aggregatedRanges.c();
                    graphQLAggregatedEntitiesAtRange = builder3.a();
                }
                builder2.c(graphQLAggregatedEntitiesAtRange);
            }
            builder.e = builder2.b();
        }
        if (defaultTextWithEntitiesWithAggregatedRangesFields.b() != null) {
            ImmutableList.Builder builder4 = ImmutableList.builder();
            while (i < defaultTextWithEntitiesWithAggregatedRangesFields.b().size()) {
                GraphQLEntityAtRange graphQLEntityAtRange;
                Ranges ranges = (Ranges) defaultTextWithEntitiesWithAggregatedRangesFields.b().get(i);
                if (ranges == null) {
                    graphQLEntityAtRange = null;
                } else {
                    GraphQLEntity graphQLEntity;
                    GraphQLEntityAtRange.Builder builder5 = new GraphQLEntityAtRange.Builder();
                    DefaultTextWithEntitiesEntityFields a = ranges.a();
                    if (a == null) {
                        graphQLEntity = null;
                    } else {
                        GraphQLEntity.Builder builder6 = new GraphQLEntity.Builder();
                        builder6.S = a.b();
                        builder6.d = a.c();
                        builder6.m = a.d();
                        builder6.u = a.C_();
                        builder6.O = a.g();
                        builder6.P = a.D_();
                        graphQLEntity = builder6.a();
                    }
                    builder5.d = graphQLEntity;
                    builder5.e = ranges.b();
                    builder5.f = ranges.c();
                    graphQLEntityAtRange = builder5.a();
                }
                builder4.c(graphQLEntityAtRange);
                i++;
            }
            builder.h = builder4.b();
        }
        builder.i = defaultTextWithEntitiesWithAggregatedRangesFields.a();
        return builder.a();
    }

    public static GraphQLPage m1088a(CommentPlaceInfoPageFieldsModel commentPlaceInfoPageFieldsModel) {
        if (commentPlaceInfoPageFieldsModel == null) {
            return null;
        }
        GraphQLStreetAddress graphQLStreetAddress;
        GraphQLPage graphQLPage;
        GraphQLLocation graphQLLocation;
        GraphQLRating graphQLRating;
        GraphQLPageVisitsConnection graphQLPageVisitsConnection;
        GraphQLImage graphQLImage;
        GraphQLTimelineAppCollection graphQLTimelineAppCollection;
        GraphQLViewerVisitsConnection graphQLViewerVisitsConnection;
        GraphQLPage.Builder builder = new GraphQLPage.Builder();
        AddressModel b = commentPlaceInfoPageFieldsModel.b();
        if (b == null) {
            graphQLStreetAddress = null;
        } else {
            GraphQLStreetAddress.Builder builder2 = new GraphQLStreetAddress.Builder();
            builder2.j = b.a();
            graphQLStreetAddress = builder2.a();
        }
        builder.f = graphQLStreetAddress;
        builder.A = commentPlaceInfoPageFieldsModel.c();
        CityModel d = commentPlaceInfoPageFieldsModel.d();
        if (d == null) {
            graphQLPage = null;
        } else {
            GraphQLPage.Builder builder3 = new GraphQLPage.Builder();
            builder3.I = d.a();
            graphQLPage = builder3.a();
        }
        builder.C = graphQLPage;
        builder.Z = commentPlaceInfoPageFieldsModel.bq_();
        builder.an = commentPlaceInfoPageFieldsModel.g();
        DefaultLocationFields bs_ = commentPlaceInfoPageFieldsModel.bs_();
        if (bs_ == null) {
            graphQLLocation = null;
        } else {
            GraphQLLocation.Builder builder4 = new GraphQLLocation.Builder();
            builder4.d = bs_.a();
            builder4.e = bs_.b();
            graphQLLocation = builder4.a();
        }
        builder.ay = graphQLLocation;
        builder.aF = commentPlaceInfoPageFieldsModel.br_();
        OverallStarRatingModel j = commentPlaceInfoPageFieldsModel.j();
        if (j == null) {
            graphQLRating = null;
        } else {
            GraphQLRating.Builder builder5 = new GraphQLRating.Builder();
            builder5.e = j.a();
            builder5.f = j.b();
            graphQLRating = builder5.a();
        }
        builder.aL = graphQLRating;
        PageVisitsModel k = commentPlaceInfoPageFieldsModel.k();
        if (k == null) {
            graphQLPageVisitsConnection = null;
        } else {
            GraphQLPageVisitsConnection.Builder builder6 = new GraphQLPageVisitsConnection.Builder();
            builder6.d = k.a();
            graphQLPageVisitsConnection = builder6.a();
        }
        builder.aV = graphQLPageVisitsConnection;
        builder.bg = commentPlaceInfoPageFieldsModel.l();
        DefaultImageFields m = commentPlaceInfoPageFieldsModel.m();
        if (m == null) {
            graphQLImage = null;
        } else {
            GraphQLImage.Builder builder7 = new GraphQLImage.Builder();
            builder7.d = m.a();
            builder7.g = m.b();
            builder7.h = m.c();
            graphQLImage = builder7.a();
        }
        builder.bv = graphQLImage;
        builder.bw = commentPlaceInfoPageFieldsModel.n();
        SavableTimelineAppCollectionExtraFieldsModel o = commentPlaceInfoPageFieldsModel.o();
        if (o == null) {
            graphQLTimelineAppCollection = null;
        } else {
            GraphQLTimelineAppCollectionMembershipStateInfo graphQLTimelineAppCollectionMembershipStateInfo;
            GraphQLTimelineAppCollectionMembershipStateInfo.Builder builder8;
            GraphQLPrivacyOption graphQLPrivacyOption;
            GraphQLSavedDashboardSection graphQLSavedDashboardSection;
            GraphQLTimelineAppCollection.Builder builder9 = new GraphQLTimelineAppCollection.Builder();
            AddItemActionInfoModel J_ = o.J_();
            if (J_ == null) {
                graphQLTimelineAppCollectionMembershipStateInfo = null;
            } else {
                builder8 = new GraphQLTimelineAppCollectionMembershipStateInfo.Builder();
                builder8.d = J_.a();
                builder8.e = m1089a(J_.b());
                graphQLTimelineAppCollectionMembershipStateInfo = builder8.a();
            }
            builder9.d = graphQLTimelineAppCollectionMembershipStateInfo;
            AddedItemStateInfoModel g = o.g();
            if (g == null) {
                graphQLTimelineAppCollectionMembershipStateInfo = null;
            } else {
                builder8 = new GraphQLTimelineAppCollectionMembershipStateInfo.Builder();
                builder8.d = g.a();
                builder8.e = m1089a(g.b());
                graphQLTimelineAppCollectionMembershipStateInfo = builder8.a();
            }
            builder9.e = graphQLTimelineAppCollectionMembershipStateInfo;
            builder9.h = o.H_();
            builder9.j = o.b();
            builder9.l = o.c();
            NewItemDefaultPrivacy d2 = o.d();
            if (d2 == null) {
                graphQLPrivacyOption = null;
            } else {
                GraphQLPrivacyOption.Builder builder10 = new GraphQLPrivacyOption.Builder();
                builder10.j = d2.c();
                builder10.n = d2.k();
                graphQLPrivacyOption = builder10.a();
            }
            builder9.m = graphQLPrivacyOption;
            SavedDashboardSectionModel I_ = o.I_();
            if (I_ == null) {
                graphQLSavedDashboardSection = null;
            } else {
                GraphQLSavedDashboardSection.Builder builder11 = new GraphQLSavedDashboardSection.Builder();
                builder11.d = I_.a();
                graphQLSavedDashboardSection = new GraphQLSavedDashboardSection(builder11);
            }
            builder9.p = graphQLSavedDashboardSection;
            builder9.t = o.j();
            graphQLTimelineAppCollection = new GraphQLTimelineAppCollection(builder9);
        }
        builder.bI = graphQLTimelineAppCollection;
        builder.bS = commentPlaceInfoPageFieldsModel.p();
        builder.ce = commentPlaceInfoPageFieldsModel.q();
        builder.cq = commentPlaceInfoPageFieldsModel.r();
        builder.cH = commentPlaceInfoPageFieldsModel.s();
        ViewerVisitsModel t = commentPlaceInfoPageFieldsModel.t();
        if (t == null) {
            graphQLViewerVisitsConnection = null;
        } else {
            GraphQLViewerVisitsConnection.Builder builder12 = new GraphQLViewerVisitsConnection.Builder();
            builder12.d = t.a();
            graphQLViewerVisitsConnection = new GraphQLViewerVisitsConnection(builder12);
        }
        builder.cL = graphQLViewerVisitsConnection;
        return builder.a();
    }
}

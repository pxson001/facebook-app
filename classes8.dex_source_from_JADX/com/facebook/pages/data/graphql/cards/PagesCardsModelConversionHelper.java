package com.facebook.pages.data.graphql.cards;

import com.facebook.events.graphql.EventsGraphQLInterfaces.EventSocialContextFields.EventMembers;
import com.facebook.events.graphql.EventsGraphQLInterfaces.UserInEventFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.AddressModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.CityModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.LocationModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventWatchersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.SuggestedEventContextSentenceModel;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.graphql.model.GraphQLEventMaybesConnection;
import com.facebook.graphql.model.GraphQLEventMaybesEdge;
import com.facebook.graphql.model.GraphQLEventMembersConnection;
import com.facebook.graphql.model.GraphQLEventMembersConnection.Builder;
import com.facebook.graphql.model.GraphQLEventMembersEdge;
import com.facebook.graphql.model.GraphQLEventWatchersConnection;
import com.facebook.graphql.model.GraphQLEventWatchersEdge;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLOwnedEventsConnection;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStreetAddress;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel.NodesModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel.NodesModel.CoverPhotoModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel.NodesModel.CoverPhotoModel.FocusModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel.NodesModel.CoverPhotoModel.PhotoModel;
import com.facebook.pages.data.graphql.cards.EventCardGraphQLModels.PageEventsConnectionModel.NodesModel.CoverPhotoModel.PhotoModel.ImageModel;
import com.google.common.collect.ImmutableList;

/* compiled from: contact_id = ' */
public final class PagesCardsModelConversionHelper {
    public static GraphQLEventMembersConnection m20682a(EventMembers eventMembers) {
        if (eventMembers == null) {
            return null;
        }
        Builder builder = new Builder();
        int a = eventMembers.a();
        builder.d = a;
        if (builder.a != null && builder.a.d) {
            builder.a.b(builder.b, 0, a);
        }
        return builder.a();
    }

    public static GraphQLPlace m20687a(EventPlaceModel eventPlaceModel) {
        if (eventPlaceModel == null) {
            return null;
        }
        GraphQLStreetAddress graphQLStreetAddress;
        GraphQLPage graphQLPage;
        GraphQLLocation graphQLLocation;
        GraphQLPlace.Builder builder = new GraphQLPlace.Builder();
        builder.X = eventPlaceModel.b();
        AddressModel c = eventPlaceModel.c();
        if (c == null) {
            graphQLStreetAddress = null;
        } else {
            GraphQLStreetAddress.Builder builder2 = new GraphQLStreetAddress.Builder();
            String a = c.a();
            builder2.h = a;
            if (builder2.a != null && builder2.a.d) {
                builder2.a.a(builder2.b, 4, a);
            }
            graphQLStreetAddress = builder2.a();
        }
        builder.d = graphQLStreetAddress;
        CityModel d = eventPlaceModel.d();
        if (d == null) {
            graphQLPage = null;
        } else {
            GraphQLPage.Builder builder3 = new GraphQLPage.Builder();
            builder3.G = d.a();
            graphQLPage = builder3.a();
        }
        builder.j = graphQLPage;
        builder.k = eventPlaceModel.dT_();
        builder.q = eventPlaceModel.g();
        LocationModel dV_ = eventPlaceModel.dV_();
        if (dV_ == null) {
            graphQLLocation = null;
        } else {
            GraphQLLocation.Builder builder4 = new GraphQLLocation.Builder();
            builder4.d = dV_.a();
            builder4.e = dV_.b();
            builder4.f = dV_.c();
            graphQLLocation = builder4.a();
        }
        builder.s = graphQLLocation;
        builder.c(eventPlaceModel.dU_());
        return builder.a();
    }

    public static GraphQLImage m20685a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    public static GraphQLActor m20680a(UserInEventFragment userInEventFragment) {
        if (userInEventFragment == null) {
            return null;
        }
        GraphQLActor.Builder builder = new GraphQLActor.Builder();
        builder.aH = userInEventFragment.g();
        builder.a(userInEventFragment.dR_());
        builder.B = userInEventFragment.b();
        builder.V = userInEventFragment.c();
        builder.ad = m20685a(userInEventFragment.d());
        return builder.a();
    }

    public static GraphQLEventMaybesConnection m20681a(FriendEventMaybesFirst5Model friendEventMaybesFirst5Model) {
        if (friendEventMaybesFirst5Model == null) {
            return null;
        }
        GraphQLEventMaybesConnection.Builder builder = new GraphQLEventMaybesConnection.Builder();
        if (friendEventMaybesFirst5Model.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < friendEventMaybesFirst5Model.a().size(); i++) {
                Object obj;
                EdgesModel edgesModel = (EdgesModel) friendEventMaybesFirst5Model.a().get(i);
                if (edgesModel == null) {
                    obj = null;
                } else {
                    GraphQLEventMaybesEdge.Builder builder3 = new GraphQLEventMaybesEdge.Builder();
                    builder3.d = m20680a(edgesModel.a());
                    GraphQLEventMaybesEdge graphQLEventMaybesEdge = new GraphQLEventMaybesEdge(builder3);
                }
                builder2.c(obj);
            }
            builder.e = builder2.b();
        }
        builder.g = friendEventMaybesFirst5Model.b();
        return new GraphQLEventMaybesConnection(builder);
    }

    public static GraphQLEventMembersConnection m20683a(FriendEventMembersFirst5Model friendEventMembersFirst5Model) {
        if (friendEventMembersFirst5Model == null) {
            return null;
        }
        Builder builder = new Builder();
        if (friendEventMembersFirst5Model.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < friendEventMembersFirst5Model.a().size(); i++) {
                Object obj;
                FriendEventMembersFirst5Model.EdgesModel edgesModel = (FriendEventMembersFirst5Model.EdgesModel) friendEventMembersFirst5Model.a().get(i);
                if (edgesModel == null) {
                    obj = null;
                } else {
                    GraphQLEventMembersEdge.Builder builder3 = new GraphQLEventMembersEdge.Builder();
                    builder3.d = m20680a(edgesModel.a());
                    GraphQLEventMembersEdge graphQLEventMembersEdge = new GraphQLEventMembersEdge(builder3);
                }
                builder2.c(obj);
            }
            builder.e = builder2.b();
        }
        builder.h = friendEventMembersFirst5Model.b();
        return builder.a();
    }

    public static GraphQLEventWatchersConnection m20684a(FriendEventWatchersFirst5Model friendEventWatchersFirst5Model) {
        if (friendEventWatchersFirst5Model == null) {
            return null;
        }
        GraphQLEventWatchersConnection.Builder builder = new GraphQLEventWatchersConnection.Builder();
        if (friendEventWatchersFirst5Model.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < friendEventWatchersFirst5Model.a().size(); i++) {
                Object obj;
                FriendEventWatchersFirst5Model.EdgesModel edgesModel = (FriendEventWatchersFirst5Model.EdgesModel) friendEventWatchersFirst5Model.a().get(i);
                if (edgesModel == null) {
                    obj = null;
                } else {
                    GraphQLEventWatchersEdge.Builder builder3 = new GraphQLEventWatchersEdge.Builder();
                    builder3.d = m20680a(edgesModel.a());
                    GraphQLEventWatchersEdge graphQLEventWatchersEdge = new GraphQLEventWatchersEdge(builder3);
                }
                builder2.c(obj);
            }
            builder.e = builder2.b();
        }
        builder.h = friendEventWatchersFirst5Model.b();
        return new GraphQLEventWatchersConnection(builder);
    }

    public static GraphQLOwnedEventsConnection m20686a(PageEventsConnectionModel pageEventsConnectionModel) {
        if (pageEventsConnectionModel == null) {
            return null;
        }
        GraphQLOwnedEventsConnection.Builder builder = new GraphQLOwnedEventsConnection.Builder();
        if (pageEventsConnectionModel.m20442a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < pageEventsConnectionModel.m20442a().size(); i++) {
                Object obj;
                NodesModel nodesModel = (NodesModel) pageEventsConnectionModel.m20442a().get(i);
                if (nodesModel == null) {
                    obj = null;
                } else {
                    GraphQLFocusedPhoto graphQLFocusedPhoto;
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    GraphQLEvent.Builder builder3 = new GraphQLEvent.Builder();
                    builder3.o = nodesModel.m20423b();
                    builder3.q = nodesModel.m20424c();
                    builder3.v = nodesModel.m20425d();
                    CoverPhotoModel kw_ = nodesModel.kw_();
                    if (kw_ == null) {
                        graphQLFocusedPhoto = null;
                    } else {
                        GraphQLVect2 graphQLVect2;
                        GraphQLPhoto graphQLPhoto;
                        GraphQLFocusedPhoto.Builder builder4 = new GraphQLFocusedPhoto.Builder();
                        FocusModel a = kw_.m20403a();
                        if (a == null) {
                            graphQLVect2 = null;
                        } else {
                            GraphQLVect2.Builder builder5 = new GraphQLVect2.Builder();
                            builder5.d = a.m20376a();
                            builder5.e = a.m20380b();
                            graphQLVect2 = builder5.a();
                        }
                        builder4.d = graphQLVect2;
                        PhotoModel b = kw_.m20404b();
                        if (b == null) {
                            graphQLPhoto = null;
                        } else {
                            GraphQLImage graphQLImage;
                            GraphQLPhoto.Builder builder6 = new GraphQLPhoto.Builder();
                            builder6.F = b.m20395b();
                            ImageModel c = b.m20396c();
                            if (c == null) {
                                graphQLImage = null;
                            } else {
                                GraphQLImage.Builder builder7 = new GraphQLImage.Builder();
                                builder7.d = c.m20384a();
                                builder7.g = c.m20388b();
                                builder7.h = c.m20389c();
                                graphQLImage = builder7.a();
                            }
                            builder6.G = graphQLImage;
                            builder6.aW = b.m20397d();
                            graphQLPhoto = builder6.a();
                        }
                        builder4.e = graphQLPhoto;
                        graphQLFocusedPhoto = builder4.a();
                    }
                    builder3.x = graphQLFocusedPhoto;
                    builder3.B = nodesModel.m20426g();
                    builder3.Q = m20682a(nodesModel.kv_());
                    builder3.R = m20687a(nodesModel.ku_());
                    builder3.ah = m20681a(nodesModel.m20427j());
                    builder3.aj = m20683a(nodesModel.m20428k());
                    builder3.al = m20684a(nodesModel.m20429l());
                    builder3.ap = nodesModel.m20430m();
                    builder3.as = nodesModel.m20431n();
                    String o = nodesModel.m20432o();
                    builder3.aC = o;
                    if (builder3.a != null && builder3.a.d) {
                        builder3.a.a(builder3.b, 75, o);
                    }
                    builder3.bh = nodesModel.m20433p();
                    SuggestedEventContextSentenceModel q = nodesModel.m20434q();
                    if (q == null) {
                        graphQLTextWithEntities = null;
                    } else {
                        GraphQLTextWithEntities.Builder builder8 = new GraphQLTextWithEntities.Builder();
                        builder8.i = q.a();
                        graphQLTextWithEntities = builder8.a();
                    }
                    builder3.bj = graphQLTextWithEntities;
                    builder3.bo = nodesModel.m20435r();
                    GraphQLEventGuestStatus s = nodesModel.m20436s();
                    builder3.bs = s;
                    if (builder3.a != null && builder3.a.d) {
                        builder3.a.a(builder3.b, 116, s);
                    }
                    if (nodesModel.m20437t() != null) {
                        ImmutableList.Builder builder9 = ImmutableList.builder();
                        for (int i2 = 0; i2 < nodesModel.m20437t().size(); i2++) {
                            builder9.c(m20680a((UserInEventFragment) nodesModel.m20437t().get(i2)));
                        }
                        builder3.bu = builder9.b();
                    }
                    GraphQLEventWatchStatus u = nodesModel.m20438u();
                    builder3.bz = u;
                    if (builder3.a != null && builder3.a.d) {
                        builder3.a.a(builder3.b, 123, u);
                    }
                    GraphQLEvent graphQLEvent = new GraphQLEvent(builder3);
                }
                builder2.c(obj);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }
}

package com.facebook.photos.pandora.protocols;

import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLInterfaces.BaseFeedbackFields.ViewerActsAsPage;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel.RealTimeActivityActorsModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.FeedbackRealTimeActivityInfoFieldsModel.RealTimeActivityInfoModel.RealTimeActivityActorsModel.NodesModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.LikersModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.ResharesModel;
import com.facebook.api.graphql.feedback.FeedbackDefaultsGraphQLModels.SimpleFeedFeedbackModel.TopLevelCommentsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel.NodeModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.SimpleReactionsFeedbackFieldsModel.ReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsFeedbackFieldsModel.SupportedReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ImportantReactorsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ViewerReactionsSocialFeedbackFieldsModel.ViewerActsAsPersonModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLFeedbackRealTimeActivityActorsConnection;
import com.facebook.graphql.model.GraphQLFeedbackRealTimeActivityInfo;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImage.Builder;
import com.facebook.graphql.model.GraphQLImportantReactorsConnection;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLReactorsOfContentConnection;
import com.facebook.graphql.model.GraphQLResharesOfContentConnection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.Likers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.TopLevelComments;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.photos.pandora.protocols.PandoraQueryInterfaces.PandoraMediaImageWithFeedbackFields;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.ActorsModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.AttachmentsModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.AttachmentsModel.MediaModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.AttachmentsModel.SourceModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.AttachmentsModel.TargetModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.AttachmentsModel.TargetModel.ApplicationModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel.CreationStoryModel.ShareableModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraQueryFeedbackModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraQueryFeedbackModel.ViewerDoesNotLikeSentenceModel;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraQueryFeedbackModel.ViewerLikesSentenceModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: has_video */
public final class PandoraModelConversionHelper {
    public static GraphQLImage m20441a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    private static GraphQLTextWithEntities m20444a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
        if (defaultTextWithEntitiesLongFields == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        if (defaultTextWithEntitiesLongFields.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < defaultTextWithEntitiesLongFields.b().size(); i++) {
                GraphQLEntityAtRange graphQLEntityAtRange;
                Ranges ranges = (Ranges) defaultTextWithEntitiesLongFields.b().get(i);
                if (ranges == null) {
                    graphQLEntityAtRange = null;
                } else {
                    GraphQLEntity graphQLEntity;
                    GraphQLEntityAtRange.Builder builder3 = new GraphQLEntityAtRange.Builder();
                    DefaultTextWithEntitiesEntityFields a = ranges.a();
                    if (a == null) {
                        graphQLEntity = null;
                    } else {
                        GraphQLEntity.Builder builder4 = new GraphQLEntity.Builder();
                        builder4.S = a.b();
                        builder4.d = a.c();
                        builder4.m = a.d();
                        builder4.u = a.C_();
                        builder4.O = a.g();
                        builder4.P = a.D_();
                        graphQLEntity = builder4.a();
                    }
                    builder3.d = graphQLEntity;
                    builder3.e = ranges.b();
                    builder3.f = ranges.c();
                    graphQLEntityAtRange = builder3.a();
                }
                builder2.c(graphQLEntityAtRange);
            }
            builder.h = builder2.b();
        }
        builder.i = defaultTextWithEntitiesLongFields.a();
        return builder.a();
    }

    private static GraphQLFeedbackRealTimeActivityInfo m20440a(RealTimeActivityInfoModel realTimeActivityInfoModel) {
        if (realTimeActivityInfoModel == null) {
            return null;
        }
        GraphQLFeedbackRealTimeActivityActorsConnection graphQLFeedbackRealTimeActivityActorsConnection;
        GraphQLFeedbackRealTimeActivityInfo.Builder builder = new GraphQLFeedbackRealTimeActivityInfo.Builder();
        RealTimeActivityActorsModel a = realTimeActivityInfoModel.a();
        if (a == null) {
            graphQLFeedbackRealTimeActivityActorsConnection = null;
        } else {
            GraphQLFeedbackRealTimeActivityActorsConnection.Builder builder2 = new GraphQLFeedbackRealTimeActivityActorsConnection.Builder();
            if (a.a() != null) {
                ImmutableList.Builder builder3 = ImmutableList.builder();
                for (int i = 0; i < a.a().size(); i++) {
                    GraphQLActor graphQLActor;
                    NodesModel nodesModel = (NodesModel) a.a().get(i);
                    if (nodesModel == null) {
                        graphQLActor = null;
                    } else {
                        GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
                        builder4.aH = nodesModel.b();
                        builder4.B = nodesModel.c();
                        builder4.V = nodesModel.d();
                        builder4.ad = m20441a(nodesModel.bW_());
                        graphQLActor = builder4.a();
                    }
                    builder3.c(graphQLActor);
                }
                builder2.d = builder3.b();
            }
            graphQLFeedbackRealTimeActivityActorsConnection = new GraphQLFeedbackRealTimeActivityActorsConnection(builder2);
        }
        builder.d = graphQLFeedbackRealTimeActivityActorsConnection;
        builder.e = m20444a(realTimeActivityInfoModel.b());
        builder.f = realTimeActivityInfoModel.c();
        return new GraphQLFeedbackRealTimeActivityInfo(builder);
    }

    private static GraphQLTopReactionsConnection m20445a(TopReactionsModel topReactionsModel) {
        if (topReactionsModel == null) {
            return null;
        }
        GraphQLTopReactionsConnection.Builder builder = new GraphQLTopReactionsConnection.Builder();
        if (topReactionsModel.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < topReactionsModel.a().size(); i++) {
                GraphQLTopReactionsEdge graphQLTopReactionsEdge;
                EdgesModel edgesModel = (EdgesModel) topReactionsModel.a().get(i);
                if (edgesModel == null) {
                    graphQLTopReactionsEdge = null;
                } else {
                    GraphQLFeedbackReactionInfo graphQLFeedbackReactionInfo;
                    GraphQLTopReactionsEdge.Builder builder3 = new GraphQLTopReactionsEdge.Builder();
                    NodeModel a = edgesModel.a();
                    if (a == null) {
                        graphQLFeedbackReactionInfo = null;
                    } else {
                        GraphQLFeedbackReactionInfo.Builder builder4 = new GraphQLFeedbackReactionInfo.Builder();
                        builder4.g = a.a();
                        graphQLFeedbackReactionInfo = builder4.a();
                    }
                    builder3.d = graphQLFeedbackReactionInfo;
                    builder3.e = edgesModel.b();
                    graphQLTopReactionsEdge = builder3.a();
                }
                builder2.c(graphQLTopReactionsEdge);
            }
            builder.d = builder2.b();
        }
        return builder.a();
    }

    private static GraphQLFeedback m20439a(PandoraQueryFeedbackModel pandoraQueryFeedbackModel) {
        if (pandoraQueryFeedbackModel == null) {
            return null;
        }
        GraphQLImportantReactorsConnection graphQLImportantReactorsConnection;
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
        GraphQLReactorsOfContentConnection graphQLReactorsOfContentConnection;
        GraphQLResharesOfContentConnection graphQLResharesOfContentConnection;
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
        GraphQLPage graphQLPage;
        GraphQLUser graphQLUser;
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        builder.d = pandoraQueryFeedbackModel.m20750b();
        builder.b(pandoraQueryFeedbackModel.m20751c());
        builder.f = pandoraQueryFeedbackModel.m20752d();
        builder.g = pandoraQueryFeedbackModel.bT_();
        builder.h = pandoraQueryFeedbackModel.m20753g();
        builder.f(pandoraQueryFeedbackModel.bU_());
        builder.j = pandoraQueryFeedbackModel.m20761q();
        builder.k = pandoraQueryFeedbackModel.bV_();
        builder.n = pandoraQueryFeedbackModel.m20754j();
        builder.o = pandoraQueryFeedbackModel.m20762r();
        builder.p = pandoraQueryFeedbackModel.m20763s();
        builder.j(pandoraQueryFeedbackModel.m20755k());
        builder.v = pandoraQueryFeedbackModel.m20756l();
        ImportantReactorsModel t = pandoraQueryFeedbackModel.m20764t();
        if (t == null) {
            graphQLImportantReactorsConnection = null;
        } else {
            GraphQLImportantReactorsConnection.Builder builder2 = new GraphQLImportantReactorsConnection.Builder();
            if (t.a() != null) {
                ImmutableList.Builder builder3 = ImmutableList.builder();
                for (int i = 0; i < t.a().size(); i++) {
                    GraphQLActor graphQLActor;
                    ImportantReactorsModel.NodesModel nodesModel = (ImportantReactorsModel.NodesModel) t.a().get(i);
                    if (nodesModel == null) {
                        graphQLActor = null;
                    } else {
                        GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
                        builder4.aH = nodesModel.a();
                        builder4.V = nodesModel.b();
                        graphQLActor = builder4.a();
                    }
                    builder3.c(graphQLActor);
                }
                builder2.d = builder3.b();
            }
            graphQLImportantReactorsConnection = builder2.a();
        }
        builder.w = graphQLImportantReactorsConnection;
        builder.m(pandoraQueryFeedbackModel.m20757m());
        builder.A = pandoraQueryFeedbackModel.m20758n();
        LikersModel u = pandoraQueryFeedbackModel.m20765u();
        if (u == null) {
            graphQLLikersOfContentConnection = null;
        } else {
            GraphQLLikersOfContentConnection.Builder builder5 = new GraphQLLikersOfContentConnection.Builder();
            builder5.a(u.a());
            graphQLLikersOfContentConnection = builder5.a();
        }
        builder.C = graphQLLikersOfContentConnection;
        ReactorsModel v = pandoraQueryFeedbackModel.m20766v();
        if (v == null) {
            graphQLReactorsOfContentConnection = null;
        } else {
            GraphQLReactorsOfContentConnection.Builder builder6 = new GraphQLReactorsOfContentConnection.Builder();
            builder6.a(v.a());
            graphQLReactorsOfContentConnection = builder6.a();
        }
        builder.E = graphQLReactorsOfContentConnection;
        builder.F = m20440a(pandoraQueryFeedbackModel.m20767w());
        builder.G = pandoraQueryFeedbackModel.m20759o();
        ResharesModel x = pandoraQueryFeedbackModel.m20768x();
        if (x == null) {
            graphQLResharesOfContentConnection = null;
        } else {
            GraphQLResharesOfContentConnection.Builder builder7 = new GraphQLResharesOfContentConnection.Builder();
            builder7.a(x.a());
            graphQLResharesOfContentConnection = builder7.a();
        }
        builder.H = graphQLResharesOfContentConnection;
        builder.J = pandoraQueryFeedbackModel.m20769y();
        if (pandoraQueryFeedbackModel.m20770z() != null) {
            ImmutableList.Builder builder8 = ImmutableList.builder();
            for (int i2 = 0; i2 < pandoraQueryFeedbackModel.m20770z().size(); i2++) {
                GraphQLFeedbackReaction graphQLFeedbackReaction;
                SupportedReactionsModel supportedReactionsModel = (SupportedReactionsModel) pandoraQueryFeedbackModel.m20770z().get(i2);
                if (supportedReactionsModel == null) {
                    graphQLFeedbackReaction = null;
                } else {
                    GraphQLFeedbackReaction.Builder builder9 = new GraphQLFeedbackReaction.Builder();
                    builder9.d = supportedReactionsModel.a();
                    graphQLFeedbackReaction = builder9.a();
                }
                builder8.c(graphQLFeedbackReaction);
            }
            builder.K = builder8.b();
        }
        TopLevelCommentsModel A = pandoraQueryFeedbackModel.m20738A();
        if (A == null) {
            graphQLTopLevelCommentsConnection = null;
        } else {
            GraphQLTopLevelCommentsConnection.Builder builder10 = new GraphQLTopLevelCommentsConnection.Builder();
            builder10.a(A.a());
            builder10.b(A.b());
            graphQLTopLevelCommentsConnection = builder10.a();
        }
        builder.L = graphQLTopLevelCommentsConnection;
        builder.M = m20445a(pandoraQueryFeedbackModel.m20739B());
        ViewerActsAsPage p = pandoraQueryFeedbackModel.m20760p();
        if (p == null) {
            graphQLPage = null;
        } else {
            GraphQLPage.Builder builder11 = new GraphQLPage.Builder();
            builder11.Z = p.b();
            builder11.aF = p.c();
            builder11.bv = m20441a(p.d());
            graphQLPage = builder11.a();
        }
        builder.P = graphQLPage;
        ViewerActsAsPersonModel C = pandoraQueryFeedbackModel.m20740C();
        if (C == null) {
            graphQLUser = null;
        } else {
            GraphQLUser.Builder builder12 = new GraphQLUser.Builder();
            builder12.ar = C.a();
            graphQLUser = builder12.a();
        }
        builder.Q = graphQLUser;
        ViewerDoesNotLikeSentenceModel D = pandoraQueryFeedbackModel.m20741D();
        if (D == null) {
            graphQLTextWithEntities = null;
        } else {
            GraphQLTextWithEntities.Builder builder13 = new GraphQLTextWithEntities.Builder();
            builder13.i = D.m20716a();
            graphQLTextWithEntities = builder13.a();
        }
        builder.S = graphQLTextWithEntities;
        builder.a(pandoraQueryFeedbackModel.m20742E());
        ViewerLikesSentenceModel F = pandoraQueryFeedbackModel.m20743F();
        if (F == null) {
            graphQLTextWithEntities = null;
        } else {
            builder13 = new GraphQLTextWithEntities.Builder();
            builder13.i = F.m20721a();
            graphQLTextWithEntities = builder13.a();
        }
        builder.W = graphQLTextWithEntities;
        return builder.a();
    }

    private static GraphQLStory m20443a(CreationStoryModel creationStoryModel) {
        int i = 0;
        if (creationStoryModel == null) {
            return null;
        }
        GraphQLEntity graphQLEntity;
        GraphQLStory.Builder builder = new GraphQLStory.Builder();
        if (creationStoryModel.m20628a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < creationStoryModel.m20628a().size(); i2++) {
                GraphQLActor graphQLActor;
                ActorsModel actorsModel = (ActorsModel) creationStoryModel.m20628a().get(i2);
                if (actorsModel == null) {
                    graphQLActor = null;
                } else {
                    GraphQLActor.Builder builder3 = new GraphQLActor.Builder();
                    builder3.aH = actorsModel.m20566a();
                    builder3.L = actorsModel.m20571b();
                    builder3.V = actorsModel.m20572c();
                    graphQLActor = builder3.a();
                }
                builder2.c(graphQLActor);
            }
            builder.f = builder2.b();
        }
        if (creationStoryModel.m20632b() != null) {
            ImmutableList.Builder builder4 = ImmutableList.builder();
            while (i < creationStoryModel.m20632b().size()) {
                GraphQLStoryAttachment graphQLStoryAttachment;
                AttachmentsModel attachmentsModel = (AttachmentsModel) creationStoryModel.m20632b().get(i);
                if (attachmentsModel == null) {
                    graphQLStoryAttachment = null;
                } else {
                    GraphQLMedia graphQLMedia;
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    GraphQLNode graphQLNode;
                    GraphQLStoryAttachment.Builder builder5 = new GraphQLStoryAttachment.Builder();
                    MediaModel a = attachmentsModel.m20610a();
                    if (a == null) {
                        graphQLMedia = null;
                    } else {
                        GraphQLMedia.Builder builder6 = new GraphQLMedia.Builder();
                        builder6.bv = a.m20580b();
                        builder6.M = a.m20581c();
                        builder6.N = m20441a(a.m20582d());
                        graphQLMedia = builder6.a();
                    }
                    builder5.l = graphQLMedia;
                    SourceModel b = attachmentsModel.m20611b();
                    if (b == null) {
                        graphQLTextWithEntities = null;
                    } else {
                        GraphQLTextWithEntities.Builder builder7 = new GraphQLTextWithEntities.Builder();
                        builder7.i = b.m20588a();
                        graphQLTextWithEntities = builder7.a();
                    }
                    builder5.o = graphQLTextWithEntities;
                    builder5.q = attachmentsModel.m20612c();
                    TargetModel d = attachmentsModel.m20613d();
                    if (d == null) {
                        graphQLNode = null;
                    } else {
                        GraphQLApplication graphQLApplication;
                        GraphQLNode.Builder builder8 = new GraphQLNode.Builder();
                        builder8.kQ = d.m20600a();
                        ApplicationModel b2 = d.m20604b();
                        if (b2 == null) {
                            graphQLApplication = null;
                        } else {
                            GraphQLApplication.Builder builder9 = new GraphQLApplication.Builder();
                            builder9.o = b2.m20594b();
                            builder9.s = b2.m20595c();
                            graphQLApplication = builder9.a();
                        }
                        builder8.R = graphQLApplication;
                        graphQLNode = builder8.a();
                    }
                    builder5.t = graphQLNode;
                    builder5.u = attachmentsModel.cO_();
                    builder5.w = attachmentsModel.m20614g();
                    graphQLStoryAttachment = builder5.a();
                }
                builder4.c(graphQLStoryAttachment);
                i++;
            }
            builder.m = builder4.b();
        }
        builder.o = creationStoryModel.m20633c();
        builder.x = creationStoryModel.m20634d();
        builder.D = m20439a(creationStoryModel.cN_());
        ShareableModel g = creationStoryModel.m20635g();
        if (g == null) {
            graphQLEntity = null;
        } else {
            GraphQLEntity.Builder builder10 = new GraphQLEntity.Builder();
            builder10.S = g.m20622b();
            builder10.m = g.m20623c();
            graphQLEntity = builder10.a();
        }
        builder.al = graphQLEntity;
        builder.aC = creationStoryModel.cM_();
        return builder.a();
    }

    private static GraphQLFeedback m20438a(DefaultFeedbackFields defaultFeedbackFields) {
        if (defaultFeedbackFields == null) {
            return null;
        }
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        builder.d = defaultFeedbackFields.b();
        builder.b(defaultFeedbackFields.c());
        builder.f = defaultFeedbackFields.d();
        builder.h = defaultFeedbackFields.x_();
        builder.f(defaultFeedbackFields.g());
        builder.j(defaultFeedbackFields.y_());
        builder.v = defaultFeedbackFields.z_();
        builder.A = defaultFeedbackFields.j();
        Likers k = defaultFeedbackFields.k();
        if (k == null) {
            graphQLLikersOfContentConnection = null;
        } else {
            GraphQLLikersOfContentConnection.Builder builder2 = new GraphQLLikersOfContentConnection.Builder();
            builder2.a(k.a());
            graphQLLikersOfContentConnection = builder2.a();
        }
        builder.C = graphQLLikersOfContentConnection;
        TopLevelComments l = defaultFeedbackFields.l();
        if (l == null) {
            graphQLTopLevelCommentsConnection = null;
        } else {
            GraphQLTopLevelCommentsConnection.Builder builder3 = new GraphQLTopLevelCommentsConnection.Builder();
            builder3.a(l.a());
            builder3.b(l.b());
            graphQLTopLevelCommentsConnection = builder3.a();
        }
        builder.L = graphQLTopLevelCommentsConnection;
        return builder.a();
    }

    @Nullable
    public static GraphQLPhoto m20442a(PandoraMediaModel pandoraMediaModel) {
        if (pandoraMediaModel == null) {
            return null;
        }
        GraphQLObjectType b = pandoraMediaModel.mo1104b();
        if (b == null || b.g() != 77090322) {
            return null;
        }
        GraphQLVect2 graphQLVect2;
        GraphQLPhoto.Builder builder = new GraphQLPhoto.Builder();
        builder.d = pandoraMediaModel.m20662j();
        builder.w = m20443a(pandoraMediaModel.m20663k());
        builder.A = m20438a(pandoraMediaModel.mo1111l());
        DefaultVect2Fields c = pandoraMediaModel.mo1108c();
        if (c == null) {
            graphQLVect2 = null;
        } else {
            GraphQLVect2.Builder builder2 = new GraphQLVect2.Builder();
            builder2.d = c.a();
            builder2.e = c.b();
            graphQLVect2 = builder2.a();
        }
        builder.B = graphQLVect2;
        builder.F = pandoraMediaModel.mo1109d();
        builder.G = m20441a(pandoraMediaModel.be_());
        builder.I = m20441a(pandoraMediaModel.mo1110g());
        builder.P = m20441a(pandoraMediaModel.bd_());
        builder.S = m20441a(pandoraMediaModel.bc_());
        builder.ab = m20441a(pandoraMediaModel.mo1112n());
        builder.aj = pandoraMediaModel.m20668p();
        builder.al = m20441a(pandoraMediaModel.mo1113q());
        builder.an = m20441a(pandoraMediaModel.mo1114r());
        builder.ao = m20441a(pandoraMediaModel.mo1115s());
        builder.ax = m20441a(pandoraMediaModel.mo1116u());
        builder.ay = m20441a(pandoraMediaModel.mo1117v());
        builder.aH = pandoraMediaModel.m20675w();
        builder.aI = pandoraMediaModel.m20676x();
        builder.aJ = m20441a(pandoraMediaModel.mo1118y());
        builder.aU = m20441a(pandoraMediaModel.mo1119z());
        return builder.a();
    }

    @Nullable
    public static GraphQLVideo m20447b(PandoraMediaModel pandoraMediaModel) {
        if (pandoraMediaModel == null) {
            return null;
        }
        GraphQLObjectType b = pandoraMediaModel.mo1104b();
        if (b == null || b.g() != 82650203) {
            return null;
        }
        GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
        builder.u = m20443a(pandoraMediaModel.m20663k());
        builder.y = m20438a(pandoraMediaModel.mo1111l());
        builder.G = pandoraMediaModel.m20665m();
        builder.H = pandoraMediaModel.mo1109d();
        builder.I = m20441a(pandoraMediaModel.be_());
        builder.J = m20441a(pandoraMediaModel.mo1110g());
        builder.O = m20441a(pandoraMediaModel.bd_());
        builder.P = m20441a(pandoraMediaModel.bc_());
        builder.V = m20441a(pandoraMediaModel.mo1112n());
        builder.ah = pandoraMediaModel.m20667o();
        builder.ai = pandoraMediaModel.m20668p();
        builder.am = m20441a(pandoraMediaModel.mo1113q());
        builder.an = m20441a(pandoraMediaModel.mo1114r());
        builder.ao = m20441a(pandoraMediaModel.mo1115s());
        builder.ar = pandoraMediaModel.m20672t();
        builder.az = m20441a(pandoraMediaModel.mo1116u());
        builder.aA = m20441a(pandoraMediaModel.mo1117v());
        builder.aH = pandoraMediaModel.m20675w();
        builder.aI = pandoraMediaModel.m20676x();
        builder.aM = m20441a(pandoraMediaModel.mo1118y());
        builder.bp = m20441a(pandoraMediaModel.mo1119z());
        builder.bI = pandoraMediaModel.m20644A();
        return builder.a();
    }

    public static PandoraMediaModel m20446a(PandoraMediaImageWithFeedbackFields pandoraMediaImageWithFeedbackFields) {
        if (pandoraMediaImageWithFeedbackFields == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m20437a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new PandoraMediaModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m20435a(FlatBufferBuilder flatBufferBuilder, DefaultFeedbackFields defaultFeedbackFields) {
        if (defaultFeedbackFields == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(defaultFeedbackFields.z_());
        int b2 = flatBufferBuilder.b(defaultFeedbackFields.j());
        Likers k = defaultFeedbackFields.k();
        int i = 0;
        if (k != null) {
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, k.a(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        TopLevelComments l = defaultFeedbackFields.l();
        i = 0;
        if (l != null) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, l.a(), 0);
            flatBufferBuilder.a(1, l.b(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i3 = i;
        flatBufferBuilder.c(10);
        flatBufferBuilder.a(0, defaultFeedbackFields.b());
        flatBufferBuilder.a(1, defaultFeedbackFields.c());
        flatBufferBuilder.a(2, defaultFeedbackFields.d());
        flatBufferBuilder.a(3, defaultFeedbackFields.x_());
        flatBufferBuilder.a(4, defaultFeedbackFields.g());
        flatBufferBuilder.a(5, defaultFeedbackFields.y_());
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.b(7, b2);
        flatBufferBuilder.b(8, i2);
        flatBufferBuilder.b(9, i3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m20434a(FlatBufferBuilder flatBufferBuilder, DefaultVect2Fields defaultVect2Fields) {
        if (defaultVect2Fields == null) {
            return 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, defaultVect2Fields.a(), 0.0d);
        flatBufferBuilder.a(1, defaultVect2Fields.b(), 0.0d);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m20436a(FlatBufferBuilder flatBufferBuilder, DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(defaultImageFields.b());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, defaultImageFields.a(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, defaultImageFields.c(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m20437a(FlatBufferBuilder flatBufferBuilder, PandoraMediaImageWithFeedbackFields pandoraMediaImageWithFeedbackFields) {
        if (pandoraMediaImageWithFeedbackFields == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(pandoraMediaImageWithFeedbackFields.mo1104b());
        int a2 = m20435a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1111l());
        int a3 = m20434a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1108c());
        int b = flatBufferBuilder.b(pandoraMediaImageWithFeedbackFields.mo1109d());
        int a4 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.be_());
        int a5 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1110g());
        int a6 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.bd_());
        int a7 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.bc_());
        int a8 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1112n());
        int a9 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1113q());
        int a10 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1114r());
        int a11 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1115s());
        int a12 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1116u());
        int a13 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1117v());
        int a14 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1118y());
        int a15 = m20436a(flatBufferBuilder, pandoraMediaImageWithFeedbackFields.mo1119z());
        flatBufferBuilder.c(25);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.b(7, a4);
        flatBufferBuilder.b(8, a5);
        flatBufferBuilder.b(9, a6);
        flatBufferBuilder.b(10, a7);
        flatBufferBuilder.b(11, a8);
        flatBufferBuilder.b(14, a9);
        flatBufferBuilder.b(15, a10);
        flatBufferBuilder.b(16, a11);
        flatBufferBuilder.b(18, a12);
        flatBufferBuilder.b(19, a13);
        flatBufferBuilder.b(22, a14);
        flatBufferBuilder.b(23, a15);
        a = flatBufferBuilder.d();
        flatBufferBuilder.d(a);
        return a;
    }
}

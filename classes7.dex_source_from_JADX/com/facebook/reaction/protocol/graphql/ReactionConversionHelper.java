package com.facebook.reaction.protocol.graphql;

import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel;
import com.facebook.api.graphql.reactions.ReactionsGraphQLModels.ReactionsCountFieldsModel.TopReactionsModel.EdgesModel.NodeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel.TemplateTokensModel;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL.Page;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntitiesRange;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetRedirectionLinkGraphQLModel.RedirectionInfoModel;
import com.facebook.graphql.model.GraphQLActivityTemplateToken;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLEditHistoryConnection;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLEntityWithImage;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedbackReactionInfo;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLRedirectionInfo;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTopReactionsConnection;
import com.facebook.graphql.model.GraphQLTopReactionsConnection.Builder;
import com.facebook.graphql.model.GraphQLTopReactionsEdge;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionTextWithEntitiesWithImages;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.EntityWithImageScaledFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.EntityWithImageScaledFragmentModel.ImageModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionTextWithEntitiesWithImagesModel.ImageRangesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.AttachmentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.AttachmentsModel.SourceModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.AuthorModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.AuthorModel.ProfilePictureModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.EditHistoryModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.FeedbackModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.FeedbackModel.LikersModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitCommentComponentFragmentModel.CommentModel.ParentFeedbackModel;
import com.google.common.collect.ImmutableList;

/* compiled from: ffd3d962f3446d6252234dd8d9fcaa7e */
public final class ReactionConversionHelper {
    public static GraphQLTopReactionsConnection m16635a(TopReactionsModel topReactionsModel) {
        if (topReactionsModel == null) {
            return null;
        }
        Builder builder = new Builder();
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

    public static GraphQLImage m16631a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    public static GraphQLTaggableActivityPreviewTemplate m16632a(MinutiaePreviewTemplateModel minutiaePreviewTemplateModel) {
        if (minutiaePreviewTemplateModel == null) {
            return null;
        }
        GraphQLTaggableActivityPreviewTemplate.Builder builder = new GraphQLTaggableActivityPreviewTemplate.Builder();
        builder.d = minutiaePreviewTemplateModel.a();
        if (minutiaePreviewTemplateModel.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < minutiaePreviewTemplateModel.b().size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken;
                TemplateTokensModel templateTokensModel = (TemplateTokensModel) minutiaePreviewTemplateModel.b().get(i);
                if (templateTokensModel == null) {
                    graphQLActivityTemplateToken = null;
                } else {
                    GraphQLActivityTemplateToken.Builder builder3 = new GraphQLActivityTemplateToken.Builder();
                    builder3.d = templateTokensModel.a();
                    builder3.e = templateTokensModel.b();
                    graphQLActivityTemplateToken = builder3.a();
                }
                builder2.c(graphQLActivityTemplateToken);
            }
            builder.e = builder2.b();
        }
        return builder.a();
    }

    public static GraphQLTextWithEntities m16634a(ReactionTextWithEntitiesWithImages reactionTextWithEntitiesWithImages) {
        if (reactionTextWithEntitiesWithImages == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        if (reactionTextWithEntitiesWithImages.mo786b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < reactionTextWithEntitiesWithImages.mo786b().size(); i++) {
                GraphQLImageAtRange graphQLImageAtRange;
                ImageRangesModel imageRangesModel = (ImageRangesModel) reactionTextWithEntitiesWithImages.mo786b().get(i);
                if (imageRangesModel == null) {
                    graphQLImageAtRange = null;
                } else {
                    GraphQLEntityWithImage graphQLEntityWithImage;
                    GraphQLImageAtRange.Builder builder3 = new GraphQLImageAtRange.Builder();
                    EntityWithImageScaledFragmentModel a = imageRangesModel.m14664a();
                    if (a == null) {
                        graphQLEntityWithImage = null;
                    } else {
                        GraphQLImage graphQLImage;
                        GraphQLEntityWithImage.Builder builder4 = new GraphQLEntityWithImage.Builder();
                        builder4.f = a.m14427a();
                        ImageModel b = a.m14429b();
                        if (b == null) {
                            graphQLImage = null;
                        } else {
                            GraphQLImage.Builder builder5 = new GraphQLImage.Builder();
                            builder5.g = b.m14422a();
                            graphQLImage = builder5.a();
                        }
                        builder4.e = graphQLImage;
                        graphQLEntityWithImage = builder4.a();
                    }
                    builder3.d = graphQLEntityWithImage;
                    builder3.e = imageRangesModel.m14666b();
                    builder3.f = imageRangesModel.m14667c();
                    graphQLImageAtRange = builder3.a();
                }
                builder2.c(graphQLImageAtRange);
            }
            builder.f = builder2.b();
        }
        builder.i = reactionTextWithEntitiesWithImages.mo785a();
        return builder.a();
    }

    public static GraphQLTextWithEntities m16633a(LinkableTextWithEntities linkableTextWithEntities) {
        if (linkableTextWithEntities == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        if (linkableTextWithEntities.b() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < linkableTextWithEntities.b().size(); i++) {
                GraphQLEntityAtRange graphQLEntityAtRange;
                LinkableTextWithEntitiesRange linkableTextWithEntitiesRange = (LinkableTextWithEntitiesRange) linkableTextWithEntities.b().get(i);
                if (linkableTextWithEntitiesRange == null) {
                    graphQLEntityAtRange = null;
                } else {
                    GraphQLEntity graphQLEntity;
                    GraphQLEntityAtRange.Builder builder3 = new GraphQLEntityAtRange.Builder();
                    GetEntityFbLinkGraphQL a = linkableTextWithEntitiesRange.a();
                    if (a == null) {
                        graphQLEntity = null;
                    } else {
                        GraphQLPage graphQLPage;
                        GraphQLEntity.Builder builder4 = new GraphQLEntity.Builder();
                        builder4.S = a.b();
                        builder4.m = a.d();
                        builder4.u = a.C_();
                        Page j = a.j();
                        if (j == null) {
                            graphQLPage = null;
                        } else {
                            GraphQLPage.Builder builder5 = new GraphQLPage.Builder();
                            builder5.Z = j.d();
                            graphQLPage = builder5.a();
                        }
                        builder4.v = graphQLPage;
                        if (a.k() != null) {
                            ImmutableList.Builder builder6 = ImmutableList.builder();
                            for (int i2 = 0; i2 < a.k().size(); i2++) {
                                Object obj;
                                RedirectionInfoModel redirectionInfoModel = (RedirectionInfoModel) a.k().get(i2);
                                if (redirectionInfoModel == null) {
                                    obj = null;
                                } else {
                                    GraphQLRedirectionInfo.Builder builder7 = new GraphQLRedirectionInfo.Builder();
                                    builder7.f = redirectionInfoModel.a();
                                    GraphQLRedirectionInfo graphQLRedirectionInfo = new GraphQLRedirectionInfo(builder7);
                                }
                                builder6.c(obj);
                            }
                            builder4.F = builder6.b();
                        }
                        builder4.O = a.g();
                        builder4.P = a.D_();
                        graphQLEntity = builder4.a();
                    }
                    builder3.d = graphQLEntity;
                    builder3.e = linkableTextWithEntitiesRange.b();
                    builder3.f = linkableTextWithEntitiesRange.c();
                    graphQLEntityAtRange = builder3.a();
                }
                builder2.c(graphQLEntityAtRange);
            }
            builder.h = builder2.b();
        }
        builder.i = linkableTextWithEntities.a();
        return builder.a();
    }

    private static GraphQLActor m16628a(AuthorModel authorModel) {
        if (authorModel == null) {
            return null;
        }
        GraphQLImage graphQLImage;
        GraphQLActor.Builder builder = new GraphQLActor.Builder();
        builder.aH = authorModel.m17137b();
        builder.B = authorModel.m17138c();
        builder.V = authorModel.m17139d();
        ProfilePictureModel gf_ = authorModel.gf_();
        if (gf_ == null) {
            graphQLImage = null;
        } else {
            GraphQLImage.Builder builder2 = new GraphQLImage.Builder();
            builder2.g = gf_.m17128a();
            graphQLImage = builder2.a();
        }
        builder.ad = graphQLImage;
        return builder.a();
    }

    private static GraphQLFeedback m16630a(FeedbackModel feedbackModel) {
        if (feedbackModel == null) {
            return null;
        }
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
        GraphQLFeedback.Builder builder = new GraphQLFeedback.Builder();
        builder.b(feedbackModel.m17169b());
        builder.f(feedbackModel.m17170c());
        builder.j(feedbackModel.m17171d());
        builder.v = feedbackModel.gg_();
        builder.A = feedbackModel.m17172g();
        LikersModel gh_ = feedbackModel.gh_();
        if (gh_ == null) {
            graphQLLikersOfContentConnection = null;
        } else {
            GraphQLLikersOfContentConnection.Builder builder2 = new GraphQLLikersOfContentConnection.Builder();
            builder2.a(gh_.m17152a());
            graphQLLikersOfContentConnection = builder2.a();
        }
        builder.C = graphQLLikersOfContentConnection;
        return builder.a();
    }

    public static GraphQLComment m16629a(CommentModel commentModel) {
        if (commentModel == null) {
            return null;
        }
        GraphQLEditHistoryConnection graphQLEditHistoryConnection;
        GraphQLFeedback graphQLFeedback;
        GraphQLComment.Builder builder = new GraphQLComment.Builder();
        if (commentModel.m17191a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < commentModel.m17191a().size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment;
                AttachmentsModel attachmentsModel = (AttachmentsModel) commentModel.m17191a().get(i);
                if (attachmentsModel == null) {
                    graphQLStoryAttachment = null;
                } else {
                    GraphQLMedia graphQLMedia;
                    GraphQLTextWithEntities graphQLTextWithEntities;
                    GraphQLStoryAttachment.Builder builder3 = new GraphQLStoryAttachment.Builder();
                    builder3.h = m16633a(attachmentsModel.m17116a());
                    SizeAwareMedia b = attachmentsModel.m17118b();
                    if (b == null) {
                        graphQLMedia = null;
                    } else {
                        GraphQLVect2 graphQLVect2;
                        GraphQLMedia.Builder builder4 = new GraphQLMedia.Builder();
                        builder4.bv = b.b();
                        DefaultVect2Fields c = b.c();
                        if (c == null) {
                            graphQLVect2 = null;
                        } else {
                            GraphQLVect2.Builder builder5 = new GraphQLVect2.Builder();
                            builder5.d = c.a();
                            builder5.e = c.b();
                            graphQLVect2 = builder5.a();
                        }
                        builder4.D = graphQLVect2;
                        builder4.M = b.d();
                        builder4.N = m16631a(b.be_());
                        builder4.O = m16631a(b.g());
                        builder4.T = m16631a(b.bd_());
                        builder4.U = m16631a(b.bc_());
                        graphQLMedia = builder4.a();
                    }
                    builder3.l = graphQLMedia;
                    builder3.n = attachmentsModel.m17119c();
                    SourceModel d = attachmentsModel.m17120d();
                    if (d == null) {
                        graphQLTextWithEntities = null;
                    } else {
                        GraphQLTextWithEntities.Builder builder6 = new GraphQLTextWithEntities.Builder();
                        builder6.i = d.m17110a();
                        graphQLTextWithEntities = builder6.a();
                    }
                    builder3.o = graphQLTextWithEntities;
                    builder3.q = attachmentsModel.gd_();
                    builder3.u = attachmentsModel.m17121g();
                    builder3.w = attachmentsModel.ge_();
                    graphQLStoryAttachment = builder3.a();
                }
                builder2.c(graphQLStoryAttachment);
            }
            builder.f = builder2.b();
        }
        builder.g = m16628a(commentModel.m17193b());
        builder.h = m16633a(commentModel.m17194c());
        builder.m = commentModel.m17195d();
        EditHistoryModel gc_ = commentModel.gc_();
        if (gc_ == null) {
            graphQLEditHistoryConnection = null;
        } else {
            GraphQLEditHistoryConnection.Builder builder7 = new GraphQLEditHistoryConnection.Builder();
            builder7.d = gc_.m17144a();
            graphQLEditHistoryConnection = builder7.a();
        }
        builder.n = graphQLEditHistoryConnection;
        builder.o = m16630a(commentModel.m17196g());
        ParentFeedbackModel gb_ = commentModel.gb_();
        if (gb_ == null) {
            graphQLFeedback = null;
        } else {
            GraphQLFeedback.Builder builder8 = new GraphQLFeedback.Builder();
            builder8.A = gb_.m17181b();
            graphQLFeedback = builder8.a();
        }
        builder.v = graphQLFeedback;
        return builder.a();
    }
}

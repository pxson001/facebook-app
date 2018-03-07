package com.facebook.photos.albums.protocols;

import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel.KeyframesModel;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLCommentsConnection;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLImage.Builder;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.GraphQLVideoGuidedTour;
import com.facebook.graphql.model.GraphQLVideoGuidedTourKeyframe;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel.MediaModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel.MediaModel.MediaCreationStoryModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel.MediaModel.MediaCreationStoryModel.ActorsModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel.TargetModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.AttachmentsModel.TargetModel.ApplicationModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel.CommentsModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.FeedbackModel.LikersModel;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel.CreationStoryModel.ShareableModel;
import com.google.common.collect.ImmutableList;

/* compiled from: intro_step_closed */
public final class VideoConversionHelper {
    public static GraphQLImage m19518a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        Builder builder = new Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    public static GraphQLTextWithEntities m19520a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        if (defaultTextWithEntitiesFields == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.i = defaultTextWithEntitiesFields.a();
        return builder.a();
    }

    public static GraphQLStoryAttachment m19519a(AttachmentsModel attachmentsModel) {
        if (attachmentsModel == null) {
            return null;
        }
        GraphQLMedia graphQLMedia;
        GraphQLNode graphQLNode;
        GraphQLStoryAttachment.Builder builder = new GraphQLStoryAttachment.Builder();
        MediaModel a = attachmentsModel.m19625a();
        if (a == null) {
            graphQLMedia = null;
        } else {
            GraphQLStory graphQLStory;
            GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
            builder2.bv = a.m19588b();
            builder2.k = a.m19589c();
            MediaCreationStoryModel d = a.m19590d();
            if (d == null) {
                graphQLStory = null;
            } else {
                GraphQLStory.Builder builder3 = new GraphQLStory.Builder();
                if (d.m19578b() != null) {
                    ImmutableList.Builder builder4 = ImmutableList.builder();
                    for (int i = 0; i < d.m19578b().size(); i++) {
                        GraphQLActor graphQLActor;
                        ActorsModel actorsModel = (ActorsModel) d.m19578b().get(i);
                        if (actorsModel == null) {
                            graphQLActor = null;
                        } else {
                            GraphQLActor.Builder builder5 = new GraphQLActor.Builder();
                            builder5.aH = actorsModel.m19565a();
                            builder5.V = actorsModel.m19569b();
                            graphQLActor = builder5.a();
                        }
                        builder4.c(graphQLActor);
                    }
                    builder3.f = builder4.b();
                }
                builder3.K = d.m19579c();
                graphQLStory = builder3.a();
            }
            builder2.z = graphQLStory;
            builder2.J = a.dd_();
            builder2.L = a.m19591g();
            builder2.M = a.de_();
            builder2.N = m19518a(a.df_());
            builder2.am = a.m19592j();
            builder2.ap = a.m19593k();
            builder2.aJ = a.m19594l();
            builder2.aM = a.m19595m();
            builder2.aN = a.m19596n();
            builder2.aR = a.m19597o();
            builder2.bm = a.m19598p();
            builder2.bt = a.m19599q();
            graphQLMedia = builder2.a();
        }
        builder.l = graphQLMedia;
        builder.o = m19520a(attachmentsModel.m19626b());
        builder.q = attachmentsModel.m19627c();
        TargetModel d2 = attachmentsModel.m19628d();
        if (d2 == null) {
            graphQLNode = null;
        } else {
            GraphQLApplication graphQLApplication;
            GraphQLNode.Builder builder6 = new GraphQLNode.Builder();
            builder6.kQ = d2.m19614a();
            ApplicationModel b = d2.m19618b();
            if (b == null) {
                graphQLApplication = null;
            } else {
                GraphQLApplication.Builder builder7 = new GraphQLApplication.Builder();
                builder7.o = b.m19607b();
                builder7.s = b.m19608c();
                graphQLApplication = builder7.a();
            }
            builder6.R = graphQLApplication;
            graphQLNode = builder6.a();
        }
        builder.t = graphQLNode;
        builder.u = attachmentsModel.dc_();
        builder.w = attachmentsModel.m19629g();
        return builder.a();
    }

    private static GraphQLVideoGuidedTour m19522a(GuidedTourModel guidedTourModel) {
        if (guidedTourModel == null) {
            return null;
        }
        GraphQLVideoGuidedTour.Builder builder = new GraphQLVideoGuidedTour.Builder();
        if (guidedTourModel.a() != null) {
            ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < guidedTourModel.a().size(); i++) {
                Object obj;
                KeyframesModel keyframesModel = (KeyframesModel) guidedTourModel.a().get(i);
                if (keyframesModel == null) {
                    obj = null;
                } else {
                    GraphQLVideoGuidedTourKeyframe.Builder builder3 = new GraphQLVideoGuidedTourKeyframe.Builder();
                    builder3.d = keyframesModel.a();
                    builder3.e = keyframesModel.b();
                    builder3.f = keyframesModel.c();
                    GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe = new GraphQLVideoGuidedTourKeyframe(builder3);
                }
                builder2.c(obj);
            }
            builder.d = builder2.b();
        }
        return new GraphQLVideoGuidedTour(builder);
    }

    public static GraphQLVideo m19521a(VideoDetailFragmentModel videoDetailFragmentModel) {
        if (videoDetailFragmentModel == null) {
            return null;
        }
        GraphQLStory graphQLStory;
        GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
        builder.n = videoDetailFragmentModel.m19714b();
        builder.o = videoDetailFragmentModel.m19715c();
        builder.q = videoDetailFragmentModel.m19716d();
        builder.t = videoDetailFragmentModel.cW_();
        CreationStoryModel g = videoDetailFragmentModel.m19717g();
        int i = 0;
        if (g == null) {
            graphQLStory = null;
        } else {
            GraphQLFeedback graphQLFeedback;
            GraphQLEntity graphQLEntity;
            GraphQLStory.Builder builder2 = new GraphQLStory.Builder();
            if (g.m19684b() != null) {
                ImmutableList.Builder builder3 = ImmutableList.builder();
                for (int i2 = 0; i2 < g.m19684b().size(); i2++) {
                    GraphQLActor graphQLActor;
                    CreationStoryModel.ActorsModel actorsModel = (CreationStoryModel.ActorsModel) g.m19684b().get(i2);
                    if (actorsModel == null) {
                        graphQLActor = null;
                    } else {
                        GraphQLActor.Builder builder4 = new GraphQLActor.Builder();
                        builder4.aH = actorsModel.m19554a();
                        builder4.V = actorsModel.m19558b();
                        graphQLActor = builder4.a();
                    }
                    builder3.c(graphQLActor);
                }
                builder2.f = builder3.b();
            }
            if (g.m19685c() != null) {
                ImmutableList.Builder builder5 = ImmutableList.builder();
                while (i < g.m19685c().size()) {
                    builder5.c(m19519a((AttachmentsModel) g.m19685c().get(i)));
                    i++;
                }
                builder2.m = builder5.b();
            }
            FeedbackModel d = g.m19686d();
            if (d == null) {
                graphQLFeedback = null;
            } else {
                GraphQLCommentsConnection graphQLCommentsConnection;
                GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
                GraphQLFeedback.Builder builder6 = new GraphQLFeedback.Builder();
                builder6.d = d.m19662b();
                builder6.b(d.m19663c());
                builder6.f(d.m19664d());
                CommentsModel di_ = d.di_();
                if (di_ == null) {
                    graphQLCommentsConnection = null;
                } else {
                    GraphQLCommentsConnection.Builder builder7 = new GraphQLCommentsConnection.Builder();
                    builder7.a(di_.m19636a());
                    graphQLCommentsConnection = builder7.a();
                }
                builder6.l = graphQLCommentsConnection;
                builder6.j(d.m19665g());
                builder6.v = d.dg_();
                builder6.A = d.dh_();
                LikersModel j = d.m19666j();
                if (j == null) {
                    graphQLLikersOfContentConnection = null;
                } else {
                    GraphQLLikersOfContentConnection.Builder builder8 = new GraphQLLikersOfContentConnection.Builder();
                    builder8.a(j.m19646a());
                    graphQLLikersOfContentConnection = builder8.a();
                }
                builder6.C = graphQLLikersOfContentConnection;
                graphQLFeedback = builder6.a();
            }
            builder2.D = graphQLFeedback;
            builder2.K = g.cZ_();
            builder2.X = m19520a(g.m19687g());
            ShareableModel db_ = g.db_();
            if (db_ == null) {
                graphQLEntity = null;
            } else {
                GraphQLEntity.Builder builder9 = new GraphQLEntity.Builder();
                builder9.S = db_.m19676b();
                builder9.m = db_.m19677c();
                graphQLEntity = builder9.a();
            }
            builder2.al = graphQLEntity;
            builder2.aw = m19520a(g.da_());
            builder2.ay = m19520a(g.m19688j());
            graphQLStory = builder2.a();
        }
        builder.u = graphQLStory;
        builder.z = m19522a(videoDetailFragmentModel.cY_());
        builder.G = videoDetailFragmentModel.cX_();
        builder.H = videoDetailFragmentModel.m19718j();
        builder.Y = videoDetailFragmentModel.m19719k();
        builder.Z = videoDetailFragmentModel.m19720l();
        builder.aa = videoDetailFragmentModel.m19721m();
        builder.ah = videoDetailFragmentModel.m19722n();
        builder.ai = videoDetailFragmentModel.m19723o();
        builder.ak = videoDetailFragmentModel.m19724p();
        builder.al = videoDetailFragmentModel.m19725q();
        builder.ar = videoDetailFragmentModel.m19726r();
        builder.at = m19520a(videoDetailFragmentModel.m19727s());
        builder.aC = videoDetailFragmentModel.m19728t();
        builder.aH = videoDetailFragmentModel.m19729u();
        builder.aI = videoDetailFragmentModel.m19730v();
        builder.aJ = videoDetailFragmentModel.m19731w();
        builder.aY = videoDetailFragmentModel.m19732x();
        builder.bi = videoDetailFragmentModel.m19733y();
        builder.bj = videoDetailFragmentModel.m19734z();
        builder.bk = videoDetailFragmentModel.m19697A();
        builder.bl = videoDetailFragmentModel.m19698B();
        builder.bn = videoDetailFragmentModel.m19699C();
        builder.bs = videoDetailFragmentModel.m19700D();
        builder.bu = m19520a(videoDetailFragmentModel.m19701E());
        builder.by = m19518a(videoDetailFragmentModel.m19702F());
        builder.bz = videoDetailFragmentModel.m19703G();
        builder.bI = videoDetailFragmentModel.m19704H();
        return builder.a();
    }
}

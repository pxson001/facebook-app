package com.facebook.friendsharing.souvenirs.protocols;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsDetailsFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel.CreationStoryModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel.CreationStoryModel.FeedbackModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel.CreationStoryModel.FeedbackModel.CommentsModel;
import com.facebook.friendsharing.souvenirs.protocols.FetchSouvenirsModels.SouvenirsMediaFieldsModel.CreationStoryModel.FeedbackModel.LikersModel;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLCommentsConnection;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLSouvenirMediaConnection;
import com.facebook.graphql.model.GraphQLSouvenirMediaEdge;
import com.facebook.graphql.model.GraphQLSouvenirMediaElement;
import com.facebook.graphql.model.GraphQLSouvenirMediaElementMediaConnection;
import com.facebook.graphql.model.GraphQLSouvenirMediaElementMediaEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: REDIRECTION */
public final class SouvenirsConversionHelper {
    @Nullable
    public static SouvenirsDetailsFieldsModel m26429a(GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m26423a(flatBufferBuilder, graphQLNode);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new SouvenirsDetailsFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static int m26427a(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        GraphQLFeedback l = graphQLStory.l();
        int i = 0;
        if (l != null) {
            GraphQLCommentsConnection p = l.p();
            int i2 = 0;
            if (p != null) {
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, p.a(), 0);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            int b = flatBufferBuilder.b(l.z_());
            int b2 = flatBufferBuilder.b(l.j());
            GraphQLLikersOfContentConnection C = l.C();
            i2 = 0;
            if (C != null) {
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, C.a(), 0);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i4 = i2;
            flatBufferBuilder.c(8);
            flatBufferBuilder.a(0, l.b());
            flatBufferBuilder.a(1, l.c());
            flatBufferBuilder.a(2, l.g());
            flatBufferBuilder.b(3, i3);
            flatBufferBuilder.a(4, l.y_());
            flatBufferBuilder.b(5, b);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, i4);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i5 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i5);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m26428a(FlatBufferBuilder flatBufferBuilder, GraphQLVect2 graphQLVect2) {
        if (graphQLVect2 == null) {
            return 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, graphQLVect2.a(), 0.0d);
        flatBufferBuilder.a(1, graphQLVect2.b(), 0.0d);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m26422a(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLImage.b());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, graphQLImage.a(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, graphQLImage.c(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m26426a(FlatBufferBuilder flatBufferBuilder, GraphQLSouvenirMediaElementMediaEdge graphQLSouvenirMediaElementMediaEdge) {
        if (graphQLSouvenirMediaElementMediaEdge == null) {
            return 0;
        }
        GraphQLMedia a = graphQLSouvenirMediaElementMediaEdge.a();
        int i = 0;
        if (a != null) {
            int a2 = flatBufferBuilder.a(a.j());
            int a3 = m26427a(flatBufferBuilder, a.F());
            int a4 = m26428a(flatBufferBuilder, a.J());
            int b = flatBufferBuilder.b(a.b());
            int a5 = m26422a(flatBufferBuilder, a.S());
            int a6 = m26422a(flatBufferBuilder, a.T());
            int a7 = m26422a(flatBufferBuilder, a.Y());
            int a8 = m26422a(flatBufferBuilder, a.Z());
            int b2 = flatBufferBuilder.b(a.aO());
            flatBufferBuilder.c(15);
            flatBufferBuilder.b(0, a2);
            flatBufferBuilder.a(1, a.t());
            flatBufferBuilder.a(2, a.y());
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            flatBufferBuilder.a(5, a.R(), 0);
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, a7);
            flatBufferBuilder.b(10, a8);
            flatBufferBuilder.a(11, a.an());
            flatBufferBuilder.a(12, a.aN(), 0);
            flatBufferBuilder.b(13, b2);
            flatBufferBuilder.a(14, a.bo(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m26425a(FlatBufferBuilder flatBufferBuilder, GraphQLSouvenirMediaEdge graphQLSouvenirMediaEdge) {
        if (graphQLSouvenirMediaEdge == null) {
            return 0;
        }
        GraphQLSouvenirMediaElement a = graphQLSouvenirMediaEdge.a();
        int i = 0;
        if (a != null) {
            int b = flatBufferBuilder.b(a.j());
            GraphQLSouvenirMediaElementMediaConnection l = a.l();
            int i2 = 0;
            if (l != null) {
                int a2;
                ImmutableList a3 = l.a();
                if (a3 != null) {
                    int[] iArr = new int[a3.size()];
                    for (int i3 = 0; i3 < a3.size(); i3++) {
                        iArr[i3] = m26426a(flatBufferBuilder, (GraphQLSouvenirMediaElementMediaEdge) a3.get(i3));
                    }
                    a2 = flatBufferBuilder.a(iArr, true);
                } else {
                    a2 = 0;
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a2);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i4 = i2;
            int a4 = flatBufferBuilder.a(a.m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, a.k());
            flatBufferBuilder.b(2, i4);
            flatBufferBuilder.b(3, a4);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i5 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i5);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m26424a(FlatBufferBuilder flatBufferBuilder, GraphQLPhoto graphQLPhoto) {
        if (graphQLPhoto == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(new GraphQLObjectType(77090322));
        int a2 = m26428a(flatBufferBuilder, graphQLPhoto.G());
        int b = flatBufferBuilder.b(graphQLPhoto.K());
        int a3 = m26422a(flatBufferBuilder, graphQLPhoto.L());
        int a4 = m26422a(flatBufferBuilder, graphQLPhoto.N());
        int a5 = m26422a(flatBufferBuilder, graphQLPhoto.U());
        int a6 = m26422a(flatBufferBuilder, graphQLPhoto.X());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, a6);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m26423a(FlatBufferBuilder flatBufferBuilder, GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return 0;
        }
        GraphQLObjectType j = graphQLNode.j();
        if (j == null || j.g() != 1814734639) {
            return 0;
        }
        int i;
        int a;
        int b = flatBufferBuilder.b(graphQLNode.dp());
        GraphQLSouvenirMediaConnection ex = graphQLNode.ex();
        int i2 = 0;
        if (ex != null) {
            ImmutableList a2 = ex.a();
            if (a2 != null) {
                int[] iArr = new int[a2.size()];
                for (i = 0; i < a2.size(); i++) {
                    iArr[i] = m26425a(flatBufferBuilder, (GraphQLSouvenirMediaEdge) a2.get(i));
                }
                a = flatBufferBuilder.a(iArr, true);
            } else {
                a = 0;
            }
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i2 = flatBufferBuilder.d();
            flatBufferBuilder.d(i2);
        }
        int i3 = i2;
        int a3 = m26424a(flatBufferBuilder, graphQLNode.hz());
        GraphQLTextWithEntities it = graphQLNode.it();
        a = 0;
        if (it != null) {
            i = flatBufferBuilder.b(it.a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, i);
            a = flatBufferBuilder.d();
            flatBufferBuilder.d(a);
        }
        int i4 = a;
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, i3);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, i4);
        b = flatBufferBuilder.d();
        flatBufferBuilder.d(b);
        return b;
    }

    private static GraphQLStory m26432a(CreationStoryModel creationStoryModel) {
        if (creationStoryModel == null) {
            return null;
        }
        GraphQLFeedback graphQLFeedback;
        Builder builder = new Builder();
        FeedbackModel a = creationStoryModel.m26367a();
        if (a == null) {
            graphQLFeedback = null;
        } else {
            GraphQLCommentsConnection graphQLCommentsConnection;
            GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
            GraphQLFeedback.Builder builder2 = new GraphQLFeedback.Builder();
            builder2.d = a.m26359b();
            builder2.b(a.m26360c());
            builder2.f(a.m26361d());
            CommentsModel hv_ = a.hv_();
            if (hv_ == null) {
                graphQLCommentsConnection = null;
            } else {
                GraphQLCommentsConnection.Builder builder3 = new GraphQLCommentsConnection.Builder();
                builder3.a(hv_.m26334a());
                graphQLCommentsConnection = builder3.a();
            }
            builder2.l = graphQLCommentsConnection;
            builder2.j(a.m26362g());
            builder2.v = a.ht_();
            builder2.A = a.hu_();
            LikersModel j = a.m26363j();
            if (j == null) {
                graphQLLikersOfContentConnection = null;
            } else {
                GraphQLLikersOfContentConnection.Builder builder4 = new GraphQLLikersOfContentConnection.Builder();
                builder4.a(j.m26342a());
                graphQLLikersOfContentConnection = builder4.a();
            }
            builder2.C = graphQLLikersOfContentConnection;
            graphQLFeedback = builder2.a();
        }
        builder.D = graphQLFeedback;
        return builder.a();
    }

    private static GraphQLImage m26430a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    @Nullable
    public static GraphQLPhoto m26431a(SouvenirsMediaFieldsModel souvenirsMediaFieldsModel) {
        if (souvenirsMediaFieldsModel == null) {
            return null;
        }
        GraphQLObjectType b = souvenirsMediaFieldsModel.m26383b();
        if (b == null || b.g() != 77090322) {
            return null;
        }
        GraphQLVect2 graphQLVect2;
        GraphQLPhoto.Builder builder = new GraphQLPhoto.Builder();
        builder.m = souvenirsMediaFieldsModel.m26387j();
        builder.r = souvenirsMediaFieldsModel.m26388k();
        builder.w = m26432a(souvenirsMediaFieldsModel.m26389l());
        DefaultVect2Fields c = souvenirsMediaFieldsModel.m26384c();
        if (c == null) {
            graphQLVect2 = null;
        } else {
            GraphQLVect2.Builder builder2 = new GraphQLVect2.Builder();
            builder2.d = c.a();
            builder2.e = c.b();
            graphQLVect2 = builder2.a();
        }
        builder.B = graphQLVect2;
        builder.F = souvenirsMediaFieldsModel.m26385d();
        builder.G = m26430a(souvenirsMediaFieldsModel.be_());
        builder.I = m26430a(souvenirsMediaFieldsModel.m26386g());
        builder.P = m26430a(souvenirsMediaFieldsModel.bd_());
        builder.S = m26430a(souvenirsMediaFieldsModel.bc_());
        builder.aj = souvenirsMediaFieldsModel.m26391n();
        builder.aH = souvenirsMediaFieldsModel.m26392o();
        builder.aI = souvenirsMediaFieldsModel.m26393p();
        return builder.a();
    }

    @Nullable
    public static GraphQLVideo m26433b(SouvenirsMediaFieldsModel souvenirsMediaFieldsModel) {
        if (souvenirsMediaFieldsModel == null) {
            return null;
        }
        GraphQLObjectType b = souvenirsMediaFieldsModel.m26383b();
        if (b == null || b.g() != 82650203) {
            return null;
        }
        GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
        builder.n = souvenirsMediaFieldsModel.m26387j();
        builder.o = souvenirsMediaFieldsModel.m26388k();
        builder.u = m26432a(souvenirsMediaFieldsModel.m26389l());
        builder.G = souvenirsMediaFieldsModel.m26390m();
        builder.H = souvenirsMediaFieldsModel.m26385d();
        builder.I = m26430a(souvenirsMediaFieldsModel.be_());
        builder.J = m26430a(souvenirsMediaFieldsModel.m26386g());
        builder.O = m26430a(souvenirsMediaFieldsModel.bd_());
        builder.P = m26430a(souvenirsMediaFieldsModel.bc_());
        builder.ai = souvenirsMediaFieldsModel.m26391n();
        builder.aH = souvenirsMediaFieldsModel.m26392o();
        builder.aI = souvenirsMediaFieldsModel.m26393p();
        builder.bI = souvenirsMediaFieldsModel.m26394q();
        return builder.a();
    }
}

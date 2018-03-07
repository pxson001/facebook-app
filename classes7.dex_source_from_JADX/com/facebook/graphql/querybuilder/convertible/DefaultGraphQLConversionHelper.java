package com.facebook.graphql.querybuilder.convertible;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLikersOfContentConnection;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTopLevelCommentsConnection;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.Likers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields.TopLevelComments;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: registration_error */
public final class DefaultGraphQLConversionHelper {
    public static GraphQLFeedback m5796a(DefaultFeedbackFields defaultFeedbackFields) {
        if (defaultFeedbackFields == null) {
            return null;
        }
        GraphQLLikersOfContentConnection graphQLLikersOfContentConnection;
        GraphQLTopLevelCommentsConnection graphQLTopLevelCommentsConnection;
        Builder builder = new Builder();
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

    public static GraphQLImage m5797a(DefaultImageFields defaultImageFields) {
        if (defaultImageFields == null) {
            return null;
        }
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.d = defaultImageFields.a();
        builder.g = defaultImageFields.b();
        builder.h = defaultImageFields.c();
        return builder.a();
    }

    public static GraphQLPageInfo m5798a(DefaultPageInfoFields defaultPageInfoFields) {
        if (defaultPageInfoFields == null) {
            return null;
        }
        GraphQLPageInfo.Builder builder = new GraphQLPageInfo.Builder();
        builder.e = defaultPageInfoFields.a();
        builder.f = defaultPageInfoFields.b();
        builder.g = defaultPageInfoFields.c();
        builder.h = defaultPageInfoFields.v_();
        return builder.a();
    }

    public static GraphQLTextWithEntities m5799a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
        if (defaultTextWithEntitiesFields == null) {
            return null;
        }
        GraphQLTextWithEntities.Builder builder = new GraphQLTextWithEntities.Builder();
        builder.i = defaultTextWithEntitiesFields.a();
        return builder.a();
    }

    public static GraphQLTextWithEntities m5800a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
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

    public static DefaultFeedbackFieldsModel m5802a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLFeedback != null) {
            int b = flatBufferBuilder.b(graphQLFeedback.z_());
            int b2 = flatBufferBuilder.b(graphQLFeedback.j());
            GraphQLLikersOfContentConnection C = graphQLFeedback.C();
            int i2 = 0;
            if (C != null) {
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, C.a(), 0);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            GraphQLTopLevelCommentsConnection L = graphQLFeedback.L();
            i2 = 0;
            if (L != null) {
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, L.a(), 0);
                flatBufferBuilder.a(1, L.b(), 0);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i4 = i2;
            flatBufferBuilder.c(10);
            flatBufferBuilder.a(0, graphQLFeedback.b());
            flatBufferBuilder.a(1, graphQLFeedback.c());
            flatBufferBuilder.a(2, graphQLFeedback.d());
            flatBufferBuilder.a(3, graphQLFeedback.x_());
            flatBufferBuilder.a(4, graphQLFeedback.g());
            flatBufferBuilder.a(5, graphQLFeedback.y_());
            flatBufferBuilder.b(6, b);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, i3);
            flatBufferBuilder.b(9, i4);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i5 = i;
        if (i5 == 0) {
            return null;
        }
        flatBufferBuilder.d(i5);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultFeedbackFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static DefaultImageFieldsModel m5803a(GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLImage != null) {
            int b = flatBufferBuilder.b(graphQLImage.b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, graphQLImage.a(), 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.a(2, graphQLImage.c(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        flatBufferBuilder.d(i2);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultImageFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static DefaultVect2FieldsModel m5801a(GraphQLVect2 graphQLVect2) {
        if (graphQLVect2 == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLVect2 != null) {
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, graphQLVect2.a(), 0.0d);
            flatBufferBuilder.a(1, graphQLVect2.b(), 0.0d);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        if (i2 == 0) {
            return null;
        }
        flatBufferBuilder.d(i2);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new DefaultVect2FieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}

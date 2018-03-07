package com.facebook.graphql.linkutil;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.GetEntityFbLinkGraphQLModel;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLRedirectionInfo;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: device_total_space */
public final class LinkExtractorConverter {
    public static GetEntityFbLinkGraphQLModel m14646a(DefaultTextWithEntitiesEntityFields defaultTextWithEntitiesEntityFields) {
        if (defaultTextWithEntitiesEntityFields == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (defaultTextWithEntitiesEntityFields != null) {
            int a = flatBufferBuilder.a(defaultTextWithEntitiesEntityFields.b());
            int b = flatBufferBuilder.b(defaultTextWithEntitiesEntityFields.d());
            int b2 = flatBufferBuilder.b(defaultTextWithEntitiesEntityFields.C_());
            int b3 = flatBufferBuilder.b(defaultTextWithEntitiesEntityFields.g());
            int b4 = flatBufferBuilder.b(defaultTextWithEntitiesEntityFields.D_());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(5, b3);
            flatBufferBuilder.b(6, b4);
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
        return new GetEntityFbLinkGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m14645a(FlatBufferBuilder flatBufferBuilder, GraphQLRedirectionInfo graphQLRedirectionInfo) {
        if (graphQLRedirectionInfo == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLRedirectionInfo.k());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static C0646xa3ec3e6c m14647a(GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m14644a(flatBufferBuilder, graphQLNode);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0646xa3ec3e6c(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m14648b(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPage.ae());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14649c(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPage.ae());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14650d(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPage.ae());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14644a(FlatBufferBuilder flatBufferBuilder, GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return 0;
        }
        int i;
        int a;
        int a2 = flatBufferBuilder.a(graphQLNode.j());
        GraphQLPage bV = graphQLNode.bV();
        int i2 = 0;
        if (bV != null) {
            int b = flatBufferBuilder.b(bV.ae());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i2 = flatBufferBuilder.d();
            flatBufferBuilder.d(i2);
        }
        int i3 = i2;
        int b2 = flatBufferBuilder.b(graphQLNode.dp());
        ImmutableList gy = graphQLNode.gy();
        if (gy != null) {
            int[] iArr = new int[gy.size()];
            for (i = 0; i < gy.size(); i++) {
                iArr[i] = m14645a(flatBufferBuilder, (GraphQLRedirectionInfo) gy.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = m14648b(flatBufferBuilder, graphQLNode.gL());
        int c = m14649c(flatBufferBuilder, graphQLNode.gM());
        int b3 = flatBufferBuilder.b(graphQLNode.iR());
        int d = m14650d(flatBufferBuilder, graphQLNode.jv());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, a2);
        flatBufferBuilder.b(1, i3);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.b(4, i);
        flatBufferBuilder.b(5, c);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, d);
        int d2 = flatBufferBuilder.d();
        flatBufferBuilder.d(d2);
        return d2;
    }
}

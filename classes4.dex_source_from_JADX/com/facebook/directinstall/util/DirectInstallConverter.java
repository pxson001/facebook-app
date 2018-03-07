package com.facebook.directinstall.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: dequeue */
public final class DirectInstallConverter {
    public static C0652x31e4f7ab m14772a(GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLActor != null) {
            int a = flatBufferBuilder.a(graphQLActor.b());
            int b = flatBufferBuilder.b(graphQLActor.aa());
            GraphQLImage ai = graphQLActor.ai();
            int i2 = 0;
            if (ai != null) {
                int b2 = flatBufferBuilder.b(ai.b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b2);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, i3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i4 = i;
        if (i4 == 0) {
            return null;
        }
        flatBufferBuilder.d(i4);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0652x31e4f7ab(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m14773b(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m14771a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLTextWithEntities.a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14770a(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
        if (graphQLEntityAtRange == null) {
            return 0;
        }
        GraphQLEntity j = graphQLEntityAtRange.j();
        int i = 0;
        if (j != null) {
            int a = flatBufferBuilder.a(j.b());
            int b = flatBufferBuilder.b(j.C_());
            GraphQLImage G = j.G();
            int i2 = 0;
            if (G != null) {
                int b2 = flatBufferBuilder.b(G.b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b2);
                i2 = flatBufferBuilder.d();
                flatBufferBuilder.d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, i3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i4 = i;
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, i4);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14774b(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLTextWithEntities.b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m14770a(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.b(graphQLTextWithEntities.a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, i);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m14769a(FlatBufferBuilder flatBufferBuilder, GraphQLApplication graphQLApplication) {
        if (graphQLApplication == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLApplication.u());
        int b2 = flatBufferBuilder.b(graphQLApplication.C());
        int b3 = flatBufferBuilder.b(graphQLApplication.R());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m14768a(FlatBufferBuilder flatBufferBuilder, GraphQLAppStoreApplication graphQLAppStoreApplication) {
        if (graphQLAppStoreApplication == null) {
            return 0;
        }
        int i;
        int i2;
        int b = flatBufferBuilder.b(graphQLAppStoreApplication.j());
        int b2 = flatBufferBuilder.b(graphQLAppStoreApplication.k());
        ImmutableList l = graphQLAppStoreApplication.l();
        if (l != null) {
            int[] iArr = new int[l.size()];
            for (i = 0; i < l.size(); i++) {
                iArr[i] = m14773b(flatBufferBuilder, (GraphQLImage) l.get(i));
            }
            i = flatBufferBuilder.a(iArr, true);
        } else {
            i = 0;
        }
        int a = m14771a(flatBufferBuilder, graphQLAppStoreApplication.m());
        int a2 = flatBufferBuilder.a(graphQLAppStoreApplication.n());
        int b3 = flatBufferBuilder.b(graphQLAppStoreApplication.p());
        int a3 = flatBufferBuilder.a(graphQLAppStoreApplication.q());
        int b4 = m14774b(flatBufferBuilder, graphQLAppStoreApplication.r());
        int c = flatBufferBuilder.c(graphQLAppStoreApplication.s());
        int i3 = 0;
        ImmutableList t = graphQLAppStoreApplication.t();
        if (t != null) {
            int[] iArr2 = new int[t.size()];
            for (i2 = 0; i2 < t.size(); i2++) {
                iArr2[i2] = m14773b(flatBufferBuilder, (GraphQLImage) t.get(i2));
            }
            i3 = flatBufferBuilder.a(iArr2, true);
        }
        i2 = m14769a(flatBufferBuilder, graphQLAppStoreApplication.u());
        int b5 = flatBufferBuilder.b(graphQLAppStoreApplication.v());
        int d = flatBufferBuilder.d(graphQLAppStoreApplication.w());
        int b6 = m14774b(flatBufferBuilder, graphQLAppStoreApplication.x());
        int b7 = flatBufferBuilder.b(graphQLAppStoreApplication.z());
        flatBufferBuilder.c(16);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, i);
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.b(4, a2);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, c);
        flatBufferBuilder.b(9, i3);
        flatBufferBuilder.b(10, i2);
        flatBufferBuilder.b(11, b5);
        flatBufferBuilder.b(12, d);
        flatBufferBuilder.b(13, b6);
        flatBufferBuilder.a(14, graphQLAppStoreApplication.y(), 0);
        flatBufferBuilder.b(15, b7);
        i3 = flatBufferBuilder.d();
        flatBufferBuilder.d(i3);
        return i3;
    }
}

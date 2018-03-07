package com.facebook.events.graphql;

import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLRedirectionInfo;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTimelineAppSection;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: num_total_segments */
public final class EventsConverter {
    public static EventCommonTextWithEntitiesModel m12794a(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLTextWithEntities != null) {
            int i2;
            int a;
            ImmutableList b = graphQLTextWithEntities.b();
            if (b != null) {
                int[] iArr = new int[b.size()];
                for (i2 = 0; i2 < b.size(); i2++) {
                    GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i2);
                    int i3 = 0;
                    if (graphQLEntityAtRange != null) {
                        int b2 = m12795b(flatBufferBuilder, graphQLEntityAtRange.j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b2);
                        flatBufferBuilder.a(1, graphQLEntityAtRange.b(), 0);
                        flatBufferBuilder.a(2, graphQLEntityAtRange.c(), 0);
                        i3 = flatBufferBuilder.d();
                        flatBufferBuilder.d(i3);
                    }
                    iArr[i2] = i3;
                }
                a = flatBufferBuilder.a(iArr, true);
            } else {
                a = 0;
            }
            i2 = flatBufferBuilder.b(graphQLTextWithEntities.a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, i2);
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
        return new EventCommonTextWithEntitiesModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m12793a(FlatBufferBuilder flatBufferBuilder, GraphQLTimelineAppSection graphQLTimelineAppSection) {
        if (graphQLTimelineAppSection == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLTimelineAppSection.n());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m12789a(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m12792a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
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

    private static int m12788a(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
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

    private static int m12796b(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLTextWithEntities.b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m12788a(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i));
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

    private static int m12787a(FlatBufferBuilder flatBufferBuilder, GraphQLApplication graphQLApplication) {
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

    private static int m12786a(FlatBufferBuilder flatBufferBuilder, GraphQLAppStoreApplication graphQLAppStoreApplication) {
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
                iArr[i] = m12789a(flatBufferBuilder, (GraphQLImage) l.get(i));
            }
            i = flatBufferBuilder.a(iArr, true);
        } else {
            i = 0;
        }
        int a = m12792a(flatBufferBuilder, graphQLAppStoreApplication.m());
        int a2 = flatBufferBuilder.a(graphQLAppStoreApplication.n());
        int b3 = flatBufferBuilder.b(graphQLAppStoreApplication.p());
        int a3 = flatBufferBuilder.a(graphQLAppStoreApplication.q());
        int b4 = m12796b(flatBufferBuilder, graphQLAppStoreApplication.r());
        int c = flatBufferBuilder.c(graphQLAppStoreApplication.s());
        int i3 = 0;
        ImmutableList t = graphQLAppStoreApplication.t();
        if (t != null) {
            int[] iArr2 = new int[t.size()];
            for (i2 = 0; i2 < t.size(); i2++) {
                iArr2[i2] = m12789a(flatBufferBuilder, (GraphQLImage) t.get(i2));
            }
            i3 = flatBufferBuilder.a(iArr2, true);
        }
        i2 = m12787a(flatBufferBuilder, graphQLAppStoreApplication.u());
        int b5 = flatBufferBuilder.b(graphQLAppStoreApplication.v());
        int d = flatBufferBuilder.d(graphQLAppStoreApplication.w());
        int b6 = m12796b(flatBufferBuilder, graphQLAppStoreApplication.x());
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

    private static int m12790a(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPage.ae());
        int b2 = flatBufferBuilder.b(graphQLPage.aG());
        GraphQLImage bs = graphQLPage.bs();
        int i = 0;
        if (bs != null) {
            int b3 = flatBufferBuilder.b(bs.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int b4 = flatBufferBuilder.b(graphQLPage.ck());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, i2);
        flatBufferBuilder.b(4, b4);
        b = flatBufferBuilder.d();
        flatBufferBuilder.d(b);
        return b;
    }

    private static int m12797d(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLImage.b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m12791a(FlatBufferBuilder flatBufferBuilder, GraphQLRedirectionInfo graphQLRedirectionInfo) {
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

    public static int m12795b(FlatBufferBuilder flatBufferBuilder, GraphQLEntity graphQLEntity) {
        if (graphQLEntity == null) {
            return 0;
        }
        int i;
        int a;
        int a2 = flatBufferBuilder.a(graphQLEntity.b());
        int c = flatBufferBuilder.c(graphQLEntity.c());
        int a3 = m12793a(flatBufferBuilder, graphQLEntity.j());
        int a4 = m12786a(flatBufferBuilder, graphQLEntity.k());
        int b = flatBufferBuilder.b(graphQLEntity.d());
        int b2 = flatBufferBuilder.b(graphQLEntity.C_());
        int a5 = m12790a(flatBufferBuilder, graphQLEntity.y());
        int d = m12797d(flatBufferBuilder, graphQLEntity.G());
        ImmutableList I = graphQLEntity.I();
        if (I != null) {
            int[] iArr = new int[I.size()];
            for (i = 0; i < I.size(); i++) {
                iArr[i] = m12791a(flatBufferBuilder, (GraphQLRedirectionInfo) I.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.b(graphQLEntity.g());
        int b3 = flatBufferBuilder.b(graphQLEntity.D_());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, a2);
        flatBufferBuilder.b(1, c);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, b);
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, d);
        flatBufferBuilder.b(8, a);
        flatBufferBuilder.b(9, i);
        flatBufferBuilder.b(10, b3);
        int d2 = flatBufferBuilder.d();
        flatBufferBuilder.d(d2);
        return d2;
    }
}

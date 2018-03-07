package com.facebook.ufiservices.util;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLRedirectionInfo;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLTimelineAppSection;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilAddLikeSentenceLinkGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyAggregatedLinksGraphQLModel;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: graph */
public final class LinkifyUtilConverter {
    public static LinkableUtilAddLikeSentenceLinkGraphQLModel m29866a(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int c = m29873c(flatBufferBuilder, graphQLTextWithEntities);
        if (c == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(c);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new LinkableUtilAddLikeSentenceLinkGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m29865a(FlatBufferBuilder flatBufferBuilder, GraphQLTimelineAppSection graphQLTimelineAppSection) {
        if (graphQLTimelineAppSection == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLTimelineAppSection.m23627n());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29861a(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLImage.mo2924b());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, graphQLImage.mo2923a(), 0);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21494a(2, graphQLImage.mo2925c(), 0);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29864a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29860a(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
        if (graphQLEntityAtRange == null) {
            return 0;
        }
        GraphQLEntity j = graphQLEntityAtRange.m23616j();
        int i = 0;
        if (j != null) {
            int a = flatBufferBuilder.m21475a(j.mo2904b());
            int b = flatBufferBuilder.m21502b(j.C_());
            GraphQLImage G = j.m22536G();
            int i2 = 0;
            if (G != null) {
                int b2 = flatBufferBuilder.m21502b(G.mo2924b());
                flatBufferBuilder.m21510c(1);
                flatBufferBuilder.m21507b(0, b2);
                i2 = flatBufferBuilder.m21511d();
                flatBufferBuilder.m21513d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.m21510c(3);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, b);
            flatBufferBuilder.m21507b(2, i3);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i4 = i;
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, i4);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29869b(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLTextWithEntities.mo2912b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m29860a(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, i);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29859a(FlatBufferBuilder flatBufferBuilder, GraphQLApplication graphQLApplication) {
        if (graphQLApplication == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLApplication.m23672u());
        int b2 = flatBufferBuilder.m21502b(graphQLApplication.m23638C());
        int b3 = flatBufferBuilder.m21502b(graphQLApplication.m23653R());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, b3);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29858a(FlatBufferBuilder flatBufferBuilder, GraphQLAppStoreApplication graphQLAppStoreApplication) {
        if (graphQLAppStoreApplication == null) {
            return 0;
        }
        int i;
        int i2;
        int b = flatBufferBuilder.m21502b(graphQLAppStoreApplication.m23947j());
        int b2 = flatBufferBuilder.m21502b(graphQLAppStoreApplication.m23948k());
        ImmutableList l = graphQLAppStoreApplication.m23949l();
        if (l != null) {
            int[] iArr = new int[l.size()];
            for (i = 0; i < l.size(); i++) {
                iArr[i] = m29861a(flatBufferBuilder, (GraphQLImage) l.get(i));
            }
            i = flatBufferBuilder.m21487a(iArr, true);
        } else {
            i = 0;
        }
        int a = m29864a(flatBufferBuilder, graphQLAppStoreApplication.m23950m());
        int a2 = flatBufferBuilder.m21477a(graphQLAppStoreApplication.m23951n());
        int b3 = flatBufferBuilder.m21502b(graphQLAppStoreApplication.m23953p());
        int a3 = flatBufferBuilder.m21477a(graphQLAppStoreApplication.m23954q());
        int b4 = m29869b(flatBufferBuilder, graphQLAppStoreApplication.m23955r());
        int c = flatBufferBuilder.m21509c(graphQLAppStoreApplication.m23956s());
        int i3 = 0;
        ImmutableList t = graphQLAppStoreApplication.m23957t();
        if (t != null) {
            int[] iArr2 = new int[t.size()];
            for (i2 = 0; i2 < t.size(); i2++) {
                iArr2[i2] = m29861a(flatBufferBuilder, (GraphQLImage) t.get(i2));
            }
            i3 = flatBufferBuilder.m21487a(iArr2, true);
        }
        i2 = m29859a(flatBufferBuilder, graphQLAppStoreApplication.m23958u());
        int b5 = flatBufferBuilder.m21502b(graphQLAppStoreApplication.m23959v());
        int d = flatBufferBuilder.m21512d(graphQLAppStoreApplication.m23960w());
        int b6 = m29869b(flatBufferBuilder, graphQLAppStoreApplication.m23961x());
        int b7 = flatBufferBuilder.m21502b(graphQLAppStoreApplication.m23963z());
        flatBufferBuilder.m21510c(16);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, b2);
        flatBufferBuilder.m21507b(2, i);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, b3);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, b4);
        flatBufferBuilder.m21507b(8, c);
        flatBufferBuilder.m21507b(9, i3);
        flatBufferBuilder.m21507b(10, i2);
        flatBufferBuilder.m21507b(11, b5);
        flatBufferBuilder.m21507b(12, d);
        flatBufferBuilder.m21507b(13, b6);
        flatBufferBuilder.m21494a(14, graphQLAppStoreApplication.m23962y(), 0);
        flatBufferBuilder.m21507b(15, b7);
        i3 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(i3);
        return i3;
    }

    private static int m29862a(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLPage.ae());
        int b2 = flatBufferBuilder.m21502b(graphQLPage.aG());
        GraphQLImage bs = graphQLPage.bs();
        int i = 0;
        if (bs != null) {
            int b3 = flatBufferBuilder.m21502b(bs.mo2924b());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, b3);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i2 = i;
        int b4 = flatBufferBuilder.m21502b(graphQLPage.ck());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, i2);
        flatBufferBuilder.m21507b(4, b4);
        b = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(b);
        return b;
    }

    private static int m29876d(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
        if (graphQLImage == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLImage.mo2924b());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29863a(FlatBufferBuilder flatBufferBuilder, GraphQLRedirectionInfo graphQLRedirectionInfo) {
        if (graphQLRedirectionInfo == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLRedirectionInfo.m24719k());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    public static int m29868b(FlatBufferBuilder flatBufferBuilder, GraphQLEntity graphQLEntity) {
        if (graphQLEntity == null) {
            return 0;
        }
        int i;
        int a;
        int a2 = flatBufferBuilder.m21475a(graphQLEntity.mo2904b());
        int c = flatBufferBuilder.m21509c(graphQLEntity.mo2905c());
        int a3 = m29865a(flatBufferBuilder, graphQLEntity.m22557j());
        int a4 = m29858a(flatBufferBuilder, graphQLEntity.m22558k());
        int b = flatBufferBuilder.m21502b(graphQLEntity.mo2906d());
        int b2 = flatBufferBuilder.m21502b(graphQLEntity.C_());
        int a5 = m29862a(flatBufferBuilder, graphQLEntity.m22572y());
        int d = m29876d(flatBufferBuilder, graphQLEntity.m22536G());
        ImmutableList I = graphQLEntity.m22538I();
        if (I != null) {
            int[] iArr = new int[I.size()];
            for (i = 0; i < I.size(); i++) {
                iArr[i] = m29863a(flatBufferBuilder, (GraphQLRedirectionInfo) I.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.m21502b(graphQLEntity.mo2907g());
        int b3 = flatBufferBuilder.m21502b(graphQLEntity.D_());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, a2);
        flatBufferBuilder.m21507b(1, c);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a5);
        flatBufferBuilder.m21507b(7, d);
        flatBufferBuilder.m21507b(8, a);
        flatBufferBuilder.m21507b(9, i);
        flatBufferBuilder.m21507b(10, b3);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    private static int m29873c(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int i2;
        int i3;
        int a;
        ImmutableList c = graphQLTextWithEntities.mo2913c();
        if (c != null) {
            int[] iArr = new int[c.size()];
            for (i = 0; i < c.size(); i++) {
                GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange = (GraphQLAggregatedEntitiesAtRange) c.get(i);
                i2 = 0;
                if (graphQLAggregatedEntitiesAtRange != null) {
                    flatBufferBuilder.m21510c(2);
                    flatBufferBuilder.m21494a(0, graphQLAggregatedEntitiesAtRange.mo2940b(), 0);
                    flatBufferBuilder.m21494a(1, graphQLAggregatedEntitiesAtRange.mo2941c(), 0);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr[i] = i2;
            }
            i = flatBufferBuilder.m21487a(iArr, true);
        } else {
            i = 0;
        }
        ImmutableList b = graphQLTextWithEntities.mo2912b();
        if (b != null) {
            int[] iArr2 = new int[b.size()];
            for (i3 = 0; i3 < b.size(); i3++) {
                GraphQLEntityAtRange graphQLEntityAtRange = (GraphQLEntityAtRange) b.get(i3);
                i2 = 0;
                if (graphQLEntityAtRange != null) {
                    int b2 = m29868b(flatBufferBuilder, graphQLEntityAtRange.m23616j());
                    flatBufferBuilder.m21510c(3);
                    flatBufferBuilder.m21507b(0, b2);
                    flatBufferBuilder.m21494a(1, graphQLEntityAtRange.mo2943b(), 0);
                    flatBufferBuilder.m21494a(2, graphQLEntityAtRange.mo2944c(), 0);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr2[i3] = i2;
            }
            a = flatBufferBuilder.m21487a(iArr2, true);
        } else {
            a = 0;
        }
        i3 = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, i);
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, i3);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    public static LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel m29870b(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int i = 0;
        if (graphQLTextWithEntities != null) {
            int i2;
            int i3;
            int a;
            ImmutableList c = graphQLTextWithEntities.mo2913c();
            if (c != null) {
                int[] iArr = new int[c.size()];
                for (i2 = 0; i2 < c.size(); i2++) {
                    iArr[i2] = m29867b(flatBufferBuilder, (GraphQLAggregatedEntitiesAtRange) c.get(i2));
                }
                i2 = flatBufferBuilder.m21487a(iArr, true);
            } else {
                i2 = 0;
            }
            ImmutableList b = graphQLTextWithEntities.mo2912b();
            if (b != null) {
                int[] iArr2 = new int[b.size()];
                for (i3 = 0; i3 < b.size(); i3++) {
                    iArr2[i3] = m29872c(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i3));
                }
                a = flatBufferBuilder.m21487a(iArr2, true);
            } else {
                a = 0;
            }
            i3 = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
            flatBufferBuilder.m21510c(3);
            flatBufferBuilder.m21507b(0, i2);
            flatBufferBuilder.m21507b(1, a);
            flatBufferBuilder.m21507b(2, i3);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i4 = i;
        if (i4 == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(i4);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new LinkifyUtilGraphQLModels$LinkableUtilAddLinksGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m29871c(FlatBufferBuilder flatBufferBuilder, GraphQLEntity graphQLEntity) {
        if (graphQLEntity == null) {
            return 0;
        }
        int a = flatBufferBuilder.m21475a(graphQLEntity.mo2904b());
        int a2 = flatBufferBuilder.m21477a(graphQLEntity.m22563p());
        int b = flatBufferBuilder.m21502b(graphQLEntity.mo2906d());
        int b2 = flatBufferBuilder.m21502b(graphQLEntity.C_());
        GraphQLImage G = graphQLEntity.m22536G();
        int i = 0;
        if (G != null) {
            int b3 = flatBufferBuilder.m21502b(G.mo2924b());
            flatBufferBuilder.m21510c(3);
            flatBufferBuilder.m21494a(0, G.mo2923a(), 0);
            flatBufferBuilder.m21507b(1, b3);
            flatBufferBuilder.m21494a(2, G.mo2925c(), 0);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i2 = i;
        int b4 = flatBufferBuilder.m21502b(graphQLEntity.D_());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(4, b2);
        flatBufferBuilder.m21507b(5, i2);
        flatBufferBuilder.m21507b(6, b4);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    public static int m29867b(FlatBufferBuilder flatBufferBuilder, GraphQLAggregatedEntitiesAtRange graphQLAggregatedEntitiesAtRange) {
        if (graphQLAggregatedEntitiesAtRange == null) {
            return 0;
        }
        int a;
        ImmutableList j = graphQLAggregatedEntitiesAtRange.m23586j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                iArr[i] = m29871c(flatBufferBuilder, (GraphQLEntity) j.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21494a(0, graphQLAggregatedEntitiesAtRange.mo2940b(), 0);
        flatBufferBuilder.m21494a(1, graphQLAggregatedEntitiesAtRange.mo2941c(), 0);
        flatBufferBuilder.m21507b(2, a);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29875d(FlatBufferBuilder flatBufferBuilder, GraphQLEntity graphQLEntity) {
        if (graphQLEntity == null) {
            return 0;
        }
        int i;
        int a;
        int a2 = flatBufferBuilder.m21475a(graphQLEntity.mo2904b());
        int c = flatBufferBuilder.m21509c(graphQLEntity.mo2905c());
        int a3 = m29865a(flatBufferBuilder, graphQLEntity.m22557j());
        int a4 = m29858a(flatBufferBuilder, graphQLEntity.m22558k());
        int b = flatBufferBuilder.m21502b(graphQLEntity.mo2906d());
        int b2 = flatBufferBuilder.m21502b(graphQLEntity.C_());
        int a5 = m29862a(flatBufferBuilder, graphQLEntity.m22572y());
        int d = m29876d(flatBufferBuilder, graphQLEntity.m22536G());
        ImmutableList I = graphQLEntity.m22538I();
        if (I != null) {
            int[] iArr = new int[I.size()];
            for (i = 0; i < I.size(); i++) {
                iArr[i] = m29863a(flatBufferBuilder, (GraphQLRedirectionInfo) I.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.m21502b(graphQLEntity.mo2907g());
        int b3 = flatBufferBuilder.m21502b(graphQLEntity.D_());
        flatBufferBuilder.m21510c(11);
        flatBufferBuilder.m21507b(0, a2);
        flatBufferBuilder.m21507b(1, c);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, b);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a5);
        flatBufferBuilder.m21507b(7, d);
        flatBufferBuilder.m21507b(8, a);
        flatBufferBuilder.m21507b(9, i);
        flatBufferBuilder.m21507b(10, b3);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    public static int m29872c(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
        if (graphQLEntityAtRange == null) {
            return 0;
        }
        int d = m29875d(flatBufferBuilder, graphQLEntityAtRange.m23616j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, d);
        flatBufferBuilder.m21494a(1, graphQLEntityAtRange.mo2943b(), 0);
        flatBufferBuilder.m21494a(2, graphQLEntityAtRange.mo2944c(), 0);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    public static LinkableUtilApplyActorsLinksGraphQLModel m29874c(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int i = 0;
        if (graphQLTextWithEntities != null) {
            int i2;
            int a;
            ImmutableList b = graphQLTextWithEntities.mo2912b();
            if (b != null) {
                int[] iArr = new int[b.size()];
                for (i2 = 0; i2 < b.size(); i2++) {
                    iArr[i2] = m29872c(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i2));
                }
                a = flatBufferBuilder.m21487a(iArr, true);
            } else {
                a = 0;
            }
            i2 = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
            flatBufferBuilder.m21510c(2);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, i2);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i3 = i;
        if (i3 == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(i3);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new LinkableUtilApplyActorsLinksGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static LinkableUtilApplyAggregatedLinksGraphQLModel m29877d(GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int i = 0;
        if (graphQLTextWithEntities != null) {
            int i2;
            int a;
            ImmutableList c = graphQLTextWithEntities.mo2913c();
            if (c != null) {
                int[] iArr = new int[c.size()];
                for (i2 = 0; i2 < c.size(); i2++) {
                    iArr[i2] = m29867b(flatBufferBuilder, (GraphQLAggregatedEntitiesAtRange) c.get(i2));
                }
                a = flatBufferBuilder.m21487a(iArr, true);
            } else {
                a = 0;
            }
            i2 = flatBufferBuilder.m21502b(graphQLTextWithEntities.mo2911a());
            flatBufferBuilder.m21510c(2);
            flatBufferBuilder.m21507b(0, a);
            flatBufferBuilder.m21507b(1, i2);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i3 = i;
        if (i3 == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(i3);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new LinkableUtilApplyAggregatedLinksGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }
}

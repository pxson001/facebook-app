package com.facebook.composer.minutiae.model;

import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel.TemplateTokensModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActivityTemplateToken;
import com.facebook.graphql.model.GraphQLActivityTemplateToken$Builder;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPage;
import com.facebook.graphql.model.GraphQLPlaceFlowInfo;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTaggableActivity;
import com.facebook.graphql.model.GraphQLTaggableActivityAllIconsConnection;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate;
import com.facebook.graphql.model.GraphQLTaggableActivityPreviewTemplate$Builder;
import com.facebook.graphql.model.GraphQLTaggableActivitySuggestionsEdge;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;

/* compiled from: addfriend */
public final class MinutiaeModelConversionHelper {
    public static MinutiaeTaggableActivityModel m19607a(GraphQLTaggableActivity graphQLTaggableActivity) {
        if (graphQLTaggableActivity == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m19601a(flatBufferBuilder, graphQLTaggableActivity);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new MinutiaeTaggableActivityModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m19602a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityAllIconsConnection graphQLTaggableActivityAllIconsConnection) {
        if (graphQLTaggableActivityAllIconsConnection == null) {
            return 0;
        }
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, graphQLTaggableActivityAllIconsConnection.a(), 0);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19597a(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m19609b(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m19604a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityPreviewTemplate graphQLTaggableActivityPreviewTemplate) {
        if (graphQLTaggableActivityPreviewTemplate == null) {
            return 0;
        }
        int a;
        int b = flatBufferBuilder.b(graphQLTaggableActivityPreviewTemplate.a());
        ImmutableList j = graphQLTaggableActivityPreviewTemplate.j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken = (GraphQLActivityTemplateToken) j.get(i);
                int i2 = 0;
                if (graphQLActivityTemplateToken != null) {
                    int a2 = flatBufferBuilder.a(graphQLActivityTemplateToken.j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, graphQLActivityTemplateToken.a(), 0);
                    flatBufferBuilder.b(1, a2);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19601a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivity graphQLTaggableActivity) {
        if (graphQLTaggableActivity == null) {
            return 0;
        }
        int a = m19602a(flatBufferBuilder, graphQLTaggableActivity.j());
        int a2 = m19597a(flatBufferBuilder, graphQLTaggableActivity.k());
        int b = m19609b(flatBufferBuilder, graphQLTaggableActivity.l());
        int b2 = flatBufferBuilder.b(graphQLTaggableActivity.m());
        int b3 = flatBufferBuilder.b(graphQLTaggableActivity.o());
        int b4 = flatBufferBuilder.b(graphQLTaggableActivity.q());
        int a3 = m19604a(flatBufferBuilder, graphQLTaggableActivity.r());
        int a4 = m19604a(flatBufferBuilder, graphQLTaggableActivity.s());
        int a5 = m19604a(flatBufferBuilder, graphQLTaggableActivity.t());
        int a6 = m19604a(flatBufferBuilder, graphQLTaggableActivity.u());
        int a7 = m19604a(flatBufferBuilder, graphQLTaggableActivity.v());
        int a8 = m19604a(flatBufferBuilder, graphQLTaggableActivity.w());
        int b5 = flatBufferBuilder.b(graphQLTaggableActivity.x());
        flatBufferBuilder.c(18);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.a(4, graphQLTaggableActivity.n());
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.a(6, graphQLTaggableActivity.p(), 0);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, a3);
        flatBufferBuilder.b(9, a4);
        flatBufferBuilder.b(10, a5);
        flatBufferBuilder.b(11, a6);
        flatBufferBuilder.b(12, a7);
        flatBufferBuilder.b(13, a8);
        flatBufferBuilder.b(14, b5);
        flatBufferBuilder.a(15, graphQLTaggableActivity.y());
        flatBufferBuilder.a(16, graphQLTaggableActivity.z());
        flatBufferBuilder.a(17, graphQLTaggableActivity.A());
        a = flatBufferBuilder.d();
        flatBufferBuilder.d(a);
        return a;
    }

    private static int m19599a(FlatBufferBuilder flatBufferBuilder, GraphQLPlaceFlowInfo graphQLPlaceFlowInfo) {
        if (graphQLPlaceFlowInfo == null) {
            return 0;
        }
        int c = flatBufferBuilder.c(graphQLPlaceFlowInfo.m20841a());
        int c2 = flatBufferBuilder.c(graphQLPlaceFlowInfo.m20842j());
        int a = flatBufferBuilder.a(graphQLPlaceFlowInfo.m20843k());
        int b = flatBufferBuilder.b(graphQLPlaceFlowInfo.m20844l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, c2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19611c(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m19603a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityIcon graphQLTaggableActivityIcon) {
        if (graphQLTaggableActivityIcon == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLTaggableActivityIcon.k());
        int c = m19611c(flatBufferBuilder, graphQLTaggableActivityIcon.m());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, c);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19610b(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivityIcon graphQLTaggableActivityIcon) {
        if (graphQLTaggableActivityIcon == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLTaggableActivityIcon.j());
        int b2 = flatBufferBuilder.b(graphQLTaggableActivityIcon.k());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19598a(FlatBufferBuilder flatBufferBuilder, GraphQLPage graphQLPage) {
        if (graphQLPage == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLPage.aG());
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, graphQLPage.au());
        flatBufferBuilder.b(1, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m19612d(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m19600a(FlatBufferBuilder flatBufferBuilder, GraphQLProfile graphQLProfile) {
        if (graphQLProfile == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLProfile.j());
        int b = flatBufferBuilder.b(graphQLProfile.b());
        int b2 = flatBufferBuilder.b(graphQLProfile.U());
        GraphQLStoryAttachment X = graphQLProfile.X();
        int i = 0;
        if (X != null) {
            int d = flatBufferBuilder.d(X.w());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, d);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int a2 = m19598a(flatBufferBuilder, graphQLProfile.Y());
        int d2 = m19612d(flatBufferBuilder, graphQLProfile.ai());
        int c = m19611c(flatBufferBuilder, graphQLProfile.as());
        int b3 = flatBufferBuilder.b(graphQLProfile.ax());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, graphQLProfile.P());
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, i2);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, d2);
        flatBufferBuilder.b(7, c);
        flatBufferBuilder.b(8, b3);
        int d3 = flatBufferBuilder.d();
        flatBufferBuilder.d(d3);
        return d3;
    }

    private static int m19606a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
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

    public static int m19605a(FlatBufferBuilder flatBufferBuilder, GraphQLTaggableActivitySuggestionsEdge graphQLTaggableActivitySuggestionsEdge) {
        if (graphQLTaggableActivitySuggestionsEdge == null) {
            return 0;
        }
        int i;
        int a;
        int a2 = m19599a(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge.m22067a());
        int b = flatBufferBuilder.b(graphQLTaggableActivitySuggestionsEdge.m22070j());
        ImmutableList k = graphQLTaggableActivitySuggestionsEdge.m22071k();
        if (k != null) {
            int[] iArr = new int[k.size()];
            for (i = 0; i < k.size(); i++) {
                iArr[i] = m19603a(flatBufferBuilder, (GraphQLTaggableActivityIcon) k.get(i));
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.b(graphQLTaggableActivitySuggestionsEdge.m22072l());
        int b2 = m19610b(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge.m22073m());
        int c = m19611c(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge.m22074n());
        int a3 = m19600a(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge.m22075o());
        int a4 = m19606a(flatBufferBuilder, graphQLTaggableActivitySuggestionsEdge.m22077q());
        int b3 = flatBufferBuilder.b(graphQLTaggableActivitySuggestionsEdge.m22078r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a2);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, i);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, c);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.a(7, graphQLTaggableActivitySuggestionsEdge.m22076p());
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, b3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static GraphQLTaggableActivityPreviewTemplate m19608a(MinutiaePreviewTemplateModel minutiaePreviewTemplateModel) {
        if (minutiaePreviewTemplateModel == null) {
            return null;
        }
        GraphQLTaggableActivityPreviewTemplate$Builder graphQLTaggableActivityPreviewTemplate$Builder = new GraphQLTaggableActivityPreviewTemplate$Builder();
        graphQLTaggableActivityPreviewTemplate$Builder.f13261d = minutiaePreviewTemplateModel.m19376a();
        if (minutiaePreviewTemplateModel.m19377b() != null) {
            Builder builder = ImmutableList.builder();
            for (int i = 0; i < minutiaePreviewTemplateModel.m19377b().size(); i++) {
                GraphQLActivityTemplateToken graphQLActivityTemplateToken;
                TemplateTokensModel templateTokensModel = (TemplateTokensModel) minutiaePreviewTemplateModel.m19377b().get(i);
                if (templateTokensModel == null) {
                    graphQLActivityTemplateToken = null;
                } else {
                    GraphQLActivityTemplateToken$Builder graphQLActivityTemplateToken$Builder = new GraphQLActivityTemplateToken$Builder();
                    graphQLActivityTemplateToken$Builder.f3272d = templateTokensModel.m19368a();
                    graphQLActivityTemplateToken$Builder.f3273e = templateTokensModel.m19372b();
                    graphQLActivityTemplateToken = graphQLActivityTemplateToken$Builder.m6389a();
                }
                builder.c(graphQLActivityTemplateToken);
            }
            graphQLTaggableActivityPreviewTemplate$Builder.f13262e = builder.b();
        }
        return graphQLTaggableActivityPreviewTemplate$Builder.m22056a();
    }
}

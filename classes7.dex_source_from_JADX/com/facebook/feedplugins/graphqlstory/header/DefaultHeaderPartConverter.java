package com.facebook.feedplugins.graphqlstory.header;

import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLModels.DispatchAvatarClickGraphQLModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLAppStoreApplication;
import com.facebook.graphql.model.GraphQLApplication;
import com.facebook.graphql.model.GraphQLEntity;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLinkTargetStoreData;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: reportedStories */
public final class DefaultHeaderPartConverter {
    public static DispatchAvatarClickGraphQLModel m5682a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int i = 0;
        if (graphQLStory != null) {
            int i2;
            int i3;
            int a;
            ImmutableList b = graphQLStory.b();
            if (b != null) {
                int[] iArr = new int[b.size()];
                for (i2 = 0; i2 < b.size(); i2++) {
                    iArr[i2] = m5674a(flatBufferBuilder, (GraphQLActor) b.get(i2));
                }
                i2 = flatBufferBuilder.a(iArr, true);
            } else {
                i2 = 0;
            }
            ImmutableList M = graphQLStory.M();
            if (M != null) {
                int[] iArr2 = new int[M.size()];
                for (i3 = 0; i3 < M.size(); i3++) {
                    iArr2[i3] = m5680a(flatBufferBuilder, (GraphQLStoryAttachment) M.get(i3));
                }
                a = flatBufferBuilder.a(iArr2, true);
            } else {
                a = 0;
            }
            i3 = flatBufferBuilder.b(graphQLStory.g());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, i2);
            flatBufferBuilder.b(1, a);
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
        return new DispatchAvatarClickGraphQLModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m5678a(FlatBufferBuilder flatBufferBuilder, GraphQLImage graphQLImage) {
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

    private static int m5681a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
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

    private static int m5677a(FlatBufferBuilder flatBufferBuilder, GraphQLEntityAtRange graphQLEntityAtRange) {
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

    private static int m5683b(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (graphQLTextWithEntities == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList b = graphQLTextWithEntities.b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m5677a(flatBufferBuilder, (GraphQLEntityAtRange) b.get(i));
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

    private static int m5676a(FlatBufferBuilder flatBufferBuilder, GraphQLApplication graphQLApplication) {
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

    private static int m5675a(FlatBufferBuilder flatBufferBuilder, GraphQLAppStoreApplication graphQLAppStoreApplication) {
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
                iArr[i] = m5678a(flatBufferBuilder, (GraphQLImage) l.get(i));
            }
            i = flatBufferBuilder.a(iArr, true);
        } else {
            i = 0;
        }
        int a = m5681a(flatBufferBuilder, graphQLAppStoreApplication.m());
        int a2 = flatBufferBuilder.a(graphQLAppStoreApplication.n());
        int b3 = flatBufferBuilder.b(graphQLAppStoreApplication.p());
        int a3 = flatBufferBuilder.a(graphQLAppStoreApplication.q());
        int b4 = m5683b(flatBufferBuilder, graphQLAppStoreApplication.r());
        int c = flatBufferBuilder.c(graphQLAppStoreApplication.s());
        int i3 = 0;
        ImmutableList t = graphQLAppStoreApplication.t();
        if (t != null) {
            int[] iArr2 = new int[t.size()];
            for (i2 = 0; i2 < t.size(); i2++) {
                iArr2[i2] = m5678a(flatBufferBuilder, (GraphQLImage) t.get(i2));
            }
            i3 = flatBufferBuilder.a(iArr2, true);
        }
        i2 = m5676a(flatBufferBuilder, graphQLAppStoreApplication.u());
        int b5 = flatBufferBuilder.b(graphQLAppStoreApplication.v());
        int d = flatBufferBuilder.d(graphQLAppStoreApplication.w());
        int b6 = m5683b(flatBufferBuilder, graphQLAppStoreApplication.x());
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

    public static int m5674a(FlatBufferBuilder flatBufferBuilder, GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLActor.b());
        int a2 = m5675a(flatBufferBuilder, graphQLActor.l());
        int a3 = flatBufferBuilder.a(graphQLActor.E());
        int b = flatBufferBuilder.b(graphQLActor.H());
        int b2 = flatBufferBuilder.b(graphQLActor.aa());
        GraphQLImage ai = graphQLActor.ai();
        int i = 0;
        if (ai != null) {
            int b3 = flatBufferBuilder.b(ai.b());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, ai.a(), 0);
            flatBufferBuilder.b(1, b3);
            flatBufferBuilder.a(2, ai.c(), 0);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        int b4 = flatBufferBuilder.b(graphQLActor.aw());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, i2);
        flatBufferBuilder.b(6, b4);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    private static int m5679a(FlatBufferBuilder flatBufferBuilder, GraphQLNode graphQLNode) {
        if (graphQLNode == null) {
            return 0;
        }
        int a = flatBufferBuilder.a(graphQLNode.j());
        int b = flatBufferBuilder.b(graphQLNode.dp());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }

    public static int m5680a(FlatBufferBuilder flatBufferBuilder, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList j = graphQLStoryAttachment.j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (i = 0; i < j.size(); i++) {
                GraphQLStoryActionLink graphQLStoryActionLink = (GraphQLStoryActionLink) j.get(i);
                int i2 = 0;
                if (graphQLStoryActionLink != null) {
                    int a2 = flatBufferBuilder.a(graphQLStoryActionLink.a());
                    GraphQLLinkTargetStoreData U = graphQLStoryActionLink.U();
                    int i3 = 0;
                    if (U != null) {
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, U.k());
                        i3 = flatBufferBuilder.d();
                        flatBufferBuilder.d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a2);
                    flatBufferBuilder.b(1, i4);
                    i2 = flatBufferBuilder.d();
                    flatBufferBuilder.d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.d(graphQLStoryAttachment.w());
        int a3 = m5679a(flatBufferBuilder, graphQLStoryAttachment.z());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, i);
        flatBufferBuilder.b(2, a3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }
}

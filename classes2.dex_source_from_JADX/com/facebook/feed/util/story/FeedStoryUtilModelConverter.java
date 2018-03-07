package com.facebook.feed.util.story;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLProfileBadge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLSubstoriesConnection;
import com.facebook.graphql.model.GraphQLTaggableActivityIcon;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* compiled from: group_feed_owner_authored_available_for_sale_type */
public final class FeedStoryUtilModelConverter {
    private static int m29444a(FlatBufferBuilder flatBufferBuilder, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return 0;
        }
        int d = flatBufferBuilder.m21512d(graphQLStoryAttachment.m23984w());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, d);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    public static C0870xa5832e5a m29447a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int c = m29449c(flatBufferBuilder, graphQLStory);
        if (c == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(c);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new C0870xa5832e5a(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m29442a(FlatBufferBuilder flatBufferBuilder, GraphQLProfileBadge graphQLProfileBadge) {
        if (graphQLProfileBadge == null) {
            return 0;
        }
        GraphQLTaggableActivityIcon j = graphQLProfileBadge.m27504j();
        int i = 0;
        if (j != null) {
            GraphQLImage l = j.l();
            int i2 = 0;
            if (l != null) {
                int b = flatBufferBuilder.m21502b(l.mo2924b());
                flatBufferBuilder.m21510c(1);
                flatBufferBuilder.m21507b(0, b);
                i2 = flatBufferBuilder.m21511d();
                flatBufferBuilder.m21513d(i2);
            }
            int i3 = i2;
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, i3);
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

    private static int m29440a(FlatBufferBuilder flatBufferBuilder, GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            return 0;
        }
        int a = flatBufferBuilder.m21475a(graphQLActor.m23790b());
        int b = flatBufferBuilder.m21502b(graphQLActor.m23765H());
        int a2 = m29442a(flatBufferBuilder, graphQLActor.ag());
        GraphQLImage ai = graphQLActor.ai();
        int i = 0;
        if (ai != null) {
            int b2 = flatBufferBuilder.m21502b(ai.mo2924b());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, b2);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i2 = i;
        flatBufferBuilder.m21510c(4);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, a2);
        flatBufferBuilder.m21507b(3, i2);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29443a(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int i;
        int a;
        ImmutableList M = graphQLStory.m22327M();
        if (M != null) {
            int[] iArr = new int[M.size()];
            for (i = 0; i < M.size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                int i2 = 0;
                if (graphQLStoryAttachment != null) {
                    int d = flatBufferBuilder.m21512d(graphQLStoryAttachment.m23984w());
                    GraphQLNode z = graphQLStoryAttachment.m23987z();
                    int i3 = 0;
                    if (z != null) {
                        int a2 = flatBufferBuilder.m21475a(z.m23390j());
                        int b = flatBufferBuilder.m21502b(z.dp());
                        flatBufferBuilder.m21510c(2);
                        flatBufferBuilder.m21507b(0, a2);
                        flatBufferBuilder.m21507b(1, b);
                        i3 = flatBufferBuilder.m21511d();
                        flatBufferBuilder.m21513d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.m21510c(2);
                    flatBufferBuilder.m21507b(0, d);
                    flatBufferBuilder.m21507b(1, i4);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        i = flatBufferBuilder.m21502b(graphQLStory.m22350c());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, i);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }

    private static int m29445a(FlatBufferBuilder flatBufferBuilder, GraphQLSubstoriesConnection graphQLSubstoriesConnection) {
        if (graphQLSubstoriesConnection == null) {
            return 0;
        }
        int a;
        ImmutableList j = graphQLSubstoriesConnection.m22608j();
        if (j != null) {
            int[] iArr = new int[j.size()];
            for (int i = 0; i < j.size(); i++) {
                iArr[i] = m29443a(flatBufferBuilder, (GraphQLStory) j.get(i));
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29441a(FlatBufferBuilder flatBufferBuilder, GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null) {
            return 0;
        }
        int b = flatBufferBuilder.m21502b(graphQLFeedback.z_());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, b);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29446a(FlatBufferBuilder flatBufferBuilder, GraphQLTextWithEntities graphQLTextWithEntities) {
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

    private static int m29449c(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int i;
        int i2;
        int a;
        ImmutableList b = graphQLStory.m22349b();
        if (b != null) {
            int[] iArr = new int[b.size()];
            for (i = 0; i < b.size(); i++) {
                iArr[i] = m29440a(flatBufferBuilder, (GraphQLActor) b.get(i));
            }
            i = flatBufferBuilder.m21487a(iArr, true);
        } else {
            i = 0;
        }
        int a2 = m29445a(flatBufferBuilder, graphQLStory.m22321G());
        GraphQLStory L = graphQLStory.m22326L();
        int i3 = 0;
        if (L != null) {
            int b2 = flatBufferBuilder.m21502b(L.m22350c());
            flatBufferBuilder.m21510c(1);
            flatBufferBuilder.m21507b(0, b2);
            i3 = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i3);
        }
        int i4 = i3;
        ImmutableList M = graphQLStory.m22327M();
        if (M != null) {
            int[] iArr2 = new int[M.size()];
            for (i2 = 0; i2 < M.size(); i2++) {
                iArr2[i2] = m29444a(flatBufferBuilder, (GraphQLStoryAttachment) M.get(i2));
            }
            a = flatBufferBuilder.m21487a(iArr2, true);
        } else {
            a = 0;
        }
        i2 = m29441a(flatBufferBuilder, graphQLStory.mo2890l());
        int a3 = m29446a(flatBufferBuilder, graphQLStory.aj());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, i);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, i4);
        flatBufferBuilder.m21507b(3, a);
        flatBufferBuilder.m21507b(4, i2);
        flatBufferBuilder.m21498a(5, graphQLStory.ac());
        flatBufferBuilder.m21507b(6, a3);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    public static C0868x33f7101d m29448b(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(HTTPTransportCallback.BODY_BYTES_RECEIVED);
        int e = m29451e(flatBufferBuilder, graphQLStory);
        if (e == 0) {
            return null;
        }
        flatBufferBuilder.m21513d(e);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.m21515e());
        wrap.position(0);
        return new C0868x33f7101d(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public static int m29450d(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        int a;
        ImmutableList M = graphQLStory.m22327M();
        if (M != null) {
            int[] iArr = new int[M.size()];
            for (int i = 0; i < M.size(); i++) {
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                int i2 = 0;
                if (graphQLStoryAttachment != null) {
                    GraphQLNode z = graphQLStoryAttachment.m23987z();
                    int i3 = 0;
                    if (z != null) {
                        int a2 = flatBufferBuilder.m21475a(z.m23390j());
                        int b = flatBufferBuilder.m21502b(z.dp());
                        flatBufferBuilder.m21510c(2);
                        flatBufferBuilder.m21507b(0, a2);
                        flatBufferBuilder.m21507b(1, b);
                        i3 = flatBufferBuilder.m21511d();
                        flatBufferBuilder.m21513d(i3);
                    }
                    int i4 = i3;
                    flatBufferBuilder.m21510c(1);
                    flatBufferBuilder.m21507b(0, i4);
                    i2 = flatBufferBuilder.m21511d();
                    flatBufferBuilder.m21513d(i2);
                }
                iArr[i] = i2;
            }
            a = flatBufferBuilder.m21487a(iArr, true);
        } else {
            a = 0;
        }
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        int d = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d);
        return d;
    }

    private static int m29451e(FlatBufferBuilder flatBufferBuilder, GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return 0;
        }
        GraphQLSubstoriesConnection G = graphQLStory.m22321G();
        int i = 0;
        if (G != null) {
            int a;
            ImmutableList j = G.m22608j();
            if (j != null) {
                int[] iArr = new int[j.size()];
                for (int i2 = 0; i2 < j.size(); i2++) {
                    iArr[i2] = m29450d(flatBufferBuilder, (GraphQLStory) j.get(i2));
                }
                a = flatBufferBuilder.m21487a(iArr, true);
            } else {
                a = 0;
            }
            flatBufferBuilder.m21510c(2);
            flatBufferBuilder.m21494a(0, G.m22604a(), 0);
            flatBufferBuilder.m21507b(1, a);
            i = flatBufferBuilder.m21511d();
            flatBufferBuilder.m21513d(i);
        }
        int i3 = i;
        int d = flatBufferBuilder.m21512d(graphQLStory.aC());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, i3);
        flatBufferBuilder.m21507b(1, d);
        int d2 = flatBufferBuilder.m21511d();
        flatBufferBuilder.m21513d(d2);
        return d2;
    }
}

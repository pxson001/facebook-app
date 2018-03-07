package com.facebook.feedplugins.topiccustomizationstory.protocols;

import com.facebook.feed.protocol.FetchNewsFeedGraphQLModels.TrueTopicFeedOptionFragmentModel;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTopicFeedOption;
import com.facebook.graphql.model.GraphQLTrueTopicFeedOption;
import java.nio.ByteBuffer;

/* compiled from: android.intent.extra.PROXY_INFO */
public final class TrueTopicFeedOptionConversionHelper {
    public static TrueTopicFeedOptionFragmentModel m10346a(GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption) {
        if (graphQLTrueTopicFeedOption == null) {
            return null;
        }
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = m10345a(flatBufferBuilder, graphQLTrueTopicFeedOption);
        if (a == 0) {
            return null;
        }
        flatBufferBuilder.d(a);
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new TrueTopicFeedOptionFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    private static int m10345a(FlatBufferBuilder flatBufferBuilder, GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption) {
        if (graphQLTrueTopicFeedOption == null) {
            return 0;
        }
        int b = flatBufferBuilder.b(graphQLTrueTopicFeedOption.j());
        int b2 = flatBufferBuilder.b(graphQLTrueTopicFeedOption.k());
        GraphQLImage m = graphQLTrueTopicFeedOption.m();
        int i = 0;
        if (m != null) {
            int b3 = flatBufferBuilder.b(m.b());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b3);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i2 = i;
        GraphQLTopicFeedOption n = graphQLTrueTopicFeedOption.n();
        i = 0;
        if (n != null) {
            b3 = flatBufferBuilder.a(n.j());
            int b4 = flatBufferBuilder.b(n.k());
            int b5 = flatBufferBuilder.b(n.l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b3);
            flatBufferBuilder.b(1, b4);
            flatBufferBuilder.b(2, b5);
            i = flatBufferBuilder.d();
            flatBufferBuilder.d(i);
        }
        int i3 = i;
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, graphQLTrueTopicFeedOption.l());
        flatBufferBuilder.b(3, i2);
        flatBufferBuilder.b(4, i3);
        int d = flatBufferBuilder.d();
        flatBufferBuilder.d(d);
        return d;
    }
}

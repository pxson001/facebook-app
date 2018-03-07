package com.facebook.feed.model;

import com.facebook.graphql.enums.GraphQLBumpReason;
import com.facebook.graphql.executor.filemap.DefaultFlatBufferCorruptionHandler;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.FeedUnitCommon;
import java.nio.ByteBuffer;

/* compiled from: maximumWeight requires weigher */
public class ClientFeedUnitEdgeBuilder {
    public String f14755A;
    public long f14756B;
    public String f14757a;
    public double f14758b;
    public String f14759c;
    public GraphQLBumpReason f14760d;
    public String f14761e;
    public String f14762f;
    public String f14763g;
    private String f14764h;
    private int f14765i;
    private int f14766j;
    private int f14767k;
    public boolean f14768l;
    public ByteBuffer f14769m;
    public ByteBuffer f14770n;
    private String f14771o;
    public long f14772p;
    private int f14773q;
    private int f14774r;
    private DefaultFlatBufferCorruptionHandler f14775s;
    private FeedUnitInflater f14776t;
    public String f14777u;
    private int f14778v;
    private int f14779w;
    public String f14780x;
    public boolean f14781y;
    public boolean f14782z;

    public final ClientFeedUnitEdgeBuilder m21164a(int i) {
        this.f14778v = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21172b(int i) {
        this.f14779w = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21169a(String str) {
        this.f14757a = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21163a(double d) {
        this.f14758b = d;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21174b(String str) {
        this.f14759c = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21167a(GraphQLBumpReason graphQLBumpReason) {
        this.f14760d = graphQLBumpReason;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21178c(String str) {
        this.f14761e = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21181d(String str) {
        this.f14762f = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21183e(String str) {
        this.f14763g = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21185f(String str) {
        this.f14764h = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21177c(int i) {
        this.f14765i = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21180d(int i) {
        this.f14767k = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21182e(int i) {
        this.f14766j = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21171a(boolean z) {
        this.f14768l = z;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21170a(ByteBuffer byteBuffer) {
        this.f14769m = byteBuffer;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21175b(ByteBuffer byteBuffer) {
        this.f14770n = byteBuffer;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21187g(String str) {
        this.f14771o = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21165a(long j) {
        this.f14772p = j;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21188h(String str) {
        this.f14777u = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21184f(int i) {
        this.f14773q = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21186g(int i) {
        this.f14774r = i;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21168a(DefaultFlatBufferCorruptionHandler defaultFlatBufferCorruptionHandler) {
        this.f14775s = defaultFlatBufferCorruptionHandler;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21166a(FeedUnitInflater feedUnitInflater) {
        this.f14776t = feedUnitInflater;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21189i(String str) {
        this.f14780x = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21176b(boolean z) {
        this.f14781y = z;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21179c(boolean z) {
        this.f14782z = z;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21190j(String str) {
        this.f14755A = str;
        return this;
    }

    public final ClientFeedUnitEdgeBuilder m21173b(long j) {
        this.f14756B = j;
        return this;
    }

    public final ClientFeedUnitEdge m21162a() {
        return new ClientFeedUnitEdge(this.f14757a, this.f14758b, this.f14759c, this.f14760d, this.f14761e, this.f14762f, this.f14763g, this.f14764h, this.f14765i, this.f14766j, this.f14767k, this.f14768l, this.f14769m, this.f14770n, this.f14771o, this.f14772p, this.f14773q, this.f14774r, this.f14778v, this.f14779w, this.f14775s, this.f14776t, this.f14777u, this.f14780x, this.f14781y, this.f14782z, this.f14755A, this.f14756B);
    }

    public static ClientFeedUnitEdge m21161a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        ClientFeedUnitEdgeBuilder clientFeedUnitEdgeBuilder = new ClientFeedUnitEdgeBuilder();
        clientFeedUnitEdgeBuilder.f14762f = graphQLFeedUnitEdge.W_();
        clientFeedUnitEdgeBuilder.f14761e = graphQLFeedUnitEdge.V_();
        clientFeedUnitEdgeBuilder.f14759c = graphQLFeedUnitEdge.m19086g();
        clientFeedUnitEdgeBuilder.f14763g = DedupableUtil.m23084a(graphQLFeedUnitEdge);
        clientFeedUnitEdgeBuilder.f14760d = graphQLFeedUnitEdge.m19090m();
        clientFeedUnitEdgeBuilder.f14758b = graphQLFeedUnitEdge.X_();
        clientFeedUnitEdgeBuilder.f14757a = graphQLFeedUnitEdge.m19084d();
        clientFeedUnitEdgeBuilder.f14780x = graphQLFeedUnitEdge.m19088k();
        clientFeedUnitEdgeBuilder.f14781y = graphQLFeedUnitEdge.m19089l();
        clientFeedUnitEdgeBuilder.f14782z = false;
        FeedUnitCommon c = graphQLFeedUnitEdge.mo2540c();
        if (c != null) {
            clientFeedUnitEdgeBuilder.f14772p = c.T_();
            clientFeedUnitEdgeBuilder.f14777u = ClientFeedUnitEdgeStoryTypeClassifier.m25093a(graphQLFeedUnitEdge);
            clientFeedUnitEdgeBuilder.f14755A = c.mo2507g();
            if (c instanceof GraphQLStory) {
                clientFeedUnitEdgeBuilder.f14756B = ((GraphQLStory) c).aZ();
            }
        }
        if (graphQLFeedUnitEdge.w_() != null) {
            clientFeedUnitEdgeBuilder.f14770n = graphQLFeedUnitEdge.w_().m21554e();
            clientFeedUnitEdgeBuilder.f14769m = graphQLFeedUnitEdge.w_().m21548c();
            clientFeedUnitEdgeBuilder.f14768l = graphQLFeedUnitEdge.w_().f15024d;
        }
        GraphQLFeedUnitEdge a = clientFeedUnitEdgeBuilder.m21162a();
        a.f12980i = graphQLFeedUnitEdge.m19091n();
        return a;
    }
}

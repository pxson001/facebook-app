package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: Unable to retrieve radio power stats */
public class GraphQLStoryAttachment$Builder extends Builder {
    public ImmutableList<GraphQLStoryActionLink> f13125d;
    @Nullable
    public GraphQLAppStoreApplication f13126e;
    public ImmutableList<GraphQLAttachmentProperty> f13127f;
    @Nullable
    public String f13128g;
    @Nullable
    public GraphQLTextWithEntities f13129h;
    @Nullable
    public GraphQLNode f13130i;
    public boolean f13131j;
    public boolean f13132k;
    @Nullable
    public GraphQLMedia f13133l;
    @Nullable
    public String f13134m;
    @Nullable
    public String f13135n;
    @Nullable
    public GraphQLTextWithEntities f13136o;
    public ImmutableList<GraphQLStoryAttachmentStyleInfo> f13137p;
    public ImmutableList<GraphQLStoryAttachmentStyle> f13138q;
    public ImmutableList<GraphQLStoryAttachment> f13139r;
    @Nullable
    public String f13140s;
    @Nullable
    public GraphQLNode f13141t;
    @Nullable
    public String f13142u;
    @Nullable
    public String f13143v;
    @Nullable
    public String f13144w;
    @Nullable
    PropertyBag f13145x = null;

    public GraphQLStoryAttachment$Builder() {
        Preconditions.checkState(this instanceof GraphQLStoryAttachment$Builder);
    }

    public static GraphQLStoryAttachment$Builder m21849a(GraphQLStoryAttachment graphQLStoryAttachment) {
        GraphQLStoryAttachment$Builder graphQLStoryAttachment$Builder = new GraphQLStoryAttachment$Builder();
        graphQLStoryAttachment.h();
        graphQLStoryAttachment$Builder.f13125d = graphQLStoryAttachment.j();
        graphQLStoryAttachment$Builder.f13126e = graphQLStoryAttachment.k();
        graphQLStoryAttachment$Builder.f13127f = graphQLStoryAttachment.l();
        graphQLStoryAttachment$Builder.f13128g = graphQLStoryAttachment.m();
        graphQLStoryAttachment$Builder.f13129h = graphQLStoryAttachment.n();
        graphQLStoryAttachment$Builder.f13130i = graphQLStoryAttachment.o();
        graphQLStoryAttachment$Builder.f13131j = graphQLStoryAttachment.p();
        graphQLStoryAttachment$Builder.f13132k = graphQLStoryAttachment.q();
        graphQLStoryAttachment$Builder.f13133l = graphQLStoryAttachment.r();
        graphQLStoryAttachment$Builder.f13134m = graphQLStoryAttachment.s();
        graphQLStoryAttachment$Builder.f13135n = graphQLStoryAttachment.t();
        graphQLStoryAttachment$Builder.f13136o = graphQLStoryAttachment.u();
        graphQLStoryAttachment$Builder.f13137p = graphQLStoryAttachment.v();
        graphQLStoryAttachment$Builder.f13138q = graphQLStoryAttachment.w();
        graphQLStoryAttachment$Builder.f13139r = graphQLStoryAttachment.x();
        graphQLStoryAttachment$Builder.f13140s = graphQLStoryAttachment.y();
        graphQLStoryAttachment$Builder.f13141t = graphQLStoryAttachment.z();
        graphQLStoryAttachment$Builder.f13142u = graphQLStoryAttachment.A();
        graphQLStoryAttachment$Builder.f13143v = graphQLStoryAttachment.B();
        graphQLStoryAttachment$Builder.f13144w = graphQLStoryAttachment.C();
        Builder.a(graphQLStoryAttachment$Builder, graphQLStoryAttachment);
        graphQLStoryAttachment$Builder.f13145x = (PropertyBag) graphQLStoryAttachment.U_().clone();
        return graphQLStoryAttachment$Builder;
    }

    public final GraphQLStoryAttachment m21850a() {
        return new GraphQLStoryAttachment(this);
    }
}

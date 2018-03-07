package com.facebook.graphql.model;

import com.facebook.graphql.enums.GraphQLStorySetCollectionType;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: UTF-8 */
public class GraphQLStorySet$Builder extends Builder {
    public ImmutableList<GraphQLStoryActionLink> f13173d;
    @Nullable
    public GraphQLStorySetStoriesConnection f13174e;
    @Nullable
    public String f13175f;
    public ImmutableList<GraphQLStorySetCollectionType> f13176g;
    @Nullable
    public String f13177h;
    @Nullable
    public String f13178i;
    public long f13179j;
    @Nullable
    public String f13180k;
    @Nullable
    public String f13181l;
    @Nullable
    public String f13182m;
    @Nullable
    public String f13183n;
    public int f13184o;
    @Nullable
    public GraphQLNegativeFeedbackActionsConnection f13185p;
    @Nullable
    public GraphQLImage f13186q;
    @Nullable
    public String f13187r;
    @Nullable
    public GraphQLTextWithEntities f13188s;
    @Nullable
    public GraphQLTextWithEntities f13189t;
    @Nullable
    public String f13190u;
    @Nullable
    public String f13191v;
    @Nullable
    PropertyBag f13192w = null;

    public GraphQLStorySet$Builder() {
        Preconditions.checkState(this instanceof GraphQLStorySet$Builder);
    }

    public static GraphQLStorySet$Builder m21888a(GraphQLStorySet graphQLStorySet) {
        GraphQLStorySet$Builder graphQLStorySet$Builder = new GraphQLStorySet$Builder();
        graphQLStorySet.h();
        graphQLStorySet$Builder.f13173d = graphQLStorySet.y();
        graphQLStorySet$Builder.f13174e = graphQLStorySet.z();
        graphQLStorySet$Builder.f13175f = graphQLStorySet.g();
        graphQLStorySet$Builder.f13176g = graphQLStorySet.G();
        graphQLStorySet$Builder.f13177h = graphQLStorySet.S_();
        graphQLStorySet$Builder.f13178i = graphQLStorySet.A();
        graphQLStorySet$Builder.f13179j = graphQLStorySet.T_();
        graphQLStorySet$Builder.f13180k = graphQLStorySet.H();
        graphQLStorySet$Builder.f13181l = graphQLStorySet.B();
        graphQLStorySet$Builder.f13182m = graphQLStorySet.J();
        graphQLStorySet$Builder.f13183n = graphQLStorySet.K();
        graphQLStorySet$Builder.f13184o = graphQLStorySet.L();
        graphQLStorySet$Builder.f13185p = graphQLStorySet.I();
        graphQLStorySet$Builder.f13186q = graphQLStorySet.M();
        graphQLStorySet$Builder.f13187r = graphQLStorySet.C();
        graphQLStorySet$Builder.f13188s = graphQLStorySet.D();
        graphQLStorySet$Builder.f13189t = graphQLStorySet.E();
        graphQLStorySet$Builder.f13190u = graphQLStorySet.k();
        graphQLStorySet$Builder.f13191v = graphQLStorySet.F();
        Builder.a(graphQLStorySet$Builder, graphQLStorySet);
        graphQLStorySet$Builder.f13192w = (PropertyBag) graphQLStorySet.U_().clone();
        return graphQLStorySet$Builder;
    }

    public final GraphQLStorySet m21889a() {
        return new GraphQLStorySet(this);
    }
}

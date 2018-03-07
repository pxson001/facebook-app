package com.facebook.photos.consumptiongallery;

import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLHelper;

/* compiled from: statesMap */
public class Feedback {
    public GraphQLFeedback f2102a;
    public ObjectType f2103b;
    public String f2104c;
    public String f2105d;
    public long f2106e;
    public int f2107f;
    public int f2108g;
    public boolean f2109h;
    public boolean f2110i;
    public boolean f2111j;

    /* compiled from: statesMap */
    public enum ObjectType {
        STORY,
        PHOTO
    }

    public Feedback(GraphQLFeedback graphQLFeedback) {
        this.f2102a = graphQLFeedback;
        this.f2103b = ObjectType.STORY;
        this.f2104c = graphQLFeedback.z_();
        this.f2105d = graphQLFeedback.j();
        this.f2106e = -1;
        this.f2107f = GraphQLHelper.p(graphQLFeedback);
        this.f2108g = GraphQLHelper.f(graphQLFeedback);
        this.f2109h = graphQLFeedback.g();
        this.f2110i = graphQLFeedback.c();
        this.f2111j = graphQLFeedback.y_();
    }

    public Feedback(ConsumptionPhoto consumptionPhoto) {
        this.f2103b = ObjectType.PHOTO;
        this.f2104c = consumptionPhoto.f2083q;
        this.f2105d = null;
        this.f2106e = consumptionPhoto.a;
        this.f2107f = consumptionPhoto.f2076j;
        this.f2108g = consumptionPhoto.f2077k;
        this.f2109h = consumptionPhoto.f2078l;
        this.f2110i = consumptionPhoto.f2079m;
        this.f2111j = consumptionPhoto.f2080n;
    }

    public final boolean m2308h() {
        return (this.f2107f == 0 && this.f2108g == 0) ? false : true;
    }
}

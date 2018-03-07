package com.facebook.feedplugins.graphqlstory.seefirsttombstone;

import com.facebook.graphql.model.GraphQLActor;

/* compiled from: immediate_active_seconds */
public class SeeFirstTombstonePersistentState {
    public String f20360a;
    public String f20361b;
    public boolean f20362c;
    public boolean f20363d;

    public final void m28021a(GraphQLActor graphQLActor) {
        if (graphQLActor == null) {
            this.f20360a = null;
            this.f20361b = null;
            return;
        }
        this.f20360a = graphQLActor.aa();
        this.f20361b = graphQLActor.m23765H();
        this.f20362c = graphQLActor.m23790b().m22301g() == 2479791;
    }
}

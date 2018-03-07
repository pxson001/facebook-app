package com.facebook.events.tickets.modal;

import android.net.Uri;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.Mutator;
import com.facebook.events.tickets.modal.EventBuyTicketsModel.State;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import javax.annotation.Nullable;

/* compiled from: arg_parent_fragment_id */
public class EventBuyTicketsModelBuilder implements Mutator {
    public String f19237A;
    private boolean f19238B;
    public State f19239C;
    public String f19240a;
    public String f19241b;
    public String f19242c;
    public int f19243d;
    public int f19244e;
    public String f19245f;
    public int f19246g;
    public String f19247h;
    public String f19248i;
    @Nullable
    public Uri f19249j;
    public LinkableTextWithEntitiesModel f19250k;
    public LinkableTextWithEntitiesModel f19251l;
    public LinkableTextWithEntitiesModel f19252m;
    public String f19253n;
    public String f19254o;
    public String f19255p;
    public String f19256q;
    public String f19257r;
    public GraphQLEventWatchStatus f19258s;
    private String f19259t;
    private String f19260u;
    private LinkableTextWithEntitiesModel f19261v;
    public String f19262w;
    public String f19263x;
    public int f19264y;
    public String f19265z;

    public final /* synthetic */ Mutator mo872e(String str) {
        this.f19240a = str;
        return this;
    }

    public final /* synthetic */ Mutator mo866a(String str) {
        this.f19262w = str;
        return this;
    }

    public final /* synthetic */ Mutator mo869b(String str) {
        this.f19263x = str;
        return this;
    }

    public final /* synthetic */ Mutator mo863a(int i) {
        this.f19264y = i;
        return this;
    }

    public final /* synthetic */ Mutator mo870c(String str) {
        this.f19265z = str;
        return this;
    }

    public final /* synthetic */ Mutator mo871d(String str) {
        this.f19237A = str;
        return this;
    }

    public final Mutator mo867a(boolean z) {
        this.f19238B = z;
        return this;
    }

    public final Mutator mo873f(String str) {
        this.f19259t = str;
        return this;
    }

    public final Mutator mo874g(String str) {
        this.f19260u = str;
        return this;
    }

    public final Mutator mo865a(LinkableTextWithEntitiesModel linkableTextWithEntitiesModel) {
        this.f19261v = linkableTextWithEntitiesModel;
        return this;
    }

    public final /* synthetic */ Mutator mo864a(State state) {
        this.f19239C = state;
        return this;
    }

    public final EventBuyTicketsModel mo868a() {
        return new EventBuyTicketsModel(this.f19240a, this.f19241b, this.f19242c, this.f19243d, this.f19244e, this.f19245f, this.f19246g, this.f19247h, this.f19248i, this.f19249j, this.f19250k, this.f19251l, this.f19252m, this.f19253n, this.f19254o, this.f19255p, this.f19256q, this.f19257r, this.f19258s, this.f19262w, this.f19263x, this.f19264y, this.f19265z, this.f19237A, this.f19238B, this.f19259t, this.f19260u, this.f19261v, this.f19239C);
    }
}

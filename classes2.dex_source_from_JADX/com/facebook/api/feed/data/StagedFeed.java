package com.facebook.api.feed.data;

import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.graphql.model.IsValidUtil;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

/* compiled from: sendZeroHeaderRequestParams */
public class StagedFeed implements Iterable<FeedEdge> {
    public List<FeedEdge> f5664a = Lists.m1296a();
    public FetchPortion f5665b = FetchPortion.CHUNKED_REMAINDER;
    public String f5666c;
    public boolean f5667d = false;
    public boolean f5668e = false;
    public boolean f5669f = false;

    public final void m9780a(List<? extends FeedEdge> list, GraphQLPageInfo graphQLPageInfo, FetchPortion fetchPortion) {
        if (IsValidUtil.m22952a(graphQLPageInfo) || !(list == null || list.isEmpty())) {
            this.f5669f = true;
            this.f5666c = graphQLPageInfo.mo1405a();
            this.f5668e = graphQLPageInfo.mo1407b();
            if (fetchPortion != FetchPortion.CHUNKED_REMAINDER) {
                this.f5667d = graphQLPageInfo.mo1408c();
            }
            this.f5665b = fetchPortion;
            this.f5664a.addAll(list);
        } else if (this.f5669f) {
            this.f5668e = graphQLPageInfo.mo1407b();
        }
    }

    public final void m9781b() {
        this.f5664a.clear();
        this.f5665b = FetchPortion.CHUNKED_REMAINDER;
        this.f5666c = null;
        this.f5667d = false;
        this.f5668e = false;
        this.f5669f = false;
    }

    public final int m9782f() {
        return this.f5664a.size();
    }

    public Iterator<FeedEdge> iterator() {
        return this.f5664a.iterator();
    }

    public final String m9783g() {
        if (this.f5664a.isEmpty()) {
            return null;
        }
        return ((GraphQLFeedUnitEdge) this.f5664a.get(0)).W_();
    }
}

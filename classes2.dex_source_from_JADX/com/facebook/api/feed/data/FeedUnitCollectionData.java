package com.facebook.api.feed.data;

import com.facebook.api.feed.util.FeedEdgeComparator;
import com.facebook.common.collect.MapWithSecondaryOrdering;
import com.facebook.feed.model.GapFeedEdge;
import com.facebook.graphql.model.DedupableUtil;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: send_additional_contacts */
public class FeedUnitCollectionData implements Iterable<FeedEdge> {
    public final MapWithSecondaryOrdering<String, FeedEdge> f5659a = new MapWithSecondaryOrdering(FeedEdgeComparator.f5641a);
    public boolean f5660b;
    public List<String> f5661c = new ArrayList();
    public List<Integer> f5662d;
    public boolean f5663e = true;

    public final boolean m9770a(String str) {
        return this.f5659a.containsKey(str);
    }

    public final GraphQLFeedUnitEdge m9773b(String str) {
        return (GraphQLFeedUnitEdge) this.f5659a.get(str);
    }

    public final void m9768a(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        if (this.f5660b && graphQLFeedUnitEdge.mo2540c() != null) {
            this.f5661c.add(graphQLFeedUnitEdge.mo2540c().mo2507g());
        }
        this.f5659a.remove(DedupableUtil.m23084a(graphQLFeedUnitEdge));
        m9765i();
    }

    public final void m9767a() {
        if (this.f5660b) {
            for (GraphQLFeedUnitEdge c : this.f5659a.values()) {
                this.f5661c.add(c.mo2540c().mo2507g());
            }
        }
        this.f5659a.clear();
        m9765i();
    }

    public final void m9774c(GraphQLFeedUnitEdge graphQLFeedUnitEdge) {
        this.f5659a.put(DedupableUtil.m23084a(graphQLFeedUnitEdge), graphQLFeedUnitEdge);
        m9765i();
    }

    public final int m9771b() {
        return this.f5659a.size();
    }

    public final boolean m9777d() {
        m9766j();
        return !this.f5662d.isEmpty();
    }

    public final void m9778e() {
        m9766j();
        if (m9777d()) {
            m9768a((GraphQLFeedUnitEdge) this.f5659a.f5654e.get(((Integer) this.f5662d.get(0)).intValue()));
        }
    }

    public final int m9779f() {
        m9766j();
        return m9777d() ? ((Integer) this.f5662d.get(0)).intValue() : -1;
    }

    public final boolean m9769a(int i) {
        m9766j();
        return m9772b(i) != -1;
    }

    public final int m9772b(int i) {
        m9766j();
        for (int i2 = 0; i2 < this.f5662d.size(); i2++) {
            int intValue = ((Integer) this.f5662d.get(i2)).intValue();
            if (intValue > i) {
                return intValue;
            }
        }
        return -1;
    }

    public final boolean m9775c(int i) {
        m9766j();
        return this.f5662d.contains(Integer.valueOf(i));
    }

    private void m9765i() {
        this.f5663e = true;
    }

    private void m9766j() {
        if (this.f5663e) {
            if (this.f5662d == null) {
                this.f5662d = new ArrayList(3);
            }
            this.f5662d.clear();
            this.f5663e = false;
            for (int i = 0; i < this.f5659a.size(); i++) {
                if (((GraphQLFeedUnitEdge) this.f5659a.f5654e.get(i)) instanceof GapFeedEdge) {
                    this.f5662d.add(Integer.valueOf(i));
                }
            }
        }
    }

    public final GraphQLFeedUnitEdge m9776d(int i) {
        return (GraphQLFeedUnitEdge) this.f5659a.f5654e.get(i);
    }

    public Iterator<FeedEdge> iterator() {
        return this.f5659a.f5654e.iterator();
    }
}

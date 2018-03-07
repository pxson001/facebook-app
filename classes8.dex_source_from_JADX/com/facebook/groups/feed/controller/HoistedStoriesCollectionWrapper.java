package com.facebook.groups.feed.controller;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.FeedEdge;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;

/* compiled from: facts_count */
public class HoistedStoriesCollectionWrapper implements ListItemCollection<FeedEdge> {
    private static final String f13972a = HoistedStoriesCollectionWrapper.class.getName();
    public final ListItemCollection<FeedEdge> f13973b;
    public List<String> f13974c;
    private ImmutableList<Integer> f13975d;

    public HoistedStoriesCollectionWrapper(ListItemCollection<FeedEdge> listItemCollection, List<String> list) {
        this.f13973b = listItemCollection;
        this.f13974c = list;
        m15586b();
    }

    public final void m15586b() {
        ImmutableMap b;
        Builder builder = ImmutableList.builder();
        ImmutableMap.Builder builder2 = ImmutableMap.builder();
        List arrayList = new ArrayList();
        if (this.f13974c == null || this.f13974c.isEmpty()) {
            b = builder2.b();
        } else {
            for (int i = 0; i < this.f13973b.a(); i++) {
                String str;
                Object obj;
                FeedUnit c = ((GraphQLFeedUnitEdge) this.f13973b.a(i)).c();
                if (c == null || !(c instanceof GraphQLStory)) {
                    str = null;
                } else {
                    str = ((GraphQLStory) c).c();
                }
                String str2 = str;
                if (str2 == null || !this.f13974c.contains(str2) || arrayList.contains(str2)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    builder2.b(str2, Integer.valueOf(i));
                    arrayList.add(str2);
                }
            }
            b = builder2.b();
        }
        ImmutableMap immutableMap = b;
        for (String str3 : this.f13974c) {
            if (immutableMap.containsKey(str3)) {
                builder.c(immutableMap.get(str3));
            }
        }
        int i2 = 0;
        while (i2 < this.f13973b.a()) {
            if (immutableMap.isEmpty() || !immutableMap.containsValue(Integer.valueOf(i2))) {
                builder.c(Integer.valueOf(i2));
            }
            i2++;
        }
        this.f13975d = builder.b();
    }

    public final int m15584a() {
        if (this.f13973b.a() != this.f13975d.size()) {
            BLog.c(f13972a, "Mismatched collection size, original: %d mapping: %d", new Object[]{Integer.valueOf(this.f13973b.a()), Integer.valueOf(this.f13975d.size())});
        }
        return this.f13973b.a();
    }

    public final Object m15585a(int i) {
        if (i < this.f13975d.size() && ((Integer) this.f13975d.get(i)).intValue() < this.f13973b.a()) {
            return (GraphQLFeedUnitEdge) this.f13973b.a(((Integer) this.f13975d.get(i)).intValue());
        }
        BLog.c(f13972a, "Requesting element at: %d Mismatched collection size, original: %d mapping: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f13973b.a()), Integer.valueOf(this.f13975d.size())});
        return (GraphQLFeedUnitEdge) this.f13973b.a(i);
    }
}

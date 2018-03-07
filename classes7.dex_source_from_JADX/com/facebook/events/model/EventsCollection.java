package com.facebook.events.model;

import android.support.v4.util.ArrayMap;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: supports_free_form */
public class EventsCollection<T extends GraphQLPersistableNode> {
    public final Map<String, Integer> f2757a = new ArrayMap();
    public final ArrayList<T> f2758b;

    public EventsCollection(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            this.f2757a.put(((GraphQLPersistableNode) list.get(i)).a(), Integer.valueOf(i));
        }
        this.f2758b = new ArrayList(list);
    }

    public final ImmutableList<T> m3026b() {
        return ImmutableList.copyOf(this.f2758b);
    }
}

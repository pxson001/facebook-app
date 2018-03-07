package com.facebook.api.feed.data;

import com.facebook.graphql.model.FeedEdge;
import java.util.ArrayList;
import java.util.List;

/* compiled from: send/publish/exception; topic=%s */
public class FeedOnTopCache {
    public static int f5670a = 4;
    public FetchPortion f5671b = FetchPortion.FULL;
    public List<FeedEdge> f5672c = new ArrayList();

    public final void m9784a() {
        this.f5672c.clear();
    }

    public final void m9785a(List<? extends FeedEdge> list) {
        if (list != null && !list.isEmpty()) {
            int size;
            int size2 = (list.size() + this.f5672c.size()) - f5670a;
            if (list.size() >= f5670a) {
                m9784a();
            } else if (size2 > 0) {
                for (size = this.f5672c.size() - 1; size >= 0 && size2 > 0; size--) {
                    this.f5672c.remove(size);
                    size2--;
                }
            }
            size = 0;
            while (size < list.size() && size < f5670a) {
                this.f5672c.add(size, list.get(size));
                size++;
            }
        }
    }

    public final boolean m9786d() {
        return this.f5672c.isEmpty();
    }
}

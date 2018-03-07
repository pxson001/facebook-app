package com.facebook.video.videohome.data;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* compiled from: status_from_server */
public class VideoHomeItemCollection implements ListItemCollection<ReactionUnitComponentNode> {
    public final List<ReactionUnitComponentNode> f2821a = new ArrayList();

    public final /* synthetic */ Object m2705a(int i) {
        return m2702b(i);
    }

    private boolean m2701a(int i, Collection<? extends ReactionUnitComponentNode> collection) {
        return this.f2821a.addAll(i, collection);
    }

    public final boolean m2706a(String str, Collection<? extends ReactionUnitComponentNode> collection) {
        for (int i = 0; i < m2703a(); i++) {
            if (m2702b(i).c.equals(str)) {
                return m2701a(i, (Collection) collection);
            }
        }
        return false;
    }

    public final boolean m2707a(String str, List<ReactionUnitComponentNode> list) {
        int a = m2704a(str);
        if (a > 0) {
            return m2701a(a, (Collection) list);
        }
        return false;
    }

    public final int m2704a(String str) {
        Iterator it = this.f2821a.iterator();
        int i = -1;
        int i2 = 0;
        while (it.hasNext()) {
            if (((ReactionUnitComponentNode) it.next()).c.equals(str)) {
                if (i < 0) {
                    i = i2;
                }
                it.remove();
            }
            i2++;
        }
        return i;
    }

    public final int m2703a() {
        return this.f2821a.size();
    }

    private ReactionUnitComponentNode m2702b(int i) {
        return (ReactionUnitComponentNode) this.f2821a.get(i);
    }
}

package com.facebook.reaction.feed.showmore;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import java.util.ArrayList;
import java.util.List;

/* compiled from: android.permission.READ_PROFILE */
public class ReactionShowMoreComponentsItemCollection implements ListItemCollection<ReactionUnitComponentNode> {
    public final List<ReactionUnitComponentNode> f19503a = new ArrayList();

    public static ReactionShowMoreComponentsItemCollection m23448a(InjectorLike injectorLike) {
        return new ReactionShowMoreComponentsItemCollection();
    }

    public final int m23449a() {
        return this.f19503a.size();
    }

    public final Object m23450a(int i) {
        return (ReactionUnitComponentNode) this.f19503a.get(i);
    }
}

package com.facebook.gametime.ui.plays;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Starting search session with one already ongoing */
public class GametimePlaysCollection implements ListItemCollection<GametimeDataFactFragment> {
    public final List<GametimeDataFactFragment> f25315a = new ArrayList();

    public final int m27219a() {
        return this.f25315a.size();
    }

    public final Object m27220a(int i) {
        return (GametimeDataFactFragment) this.f25315a.get(i);
    }
}

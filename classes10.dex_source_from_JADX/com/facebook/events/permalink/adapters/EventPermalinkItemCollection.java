package com.facebook.events.permalink.adapters;

import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.events.permalink.multirow.EventPartDefinitionKey;
import com.facebook.events.permalink.multirow.EventPermalinkNode;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import java.util.ArrayList;

/* compiled from: buy_event_tickets */
public class EventPermalinkItemCollection implements ListItemCollection<Object> {
    public static final Object f18163a = new Object();
    private final ArrayList<EventPermalinkNode<?>> f18164b = new ArrayList();
    private EventPermalinkNode<GraphQLStory> f18165c;
    private EventPermalinkNode<Object> f18166d;
    public FeedUnitCollection f18167e;

    public static EventPermalinkItemCollection m18542a(InjectorLike injectorLike) {
        return new EventPermalinkItemCollection();
    }

    public final int m18545a() {
        return (this.f18167e == null ? 0 : this.f18167e.a()) + this.f18164b.size();
    }

    public final Object m18546a(int i) {
        int size = this.f18164b.size();
        return i < size ? this.f18164b.get(i) : this.f18167e.b(i - size);
    }

    public final GraphQLStory m18549b() {
        EventPermalinkNode eventPermalinkNode = this.f18165c;
        return (GraphQLStory) (eventPermalinkNode == null ? null : eventPermalinkNode.f18712a);
    }

    public final void m18547a(GraphQLStory graphQLStory) {
        this.f18165c = EventPermalinkNode.m18998a(EventPartDefinitionKey.f18709c, graphQLStory);
        m18544d();
    }

    public final void m18548a(boolean z) {
        this.f18166d = EventPermalinkNode.m18998a(EventPartDefinitionKey.f18711e, z ? f18163a : null);
        m18544d();
    }

    private void m18544d() {
        this.f18164b.clear();
        m18543a(this.f18165c);
        m18543a(this.f18166d);
    }

    private void m18543a(EventPermalinkNode<?> eventPermalinkNode) {
        if (eventPermalinkNode != null) {
            this.f18164b.add(eventPermalinkNode);
        }
    }
}

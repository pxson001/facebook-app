package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unknown query param name  */
public class FeedTextHeaderComponent$State extends Component<FeedTextHeaderComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21235a;
    public E f21236b;
    final /* synthetic */ FeedTextHeaderComponent f21237c;

    public FeedTextHeaderComponent$State(FeedTextHeaderComponent feedTextHeaderComponent) {
        this.f21237c = feedTextHeaderComponent;
        super(feedTextHeaderComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FeedTextHeaderComponent$State feedTextHeaderComponent$State = (FeedTextHeaderComponent$State) obj;
        if (this.b == feedTextHeaderComponent$State.b) {
            return true;
        }
        if (this.f21235a == null ? feedTextHeaderComponent$State.f21235a != null : !this.f21235a.equals(feedTextHeaderComponent$State.f21235a)) {
            return false;
        }
        if (this.f21236b != null) {
            if (this.f21236b.equals(feedTextHeaderComponent$State.f21236b)) {
                return true;
            }
        } else if (feedTextHeaderComponent$State.f21236b == null) {
            return true;
        }
        return false;
    }
}

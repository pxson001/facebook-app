package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unexpected height! expected= */
public class LikableHeaderComponent$State extends Component<LikableHeaderComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21364a;
    public E f21365b;
    final /* synthetic */ LikableHeaderComponent f21366c;

    public LikableHeaderComponent$State(LikableHeaderComponent likableHeaderComponent) {
        this.f21366c = likableHeaderComponent;
        super(likableHeaderComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LikableHeaderComponent$State likableHeaderComponent$State = (LikableHeaderComponent$State) obj;
        if (this.b == likableHeaderComponent$State.b) {
            return true;
        }
        if (this.f21364a == null ? likableHeaderComponent$State.f21364a != null : !this.f21364a.equals(likableHeaderComponent$State.f21364a)) {
            return false;
        }
        if (this.f21365b != null) {
            if (this.f21365b.equals(likableHeaderComponent$State.f21365b)) {
                return true;
            }
        } else if (likableHeaderComponent$State.f21365b == null) {
            return true;
        }
        return false;
    }
}

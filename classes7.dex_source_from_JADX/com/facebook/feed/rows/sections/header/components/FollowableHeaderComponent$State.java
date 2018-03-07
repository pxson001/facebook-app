package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unknown condition type  */
public class FollowableHeaderComponent$State extends Component<FollowableHeaderComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21263a;
    public E f21264b;
    final /* synthetic */ FollowableHeaderComponent f21265c;

    public FollowableHeaderComponent$State(FollowableHeaderComponent followableHeaderComponent) {
        this.f21265c = followableHeaderComponent;
        super(followableHeaderComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FollowableHeaderComponent$State followableHeaderComponent$State = (FollowableHeaderComponent$State) obj;
        if (this.b == followableHeaderComponent$State.b) {
            return true;
        }
        if (this.f21263a == null ? followableHeaderComponent$State.f21263a != null : !this.f21263a.equals(followableHeaderComponent$State.f21263a)) {
            return false;
        }
        if (this.f21264b != null) {
            if (this.f21264b.equals(followableHeaderComponent$State.f21264b)) {
                return true;
            }
        } else if (followableHeaderComponent$State.f21264b == null) {
            return true;
        }
        return false;
    }
}

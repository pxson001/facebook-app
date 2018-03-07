package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unknown module type  */
public class FollowButtonComponent$State extends Component<FollowButtonComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21246a;
    public String f21247b;
    public GraphQLSubscribeStatus f21248c;
    public E f21249d;
    int f21250e = FollowButtonComponentSpec.a;
    int f21251f = FollowButtonComponentSpec.b;
    public SubscribeLocation f21252g;
    public ActorUnsubscribeInputData.SubscribeLocation f21253h;
    final /* synthetic */ FollowButtonComponent f21254i;

    public FollowButtonComponent$State(FollowButtonComponent followButtonComponent) {
        this.f21254i = followButtonComponent;
        super(followButtonComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FollowButtonComponent$State followButtonComponent$State = (FollowButtonComponent$State) obj;
        if (this.b == followButtonComponent$State.b) {
            return true;
        }
        if (this.f21246a == null ? followButtonComponent$State.f21246a != null : !this.f21246a.equals(followButtonComponent$State.f21246a)) {
            return false;
        }
        if (this.f21247b == null ? followButtonComponent$State.f21247b != null : !this.f21247b.equals(followButtonComponent$State.f21247b)) {
            return false;
        }
        if (this.f21248c == null ? followButtonComponent$State.f21248c != null : !this.f21248c.equals(followButtonComponent$State.f21248c)) {
            return false;
        }
        if (this.f21249d == null ? followButtonComponent$State.f21249d != null : !this.f21249d.equals(followButtonComponent$State.f21249d)) {
            return false;
        }
        if (this.f21250e != followButtonComponent$State.f21250e) {
            return false;
        }
        if (this.f21251f != followButtonComponent$State.f21251f) {
            return false;
        }
        if (this.f21252g == null ? followButtonComponent$State.f21252g != null : !this.f21252g.equals(followButtonComponent$State.f21252g)) {
            return false;
        }
        if (this.f21253h != null) {
            if (this.f21253h.equals(followButtonComponent$State.f21253h)) {
                return true;
            }
        } else if (followButtonComponent$State.f21253h == null) {
            return true;
        }
        return false;
    }
}

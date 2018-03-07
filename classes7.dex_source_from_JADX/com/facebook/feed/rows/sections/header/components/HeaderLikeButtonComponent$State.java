package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unicode Exception */
public class HeaderLikeButtonComponent$State extends Component<HeaderLikeButtonComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21323a;
    public E f21324b;
    final /* synthetic */ HeaderLikeButtonComponent f21325c;

    public HeaderLikeButtonComponent$State(HeaderLikeButtonComponent headerLikeButtonComponent) {
        this.f21325c = headerLikeButtonComponent;
        super(headerLikeButtonComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HeaderLikeButtonComponent$State headerLikeButtonComponent$State = (HeaderLikeButtonComponent$State) obj;
        if (this.b == headerLikeButtonComponent$State.b) {
            return true;
        }
        if (this.f21323a == null ? headerLikeButtonComponent$State.f21323a != null : !this.f21323a.equals(headerLikeButtonComponent$State.f21323a)) {
            return false;
        }
        if (this.f21324b != null) {
            if (this.f21324b.equals(headerLikeButtonComponent$State.f21324b)) {
                return true;
            }
        } else if (headerLikeButtonComponent$State.f21324b == null) {
            return true;
        }
        return false;
    }
}

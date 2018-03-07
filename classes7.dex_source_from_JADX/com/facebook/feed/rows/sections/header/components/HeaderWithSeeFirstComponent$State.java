package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unexpected moov box. */
public class HeaderWithSeeFirstComponent$State extends Component<HeaderWithSeeFirstComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21353a;
    public E f21354b;
    final /* synthetic */ HeaderWithSeeFirstComponent f21355c;

    public HeaderWithSeeFirstComponent$State(HeaderWithSeeFirstComponent headerWithSeeFirstComponent) {
        this.f21355c = headerWithSeeFirstComponent;
        super(headerWithSeeFirstComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HeaderWithSeeFirstComponent$State headerWithSeeFirstComponent$State = (HeaderWithSeeFirstComponent$State) obj;
        if (this.b == headerWithSeeFirstComponent$State.b) {
            return true;
        }
        if (this.f21353a == null ? headerWithSeeFirstComponent$State.f21353a != null : !this.f21353a.equals(headerWithSeeFirstComponent$State.f21353a)) {
            return false;
        }
        if (this.f21354b != null) {
            if (this.f21354b.equals(headerWithSeeFirstComponent$State.f21354b)) {
                return true;
            }
        } else if (headerWithSeeFirstComponent$State.f21354b == null) {
            return true;
        }
        return false;
    }
}

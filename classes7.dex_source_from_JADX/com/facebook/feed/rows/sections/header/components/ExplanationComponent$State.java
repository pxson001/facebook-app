package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unknown type */
public class ExplanationComponent$State extends Component<ExplanationComponent> implements Cloneable {
    FeedProps<GraphQLStory> f21209a;
    E f21210b;
    TextHeaderStyle f21211c;
    final /* synthetic */ ExplanationComponent f21212d;

    public ExplanationComponent$State(ExplanationComponent explanationComponent) {
        this.f21212d = explanationComponent;
        super(explanationComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExplanationComponent$State explanationComponent$State = (ExplanationComponent$State) obj;
        if (this.b == explanationComponent$State.b) {
            return true;
        }
        if (this.f21209a == null ? explanationComponent$State.f21209a != null : !this.f21209a.equals(explanationComponent$State.f21209a)) {
            return false;
        }
        if (this.f21210b == null ? explanationComponent$State.f21210b != null : !this.f21210b.equals(explanationComponent$State.f21210b)) {
            return false;
        }
        if (this.f21211c != null) {
            if (this.f21211c.equals(explanationComponent$State.f21211c)) {
                return true;
            }
        } else if (explanationComponent$State.f21211c == null) {
            return true;
        }
        return false;
    }
}

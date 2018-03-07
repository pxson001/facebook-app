package com.facebook.feed.rows.sections.text;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: UNDO_CLICKED */
public class InstantArticleTextComponent$State extends Component<InstantArticleTextComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21584a;
    public E f21585b;
    final /* synthetic */ InstantArticleTextComponent f21586c;

    public InstantArticleTextComponent$State(InstantArticleTextComponent instantArticleTextComponent) {
        this.f21586c = instantArticleTextComponent;
        super(instantArticleTextComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InstantArticleTextComponent$State instantArticleTextComponent$State = (InstantArticleTextComponent$State) obj;
        if (this.b == instantArticleTextComponent$State.b) {
            return true;
        }
        if (this.f21584a == null ? instantArticleTextComponent$State.f21584a != null : !this.f21584a.equals(instantArticleTextComponent$State.f21584a)) {
            return false;
        }
        if (this.f21585b != null) {
            if (this.f21585b.equals(instantArticleTextComponent$State.f21585b)) {
                return true;
            }
        } else if (instantArticleTextComponent$State.f21585b == null) {
            return true;
        }
        return false;
    }
}

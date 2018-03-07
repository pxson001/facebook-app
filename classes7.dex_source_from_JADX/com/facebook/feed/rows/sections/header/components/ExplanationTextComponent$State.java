package com.facebook.feed.rows.sections.header.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Unknown query param type  */
public class ExplanationTextComponent$State extends Component<ExplanationTextComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f21221a;
    public E f21222b;
    public int f21223c;
    public int f21224d;
    public int f21225e;
    final /* synthetic */ ExplanationTextComponent f21226f;

    public ExplanationTextComponent$State(ExplanationTextComponent explanationTextComponent) {
        this.f21226f = explanationTextComponent;
        super(explanationTextComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExplanationTextComponent$State explanationTextComponent$State = (ExplanationTextComponent$State) obj;
        if (this.b == explanationTextComponent$State.b) {
            return true;
        }
        if (this.f21221a == null ? explanationTextComponent$State.f21221a != null : !this.f21221a.equals(explanationTextComponent$State.f21221a)) {
            return false;
        }
        if (this.f21222b == null ? explanationTextComponent$State.f21222b != null : !this.f21222b.equals(explanationTextComponent$State.f21222b)) {
            return false;
        }
        if (this.f21223c != explanationTextComponent$State.f21223c) {
            return false;
        }
        if (this.f21224d != explanationTextComponent$State.f21224d) {
            return false;
        }
        if (this.f21225e != explanationTextComponent$State.f21225e) {
            return false;
        }
        return true;
    }
}

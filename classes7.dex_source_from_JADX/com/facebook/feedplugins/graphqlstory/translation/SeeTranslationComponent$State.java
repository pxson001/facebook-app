package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: Save Button is binded without a target object. */
public class SeeTranslationComponent$State extends Component<SeeTranslationComponent> implements Cloneable {
    public FeedProps<GraphQLStory> f23456a;
    public E f23457b;
    TranslatedTextPersistentState f23458c;
    final /* synthetic */ SeeTranslationComponent f23459d;

    public SeeTranslationComponent$State(SeeTranslationComponent seeTranslationComponent) {
        this.f23459d = seeTranslationComponent;
        super(seeTranslationComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SeeTranslationComponent$State seeTranslationComponent$State = (SeeTranslationComponent$State) obj;
        if (this.b == seeTranslationComponent$State.b) {
            return true;
        }
        if (this.f23456a == null ? seeTranslationComponent$State.f23456a != null : !this.f23456a.equals(seeTranslationComponent$State.f23456a)) {
            return false;
        }
        if (this.f23457b != null) {
            if (this.f23457b.equals(seeTranslationComponent$State.f23457b)) {
                return true;
            }
        } else if (seeTranslationComponent$State.f23457b == null) {
            return true;
        }
        return false;
    }

    protected final void m25745a(Component<SeeTranslationComponent> component) {
        this.f23458c = ((SeeTranslationComponent$State) component).f23458c;
    }
}

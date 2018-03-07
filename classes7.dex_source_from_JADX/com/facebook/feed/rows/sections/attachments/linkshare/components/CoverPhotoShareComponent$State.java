package com.facebook.feed.rows.sections.attachments.linkshare.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: Verb */
public class CoverPhotoShareComponent$State extends Component<CoverPhotoShareComponent> implements Cloneable {
    public FeedProps<GraphQLStoryAttachment> f21049a;
    public E f21050b;
    final /* synthetic */ CoverPhotoShareComponent f21051c;

    public CoverPhotoShareComponent$State(CoverPhotoShareComponent coverPhotoShareComponent) {
        this.f21051c = coverPhotoShareComponent;
        super(coverPhotoShareComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CoverPhotoShareComponent$State coverPhotoShareComponent$State = (CoverPhotoShareComponent$State) obj;
        if (this.b == coverPhotoShareComponent$State.b) {
            return true;
        }
        if (this.f21049a == null ? coverPhotoShareComponent$State.f21049a != null : !this.f21049a.equals(coverPhotoShareComponent$State.f21049a)) {
            return false;
        }
        if (this.f21050b != null) {
            if (this.f21050b.equals(coverPhotoShareComponent$State.f21050b)) {
                return true;
            }
        } else if (coverPhotoShareComponent$State.f21050b == null) {
            return true;
        }
        return false;
    }
}

package com.facebook.feedplugins.pyml.rows.components;

import com.facebook.components.Component;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;

/* compiled from: android.settings.INTERNAL_STORAGE_SETTINGS */
public class PagesYouMayLikeComponent$State extends Component<PagesYouMayLikeComponent> implements Cloneable {
    E f19805a;
    FeedUnitAndChangePageListener<GraphQLPYMLWithLargeImageFeedUnit> f19806b;
    boolean f19807c;
    final /* synthetic */ PagesYouMayLikeComponent f19808d;

    public PagesYouMayLikeComponent$State(PagesYouMayLikeComponent pagesYouMayLikeComponent) {
        this.f19808d = pagesYouMayLikeComponent;
        super(pagesYouMayLikeComponent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PagesYouMayLikeComponent$State pagesYouMayLikeComponent$State = (PagesYouMayLikeComponent$State) obj;
        if (this.b == pagesYouMayLikeComponent$State.b) {
            return true;
        }
        if (this.f19805a == null ? pagesYouMayLikeComponent$State.f19805a != null : !this.f19805a.equals(pagesYouMayLikeComponent$State.f19805a)) {
            return false;
        }
        if (this.f19806b == null ? pagesYouMayLikeComponent$State.f19806b != null : !this.f19806b.equals(pagesYouMayLikeComponent$State.f19806b)) {
            return false;
        }
        if (this.f19807c != pagesYouMayLikeComponent$State.f19807c) {
            return false;
        }
        return true;
    }
}

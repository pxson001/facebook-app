package com.facebook.events.widget.eventcard;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelector.PublicEventOptionsPresenter;
import com.facebook.graphql.enums.GraphQLEventWatchStatus;

/* compiled from: calculate_stats */
class EventActionButtonStateSelector$PublicEventOptionsPresenter$1 implements OnMenuItemClickListener {
    final /* synthetic */ GraphQLEventWatchStatus f17909a;
    final /* synthetic */ PublicEventOptionsPresenter f17910b;

    EventActionButtonStateSelector$PublicEventOptionsPresenter$1(PublicEventOptionsPresenter publicEventOptionsPresenter, GraphQLEventWatchStatus graphQLEventWatchStatus) {
        this.f17910b = publicEventOptionsPresenter;
        this.f17909a = graphQLEventWatchStatus;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f17910b.a.e.a(this.f17910b.c, this.f17909a);
        return true;
    }
}

package com.facebook.feed.ui.location;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Tap this icon and help us test Ad Break! Please leave feedback in the Live Feedback group. */
class StoryLocationPlaceInfoView$3 implements OnClickListener {
    final /* synthetic */ int f22327a;
    final /* synthetic */ GraphQLPlace f22328b;
    final /* synthetic */ StoryLocationPlaceInfoView f22329c;

    StoryLocationPlaceInfoView$3(StoryLocationPlaceInfoView storyLocationPlaceInfoView, int i, GraphQLPlace graphQLPlace) {
        this.f22329c = storyLocationPlaceInfoView;
        this.f22327a = i;
        this.f22328b = graphQLPlace;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 2052649463);
        StoryLocationPlaceInfoView.a(this.f22329c, this.f22327a, this.f22328b);
        Logger.a(2, EntryType.UI_INPUT_END, 1402262554, a);
    }
}

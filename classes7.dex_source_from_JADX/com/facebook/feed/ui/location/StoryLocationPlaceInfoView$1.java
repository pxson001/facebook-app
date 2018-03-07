package com.facebook.feed.ui.location;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: Tap this icon and help us test Ad Break! Please leave feedback in the Live Feedback group. */
class StoryLocationPlaceInfoView$1 implements OnClickListener {
    final /* synthetic */ GraphQLPlace f22325a;
    final /* synthetic */ StoryLocationPlaceInfoView f22326b;

    StoryLocationPlaceInfoView$1(StoryLocationPlaceInfoView storyLocationPlaceInfoView, GraphQLPlace graphQLPlace) {
        this.f22326b = storyLocationPlaceInfoView;
        this.f22325a = graphQLPlace;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1668158529);
        Intent a2 = this.f22326b.n.a(this.f22326b.getContext(), StringFormatUtil.a(FBLinks.al, new Object[]{this.f22325a.x(), CrowdEntryPoint.FEED_ADD_PHOTO_BUTTON.getFullName()}));
        if (a2 != null) {
            a2.putExtra("profile_name", this.f22325a.B());
            this.f22326b.o.a(a2, this.f22326b.getContext());
        } else {
            this.f22326b.l.a(getClass().getSimpleName(), "Could not create Suggest Edits intent for Add Photo button in News Feed");
        }
        LogUtils.a(1356430111, a);
    }
}

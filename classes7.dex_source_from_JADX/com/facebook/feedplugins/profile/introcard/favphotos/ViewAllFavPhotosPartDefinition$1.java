package com.facebook.feedplugins.profile.introcard.favphotos;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: SMS_USER */
class ViewAllFavPhotosPartDefinition$1 implements OnClickListener {
    final /* synthetic */ FeedProps f23757a;
    final /* synthetic */ FeedEnvironment f23758b;
    final /* synthetic */ ViewAllFavPhotosPartDefinition f23759c;

    ViewAllFavPhotosPartDefinition$1(ViewAllFavPhotosPartDefinition viewAllFavPhotosPartDefinition, FeedProps feedProps, FeedEnvironment feedEnvironment) {
        this.f23759c = viewAllFavPhotosPartDefinition;
        this.f23757a = feedProps;
        this.f23758b = feedEnvironment;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2119942269);
        ViewAllFavPhotosPartDefinition.a(this.f23759c, view, this.f23757a, this.f23758b);
        Logger.a(2, EntryType.UI_INPUT_END, -1251799865, a);
    }
}

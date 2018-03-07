package com.facebook.attachments.angora.actionbutton;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: userLatitude */
class ShareActionButton$OnShareClickListener implements OnClickListener {
    final /* synthetic */ ShareActionButton f886a;
    private FeedProps<GraphQLStory> f887b;

    public ShareActionButton$OnShareClickListener(ShareActionButton shareActionButton, FeedProps<GraphQLStory> feedProps) {
        this.f886a = shareActionButton;
        this.f887b = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 72257068);
        this.f886a.b.a(this.f887b, view, ComposerSourceType.AGGREGATED_STORY_ACTION_BUTTON, Surface.ANDROID_COMPOSER);
        Logger.a(2, EntryType.UI_INPUT_END, 609462576, a);
    }
}

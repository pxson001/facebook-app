package com.facebook.feedplugins.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.channelfeed.protocol.VideoChannelMutationsHelper;

/* compiled from: fragment_name */
class FollowVideosPromptPartDefinition$ButtonClickHandler implements OnClickListener {
    private final String f13028a;
    private final String f13029b;
    private final boolean f13030c;
    private final VideoChannelMutationsHelper f13031d;
    private final FollowVideosState f13032e;

    public FollowVideosPromptPartDefinition$ButtonClickHandler(String str, String str2, boolean z, VideoChannelMutationsHelper videoChannelMutationsHelper, FollowVideosState followVideosState) {
        this.f13028a = str;
        this.f13029b = str2;
        this.f13030c = z;
        this.f13031d = videoChannelMutationsHelper;
        this.f13032e = followVideosState;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1884833508);
        this.f13032e.a = true;
        if (this.f13030c) {
            this.f13031d.a(this.f13029b, Surface.UNKNOWN);
        } else {
            this.f13031d.a(this.f13029b, VideoChannelUnsubscribeInputData.Surface.UNKNOWN);
        }
        LogUtils.a(132714247, a);
    }
}

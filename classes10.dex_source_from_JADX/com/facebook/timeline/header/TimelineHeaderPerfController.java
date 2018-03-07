package com.facebook.timeline.header;

import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.data.PhotoLoadState;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.ui.TimelineFragmentView;
import javax.annotation.Nullable;

/* compiled from: friend_list_tab_selected */
public interface TimelineHeaderPerfController {
    void mo524a(@Nullable TimelineFragment timelineFragment);

    void mo525a(PhotoLoadState photoLoadState);

    void mo526a(@Nullable TimelineHeaderUserData timelineHeaderUserData, TimelineFragmentView timelineFragmentView);

    void mo527b(PhotoLoadState photoLoadState);
}

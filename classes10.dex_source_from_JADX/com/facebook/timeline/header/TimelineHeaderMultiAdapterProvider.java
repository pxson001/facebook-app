package com.facebook.timeline.header;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.widget.listview.FbListAdapter;
import java.util.List;

/* compiled from: friendlist_ */
public class TimelineHeaderMultiAdapterProvider extends AbstractAssistedProvider<TimelineHeaderMultiAdapter> {
    public static TimelineHeaderMultiAdapter m11452a(TimelineHeaderUserData timelineHeaderUserData, TimelineHeaderTopAdapter timelineHeaderTopAdapter, List<FbListAdapter> list) {
        return new TimelineHeaderMultiAdapter(timelineHeaderUserData, timelineHeaderTopAdapter, list);
    }
}

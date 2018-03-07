package com.facebook.timeline.header;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.timeline.contextual.TimelineContextualInfoAdapter;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: friends_day */
public class TimelineContextItemsSection extends CustomLinearLayout {
    public TimelineContextItemsSection(Context context) {
        super(context);
    }

    public TimelineContextItemsSection(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setAdapter(@Nullable TimelineContextualInfoAdapter timelineContextualInfoAdapter) {
        removeAllViews();
        if (timelineContextualInfoAdapter == null || timelineContextualInfoAdapter.getCount() == 0) {
            setVisibility(8);
            return;
        }
        for (int i = 0; i < timelineContextualInfoAdapter.getCount(); i++) {
            addView(timelineContextualInfoAdapter.getView(i, null, this));
        }
        setVisibility(0);
    }
}

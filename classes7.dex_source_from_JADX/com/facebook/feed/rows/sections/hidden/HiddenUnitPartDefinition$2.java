package com.facebook.feed.rows.sections.hidden;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: Unable to load IA %s */
class HiddenUnitPartDefinition$2 implements OnClickListener {
    final /* synthetic */ FeedProps f21466a;
    final /* synthetic */ HasFeedListType f21467b;
    final /* synthetic */ HiddenUnitPartDefinition f21468c;

    HiddenUnitPartDefinition$2(HiddenUnitPartDefinition hiddenUnitPartDefinition, FeedProps feedProps, HasFeedListType hasFeedListType) {
        this.f21468c = hiddenUnitPartDefinition;
        this.f21466a = feedProps;
        this.f21467b = hasFeedListType;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1636578383);
        HiddenUnitPartDefinition.a(this.f21468c, view.getContext(), this.f21466a, HiddenUnitPartDefinition.a(this.f21468c, this.f21467b.c()));
        Logger.a(2, EntryType.UI_INPUT_END, 1483179141, a);
    }
}

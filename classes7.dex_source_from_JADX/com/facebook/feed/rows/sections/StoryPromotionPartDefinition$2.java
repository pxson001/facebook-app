package com.facebook.feed.rows.sections;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: \s+ */
class StoryPromotionPartDefinition$2 implements OnClickListener {
    final /* synthetic */ StoryPromotionPartDefinition$State f20407a;
    final /* synthetic */ StoryPromotionPartDefinition f20408b;

    StoryPromotionPartDefinition$2(StoryPromotionPartDefinition storyPromotionPartDefinition, StoryPromotionPartDefinition$State storyPromotionPartDefinition$State) {
        this.f20408b = storyPromotionPartDefinition;
        this.f20407a = storyPromotionPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -92071787);
        StoryPromotionPartDefinition.b(this.f20408b, this.f20407a.f20430d, this.f20407a.f20434h, this.f20407a.f20428b, this.f20407a.f20433g);
        Logger.a(2, EntryType.UI_INPUT_END, -806858634, a);
    }
}

package com.facebook.feed.rows.sections;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: \s+ */
public class StoryPromotionPartDefinition$4 implements OnClickListener {
    final /* synthetic */ StoryPromotionPartDefinition$State f20420a;
    final /* synthetic */ String f20421b;
    final /* synthetic */ StoryPromotionPartDefinition f20422c;

    public StoryPromotionPartDefinition$4(StoryPromotionPartDefinition storyPromotionPartDefinition, StoryPromotionPartDefinition$State storyPromotionPartDefinition$State, String str) {
        this.f20422c = storyPromotionPartDefinition;
        this.f20420a = storyPromotionPartDefinition$State;
        this.f20421b = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1763292459);
        StoryPromotionPartDefinition.a(this.f20422c, this.f20420a, this.f20420a.f20430d, this.f20421b, StoryPromotionPartDefinition.a(this.f20422c, this.f20420a.f20434h, this.f20420a.f20433g));
        Logger.a(2, EntryType.UI_INPUT_END, 1317149993, a);
    }
}

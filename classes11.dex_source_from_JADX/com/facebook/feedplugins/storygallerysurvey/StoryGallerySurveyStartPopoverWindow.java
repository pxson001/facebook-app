package com.facebook.feedplugins.storygallerysurvey;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.feedplugins.storygallerysurvey.StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition.C11332.C11321;
import com.facebook.feedplugins.storygallerysurvey.constants.StoryGallerySurveyConstants.ActionType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: blacklistPeopleYouShouldFollowParamsKey */
public class StoryGallerySurveyStartPopoverWindow extends PopoverWindow {
    public C11321 f9521a;

    /* compiled from: blacklistPeopleYouShouldFollowParamsKey */
    public class C11341 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyStartPopoverWindow f9520a;

        public C11341(StoryGallerySurveyStartPopoverWindow storyGallerySurveyStartPopoverWindow) {
            this.f9520a = storyGallerySurveyStartPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2015564328);
            C11321 c11321 = this.f9520a.f9521a;
            c11321.f9504a.l();
            StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition.m10058a(c11321.f9506c.f9508b, c11321.f9506c.f9507a, c11321.f9505b);
            c11321.f9506c.f9508b.f9518d.m10070a(ActionType.START, c11321.f9506c.f9507a);
            Bundle bundle = new Bundle();
            FlatBufferModelHelper.a(bundle, "story_gallery_survey_feed_unit", c11321.f9506c.f9507a);
            c11321.f9506c.f9508b.f9516b.a(c11321.f9505b.getContext(), StoryGallerySurveyFeedUnitTwoButtonFooterPartDefinition.f9513a, bundle);
            Logger.a(2, EntryType.UI_INPUT_END, 719232490, a);
        }
    }

    public StoryGallerySurveyStartPopoverWindow(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130907251, null, false);
        d(inflate);
        inflate.findViewById(2131567692).setOnClickListener(new C11341(this));
    }
}

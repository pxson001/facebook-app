package com.facebook.storygallerysurvey.popover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.storygallerysurvey.fragment.StoryGallerySurveyWithStoryFragment.C15357;

/* compiled from: Not Implemented */
public class StoryGallerySurveyWithStoryFinishPopoverWindow extends PopoverWindow {
    public C15357 f12962a;

    /* compiled from: Not Implemented */
    public class C15361 implements OnClickListener {
        final /* synthetic */ StoryGallerySurveyWithStoryFinishPopoverWindow f12961a;

        public C15361(StoryGallerySurveyWithStoryFinishPopoverWindow storyGallerySurveyWithStoryFinishPopoverWindow) {
            this.f12961a = storyGallerySurveyWithStoryFinishPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -307725568);
            this.f12961a.f12962a.m13636a();
            Logger.a(2, EntryType.UI_INPUT_END, -1958527541, a);
        }
    }

    public StoryGallerySurveyWithStoryFinishPopoverWindow(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130907249, null, false);
        d(inflate);
        inflate.findViewById(2131567688).setOnClickListener(new C15361(this));
    }
}

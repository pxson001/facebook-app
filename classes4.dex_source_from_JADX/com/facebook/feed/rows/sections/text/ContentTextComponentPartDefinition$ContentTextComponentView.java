package com.facebook.feed.rows.sections.text;

import android.content.Context;
import android.view.MotionEvent;
import com.facebook.components.feed.FeedComponentView;
import com.facebook.feed.rows.views.CopyStoryTextListener;
import com.facebook.feed.rows.views.CopyStoryTextListenerController;
import com.facebook.feed.rows.views.SupportsCopyStoryText;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: edit_privacy_save_failed */
public class ContentTextComponentPartDefinition$ContentTextComponentView extends FeedComponentView implements SupportsCopyStoryText {
    private CopyStoryTextListenerController f13361a;

    public ContentTextComponentPartDefinition$ContentTextComponentView(Context context) {
        super(context);
        this.f13361a = new CopyStoryTextListenerController(context);
    }

    public void setCopyTextGestureListener(CopyStoryTextListener copyStoryTextListener) {
        this.f13361a.setCopyTextGestureListener(copyStoryTextListener);
    }

    public final void iD_() {
        this.f13361a.iD_();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1896721765);
        boolean z = this.f13361a.a(motionEvent) && super.onTouchEvent(motionEvent);
        LogUtils.a(-1142389967, a);
        return z;
    }
}

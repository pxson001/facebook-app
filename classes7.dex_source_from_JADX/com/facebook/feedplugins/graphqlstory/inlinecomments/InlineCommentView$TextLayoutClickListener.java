package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: Selected overlay not in list */
public class InlineCommentView$TextLayoutClickListener implements OnClickListener {
    final /* synthetic */ InlineCommentView f23355a;
    private final Handler f23356b = new Handler();

    /* compiled from: Selected overlay not in list */
    class C20201 implements Runnable {
        final /* synthetic */ InlineCommentView$TextLayoutClickListener f23354a;

        C20201(InlineCommentView$TextLayoutClickListener inlineCommentView$TextLayoutClickListener) {
            this.f23354a = inlineCommentView$TextLayoutClickListener;
        }

        public void run() {
            this.f23354a.f23355a.dispatchTouchEvent(MotionEvent.obtain(1, 1, 0, 1.0f, 1.0f, 0));
            this.f23354a.f23355a.dispatchTouchEvent(MotionEvent.obtain(1, 1, 1, 1.0f, 1.0f, 0));
        }
    }

    public InlineCommentView$TextLayoutClickListener(InlineCommentView inlineCommentView) {
        this.f23355a = inlineCommentView;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1275788082);
        HandlerDetour.a(this.f23356b, new C20201(this), 1086643969);
        Logger.a(2, EntryType.UI_INPUT_END, 216441227, a);
    }
}

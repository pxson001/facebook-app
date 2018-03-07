package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.recents.InboxRecentItemVideoView.InboxRecentItemVideoViewEnvironment;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.plugins.VideoControlsBasePlugin;
import com.facebook.video.player.plugins.VideoControlsBasePlugin.InitialChromeBehavior;
import javax.annotation.Nullable;

/* compiled from: send success */
public class InboxRecentItemVideoControlsPlugin extends VideoControlsBasePlugin<InboxRecentItemVideoEnvironment> {
    private final GestureDetector f2880m;
    @Nullable
    public OnLongClickListener f2881n;

    /* compiled from: send success */
    class LongClickOnGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ InboxRecentItemVideoControlsPlugin f2879a;

        public LongClickOnGestureListener(InboxRecentItemVideoControlsPlugin inboxRecentItemVideoControlsPlugin) {
            this.f2879a = inboxRecentItemVideoControlsPlugin;
        }

        public void onLongPress(MotionEvent motionEvent) {
            if (this.f2879a.f2881n != null) {
                this.f2879a.performHapticFeedback(0);
                this.f2879a.f2881n.onLongClick(this.f2879a);
            }
        }
    }

    public InboxRecentItemVideoControlsPlugin(Context context, InboxRecentItemVideoViewEnvironment inboxRecentItemVideoViewEnvironment) {
        super(context);
        setEnvironment(inboxRecentItemVideoViewEnvironment);
        this.f2880m = new GestureDetector(context, new LongClickOnGestureListener(this));
    }

    protected int getContentView() {
        return 2130904884;
    }

    protected final void m2844a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            a(InitialChromeBehavior.AUTO_WITH_INITIALLY_VISIBLE);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -806685778);
        if (this.f2880m.onTouchEvent(motionEvent)) {
            Logger.a(2, EntryType.UI_INPUT_END, -1928613838, a);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        LogUtils.a(-1925658809, a);
        return onTouchEvent;
    }

    public void setOnLongClickListener(@Nullable OnLongClickListener onLongClickListener) {
        this.f2881n = onLongClickListener;
    }
}

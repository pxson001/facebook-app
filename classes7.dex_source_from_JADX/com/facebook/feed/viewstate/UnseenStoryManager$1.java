package com.facebook.feed.viewstate;

import android.os.SystemClock;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.viewstate.UnseenBackgroundDrawable.AnimationState;
import java.util.List;

/* compiled from: share_return_to_fb4a */
public class UnseenStoryManager$1 implements Runnable {
    final /* synthetic */ FeedProps f3859a;
    final /* synthetic */ UnseenStoryManager f3860b;

    public UnseenStoryManager$1(UnseenStoryManager unseenStoryManager, FeedProps feedProps) {
        this.f3860b = unseenStoryManager;
        this.f3859a = feedProps;
    }

    public void run() {
        UnseenStoryManager unseenStoryManager = this.f3860b;
        String d = UnseenStoryManager.d(this.f3859a);
        if (unseenStoryManager.a.containsKey(d)) {
            List list = (List) unseenStoryManager.a.get(d);
            for (int i = 0; i < list.size(); i++) {
                UnseenBackgroundDrawable unseenBackgroundDrawable = (UnseenBackgroundDrawable) list.get(i);
                if (!(unseenBackgroundDrawable.f3858d == AnimationState.TRANSITION_FINISHED || unseenBackgroundDrawable.f3858d == AnimationState.TRANSITION_RUNNING)) {
                    unseenBackgroundDrawable.f3855a = SystemClock.uptimeMillis();
                    unseenBackgroundDrawable.f3858d = AnimationState.TRANSITION_RUNNING;
                    unseenBackgroundDrawable.invalidateSelf();
                }
            }
            unseenStoryManager.a.remove(d);
        }
        unseenStoryManager.b.add(d);
    }
}

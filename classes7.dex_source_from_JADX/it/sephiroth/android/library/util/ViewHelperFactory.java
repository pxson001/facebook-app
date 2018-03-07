package it.sephiroth.android.library.util;

import android.util.Log;
import android.view.View;

/* compiled from: viewer_watching_video_broadcast_tool_tip_has_shown */
public class ViewHelperFactory {

    /* compiled from: viewer_watching_video_broadcast_tool_tip_has_shown */
    public abstract class ViewHelper {
        protected View f368a;

        public abstract void mo3a(int i);

        public abstract void mo4a(Runnable runnable);

        public abstract boolean mo5a();

        protected ViewHelper(View view) {
            this.f368a = view;
        }
    }

    /* compiled from: viewer_watching_video_broadcast_tool_tip_has_shown */
    public class ViewHelperDefault extends ViewHelper {
        public ViewHelperDefault(View view) {
            super(view);
        }

        public void mo4a(Runnable runnable) {
            this.f368a.post(runnable);
        }

        public void mo3a(int i) {
            Log.d("ViewHelper", "setScrollX: " + i);
            this.f368a.scrollTo(i, this.f368a.getScrollY());
        }

        public boolean mo5a() {
            return false;
        }
    }
}

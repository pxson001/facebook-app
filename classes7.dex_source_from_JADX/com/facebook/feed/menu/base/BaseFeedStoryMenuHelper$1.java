package com.facebook.feed.menu.base;

import android.app.Activity;
import com.facebook.widget.bottomsheet.BottomSheetDialog;

/* compiled from: analytics_extra_data */
class BaseFeedStoryMenuHelper$1 extends BaseActivityLifecycleCallbacks {
    final /* synthetic */ Activity f19374a;
    final /* synthetic */ BottomSheetDialog f19375b;
    final /* synthetic */ BaseFeedStoryMenuHelper f19376c;

    BaseFeedStoryMenuHelper$1(BaseFeedStoryMenuHelper baseFeedStoryMenuHelper, Activity activity, BottomSheetDialog bottomSheetDialog) {
        this.f19376c = baseFeedStoryMenuHelper;
        this.f19374a = activity;
        this.f19375b = bottomSheetDialog;
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity.equals(this.f19374a)) {
            this.f19375b.dismiss();
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }
}

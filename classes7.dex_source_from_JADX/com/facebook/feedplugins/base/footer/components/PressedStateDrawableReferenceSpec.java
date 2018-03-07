package com.facebook.feedplugins.base.footer.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.annotations.ReferenceSpec;
import com.facebook.feed.widget.DownstateType;

@ReferenceSpec
/* compiled from: SystemTrayLogService */
public class PressedStateDrawableReferenceSpec {
    public static final SynchronizedPool<Drawable> f23012a = new SynchronizedPool(8);
    public static final SynchronizedPool<Drawable> f23013b = new SynchronizedPool(8);

    /* compiled from: SystemTrayLogService */
    public class PressedStateBackgroundDrawable extends StateListDrawable {
        public PressedStateBackgroundDrawable(Context context, DownstateType downstateType) {
            addState(new int[]{16842919}, context.getResources().getDrawable(downstateType == DownstateType.NEWSFEED_SHADOW ? 2130840220 : 2130843499));
        }

        protected boolean onStateChange(int[] iArr) {
            super.onStateChange(iArr);
            return false;
        }
    }
}

package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.facecastdisplay.LiveEventsLogger;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.prefs.shared.SharedPrefKeys;
import com.facebook.video.player.RichVideoPlayerParams;
import javax.annotation.Nullable;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: The media router service must only be accessed on the application's main thread. */
public class FullScreenVideoBroadcastPlugin extends VideoBroadcastPlugin implements OnDismissListener {
    private static final PrefKey f22246u = ((PrefKey) SharedPrefKeys.h.a("viewer_watching_video_broadcast_tool_tip_has_shown"));
    @Inject
    public FbSharedPreferences f22247b;
    @Inject
    public LiveEventsLogger f22248c;
    @Nullable
    private NoArrowTooltip f22249v;
    private boolean f22250w;

    /* compiled from: The media router service must only be accessed on the application's main thread. */
    class NoArrowTooltip extends Tooltip {
        public NoArrowTooltip(Context context, int i) {
            super(context, i);
        }

        protected final void m24885a(View view, boolean z, LayoutParams layoutParams) {
            super.a(view, z, layoutParams);
            View findViewById = this.f.findViewById(2131561860);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public static void m24886a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FullScreenVideoBroadcastPlugin fullScreenVideoBroadcastPlugin = (FullScreenVideoBroadcastPlugin) obj;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        LiveEventsLogger b = LiveEventsLogger.b(fbInjector);
        fullScreenVideoBroadcastPlugin.f22247b = fbSharedPreferences;
        fullScreenVideoBroadcastPlugin.f22248c = b;
    }

    @DoNotStrip
    public FullScreenVideoBroadcastPlugin(Context context) {
        this(context, null);
    }

    private FullScreenVideoBroadcastPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Integer.valueOf(0));
    }

    private FullScreenVideoBroadcastPlugin(Context context, AttributeSet attributeSet, Integer num) {
        super(context, attributeSet, num);
        Class cls = FullScreenVideoBroadcastPlugin.class;
        m24886a((Object) this, getContext());
    }

    protected final void m24888a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        this.f22250w = this.f22247b.a(f22246u, false);
        if (this.f22250w) {
            m24887k();
            return;
        }
        this.f22249v = new NoArrowTooltip(getContext(), 2);
        this.f22249v.t = 8000;
        this.f22249v.b(2131232831);
        this.f22249v.c(this.r);
        this.f22249v.H = this;
        this.f22249v.d();
    }

    public final void m24890c() {
        if (this.f22249v != null && this.f22249v.r) {
            this.f22249v.H = null;
            this.f22249v.l();
        }
        super.c();
    }

    public final boolean m24889a(PopoverWindow popoverWindow) {
        this.f22247b.edit().putBoolean(f22246u, true).commit();
        this.f22250w = true;
        m24887k();
        return true;
    }

    private void m24887k() {
        this.f22248c.a(this.s, 0);
    }
}

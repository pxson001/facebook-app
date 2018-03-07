package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.facebook.video.player.plugins.RichVideoPlayerPluginWithEnv;
import com.google.common.base.Function;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: street2 */
public class ChannelFeedClickToFullscreenPlugin<E extends CanOpenFullscreen> extends RichVideoPlayerPluginWithEnv<E> {
    @Nullable
    public RichVideoPlayerParams f2722a;

    /* compiled from: street2 */
    class C02481 implements OnClickListener {
        final /* synthetic */ ChannelFeedClickToFullscreenPlugin f2721a;

        C02481(ChannelFeedClickToFullscreenPlugin channelFeedClickToFullscreenPlugin) {
            this.f2721a = channelFeedClickToFullscreenPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1455965315);
            Function a2 = this.f2721a.c != null ? ((CanOpenFullscreen) this.f2721a.c).a() : null;
            if (!(this.f2721a.f2722a == null || a2 == null)) {
                a2.apply(this.f2721a.f2722a);
            }
            LogUtils.a(103130968, a);
        }
    }

    @DoNotStrip
    public ChannelFeedClickToFullscreenPlugin(Context context) {
        this(context, null);
    }

    private ChannelFeedClickToFullscreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeedClickToFullscreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903534);
        a(2131560276).setOnClickListener(new C02481(this));
    }

    protected final void m2611a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f2722a = richVideoPlayerParams;
    }
}

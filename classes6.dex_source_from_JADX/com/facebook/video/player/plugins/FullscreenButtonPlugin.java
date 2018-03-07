package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.CanOpenFullscreen;
import com.google.common.base.Function;

/* compiled from: composer_attach_movie_remove */
public class FullscreenButtonPlugin<E extends CanOpenFullscreen> extends RichVideoPlayerPluginWithEnv<E> {
    public RichVideoPlayerParams f19332a;

    /* compiled from: composer_attach_movie_remove */
    class C14431 implements OnClickListener {
        final /* synthetic */ FullscreenButtonPlugin f19331a;

        C14431(FullscreenButtonPlugin fullscreenButtonPlugin) {
            this.f19331a = fullscreenButtonPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -990196690);
            Function a2 = this.f19331a.c != null ? ((CanOpenFullscreen) this.f19331a.c).m28062a() : null;
            if (a2 != null) {
                a2.apply(this.f19331a.f19332a);
            }
            LogUtils.a(-933502547, a);
        }
    }

    public FullscreenButtonPlugin(Context context) {
        this(context, null);
    }

    public FullscreenButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullscreenButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904549);
        a(2131562407).setOnClickListener(new C14431(this));
    }

    protected final void m28102a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        this.f19332a = richVideoPlayerParams;
    }
}

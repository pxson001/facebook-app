package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.event.FbEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPCastStateChangeEvent;
import com.facebook.video.player.events.RVPCastStateChangeEvent.State;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestPlayingEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: composer_button_target */
public class ClickToPlayPlugin extends RichVideoPlayerPlugin {
    public final View f19300d;

    /* compiled from: composer_button_target */
    class C14391 implements OnClickListener {
        final /* synthetic */ ClickToPlayPlugin f19310a;

        C14391(ClickToPlayPlugin clickToPlayPlugin) {
            this.f19310a = clickToPlayPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -484739661);
            if (this.f19310a.h == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 1671021050, a);
                return;
            }
            if (this.f19310a.h.i() || this.f19310a.h.k()) {
                this.f19310a.mo1482e();
            } else {
                this.f19310a.mo1481d();
            }
            LogUtils.a(460737653, a);
        }
    }

    /* compiled from: composer_button_target */
    class C14402 implements OnClickListener {
        final /* synthetic */ ClickToPlayPlugin f19311a;

        C14402(ClickToPlayPlugin clickToPlayPlugin) {
            this.f19311a = clickToPlayPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -501685489);
            this.f19311a.g.a(new RVPCastStateChangeEvent(State.CAST_TOGGLE_PLAYBACK));
            Logger.a(2, EntryType.UI_INPUT_END, 858654685, a);
        }
    }

    /* compiled from: composer_button_target */
    class CastStateChangeHandler extends RichVideoPlayerEventSubscriber<RVPCastStateChangeEvent> {
        final /* synthetic */ ClickToPlayPlugin f19312a;

        public CastStateChangeHandler(ClickToPlayPlugin clickToPlayPlugin) {
            this.f19312a = clickToPlayPlugin;
        }

        public final void m28083b(FbEvent fbEvent) {
            RVPCastStateChangeEvent rVPCastStateChangeEvent = (RVPCastStateChangeEvent) fbEvent;
            if (rVPCastStateChangeEvent.f19269a == State.CAST_INITIATED) {
                this.f19312a.mo1480a(true);
            } else if (rVPCastStateChangeEvent.f19269a == State.CAST_STOPPED) {
                this.f19312a.mo1480a(false);
            }
        }

        public final Class<RVPCastStateChangeEvent> m28082a() {
            return RVPCastStateChangeEvent.class;
        }
    }

    public ClickToPlayPlugin(Context context) {
        this(context, null);
    }

    public ClickToPlayPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClickToPlayPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(getContentView());
        this.f19300d = a(2131560325);
        this.f.add(new CastStateChangeHandler(this));
    }

    protected void mo1484a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            mo1486f();
        }
    }

    protected void mo1485c() {
        this.f19300d.setOnClickListener(null);
    }

    private void mo1486f() {
        this.f19300d.setOnClickListener(new C14391(this));
    }

    protected int getContentView() {
        return 2130903577;
    }

    protected void mo1481d() {
        this.g.a(new RVPRequestPlayingEvent(EventTriggerType.BY_USER));
    }

    protected void mo1482e() {
        this.g.a(new RVPRequestPausingEvent(EventTriggerType.BY_USER));
    }

    protected void mo1480a(boolean z) {
        if (z) {
            this.f19300d.setOnClickListener(new C14402(this));
        } else {
            mo1486f();
        }
    }
}

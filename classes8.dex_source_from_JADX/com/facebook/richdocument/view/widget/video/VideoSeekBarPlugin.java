package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.SeekBar;
import com.facebook.common.locale.Locales;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.ui.FbTextView;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.events.RVPRequestPausingEvent;
import com.facebook.video.player.events.RVPRequestSeekingEvent;
import com.facebook.video.player.events.RichVideoPlayerEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.SeekBarBasePlugin;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/* compiled from: null_state_candidate_results */
public class VideoSeekBarPlugin extends SeekBarBasePlugin {
    public FbTextView f7759l;
    public FbTextView f7760m;
    public final VideoSeekBarView f7761n;
    public SeekbarPluginHelper f7762o;
    public HamDimensions f7763p;
    public Locale f7764q;
    private int f7765r;
    private int f7766s;

    /* compiled from: null_state_candidate_results */
    public class SeekbarPluginHelper {
        public State f7758a;

        /* compiled from: null_state_candidate_results */
        class RequestPausingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestPausingEvent> {
            final /* synthetic */ SeekbarPluginHelper f7756a;

            public RequestPausingEventSubscriber(SeekbarPluginHelper seekbarPluginHelper) {
                this.f7756a = seekbarPluginHelper;
            }

            public final void m8021b(FbEvent fbEvent) {
                SeekbarPluginHelper.m8024a(this.f7756a, (RVPRequestPausingEvent) fbEvent);
            }

            public final Class<RVPRequestPausingEvent> m8020a() {
                return RVPRequestPausingEvent.class;
            }
        }

        /* compiled from: null_state_candidate_results */
        class RequestSeekingEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSeekingEvent> {
            final /* synthetic */ SeekbarPluginHelper f7757a;

            public RequestSeekingEventSubscriber(SeekbarPluginHelper seekbarPluginHelper) {
                this.f7757a = seekbarPluginHelper;
            }

            public final void m8023b(FbEvent fbEvent) {
                SeekbarPluginHelper.m8024a(this.f7757a, (RVPRequestSeekingEvent) fbEvent);
            }

            public final Class<RVPRequestSeekingEvent> m8022a() {
                return RVPRequestSeekingEvent.class;
            }
        }

        /* compiled from: null_state_candidate_results */
        public enum State {
            CONSUMING_PAUSE,
            IDLE
        }

        public SeekbarPluginHelper(List<RichVideoPlayerEventSubscriber<? extends RichVideoPlayerEvent>> list) {
            list.add(new RequestSeekingEventSubscriber(this));
            list.add(new RequestPausingEventSubscriber(this));
        }

        public static void m8024a(SeekbarPluginHelper seekbarPluginHelper, RichVideoPlayerEvent richVideoPlayerEvent) {
            if (m8025b(richVideoPlayerEvent) || m8026c(richVideoPlayerEvent)) {
                seekbarPluginHelper.f7758a = State.CONSUMING_PAUSE;
            } else {
                seekbarPluginHelper.f7758a = State.IDLE;
            }
        }

        private static boolean m8025b(RichVideoPlayerEvent richVideoPlayerEvent) {
            return (richVideoPlayerEvent instanceof RVPRequestPausingEvent) && ((RVPRequestPausingEvent) richVideoPlayerEvent).a == EventTriggerType.BY_SEEKBAR_CONTROLLER;
        }

        private static boolean m8026c(RichVideoPlayerEvent richVideoPlayerEvent) {
            return (richVideoPlayerEvent instanceof RVPRequestSeekingEvent) && ((RVPRequestSeekingEvent) richVideoPlayerEvent).a == EventTriggerType.BY_USER;
        }
    }

    public static void m8027a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        VideoSeekBarPlugin videoSeekBarPlugin = (VideoSeekBarPlugin) obj;
        HamDimensions a = HamDimensions.m5268a(injectorLike);
        Locales a2 = Locales.a(injectorLike);
        videoSeekBarPlugin.f7763p = a;
        videoSeekBarPlugin.f7764q = a2.a();
        SeekBar seekBar = (SeekBar) videoSeekBarPlugin.findViewById(2131562401);
        int b = videoSeekBarPlugin.f7763p.m5276b(2131558648);
        int b2 = videoSeekBarPlugin.f7763p.m5276b(2131558665);
        videoSeekBarPlugin.f7759l = (FbTextView) videoSeekBarPlugin.findViewById(2131562400);
        videoSeekBarPlugin.f7760m = (FbTextView) videoSeekBarPlugin.findViewById(2131562402);
        videoSeekBarPlugin.f7759l.setTextSize(0, (float) b2);
        videoSeekBarPlugin.f7760m.setTextSize(0, (float) b2);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) seekBar.getLayoutParams();
        marginLayoutParams.setMargins(b, marginLayoutParams.topMargin, b, marginLayoutParams.bottomMargin);
        if (VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMarginStart(b);
            marginLayoutParams.setMarginEnd(b);
        }
        seekBar.setLayoutParams(marginLayoutParams);
        ((ViewGroup) seekBar.getParent()).setClipChildren(false);
        ((ViewGroup) seekBar.getParent()).setClipToPadding(false);
    }

    public VideoSeekBarPlugin(Context context) {
        this(context, null);
    }

    private VideoSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7765r = -1;
        this.f7766s = -1;
        Class cls = VideoSeekBarPlugin.class;
        m8027a((Object) this, getContext());
        this.f7761n = (VideoSeekBarView) getChildAt(0);
        removeView(this.f7761n);
    }

    public int getContentView() {
        return 2130906888;
    }

    protected int getActiveThumbResource() {
        return 2130843067;
    }

    public final void m8030a(ViewGroup viewGroup) {
    }

    public void setEventBus(RichVideoPlayerEventBus richVideoPlayerEventBus) {
        this.f7762o = new SeekbarPluginHelper(this.f);
        super.setEventBus(richVideoPlayerEventBus);
    }

    protected final void m8029a(int i, int i2) {
        int i3 = i / 1000;
        int i4 = (i2 / 1000) - i3;
        if (i3 != this.f7765r || i4 != this.f7766s) {
            this.f7765r = i3;
            this.f7766s = i4;
            CharSequence d = m8028d(i3 * 1000);
            CharSequence d2 = m8028d(i4 * 1000);
            this.f7759l.setText(d);
            this.f7760m.setText(d2);
        }
    }

    private String m8028d(int i) {
        Appendable stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder, this.f7764q);
        stringBuilder.setLength(0);
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        if (i2 / 3600 > 0) {
            return formatter.format("%d:%2d:%02d", new Object[]{Integer.valueOf(i2 / 3600), Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
        }
        String str;
        if (i4 > 9) {
            str = "%2d:%02d";
        } else {
            str = "%d:%02d";
        }
        return formatter.format(str, new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
    }
}

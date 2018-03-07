package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.touch.TouchSlopDetector;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.VideoAnimationHelper;
import com.facebook.video.player.VideoAnimationHelper.2;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPChromeVisibilityChangedEvent;
import com.facebook.video.player.events.RVPLoadingSpinnerStateEvent;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: play_sample */
public abstract class VideoControlsBasePlugin<E extends AnyPlayerEnvironment> extends AggregatePlugin<E> {
    protected boolean f4490d;
    @Inject
    public VideoAnimationHelper f4491l;
    private final TouchSlopDetector f4492m;
    private final GestureDetector f4493n;
    public final AutohideHandler f4494o;
    public boolean f4495p;
    public ChromeBehavior f4496q;
    public int f4497r;

    public static void m4998a(Object obj, Context context) {
        ((VideoControlsBasePlugin) obj).f4491l = VideoAnimationHelper.m14973a(FbInjector.get(context));
    }

    protected abstract int getContentView();

    public VideoControlsBasePlugin(Context context) {
        this(context, null);
    }

    private VideoControlsBasePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoControlsBasePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4492m = new TouchSlopDetector();
        this.f4494o = new AutohideHandler(this);
        this.f4495p = false;
        this.f4496q = ChromeBehavior.AUTO;
        this.f4497r = 3000;
        Class cls = VideoControlsBasePlugin.class;
        m4998a((Object) this, getContext());
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new ChromeStateEventSubscriber(this));
        setContentView(getContentView());
        this.f4492m.f4686a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f4493n = new GestureDetector(context, new OnFlingListener(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.f4490d) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f4490d) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1342119);
        switch (motionEvent.getAction() & 255) {
            case 1:
                if (!this.f4492m.m5172a() && this.f4496q == ChromeBehavior.AUTO) {
                    m5004d();
                    break;
                }
        }
        this.f4492m.m5173a(motionEvent);
        this.f4493n.onTouchEvent(motionEvent);
        LogUtils.a(854032556, a);
        return true;
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            m5001a(InitialChromeBehavior.AUTO_WITH_INITIALLY_HIDDEN);
        }
    }

    protected final void m5001a(InitialChromeBehavior initialChromeBehavior) {
        this.f4495p = false;
        this.f4490d = initialChromeBehavior.isInitiallyVisible();
        if (this.f4490d) {
            mo390d(0);
        } else {
            mo389c(0);
        }
        this.f4496q = initialChromeBehavior.getBehavior();
    }

    protected void mo378c() {
        this.f4494o.removeMessages(1);
    }

    public final void m5004d() {
        Preconditions.checkState(this.f4496q == ChromeBehavior.AUTO);
        if (this.f14096h != null && this.f14096h.f5115l != State.PLAYBACK_COMPLETE) {
            if (this.f4490d) {
                mo389c(500);
            } else if (this.f14096h.m5480i()) {
                Preconditions.checkState(this.f4496q == ChromeBehavior.AUTO);
                mo390d(500);
                m5006e();
            } else {
                m4999l(this);
            }
        }
    }

    protected void mo389c(int i) {
        this.f4490d = false;
        this.f4491l.m14974a(this, i, 0);
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.DEFAULT));
            this.f14095g.m14878a(new RVPChromeVisibilityChangedEvent(this.f4490d));
        }
    }

    public void mo390d(int i) {
        this.f4490d = true;
        VideoAnimationHelper videoAnimationHelper = this.f4491l;
        animate().alpha(1.0f).setDuration((long) i).setInterpolator(videoAnimationHelper.f14162a).setListener(new 2(videoAnimationHelper, this)).start();
        if (this.f14095g != null) {
            this.f14095g.m14878a(new RVPLoadingSpinnerStateEvent(RVPLoadingSpinnerStateEvent.State.HIDE));
            this.f14095g.m14878a(new RVPChromeVisibilityChangedEvent(this.f4490d));
        }
    }

    public static void m4999l(VideoControlsBasePlugin videoControlsBasePlugin) {
        Preconditions.checkState(videoControlsBasePlugin.f4496q == ChromeBehavior.AUTO);
        videoControlsBasePlugin.mo390d(500);
        videoControlsBasePlugin.f4494o.removeMessages(1);
    }

    public final void m5006e() {
        Preconditions.checkState(this.f4496q == ChromeBehavior.AUTO);
        this.f4494o.removeMessages(1);
        this.f4494o.sendEmptyMessageDelayed(1, (long) this.f4497r);
    }

    public final void m5007f() {
        this.f4494o.removeMessages(1);
    }
}

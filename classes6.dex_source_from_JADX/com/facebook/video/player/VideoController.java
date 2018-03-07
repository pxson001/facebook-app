package com.facebook.video.player;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.animations.BaseAnimatorListener;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.engine.PlayPosition;
import com.facebook.video.player.FullScreenVideoPlayer.AnonymousClass21;
import com.facebook.video.subtitles.controller.SubtitleAdapter;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.CustomViewUtils;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: composer_friend_tag_ready */
public class VideoController extends CustomRelativeLayout {
    protected FbTextView f19234a;
    private final LinearLayout f19235b;
    private final LinearLayout f19236c;
    private final ImageView f19237d;
    private final ImageButton f19238e;
    private final ImageButton f19239f;
    private final ImageView f19240g;
    private final SeekBar f19241h;
    public final TextView f19242i;
    public final TextView f19243j;
    public final Handler f19244k;
    public final AutohideHandler f19245l;
    public AnonymousClass21 f19246m;
    public VideoControllable f19247n;
    public boolean f19248o;
    public WeakReference<SubtitleAdapter> f19249p;
    public int f19250q;
    private EventTriggerType f19251r;
    private boolean f19252s;
    public boolean f19253t;
    public FullScreenChromeInteractionListener f19254u;
    public boolean f19255v;
    private final OnSeekBarChangeListener f19256w;

    /* compiled from: composer_friend_tag_ready */
    class C14281 implements OnClickListener {
        final /* synthetic */ VideoController f19221a;

        C14281(VideoController videoController) {
            this.f19221a = videoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 728536748);
            this.f19221a.f19246m.m27725a();
            Logger.a(2, EntryType.UI_INPUT_END, -1206514714, a);
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14292 implements OnClickListener {
        final /* synthetic */ VideoController f19222a;

        C14292(VideoController videoController) {
            this.f19222a = videoController;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -567915649, Logger.a(2, EntryType.UI_INPUT_START, -1657867236));
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14303 implements OnClickListener {
        final /* synthetic */ VideoController f19223a;

        C14303(VideoController videoController) {
            this.f19223a = videoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1765213318);
            this.f19223a.m28038a(EventTriggerType.BY_USER);
            Logger.a(2, EntryType.UI_INPUT_END, 1955617993, a);
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14314 implements OnClickListener {
        final /* synthetic */ VideoController f19224a;

        C14314(VideoController videoController) {
            this.f19224a = videoController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1038417663);
            this.f19224a.m28042b(EventTriggerType.BY_USER);
            Logger.a(2, EntryType.UI_INPUT_END, -1387580248, a);
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14325 implements OnClickListener {
        final /* synthetic */ VideoController f19225a;

        C14325(VideoController videoController) {
            this.f19225a = videoController;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, 681200294, Logger.a(2, EntryType.UI_INPUT_START, -1737997189));
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14336 implements FullScreenChromeInteractionListener {
        boolean f19226a = false;
        final /* synthetic */ VideoController f19227b;

        C14336(VideoController videoController) {
            this.f19227b = videoController;
        }

        public final void mo1449a() {
            this.f19227b.f19245l.removeMessages(1);
            this.f19227b.m28045d();
            this.f19226a = true;
        }

        public final void mo1450a(boolean z) {
            this.f19227b.f19245l.removeMessages(1);
            if (!this.f19226a || (this.f19226a && z)) {
                this.f19227b.f19245l.sendEmptyMessageDelayed(1, 3000);
                this.f19226a = false;
            }
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14347 extends BaseAnimatorListener {
        final /* synthetic */ VideoController f19228a;

        C14347(VideoController videoController) {
            this.f19228a = videoController;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19228a.setVisibility(8);
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14358 extends BaseAnimatorListener {
        final /* synthetic */ VideoController f19229a;

        C14358(VideoController videoController) {
            this.f19229a = videoController;
        }

        public void onAnimationEnd(Animator animator) {
            this.f19229a.setAlpha(1.0f);
            this.f19229a.bringToFront();
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class C14369 implements OnSeekBarChangeListener {
        final /* synthetic */ VideoController f19230a;
        private boolean f19231b;

        C14369(VideoController videoController) {
            this.f19230a = videoController;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            boolean z = true;
            if (this.f19230a.f19254u != null) {
                this.f19230a.f19254u.mo1449a();
            }
            this.f19230a.f19248o = true;
            this.f19230a.f19244k.removeMessages(2);
            if (this.f19230a.m28041a()) {
                this.f19230a.f19250q = this.f19230a.f19247n.getVideoViewCurrentPosition();
            }
            if (!(this.f19230a.m28041a() && this.f19230a.f19247n.mo1425a())) {
                z = false;
            }
            this.f19231b = z;
            if (this.f19231b) {
                this.f19230a.m28042b(EventTriggerType.BY_SEEKBAR_CONTROLLER);
            }
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                int i2 = 0;
                if (this.f19230a.m28041a()) {
                    i2 = this.f19230a.f19247n.getVideoViewDurationInMillis();
                }
                if (i2 > 0 || !this.f19230a.f19253t) {
                    long j = (long) i2;
                    long j2 = (((long) i) * j) / 1000;
                    if (this.f19230a.m28041a()) {
                        this.f19230a.f19247n.i_((int) j2);
                    }
                    this.f19230a.f19242i.setText(Utils.m28005a((long) ((int) j2)));
                    this.f19230a.f19243j.setText("-" + Utils.m28005a((long) ((int) (j - j2))));
                    if (this.f19230a.m28043b()) {
                        ((CustomSubtitleAdapter) this.f19230a.f19249p.get()).d();
                    }
                }
            }
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            if (this.f19230a.f19254u != null) {
                this.f19230a.f19254u.mo1450a(false);
            }
            this.f19230a.f19248o = false;
            VideoController.m28036o(this.f19230a);
            this.f19230a.f19250q;
            if (this.f19230a.m28043b() && this.f19230a.m28041a()) {
                CustomSubtitleAdapter customSubtitleAdapter = (CustomSubtitleAdapter) this.f19230a.f19249p.get();
                customSubtitleAdapter.d();
                customSubtitleAdapter.a(this.f19230a.f19247n.getVideoViewCurrentPosition());
                customSubtitleAdapter.b();
            }
            if (this.f19230a.f19246m != null) {
                this.f19230a.f19246m.m27726a(this.f19230a.f19250q);
            }
            if (this.f19231b) {
                this.f19230a.m28038a(EventTriggerType.BY_SEEKBAR_CONTROLLER);
            } else {
                this.f19230a.f19244k.sendEmptyMessage(2);
            }
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class AutohideHandler extends Handler {
        private final WeakReference<VideoController> f19232a;

        public AutohideHandler(VideoController videoController) {
            this.f19232a = new WeakReference(videoController);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    VideoController videoController = (VideoController) this.f19232a.get();
                    if (videoController != null) {
                        videoController.m28044c();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: composer_friend_tag_ready */
    class ProgressHandler extends Handler {
        private final WeakReference<VideoController> f19233a;

        public ProgressHandler(VideoController videoController) {
            this.f19233a = new WeakReference(videoController);
        }

        public void handleMessage(Message message) {
            VideoController videoController = (VideoController) this.f19233a.get();
            if (videoController != null) {
                switch (message.what) {
                    case 2:
                        VideoController.m28036o(videoController);
                        if (!videoController.f19248o && videoController.m28041a() && videoController.f19255v) {
                            sendMessageDelayed(obtainMessage(2), 42);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public VideoController(Context context) {
        this(context, null, 0);
    }

    public VideoController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f19248o = false;
        this.f19252s = false;
        this.f19253t = false;
        this.f19256w = new C14369(this);
        setContentView(2130904545);
        this.f19235b = (LinearLayout) a(2131562406);
        m28030k();
        this.f19236c = (LinearLayout) a(2131562408);
        m28031l();
        this.f19237d = (ImageView) a(2131562407);
        this.f19238e = (ImageButton) a(2131562409);
        this.f19239f = (ImageButton) a(2131562410);
        this.f19240g = (ImageView) a(2131561907);
        this.f19241h = (SeekBar) a(2131562401);
        this.f19242i = (TextView) a(2131562400);
        this.f19243j = (TextView) a(2131562411);
        this.f19234a = (FbTextView) a(2131562412);
        this.f19234a.setOnClickListener(new C14281(this));
        this.f19237d.setOnClickListener(new C14292(this));
        this.f19238e.setOnClickListener(new C14303(this));
        this.f19239f.setOnClickListener(new C14314(this));
        this.f19240g.setOnClickListener(new C14325(this));
        this.f19241h.setOnSeekBarChangeListener(this.f19256w);
        this.f19241h.setMax(1000);
        this.f19244k = new ProgressHandler(this);
        this.f19245l = new AutohideHandler(this);
        this.f19254u = new C14336(this);
    }

    private void m28030k() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(2130842795);
        bitmapDrawable.mutate();
        bitmapDrawable.setTileModeX(TileMode.REPEAT);
        bitmapDrawable.setGravity(48);
        CustomViewUtils.b(this.f19235b, bitmapDrawable);
    }

    private void m28031l() {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(2130842794);
        bitmapDrawable.mutate();
        bitmapDrawable.setTileModeX(TileMode.REPEAT);
        bitmapDrawable.setGravity(80);
        CustomViewUtils.b(this.f19236c, bitmapDrawable);
        this.f19252s = true;
    }

    public void setSubtitleAdapter(@Nullable CustomSubtitleAdapter customSubtitleAdapter) {
        this.f19249p = new WeakReference(customSubtitleAdapter);
    }

    public final void m28038a(EventTriggerType eventTriggerType) {
        m28039a(eventTriggerType, PlayPosition.a);
    }

    public final void m28039a(EventTriggerType eventTriggerType, PlayPosition playPosition) {
        this.f19255v = true;
        if (this.f19246m != null) {
            this.f19246m.m27727a(eventTriggerType);
        }
        m28050i();
        if (m28041a()) {
            this.f19247n.mo1432a(playPosition);
        } else {
            this.f19251r = eventTriggerType;
        }
        if (m28043b()) {
            ((CustomSubtitleAdapter) this.f19249p.get()).b();
        }
        if (this.f19246m != null) {
            this.f19246m.m27728b(eventTriggerType);
        }
        this.f19244k.sendEmptyMessage(2);
    }

    public final void m28042b(EventTriggerType eventTriggerType) {
        this.f19255v = false;
        m28035n();
        if (m28041a()) {
            this.f19247n.mo1426b();
        }
        if (m28043b()) {
            ((CustomSubtitleAdapter) this.f19249p.get()).c();
        }
        this.f19244k.sendEmptyMessage(2);
        if (this.f19254u != null) {
            this.f19254u.mo1449a();
        }
        if (this.f19246m != null) {
            this.f19246m.m27729c(eventTriggerType);
        }
    }

    public void setPlaying(boolean z) {
        this.f19255v = z;
        this.f19250q;
    }

    final boolean m28041a() {
        return this.f19247n != null;
    }

    final boolean m28043b() {
        return (this.f19249p == null || this.f19249p.get() == null) ? false : true;
    }

    public void setChromeInteractionListener(FullScreenChromeInteractionListener fullScreenChromeInteractionListener) {
        this.f19254u = fullScreenChromeInteractionListener;
    }

    public final void m28044c() {
        animate().alpha(0.0f).setDuration(250).setListener(new C14347(this));
    }

    public final void m28045d() {
        setVisibility(0);
        animate().alpha(1.0f).setDuration(250).setListener(new C14358(this));
    }

    public final void m28046e() {
        if (getVisibility() != 0) {
            m28045d();
        }
        if (this.f19254u != null) {
            this.f19254u.mo1450a(true);
        }
    }

    public final void m28047f() {
        this.f19235b.setVisibility(0);
    }

    public final void m28048g() {
        this.f19235b.setVisibility(8);
    }

    public void setCurrentTimeMs(int i) {
        this.f19242i.setText(Utils.m28005a((long) i));
    }

    public final boolean m28049h() {
        return this.f19236c.getVisibility() == 0;
    }

    public static void m28034m(VideoController videoController) {
        if (!videoController.m28041a()) {
            return;
        }
        if (videoController.f19247n.mo1425a()) {
            videoController.m28050i();
        } else {
            videoController.m28035n();
        }
    }

    private void m28035n() {
        this.f19239f.setVisibility(8);
        this.f19238e.setVisibility(0);
    }

    public final void m28050i() {
        this.f19238e.setVisibility(8);
        this.f19239f.setVisibility(0);
    }

    public final void m28040a(boolean z) {
        if (z) {
            this.f19234a.setTextColor(getResources().getColor(2131361867));
        } else {
            this.f19234a.setTextColor(getResources().getColor(2131361858));
        }
    }

    public void setVideoController(VideoControllable videoControllable) {
        this.f19247n = videoControllable;
        if (this.f19251r != null && videoControllable != null) {
            m28038a(this.f19251r);
            this.f19251r = null;
        }
    }

    public void setSkipSeekIfNoDuration(boolean z) {
        this.f19253t = z;
    }

    public final void m28037a(int i, int i2) {
        this.f19247n.mo1430a(i, i2);
    }

    public final boolean m28051j() {
        return this.f19248o;
    }

    public static int m28036o(VideoController videoController) {
        if (!videoController.m28041a() || videoController.f19248o) {
            return 0;
        }
        int videoViewCurrentPosition = videoController.f19247n.getVideoViewCurrentPosition();
        if (videoViewCurrentPosition > 0) {
            videoViewCurrentPosition -= videoController.f19247n.getTrimStartPositionMs();
        }
        int videoViewDurationInMillis = videoController.f19247n.getVideoViewDurationInMillis();
        if (videoViewDurationInMillis < videoViewCurrentPosition) {
            return videoViewCurrentPosition;
        }
        if (videoController.f19241h != null) {
            if (videoViewDurationInMillis > 0) {
                videoController.f19241h.setProgress((int) ((1000 * ((long) videoViewCurrentPosition)) / ((long) videoViewDurationInMillis)));
            }
            videoController.f19241h.setSecondaryProgress(videoController.f19247n.getBufferPercentage() * 10);
        }
        if (videoController.f19243j != null) {
            videoController.f19243j.setText("-" + Utils.m28005a((long) (videoViewDurationInMillis - videoViewCurrentPosition)));
        }
        if (videoController.f19242i == null) {
            return videoViewCurrentPosition;
        }
        videoController.f19242i.setText(Utils.m28005a((long) videoViewCurrentPosition));
        return videoViewCurrentPosition;
    }
}

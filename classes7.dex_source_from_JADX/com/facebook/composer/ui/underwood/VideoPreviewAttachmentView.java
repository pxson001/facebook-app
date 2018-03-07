package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.composer.ui.underwood.UnderwoodAttachmentUtils.MeasureSpecs;
import com.facebook.content.event.FbEvent;
import com.facebook.ipc.videoeditgallery.VideoEditFeature;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.creativeediting.VideoEditGalleryFragmentManager;
import com.facebook.video.creativeediting.analytics.ComposerEntryPoint;
import com.facebook.video.creativeediting.analytics.VideoEditingGalleryEntryPoint;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.events.RVPMeasureEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.TrimmedVideoLoopingPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: comment_photo */
public class VideoPreviewAttachmentView extends CustomFrameLayout {
    public RVPMeasureSubscriber f17335a;
    public RichVideoPlayer f17336b;
    public ViewStub f17337c;
    public View f17338d;
    public View f17339e;
    public View f17340f;
    public VideoPreviewAttachmentViewController f17341g;
    public float f17342h;
    public float f17343i;
    public boolean f17344j;
    public int f17345k;

    /* compiled from: comment_photo */
    public class C14201 implements OnClickListener {
        final /* synthetic */ VideoPreviewAttachmentView f17331a;

        public C14201(VideoPreviewAttachmentView videoPreviewAttachmentView) {
            this.f17331a = videoPreviewAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1314954181);
            VideoPreviewAttachmentView videoPreviewAttachmentView;
            if (this.f17331a.f17336b.m()) {
                videoPreviewAttachmentView = this.f17331a;
                videoPreviewAttachmentView.f17336b.b(EventTriggerType.BY_USER);
                videoPreviewAttachmentView.f17344j = true;
                videoPreviewAttachmentView.f17340f.setVisibility(0);
            } else {
                videoPreviewAttachmentView = this.f17331a;
                videoPreviewAttachmentView.f17336b.a(EventTriggerType.BY_USER);
                videoPreviewAttachmentView.f17344j = false;
                videoPreviewAttachmentView.f17340f.setVisibility(8);
            }
            if (this.f17331a.f17341g != null) {
                this.f17331a.f17341g.m21260m();
            }
            LogUtils.a(-1905842413, a);
        }
    }

    /* compiled from: comment_photo */
    public class C14212 implements OnClickListener {
        final /* synthetic */ VideoPreviewAttachmentView f17332a;

        public C14212(VideoPreviewAttachmentView videoPreviewAttachmentView) {
            this.f17332a = videoPreviewAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1942106299);
            if (this.f17332a.f17341g != null) {
                this.f17332a.f17341g.m21259l();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1823060598, a);
        }
    }

    /* compiled from: comment_photo */
    public class C14223 implements OnClickListener {
        final /* synthetic */ VideoPreviewAttachmentView f17333a;

        public C14223(VideoPreviewAttachmentView videoPreviewAttachmentView) {
            this.f17333a = videoPreviewAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 297522429);
            if (this.f17333a.f17341g != null) {
                Builder a2;
                VideoPreviewAttachmentViewController videoPreviewAttachmentViewController = this.f17333a.f17341g;
                VideoCreativeEditingData f = videoPreviewAttachmentViewController.f17369r.f();
                if (f == null) {
                    f = new VideoCreativeEditingData.Builder().a();
                }
                if (videoPreviewAttachmentViewController.f17371t == null) {
                    a2 = new Builder().m8067a(VideoEditFeature.TRIM);
                    a2.f6190b = videoPreviewAttachmentViewController.f17361j;
                    a2 = a2;
                    a2.f6192d = true;
                    a2 = a2;
                    a2.f6193e = true;
                    a2 = a2;
                    a2.f6200l = videoPreviewAttachmentViewController.f17370s.getCurrentPositionMs();
                    videoPreviewAttachmentViewController.f17371t = a2.m8068a();
                } else {
                    a2 = new Builder(videoPreviewAttachmentViewController.f17371t);
                    a2.f6200l = videoPreviewAttachmentViewController.f17370s.getCurrentPositionMs();
                    videoPreviewAttachmentViewController.f17371t = a2.m8068a();
                }
                a2 = new Builder(videoPreviewAttachmentViewController.f17371t);
                a2.f6191c = f;
                VideoEditGalleryLaunchConfiguration a3 = a2.m8068a();
                videoPreviewAttachmentViewController.f17359h.m19549a(videoPreviewAttachmentViewController.f17369r.c().toString(), ComposerEntryPoint.TAP_PLAYER, videoPreviewAttachmentViewController.f17361j);
                if (videoPreviewAttachmentViewController.f17372u == null) {
                    videoPreviewAttachmentViewController.f17372u = new VideoEditGalleryFragmentManager(videoPreviewAttachmentViewController.f17360i);
                }
                videoPreviewAttachmentViewController.f17372u.m19478a(a3, videoPreviewAttachmentViewController.f17369r.c(), videoPreviewAttachmentViewController.f17352a, VideoEditingGalleryEntryPoint.COMPOSER, AnimationParam.m12362a(videoPreviewAttachmentViewController.f17370s));
                videoPreviewAttachmentViewController.f17370s.m21234a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -493919843, a);
        }
    }

    /* compiled from: comment_photo */
    public class RVPMeasureSubscriber extends RichVideoPlayerEventSubscriber<RVPMeasureEvent> {
        final /* synthetic */ VideoPreviewAttachmentView f17334a;

        public RVPMeasureSubscriber(VideoPreviewAttachmentView videoPreviewAttachmentView) {
            this.f17334a = videoPreviewAttachmentView;
        }

        public final void m21233b(FbEvent fbEvent) {
            if (this.f17334a.f17336b.getWidth() != 0 && this.f17334a.f17336b.getHeight() != 0) {
                this.f17334a.m21236h();
                this.f17334a.f17336b.b(this.f17334a.f17335a);
            }
        }

        public final Class<RVPMeasureEvent> m21232a() {
            return RVPMeasureEvent.class;
        }
    }

    public VideoPreviewAttachmentView(Context context) {
        this(context, null);
    }

    private VideoPreviewAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoPreviewAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907639);
        this.f17336b = (RichVideoPlayer) c(2131560290);
        this.f17336b.setOnClickListener(new C14201(this));
        this.f17336b.a(new VideoPlugin(getContext()));
        this.f17336b.a(new CoverImagePlugin(getContext()));
        this.f17336b.a(new TrimmedVideoLoopingPlugin(getContext()));
        this.f17337c = (ViewStub) c(2131568250);
        this.f17339e = findViewById(2131560526);
        this.f17339e.setOnClickListener(new C14212(this));
        this.f17340f = c(2131563867);
        this.f17343i = 1.0f;
        this.f17335a = new RVPMeasureSubscriber(this);
    }

    public final void m21234a() {
        this.f17336b.g();
        this.f17344j = false;
        this.f17336b.setRotation(0.0f);
    }

    public final void m21235g() {
        if (!this.f17344j && this.f17336b.u != null && !this.f17336b.u.l.isPlayingState()) {
            this.f17340f.setVisibility(0);
        }
    }

    public final void m21236h() {
        if (!this.f17344j) {
            if (this.f17336b.isShown() && !this.f17336b.m()) {
                this.f17336b.a(EventTriggerType.BY_PLAYER);
            }
            this.f17340f.setVisibility(8);
        }
    }

    public int getCurrentPositionMs() {
        return this.f17336b.getCurrentPositionMs();
    }

    protected void onMeasure(int i, int i2) {
        MeasureSpecs a = UnderwoodAttachmentUtils.m21132a(this.f17345k % 180 == 0 ? this.f17342h : 1.0f / this.f17342h, (LayoutParams) getLayoutParams(), new MeasureSpecs(i, i2));
        setMeasuredDimension(a.f17170a, a.f17171b);
        if (this.f17345k % 180 == 0) {
            measureChildren(a.f17170a, a.f17171b);
        } else {
            measureChildren(a.f17171b, a.f17170a);
        }
    }
}

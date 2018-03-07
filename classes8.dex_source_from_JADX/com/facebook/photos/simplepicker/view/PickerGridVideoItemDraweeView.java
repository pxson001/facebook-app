package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.MediaItem;
import com.facebook.photos.base.media.VideoItem;
import com.facebook.photos.simplepicker.abtest.SimplePickerExperimentsUtil;
import com.facebook.photos.simplepicker.controller.PickerGridItemType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.RichVideoPlayerParams.Builder;
import com.facebook.video.player.events.RVPMeasureEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.VideoPlugin;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: session-id */
public class PickerGridVideoItemDraweeView extends PickerGridPhotoItemDraweeView implements PickerPlayableView {
    private static final String f3293d = PickerGridVideoItemDraweeView.class.getName();
    @Inject
    public QeAccessor f3294a;
    @Inject
    public Lazy<FbErrorReporter> f3295c;
    private ImageView f3296e;
    private TextView f3297f;
    public RichVideoPlayer f3298g;
    public RVPMeasureSubscriber f3299h;
    private int f3300i;

    /* compiled from: session-id */
    public class RVPMeasureSubscriber extends RichVideoPlayerEventSubscriber<RVPMeasureEvent> {
        final /* synthetic */ PickerGridVideoItemDraweeView f3292a;

        public RVPMeasureSubscriber(PickerGridVideoItemDraweeView pickerGridVideoItemDraweeView) {
            this.f3292a = pickerGridVideoItemDraweeView;
        }

        public final void m3238b(FbEvent fbEvent) {
            State playerState = this.f3292a.f3298g.getPlayerState();
            if (this.f3292a.f3298g.getWidth() != 0 && this.f3292a.f3298g.getHeight() != 0) {
                if (playerState == State.ATTEMPT_TO_PLAY || playerState == State.PLAYING) {
                    this.f3292a.f3298g.setVisibility(0);
                }
            }
        }

        public final Class<RVPMeasureEvent> m3237a() {
            return RVPMeasureEvent.class;
        }
    }

    public static void m3241a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PickerGridVideoItemDraweeView pickerGridVideoItemDraweeView = (PickerGridVideoItemDraweeView) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        pickerGridVideoItemDraweeView.f3294a = qeAccessor;
        pickerGridVideoItemDraweeView.f3295c = b;
    }

    public PickerGridVideoItemDraweeView(Context context) {
        this(context, null);
    }

    private PickerGridVideoItemDraweeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PickerGridVideoItemDraweeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, (byte) 0);
        this.f3300i = Integer.MIN_VALUE;
        Class cls = PickerGridVideoItemDraweeView.class;
        m3241a(this, getContext());
        this.f3299h = new RVPMeasureSubscriber(this);
    }

    public int getLayoutResourceId() {
        return 2130906234;
    }

    protected final void mo165b() {
        m3242k();
        super.mo165b();
    }

    protected final void mo162a() {
        MediaItem mediaItem = getMediaItem();
        if (mediaItem == null || (mediaItem instanceof VideoItem)) {
            if (this.f3298g != null) {
                hN_();
                this.f3298g.g();
            }
            m3242k();
            super.mo162a();
            return;
        }
        ((AbstractFbErrorReporter) this.f3295c.get()).a(f3293d, StringFormatUtil.a("Cannot render a %s view as a PickerGridVideoItemDraweeView", new Object[]{mediaItem.getClass().getName()}));
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.VIDEO;
    }

    private void m3242k() {
        if (this.f3296e == null) {
            this.f3296e = (ImageView) ((ViewStub) c(2131560554)).inflate();
        }
        if (this.f3297f == null) {
            this.f3297f = (TextView) ((ViewStub) c(2131565958)).inflate();
        }
        this.f3296e.setVisibility(0);
        long r = this.f3237b == null ? -1 : ((VideoItem) this.f3237b).r();
        if (r != -1) {
            TextView textView = this.f3297f;
            long j = r / 1000;
            long j2 = j / 60;
            j %= 60;
            StringBuilder stringBuilder = new StringBuilder();
            if (j2 <= 9) {
                stringBuilder.append('0');
            }
            stringBuilder.append(j2).append(':');
            if (j <= 9) {
                stringBuilder.append('0');
            }
            stringBuilder.append(j);
            textView.setText(stringBuilder.toString());
            this.f3297f.setVisibility(0);
            return;
        }
        this.f3297f.setVisibility(4);
    }

    public final void hN_() {
        if (this.f3298g != null) {
            if (this.f3296e != null) {
                this.f3296e.setVisibility(0);
            }
            if (this.f3297f != null) {
                this.f3297f.setVisibility(0);
            }
            this.f3298g.b(EventTriggerType.BY_PLAYER);
            this.f3298g.b(this.f3299h);
            this.f3298g.invalidate();
            this.f3298g.requestLayout();
        }
    }

    public final void mo175h() {
        if (this.f3298g == null && SimplePickerExperimentsUtil.m2989a(this.f3294a)) {
            this.f3298g = (RichVideoPlayer) ((ViewStub) c(2131562414)).inflate();
            this.f3298g.a(new VideoPlugin(getContext()));
            this.f3298g.setShouldCropToFit(true);
            this.f3298g.setPlayerOrigin(PlayerOrigin.SIMPLE_PICKER);
            this.f3298g.setVisibility(4);
        }
        if (!(this.f3237b == null || this.f3237b.f() == null || this.f3298g == null)) {
            VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
            newBuilder.a = this.f3237b.f();
            newBuilder = newBuilder;
            newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
            VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
            a.g = true;
            a = a;
            Builder builder = new Builder();
            builder.a = a.m();
            RichVideoPlayerParams b = builder.b();
            this.f3298g.a(this.f3299h);
            this.f3298g.a(b);
        }
        if (this.f3298g != null) {
            if (this.f3296e != null) {
                this.f3296e.setVisibility(4);
            }
            if (this.f3297f != null) {
                this.f3297f.setVisibility(4);
            }
            this.f3298g.a(EventTriggerType.BY_PLAYER);
        }
    }

    public int getPlayPriority() {
        if (this.f3300i != Integer.MIN_VALUE) {
            return this.f3300i;
        }
        if (isSelected()) {
            return getSelectedOrder();
        }
        return getIndex() * -1;
    }

    public final void mo173a(int i) {
        this.f3300i = i;
    }

    public final void hO_() {
        this.f3300i = Integer.MIN_VALUE;
    }
}

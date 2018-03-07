package com.facebook.photos.simplepicker.view;

import android.content.Context;
import android.graphics.Bitmap;
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

/* compiled from: server_error */
public class PickerGridVideoItemView extends PickerGridPhotoItemView implements PickerPlayableView {
    private static final String f3302i = PickerGridVideoItemView.class.getName();
    @Inject
    public QeAccessor f3303a;
    @Inject
    public Lazy<FbErrorReporter> f3304h;
    private ImageView f3305j;
    private TextView f3306k;
    public RichVideoPlayer f3307l;
    public RVPMeasureSubscriber f3308m;
    private int f3309n = Integer.MIN_VALUE;

    /* compiled from: server_error */
    public class RVPMeasureSubscriber extends RichVideoPlayerEventSubscriber<RVPMeasureEvent> {
        final /* synthetic */ PickerGridVideoItemView f3301a;

        public RVPMeasureSubscriber(PickerGridVideoItemView pickerGridVideoItemView) {
            this.f3301a = pickerGridVideoItemView;
        }

        public final void m3248b(FbEvent fbEvent) {
            State playerState = this.f3301a.f3307l.getPlayerState();
            if (this.f3301a.f3307l.getWidth() != 0 && this.f3301a.f3307l.getHeight() != 0) {
                if (playerState == State.ATTEMPT_TO_PLAY || playerState == State.PLAYING) {
                    this.f3301a.f3307l.setVisibility(0);
                }
            }
        }

        public final Class<RVPMeasureEvent> m3247a() {
            return RVPMeasureEvent.class;
        }
    }

    public static void m3250a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PickerGridVideoItemView pickerGridVideoItemView = (PickerGridVideoItemView) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        pickerGridVideoItemView.f3303a = qeAccessor;
        pickerGridVideoItemView.f3304h = b;
    }

    public PickerGridVideoItemView(Context context) {
        super(context);
        Class cls = PickerGridVideoItemView.class;
        m3250a((Object) this, getContext());
        this.f3308m = new RVPMeasureSubscriber(this);
    }

    public int getLayoutResourceId() {
        return 2130906235;
    }

    protected final void mo166a() {
        super.mo166a();
        m3251k();
    }

    public PickerGridItemType getItemType() {
        return PickerGridItemType.VIDEO;
    }

    public final void mo178a(@Nullable MediaItem mediaItem, @Nullable Bitmap bitmap) {
        if (mediaItem == null || (mediaItem instanceof VideoItem)) {
            super.mo178a(mediaItem, bitmap);
            return;
        }
        ((AbstractFbErrorReporter) this.f3304h.get()).a(f3302i, StringFormatUtil.a("Cannot render a %s view as a PickerGridVideoItemView", new Object[]{mediaItem.getClass().getName()}));
    }

    public void setMediaBitmap(@Nullable Bitmap bitmap) {
        super.setMediaBitmap(bitmap);
        if (this.f3307l != null) {
            hN_();
            this.f3307l.g();
        }
        m3251k();
    }

    private void m3251k() {
        long j;
        if (this.f3305j == null) {
            this.f3305j = (ImageView) ((ViewStub) c(2131560554)).inflate();
        }
        if (this.f3306k == null) {
            this.f3306k = (TextView) ((ViewStub) c(2131565958)).inflate();
        }
        this.f3305j.setVisibility(0);
        if (this.f3255g == null) {
            j = -1;
        } else {
            j = ((VideoItem) this.f3255g).d;
        }
        if (!mo168g() || j == -1) {
            this.f3306k.setVisibility(4);
            return;
        }
        this.f3306k.setText(m3249a(j));
        this.f3306k.setVisibility(0);
    }

    public final void hN_() {
        if (this.f3307l != null) {
            this.f3305j.setVisibility(0);
            this.f3306k.setVisibility(0);
            this.f3307l.b(EventTriggerType.BY_PLAYER);
            this.f3307l.b(this.f3308m);
            this.f3307l.invalidate();
            this.f3307l.requestLayout();
        }
    }

    public int getPlayPriority() {
        if (this.f3309n != Integer.MIN_VALUE) {
            return this.f3309n;
        }
        if (isSelected()) {
            return getSelectedOrder();
        }
        return getIndex() * -1;
    }

    public final void mo173a(int i) {
        this.f3309n = i;
    }

    public final void hO_() {
        this.f3309n = Integer.MIN_VALUE;
    }

    public final void mo175h() {
        if (this.f3307l == null && SimplePickerExperimentsUtil.m2989a(this.f3303a)) {
            this.f3307l = (RichVideoPlayer) ((ViewStub) c(2131562414)).inflate();
            this.f3307l.a(new VideoPlugin(getContext()));
            this.f3307l.setShouldCropToFit(true);
            this.f3307l.setPlayerOrigin(PlayerOrigin.SIMPLE_PICKER);
            this.f3307l.setVisibility(4);
        }
        if (!(this.f3255g == null || this.f3255g.f() == null || this.f3307l == null)) {
            VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
            newBuilder.a = this.f3255g.f();
            newBuilder = newBuilder;
            newBuilder.f = StreamSourceType.FROM_LOCAL_STORAGE;
            VideoPlayerParamsBuilder a = VideoPlayerParams.newBuilder().a(newBuilder.i());
            a.g = true;
            a = a;
            Builder builder = new Builder();
            builder.a = a.m();
            RichVideoPlayerParams b = builder.b();
            this.f3307l.a(this.f3308m);
            this.f3307l.a(b);
        }
        if (this.f3307l != null) {
            this.f3305j.setVisibility(4);
            this.f3306k.setVisibility(4);
            this.f3307l.a(EventTriggerType.BY_PLAYER);
        }
    }

    private static String m3249a(long j) {
        long j2 = j / 1000;
        long j3 = j2 / 60;
        j2 %= 60;
        StringBuilder stringBuilder = new StringBuilder();
        if (j3 <= 9) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j3).append(':');
        if (j2 <= 9) {
            stringBuilder.append('0');
        }
        stringBuilder.append(j2);
        return stringBuilder.toString();
    }
}

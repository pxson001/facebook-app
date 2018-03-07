package com.facebook.videocodec.trimming;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.videocodec.common.VideoPreviewView;
import com.facebook.videocodec.common.VideoPreviewView.PlaybackState;

/* compiled from: com.google.android.gms.maps.internal.IOnMapLongClickListener */
public class VideoTrimmingPreviewView extends VideoPreviewView {
    private static final Class<?> f19772d = VideoTrimmingPreviewView.class;
    public AbstractFbErrorReporter f19773e;
    public ErrorDialogs f19774f;

    /* compiled from: com.google.android.gms.maps.internal.IOnMapLongClickListener */
    class C14811 implements OnClickListener {
        final /* synthetic */ VideoTrimmingPreviewView f19768a;

        C14811(VideoTrimmingPreviewView videoTrimmingPreviewView) {
            this.f19768a = videoTrimmingPreviewView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1558619259);
            VideoPreviewView videoPreviewView = this.f19768a;
            if (videoPreviewView.f19700c != null) {
                videoPreviewView.f19700c.m28418a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -666166821, a);
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMapLongClickListener */
    class C14822 implements OnPreparedListener {
        final /* synthetic */ VideoTrimmingPreviewView f19769a;

        C14822(VideoTrimmingPreviewView videoTrimmingPreviewView) {
            this.f19769a = videoTrimmingPreviewView;
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            this.f19769a.m28411a(PlaybackState.PAUSED);
            VideoPreviewView videoPreviewView = this.f19769a;
            if (videoPreviewView.f19700c != null) {
                videoPreviewView.f19700c.m28421d();
            }
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMapLongClickListener */
    class C14833 implements OnCompletionListener {
        final /* synthetic */ VideoTrimmingPreviewView f19770a;

        C14833(VideoTrimmingPreviewView videoTrimmingPreviewView) {
            this.f19770a = videoTrimmingPreviewView;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f19770a.f19699b.setVisibility(0);
            this.f19770a.m28411a(PlaybackState.PAUSED);
            if (this.f19770a.f19700c != null) {
                this.f19770a.f19700c.m28419b();
            }
        }
    }

    /* compiled from: com.google.android.gms.maps.internal.IOnMapLongClickListener */
    class C14844 implements OnErrorListener {
        final /* synthetic */ VideoTrimmingPreviewView f19771a;

        C14844(VideoTrimmingPreviewView videoTrimmingPreviewView) {
            this.f19771a = videoTrimmingPreviewView;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            this.f19771a.f19773e.a("VideoTrimmingPreviewView_FAILED_TO_PREPARE_VIDEO", StringFormatUtil.a("MediaPlayer error (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            this.f19771a.m28411a(PlaybackState.ERROR);
            this.f19771a.f19774f.a(ErrorDialogParams.a(this.f19771a.getResources()).a(2131230721).b(2131232762).l());
            return true;
        }
    }

    private static <T extends View> void m28498a(Class<T> cls, T t) {
        m28499a((Object) t, t.getContext());
    }

    private static void m28499a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VideoTrimmingPreviewView videoTrimmingPreviewView = (VideoTrimmingPreviewView) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        ErrorDialogs a = ErrorDialogs.a(fbInjector);
        videoTrimmingPreviewView.f19773e = abstractFbErrorReporter;
        videoTrimmingPreviewView.f19774f = a;
    }

    public VideoTrimmingPreviewView(Context context) {
        super(context);
        m28507f();
    }

    public VideoTrimmingPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m28507f();
    }

    public VideoTrimmingPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m28507f();
    }

    private void m28507f() {
        m28498a(VideoTrimmingPreviewView.class, (View) this);
        setOnClickListener(new C14811(this));
        this.f19698a.setOnPreparedListener(new C14822(this));
        this.f19698a.setOnCompletionListener(new C14833(this));
        this.f19698a.setOnErrorListener(new C14844(this));
    }

    static /* synthetic */ void m28496a(VideoTrimmingPreviewView videoTrimmingPreviewView) {
        if (videoTrimmingPreviewView.f19700c != null) {
            videoTrimmingPreviewView.f19700c.m28418a();
        }
    }

    static /* synthetic */ void m28500b(VideoTrimmingPreviewView videoTrimmingPreviewView) {
        if (videoTrimmingPreviewView.f19700c != null) {
            videoTrimmingPreviewView.f19700c.m28421d();
        }
    }
}

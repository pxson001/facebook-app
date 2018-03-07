package com.facebook.video.videohome.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.async.CancellableRunnable;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.videohome.liveupdates.BroadcastStatusUpdateManager;
import com.facebook.video.videohome.liveupdates.LiveUpdatesManager;
import com.facebook.video.videohome.prefetching.VideoHomeReactionSessionHelper;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: show_payment_error_dialog */
public class VideoHomeDebugOverlayView extends CustomLinearLayout {
    @Inject
    Lazy<VideoHomeReactionSessionHelper> f3343a;
    @Inject
    Lazy<AndroidThreadUtil> f3344b;
    @Inject
    Lazy<LiveUpdatesManager> f3345c;
    public CancellableRunnable f3346d;
    public TextView f3347e;
    private Button f3348f;

    /* compiled from: show_payment_error_dialog */
    class C03081 implements OnClickListener {
        final /* synthetic */ VideoHomeDebugOverlayView f3341a;

        C03081(VideoHomeDebugOverlayView videoHomeDebugOverlayView) {
            this.f3341a = videoHomeDebugOverlayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -572320393);
            LiveUpdatesManager liveUpdatesManager = (LiveUpdatesManager) this.f3341a.f3345c.get();
            if (liveUpdatesManager.b.b) {
                BroadcastStatusUpdateManager broadcastStatusUpdateManager = (BroadcastStatusUpdateManager) liveUpdatesManager.a.get();
                for (String str : broadcastStatusUpdateManager.d.keySet()) {
                    if (broadcastStatusUpdateManager.a(str) == GraphQLVideoBroadcastStatus.LIVE) {
                        BroadcastStatusUpdateManager.a(broadcastStatusUpdateManager, str, GraphQLVideoBroadcastStatus.LIVE_STOPPED);
                        break;
                    }
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 730813877, a);
        }
    }

    /* compiled from: show_payment_error_dialog */
    class C03092 implements Runnable {
        final /* synthetic */ VideoHomeDebugOverlayView f3342a;

        C03092(VideoHomeDebugOverlayView videoHomeDebugOverlayView) {
            this.f3342a = videoHomeDebugOverlayView;
        }

        public void run() {
            this.f3342a.f3347e.setText(((VideoHomeReactionSessionHelper) this.f3342a.f3343a.get()).f3313w);
            ((DefaultAndroidThreadUtil) this.f3342a.f3344b.get()).b(this.f3342a.f3346d, 1000);
        }
    }

    private static <T extends View> void m3176a(Class<T> cls, T t) {
        m3177a((Object) t, t.getContext());
    }

    private static void m3177a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoHomeDebugOverlayView) obj).m3175a(IdBasedSingletonScopeProvider.b(fbInjector, 11702), IdBasedLazy.a(fbInjector, 517), IdBasedSingletonScopeProvider.b(fbInjector, 3708));
    }

    public VideoHomeDebugOverlayView(Context context) {
        this(context, null);
    }

    public VideoHomeDebugOverlayView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoHomeDebugOverlayView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3176a(VideoHomeDebugOverlayView.class, (View) this);
        setContentView(2130907713);
        this.f3347e = (TextView) a(2131568422);
        this.f3348f = (Button) a(2131568421);
        this.f3348f.setOnClickListener(new C03081(this));
        this.f3346d = getCancellableLiveVideosCountRunnable();
        if (this.f3346d != null) {
            ((DefaultAndroidThreadUtil) this.f3344b.get()).b(this.f3346d, 1000);
        }
    }

    private void m3175a(Lazy<VideoHomeReactionSessionHelper> lazy, Lazy<AndroidThreadUtil> lazy2, Lazy<LiveUpdatesManager> lazy3) {
        this.f3343a = lazy;
        this.f3344b = lazy2;
        this.f3345c = lazy3;
    }

    @Nullable
    private CancellableRunnable getCancellableLiveVideosCountRunnable() {
        return new CancellableRunnable(new C03092(this));
    }
}

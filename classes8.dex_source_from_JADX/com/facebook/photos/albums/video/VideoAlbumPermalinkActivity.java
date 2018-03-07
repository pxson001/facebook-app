package com.facebook.photos.albums.video;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.albums.events.AlbumsEventBus;
import com.facebook.photos.albums.events.AlbumsEvents.LaunchVideoPlayerEvent;
import com.facebook.photos.albums.protocols.VideosUploadedByUserGraphQLModels.VideoDetailFragmentModel;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.VideoAlbumOriginType;
import com.facebook.video.engine.VideoLoggingUtils;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: confirm_action_params */
public class VideoAlbumPermalinkActivity extends FbFragmentActivity {
    private Lazy<AlbumsEventBus> f17325p;
    private final com.facebook.photos.albums.events.AlbumsEvents.LaunchVideoPlayerEventSubscriber f17326q = new LaunchVideoPlayerEventSubscriber(this);
    public FullscreenVideoPlayerLauncher f17327r;
    private Lazy<VideoLoggingUtils> f17328s;
    public ZeroDialogController f17329t;

    /* compiled from: confirm_action_params */
    class C18381 implements OnClickListener {
        final /* synthetic */ VideoAlbumPermalinkActivity f17322a;

        C18381(VideoAlbumPermalinkActivity videoAlbumPermalinkActivity) {
            this.f17322a = videoAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -874521124);
            this.f17322a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -437241246, a);
        }
    }

    /* compiled from: confirm_action_params */
    class C18392 implements Listener {
        final /* synthetic */ VideoAlbumPermalinkActivity f17323a;

        C18392(VideoAlbumPermalinkActivity videoAlbumPermalinkActivity) {
            this.f17323a = videoAlbumPermalinkActivity;
        }

        public final void m21340a(Object obj) {
            VideoAlbumPermalinkActivity videoAlbumPermalinkActivity = this.f17323a;
            VideoDetailFragmentModel videoDetailFragmentModel = (VideoDetailFragmentModel) obj;
            VideoAlbumOriginType asOriginType = VideoAlbumOriginType.asOriginType(videoAlbumPermalinkActivity.getIntent().getExtras().getString("origin"));
            if (asOriginType == null || !asOriginType.equals(VideoAlbumOriginType.PAGE_VIDEO_HUB)) {
                videoAlbumPermalinkActivity.f17327r.m11258b(videoDetailFragmentModel, videoAlbumPermalinkActivity, PlayerOrigin.VIDEO_ALBUM_PERMALINK);
            } else {
                videoAlbumPermalinkActivity.f17327r.m11258b(videoDetailFragmentModel, videoAlbumPermalinkActivity, PlayerOrigin.PAGE_TIMELINE);
            }
        }

        public final void m21339a() {
        }
    }

    /* compiled from: confirm_action_params */
    class LaunchVideoPlayerEventSubscriber extends com.facebook.photos.albums.events.AlbumsEvents.LaunchVideoPlayerEventSubscriber {
        final /* synthetic */ VideoAlbumPermalinkActivity f17324a;

        public LaunchVideoPlayerEventSubscriber(VideoAlbumPermalinkActivity videoAlbumPermalinkActivity) {
            this.f17324a = videoAlbumPermalinkActivity;
        }

        public final void m21341b(FbEvent fbEvent) {
            this.f17324a.f17329t.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f17324a.kO_(), ((LaunchVideoPlayerEvent) fbEvent).a);
        }
    }

    /* compiled from: confirm_action_params */
    public enum VideoAlbumEntityType {
        USER,
        VIDEO_LIST
    }

    private static <T extends Context> void m21345a(Class<T> cls, T t) {
        m21346a((Object) t, (Context) t);
    }

    public static void m21346a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VideoAlbumPermalinkActivity) obj).m21344a(IdBasedSingletonScopeProvider.b(fbInjector, 9247), FullscreenVideoPlayerLauncher.m11255b(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 3663), (ZeroDialogController) FbZeroDialogController.b(fbInjector));
    }

    public static Intent m21342a(Context context, Long l, VideoAlbumEntityType videoAlbumEntityType, VideoAlbumOriginType videoAlbumOriginType) {
        Intent intent = new Intent(context, VideoAlbumPermalinkActivity.class);
        intent.putExtra("target_actor_id", l).putExtra("target_actor_type", videoAlbumEntityType).putExtra("origin", videoAlbumOriginType.value);
        return intent;
    }

    public final void m21347a(Bundle bundle) {
        super.a(bundle);
        Class cls = VideoAlbumPermalinkActivity.class;
        m21346a((Object) this, (Context) this);
    }

    @Inject
    private void m21344a(Lazy<AlbumsEventBus> lazy, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, Lazy<VideoLoggingUtils> lazy2, ZeroDialogController zeroDialogController) {
        this.f17325p = lazy;
        this.f17327r = fullscreenVideoPlayerLauncher;
        this.f17328s = lazy2;
        this.f17329t = zeroDialogController;
    }

    public final void m21348b(Bundle bundle) {
        boolean z = (getIntent().getExtras() == null || getIntent().getExtras().isEmpty()) ? false : true;
        Preconditions.checkState(z, "Extras of the intent was expected to hold a long value for target id");
        ((VideoLoggingUtils) this.f17328s.get()).a(VideoAlbumOriginType.asOriginType(getIntent().getExtras().getString("origin")));
        super.b(bundle);
        setContentView(2130907653);
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) findViewById(2131558563);
            fbTitleBar.setHasBackButton(false);
            fbTitleBar.a(new C18381(this));
        }
        this.f17329t.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, getString(2131232932), new C18392(this));
        VideoAlbumEntityType videoAlbumEntityType = (VideoAlbumEntityType) getIntent().getExtras().getSerializable("target_actor_type");
        long j = getIntent().getExtras().getLong("target_actor_id");
        VideoAlbumPermalinkFragment videoAlbumPermalinkFragment = new VideoAlbumPermalinkFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putLong("target_actor_id", j);
        bundle2.putSerializable("target_actor_type", videoAlbumEntityType);
        videoAlbumPermalinkFragment.g(bundle2);
        kO_().a().b(2131558429, videoAlbumPermalinkFragment).b();
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1643690817);
        super.onResume();
        ((AlbumsEventBus) this.f17325p.get()).a(this.f17326q);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -888239289, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -887977535);
        ((AlbumsEventBus) this.f17325p.get()).b(this.f17326q);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 100671326, a);
    }
}

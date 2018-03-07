package com.facebook.photos.mediagallery.ui;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.UriUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediagallery.abtest.ExperimentsForMediaGalleryAbTestModule;
import com.facebook.photos.mediagallery.ui.MediaGalleryDataSource.Subscriber;
import com.facebook.photos.mediagallery.ui.MediaGalleryFragment.C02866;
import com.facebook.photos.mediagallery.ui.widget.MediaGalleryVideoChromeController;
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
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.CoverImagePlugin;
import com.facebook.video.player.plugins.InvisibleSeekBarPlugin;
import com.facebook.video.player.plugins.LoadingSpinnerPlugin;
import com.facebook.video.player.plugins.VideoPlugin;
import com.facebook.video.server.VideoServer;
import com.facebook.video.server.VideoServerMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: sms_code_searched */
public class MediaGalleryVideoPageFragment extends FbFragment implements FragmentWithMediaId, Subscriber {
    @Inject
    public QeAccessor f2424a;
    private C02902 al;
    private PlayerStateChangedEventSubscriber am;
    public InvisibleSeekBarPlugin an;
    private final Rect ao = new Rect();
    @Inject
    public MediaGalleryDataSource f2425b;
    @Inject
    public MediaGalleryVideoChromeController f2426c;
    @Inject
    public VideoServer f2427d;
    public RichVideoPlayer f2428e;
    public String f2429f;
    private RichVideoPlayerParams f2430g = null;
    public boolean f2431h;
    private C02891 f2432i;

    /* compiled from: sms_code_searched */
    public class C02891 {
        public final /* synthetic */ MediaGalleryVideoPageFragment f2419a;

        public C02891(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
            this.f2419a = mediaGalleryVideoPageFragment;
        }
    }

    /* compiled from: sms_code_searched */
    public class C02902 {
        public final /* synthetic */ MediaGalleryVideoPageFragment f2420a;

        public C02902(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
            this.f2420a = mediaGalleryVideoPageFragment;
        }
    }

    /* compiled from: sms_code_searched */
    public class C02913 {
        public final /* synthetic */ MediaGalleryVideoPageFragment f2421a;

        public C02913(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
            this.f2421a = mediaGalleryVideoPageFragment;
        }
    }

    /* compiled from: sms_code_searched */
    public class C02924 implements OnClickListener {
        final /* synthetic */ MediaGalleryVideoPageFragment f2422a;

        public C02924(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
            this.f2422a = mediaGalleryVideoPageFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1257655656);
            if (this.f2422a.f2426c.f2833a != null) {
                C02866 c02866 = this.f2422a.f2426c.f2833a;
                String str = this.f2422a.f2429f;
                if (c02866.f2383a.aL != null && MediaGalleryFragment.m2509a(c02866.f2383a, str) && c02866.f2383a.aL.m2788b()) {
                    c02866.f2383a.aA.b(FunnelRegistry.z, "single_tap_on_video");
                    MediaGalleryFragment.aE(c02866.f2383a).b();
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 951233736, a);
        }
    }

    /* compiled from: sms_code_searched */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ MediaGalleryVideoPageFragment f2423a;

        public PlayerStateChangedEventSubscriber(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
            this.f2423a = mediaGalleryVideoPageFragment;
        }

        public final void m2549b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f2423a.f2426c.f2833a != null) {
                C02866 c02866 = this.f2423a.f2426c.f2833a;
                String str = this.f2423a.f2429f;
                boolean isPlayingState = rVPPlayerStateChangedEvent.b.isPlayingState();
                if (c02866.f2383a.aL != null && MediaGalleryFragment.m2509a(c02866.f2383a, str)) {
                    c02866.f2383a.aL.m2789c(isPlayingState);
                }
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m2548a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m2550a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment = (MediaGalleryVideoPageFragment) obj;
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        MediaGalleryDataSource a = MediaGalleryDataSource.m2473a(injectorLike);
        MediaGalleryVideoChromeController a2 = MediaGalleryVideoChromeController.m2873a(injectorLike);
        VideoServer a3 = VideoServerMethodAutoProvider.a(injectorLike);
        mediaGalleryVideoPageFragment.f2424a = qeAccessor;
        mediaGalleryVideoPageFragment.f2425b = a;
        mediaGalleryVideoPageFragment.f2426c = a2;
        mediaGalleryVideoPageFragment.f2427d = a3;
    }

    public final void m2560c(Bundle bundle) {
        super.c(bundle);
        Class cls = MediaGalleryVideoPageFragment.class;
        m2550a((Object) this, getContext());
        if (bundle != null) {
            this.f2429f = bundle.getString("EXTRA_MEDIA_ID");
        }
    }

    public final void m2561e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("EXTRA_MEDIA_ID", this.f2429f);
    }

    public final View m2556a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 226670548);
        View inflate = layoutInflater.inflate(2130905178, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 176833983, a);
        return inflate;
    }

    public final void m2558a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.am = new PlayerStateChangedEventSubscriber(this);
        this.f2428e = (RichVideoPlayer) e(2131563719);
        this.f2428e.a(this.am);
        RichVideoPlayer richVideoPlayer = this.f2428e;
        Context context = getContext();
        richVideoPlayer.a(new VideoPlugin(context));
        richVideoPlayer.a(new CoverImagePlugin(context));
        richVideoPlayer.a(new LoadingSpinnerPlugin(context));
        this.an = new InvisibleSeekBarPlugin(context);
        richVideoPlayer.a(this.an);
        this.f2425b.m2476a(this.f2429f, this);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -639025131);
        this.f2425b.m2475a(this.f2429f);
        this.f2428e.b(this.am);
        this.f2428e.g();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 500470068, a);
    }

    public final void m2554G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1462849299);
        super.G();
        if (this.f2432i == null) {
            this.f2432i = new C02891(this);
        }
        if (this.al == null) {
            this.al = new C02902(this);
        }
        MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2426c;
        C02891 c02891 = this.f2432i;
        if (c02891 != null) {
            mediaGalleryVideoChromeController.f2834b.put(c02891, Boolean.valueOf(true));
        }
        mediaGalleryVideoChromeController = this.f2426c;
        C02902 c02902 = this.al;
        if (c02902 != null) {
            mediaGalleryVideoChromeController.f2835c.put(c02902, Boolean.valueOf(true));
        }
        if (this.f2430g != null) {
            this.f2428e.a(this.f2430g);
            this.f2430g = null;
        }
        as(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -461452654, a);
    }

    public final void m2555H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -472975266);
        super.H();
        MediaGalleryVideoChromeController mediaGalleryVideoChromeController = this.f2426c;
        C02891 c02891 = this.f2432i;
        if (c02891 != null) {
            mediaGalleryVideoChromeController.f2834b.remove(c02891);
        }
        mediaGalleryVideoChromeController = this.f2426c;
        C02902 c02902 = this.al;
        if (c02902 != null) {
            mediaGalleryVideoChromeController.f2835c.remove(c02902);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1523296949, a);
    }

    public final void mo118a(MediaMetadata mediaMetadata) {
        if (mediaMetadata != null) {
            Uri a = UriUtil.a(mediaMetadata.Q());
            Uri a2 = UriUtil.a(mediaMetadata.E());
            this.f2431h = a2 != null;
            DefaultImageFields be_ = mediaMetadata.be_();
            if (a != null && be_ != null) {
                DefaultImageFields g = mediaMetadata.g();
                Uri a3 = UriUtil.a(g != null ? g.b() : be_.b());
                int c = mediaMetadata.be_().c();
                int a4 = mediaMetadata.be_().a();
                double d = 1.0d;
                if (a4 > 0) {
                    d = ((double) c) / ((double) a4);
                }
                VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
                newBuilder.a = this.f2427d.a(a, mediaMetadata.d(), false);
                VideoDataSourceBuilder videoDataSourceBuilder = newBuilder;
                videoDataSourceBuilder.b = a2;
                videoDataSourceBuilder = videoDataSourceBuilder;
                videoDataSourceBuilder.f = StreamSourceType.FROM_STREAM;
                VideoPlayerParamsBuilder a5 = VideoPlayerParams.newBuilder().a(videoDataSourceBuilder.i());
                a5.g = false;
                VideoPlayerParamsBuilder videoPlayerParamsBuilder = a5;
                Builder builder = new Builder();
                builder.a = videoPlayerParamsBuilder.m();
                RichVideoPlayerParams b = builder.a("CoverImageParamsKey", ImageRequestBuilder.a(a3).m()).a("VideoAspectRatioKey", Double.valueOf(d)).a("InvisibleSeekBarListenerKey", new C02913(this)).b();
                if (this.f2428e != null) {
                    this.f2428e.setPlayerOrigin(PlayerOrigin.MEDIA_GALLERY);
                    this.f2428e.setOnClickListener(new C02924(this));
                    this.f2428e.a(b);
                } else {
                    this.f2430g = b;
                }
                this.f2429f = mediaMetadata.d();
            }
        }
    }

    public final String mo117a() {
        return this.f2429f;
    }

    public static boolean m2552b(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
        return mediaGalleryVideoPageFragment.f2428e.getGlobalVisibleRect(mediaGalleryVideoPageFragment.ao);
    }

    public static boolean m2553e(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
        return mediaGalleryVideoPageFragment.f2424a.a(ExperimentsForMediaGalleryAbTestModule.k, false);
    }

    public static boolean m2551a(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment, String str) {
        return StringUtil.a(str, mediaGalleryVideoPageFragment.f2429f);
    }

    public static void as(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
        if (m2552b(mediaGalleryVideoPageFragment) && !at(mediaGalleryVideoPageFragment) && m2553e(mediaGalleryVideoPageFragment)) {
            mediaGalleryVideoPageFragment.f2428e.a(EventTriggerType.BY_PLAYER);
            if (mediaGalleryVideoPageFragment.f2426c.f2833a != null) {
                mediaGalleryVideoPageFragment.f2426c.f2833a.m2496a();
            }
        }
    }

    public static boolean at(MediaGalleryVideoPageFragment mediaGalleryVideoPageFragment) {
        return (mediaGalleryVideoPageFragment.f2428e.u == null || mediaGalleryVideoPageFragment.f2428e.u.l == null) ? false : mediaGalleryVideoPageFragment.f2428e.u.l.isPlayingState();
    }
}

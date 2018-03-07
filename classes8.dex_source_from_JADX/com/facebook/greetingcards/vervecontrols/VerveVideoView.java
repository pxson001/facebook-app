package com.facebook.greetingcards.vervecontrols;

import android.content.Context;
import android.net.Uri;
import android.widget.FrameLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.eventbus.TypedEventBus;
import com.facebook.common.eventbus.TypedHandler;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.greetingcards.verve.render.VerveVideoContainer;
import com.facebook.greetingcards.verve.render.VerveVideoContainer$VerveVideoContainerListener;
import com.facebook.inject.FbInjector;
import com.facebook.video.api.AsyncVideo;
import com.facebook.video.api.VideoCore;
import com.facebook.video.api.VideoEvents.CompletedEvent;
import com.facebook.video.api.playersession.VideoPlayerSessionManager;
import com.facebook.video.engine.texview.TextureAttachManager;
import com.facebook.video.newplayer.CoverImagePlugin;
import com.facebook.video.newplayer.VideoPlayer;
import com.facebook.video.newplayer.VideoPlayer.Plugin;
import com.facebook.video.server.VideoPlayerSessionManagerMethodAutoProvider;
import com.facebook.video.view.TextureViewHolder;
import com.facebook.video.view.TextureViewImplementation;
import com.facebook.video.view.UiThreadTypedEventBus;
import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: view_page_mentions */
public class VerveVideoView extends FrameLayout implements VerveVideoContainer {
    @Inject
    AbstractFbErrorReporter f444a;
    @Inject
    DefaultAndroidThreadUtil f445b;
    @Inject
    TextureAttachManager f446c;
    @Inject
    VideoPlayerSessionManager f447d;
    @DefaultExecutorService
    @Inject
    ScheduledExecutorService f448e;
    private final TypedEventBus f449f = new UiThreadTypedEventBus(this.f445b);
    public final VideoPlayer<Uri> f450g;
    private final CoverImagePlugin f451h;
    private VerveVideoContainer$VerveVideoContainerListener f452i;

    /* compiled from: view_page_mentions */
    public class C00531 implements TypedHandler {
        final /* synthetic */ VerveVideoView f443a;

        C00531(VerveVideoView verveVideoView) {
            this.f443a = verveVideoView;
        }
    }

    public static void m421a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((VerveVideoView) obj).m420a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), TextureAttachManager.a(fbInjector), VideoPlayerSessionManagerMethodAutoProvider.a(fbInjector), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector));
    }

    public VerveVideoView(Context context) {
        super(context);
        Class cls = VerveVideoView.class;
        m421a(this, getContext());
        this.f449f.a(CompletedEvent.class, new C00531(this));
        TextureViewHolder textureViewHolder = new TextureViewHolder(context, this.f446c);
        this.f450g = new VideoPlayer(context, textureViewHolder.a, new AsyncVideo(new VideoCore(new TextureViewImplementation(context, textureViewHolder, this.f448e, this.f445b, this.f449f, false, false, this.f447d, this.f444a), this.f449f), this.f445b));
        this.f451h = new CoverImagePlugin();
        FrameLayout frameLayout = this.f450g;
        Plugin plugin = this.f451h;
        Preconditions.checkArgument(plugin.f9783a == null, "Plugin already registered");
        plugin.f9783a = frameLayout;
        plugin.mo622a(frameLayout.getEventBus(), frameLayout);
        addView(this.f450g);
    }

    private void m420a(AbstractFbErrorReporter abstractFbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil, TextureAttachManager textureAttachManager, VideoPlayerSessionManager videoPlayerSessionManager, ScheduledExecutorService scheduledExecutorService) {
        this.f444a = abstractFbErrorReporter;
        this.f445b = defaultAndroidThreadUtil;
        this.f446c = textureAttachManager;
        this.f447d = videoPlayerSessionManager;
        this.f448e = scheduledExecutorService;
    }

    public void setVideoListener(VerveVideoContainer$VerveVideoContainerListener verveVideoContainer$VerveVideoContainerListener) {
        this.f452i = verveVideoContainer$VerveVideoContainerListener;
    }

    public void setCoverUri(Uri uri) {
        this.f451h.m11482a(uri);
    }

    public VideoPlayer<Uri> getVideoPlayer() {
        return this.f450g;
    }
}

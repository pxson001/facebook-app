package com.facebook.groups.react;

import android.app.Activity;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.groups.treehouse.perf.TreehousePerfLogger;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory.Builder;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.react.bridge.ReactContext;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: payment_method_added */
public class PhotoGalleryLauncher {
    public final Activity f7032a;
    public final Lazy<MediaGalleryLauncher> f7033b;
    public final GroupsReactDataFetcher f7034c;
    private final MediaGalleryLauncherParamsFactory f7035d;
    public final TreehousePerfLogger f7036e;

    /* compiled from: payment_method_added */
    public class C07391 implements FutureCallback<GraphQLStory> {
        final /* synthetic */ PhotoGalleryLauncher f7029a;

        public C07391(PhotoGalleryLauncher photoGalleryLauncher) {
            this.f7029a = photoGalleryLauncher;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLStory graphQLStory = (GraphQLStory) obj;
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
            if (o != null && o.r() != null) {
                Builder a = MediaGalleryLauncherParamsFactory.a(o);
                FeedProps c = FeedProps.c(graphQLStory);
                MediaGalleryLauncherParams.Builder a2 = a.a(FullscreenGallerySource.NEWSFEED);
                a2.h = graphQLStory.g();
                a2 = a2;
                a2.k = graphQLStory.c();
                a2 = a2;
                a2.j = TrackableFeedProps.a(c).toString();
                a2 = a2;
                a2.l = StoryProps.p(c);
                a2.i = graphQLStory.ai();
                MediaGalleryLauncherParams b = a.b();
                this.f7029a.f7036e.f7049f.b(TreehousePerfLogger.f7046d);
                ((MediaGalleryLauncher) this.f7029a.f7033b.get()).a(this.f7029a.f7032a, b, null);
            }
        }

        public void onFailure(Throwable th) {
            this.f7029a.f7036e.f7049f.f(TreehousePerfLogger.f7046d);
        }
    }

    /* compiled from: payment_method_added */
    public class C07402 implements Runnable {
        final /* synthetic */ MediaGalleryLauncherParams.Builder f7030a;
        final /* synthetic */ PhotoGalleryLauncher f7031b;

        public C07402(PhotoGalleryLauncher photoGalleryLauncher, MediaGalleryLauncherParams.Builder builder) {
            this.f7031b = photoGalleryLauncher;
            this.f7030a = builder;
        }

        public void run() {
            ((MediaGalleryLauncher) this.f7031b.f7033b.get()).a(this.f7031b.f7032a, this.f7030a.b(), null);
        }
    }

    @Inject
    public PhotoGalleryLauncher(@Assisted ReactContext reactContext, @Assisted Activity activity, Lazy<MediaGalleryLauncher> lazy, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, TreehousePerfLogger treehousePerfLogger, GroupsReactDataFetcherProvider groupsReactDataFetcherProvider) {
        this.f7032a = activity;
        this.f7033b = lazy;
        this.f7035d = mediaGalleryLauncherParamsFactory;
        this.f7036e = treehousePerfLogger;
        this.f7034c = groupsReactDataFetcherProvider.m7318a(reactContext);
    }
}

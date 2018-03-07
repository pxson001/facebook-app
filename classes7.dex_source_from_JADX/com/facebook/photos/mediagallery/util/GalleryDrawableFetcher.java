package com.facebook.photos.mediagallery.util;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediagallery.util.ZoomableImageWrapper.FetcherListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.images.DelayedDrawableProvider;
import com.facebook.widget.images.DrawableFetch;
import com.facebook.widget.images.DrawableFetchProvider;
import com.facebook.widget.images.DrawableFetchRequest;
import com.facebook.widget.images.DrawableFetchRequest.Builder;
import com.facebook.widget.images.RemoteDrawableLoader;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_responded */
public class GalleryDrawableFetcher {
    private static final ColorDrawable f10777a = new ColorDrawable(0);
    public final FetcherListener f10778b;
    private final RemoteDrawableLoader f10779c;
    public final DefaultAndroidThreadUtil f10780d;
    private final Optional<WarmupImageHelper> f10781e;
    public MediaMetadata f10782f;
    private TasksManager<String> f10783g;
    public FullImageStatus f10784h = FullImageStatus.NONE;

    /* compiled from: is_responded */
    public enum FullImageStatus {
        NONE,
        FAILED,
        SUCCEEDED,
        LOADING
    }

    /* compiled from: is_responded */
    class RemoteDrawableCallback extends AbstractDisposableFutureCallback<Drawable> {
        final /* synthetic */ GalleryDrawableFetcher f10776a;

        public RemoteDrawableCallback(GalleryDrawableFetcher galleryDrawableFetcher) {
            this.f10776a = galleryDrawableFetcher;
        }

        protected final void m12800a(Object obj) {
            Drawable drawable = (Drawable) obj;
            this.f10776a.f10784h = FullImageStatus.SUCCEEDED;
            this.f10776a.f10780d.a();
            this.f10776a.f10778b.m12832a(drawable, this.f10776a.f10782f.d());
        }

        protected final void m12801a(Throwable th) {
            this.f10776a.f10784h = FullImageStatus.FAILED;
            this.f10776a.f10780d.a();
            FetcherListener fetcherListener = this.f10776a.f10778b;
            String d = this.f10776a.f10782f.d();
            fetcherListener.f10806a.f10815f.a();
            ZoomableImageWrapper.m12833a(fetcherListener.f10806a, fetcherListener.f10806a.f10812b);
            fetcherListener.f10806a.f10817h.m12032a(d, false);
        }
    }

    @Inject
    public GalleryDrawableFetcher(@Assisted GalleryDrawableFetcherListener galleryDrawableFetcherListener, @Assisted Optional<WarmupImageHelper> optional, RemoteDrawableLoader remoteDrawableLoader, AndroidThreadUtil androidThreadUtil, TasksManager tasksManager) {
        this.f10778b = galleryDrawableFetcherListener;
        this.f10781e = optional;
        this.f10779c = remoteDrawableLoader;
        this.f10780d = androidThreadUtil;
        this.f10783g = tasksManager;
    }

    public final void m12805a(@Nullable MediaMetadata mediaMetadata) {
        this.f10780d.a();
        MediaMetadata mediaMetadata2 = this.f10782f;
        this.f10782f = mediaMetadata;
        if (this.f10782f == null) {
            m12804b();
            return;
        }
        boolean equals;
        Preconditions.checkNotNull(this.f10782f.d());
        Preconditions.checkNotNull(this.f10782f.g());
        if (!m12803a(mediaMetadata2, this.f10782f)) {
            m12804b();
        }
        FetcherListener fetcherListener = this.f10778b;
        fetcherListener.f10806a.f10817h.m12035c(this.f10782f.d());
        MediaMetadata mediaMetadata3 = this.f10782f;
        Preconditions.checkNotNull(mediaMetadata3);
        if (m12803a(mediaMetadata2, mediaMetadata3)) {
            equals = mediaMetadata3.g().b().equals(mediaMetadata2.g().b());
        } else {
            equals = false;
        }
        if (equals) {
            if (this.f10784h == FullImageStatus.SUCCEEDED) {
                FetcherListener fetcherListener2 = this.f10778b;
                fetcherListener2.f10806a.f10817h.m12032a(this.f10782f.d(), true);
                return;
            } else if (this.f10784h == FullImageStatus.LOADING) {
                return;
            }
        }
        if (this.f10784h == FullImageStatus.NONE && this.f10781e.isPresent()) {
            Drawable a;
            WarmupImageHelper warmupImageHelper = (WarmupImageHelper) this.f10781e.get();
            mediaMetadata3 = this.f10782f;
            if (warmupImageHelper.f10800a.equals(((SizeAwareMedia) Preconditions.checkNotNull(mediaMetadata3)).d())) {
                a = warmupImageHelper.f10802c.a(warmupImageHelper.f10801b);
            } else {
                a = null;
            }
            if (a == null && mediaMetadata3.bc_() != null) {
                a = warmupImageHelper.f10802c.a(ImageRequest.a(mediaMetadata3.bc_().b()));
            }
            if (a == null && mediaMetadata3.bd_() != null) {
                a = warmupImageHelper.f10802c.a(ImageRequest.a(mediaMetadata3.bd_().b()));
            }
            this.f10778b.m12832a(a, this.f10782f.d());
        }
        this.f10784h = FullImageStatus.LOADING;
        this.f10783g.a("FETCH_TASK", m12802a(this.f10782f.g()), new RemoteDrawableCallback(this));
    }

    private void m12804b() {
        this.f10783g.c();
        this.f10784h = FullImageStatus.NONE;
        this.f10778b.m12832a(null, "");
    }

    public static boolean m12803a(@Nullable MediaMetadata mediaMetadata, MediaMetadata mediaMetadata2) {
        Preconditions.checkNotNull(mediaMetadata2);
        if (mediaMetadata == null) {
            return false;
        }
        return mediaMetadata2.d().equals(mediaMetadata.d());
    }

    private ListenableFuture<Drawable> m12802a(DefaultImageFields defaultImageFields) {
        Uri parse = Uri.parse(defaultImageFields.b());
        Builder builder = new Builder();
        builder.f = parse;
        Builder builder2 = builder;
        builder2.d = defaultImageFields.c();
        builder2 = builder2;
        builder2.c = defaultImageFields.a();
        builder2 = builder2;
        builder2.a = f10777a;
        DrawableFetchRequest drawableFetchRequest = new DrawableFetchRequest(builder2);
        RemoteDrawableLoader remoteDrawableLoader = this.f10779c;
        ListenableFuture c = remoteDrawableLoader.c(drawableFetchRequest);
        DrawableFetchProvider drawableFetchProvider = remoteDrawableLoader.c;
        return new DrawableFetch((DelayedDrawableProvider) drawableFetchProvider.getOnDemandAssistedProviderForStaticDi(DelayedDrawableProvider.class), drawableFetchRequest.a, c, drawableFetchRequest).a;
    }
}

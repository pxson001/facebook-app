package com.facebook.photos.photoset.launcher;

import android.content.Context;
import android.net.Uri;
import com.facebook.graphql.calls.CategoryInputCategoryName;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.PhotosTakenHereMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PhotosTakenOfMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.PostedPhotosMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: cold_start_cursor */
public class PhotoSetConsumptionGalleryPhotoLauncher {
    private Lazy<MediaGalleryLauncher> f17791a;
    private Lazy<MediaGalleryLauncherParamsFactory> f17792b;

    public static PhotoSetConsumptionGalleryPhotoLauncher m21766b(InjectorLike injectorLike) {
        return new PhotoSetConsumptionGalleryPhotoLauncher(IdBasedLazy.a(injectorLike, 9351), IdBasedSingletonScopeProvider.b(injectorLike, 9346));
    }

    @Inject
    public PhotoSetConsumptionGalleryPhotoLauncher(Lazy<MediaGalleryLauncher> lazy, Lazy<MediaGalleryLauncherParamsFactory> lazy2) {
        this.f17791a = lazy;
        this.f17792b = lazy2;
    }

    public final void m21767a(Context context, GraphQLAlbum graphQLAlbum, String str, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        ImageRequest a;
        this.f17792b.get();
        Builder a2 = MediaGalleryLauncherParamsFactory.a(graphQLAlbum).b(immutableList).a(fullscreenGallerySource).a(str);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        Builder a3 = a2.a(a);
        a3.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.b(), null);
    }

    public static PhotoSetConsumptionGalleryPhotoLauncher m21765a(InjectorLike injectorLike) {
        return m21766b(injectorLike);
    }

    public final void m21771a(Context context, String str, String str2, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        ImageRequest a;
        this.f17792b.get();
        Builder a2 = MediaGalleryLauncherParamsFactory.b(str).b(immutableList).a(fullscreenGallerySource).a(str2);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        Builder a3 = a2.a(a);
        a3.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.b(), null);
    }

    public final void m21772a(Context context, String str, String str2, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        this.f17792b.get();
        Builder a = new MediaGalleryLauncherParamsFactory.Builder(MediaFetcherConstructionRule.a(PhotosTakenHereMediaQueryProvider.class, new IdQueryParam(str))).b(immutableList).a(fullscreenGallerySource).a(str2);
        a.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a.b(), null);
    }

    public final void m21774b(Context context, String str, String str2, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        this.f17792b.get();
        Builder a = new MediaGalleryLauncherParamsFactory.Builder(MediaFetcherConstructionRule.a(PhotosTakenOfMediaQueryProvider.class, new IdQueryParam(str))).b(immutableList).a(fullscreenGallerySource).a(str2);
        a.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a.b(), null);
    }

    public final void m21773b(Context context, String str, String str2, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        ImageRequest a;
        this.f17792b.get();
        Builder a2 = new MediaGalleryLauncherParamsFactory.Builder(MediaFetcherConstructionRule.a(PostedPhotosMediaQueryProvider.class, new IdQueryParam(str))).b(immutableList).a(fullscreenGallerySource).a(str2);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        Builder a3 = a2.a(a);
        a3.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.b(), null);
    }

    public final void m21770a(Context context, String str, CategoryInputCategoryName categoryInputCategoryName, String str2, String str3, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        ImageRequest a;
        Builder a2 = MediaGalleryLauncherParamsFactory.a(str, categoryInputCategoryName, str2).b(immutableList).a(fullscreenGallerySource).a(str3);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        Builder a3 = a2.a(a);
        a3.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.b(), null);
    }

    public final void m21768a(Context context, String str, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, FullscreenGallerySource fullscreenGallerySource, boolean z) {
        ImageRequest a;
        Builder a2 = MediaGalleryLauncherParamsFactory.c(immutableList).a(fullscreenGallerySource).a(str);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        Builder a3 = a2.a(a);
        a3.m = z;
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.b(), null);
    }

    public final void m21769a(Context context, String str, @Nullable Uri uri, ImmutableList<? extends SizeAwareMedia> immutableList, String str2) {
        ImageRequest a;
        MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = new MediaGalleryLauncherParamsFactory();
        Builder a2 = MediaGalleryLauncherParamsFactory.a(str2).b(immutableList).a(FullscreenGallerySource.GROUPS_INFO_PAGE_PHOTO_ITEM);
        a2.m = false;
        Builder a3 = a2.a(str);
        if (uri != null) {
            a = ImageRequest.a(uri);
        } else {
            a = null;
        }
        ((MediaGalleryLauncher) this.f17791a.get()).a(context, a3.a(a).b(), null);
    }
}

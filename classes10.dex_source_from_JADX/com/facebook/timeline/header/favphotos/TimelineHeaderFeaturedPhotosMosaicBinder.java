package com.facebook.timeline.header.favphotos;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.timeline.header.controllers.MediaGalleryLauncherHelper;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.IntroCardPhotoFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.IntroCardPhotoFieldsModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetched_suggestions */
public class TimelineHeaderFeaturedPhotosMosaicBinder {
    public static final LayoutParams f11730a = new LayoutParams(0, 0, 6, 6);
    private static final CallerContext f11731b = CallerContext.a(TimelineHeaderFavoritePhotosView.class, "timeline");
    private final Provider<MediaGalleryLauncher> f11732c;
    private final Context f11733d;
    private final MediaCollageHelper f11734e;
    private final FavoritePhotosUtil f11735f;

    public static TimelineHeaderFeaturedPhotosMosaicBinder m11829b(InjectorLike injectorLike) {
        return new TimelineHeaderFeaturedPhotosMosaicBinder(IdBasedProvider.a(injectorLike, 9351), MediaCollageHelper.m11810b(injectorLike), (Context) injectorLike.getInstance(Context.class), FavoritePhotosUtil.m11786a(injectorLike));
    }

    @Inject
    public TimelineHeaderFeaturedPhotosMosaicBinder(Provider<MediaGalleryLauncher> provider, MediaCollageHelper mediaCollageHelper, Context context, FavoritePhotosUtil favoritePhotosUtil) {
        this.f11732c = provider;
        this.f11734e = mediaCollageHelper;
        this.f11733d = context;
        this.f11735f = favoritePhotosUtil;
    }

    public final void m11830a(TimelineHeaderFeaturedPhotosMosaicView timelineHeaderFeaturedPhotosMosaicView, ImmutableList<? extends IntroCardPhotoFields> immutableList, List<? extends CollageLayoutFields> list) {
        timelineHeaderFeaturedPhotosMosaicView.removeAllViews();
        for (int i = 0; i < immutableList.size(); i++) {
            IntroCardPhotoFieldsModel introCardPhotoFieldsModel = (IntroCardPhotoFieldsModel) immutableList.get(i);
            CollageLayoutFields collageLayoutFields = (CollageLayoutFields) list.get(i);
            FbDraweeView a = this.f11734e.m11812a(this.f11733d, f11731b, introCardPhotoFieldsModel, introCardPhotoFieldsModel.j(), collageLayoutFields);
            a.setOnClickListener(m11825a(introCardPhotoFieldsModel, collageLayoutFields, immutableList, list));
            timelineHeaderFeaturedPhotosMosaicView.addView(a);
        }
    }

    private OnClickListener m11825a(SizeAwareMedia sizeAwareMedia, CollageLayoutFields collageLayoutFields, ImmutableList<? extends SizeAwareMedia> immutableList, List<? extends CollageLayoutFields> list) {
        final SizeAwareMedia sizeAwareMedia2 = sizeAwareMedia;
        final CollageLayoutFields collageLayoutFields2 = collageLayoutFields;
        final ImmutableList<? extends SizeAwareMedia> immutableList2 = immutableList;
        final List<? extends CollageLayoutFields> list2 = list;
        return new OnClickListener(this) {
            final /* synthetic */ TimelineHeaderFeaturedPhotosMosaicBinder f11729e;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -374938457);
                if (sizeAwareMedia2 == null || sizeAwareMedia2.d() == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1369121521, a);
                    return;
                }
                this.f11729e.m11827a((FbDraweeView) view, sizeAwareMedia2, collageLayoutFields2, immutableList2, list2);
                LogUtils.a(1180275877, a);
            }
        };
    }

    private void m11827a(FbDraweeView fbDraweeView, SizeAwareMedia sizeAwareMedia, CollageLayoutFields collageLayoutFields, ImmutableList<? extends SizeAwareMedia> immutableList, List<? extends CollageLayoutFields> list) {
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SizeAwareMedia sizeAwareMedia2 = (SizeAwareMedia) immutableList.get(i);
            if (sizeAwareMedia2 != null) {
                builder.c(sizeAwareMedia2.d());
            }
        }
        MediaGalleryLauncherParamsFactory.Builder f = MediaGalleryLauncherParamsFactory.f(builder.b());
        String d = sizeAwareMedia.d();
        ImageRequest a = ImageRequest.a(this.f11734e.m11811a(sizeAwareMedia, collageLayoutFields));
        ((MediaGalleryLauncher) this.f11732c.get()).a(this.f11733d, f.a(FullscreenGallerySource.TIMELINE_PHOTOS_OF_USER).a(d).a(a).a(m11826a(immutableList, list)).b(), MediaGalleryLauncherHelper.m11671a(d, fbDraweeView, a));
    }

    private ImmutableList<MediaMetadata> m11826a(ImmutableList<? extends SizeAwareMedia> immutableList, List<? extends CollageLayoutFields> list) {
        Builder builder = new Builder();
        for (int i = 0; i < immutableList.size(); i++) {
            SizeAwareMedia sizeAwareMedia = (SizeAwareMedia) immutableList.get(i);
            builder.c(MediaGalleryLauncherHelper.m11670a(sizeAwareMedia.d(), this.f11735f.m11793a(sizeAwareMedia, (CollageLayoutFields) list.get(i))));
        }
        return builder.b();
    }
}

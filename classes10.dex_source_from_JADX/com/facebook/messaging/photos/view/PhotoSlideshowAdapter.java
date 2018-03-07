package com.facebook.messaging.photos.view;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: registration_profile_pic_step_completed */
public class PhotoSlideshowAdapter extends Adapter<ViewHolder> {
    private final SlideshowMediaViewHolderProvider f3612a;
    private ImmutableList<MediaMessageItem> f3613b;

    private static PhotoSlideshowAdapter m3428b(InjectorLike injectorLike) {
        return new PhotoSlideshowAdapter((SlideshowMediaViewHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SlideshowMediaViewHolderProvider.class));
    }

    @Inject
    public PhotoSlideshowAdapter(SlideshowMediaViewHolderProvider slideshowMediaViewHolderProvider) {
        this.f3612a = slideshowMediaViewHolderProvider;
    }

    public final ViewHolder m3429a(ViewGroup viewGroup, int i) {
        return new SlideshowMediaViewHolder(FbDraweeControllerBuilder.b(this.f3612a), LayoutInflater.from(viewGroup.getContext()).inflate(2130906213, viewGroup, false));
    }

    public final void m3430a(ViewHolder viewHolder, int i) {
        SlideshowMediaViewHolder slideshowMediaViewHolder = (SlideshowMediaViewHolder) viewHolder;
        slideshowMediaViewHolder.f3654m.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) slideshowMediaViewHolder.f3653l.p().a(CallerContext.a(PhotoSlideshowAdapter.class)).c(ImageRequestBuilder.a(((MediaMessageItem) this.f3613b.get(i)).d()).m())).b(slideshowMediaViewHolder.f3654m.getController())).s());
    }

    public final int aZ_() {
        return this.f3613b.size();
    }
}

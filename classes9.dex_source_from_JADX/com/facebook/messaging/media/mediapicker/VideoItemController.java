package com.facebook.messaging.media.mediapicker;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.mediapicker.MediaPickerGridAdapter.VideoItemListener;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: mAssociation */
public class VideoItemController extends ViewHolder {
    private static final CallerContext f11740l = CallerContext.a(VideoItemController.class);
    private final FbDraweeControllerBuilder f11741m;
    private final Resources f11742n;
    private final TimeFormatUtil f11743o;
    private final ResizeOptions f11744p;
    public final FbDraweeView f11745q;
    public final View f11746r;
    private final DraweeControllerListener f11747s = new DraweeControllerListener(this);
    private final ThumbnailClickListener f11748t = new ThumbnailClickListener(this);
    @Nullable
    public VideoItemListener f11749u;
    @Nullable
    public MediaResource f11750v;

    /* compiled from: mAssociation */
    class DraweeControllerListener extends BaseControllerListener {
        final /* synthetic */ VideoItemController f11738a;

        public DraweeControllerListener(VideoItemController videoItemController) {
            this.f11738a = videoItemController;
        }

        public final /* bridge */ /* synthetic */ void m12386a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        }

        public final void m12387b(String str, Throwable th) {
            this.f11738a.f11745q.setVisibility(8);
            this.f11738a.f11746r.setVisibility(0);
        }
    }

    /* compiled from: mAssociation */
    class ThumbnailClickListener implements OnClickListener {
        final /* synthetic */ VideoItemController f11739a;

        public ThumbnailClickListener(VideoItemController videoItemController) {
            this.f11739a = videoItemController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -365092253);
            if (this.f11739a.f11749u != null) {
                Preconditions.checkNotNull(this.f11739a.f11750v);
                VideoItemListener videoItemListener = this.f11739a.f11749u;
                MediaResource mediaResource = this.f11739a.f11750v;
                if (videoItemListener.f11702a.f11711i != null) {
                    videoItemListener.f11702a.f11711i.m12340a(mediaResource);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1138398700, a);
        }
    }

    @Inject
    public VideoItemController(FbDraweeControllerBuilder fbDraweeControllerBuilder, Resources resources, TimeFormatUtil timeFormatUtil, @Assisted View view) {
        super(view);
        this.f11741m = fbDraweeControllerBuilder;
        this.f11742n = resources;
        this.f11743o = timeFormatUtil;
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431776);
        this.f11744p = new ResizeOptions(dimensionPixelSize, dimensionPixelSize);
        this.f11745q = (FbDraweeView) view.findViewById(2131562910);
        this.f11746r = view.findViewById(2131563975);
        this.f11745q.setOnClickListener(this.f11748t);
    }

    public final void m12388a(MediaResource mediaResource) {
        Preconditions.checkArgument(mediaResource.d == Type.VIDEO);
        this.f11750v = mediaResource;
        String a = this.f11743o.a(TimeFormatStyle.MONTH_DAY_YEAR_STYLE, mediaResource.A);
        this.f11745q.setContentDescription(this.f11742n.getString(2131240888, new Object[]{a}));
        ImageRequestBuilder a2 = ImageRequestBuilder.a(mediaResource.c);
        a2.d = this.f11744p;
        this.f11745q.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f11741m.p().a(f11740l).a(this.f11747s)).c(a2.m())).b(this.f11745q.getController())).s());
        this.f11745q.setVisibility(0);
        this.f11746r.setVisibility(8);
    }
}

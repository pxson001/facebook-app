package com.facebook.feed.photoreminder;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.photoreminder.model.MediaModel;
import com.facebook.feed.photoreminder.model.MediaModel.MediaType;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Action;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Builder;
import com.facebook.ipc.productionprompts.actionhandler.PromptActionContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.PromptInfo;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.util.VideoPlayerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: admin_panel_view_timeline */
public class PhotoGalleryScrollAdapter extends Adapter<MediaGalleryThumbnailViewHolder> {
    private static final CallerContext f19704a = CallerContext.a(PhotoGalleryScrollAdapter.class, "native_newsfeed");
    private final MediaReminderUtil f19705b;
    public Provider<InlineComposerPromptActionHandler> f19706c;
    public final PhotoReminderPromptActionHandler f19707d;
    private final PromptsExperimentHelper f19708e;
    public final PromptActionContextFactory f19709f;
    public List<MediaModel> f19710g;
    private FbDraweeControllerBuilder f19711h;
    private ResizeOptions f19712i;
    private Context f19713j;
    private int f19714k;
    private LayoutParams f19715l;
    public String f19716m;
    private Drawable f19717n;
    private Drawable f19718o;
    private RelativeLayout.LayoutParams f19719p;
    private ArrayList<Uri> f19720q = new ArrayList();
    public InlineComposerPromptSession f19721r;
    private HashMap<Uri, DraweeController> f19722s;

    /* compiled from: admin_panel_view_timeline */
    public class MediaGalleryThumbnailViewHolder extends ViewHolder implements OnClickListener {
        FbDraweeView f19698l;
        @Nullable
        Uri f19699m;
        MediaType f19700n;
        final /* synthetic */ PhotoGalleryScrollAdapter f19701o;

        public MediaGalleryThumbnailViewHolder(PhotoGalleryScrollAdapter photoGalleryScrollAdapter, View view) {
            this.f19701o = photoGalleryScrollAdapter;
            super(view);
            this.f19698l = (FbDraweeView) view.findViewById(2131562230);
        }

        public final void m22972a(@Nullable Uri uri, MediaType mediaType) {
            this.f19699m = uri;
            this.f19700n = mediaType;
            this.f19698l.setController(PhotoGalleryScrollAdapter.m22975a(this.f19701o, uri));
            this.f19698l.setOnClickListener(this);
        }

        public void onClick(View view) {
            PromptActionContext a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, -738927700);
            PromptActionContextFactory promptActionContextFactory;
            if (this.f19699m == null) {
                promptActionContextFactory = this.f19701o.f19709f;
                a = PromptActionContextFactory.a(this.f19701o.f19716m);
            } else {
                promptActionContextFactory = this.f19701o.f19709f;
                String str = this.f19701o.f19716m;
                int e = e();
                MediaType mediaType = this.f19700n;
                Uri uri = this.f19699m;
                Builder builder = new Builder();
                builder.a = str;
                builder = builder.b(str);
                builder.c = e;
                builder = builder;
                builder.d = mediaType;
                builder = builder;
                builder.e = uri;
                builder = builder;
                builder.b = Action.PHOTO_REMINDER_TAP_ON_MEDIA;
                a = builder.a();
            }
            PhotoGalleryScrollAdapter photoGalleryScrollAdapter = this.f19701o;
            if (1 != 0) {
                ((InlineComposerPromptActionHandler) photoGalleryScrollAdapter.f19706c.get()).a(view, photoGalleryScrollAdapter.f19721r, a);
            } else {
                photoGalleryScrollAdapter.f19707d.a(view, new InlineComposerPromptSession.Builder().a(new PhotoReminderPromptObject(new MediaReminderModel(photoGalleryScrollAdapter.f19710g))).a(PromptInfo.a).a(), a);
            }
            LogUtils.a(305972205, a2);
        }
    }

    /* compiled from: admin_panel_view_timeline */
    enum MediaListItemType {
        PHOTO,
        VIDEO,
        MORE_MEDIA
    }

    /* compiled from: admin_panel_view_timeline */
    class VideoThumbnailViewHolder extends MediaGalleryThumbnailViewHolder {
        FbTextView f19702p;
        final /* synthetic */ PhotoGalleryScrollAdapter f19703q;

        public VideoThumbnailViewHolder(PhotoGalleryScrollAdapter photoGalleryScrollAdapter, View view) {
            this.f19703q = photoGalleryScrollAdapter;
            super(photoGalleryScrollAdapter, view);
            this.f19702p = (FbTextView) view.findViewById(2131567239);
        }

        public final void m22973a(Uri uri, String str) {
            super.m22972a(uri, MediaType.VIDEO);
            this.f19702p.setText(str);
        }
    }

    public final ViewHolder m22977a(ViewGroup viewGroup, int i) {
        View inflate;
        if (i == MediaListItemType.VIDEO.ordinal()) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906961, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906960, viewGroup, false);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131562230);
        fbDraweeView.setAspectRatio(1.0f);
        fbDraweeView.setController(this.f19711h.a(f19704a).s());
        fbDraweeView.setContentDescription(this.f19713j.getResources().getString(2131235709));
        if (i == MediaListItemType.VIDEO.ordinal()) {
            fbDraweeView.setLayoutParams(this.f19719p);
            return new VideoThumbnailViewHolder(this, inflate);
        }
        fbDraweeView.setLayoutParams(this.f19715l);
        return new MediaGalleryThumbnailViewHolder(this, inflate);
    }

    public final void m22978a(ViewHolder viewHolder, int i) {
        Object obj;
        MediaGalleryThumbnailViewHolder mediaGalleryThumbnailViewHolder = (MediaGalleryThumbnailViewHolder) viewHolder;
        FbDraweeView fbDraweeView = mediaGalleryThumbnailViewHolder.f19698l;
        if (this.f19710g.size() == i) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            mediaGalleryThumbnailViewHolder.m22972a(null, MediaType.UNKNOWN);
            ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(this.f19718o, ScaleType.e);
            return;
        }
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).b(this.f19717n);
        MediaModel mediaModel = (MediaModel) this.f19710g.get(i);
        Uri uri = mediaModel.f19772d;
        if (mediaModel.f19770b == MediaType.VIDEO) {
            ((VideoThumbnailViewHolder) mediaGalleryThumbnailViewHolder).m22973a(uri, VideoPlayerUtils.a((int) TimeUnit.MILLISECONDS.toSeconds((long) mediaModel.f19771c)));
        } else {
            mediaGalleryThumbnailViewHolder.m22972a(uri, MediaType.PHOTO);
        }
    }

    @Inject
    public PhotoGalleryScrollAdapter(FbDraweeControllerBuilder fbDraweeControllerBuilder, Context context, MediaReminderUtil mediaReminderUtil, Provider<InlineComposerPromptActionHandler> provider, PhotoReminderPromptActionHandler photoReminderPromptActionHandler, PromptsExperimentHelper promptsExperimentHelper, PromptActionContextFactory promptActionContextFactory) {
        this.f19711h = fbDraweeControllerBuilder;
        this.f19713j = context;
        this.f19705b = mediaReminderUtil;
        this.f19706c = provider;
        this.f19707d = photoReminderPromptActionHandler;
        this.f19708e = promptsExperimentHelper;
        this.f19709f = promptActionContextFactory;
    }

    public final void m22979a(List<MediaModel> list) {
        this.f19714k = this.f19705b.f();
        this.f19710g = list;
        this.f19715l = new LayoutParams(this.f19714k, this.f19714k);
        this.f19719p = new RelativeLayout.LayoutParams(this.f19714k, this.f19714k);
        this.f19717n = new ColorDrawable(this.f19713j.getResources().getColor(2131363103));
        this.f19718o = this.f19713j.getResources().getDrawable(2130841282);
        m22976d();
    }

    public final int aZ_() {
        if (this.f19710g == null) {
            return 0;
        }
        return this.f19710g.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == this.f19710g.size()) {
            return MediaListItemType.MORE_MEDIA.ordinal();
        }
        if (((MediaModel) this.f19710g.get(i)).f19770b == MediaType.VIDEO) {
            return MediaListItemType.VIDEO.ordinal();
        }
        return MediaListItemType.PHOTO.ordinal();
    }

    private void m22976d() {
        if (this.f19722s == null) {
            this.f19722s = new HashMap();
            if (this.f19712i == null) {
                this.f19712i = new ResizeOptions(this.f19714k, this.f19714k);
            }
            for (MediaModel mediaModel : this.f19710g) {
                Uri uri = mediaModel.f19772d;
                this.f19722s.put(uri, m22974a(uri, this.f19712i));
            }
        }
    }

    @Nullable
    public static DraweeController m22975a(@Nullable PhotoGalleryScrollAdapter photoGalleryScrollAdapter, Uri uri) {
        if (uri == null || photoGalleryScrollAdapter.f19722s == null) {
            return null;
        }
        if (photoGalleryScrollAdapter.f19722s.containsKey(uri)) {
            return (DraweeController) photoGalleryScrollAdapter.f19722s.get(uri);
        }
        photoGalleryScrollAdapter.f19722s.put(uri, photoGalleryScrollAdapter.m22974a(uri, photoGalleryScrollAdapter.f19712i));
        return (DraweeController) photoGalleryScrollAdapter.f19722s.get(uri);
    }

    @Nullable
    private DraweeController m22974a(@Nullable Uri uri, @Nullable ResizeOptions resizeOptions) {
        if (uri == null) {
            return null;
        }
        ImageRequestBuilder a = ImageRequestBuilder.a(uri);
        a.d = resizeOptions;
        a = a;
        a.c = true;
        return ((FbDraweeControllerBuilder) this.f19711h.c(a.m())).a(f19704a).s();
    }
}

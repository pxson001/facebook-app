package com.facebook.messaging.composer.triggers;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composer.triggers.ContentSearchResultsView.C11421;
import com.facebook.messaging.composer.triggers.analytics.ContentSearchLogger;
import com.facebook.messaging.media.externalmedia.ExternalMediaGraphQLResult;
import com.facebook.stickers.abtest.StickerContentSearchExperimentAccessor;
import com.facebook.stickers.model.Sticker;
import com.facebook.stickers.ui.StickerUrls;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.media.attachments.MediaResource;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: messenger_inbox_unit_title */
public class ContentSearchResultsAdapter extends Adapter<ContentSearchResultsViewHolder> {
    private static final CallerContext f9832a = CallerContext.a(ContentSearchResultsAdapter.class, "content_search_result");
    public final ContentSearchLogger f9833b;
    private final FbDraweeControllerBuilder f9834c;
    private final LayoutInflater f9835d;
    public final Resources f9836e;
    private final StickerContentSearchExperimentAccessor f9837f;
    private final StickerUrls f9838g;
    public List<ExternalMediaGraphQLResult> f9839h = Collections.emptyList();
    public C11421 f9840i;
    public Drawable f9841j;
    private final OnClickListener f9842k = new C11381(this);
    private final OnLongClickListener f9843l = new C11392(this);

    /* compiled from: messenger_inbox_unit_title */
    class C11381 implements OnClickListener {
        final /* synthetic */ ContentSearchResultsAdapter f9825a;

        C11381(ContentSearchResultsAdapter contentSearchResultsAdapter) {
            this.f9825a = contentSearchResultsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2139193895);
            Object tag = view.getTag();
            int f = ((LayoutParams) view.getLayoutParams()).f();
            if (tag instanceof Sticker) {
                Sticker sticker = (Sticker) tag;
                if (this.f9825a.f9840i != null) {
                    this.f9825a.f9840i.m10398a(sticker, f);
                }
            } else if (tag instanceof MediaResource) {
                MediaResource mediaResource = (MediaResource) tag;
                if (this.f9825a.f9840i != null) {
                    this.f9825a.f9840i.m10399a(mediaResource, f);
                }
            }
            LogUtils.a(-1166065536, a);
        }
    }

    /* compiled from: messenger_inbox_unit_title */
    class C11392 implements OnLongClickListener {
        final /* synthetic */ ContentSearchResultsAdapter f9826a;

        C11392(ContentSearchResultsAdapter contentSearchResultsAdapter) {
            this.f9826a = contentSearchResultsAdapter;
        }

        public boolean onLongClick(View view) {
            if (this.f9826a.f9840i != null) {
                Object tag = view.getTag();
                if (tag instanceof MediaResource) {
                    MediaResource mediaResource = (MediaResource) tag;
                    ((LayoutParams) view.getLayoutParams()).f();
                    return this.f9826a.f9840i.m10400a(mediaResource);
                }
            }
            return false;
        }
    }

    public final void m10395a(ViewHolder viewHolder, final int i) {
        final ContentSearchResultItemView contentSearchResultItemView = (ContentSearchResultItemView) ((ContentSearchResultsViewHolder) viewHolder).a;
        contentSearchResultItemView.setShowErrorVisible(false);
        DraweeView draweeView = contentSearchResultItemView.f9823e;
        final ExternalMediaGraphQLResult externalMediaGraphQLResult = (ExternalMediaGraphQLResult) this.f9839h.get(i);
        ((FbDraweeControllerBuilder) this.f9834c.p().a(f9832a).b(draweeView.getController())).a(new BaseControllerListener(this) {
            final /* synthetic */ ContentSearchResultsAdapter f9830d;

            public final void m10392a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                if (animatable != null) {
                    animatable.start();
                }
                this.f9830d.f9833b.f9933c.b(6815745, externalMediaGraphQLResult.f11610c.hashCode(), (short) 2);
                this.f9830d.f9840i.m10397a(i);
                contentSearchResultItemView.setShowErrorVisible(false);
            }

            public final void m10391a(String str, Object obj) {
                ContentSearchLogger contentSearchLogger = this.f9830d.f9833b;
                String str2 = externalMediaGraphQLResult.f11609b;
                String str3 = externalMediaGraphQLResult.f11610c;
                contentSearchLogger.f9933c.e(6815745, str3.hashCode());
                contentSearchLogger.f9933c.b(6815745, str3.hashCode(), str2);
            }

            public final void m10390a(String str) {
                this.f9830d.f9833b.f9933c.markerCancel(6815745, externalMediaGraphQLResult.f11610c.hashCode());
            }

            public final void m10393b(String str, Throwable th) {
                this.f9830d.f9833b.f9933c.b(6815745, externalMediaGraphQLResult.f11610c.hashCode(), (short) 3);
                this.f9830d.f9833b.m10484c();
                contentSearchResultItemView.setShowErrorVisible(true);
            }
        });
        MediaResource mediaResource = (MediaResource) externalMediaGraphQLResult.f11613f.get(0);
        MediaResource mediaResource2 = (MediaResource) externalMediaGraphQLResult.f11613f.get(1);
        draweeView.setAspectRatio(((float) mediaResource2.j) / ((float) mediaResource2.k));
        switch (getItemViewType(i)) {
            case 0:
                Sticker sticker = externalMediaGraphQLResult.f11611d;
                ImageRequest[] b = this.f9837f.a() ? this.f9838g.b(sticker) : StickerUrls.a(sticker);
                this.f9834c.a(b);
                this.f9833b.m10483a(b, f9832a, externalMediaGraphQLResult.f11609b, externalMediaGraphQLResult.f11610c);
                contentSearchResultItemView.setTag(sticker);
                break;
            case 1:
                MediaResource mediaResource3 = externalMediaGraphQLResult.f11612e;
                ImageRequestBuilder a = ImageRequestBuilder.a(mediaResource2.c);
                ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
                newBuilder.d = true;
                a.e = newBuilder.h();
                ImageRequest m = a.m();
                ((FbDraweeControllerBuilder) this.f9834c.d(ImageRequest.a(mediaResource.c))).c(m);
                this.f9833b.m10482a(m, f9832a, externalMediaGraphQLResult.f11609b, externalMediaGraphQLResult.f11610c);
                contentSearchResultItemView.setTag(mediaResource3);
                break;
            default:
                throw new IllegalStateException("Binding a view that is not a sticker or a media resource");
        }
        draweeView.setController(this.f9834c.s());
    }

    @Inject
    public ContentSearchResultsAdapter(ContentSearchLogger contentSearchLogger, FbDraweeControllerBuilder fbDraweeControllerBuilder, LayoutInflater layoutInflater, Resources resources, StickerContentSearchExperimentAccessor stickerContentSearchExperimentAccessor, StickerUrls stickerUrls) {
        this.f9833b = contentSearchLogger;
        this.f9834c = fbDraweeControllerBuilder;
        this.f9835d = layoutInflater;
        this.f9836e = resources;
        this.f9837f = stickerContentSearchExperimentAccessor;
        this.f9838g = stickerUrls;
    }

    public final void m10396a(List<ExternalMediaGraphQLResult> list) {
        this.f9839h = list;
        notifyDataSetChanged();
    }

    public final ViewHolder m10394a(ViewGroup viewGroup, int i) {
        ContentSearchResultItemView contentSearchResultItemView = (ContentSearchResultItemView) this.f9835d.inflate(2130903789, viewGroup, false);
        Drawable colorDrawable = new ColorDrawable(this.f9836e.getColor(2131362420));
        if (this.f9841j == null) {
            this.f9841j = this.f9836e.getDrawable(2130844043);
        }
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(this.f9841j.getConstantState().newDrawable(), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(this.f9836e);
        genericDraweeHierarchyBuilder.d = 300;
        genericDraweeHierarchyBuilder = genericDraweeHierarchyBuilder;
        genericDraweeHierarchyBuilder.f = colorDrawable;
        GenericDraweeHierarchyBuilder e = genericDraweeHierarchyBuilder.e(ScaleType.c);
        e.l = autoRotateDrawable;
        contentSearchResultItemView.setHierarchy(e.u());
        contentSearchResultItemView.setOnClickListener(this.f9842k);
        contentSearchResultItemView.setOnLongClickListener(this.f9843l);
        switch (i) {
            case 0:
                contentSearchResultItemView.setContentDescription(this.f9836e.getString(2131231708));
                break;
            case 1:
                contentSearchResultItemView.setContentDescription(this.f9836e.getString(2131231711));
                break;
            default:
                throw new IllegalStateException("Illegal view item type, not media or sticker");
        }
        return new ContentSearchResultsViewHolder(contentSearchResultItemView);
    }

    public int getItemViewType(int i) {
        switch (((ExternalMediaGraphQLResult) this.f9839h.get(i)).f11608a) {
            case STICKER:
                return 0;
            case MEDIA_RESOURCE:
                return 1;
            default:
                throw new IllegalStateException("Illegal view item type, not media or sticker");
        }
    }

    public final int aZ_() {
        return this.f9839h.size();
    }
}

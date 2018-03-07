package com.facebook.friendsharing.suggestedcoverphotos.prompt;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.friendsharing.suggestedcoverphotos.abtest.ExperimentsForSuggestedCoverPhotosAbtestModule;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: Profile Pic cannot be saved because bitmap is recycled */
public class CoverPhotoPromptScrollAdapter extends Adapter<CoverPhotoThumbnailViewHolder> {
    public static final CallerContext f24329a = CallerContext.a(CoverPhotoPromptScrollAdapter.class, CoverPhotoPromptScrollAdapter.class.getSimpleName());
    public final int f24330b;
    private final ImmutableList<String> f24331c;
    public final FbDraweeControllerBuilder f24332d;
    public final PromptActionContextFactory f24333e;
    public final InlineComposerPromptSession f24334f;
    public final InlineComposerPromptActionHandler f24335g;
    public final QeAccessor f24336h;
    public Drawable f24337i;
    public Drawable f24338j;

    /* compiled from: Profile Pic cannot be saved because bitmap is recycled */
    public class CoverPhotoThumbnailViewHolder extends ViewHolder {
        final /* synthetic */ CoverPhotoPromptScrollAdapter f24327l;
        private final DraweeView f24328m;

        public CoverPhotoThumbnailViewHolder(CoverPhotoPromptScrollAdapter coverPhotoPromptScrollAdapter, View view) {
            this.f24327l = coverPhotoPromptScrollAdapter;
            super(view);
            this.f24328m = (DraweeView) FindViewUtil.b(view, 2131560815);
        }

        public static void m26519a(@Nullable CoverPhotoThumbnailViewHolder coverPhotoThumbnailViewHolder, final Uri uri, final int i) {
            GenericDraweeHierarchy u = new GenericDraweeHierarchyBuilder(coverPhotoThumbnailViewHolder.f24328m.getResources()).e(ScaleType.g).u();
            FbDraweeControllerBuilder a = coverPhotoThumbnailViewHolder.f24327l.f24332d.p().a(CoverPhotoPromptScrollAdapter.f24329a);
            if (uri != null) {
                ImageRequestBuilder a2 = ImageRequestBuilder.a(uri);
                a2.g = true;
                a2 = a2;
                a2.d = new ResizeOptions(coverPhotoThumbnailViewHolder.f24327l.f24330b, coverPhotoThumbnailViewHolder.f24327l.f24330b);
                a.c(a2.m());
                u.b(coverPhotoThumbnailViewHolder.f24327l.f24338j);
            } else {
                u.a(coverPhotoThumbnailViewHolder.f24327l.f24337i, ScaleType.e);
            }
            coverPhotoThumbnailViewHolder.f24328m.getLayoutParams().height = coverPhotoThumbnailViewHolder.f24327l.f24330b;
            coverPhotoThumbnailViewHolder.f24328m.getLayoutParams().width = coverPhotoThumbnailViewHolder.f24327l.f24330b;
            coverPhotoThumbnailViewHolder.f24328m.setHierarchy(u);
            coverPhotoThumbnailViewHolder.f24328m.setController(a.s());
            coverPhotoThumbnailViewHolder.f24328m.setOnClickListener(new OnClickListener(coverPhotoThumbnailViewHolder) {
                final /* synthetic */ CoverPhotoThumbnailViewHolder f24326c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1476471429);
                    Builder a2 = this.f24326c.f24327l.f24333e.a(this.f24326c.f24327l.f24334f);
                    a2.i = uri;
                    a2 = a2;
                    a2.j = i;
                    this.f24326c.f24327l.f24335g.a(view, this.f24326c.f24327l.f24334f, a2.a());
                    Logger.a(2, EntryType.UI_INPUT_END, 2076747852, a);
                }
            });
        }
    }

    public final void m26521a(ViewHolder viewHolder, int i) {
        CoverPhotoThumbnailViewHolder coverPhotoThumbnailViewHolder = (CoverPhotoThumbnailViewHolder) viewHolder;
        if (i == aZ_() - 1) {
            CoverPhotoThumbnailViewHolder.m26519a(coverPhotoThumbnailViewHolder, null, -2);
        } else {
            CoverPhotoThumbnailViewHolder.m26519a(coverPhotoThumbnailViewHolder, Uri.parse((String) this.f24331c.get(i)), i);
        }
    }

    @Inject
    public CoverPhotoPromptScrollAdapter(@Assisted Integer num, @Assisted InlineComposerPromptSession inlineComposerPromptSession, FbDraweeControllerBuilder fbDraweeControllerBuilder, PromptActionContextFactory promptActionContextFactory, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, Context context, QeAccessor qeAccessor) {
        this.f24330b = num.intValue();
        this.f24332d = fbDraweeControllerBuilder;
        this.f24333e = promptActionContextFactory;
        this.f24335g = inlineComposerPromptActionHandler;
        this.f24334f = inlineComposerPromptSession;
        this.f24336h = qeAccessor;
        this.f24331c = (ImmutableList) Preconditions.checkNotNull(((ProductionPromptObject) inlineComposerPromptSession.a).a.s());
        this.f24337i = context.getResources().getDrawable(2130841282);
        this.f24338j = new ColorDrawable(context.getResources().getColor(2131361957));
    }

    public final ViewHolder m26520a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903816, viewGroup, false);
        inflate.getLayoutParams().width = this.f24330b;
        inflate.getLayoutParams().height = this.f24330b;
        return new CoverPhotoThumbnailViewHolder(this, inflate);
    }

    public final int aZ_() {
        int a = this.f24336h.a(ExperimentsForSuggestedCoverPhotosAbtestModule.f24312f, 8);
        return this.f24331c.size() > a ? a + 1 : this.f24331c.size() + 1;
    }
}

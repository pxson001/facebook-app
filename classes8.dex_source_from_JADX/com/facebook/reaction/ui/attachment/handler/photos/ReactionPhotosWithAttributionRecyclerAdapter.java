package com.facebook.reaction.ui.attachment.handler.photos;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.PageMediaWithAttribution;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionPhotosRecyclerAdapter.ReactionPhotoViewHolder;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: VIEW_PAGE_PROFILE */
public class ReactionPhotosWithAttributionRecyclerAdapter extends ReactionPhotosRecyclerAdapter<ReactionPhotoWithAttributionViewHolder> {
    public static final CallerContext f21003a = CallerContext.a(ReactionPhotosWithAttributionRecyclerAdapter.class, "reaction_dialog_photos");
    public static final CallerContext f21004b = CallerContext.b(ReactionPhotosWithAttributionRecyclerAdapter.class, "privacy");
    public final Locales f21005c;
    public final TimeFormatUtil f21006d;
    public ReactionPhotosHandler f21007e;
    public String f21008f;
    public String f21009g;

    /* compiled from: VIEW_PAGE_PROFILE */
    public class ReactionPhotoWithAttributionViewHolder extends ReactionPhotoViewHolder<PageMediaWithAttribution> {
        final /* synthetic */ ReactionPhotosWithAttributionRecyclerAdapter f20997l;
        private FbDraweeView f20998m;
        private FbRelativeLayout f20999n;
        private FbTextView f21000o;
        private FbTextView f21001p;
        private FbDraweeView f21002q;

        public final void mo1146a(SizeAwareMedia sizeAwareMedia) {
            sizeAwareMedia = (PageMediaWithAttribution) sizeAwareMedia;
            this.f20998m.a(Uri.parse(sizeAwareMedia.bc_().b()), ReactionPhotosWithAttributionRecyclerAdapter.f21003a);
            this.f20998m.setOnClickListener(this.f20997l.f21007e.m24620a(this.f20997l.f21008f, this.f20997l.f21009g, sizeAwareMedia));
            this.f20999n.setVisibility(0);
            this.f21002q.setVisibility(0);
            this.f21000o.setText(sizeAwareMedia.k().b());
            this.f21001p.setText(this.f20997l.f21006d.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, sizeAwareMedia.j() * 1000).toUpperCase(this.f20997l.f21005c.a()));
            this.f21002q.a(Uri.parse(sizeAwareMedia.l().a().a()), ReactionPhotosWithAttributionRecyclerAdapter.f21004b);
        }

        public ReactionPhotoWithAttributionViewHolder(ReactionPhotosWithAttributionRecyclerAdapter reactionPhotosWithAttributionRecyclerAdapter, View view, FbDraweeView fbDraweeView, FbRelativeLayout fbRelativeLayout, FbTextView fbTextView, FbTextView fbTextView2, FbDraweeView fbDraweeView2) {
            this.f20997l = reactionPhotosWithAttributionRecyclerAdapter;
            super(view);
            this.f20998m = fbDraweeView;
            this.f20999n = fbRelativeLayout;
            this.f21000o = fbTextView;
            this.f21001p = fbTextView2;
            this.f21002q = fbDraweeView2;
        }
    }

    @Inject
    public ReactionPhotosWithAttributionRecyclerAdapter(Locales locales, TimeFormatUtil timeFormatUtil, @Assisted ReactionPhotosHandler reactionPhotosHandler, @Assisted ReactionAttachmentsModel reactionAttachmentsModel, @Assisted String str, @Assisted String str2) {
        this.f21005c = locales;
        this.f21006d = timeFormatUtil;
        this.f21007e = reactionPhotosHandler;
        List arrayList = new ArrayList();
        ImmutableList b = reactionAttachmentsModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((EdgesModel) b.get(i)).a().P());
        }
        m24641a(arrayList);
        this.f21008f = str;
        this.f21009g = str2;
    }

    public final ViewHolder m24654a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906608, viewGroup, false);
        int i2 = this.f21007e.m24631i();
        inflate.getLayoutParams().height = i2;
        inflate.getLayoutParams().width = i2;
        return new ReactionPhotoWithAttributionViewHolder(this, inflate, (FbDraweeView) inflate.findViewById(2131566611), (FbRelativeLayout) inflate.findViewById(2131566612), (FbTextView) inflate.findViewById(2131566613), (FbTextView) inflate.findViewById(2131566614), (FbDraweeView) inflate.findViewById(2131566615));
    }
}

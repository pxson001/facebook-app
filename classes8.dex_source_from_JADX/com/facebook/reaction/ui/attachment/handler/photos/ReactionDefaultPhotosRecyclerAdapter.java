package com.facebook.reaction.ui.attachment.handler.photos;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.reaction.ui.attachment.handler.photos.ReactionPhotosRecyclerAdapter.ReactionPhotoViewHolder;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: VIEW_PHOTO_MENU_TAP */
public class ReactionDefaultPhotosRecyclerAdapter extends ReactionPhotosRecyclerAdapter<ReactionDefaultPhotoViewHolder> {
    public static final CallerContext f20985a = CallerContext.a(ReactionDefaultPhotosRecyclerAdapter.class, "reaction_dialog_photos");
    public ReactionPhotosHandler f20986b;
    public String f20987c;
    public String f20988d;

    /* compiled from: VIEW_PHOTO_MENU_TAP */
    public class ReactionDefaultPhotoViewHolder extends ReactionPhotoViewHolder<SizeAwareMedia> {
        final /* synthetic */ ReactionDefaultPhotosRecyclerAdapter f20982l;
        private FbDraweeView f20983m;

        public ReactionDefaultPhotoViewHolder(ReactionDefaultPhotosRecyclerAdapter reactionDefaultPhotosRecyclerAdapter, FbDraweeView fbDraweeView) {
            this.f20982l = reactionDefaultPhotosRecyclerAdapter;
            super(fbDraweeView);
            this.f20983m = fbDraweeView;
        }

        public final void mo1146a(SizeAwareMedia sizeAwareMedia) {
            this.f20983m.a(Uri.parse(sizeAwareMedia.bc_().b()), ReactionDefaultPhotosRecyclerAdapter.f20985a);
            this.f20983m.setOnClickListener(this.f20982l.f20986b.m24620a(this.f20982l.f20987c, this.f20982l.f20988d, sizeAwareMedia));
        }
    }

    public ReactionDefaultPhotosRecyclerAdapter(ReactionPhotosHandler reactionPhotosHandler, ReactionAttachmentsModel reactionAttachmentsModel, String str, String str2) {
        this.f20986b = reactionPhotosHandler;
        List arrayList = new ArrayList();
        ImmutableList b = reactionAttachmentsModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            EdgesModel edgesModel = (EdgesModel) b.get(i);
            if (!(edgesModel.a() == null || edgesModel.a().E() == null || !m24642a(edgesModel.a().E()))) {
                arrayList.add(edgesModel.a().E());
            }
        }
        m24641a(arrayList);
        this.f20987c = str;
        this.f20988d = str2;
    }

    public final ViewHolder m24643a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906607, viewGroup, false);
        int i2 = this.f20986b.m24631i();
        inflate.getLayoutParams().height = i2;
        inflate.getLayoutParams().width = i2;
        return new ReactionDefaultPhotoViewHolder(this, (FbDraweeView) inflate.findViewById(2131566610));
    }

    public static boolean m24642a(@Nullable SizeAwareMedia sizeAwareMedia) {
        return (sizeAwareMedia == null || Strings.isNullOrEmpty(sizeAwareMedia.d()) || sizeAwareMedia.bc_() == null || sizeAwareMedia.bc_().b() == null) ? false : true;
    }
}

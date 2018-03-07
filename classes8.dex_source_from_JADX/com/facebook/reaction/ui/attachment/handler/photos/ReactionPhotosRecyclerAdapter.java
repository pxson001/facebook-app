package com.facebook.reaction.ui.attachment.handler.photos;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VIEW_PORT_VIEWS */
public abstract class ReactionPhotosRecyclerAdapter<VH extends ReactionPhotoViewHolder> extends Adapter<VH> {
    public final List<SizeAwareMedia> f20984a = new ArrayList();

    /* compiled from: VIEW_PORT_VIEWS */
    public abstract class ReactionPhotoViewHolder<P extends SizeAwareMedia> extends ViewHolder {
        abstract void mo1146a(P p);

        public ReactionPhotoViewHolder(View view) {
            super(view);
        }
    }

    public final void m24640a(ViewHolder viewHolder, int i) {
        ((ReactionPhotoViewHolder) viewHolder).mo1146a((SizeAwareMedia) this.f20984a.get(i));
    }

    public final void m24641a(List<? extends SizeAwareMedia> list) {
        int size = this.f20984a.size();
        this.f20984a.addAll(list);
        c(size, list.size());
    }

    public final int aZ_() {
        return this.f20984a.size();
    }
}

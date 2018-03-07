package com.facebook.nearby.v2.resultlist.views;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.List;

/* compiled from: dataProvider was garbage collected */
public class SetSearchPlacePhotoCarouselAdapter extends Adapter<PhotoCarouselViewHolder> {
    private static final CallerContext f15914a = CallerContext.a(SetSearchPlacePhotoCarouselAdapter.class);
    private Context f15915b;
    private int f15916c;
    public List<String> f15917d;
    public OnPhotoClickListener f15918e;

    /* compiled from: dataProvider was garbage collected */
    public interface OnPhotoClickListener {
        void v_(int i);
    }

    /* compiled from: dataProvider was garbage collected */
    public class PhotoCarouselViewHolder extends ViewHolder {
        final /* synthetic */ SetSearchPlacePhotoCarouselAdapter f15910l;
        public FbDraweeView f15911m;
        public int f15912n = 0;
        private final OnClickListener f15913o = new C17051(this);

        /* compiled from: dataProvider was garbage collected */
        class C17051 implements OnClickListener {
            final /* synthetic */ PhotoCarouselViewHolder f15909a;

            C17051(PhotoCarouselViewHolder photoCarouselViewHolder) {
                this.f15909a = photoCarouselViewHolder;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1964608340);
                if (this.f15909a.f15910l.f15918e != null) {
                    this.f15909a.f15910l.f15918e.v_(this.f15909a.f15912n);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 917025315, a);
            }
        }

        public PhotoCarouselViewHolder(SetSearchPlacePhotoCarouselAdapter setSearchPlacePhotoCarouselAdapter, FbDraweeView fbDraweeView) {
            this.f15910l = setSearchPlacePhotoCarouselAdapter;
            super(fbDraweeView);
            this.f15911m = fbDraweeView;
            Resources resources = this.f15911m.getResources();
            this.f15911m.setHierarchy(new GenericDraweeHierarchyBuilder(resources).a(resources.getDrawable(2130842608), ScaleType.g).e(ScaleType.g).u());
            this.f15911m.setOnClickListener(this.f15913o);
        }
    }

    public final void m18769a(ViewHolder viewHolder, int i) {
        PhotoCarouselViewHolder photoCarouselViewHolder = (PhotoCarouselViewHolder) viewHolder;
        photoCarouselViewHolder.f15912n = i;
        if (this.f15917d == null || i < 0 || i >= this.f15917d.size()) {
            photoCarouselViewHolder.f15911m.a(null, f15914a);
            return;
        }
        photoCarouselViewHolder.f15911m.a(Uri.parse((String) this.f15917d.get(i)), f15914a);
    }

    public SetSearchPlacePhotoCarouselAdapter(Context context, int i, OnPhotoClickListener onPhotoClickListener) {
        this.f15915b = context;
        this.f15916c = i;
        this.f15918e = onPhotoClickListener;
    }

    public final int aZ_() {
        return this.f15917d == null ? 0 : this.f15917d.size();
    }

    public final ViewHolder m18768a(ViewGroup viewGroup, int i) {
        FbDraweeView fbDraweeView = new FbDraweeView(this.f15915b);
        fbDraweeView.setLayoutParams(new LayoutParams(this.f15916c, this.f15916c));
        return new PhotoCarouselViewHolder(this, fbDraweeView);
    }
}

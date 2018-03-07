package com.facebook.photos.editgallery;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.util.Pair;
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
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.model.SwipeableParams.SwipeableItemType;
import com.facebook.photos.creativeediting.swipeable.common.FrameImageView;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentController.C08673;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor;
import com.facebook.resources.ui.FbTextView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: lead_gen_deep_link_user_info_create */
public class FilterPickerScrollAdapter extends Adapter<FilterPickerScrollViewHolder> {
    public static final CallerContext f10399a = CallerContext.a(FilterPickerScrollAdapter.class);
    public final ColorDrawable f10400b;
    public final ColorDrawable f10401c;
    public final Context f10402d;
    public final C08673 f10403e;
    public final FbDraweeControllerBuilder f10404f;
    private final ImmutableList<SwipeableParams> f10405g;
    public final PostprocessorFactory f10406h;
    public final SwipeableParamsHelper f10407i;
    public final Uri f10408j;
    public final int f10409k;
    public FilterPickerScrollViewHolder f10410l;
    public int f10411m = -1;

    /* compiled from: lead_gen_deep_link_user_info_create */
    public class FilterPickerScrollViewHolder extends ViewHolder {
        public final /* synthetic */ FilterPickerScrollAdapter f10390l;
        public FbTextView f10391m;
        private View f10392n;

        protected void mo586a(SwipeableParams swipeableParams) {
            this.f10391m.setText(swipeableParams.d);
            View view = this.f10392n;
            final String str = swipeableParams.b;
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FilterPickerScrollViewHolder f10389b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -2117958083);
                    this.f10389b.f10390l.f10403e.m12157a().m11778a(str);
                    if (this.f10389b.f10390l.f10410l != null) {
                        this.f10389b.f10390l.f10410l.m12262x();
                    }
                    FilterPickerScrollAdapter filterPickerScrollAdapter = this.f10389b.f10390l;
                    FilterPickerScrollViewHolder filterPickerScrollViewHolder = this.f10389b;
                    filterPickerScrollViewHolder.f10391m.setBackground(filterPickerScrollViewHolder.f10390l.f10400b);
                    filterPickerScrollViewHolder.f10391m.setTextColor(filterPickerScrollViewHolder.f10390l.f10402d.getResources().getColor(2131361920));
                    filterPickerScrollAdapter.f10410l = filterPickerScrollViewHolder;
                    Logger.a(2, EntryType.UI_INPUT_END, 580450516, a);
                }
            });
            m12262x();
        }

        public FilterPickerScrollViewHolder(FilterPickerScrollAdapter filterPickerScrollAdapter, View view) {
            this.f10390l = filterPickerScrollAdapter;
            super(view);
            this.f10392n = view;
            this.f10391m = (FbTextView) FindViewUtil.b(view, 2131561120);
        }

        protected final void m12262x() {
            if (this.f10391m != null) {
                this.f10391m.setBackground(this.f10390l.f10401c);
                this.f10391m.setTextColor(this.f10390l.f10402d.getResources().getColor(2131361958));
            }
        }

        protected final DraweeController m12259a(Uri uri, @Nullable Postprocessor postprocessor) {
            ImageRequestBuilder a = ImageRequestBuilder.a(uri);
            a.j = postprocessor;
            a = a;
            a.d = new ResizeOptions(this.f10390l.f10409k, this.f10390l.f10409k);
            a = a;
            a.c = true;
            return ((FbDraweeControllerBuilder) this.f10390l.f10404f.p().c(a.m())).a(FilterPickerScrollAdapter.f10399a).s();
        }

        protected final GenericDraweeHierarchy m12261b(boolean z) {
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(this.f10390l.f10402d.getResources()).e(z ? ScaleType.g : ScaleType.c);
            e.d = 0;
            return e.u();
        }
    }

    /* compiled from: lead_gen_deep_link_user_info_create */
    class FilterThumbnailViewHolder extends FilterPickerScrollViewHolder {
        final /* synthetic */ FilterPickerScrollAdapter f10393m;
        private DraweeView f10394n;

        public FilterThumbnailViewHolder(FilterPickerScrollAdapter filterPickerScrollAdapter, View view) {
            this.f10393m = filterPickerScrollAdapter;
            super(filterPickerScrollAdapter, view);
            this.f10394n = (DraweeView) FindViewUtil.b(view, 2131561122);
        }

        protected final void mo586a(SwipeableParams swipeableParams) {
            super.mo586a(swipeableParams);
            Builder builder = new Builder();
            builder.a = swipeableParams.b;
            FiltersRepeatedPostprocessor a = this.f10393m.f10406h.m12267a(builder.a(), UriRequestType.SHOW_ORIGINAL_URI, 0);
            this.f10394n.setHierarchy(m12261b(true));
            this.f10394n.setController(m12259a(this.f10393m.f10408j, a));
        }
    }

    /* compiled from: lead_gen_deep_link_user_info_create */
    class FrameThumbnailViewHolder extends FilterPickerScrollViewHolder {
        final /* synthetic */ FilterPickerScrollAdapter f10395m;
        private DraweeSwipeableItem f10396n;
        private DraweeHolder f10397o;
        private FrameImageView f10398p;

        public FrameThumbnailViewHolder(FilterPickerScrollAdapter filterPickerScrollAdapter, View view) {
            this.f10395m = filterPickerScrollAdapter;
            super(filterPickerScrollAdapter, view);
            this.f10398p = (FrameImageView) FindViewUtil.b(view, 2131561123);
        }

        protected final void mo586a(SwipeableParams swipeableParams) {
            super.mo586a(swipeableParams);
            if (this.f10398p.getDrawable() == null) {
                this.f10397o = DraweeHolder.a(m12261b(true), this.f10395m.f10402d);
                this.f10397o.a(m12259a(this.f10395m.f10408j, null));
                this.f10398p.setImageDrawable(this.f10397o.h());
            }
            this.f10396n = new DraweeSwipeableItem(null, swipeableParams.b);
            ImmutableList a = swipeableParams.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                StickerParams stickerParams = (StickerParams) a.get(i);
                DraweeHolder a2 = DraweeHolder.a(m12261b(false), this.f10395m.f10402d);
                a2.a(m12259a(stickerParams.d(), null));
                DraweeSwipeableItem draweeSwipeableItem = this.f10396n;
                SwipeableParamsHelper swipeableParamsHelper = this.f10395m.f10407i;
                CreativeEditingSwipeableController a3 = this.f10395m.f10403e.m12157a();
                draweeSwipeableItem.a(SwipeableParamsHelper.m11705a(stickerParams, new Pair(Integer.valueOf(a3.f9829u), Integer.valueOf(a3.f9830v))), a2);
            }
            this.f10398p.setSwipeableItem(this.f10396n);
        }
    }

    public final ViewHolder m12265a(ViewGroup viewGroup, int i) {
        if (i == SwipeableItemType.FILTER.ordinal()) {
            return new FilterThumbnailViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903940, viewGroup, false));
        }
        return new FrameThumbnailViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130903941, viewGroup, false));
    }

    public final void m12266a(ViewHolder viewHolder, int i) {
        FilterPickerScrollViewHolder filterPickerScrollViewHolder = (FilterPickerScrollViewHolder) viewHolder;
        filterPickerScrollViewHolder.mo586a((SwipeableParams) this.f10405g.get(i));
        if (this.f10411m == i) {
            filterPickerScrollViewHolder.a.performClick();
        }
    }

    @Inject
    public FilterPickerScrollAdapter(@Assisted Context context, @Assisted Uri uri, @Assisted State state, @Assisted C08673 c08673, FbDraweeControllerBuilder fbDraweeControllerBuilder, PostprocessorFactoryProvider postprocessorFactoryProvider, SwipeableParamsHelper swipeableParamsHelper) {
        this.f10402d = context;
        this.f10404f = fbDraweeControllerBuilder;
        this.f10408j = uri;
        this.f10406h = postprocessorFactoryProvider.m12268a(new ArrayList());
        this.f10403e = c08673;
        this.f10407i = swipeableParamsHelper;
        this.f10405g = state.f10295p;
        this.f10409k = this.f10402d.getResources().getDimensionPixelSize(2131429555);
        this.f10400b = new ColorDrawable(this.f10402d.getResources().getColor(2131361917));
        this.f10401c = new ColorDrawable(this.f10402d.getResources().getColor(2131361871));
    }

    public final int aZ_() {
        return this.f10405g.size();
    }

    public int getItemViewType(int i) {
        return ((SwipeableParams) this.f10405g.get(i)).c.ordinal();
    }
}

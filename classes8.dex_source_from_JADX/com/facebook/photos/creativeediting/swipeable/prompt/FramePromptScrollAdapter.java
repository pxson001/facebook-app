package com.facebook.photos.creativeediting.swipeable.prompt;

import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.common.FrameImageView;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.actionhandlers.FramePromptActionHandler;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: spherical_inline_aspect_ratio */
public class FramePromptScrollAdapter extends Adapter<FrameThumbnailViewHolder> {
    public static final CallerContext f2297a = CallerContext.a(FramePromptScrollAdapter.class, FramePromptScrollAdapter.class.getSimpleName());
    public final FbDraweeControllerBuilder f2298b;
    private final SwipeableParamsHelper f2299c;
    public final int f2300d;
    public final FramePromptActionHandler f2301e;
    public final InlineComposerPromptActionHandler f2302f;
    public final InlineComposerPromptSession f2303g;
    private final FramePackModel f2304h = ((FramePackModel) Preconditions.checkNotNull(((ProductionPromptObject) this.f2303g.a).a.m()));
    private final ImmutableList<SwipeableParams> f2305i = this.f2299c.a(this.f2304h, this.f2300d, this.f2300d);
    public final PromptActionContextFactory f2306j;
    public final PromptsExperimentHelper f2307k;

    /* compiled from: spherical_inline_aspect_ratio */
    public class FrameThumbnailViewHolder extends ViewHolder implements OnClickListener {
        public final /* synthetic */ FramePromptScrollAdapter f2293l;
        public final FrameImageView f2294m;
        public DraweeSwipeableItem f2295n;
        public SwipeableParams f2296o;

        /* compiled from: spherical_inline_aspect_ratio */
        public class C02751 extends BaseControllerListener {
            final /* synthetic */ FrameThumbnailViewHolder f2292a;

            public C02751(FrameThumbnailViewHolder frameThumbnailViewHolder) {
                this.f2292a = frameThumbnailViewHolder;
            }

            public final void m2421a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                super.a(str, (CloseableImage) obj, animatable);
                this.f2292a.f2294m.invalidate();
            }
        }

        public FrameThumbnailViewHolder(FramePromptScrollAdapter framePromptScrollAdapter, View view) {
            this.f2293l = framePromptScrollAdapter;
            super(view);
            view.setOnClickListener(this);
            this.f2294m = (FrameImageView) view.findViewById(2131562230);
            this.f2294m.setActualImageBounds(new RectF(0.0f, 0.0f, (float) framePromptScrollAdapter.f2300d, (float) framePromptScrollAdapter.f2300d));
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -938873492);
            Builder a2 = this.f2293l.f2306j.a(this.f2293l.f2303g);
            a2.f1152g = this.f2296o.b;
            a2 = a2;
            PromptsExperimentHelper promptsExperimentHelper = this.f2293l.f2307k;
            if (1 != 0) {
                this.f2293l.f2302f.a(view, this.f2293l.f2303g, a2.m1383a());
            } else {
                this.f2293l.f2301e.a(view, this.f2293l.f2303g, a2.m1384b(SafeUUIDGenerator.a().toString()).m1383a());
            }
            LogUtils.a(-2039557289, a);
        }
    }

    public final void m2423a(ViewHolder viewHolder, int i) {
        FrameThumbnailViewHolder frameThumbnailViewHolder = (FrameThumbnailViewHolder) viewHolder;
        frameThumbnailViewHolder.f2296o = (SwipeableParams) this.f2305i.get(i);
        frameThumbnailViewHolder.f2295n = new DraweeSwipeableItem(null, "");
        ImmutableList a = frameThumbnailViewHolder.f2296o.a();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            StickerParams stickerParams = (StickerParams) a.get(i2);
            DraweeSwipeableItem draweeSwipeableItem = frameThumbnailViewHolder.f2295n;
            Uri d = stickerParams.d();
            GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(frameThumbnailViewHolder.f2294m.getResources()).e(ScaleType.c);
            e.d = 0;
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = e;
            frameThumbnailViewHolder.f2293l.f2298b.p();
            FbPipelineDraweeController s = ((FbDraweeControllerBuilder) frameThumbnailViewHolder.f2293l.f2298b.b(d).a(f2297a).a(new C02751(frameThumbnailViewHolder))).s();
            DraweeHolder a2 = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), frameThumbnailViewHolder.f2294m.getContext());
            a2.a(s);
            draweeSwipeableItem.a(stickerParams, a2);
        }
        frameThumbnailViewHolder.f2294m.setSwipeableItem(frameThumbnailViewHolder.f2295n);
    }

    @Inject
    public FramePromptScrollAdapter(@Assisted Integer num, @Assisted InlineComposerPromptSession inlineComposerPromptSession, FbDraweeControllerBuilder fbDraweeControllerBuilder, SwipeableParamsHelper swipeableParamsHelper, FramePromptActionHandler framePromptActionHandler, InlineComposerPromptActionHandler inlineComposerPromptActionHandler, PromptActionContextFactory promptActionContextFactory, PromptsExperimentHelper promptsExperimentHelper) {
        this.f2300d = num.intValue();
        this.f2303g = inlineComposerPromptSession;
        this.f2298b = fbDraweeControllerBuilder;
        this.f2299c = swipeableParamsHelper;
        this.f2301e = framePromptActionHandler;
        this.f2302f = inlineComposerPromptActionHandler;
        this.f2306j = promptActionContextFactory;
        this.f2307k = promptsExperimentHelper;
    }

    public final ViewHolder m2422a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130904464, viewGroup, false);
        inflate.getLayoutParams().width = this.f2300d;
        inflate.getLayoutParams().height = this.f2300d;
        return new FrameThumbnailViewHolder(this, inflate);
    }

    public final int aZ_() {
        return this.f2304h.c().size();
    }
}

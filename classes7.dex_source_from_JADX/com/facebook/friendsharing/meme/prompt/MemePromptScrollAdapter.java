package com.facebook.friendsharing.meme.prompt;

import android.content.res.Resources;
import android.net.Uri;
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
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextFactory;
import com.facebook.ipc.productionprompts.actioncontext.PromptActionContextImpl.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.common.InlineComposerPromptActionHandler;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Ridge NUX */
public class MemePromptScrollAdapter extends Adapter<MemeThumbnailViewHolder> {
    public static final CallerContext f23970a = CallerContext.a(MemePromptView.class);
    public int f23971b;
    public ImmutableList<String> f23972c;
    public FbDraweeControllerBuilder f23973d;
    public PromptActionContextFactory f23974e;
    public InlineComposerPromptActionHandler f23975f;
    public InlineComposerPromptSession f23976g;

    /* compiled from: Ridge NUX */
    public class MemeThumbnailViewHolder extends ViewHolder {
        final /* synthetic */ MemePromptScrollAdapter f23968l;
        private final View f23969m;

        public MemeThumbnailViewHolder(MemePromptScrollAdapter memePromptScrollAdapter, View view) {
            this.f23968l = memePromptScrollAdapter;
            super(view);
            this.f23969m = view;
        }

        public final void m26088c(int i) {
            if (i < 3 || (i == 3 && i == this.f23968l.f23972c.size() - 1)) {
                m26086d(i);
            } else {
                m26087e(i);
            }
        }

        private void m26086d(int i) {
            FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(this.f23969m, 2131563798);
            fbDraweeView.getLayoutParams().width = this.f23968l.f23971b;
            fbDraweeView.getLayoutParams().height = this.f23968l.f23971b;
            fbDraweeView.setHierarchy(m26083a(fbDraweeView.getResources()));
            fbDraweeView.setController(m26084a((String) this.f23968l.f23972c.get(i)));
            fbDraweeView.setOnClickListener(m26085b((String) this.f23968l.f23972c.get(i)));
        }

        private void m26087e(int i) {
            MemePromptImageView memePromptImageView = (MemePromptImageView) FindViewUtil.b(this.f23969m, 2131563799);
            memePromptImageView.getLayoutParams().width = this.f23968l.f23971b;
            memePromptImageView.getLayoutParams().height = this.f23968l.f23971b;
            DraweeHolder a = DraweeHolder.a(m26083a(memePromptImageView.getResources()), this.f23969m.getContext());
            a.a(m26084a((String) this.f23968l.f23972c.get(i)));
            memePromptImageView.setImageDrawable(a.h());
            memePromptImageView.setCount(this.f23968l.f23972c.size() - i);
            memePromptImageView.setOnClickListener(m26085b(null));
        }

        private DraweeController m26084a(String str) {
            ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(str));
            a.c = true;
            return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f23968l.f23973d.c(a.m())).a(MemePromptScrollAdapter.f23970a).c(true)).s();
        }

        private static GenericDraweeHierarchy m26083a(Resources resources) {
            return new GenericDraweeHierarchyBuilder(resources).e(ScaleType.g).u();
        }

        private OnClickListener m26085b(@Nullable final String str) {
            return new OnClickListener(this) {
                final /* synthetic */ MemeThumbnailViewHolder f23967b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2046495001);
                    Builder a2 = this.f23967b.f23968l.f23974e.a(this.f23967b.f23968l.f23976g);
                    a2.h = str;
                    this.f23967b.f23968l.f23975f.a(view, this.f23967b.f23968l.f23976g, a2.a());
                    Logger.a(2, EntryType.UI_INPUT_END, 982554678, a);
                }
            };
        }
    }

    public final void m26090a(ViewHolder viewHolder, int i) {
        ((MemeThumbnailViewHolder) viewHolder).m26088c(i);
    }

    @Inject
    public MemePromptScrollAdapter(@Assisted Integer num, @Assisted InlineComposerPromptSession inlineComposerPromptSession, FbDraweeControllerBuilder fbDraweeControllerBuilder, PromptActionContextFactory promptActionContextFactory, InlineComposerPromptActionHandler inlineComposerPromptActionHandler) {
        this.f23971b = num.intValue();
        this.f23972c = (ImmutableList) Preconditions.checkNotNull(((ProductionPromptObject) inlineComposerPromptSession.a).a.r());
        this.f23976g = inlineComposerPromptSession;
        this.f23973d = fbDraweeControllerBuilder;
        this.f23974e = promptActionContextFactory;
        this.f23975f = inlineComposerPromptActionHandler;
    }

    public final ViewHolder m26089a(ViewGroup viewGroup, int i) {
        return new MemeThumbnailViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130905210, viewGroup, false));
    }

    public final int aZ_() {
        return Math.min(this.f23972c.size(), 4);
    }
}

package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.reaction.ui.attachment.handler.photos.AbstractReactionHscrollPhotosHandler;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: WALLFEED_ACTIVATION */
public class ReactionFacepileHscrollHandler extends AbstractReactionHscrollPhotosHandler {
    public static final CallerContext f20853c = CallerContext.a(ReactionFacepileHscrollHandler.class, "reaction_dialog");
    public final ReactionIntentFactory f20854d;
    public final ReactionIntentLauncher f20855e;
    private ReactionFacepileHscrollRecyclerAdapter f20856f;
    private ReactionFacepileScrollListener f20857g;
    public int f20858h;
    public int f20859i;
    public String f20860j;
    public String f20861k;

    /* compiled from: WALLFEED_ACTIVATION */
    public class C22031 implements OnClickListener {
        final /* synthetic */ ReactionProfileFields f20841a;
        final /* synthetic */ String f20842b;
        final /* synthetic */ String f20843c;
        final /* synthetic */ ReactionFacepileHscrollHandler f20844d;

        public C22031(ReactionFacepileHscrollHandler reactionFacepileHscrollHandler, ReactionProfileFields reactionProfileFields, String str, String str2) {
            this.f20844d = reactionFacepileHscrollHandler;
            this.f20841a = reactionProfileFields;
            this.f20842b = str;
            this.f20843c = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1708121287);
            ReactionAttachmentIntent a2 = this.f20844d.f20854d.m22736a(this.f20841a, UnitInteractionType.PROFILE_TAP);
            if (a2 != null) {
                this.f20844d.m22851a(this.f20842b, this.f20843c, a2);
                this.f20844d.f20855e.m24384a(this.f20842b, a2, this.f20844d.m22858c(), this.f20844d.f18821d);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1057982066, a);
        }
    }

    /* compiled from: WALLFEED_ACTIVATION */
    class ReactionFacepileHscrollRecyclerAdapter extends Adapter<ReactionFacepileViewHolder> {
        final /* synthetic */ ReactionFacepileHscrollHandler f20845a;
        private final List<ReactionProfileFields> f20846b = new ArrayList();

        public final void m24485a(ViewHolder viewHolder, int i) {
            ReactionFacepileViewHolder reactionFacepileViewHolder = (ReactionFacepileViewHolder) viewHolder;
            ReactionProfileFields reactionProfileFields = (ReactionProfileFields) this.f20846b.get(i);
            reactionFacepileViewHolder.f20849m.a(Uri.parse(reactionProfileFields.k().b()), ReactionFacepileHscrollHandler.f20853c);
            reactionFacepileViewHolder.f20849m.setOnClickListener(new C22031(reactionFacepileViewHolder.f20848l, reactionProfileFields, reactionFacepileViewHolder.f20848l.f20860j, reactionFacepileViewHolder.f20848l.f20861k));
        }

        public ReactionFacepileHscrollRecyclerAdapter(ReactionFacepileHscrollHandler reactionFacepileHscrollHandler, ReactionAttachmentsModel reactionAttachmentsModel) {
            this.f20845a = reactionFacepileHscrollHandler;
            ImmutableList b = reactionAttachmentsModel.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                EdgesModel edgesModel = (EdgesModel) b.get(i);
                if (edgesModel.a().M() != null) {
                    this.f20846b.add(edgesModel.a().M());
                }
            }
        }

        public final int aZ_() {
            return this.f20846b.size();
        }

        public final ViewHolder m24484a(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906665, viewGroup, false);
            inflate.getLayoutParams().height = m24483d();
            inflate.getLayoutParams().width = m24483d();
            FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131566713);
            fbDraweeView.setAspectRatio(1.0f);
            return new ReactionFacepileViewHolder(this.f20845a, fbDraweeView);
        }

        private int m24483d() {
            return (int) this.f20845a.f18821d.getResources().getDimension(2131431428);
        }
    }

    /* compiled from: WALLFEED_ACTIVATION */
    class ReactionFacepileScrollListener extends OnScrollListener {
        final /* synthetic */ ReactionFacepileHscrollHandler f20847a;

        public ReactionFacepileScrollListener(ReactionFacepileHscrollHandler reactionFacepileHscrollHandler) {
            this.f20847a = reactionFacepileHscrollHandler;
        }

        public final void m24486a(RecyclerView recyclerView, int i, int i2) {
            this.f20847a.f20859i = this.f20847a.f20850a.l();
            View c = this.f20847a.f20850a.c(this.f20847a.f20859i);
            this.f20847a.f20858h = c.getLeft() - this.f20847a.f20852c.getPaddingLeft();
        }
    }

    /* compiled from: WALLFEED_ACTIVATION */
    public class ReactionFacepileViewHolder extends ViewHolder {
        public final /* synthetic */ ReactionFacepileHscrollHandler f20848l;
        public FbDraweeView f20849m;

        public ReactionFacepileViewHolder(ReactionFacepileHscrollHandler reactionFacepileHscrollHandler, FbDraweeView fbDraweeView) {
            this.f20848l = reactionFacepileHscrollHandler;
            super(fbDraweeView);
            this.f20849m = fbDraweeView;
        }
    }

    @Inject
    public ReactionFacepileHscrollHandler(Provider<HScrollLinearLayoutManager> provider, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(provider, reactionIntentLauncher);
        this.f20854d = reactionIntentFactory;
        this.f20855e = reactionIntentLauncher;
    }

    public final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        if (this.f20856f == null) {
            this.f20860j = str;
            this.f20861k = str2;
            this.f20856f = new ReactionFacepileHscrollRecyclerAdapter(this, reactionAttachmentsModel);
            this.f20857g = new ReactionFacepileScrollListener(this);
        }
        RecyclerView recyclerView = this.f20852c;
        recyclerView.setHorizontalScrollBarEnabled(false);
        recyclerView.setAdapter(this.f20856f);
        recyclerView.setOnScrollListener(this.f20857g);
        this.f20850a.d(this.f20859i, this.f20858h);
        return this.f20856f.aZ_();
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.M() == null || reactionStoryAttachmentFragmentModel.M().k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().k().b())) ? false : true;
    }
}

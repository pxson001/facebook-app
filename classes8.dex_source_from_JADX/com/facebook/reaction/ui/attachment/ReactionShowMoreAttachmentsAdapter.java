package com.facebook.reaction.ui.attachment;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionAttachmentListener;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler;
import com.facebook.reaction.common.ReactionRecyclableAttachmentHandler.C20781;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreAttachmentsDataFetcher;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreAttachmentsDataFetcherProvider;
import com.facebook.reaction.ui.datafetcher.ReactionShowMoreDataFetcher.FetcherListener;
import javax.inject.Inject;

/* compiled from: WebViewBlock must have either a non-null source or url */
public class ReactionShowMoreAttachmentsAdapter<VH extends ViewHolder> extends Adapter<VH> implements FetcherListener {
    private final ReactionRecyclableAttachmentHandler<VH> f20785a;
    private final ReactionCardContainer f20786b;
    private final ReactionShowMoreAttachmentsDataFetcher f20787c;
    private final Surface f20788d;
    private boolean f20789e = false;
    private String f20790f;
    private String f20791g;

    /* compiled from: WebViewBlock must have either a non-null source or url */
    class EmptyReactionAttachmentListener implements ReactionAttachmentListener {
        public final void mo981a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        }

        public final void mo980a(String str, String str2) {
        }

        public final void mo979a(String str, int i) {
        }

        public final void mo983b(String str, int i) {
        }

        public final void mo982a(Throwable th) {
        }
    }

    @Inject
    public ReactionShowMoreAttachmentsAdapter(@Assisted ReactionRecyclableAttachmentHandler<VH> reactionRecyclableAttachmentHandler, @Assisted ReactionCardContainer reactionCardContainer, @Assisted String str, @Assisted Surface surface, @Assisted String str2, ReactionShowMoreAttachmentsDataFetcherProvider reactionShowMoreAttachmentsDataFetcherProvider) {
        this.f20785a = reactionRecyclableAttachmentHandler;
        this.f20786b = reactionCardContainer;
        this.f20790f = str;
        this.f20788d = surface;
        this.f20791g = str2;
        this.f20787c = reactionShowMoreAttachmentsDataFetcherProvider.m24726a(reactionRecyclableAttachmentHandler, str2, this, str, surface);
    }

    public final void mo1126d() {
        notifyDataSetChanged();
    }

    public final VH m24428a(ViewGroup viewGroup, int i) {
        if (!this.f20789e) {
            this.f20785a.mo1127a(new EmptyReactionAttachmentListener(), viewGroup, this.f20786b, this.f20790f, this.f20788d, null);
            this.f20789e = true;
        }
        return this.f20785a.mo1131g();
    }

    public final void m24429a(VH vh, int i) {
        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = (ReactionStoryAttachmentFragmentModel) this.f20787c.f21106b.get(i);
        this.f20785a.mo1130a(vh, reactionStoryAttachmentFragmentModel);
        vh.a.setOnClickListener(new C20781(this.f20785a, reactionStoryAttachmentFragmentModel, this.f20791g));
    }

    public final int aZ_() {
        return this.f20787c.f21106b.size();
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final void m24431e() {
        this.f20787c.m24721b();
    }
}

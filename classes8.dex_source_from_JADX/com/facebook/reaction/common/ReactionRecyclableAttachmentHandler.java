package com.facebook.reaction.common;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import javax.annotation.Nullable;

/* compiled from: block_media_type */
public abstract class ReactionRecyclableAttachmentHandler<VH extends ViewHolder> extends ReactionAttachmentHandler {

    /* compiled from: block_media_type */
    public class C20781 implements OnClickListener {
        final /* synthetic */ ReactionStoryAttachmentFragmentModel f18858a;
        final /* synthetic */ String f18859b;
        final /* synthetic */ ReactionRecyclableAttachmentHandler f18860c;

        public C20781(ReactionRecyclableAttachmentHandler reactionRecyclableAttachmentHandler, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, String str) {
            this.f18860c = reactionRecyclableAttachmentHandler;
            this.f18858a = reactionStoryAttachmentFragmentModel;
            this.f18859b = str;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1116301307);
            ReactionAttachmentIntent a2 = this.f18860c.mo1129a(this.f18858a, view);
            if (a2 != null) {
                this.f18860c.mo1138a(this.f18859b, a2, view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 373034803, a);
        }
    }

    public abstract void mo1130a(VH vh, ReactionStoryAttachmentFragment reactionStoryAttachmentFragment);

    public abstract boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel);

    public abstract VH mo1131g();

    public ReactionRecyclableAttachmentHandler(@Nullable ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ViewHolder g = mo1131g();
        mo1130a(g, reactionStoryAttachmentFragmentModel);
        return g.a;
    }
}

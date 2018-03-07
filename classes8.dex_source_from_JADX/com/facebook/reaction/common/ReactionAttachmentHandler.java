package com.facebook.reaction.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.interfaces.ReactionUnitParent;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: boosted_cta_promotions */
public abstract class ReactionAttachmentHandler {
    public ReactionAttachmentListener f18818a;
    private WeakReference<ReactionCardContainer> f18819b;
    public ViewGroup f18820c;
    public Context f18821d;
    private LayoutInflater f18822e;
    private boolean f18823f = false;
    public String f18824g;
    private Surface f18825h;
    private final ReactionIntentLauncher f18826i;
    @Nullable
    public ReactionUnitParent f18827j;

    /* compiled from: boosted_cta_promotions */
    public final class AttachmentClickListener implements OnClickListener {
        final /* synthetic */ ReactionAttachmentHandler f18814a;
        private final String f18815b;
        private final String f18816c;
        private final ReactionStoryAttachmentFragmentModel f18817d;

        public AttachmentClickListener(ReactionAttachmentHandler reactionAttachmentHandler, String str, String str2, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
            this.f18814a = reactionAttachmentHandler;
            this.f18815b = str;
            this.f18816c = str2;
            this.f18817d = reactionStoryAttachmentFragmentModel;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -186622537);
            ReactionAttachmentIntent a2 = this.f18814a.mo1129a(this.f18817d, view);
            if (a2 != null) {
                this.f18814a.m22851a(this.f18815b, this.f18816c, a2);
                this.f18814a.mo1138a(this.f18815b, a2, view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1129716353, a);
        }
    }

    public abstract View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel);

    @Nullable
    protected abstract ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view);

    public abstract boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel);

    public ReactionAttachmentHandler(ReactionIntentLauncher reactionIntentLauncher) {
        this.f18826i = reactionIntentLauncher;
    }

    public void mo1127a(ReactionAttachmentListener reactionAttachmentListener, ViewGroup viewGroup, @Nullable ReactionCardContainer reactionCardContainer, String str, Surface surface, @Nullable ReactionUnitParent reactionUnitParent) {
        this.f18818a = reactionAttachmentListener;
        this.f18819b = new WeakReference(reactionCardContainer);
        this.f18820c = viewGroup;
        this.f18821d = viewGroup.getContext();
        this.f18822e = LayoutInflater.from(this.f18821d);
        this.f18824g = str;
        this.f18825h = surface;
        this.f18827j = reactionUnitParent;
        this.f18823f = true;
    }

    public boolean mo1135a(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        Preconditions.checkState(this.f18823f);
        int b = mo1128b(str, str2, reactionAttachmentsModel);
        if (b <= 0) {
            return false;
        }
        m22850a(str, str2, b, b);
        return true;
    }

    public boolean mo1136a() {
        Preconditions.checkState(this.f18823f);
        return false;
    }

    public boolean mo1140a(ReactionAttachmentsModel reactionAttachmentsModel) {
        ImmutableList b = reactionAttachmentsModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionStoryAttachmentFragmentModel a = ((EdgesModel) b.get(i)).a();
            if (a == null || !mo1119b(a)) {
                return false;
            }
        }
        return true;
    }

    protected int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        ImmutableList b = reactionAttachmentsModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionStoryAttachmentFragmentModel a = ((EdgesModel) b.get(i)).a();
            if (a == null || !mo1119b(a)) {
                return 0;
            }
            View a2 = mo1118a(a);
            if (a2 == null) {
                return 0;
            }
            a2.setOnClickListener(new AttachmentClickListener(this, str, str2, a));
            mo1132a(a2);
        }
        return b.size();
    }

    public void mo1138a(String str, ReactionAttachmentIntent reactionAttachmentIntent, View view) {
        this.f18826i.m24384a(str, reactionAttachmentIntent, m22858c(), this.f18821d);
    }

    protected void mo1132a(View view) {
        this.f18820c.addView(view);
    }

    @Nullable
    public final ReactionCardContainer m22858c() {
        return (ReactionCardContainer) this.f18819b.get();
    }

    protected final String m22843a(long j) {
        Context context = this.f18821d;
        TimeFormatStyle timeFormatStyle = TimeFormatStyle.STREAM_RELATIVE_STYLE;
        long j2 = 1000 * j;
        if (DefaultTimeFormatUtil.b == null) {
            DefaultTimeFormatUtil.b = (TimeFormatUtil) DefaultTimeFormatUtil.a(FbInjector.get(context));
        }
        return DefaultTimeFormatUtil.b.a(timeFormatStyle, j2);
    }

    protected final Context m22859d() {
        return this.f18821d;
    }

    public final void m22851a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f18818a.mo981a(str, str2, reactionAttachmentIntent);
    }

    public final void m22849a(String str, String str2) {
        this.f18818a.mo980a(str, str2);
    }

    public final void m22847a(String str, int i) {
        this.f18818a.mo979a(str, i);
    }

    public final void m22850a(String str, String str2, int i, int i2) {
        this.f18818a.mo983b(str, i2);
    }

    public final View m22840a(int i) {
        return this.f18822e.inflate(i, this.f18820c, false);
    }

    protected final void m22845a(View view, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ImmutableList b = reactionStoryAttachmentFragmentModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel = (ReactionAttachmentActionFragmentModel) b.get(i);
            ImmutableList fF_ = reactionAttachmentActionFragmentModel.fF_();
            if (fF_ != null) {
                int size2 = fF_.size();
                int i2 = 0;
                while (i2 < size2) {
                    if (!mo1134a(view, reactionStoryAttachmentFragmentModel, reactionAttachmentActionFragmentModel, (GraphQLReactionStoryAttachmentActionStyle) fF_.get(i2))) {
                        i2++;
                    } else {
                        return;
                    }
                }
                continue;
            }
        }
    }

    protected boolean mo1134a(View view, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel, GraphQLReactionStoryAttachmentActionStyle graphQLReactionStoryAttachmentActionStyle) {
        return false;
    }
}

package com.facebook.reaction.feed.unitcomponents.util;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.layout.ViewGroupWithDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionCommonFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: You must inherit from ReactionRecyclableAttachmentHandler to use this fragment */
public class ReactionOpenBottomActionSheetHelper {
    private final ReactionActionHandler f20711a;

    /* compiled from: You must inherit from ReactionRecyclableAttachmentHandler to use this fragment */
    class BottomSheetDialogItem {
        public final ReactionStoryAttachmentActionCommonFragment f20702a;
        public final ReactionAttachmentIntent f20703b;

        public BottomSheetDialogItem(ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment, ReactionAttachmentIntent reactionAttachmentIntent) {
            this.f20702a = reactionStoryAttachmentActionCommonFragment;
            this.f20703b = reactionAttachmentIntent;
        }
    }

    /* compiled from: You must inherit from ReactionRecyclableAttachmentHandler to use this fragment */
    class ReactionBottomMenuAdapter extends Adapter<ItemViewHolder> {
        private final ImmutableList<BottomSheetDialogItem> f20706a;
        public final CanLaunchReactionIntent f20707b;
        private final LayoutInflater f20708c;
        public final String f20709d;
        public final String f20710e;

        /* compiled from: You must inherit from ReactionRecyclableAttachmentHandler to use this fragment */
        public class ItemViewHolder extends ViewHolder {
            public ItemViewHolder(ContentView contentView) {
                super(contentView);
            }
        }

        public final void m24366a(ViewHolder viewHolder, int i) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
            Uri uri = null;
            final BottomSheetDialogItem bottomSheetDialogItem = (BottomSheetDialogItem) this.f20706a.get(i);
            ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment = bottomSheetDialogItem.f20702a;
            ViewGroupWithDraweeView viewGroupWithDraweeView = (ContentView) itemViewHolder.a;
            CharSequence a = reactionStoryAttachmentActionCommonFragment.g() == null ? null : reactionStoryAttachmentActionCommonFragment.g().a();
            if (reactionStoryAttachmentActionCommonFragment.d() != null) {
                uri = Uri.parse(reactionStoryAttachmentActionCommonFragment.d().b());
            }
            if (uri != null) {
                viewGroupWithDraweeView.setThumbnailUri(uri);
                viewGroupWithDraweeView.setShowThumbnail(true);
            } else {
                viewGroupWithDraweeView.setShowThumbnail(false);
            }
            viewGroupWithDraweeView.setTitleText(reactionStoryAttachmentActionCommonFragment.fU_().a());
            viewGroupWithDraweeView.setSubtitleText(a);
            viewGroupWithDraweeView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ReactionBottomMenuAdapter f20705b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -56423745);
                    this.f20705b.f20707b.mo695a(this.f20705b.f20709d, this.f20705b.f20710e, bottomSheetDialogItem.f20703b);
                    Logger.a(2, EntryType.UI_INPUT_END, -273945440, a);
                }
            });
        }

        public ReactionBottomMenuAdapter(Context context, ImmutableList<BottomSheetDialogItem> immutableList, CanLaunchReactionIntent canLaunchReactionIntent, String str, String str2) {
            this.f20709d = str;
            this.f20710e = str2;
            this.f20708c = LayoutInflater.from(context);
            this.f20706a = immutableList;
            this.f20707b = canLaunchReactionIntent;
        }

        public final ViewHolder m24365a(ViewGroup viewGroup, int i) {
            return new ItemViewHolder((ContentView) this.f20708c.inflate(2130906588, viewGroup, false));
        }

        public final int aZ_() {
            return this.f20706a.size();
        }
    }

    @Inject
    public ReactionOpenBottomActionSheetHelper(ReactionActionHandler reactionActionHandler) {
        this.f20711a = reactionActionHandler;
    }

    public final void m24367a(@Nullable ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, CanLaunchReactionIntent canLaunchReactionIntent, Context context, HasReactionInteractionTracker hasReactionInteractionTracker, HasReactionSession hasReactionSession, String str, String str2) {
        if (reactionStoryAttachmentActionFragmentModel != null && !reactionStoryAttachmentActionFragmentModel.ae().isEmpty()) {
            Builder builder = ImmutableList.builder();
            ImmutableList ae = reactionStoryAttachmentActionFragmentModel.ae();
            int size = ae.size();
            for (int i = 0; i < size; i++) {
                ReactionStoryAttachmentActionCommonFragment reactionStoryAttachmentActionCommonFragment = (ReactionStoryAttachmentActionCommonFragment) ae.get(i);
                if (!(reactionStoryAttachmentActionCommonFragment.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionCommonFragment.fU_().a()))) {
                    ReactionAttachmentIntent a = this.f20711a.m22676a(reactionStoryAttachmentActionCommonFragment, context, reactionStoryAttachmentActionCommonFragment.fU_().a(), hasReactionSession.mo704p().m22562f(), hasReactionSession.mo704p().m22575w(), str);
                    if (a != null) {
                        builder.c(new BottomSheetDialogItem(reactionStoryAttachmentActionCommonFragment, a));
                    }
                }
            }
            ImmutableList b = builder.b();
            if (!b.isEmpty()) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
                bottomSheetDialog.a(new ReactionBottomMenuAdapter(context, b, canLaunchReactionIntent, str, str2));
                bottomSheetDialog.show();
                hasReactionInteractionTracker.kE_().mo984a(str, str2, null, UnitInteractionType.OPEN_VERTICAL_ACTION_SHEET_TAP);
            }
        }
    }
}

package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: Video parameters were not retrieved */
public class ReactionPageYouMayLikeHscrollHandler extends AbstractReactionHscrollHandler {
    private static final CallerContext f20904b = CallerContext.a(ReactionPageYouMayLikeHscrollHandler.class, "reaction_dialog", "PROFILE_PHOTO");
    private final ReactionIntentFactory f20905c;
    public final RawLikeHelper f20906d;
    public final HashMap<String, Boolean> f20907e = new HashMap();

    @Inject
    public ReactionPageYouMayLikeHscrollHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionUtil reactionUtil, RawLikeHelper rawLikeHelper) {
        super(reactionIntentFactory, reactionIntentLauncher, reactionUtil);
        this.f20905c = reactionIntentFactory;
        this.f20906d = rawLikeHelper;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.M() == null || reactionStoryAttachmentFragmentModel.M().k() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().k().b()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().eL_()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.M().j())) ? false : true;
    }

    protected final View mo1118a(final ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906602);
        FbDraweeView fbDraweeView = (FbDraweeView) a.findViewById(2131566590);
        FbTextView fbTextView = (FbTextView) a.findViewById(2131566591);
        FbTextView fbTextView2 = (FbTextView) a.findViewById(2131566604);
        final GlyphView glyphView = (GlyphView) a.findViewById(2131566595);
        if (!this.f20907e.containsKey(reactionStoryAttachmentFragmentModel.M().eL_())) {
            this.f20907e.put(reactionStoryAttachmentFragmentModel.M().eL_(), Boolean.valueOf(reactionStoryAttachmentFragmentModel.M().eK_()));
        }
        glyphView.setSelected(((Boolean) this.f20907e.get(reactionStoryAttachmentFragmentModel.M().eL_())).booleanValue());
        glyphView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReactionPageYouMayLikeHscrollHandler f20903c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -379368973);
                final boolean booleanValue = ((Boolean) this.f20903c.f20907e.get(reactionStoryAttachmentFragmentModel.M().eL_())).booleanValue();
                final boolean z = !booleanValue;
                this.f20903c.f20906d.a(reactionStoryAttachmentFragmentModel.M().eL_(), z, null, "reaction_dialog", null, null, null, true, new MutationCallback<String>(this) {
                    final /* synthetic */ C22101 f20900c;

                    public final /* bridge */ /* synthetic */ void m24539b(Object obj) {
                    }

                    public final /* bridge */ /* synthetic */ void m24540c(Object obj) {
                    }

                    public final void m24537a(Object obj) {
                        this.f20900c.f20903c.f20907e.put(reactionStoryAttachmentFragmentModel.M().eL_(), Boolean.valueOf(z));
                        glyphView.setSelected(z);
                    }

                    public final void m24538a(Object obj, ServiceException serviceException) {
                        this.f20900c.f20903c.f20907e.put(reactionStoryAttachmentFragmentModel.M().eL_(), Boolean.valueOf(booleanValue));
                        glyphView.setSelected(booleanValue);
                    }
                });
                if (z) {
                    this.f20903c.m24448g();
                }
                LogUtils.a(467846319, a);
            }
        });
        fbDraweeView.a(Uri.parse(reactionStoryAttachmentFragmentModel.M().k().b()), f20904b);
        fbDraweeView.setAspectRatio(1.9f);
        fbTextView.setText(reactionStoryAttachmentFragmentModel.M().j());
        if (reactionStoryAttachmentFragmentModel.k() != null) {
            fbTextView2.setText(reactionStoryAttachmentFragmentModel.k().a());
        }
        return a;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return this.f20905c.m22731a(view.getContext(), reactionStoryAttachmentFragmentModel.M().eL_(), reactionStoryAttachmentFragmentModel.M().j(), UnitInteractionType.PROFILE_TAP);
    }
}

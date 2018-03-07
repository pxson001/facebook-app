package com.facebook.reaction.ui.attachment.handler;

import android.view.View;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionView;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionViewController;
import com.facebook.crowdsourcing.placequestion.PlaceQuestionViewController.PlaceQuestionInteractionListener;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionAnswerFieldsModel;
import com.facebook.crowdsourcing.protocol.graphql.PlaceQuestionFragmentsModels.PlaceQuestionFieldsModel;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/* compiled from: Video ad fetcher returns no data model */
public abstract class ReactionPlaceQuestionAbstractHandler extends ReactionAttachmentHandler {
    protected final PlaceQuestionViewController f20909a;
    public String f20910b;
    public String f20911c;

    /* compiled from: Video ad fetcher returns no data model */
    class C22111 implements PlaceQuestionInteractionListener {
        final /* synthetic */ ReactionPlaceQuestionAbstractHandler f20908a;

        C22111(ReactionPlaceQuestionAbstractHandler reactionPlaceQuestionAbstractHandler) {
            this.f20908a = reactionPlaceQuestionAbstractHandler;
        }

        public final void m24544e() {
            if (this.f20908a.f18827j != null) {
                this.f20908a.f18827j.ko_();
                this.f20908a.f18827j.m4775b();
            }
            this.f20908a.m22851a(this.f20908a.f20910b, this.f20908a.f20911c, new ReactionAttachmentIntent(null, UnitInteractionType.QUESTION_ANSWER_TAP));
        }

        public final void m24545f() {
            if (this.f20908a.f18827j != null) {
                this.f20908a.f18827j.ko_();
                this.f20908a.f18827j.m4775b();
            }
            this.f20908a.m22851a(this.f20908a.f20910b, this.f20908a.f20911c, new ReactionAttachmentIntent(null, UnitInteractionType.QUESTION_SKIP_TAP));
        }
    }

    protected abstract int mo1137g();

    public ReactionPlaceQuestionAbstractHandler(PlaceQuestionViewController placeQuestionViewController, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20909a = placeQuestionViewController;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20910b = str;
        this.f20911c = str2;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        PlaceQuestionView placeQuestionView = (PlaceQuestionView) m22840a(2130906705);
        this.f20909a.a(placeQuestionView, reactionStoryAttachmentFragmentModel.H(), mo1137g(), new C22111(this));
        return placeQuestionView;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        boolean z;
        PlaceQuestionFieldsModel H = reactionStoryAttachmentFragmentModel.H();
        if (H == null || H.b() == null || H.j() == null || Strings.isNullOrEmpty(H.j().a())) {
            z = false;
        } else {
            ImmutableList c = H.c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                Object obj;
                PlaceQuestionAnswerFieldsModel placeQuestionAnswerFieldsModel = (PlaceQuestionAnswerFieldsModel) c.get(i);
                if (placeQuestionAnswerFieldsModel.a() == null || Strings.isNullOrEmpty(placeQuestionAnswerFieldsModel.a().a()) || Strings.isNullOrEmpty(placeQuestionAnswerFieldsModel.b())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj == null) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        return z;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    public final boolean mo1136a() {
        return true;
    }
}

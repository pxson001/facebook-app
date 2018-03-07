package com.facebook.reaction.ui.attachment.handler;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.contentview.ContentViewWithButton.Theme;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentActionStyle;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionFeedbackFieldsModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLModels.ReactionStoryAttachmentStoryFragmentModel.ActorsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoriesActionFieldsModel.StoriesModel;
import com.facebook.reaction.protocol.graphql.ReactionConversionHelper;
import com.facebook.ui.touchlistener.HighlightViewOnTouchListener;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import java.util.HashMap;
import javax.inject.Inject;

/* compiled from: VIEW_STRUCTURE_MENU_TAP */
public class ReactionTodayGenericProfileHandler extends ReactionProfileStoryHandler {
    private GlyphColorizer f20958a;
    public RawLikeHelper f20959b;
    public HashMap<String, Boolean> f20960c = new HashMap();

    /* compiled from: VIEW_STRUCTURE_MENU_TAP */
    public class C22222 implements MutationCallback<String> {
        final /* synthetic */ ReactionFeedbackFieldsModel f20954a;
        final /* synthetic */ boolean f20955b;
        final /* synthetic */ ContentViewWithButton f20956c;
        final /* synthetic */ ReactionTodayGenericProfileHandler f20957d;

        public C22222(ReactionTodayGenericProfileHandler reactionTodayGenericProfileHandler, ReactionFeedbackFieldsModel reactionFeedbackFieldsModel, boolean z, ContentViewWithButton contentViewWithButton) {
            this.f20957d = reactionTodayGenericProfileHandler;
            this.f20954a = reactionFeedbackFieldsModel;
            this.f20955b = z;
            this.f20956c = contentViewWithButton;
        }

        public final /* bridge */ /* synthetic */ void m24599a(Object obj) {
        }

        public final void m24600a(Object obj, ServiceException serviceException) {
            boolean z;
            boolean z2 = true;
            HashMap hashMap = this.f20957d.f20960c;
            String d = this.f20954a.d();
            if (this.f20955b) {
                z = false;
            } else {
                z = true;
            }
            hashMap.put(d, Boolean.valueOf(z));
            ContentViewWithButton contentViewWithButton = this.f20956c;
            ReactionTodayGenericProfileHandler reactionTodayGenericProfileHandler = this.f20957d;
            if (this.f20955b) {
                z2 = false;
            }
            contentViewWithButton.setActionButtonDrawable(ReactionTodayGenericProfileHandler.m24603a(reactionTodayGenericProfileHandler, z2));
        }

        public final /* bridge */ /* synthetic */ void m24601b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m24602c(Object obj) {
        }
    }

    @Inject
    public ReactionTodayGenericProfileHandler(GlyphColorizer glyphColorizer, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, RawLikeHelper rawLikeHelper) {
        super(reactionIntentFactory, reactionIntentLauncher);
        this.f20958a = glyphColorizer;
        this.f20959b = rawLikeHelper;
    }

    protected final void mo1139a(View view, ActorsModel actorsModel) {
        if (actorsModel.c() != null && actorsModel.c().b() != null) {
            ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
            contentViewWithButton.setThumbnailUri(actorsModel.c().b());
            contentViewWithButton.setThumbnailPlaceholderResource(2131361970);
        }
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        ReactionStoryAttachmentStoryFragmentModel W = reactionStoryAttachmentFragmentModel.W();
        ActorsModel actorsModel = (ActorsModel) W.b().get(0);
        View view = (ContentViewWithButton) m22840a(2130906593);
        view.setShowActionButton(false);
        view.setActionButtonTheme(Theme.NONE);
        view.setMetaText(m22843a(W.d()));
        mo1139a(view, actorsModel);
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view.getTitleView();
        textWithEntitiesView.a(ReactionConversionHelper.a(reactionStoryAttachmentFragmentModel.z()), textWithEntitiesView.getTextSize(), 0);
        m22845a(view, reactionStoryAttachmentFragmentModel);
        view.setOnTouchListener(new HighlightViewOnTouchListener());
        return view;
    }

    protected final boolean mo1134a(View view, ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, ReactionAttachmentActionFragmentModel reactionAttachmentActionFragmentModel, GraphQLReactionStoryAttachmentActionStyle graphQLReactionStoryAttachmentActionStyle) {
        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        if (!(!graphQLReactionStoryAttachmentActionStyle.equals(GraphQLReactionStoryAttachmentActionStyle.LIKE_STORY) || reactionAttachmentActionFragmentModel.d().isEmpty() || ((StoriesModel) reactionAttachmentActionFragmentModel.d().get(0)).a() == null)) {
            final ReactionFeedbackFieldsModel a = ((StoriesModel) reactionAttachmentActionFragmentModel.d().get(0)).a();
            if (a.b()) {
                contentViewWithButton.setShowActionButton(true);
                contentViewWithButton.setActionButtonContentDescription(contentViewWithButton.getResources().getString(2131237288));
                contentViewWithButton.setActionButtonDrawable(m24603a(this, a.c()));
                contentViewWithButton.setActionButtonOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ReactionTodayGenericProfileHandler f20953b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -426772825);
                        ReactionTodayGenericProfileHandler reactionTodayGenericProfileHandler = this.f20953b;
                        ReactionFeedbackFieldsModel reactionFeedbackFieldsModel = a;
                        boolean z = true;
                        ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view.getParent();
                        if (reactionTodayGenericProfileHandler.f20960c.containsKey(reactionFeedbackFieldsModel.d())) {
                            if (((Boolean) reactionTodayGenericProfileHandler.f20960c.get(reactionFeedbackFieldsModel.d())).booleanValue()) {
                                z = false;
                            }
                        } else if (reactionFeedbackFieldsModel.c()) {
                            z = false;
                        }
                        reactionTodayGenericProfileHandler.f20960c.put(reactionFeedbackFieldsModel.d(), Boolean.valueOf(z));
                        contentViewWithButton.setActionButtonDrawable(ReactionTodayGenericProfileHandler.m24603a(reactionTodayGenericProfileHandler, z));
                        Builder builder = new Builder();
                        builder.v = reactionFeedbackFieldsModel.d();
                        builder = builder;
                        builder.A = reactionFeedbackFieldsModel.eF_();
                        GraphQLFeedback a2 = builder.j(z).f(reactionFeedbackFieldsModel.b()).a();
                        FeedbackLoggingParams.Builder builder2 = new FeedbackLoggingParams.Builder();
                        builder2.c = "reaction_dialog";
                        reactionTodayGenericProfileHandler.f20959b.a(reactionFeedbackFieldsModel.eF_(), z, a2, builder2.a(), new C22222(reactionTodayGenericProfileHandler, reactionFeedbackFieldsModel, z, contentViewWithButton));
                        Logger.a(2, EntryType.UI_INPUT_END, -1335817877, a);
                    }
                });
                return true;
            }
        }
        return false;
    }

    public static Drawable m24603a(ReactionTodayGenericProfileHandler reactionTodayGenericProfileHandler, boolean z) {
        return z ? reactionTodayGenericProfileHandler.f20958a.a(2130841052, -10972929) : reactionTodayGenericProfileHandler.f18821d.getResources().getDrawable(2130841052);
    }
}

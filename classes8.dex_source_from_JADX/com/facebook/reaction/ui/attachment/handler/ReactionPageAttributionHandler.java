package com.facebook.reaction.ui.attachment.handler;

import android.net.Uri;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.GetEntityFbLinkGraphQL;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentHandler;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView.LinkableEntityListener;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: View/Launch view intent FB URIs a.k.a. segues */
public class ReactionPageAttributionHandler extends ReactionAttachmentHandler {
    public ReactionIntentFactory f20884a;
    public ReactionIntentLauncher f20885b;
    public String f20886c;
    public String f20887d;

    /* compiled from: View/Launch view intent FB URIs a.k.a. segues */
    class C22081 implements LinkableEntityListener {
        final /* synthetic */ ReactionPageAttributionHandler f20883a;

        C22081(ReactionPageAttributionHandler reactionPageAttributionHandler) {
            this.f20883a = reactionPageAttributionHandler;
        }

        public final void m24513a(GetEntityFbLinkGraphQL getEntityFbLinkGraphQL) {
            ReactionAttachmentIntent reactionAttachmentIntent;
            String a = this.f20883a.f20884a.f18783f.a(getEntityFbLinkGraphQL);
            if (Strings.isNullOrEmpty(a)) {
                reactionAttachmentIntent = null;
            } else {
                reactionAttachmentIntent = ReactionIntentFactory.m22690a(Uri.parse(a), UnitInteractionType.TEXT_ENTITY_TAP);
            }
            ReactionAttachmentIntent reactionAttachmentIntent2 = reactionAttachmentIntent;
            if (reactionAttachmentIntent2 != null) {
                if (!(this.f20883a.m22858c() == null || this.f20883a.m22858c().getInteractionTracker() == null)) {
                    this.f20883a.m22858c().getInteractionTracker().mo981a(this.f20883a.f20886c, this.f20883a.f20887d, reactionAttachmentIntent2);
                }
                this.f20883a.f20885b.m24384a(this.f20883a.f20886c, reactionAttachmentIntent2, this.f20883a.m22858c(), this.f20883a.f18821d);
            }
        }
    }

    @Inject
    public ReactionPageAttributionHandler(ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher) {
        super(reactionIntentLauncher);
        this.f20884a = reactionIntentFactory;
        this.f20885b = reactionIntentLauncher;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        this.f20886c = str;
        this.f20887d = str2;
        return super.mo1128b(str, str2, reactionAttachmentsModel);
    }

    protected final View mo1118a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        View a = m22840a(2130906591);
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) a.findViewById(2131566588);
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) a.findViewById(2131566587);
        Object b = reactionStoryAttachmentFragmentModel.g().b();
        if (!StringUtil.a(b)) {
            imageBlockLayout.setThumbnailUri(b);
        }
        textWithEntitiesView.a(reactionStoryAttachmentFragmentModel.g().a(), new C22081(this));
        return a;
    }

    protected final ReactionAttachmentIntent mo1129a(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel, View view) {
        return null;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return (reactionStoryAttachmentFragmentModel.g() == null || reactionStoryAttachmentFragmentModel.g().a() == null) ? false : true;
    }
}

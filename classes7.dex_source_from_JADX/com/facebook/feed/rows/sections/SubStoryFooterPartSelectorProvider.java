package com.facebook.feed.rows.sections;

import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.feedbackreactions.ReactionsFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterPartDefinition;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: [createLinkStoryAttachmentFromComposerShareParams] sharePreview empty */
public class SubStoryFooterPartSelectorProvider extends AbstractAssistedProvider<SubStoryFooterPartSelector> {
    public final SubStoryFooterPartSelector m23560a(FooterLevel footerLevel) {
        return new SubStoryFooterPartSelector(GraphQLStoryUtil.a(this), ReactionsFooterPartDefinition.a(this), FooterPartDefinition.a(this), (SubStoryFooterPartDefinitionProvider) getOnDemandAssistedProviderForStaticDi(SubStoryFooterPartDefinitionProvider.class), footerLevel);
    }
}

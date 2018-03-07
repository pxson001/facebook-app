package com.facebook.feed.rows.sections;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.feedbackreactions.ReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

/* compiled from: [createPrivacyScopeFromComposerPrivacyData] selectedLegacyGraphApiPrivacyJson empty */
public class SubStoryFooterPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private final SubStoryFooterPartDefinition<ReactionsFooterView> f20469a;
    private final SubStoryFooterPartDefinition f20470b;
    private final GraphQLStoryUtil f20471c;

    public final Object m23558a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20469a, feedProps).a(this.f20470b, feedProps);
        return null;
    }

    public final boolean m23559a(Object obj) {
        return this.f20471c.c((FeedProps) obj);
    }

    @Inject
    public SubStoryFooterPartSelector(GraphQLStoryUtil graphQLStoryUtil, ReactionsFooterPartDefinition reactionsFooterPartDefinition, FooterPartDefinition footerPartDefinition, SubStoryFooterPartDefinitionProvider subStoryFooterPartDefinitionProvider, @Assisted FooterLevel footerLevel) {
        this.f20471c = graphQLStoryUtil;
        this.f20469a = subStoryFooterPartDefinitionProvider.m23557a(reactionsFooterPartDefinition, footerLevel);
        this.f20470b = subStoryFooterPartDefinitionProvider.m23557a(footerPartDefinition, footerLevel);
    }
}

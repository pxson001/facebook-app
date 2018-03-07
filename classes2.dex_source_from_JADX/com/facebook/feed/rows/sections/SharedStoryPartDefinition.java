package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.inlinesurvey.InlineSurveyGroupPartDefinition;
import com.facebook.feed.rows.sections.text.TextSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.followup.FollowUpGroupPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition;
import com.facebook.feedplugins.graphqlstory.seefirsttombstone.SeeFirstTombstonePartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: initializeGatekeeperStore */
public class SharedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static SharedStoryPartDefinition f19993n;
    private static final Object f19994o = new Object();
    private final FollowUpGroupPartDefinition<FeedEnvironment> f19995a;
    private final InlineCommentComposerPartDefinition<FeedEnvironment> f19996b;
    private final FeedCommentsPartDefinition<FeedEnvironment> f19997c;
    private final TopLevelFooterPartSelector f19998d;
    private final BlingBarSelectorPartDefinition f19999e;
    private final FeedAttachedStoryPartDefinition f20000f;
    private final AttachmentsPartDefinition f20001g;
    private final TextSelectorPartDefinition f20002h;
    private final HeaderSelectorPartDefinition f20003i;
    private final ExplanationSelectorPartDefinition f20004j;
    private final SeeFirstTombstonePartDefinition<FeedEnvironment> f20005k;
    private final StoryPromotionPartDefinition<FeedEnvironment> f20006l;
    private final InlineSurveyGroupPartDefinition f20007m;

    private static SharedStoryPartDefinition m27745b(InjectorLike injectorLike) {
        return new SharedStoryPartDefinition(SeeFirstTombstonePartDefinition.m27752a(injectorLike), ExplanationSelectorPartDefinition.m27773a(injectorLike), HeaderSelectorPartDefinition.m27777a(injectorLike), TextSelectorPartDefinition.m28559a(injectorLike), AttachmentsPartDefinition.m27796a(injectorLike), FeedAttachedStoryPartDefinition.m32655a(injectorLike), BlingBarSelectorPartDefinition.m27852a(injectorLike), TopLevelFooterPartSelector.m28947a(injectorLike), FeedCommentsPartDefinition.m27856a(injectorLike), InlineCommentComposerPartDefinition.m27906a(injectorLike), FollowUpGroupPartDefinition.m27958a(injectorLike), StoryPromotionPartDefinition.m32727a(injectorLike), InlineSurveyGroupPartDefinition.m27923a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        Object obj2 = (GraphQLStory) obj.f13444a;
        baseMultiRowSubParts.m19112a(this.f20005k, new Props(obj2, (FeedEnvironment) anyEnvironment));
        baseMultiRowSubParts.m19112a(this.f20004j, obj);
        baseMultiRowSubParts.m19112a(this.f20003i, obj);
        baseMultiRowSubParts.m19112a(this.f20002h, obj);
        baseMultiRowSubParts.m19112a(this.f20001g, obj);
        baseMultiRowSubParts.m19112a(this.f20000f, obj);
        baseMultiRowSubParts.m19112a(this.f19999e, obj);
        baseMultiRowSubParts.m19112a(this.f19998d, obj);
        baseMultiRowSubParts.m19112a(this.f20006l, obj);
        baseMultiRowSubParts.m19112a(this.f19997c, obj);
        baseMultiRowSubParts.m19112a(this.f19996b, obj);
        baseMultiRowSubParts.m19112a(this.f20007m, obj);
        baseMultiRowSubParts.m19112a(this.f19995a, obj2);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        return m27744a((FeedProps) obj);
    }

    public static SharedStoryPartDefinition m27743a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SharedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f19994o) {
                SharedStoryPartDefinition sharedStoryPartDefinition;
                if (a2 != null) {
                    sharedStoryPartDefinition = (SharedStoryPartDefinition) a2.mo818a(f19994o);
                } else {
                    sharedStoryPartDefinition = f19993n;
                }
                if (sharedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27745b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f19994o, b3);
                        } else {
                            f19993n = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = sharedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SharedStoryPartDefinition(SeeFirstTombstonePartDefinition seeFirstTombstonePartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, TextSelectorPartDefinition textSelectorPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, FeedAttachedStoryPartDefinition feedAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition, FollowUpGroupPartDefinition followUpGroupPartDefinition, StoryPromotionPartDefinition storyPromotionPartDefinition, InlineSurveyGroupPartDefinition inlineSurveyGroupPartDefinition) {
        this.f19995a = followUpGroupPartDefinition;
        this.f19996b = inlineCommentComposerPartDefinition;
        this.f19997c = feedCommentsPartDefinition;
        this.f19998d = topLevelFooterPartSelector;
        this.f19999e = blingBarSelectorPartDefinition;
        this.f20000f = feedAttachedStoryPartDefinition;
        this.f20001g = attachmentsPartDefinition;
        this.f20002h = textSelectorPartDefinition;
        this.f20003i = headerSelectorPartDefinition;
        this.f20004j = explanationSelectorPartDefinition;
        this.f20005k = seeFirstTombstonePartDefinition;
        this.f20006l = storyPromotionPartDefinition;
        this.f20007m = inlineSurveyGroupPartDefinition;
    }

    public static boolean m27744a(FeedProps<GraphQLStory> feedProps) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        return graphQLStory.m22326L() != null && graphQLStory.aD() == 0;
    }
}

package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.FeedHiddenUnitGroupPartDefinition;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.graphqlstory.footer.SeeMoreFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.graphql.story.util.StoryUtilModelConverter;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowSubParts;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: actor is available */
public class SubStoriesGroupPartDefinition extends BaseMultiRowGroupPartDefinition<Props, Void, FeedEnvironment> {
    private static SubStoriesGroupPartDefinition f20446j;
    private static final Object f20447k = new Object();
    private final GraphQLStoryUtil f20448a;
    private final QeAccessor f20449b;
    private final FeedCommentsPartDefinition f20450c;
    private final SubStoryFooterPartSelector f20451d;
    private final SubStoryFooterPartSelector f20452e;
    private final SubStoryFooterPartSelector f20453f;
    private final SubStoryFooterPartSelector f20454g;
    private final SeeMoreFooterPartDefinition f20455h;
    private final FeedHiddenUnitGroupPartDefinition f20456i;

    /* compiled from: actor is available */
    public interface Callbacks {
        void mo1482a(MultiRowSubParts<FeedEnvironment> multiRowSubParts, FeedProps<GraphQLStory> feedProps);
    }

    /* compiled from: actor is available */
    public class Props {
        FeedProps<GraphQLStory> f20444a;
        Callbacks f20445b;

        public Props(FeedProps<GraphQLStory> feedProps, Callbacks callbacks) {
            this.f20444a = feedProps;
            this.f20445b = callbacks;
        }
    }

    private static SubStoriesGroupPartDefinition m23538b(InjectorLike injectorLike) {
        return new SubStoriesGroupPartDefinition(GraphQLStoryUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), SeeMoreFooterPartDefinition.m25632a(injectorLike), (SubStoryFooterPartSelectorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SubStoryFooterPartSelectorProvider.class), FeedHiddenUnitGroupPartDefinition.a(injectorLike));
    }

    public final Object m23539a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) props.f20444a.a;
        int size = StoryHierarchyHelper.a(graphQLStory).j().size();
        int i = size - 1;
        boolean h = this.f20448a.h(props.f20444a);
        for (int i2 = 0; i2 < size; i2++) {
            GraphQLStory graphQLStory2 = (GraphQLStory) StoryHierarchyHelper.a(graphQLStory).j().get(i2);
            FeedProps a = props.f20444a.a(graphQLStory2);
            if (!baseMultiRowSubParts.a(this.f20456i, a)) {
                props.f20445b.mo1482a(baseMultiRowSubParts, props.f20444a.a(graphQLStory2));
                if (h) {
                    if (this.f20450c.a(a) && this.f20449b.a(ExperimentsForMultipleRowsStoriesAbtestModule.a, false)) {
                        baseMultiRowSubParts.a(this.f20453f, a);
                        baseMultiRowSubParts.a(this.f20450c, a);
                    } else {
                        baseMultiRowSubParts.a(this.f20454g, a);
                    }
                } else if (i2 == i) {
                    baseMultiRowSubParts.a(this.f20452e, a);
                } else {
                    baseMultiRowSubParts.a(this.f20451d, a);
                }
            }
        }
        baseMultiRowSubParts.a(this.f20455h, props.f20444a);
        return null;
    }

    public final boolean m23540a(Object obj) {
        return m23537a((GraphQLStory) ((Props) obj).f20444a.a);
    }

    public static SubStoriesGroupPartDefinition m23536a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SubStoriesGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20447k) {
                SubStoriesGroupPartDefinition subStoriesGroupPartDefinition;
                if (a2 != null) {
                    subStoriesGroupPartDefinition = (SubStoriesGroupPartDefinition) a2.a(f20447k);
                } else {
                    subStoriesGroupPartDefinition = f20446j;
                }
                if (subStoriesGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23538b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20447k, b3);
                        } else {
                            f20446j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = subStoriesGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SubStoriesGroupPartDefinition(GraphQLStoryUtil graphQLStoryUtil, QeAccessor qeAccessor, FeedCommentsPartDefinition feedCommentsPartDefinition, SeeMoreFooterPartDefinition seeMoreFooterPartDefinition, SubStoryFooterPartSelectorProvider subStoryFooterPartSelectorProvider, FeedHiddenUnitGroupPartDefinition feedHiddenUnitGroupPartDefinition) {
        this.f20448a = graphQLStoryUtil;
        this.f20449b = qeAccessor;
        this.f20450c = feedCommentsPartDefinition;
        this.f20451d = subStoryFooterPartSelectorProvider.m23560a(FooterLevel.SUB_STORY);
        this.f20452e = subStoryFooterPartSelectorProvider.m23560a(FooterLevel.LAST_SUB_STORY);
        this.f20453f = subStoryFooterPartSelectorProvider.m23560a(FooterLevel.SUB_STORY_BOX_WITH_COMMENTS);
        this.f20454g = subStoryFooterPartSelectorProvider.m23560a(FooterLevel.SUB_STORY_BOX_WITHOUT_COMMENTS);
        this.f20455h = seeMoreFooterPartDefinition;
        this.f20456i = feedHiddenUnitGroupPartDefinition;
    }

    public static boolean m23537a(GraphQLStory graphQLStory) {
        if (graphQLStory.aD() == 0 || GraphQLStoryUtil.a(StoryUtilModelConverter.a(graphQLStory))) {
            return false;
        }
        return true;
    }
}

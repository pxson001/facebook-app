package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.components.LikableHeaderComponentPartDefinition;
import com.facebook.feedplugins.graphqlstory.page.actionablepage.CallToActionResolver;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: img_size */
public class LikableHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static LikableHeaderSelectorPartDefinition f20364e;
    private static final Object f20365f = new Object();
    private final StoryActionLinkUtil f20366a;
    private final CallToActionResolver f20367b;
    private final Lazy<LikableHeaderComponentPartDefinition<FeedEnvironment>> f20368c;
    private final Lazy<LikableHeaderPartDefinition<FeedEnvironment>> f20369d;

    private static LikableHeaderSelectorPartDefinition m28023b(InjectorLike injectorLike) {
        return new LikableHeaderSelectorPartDefinition(IdBasedLazy.m1808a(injectorLike, 1660), IdBasedLazy.m1808a(injectorLike, 1609), StoryActionLinkUtil.m28026b(injectorLike), CallToActionResolver.m10678a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        SubPartsSelector.m19115a(baseMultiRowSubParts, this.f20368c, obj).m19119a(this.f20369d, obj);
        return null;
    }

    public final boolean mo2536a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        boolean j = StoryAttachmentHelper.m28037j(graphQLStory);
        if (this.f20367b.m10679a(graphQLStory) && !j) {
            return false;
        }
        GraphQLStoryAttachment o = StoryAttachmentHelper.m28042o(graphQLStory);
        if (j && o != null && CallToActionUtil.m32461h(o)) {
            return false;
        }
        Object obj2;
        if (o == null || o.m23979r() == null || !o.m23979r().al()) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            return false;
        }
        GraphQLStoryActionLink a = this.f20366a.m28027a(feedProps);
        return (a == null || a.ab() == null) ? false : true;
    }

    @Inject
    public LikableHeaderSelectorPartDefinition(Lazy<LikableHeaderComponentPartDefinition> lazy, Lazy<LikableHeaderPartDefinition> lazy2, StoryActionLinkUtil storyActionLinkUtil, CallToActionResolver callToActionResolver) {
        this.f20368c = lazy;
        this.f20369d = lazy2;
        this.f20366a = storyActionLinkUtil;
        this.f20367b = callToActionResolver;
    }

    public static LikableHeaderSelectorPartDefinition m28022a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LikableHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20365f) {
                LikableHeaderSelectorPartDefinition likableHeaderSelectorPartDefinition;
                if (a2 != null) {
                    likableHeaderSelectorPartDefinition = (LikableHeaderSelectorPartDefinition) a2.mo818a(f20365f);
                } else {
                    likableHeaderSelectorPartDefinition = f20364e;
                }
                if (likableHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28023b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20365f, b3);
                        } else {
                            f20364e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = likableHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}

package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitPagerIndicatorPartDefinition;
import com.facebook.graphql.model.GraphQLStorySet;
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
/* compiled from: audience_educator_privacy_type_extra */
public class StorySetPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStorySet>, Void, FeedEnvironment> {
    private static StorySetPartDefinition f9762i;
    private static final Object f9763j = new Object();
    private final StorySetKeepAttachedHscrollPartDefinition f9764a;
    private final StorySetAttachmentStyleHScrollPartDefinition f9765b;
    private final StorySetHScrollPartDefinition f9766c;
    private final FeedUnitPagerIndicatorPartDefinition<GraphQLStorySet, FeedEnvironment> f9767d;
    private final StorySetVideoCollectionFooterPartDefinition f9768e;
    private final StorySetVideoCollectionHeaderPartDefinition f9769f;
    private final StorySetHeaderWithIconAndMenuPartDefinition f9770g;
    private final StorySetSingleStoryGroupPartDefinition f9771h;

    private static StorySetPartDefinition m10200b(InjectorLike injectorLike) {
        return new StorySetPartDefinition(StorySetKeepAttachedHscrollPartDefinition.m10148a(injectorLike), StorySetAttachmentStyleHScrollPartDefinition.m10110a(injectorLike), StorySetHScrollPartDefinition.m10133a(injectorLike), FeedUnitPagerIndicatorPartDefinition.a(injectorLike), StorySetVideoCollectionFooterPartDefinition.m10210a(injectorLike), StorySetVideoCollectionHeaderPartDefinition.m10215a(injectorLike), StorySetHeaderWithIconAndMenuPartDefinition.m10143a(injectorLike), StorySetSingleStoryGroupPartDefinition.m10203a(injectorLike));
    }

    public final Object m10201a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedUnitAndChangePageListener feedUnitAndChangePageListener = new FeedUnitAndChangePageListener(feedProps, FeedUnitPagerIndicatorPartDefinition.b());
        SubPartsSelector.a(baseMultiRowSubParts, this.f9770g, feedProps).a(this.f9769f, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f9771h, feedProps).a(this.f9764a, feedUnitAndChangePageListener).a(this.f9765b, feedUnitAndChangePageListener).a(this.f9766c, feedUnitAndChangePageListener);
        if (!StorySetSingleStoryGroupPartDefinition.m10204a(feedProps)) {
            SubPartsSelector.a(baseMultiRowSubParts, this.f9768e, feedProps).a(this.f9767d, feedUnitAndChangePageListener);
        }
        return null;
    }

    @Inject
    public StorySetPartDefinition(StorySetKeepAttachedHscrollPartDefinition storySetKeepAttachedHscrollPartDefinition, StorySetAttachmentStyleHScrollPartDefinition storySetAttachmentStyleHScrollPartDefinition, StorySetHScrollPartDefinition storySetHScrollPartDefinition, FeedUnitPagerIndicatorPartDefinition feedUnitPagerIndicatorPartDefinition, StorySetVideoCollectionFooterPartDefinition storySetVideoCollectionFooterPartDefinition, StorySetVideoCollectionHeaderPartDefinition storySetVideoCollectionHeaderPartDefinition, StorySetHeaderWithIconAndMenuPartDefinition storySetHeaderWithIconAndMenuPartDefinition, StorySetSingleStoryGroupPartDefinition storySetSingleStoryGroupPartDefinition) {
        this.f9764a = storySetKeepAttachedHscrollPartDefinition;
        this.f9765b = storySetAttachmentStyleHScrollPartDefinition;
        this.f9766c = storySetHScrollPartDefinition;
        this.f9767d = feedUnitPagerIndicatorPartDefinition;
        this.f9768e = storySetVideoCollectionFooterPartDefinition;
        this.f9769f = storySetVideoCollectionHeaderPartDefinition;
        this.f9770g = storySetHeaderWithIconAndMenuPartDefinition;
        this.f9771h = storySetSingleStoryGroupPartDefinition;
    }

    public static StorySetPartDefinition m10199a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9763j) {
                StorySetPartDefinition storySetPartDefinition;
                if (a2 != null) {
                    storySetPartDefinition = (StorySetPartDefinition) a2.a(f9763j);
                } else {
                    storySetPartDefinition = f9762i;
                }
                if (storySetPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10200b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9763j, b3);
                        } else {
                            f9762i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m10202a(Object obj) {
        return true;
    }
}

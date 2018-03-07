package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ExplanationTextPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_requester_id */
public class SocialContextExplanationPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithMenuButtonView> implements HasSpecialStyling {
    private static SocialContextExplanationPartDefinition f23164c;
    private static final Object f23165d = new Object();
    private final FeedStoryUtil f23166a;
    private final BaseExplanationPartDefinition<E> f23167b;

    private static SocialContextExplanationPartDefinition m31274b(InjectorLike injectorLike) {
        return new SocialContextExplanationPartDefinition(FeedStoryUtil.m18578a(injectorLike), BaseExplanationPartDefinition.m31279a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f23167b, new Props((FeedProps) obj, TextHeaderStyle.SOCIAL_CONTEXT));
        return null;
    }

    public final boolean m31277a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).f13444a;
        return graphQLStory.aG() != null && FeedStoryUtil.m18581a(graphQLStory);
    }

    @Inject
    public SocialContextExplanationPartDefinition(FeedStoryUtil feedStoryUtil, BaseExplanationPartDefinition baseExplanationPartDefinition) {
        this.f23166a = feedStoryUtil;
        this.f23167b = baseExplanationPartDefinition;
    }

    public final ViewType mo2547a() {
        return ExplanationPartDefinition.f24309a;
    }

    public static SocialContextExplanationPartDefinition m31273a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SocialContextExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23165d) {
                SocialContextExplanationPartDefinition socialContextExplanationPartDefinition;
                if (a2 != null) {
                    socialContextExplanationPartDefinition = (SocialContextExplanationPartDefinition) a2.mo818a(f23165d);
                } else {
                    socialContextExplanationPartDefinition = f23164c;
                }
                if (socialContextExplanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31274b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23165d, b3);
                        } else {
                            f23164c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = socialContextExplanationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }
}

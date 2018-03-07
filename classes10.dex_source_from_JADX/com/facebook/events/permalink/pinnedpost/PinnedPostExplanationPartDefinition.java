package com.facebook.events.permalink.pinnedpost;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.BaseExplanationPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationTextPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.TextHeaderStyle;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
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
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: background_location_upsell_miniphone_selected */
public class PinnedPostExplanationPartDefinition<E extends HasFeedListType & HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithMenuButtonView> implements HasSpecialStyling {
    private static PinnedPostExplanationPartDefinition f18778b;
    private static final Object f18779c = new Object();
    private final BaseExplanationPartDefinition<E> f18780a;

    private static PinnedPostExplanationPartDefinition m19086b(InjectorLike injectorLike) {
        return new PinnedPostExplanationPartDefinition(BaseExplanationPartDefinition.a(injectorLike));
    }

    public final Object m19088a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        subParts.a(this.f18780a, new Props(feedProps, TextHeaderStyle.STORY_HEADER));
        return (Void) super.a(subParts, feedProps, hasFeedListType);
    }

    public final boolean m19089a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return (graphQLStory.W() == null || Strings.isNullOrEmpty(graphQLStory.W().a())) ? false : true;
    }

    @Inject
    public PinnedPostExplanationPartDefinition(BaseExplanationPartDefinition baseExplanationPartDefinition) {
        this.f18780a = baseExplanationPartDefinition;
    }

    public final ViewType<TextWithMenuButtonView> m19087a() {
        return TextWithMenuButtonView.b;
    }

    public static PinnedPostExplanationPartDefinition m19085a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PinnedPostExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18779c) {
                PinnedPostExplanationPartDefinition pinnedPostExplanationPartDefinition;
                if (a2 != null) {
                    pinnedPostExplanationPartDefinition = (PinnedPostExplanationPartDefinition) a2.a(f18779c);
                } else {
                    pinnedPostExplanationPartDefinition = f18778b;
                }
                if (pinnedPostExplanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m19086b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18779c, b3);
                        } else {
                            f18778b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pinnedPostExplanationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final SpecialStylingType m19090b() {
        return SpecialStylingType.NEED_BOTTOM_DIVIDER;
    }
}

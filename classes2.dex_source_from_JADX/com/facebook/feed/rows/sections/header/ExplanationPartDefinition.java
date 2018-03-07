package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.view.View;
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
/* compiled from: fetchHomeStoriesFromDb failed */
public class ExplanationPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithMenuButtonView> implements HasSpecialStyling {
    public static final ViewType f24309a = new C09861();
    private static ExplanationPartDefinition f24310d;
    private static final Object f24311e = new Object();
    private final FeedStoryUtil f24312b;
    private final BaseExplanationPartDefinition<E> f24313c;

    /* compiled from: fetchHomeStoriesFromDb failed */
    final class C09861 extends ViewType {
        C09861() {
        }

        public final View mo1995a(Context context) {
            return new TextWithMenuButtonView(context);
        }
    }

    private static ExplanationPartDefinition m32649b(InjectorLike injectorLike) {
        return new ExplanationPartDefinition(FeedStoryUtil.m18578a(injectorLike), BaseExplanationPartDefinition.m31279a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f24313c, new Props((FeedProps) obj, TextHeaderStyle.SUGGESTED_CONTENT));
        return null;
    }

    public final boolean m32652a(Object obj) {
        return FeedStoryUtil.m18581a((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    @Inject
    public ExplanationPartDefinition(FeedStoryUtil feedStoryUtil, BaseExplanationPartDefinition baseExplanationPartDefinition) {
        this.f24312b = feedStoryUtil;
        this.f24313c = baseExplanationPartDefinition;
    }

    public final ViewType mo2547a() {
        return f24309a;
    }

    public static ExplanationPartDefinition m32648a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24311e) {
                ExplanationPartDefinition explanationPartDefinition;
                if (a2 != null) {
                    explanationPartDefinition = (ExplanationPartDefinition) a2.mo818a(f24311e);
                } else {
                    explanationPartDefinition = f24310d;
                }
                if (explanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32649b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24311e, b3);
                        } else {
                            f24310d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = explanationPartDefinition;
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

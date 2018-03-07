package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ExplanationTextPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friend_request */
public class BaseExplanationPartDefinition<E extends HasPositionInformation & HasMenuButtonProvider & HasPersistentState & HasInvalidate> extends BaseSinglePartDefinition<Props, Void, E, TextWithMenuButtonView> {
    private static BaseExplanationPartDefinition f23168d;
    private static final Object f23169e = new Object();
    private final BackgroundPartDefinition f23170a;
    private final MenuButtonPartDefinition f23171b;
    private final ExplanationTextPartDefinition<E> f23172c;

    private static BaseExplanationPartDefinition m31281b(InjectorLike injectorLike) {
        return new BaseExplanationPartDefinition(BackgroundPartDefinition.m19135a(injectorLike), MenuButtonPartDefinition.m26324a(injectorLike), ExplanationTextPartDefinition.m31284a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.mo2756a(this.f23170a, new StylingData(props.a, m31280a(props.a)));
        subParts.mo2755a(2131562876, this.f23172c, props);
        subParts.mo2755a(2131560877, this.f23171b, new MenuButtonPartDefinition.Props(props.a, m31282b(props.a)));
        return null;
    }

    @Inject
    public BaseExplanationPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, ExplanationTextPartDefinition explanationTextPartDefinition) {
        this.f23170a = backgroundPartDefinition;
        this.f23171b = menuButtonPartDefinition;
        this.f23172c = explanationTextPartDefinition;
    }

    public static BaseExplanationPartDefinition m31279a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BaseExplanationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23169e) {
                BaseExplanationPartDefinition baseExplanationPartDefinition;
                if (a2 != null) {
                    baseExplanationPartDefinition = (BaseExplanationPartDefinition) a2.mo818a(f23169e);
                } else {
                    baseExplanationPartDefinition = f23168d;
                }
                if (baseExplanationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m31281b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23169e, b3);
                        } else {
                            f23168d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = baseExplanationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static PaddingStyle m31280a(FeedProps<GraphQLStory> feedProps) {
        if (feedProps.m19807c() == null) {
            return PaddingStyle.f13080j;
        }
        return PaddingStyle.f13075e;
    }

    public static MenuConfig m31282b(FeedProps<GraphQLStory> feedProps) {
        Object obj;
        if (feedProps.m19807c() != null || (((GraphQLStory) feedProps.f13444a).aG() == null && ((GraphQLStory) feedProps.f13444a).m22337W() == null)) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return MenuConfig.CLICKABLE;
        }
        return MenuConfig.HIDDEN;
    }
}

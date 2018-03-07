package com.facebook.feedplugins.customizedstory;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.facebookvoice.FacebookVoiceHeaderView;
import com.facebook.graphql.enums.GraphQLStoryHeaderStyle;
import com.facebook.graphql.model.GraphQLCustomizedStory;
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
/* compiled from: presence_typing */
public class CustomizedStoryHeaderFbVoicePartDefinition<E extends HasMenuButtonProvider & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLCustomizedStory>, Void, E, FacebookVoiceHeaderView> {
    public static final ViewType f4261a = new C02001();
    private static CustomizedStoryHeaderFbVoicePartDefinition f4262e;
    private static final Object f4263f = new Object();
    private final BackgroundPartDefinition f4264b;
    private final CustomizedStoryHeaderDataPartDefinition f4265c;
    private final MenuButtonPartDefinition f4266d;

    /* compiled from: presence_typing */
    final class C02001 extends ViewType {
        C02001() {
        }

        public final View m4802a(Context context) {
            return new FacebookVoiceHeaderView(context);
        }
    }

    private static CustomizedStoryHeaderFbVoicePartDefinition m4798b(InjectorLike injectorLike) {
        return new CustomizedStoryHeaderFbVoicePartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), CustomizedStoryHeaderDataPartDefinition.m4804a(injectorLike));
    }

    public final Object m4800a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        subParts.a(this.f4265c, (GraphQLCustomizedStory) feedProps.a);
        subParts.a(this.f4264b, new StylingData(feedProps, PaddingStyle.i));
        subParts.a(2131560877, this.f4266d, new Props(feedProps, hasMenuButtonProvider.e() != null ? MenuConfig.CLICKABLE : MenuConfig.HIDDEN));
        return null;
    }

    public final boolean m4801a(Object obj) {
        GraphQLCustomizedStory graphQLCustomizedStory = (GraphQLCustomizedStory) ((FeedProps) obj).a;
        if (graphQLCustomizedStory.I() != null) {
            Object obj2 = (graphQLCustomizedStory.I().m() == null || !graphQLCustomizedStory.I().m().contains(GraphQLStoryHeaderStyle.FACEBOOK_VOICE)) ? null : 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public CustomizedStoryHeaderFbVoicePartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, CustomizedStoryHeaderDataPartDefinition customizedStoryHeaderDataPartDefinition) {
        this.f4264b = backgroundPartDefinition;
        this.f4266d = menuButtonPartDefinition;
        this.f4265c = customizedStoryHeaderDataPartDefinition;
    }

    public final ViewType m4799a() {
        return f4261a;
    }

    public static CustomizedStoryHeaderFbVoicePartDefinition m4797a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CustomizedStoryHeaderFbVoicePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4263f) {
                CustomizedStoryHeaderFbVoicePartDefinition customizedStoryHeaderFbVoicePartDefinition;
                if (a2 != null) {
                    customizedStoryHeaderFbVoicePartDefinition = (CustomizedStoryHeaderFbVoicePartDefinition) a2.a(f4263f);
                } else {
                    customizedStoryHeaderFbVoicePartDefinition = f4262e;
                }
                if (customizedStoryHeaderFbVoicePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4798b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4263f, b3);
                        } else {
                            f4262e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = customizedStoryHeaderFbVoicePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

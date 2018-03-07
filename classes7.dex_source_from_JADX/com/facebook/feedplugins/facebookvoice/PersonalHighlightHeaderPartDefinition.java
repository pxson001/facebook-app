package com.facebook.feedplugins.facebookvoice;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.MenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.MenuConfig;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: StyleConstants */
public class PersonalHighlightHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FacebookVoiceHeaderView> {
    public static final ViewType f23102a = new C19971();
    private static PersonalHighlightHeaderPartDefinition f23103f;
    private static final Object f23104g = new Object();
    private final BackgroundPartDefinition f23105b;
    private final PersonalHighlightHeaderDataPartDefinition f23106c;
    private final MenuButtonPartDefinition f23107d;
    private final FeedStoryUtil f23108e;

    /* compiled from: StyleConstants */
    final class C19971 extends ViewType {
        C19971() {
        }

        public final View m25536a(Context context) {
            return new FacebookVoiceHeaderView(context);
        }
    }

    private static PersonalHighlightHeaderPartDefinition m25538b(InjectorLike injectorLike) {
        return new PersonalHighlightHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), MenuButtonPartDefinition.a(injectorLike), PersonalHighlightHeaderDataPartDefinition.m25533a(injectorLike), FeedStoryUtil.a(injectorLike));
    }

    public final Object m25540a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasMenuButtonProvider hasMenuButtonProvider = (HasMenuButtonProvider) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23106c, graphQLStory);
        subParts.a(this.f23105b, new StylingData(feedProps, PaddingStyle.i));
        BaseFeedStoryMenuHelper e = hasMenuButtonProvider.e();
        Object obj2 = (e == null || !e.a(graphQLStory).a(feedProps) || FeedStoryUtil.a(graphQLStory)) ? null : 1;
        subParts.a(2131560877, this.f23107d, new Props(feedProps, obj2 != null ? MenuConfig.CLICKABLE : MenuConfig.HIDDEN));
        return null;
    }

    public final boolean m25541a(Object obj) {
        return FeedStoryUtil.e((FeedProps) obj);
    }

    @Inject
    public PersonalHighlightHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, MenuButtonPartDefinition menuButtonPartDefinition, PersonalHighlightHeaderDataPartDefinition personalHighlightHeaderDataPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f23105b = backgroundPartDefinition;
        this.f23107d = menuButtonPartDefinition;
        this.f23106c = personalHighlightHeaderDataPartDefinition;
        this.f23108e = feedStoryUtil;
    }

    public static PersonalHighlightHeaderPartDefinition m25537a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonalHighlightHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23104g) {
                PersonalHighlightHeaderPartDefinition personalHighlightHeaderPartDefinition;
                if (a2 != null) {
                    personalHighlightHeaderPartDefinition = (PersonalHighlightHeaderPartDefinition) a2.a(f23104g);
                } else {
                    personalHighlightHeaderPartDefinition = f23103f;
                }
                if (personalHighlightHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25538b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23104g, b3);
                        } else {
                            f23103f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = personalHighlightHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m25539a() {
        return f23102a;
    }
}

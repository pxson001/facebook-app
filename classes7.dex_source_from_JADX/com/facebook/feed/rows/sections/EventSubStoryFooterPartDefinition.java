package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition$Props;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
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
/* compiled from: _<cstr> */
public class EventSubStoryFooterPartDefinition<E extends HasFeedListType & HasPersistentState> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultFooterView> {
    private static EventSubStoryFooterPartDefinition f20365c;
    private static final Object f20366d = new Object();
    private final BasicFooterPartDefinition f20367a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f20368b;

    private static EventSubStoryFooterPartDefinition m23492b(InjectorLike injectorLike) {
        return new EventSubStoryFooterPartDefinition(BasicFooterPartDefinition.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m23493a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20368b, new Props(feedProps, FooterLevel.PAGE));
        subParts.a(this.f20367a, new BasicFooterPartDefinition$Props(feedProps, true));
        return null;
    }

    @Inject
    public EventSubStoryFooterPartDefinition(BasicFooterPartDefinition basicFooterPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition) {
        this.f20367a = basicFooterPartDefinition;
        this.f20368b = footerBackgroundPartDefinition;
    }

    public static EventSubStoryFooterPartDefinition m23491a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventSubStoryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20366d) {
                EventSubStoryFooterPartDefinition eventSubStoryFooterPartDefinition;
                if (a2 != null) {
                    eventSubStoryFooterPartDefinition = (EventSubStoryFooterPartDefinition) a2.a(f20366d);
                } else {
                    eventSubStoryFooterPartDefinition = f20365c;
                }
                if (eventSubStoryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23492b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20366d, b3);
                        } else {
                            f20365c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = eventSubStoryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

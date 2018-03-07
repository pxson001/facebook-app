package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.feedbackreactions.ui.BaseReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
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
/* compiled from: auth_code */
public class StorySetPageReactionsUFIPartDefinition<E extends AnyEnvironment, V extends View & Footer> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static StorySetPageReactionsUFIPartDefinition f9741c;
    private static final Object f9742d = new Object();
    private final FooterBackgroundPartDefinition<ReactionsFooterView> f9743a;
    private final BaseReactionsFooterPartDefinition f9744b;

    private static StorySetPageReactionsUFIPartDefinition m10186b(InjectorLike injectorLike) {
        return new StorySetPageReactionsUFIPartDefinition(FooterBackgroundPartDefinition.a(injectorLike), BaseReactionsFooterPartDefinition.a(injectorLike));
    }

    public final Object m10187a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131567719, this.f9743a, new Props(feedProps, FooterLevel.PAGE));
        subParts.a(2131567719, this.f9744b, new BaseReactionsFooterPartDefinition.Props(feedProps, true));
        return null;
    }

    @Inject
    public StorySetPageReactionsUFIPartDefinition(FooterBackgroundPartDefinition footerBackgroundPartDefinition, BaseReactionsFooterPartDefinition baseReactionsFooterPartDefinition) {
        this.f9743a = footerBackgroundPartDefinition;
        this.f9744b = baseReactionsFooterPartDefinition;
    }

    public static StorySetPageReactionsUFIPartDefinition m10185a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageReactionsUFIPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9742d) {
                StorySetPageReactionsUFIPartDefinition storySetPageReactionsUFIPartDefinition;
                if (a2 != null) {
                    storySetPageReactionsUFIPartDefinition = (StorySetPageReactionsUFIPartDefinition) a2.a(f9742d);
                } else {
                    storySetPageReactionsUFIPartDefinition = f9741c;
                }
                if (storySetPageReactionsUFIPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10186b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9742d, b3);
                        } else {
                            f9741c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageReactionsUFIPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

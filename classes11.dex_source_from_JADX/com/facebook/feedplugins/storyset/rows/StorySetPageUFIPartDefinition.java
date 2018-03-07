package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.base.footer.ui.Footer;
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
/* compiled from: audio_duration_ms */
public class StorySetPageUFIPartDefinition<E extends AnyEnvironment, V extends View & Footer> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static StorySetPageUFIPartDefinition f9752c;
    private static final Object f9753d = new Object();
    private final FooterBackgroundPartDefinition<DefaultFooterView> f9754a;
    private final BasicFooterPartDefinition f9755b;

    private static StorySetPageUFIPartDefinition m10194b(InjectorLike injectorLike) {
        return new StorySetPageUFIPartDefinition(FooterBackgroundPartDefinition.a(injectorLike), BasicFooterPartDefinition.a(injectorLike));
    }

    public final Object m10195a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131562639, this.f9754a, new Props(feedProps, FooterLevel.PAGE));
        subParts.a(2131562639, this.f9755b, new BasicFooterPartDefinition.Props(feedProps, true));
        return null;
    }

    @Inject
    public StorySetPageUFIPartDefinition(FooterBackgroundPartDefinition footerBackgroundPartDefinition, BasicFooterPartDefinition basicFooterPartDefinition) {
        this.f9754a = footerBackgroundPartDefinition;
        this.f9755b = basicFooterPartDefinition;
    }

    public static StorySetPageUFIPartDefinition m10193a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageUFIPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9753d) {
                StorySetPageUFIPartDefinition storySetPageUFIPartDefinition;
                if (a2 != null) {
                    storySetPageUFIPartDefinition = (StorySetPageUFIPartDefinition) a2.a(f9753d);
                } else {
                    storySetPageUFIPartDefinition = f9752c;
                }
                if (storySetPageUFIPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10194b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9753d, b3);
                        } else {
                            f9752c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageUFIPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

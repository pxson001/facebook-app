package com.facebook.feedplugins.pysf.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.TitleWithMenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.TitleWithMenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.graphql.model.GraphQLPeopleYouShouldFollowFeedUnit;
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
/* compiled from: checkup_cover */
public class PeopleYouShouldFollowHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouShouldFollowFeedUnit>, Void, FeedEnvironment, TextWithMenuButtonView> {
    private static PeopleYouShouldFollowHeaderPartDefinition f8817b;
    private static final Object f8818c = new Object();
    private final TitleWithMenuButtonPartDefinition f8819a;

    private static PeopleYouShouldFollowHeaderPartDefinition m9577b(InjectorLike injectorLike) {
        return new PeopleYouShouldFollowHeaderPartDefinition(TitleWithMenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9579a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f8819a, new Props(feedProps, ((GraphQLPeopleYouShouldFollowFeedUnit) feedProps.a).s().a(), Sponsored.NOT_SPONSORED, false));
        return null;
    }

    @Inject
    public PeopleYouShouldFollowHeaderPartDefinition(TitleWithMenuButtonPartDefinition titleWithMenuButtonPartDefinition) {
        this.f8819a = titleWithMenuButtonPartDefinition;
    }

    public final boolean m9580a(Object obj) {
        return true;
    }

    public final ViewType<TextWithMenuButtonView> m9578a() {
        return TextWithMenuButtonView.b;
    }

    public static PeopleYouShouldFollowHeaderPartDefinition m9576a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouShouldFollowHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8818c) {
                PeopleYouShouldFollowHeaderPartDefinition peopleYouShouldFollowHeaderPartDefinition;
                if (a2 != null) {
                    peopleYouShouldFollowHeaderPartDefinition = (PeopleYouShouldFollowHeaderPartDefinition) a2.a(f8818c);
                } else {
                    peopleYouShouldFollowHeaderPartDefinition = f8817b;
                }
                if (peopleYouShouldFollowHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9577b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8818c, b3);
                        } else {
                            f8817b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouShouldFollowHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

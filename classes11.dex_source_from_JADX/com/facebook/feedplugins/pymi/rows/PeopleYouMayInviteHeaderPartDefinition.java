package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.TitleWithMenuButtonPartDefinition;
import com.facebook.feed.rows.sections.header.TitleWithMenuButtonPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.sections.header.ui.TextWithMenuButtonView;
import com.facebook.graphql.model.GraphQLPeopleYouMayInviteFeedUnit;
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
/* compiled from: clientClosed */
public class PeopleYouMayInviteHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouMayInviteFeedUnit>, String, FeedEnvironment, TextWithMenuButtonView> {
    private static PeopleYouMayInviteHeaderPartDefinition f8771c;
    private static final Object f8772d = new Object();
    private final Resources f8773a;
    private final TitleWithMenuButtonPartDefinition f8774b;

    private static PeopleYouMayInviteHeaderPartDefinition m9551b(InjectorLike injectorLike) {
        return new PeopleYouMayInviteHeaderPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), TitleWithMenuButtonPartDefinition.a(injectorLike));
    }

    public final Object m9553a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        String string = this.f8773a.getString(2131239080);
        subParts.a(this.f8774b, new Props(feedProps, string, Sponsored.NOT_SPONSORED, true));
        return string;
    }

    @Inject
    public PeopleYouMayInviteHeaderPartDefinition(Resources resources, TitleWithMenuButtonPartDefinition titleWithMenuButtonPartDefinition) {
        this.f8773a = resources;
        this.f8774b = titleWithMenuButtonPartDefinition;
    }

    public final ViewType m9552a() {
        return TextWithMenuButtonView.b;
    }

    public final boolean m9554a(Object obj) {
        return true;
    }

    public static PeopleYouMayInviteHeaderPartDefinition m9550a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayInviteHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8772d) {
                PeopleYouMayInviteHeaderPartDefinition peopleYouMayInviteHeaderPartDefinition;
                if (a2 != null) {
                    peopleYouMayInviteHeaderPartDefinition = (PeopleYouMayInviteHeaderPartDefinition) a2.a(f8772d);
                } else {
                    peopleYouMayInviteHeaderPartDefinition = f8771c;
                }
                if (peopleYouMayInviteHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9551b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8772d, b3);
                        } else {
                            f8771c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayInviteHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

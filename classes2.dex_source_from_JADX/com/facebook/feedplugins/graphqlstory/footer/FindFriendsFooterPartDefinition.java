package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: has_question */
public class FindFriendsFooterPartDefinition extends MultiRowSinglePartDefinition<GraphQLStory, Void, AnyEnvironment, OneButtonFooterView> {
    public static final String f21299a = FBLinks.m4311a("faceweb/f?href=%2Ffindfriends%2Fbrowser%2F");
    private static FindFriendsFooterPartDefinition f21300g;
    private static final Object f21301h = new Object();
    public final IFeedIntentBuilder f21302b;
    private final ClickListenerPartDefinition f21303c;
    private final TextPartDefinition f21304d;
    private final OneButtonFooterStylerPartDefinition f21305e;
    private final Context f21306f;

    private static FindFriendsFooterPartDefinition m29001b(InjectorLike injectorLike) {
        return new FindFriendsFooterPartDefinition(OneButtonFooterStylerPartDefinition.m26639a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike.getApplicationInjector()), ClickListenerPartDefinition.m19353a(injectorLike), TextPartDefinition.m19379a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f21305e, null);
        subParts.mo2755a(2131559974, this.f21304d, this.f21306f.getString(2131233242));
        subParts.mo2756a(this.f21303c, new 1(this));
        return null;
    }

    public final boolean m29004a(Object obj) {
        List E = ((GraphQLStory) obj).m22319E();
        if (E == null || E.isEmpty()) {
            return false;
        }
        GraphQLObjectType a = ((GraphQLStoryActionLink) E.get(0)).m22901a();
        return a != null && a.m22301g() == 1508518380;
    }

    @Inject
    public FindFriendsFooterPartDefinition(OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, @NeedsApplicationInjector IFeedIntentBuilder iFeedIntentBuilder, ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, Context context) {
        this.f21305e = oneButtonFooterStylerPartDefinition;
        this.f21302b = iFeedIntentBuilder;
        this.f21303c = clickListenerPartDefinition;
        this.f21304d = textPartDefinition;
        this.f21306f = context;
    }

    public static FindFriendsFooterPartDefinition m29000a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindFriendsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21301h) {
                FindFriendsFooterPartDefinition findFriendsFooterPartDefinition;
                if (a2 != null) {
                    findFriendsFooterPartDefinition = (FindFriendsFooterPartDefinition) a2.mo818a(f21301h);
                } else {
                    findFriendsFooterPartDefinition = f21300g;
                }
                if (findFriendsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29001b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21301h, b3);
                        } else {
                            f21300g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = findFriendsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return OneButtonFooterView.a;
    }
}

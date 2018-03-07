package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feedplugins.pymk.logging.PeopleYouMayKnowAnalyticsLogger;
import com.facebook.feedplugins.pymk.views.rows.CCUPromoCardView;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: notifications_session */
public class CCUPromoCardPartDefinition<E extends AnyEnvironment> extends BaseSinglePartDefinitionWithViewType<GraphQLPaginatedPeopleYouMayKnowFeedUnit, Void, E, CCUPromoCardView> {
    public static final ViewType<CCUPromoCardView> f6708a = new C03111();
    private static CCUPromoCardPartDefinition f6709i;
    private static final Object f6710j = new Object();
    private final ClickListenerPartDefinition f6711b;
    private final TextPartDefinition f6712c;
    public final Context f6713d;
    public final SecureContextHelper f6714e;
    public final UriIntentMapper f6715f;
    private final Provider<User> f6716g;
    public final PeopleYouMayKnowAnalyticsLogger f6717h;

    /* compiled from: notifications_session */
    final class C03111 extends ViewType<CCUPromoCardView> {
        C03111() {
        }

        public final View m7108a(Context context) {
            return new CCUPromoCardView(context);
        }
    }

    private static CCUPromoCardPartDefinition m7105b(InjectorLike injectorLike) {
        return new CCUPromoCardPartDefinition(ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), PeopleYouMayKnowAnalyticsLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    public final Object m7107a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) obj;
        subParts.a(2131561952, this.f6712c, StringFormatUtil.formatStrLocaleSafe(this.f6713d.getString(2131235591), ((User) this.f6716g.get()).h()));
        subParts.a(2131561954, this.f6711b, new 2(this));
        return null;
    }

    @Inject
    public CCUPromoCardPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, Context context, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, PeopleYouMayKnowAnalyticsLogger peopleYouMayKnowAnalyticsLogger, Provider<User> provider) {
        this.f6711b = clickListenerPartDefinition;
        this.f6712c = textPartDefinition;
        this.f6713d = context;
        this.f6714e = secureContextHelper;
        this.f6715f = uriIntentMapper;
        this.f6716g = provider;
        this.f6717h = peopleYouMayKnowAnalyticsLogger;
    }

    public static CCUPromoCardPartDefinition m7104a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CCUPromoCardPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6710j) {
                CCUPromoCardPartDefinition cCUPromoCardPartDefinition;
                if (a2 != null) {
                    cCUPromoCardPartDefinition = (CCUPromoCardPartDefinition) a2.a(f6710j);
                } else {
                    cCUPromoCardPartDefinition = f6709i;
                }
                if (cCUPromoCardPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7105b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6710j, b3);
                        } else {
                            f6709i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = cCUPromoCardPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<CCUPromoCardView> m7106a() {
        return f6708a;
    }
}

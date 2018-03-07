package com.facebook.feedplugins.pymi.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feedplugins.pymi.abtest.ExperimentsForPymiModule;
import com.facebook.feedplugins.pymi.views.FutureFriendingHeaderView;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: closeDrawer */
public class FutureFriendingHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLPeopleYouMayInviteFeedUnit>, Void, HasPositionInformation, FutureFriendingHeaderView> {
    public static final ViewType<FutureFriendingHeaderView> f8753a = new C10711();
    private static FutureFriendingHeaderPartDefinition f8754e;
    private static final Object f8755f = new Object();
    private final BackgroundPartDefinition f8756b;
    private final QeAccessor f8757c;
    private final TextPartDefinition f8758d;

    /* compiled from: closeDrawer */
    final class C10711 extends ViewType<FutureFriendingHeaderView> {
        C10711() {
        }

        public final View m9538a(Context context) {
            return new FutureFriendingHeaderView(context);
        }
    }

    private static FutureFriendingHeaderPartDefinition m9540b(InjectorLike injectorLike) {
        return new FutureFriendingHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m9542a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f8756b, new StylingData((FeedProps) obj, PaddingStyle.a));
        subParts.a(2131562473, this.f8758d, this.f8757c.a(ExperimentsForPymiModule.f8673c, ""));
        subParts.a(2131562474, this.f8758d, this.f8757c.a(ExperimentsForPymiModule.f8672b, ""));
        return null;
    }

    @Inject
    public FutureFriendingHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition, QeAccessor qeAccessor, TextPartDefinition textPartDefinition) {
        this.f8756b = backgroundPartDefinition;
        this.f8757c = qeAccessor;
        this.f8758d = textPartDefinition;
    }

    public final boolean m9543a(Object obj) {
        return true;
    }

    public static FutureFriendingHeaderPartDefinition m9539a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FutureFriendingHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8755f) {
                FutureFriendingHeaderPartDefinition futureFriendingHeaderPartDefinition;
                if (a2 != null) {
                    futureFriendingHeaderPartDefinition = (FutureFriendingHeaderPartDefinition) a2.a(f8755f);
                } else {
                    futureFriendingHeaderPartDefinition = f8754e;
                }
                if (futureFriendingHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9540b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8755f, b3);
                        } else {
                            f8754e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = futureFriendingHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<FutureFriendingHeaderView> m9541a() {
        return f8753a;
    }
}

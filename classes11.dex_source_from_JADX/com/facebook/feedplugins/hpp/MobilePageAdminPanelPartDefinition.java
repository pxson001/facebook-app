package com.facebook.feedplugins.hpp;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMobilePageAdminPanelFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_field_active */
public class MobilePageAdminPanelPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLMobilePageAdminPanelFeedUnit>, Void, FeedEnvironment> {
    private static MobilePageAdminPanelPartDefinition f7795c;
    private static final Object f7796d = new Object();
    private final MobilePageAdminPanelHeaderPartDefinition f7797a;
    private final MobilePageAdminPanelBodyPartDefinition<FeedEnvironment> f7798b;

    private static MobilePageAdminPanelPartDefinition m8964b(InjectorLike injectorLike) {
        return new MobilePageAdminPanelPartDefinition(MobilePageAdminPanelHeaderPartDefinition.m8956a(injectorLike), MobilePageAdminPanelBodyPartDefinition.m8950a(injectorLike));
    }

    public final Object m8965a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f7797a, feedProps);
        baseMultiRowSubParts.a(this.f7798b, feedProps);
        return null;
    }

    @Inject
    public MobilePageAdminPanelPartDefinition(MobilePageAdminPanelHeaderPartDefinition mobilePageAdminPanelHeaderPartDefinition, MobilePageAdminPanelBodyPartDefinition mobilePageAdminPanelBodyPartDefinition) {
        this.f7797a = mobilePageAdminPanelHeaderPartDefinition;
        this.f7798b = mobilePageAdminPanelBodyPartDefinition;
    }

    public final boolean m8966a(Object obj) {
        return true;
    }

    public static MobilePageAdminPanelPartDefinition m8963a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MobilePageAdminPanelPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7796d) {
                MobilePageAdminPanelPartDefinition mobilePageAdminPanelPartDefinition;
                if (a2 != null) {
                    mobilePageAdminPanelPartDefinition = (MobilePageAdminPanelPartDefinition) a2.a(f7796d);
                } else {
                    mobilePageAdminPanelPartDefinition = f7795c;
                }
                if (mobilePageAdminPanelPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8964b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7796d, b3);
                        } else {
                            f7795c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mobilePageAdminPanelPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

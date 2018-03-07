package com.facebook.timeline.editfeaturedcontainers.rows;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.editfeaturedcontainers.models.RecentSectionData;
import com.facebook.timeline.editfeaturedcontainers.rows.NullStateSectionTitlePartDefinition.Props;
import javax.inject.Inject;

@ContextScoped
/* compiled from: getSuggestedBots */
public class NullStateRecentSectionPartDefinition extends BaseMultiRowGroupPartDefinition<RecentSectionData, Void, AnyEnvironment> {
    private static NullStateRecentSectionPartDefinition f10827d;
    private static final Object f10828e = new Object();
    private final NullStateSectionTitlePartDefinition f10829a;
    private final NullStateYourPhotosPartDefinition f10830b;
    public final Resources f10831c;

    private static NullStateRecentSectionPartDefinition m10953b(InjectorLike injectorLike) {
        return new NullStateRecentSectionPartDefinition(NullStateSectionTitlePartDefinition.m10961a(injectorLike), NullStateYourPhotosPartDefinition.m10998a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m10954a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f10829a, new Props(this.f10831c.getString(2131241386), null));
        baseMultiRowSubParts.a(this.f10830b, null);
        return null;
    }

    @Inject
    public NullStateRecentSectionPartDefinition(NullStateSectionTitlePartDefinition nullStateSectionTitlePartDefinition, NullStateYourPhotosPartDefinition nullStateYourPhotosPartDefinition, Resources resources) {
        this.f10829a = nullStateSectionTitlePartDefinition;
        this.f10830b = nullStateYourPhotosPartDefinition;
        this.f10831c = resources;
    }

    public final boolean m10955a(Object obj) {
        return true;
    }

    public static NullStateRecentSectionPartDefinition m10952a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NullStateRecentSectionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f10828e) {
                NullStateRecentSectionPartDefinition nullStateRecentSectionPartDefinition;
                if (a2 != null) {
                    nullStateRecentSectionPartDefinition = (NullStateRecentSectionPartDefinition) a2.a(f10828e);
                } else {
                    nullStateRecentSectionPartDefinition = f10827d;
                }
                if (nullStateRecentSectionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10953b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f10828e, b3);
                        } else {
                            f10827d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = nullStateRecentSectionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

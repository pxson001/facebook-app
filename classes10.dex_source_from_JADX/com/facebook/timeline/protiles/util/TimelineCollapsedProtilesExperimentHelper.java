package com.facebook.timeline.protiles.util;

import android.content.Context;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLProfileTileSectionType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.model.ProtileModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fb4a_backgroundConfirmationAddPendingContactpoint */
public class TimelineCollapsedProtilesExperimentHelper {
    private static TimelineCollapsedProtilesExperimentHelper f12395c;
    private static final Object f12396d = new Object();
    public final QeAccessor f12397a;
    public final boolean f12398b;

    private static TimelineCollapsedProtilesExperimentHelper m12439b(InjectorLike injectorLike) {
        return new TimelineCollapsedProtilesExperimentHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), FbNetworkManager.a(injectorLike));
    }

    @Inject
    public TimelineCollapsedProtilesExperimentHelper(QeAccessor qeAccessor, FbNetworkManager fbNetworkManager) {
        this.f12397a = qeAccessor;
        this.f12398b = fbNetworkManager.g();
    }

    public final boolean m12443a() {
        return m12440c();
    }

    public final boolean m12444a(ProtileModel protileModel) {
        return m12441d(protileModel) || m12442e(protileModel);
    }

    public final boolean m12445c(ProtileModel protileModel) {
        return m12440c() || m12441d(protileModel) || m12442e(protileModel);
    }

    public static TimelineCollapsedProtilesExperimentHelper m12438a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineCollapsedProtilesExperimentHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12396d) {
                TimelineCollapsedProtilesExperimentHelper timelineCollapsedProtilesExperimentHelper;
                if (a2 != null) {
                    timelineCollapsedProtilesExperimentHelper = (TimelineCollapsedProtilesExperimentHelper) a2.a(f12396d);
                } else {
                    timelineCollapsedProtilesExperimentHelper = f12395c;
                }
                if (timelineCollapsedProtilesExperimentHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12439b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12396d, b3);
                        } else {
                            f12395c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineCollapsedProtilesExperimentHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private boolean m12440c() {
        if (this.f12398b) {
            return this.f12397a.a(ExperimentsForTimelineAbTestModule.w, false);
        }
        return this.f12397a.a(ExperimentsForTimelineAbTestModule.s, false);
    }

    private boolean m12441d(ProtileModel protileModel) {
        if (protileModel.m12109b() != GraphQLProfileTileSectionType.PHOTOS) {
            return false;
        }
        if (this.f12398b) {
            return this.f12397a.a(ExperimentsForTimelineAbTestModule.y, false);
        }
        return this.f12397a.a(ExperimentsForTimelineAbTestModule.u, false);
    }

    private boolean m12442e(ProtileModel protileModel) {
        if (protileModel.m12109b() != GraphQLProfileTileSectionType.FRIENDS) {
            return false;
        }
        if (this.f12398b) {
            return this.f12397a.a(ExperimentsForTimelineAbTestModule.x, false);
        }
        return this.f12397a.a(ExperimentsForTimelineAbTestModule.t, false);
    }
}

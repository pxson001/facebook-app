package com.facebook.timeline.aboutpage;

import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import javax.inject.Inject;

/* compiled from: NOTIFICATIONS */
public class CollectionsQeHelper {
    public final QeAccessor f13009a;

    public static CollectionsQeHelper m13763b(InjectorLike injectorLike) {
        return new CollectionsQeHelper((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public CollectionsQeHelper(QeAccessor qeAccessor) {
        this.f13009a = qeAccessor;
    }

    public final boolean m13764a() {
        return this.f13009a.a(ExperimentsForTimelineAbTestModule.q, false);
    }

    public final boolean m13765d() {
        return m13764a();
    }

    public static CollectionsQeHelper m13762a(InjectorLike injectorLike) {
        return m13763b(injectorLike);
    }

    public final boolean m13766f() {
        return this.f13009a.a(ExperimentsForTimelineAbTestModule.r, false);
    }
}

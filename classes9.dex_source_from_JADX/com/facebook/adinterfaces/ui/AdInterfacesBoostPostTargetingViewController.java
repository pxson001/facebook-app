package com.facebook.adinterfaces.ui;

import android.util.Pair;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: VERIFICATION_REASON_COMPLIANCE_WEEKLY_300 */
public class AdInterfacesBoostPostTargetingViewController extends AdInterfacesTargetingViewController<AdInterfacesBoostPostDataModel> {
    private QeAccessor f22602k;
    private AdInterfacesBoostPostDataModel f22603l;

    public static AdInterfacesBoostPostTargetingViewController m24522d(InjectorLike injectorLike) {
        return new AdInterfacesBoostPostTargetingViewController(AdInterfacesAudienceOptionsViewController.m24419b(injectorLike), AdInterfacesDataHelper.m22789a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        super.mo983a(baseAdInterfacesData);
        this.f22603l = baseAdInterfacesData;
    }

    @Inject
    public AdInterfacesBoostPostTargetingViewController(AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController, AdInterfacesDataHelper adInterfacesDataHelper, QeAccessor qeAccessor) {
        super(adInterfacesAudienceOptionsViewController, adInterfacesDataHelper);
        this.f22602k = qeAccessor;
    }

    public final void mo992a(AdInterfacesTargetingView adInterfacesTargetingView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo992a(adInterfacesTargetingView, adInterfacesCardLayout);
        if (this.f22602k.a(Liveness.Live, ExposureLogging.Off, ExperimentsForAdInterfacesModule.f21614k, false)) {
            List arrayList = new ArrayList();
            arrayList.add(new Pair(Integer.valueOf(2131560209), Integer.valueOf(2131234121)));
            arrayList.add(new Pair(Integer.valueOf(2131559258), Integer.valueOf(2131234122)));
            arrayList.add(new Pair(Integer.valueOf(2131559260), Integer.valueOf(2131234123)));
            arrayList.add(new Pair(Integer.valueOf(2131559340), Integer.valueOf(2131234124)));
            arrayList.add(new Pair(Integer.valueOf(2131559342), Integer.valueOf(2131234125)));
            arrayList.add(new Pair(Integer.valueOf(2131559346), Integer.valueOf(2131234126)));
            arrayList.add(new Pair(Integer.valueOf(2131559349), Integer.valueOf(2131234127)));
            arrayList.add(new Pair(Integer.valueOf(2131559259), Integer.valueOf(2131234128)));
            arrayList.add(new Pair(Integer.valueOf(2131560211), Integer.valueOf(2131234129)));
            this.f22440b.m22430a(adInterfacesCardLayout.m24583a(arrayList, "targeting"));
        }
        if (m24523f()) {
            m24455e(false);
            this.f22603l.f21754j.m22838a(GraphQLBoostedPostAudienceOption.NCPP);
            AdInterfacesUiUtil.m25237a(this.f22581e, 1);
            return;
        }
        m24455e(true);
        AdInterfacesUiUtil.m25237a(this.f22581e, 1);
    }

    protected final void mo993b(boolean z) {
        super.mo993b(z);
        if (m24523f()) {
            ((AdInterfacesTargetingView) this.f22581e).setLocationSelectorDividerVisibility(8);
        }
    }

    private boolean m24523f() {
        return this.f22603l.f21780a.m23711j() == null;
    }
}

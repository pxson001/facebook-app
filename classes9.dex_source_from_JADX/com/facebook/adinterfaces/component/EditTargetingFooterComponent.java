package com.facebook.adinterfaces.component;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.ui.AdInterfacesEditTargetingFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesFooterView;
import com.facebook.adinterfaces.ui.AdInterfacesLegalUtil;
import com.facebook.adinterfaces.ui.AdInterfacesViewController;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: _VirtualObject_ */
public class EditTargetingFooterComponent implements AdInterfacesComponent<AdInterfacesFooterView, AdInterfacesBoostPostDataModel> {
    private AdInterfacesEditTargetingFooterViewController f21632a;

    public static EditTargetingFooterComponent m22645b(InjectorLike injectorLike) {
        return new EditTargetingFooterComponent(new AdInterfacesEditTargetingFooterViewController(AdInterfacesLegalUtil.m24675a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), BoostedComponentLogger.m22753a(injectorLike)));
    }

    public final boolean mo947a(BaseAdInterfacesData baseAdInterfacesData) {
        baseAdInterfacesData = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
        if (!AdInterfacesDataHelper.m22811g(baseAdInterfacesData)) {
            return false;
        }
        if (baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.EXTENDABLE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.PAUSED) {
            return true;
        }
        return false;
    }

    @Inject
    EditTargetingFooterComponent(AdInterfacesEditTargetingFooterViewController adInterfacesEditTargetingFooterViewController) {
        this.f21632a = adInterfacesEditTargetingFooterViewController;
    }

    public final int mo946a() {
        return 2130903118;
    }

    public final AdInterfacesViewController<AdInterfacesFooterView, AdInterfacesBoostPostDataModel> mo948b() {
        return this.f21632a;
    }

    public final ComponentType mo949c() {
        return ComponentType.FOOTER;
    }
}

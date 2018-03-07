package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.util.Pair;
import android.view.View;
import com.facebook.adinterfaces.FBStepperWithLabel;
import com.facebook.adinterfaces.FBStepperWithLabel.StepperCallback;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DurationChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScheduleValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ScheduleValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedBudgetChangeEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_THREAD */
public class AdInterfacesDurationStepperViewController extends BaseAdInterfacesViewController<FBStepperWithLabel, AdInterfacesDataModel> {
    private final Resources f22686a;
    private final QeAccessor f22687b;
    public BaseAdInterfacesData f22688c;
    public int f22689d;
    private String f22690e;
    public AdInterfacesCardLayout f22691f;
    public FBStepperWithLabel f22692g;

    /* compiled from: V2_THREAD */
    class C26131 implements StepperCallback {
        final /* synthetic */ AdInterfacesDurationStepperViewController f22683a;

        C26131(AdInterfacesDurationStepperViewController adInterfacesDurationStepperViewController) {
            this.f22683a = adInterfacesDurationStepperViewController;
        }

        public final String mo944a(int i) {
            int i2 = this.f22683a.f22689d != i ? 1 : 0;
            this.f22683a.f22689d = i;
            AdInterfacesDurationStepperViewController.m24612c(this.f22683a);
            if (i2 != 0) {
                this.f22683a.f22688c.f21753i = this.f22683a.f22689d;
                this.f22683a.f22440b.m22429a(new DurationChangeEvent(this.f22683a.f22689d));
            }
            return this.f22683a.f22692g.getResources().getQuantityString(2131689577, this.f22683a.f22689d, new Object[]{Integer.valueOf(this.f22683a.f22689d)});
        }
    }

    /* compiled from: V2_THREAD */
    public class C26142 extends SelectedBudgetChangeEventSubscriber {
        final /* synthetic */ AdInterfacesDurationStepperViewController f22684a;

        public C26142(AdInterfacesDurationStepperViewController adInterfacesDurationStepperViewController) {
            this.f22684a = adInterfacesDurationStepperViewController;
        }

        public final void m24610b(FbEvent fbEvent) {
            AdInterfacesDurationStepperViewController.m24612c(this.f22684a);
        }
    }

    /* compiled from: V2_THREAD */
    public class C26153 extends ScheduleValidationEventSubscriber {
        final /* synthetic */ AdInterfacesDurationStepperViewController f22685a;

        public C26153(AdInterfacesDurationStepperViewController adInterfacesDurationStepperViewController) {
            this.f22685a = adInterfacesDurationStepperViewController;
        }

        public final void m24611b(FbEvent fbEvent) {
            this.f22685a.f22691f.m24584a(((ScheduleValidationEvent) fbEvent).f21655a);
        }
    }

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        FBStepperWithLabel fBStepperWithLabel = (FBStepperWithLabel) view;
        super.mo982a(fBStepperWithLabel, adInterfacesCardLayout);
        this.f22691f = adInterfacesCardLayout;
        this.f22692g = fBStepperWithLabel;
        this.f22690e = this.f22686a.getString(2131233900);
        this.f22692g.setStep(this.f22689d);
        fBStepperWithLabel.setStepperCallback(new C26131(this));
        this.f22440b.m22430a(new C26142(this));
        this.f22440b.m22430a(new C26153(this));
        if (this.f22687b.a(Liveness.Live, ExposureLogging.Off, ExperimentsForAdInterfacesModule.f21614k, false)) {
            List arrayList = new ArrayList();
            arrayList.add(new Pair(Integer.valueOf(2131560209), Integer.valueOf(2131234135)));
            arrayList.add(new Pair(Integer.valueOf(2131567646), Integer.valueOf(2131234136)));
            arrayList.add(new Pair(Integer.valueOf(2131567647), Integer.valueOf(2131234137)));
            arrayList.add(new Pair(Integer.valueOf(2131567648), Integer.valueOf(2131234138)));
            arrayList.add(new Pair(Integer.valueOf(2131560221), Integer.valueOf(2131234139)));
            arrayList.add(new Pair(Integer.valueOf(2131560211), Integer.valueOf(2131234129)));
            this.f22440b.m22430a(adInterfacesCardLayout.m24583a(arrayList, "duration"));
            return;
        }
        this.f22691f.m24585a(this.f22691f.getResources().getString(2131233883), 2130843651);
    }

    @Inject
    public AdInterfacesDurationStepperViewController(Resources resources, QeAccessor qeAccessor) {
        this.f22686a = resources;
        this.f22687b = qeAccessor;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22688c = baseAdInterfacesData;
        this.f22689d = baseAdInterfacesData.f21753i;
    }

    public final void mo981a() {
        super.mo981a();
        this.f22692g = null;
        this.f22691f = null;
    }

    public static void m24612c(AdInterfacesDurationStepperViewController adInterfacesDurationStepperViewController) {
        if (adInterfacesDurationStepperViewController.f22689d == 1) {
            adInterfacesDurationStepperViewController.f22691f.setFooterSpannableText(null);
            return;
        }
        CurrencyQuantityModel currencyQuantityModel = adInterfacesDurationStepperViewController.f22688c.f21750f;
        if (currencyQuantityModel == null) {
            adInterfacesDurationStepperViewController.f22691f.setFooterSpannableText(null);
            return;
        }
        adInterfacesDurationStepperViewController.f22691f.setFooterSpannableText(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(adInterfacesDurationStepperViewController.f22690e, BudgetHelper.m25097a(currencyQuantityModel.m23421j(), BudgetHelper.m25098a(currencyQuantityModel).longValue() / ((long) adInterfacesDurationStepperViewController.f22689d), BudgetHelper.m25107g(adInterfacesDurationStepperViewController.f22688c)))));
    }

    public final void mo984a(Bundle bundle) {
        bundle.putInt("duration", this.f22689d);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.f22692g.setStep(bundle.getInt("duration"));
        }
    }
}

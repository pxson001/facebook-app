package com.facebook.adinterfaces.ui;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedBudgetChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedBudgetChangeEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VG */
public class AdInterfacesFooterViewController<D extends AdInterfacesDataModel> extends BaseAdInterfacesViewController<AdInterfacesFooterView, D> {
    private final AdInterfacesLegalUtil f22588a;
    public D f22589b;
    public AdInterfacesFooterView f22590c;

    /* compiled from: VG */
    class C26251 extends DataValidationEventSubscriber {
        final /* synthetic */ AdInterfacesFooterViewController f22726a;

        C26251(AdInterfacesFooterViewController adInterfacesFooterViewController) {
            this.f22726a = adInterfacesFooterViewController;
        }

        public final void m24646b(FbEvent fbEvent) {
            DataValidationEvent dataValidationEvent = (DataValidationEvent) fbEvent;
            this.f22726a.f22590c.setCreateAdButtonEnabled(dataValidationEvent.f21658a);
            this.f22726a.f22590c.setAddBudgetButtonEnabled(dataValidationEvent.f21658a);
        }
    }

    /* compiled from: VG */
    class C26262 extends SelectedBudgetChangeEventSubscriber {
        final /* synthetic */ AdInterfacesFooterViewController f22727a;

        C26262(AdInterfacesFooterViewController adInterfacesFooterViewController) {
            this.f22727a = adInterfacesFooterViewController;
        }

        public final void m24647b(FbEvent fbEvent) {
            this.f22727a.mo997b(((SelectedBudgetChangeEvent) fbEvent).f21676a);
        }
    }

    /* compiled from: VG */
    class C26273 implements OnClickListener {
        final /* synthetic */ AdInterfacesFooterViewController f22728a;

        C26273(AdInterfacesFooterViewController adInterfacesFooterViewController) {
            this.f22728a = adInterfacesFooterViewController;
        }

        public void onClick(View view) {
            Logger.a(2, EntryType.UI_INPUT_END, -941500933, Logger.a(2, EntryType.UI_INPUT_START, -2051425788));
        }
    }

    public static AdInterfacesFooterViewController m24477a(InjectorLike injectorLike) {
        return new AdInterfacesFooterViewController(AdInterfacesLegalUtil.m24675a(injectorLike));
    }

    @Inject
    public AdInterfacesFooterViewController(AdInterfacesLegalUtil adInterfacesLegalUtil) {
        this.f22588a = adInterfacesLegalUtil;
    }

    public static AdInterfacesFooterViewController m24478b(InjectorLike injectorLike) {
        return m24477a(injectorLike);
    }

    private void m24479m() {
        this.f22440b.m22430a(new C26251(this));
        this.f22440b.m22430a(new C26262(this));
    }

    public void mo983a(D d) {
        this.f22589b = d;
    }

    public void mo1005a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesFooterView, adInterfacesCardLayout);
        this.f22590c = adInterfacesFooterView;
        m24479m();
        m24480n();
        mo997b(this.f22589b.f21750f);
        mo999d();
        m24481o();
        mo1003h();
        boolean a = this.f22440b.m22432a();
        this.f22590c.setCreateAdButtonEnabled(a);
        this.f22590c.setAddBudgetButtonEnabled(a);
    }

    private void m24480n() {
        this.f22590c.setLegalDisclaimerContent(this.f22588a.m24678a());
        this.f22590c.setLegalDisclaimerMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void mo999d() {
    }

    private void m24481o() {
        this.f22590c.setCreateAdButtonListener(mo996b());
        this.f22590c.setAddBudgetButtonListener(mo1000e());
        this.f22590c.setResumeAdButtonListener(mo1001f());
        this.f22590c.setPauseAdButtonListener(mo1002g());
        this.f22590c.setDeleteAdButtonListener(mo998c());
    }

    protected void mo1003h() {
        this.f22590c.setCreateAdButtonVisibility(0);
        this.f22590c.setAddBudgetButtonVisibility(8);
        this.f22590c.setResumeAdButtonVisibility(8);
        this.f22590c.setPauseAdButtonVisibility(8);
        this.f22590c.setDeleteAdButtonVisibility(8);
    }

    protected OnClickListener mo996b() {
        return new C26273(this);
    }

    protected OnClickListener mo1000e() {
        return null;
    }

    protected OnClickListener mo1001f() {
        return null;
    }

    protected OnClickListener mo1002g() {
        return null;
    }

    protected OnClickListener mo998c() {
        return null;
    }

    public void mo981a() {
        super.mo981a();
        this.f22590c = null;
    }

    protected void mo997b(CurrencyQuantityModel currencyQuantityModel) {
        if (currencyQuantityModel == null) {
            this.f22590c.setCreateAdButtonText(mo995a(null));
            return;
        }
        this.f22590c.setCreateAdButtonText(mo995a(BudgetHelper.m25097a(currencyQuantityModel.m23421j(), BudgetHelper.m25098a(currencyQuantityModel).longValue(), BudgetHelper.m25107g(this.f22589b))));
    }

    protected final AdInterfacesFooterView m24496j() {
        return this.f22590c;
    }

    protected String mo995a(@Nullable String str) {
        if (str == null) {
            return this.f22590c.getContext().getString(2131234070);
        }
        if (BudgetHelper.m25102b(this.f22589b) && (this.f22589b instanceof AdInterfacesBoostedComponentDataModel)) {
            return this.f22590c.getContext().getString(2131234027, new Object[]{str});
        }
        return this.f22590c.getContext().getString(2131234028, new Object[]{str});
    }

    protected String mo994a(CurrencyQuantityModel currencyQuantityModel) {
        return this.f22590c.getContext().getString(2131233983);
    }
}

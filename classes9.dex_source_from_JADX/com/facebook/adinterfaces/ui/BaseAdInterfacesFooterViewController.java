package com.facebook.adinterfaces.ui;

import android.view.View.OnClickListener;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;

/* compiled from: V2_TRENDING_GIFS */
public abstract class BaseAdInterfacesFooterViewController extends BaseAdInterfacesViewController<AdInterfacesFooterView, AdInterfacesDataModel> {
    public BaseAdInterfacesData f22681a;
    public AdInterfacesFooterView f22682b;

    protected abstract void mo1009b();

    public abstract OnClickListener mo1010c();

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22681a = baseAdInterfacesData;
    }

    public void mo1008a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesFooterView, adInterfacesCardLayout);
        this.f22682b = adInterfacesFooterView;
        mo1009b();
        this.f22682b.setCreateAdButtonListener(mo1010c());
        this.f22682b.setCreateAdButtonVisibility(0);
        this.f22682b.setAddBudgetButtonVisibility(8);
        this.f22682b.setResumeAdButtonVisibility(8);
        this.f22682b.setPauseAdButtonVisibility(8);
        this.f22682b.setDeleteAdButtonVisibility(8);
    }

    public void mo981a() {
        super.mo981a();
        this.f22682b = null;
    }
}

package com.facebook.adinterfaces.objective;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.AdInterfacesSavedButtonSpecProvider;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.objective.HasNavbarButtonSpec.ButtonListener;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.adinterfaces.ui.AdInterfacesSaveFooterViewController;
import com.facebook.adinterfaces.ui.BoostedComponentBudgetViewController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [[phone_number]] */
public class BoostedComponentEditBudgetObjective implements AdInterfacesObjective, HasNavbarButtonSpec {
    ImmutableList<AdInterfacesComponent> f21871g;
    public final EditBoostedComponentMethod f21872h;
    private final AdInterfacesSavedButtonSpecProvider f21873i;
    public AdInterfacesBoostedComponentDataModel f21874j;

    /* compiled from: [[phone_number]] */
    class C25281 implements ButtonListener {
        final /* synthetic */ BoostedComponentEditBudgetObjective f21870a;

        C25281(BoostedComponentEditBudgetObjective boostedComponentEditBudgetObjective) {
            this.f21870a = boostedComponentEditBudgetObjective;
        }

        public final void mo970a(Context context) {
            if (AdInterfacesDataHelper.m22814j(this.f21870a.f21874j)) {
                this.f21870a.f21872h.m24072b(this.f21870a.f21874j, context);
            }
        }
    }

    @Inject
    public BoostedComponentEditBudgetObjective(EditBoostedComponentMethod editBoostedComponentMethod, AdInterfacesSavedButtonSpecProvider adInterfacesSavedButtonSpecProvider, BoostedComponentBudgetViewController boostedComponentBudgetViewController, AdInterfacesSaveFooterViewController adInterfacesSaveFooterViewController, QeAccessor qeAccessor) {
        this.f21872h = editBoostedComponentMethod;
        this.f21873i = adInterfacesSavedButtonSpecProvider;
        Builder c = new Builder().c(new AdInterfacesInlineComponent(2130903107, boostedComponentBudgetViewController, a, ComponentType.BUDGET));
        if (!qeAccessor.a(ExperimentsForAdInterfacesModule.f21606c, false)) {
            c.c(new AdInterfacesInlineComponent(2130903118, adInterfacesSaveFooterViewController, a, ComponentType.FOOTER));
        }
        this.f21871g = c.b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21871g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21874j = (AdInterfacesBoostedComponentDataModel) intent.getParcelableExtra("data");
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(this.f21874j);
    }

    public final TitleBarButtonSpec mo971b() {
        return this.f21873i.m22511a();
    }

    public final ButtonListener mo972c() {
        return new C25281(this);
    }
}

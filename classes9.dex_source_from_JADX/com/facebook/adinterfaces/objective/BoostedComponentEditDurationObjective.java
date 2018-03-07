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
import com.facebook.adinterfaces.ui.AdInterfacesScheduleViewController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: [[learn_more_link]] */
public class BoostedComponentEditDurationObjective implements AdInterfacesObjective, HasNavbarButtonSpec {
    ImmutableList<AdInterfacesComponent> f21887g;
    public final EditBoostedComponentMethod f21888h;
    private final AdInterfacesSavedButtonSpecProvider f21889i;
    public AdInterfacesBoostedComponentDataModel f21890j;

    /* compiled from: [[learn_more_link]] */
    class C25331 implements ButtonListener {
        final /* synthetic */ BoostedComponentEditDurationObjective f21886a;

        C25331(BoostedComponentEditDurationObjective boostedComponentEditDurationObjective) {
            this.f21886a = boostedComponentEditDurationObjective;
        }

        public final void mo970a(Context context) {
            if (AdInterfacesDataHelper.m22814j(this.f21886a.f21890j)) {
                this.f21886a.f21888h.m24072b(this.f21886a.f21890j, context);
            }
        }
    }

    @Inject
    public BoostedComponentEditDurationObjective(EditBoostedComponentMethod editBoostedComponentMethod, AdInterfacesSavedButtonSpecProvider adInterfacesSavedButtonSpecProvider, AdInterfacesScheduleViewController adInterfacesScheduleViewController, AdInterfacesSaveFooterViewController adInterfacesSaveFooterViewController, QeAccessor qeAccessor) {
        this.f21888h = editBoostedComponentMethod;
        this.f21889i = adInterfacesSavedButtonSpecProvider;
        Builder c = new Builder().c(new AdInterfacesInlineComponent(2130903140, adInterfacesScheduleViewController, a, ComponentType.DURATION));
        if (!qeAccessor.a(ExperimentsForAdInterfacesModule.f21606c, false)) {
            c.c(new AdInterfacesInlineComponent(2130903118, adInterfacesSaveFooterViewController, a, ComponentType.FOOTER));
        }
        this.f21887g = c.b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21887g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21890j = (AdInterfacesBoostedComponentDataModel) intent.getParcelableExtra("data");
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(this.f21890j);
    }

    public final TitleBarButtonSpec mo971b() {
        return this.f21889i.m22511a();
    }

    public final ButtonListener mo972c() {
        return new C25331(this);
    }
}

package com.facebook.adinterfaces.objective;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.AdInterfacesSavedButtonSpecProvider;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.SpacerComponent;
import com.facebook.adinterfaces.component.ValidationComponent;
import com.facebook.adinterfaces.events.AdInterfacesEventBus;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.objective.HasNavbarButtonSpec.ButtonListener;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentCreativeModel;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.adinterfaces.ui.AdCreativeController;
import com.facebook.adinterfaces.ui.AdInterfacesAddressViewController;
import com.facebook.adinterfaces.ui.AdInterfacesCallToActionViewController;
import com.facebook.adinterfaces.ui.AdInterfacesDoneFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPhoneNumberViewController;
import com.facebook.adinterfaces.ui.AdInterfacesSaveFooterViewController;
import com.facebook.adinterfaces.ui.AdInterfacesUrlViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: [[link_learn_more]] */
public class BoostedComponentEditCreativeObjective implements AdInterfacesObjective, HasNavbarButtonSpec {
    public final AdInterfacesEventBus f21879g;
    private final AdInterfacesSavedButtonSpecProvider f21880h;
    public final EditBoostedComponentMethod f21881i;
    private ImmutableList<AdInterfacesComponent> f21882j;
    private final AdInterfacesComponentStatus f21883k = new C25291(this);
    private final AdInterfacesComponentStatus f21884l = new C25302(this);
    public AdInterfacesBoostedComponentDataModel f21885m;

    /* compiled from: [[link_learn_more]] */
    class C25291 implements AdInterfacesComponentStatus {
        final /* synthetic */ BoostedComponentEditCreativeObjective f21875a;

        C25291(BoostedComponentEditCreativeObjective boostedComponentEditCreativeObjective) {
            this.f21875a = boostedComponentEditCreativeObjective;
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            return (baseAdInterfacesData.mo962b() == ObjectiveType.LOCAL_AWARENESS_EDIT_CREATIVE ? 1 : null) != null && AdInterfacesObjective.f21835f.mo967a(baseAdInterfacesData);
        }
    }

    /* compiled from: [[link_learn_more]] */
    class C25302 implements AdInterfacesComponentStatus {
        final /* synthetic */ BoostedComponentEditCreativeObjective f21876a;

        C25302(BoostedComponentEditCreativeObjective boostedComponentEditCreativeObjective) {
            this.f21876a = boostedComponentEditCreativeObjective;
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            return AdInterfacesDataHelper.m22811g(baseAdInterfacesData) && AdInterfacesDataHelper.m22814j(baseAdInterfacesData);
        }
    }

    /* compiled from: [[link_learn_more]] */
    class C25313 implements ButtonListener {
        final /* synthetic */ BoostedComponentEditCreativeObjective f21877a;

        C25313(BoostedComponentEditCreativeObjective boostedComponentEditCreativeObjective) {
            this.f21877a = boostedComponentEditCreativeObjective;
        }

        public final void mo970a(Context context) {
            if (AdInterfacesDataHelper.m22814j(this.f21877a.f21885m)) {
                this.f21877a.f21881i.m24072b(this.f21877a.f21885m, context);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("CREATIVE_EDIT_DATA", this.f21877a.f21885m);
            this.f21877a.f21879g.a(new IntentEvent(intent, true));
        }
    }

    /* compiled from: [[link_learn_more]] */
    public /* synthetic */ class C25324 {
        public static final /* synthetic */ int[] f21878a = new int[ObjectiveType.values().length];

        static {
            try {
                f21878a[ObjectiveType.LOCAL_AWARENESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21878a[ObjectiveType.PAGE_LIKE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21878a[ObjectiveType.PROMOTE_WEBSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21878a[ObjectiveType.PROMOTE_CTA.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static BoostedComponentEditCreativeObjective m22950b(InjectorLike injectorLike) {
        return new BoostedComponentEditCreativeObjective(ValidationComponent.m22719b(injectorLike), AdCreativeController.m24321b(injectorLike), AdInterfacesPhoneNumberViewController.m24829b(injectorLike), AdInterfacesAddressViewController.m24387b(injectorLike), AdInterfacesCallToActionViewController.m24548a(injectorLike), AdInterfacesUrlViewController.m24980b(injectorLike), AdInterfacesDoneFooterViewController.m24604a(injectorLike), AdInterfacesEventBus.m22728a(injectorLike), AdInterfacesSavedButtonSpecProvider.m22510b(injectorLike), SpacerComponent.m22703a(injectorLike), AdInterfacesSaveFooterViewController.m24859b(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    BoostedComponentEditCreativeObjective(ValidationComponent validationComponent, AdCreativeController adCreativeController, AdInterfacesPhoneNumberViewController adInterfacesPhoneNumberViewController, AdInterfacesAddressViewController adInterfacesAddressViewController, AdInterfacesCallToActionViewController adInterfacesCallToActionViewController, AdInterfacesUrlViewController adInterfacesUrlViewController, AdInterfacesDoneFooterViewController adInterfacesDoneFooterViewController, AdInterfacesEventBus adInterfacesEventBus, AdInterfacesSavedButtonSpecProvider adInterfacesSavedButtonSpecProvider, SpacerComponent spacerComponent, AdInterfacesSaveFooterViewController adInterfacesSaveFooterViewController, EditBoostedComponentMethod editBoostedComponentMethod, QeAccessor qeAccessor) {
        this.f21879g = adInterfacesEventBus;
        this.f21880h = adInterfacesSavedButtonSpecProvider;
        this.f21881i = editBoostedComponentMethod;
        Builder c = new Builder().c(validationComponent).c(new AdInterfacesInlineComponent(2130903113, adCreativeController, a, ComponentType.AD_CREATIVE)).c(new AdInterfacesInlineComponent(2130903110, adInterfacesCallToActionViewController, this.f21883k, ComponentType.CALL_TO_ACTION)).c(new AdInterfacesInlineComponent(2130903108, adInterfacesPhoneNumberViewController, this.f21883k, ComponentType.PHONE_NUMBER)).c(new AdInterfacesInlineComponent(2130903120, adInterfacesAddressViewController, this.f21883k, ComponentType.ADDRESS)).c(new AdInterfacesInlineComponent(2130903154, adInterfacesUrlViewController, this.f21883k, ComponentType.WEBSITE_URL)).c(spacerComponent);
        if (!qeAccessor.a(ExperimentsForAdInterfacesModule.f21606c, false)) {
            c.c(new AdInterfacesInlineComponent(2130903118, adInterfacesDoneFooterViewController, f, ComponentType.FOOTER)).c(new AdInterfacesInlineComponent(2130903118, adInterfacesSaveFooterViewController, this.f21884l, ComponentType.FOOTER));
        }
        this.f21882j = c.b();
    }

    public static ObjectiveType m22951c(BaseAdInterfacesData baseAdInterfacesData) {
        if (AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
            ObjectiveType objectiveType;
            switch (C25324.f21878a[baseAdInterfacesData.mo962b().ordinal()]) {
                case 2:
                    objectiveType = ObjectiveType.PAGE_LIKE_EDIT_RUNNING_CREATIVE;
                    break;
                default:
                    objectiveType = null;
                    break;
            }
            return objectiveType;
        }
        switch (C25324.f21878a[baseAdInterfacesData.mo962b().ordinal()]) {
            case 1:
                return ObjectiveType.LOCAL_AWARENESS_EDIT_CREATIVE;
            case 2:
                return ObjectiveType.PAGE_LIKE_EDIT_CREATIVE;
            case 3:
                return ObjectiveType.PROMOTE_WEBSITE_EDIT_CREATIVE;
            case 4:
                return ObjectiveType.PROMOTE_CTA_EDIT_CREATIVE;
            default:
                return null;
        }
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21882j;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        BaseAdInterfacesData baseAdInterfacesData = (AdInterfacesBoostedComponentDataModel) intent.getParcelableExtra("data");
        if (AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
            CreativeAdModel creativeAdModel;
            BaseAdInterfacesData baseAdInterfacesData2 = (AdInterfacesBoostedComponentDataModel) new AdInterfacesBoostedComponentDataModel.Builder().mo950a();
            baseAdInterfacesData2.f21748d = baseAdInterfacesData.f21748d;
            baseAdInterfacesData2.f21747c = baseAdInterfacesData.f21747c;
            baseAdInterfacesData2.f21799d = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21799d;
            baseAdInterfacesData2.f21746b = baseAdInterfacesData.mo962b();
            baseAdInterfacesData2.f21797b = ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b;
            AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
            BoostedComponentCreativeModel o = adInterfacesBoostedComponentDataModel.f21797b.m23348o();
            if (o == null) {
                creativeAdModel = null;
            } else {
                CreativeAdModel.Builder builder = new CreativeAdModel.Builder();
                builder.f21762c = adInterfacesBoostedComponentDataModel.f21747c;
                builder.f21760a = adInterfacesBoostedComponentDataModel.mo951C().f21774g;
                builder.f21764e = o.m23269j();
                if (o.m23270k() != null) {
                    builder.f21767h = o.m23270k().m23240a();
                }
                creativeAdModel = builder.m22863a();
            }
            baseAdInterfacesData2.mo952a(creativeAdModel);
            AdminInfoModel.Builder builder2 = new AdminInfoModel.Builder();
            AdAccountsModel.Builder builder3 = new AdAccountsModel.Builder();
            builder3.f21981a = ImmutableList.of(AdInterfacesDataHelper.m22806e(baseAdInterfacesData));
            builder2.f21989a = builder3.m23153a();
            baseAdInterfacesData2.f21745a = builder2.m23179a();
            BaseAdInterfacesData baseAdInterfacesData3 = baseAdInterfacesData2;
            this.f21885m = baseAdInterfacesData3;
            adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(baseAdInterfacesData3);
            return;
        }
        baseAdInterfacesData.f21746b = m22951c(baseAdInterfacesData);
        this.f21885m = baseAdInterfacesData;
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(baseAdInterfacesData);
    }

    public final TitleBarButtonSpec mo971b() {
        return this.f21880h.m22511a();
    }

    public final ButtonListener mo972c() {
        return new C25313(this);
    }
}

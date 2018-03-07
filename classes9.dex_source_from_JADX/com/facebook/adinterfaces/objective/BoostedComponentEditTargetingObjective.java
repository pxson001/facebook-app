package com.facebook.adinterfaces.objective;

import android.content.Context;
import android.content.Intent;
import com.facebook.adinterfaces.AdInterfacesSavedButtonSpecProvider;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.objective.HasNavbarButtonSpec.ButtonListener;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.adinterfaces.ui.AdInterfacesEditTargetingInfoViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesPageLikeUnifiedTargetingViewController;
import com.facebook.adinterfaces.ui.AdInterfacesSaveFooterViewController;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: [[facebook_terms_link]] */
public class BoostedComponentEditTargetingObjective implements AdInterfacesObjective, HasNavbarButtonSpec {
    ImmutableList<AdInterfacesComponent> f21895g;
    AdInterfacesComponentStatus f21896h = new C25341(this);
    AdInterfacesComponentStatus f21897i = new C25352(this);
    public final EditBoostedComponentMethod f21898j;
    private final AdInterfacesSavedButtonSpecProvider f21899k;
    public AdInterfacesBoostedComponentDataModel f21900l;

    /* compiled from: [[facebook_terms_link]] */
    class C25341 implements AdInterfacesComponentStatus {
        final /* synthetic */ BoostedComponentEditTargetingObjective f21891a;

        C25341(BoostedComponentEditTargetingObjective boostedComponentEditTargetingObjective) {
            this.f21891a = boostedComponentEditTargetingObjective;
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            return AdInterfacesObjective.f21830a.mo967a(baseAdInterfacesData) && !BoostedComponentEditTargetingObjective.m22964a(this.f21891a, baseAdInterfacesData.mo962b());
        }
    }

    /* compiled from: [[facebook_terms_link]] */
    class C25352 implements AdInterfacesComponentStatus {
        final /* synthetic */ BoostedComponentEditTargetingObjective f21892a;

        C25352(BoostedComponentEditTargetingObjective boostedComponentEditTargetingObjective) {
            this.f21892a = boostedComponentEditTargetingObjective;
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            return AdInterfacesObjective.f21830a.mo967a(baseAdInterfacesData) && BoostedComponentEditTargetingObjective.m22964a(this.f21892a, baseAdInterfacesData.mo962b());
        }
    }

    /* compiled from: [[facebook_terms_link]] */
    class C25363 implements ButtonListener {
        final /* synthetic */ BoostedComponentEditTargetingObjective f21893a;

        C25363(BoostedComponentEditTargetingObjective boostedComponentEditTargetingObjective) {
            this.f21893a = boostedComponentEditTargetingObjective;
        }

        public final void mo970a(Context context) {
            if (AdInterfacesDataHelper.m22814j(this.f21893a.f21900l)) {
                this.f21893a.f21898j.m24072b(this.f21893a.f21900l, context);
            }
        }
    }

    /* compiled from: [[facebook_terms_link]] */
    public /* synthetic */ class C25374 {
        public static final /* synthetic */ int[] f21894a = new int[ObjectiveType.values().length];

        static {
            try {
                f21894a[ObjectiveType.PAGE_LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21894a[ObjectiveType.PROMOTE_CTA.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21894a[ObjectiveType.PROMOTE_WEBSITE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static BoostedComponentEditTargetingObjective m22965b(InjectorLike injectorLike) {
        return new BoostedComponentEditTargetingObjective(EditBoostedComponentMethod.m24067a(injectorLike), AdInterfacesSavedButtonSpecProvider.m22510b(injectorLike), AdInterfacesEditTargetingInfoViewController.m24627a(injectorLike), AdInterfacesPageLikeTargetingViewController.m24791d(injectorLike), AdInterfacesSaveFooterViewController.m24859b(injectorLike), AdInterfacesPageLikeUnifiedTargetingViewController.m24810d(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    static /* synthetic */ boolean m22964a(BoostedComponentEditTargetingObjective boostedComponentEditTargetingObjective, ObjectiveType objectiveType) {
        boolean z;
        switch (C25374.f21894a[objectiveType.ordinal()]) {
            case 1:
            case 2:
            case 3:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    @Inject
    BoostedComponentEditTargetingObjective(EditBoostedComponentMethod editBoostedComponentMethod, AdInterfacesSavedButtonSpecProvider adInterfacesSavedButtonSpecProvider, AdInterfacesEditTargetingInfoViewController adInterfacesEditTargetingInfoViewController, AdInterfacesPageLikeTargetingViewController adInterfacesPageLikeTargetingViewController, AdInterfacesSaveFooterViewController adInterfacesSaveFooterViewController, AdInterfacesPageLikeUnifiedTargetingViewController adInterfacesPageLikeUnifiedTargetingViewController, QeAccessor qeAccessor) {
        this.f21898j = editBoostedComponentMethod;
        this.f21899k = adInterfacesSavedButtonSpecProvider;
        Builder c = new Builder().c(new AdInterfacesInlineComponent(2130903121, adInterfacesEditTargetingInfoViewController, a, ComponentType.INFO_CARD)).c(new AdInterfacesInlineComponent(2130903147, adInterfacesPageLikeTargetingViewController, this.f21896h, ComponentType.TARGETING)).c(new AdInterfacesInlineComponent(2130903151, adInterfacesPageLikeUnifiedTargetingViewController, this.f21897i, ComponentType.TARGETING));
        if (!qeAccessor.a(ExperimentsForAdInterfacesModule.f21606c, false)) {
            c.c(new AdInterfacesInlineComponent(2130903118, adInterfacesSaveFooterViewController, a, ComponentType.FOOTER));
        }
        this.f21895g = c.b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21895g;
    }

    public final void mo969a(Intent intent, AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        this.f21900l = (AdInterfacesBoostedComponentDataModel) intent.getParcelableExtra("data");
        adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(this.f21900l);
    }

    public final TitleBarButtonSpec mo971b() {
        return this.f21899k.m22511a();
    }

    public final ButtonListener mo972c() {
        return new C25363(this);
    }
}

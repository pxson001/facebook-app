package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.CreateBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: VERBOSE */
public class AdInterfacesBoostedAppFooterViewController extends AdInterfacesFooterViewController<AdInterfacesDataModel> {
    public final CreateBoostedComponentMethod f22612a;
    public final EditBoostedComponentMethod f22613b;
    public AdInterfacesBoostedComponentDataModel f22614c;
    public AdInterfacesFooterView f22615d;

    /* compiled from: VERBOSE */
    class C25941 implements OnClickListener {
        final /* synthetic */ AdInterfacesBoostedAppFooterViewController f22609a;

        C25941(AdInterfacesBoostedAppFooterViewController adInterfacesBoostedAppFooterViewController) {
            this.f22609a = adInterfacesBoostedAppFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 82658103);
            this.f22609a.f22612a.m24057a(this.f22609a.f22440b, this.f22609a.f22614c, this.f22609a.f22615d.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -1981131325, a);
        }
    }

    /* compiled from: VERBOSE */
    class C25952 implements OnClickListener {
        final /* synthetic */ AdInterfacesBoostedAppFooterViewController f22610a;

        C25952(AdInterfacesBoostedAppFooterViewController adInterfacesBoostedAppFooterViewController) {
            this.f22610a = adInterfacesBoostedAppFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -352318390);
            this.f22610a.f22614c.f21748d = AdInterfacesStatus.ACTIVE;
            this.f22610a.f22613b.m24070a(this.f22610a.f22614c, this.f22610a.f22615d.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 513800946, a);
        }
    }

    public static AdInterfacesBoostedAppFooterViewController m24534c(InjectorLike injectorLike) {
        return new AdInterfacesBoostedAppFooterViewController(AdInterfacesLegalUtil.m24675a(injectorLike), CreateBoostedComponentMethod.m24054a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike));
    }

    @Inject
    public AdInterfacesBoostedAppFooterViewController(AdInterfacesLegalUtil adInterfacesLegalUtil, CreateBoostedComponentMethod createBoostedComponentMethod, EditBoostedComponentMethod editBoostedComponentMethod) {
        super(adInterfacesLegalUtil);
        this.f22612a = createBoostedComponentMethod;
        this.f22613b = editBoostedComponentMethod;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        super.mo983a(baseAdInterfacesData);
        this.f22614c = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
    }

    public final void mo1005a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1005a(adInterfacesFooterView, adInterfacesCardLayout);
        this.f22615d = adInterfacesFooterView;
    }

    public final void mo981a() {
        this.f22615d = null;
    }

    protected final OnClickListener mo996b() {
        return new C25941(this);
    }

    protected final OnClickListener mo1001f() {
        return new C25952(this);
    }

    protected final void mo1003h() {
        switch (this.f22614c.f21748d) {
            case INACTIVE:
            case REJECTED:
            case FINISHED:
            case NEVER_BOOSTED:
                this.f22590c.setCreateAdButtonVisibility(0);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
            case PAUSED:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(0);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
            default:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(8);
                this.f22590c.setResumeAdButtonVisibility(8);
                this.f22590c.setPauseAdButtonVisibility(8);
                this.f22590c.setDeleteAdButtonVisibility(8);
                return;
        }
    }
}

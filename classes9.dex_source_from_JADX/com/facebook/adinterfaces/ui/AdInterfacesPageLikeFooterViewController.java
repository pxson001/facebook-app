package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.CreateBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: V2_BYMM */
public class AdInterfacesPageLikeFooterViewController extends AdInterfacesFooterViewController {
    public final CreateBoostedComponentMethod f22846a;
    public final EditBoostedComponentMethod f22847b;
    public AdInterfacesBoostedComponentDataModel f22848c;

    /* compiled from: V2_BYMM */
    class C26541 implements OnClickListener {
        final /* synthetic */ AdInterfacesPageLikeFooterViewController f22842a;

        C26541(AdInterfacesPageLikeFooterViewController adInterfacesPageLikeFooterViewController) {
            this.f22842a = adInterfacesPageLikeFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2078590662);
            this.f22842a.f22846a.m24057a(this.f22842a.f22440b, this.f22842a.f22848c, this.f22842a.f22590c.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 901132748, a);
        }
    }

    /* compiled from: V2_BYMM */
    class C26552 implements OnClickListener {
        final /* synthetic */ AdInterfacesPageLikeFooterViewController f22843a;

        C26552(AdInterfacesPageLikeFooterViewController adInterfacesPageLikeFooterViewController) {
            this.f22843a = adInterfacesPageLikeFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -793741025);
            this.f22843a.f22847b.m24070a(this.f22843a.f22848c, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, -207058469, a);
        }
    }

    /* compiled from: V2_BYMM */
    class C26563 implements OnClickListener {
        final /* synthetic */ AdInterfacesPageLikeFooterViewController f22844a;

        C26563(AdInterfacesPageLikeFooterViewController adInterfacesPageLikeFooterViewController) {
            this.f22844a = adInterfacesPageLikeFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 468751104);
            this.f22844a.f22848c.f21748d = AdInterfacesStatus.ACTIVE;
            this.f22844a.f22847b.m24070a(this.f22844a.f22848c, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1502714529, a);
        }
    }

    public static AdInterfacesPageLikeFooterViewController m24783c(InjectorLike injectorLike) {
        return new AdInterfacesPageLikeFooterViewController(AdInterfacesLegalUtil.m24675a(injectorLike), CreateBoostedComponentMethod.m24054a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike));
    }

    @Inject
    public AdInterfacesPageLikeFooterViewController(AdInterfacesLegalUtil adInterfacesLegalUtil, CreateBoostedComponentMethod createBoostedComponentMethod, EditBoostedComponentMethod editBoostedComponentMethod) {
        super(adInterfacesLegalUtil);
        this.f22846a = createBoostedComponentMethod;
        this.f22847b = editBoostedComponentMethod;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        super.mo983a(baseAdInterfacesData);
        this.f22848c = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
    }

    public final void mo1005a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1005a(adInterfacesFooterView, adInterfacesCardLayout);
        adInterfacesFooterView.setAlpha(0.9f);
    }

    public static AdInterfacesPageLikeFooterViewController m24782a(InjectorLike injectorLike) {
        return m24783c(injectorLike);
    }

    protected final OnClickListener mo996b() {
        return new C26541(this);
    }

    protected final OnClickListener mo1000e() {
        return new C26552(this);
    }

    protected final OnClickListener mo1001f() {
        return new C26563(this);
    }

    protected final void mo1003h() {
        switch (this.f22848c.f21748d) {
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
            case PENDING:
            case ACTIVE:
            case CREATING:
                this.f22590c.setCreateAdButtonVisibility(8);
                this.f22590c.setAddBudgetButtonVisibility(0);
                this.f22590c.setResumeAdButtonVisibility(8);
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

    protected final void mo999d() {
        this.f22590c.setAddBudgetButtonText(this.f22590c.getResources().getString(2131233984));
    }
}

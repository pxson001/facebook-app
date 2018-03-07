package com.facebook.adinterfaces.ui;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEventSubscriber;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: Use getMyMontageMessageInfo(..) instead for the logged-in user's Montage messages */
public class AdInterfacesSaveFooterViewController extends BaseAdInterfacesFooterViewController {
    public final AdInterfacesLegalUtil f22898a;
    public EditBoostedComponentMethod f22899b;

    /* compiled from: Use getMyMontageMessageInfo(..) instead for the logged-in user's Montage messages */
    class C26642 implements OnClickListener {
        final /* synthetic */ AdInterfacesSaveFooterViewController f22897a;

        C26642(AdInterfacesSaveFooterViewController adInterfacesSaveFooterViewController) {
            this.f22897a = adInterfacesSaveFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1256891182);
            this.f22897a.f22899b.m24072b((AdInterfacesBoostedComponentDataModel) this.f22897a.f22681a, view.getContext());
            Logger.a(2, EntryType.UI_INPUT_END, 1553842130, a);
        }
    }

    public static AdInterfacesSaveFooterViewController m24859b(InjectorLike injectorLike) {
        return new AdInterfacesSaveFooterViewController(AdInterfacesLegalUtil.m24675a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike));
    }

    @Inject
    public AdInterfacesSaveFooterViewController(AdInterfacesLegalUtil adInterfacesLegalUtil, EditBoostedComponentMethod editBoostedComponentMethod) {
        this.f22898a = adInterfacesLegalUtil;
        this.f22899b = editBoostedComponentMethod;
    }

    public final void mo1008a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1008a(adInterfacesFooterView, adInterfacesCardLayout);
        final AdInterfacesFooterView adInterfacesFooterView2 = this.f22682b;
        this.f22440b.m22430a(new DataValidationEventSubscriber(this) {
            final /* synthetic */ AdInterfacesSaveFooterViewController f22896b;

            public final void m24858b(FbEvent fbEvent) {
                adInterfacesFooterView2.setCreateAdButtonEnabled(((DataValidationEvent) fbEvent).f21658a);
            }
        });
        adInterfacesFooterView2 = this.f22682b;
        adInterfacesFooterView2.setLegalDisclaimerContent(this.f22898a.m24678a());
        adInterfacesFooterView2.setLegalDisclaimerMovementMethod(LinkMovementMethod.getInstance());
        this.f22682b.setCreateAdButtonEnabled(this.f22440b.m22432a());
    }

    protected final void mo1009b() {
        AdInterfacesFooterView adInterfacesFooterView = this.f22682b;
        adInterfacesFooterView.setCreateAdButtonText(adInterfacesFooterView.getContext().getString(2131233984));
    }

    protected final OnClickListener mo1010c() {
        return new C26642(this);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22899b.m24050a();
    }
}

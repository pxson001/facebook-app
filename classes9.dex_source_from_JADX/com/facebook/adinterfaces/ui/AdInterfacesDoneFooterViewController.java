package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.DataValidationEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: V2_TRENDING_GIF_ITEM */
public class AdInterfacesDoneFooterViewController extends BaseAdInterfacesFooterViewController {

    /* compiled from: V2_TRENDING_GIF_ITEM */
    public class C26111 extends DataValidationEventSubscriber {
        final /* synthetic */ AdInterfacesDoneFooterViewController f22679a;

        public C26111(AdInterfacesDoneFooterViewController adInterfacesDoneFooterViewController) {
            this.f22679a = adInterfacesDoneFooterViewController;
        }

        public final void m24597b(FbEvent fbEvent) {
            this.f22679a.f22682b.setCreateAdButtonEnabled(((DataValidationEvent) fbEvent).f21658a);
        }
    }

    /* compiled from: V2_TRENDING_GIF_ITEM */
    class C26122 implements OnClickListener {
        final /* synthetic */ AdInterfacesDoneFooterViewController f22680a;

        C26122(AdInterfacesDoneFooterViewController adInterfacesDoneFooterViewController) {
            this.f22680a = adInterfacesDoneFooterViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1129886924);
            Intent intent = new Intent();
            intent.putExtra("CREATIVE_EDIT_DATA", this.f22680a.f22681a);
            this.f22680a.f22440b.m22429a(new IntentEvent(intent, true));
            Logger.a(2, EntryType.UI_INPUT_END, 383753176, a);
        }
    }

    public static AdInterfacesDoneFooterViewController m24604a(InjectorLike injectorLike) {
        return new AdInterfacesDoneFooterViewController();
    }

    public final void mo1008a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1008a(adInterfacesFooterView, adInterfacesCardLayout);
        adInterfacesFooterView.setLegalDisclaimerVisibility(8);
        this.f22440b.m22430a(new C26111(this));
        this.f22682b.setCreateAdButtonEnabled(this.f22440b.m22432a());
    }

    protected final OnClickListener mo1010c() {
        return new C26122(this);
    }

    protected final void mo1009b() {
        AdInterfacesFooterView adInterfacesFooterView = this.f22682b;
        adInterfacesFooterView.setCreateAdButtonText(adInterfacesFooterView.getContext().getString(2131233985));
    }
}

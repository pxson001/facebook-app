package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.content.event.FbEvent;
import javax.annotation.Nullable;

/* compiled from: Value length > LENGTH_QUOTE! */
public abstract class BaseAdInterfacesViewController<T extends View, D extends AdInterfacesDataModel> {
    public boolean f22439a = false;
    public AdInterfacesContext f22440b;

    public abstract void mo983a(D d);

    public void mo988a(AdInterfacesContext adInterfacesContext) {
        this.f22440b = adInterfacesContext;
    }

    public void mo982a(T t, @Nullable final AdInterfacesCardLayout adInterfacesCardLayout) {
        this.f22439a = true;
        this.f22440b.m22430a(new ServerValidationRequestEventSubscriber(this) {
            final /* synthetic */ BaseAdInterfacesViewController f23013b;

            public final void m24992b(FbEvent fbEvent) {
                if (adInterfacesCardLayout != null) {
                    adInterfacesCardLayout.m24584a(null);
                }
            }
        });
    }

    public void mo981a() {
        this.f22439a = false;
    }

    public void mo985b(@Nullable Bundle bundle) {
    }

    public void mo984a(Bundle bundle) {
    }

    public final AdInterfacesContext m24311l() {
        return this.f22440b;
    }
}

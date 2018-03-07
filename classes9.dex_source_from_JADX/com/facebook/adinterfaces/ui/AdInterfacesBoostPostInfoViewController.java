package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VERIFY */
public class AdInterfacesBoostPostInfoViewController extends AdInterfacesInfoViewController {
    @Inject
    public AdInterfacesBoostPostInfoViewController(AdInterfacesHelper adInterfacesHelper) {
        super(adInterfacesHelper);
    }

    public final void mo1004a(TextWithEntitiesView textWithEntitiesView, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1004a(textWithEntitiesView, adInterfacesCardLayout);
        switch (this.f22599c.f21748d) {
            case EXTENDABLE:
                m24516a(2131233878);
                return;
            case FINISHED:
                m24516a(2131233879);
                return;
            default:
                return;
        }
    }
}

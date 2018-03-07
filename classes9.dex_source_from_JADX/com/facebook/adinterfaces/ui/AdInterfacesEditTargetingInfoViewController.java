package com.facebook.adinterfaces.ui;

import android.view.View;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;

/* compiled from: V2_RTC_RECOMMENDATION */
public class AdInterfacesEditTargetingInfoViewController extends BaseAdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> {
    BaseAdInterfacesData f22704a;

    public static AdInterfacesEditTargetingInfoViewController m24627a(InjectorLike injectorLike) {
        return new AdInterfacesEditTargetingInfoViewController();
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        super.mo982a(textWithEntitiesView, adInterfacesCardLayout);
        textWithEntitiesView.setVisibility(0);
        if (adInterfacesCardLayout != null) {
            adInterfacesCardLayout.setVisibility(0);
        }
        if (this.f22704a.f21748d == AdInterfacesStatus.ACTIVE || this.f22704a.f21748d == AdInterfacesStatus.EXTENDABLE || this.f22704a.f21748d == AdInterfacesStatus.PENDING || this.f22704a.f21748d == AdInterfacesStatus.PAUSED) {
            textWithEntitiesView.setText(textWithEntitiesView.getContext().getString(2131233954));
        } else {
            textWithEntitiesView.setText(textWithEntitiesView.getContext().getString(2131233955));
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22704a = baseAdInterfacesData;
    }
}

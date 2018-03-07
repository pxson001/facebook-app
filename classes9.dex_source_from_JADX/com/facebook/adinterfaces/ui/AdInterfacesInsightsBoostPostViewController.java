package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: V2_RECENT_LINK */
public class AdInterfacesInsightsBoostPostViewController extends BaseAdInterfacesFooterViewController {

    /* compiled from: V2_RECENT_LINK */
    class C26311 implements OnClickListener {
        final /* synthetic */ AdInterfacesInsightsBoostPostViewController f22733a;

        C26311(AdInterfacesInsightsBoostPostViewController adInterfacesInsightsBoostPostViewController) {
            this.f22733a = adInterfacesInsightsBoostPostViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1320842873);
            this.f22733a.f22440b.m22429a(new IntentEvent(((AdInterfacesBoostPostDataModel) this.f22733a.f22681a).f21786g));
            Logger.a(2, EntryType.UI_INPUT_END, 1923185101, a);
        }
    }

    public static AdInterfacesInsightsBoostPostViewController m24650a(InjectorLike injectorLike) {
        return new AdInterfacesInsightsBoostPostViewController();
    }

    public final void mo1008a(AdInterfacesFooterView adInterfacesFooterView, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo1008a(adInterfacesFooterView, adInterfacesCardLayout);
        adInterfacesFooterView.setLegalDisclaimerVisibility(8);
    }

    protected final OnClickListener mo1010c() {
        return new C26311(this);
    }

    protected final void mo1009b() {
        int i;
        AdInterfacesFooterView adInterfacesFooterView = this.f22682b;
        if (AdInterfacesDataHelper.m22814j(this.f22681a)) {
            i = 2131234021;
        } else {
            i = ((AdInterfacesBoostPostDataModel) this.f22681a).f21786g.getIntExtra("title", -1);
        }
        adInterfacesFooterView.setCreateAdButtonText(adInterfacesFooterView.getContext().getString(Integer.valueOf(i).intValue()));
    }
}

package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: UpdateUploadStatus */
public class AdInterfacesUnifiedTargetingView extends AdInterfacesBaseTargetingView {
    public AdInterfacesUnifiedAudienceOptionsView f22979b;

    public AdInterfacesUnifiedTargetingView(Context context) {
        super(context);
    }

    public AdInterfacesUnifiedTargetingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdInterfacesUnifiedTargetingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void mo1014a() {
        super.mo1014a();
        this.f22979b = (AdInterfacesUnifiedAudienceOptionsView) a(2131559338);
    }

    public final void mo1016b() {
        setContentView(2130903152);
    }

    public AdInterfacesUnifiedAudienceOptionsView getAudienceOptionsView() {
        return this.f22979b;
    }
}

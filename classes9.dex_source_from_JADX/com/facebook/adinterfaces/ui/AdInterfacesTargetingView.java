package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;

/* compiled from: Upload failed at transfer stage with sessionId %s and streamId %s */
public class AdInterfacesTargetingView extends AdInterfacesBaseTargetingView {
    public AdInterfacesAudienceOptionsView f22959b;

    public AdInterfacesTargetingView(Context context) {
        super(context);
    }

    public AdInterfacesTargetingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdInterfacesTargetingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void mo1014a() {
        super.mo1014a();
        this.f22959b = (AdInterfacesAudienceOptionsView) a(2131559338);
    }

    public AdInterfacesAudienceOptionsView getAudienceOptionsView() {
        return this.f22959b;
    }
}

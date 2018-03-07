package com.facebook.adinterfaces;

import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;

/* compiled from: account_nux */
interface AdInterfacesCallToAction {
    String getUri(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel);

    boolean isAvailable(AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel);
}

package com.facebook.adinterfaces.ui;

import android.content.Context;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerAdapter.SpinnerAdapterItem;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.List;

/* compiled from: Upload failed with at transcoding stage with sessionId %s and streamId %s */
public class AdInterfacesSpinnerAdapterProvider extends AbstractAssistedProvider<AdInterfacesSpinnerAdapter> {
    public final AdInterfacesSpinnerAdapter m24920a(List<SpinnerAdapterItem> list) {
        return new AdInterfacesSpinnerAdapter((Context) getInstance(Context.class), list);
    }
}

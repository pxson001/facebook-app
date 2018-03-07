package com.facebook.composer.ui.footerbar;

import com.facebook.composer.ui.footerbar.ComposerCheckInFooterBarController.Listener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.resources.ui.FbTextView;

/* compiled from: fbredirect */
public class ComposerImplicitLocationFooterBarControllerProvider extends AbstractAssistedProvider<ComposerImplicitLocationFooterBarController> {
    public static <DataProvider extends ProvidesIsImplicitLocationSupported & ProvidesLocationInfo> ComposerImplicitLocationFooterBarController<DataProvider> m8323a(LazyFooterView<FbTextView> lazyFooterView, DataProvider dataProvider, Listener listener) {
        return new ComposerImplicitLocationFooterBarController(lazyFooterView, (ProvidesIsImplicitLocationSupported) dataProvider, listener);
    }
}

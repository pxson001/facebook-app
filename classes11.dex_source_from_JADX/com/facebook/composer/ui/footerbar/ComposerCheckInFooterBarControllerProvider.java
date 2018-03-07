package com.facebook.composer.ui.footerbar;

import android.content.Context;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.ui.footerbar.ComposerCheckInFooterBarController.Listener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesShouldShowNoLocationBadge;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;

/* compiled from: feed quick cam */
public class ComposerCheckInFooterBarControllerProvider extends AbstractAssistedProvider<ComposerCheckInFooterBarController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesSessionId & ProvidesShouldShowNoLocationBadge & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo> ComposerCheckInFooterBarController<DataProvider> m8310a(TipManager tipManager, LazyFooterView<BadgeableFooterButton> lazyFooterView, Listener listener, DataProvider dataProvider) {
        return new ComposerCheckInFooterBarController(tipManager, lazyFooterView, listener, (ProvidesAttachments) dataProvider, (Context) getInstance(Context.class), FbNetworkManager.a(this), TipSeenTracker.b(this));
    }
}

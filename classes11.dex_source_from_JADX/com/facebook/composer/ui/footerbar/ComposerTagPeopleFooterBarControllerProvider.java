package com.facebook.composer.ui.footerbar;

import android.content.Context;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.tip.TipManager;
import com.facebook.composer.ui.footerbar.ComposerTagPeopleFooterBarController.Listener;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;

/* compiled from: fb_incentive_start_contact_inviter_fragment */
public class ComposerTagPeopleFooterBarControllerProvider extends AbstractAssistedProvider<ComposerTagPeopleFooterBarController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsTagPeopleSupported & ProvidesConfiguration & ProvidesLocationInfo & ProvidesTaggedUsers & ProvidesTargetData> ComposerTagPeopleFooterBarController<DataProvider> m8345a(TipManager tipManager, LazyFooterView<GlyphButton> lazyFooterView, DataProvider dataProvider, Listener listener) {
        return new ComposerTagPeopleFooterBarController(tipManager, lazyFooterView, (ProvidesAttachments) dataProvider, listener, (Context) getInstance(Context.class));
    }
}

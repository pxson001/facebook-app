package com.facebook.composer.privacy.controller;

import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.privacy.controller.SelectablePrivacyPillViewController.PillClickedListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagExpansionPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.LazyView;

/* compiled from: fitness_story */
public class SelectablePrivacyPillViewControllerProvider extends AbstractAssistedProvider<SelectablePrivacyPillViewController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsTagExpansionPillSupported & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPrivacyData & ProvidesTaggedUsers> SelectablePrivacyPillViewController<DataProvider> m8217a(DataProvider dataProvider, LazyView<FbTextView> lazyView, PillClickedListener pillClickedListener) {
        return new SelectablePrivacyPillViewController(ResourcesMethodAutoProvider.a(this), GlyphColorizer.a(this), ComposerAnalyticsLogger.a(this), User_LoggedInUserMethodAutoProvider.b(this), (ProvidesAttachments) dataProvider, lazyView, pillClickedListener, PrivacyIcons.a(this));
    }
}

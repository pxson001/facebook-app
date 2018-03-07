package com.facebook.composer.privacy.controller;

import android.content.Context;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.privacy.common.TagExpandPrivacyHelper;
import com.facebook.composer.privacy.controller.SelectablePrivacyPillViewController.PillClickedListener;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.privacy.selector.AudienceTypeaheadUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.LazyView;

/* compiled from: first edge.getNode() is null */
public class SelectablePrivacyPillViewUsingBaseTokenControllerProvider extends AbstractAssistedProvider<SelectablePrivacyPillViewUsingBaseTokenController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPrivacyData & ProvidesTaggedUsers> SelectablePrivacyPillViewUsingBaseTokenController<DataProvider> m8222a(Context context, DataProvider dataProvider, LazyView<FbTextView> lazyView, PillClickedListener pillClickedListener) {
        return new SelectablePrivacyPillViewUsingBaseTokenController(AudienceTypeaheadUtil.b(this), TagExpandPrivacyHelper.a(this), ScreenUtil.a(this), ComposerAnalyticsLogger.a(this), GlyphColorizer.a(this), User_LoggedInUserMethodAutoProvider.b(this), context, (ProvidesAttachments) dataProvider, lazyView, pillClickedListener);
    }
}

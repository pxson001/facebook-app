package com.facebook.composer.location.feedattachment;

import com.facebook.checkin.rows.BaseCheckinStoryPartDefinition;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.location.feedattachment.CheckinPreviewAttachmentController.Callback;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.SetsLocationInfo;
import com.facebook.maps.rows.MapPartDefinition;
import com.facebook.maps.rows.MapSizeHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: from_legal */
public class CheckinPreviewAttachmentControllerProvider extends AbstractAssistedProvider<CheckinPreviewAttachmentController> {
    public final <DataProvider extends ProvidesContentType & ProvidesLocationInfo, Transaction extends ComposerTransaction & SetsLocationInfo<Transaction>> CheckinPreviewAttachmentController<DataProvider, Transaction> m8136a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator, Callback callback) {
        return new CheckinPreviewAttachmentController((ProvidesContentType) dataProvider, composerMutator, callback, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ComposerAnalyticsLogger.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), MapPartDefinition.a(this), GraphQLQueryExecutor.a(this), GraphQLImageHelper.a(this), ResourcesMethodAutoProvider.a(this), BaseCheckinStoryPartDefinition.a(this), GlyphColorizer.a(this), MapSizeHelper.a(this));
    }
}

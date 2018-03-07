package com.facebook.composer.targetselection;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerAlbumCapability;
import com.facebook.composer.capability.ComposerCheckinCapability;
import com.facebook.composer.capability.ComposerMinutiaeCapability;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.composer.capability.ComposerPhotoCapability;
import com.facebook.composer.capability.ComposerTagPeopleCapability;
import com.facebook.composer.controller.ComposerTitleGenerator;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.pagesintegration.CheckViewerPageAdminPagesUtil;
import com.facebook.composer.targetselection.ComposerTargetSelectorController.TargetSelectorClient;
import com.facebook.composer.viewerpageadminutil.CheckViewerPageAdminUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsInlineSproutsSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTargetMenuSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTransliterationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsAttachingToAlbumsGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsCheckinGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsMinutiaeGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsPhotoGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsTaggingPeopleGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter;

/* compiled from: fetchLayoutAndTilesParams */
public class ComposerTargetSelectorControllerProvider extends AbstractAssistedProvider<ComposerTargetSelectorController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsTargetMenuSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesIsTransliterationSupported & ProvidesIsInlineSproutsSupported & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPluginAllowsAttachingToAlbumsGetter & ProvidesPluginAllowsCheckinGetter & ProvidesPluginAllowsMinutiaeGetter & ProvidesPluginAllowsPhotoGetter & ProvidesPluginAllowsTaggingPeopleGetter & ProvidesPluginTitleGetter & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode & ProvidesRedSpaceValue> ComposerTargetSelectorController<DataProvider> m8281a(TargetSelectorClient targetSelectorClient, DataProvider dataProvider) {
        return new ComposerTargetSelectorController(DefaultComposerTargetTypesBuilder.m8282a(this), STATICDI_MULTIBIND_PROVIDER$ComposerTargetInfoProvider.m8284a(this), (CheckViewerPageAdminUtil) CheckViewerPageAdminPagesUtil.m8156a((InjectorLike) this), ComposerPhotoCapability.a(this), ComposerMultimediaCapability.a(this), ComposerMinutiaeCapability.a(this), ComposerCheckinCapability.a(this), ComposerTagPeopleCapability.a(this), ComposerAlbumCapability.a(this), ComposerTitleGenerator.m7750a(this), ComposerAnalyticsLogger.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), ResourcesMethodAutoProvider.a(this), targetSelectorClient, (ProvidesAttachments) dataProvider);
    }
}

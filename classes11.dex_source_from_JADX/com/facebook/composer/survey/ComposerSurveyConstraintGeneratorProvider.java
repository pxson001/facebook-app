package com.facebook.composer.survey;

import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginSurveyConstraintGetter;

/* compiled from: fetchPagesAlbumsList_%s_%s */
public class ComposerSurveyConstraintGeneratorProvider extends AbstractAssistedProvider<ComposerSurveyConstraintGenerator> {
    public final <DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPluginSurveyConstraintGetter & ProvidesPrivacyData & ProvidesTaggedUsers> ComposerSurveyConstraintGenerator<DataProvider> m8268a(DataProvider dataProvider) {
        ComposerSurveyConstraintGenerator<DataProvider> composerSurveyConstraintGenerator = new ComposerSurveyConstraintGenerator((ProvidesAttachments) dataProvider);
        composerSurveyConstraintGenerator.f6944a = IdBasedProvider.a(this, 3595);
        return composerSurveyConstraintGenerator;
    }
}

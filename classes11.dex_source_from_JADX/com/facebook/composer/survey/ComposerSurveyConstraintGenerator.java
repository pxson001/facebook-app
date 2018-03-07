package com.facebook.composer.survey;

import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginSurveyConstraintGetter;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Provider;

/* compiled from: fetchRecommendedPagesInCategory */
public class ComposerSurveyConstraintGenerator<DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesTextWithEntities & ProvidesPluginSurveyConstraintGetter & ProvidesPrivacyData & ProvidesTaggedUsers> {
    @Inject
    @LoggedInUser
    public volatile Provider<User> f6944a = UltralightRuntime.a;
    public final WeakReference<DataProvider> f6945b;

    @Inject
    public ComposerSurveyConstraintGenerator(@Assisted DataProvider dataProvider) {
        this.f6945b = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }
}

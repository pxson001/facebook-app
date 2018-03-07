package com.facebook.composer.privacy.common;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nonnull;

/* compiled from: targetID */
public class ComposerAlbumPrivacyDelegateProvider extends AbstractAssistedProvider<ComposerAlbumPrivacyDelegate> {
    public final ComposerAlbumPrivacyDelegate m1909a(PrivacyUpdatedHandler privacyUpdatedHandler, @Nonnull GraphQLAlbum graphQLAlbum) {
        return new ComposerAlbumPrivacyDelegate(privacyUpdatedHandler, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), TasksManager.b(this), ResourcesMethodAutoProvider.a(this), graphQLAlbum);
    }
}

package com.facebook.entitycards.loader;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoader;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: iconWidth */
public class DefaultEntityCardsPageLoaderProvider extends AbstractAssistedProvider<DefaultEntityCardsPageLoader> {
    public final DefaultEntityCardsPageLoader m12957a(EntityCardsIdsForPageLoader entityCardsIdsForPageLoader, DefaultPersonCardsLoader defaultPersonCardsLoader, String str, Bundle bundle) {
        return new DefaultEntityCardsPageLoader(entityCardsIdsForPageLoader, defaultPersonCardsLoader, str, bundle, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}

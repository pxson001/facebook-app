package com.facebook.transliteration;

import android.content.Context;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.transliteration.algorithms.bigram.BigramAlgorithmProvider;
import com.facebook.transliteration.autocomplete.WordPredictor;
import com.facebook.transliteration.database.TransliterationDatabaseSupplier;
import com.facebook.transliteration.datamanager.DictionaryDataManager;
import java.util.concurrent.ExecutorService;

/* compiled from: extra_current_location */
public class TransliterationProvider extends AbstractAssistedProvider<Transliteration> {
    public final Transliteration m19104a(Algorithm algorithm, Boolean bool, Integer num) {
        return new Transliteration((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(this), (Context) getInstance(Context.class), TransliterateAnalyticsLogger.m19046a((InjectorLike) this), TransliterationDatabaseSupplier.m19160a((InjectorLike) this), DictionaryDataManager.m19184b((InjectorLike) this), (BigramAlgorithmProvider) getOnDemandAssistedProviderForStaticDi(BigramAlgorithmProvider.class), IdBasedLazy.a(this, 11441), IdBasedLazy.a(this, 11442), WordPredictor.m19157a(this), algorithm, bool, num);
    }
}

package com.facebook.feedplugins.graphqlstory.translation;

import com.facebook.debug.log.BLog;
import com.facebook.feed.protocol.FetchTranslationsGraphQLModels.TranslatedStoryMessageModel;
import com.facebook.graphql.executor.GraphQLResult;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: Save Button has been rebinded to a different attachment. */
class TranslationDataLoader$1 implements FutureCallback<GraphQLResult<TranslatedStoryMessageModel>> {
    final /* synthetic */ TranslatedTextPersistentState f23472a;
    final /* synthetic */ TranslationDataLoader f23473b;

    TranslationDataLoader$1(TranslationDataLoader translationDataLoader, TranslatedTextPersistentState translatedTextPersistentState) {
        this.f23473b = translationDataLoader;
        this.f23472a = translatedTextPersistentState;
    }

    public void onSuccess(@Nullable Object obj) {
        GraphQLResult graphQLResult = (GraphQLResult) obj;
        if (graphQLResult == null || graphQLResult.e == null || ((TranslatedStoryMessageModel) graphQLResult.e).j() == null) {
            BLog.c(TranslationDataLoader.a, "Cannot fetch translation for story.", new NullPointerException("Null Story Translation"));
            this.f23472a.a = null;
            this.f23472a.b = false;
            this.f23473b.d.mo1588a();
            return;
        }
        this.f23473b.c.a();
        this.f23472a.a = ((TranslatedStoryMessageModel) graphQLResult.e).j();
        this.f23472a.b = false;
        this.f23473b.d.mo1588a();
    }

    public void onFailure(Throwable th) {
        BLog.b(TranslationDataLoader.a, "Cannot fetch translation for story.", th);
    }
}

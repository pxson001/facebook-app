package com.facebook.feedback.reactions.ui;

import android.content.Context;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.executors.Handler_ForNonUiThreadMethodAutoProvider;
import com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher;
import com.facebook.feedback.reactions.api.FeedbackReactionsSettingsLogger;
import com.facebook.feedback.reactions.api.FeedbackReactionsVectorAssetFetcher;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;

/* compiled from: hasNextPage */
public class FeedbackReactionsDownloaderProvider extends AbstractAssistedProvider<FeedbackReactionsDownloader> {
    public final FeedbackReactionsDownloader m29096a(FeedbackReactionsController feedbackReactionsController, ReactionModelFactory reactionModelFactory) {
        return new FeedbackReactionsDownloader((Context) getInstance(Context.class), feedbackReactionsController, reactionModelFactory, FeedbackReactionHelper.m29122a(this), FeedbackReactionsSettingsFetcher.m29175a(this), FbSharedPreferencesImpl.m1826a((InjectorLike) this), Handler_ForNonUiThreadMethodAutoProvider.m5523b(this), FeedbackReactionsSettingsLogger.m29178b(this), C0055x2995691a.m1881a(this), FeedbackReactionsVectorAssetFetcher.m29183b(this));
    }
}

package com.facebook.feedback.reactions.ui;

import android.content.Context;
import android.os.Handler;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.feedback.reactions.api.C0850x41c6c670.FeedbackReactionSettingsModel.ReactionInfosModel;
import com.facebook.feedback.reactions.api.FeedbackReactionsSettingsFetcher;
import com.facebook.feedback.reactions.api.FeedbackReactionsSettingsLogger;
import com.facebook.feedback.reactions.api.FeedbackReactionsVectorAssetFetcher;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController.ImageFormat;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: gu */
public class FeedbackReactionsDownloader {
    public static final Class<?> f21446a = FeedbackReactionsDownloader.class;
    public static final ImageFormat[] f21447b = new ImageFormat[]{ImageFormat.SMALL, ImageFormat.LARGE, ImageFormat.TAB_ICONS, ImageFormat.VECTOR};
    private final Context f21448c;
    public final FeedbackReactionsController f21449d;
    public final ReactionModelFactory f21450e;
    public final FeedbackReactionHelper f21451f;
    private final FeedbackReactionsSettingsFetcher f21452g;
    public final FbSharedPreferences f21453h;
    @ForNonUiThread
    public final Handler f21454i;
    public final FeedbackReactionsSettingsLogger f21455j;
    public final Executor f21456k;
    public final FeedbackReactionsVectorAssetFetcher f21457l;

    /* compiled from: gu */
    class C08461 extends AbstractDisposableFutureCallback<List<ReactionInfosModel>> {
        final /* synthetic */ FeedbackReactionsDownloader f21491a;

        C08461(FeedbackReactionsDownloader feedbackReactionsDownloader) {
            this.f21491a = feedbackReactionsDownloader;
        }

        protected final void mo347a(Object obj) {
            HandlerDetour.a(this.f21491a.f21454i, new PersistanceRunnable(this.f21491a, (List) obj), 823043661);
        }

        protected final void mo348a(Throwable th) {
            BLog.b(FeedbackReactionsDownloader.f21446a, "Failed to fetch the reactions ordering from the server - ", th);
        }
    }

    @Inject
    public FeedbackReactionsDownloader(Context context, @Assisted FeedbackReactionsController feedbackReactionsController, @Assisted ReactionModelFactory reactionModelFactory, FeedbackReactionHelper feedbackReactionHelper, FeedbackReactionsSettingsFetcher feedbackReactionsSettingsFetcher, FbSharedPreferences fbSharedPreferences, Handler handler, FeedbackReactionsSettingsLogger feedbackReactionsSettingsLogger, ExecutorService executorService, FeedbackReactionsVectorAssetFetcher feedbackReactionsVectorAssetFetcher) {
        this.f21448c = context;
        this.f21449d = feedbackReactionsController;
        this.f21450e = reactionModelFactory;
        this.f21451f = feedbackReactionHelper;
        this.f21452g = feedbackReactionsSettingsFetcher;
        this.f21453h = fbSharedPreferences;
        this.f21454i = handler;
        this.f21455j = feedbackReactionsSettingsLogger;
        this.f21456k = executorService;
        this.f21457l = feedbackReactionsVectorAssetFetcher;
    }

    public final void m29174a(boolean z) {
        this.f21452g.m29177a(this.f21448c.getResources().getDisplayMetrics().density, false, new C08461(this), this.f21455j, z);
    }
}

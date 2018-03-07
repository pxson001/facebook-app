package com.facebook.saved.launcher;

import android.app.Activity;
import android.content.res.Resources;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.reviews.composer.config.ReviewComposerPluginConfig;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.ReviewBasicFieldsModel.ValueModel.Builder;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel.PrivacyOptionsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsModels.SelectedPrivacyOptionFieldsModel.PrivacyOptionsModel.EdgesModel;
import com.facebook.reviews.util.PageReviewLoader;
import com.facebook.reviews.util.PageReviewLoader.LoadSingleReviewCallback;
import com.facebook.reviews.util.helper.ReviewsGraphQLHelper;
import com.facebook.saved.contextmenu.interfaces.ReviewableItemWrapper;
import com.facebook.saved.event.SavedEventBus;
import com.facebook.saved.event.SavedEvents.SavedItemReviewedEvent;
import com.facebook.saved.intent.RequestCode;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: internal_settings_opened */
public class SavedReviewComposerLauncherWithResult {
    private final ComposerLauncher f9201a;
    public final Resources f9202b;
    public final TasksManager f9203c;
    public final ComposerPublishServiceHelper f9204d;
    public final Toaster f9205e;
    public final PageReviewLoader f9206f;
    public final SavedEventBus f9207g;
    private final ComposerConfigurationFactory f9208h;

    /* compiled from: internal_settings_opened */
    public class C13961 extends OperationResultFutureCallback {
        final /* synthetic */ PostReviewParams f9195a;
        final /* synthetic */ SavedReviewComposerLauncherWithResult f9196b;

        public C13961(SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult, PostReviewParams postReviewParams) {
            this.f9196b = savedReviewComposerLauncherWithResult;
            this.f9195a = postReviewParams;
        }

        protected final void m9216a(Object obj) {
            ValueModel a;
            OperationResult operationResult = (OperationResult) obj;
            this.f9196b.f9205e.b(new ToastBuilder(this.f9196b.f9202b.getString(2131235328)));
            ReviewWithFeedback reviewWithFeedback = (ReviewWithFeedback) operationResult.h();
            if (reviewWithFeedback.d() != null) {
                Builder builder = new Builder();
                builder.a = reviewWithFeedback.d().a();
                a = builder.a();
            } else {
                a = null;
            }
            EdgesModel.Builder builder2 = new EdgesModel.Builder();
            builder2.b = ((EdgesModel) reviewWithFeedback.c().b().a().get(0)).b();
            EdgesModel a2 = builder2.a();
            PrivacyOptionsModel.Builder builder3 = new PrivacyOptionsModel.Builder();
            builder3.a = ImmutableList.of(a2);
            PrivacyOptionsModel a3 = builder3.a();
            SavedEventBus savedEventBus = this.f9196b.f9207g;
            ReviewBasicFieldsModel.Builder builder4 = new ReviewBasicFieldsModel.Builder();
            builder4.d = a;
            ReviewBasicFieldsModel.Builder builder5 = builder4;
            builder5.b = reviewWithFeedback.b();
            ReviewBasicFieldsModel.Builder builder6 = builder5;
            SelectedPrivacyOptionFieldsModel.Builder builder7 = new SelectedPrivacyOptionFieldsModel.Builder();
            builder7.b = a3;
            builder6.c = builder7.a();
            savedEventBus.a(new SavedItemReviewedEvent(builder6.a(), String.valueOf(this.f9195a.b)));
        }

        protected final void m9215a(ServiceException serviceException) {
            this.f9196b.f9205e.b(new ToastBuilder(this.f9196b.f9202b.getString(2131235329)));
        }
    }

    /* compiled from: internal_settings_opened */
    public class C13972 implements LoadSingleReviewCallback {
        final /* synthetic */ ProgressDialog f9197a;
        final /* synthetic */ ReviewableItemWrapper f9198b;
        final /* synthetic */ Activity f9199c;
        final /* synthetic */ SavedReviewComposerLauncherWithResult f9200d;

        public C13972(SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult, ProgressDialog progressDialog, ReviewableItemWrapper reviewableItemWrapper, Activity activity) {
            this.f9200d = savedReviewComposerLauncherWithResult;
            this.f9197a = progressDialog;
            this.f9198b = reviewableItemWrapper;
            this.f9199c = activity;
        }

        public final void m9218a(ReviewBasicFields reviewBasicFields) {
            this.f9197a.dismiss();
            SavedReviewComposerLauncherWithResult.m9219a(this.f9200d, this.f9198b, this.f9199c, reviewBasicFields);
        }

        public final void m9217a() {
            this.f9197a.dismiss();
            this.f9200d.f9205e.b(new ToastBuilder(2131235356));
        }
    }

    public static SavedReviewComposerLauncherWithResult m9220b(InjectorLike injectorLike) {
        return new SavedReviewComposerLauncherWithResult((ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), ComposerPublishServiceHelper.b(injectorLike), Toaster.b(injectorLike), PageReviewLoader.a(injectorLike), SavedEventBus.m9122a(injectorLike), ComposerConfigurationFactory.b(injectorLike));
    }

    @Inject
    public SavedReviewComposerLauncherWithResult(ComposerLauncher composerLauncher, Resources resources, TasksManager tasksManager, ComposerPublishServiceHelper composerPublishServiceHelper, Toaster toaster, PageReviewLoader pageReviewLoader, SavedEventBus savedEventBus, ComposerConfigurationFactory composerConfigurationFactory) {
        this.f9201a = composerLauncher;
        this.f9202b = resources;
        this.f9203c = tasksManager;
        this.f9204d = composerPublishServiceHelper;
        this.f9205e = toaster;
        this.f9206f = pageReviewLoader;
        this.f9207g = savedEventBus;
        this.f9208h = composerConfigurationFactory;
    }

    public static void m9219a(SavedReviewComposerLauncherWithResult savedReviewComposerLauncherWithResult, ReviewableItemWrapper reviewableItemWrapper, @Nullable Activity activity, ReviewBasicFields reviewBasicFields) {
        boolean z;
        int a = ReviewsGraphQLHelper.a(reviewBasicFields);
        ComposerSourceType composerSourceType = ComposerSourceType.SAVED_DASHBOARD;
        if (a != 0) {
            z = true;
        } else {
            z = false;
        }
        ComposerConfiguration.Builder initialPrivacyOverride = ComposerConfigurationFactory.a(composerSourceType, z, Long.parseLong(reviewableItemWrapper.mo424a()), reviewableItemWrapper.mo428e(), CurationMechanism.REVIEW_BUTTON, CurationSurface.NATIVE_SAVED_DASHBOARD).setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.c())).setHideKeyboardIfReachedMinimumHeight(true).setInitialRating(a).setInitialPrivacyOverride(ReviewsGraphQLHelper.c(reviewBasicFields));
        String b = ReviewsGraphQLHelper.b(reviewBasicFields);
        if (b != null) {
            initialPrivacyOverride.setInitialText(GraphQLHelper.a(b));
        }
        savedReviewComposerLauncherWithResult.f9201a.a(null, initialPrivacyOverride.a(), RequestCode.REVIEW_ITEM.ordinal(), activity);
    }
}

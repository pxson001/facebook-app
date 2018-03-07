package com.facebook.reviews.util.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.protocol.PostReviewParams;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.reviews.analytics.ReviewsLogger;
import com.facebook.reviews.composer.config.ReviewComposerPluginConfig;
import com.facebook.reviews.util.helper.ReviewsMessagesHelper;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: profile_video_android_take_video_with_camera */
public class ReviewComposerLauncherAndHandler {
    private static ReviewComposerLauncherAndHandler f4991j;
    private static final Object f4992k = new Object();
    private final ComposerConfigurationFactory f4993a;
    private final ComposerLauncher f4994b;
    private final ComposerPublishServiceHelper f4995c;
    private final Resources f4996d;
    public final ReviewsLogger f4997e;
    public final ReviewsMessagesHelper f4998f;
    private final TasksManager<String> f4999g;
    public final Toaster f5000h;
    public ProgressDialog f5001i;

    /* compiled from: profile_video_android_take_video_with_camera */
    public abstract class PostReviewCallbackBase {
        public void mo1172a() {
        }

        public void mo1173b() {
        }

        public void mo1125a(OperationResult operationResult) {
        }
    }

    private static ReviewComposerLauncherAndHandler m4944b(InjectorLike injectorLike) {
        return new ReviewComposerLauncherAndHandler(ComposerConfigurationFactory.b(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), ComposerPublishServiceHelper.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), ReviewsMessagesHelper.m4926a(injectorLike), ReviewsLogger.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike));
    }

    public static ReviewComposerLauncherAndHandler m4943a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReviewComposerLauncherAndHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f4992k) {
                ReviewComposerLauncherAndHandler reviewComposerLauncherAndHandler;
                if (a2 != null) {
                    reviewComposerLauncherAndHandler = (ReviewComposerLauncherAndHandler) a2.a(f4992k);
                } else {
                    reviewComposerLauncherAndHandler = f4991j;
                }
                if (reviewComposerLauncherAndHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m4944b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f4992k, b3);
                        } else {
                            f4991j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reviewComposerLauncherAndHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReviewComposerLauncherAndHandler(ComposerConfigurationFactory composerConfigurationFactory, ComposerLauncher composerLauncher, ComposerPublishServiceHelper composerPublishServiceHelper, Resources resources, ReviewsMessagesHelper reviewsMessagesHelper, ReviewsLogger reviewsLogger, TasksManager tasksManager, Toaster toaster) {
        this.f4993a = composerConfigurationFactory;
        this.f4994b = composerLauncher;
        this.f4996d = resources;
        this.f4997e = reviewsLogger;
        this.f4998f = reviewsMessagesHelper;
        this.f4995c = composerPublishServiceHelper;
        this.f4999g = tasksManager;
        this.f5000h = toaster;
    }

    public final void m4945a(int i, Activity activity, ComposerSourceType composerSourceType, CurationSurface curationSurface, CurationMechanism curationMechanism, int i2, long j, @Nullable String str, @Nullable String str2, @Nullable GraphQLPrivacyOption graphQLPrivacyOption, @Nullable String str3) {
        boolean z;
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        Builder initialPrivacyOverride = ComposerConfigurationFactory.a(composerSourceType, z, j, str, curationMechanism, curationSurface).setPluginConfig(new DefaultPluginConfigSerializer().a(ReviewComposerPluginConfig.m4870c())).setCacheId(str3).setInitialRating(i2).setInitialPrivacyOverride(graphQLPrivacyOption);
        if (str2 != null) {
            initialPrivacyOverride.setInitialText(GraphQLHelper.a(str2));
        }
        this.f4994b.a(null, initialPrivacyOverride.a(), i, activity);
    }

    public final void m4946a(int i, Intent intent, final String str, final Optional<? extends PostReviewCallback> optional, Optional<Context> optional2) {
        if (i == 0) {
            if (this.f5001i != null) {
                this.f5001i.dismiss();
            }
            if (optional.isPresent()) {
                ((PostReviewCallbackBase) optional.get()).mo1172a();
            }
        } else if (i == -1) {
            final PostReviewParams postReviewParams = (PostReviewParams) intent.getParcelableExtra("publishReviewParams");
            if (postReviewParams == null) {
                this.f5000h.b(new ToastBuilder(this.f4996d.getString(2131235329)));
                if (optional.isPresent()) {
                    PostReviewCallbackBase postReviewCallbackBase = (PostReviewCallbackBase) optional.get();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Returned intent does not contain PostReviewParams to post the review");
                    postReviewCallbackBase.mo1173b();
                    return;
                }
                return;
            }
            if (optional2.isPresent()) {
                this.f5001i = ProgressDialog.a((Context) optional2.get(), ((Context) optional2.get()).getString(2131235326), ((Context) optional2.get()).getString(2131235327), true, false);
            }
            if (optional.isPresent()) {
                optional.get();
            }
            this.f4999g.a("task_key_post_review" + postReviewParams.b, this.f4995c.a(postReviewParams, null), new OperationResultFutureCallback(this) {
                final /* synthetic */ ReviewComposerLauncherAndHandler f4990d;

                protected final void m4939a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f4990d.f4997e.c(str, String.valueOf(postReviewParams.b));
                    if (this.f4990d.f5001i != null) {
                        this.f4990d.f5001i.dismiss();
                    }
                    this.f4990d.f5000h.a(new ToastBuilder(2131235328));
                    if (optional.isPresent()) {
                        ((PostReviewCallbackBase) optional.get()).mo1125a(operationResult);
                    }
                }

                protected final void m4938a(ServiceException serviceException) {
                    this.f4990d.f5000h.a(new ToastBuilder(this.f4990d.f4998f.m4929a(serviceException)));
                    this.f4990d.f4997e.d(str, String.valueOf(postReviewParams.b));
                    if (this.f4990d.f5001i != null) {
                        this.f4990d.f5001i.dismiss();
                    }
                    this.f4990d.f5000h.a(new ToastBuilder(2131235329));
                    if (optional.isPresent()) {
                        ((PostReviewCallbackBase) optional.get()).mo1173b();
                    }
                }
            });
        }
    }
}

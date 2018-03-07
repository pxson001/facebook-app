package com.facebook.productionprompts.common;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelper;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelperProvider;
import com.facebook.composer.publish.helpers.PublishStatusHelper;
import com.facebook.composer.publish.helpers.PublishStatusHelperProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.plugin.ComposerPluginDataProvider;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.model.PromptObject;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: requested_units */
public class PromptPublishIntentHelper {
    private final PublishStatusHelperProvider f4507a;
    private final PublishAttachmentsHelperProvider f4508b;
    private final OptimisticPostHelperProvider f4509c;

    public static PromptPublishIntentHelper m4362b(InjectorLike injectorLike) {
        return new PromptPublishIntentHelper((PublishStatusHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishStatusHelperProvider.class), (PublishAttachmentsHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PublishAttachmentsHelperProvider.class), (OptimisticPostHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class));
    }

    @Inject
    public PromptPublishIntentHelper(PublishStatusHelperProvider publishStatusHelperProvider, PublishAttachmentsHelperProvider publishAttachmentsHelperProvider, OptimisticPostHelperProvider optimisticPostHelperProvider) {
        this.f4507a = publishStatusHelperProvider;
        this.f4508b = publishAttachmentsHelperProvider;
        this.f4509c = optimisticPostHelperProvider;
    }

    public final Intent m4363a(ComposerPluginDataProvider composerPluginDataProvider, BooleanGetter booleanGetter, PromptAnalytics promptAnalytics, Class<? extends PromptObject> cls, boolean z) {
        PublishPostParams a;
        PromptAnalytics promptAnalytics2;
        boolean z2;
        OptimisticPostHelper a2 = this.f4509c.a(composerPluginDataProvider, booleanGetter);
        PublishAttachmentsHelper a3 = this.f4508b.a(composerPluginDataProvider);
        PublishStatusHelper a4 = this.f4507a.a(composerPluginDataProvider, a3, a2);
        PublishPostParams a5 = a4.a();
        if (z) {
            Builder builder = new Builder(a5);
            builder.an = promptAnalytics;
            a = builder.a();
        } else {
            a = a5;
        }
        if (z) {
            promptAnalytics2 = promptAnalytics;
        } else {
            promptAnalytics2 = null;
        }
        boolean a6 = a2.a();
        if (a3.a()) {
            UploadOperation.Builder builder2 = new UploadOperation.Builder(a3.c());
            builder2.W = promptAnalytics2;
            a3.a(builder2.a());
            if (!a6) {
                a3.d();
            }
            z2 = true;
        } else {
            z2 = false;
        }
        Intent a7 = a4.a(a, z2);
        a7.putExtras(m4361a(promptAnalytics, cls, Boolean.valueOf(z)));
        return a7;
    }

    public static Bundle m4361a(PromptAnalytics promptAnalytics, Class<? extends PromptObject> cls, @Nullable Boolean bool) {
        Bundle bundle = new Bundle();
        if (promptAnalytics != null) {
            bundle.putParcelable("prompt_entry_point_analytics_extra", promptAnalytics);
            bundle.putString("prompt_object_class_name_extra", cls.getSimpleName());
            if (bool != null) {
                bundle.putBoolean("did_use_prompt_extra", bool.booleanValue());
            }
        }
        return bundle;
    }
}

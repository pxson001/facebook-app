package com.facebook.katana.platform;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.opengraph.server.PublishOpenGraphActionOperation.Params;
import com.facebook.platform.params.PlatformComposerParams;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: turn off sms promo */
public class PlatformPublishClient {
    private final ComposerPublishServiceHelper f1142a;
    public final DefaultBlueServiceOperationFactory f1143b;

    public static PlatformPublishClient m1166a(InjectorLike injectorLike) {
        return new PlatformPublishClient(ComposerPublishServiceHelper.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public PlatformPublishClient(ComposerPublishServiceHelper composerPublishServiceHelper, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f1142a = composerPublishServiceHelper;
        this.f1143b = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<OperationResult> m1167a(Intent intent, String str, ObjectNode objectNode) {
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        PlatformComposerParams platformComposerParams = new PlatformComposerParams(publishPostParams.androidKeyHash, publishPostParams.isExplicitLocation, publishPostParams.isTagsUserSelected, publishPostParams.placeTag, publishPostParams.privacy, publishPostParams.proxiedAppId, publishPostParams.proxiedAppName, publishPostParams.rawMessage, Sets.b(publishPostParams.taggedIds));
        Bundle bundle = new Bundle();
        bundle.putParcelable("publishPostParams", publishPostParams);
        bundle.putParcelable("platformParams", platformComposerParams);
        bundle.putParcelable("platform_publish_open_graph_action_params", new Params(str, objectNode));
        return this.f1142a.a(bundle, "platform_publish_open_graph_action");
    }
}

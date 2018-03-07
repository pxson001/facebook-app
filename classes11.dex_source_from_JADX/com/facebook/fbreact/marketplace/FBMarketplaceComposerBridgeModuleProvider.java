package com.facebook.fbreact.marketplace;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.concurrent.ExecutorService;

/* compiled from: extra_go_to_composer_when_page_selected */
public class FBMarketplaceComposerBridgeModuleProvider extends AbstractAssistedProvider<FBMarketplaceComposerBridgeModule> {
    public final FBMarketplaceComposerBridgeModule m8552a(ReactApplicationContext reactApplicationContext) {
        return new FBMarketplaceComposerBridgeModule(reactApplicationContext, (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (UriIntentMapper) Fb4aUriIntentMapper.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), UploadManager.a(this), UploadOperationFactory.b(this), ComposerPublishServiceHelper.b(this), MarketplacePostUploadReceiver.m8565a((InjectorLike) this), Fb4aReactInstanceManager.a(this));
    }
}

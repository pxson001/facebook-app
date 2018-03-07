package com.facebook.groups.fb4a.react;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.groups.fb4a.react.intent.GeneralGroupsReactFragmentIntentBuilder;
import com.facebook.groups.react.CameraLauncherProvider;
import com.facebook.groups.react.EditPostLauncherProvider;
import com.facebook.groups.react.GroupComposerLauncherProvider;
import com.facebook.groups.react.PhotoGalleryLauncherProvider;
import com.facebook.groups.react.PhotoPickerLauncherProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.react.bridge.ReactApplicationContext;

/* compiled from: payments_confirm_card_details */
public class FB4AGroupsManagerJavaModuleProvider extends AbstractAssistedProvider<FB4AGroupsManagerJavaModule> {
    public final FB4AGroupsManagerJavaModule m7186a(ReactApplicationContext reactApplicationContext) {
        return new FB4AGroupsManagerJavaModule(reactApplicationContext, FbReactInstanceHolder.a(this), DefaultAndroidThreadUtil.b(this), GroupPostSearchLauncher.m7197b(this), (Fb4aGroupNavigationLauncherProvider) getOnDemandAssistedProviderForStaticDi(Fb4aGroupNavigationLauncherProvider.class), (GroupComposerLauncherProvider) getOnDemandAssistedProviderForStaticDi(GroupComposerLauncherProvider.class), (PhotoGalleryLauncherProvider) getOnDemandAssistedProviderForStaticDi(PhotoGalleryLauncherProvider.class), (PhotoPickerLauncherProvider) getOnDemandAssistedProviderForStaticDi(PhotoPickerLauncherProvider.class), (EditPostLauncherProvider) getOnDemandAssistedProviderForStaticDi(EditPostLauncherProvider.class), (CameraLauncherProvider) getOnDemandAssistedProviderForStaticDi(CameraLauncherProvider.class), FeedEventBus.a(this), GeneralGroupsReactFragmentIntentBuilder.a(this));
    }
}

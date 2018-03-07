package com.facebook.backstage.consumption;

import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageFragment.FragmentActionListener;
import com.facebook.backstage.consumption.audience.PrivacySettingsView;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.importflow.ImportFlowGridView;
import com.facebook.backstage.consumption.importflow.ImportFlowLauncher;
import com.facebook.backstage.consumption.nux.BackstageNuxViewHolder;
import com.facebook.backstage.consumption.nux.BackstageOnboardNuxHelper;
import com.facebook.backstage.consumption.reply.BackstageReplyThreadSummaryListView;
import com.facebook.backstage.consumption.reply.ReplyDataProvider;
import com.facebook.backstage.ui.LazyView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;

/* compiled from: saved_audience_cursor */
public class BackstageNavigatorImplProvider extends AbstractAssistedProvider<BackstageNavigatorImpl> {
    public final BackstageNavigatorImpl m4501a(BackstageGridView backstageGridView, BackstageActivityButton backstageActivityButton, LazyView<ImportFlowGridView> lazyView, LazyView<BackstageReplyThreadSummaryListView> lazyView2, LazyView<PrivacySettingsView> lazyView3, CameraHolder cameraHolder, CameraFlowLauncher cameraFlowLauncher, StatusBarColorChanger statusBarColorChanger, BackstageNuxViewHolder backstageNuxViewHolder, ActivityRuntimePermissionsManager activityRuntimePermissionsManager, FragmentActionListener fragmentActionListener) {
        return new BackstageNavigatorImpl(ReplyDataProvider.m4801a((InjectorLike) this), ProfilesDataProvider.m4540a((InjectorLike) this), BackstageOnboardNuxHelper.m4732a(this), ImportFlowLauncher.m4647a(this), backstageGridView, backstageActivityButton, lazyView, lazyView2, lazyView3, cameraHolder, cameraFlowLauncher, statusBarColorChanger, backstageNuxViewHolder, activityRuntimePermissionsManager, fragmentActionListener);
    }
}

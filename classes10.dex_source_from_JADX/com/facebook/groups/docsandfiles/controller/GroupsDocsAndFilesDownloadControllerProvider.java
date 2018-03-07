package com.facebook.groups.docsandfiles.controller;

import android.content.Context;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30538;
import com.facebook.groups.docsandfiles.loader.FileMediaDownloader;
import com.facebook.groups.docsandfiles.view.DefaultGroupDocsAndFilesViewFactory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: User canceled message */
public class GroupsDocsAndFilesDownloadControllerProvider extends AbstractAssistedProvider<GroupsDocsAndFilesDownloadController> {
    public final GroupsDocsAndFilesDownloadController m22321a(Context context, C30538 c30538) {
        return new GroupsDocsAndFilesDownloadController((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), IdBasedLazy.a(this, 3588), FileMediaDownloader.m22381b(this), IdBasedSingletonScopeProvider.b(this, 494), IdBasedSingletonScopeProvider.b(this, 30), TasksManager.b(this), DefaultGroupDocsAndFilesViewFactory.m22522b(this), NotificationManagerMethodAutoProvider.b(this), context, c30538);
    }
}

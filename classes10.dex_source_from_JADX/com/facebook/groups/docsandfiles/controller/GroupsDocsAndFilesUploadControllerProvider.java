package com.facebook.groups.docsandfiles.controller;

import android.content.Context;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.groups.docsandfiles.fragment.GroupDocsAndFilesFragment.C30483;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ExecutorService;

/* compiled from: UploadContactsQuery */
public class GroupsDocsAndFilesUploadControllerProvider extends AbstractAssistedProvider<GroupsDocsAndFilesUploadController> {
    public final GroupsDocsAndFilesUploadController m22342a(String str, Context context, C30483 c30483) {
        return new GroupsDocsAndFilesUploadController((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), IdBasedSingletonScopeProvider.b(this, 30), TasksManager.b(this), IdBasedSingletonScopeProvider.b(this, 5816), ViewerContextManagerProvider.b(this), Boolean_IsTabletMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), IdBasedSingletonScopeProvider.b(this, 339), str, context, c30483);
    }
}

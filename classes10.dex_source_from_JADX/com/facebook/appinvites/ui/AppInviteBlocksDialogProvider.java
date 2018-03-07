package com.facebook.appinvites.ui;

import android.content.Context;
import com.facebook.appinvites.adapter.AppInvitesBlockedListAdapterProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: downloadmanager_failure */
public class AppInviteBlocksDialogProvider extends AbstractAssistedProvider<AppInviteBlocksDialog> {
    public final AppInviteBlocksDialog m15094a(Context context, Integer num) {
        return new AppInviteBlocksDialog(GraphQLQueryExecutor.a(this), TasksManager.b(this), (AppInvitesBlockedListAdapterProvider) getOnDemandAssistedProviderForStaticDi(AppInvitesBlockedListAdapterProvider.class), context, num);
    }
}

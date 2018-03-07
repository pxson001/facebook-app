package com.facebook.groups.feed.ui;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.groups.feed.ui.GroupsFeedFragment.AnonymousClass15;
import com.facebook.groups.mutations.GroupsClient;
import com.facebook.inject.AbstractAssistedProvider;
import java.util.concurrent.ExecutorService;

/* compiled from: TimelineFragment.onFragmentCreate.fetchTimeline */
public class GroupMallNotifMegaphoneControllerProvider extends AbstractAssistedProvider<GroupMallNotifMegaphoneController> {
    public final GroupMallNotifMegaphoneController m23181a(AnonymousClass15 anonymousClass15) {
        return new GroupMallNotifMegaphoneController(ResourcesMethodAutoProvider.a(this), anonymousClass15, (SecureContextHelper) DefaultSecureContextHelper.a(this), GroupsClient.b(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this));
    }
}

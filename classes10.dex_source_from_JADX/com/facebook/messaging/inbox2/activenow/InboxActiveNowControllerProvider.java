package com.facebook.messaging.inbox2.activenow;

import android.support.v7.widget.RecyclerView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.messaging.contacts.picker.ContactPickerRowsFactory;
import com.facebook.messaging.inbox2.items.InboxAdapter;
import com.facebook.presence.DefaultPresenceManager;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: share_thread_view */
public class InboxActiveNowControllerProvider extends AbstractAssistedProvider<InboxActiveNowController> {
    public final InboxActiveNowController m2594a(RecyclerView recyclerView, InboxAdapter inboxAdapter) {
        return new InboxActiveNowController(IdBasedProvider.a(this, 4296), ContactPickerRowsFactory.m1786b(this), ContactsLoaderFactory.a(this), DefaultPresenceManager.a(this), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (Clock) SystemClockMethodAutoProvider.a(this), recyclerView, inboxAdapter);
    }
}

package com.facebook.fbreact.events;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.contacts.iterator.ContactIterators;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dashboard.EventsDashboardBirthdaysComposerController;
import com.facebook.events.eventsevents.EventsEventBus;
import com.facebook.events.permalink.EventPermalinkController;
import com.facebook.events.permalink.actionbar.ActionItemEdit;
import com.facebook.events.permalink.actionbar.ActionItemInvite;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.concurrent.ExecutorService;

/* compiled from: facebook_event */
public class FBEventsNativeModuleProvider extends AbstractAssistedProvider<FBEventsNativeModule> {
    public final FBEventsNativeModule m8492a(ReactApplicationContext reactApplicationContext) {
        return new FBEventsNativeModule(reactApplicationContext, ContactIterators.a(this), EventPermalinkController.b(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), ActionItemInvite.a(this), ActionItemEdit.b(this), EventsDashboardBirthdaysComposerController.b(this), GraphQLQueryExecutor.a(this), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), EventsEventBus.a(this), IdBasedProvider.a(this, 5621));
    }
}

package com.facebook.contacts.background;

import com.facebook.backgroundtasks.AbstractBackgroundTask;
import com.facebook.backgroundtasks.BackgroundResult;
import com.facebook.backgroundtasks.BackgroundTask.Prerequisite;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Annotation;
import java.util.EnumSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: fb4a_per_attachment_truncation */
public class AddressBookSyncBackgroundTask extends AbstractBackgroundTask {
    private final AddressBookPeriodicRunner f12104a;

    @Inject
    public AddressBookSyncBackgroundTask(AddressBookPeriodicRunner addressBookPeriodicRunner) {
        super("ADDRESSBOOK_SYNC");
        this.f12104a = addressBookPeriodicRunner;
    }

    public final ImmutableSet<Class<? extends Annotation>> mo599b() {
        return ImmutableSet.of(ContactsTaskTag.class);
    }

    public final boolean mo595i() {
        this.f12104a.m12797a(false);
        return false;
    }

    public final Set<Prerequisite> mo594h() {
        return EnumSet.of(Prerequisite.USER_LOGGED_IN, Prerequisite.NETWORK_CONNECTIVITY);
    }

    public final ListenableFuture<BackgroundResult> mo596j() {
        return null;
    }
}

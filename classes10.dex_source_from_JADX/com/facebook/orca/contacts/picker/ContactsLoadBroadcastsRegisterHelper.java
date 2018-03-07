package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager.ReceiverBuilder;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.idleexecutor.IdleExecutor_DefaultIdleExecutorMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.contacts.picker.ContactMultipickerFragment.C09135;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: num_top_friends */
public class ContactsLoadBroadcastsRegisterHelper {
    private static final Class<?> f6077a = ContactsLoadBroadcastsRegisterHelper.class;
    public Map<String, ContactsActionCallback> f6078b = new HashMap();
    public AddressBookPeriodicRunner f6079c;
    private BaseFbBroadcastManager f6080d;
    public ReceiverBuilder f6081e = this.f6080d.a();
    public SelfRegistrableReceiverImpl f6082f;
    private BroadcastActionReceiver f6083g = new BroadcastActionReceiver(this);
    public Executor f6084h;

    /* compiled from: num_top_friends */
    public class C09261 implements Runnable {
        final /* synthetic */ ContactsLoadBroadcastsRegisterHelper f6075a;

        public C09261(ContactsLoadBroadcastsRegisterHelper contactsLoadBroadcastsRegisterHelper) {
            this.f6075a = contactsLoadBroadcastsRegisterHelper;
        }

        public void run() {
            this.f6075a.f6079c.a();
        }
    }

    /* compiled from: num_top_friends */
    class BroadcastActionReceiver implements ActionReceiver {
        final /* synthetic */ ContactsLoadBroadcastsRegisterHelper f6076a;

        public BroadcastActionReceiver(ContactsLoadBroadcastsRegisterHelper contactsLoadBroadcastsRegisterHelper) {
            this.f6076a = contactsLoadBroadcastsRegisterHelper;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -767968306);
            String action = intent.getAction();
            if (this.f6076a.f6078b.containsKey(action)) {
                ((C09135) this.f6076a.f6078b.get(action)).m5671a(intent);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1011302785, a);
        }
    }

    public static ContactsLoadBroadcastsRegisterHelper m5786b(InjectorLike injectorLike) {
        return new ContactsLoadBroadcastsRegisterHelper(AddressBookPeriodicRunner.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), (Executor) IdleExecutor_DefaultIdleExecutorMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsLoadBroadcastsRegisterHelper(AddressBookPeriodicRunner addressBookPeriodicRunner, BaseFbBroadcastManager baseFbBroadcastManager, Executor executor) {
        this.f6079c = addressBookPeriodicRunner;
        this.f6080d = baseFbBroadcastManager;
        this.f6084h = executor;
    }

    public final void m5787a(String str, C09135 c09135) {
        this.f6078b.put(str, c09135);
        this.f6081e.a(str, this.f6083g);
    }
}

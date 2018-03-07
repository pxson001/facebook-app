package com.facebook.contacts.ccu.internsetting;

import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.contacts.ccu.ContactsUploadClient;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.calls.ContactUploadSessionCreateAndMaybeBatchUploadInputData.Source;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: privacy_policy_uri */
public class ContactsUploadInternSettingHelper {
    public final ContactsUploadClient f6280a;
    private final ExecutorService f6281b;
    private final GatekeeperStoreImpl f6282c;

    public static ContactsUploadInternSettingHelper m6691a(InjectorLike injectorLike) {
        return new ContactsUploadInternSettingHelper(ContactsUploadClient.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ContactsUploadInternSettingHelper(ContactsUploadClient contactsUploadClient, ExecutorService executorService, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f6281b = executorService;
        this.f6280a = contactsUploadClient;
        this.f6282c = gatekeeperStoreImpl;
    }

    public final boolean m6693a() {
        return this.f6282c.a(387, false);
    }

    public final void m6694b() {
        m6692a(true);
    }

    public final void m6695c() {
        m6692a(false);
    }

    private void m6692a(final boolean z) {
        ExecutorDetour.a(this.f6281b, new Runnable(this) {
            final /* synthetic */ ContactsUploadInternSettingHelper f6279b;

            public void run() {
                this.f6279b.f6280a.a(Source.FB_CCU_BACKGROUND_PING, z, 0);
            }
        }, -944576066);
    }
}

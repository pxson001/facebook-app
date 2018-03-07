package com.facebook.messaging.sms.migration.util;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.contactlogs.ContactLogsUploadRunner;
import com.facebook.contactlogs.upload.ContactLogsUploadSettings;
import com.facebook.contacts.upload.ContactsUploadRunner;
import com.facebook.contacts.upload.ContactsUploadVisibility;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: purchased_tickets_count */
public class SMSUploadUtil {
    public ContactLogsUploadRunner f4242a;
    private ContactLogsUploadSettings f4243b;
    private ContactsUploadRunner f4244c;

    public static SMSUploadUtil m3866b(InjectorLike injectorLike) {
        return new SMSUploadUtil(ContactLogsUploadRunner.a(injectorLike), ContactLogsUploadSettings.b(injectorLike), ContactsUploadRunner.a(injectorLike));
    }

    @Inject
    SMSUploadUtil(ContactLogsUploadRunner contactLogsUploadRunner, ContactLogsUploadSettings contactLogsUploadSettings, ContactsUploadRunner contactsUploadRunner) {
        this.f4242a = contactLogsUploadRunner;
        this.f4243b = contactLogsUploadSettings;
        this.f4244c = contactsUploadRunner;
    }

    public final void m3867a() {
        this.f4244c.a(ContactsUploadVisibility.SHOW);
        this.f4243b.a(true);
        this.f4242a.a();
    }

    public final void m3868a(ArrayList<String> arrayList) {
        ContactLogsUploadRunner contactLogsUploadRunner = this.f4242a;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("target_ids", arrayList);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(contactLogsUploadRunner.b, "begin_journeys", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(ContactLogsUploadRunner.class), 160344087).a();
    }
}

package com.facebook.messaging.sms.migration.util;

import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.contactlogs.migrator.TopSmsContact;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Lazy;
import com.facebook.messaging.contacts.loader.ContactListsCache;
import com.facebook.messaging.sms.migration.ContactMatchingOperationResult;
import com.facebook.messaging.sms.migration.SMSLocalContactRow;
import com.facebook.messaging.sms.migration.SMSLocalContactRowBuilder;
import com.facebook.messaging.sms.migration.SMSMatchedContactRow;
import com.facebook.messaging.sms.migration.abtest.ExperimentsForSMSMigrationModule;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.HashSet;
import javax.inject.Inject;

/* compiled from: purged- */
public class ContactMatchingUtil {
    private final Lazy<ContactListsCache> f4236a;
    private final QeAccessor f4237b;
    private final UserKey f4238c;

    @Inject
    public ContactMatchingUtil(Lazy<ContactListsCache> lazy, QeAccessor qeAccessor, UserKey userKey) {
        this.f4236a = lazy;
        this.f4237b = qeAccessor;
        this.f4238c = userKey;
    }

    public final ContactMatchingOperationResult m3863a(OperationResult operationResult) {
        ArrayList i = operationResult.i();
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        String b = this.f4238c.b();
        HashSet a = m3861a();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = (Bundle) i.get(i2);
            Object string = bundle.getString("id");
            if (!(string.equals(b) || a.contains(string))) {
                if (StringUtil.c(string) || string.equals("0")) {
                    SMSLocalContactRowBuilder c = SMSLocalContactRow.m3835c();
                    c.f4188b = bundle.getString("name");
                    c = c;
                    c.f4187a = bundle.getString("phone_number");
                    SMSLocalContactRow b2 = c.m3838b();
                    b2.f4186f = false;
                    builder2.c(b2);
                } else {
                    SMSMatchedContactRow a2 = SMSMatchedContactRow.m3839a(bundle);
                    a2.a(true);
                    builder.c(a2);
                }
            }
        }
        return new ContactMatchingOperationResult(builder.b(), builder2.b());
    }

    private HashSet<String> m3861a() {
        int i = 0;
        HashSet<String> hashSet = new HashSet();
        if (this.f4237b.a(ExperimentsForSMSMigrationModule.f4217a, false)) {
            ImmutableList c = ((ContactListsCache) this.f4236a.get()).c();
            if (c != null) {
                int size = c.size();
                while (i < size) {
                    hashSet.add(((User) c.get(i)).a);
                    i++;
                }
            }
        }
        return hashSet;
    }

    public static ImmutableList<TopSmsContact> m3862c(ImmutableList<SMSLocalContactRow> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SMSLocalContactRow sMSLocalContactRow = (SMSLocalContactRow) immutableList.get(i);
            builder.c(new TopSmsContact(sMSLocalContactRow.f4181a, sMSLocalContactRow.f4182b, sMSLocalContactRow.f4183c, sMSLocalContactRow.f4184d));
        }
        return builder.b();
    }
}

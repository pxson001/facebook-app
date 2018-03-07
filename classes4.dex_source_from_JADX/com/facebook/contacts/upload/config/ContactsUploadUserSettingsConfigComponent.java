package com.facebook.contacts.upload.config;

import com.facebook.config.background.AbstractConfigurationComponent;
import com.facebook.contacts.upload.data.ContactsUploadDbHandler;
import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.contacts.upload.protocol.GetContactsUploadSettingsMethod;
import com.facebook.contacts.upload.protocol.GetContactsUploadSettingsMethod.Result;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.collect.ImmutableList;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: rtc_agg_exp_uni */
public class ContactsUploadUserSettingsConfigComponent extends AbstractConfigurationComponent {
    private final FbSharedPreferences f3309a;
    public final ContactsUploadDbHandler f3310b;
    public final GetContactsUploadSettingsMethod f3311c;
    public final ContactUploadStatusHelper f3312d;
    private final BatchComponent f3313e = new C01501(this);

    /* compiled from: rtc_agg_exp_uni */
    class C01501 implements BatchComponent {
        final /* synthetic */ ContactsUploadUserSettingsConfigComponent f3314a;

        C01501(ContactsUploadUserSettingsConfigComponent contactsUploadUserSettingsConfigComponent) {
            this.f3314a = contactsUploadUserSettingsConfigComponent;
        }

        public final Iterable<BatchOperation> mo99a() {
            Builder a = BatchOperation.m12541a(this.f3314a.f3311c, null);
            a.f11927c = "contacts_upload_settings";
            return ImmutableList.of(a.m12549a());
        }

        public final void mo100a(Map<String, Object> map) {
            Result result = (Result) map.get("contacts_upload_settings");
            if (this.f3314a.f3312d.m11418a() && !result.f3431a) {
                this.f3314a.f3312d.m11417a(false);
                this.f3314a.f3310b.m12836a();
            }
        }
    }

    @Inject
    public ContactsUploadUserSettingsConfigComponent(FbSharedPreferences fbSharedPreferences, ContactsUploadDbHandler contactsUploadDbHandler, GetContactsUploadSettingsMethod getContactsUploadSettingsMethod, ContactUploadStatusHelper contactUploadStatusHelper) {
        this.f3309a = fbSharedPreferences;
        this.f3310b = contactsUploadDbHandler;
        this.f3311c = getContactsUploadSettingsMethod;
        this.f3312d = contactUploadStatusHelper;
    }

    public final BatchComponent mo101b() {
        return this.f3313e;
    }

    public final long co_() {
        return 86400000;
    }
}

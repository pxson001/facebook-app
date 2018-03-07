package com.facebook.growth.contactinviter;

import com.facebook.common.executors.FbAsyncTask;
import com.facebook.growth.contactinviter.ContactInviterFragment.C33552;
import com.facebook.growth.util.PhonebookUtils;
import com.facebook.ipc.model.FacebookPhonebookContact;
import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: TERMS */
public class PhoneContactFetcher {
    public PhonebookUtils f23313a;
    public C33552 f23314b;

    /* compiled from: TERMS */
    public class GetPhoneBookTask extends FbAsyncTask<Void, Void, List<FacebookPhonebookContact>> {
        final /* synthetic */ PhoneContactFetcher f23312a;

        public GetPhoneBookTask(PhoneContactFetcher phoneContactFetcher) {
            this.f23312a = phoneContactFetcher;
        }

        protected void onPostExecute(Object obj) {
            List<FacebookPhonebookContact> list = (List) obj;
            List arrayList = new ArrayList();
            for (FacebookPhonebookContact facebookPhonebookContact : list) {
                if (!Strings.isNullOrEmpty(facebookPhonebookContact.phone)) {
                    arrayList.add(new PhoneContactToken(facebookPhonebookContact.name, facebookPhonebookContact.phone));
                } else if (facebookPhonebookContact.a != null && facebookPhonebookContact.a.size() > 0) {
                    arrayList.add(new PhoneContactToken(facebookPhonebookContact.name, (String) facebookPhonebookContact.a.get(0)));
                }
            }
            if (this.f23312a.f23314b != null) {
                this.f23312a.f23314b.m24600a(arrayList);
            }
        }

        protected final Object m24624a(Object[] objArr) {
            return this.f23312a.f23313a.a();
        }
    }

    @Inject
    public PhoneContactFetcher(PhonebookUtils phonebookUtils) {
        this.f23313a = phonebookUtils;
    }
}

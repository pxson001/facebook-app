package com.facebook.contacts.ccu;

import com.facebook.contacts.ccu.snapshot.ContactsUploadSnapshot;
import java.util.List;

/* compiled from: profilePhotoSource */
public class ContactsUploadClient$UploadContactBatchInfo {
    public final int f6209a;
    public final List<AddressbookContact> f6210b;
    public final List<ContactsUploadSnapshot> f6211c;
    public boolean f6212d;

    public ContactsUploadClient$UploadContactBatchInfo(int i, List<AddressbookContact> list, List<ContactsUploadSnapshot> list2, boolean z) {
        this.f6209a = i;
        this.f6210b = list;
        this.f6211c = list2;
        this.f6212d = z;
    }
}

package com.facebook.contacts.upload.data;

import com.google.common.base.Objects;

/* compiled from: tapped_all_photos */
public class PhoneAddressBookSnapshotEntry {
    public final long f2197a;
    public final String f2198b;

    public PhoneAddressBookSnapshotEntry(long j, String str) {
        this.f2197a = j;
        this.f2198b = str;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneAddressBookSnapshotEntry phoneAddressBookSnapshotEntry = (PhoneAddressBookSnapshotEntry) obj;
        if (Objects.equal(this.f2198b, phoneAddressBookSnapshotEntry.f2198b) && Objects.equal(Long.valueOf(this.f2197a), Long.valueOf(phoneAddressBookSnapshotEntry.f2197a))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f2198b, Long.valueOf(this.f2197a)});
    }
}

package com.facebook.contacts.upload.data;

import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: tapped_all_nearby_locations_map */
public class PhoneAddressBookSnapshotEntryChange {
    public final ChangeType f2199a;
    public final long f2200b;
    public final PhoneAddressBookSnapshotEntry f2201c;

    /* compiled from: tapped_all_nearby_locations_map */
    public enum ChangeType {
        ADD,
        UPDATE,
        DELETE
    }

    public PhoneAddressBookSnapshotEntryChange(ChangeType changeType, long j, @Nullable PhoneAddressBookSnapshotEntry phoneAddressBookSnapshotEntry) {
        this.f2199a = changeType;
        this.f2200b = j;
        this.f2201c = phoneAddressBookSnapshotEntry;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneAddressBookSnapshotEntryChange phoneAddressBookSnapshotEntryChange = (PhoneAddressBookSnapshotEntryChange) obj;
        if (Objects.equal(this.f2199a, phoneAddressBookSnapshotEntryChange.f2199a) && Objects.equal(Long.valueOf(this.f2200b), Long.valueOf(phoneAddressBookSnapshotEntryChange.f2200b)) && Objects.equal(this.f2201c, phoneAddressBookSnapshotEntryChange.f2201c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f2199a, Long.valueOf(this.f2200b), this.f2201c});
    }
}

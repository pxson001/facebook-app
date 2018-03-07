package com.facebook.mqtt;

import android.util.Base64;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = AddressEntryDeserializer.class)
@Immutable
/* compiled from: torch */
class AddressEntry {
    private ImmutableList<InetAddress> f2840a;
    @JsonProperty("address_list_data")
    ImmutableList<String> mAddressListData;
    @JsonProperty("fail_count")
    final int mFailCount;
    @JsonProperty("host_name")
    final String mHostName;
    @JsonProperty("priority")
    final int mPriority;

    private ImmutableList<InetAddress> m3950a() {
        if (this.f2840a == null) {
            Builder builder = ImmutableList.builder();
            int size = this.mAddressListData.size();
            for (int i = 0; i < size; i++) {
                Object byAddress;
                try {
                    byAddress = InetAddress.getByAddress(Base64.decode((String) this.mAddressListData.get(i), 0));
                } catch (UnknownHostException e) {
                    byAddress = null;
                } catch (IllegalArgumentException e2) {
                    byAddress = null;
                }
                if (byAddress != null) {
                    builder.c(byAddress);
                }
            }
            this.f2840a = builder.b();
        }
        return this.f2840a;
    }

    public AddressEntry() {
        this("", null, 0, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AddressEntry addressEntry = (AddressEntry) obj;
        if (m3950a().equals(addressEntry.m3950a()) && this.mHostName.equals(addressEntry.mHostName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.mHostName.hashCode() * 31) + m3950a().hashCode();
    }

    private AddressEntry(String str, @Nullable ImmutableList<InetAddress> immutableList, int i, int i2) {
        this.mHostName = str;
        this.f2840a = immutableList;
        if (this.f2840a != null) {
            Builder builder = ImmutableList.builder();
            int size = this.f2840a.size();
            for (int i3 = 0; i3 < size; i3++) {
                builder.c(Base64.encodeToString(((InetAddress) this.f2840a.get(i3)).getAddress(), 0));
            }
            this.mAddressListData = builder.b();
        }
        this.mPriority = i;
        this.mFailCount = i2;
    }

    public String toString() {
        return "AE{'" + this.mHostName + '\'' + ", " + m3950a().toString() + ", " + this.mPriority + ", " + this.mFailCount + '}';
    }
}

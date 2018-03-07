package com.facebook.placetips.bootstrap.data;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.stringformat.StringFormatUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Objects;
import java.util.UUID;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PulsarRecordDeserializer.class)
@JsonSerialize(using = PulsarRecordSerializer.class)
/* compiled from: search_fragment_resumed */
public class PulsarRecord {
    @JsonProperty("company_identifier")
    final int mCompanyIdentifier;
    @JsonProperty("major")
    final int mMajor;
    @JsonProperty("minor")
    final int mMinor;
    @JsonProperty("pulsar_ad_indicator")
    final int mPulsarAdvertismentIndicator;
    @JsonProperty("uuid")
    final UUID mUUID;

    public PulsarRecord(int i, int i2, UUID uuid, int i3, int i4) {
        this.mCompanyIdentifier = i;
        this.mPulsarAdvertismentIndicator = i2;
        this.mUUID = uuid;
        this.mMajor = i3;
        this.mMinor = i4;
    }

    public PulsarRecord() {
        this.mCompanyIdentifier = -1;
        this.mPulsarAdvertismentIndicator = -1;
        this.mUUID = null;
        this.mMajor = -1;
        this.mMinor = -1;
    }

    public final UUID m3723a() {
        return this.mUUID;
    }

    public final int m3724b() {
        return this.mMajor;
    }

    public final int m3725c() {
        return this.mMinor;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Integer.valueOf(this.mCompanyIdentifier), Integer.valueOf(this.mPulsarAdvertismentIndicator), this.mUUID, Integer.valueOf(this.mMajor), Integer.valueOf(this.mMinor)});
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof PulsarRecord) && hashCode() == obj.hashCode();
    }

    public String toString() {
        return StringFormatUtil.a("Pulsar Record: companyIdent: %d, adIndicator: %d, major: %d, minor: %d, uuid: %s", new Object[]{Integer.valueOf(this.mCompanyIdentifier), Integer.valueOf(this.mPulsarAdvertismentIndicator), Integer.valueOf(this.mMajor), Integer.valueOf(this.mMinor), this.mUUID});
    }
}

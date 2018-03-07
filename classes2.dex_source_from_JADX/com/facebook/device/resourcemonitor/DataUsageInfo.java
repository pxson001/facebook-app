package com.facebook.device.resourcemonitor;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.qe.schema.Locators;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.text.DecimalFormat;

@AutoGenJsonDeserializer
@JsonDeserialize(using = DataUsageInfoDeserializer.class)
/* compiled from: set1 */
public class DataUsageInfo implements JsonSerializable {
    private static DecimalFormat f5372a = new DecimalFormat("##0.0");
    @JsonProperty("MobileReceivedBytes")
    private long mMobileReceivedBytes;
    @JsonProperty("MobileSentBytes")
    private long mMobileSentBytes;
    @JsonProperty("WifiReceivedBytes")
    private long mWifiReceivedBytes;
    @JsonProperty("WifiSentBytes")
    private long mWifiSentBytes;

    public DataUsageInfo(long j, long j2, long j3, long j4) {
        this.mWifiReceivedBytes = j;
        this.mWifiSentBytes = j2;
        this.mMobileReceivedBytes = j3;
        this.mMobileSentBytes = j4;
    }

    DataUsageInfo() {
    }

    public final long m9254a() {
        return ((this.mWifiReceivedBytes + this.mWifiSentBytes) + this.mMobileReceivedBytes) + this.mMobileSentBytes;
    }

    public String toString() {
        return StringFormatUtil.a("Wifi received: %s, Wifi sent: %s, Mobile received: %s, Mobile sent: %s, Total: %s", new Object[]{m9253e(this.mWifiReceivedBytes), m9253e(this.mWifiSentBytes), m9253e(this.mMobileReceivedBytes), m9253e(this.mMobileSentBytes), m9253e(m9254a())});
    }

    final void m9255a(long j) {
        this.mWifiReceivedBytes += j;
    }

    final void m9256b(long j) {
        this.mWifiSentBytes += j;
    }

    final void m9257c(long j) {
        this.mMobileReceivedBytes += j;
    }

    final void m9258d(long j) {
        this.mMobileSentBytes += j;
    }

    private static String m9253e(long j) {
        if (j < Locators.dm) {
            return j + "B";
        }
        if (j < 1048576) {
            return StringFormatUtil.formatStrLocaleSafe("%sKB", f5372a.format(((double) j) / 1024.0d));
        }
        return StringFormatUtil.formatStrLocaleSafe("%sMB", f5372a.format(((double) j) / 1048576.0d));
    }

    public void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        m9252a(jsonGenerator);
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) {
        m9252a(jsonGenerator);
    }

    private void m9252a(JsonGenerator jsonGenerator) {
        jsonGenerator.mo1134f();
        jsonGenerator.mo1115a("WifiReceivedBytes");
        jsonGenerator.mo1111a(this.mWifiReceivedBytes);
        jsonGenerator.mo1115a("WifiSentBytes");
        jsonGenerator.mo1111a(this.mWifiSentBytes);
        jsonGenerator.mo1115a("MobileReceivedBytes");
        jsonGenerator.mo1111a(this.mMobileReceivedBytes);
        jsonGenerator.mo1115a("MobileSentBytes");
        jsonGenerator.mo1111a(this.mMobileSentBytes);
        jsonGenerator.mo1136g();
    }
}

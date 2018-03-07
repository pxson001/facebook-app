package com.facebook.platform.common.action;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.util.StringUtil;
import com.facebook.platform.common.PlatformConstants;
import com.facebook.platform.common.activity.PlatformActivityActionNotSupportedException;
import com.facebook.platform.common.activity.PlatformActivityErrorBundleBuilder;

/* compiled from: streamingImageThumbnail */
public class PlatformAppCall implements Parcelable {
    public static final Creator<PlatformAppCall> CREATOR = new C02221();
    public final String f4010a;
    public final int f4011b;
    public final boolean f4012c;
    public final String f4013d;
    public final String f4014e;
    public final String f4015f;
    public final String f4016g;
    public final String f4017h;
    public final String f4018i;
    public final String f4019j;

    /* compiled from: streamingImageThumbnail */
    final class C02221 implements Creator<PlatformAppCall> {
        C02221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PlatformAppCall(parcel);
        }

        public final Object[] newArray(int i) {
            return new PlatformAppCall[i];
        }
    }

    /* compiled from: streamingImageThumbnail */
    public class Builder {
        public String f4000a;
        public int f4001b;
        public boolean f4002c;
        public String f4003d;
        public String f4004e;
        public String f4005f;
        public String f4006g;
        public String f4007h;
        public String f4008i;
        public String f4009j;

        public Builder(Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                throw new PlatformActivityActionNotSupportedException(PlatformActivityErrorBundleBuilder.m5924a("Unable to proceed with no extras in Intent", new Object[0]).f4035a);
            }
            Object obj = extras.get("com.facebook.platform.protocol.PROTOCOL_VERSION");
            if (obj instanceof Integer) {
                this.f4001b = ((Integer) obj).intValue();
                if (PlatformConstants.f3998a.contains(Integer.valueOf(this.f4001b))) {
                    obj = extras.get("com.facebook.platform.extra.APPLICATION_ID");
                    if (obj instanceof String) {
                        this.f4004e = (String) obj;
                        obj = extras.get("com.facebook.platform.extra.METADATA");
                        if (obj instanceof String) {
                            this.f4008i = (String) obj;
                        }
                        this.f4007h = intent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
                        this.f4009j = intent.getStringExtra("composer_session_id");
                        Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
                        if (bundleExtra == null || this.f4001b < 20140701) {
                            this.f4005f = intent.getStringExtra("com.facebook.platform.extra.APPLICATION_NAME");
                            this.f4000a = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
                        } else {
                            this.f4002c = true;
                            this.f4005f = bundleExtra.getString("app_name");
                            this.f4000a = bundleExtra.getString("action_id");
                        }
                        if (StringUtil.a(this.f4000a)) {
                            this.f4000a = SafeUUIDGenerator.a().toString();
                            return;
                        }
                        return;
                    }
                    throw new PlatformActivityActionNotSupportedException(PlatformActivityErrorBundleBuilder.m5923a("com.facebook.platform.extra.APPLICATION_ID", String.class, obj).f4035a);
                }
                throw new PlatformActivityActionNotSupportedException(PlatformActivityErrorBundleBuilder.m5924a("Unknown protocol version extra '%s': %d", "com.facebook.platform.protocol.PROTOCOL_VERSION", Integer.valueOf(this.f4001b)).f4035a);
            }
            throw new PlatformActivityActionNotSupportedException(PlatformActivityErrorBundleBuilder.m5923a("com.facebook.platform.protocol.PROTOCOL_VERSION", Integer.class, obj).f4035a);
        }

        public final Builder m5908a(String str) {
            this.f4003d = str;
            return this;
        }

        public final Builder m5910b(String str) {
            this.f4006g = str;
            return this;
        }

        public final PlatformAppCall m5909a() {
            return new PlatformAppCall(this);
        }
    }

    public PlatformAppCall(String str, int i, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.f4010a = str;
        this.f4011b = i;
        this.f4012c = z;
        this.f4013d = str2;
        this.f4014e = str3;
        this.f4015f = str4;
        this.f4016g = str5;
        this.f4017h = str6;
        this.f4018i = str7;
        this.f4019j = str8;
    }

    public PlatformAppCall(Builder builder) {
        this.f4010a = builder.f4000a;
        this.f4011b = builder.f4001b;
        this.f4012c = builder.f4002c;
        this.f4013d = builder.f4003d;
        this.f4014e = builder.f4004e;
        this.f4015f = builder.f4005f;
        this.f4016g = builder.f4006g;
        this.f4017h = builder.f4008i;
        this.f4018i = builder.f4007h;
        this.f4019j = builder.f4009j;
    }

    public PlatformAppCall(Parcel parcel) {
        this.f4010a = parcel.readString();
        this.f4011b = parcel.readInt();
        this.f4013d = parcel.readString();
        this.f4014e = parcel.readString();
        this.f4015f = parcel.readString();
        this.f4016g = parcel.readString();
        this.f4017h = parcel.readString();
        this.f4018i = parcel.readString();
        this.f4019j = parcel.readString();
        this.f4012c = parcel.createBooleanArray()[0];
    }

    public final String m5912a() {
        return this.f4010a;
    }

    public final boolean m5913d() {
        return this.f4012c && this.f4011b >= 20141107;
    }

    public final String m5914j() {
        return this.f4018i;
    }

    public static Bundle m5911a(Intent intent) {
        Bundle bundleExtra = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
        if (bundleExtra != null) {
            return new Bundle(bundleExtra);
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4010a);
        parcel.writeInt(this.f4011b);
        parcel.writeString(this.f4013d);
        parcel.writeString(this.f4014e);
        parcel.writeString(this.f4015f);
        parcel.writeString(this.f4016g);
        parcel.writeString(this.f4017h);
        parcel.writeString(this.f4018i);
        parcel.writeString(this.f4019j);
        parcel.writeBooleanArray(new boolean[]{this.f4012c});
    }
}

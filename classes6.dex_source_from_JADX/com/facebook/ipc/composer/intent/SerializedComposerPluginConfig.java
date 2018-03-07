package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = SerializedComposerPluginConfigDeserializer.class)
@JsonSerialize(using = SerializedComposerPluginConfigSerializer.class)
/* compiled from: liked */
public class SerializedComposerPluginConfig implements Parcelable {
    public static final Creator<SerializedComposerPluginConfig> CREATOR = new C07411();
    @JsonProperty("data")
    @Nullable
    final String mData;
    @JsonProperty("persist_key")
    final String mPersistenceKey;

    /* compiled from: liked */
    final class C07411 implements Creator<SerializedComposerPluginConfig> {
        C07411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SerializedComposerPluginConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new SerializedComposerPluginConfig[i];
        }
    }

    public static SerializedComposerPluginConfig m18282a(HasPersistenceKey hasPersistenceKey, @Nullable String str) {
        return new SerializedComposerPluginConfig(hasPersistenceKey, str);
    }

    private SerializedComposerPluginConfig(HasPersistenceKey hasPersistenceKey, @Nullable String str) {
        Preconditions.checkNotNull(hasPersistenceKey);
        this.mPersistenceKey = hasPersistenceKey.mo1081b();
        Preconditions.checkNotNull(this.mPersistenceKey);
        this.mData = str;
    }

    private SerializedComposerPluginConfig() {
        this.mPersistenceKey = "ComposerPluginConfig_from_json";
        this.mData = null;
    }

    public SerializedComposerPluginConfig(Parcel parcel) {
        this.mPersistenceKey = parcel.readString();
        this.mData = parcel.readString();
    }

    public final String m18283a() {
        return this.mPersistenceKey;
    }

    @Nullable
    public final String m18284b() {
        return this.mData;
    }

    public String toString() {
        return this.mPersistenceKey;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mPersistenceKey);
        parcel.writeString(this.mData);
    }
}

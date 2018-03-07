package com.facebook.assetdownload;

import android.net.Uri;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@AutoGenJsonDeserializer
/* compiled from: profile_wizard_nux */
public class AssetDownloadConfiguration {
    public static final Uri f7255a = null;
    public static final ConnectionConstraint f7256b = ConnectionConstraint.CAN_BE_ANY;
    public static final StorageConstraint f7257c = StorageConstraint.CAN_BE_EXTERNAL;
    public static final File f7258d = null;
    public static final String f7259e = null;
    public static final ImmutableMap<String, String> f7260f = RegularImmutableBiMap.a;
    private Uri f7261g;
    private File f7262h;
    @JsonProperty("analytics_tag")
    public String mAnalyticsTag;
    @JsonProperty("connection_constraint")
    public ConnectionConstraint mConnectionConstraint;
    @JsonProperty("http_headers")
    public ImmutableMap<String, String> mHttpHeaders;
    @JsonProperty("identifier")
    public String mIdentifier;
    @JsonProperty("namespace")
    public String mNamespace;
    @JsonProperty("priority")
    public int mPriority;
    @JsonProperty("storage_constraint")
    public StorageConstraint mStorageConstraint;
    @JsonProperty("custom_location")
    String mStringCustomLocation;
    @JsonProperty("source")
    String mStringSource;

    /* compiled from: profile_wizard_nux */
    public class Builder {
        private final String f7246a;
        public Uri f7247b = AssetDownloadConfiguration.f7255a;
        public int f7248c = 0;
        public ConnectionConstraint f7249d = AssetDownloadConfiguration.f7256b;
        public StorageConstraint f7250e = AssetDownloadConfiguration.f7257c;
        private String f7251f = "default_asset_download";
        private File f7252g = AssetDownloadConfiguration.f7258d;
        public String f7253h = AssetDownloadConfiguration.f7259e;
        public Map<String, String> f7254i = new HashMap();

        public Builder(String str) {
            this.f7246a = str;
        }

        public final AssetDownloadConfiguration m10372a() {
            return new AssetDownloadConfiguration(this.f7246a, this.f7247b, this.f7248c, this.f7249d, this.f7250e, this.f7251f, this.f7252g, this.f7253h, this.f7254i);
        }
    }

    /* compiled from: profile_wizard_nux */
    public enum ConnectionConstraint {
        CAN_BE_ANY,
        MUST_BE_WIFI
    }

    /* compiled from: profile_wizard_nux */
    public enum StorageConstraint {
        CAN_BE_EXTERNAL,
        MUST_BE_INTERNAL,
        MUST_BE_CUSTOM_LOCATION
    }

    AssetDownloadConfiguration() {
        this("", f7255a, 0, f7256b, f7257c, "default_asset_download", f7258d, f7259e, f7260f);
    }

    AssetDownloadConfiguration(String str, Uri uri, int i, ConnectionConstraint connectionConstraint, StorageConstraint storageConstraint, String str2, File file, String str3, Map<String, String> map) {
        String str4 = null;
        Preconditions.checkNotNull(str, "identifier must not be null");
        this.mIdentifier = str;
        this.f7261g = uri;
        this.mStringSource = uri != null ? uri.toString() : null;
        this.mPriority = i;
        this.mConnectionConstraint = connectionConstraint;
        this.mStorageConstraint = storageConstraint;
        this.mAnalyticsTag = str2;
        this.f7262h = file;
        if (this.f7262h != null) {
            str4 = this.f7262h.getAbsolutePath();
        }
        this.mStringCustomLocation = str4;
        this.mNamespace = str3;
        this.mHttpHeaders = ImmutableMap.copyOf(map);
    }

    public final Uri m10373a() {
        if (this.f7261g == null && this.mStringSource != null) {
            this.f7261g = Uri.parse(this.mStringSource);
        }
        return this.f7261g;
    }

    public final int m10374b() {
        return this.mPriority;
    }

    public final StorageConstraint m10375d() {
        return this.mStorageConstraint;
    }

    public final String m10376e() {
        return this.mIdentifier;
    }

    @Nullable
    public final File m10377g() {
        if (this.f7262h == null && this.mStringCustomLocation != null) {
            this.f7262h = new File(this.mStringCustomLocation);
        }
        return this.f7262h;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("identifier", this.mIdentifier).add("source", m10373a()).add("priority", this.mPriority).add("connectionConstraint", this.mConnectionConstraint).add("storageConstraint", this.mStorageConstraint).add("analyticsTag", this.mAnalyticsTag).add("customLocation", m10377g()).add("namespace", this.mNamespace).toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.mIdentifier.equals(((AssetDownloadConfiguration) obj).mIdentifier);
    }

    public int hashCode() {
        return this.mIdentifier.hashCode();
    }
}

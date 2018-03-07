package com.facebook.composer.audienceeducator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.privacy.audience.AudienceEducatorManager.AudienceEducatorType;
import com.google.common.base.Objects;

/* compiled from: createView */
public final class ComposerAudienceEducatorData implements Parcelable {
    public static final Creator<ComposerAudienceEducatorData> CREATOR = new C13181();
    public final String f16676a;
    public final String f16677b;
    public final String f16678c;
    public final TagExpansionExplanationType f16679d;
    public final AudienceEducatorType f16680e;
    public final boolean f16681f;
    public final boolean f16682g;
    public final boolean f16683h;

    /* compiled from: createView */
    final class C13181 implements Creator<ComposerAudienceEducatorData> {
        C13181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerAudienceEducatorData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerAudienceEducatorData[i];
        }
    }

    /* compiled from: createView */
    public class Builder {
        public String f16668a;
        public String f16669b;
        public String f16670c;
        public TagExpansionExplanationType f16671d;
        public AudienceEducatorType f16672e;
        public boolean f16673f;
        public boolean f16674g;
        public boolean f16675h;

        public Builder(ComposerAudienceEducatorData composerAudienceEducatorData) {
            this.f16668a = composerAudienceEducatorData.f16676a;
            this.f16669b = composerAudienceEducatorData.f16677b;
            this.f16670c = composerAudienceEducatorData.f16678c;
            this.f16671d = composerAudienceEducatorData.f16679d;
            this.f16672e = composerAudienceEducatorData.f16680e;
            this.f16673f = composerAudienceEducatorData.f16681f;
            this.f16674g = composerAudienceEducatorData.f16682g;
            this.f16675h = composerAudienceEducatorData.f16683h;
        }

        public final ComposerAudienceEducatorData m20707a() {
            return new ComposerAudienceEducatorData(this);
        }
    }

    /* compiled from: createView */
    public enum TagExpansionExplanationType {
        NONE,
        TAGGEES,
        FRIENDS_OF_TAGGEES
    }

    public ComposerAudienceEducatorData(Builder builder) {
        this.f16676a = builder.f16668a;
        this.f16677b = builder.f16669b;
        this.f16678c = builder.f16670c;
        this.f16679d = builder.f16671d;
        this.f16680e = builder.f16672e;
        this.f16681f = builder.f16673f;
        this.f16682g = builder.f16674g;
        this.f16683h = builder.f16675h;
    }

    public ComposerAudienceEducatorData(Parcel parcel) {
        this.f16676a = parcel.readString();
        this.f16677b = parcel.readString();
        this.f16678c = parcel.readString();
        this.f16679d = (TagExpansionExplanationType) ParcelUtil.c(parcel, TagExpansionExplanationType.class);
        this.f16680e = (AudienceEducatorType) ParcelUtil.c(parcel, AudienceEducatorType.class);
        this.f16681f = ParcelUtil.a(parcel);
        this.f16682g = ParcelUtil.a(parcel);
        this.f16683h = ParcelUtil.a(parcel);
    }

    public final Builder m20708a() {
        return new Builder(this);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f16676a);
        parcel.writeString(this.f16677b);
        parcel.writeString(this.f16678c);
        ParcelUtil.a(parcel, this.f16679d);
        ParcelUtil.a(parcel, this.f16680e);
        ParcelUtil.a(parcel, this.f16681f);
        ParcelUtil.a(parcel, this.f16682g);
        ParcelUtil.a(parcel, this.f16683h);
    }

    public final String toString() {
        return Objects.toStringHelper(ComposerAudienceEducatorData.class).add("tooltipTitle", this.f16676a).add("tooltipBody", this.f16677b).add("selectedPrivacyName", this.f16678c).add("tagExpansionEducationType", this.f16679d).add("educatorType", this.f16680e).add("selectedMoreOptions", this.f16681f).add("reshowFlow", this.f16682g).add("usingDefaultAudience", this.f16683h).toString();
    }
}

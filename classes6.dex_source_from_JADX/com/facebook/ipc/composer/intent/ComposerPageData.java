package com.facebook.ipc.composer.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@AutoGenJsonSerializer
@JsonDeserialize(using = Deserializer.class)
@JsonSerialize(using = ComposerPageDataSerializer.class)
/* compiled from: load_time */
public class ComposerPageData implements Parcelable {
    public static final Creator<ComposerPageData> CREATOR = new C07361();
    public final boolean f11556a;
    @Nullable
    public final ViewerContext f11557b;

    /* compiled from: load_time */
    final class C07361 implements Creator<ComposerPageData> {
        C07361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ComposerPageData(parcel);
        }

        public final Object[] newArray(int i) {
            return new ComposerPageData[i];
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = ComposerPageData_BuilderDeserializer.class)
    /* compiled from: load_time */
    public class Builder {
        public boolean f11553a;
        @Nullable
        public ViewerContext f11554b;

        public Builder(ComposerPageData composerPageData) {
            Preconditions.checkNotNull(composerPageData);
            if (composerPageData instanceof ComposerPageData) {
                composerPageData = composerPageData;
                this.f11553a = composerPageData.f11556a;
                this.f11554b = composerPageData.f11557b;
                return;
            }
            this.f11553a = composerPageData.getIsPageVerified();
            this.f11554b = composerPageData.getPostAsPageViewerContext();
        }

        public final ComposerPageData m18233a() {
            return new ComposerPageData(this);
        }

        @JsonProperty("is_page_verified")
        public Builder setIsPageVerified(boolean z) {
            this.f11553a = z;
            return this;
        }

        @JsonProperty("post_as_page_viewer_context")
        public Builder setPostAsPageViewerContext(@Nullable ViewerContext viewerContext) {
            this.f11554b = viewerContext;
            return this;
        }
    }

    /* compiled from: load_time */
    class Deserializer extends JsonDeserializer<ComposerPageData> {
        private static final ComposerPageData_BuilderDeserializer f11555a = new ComposerPageData_BuilderDeserializer();

        private Deserializer() {
        }

        public Object m18234a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return ((Builder) f11555a.a(jsonParser, deserializationContext)).m18233a();
        }
    }

    public ComposerPageData(Builder builder) {
        this.f11556a = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(builder.f11553a))).booleanValue();
        this.f11557b = builder.f11554b;
    }

    public ComposerPageData(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f11556a = z;
        if (parcel.readInt() == 0) {
            this.f11557b = null;
        } else {
            this.f11557b = (ViewerContext) parcel.readParcelable(ViewerContext.class.getClassLoader());
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder m18235a(ComposerPageData composerPageData) {
        return new Builder(composerPageData);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f11556a ? 1 : 0);
        if (this.f11557b == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeParcelable(this.f11557b, i);
    }

    public int describeContents() {
        return 0;
    }

    @JsonProperty("is_page_verified")
    public boolean getIsPageVerified() {
        return this.f11556a;
    }

    @JsonProperty("post_as_page_viewer_context")
    @Nullable
    public ViewerContext getPostAsPageViewerContext() {
        return this.f11557b;
    }
}

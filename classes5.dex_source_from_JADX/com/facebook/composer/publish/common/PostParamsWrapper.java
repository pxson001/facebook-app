package com.facebook.composer.publish.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.RetrySource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PostParamsWrapperDeserializer.class)
@JsonSerialize(using = PostParamsWrapperSerializer.class)
/* compiled from: actor */
public class PostParamsWrapper implements Parcelable {
    public static final Creator<PostParamsWrapper> CREATOR = new C10881();
    @JsonProperty("edit_post_params")
    @Nullable
    private final EditPostParams editPostParams;
    @JsonProperty("publish_post_params")
    @Nullable
    private final PublishPostParams publishPostParams;

    /* compiled from: actor */
    final class C10881 implements Creator<PostParamsWrapper> {
        C10881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PostParamsWrapper(parcel);
        }

        public final Object[] newArray(int i) {
            return new PostParamsWrapper[i];
        }
    }

    private PostParamsWrapper() {
        this.publishPostParams = null;
        this.editPostParams = null;
    }

    public PostParamsWrapper(PublishPostParams publishPostParams) {
        Preconditions.checkNotNull(publishPostParams);
        this.publishPostParams = publishPostParams;
        this.editPostParams = null;
    }

    public PostParamsWrapper(EditPostParams editPostParams) {
        Preconditions.checkNotNull(editPostParams);
        this.publishPostParams = null;
        this.editPostParams = editPostParams;
    }

    public PostParamsWrapper(PostParamsWrapper postParamsWrapper) {
        boolean z = (postParamsWrapper.publishPostParams == null && postParamsWrapper.editPostParams == null) ? false : true;
        Preconditions.checkArgument(z);
        if (postParamsWrapper.publishPostParams != null) {
            this.publishPostParams = new Builder(postParamsWrapper.publishPostParams).m19701a();
            this.editPostParams = null;
            return;
        }
        this.publishPostParams = null;
        this.editPostParams = new EditPostParams.Builder(postParamsWrapper.editPostParams).m19645a();
    }

    public PostParamsWrapper(Parcel parcel) {
        this.publishPostParams = (PublishPostParams) parcel.readParcelable(PublishPostParams.class.getClassLoader());
        this.editPostParams = (EditPostParams) parcel.readParcelable(EditPostParams.class.getClassLoader());
    }

    public final String m19680a() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.composerSessionId;
        }
        return this.editPostParams.composerSessionId;
    }

    @Nullable
    public final ErrorDetails m19683b() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.m19715b();
        }
        return this.editPostParams.m19647a();
    }

    public final void m19681a(ErrorDetails errorDetails) {
        if (this.publishPostParams != null) {
            this.publishPostParams.m19713a(errorDetails);
        } else {
            this.editPostParams.m19648a(errorDetails);
        }
    }

    public final long m19684c() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.originalPostTime;
        }
        return this.editPostParams.originalPostTime;
    }

    public final long m19685d() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.targetId;
        }
        return ((EditPostParams) Preconditions.checkNotNull(this.editPostParams)).targetId;
    }

    public final boolean m19686e() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.isPhotoContainer;
        }
        return ((EditPostParams) Preconditions.checkNotNull(this.editPostParams)).isPhotoContainer;
    }

    public final ComposerType m19687f() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.composerType;
        }
        return ComposerType.STATUS;
    }

    public final void m19682a(RetrySource retrySource) {
        if (this.publishPostParams != null) {
            this.publishPostParams.m19714a(retrySource);
        }
    }

    public final int m19688g() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.m19716c();
        }
        return 0;
    }

    @Nullable
    public final String m19689h() {
        if (this.publishPostParams != null) {
            return this.publishPostParams.referencedStickerId;
        }
        return null;
    }

    @Nullable
    public final String m19690i() {
        if (this.editPostParams != null) {
            return this.editPostParams.legacyStoryApiId;
        }
        return null;
    }

    @Nullable
    public final EditPostParams m19691j() {
        return this.editPostParams;
    }

    @Nullable
    public final PublishPostParams m19692k() {
        return this.publishPostParams;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.publishPostParams, i);
        parcel.writeParcelable(this.editPostParams, i);
    }
}

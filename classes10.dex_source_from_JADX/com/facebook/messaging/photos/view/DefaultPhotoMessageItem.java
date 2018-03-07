package com.facebook.messaging.photos.view;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.photos.service.MediaMessageItem;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: registration_saved_unused_form_data */
public class DefaultPhotoMessageItem implements Parcelable, MediaMessageItem {
    public static final Creator<DefaultPhotoMessageItem> CREATOR = new C05571();
    public final ImageAttachmentData f3583a;
    public Uri f3584b = null;
    public boolean f3585c = false;
    @Nullable
    private final Message f3586d;
    private final MediaResource f3587e;

    /* compiled from: registration_saved_unused_form_data */
    final class C05571 implements Creator<DefaultPhotoMessageItem> {
        C05571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DefaultPhotoMessageItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new DefaultPhotoMessageItem[i];
        }
    }

    public DefaultPhotoMessageItem(ImageAttachmentData imageAttachmentData, @Nullable Message message) {
        long j;
        this.f3583a = imageAttachmentData;
        this.f3586d = message;
        Uri uri = imageAttachmentData.b != null ? imageAttachmentData.b.a : imageAttachmentData.a.a;
        MediaResourceBuilder a = MediaResource.a();
        a.b = Type.PHOTO;
        a = a;
        a.c = Source.ATTACHED_MEDIA;
        a = a;
        a.a = uri;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.s = imageAttachmentData.e;
        MediaResourceBuilder mediaResourceBuilder2 = mediaResourceBuilder;
        if (message == null) {
            j = 0;
        } else {
            j = message.c;
        }
        mediaResourceBuilder2.y = j;
        mediaResourceBuilder2 = mediaResourceBuilder2;
        if (message != null) {
            ImmutableList immutableList = message.i;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Attachment attachment = (Attachment) immutableList.get(i);
                if (attachment.c.equals(imageAttachmentData.e)) {
                    mediaResourceBuilder2.B = attachment.j;
                }
            }
        }
        this.f3587e = mediaResourceBuilder2.C();
    }

    public DefaultPhotoMessageItem(Parcel parcel) {
        this.f3583a = (ImageAttachmentData) parcel.readParcelable(ImageAttachmentData.class.getClassLoader());
        this.f3587e = (MediaResource) parcel.readParcelable(MediaResource.class.getClassLoader());
        this.f3586d = (Message) parcel.readParcelable(Message.class.getClassLoader());
    }

    public final int m3412b() {
        return this.f3583a.d;
    }

    public final int m3413c() {
        return this.f3583a.c;
    }

    public final MediaResource m3415e() {
        return this.f3587e;
    }

    public final void m3409a(Uri uri) {
        this.f3584b = uri;
    }

    public final void m3410a(boolean z) {
        this.f3585c = z;
    }

    public final boolean m3411a() {
        return this.f3585c;
    }

    public final Uri m3414d() {
        return (this.f3584b == null || !this.f3585c) ? m3415e().c : this.f3584b;
    }

    public final String m3416f() {
        return this.f3586d == null ? "" : this.f3586d.e.c;
    }

    public final UserKey m3417g() {
        return this.f3586d == null ? null : this.f3586d.e.b;
    }

    public final String m3418h() {
        return this.f3586d == null ? "" : this.f3586d.f;
    }

    @Nullable
    public final Message m3419i() {
        return this.f3586d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3583a, i);
        parcel.writeParcelable(this.f3587e, i);
        parcel.writeParcelable(this.f3586d, i);
    }
}

package com.facebook.goodwill.composer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.ipc.media.MediaItem;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: {package_name} */
public class GoodwillComposerEvent implements Parcelable {
    public static final Creator<GoodwillComposerEvent> CREATOR = new C00081();
    public final String f71a;
    public final String f72b;
    public final String f73c;
    private final String f74d;
    private final String f75e;
    private final String f76f;
    public final List<GoodwillPhoto> f77g;
    public final int f78h;
    public final String f79i;
    private String f80j;

    /* compiled from: {package_name} */
    final class C00081 implements Creator<GoodwillComposerEvent> {
        C00081() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GoodwillComposerEvent(parcel);
        }

        public final Object[] newArray(int i) {
            return new GoodwillComposerEvent[i];
        }
    }

    /* compiled from: {package_name} */
    public class GoodwillPhoto implements Parcelable {
        public static final Creator<GoodwillPhoto> CREATOR = new C00091();
        public String f68a;
        public final MediaItem f69b;
        public final GraphQLMedia f70c;

        /* compiled from: {package_name} */
        final class C00091 implements Creator<GoodwillPhoto> {
            C00091() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GoodwillPhoto(parcel);
            }

            public final Object[] newArray(int i) {
                return new GoodwillPhoto[i];
            }
        }

        public GoodwillPhoto(MediaItem mediaItem) {
            this.f68a = null;
            this.f69b = mediaItem;
            this.f70c = null;
        }

        public GoodwillPhoto(GraphQLMedia graphQLMedia) {
            this.f68a = graphQLMedia.b();
            this.f69b = null;
            this.f70c = graphQLMedia;
        }

        public GoodwillPhoto(Parcel parcel) {
            this.f68a = parcel.readString();
            this.f69b = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
            this.f70c = (GraphQLMedia) FlatBufferModelHelper.a(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f68a);
            parcel.writeParcelable(this.f69b, i);
            FlatBufferModelHelper.a(parcel, this.f70c);
        }

        public final Uri m89d() {
            if (this.f69b != null) {
                return this.f69b.f();
            }
            if (this.f70c == null || this.f70c.S() == null) {
                return null;
            }
            return ImageUtil.a(this.f70c.S());
        }
    }

    public GoodwillComposerEvent() {
        this.f80j = "";
        this.f71a = "";
        this.f73c = "";
        this.f72b = "";
        this.f74d = "";
        this.f75e = "";
        this.f76f = "";
        this.f77g = new ArrayList();
        this.f78h = 0;
        this.f79i = "";
    }

    public GoodwillComposerEvent(String str, String str2, String str3, String str4, String str5, String str6, int i, String str7) {
        this.f80j = "";
        this.f71a = str;
        this.f73c = str2;
        this.f72b = str3;
        this.f74d = str4;
        this.f75e = str5;
        this.f76f = str6;
        this.f77g = new ArrayList();
        this.f78h = i;
        this.f79i = str7;
    }

    public GoodwillComposerEvent(Parcel parcel) {
        this.f80j = "";
        this.f71a = parcel.readString();
        this.f73c = parcel.readString();
        this.f72b = parcel.readString();
        this.f74d = parcel.readString();
        this.f75e = parcel.readString();
        this.f76f = parcel.readString();
        this.f77g = new ArrayList();
        parcel.readTypedList(this.f77g, GoodwillPhoto.CREATOR);
        this.f78h = parcel.readInt();
        this.f80j = parcel.readString();
        this.f79i = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f71a);
        parcel.writeString(this.f73c);
        parcel.writeString(this.f72b);
        parcel.writeString(this.f74d);
        parcel.writeString(this.f75e);
        parcel.writeString(this.f76f);
        parcel.writeTypedList(this.f77g);
        parcel.writeInt(this.f78h);
        parcel.writeString(this.f80j);
        parcel.writeString(this.f79i);
    }

    public final String m90a() {
        return this.f71a;
    }

    public final String m93d() {
        return this.f74d;
    }

    public final String m94e() {
        return this.f75e;
    }

    public final String m95f() {
        return this.f76f;
    }

    public final ImmutableList<GoodwillPhoto> m96g() {
        return ImmutableList.copyOf(this.f77g);
    }

    public final void m91a(GoodwillPhoto goodwillPhoto) {
        this.f77g.add(goodwillPhoto);
    }

    public final void m92b(GoodwillPhoto goodwillPhoto) {
        this.f77g.remove(goodwillPhoto);
    }

    public final String m97i() {
        return this.f79i;
    }
}

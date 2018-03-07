package com.facebook.media.upload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.StringUtil;
import com.facebook.photos.upload.uploaders.VideoUploaderProgressListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: keyword_bootstrap_type */
public class MediaUploadParameters implements Parcelable {
    public static final Creator<MediaUploadParameters> CREATOR = new C07581();
    public final String f11891a;
    public final String f11892b;
    public final boolean f11893c;
    public final String f11894d;
    public final List<NameValuePair> f11895e;
    public final List<NameValuePair> f11896f;
    public final List<MediaAttachementBody> f11897g;
    public final VideoUploaderProgressListener f11898h;

    /* compiled from: keyword_bootstrap_type */
    final class C07581 implements Creator<MediaUploadParameters> {
        C07581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MediaUploadParameters(parcel);
        }

        public final Object[] newArray(int i) {
            return new MediaUploadParameters[i];
        }
    }

    public MediaUploadParameters(String str, String str2, boolean z, String str3, List<NameValuePair> list, List<NameValuePair> list2, List<MediaAttachementBody> list3, MediaUploadProgressListener mediaUploadProgressListener) {
        if (StringUtil.a(str)) {
            throw new IllegalArgumentException("Waterfall ID must be non empty");
        } else if (StringUtil.a(str2)) {
            throw new IllegalArgumentException("Target ID must be non empty");
        } else {
            this.f11891a = str;
            this.f11892b = str2;
            this.f11893c = z;
            this.f11894d = str3;
            this.f11895e = list;
            this.f11896f = list2;
            this.f11897g = list3;
            this.f11898h = mediaUploadProgressListener;
        }
    }

    public MediaUploadParameters(Parcel parcel) {
        boolean z = true;
        this.f11891a = parcel.readString();
        this.f11892b = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f11893c = z;
        this.f11894d = parcel.readString();
        this.f11895e = m18847a(parcel);
        this.f11896f = m18847a(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.f11897g = new ArrayList(readInt);
            parcel.readTypedList(this.f11897g, MediaAttachementBody.CREATOR);
        } else {
            this.f11897g = null;
        }
        this.f11898h = null;
    }

    public final String m18849a() {
        return this.f11891a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.f11891a);
        parcel.writeString(this.f11892b);
        parcel.writeInt(this.f11893c ? 1 : 0);
        parcel.writeString(this.f11894d);
        m18848a(this.f11895e, parcel);
        m18848a(this.f11896f, parcel);
        if (this.f11897g != null) {
            i2 = this.f11897g.size();
        }
        parcel.writeInt(i2);
        if (i2 > 0) {
            parcel.writeTypedList(this.f11897g);
        }
    }

    private static void m18848a(List<NameValuePair> list, Parcel parcel) {
        int size;
        int i = 0;
        if (list != null) {
            size = list.size();
        } else {
            size = 0;
        }
        parcel.writeInt(size);
        while (i < size) {
            NameValuePair nameValuePair = (NameValuePair) list.get(i);
            parcel.writeString(nameValuePair.getName());
            parcel.writeString(nameValuePair.getValue());
            i++;
        }
    }

    private static List<NameValuePair> m18847a(Parcel parcel) {
        List<NameValuePair> list = null;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            list = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                list.add(new BasicNameValuePair(parcel.readString(), parcel.readString()));
            }
        }
        return list;
    }
}

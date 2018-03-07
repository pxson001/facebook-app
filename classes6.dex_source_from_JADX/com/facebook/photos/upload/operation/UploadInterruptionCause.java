package com.facebook.photos.upload.operation;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.photos.base.analytics.ExceptionInterpreter;
import com.facebook.photos.base.analytics.ExceptionInterpreter.Diagnostic;
import com.facebook.photos.base.analytics.PhotoFlowLogger$ExceptionReporter;

/* compiled from: gms_ls_upsell */
public class UploadInterruptionCause implements Parcelable, PhotoFlowLogger$ExceptionReporter {
    public static final Creator<UploadInterruptionCause> CREATOR = new C08841();
    public final boolean f13691a;
    public final boolean f13692b;
    public final String f13693c;
    public final Diagnostic f13694d;
    private final String f13695e;
    private final String f13696f;
    private final int f13697g;
    private final int f13698h;
    private final String f13699i;

    /* compiled from: gms_ls_upsell */
    final class C08841 implements Creator<UploadInterruptionCause> {
        C08841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UploadInterruptionCause(parcel);
        }

        public final Object[] newArray(int i) {
            return new UploadInterruptionCause[i];
        }
    }

    public UploadInterruptionCause(Exception exception) {
        this(new ExceptionInterpreter(exception));
    }

    public UploadInterruptionCause(ExceptionInterpreter exceptionInterpreter) {
        this.f13691a = exceptionInterpreter.f12627l;
        this.f13692b = exceptionInterpreter.f12628m;
        this.f13693c = exceptionInterpreter.f12629n;
        this.f13694d = exceptionInterpreter.f12630o;
        this.f13695e = exceptionInterpreter.mo1089c();
        this.f13696f = exceptionInterpreter.mo1090d();
        this.f13697g = exceptionInterpreter.mo1091e();
        this.f13698h = exceptionInterpreter.mo1092f();
        this.f13699i = exceptionInterpreter.mo1093g();
    }

    public UploadInterruptionCause(Parcel parcel) {
        this.f13691a = ParcelUtil.a(parcel);
        this.f13692b = ParcelUtil.a(parcel);
        this.f13693c = parcel.readString();
        this.f13694d = Diagnostic.valueOf(parcel.readString());
        this.f13695e = parcel.readString();
        this.f13696f = parcel.readString();
        this.f13697g = parcel.readInt();
        this.f13698h = parcel.readInt();
        this.f13699i = parcel.readString();
    }

    public final boolean m21444a() {
        return this.f13691a;
    }

    public final boolean m21451h() {
        return this.f13692b;
    }

    public final String mo1088b() {
        return null;
    }

    public final String mo1089c() {
        return this.f13695e;
    }

    public final String mo1090d() {
        return this.f13696f;
    }

    public final int mo1091e() {
        return this.f13697g;
    }

    public final int mo1092f() {
        return this.f13698h;
    }

    public final String mo1093g() {
        return this.f13699i;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f13691a);
        ParcelUtil.a(parcel, this.f13692b);
        parcel.writeString(this.f13693c);
        parcel.writeString(this.f13694d.name());
        parcel.writeString(this.f13695e);
        parcel.writeString(this.f13696f);
        parcel.writeInt(this.f13697g);
        parcel.writeInt(this.f13698h);
        parcel.writeString(this.f13699i);
    }

    public int describeContents() {
        return 0;
    }
}

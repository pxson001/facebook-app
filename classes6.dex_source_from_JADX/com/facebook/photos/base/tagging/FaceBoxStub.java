package com.facebook.photos.base.tagging;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import java.util.List;

/* compiled from: initial_control_node */
public class FaceBoxStub implements TagTarget {
    public static final Creator<FaceBoxStub> CREATOR = new C08121();
    public RectF f12778a;
    public PointF f12779b;
    public PointF f12780c;

    /* compiled from: initial_control_node */
    final class C08121 implements Creator<FaceBoxStub> {
        C08121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FaceBoxStub(parcel);
        }

        public final Object[] newArray(int i) {
            return new FaceBoxStub[i];
        }
    }

    public FaceBoxStub(RectF rectF) {
        this.f12778a = (RectF) Preconditions.checkNotNull(rectF);
        this.f12779b = new PointF(rectF.centerX(), rectF.bottom);
        this.f12780c = new PointF(rectF.centerX(), rectF.centerY());
    }

    public final RectF mo1099d() {
        return this.f12778a;
    }

    public final PointF mo1100e() {
        return this.f12779b;
    }

    public final PointF mo1101f() {
        return this.f12780c;
    }

    public final List<TaggingProfile> mo1102n() {
        return null;
    }

    public FaceBoxStub(Parcel parcel) {
        this.f12778a = (RectF) parcel.readParcelable(null);
        this.f12779b = new PointF();
        this.f12779b.x = parcel.readFloat();
        this.f12779b.y = parcel.readFloat();
        this.f12780c = new PointF();
        this.f12780c.x = parcel.readFloat();
        this.f12780c.y = parcel.readFloat();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12778a, i);
        parcel.writeFloat(this.f12779b.x);
        parcel.writeFloat(this.f12779b.y);
        parcel.writeFloat(this.f12780c.x);
        parcel.writeFloat(this.f12780c.y);
    }

    public int describeContents() {
        return 0;
    }
}

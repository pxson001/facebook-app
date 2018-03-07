package com.facebook.photos.base.tagging;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: info_incorrect */
public class TagPoint implements TagTarget {
    public static final Creator<TagPoint> CREATOR = new C08141();
    public PointF f12795a;
    public RectF f12796b;
    public List<TaggingProfile> f12797c;

    /* compiled from: info_incorrect */
    final class C08141 implements Creator<TagPoint> {
        C08141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new TagPoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new TagPoint[i];
        }
    }

    public TagPoint(PointF pointF, @Nullable List<TaggingProfile> list) {
        this.f12795a = (PointF) Preconditions.checkNotNull(pointF);
        this.f12796b = new RectF(pointF.x, pointF.y, pointF.x, pointF.y);
        this.f12797c = list;
    }

    public final RectF mo1099d() {
        return this.f12796b;
    }

    public final PointF mo1100e() {
        return this.f12795a;
    }

    public final PointF mo1101f() {
        return this.f12795a;
    }

    public final List<TaggingProfile> mo1102n() {
        return this.f12797c;
    }

    public TagPoint(Parcel parcel) {
        this.f12796b = new RectF();
        RectF rectF = this.f12796b;
        rectF.left = parcel.readFloat();
        rectF.top = parcel.readFloat();
        rectF.right = parcel.readFloat();
        rectF.bottom = parcel.readFloat();
        this.f12795a = new PointF();
        PointF pointF = this.f12795a;
        pointF.x = parcel.readFloat();
        pointF.y = parcel.readFloat();
        this.f12797c = Lists.a();
        if (parcel.readInt() == 1) {
            this.f12797c = null;
        } else {
            parcel.readList(this.f12797c, TaggingProfile.class.getClassLoader());
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        RectF rectF = this.f12796b;
        parcel.writeFloat(rectF.left);
        parcel.writeFloat(rectF.top);
        parcel.writeFloat(rectF.right);
        parcel.writeFloat(rectF.bottom);
        PointF pointF = this.f12795a;
        parcel.writeFloat(pointF.x);
        parcel.writeFloat(pointF.y);
        if (this.f12797c != null) {
            parcel.writeInt(0);
            parcel.writeList(this.f12797c);
            return;
        }
        parcel.writeInt(1);
    }

    public int describeContents() {
        return 0;
    }
}

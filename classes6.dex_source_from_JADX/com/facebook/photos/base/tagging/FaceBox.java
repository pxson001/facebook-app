package com.facebook.photos.base.tagging;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: initial_facecast_info */
public class FaceBox implements TagTarget, PhotoOverlayItem {
    public static final Creator<FaceBox> CREATOR = new C08111();
    public String f12765a;
    public RectF f12766b;
    private RectF f12767c;
    private PointF f12768d;
    private PointF f12769e;
    public boolean f12770f;
    private Map<FaceBoxTarget, PointF> f12771g;
    private boolean f12772h;
    private boolean f12773i;
    @Nullable
    public byte[] f12774j;
    private int f12775k;
    private int f12776l;
    private List<TaggingProfile> f12777m;

    /* compiled from: initial_facecast_info */
    final class C08111 implements Creator<FaceBox> {
        C08111() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FaceBox(parcel);
        }

        public final Object[] newArray(int i) {
            return new FaceBox[i];
        }
    }

    /* compiled from: initial_facecast_info */
    public enum FaceBoxTarget {
        BOTTOM,
        TOP,
        LEFT,
        RIGHT,
        BOTTOMLEFT,
        BOTTOMRIGHT,
        TOPLEFT,
        TOPRIGHT
    }

    public final boolean m20156a(long j) {
        if (m20169o() && !this.f12770f) {
            if (m20170p()) {
                if (((TaggingProfile) this.f12777m.get(0)).f17539b == j) {
                    return true;
                }
            } else if (!this.f12772h) {
                int min = Math.min(0, this.f12777m.size());
                for (int i = 0; i < min; i++) {
                    if (((TaggingProfile) this.f12777m.get(i)).f17539b == j) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final RectF mo221a() {
        return this.f12767c;
    }

    public final PointF mo223b() {
        return this.f12768d;
    }

    public final float mo224c() {
        return 0.0f;
    }

    public final PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f) {
        return new FaceBox(rectF, this.f12777m, this.f12770f, this.f12773i, this.f12772h);
    }

    public FaceBox(RectF rectF) {
        this(rectF, null, false, true);
    }

    public FaceBox(RectF rectF, List<TaggingProfile> list, boolean z) {
        this(rectF, list, z, true);
    }

    public FaceBox(RectF rectF, @Nullable List<TaggingProfile> list, boolean z, boolean z2) {
        this(rectF, list, z, z2, false);
    }

    private FaceBox(RectF rectF, @Nullable List<TaggingProfile> list, boolean z, boolean z2, boolean z3) {
        this.f12773i = z2;
        this.f12765a = SafeUUIDGenerator.a().toString();
        m20148a(rectF, z2);
        this.f12770f = z;
        m20150a((List) list, z3);
        m20154a(-1, -1);
    }

    public final RectF mo1099d() {
        return this.f12767c;
    }

    public final PointF mo1100e() {
        return this.f12768d;
    }

    public final PointF mo1101f() {
        return this.f12769e;
    }

    private void m20148a(RectF rectF, boolean z) {
        RectF rectF2;
        this.f12766b = (RectF) Preconditions.checkNotNull(rectF);
        if (z) {
            RectF rectF3 = new RectF(this.f12766b);
            Matrix matrix = new Matrix();
            matrix.setTranslate(0.0f, rectF3.height() * -0.1f);
            matrix.mapRect(rectF3);
            matrix = new Matrix();
            matrix.setScale(1.25f, 1.25f, rectF3.centerX(), rectF3.centerY());
            matrix.mapRect(rectF3);
            rectF2 = rectF3;
        } else {
            rectF2 = this.f12766b;
        }
        this.f12767c = rectF2;
        this.f12768d = new PointF(this.f12767c.centerX(), this.f12767c.bottom);
        this.f12769e = new PointF(this.f12767c.centerX(), this.f12767c.centerY());
        this.f12771g = Maps.a(FaceBoxTarget.class);
        this.f12771g.put(FaceBoxTarget.BOTTOM, new PointF(this.f12767c.centerX(), this.f12767c.bottom));
        this.f12771g.put(FaceBoxTarget.TOP, new PointF(this.f12767c.centerX(), this.f12767c.top));
        this.f12771g.put(FaceBoxTarget.LEFT, new PointF(this.f12767c.left, this.f12767c.centerY()));
        this.f12771g.put(FaceBoxTarget.RIGHT, new PointF(this.f12767c.right, this.f12767c.centerY()));
        this.f12771g.put(FaceBoxTarget.BOTTOMLEFT, new PointF(this.f12767c.left, this.f12767c.bottom));
        this.f12771g.put(FaceBoxTarget.BOTTOMRIGHT, new PointF(this.f12767c.right, this.f12767c.bottom));
        this.f12771g.put(FaceBoxTarget.TOPLEFT, new PointF(this.f12767c.left, this.f12767c.top));
        this.f12771g.put(FaceBoxTarget.TOPRIGHT, new PointF(this.f12767c.right, this.f12767c.top));
    }

    public final Map<FaceBoxTarget, PointF> m20163i() {
        return ImmutableMap.copyOf(this.f12771g);
    }

    public final void m20154a(int i, int i2) {
        this.f12775k = i;
        this.f12776l = i2;
    }

    @Nullable
    public final byte[] m20164j() {
        return this.f12774j;
    }

    public final int m20165k() {
        return this.f12775k;
    }

    public final int m20166l() {
        return this.f12776l;
    }

    public final boolean m20167m() {
        return this.f12770f;
    }

    public final List<TaggingProfile> mo1102n() {
        return this.f12777m;
    }

    private void m20150a(@Nullable List<TaggingProfile> list, boolean z) {
        this.f12777m = list;
        this.f12772h = z;
    }

    public final void m20155a(List<TaggingProfile> list) {
        m20150a((List) list, true);
    }

    public final void m20158b(List<TaggingProfile> list) {
        m20150a((List) list, false);
    }

    public final boolean m20169o() {
        return this.f12777m != null;
    }

    public final boolean m20170p() {
        return m20169o() && mo1102n().size() == 1;
    }

    private static void m20149a(Parcel parcel, RectF rectF) {
        parcel.writeFloat(rectF.left);
        parcel.writeFloat(rectF.top);
        parcel.writeFloat(rectF.right);
        parcel.writeFloat(rectF.bottom);
    }

    private static void m20151b(Parcel parcel, RectF rectF) {
        rectF.left = parcel.readFloat();
        rectF.top = parcel.readFloat();
        rectF.right = parcel.readFloat();
        rectF.bottom = parcel.readFloat();
    }

    public FaceBox(Parcel parcel) {
        int i;
        int i2 = 0;
        this.f12765a = parcel.readString();
        this.f12772h = ParcelUtil.a(parcel);
        this.f12766b = new RectF();
        m20151b(parcel, this.f12766b);
        this.f12767c = new RectF();
        m20151b(parcel, this.f12767c);
        this.f12768d = new PointF();
        this.f12768d.x = parcel.readFloat();
        this.f12768d.y = parcel.readFloat();
        this.f12769e = new PointF();
        this.f12769e.x = parcel.readFloat();
        this.f12769e.y = parcel.readFloat();
        this.f12770f = ParcelUtil.a(parcel);
        this.f12773i = ParcelUtil.a(parcel);
        int readInt = parcel.readInt();
        if (readInt != -1) {
            this.f12774j = new byte[readInt];
            parcel.readByteArray(this.f12774j);
        }
        this.f12775k = parcel.readInt();
        this.f12776l = parcel.readInt();
        this.f12777m = Lists.a();
        int readInt2 = parcel.readInt();
        if (readInt2 != 0) {
            for (i = 0; i < readInt2; i++) {
                this.f12777m.add((TaggingProfile) parcel.readParcelable(TaggingProfile.class.getClassLoader()));
            }
        } else {
            this.f12777m = null;
        }
        this.f12771g = Maps.a(FaceBoxTarget.class);
        i = parcel.readInt();
        while (i2 < i) {
            this.f12771g.put((FaceBoxTarget) parcel.readSerializable(), new PointF(parcel.readFloat(), parcel.readFloat()));
            i2++;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12765a);
        ParcelUtil.a(parcel, this.f12772h);
        m20149a(parcel, this.f12766b);
        m20149a(parcel, this.f12767c);
        parcel.writeFloat(this.f12768d.x);
        parcel.writeFloat(this.f12768d.y);
        parcel.writeFloat(this.f12769e.x);
        parcel.writeFloat(this.f12769e.y);
        ParcelUtil.a(parcel, this.f12770f);
        ParcelUtil.a(parcel, this.f12773i);
        if (this.f12774j == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.f12774j.length);
            parcel.writeByteArray(this.f12774j);
        }
        parcel.writeInt(this.f12775k);
        parcel.writeInt(this.f12776l);
        if (this.f12777m != null) {
            parcel.writeInt(this.f12777m.size());
            for (int i2 = 0; i2 < this.f12777m.size(); i2++) {
                parcel.writeParcelable((Parcelable) this.f12777m.get(i2), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f12771g.size());
        for (FaceBoxTarget faceBoxTarget : this.f12771g.keySet()) {
            parcel.writeSerializable(faceBoxTarget);
            parcel.writeFloat(((PointF) this.f12771g.get(faceBoxTarget)).x);
            parcel.writeFloat(((PointF) this.f12771g.get(faceBoxTarget)).y);
        }
    }

    public int describeContents() {
        return 0;
    }
}

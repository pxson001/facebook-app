package com.facebook.photos.base.tagging;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.debug.log.BLog;
import com.facebook.photos.base.tagging.FaceBox.FaceBoxTarget;
import com.facebook.photos.base.tagging.compat.FacebookPhotoTagBase;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.user.model.Name;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: initStageII */
public class Tag extends FacebookPhotoTagBase implements Parcelable, PhotoOverlayItem {
    public static final Creator<Tag> CREATOR = new C08131();
    public TagTarget f12786a;
    public Name f12787b;
    public long f12788c;
    public boolean f12789d;
    public boolean f12790e;
    public Type f12791f;
    public Map<FaceBoxTarget, PointF> f12792g;
    public long f12793h;
    public String f12794i;

    /* compiled from: initStageII */
    final class C08131 implements Creator<Tag> {
        C08131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Tag(parcel);
        }

        public final Object[] newArray(int i) {
            return new Tag[i];
        }
    }

    public Tag(TagTarget tagTarget, Name name, long j, Type type) {
        this(tagTarget, name, j, false, type);
    }

    public Tag(TagTarget tagTarget, Name name, long j, Type type, boolean z) {
        this(tagTarget, name, j, false, type, z);
    }

    public Tag(TagTarget tagTarget, Name name, long j, boolean z, Type type) {
        this(tagTarget, name, j, z, type, false);
    }

    public Tag(TagTarget tagTarget, Name name, long j, boolean z, Type type, boolean z2) {
        this.f12786a = tagTarget;
        this.f12787b = (Name) Preconditions.checkNotNull(name);
        this.f12788c = j;
        this.f12789d = z;
        this.f12790e = z2;
        this.f12791f = type;
        this.f12792g = Maps.a(FaceBoxTarget.class);
    }

    public final PhotoOverlayItem mo222a(RectF rectF, PointF pointF, float f) {
        TagTarget tagPoint;
        if (this.f12786a instanceof TagPoint) {
            tagPoint = new TagPoint(new PointF(pointF.x, pointF.y), this.f12786a.mo1102n());
        } else if (this.f12786a instanceof FaceBox) {
            tagPoint = new FaceBox(rectF, this.f12786a.mo1102n(), ((FaceBox) this.f12786a).f12770f);
        } else {
            tagPoint = new FaceBoxStub(rectF);
        }
        return new Tag(tagPoint, this.f12787b, this.f12788c, this.f12791f);
    }

    public final TagTarget m20185d() {
        return this.f12786a;
    }

    public final void m20182a(Map<FaceBoxTarget, PointF> map) {
        this.f12792g.putAll(map);
    }

    public final long m20186e() {
        return this.f12793h;
    }

    public final void m20181a(long j) {
        this.f12793h = j;
    }

    @Nullable
    public final Name m20187f() {
        return this.f12787b;
    }

    public final long m20188h() {
        return this.f12788c;
    }

    public final Type m20189i() {
        return this.f12791f;
    }

    public final boolean m20190j() {
        return this.f12791f == Type.TEXT;
    }

    public final Boolean m20191k() {
        return Boolean.valueOf(this.f12789d);
    }

    public final boolean m20192l() {
        return this.f12790e;
    }

    public Tag(Parcel parcel) {
        this.f12786a = (TagTarget) parcel.readParcelable(TagTarget.class.getClassLoader());
        this.f12787b = (Name) parcel.readParcelable(Name.class.getClassLoader());
        this.f12788c = parcel.readLong();
        this.f12791f = Type.values()[parcel.readInt()];
        this.f12790e = ParcelUtil.a(parcel);
        this.f12789d = ParcelUtil.a(parcel);
        this.f12792g = Maps.a(FaceBoxTarget.class);
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f12792g.put((FaceBoxTarget) parcel.readSerializable(), new PointF(parcel.readFloat(), parcel.readFloat()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12786a, i);
        parcel.writeParcelable(this.f12787b, i);
        parcel.writeLong(this.f12788c);
        parcel.writeInt(this.f12791f.ordinal());
        ParcelUtil.a(parcel, this.f12790e);
        ParcelUtil.a(parcel, this.f12789d);
        parcel.writeInt(this.f12792g.size());
        for (FaceBoxTarget faceBoxTarget : this.f12792g.keySet()) {
            parcel.writeSerializable(faceBoxTarget);
            parcel.writeFloat(((PointF) this.f12792g.get(faceBoxTarget)).x);
            parcel.writeFloat(((PointF) this.f12792g.get(faceBoxTarget)).y);
        }
    }

    public int describeContents() {
        return 0;
    }

    public final RectF mo221a() {
        return this.f12786a.mo1099d();
    }

    public final PointF mo223b() {
        return this.f12786a.mo1100e();
    }

    public final float mo224c() {
        return 0.0f;
    }

    public final JSONObject mo1103m() {
        boolean z = ((double) this.f12786a.mo1101f().x) <= 1.0d && ((double) this.f12786a.mo1101f().y) <= 1.0d;
        Preconditions.checkArgument(z);
        try {
            JSONObject put = new JSONObject().put("x", (double) (this.f12786a.mo1101f().x * 100.0f)).put("y", (double) (this.f12786a.mo1101f().y * 100.0f));
            if (m20188h() > 0) {
                put.put("tag_uid", m20188h());
                return put;
            }
            put.put("tag_text", this.f12787b.g());
            return put;
        } catch (Throwable e) {
            BLog.b("", "inconceivable JSON exception", e);
            return null;
        }
    }
}

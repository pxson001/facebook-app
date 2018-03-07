package com.facebook.feed.collage;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.facebook.common.util.SizeUtil;
import com.facebook.dialtone.DialtoneController;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLVect2;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: object_details */
public class CollageLayoutCalculator<T extends CollageItem> {
    public final Context f6296a;
    public final CollageLayoutProperties<T> f6297b;
    public int f6298c = SizeUtil.a(this.f6296a, (float) this.f6297b.mo558b());
    public int f6299d = this.f6297b.mo560c();
    public int f6300e;
    public Rect[] f6301f;
    public PointF[] f6302g;

    @Inject
    public CollageLayoutCalculator(Context context, @Assisted CollageLayoutProperties<T> collageLayoutProperties, DialtoneController dialtoneController) {
        this.f6296a = context;
        this.f6297b = collageLayoutProperties;
        int size = this.f6297b.mo557a().size();
        this.f6301f = new Rect[size];
        this.f6302g = new PointF[size];
        for (int i = 0; i < size; i++) {
            PointF pointF;
            CollageItem collageItem = (CollageItem) this.f6297b.mo557a().get(i);
            GraphQLMedia b = collageItem.mo564b();
            int a = this.f6297b.mo556a(collageItem);
            int b2 = this.f6297b.mo559b(collageItem);
            int c = this.f6297b.mo561c(collageItem);
            int d = this.f6297b.mo562d(collageItem);
            this.f6301f[i] = new Rect(a, b2, c + a, b2 + d);
            this.f6300e = Math.max(this.f6300e, d + b2);
            GraphQLVect2 J = b != null ? b.J() : null;
            PointF[] pointFArr = this.f6302g;
            if (J != null) {
                pointF = new PointF((float) J.a(), (float) J.b());
            } else {
                pointF = new PointF(0.5f, 0.5f);
            }
            pointFArr[i] = pointF;
        }
    }

    public final ImmutableList<T> m6775a() {
        return this.f6297b.mo557a();
    }

    public final int m6773a(int i) {
        return (((i - (this.f6298c * 2)) / this.f6299d) * this.f6300e) + (this.f6298c * 2);
    }

    public final int m6774a(int i, int i2) {
        if (this.f6301f[i].left == 0) {
            return 0;
        }
        return i2;
    }

    public final int m6776b(int i, int i2) {
        if (this.f6301f[i].left + this.f6301f[i].width() == this.f6299d) {
            return 0;
        }
        return i2;
    }

    public final int m6777c(int i, int i2) {
        if (this.f6301f[i].bottom == this.f6300e) {
            return 0;
        }
        return i2;
    }
}

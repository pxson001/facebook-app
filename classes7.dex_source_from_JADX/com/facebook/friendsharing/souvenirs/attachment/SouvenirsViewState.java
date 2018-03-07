package com.facebook.friendsharing.souvenirs.attachment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.ArrayDrawable;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.RoundedCornersDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirUriItem;
import com.facebook.friendsharing.souvenirs.util.SouvenirLocalImageRequest;
import com.facebook.friendsharing.souvenirs.util.SouvenirModelHelper;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Remove feed-inject.json file */
public class SouvenirsViewState {
    public final SouvenirModel f24025a;
    public final OnClickListener f24026b;
    public final DraweeController[] f24027c;
    public final MultiDraweeHolder f24028d;
    public final ImmutableList<SouvenirUriItem> f24029e;
    private final FbDraweeControllerBuilder f24030f;
    private final SouvenirLocalImageRequest f24031g;
    public FadeDrawable f24032h;
    public Drawable f24033i;

    @Inject
    public SouvenirsViewState(@Assisted SouvenirModel souvenirModel, @Assisted OnClickListener onClickListener, FbDraweeControllerBuilder fbDraweeControllerBuilder, SouvenirLocalImageRequest souvenirLocalImageRequest) {
        Iterator b;
        this.f24025a = souvenirModel;
        this.f24026b = onClickListener;
        this.f24030f = fbDraweeControllerBuilder;
        this.f24031g = souvenirLocalImageRequest;
        if (Iterators.b(SouvenirModelHelper.m26457b(souvenirModel)) > 0) {
            b = SouvenirModelHelper.m26457b(souvenirModel);
        } else {
            b = Iterators.b(SouvenirModelHelper.m26454a(souvenirModel), SouvenirModelHelper.f24216b);
        }
        this.f24029e = ImmutableList.copyOf(Iterators.c(b, 5));
        this.f24027c = new DraweeController[m26123b()];
        this.f24028d = new MultiDraweeHolder();
    }

    public final int m26123b() {
        return Math.min(this.f24029e.size(), 5);
    }

    public final void m26122a(Context context, boolean z, @Nullable AnyEnvironment anyEnvironment) {
        Preconditions.checkState(this.f24028d.d() == 0);
        int b = m26123b();
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                PointF a = ((SouvenirUriItem) this.f24029e.get(i)).b().mFocusPoint.a();
                GenericDraweeHierarchyBuilder e = new GenericDraweeHierarchyBuilder(context.getResources()).e(ScaleType.h);
                e.p = a;
                this.f24028d.a(new DraweeHolder(e.u()));
                m26121a(i, i);
            }
            Drawable[] drawableArr = new Drawable[this.f24028d.d()];
            for (int i2 = 0; i2 < this.f24028d.d(); i2++) {
                DraweeHolder b2 = this.f24028d.b(i2);
                drawableArr[i2] = b2.h();
                b2.a(this.f24027c[i2]);
            }
            this.f24032h = new FadeDrawable(drawableArr);
            this.f24032h.c(500);
            int[] iArr = new int[]{Color.argb(192, 0, 0, 0), 0, 0};
            ArrayDrawable arrayDrawable = new ArrayDrawable(new Drawable[]{this.f24032h, new GradientDrawable(Orientation.BOTTOM_TOP, iArr)});
            if (z) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(arrayDrawable);
                roundedCornersDrawable.a((float) context.getResources().getDimensionPixelSize(2131432497));
                roundedCornersDrawable.a(-1);
                this.f24033i = roundedCornersDrawable;
                return;
            }
            this.f24033i = arrayDrawable;
        }
    }

    public final void m26121a(int i, int i2) {
        SouvenirUriItem souvenirUriItem = (SouvenirUriItem) this.f24029e.get(i);
        this.f24030f.a(CallerContext.a(getClass()));
        FbDraweeControllerBuilder fbDraweeControllerBuilder = this.f24030f;
        SouvenirLocalImageRequest souvenirLocalImageRequest = this.f24031g;
        ImageRequestBuilder a = ImageRequestBuilder.a(souvenirUriItem.b().mUri);
        a.c = true;
        a = a;
        a.d = new ResizeOptions(souvenirLocalImageRequest.f24213a / 2, souvenirLocalImageRequest.f24214b / 2);
        a = a;
        a.h = true;
        fbDraweeControllerBuilder.c(a.m());
        this.f24027c[i2] = this.f24030f.s();
        this.f24030f.p();
    }
}

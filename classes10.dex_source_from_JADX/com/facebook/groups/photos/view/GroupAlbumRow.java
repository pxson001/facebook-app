package com.facebook.groups.photos.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: TL onNewResult */
public class GroupAlbumRow extends CustomLinearLayout {
    public static final CallerContext f23093e = CallerContext.a(GroupAlbumRow.class, "group_photos");
    @Inject
    public Resources f23094a;
    public final Paint f23095b = new Paint(1);
    public float f23096c;
    public float f23097d;
    public ImmutableList<FbDraweeView> f23098f;
    public FbDraweeView f23099g;

    public static void m24417a(Object obj, Context context) {
        ((GroupAlbumRow) obj).f23094a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public GroupAlbumRow(Context context) {
        super(context);
        Class cls = GroupAlbumRow.class;
        m24417a(this, getContext());
        setOrientation(0);
        setContentView(2130904638);
        LayoutInflater from = LayoutInflater.from(getContext());
        GridLayout gridLayout = (GridLayout) findViewById(2131562619);
        Builder builder = new Builder();
        for (int i = 0; i < 4; i++) {
            FbDraweeView fbDraweeView = (FbDraweeView) from.inflate(2130904636, gridLayout, false);
            builder.c(fbDraweeView);
            gridLayout.addView(fbDraweeView);
        }
        this.f23098f = builder.b();
        this.f23099g = (FbDraweeView) findViewById(2131562620);
        this.f23095b.setColor(this.f23094a.getColor(2131363505));
        this.f23095b.setStyle(Style.FILL);
        this.f23096c = this.f23094a.getDimension(2131431925);
        this.f23097d = this.f23094a.getDimension(2131431927);
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawRect(this.f23096c, ((float) getHeight()) - this.f23097d, ((float) getWidth()) - this.f23096c, (float) getHeight(), this.f23095b);
    }
}

package com.facebook.goodwill.composer.photofragment;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.facebook.attachments.photos.GraphQLImageChooser;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;

/* compiled from: {a_place_for_theme} */
public class GoodwillPhotoView extends FbRelativeLayout {
    private static final CallerContext f115a = CallerContext.a(FbDraweeView.class, "goodwill_composer");
    public FbDraweeView f116b;
    public ImageView f117c;
    public PhotoFromFbOrCameraFragment f118d;
    public GoodwillPhoto f119e;
    public final Point f120f = new Point(0, 0);
    public Uri f121g;
    public GraphQLImageChooser f122h;
    public BitmapUtils f123i;
    public FbDraweeControllerBuilder f124j;

    /* compiled from: {a_place_for_theme} */
    public class C00121 implements OnClickListener {
        final /* synthetic */ GoodwillPhotoView f112a;

        public C00121(GoodwillPhotoView goodwillPhotoView) {
            this.f112a = goodwillPhotoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 112488003);
            if (this.f112a.f118d != null) {
                this.f112a.f118d.m154a(this.f112a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1723542615, a);
        }
    }

    /* compiled from: {a_place_for_theme} */
    public class C00132 implements OnLongClickListener {
        final /* synthetic */ GoodwillPhotoView f113a;

        public C00132(GoodwillPhotoView goodwillPhotoView) {
            this.f113a = goodwillPhotoView;
        }

        public boolean onLongClick(View view) {
            if (this.f113a.f118d != null) {
                this.f113a.f118d.m155a(this.f113a, this.f113a.f120f);
            }
            return true;
        }
    }

    /* compiled from: {a_place_for_theme} */
    public class C00143 implements OnTouchListener {
        final /* synthetic */ GoodwillPhotoView f114a;

        public C00143(GoodwillPhotoView goodwillPhotoView) {
            this.f114a = goodwillPhotoView;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f114a.f120f.set(((int) motionEvent.getX()) + this.f114a.getLeft(), ((int) motionEvent.getY()) + this.f114a.getTop());
            return false;
        }
    }

    public static void m143a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GoodwillPhotoView goodwillPhotoView = (GoodwillPhotoView) obj;
        GraphQLImageChooser a = GraphQLImageChooser.a(fbInjector);
        BitmapUtils a2 = BitmapUtils.a(fbInjector);
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        goodwillPhotoView.f122h = a;
        goodwillPhotoView.f123i = a2;
        goodwillPhotoView.f124j = b;
    }

    public GoodwillPhotoView(Context context) {
        super(context);
        Class cls = GoodwillPhotoView.class;
        m143a(this, getContext());
        LayoutInflater.from(getContext()).inflate(2130904619, this);
        this.f116b = (FbDraweeView) findViewById(2131562591);
        this.f117c = (ImageView) findViewById(2131562592);
        this.f117c.setOnClickListener(new C00121(this));
        this.f116b.setOnLongClickListener(new C00132(this));
        this.f116b.setOnTouchListener(new C00143(this));
    }

    public void setPhoto(GoodwillPhoto goodwillPhoto) {
        Uri uri = null;
        this.f119e = goodwillPhoto;
        getResources().getDimension(2131432822);
        int dimensionPixelSize = getResources().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(2131432822) * 2);
        float f = 0.0f;
        float f2;
        if (goodwillPhoto.f69b != null) {
            uri = goodwillPhoto.f69b.f();
            Dimension a = BitmapUtils.a(uri.getPath());
            int i = a.b;
            int i2 = a.a;
            int b = BitmapUtils.b(uri.getPath());
            if (i2 > 0) {
                f2 = ((float) i) / ((float) i2);
            } else {
                f2 = 1.0f;
            }
            if (b == 90 || b == 270) {
                f2 = 1.0f / f2;
            }
            f = f2;
        } else if (goodwillPhoto.f70c != null) {
            GraphQLImage a2 = GraphQLImageChooser.a(goodwillPhoto.f70c, dimensionPixelSize);
            if (a2 != null) {
                uri = ImageUtil.a(a2);
                f2 = GraphQLHelper.a(a2);
                if (f2 <= 0.0f && a2.a() > 0) {
                    f2 = ((float) a2.c()) / ((float) a2.a());
                }
                if (f2 <= 0.0f) {
                    f2 = 1.0f;
                }
                f = f2;
            }
        }
        if (uri != null) {
            this.f121g = uri;
            this.f116b.getLayoutParams().height = Math.round(((float) dimensionPixelSize) / f);
            this.f116b.getLayoutParams().width = dimensionPixelSize;
            this.f116b.setController(this.f124j.b(this.f121g).a(f115a).s());
        }
    }

    public Rect getPhotoRect() {
        int left = getLeft() + this.f116b.getLeft();
        int top = getTop() + this.f116b.getTop();
        return new Rect(left, top, this.f116b.getWidth() + left, this.f116b.getHeight() + top);
    }
}

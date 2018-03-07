package com.facebook.photos.albums;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.i18n.RTLUtil;
import com.facebook.dialtone.DialtoneController.FeatureType;
import com.facebook.drawee.fbpipeline.DegradableDraweeController;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.MultiDraweeHolder;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: manage */
public class AlbumsRowView extends CustomViewGroup {
    private static final CallerContext f9342a = CallerContext.a(AlbumsRowView.class, "photos_albums_view");
    private double f9343b = -1.0d;
    private double f9344c = -1.0d;
    private double f9345d = -1.0d;
    private int f9346e = -1;
    private int f9347f = -1;
    private GraphQLAlbum f9348g;
    private GraphQLAlbum f9349h;
    private boolean f9350i;
    private Provider<FbDraweeControllerBuilder> f9351j;
    private RTLUtil f9352k;
    private final MultiDraweeHolder<GenericDraweeHierarchy> f9353l = new MultiDraweeHolder();

    /* compiled from: manage */
    enum CoverPhoto {
        LEFT,
        RIGHT
    }

    private static <T extends View> void m11342a(Class<T> cls, T t) {
        m11343a((Object) t, t.getContext());
    }

    private static void m11343a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AlbumsRowView) obj).m11344a(IdBasedProvider.a(fbInjector, 1117), RTLUtil.a(fbInjector));
    }

    public AlbumsRowView(Context context) {
        super(context);
        m11345b();
    }

    public AlbumsRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11345b();
    }

    public AlbumsRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11345b();
    }

    @Inject
    private void m11344a(Provider<FbDraweeControllerBuilder> provider, RTLUtil rTLUtil) {
        this.f9351j = provider;
        this.f9352k = rTLUtil;
    }

    private void m11345b() {
        m11342a(AlbumsRowView.class, (View) this);
        this.f9343b = (double) getResources().getDisplayMetrics().widthPixels;
        this.f9344c = (double) getResources().getDimensionPixelSize(2131429444);
        setWillNotCacheDrawing(true);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(getResources());
        for (int i = 0; i < 2; i++) {
            genericDraweeHierarchyBuilder.f = new ColorDrawable(getResources().getColor(2131362899));
            genericDraweeHierarchyBuilder.f(getResources().getDrawable(2130837622));
            this.f9353l.a(DraweeHolder.a(genericDraweeHierarchyBuilder.u(), getContext()));
        }
        forceLayout();
    }

    public final void m11350a(GraphQLAlbum graphQLAlbum, GraphQLAlbum graphQLAlbum2, boolean z, int i, int i2) {
        m11349a();
        this.f9348g = graphQLAlbum;
        this.f9349h = graphQLAlbum2;
        this.f9347f = i2;
        this.f9346e = i;
        if (this.f9346e != 0) {
            this.f9344c = (double) this.f9346e;
        }
        if (this.f9347f == 0) {
            this.f9347f = this.f9346e;
        }
        this.f9345d = this.f9346e == 0 ? (this.f9343b - this.f9344c) / 2.0d : ((this.f9343b - ((double) (this.f9346e * 2))) - this.f9344c) / 2.0d;
        this.f9350i = z;
        m11346c();
    }

    private void m11346c() {
        m11341a(this.f9348g, CoverPhoto.LEFT);
        m11341a(this.f9349h, CoverPhoto.RIGHT);
    }

    private void m11341a(GraphQLAlbum graphQLAlbum, CoverPhoto coverPhoto) {
        DraweeController draweeController;
        Drawable colorDrawable;
        DraweeHolder b = this.f9353l.b(coverPhoto == CoverPhoto.LEFT ? 0 : 1);
        if (graphQLAlbum == null) {
            draweeController = null;
            colorDrawable = new ColorDrawable(getResources().getColor(2131361864));
        } else if (graphQLAlbum.j() == null || graphQLAlbum.j().af() == null || graphQLAlbum.j().af().b() == null) {
            draweeController = null;
            colorDrawable = getResources().getDrawable(2130839460);
        } else {
            Uri a = ImageUtil.a(graphQLAlbum.j().af());
            Drawable colorDrawable2 = new ColorDrawable(getResources().getColor(2131362899));
            FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f9351j.get()).a(f9342a).b(b.f)).b(a).s();
            if (s instanceof DegradableDraweeController) {
                ((DegradableDraweeController) s).a(0, FeatureType.ALBUM);
            }
            Drawable drawable = colorDrawable2;
            draweeController = s;
            colorDrawable = drawable;
        }
        ((GenericDraweeHierarchy) b.f()).b(colorDrawable);
        b.a(draweeController);
        Drawable h = b.h();
        Rect a2 = m11340a(coverPhoto);
        if (graphQLAlbum == null) {
            h.setVisible(false, true);
            h.setBounds(0, 0, 0, 0);
        } else {
            h.setVisible(this.f9350i, true);
            h.setBounds(a2.left, a2.top, a2.right, a2.bottom);
        }
        h.setCallback(this);
    }

    protected void dispatchDraw(Canvas canvas) {
        MultiDraweeHolder multiDraweeHolder = this.f9353l;
        for (int i = 0; i < multiDraweeHolder.b.size(); i++) {
            Drawable h = multiDraweeHolder.b(i).h();
            if (h != null) {
                h.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    private Rect m11340a(CoverPhoto coverPhoto) {
        if (coverPhoto == (this.f9352k.a() ? CoverPhoto.RIGHT : CoverPhoto.LEFT)) {
            return new Rect(this.f9346e, this.f9347f, (int) (this.f9345d + ((double) this.f9346e)), (int) (this.f9345d + ((double) this.f9347f)));
        }
        return new Rect((int) ((this.f9345d + this.f9344c) + ((double) this.f9346e)), this.f9347f, ((int) this.f9343b) - this.f9346e, ((int) this.f9345d) + this.f9347f);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 7399558);
        super.onAttachedToWindow();
        m11347d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 145543784, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        m11348e();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m11347d();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2118287016);
        super.onDetachedFromWindow();
        m11348e();
        m11349a();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 558576440, a);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return this.f9353l.a(drawable) || super.verifyDrawable(drawable);
    }

    private void m11347d() {
        this.f9353l.a();
    }

    private void m11348e() {
        this.f9353l.b();
    }

    public final void m11349a() {
        m11348e();
        for (int i = 0; i < this.f9353l.d(); i++) {
            this.f9353l.b(i).a(null);
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = (int) (this.f9345d + ((double) this.f9347f));
        if (i3 == View.getDefaultSize(getSuggestedMinimumHeight(), i2)) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), i), i3);
        }
    }
}

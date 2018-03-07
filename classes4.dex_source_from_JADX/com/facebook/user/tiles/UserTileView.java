package com.facebook.user.tiles;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: oxygen_map_disk_cache_read_error */
public class UserTileView extends View {
    @Inject
    public UserTileDrawableController f5678a;
    protected boolean f5679b;

    private static <T extends View> void m6171a(Class<T> cls, T t) {
        m6172a((Object) t, t.getContext());
    }

    private static void m6172a(Object obj, Context context) {
        ((UserTileView) obj).f5678a = UserTileDrawableController.m6177b(FbInjector.get(context));
    }

    public UserTileView(Context context) {
        super(context);
        m6169a(null, 0);
    }

    public UserTileView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6169a(attributeSet, 0);
    }

    public UserTileView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6169a(attributeSet, i);
    }

    private void m6169a(AttributeSet attributeSet, int i) {
        m6171a(UserTileView.class, (View) this);
        this.f5678a.m6185a(getContext(), attributeSet, i);
        this.f5678a.f5694m.setCallback(this);
    }

    private void m6170a(UserTileDrawableController userTileDrawableController) {
        this.f5678a = userTileDrawableController;
    }

    public void setParams(UserTileViewParams userTileViewParams) {
        this.f5678a.m6187a(userTileViewParams);
    }

    public void setTileSizePx(int i) {
        this.f5678a.m6183a(i);
    }

    public void setOnUserTileUpdatedListener(OnUserTileUpdatedListener onUserTileUpdatedListener) {
        this.f5678a.f5683A = onUserTileUpdatedListener;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1191906781);
        super.onAttachedToWindow();
        this.f5678a.m6189c();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2047012735, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -968442284);
        this.f5678a.m6190d();
        super.onDetachedFromWindow();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2096068858, a);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (this.f5678a != null && drawable == this.f5678a.f5694m) || super.verifyDrawable(drawable);
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f5678a.f5694m.jumpToCurrentState();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f5678a.f5694m.setState(getDrawableState());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f5679b = true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m6173a(canvas, this.f5678a.f5694m);
    }

    public Drawable getUserTileDrawable() {
        Drawable drawable = this.f5678a.f5695n;
        Drawable background = getBackground();
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        background.draw(canvas);
        m6173a(canvas, drawable);
        return new BitmapDrawable(getResources(), createBitmap);
    }

    protected void m6173a(Canvas canvas, Drawable drawable) {
        if (this.f5679b) {
            this.f5678a.m6184a(getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
            this.f5679b = false;
        }
        drawable.draw(canvas);
    }

    public void setUseInbox2AlternateBadges(boolean z) {
        this.f5678a.f5696o.f5715g = z;
        invalidate();
    }
}

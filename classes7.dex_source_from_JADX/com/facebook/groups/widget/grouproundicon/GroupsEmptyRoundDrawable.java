package com.facebook.groups.widget.grouproundicon;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

@Deprecated
/* compiled from: profileId */
public class GroupsEmptyRoundDrawable extends ForwardingDrawable {
    public static final int f5955a = 2130843734;
    public static final int f5956c = 2130843731;
    private final int f5957d;
    private final Resources f5958e;
    private final GroupRoundIconDrawHelper f5959f = new GroupRoundIconDrawHelper();
    public boolean f5960g = true;
    public boolean f5961h = true;
    public int f5962i = -1;

    private static GroupsEmptyRoundDrawable m7605b(InjectorLike injectorLike) {
        return new GroupsEmptyRoundDrawable(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupsEmptyRoundDrawable(Resources resources) {
        super(new ColorDrawable(0));
        this.f5958e = resources;
        this.f5957d = this.f5958e.getDimensionPixelSize(2131431997);
    }

    public void draw(Canvas canvas) {
        if (this.f5960g) {
            int i;
            this.f5960g = false;
            Resources resources = this.f5958e;
            if (this.f5961h) {
                i = f5955a;
            } else {
                i = f5956c;
            }
            b(resources.getDrawable(i).mutate());
        }
        Bitmap bitmap = ((BitmapDrawable) getCurrent()).getBitmap();
        GroupRoundIconDrawHelper groupRoundIconDrawHelper = this.f5959f;
        Rect bounds = getBounds();
        if (bitmap != groupRoundIconDrawHelper.f5951c) {
            groupRoundIconDrawHelper.f5951c = bitmap;
            groupRoundIconDrawHelper.f5952d = new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP);
            groupRoundIconDrawHelper.f5949a.setShader(groupRoundIconDrawHelper.f5952d);
        }
        groupRoundIconDrawHelper.f5950b.reset();
        groupRoundIconDrawHelper.f5950b.setTranslate((float) (bounds.left + ((bounds.width() - bitmap.getWidth()) / 2)), (float) (bounds.top + ((bounds.height() - bitmap.getHeight()) / 2)));
        groupRoundIconDrawHelper.f5952d.setLocalMatrix(groupRoundIconDrawHelper.f5950b);
        canvas.drawCircle((float) bounds.centerX(), (float) bounds.centerY(), ((float) Math.min(bounds.width(), bounds.height())) / 2.0f, groupRoundIconDrawHelper.f5949a);
    }

    protected void onBoundsChange(Rect rect) {
        boolean z;
        super.onBoundsChange(rect);
        int i = this.f5962i;
        if (rect.width() < this.f5957d) {
            z = true;
        } else {
            z = false;
        }
        if (!(i == this.f5962i && z == this.f5961h)) {
            this.f5960g = true;
            invalidateSelf();
        }
        this.f5962i = i;
        this.f5961h = z;
    }
}

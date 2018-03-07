package com.facebook.components.fb.fresco;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.facebook.components.ImageContent;
import com.facebook.components.fresco.NoOpDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.FbDraweeHolder;
import java.util.Collections;
import java.util.List;

/* compiled from: friends_day/share?promotion_id={promotion_id} */
public class FbDraweeDrawable<DH extends DraweeHierarchy> extends ForwardingDrawable implements ImageContent {
    public final Drawable f23025a = new NoOpDrawable();
    public final FbDraweeHolder<DH> f23026c;

    public FbDraweeDrawable(Context context, DH dh) {
        super(null);
        mo2744b(this.f23025a);
        this.f23026c = new FbDraweeHolder(dh);
        this.f23026c.f23030c = true;
    }

    public void draw(Canvas canvas) {
        this.f23026c.m20517a();
        super.draw(canvas);
    }

    public final List<Drawable> hj_() {
        return Collections.singletonList(this);
    }

    public final DH m31157d() {
        return this.f23026c.m20525f();
    }

    public final void m31156a(DraweeController draweeController) {
        this.f23026c.mo3378a(draweeController);
    }
}

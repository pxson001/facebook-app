package com.facebook.feedplugins.calltoaction;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: SwipableImageController not bound */
public class ActionLinkCallToActionView extends ImageBlockLayout {
    public static final ViewType<ActionLinkCallToActionView> f23054h = new C19941();
    @Inject
    public AllCapsTransformationMethod f23055i;
    public LazyView<FbDraweeView> f23056j = new LazyView((ViewStub) getView(2131559193));
    public TextView f23057k = ((TextView) getView(2131559195));
    public boolean f23058l;
    public Paint f23059m;
    public int f23060n;

    /* compiled from: SwipableImageController not bound */
    final class C19941 extends ViewType<ActionLinkCallToActionView> {
        C19941() {
        }

        public final View m25515a(Context context) {
            return new ActionLinkCallToActionView(context);
        }
    }

    public static void m25514a(Object obj, Context context) {
        ((ActionLinkCallToActionView) obj).f23055i = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public ActionLinkCallToActionView(Context context) {
        super(context);
        Class cls = ActionLinkCallToActionView.class;
        m25514a(this, getContext());
        setContentView(2130903078);
        this.f23057k.setTransformationMethod(this.f23055i);
        this.f23059m = new Paint();
        this.f23059m.setColor(getResources().getColor(2131362761));
        this.f23059m.setStrokeWidth(1.0f);
        this.f23060n = getResources().getDimensionPixelSize(2131427380);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f23058l) {
            canvas.drawLine(0.0f, (float) (getHeight() - this.f23060n), (float) getWidth(), (float) (getHeight() - this.f23060n), this.f23059m);
        }
    }
}

package com.facebook.timeline.header.intro;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelper.BordersSpec;
import com.facebook.timeline.header.ui.ViewBorderDrawingHelperProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetch_nearby_friends */
public class LinearLayoutWithTopBorder extends LinearLayout {
    private static final BordersSpec f11830b = new BordersSpec(false, false, true, false);
    @Inject
    public ViewBorderDrawingHelperProvider f11831a;
    private ViewBorderDrawingHelper f11832c;

    private static <T extends View> void m11892a(Class<T> cls, T t) {
        m11893a((Object) t, t.getContext());
    }

    private static void m11893a(Object obj, Context context) {
        ((LinearLayoutWithTopBorder) obj).f11831a = (ViewBorderDrawingHelperProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(ViewBorderDrawingHelperProvider.class);
    }

    public LinearLayoutWithTopBorder(Context context) {
        super(context, null);
        m11890a();
    }

    public LinearLayoutWithTopBorder(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11890a();
    }

    private void m11890a() {
        m11892a(LinearLayoutWithTopBorder.class, (View) this);
        this.f11832c = this.f11831a.m12060a(2131361980, getResources().getDimensionPixelSize(2131427380));
        this.f11832c.m12059a(this, f11830b);
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f11832c.m12058a(this, canvas, f11830b);
    }

    private void m11891a(ViewBorderDrawingHelperProvider viewBorderDrawingHelperProvider) {
        this.f11831a = viewBorderDrawingHelperProvider;
    }
}

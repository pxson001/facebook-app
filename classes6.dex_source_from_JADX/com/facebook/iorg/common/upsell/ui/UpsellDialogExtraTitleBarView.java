package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.picassolike.PicassoLikeViewStub;
import com.facebook.picassolike.fresco.FrescoImpl;
import javax.inject.Inject;

/* compiled from: m1.0 */
public class UpsellDialogExtraTitleBarView extends LinearLayout {
    @Inject
    public FrescoImpl f11365a;
    private View f11366b;

    private static <T extends View> void m18156a(Class<T> cls, T t) {
        m18157a((Object) t, t.getContext());
    }

    private static void m18157a(Object obj, Context context) {
        ((UpsellDialogExtraTitleBarView) obj).f11365a = FrescoImpl.m22172a(FbInjector.get(context));
    }

    public UpsellDialogExtraTitleBarView(Context context) {
        super(context);
        m18155a();
    }

    public UpsellDialogExtraTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18155a();
    }

    private void m18155a() {
        m18156a(UpsellDialogExtraTitleBarView.class, (View) this);
        LayoutInflater.from(getContext()).inflate(2130907618, this);
        this.f11366b = ((PicassoLikeViewStub) findViewById(2131568222)).a();
    }

    public void setTitleImageByUrl(String str) {
        this.f11366b.getLayoutParams().height = (int) getResources().getDimension(2131428363);
        FrescoImpl frescoImpl = this.f11365a;
        getContext();
        frescoImpl.m22174a(this.f11366b, str);
    }

    public void setTitleImageResource(int i) {
        this.f11365a.m22173a(i, this.f11366b);
    }
}

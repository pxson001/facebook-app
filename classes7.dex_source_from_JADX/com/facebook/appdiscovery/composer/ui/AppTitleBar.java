package com.facebook.appdiscovery.composer.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.composer.ui.titlebar.ComposerHarrisonPlusResourceHelper;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.LazyView;
import javax.inject.Inject;

/* compiled from: cta_lead_gen_page_vpv */
public class AppTitleBar extends CustomLinearLayout {
    @Inject
    public LayoutInflater f16451a;
    private LazyView<FbDraweeView> f16452b;
    public LinearLayout f16453c;
    private LazyView<ImageView> f16454d;
    private CustomFrameLayout f16455e;

    private static <T extends View> void m20531a(Class<T> cls, T t) {
        m20532a((Object) t, t.getContext());
    }

    private static void m20532a(Object obj, Context context) {
        ((AppTitleBar) obj).f16451a = LayoutInflaterMethodAutoProvider.b(FbInjector.get(context));
    }

    public AppTitleBar(Context context) {
        super(context);
        m20528a();
    }

    public AppTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20528a();
    }

    private void m20528a() {
        m20531a(AppTitleBar.class, (View) this);
        this.f16451a.inflate(2130903659, this);
        this.f16452b = new LazyView((ViewStub) a(2131562857));
        this.f16454d = new LazyView((ViewStub) a(2131562855));
        this.f16455e = (CustomFrameLayout) a(2131560491);
        this.f16453c = (LinearLayout) a(2131562854);
        m20530a(HarrisonPlusIconType.m2080c());
    }

    private void m20530a(HarrisonPlusIconType harrisonPlusIconType) {
        ComposerHarrisonPlusResourceHelper.m2061a(harrisonPlusIconType, this.f16452b, this.f16454d);
    }

    private void m20529a(LayoutInflater layoutInflater) {
        this.f16451a = layoutInflater;
    }

    public EditText getSearchEditBox() {
        return (EditText) this.f16455e.findViewById(2131560492);
    }

    public View getClearSearchTextButton() {
        return this.f16455e.findViewById(2131560324);
    }

    public View getSecondaryButton() {
        return this.f16453c;
    }
}

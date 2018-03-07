package com.facebook.composer.ui.titlebar;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.common.ui.util.LayoutParamsUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.LazyView;
import com.facebook.widget.text.SimpleVariableTextLayoutView;

@Deprecated
/* compiled from: tapped_like_page */
public class ComposerHarrisonPlusTitleBar extends ComposerBaseTitleBar {
    private LazyView<FbDraweeView> f2085c;
    private LazyView<ImageView> f2086d;

    public ComposerHarrisonPlusTitleBar(Context context) {
        super(context);
        m2063b();
    }

    public ComposerHarrisonPlusTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2063b();
    }

    private void m2063b() {
        this.f2077a.inflate(2130903678, this);
        this.f2085c = new LazyView((ViewStub) a(2131562857));
        this.f2086d = new LazyView((ViewStub) a(2131562855));
    }

    protected SimpleVariableTextLayoutView getTitleTextView() {
        return (SimpleVariableTextLayoutView) a(2131559636);
    }

    protected SimpleVariableTextLayoutView getPrimaryTextButton() {
        return (SimpleVariableTextLayoutView) a(2131562858);
    }

    protected View getSecondaryButton() {
        return a(2131562854);
    }

    protected View getPrimaryButtonDivider() {
        return a(2131559185);
    }

    public final void mo94a(HarrisonPlusIconType harrisonPlusIconType) {
        ComposerHarrisonPlusResourceHelper.m2061a(harrisonPlusIconType, this.f2085c, this.f2086d);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        SimpleVariableTextLayoutView titleTextView = getTitleTextView();
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428150);
        LayoutParamsUtil.b(titleTextView, dimensionPixelSize);
        LayoutParamsUtil.b(this, dimensionPixelSize);
    }
}

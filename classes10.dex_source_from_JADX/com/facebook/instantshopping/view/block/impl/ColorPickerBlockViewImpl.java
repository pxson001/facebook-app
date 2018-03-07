package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.instantshopping.action.InstantShoppingActionUtils;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingActionFragmentModel;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingColorSelectorColorFragmentModel;
import com.facebook.instantshopping.presenter.ColorPickerBlockPresenter;
import com.facebook.instantshopping.utils.SizeUtils;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.block.ColorPickerItemView;
import com.facebook.instantshopping.view.widget.ColorPickerColorItemLayout;
import com.facebook.instantshopping.view.widget.ColorPickerImageItemLayout;
import com.facebook.instantshopping.view.widget.ColorPickerTextItemLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import javax.inject.Inject;

/* compiled from: STATUS_SUBSCRIBED_HIGHLIGHTS */
public class ColorPickerBlockViewImpl extends AbstractBlockView<ColorPickerBlockPresenter> implements ColorPickerBlockView {
    @Inject
    public InstantShoppingActionUtils f23718a;
    @Inject
    public InstantShoppingAnalyticsLogger f23719b;
    @Inject
    public SizeUtils f23720c;
    public final LinearLayout f23721d;
    public OnClickListener f23722e = new C34011(this);
    public ColorPickerItemView f23723f;
    public LoggingParams f23724g;

    /* compiled from: STATUS_SUBSCRIBED_HIGHLIGHTS */
    public class C34011 implements OnClickListener {
        final /* synthetic */ ColorPickerBlockViewImpl f23717a;

        public C34011(ColorPickerBlockViewImpl colorPickerBlockViewImpl) {
            this.f23717a = colorPickerBlockViewImpl;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 319161529);
            if (this.f23717a.f23723f != null) {
                this.f23717a.f23723f.setIsSelected(false);
                if (this.f23717a.f23723f instanceof ColorPickerTextItemLayout) {
                    this.f23717a.f23720c.a = false;
                }
            }
            this.f23717a.f23723f = (ColorPickerItemView) view;
            this.f23717a.f23723f.setIsSelected(true);
            if (this.f23717a.f23723f instanceof ColorPickerTextItemLayout) {
                this.f23717a.f23720c.a = true;
            }
            if (((ColorPickerItemView) view).getAction() != null) {
                this.f23717a.f23718a.m24802a(this.f23717a.getContext(), ((ColorPickerItemView) view).getAction(), this.f23717a.f23724g, null);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -462089, a);
        }
    }

    public static void m25045a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ColorPickerBlockViewImpl colorPickerBlockViewImpl = (ColorPickerBlockViewImpl) obj;
        InstantShoppingActionUtils a = InstantShoppingActionUtils.m24796a(injectorLike);
        InstantShoppingAnalyticsLogger a2 = InstantShoppingAnalyticsLogger.m24853a(injectorLike);
        SizeUtils a3 = SizeUtils.a(injectorLike);
        colorPickerBlockViewImpl.f23718a = a;
        colorPickerBlockViewImpl.f23719b = a2;
        colorPickerBlockViewImpl.f23720c = a3;
    }

    public ColorPickerBlockViewImpl(View view) {
        super(view);
        Class cls = ColorPickerBlockViewImpl.class;
        m25045a(this, getContext());
        this.f23721d = (LinearLayout) view.findViewById(2131563231);
    }

    public final void mo1029a(InstantShoppingColorSelectorColorFragmentModel instantShoppingColorSelectorColorFragmentModel, boolean z, LoggingParams loggingParams) {
        this.f23724g = loggingParams;
        if (instantShoppingColorSelectorColorFragmentModel.c() != null) {
            String d = instantShoppingColorSelectorColorFragmentModel.c().d();
            String d2 = instantShoppingColorSelectorColorFragmentModel.d();
            InstantShoppingActionFragmentModel a = instantShoppingColorSelectorColorFragmentModel.a();
            ColorPickerImageItemLayout colorPickerImageItemLayout = (ColorPickerImageItemLayout) LayoutInflater.from(getContext()).inflate(2130904944, this.f23721d, false);
            this.f23721d.addView(colorPickerImageItemLayout);
            colorPickerImageItemLayout.m25147a();
            colorPickerImageItemLayout.setImageUrl(d);
            colorPickerImageItemLayout.f23866d = a;
            colorPickerImageItemLayout.setOnClickListener(this.f23722e);
            if (d2 != null && d2.equals("OUT_OF_STOCK")) {
                colorPickerImageItemLayout.setDisabled(true);
            }
            if (z) {
                this.f23723f = colorPickerImageItemLayout;
                this.f23723f.setIsSelected(true);
            }
        } else if (!StringUtil.a(instantShoppingColorSelectorColorFragmentModel.b())) {
            String b;
            if (instantShoppingColorSelectorColorFragmentModel.b().startsWith("#")) {
                b = instantShoppingColorSelectorColorFragmentModel.b();
            } else {
                b = "#" + instantShoppingColorSelectorColorFragmentModel.b();
            }
            m25044a(Color.parseColor(b), instantShoppingColorSelectorColorFragmentModel.d(), z, instantShoppingColorSelectorColorFragmentModel.a());
        } else if (!StringUtil.a(instantShoppingColorSelectorColorFragmentModel.iH_())) {
            m25046a(instantShoppingColorSelectorColorFragmentModel.iH_(), instantShoppingColorSelectorColorFragmentModel.d(), z, instantShoppingColorSelectorColorFragmentModel.a());
        }
    }

    private void m25046a(String str, String str2, boolean z, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        ColorPickerTextItemLayout colorPickerTextItemLayout = (ColorPickerTextItemLayout) LayoutInflater.from(getContext()).inflate(2130904947, this.f23721d, false);
        this.f23721d.addView(colorPickerTextItemLayout);
        colorPickerTextItemLayout.m25150a();
        colorPickerTextItemLayout.setOptionText(str);
        colorPickerTextItemLayout.f23873b = instantShoppingActionFragmentModel;
        colorPickerTextItemLayout.setOnClickListener(this.f23722e);
        if (str2 != null && str2.equals("OUT_OF_STOCK")) {
            colorPickerTextItemLayout.setDisabled(true);
        }
        if (z) {
            this.f23723f = colorPickerTextItemLayout;
            this.f23723f.setIsSelected(true);
            this.f23720c.a = true;
        }
    }

    private void m25044a(int i, String str, boolean z, InstantShoppingActionFragmentModel instantShoppingActionFragmentModel) {
        ColorPickerColorItemLayout colorPickerColorItemLayout = (ColorPickerColorItemLayout) LayoutInflater.from(getContext()).inflate(2130904943, this.f23721d, false);
        this.f23721d.addView(colorPickerColorItemLayout);
        colorPickerColorItemLayout.m25146a();
        colorPickerColorItemLayout.setColor(i);
        colorPickerColorItemLayout.f23861d = instantShoppingActionFragmentModel;
        colorPickerColorItemLayout.setOnClickListener(this.f23722e);
        if (str != null && str.equals("OUT_OF_STOCK")) {
            colorPickerColorItemLayout.setDisabled(true);
        }
        if (z) {
            this.f23723f = colorPickerColorItemLayout;
            this.f23723f.setIsSelected(true);
        }
    }
}

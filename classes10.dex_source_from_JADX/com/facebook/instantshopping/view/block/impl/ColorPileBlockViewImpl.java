package com.facebook.instantshopping.view.block.impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.instantshopping.logging.InstantShoppingAnalyticsLogger;
import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingColorSelectorColorFragmentModel;
import com.facebook.instantshopping.presenter.ColorPickerBlockPresenter;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.widget.ColorPickerPileImageItemLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import javax.inject.Inject;

/* compiled from: STATUS_SUBSCRIBED_ALL */
public class ColorPileBlockViewImpl extends AbstractBlockView<ColorPickerBlockPresenter> implements ColorPickerBlockView {
    @Inject
    public InstantShoppingAnalyticsLogger f23726a;
    public final LinearLayout f23727b;
    public OnClickListener f23728c = new C34021(this);
    public LoggingParams f23729d;

    /* compiled from: STATUS_SUBSCRIBED_ALL */
    public class C34021 implements OnClickListener {
        final /* synthetic */ ColorPileBlockViewImpl f23725a;

        public C34021(ColorPileBlockViewImpl colorPileBlockViewImpl) {
            this.f23725a = colorPileBlockViewImpl;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 62238109);
            this.f23725a.f23726a.m24857a(this.f23725a.f23729d, null);
            Logger.a(2, EntryType.UI_INPUT_END, -82702692, a);
        }
    }

    public static void m25048a(Object obj, Context context) {
        ((ColorPileBlockViewImpl) obj).f23726a = InstantShoppingAnalyticsLogger.m24853a(FbInjector.get(context));
    }

    public ColorPileBlockViewImpl(View view) {
        super(view);
        Class cls = ColorPileBlockViewImpl.class;
        m25048a(this, getContext());
        this.f23727b = (LinearLayout) view.findViewById(2131563240);
    }

    public final void mo1029a(InstantShoppingColorSelectorColorFragmentModel instantShoppingColorSelectorColorFragmentModel, boolean z, LoggingParams loggingParams) {
        this.f23729d = loggingParams;
        if (instantShoppingColorSelectorColorFragmentModel.c() != null) {
            String d = instantShoppingColorSelectorColorFragmentModel.c().d();
            ColorPickerPileImageItemLayout colorPickerPileImageItemLayout = (ColorPickerPileImageItemLayout) LayoutInflater.from(getContext()).inflate(2130904945, this.f23727b, false);
            this.f23727b.addView(colorPickerPileImageItemLayout);
            colorPickerPileImageItemLayout.m25148a();
            colorPickerPileImageItemLayout.setImageUrl(d);
            colorPickerPileImageItemLayout.setOnClickListener(this.f23728c);
        }
    }
}

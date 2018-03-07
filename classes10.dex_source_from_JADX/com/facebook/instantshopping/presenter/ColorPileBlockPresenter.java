package com.facebook.instantshopping.presenter;

import android.view.LayoutInflater;
import com.facebook.instantshopping.model.data.ColorPickerBlockData;
import com.facebook.instantshopping.model.data.impl.ColorPickerBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingColorSelectorColorFragmentModel;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.block.impl.ColorPileBlockViewImpl;
import com.facebook.instantshopping.view.widget.ColorPickerPileTextItemLayout;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: SUGGESTED_PRICE */
public class ColorPileBlockPresenter extends AbstractBlockPresenter<ColorPickerBlockView, ColorPickerBlockData> {
    public final void m24990a(BlockData blockData) {
        ColorPickerBlockDataImpl colorPickerBlockDataImpl = (ColorPickerBlockDataImpl) blockData;
        ((ColorPileBlockViewImpl) this.d).f23727b.removeAllViews();
        int B = colorPickerBlockDataImpl.mo1000B() / 10;
        int i = 0;
        while (i < B && i < colorPickerBlockDataImpl.m24950b().size()) {
            ((ColorPickerBlockView) this.d).mo1029a((InstantShoppingColorSelectorColorFragmentModel) colorPickerBlockDataImpl.m24950b().get(i), false, colorPickerBlockDataImpl.mo1008C());
            i++;
        }
        if (B < colorPickerBlockDataImpl.m24950b().size()) {
            ColorPileBlockViewImpl colorPileBlockViewImpl = (ColorPileBlockViewImpl) this.d;
            int size = colorPickerBlockDataImpl.m24950b().size() - B;
            colorPileBlockViewImpl.f23729d = colorPickerBlockDataImpl.mo1008C();
            ColorPickerPileTextItemLayout colorPickerPileTextItemLayout = (ColorPickerPileTextItemLayout) LayoutInflater.from(colorPileBlockViewImpl.getContext()).inflate(2130904946, colorPileBlockViewImpl.f23727b, false);
            colorPileBlockViewImpl.f23727b.addView(colorPickerPileTextItemLayout);
            colorPickerPileTextItemLayout.m25149a();
            colorPickerPileTextItemLayout.setMoreText(String.format(colorPileBlockViewImpl.getContext().getString(2131239259), new Object[]{Integer.valueOf(size)}));
            colorPickerPileTextItemLayout.setOnClickListener(colorPileBlockViewImpl.f23728c);
        }
        ColorPileBlockViewImpl colorPileBlockViewImpl2 = (ColorPileBlockViewImpl) this.d;
        colorPileBlockViewImpl2.f23726a.m24856a(colorPickerBlockDataImpl.mo1008C());
    }

    public ColorPileBlockPresenter(ColorPickerBlockView colorPickerBlockView) {
        super(colorPickerBlockView);
    }
}

package com.facebook.instantshopping.presenter;

import com.facebook.instantshopping.model.data.ColorPickerBlockData;
import com.facebook.instantshopping.model.data.impl.ColorPickerBlockDataImpl;
import com.facebook.instantshopping.model.graphql.InstantShoppingGraphQLModels.InstantShoppingColorSelectorColorFragmentModel;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.block.impl.ColorPickerBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: SUGGESTIONS_FAILED */
public class ColorPickerBlockPresenter extends AbstractBlockPresenter<ColorPickerBlockView, ColorPickerBlockData> {
    public boolean f23666d;

    public final void m24989a(BlockData blockData) {
        ColorPickerBlockDataImpl colorPickerBlockDataImpl = (ColorPickerBlockDataImpl) blockData;
        if (!this.f23666d) {
            for (int i = 0; i < colorPickerBlockDataImpl.m24950b().size(); i++) {
                boolean z;
                if (i == colorPickerBlockDataImpl.f23640a.k()) {
                    z = true;
                } else {
                    z = false;
                }
                ((ColorPickerBlockView) this.d).mo1029a((InstantShoppingColorSelectorColorFragmentModel) colorPickerBlockDataImpl.m24950b().get(i), z, colorPickerBlockDataImpl.mo1008C());
            }
            this.f23666d = true;
        }
        ColorPickerBlockViewImpl colorPickerBlockViewImpl = (ColorPickerBlockViewImpl) this.d;
        colorPickerBlockViewImpl.f23719b.m24856a(colorPickerBlockDataImpl.mo1008C());
    }

    public ColorPickerBlockPresenter(ColorPickerBlockView colorPickerBlockView) {
        super(colorPickerBlockView);
    }
}

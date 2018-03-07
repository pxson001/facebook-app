package com.facebook.instantshopping.genesis;

import android.view.View;
import android.widget.HorizontalScrollView;
import com.facebook.instantshopping.presenter.ColorPickerBlockPresenter;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.block.impl.ColorPickerBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: SimpleRowItem{msgType= */
public class ColorPickerBlockCreator extends BaseBlockCreator<ColorPickerBlockView> {
    public final AbstractBlockPresenter m24818a(BlockView blockView) {
        return new ColorPickerBlockPresenter((ColorPickerBlockView) blockView);
    }

    @Inject
    public ColorPickerBlockCreator() {
        super(2130904942, 104);
    }

    public final BlockView m24819a(View view) {
        return new ColorPickerBlockViewImpl((HorizontalScrollView) view.findViewById(2131563230));
    }
}

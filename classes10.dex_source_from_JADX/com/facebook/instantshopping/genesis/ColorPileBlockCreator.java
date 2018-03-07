package com.facebook.instantshopping.genesis;

import android.view.View;
import android.widget.LinearLayout;
import com.facebook.instantshopping.presenter.ColorPileBlockPresenter;
import com.facebook.instantshopping.view.block.ColorPickerBlockView;
import com.facebook.instantshopping.view.block.impl.ColorPileBlockViewImpl;
import com.facebook.richdocument.genesis.BaseBlockCreator;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import javax.inject.Inject;

/* compiled from: SimpleDateFormat */
public class ColorPileBlockCreator extends BaseBlockCreator<ColorPickerBlockView> {
    public final AbstractBlockPresenter m24820a(BlockView blockView) {
        return new ColorPileBlockPresenter((ColorPickerBlockView) blockView);
    }

    @Inject
    public ColorPileBlockCreator() {
        super(2130904948, 111);
    }

    public final BlockView m24821a(View view) {
        return new ColorPileBlockViewImpl((LinearLayout) view.findViewById(2131563240));
    }
}

package com.facebook.notes.view.block.impl;

import android.view.View;
import com.facebook.notes.presenter.UFIBlockPresenter;
import com.facebook.notes.view.block.UFIBlockView;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import com.facebook.richdocument.view.widget.UFIView;

/* compiled from: Tried to share nonexistent photo */
public class UFIBlockViewImpl extends AbstractBlockView<UFIBlockPresenter> implements UFIBlockView {
    public final UFIView f10541a;

    public UFIBlockViewImpl(View view) {
        super(view);
        this.f10541a = (UFIView) view;
        this.f10541a.setIsOverlay(false);
    }
}

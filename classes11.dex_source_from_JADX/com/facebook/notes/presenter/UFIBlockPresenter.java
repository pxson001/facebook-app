package com.facebook.notes.presenter;

import com.facebook.notes.model.data.UFIBlockData;
import com.facebook.notes.model.data.impl.UFIBlockDataImpl;
import com.facebook.notes.view.block.UFIBlockView;
import com.facebook.notes.view.block.impl.UFIBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity. */
public class UFIBlockPresenter extends AbstractBlockPresenter<UFIBlockView, UFIBlockData> {
    public final void m11038a(BlockData blockData) {
        UFIBlockDataImpl uFIBlockDataImpl = (UFIBlockDataImpl) blockData;
        ((UFIBlockViewImpl) this.d).a(null);
        UFIBlockViewImpl uFIBlockViewImpl = (UFIBlockViewImpl) this.d;
        uFIBlockViewImpl.f10541a.setAnnotation(uFIBlockDataImpl.f10534a);
    }

    public UFIBlockPresenter(UFIBlockViewImpl uFIBlockViewImpl) {
        super(uFIBlockViewImpl);
    }
}

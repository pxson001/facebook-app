package com.facebook.instantshopping.presenter;

import com.facebook.instantshopping.logging.LoggingParams;
import com.facebook.instantshopping.model.block.BaseInstantShoppingBlockWrapper;
import com.facebook.instantshopping.model.block.text.InstantShoppingText.InstantShoppingTextBuilder;
import com.facebook.instantshopping.model.block.text.InstantShoppingTextBlockWrapper;
import com.facebook.instantshopping.model.data.ExpandableBlockData;
import com.facebook.instantshopping.model.data.impl.ExpandableBlockDataImpl;
import com.facebook.instantshopping.view.block.ExpandableBlockView;
import com.facebook.instantshopping.view.block.impl.ExpandableBlockViewImpl;
import com.facebook.instantshopping.view.block.impl.ExpandableBlockViewImpl.C34031;
import com.facebook.instantshopping.view.block.impl.ExpandableBlockViewImpl.C34042;
import com.facebook.instantshopping.view.block.impl.ExpandableBlockViewImpl.C34053;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: SUCCESS_NO_DATA */
public class ExpandableBlockPresenter extends AbstractBlockPresenter<ExpandableBlockView, ExpandableBlockData> {
    public final void m24997a(BlockData blockData) {
        ExpandableBlockDataImpl expandableBlockDataImpl = (ExpandableBlockDataImpl) blockData;
        ExpandableBlockViewImpl expandableBlockViewImpl = (ExpandableBlockViewImpl) this.d;
        BaseInstantShoppingBlockWrapper instantShoppingTextBlockWrapper = new InstantShoppingTextBlockWrapper(expandableBlockDataImpl.f23642a.p());
        expandableBlockViewImpl.f23740c.d.setText(new InstantShoppingTextBuilder(expandableBlockViewImpl.getContext(), instantShoppingTextBlockWrapper.m24906f()).a(instantShoppingTextBlockWrapper).a().a);
        expandableBlockViewImpl.f23739b.a(expandableBlockViewImpl.f23740c.d, instantShoppingTextBlockWrapper.m24891e(), instantShoppingTextBlockWrapper.nu_());
        instantShoppingTextBlockWrapper = new InstantShoppingTextBlockWrapper(expandableBlockDataImpl.f23642a.o());
        expandableBlockViewImpl.f23742e.d.setText(new InstantShoppingTextBuilder(expandableBlockViewImpl.getContext(), instantShoppingTextBlockWrapper.m24906f()).a(instantShoppingTextBlockWrapper).a().a);
        expandableBlockViewImpl.f23739b.a(expandableBlockViewImpl.f23742e.d, instantShoppingTextBlockWrapper.m24891e(), instantShoppingTextBlockWrapper.nu_());
        LoggingParams C = expandableBlockDataImpl.mo1008C();
        expandableBlockViewImpl.f23742e.d.setOnClickListener(new C34031(expandableBlockViewImpl, C));
        expandableBlockViewImpl.f23741d.setOnClickListener(new C34042(expandableBlockViewImpl, C));
        expandableBlockViewImpl.f23743f.setOnClickListener(new C34053(expandableBlockViewImpl, C));
        expandableBlockViewImpl.f23738a.m24856a(expandableBlockDataImpl.mo1008C());
    }

    public ExpandableBlockPresenter(ExpandableBlockViewImpl expandableBlockViewImpl) {
        super(expandableBlockViewImpl);
    }
}

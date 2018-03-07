package com.facebook.richdocument.presenter;

import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.HairlineBlockData;
import com.facebook.richdocument.model.data.impl.HairlineBlockDataImpl;
import com.facebook.richdocument.view.block.HairlineBlockView;

/* compiled from: photoCount */
public class HairlineBlockPresenter extends AbstractBlockPresenter<HairlineBlockView, HairlineBlockData> {
    public final void mo366a(BlockData blockData) {
        HairlineBlockDataImpl hairlineBlockDataImpl = (HairlineBlockDataImpl) blockData;
        ((HairlineBlockView) this.f6382d).mo388c(hairlineBlockDataImpl.f5699a);
        ((HairlineBlockView) this.f6382d).mo386a(hairlineBlockDataImpl.f5700b);
        ((HairlineBlockView) this.f6382d).mo387b(hairlineBlockDataImpl.f5701c);
    }

    public HairlineBlockPresenter(HairlineBlockView hairlineBlockView) {
        super(hairlineBlockView);
    }
}

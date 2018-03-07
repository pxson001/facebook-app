package com.facebook.richdocument.genesis;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;
import com.facebook.richdocument.presenter.ImageBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.ImageBlockView;
import com.facebook.richdocument.view.block.impl.ImageBlockViewImpl;
import com.facebook.richdocument.view.util.CompositeRecyclableViewFactory;
import com.facebook.richdocument.view.viewholder.BlockViewHolder;
import javax.inject.Inject;

/* compiled from: playableUrl */
public class PhotoBlockCreator extends BaseBlockCreator<ImageBlockView> {
    private final CompositeRecyclableViewFactory f5289a;

    public final /* synthetic */ BlockView mo264a(View view) {
        return ImageBlockViewImpl.m6995a(view);
    }

    @Inject
    public PhotoBlockCreator(CompositeRecyclableViewFactory compositeRecyclableViewFactory) {
        super(2130906878, 4);
        this.f5289a = compositeRecyclableViewFactory;
    }

    private static AbstractBlockPresenter m5249a(ImageBlockViewImpl imageBlockViewImpl) {
        return new ImageBlockPresenter(imageBlockViewImpl);
    }

    public final BlockViewHolder mo265a(ViewGroup viewGroup) {
        ImageBlockViewImpl a = ImageBlockViewImpl.m6995a(this.f5289a.m7358a(2130906878));
        m5249a(a);
        return new BlockViewHolder(a);
    }
}

package com.facebook.notes.presenter;

import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.notes.model.data.FromAuthorBlockData;
import com.facebook.notes.model.data.impl.FromAuthorDataBlockImpl;
import com.facebook.notes.view.block.FromBlockView;
import com.facebook.notes.view.block.impl.FromBlockViewImpl;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.presenter.AbstractBlockPresenter;

/* compiled from: Trying to enable bluetooth discovery finished receiver */
public class FromBlockPresenter extends AbstractBlockPresenter<FromBlockView, FromAuthorBlockData> {
    public final void m11036a(BlockData blockData) {
        FromAuthorDataBlockImpl fromAuthorDataBlockImpl = (FromAuthorDataBlockImpl) blockData;
        Object obj = null;
        ((FromBlockViewImpl) this.d).a(null);
        FromBlockViewImpl fromBlockViewImpl = (FromBlockViewImpl) this.d;
        String str = fromAuthorDataBlockImpl.f10530a;
        if (fromAuthorDataBlockImpl.f10531b != null) {
            obj = fromAuthorDataBlockImpl.f10531b;
        }
        fromBlockViewImpl.f10537c.setText(str);
        if (StringUtil.c(obj)) {
            fromBlockViewImpl.f10538d.setController(null);
        } else {
            fromBlockViewImpl.f10538d.a(Uri.parse(obj), FromBlockViewImpl.f10535b);
        }
    }

    public FromBlockPresenter(FromBlockViewImpl fromBlockViewImpl) {
        super(fromBlockViewImpl);
    }
}

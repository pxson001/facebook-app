package com.facebook.richdocument.view.block;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.facebook.richdocument.presenter.BlockPresenter;
import com.facebook.richdocument.view.viewholder.ViewHolderAware;

/* compiled from: pandora_instance_id */
public interface BlockView<T extends BlockPresenter> extends ViewHolderAware {
    void mo374a(Bundle bundle);

    void mo376a(T t);

    boolean mo377a(int i, int i2);

    void mo378b(Bundle bundle);

    void mo379c(Bundle bundle);

    Context getContext();

    T iX_();

    View iY_();
}

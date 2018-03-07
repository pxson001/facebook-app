package com.facebook.iorg.common.zero.ui;

import android.support.v4.app.FragmentManager;
import com.facebook.iorg.common.zero.IorgDialogDisplayContext;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: presence_cache_age */
public final class ZeroDialogController$DialogData<T> {
    public ZeroFeatureKey f5063a;
    public String f5064b;
    public String f5065c;
    @Nullable
    public ZeroDialogController$Listener f5066d;
    @Nullable
    public String f5067e;
    @Nullable
    public ListenableFuture<T> f5068f;
    @Nullable
    public FutureCallback<T> f5069g;
    @Nullable
    public IorgDialogDisplayContext f5070h;
    @Nullable
    public FragmentManager f5071i;
    public ZeroDialogController$DialogToShow f5072j;
    final /* synthetic */ ZeroDialogController f5073k;

    public ZeroDialogController$DialogData(ZeroDialogController zeroDialogController) {
        this.f5073k = zeroDialogController;
    }

    public final String toString() {
        return "DialogData{dialogKey=" + this.f5063a + ", dialogTitle='" + this.f5064b + '\'' + ", dialogContent='" + this.f5065c + '\'' + ", dialogListener=" + this.f5066d + ", uri='" + this.f5067e + '\'' + ", displayContext=" + (this.f5070h != null ? this.f5070h.name() : "null") + ", dialogToShow=" + this.f5072j + '}';
    }
}

package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.google.common.base.Objects;

/* compiled from: com.google.android.gms.cast.metadata.LOCATION_NAME */
public class PandoraRendererCacheConfig {
    public final PandoraInstanceId f17478a;
    public final int f17479b;
    public final int f17480c;
    public final PandoraRequestSource f17481d;
    public final boolean f17482e;

    public PandoraRendererCacheConfig(PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, boolean z) {
        this.f17478a = pandoraInstanceId;
        this.f17479b = -1;
        this.f17480c = -1;
        this.f17481d = pandoraRequestSource;
        this.f17482e = z;
    }

    public PandoraRendererCacheConfig(PandoraInstanceId pandoraInstanceId, int i, int i2, PandoraRequestSource pandoraRequestSource, boolean z) {
        this.f17478a = pandoraInstanceId;
        this.f17479b = i;
        this.f17480c = i2;
        this.f17481d = pandoraRequestSource;
        this.f17482e = z;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PandoraRendererCacheConfig)) {
            return false;
        }
        PandoraRendererCacheConfig pandoraRendererCacheConfig = (PandoraRendererCacheConfig) obj;
        if (Objects.equal(this.f17478a, pandoraRendererCacheConfig.f17478a) && this.f17479b == pandoraRendererCacheConfig.f17479b && this.f17480c == pandoraRendererCacheConfig.f17480c && this.f17481d == pandoraRendererCacheConfig.f17481d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f17478a.hashCode() + ((this.f17479b * this.f17480c) * (this.f17481d.ordinal() + 1))) + this.f17479b;
    }
}

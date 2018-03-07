package com.facebook.photos.pandora.common.ui.renderer.factories;

import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.google.common.collect.ImmutableList;

/* compiled from: com.google.android.gms.cast.metadata.SEASON_NUMBER */
public abstract class AbstractPandoraRendererSingleDataModelRowFactory implements PandoraRendererRowFactory {
    public abstract ImmutableList<? extends PandoraRendererRow> mo1046a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraDataModel pandoraDataModel);

    public abstract boolean mo1047a(PandoraDataModel pandoraDataModel);
}

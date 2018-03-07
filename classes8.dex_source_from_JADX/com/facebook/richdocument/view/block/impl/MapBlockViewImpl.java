package com.facebook.richdocument.view.block.impl;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.presenter.MapBlockPresenter;
import com.facebook.richdocument.view.block.BlockView;
import com.facebook.richdocument.view.block.LocationAnnotationAware;
import com.facebook.richdocument.view.block.MapBlockView;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;

/* compiled from: page_loader_currently_loading_ids_right */
public class MapBlockViewImpl extends MediaBlockView<MapBlockPresenter, RichDocumentImageView> implements MapBlockView, BlockView, LocationAnnotationAware, TextAnnotationAware {
    public MapBlockViewImpl(MediaFrame mediaFrame, View view) {
        super(mediaFrame, view);
        m6983a(new MapUnderlayPlugin(mediaFrame));
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        ((RichDocumentImageView) m6992h()).m7587c();
    }

    public final void mo391a(RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel) {
    }

    public final void mo375a(ViewHolder viewHolder) {
        super.mo375a(viewHolder);
        viewHolder.a(false);
    }
}

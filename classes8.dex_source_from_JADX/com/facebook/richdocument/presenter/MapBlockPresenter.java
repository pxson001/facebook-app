package com.facebook.richdocument.presenter;

import android.content.Context;
import com.facebook.graphql.enums.GraphQLDocumentMapStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.MapBlockData;
import com.facebook.richdocument.model.data.impl.MapBlockDataImpl;
import com.facebook.richdocument.view.block.MapBlockView;
import com.facebook.richdocument.view.block.impl.MapBlockViewImpl;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;
import java.util.List;
import javax.inject.Inject;

/* compiled from: person_card_action_bar_clicked_removed_item */
public class MapBlockPresenter extends AbstractBlockPresenter<MapBlockView, MapBlockData> {
    @Inject
    public Lazy<RichDocumentInfo> f6425d;

    /* compiled from: person_card_action_bar_clicked_removed_item */
    public /* synthetic */ class C07291 {
        public static final /* synthetic */ int[] f6424a = new int[GraphQLDocumentMapStyle.values().length];

        static {
            try {
                f6424a[GraphQLDocumentMapStyle.HYBRID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6424a[GraphQLDocumentMapStyle.SATELLITE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6424a[GraphQLDocumentMapStyle.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6424a[GraphQLDocumentMapStyle.STANDARD.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void m6808a(Object obj, Context context) {
        ((MapBlockPresenter) obj).f6425d = IdBasedLazy.a(FbInjector.get(context), 10295);
    }

    public final void mo366a(BlockData blockData) {
        int i;
        int dimensionPixelSize;
        MapBlockDataImpl mapBlockDataImpl = (MapBlockDataImpl) blockData;
        ((MapBlockViewImpl) this.f6382d).mo374a(null);
        switch (C07291.f6424a[mapBlockDataImpl.f5737b.ordinal()]) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 2;
                break;
            default:
                i = 1;
                break;
        }
        int i2 = i;
        List list = mapBlockDataImpl.f5738c;
        int i3 = mapBlockDataImpl.f5736a;
        if (i3 <= 0) {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131431814);
        } else {
            dimensionPixelSize = i3;
        }
        MapBlockViewImpl mapBlockViewImpl = (MapBlockViewImpl) this.f6382d;
        mapBlockViewImpl.m6982a(MediaTransitionState.f6977a);
        ((RichDocumentImageView) mapBlockViewImpl.m6992h()).m7586a(null, mapBlockViewImpl.getContext().getResources().getDisplayMetrics().widthPixels, dimensionPixelSize, null);
        ((RichDocumentImageView) mapBlockViewImpl.m6992h()).setVisibility(8);
        ((MapUnderlayPlugin) mapBlockViewImpl.m6975a(MapUnderlayPlugin.class)).m7939a(i2, list);
        PresenterUtils.m6823a(this.f6382d, mapBlockDataImpl, ((RichDocumentInfo) this.f6425d.get()).f5119g, mapBlockDataImpl.iQ_());
    }

    public MapBlockPresenter(MapBlockViewImpl mapBlockViewImpl) {
        super(mapBlockViewImpl);
        Class cls = MapBlockPresenter.class;
        m6808a(this, getContext());
    }
}

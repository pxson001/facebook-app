package com.facebook.photos.creativeediting.swipeable.composer;

import android.net.Uri;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.swipeable.common.FrameAssetsLoader;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsHelper;
import com.facebook.photos.creativeediting.swipeable.common.SwipeableParamsListBuilderProvider;

/* compiled from: mp_android_redspace_divebar_nux */
public class CreativeEditingSwipeableControllerProvider extends AbstractAssistedProvider<CreativeEditingSwipeableController> {
    public final CreativeEditingSwipeableController m19557a(EventListener eventListener, SwipeableDraweeControllerGeneratorImpl swipeableDraweeControllerGeneratorImpl, Uri uri, String str) {
        return new CreativeEditingSwipeableController(eventListener, swipeableDraweeControllerGeneratorImpl, uri, str, (SwipeableNuxManagerProvider) getOnDemandAssistedProviderForStaticDi(SwipeableNuxManagerProvider.class), SwipeableParamsHelper.b(this), (SwipeableTouchEventControllerProvider) getOnDemandAssistedProviderForStaticDi(SwipeableTouchEventControllerProvider.class), FrameAssetsLoader.a(this), (SwipeableParamsListBuilderProvider) getOnDemandAssistedProviderForStaticDi(SwipeableParamsListBuilderProvider.class));
    }
}

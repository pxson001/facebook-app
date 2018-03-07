package com.facebook.maps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import com.facebook.android.maps.model.BitmapDescriptorFactory;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.friendsnearby.ui.FriendsNearbyMapMarkerImageTransformation;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.maps.delegate.MarkerDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: voipCapabilities */
public class UrlImageMarkerController {
    private static final Object f334a = CallerContext.a(UrlImageMarkerController.class, "nearby_map");
    private final ImagePipeline f335b;
    private final ExecutorService f336c;
    public final List<DataSource<CloseableReference<CloseableImage>>> f337d = Collections.synchronizedList(new ArrayList());
    public List<CloseableReference<Bitmap>> f338e = Collections.synchronizedList(new ArrayList());
    public boolean f339f;
    public boolean f340g;

    @Inject
    public UrlImageMarkerController(ImagePipeline imagePipeline, ExecutorService executorService) {
        this.f335b = imagePipeline;
        this.f336c = executorService;
    }

    public final void m293a(final MarkerDelegate markerDelegate, Uri uri, final FriendsNearbyMapMarkerImageTransformation friendsNearbyMapMarkerImageTransformation) {
        final DataSource c = this.f335b.c(ImageRequest.a(uri), f334a);
        C00411 c00411 = new BaseBitmapDataSubscriber(this) {
            final /* synthetic */ UrlImageMarkerController f333d;

            protected final void m291a(@Nullable Bitmap bitmap) {
                this.f333d.f337d.remove(c);
                if (bitmap != null) {
                    FriendsNearbyMapMarkerImageTransformation friendsNearbyMapMarkerImageTransformation = friendsNearbyMapMarkerImageTransformation;
                    CloseableReference a = friendsNearbyMapMarkerImageTransformation.d.a(friendsNearbyMapMarkerImageTransformation.a.getIntrinsicWidth(), friendsNearbyMapMarkerImageTransformation.a.getIntrinsicHeight());
                    ((Bitmap) a.a()).setHasAlpha(true);
                    Canvas canvas = new Canvas((Bitmap) a.a());
                    canvas.translate((float) friendsNearbyMapMarkerImageTransformation.c, (float) friendsNearbyMapMarkerImageTransformation.c);
                    friendsNearbyMapMarkerImageTransformation.b.a(canvas, bitmap);
                    canvas.translate((float) (-friendsNearbyMapMarkerImageTransformation.c), (float) (-friendsNearbyMapMarkerImageTransformation.c));
                    friendsNearbyMapMarkerImageTransformation.a.draw(canvas);
                    CloseableReference closeableReference = a;
                    markerDelegate.m362a(BitmapDescriptorFactory.a((Bitmap) closeableReference.a()));
                    if (this.f333d.f339f) {
                        this.f333d.f338e.add(closeableReference);
                    } else {
                        CloseableReference.c(closeableReference);
                    }
                }
            }

            protected final void m292f(DataSource<CloseableReference<CloseableImage>> dataSource) {
            }
        };
        this.f337d.add(c);
        c.a(c00411, this.f336c);
    }
}

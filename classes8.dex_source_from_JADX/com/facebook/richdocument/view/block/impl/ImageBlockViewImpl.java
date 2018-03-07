package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLDocumentMediaPresentationStyle;
import com.facebook.http.observer.ConnectionQuality;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.richdocument.RichDocumentContextWrapper;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.logging.ImagePerfLogger;
import com.facebook.richdocument.logging.ImagePerfLogger.ImageInfo;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import com.facebook.richdocument.presenter.ImageBlockPresenter;
import com.facebook.richdocument.utils.ConnectionQualityMonitor;
import com.facebook.richdocument.view.block.BlockViewUtil;
import com.facebook.richdocument.view.block.FeedbackAware;
import com.facebook.richdocument.view.block.ImageBlockView;
import com.facebook.richdocument.view.block.LocationAnnotationAware;
import com.facebook.richdocument.view.block.TextAnnotationAware;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.CircularIndeterminateLoadingIndicator;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.RichDocumentImageView.ImageSetListener;
import com.facebook.richdocument.view.widget.RichDocumentRecyclerView;
import com.facebook.richdocument.view.widget.SlideshowView;
import com.facebook.richdocument.view.widget.UFIView;
import com.facebook.richdocument.view.widget.UFIView.ComposerLaunchParams;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.CircularIndeterminateLoadingIndicatorPlugin;
import com.facebook.richdocument.view.widget.media.plugins.ExternalClickPlugin;
import com.facebook.richdocument.view.widget.media.plugins.HighResolutionImageSwapPlugin;
import com.facebook.richdocument.view.widget.media.plugins.ImageInteractionMonitorPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MapUnderlayPlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaFramePlugin;
import com.facebook.richdocument.view.widget.media.plugins.MediaTiltPlugin;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.inject.Inject;

/* compiled from: page_new_activity_count_tap */
public class ImageBlockViewImpl extends MediaBlockView<ImageBlockPresenter, RichDocumentImageView> implements ImageBlockView, ImageSetListener, FeedbackAware, LocationAnnotationAware, TextAnnotationAware, ImageSetListener {
    @Inject
    public GatekeeperStoreImpl f6640a;
    @Inject
    public ConnectionQualityMonitor f6641b;
    @Inject
    public ImagePerfLogger f6642c;
    @Inject
    public QeAccessor f6643d;
    private final boolean f6644j = this.f6640a.a(693, false);
    private final boolean f6645k;
    private String f6646l;
    private String f6647m;
    private int f6648n;
    private int f6649o;
    private GraphQLDocumentMediaPresentationStyle f6650p;
    public ImageSetListener f6651q;
    private boolean f6652r;
    private boolean f6653s;
    private boolean f6654t;
    private boolean f6655u;
    private boolean f6656v;
    private CircularIndeterminateLoadingIndicator f6657w;

    public static void m6996a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ImageBlockViewImpl imageBlockViewImpl = (ImageBlockViewImpl) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        ConnectionQualityMonitor a2 = ConnectionQualityMonitor.a(fbInjector);
        ImagePerfLogger a3 = ImagePerfLogger.m5347a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        imageBlockViewImpl.f6640a = a;
        imageBlockViewImpl.f6641b = a2;
        imageBlockViewImpl.f6642c = a3;
        imageBlockViewImpl.f6643d = qeAccessor;
    }

    public ImageBlockViewImpl(MediaFrame mediaFrame, View view) {
        boolean z = true;
        super(mediaFrame, view);
        Class cls = ImageBlockViewImpl.class;
        m6996a(this, getContext());
        ConnectionQuality a = this.f6641b.a();
        boolean z2 = this.f6644j && this.f6640a.a(695, false) && a.compareTo(ConnectionQuality.GOOD) < 0 && m7003c();
        this.f6645k = z2;
        this.f6654t = this.f6643d.a(ExperimentsForRichDocumentAbtestModule.c, false);
        this.f6655u = this.f6643d.a(ExperimentsForRichDocumentAbtestModule.b, true);
        if (!(this.f6654t && this.f6655u)) {
            z = false;
        }
        this.f6656v = z;
        if (this.f6645k) {
            this.f6657w = (CircularIndeterminateLoadingIndicator) LayoutInflater.from(getContext()).inflate(2130906867, this.f6634a.mo480b(), false);
            MediaFramePlugin circularIndeterminateLoadingIndicatorPlugin = new CircularIndeterminateLoadingIndicatorPlugin(this.f6634a, this.f6657w);
            m6983a(circularIndeterminateLoadingIndicatorPlugin);
            this.f6651q = circularIndeterminateLoadingIndicatorPlugin;
        }
        m6983a(new MediaTiltPlugin(mediaFrame));
        m6983a(new MapUnderlayPlugin(mediaFrame));
        m6983a(new ExternalClickPlugin(mediaFrame));
        m6983a(new ImageInteractionMonitorPlugin(mediaFrame));
        ((RichDocumentImageView) m6992h()).f7318h = this;
    }

    public void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6653s = false;
        this.f6652r = false;
        this.f6647m = null;
        this.f6646l = null;
        this.f6648n = 0;
        this.f6649o = 0;
        this.f6650p = null;
        TracerDetour.a("ImageBlockViewImpl.reset#reset RichDocumentImageView", 1333389214);
        ((RichDocumentImageView) m6992h()).m7587c();
        TracerDetour.a(-539415484);
    }

    public final void m7000a(String str, String str2, int i, int i2, String str3, int i3, int i4, GraphQLDocumentMediaPresentationStyle graphQLDocumentMediaPresentationStyle, String str4) {
        this.f6646l = str;
        this.f6647m = str4;
        this.f6650p = graphQLDocumentMediaPresentationStyle;
        m6982a(BlockViewUtil.m6916a(graphQLDocumentMediaPresentationStyle));
        if (this.f6645k) {
            m6990f().mo407a(this.f6657w);
        }
        if (!this.f6656v || str3 == null) {
            ((RichDocumentImageView) m6992h()).m7586a(str2, i, i2, null);
            this.f6648n = i;
            this.f6649o = i2;
        } else {
            ((RichDocumentImageView) m6992h()).m7586a(str3, i, i2, null);
            this.f6648n = i3;
            this.f6649o = i4;
            m6987b(HighResolutionImageSwapPlugin.class);
            m6983a(new HighResolutionImageSwapPlugin(m6990f(), (RichDocumentImageView) m6992h(), str2, i, i2));
        }
        ImageInteractionMonitorPlugin imageInteractionMonitorPlugin = (ImageInteractionMonitorPlugin) m6975a(ImageInteractionMonitorPlugin.class);
        if (imageInteractionMonitorPlugin != null) {
            imageInteractionMonitorPlugin.f7639b = str4;
        }
    }

    public void m6999a(String str, int i, int i2) {
        if (this.f6644j) {
            ((RichDocumentImageView) m6992h()).m7585a(str, i, i2);
        }
    }

    public boolean m7003c() {
        return true;
    }

    public void mo378b(Bundle bundle) {
        super.mo378b(bundle);
        this.f6642c.m5350a(this.f6647m, this.f6648n, this.f6649o, this.f6650p, this.f6652r, this.f6653s);
        ViewParent parent = ((RichDocumentImageView) m6992h()).getParent();
        while (parent != null && !(parent instanceof RichDocumentRecyclerView)) {
            if (parent instanceof SlideshowView) {
                AnnotationView a = this.f6634a.getBody().getAnnotationViews().m7392a(AnnotationType.UFI);
                if (a != null && (a instanceof UFIView)) {
                    ((UFIView) a).setShowShareButton(false);
                    return;
                }
                return;
            }
            parent = parent.getParent();
        }
    }

    public static ImageBlockViewImpl m6995a(View view) {
        return new ImageBlockViewImpl((MediaFrame) view, view);
    }

    public final void mo395a(RichDocumentImageView richDocumentImageView) {
        this.f6652r = true;
        ImagePerfLogger imagePerfLogger = this.f6642c;
        ImageInfo imageInfo = (ImageInfo) imagePerfLogger.f5472f.get(this.f6647m);
        if (!(imageInfo == null || imageInfo.f5459h)) {
            imageInfo.f5456e = imagePerfLogger.f5471e.now() - imageInfo.f5461j;
            imageInfo.f5460i = true;
        }
        if (this.f6651q != null) {
            this.f6651q.mo396b(richDocumentImageView);
        }
    }

    public final void mo396b(RichDocumentImageView richDocumentImageView) {
        this.f6653s = true;
        this.f6642c.m5351a(this.f6647m, RichDocumentContextWrapper.m5021a(getContext()), this.f6654t, this.f6655u);
        if (this.f6651q != null) {
            this.f6651q.mo396b(richDocumentImageView);
        }
    }

    protected final ComposerLaunchParams mo397d() {
        return BlockViewUtil.m6917a(this.f6646l, 77090322);
    }
}

package com.facebook.videocodec.effects.renderers;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;
import com.facebook.videocodec.effects.GLRenderer;
import com.facebook.videocodec.effects.VideoRenderer;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: detail_items */
public class EffectsFactory {
    public OverlayRendererProvider f15822a;

    /* compiled from: detail_items */
    public class EffectsBuilder {
        private List<GLRenderer> f15820a = new ArrayList();
        private OverlayRendererProvider f15821b;

        public EffectsBuilder(GLRenderer gLRenderer, OverlayRendererProvider overlayRendererProvider) {
            this.f15820a.add(gLRenderer);
            this.f15821b = overlayRendererProvider;
        }

        public final EffectsBuilder m19779a(Uri uri, CallerContext callerContext) {
            this.f15820a.add(this.f15821b.m19790a(uri, callerContext));
            return this;
        }

        public final ImmutableList<GLRenderer> m19780a() {
            return ImmutableList.copyOf(this.f15820a);
        }
    }

    public static EffectsFactory m19782b(InjectorLike injectorLike) {
        return new EffectsFactory((OverlayRendererProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(OverlayRendererProvider.class));
    }

    @Inject
    public EffectsFactory(OverlayRendererProvider overlayRendererProvider) {
        this.f15822a = overlayRendererProvider;
    }

    public final EffectsBuilder m19783a() {
        return new EffectsBuilder(new VideoRenderer(), this.f15822a);
    }

    public static EffectsFactory m19781a(InjectorLike injectorLike) {
        return m19782b(injectorLike);
    }
}

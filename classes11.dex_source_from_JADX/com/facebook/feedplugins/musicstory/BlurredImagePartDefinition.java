package com.facebook.feedplugins.musicstory;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.ui.images.effects.Blur;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

/* compiled from: composer_place_tagging_inline_sprout */
public class BlurredImagePartDefinition extends BaseSinglePartDefinition<Uri, State, AnyEnvironment, SimpleMusicStoryView> {
    private final Postprocessor f8136a = new C10161(this);
    public final FbDraweeControllerBuilder f8137b;
    public final CallerContext f8138c;

    /* compiled from: composer_place_tagging_inline_sprout */
    class C10161 extends BasePostprocessor {
        final /* synthetic */ BlurredImagePartDefinition f8134a;

        C10161(BlurredImagePartDefinition blurredImagePartDefinition) {
            this.f8134a = blurredImagePartDefinition;
        }

        public final void m9143a(Bitmap bitmap) {
            Blur.b(bitmap, 20);
        }
    }

    @Immutable
    /* compiled from: composer_place_tagging_inline_sprout */
    public class State {
        public final ImageRequest f8135a;

        public State(ImageRequest imageRequest) {
            this.f8135a = imageRequest;
        }
    }

    public final Object m9144a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ImageRequestBuilder a = ImageRequestBuilder.a((Uri) obj);
        a.j = this.f8136a;
        return new State(a.m());
    }

    public final /* bridge */ /* synthetic */ void m9145a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -809154534);
        Uri uri = (Uri) obj;
        State state = (State) obj2;
        SimpleMusicStoryView simpleMusicStoryView = (SimpleMusicStoryView) view;
        if (!uri.equals(simpleMusicStoryView.f8208d)) {
            simpleMusicStoryView.f8207c.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f8137b.c(state.f8135a)).b(simpleMusicStoryView.f8207c.getController())).a(this.f8138c).s());
            simpleMusicStoryView.f8208d = uri;
        }
        Logger.a(8, EntryType.MARK_POP, 435902722, a);
    }

    @Inject
    public BlurredImagePartDefinition(@Assisted CallerContext callerContext, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f8137b = fbDraweeControllerBuilder;
        this.f8138c = callerContext;
    }
}

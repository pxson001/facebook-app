package com.facebook.video.videohome.partdefinitions;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.capability.ComposerFacecastCapability;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.user.model.User;
import com.facebook.video.videohome.data.VideoHomeComposerItem;
import com.facebook.video.videohome.environment.VideoHomeEnvironment;
import com.facebook.video.videohome.views.VideoHomeComposerOnClickListenerProvider;
import com.facebook.video.videohome.views.VideoHomeComposerView;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: sms_in_base64 */
public class VideoHomeComposerPartDefinition extends MultiRowSinglePartDefinition<VideoHomeComposerItem, Void, VideoHomeEnvironment, VideoHomeComposerView> {
    public static final ViewType<View> f3038a = new C02861();
    private static final CallerContext f3039b = CallerContext.a(VideoHomeComposerPartDefinition.class, "video_home");
    private static VideoHomeComposerPartDefinition f3040j;
    private static final Object f3041k = new Object();
    private final VideoHomeComposerOnClickListenerProvider f3042c;
    private final ClickListenerPartDefinition f3043d;
    private final FbDraweePartDefinition f3044e;
    private final TextPartDefinition f3045f;
    private final ComposerFacecastCapability f3046g;
    @LoggedInUser
    private final Provider<User> f3047h;
    private final Activity f3048i;

    /* compiled from: sms_in_base64 */
    final class C02861 extends ViewType<View> {
        C02861() {
        }

        public final View m2915a(Context context) {
            return new VideoHomeComposerView(context);
        }
    }

    private static VideoHomeComposerPartDefinition m2917b(InjectorLike injectorLike) {
        return new VideoHomeComposerPartDefinition((VideoHomeComposerOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoHomeComposerOnClickListenerProvider.class), ClickListenerPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ComposerFacecastCapability.b(injectorLike), IdBasedProvider.a(injectorLike, 3595), ActivityMethodAutoProvider.b(injectorLike));
    }

    public static VideoHomeComposerPartDefinition m2916a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeComposerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f3041k) {
                VideoHomeComposerPartDefinition videoHomeComposerPartDefinition;
                if (a2 != null) {
                    videoHomeComposerPartDefinition = (VideoHomeComposerPartDefinition) a2.a(f3041k);
                } else {
                    videoHomeComposerPartDefinition = f3040j;
                }
                if (videoHomeComposerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2917b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f3041k, b3);
                        } else {
                            f3040j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeComposerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomeComposerPartDefinition(VideoHomeComposerOnClickListenerProvider videoHomeComposerOnClickListenerProvider, ClickListenerPartDefinition clickListenerPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, ComposerFacecastCapability composerFacecastCapability, Provider<User> provider, Activity activity) {
        this.f3042c = videoHomeComposerOnClickListenerProvider;
        this.f3043d = clickListenerPartDefinition;
        this.f3044e = fbDraweePartDefinition;
        this.f3045f = textPartDefinition;
        this.f3046g = composerFacecastCapability;
        this.f3047h = provider;
        this.f3048i = activity;
    }

    public final ViewType m2918a() {
        return f3038a;
    }

    public final boolean m2920a(Object obj) {
        return this.f3046g.a(TargetType.UNDIRECTED);
    }

    public final Object m2919a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        User user = (User) this.f3047h.get();
        subParts.a(this.f3043d, this.f3042c.m3173a(this.f3048i));
        subParts.a(2131568419, this.f3045f, user.e.g());
        FbDraweePartDefinition fbDraweePartDefinition = this.f3044e;
        Builder a = FbDraweePartDefinition.a();
        a.c = f3039b;
        subParts.a(2131568418, fbDraweePartDefinition, a.a(user.x()).a());
        return null;
    }
}

package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.feedplugins.base.footer.rows.FooterButtonClickListenerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.feedplugins.base.footer.ui.FooterBinderUtil;
import com.facebook.feedplugins.base.footer.ui.FooterButtonAndTouchSpringKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.SimpleMediaFeedbackModel;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: action_is_highlighted */
public class MediaMetadataFooterPartDefinition<E extends HasPersistentState & CanLaunchPhotosFeedFlyout & CanLikePhotosFeedImage, V extends View & Footer> extends BaseSinglePartDefinition<MediaMetadata, State, E, V> {
    private static MediaMetadataFooterPartDefinition f20038f;
    private static final Object f20039g = new Object();
    private final Provider<TouchSpring> f20040a;
    private final FooterButtonClickListenerPartDefinition f20041b;
    public final Context f20042c;
    public final ComposerLauncher f20043d;
    public final Lazy<IFeedIntentBuilder> f20044e;

    /* compiled from: action_is_highlighted */
    public /* synthetic */ class C17332 {
        public static final /* synthetic */ int[] f20035a = new int[FooterButtonId.values().length];

        static {
            try {
                f20035a[FooterButtonId.LIKE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f20035a[FooterButtonId.COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f20035a[FooterButtonId.SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: action_is_highlighted */
    public class State {
        public EnumMap<FooterButtonId, TouchSpring> f20036a;
        public boolean f20037b;

        public State(EnumMap<FooterButtonId, TouchSpring> enumMap, boolean z) {
            this.f20036a = enumMap;
            this.f20037b = z;
        }
    }

    private static MediaMetadataFooterPartDefinition m23221b(InjectorLike injectorLike) {
        return new MediaMetadataFooterPartDefinition(IdBasedProvider.a(injectorLike, 3736), FooterButtonClickListenerPartDefinition.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 2347));
    }

    public final Object m23222a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean g;
        boolean c;
        final MediaMetadata mediaMetadata = (MediaMetadata) obj;
        final HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        boolean z = false;
        subParts.a(this.f20041b, new ButtonClickedListener(this) {
            final /* synthetic */ MediaMetadataFooterPartDefinition f20034c;

            public final void m23215a(View view, FooterButtonId footerButtonId) {
                MediaMetadataFooterPartDefinition mediaMetadataFooterPartDefinition = this.f20034c;
                MediaMetadata mediaMetadata = mediaMetadata;
                HasPersistentState hasPersistentState = hasPersistentState;
                switch (C17332.f20035a[footerButtonId.ordinal()]) {
                    case 1:
                        MediaMetadataFooterPartDefinition.m23219a(mediaMetadata, hasPersistentState);
                        view.sendAccessibilityEvent(8);
                        return;
                    case 2:
                        MediaMetadataFooterPartDefinition.m23217a(view, mediaMetadata, hasPersistentState);
                        return;
                    case 3:
                        mediaMetadataFooterPartDefinition.f20043d.a(null, ((IFeedIntentBuilder) mediaMetadataFooterPartDefinition.f20044e.get()).a(mediaMetadata.d(), ComposerSourceType.PHOTOS_FEED).setIsFireAndForget(true).a(), mediaMetadataFooterPartDefinition.f20042c);
                        return;
                    default:
                        return;
                }
            }
        });
        EnumMap enumMap = (EnumMap) hasPersistentState.a(new FooterButtonAndTouchSpringKey(mediaMetadata.d()), new CacheableEntityWrapper(mediaMetadata.d()));
        SimpleMediaFeedbackModel C = mediaMetadata.C();
        if (C != null) {
            g = C.g();
            c = C.c();
            z = C.k();
        } else {
            c = false;
            g = false;
        }
        FooterBinderUtil.a(g, c, m23220a(mediaMetadata), enumMap, this.f20040a);
        return new State(enumMap, z);
    }

    public final /* bridge */ /* synthetic */ void m23223a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1658601651);
        m23218a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1008612516, a);
    }

    public static MediaMetadataFooterPartDefinition m23216a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaMetadataFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20039g) {
                MediaMetadataFooterPartDefinition mediaMetadataFooterPartDefinition;
                if (a2 != null) {
                    mediaMetadataFooterPartDefinition = (MediaMetadataFooterPartDefinition) a2.a(f20039g);
                } else {
                    mediaMetadataFooterPartDefinition = f20038f;
                }
                if (mediaMetadataFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23221b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20039g, b3);
                        } else {
                            f20038f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaMetadataFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MediaMetadataFooterPartDefinition(Provider<TouchSpring> provider, FooterButtonClickListenerPartDefinition footerButtonClickListenerPartDefinition, Context context, ComposerLauncher composerLauncher, Lazy<IFeedIntentBuilder> lazy) {
        this.f20040a = provider;
        this.f20041b = footerButtonClickListenerPartDefinition;
        this.f20042c = context;
        this.f20043d = composerLauncher;
        this.f20044e = lazy;
    }

    private static void m23218a(State state, V v) {
        ((Footer) v).setButtons(state.f20036a.keySet());
        ((Footer) v).setSprings(state.f20036a);
        ((Footer) v).setIsLiked(state.f20037b);
    }

    public final void m23224b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((Footer) view).a();
    }

    public static void m23219a(MediaMetadata mediaMetadata, E e) {
        ((CanLikePhotosFeedImage) e).mo1485a(PhotosMetadataConversionHelper.a(mediaMetadata.C()));
    }

    public static void m23217a(View view, MediaMetadata mediaMetadata, E e) {
        ((CanLaunchPhotosFeedFlyout) e).mo1484a(PhotosMetadataConversionHelper.a(mediaMetadata.C()), view, FlyoutLauncher$FlyoutContext.PHOTOS_FEED_FOOTER);
    }

    public static boolean m23220a(MediaMetadata mediaMetadata) {
        return mediaMetadata.q() || mediaMetadata.u();
    }
}

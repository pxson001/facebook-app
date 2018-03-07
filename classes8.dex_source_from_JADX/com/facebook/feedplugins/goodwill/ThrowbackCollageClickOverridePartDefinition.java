package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.collage.CollageItem;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.collage.ui.CollageAttachmentView.OnImageClickListener;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_share_composer_open */
public class ThrowbackCollageClickOverridePartDefinition extends BaseSinglePartDefinition<Void, OnImageClickListener<StoryCollageItem>, AnyEnvironment, CollageAttachmentView> {
    private static ThrowbackCollageClickOverridePartDefinition f12371c;
    private static final Object f12372d = new Object();
    public final MediaGalleryLauncher f12373a;
    public final MediaGalleryLauncherParamsFactory f12374b;

    /* compiled from: goodwill_throwback_share_composer_open */
    public class C13061 implements OnImageClickListener<StoryCollageItem> {
        final /* synthetic */ ThrowbackCollageClickOverridePartDefinition f12370a;

        public C13061(ThrowbackCollageClickOverridePartDefinition throwbackCollageClickOverridePartDefinition) {
            this.f12370a = throwbackCollageClickOverridePartDefinition;
        }

        public final void m14300a(CollageAttachmentView collageAttachmentView, CollageItem collageItem, int i) {
            StoryCollageItem storyCollageItem = (StoryCollageItem) collageItem;
            MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory = this.f12370a.f12374b;
            this.f12370a.f12373a.a(collageAttachmentView.getContext(), MediaGalleryLauncherParamsFactory.a((GraphQLStoryAttachment) storyCollageItem.a.a).a(FullscreenGallerySource.NEWSFEED).b(), null);
        }
    }

    private static ThrowbackCollageClickOverridePartDefinition m14302b(InjectorLike injectorLike) {
        return new ThrowbackCollageClickOverridePartDefinition((MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike), MediaGalleryLauncherParamsFactory.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m14304a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2090927219);
        ((CollageAttachmentView) view).u = (OnImageClickListener) obj2;
        Logger.a(8, EntryType.MARK_POP, 644915031, a);
    }

    public final void m14305b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((CollageAttachmentView) view).u = null;
    }

    @Inject
    public ThrowbackCollageClickOverridePartDefinition(MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory) {
        this.f12373a = mediaGalleryLauncher;
        this.f12374b = mediaGalleryLauncherParamsFactory;
    }

    public static ThrowbackCollageClickOverridePartDefinition m14301a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackCollageClickOverridePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12372d) {
                ThrowbackCollageClickOverridePartDefinition throwbackCollageClickOverridePartDefinition;
                if (a2 != null) {
                    throwbackCollageClickOverridePartDefinition = (ThrowbackCollageClickOverridePartDefinition) a2.a(f12372d);
                } else {
                    throwbackCollageClickOverridePartDefinition = f12371c;
                }
                if (throwbackCollageClickOverridePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14302b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12372d, b3);
                        } else {
                            f12371c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackCollageClickOverridePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m14303a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new C13061(this);
    }
}

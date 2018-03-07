package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.ui.FlyoutLauncher$FlyoutContext;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationBuilder;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
import com.facebook.graphql.model.GraphQLFeedback;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

@ContextScoped
/* compiled from: action_location */
public class MediaMetadataBlingBarPartDefinition<E extends CanLaunchPhotosFeedFlyout & HasPersistentState & HasPositionInformation> extends BaseSinglePartDefinition<MediaMetadata, Void, E, DefaultBlingBarView> {
    private static MediaMetadataBlingBarPartDefinition f20027d;
    private static final Object f20028e = new Object();
    private final BackgroundPartDefinition f20029a;
    private final BlingBarAnimationsPartDefinition f20030b;
    private final ClickListenerPartDefinition f20031c;

    private static MediaMetadataBlingBarPartDefinition m23213b(InjectorLike injectorLike) {
        return new MediaMetadataBlingBarPartDefinition(BackgroundPartDefinition.a(injectorLike), BlingBarAnimationsPartDefinition.m25422a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m23214a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        final CanLaunchPhotosFeedFlyout canLaunchPhotosFeedFlyout = (CanLaunchPhotosFeedFlyout) anyEnvironment;
        final GraphQLFeedback a = PhotosMetadataConversionHelper.a(mediaMetadata.C());
        subParts.a(this.f20029a, new StylingData(BlingBarRootPartDefinition.f22896a));
        BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition = this.f20030b;
        CacheableEntityWrapper cacheableEntityWrapper = new CacheableEntityWrapper(mediaMetadata.d());
        String str = getClass() + mediaMetadata.d();
        if (BlingBarAnimationBuilder.m25411b(a) > 0 || BlingBarAnimationBuilder.m25409a(a) > 0) {
            z = true;
        } else {
            z = false;
        }
        subParts.a(blingBarAnimationsPartDefinition, new Props(cacheableEntityWrapper, a, str, z));
        subParts.a(this.f20031c, new OnClickListener(this) {
            final /* synthetic */ MediaMetadataBlingBarPartDefinition f20026c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -451171197);
                canLaunchPhotosFeedFlyout.mo1484a(a, view, FlyoutLauncher$FlyoutContext.PHOTOS_FEED_BLINGBAR);
                Logger.a(2, EntryType.UI_INPUT_END, 869756714, a);
            }
        });
        return null;
    }

    @Inject
    public MediaMetadataBlingBarPartDefinition(BackgroundPartDefinition backgroundPartDefinition, BlingBarAnimationsPartDefinition blingBarAnimationsPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f20029a = backgroundPartDefinition;
        this.f20030b = blingBarAnimationsPartDefinition;
        this.f20031c = clickListenerPartDefinition;
    }

    public static MediaMetadataBlingBarPartDefinition m23212a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MediaMetadataBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20028e) {
                MediaMetadataBlingBarPartDefinition mediaMetadataBlingBarPartDefinition;
                if (a2 != null) {
                    mediaMetadataBlingBarPartDefinition = (MediaMetadataBlingBarPartDefinition) a2.a(f20028e);
                } else {
                    mediaMetadataBlingBarPartDefinition = f20027d;
                }
                if (mediaMetadataBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23213b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20028e, b3);
                        } else {
                            f20027d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mediaMetadataBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

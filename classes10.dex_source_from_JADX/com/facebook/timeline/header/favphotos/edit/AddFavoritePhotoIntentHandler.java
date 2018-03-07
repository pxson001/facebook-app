package com.facebook.timeline.header.favphotos.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverWindow.OnCancelListener;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.favmediapicker.ui.FavoriteMediaPickerActivity;
import com.facebook.timeline.header.controllers.TimelineHeaderImagesController;
import com.facebook.timeline.logging.TimelineAnalyticsLogger;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fetch_single_theme */
public class AddFavoritePhotoIntentHandler {
    public final long f11767a;
    public final Bundle f11768b;
    public final QeAccessor f11769c;
    public final TimelineAnalyticsLogger f11770d;
    public final Provider<SecureContextHelper> f11771e;
    public final Provider<IFeedIntentBuilder> f11772f;
    public final Lazy<TimelineHeaderImagesController> f11773g;
    public final Context f11774h;
    public Intent f11775i;
    public Intent f11776j;
    public OnMenuItemClickListener f11777k;
    public OnMenuItemClickListener f11778l;

    @Inject
    public AddFavoritePhotoIntentHandler(@Assisted Context context, @Assisted Bundle bundle, QeAccessor qeAccessor, TimelineAnalyticsLogger timelineAnalyticsLogger, Provider<SecureContextHelper> provider, Provider<IFeedIntentBuilder> provider2, Lazy<TimelineHeaderImagesController> lazy, Provider<String> provider3) {
        this.f11767a = Long.parseLong((String) provider3.get());
        this.f11768b = bundle;
        this.f11769c = qeAccessor;
        this.f11770d = timelineAnalyticsLogger;
        this.f11771e = provider;
        this.f11772f = provider2;
        this.f11774h = context;
        this.f11773g = lazy;
    }

    public final void m11844a(Fragment fragment, View view, @Nullable SizeAwareMedia sizeAwareMedia, OnCancelListener onCancelListener, OnDismissListener onDismissListener) {
        if (this.f11769c.a(ExperimentsForTimelineAbTestModule.I, false)) {
            ((SecureContextHelper) this.f11771e.get()).a(new Intent(fragment.getContext(), FavoriteMediaPickerActivity.class), 3, fragment);
        } else if (this.f11769c.a(ExperimentsForTimelineAbTestModule.ac, false) || sizeAwareMedia != null) {
            m11842b(fragment, view, sizeAwareMedia, onCancelListener, onDismissListener);
        } else {
            m11843d(this, fragment);
        }
    }

    private void m11842b(final Fragment fragment, View view, @Nullable final SizeAwareMedia sizeAwareMedia, OnCancelListener onCancelListener, OnDismissListener onDismissListener) {
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(view.getContext());
        figPopoverMenuWindow.I = onCancelListener;
        figPopoverMenuWindow.H = onDismissListener;
        PopoverMenu c = figPopoverMenuWindow.c();
        MenuItemImpl a = c.a(2131235039);
        if (this.f11777k == null) {
            this.f11777k = new OnMenuItemClickListener(this) {
                final /* synthetic */ AddFavoritePhotoIntentHandler f11761b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f11761b.f11770d.k(this.f11761b.f11767a);
                    AddFavoritePhotoIntentHandler.m11843d(this.f11761b, fragment);
                    return true;
                }
            };
        }
        a.setOnMenuItemClickListener(this.f11777k);
        a = c.a(2131234984);
        if (this.f11778l == null) {
            this.f11778l = new OnMenuItemClickListener(this) {
                final /* synthetic */ AddFavoritePhotoIntentHandler f11763b;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    this.f11763b.f11770d.l(this.f11763b.f11767a);
                    AddFavoritePhotoIntentHandler addFavoritePhotoIntentHandler = this.f11763b;
                    Fragment fragment = fragment;
                    SecureContextHelper secureContextHelper = (SecureContextHelper) addFavoritePhotoIntentHandler.f11771e.get();
                    if (addFavoritePhotoIntentHandler.f11776j == null) {
                        addFavoritePhotoIntentHandler.f11776j = SimplePickerIntent.a(addFavoritePhotoIntentHandler.f11774h, new Builder(SimplePickerSource.FAVORITE_PHOTOS).h().i().a(Action.NONE));
                    }
                    secureContextHelper.a(addFavoritePhotoIntentHandler.f11776j, 2, fragment);
                    return true;
                }
            };
        }
        a.setOnMenuItemClickListener(this.f11778l);
        if (sizeAwareMedia != null) {
            c.a(2131234973).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                final /* synthetic */ AddFavoritePhotoIntentHandler f11766c;

                public boolean onMenuItemClick(MenuItem menuItem) {
                    ImageRequest imageRequest;
                    this.f11766c.f11770d.o(this.f11766c.f11767a);
                    AddFavoritePhotoIntentHandler addFavoritePhotoIntentHandler = this.f11766c;
                    Fragment fragment = fragment;
                    SizeAwareMedia sizeAwareMedia = sizeAwareMedia;
                    if (sizeAwareMedia.g() == null || sizeAwareMedia.g().b() == null) {
                        imageRequest = null;
                    } else {
                        imageRequest = ImageRequest.a(sizeAwareMedia.g().b());
                    }
                    ((TimelineHeaderImagesController) addFavoritePhotoIntentHandler.f11773g.get()).m11683a(sizeAwareMedia.d(), null, imageRequest, sizeAwareMedia.g(), FullscreenGallerySource.TIMELINE_INTRO_CARD_FAV_PHOTO);
                    return true;
                }
            });
        }
        figPopoverMenuWindow.a(view);
    }

    public static void m11843d(AddFavoritePhotoIntentHandler addFavoritePhotoIntentHandler, Fragment fragment) {
        SecureContextHelper secureContextHelper = (SecureContextHelper) addFavoritePhotoIntentHandler.f11771e.get();
        if (addFavoritePhotoIntentHandler.f11775i == null) {
            addFavoritePhotoIntentHandler.f11775i = ((IFeedIntentBuilder) addFavoritePhotoIntentHandler.f11772f.get()).b(addFavoritePhotoIntentHandler.f11774h, StringFormatUtil.formatStrLocaleSafe(FBLinks.bn, Long.valueOf(addFavoritePhotoIntentHandler.f11767a)));
            addFavoritePhotoIntentHandler.f11775i.putExtra("pick_pic_lite", true);
            addFavoritePhotoIntentHandler.f11775i.putExtra("disable_camera_roll", true);
            Intent intent = addFavoritePhotoIntentHandler.f11775i;
            String str = "disable_tagged_media_set";
            boolean z = (addFavoritePhotoIntentHandler.f11768b.getBoolean("has_tagged_mediaset") && addFavoritePhotoIntentHandler.f11769c.a(ExperimentsForTimelineAbTestModule.al, false)) ? false : true;
            intent.putExtra(str, z);
            addFavoritePhotoIntentHandler.f11775i.putExtra("land_on_uploads_tab", addFavoritePhotoIntentHandler.f11768b.getBoolean("land_on_uploads_tab", false));
            addFavoritePhotoIntentHandler.f11775i.putExtra("title", addFavoritePhotoIntentHandler.f11774h.getString(2131235028));
        }
        secureContextHelper.a(addFavoritePhotoIntentHandler.f11775i, 1, fragment);
    }
}

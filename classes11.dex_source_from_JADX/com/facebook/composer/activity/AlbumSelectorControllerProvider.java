package com.facebook.composer.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.composer.activity.AlbumSelectorActivity.C07481;
import com.facebook.composer.activity.AlbumSelectorActivity.C07492;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.photos.albumcreator.AlbumCreatorIntentBuilder;
import com.facebook.photos.albums.events.AlbumsEventBus;

/* compiled from: is_managed */
public class AlbumSelectorControllerProvider extends AbstractAssistedProvider<AlbumSelectorController> {
    public final AlbumSelectorController m7366a(C07492 c07492, C07481 c07481, Fragment fragment, ViewerContext viewerContext) {
        return new AlbumSelectorController(c07492, c07481, fragment, viewerContext, AlbumsEventBus.a(this), ComposerAnalyticsLogger.a(this), AlbumCreatorIntentBuilder.b(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), (Context) getInstance(Context.class), AllCapsTransformationMethod.b(this), IdBasedLazy.a(this, 5184));
    }
}

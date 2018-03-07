package com.facebook.photos.simplepicker.controller;

import android.content.Context;
import android.database.Cursor;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.local.LocalMediaCursorMethodAutoProvider;
import com.facebook.photos.simplepicker.SimplePickerFragment.BitmapRenderedCallback;
import com.facebook.photos.simplepicker.autoplay.MediaPickerVideoAutoplayManager;
import com.facebook.photos.simplepicker.view.GridItemViewOnTouchListenerProvider;
import com.facebook.photos.simplepicker.view.PickerLongPressProgressBar;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.google.common.base.Optional;
import java.util.concurrent.ExecutorService;

/* compiled from: shared */
public class LegacySimplePickerGridViewCursorAdapterProvider extends AbstractAssistedProvider<LegacySimplePickerGridViewCursorAdapter> {
    public final LegacySimplePickerGridViewCursorAdapter m3096a(ThumbnailSource thumbnailSource, Cursor cursor, BitmapRenderedCallback bitmapRenderedCallback, PickerSelectionController pickerSelectionController, Optional<PickerLongPressProgressBar> optional, boolean z, boolean z2) {
        return new LegacySimplePickerGridViewCursorAdapter(thumbnailSource, cursor, bitmapRenderedCallback, pickerSelectionController, optional, z, z2, (Context) getInstance(Context.class, ForAppContext.class), LocalMediaCursorMethodAutoProvider.a(this), (GridItemViewOnTouchListenerProvider) getOnDemandAssistedProviderForStaticDi(GridItemViewOnTouchListenerProvider.class), (SequenceLogger) SequenceLoggerImpl.a(this), IdBasedSingletonScopeProvider.b(this, 494), SimplePickerGridViewUtil.m3142a(this), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(this), DefaultAndroidThreadUtil.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), MediaPickerVideoAutoplayManager.m2991a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), Photos360QEHelper.a(this));
    }
}

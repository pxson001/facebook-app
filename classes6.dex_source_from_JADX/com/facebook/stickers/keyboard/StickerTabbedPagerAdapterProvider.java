package com.facebook.stickers.keyboard;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.stickers.analytics.DownloadPreviewStickerPacksLogger;
import com.facebook.stickers.client.StickerAssetManager;
import com.facebook.stickers.service.MessagesStickerServiceGatekeepers;

/* compiled from: edit_photo_location */
public class StickerTabbedPagerAdapterProvider extends AbstractAssistedProvider<StickerTabbedPagerAdapter> {
    public final StickerTabbedPagerAdapter m24551a(Context context, LayoutInflater layoutInflater) {
        return new StickerTabbedPagerAdapter(ResourcesMethodAutoProvider.a(this), DefaultAppChoreographer.a(this), StickerAssetManager.m23925b(this), StickerKeyboardLogger.m24477b(this), DownloadPreviewStickerPacksLogger.m23891a((InjectorLike) this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), (StickerPackPageViewProvider) getOnDemandAssistedProviderForStaticDi(StickerPackPageViewProvider.class), context, layoutInflater, MessagesStickerServiceGatekeepers.b(this));
    }
}

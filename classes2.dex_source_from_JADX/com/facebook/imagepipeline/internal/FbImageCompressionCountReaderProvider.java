package com.facebook.imagepipeline.internal;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.datasensitivity.pref.DataSensitivitySettingsPrefUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsAnalyticsLogger;
import com.facebook.photos.progressiveimagequality.datausage.CompressionSavingsStorageHandler;
import java.io.InputStream;

/* compiled from: org.torproject.android */
public class FbImageCompressionCountReaderProvider extends AbstractAssistedProvider<FbImageCompressionCountReader> {
    public final FbImageCompressionCountReader m16006a(Uri uri, InputStream inputStream, CallerContext callerContext) {
        return new FbImageCompressionCountReader(CompressionSavingsStorageHandler.a(this), CompressionSavingsAnalyticsLogger.a(this), DataSensitivitySettingsPrefUtil.m8604a((InjectorLike) this), FbNetworkManager.m3811a((InjectorLike) this), uri, inputStream, callerContext);
    }
}

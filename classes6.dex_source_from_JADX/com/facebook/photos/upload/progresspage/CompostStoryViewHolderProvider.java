package com.facebook.photos.upload.progresspage;

import android.content.Context;
import android.view.View;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: getSignatureFingerprint */
public class CompostStoryViewHolderProvider extends AbstractAssistedProvider<CompostStoryViewHolder> {
    public final CompostStoryViewHolder m21675a(Context context, View view) {
        return new CompostStoryViewHolder(context, view, CompostStoryViewUtil.m21676b(this), FbNetworkManager.a(this), PendingStoryStore.a(this), (TimeFormatUtil) DefaultTimeFormatUtil.a(this), ViewPermalinkIntentFactory.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this), CompostAnalyticsLogger.m21244b((InjectorLike) this), IdBasedLazy.a(this, 3595), IdBasedSingletonScopeProvider.b(this, 2436), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

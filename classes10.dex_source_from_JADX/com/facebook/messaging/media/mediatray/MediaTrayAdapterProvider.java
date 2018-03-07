package com.facebook.messaging.media.mediatray;

import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.messaging.photoreminders.PhotoRemindersGatingUtil;
import com.facebook.messaging.photoreminders.PhotoRemindersLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: security_checkup */
public class MediaTrayAdapterProvider extends AbstractAssistedProvider<MediaTrayAdapter> {
    public final MediaTrayAdapter m3015a(ImmutableList<MediaTrayLoader$Item> immutableList) {
        return new MediaTrayAdapter(LayoutInflaterMethodAutoProvider.b(this), (MediaTrayItemViewHolderProvider) getOnDemandAssistedProviderForStaticDi(MediaTrayItemViewHolderProvider.class), new PhotoRemindersNuxController((Clock) SystemClockMethodAutoProvider.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), GatekeeperStoreImplMethodAutoProvider.a(this), LayoutInflaterMethodAutoProvider.b(this), PhotoRemindersGatingUtil.b(this), PhotoRemindersLogger.b(this), (PhotoRemindersNuxViewHolderProvider) getOnDemandAssistedProviderForStaticDi(PhotoRemindersNuxViewHolderProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), (SecureContextHelper) DefaultSecureContextHelper.a(this)), immutableList);
    }
}

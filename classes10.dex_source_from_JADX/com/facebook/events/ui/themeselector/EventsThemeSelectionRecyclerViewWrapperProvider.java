package com.facebook.events.ui.themeselector;

import android.content.Context;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: app_profile_image_size */
public class EventsThemeSelectionRecyclerViewWrapperProvider extends AbstractAssistedProvider<EventsThemeSelectionRecyclerViewWrapper> {
    public final EventsThemeSelectionRecyclerViewWrapper m19774a(String str, String str2, Integer num, String str3) {
        return new EventsThemeSelectionRecyclerViewWrapper(str, str2, num, str3, (Context) getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ScreenUtil.a(this), (ConnectionControllerBuilderProvider) getOnDemandAssistedProviderForStaticDi(ConnectionControllerBuilderProvider.class));
    }
}

package com.facebook.search.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;

/* compiled from: show_date */
public class SearchBarFormattedTooltipControllerProvider extends AbstractAssistedProvider<SearchBarFormattedTooltipController> {
    public final SearchBarFormattedTooltipController m8760a(View view, SearchAwarenessUnitProperties searchAwarenessUnitProperties, SearchAwarenessController searchAwarenessController) {
        SearchBarFormattedTooltipController searchBarFormattedTooltipController = new SearchBarFormattedTooltipController((Context) getInstance(Context.class), view, searchAwarenessUnitProperties, searchAwarenessController, SearchAwarenessOptOutController.a(this), Fb4aUriIntentMapper.m8640a((InjectorLike) this), DefaultSecureContextHelper.m4636a((InjectorLike) this), QeInternalImplMethodAutoProvider.m3744a(this), GatekeeperStoreImplMethodAutoProvider.m2131a(this), SearchAwarenessLogger.m12394b((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this));
        searchBarFormattedTooltipController.a = IdBasedProvider.m1811a(this, 10517);
        return searchBarFormattedTooltipController;
    }
}

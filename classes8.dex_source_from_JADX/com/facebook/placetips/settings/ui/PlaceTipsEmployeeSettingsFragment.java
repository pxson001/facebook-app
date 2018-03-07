package com.facebook.placetips.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.auth.annotations.IsMeUserAnEmployee;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.common.util.TriState;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.placetips.bootstrap.ConfidenceLevel;
import com.facebook.placetips.bootstrap.IsUserPlaceTipsDebugEmployee;
import com.facebook.placetips.bootstrap.PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.bootstrap.PresenceSource;
import com.facebook.placetips.bootstrap.PresenceSourceType;
import com.facebook.placetips.bootstrap.STATICDI_MULTIBIND_PROVIDER$PlaceTipsDebugStatusDataProvider;
import com.facebook.placetips.presence.PagePresenceManager;
import com.facebook.placetips.presence.PagePresenceManager$PresenceUpdateBuilder;
import com.facebook.placetips.presence.PlaceTipsHeaderUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: captcha/validations */
public class PlaceTipsEmployeeSettingsFragment extends FbFragment {
    @Inject
    @IsMeUserAnEmployee
    Provider<TriState> f18437a;
    @Inject
    @IsUserPlaceTipsDebugEmployee
    Provider<Boolean> f18438b;
    @Inject
    DefaultAndroidThreadUtil f18439c;
    @Inject
    Provider<Set<PlaceTipsDebugStatusDataProvider>> f18440d;
    @Inject
    public Lazy<PagePresenceManager> f18441e;
    @Inject
    public Lazy<SecureContextHelper> f18442f;
    public TextView f18443g;
    private Button f18444h;

    /* compiled from: captcha/validations */
    class C20221 implements OnClickListener {
        final /* synthetic */ PlaceTipsEmployeeSettingsFragment f18432a;

        C20221(PlaceTipsEmployeeSettingsFragment placeTipsEmployeeSettingsFragment) {
            this.f18432a = placeTipsEmployeeSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1487506527);
            PlaceTipsEmployeeSettingsFragment.m22373b(this.f18432a);
            Logger.a(2, EntryType.UI_INPUT_END, 382774437, a);
        }
    }

    /* compiled from: captcha/validations */
    class C20232 implements OnClickListener {
        final /* synthetic */ PlaceTipsEmployeeSettingsFragment f18433a;

        C20232(PlaceTipsEmployeeSettingsFragment placeTipsEmployeeSettingsFragment) {
            this.f18433a = placeTipsEmployeeSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -609301991);
            PlaceTipsEmployeeSettingsFragment placeTipsEmployeeSettingsFragment = this.f18433a;
            Builder newBuilder = PlacePickerConfiguration.newBuilder();
            newBuilder.p = SearchType.PLACE_TIPS_EMPLOYEE_SETTINGS;
            ((SecureContextHelper) placeTipsEmployeeSettingsFragment.f18442f.get()).a(CheckinIntentCreator.a(placeTipsEmployeeSettingsFragment.getContext(), newBuilder.a()), 1, placeTipsEmployeeSettingsFragment);
            Logger.a(2, EntryType.UI_INPUT_END, -1099225496, a);
        }
    }

    /* compiled from: captcha/validations */
    class C20243 implements OnClickListener {
        final /* synthetic */ PlaceTipsEmployeeSettingsFragment f18434a;

        C20243(PlaceTipsEmployeeSettingsFragment placeTipsEmployeeSettingsFragment) {
            this.f18434a = placeTipsEmployeeSettingsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1974501772);
            ((PagePresenceManager) this.f18434a.f18441e.get()).a(PresenceSourceType.INJECT);
            Logger.a(2, EntryType.UI_INPUT_END, -604384563, a);
        }
    }

    public static void m22371a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlaceTipsEmployeeSettingsFragment) obj).m22372a(IdBasedProvider.a(fbInjector, 640), IdBasedProvider.a(fbInjector, 4262), DefaultAndroidThreadUtil.b(fbInjector), new STATICDI_MULTIBIND_PROVIDER$PlaceTipsDebugStatusDataProvider(fbInjector.getScopeAwareInjector()), IdBasedSingletonScopeProvider.b(fbInjector, 3009), IdBasedSingletonScopeProvider.b(fbInjector, 968));
    }

    private void m22372a(Provider<TriState> provider, Provider<Boolean> provider2, AndroidThreadUtil androidThreadUtil, Provider<Set<PlaceTipsDebugStatusDataProvider>> provider3, Lazy<PagePresenceManager> lazy, Lazy<SecureContextHelper> lazy2) {
        this.f18437a = provider;
        this.f18438b = provider2;
        this.f18439c = androidThreadUtil;
        this.f18440d = provider3;
        this.f18441e = lazy;
        this.f18442f = lazy2;
    }

    public final void m22377c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlaceTipsEmployeeSettingsFragment.class;
        m22371a((Object) this, getContext());
    }

    public final View m22374a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2043446848);
        if (((TriState) this.f18437a.get()).asBoolean(false) && ((Boolean) this.f18438b.get()).booleanValue()) {
            View inflate = layoutInflater.inflate(2130906281, viewGroup, false);
            LogUtils.f(-1860824707, a);
            return inflate;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -777457434, a);
        return null;
    }

    public final void m22376a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.T != null) {
            this.f18443g = (TextView) e(2131566044);
            this.f18444h = (Button) e(2131566042);
            e(2131566041).setOnClickListener(new C20221(this));
            this.f18444h.setOnClickListener(new C20232(this));
            e(2131566043).setOnClickListener(new C20243(this));
            m22373b(this);
        }
    }

    public final void m22375a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
            PagePresenceManager$PresenceUpdateBuilder a = ((PagePresenceManager) this.f18441e.get()).a(PresenceSource.m3710a(PresenceSourceType.INJECT));
            a.f3883c = checkinPlaceModel.cf_();
            a = a;
            a.f3884d = checkinPlaceModel.j();
            a = a;
            a.f3896p = ConfidenceLevel.HIGH;
            a = a;
            a.f3887g = PlaceTipsHeaderUtil.m3874a(checkinPlaceModel.j(), "You are pretending to be at %s");
            a.m3872a();
        }
    }

    public static void m22373b(PlaceTipsEmployeeSettingsFragment placeTipsEmployeeSettingsFragment) {
        final Set set = (Set) placeTipsEmployeeSettingsFragment.f18440d.get();
        placeTipsEmployeeSettingsFragment.f18439c.a(new FbAsyncTask<Void, Void, CharSequence>(placeTipsEmployeeSettingsFragment) {
            final /* synthetic */ PlaceTipsEmployeeSettingsFragment f18436b;

            protected void onPostExecute(Object obj) {
                this.f18436b.f18443g.setText((CharSequence) obj);
            }

            protected final Object m22370a(Object[] objArr) {
                Object obj = null;
                for (PlaceTipsDebugStatusDataProvider placeTipsDebugStatusDataProvider : set) {
                    if (obj == null) {
                        obj = placeTipsDebugStatusDataProvider.a();
                    } else {
                        obj = TextUtils.concat(new CharSequence[]{obj, "\n\n", placeTipsDebugStatusDataProvider.a()});
                    }
                }
                return obj;
            }
        }, new Void[0]);
    }
}

package com.facebook.places.create;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: cbe4ecd92bb699d73e88c3f856d26e54 */
public class PlaceCreationDupActivity extends FbFragmentActivity implements OnItemClickListener {
    @Inject
    PlaceCreationDupAdapter f18195p;
    @Inject
    BellerophonLogger f18196q;
    private ComposerTitleBar f18197r;
    private BetterListView f18198s;
    private ArrayList<CheckinPlace> f18199t;
    private BellerophonLoggerData f18200u;
    private final OnToolbarButtonListener f18201v = new C19761(this);

    /* compiled from: cbe4ecd92bb699d73e88c3f856d26e54 */
    class C19761 extends OnToolbarButtonListener {
        final /* synthetic */ PlaceCreationDupActivity f18193a;

        C19761(PlaceCreationDupActivity placeCreationDupActivity) {
            this.f18193a = placeCreationDupActivity;
        }

        public final void m22160a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            PlaceCreationDupActivity.m22167j(this.f18193a);
        }
    }

    /* compiled from: cbe4ecd92bb699d73e88c3f856d26e54 */
    class C19772 implements OnBackPressedListener {
        final /* synthetic */ PlaceCreationDupActivity f18194a;

        C19772(PlaceCreationDupActivity placeCreationDupActivity) {
            this.f18194a = placeCreationDupActivity;
        }

        public final void m22161a() {
            this.f18194a.onBackPressed();
        }
    }

    private static <T extends Context> void m22164a(Class<T> cls, T t) {
        m22165a((Object) t, (Context) t);
    }

    public static void m22165a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PlaceCreationDupActivity) obj).m22163a(new PlaceCreationDupAdapter((Context) injectorLike.getInstance(Context.class), LayoutInflaterMethodAutoProvider.b(injectorLike), LocaleMethodAutoProvider.b(injectorLike)), BellerophonLogger.m22100b(injectorLike));
    }

    public final void m22168b(Bundle bundle) {
        super.b(bundle);
        this.f18199t = (ArrayList) FlatBufferModelHelper.b(getIntent(), "possible_dup_places");
        Class cls = PlaceCreationDupActivity.class;
        m22165a((Object) this, (Context) this);
        setContentView(2130906246);
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(-1));
        this.f18200u = (BellerophonLoggerData) getIntent().getParcelableExtra("bellerophon_logger_data");
        this.f18196q.f18119a = this.f18200u;
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C19772(this));
        String i = m22166i();
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = i;
        StateBuilder stateBuilder2 = stateBuilder;
        stateBuilder2.d = HarrisonPlusIconType.c();
        this.f18197r = new ComposerTitleBar(composerBaseTitleBar, stateBuilder2.a());
        ComposerTitleBar composerTitleBar = this.f18197r;
        stateBuilder2 = this.f18197r.b.a();
        Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131235217);
        stateBuilder2.b = a.a();
        stateBuilder2 = stateBuilder2;
        stateBuilder2.c = this.f18201v;
        composerTitleBar.a(stateBuilder2.a());
        this.f18198s = (BetterListView) findViewById(16908298);
        this.f18198s.setAdapter(this.f18195p);
        this.f18198s.setEmptyView(null);
        this.f18198s.setOnItemClickListener(this);
        BaseAdapter baseAdapter = this.f18195p;
        baseAdapter.f18205d = ImmutableList.copyOf(this.f18199t);
        AdapterDetour.a(baseAdapter, 1224537580);
        AdapterDetour.a(this.f18195p, 1332339325);
    }

    private String m22166i() {
        return getString(2131235230);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) this.f18198s.getAdapter().getItem(i);
        this.f18196q.m22101a(checkinPlaceModel.cf_());
        Intent intent = new Intent();
        intent.putExtra("continue_place_creation", false);
        FlatBufferModelHelper.a(intent, "select_existing_place", checkinPlaceModel);
        setResult(-1, intent);
        finish();
    }

    public static void m22167j(PlaceCreationDupActivity placeCreationDupActivity) {
        placeCreationDupActivity.f18196q.m22103c();
        Intent intent = new Intent();
        intent.putExtra("continue_place_creation", true);
        placeCreationDupActivity.setResult(-1, intent);
        placeCreationDupActivity.finish();
    }

    private void m22163a(PlaceCreationDupAdapter placeCreationDupAdapter, BellerophonLogger bellerophonLogger) {
        this.f18195p = placeCreationDupAdapter;
        this.f18196q = bellerophonLogger;
    }

    public void onBackPressed() {
        this.f18196q.m22104d();
        super.onBackPressed();
    }
}

package com.facebook.places.create.citypicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: see_more_tap */
public class CityPickerActivity extends FbFragmentActivity implements TextWatcher, OnItemClickListener {
    private final FutureCallback<ArrayList<CheckinPlace>> f3544A = new C04523(this);
    @Inject
    CityPickerAdapter f3545p;
    @Inject
    FetchCityRunner f3546q;
    private BetterListView f3547r;
    private ComposerTitleBar f3548s;
    private EditText f3549t;
    private Location f3550u;
    public ArrayList<CheckinPlace> f3551v;
    private String f3552w;
    private FrameLayout f3553x;
    private LazyView<FrameLayout> f3554y;
    private String f3555z;

    /* compiled from: see_more_tap */
    class C04491 implements OnBackPressedListener {
        final /* synthetic */ CityPickerActivity f3540a;

        C04491(CityPickerActivity cityPickerActivity) {
            this.f3540a = cityPickerActivity;
        }

        public final void m3468a() {
            this.f3540a.onBackPressed();
        }
    }

    /* compiled from: see_more_tap */
    class C04512 implements OnInflateRunner {
        final /* synthetic */ CityPickerActivity f3542a;

        /* compiled from: see_more_tap */
        class C04501 implements OnClickListener {
            final /* synthetic */ C04512 f3541a;

            C04501(C04512 c04512) {
                this.f3541a = c04512;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -613098158);
                this.f3541a.f3542a.m3478i();
                Logger.a(2, EntryType.UI_INPUT_END, -214071419, a);
            }
        }

        C04512(CityPickerActivity cityPickerActivity) {
            this.f3542a = cityPickerActivity;
        }

        public final void m3469a(View view) {
            view.findViewById(2131565969).setOnClickListener(new C04501(this));
        }
    }

    /* compiled from: see_more_tap */
    class C04523 implements FutureCallback<ArrayList<CheckinPlace>> {
        final /* synthetic */ CityPickerActivity f3543a;

        C04523(CityPickerActivity cityPickerActivity) {
            this.f3543a = cityPickerActivity;
        }

        public void onSuccess(Object obj) {
            this.f3543a.f3551v = (ArrayList) obj;
            this.f3543a.f3545p.m3480a(this.f3543a.f3551v);
            AdapterDetour.a(this.f3543a.f3545p, -1558105395);
        }

        public void onFailure(Throwable th) {
        }
    }

    private static <T extends Context> void m3473a(Class<T> cls, T t) {
        m3474a((Object) t, (Context) t);
    }

    public static void m3474a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((CityPickerActivity) obj).m3472a(new CityPickerAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector)), FetchCityRunner.m3486b(fbInjector));
    }

    private void m3472a(CityPickerAdapter cityPickerAdapter, FetchCityRunner fetchCityRunner) {
        this.f3545p = cityPickerAdapter;
        this.f3546q = fetchCityRunner;
    }

    public final void m3477b(Bundle bundle) {
        Class cls = CityPickerActivity.class;
        m3474a((Object) this, (Context) this);
        setContentView(2130903571);
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(-1));
        if (bundle == null) {
            this.f3552w = "";
            this.f3551v = Lists.a();
        } else {
            this.f3552w = bundle.getString("state_query");
            this.f3551v = (ArrayList) FlatBufferModelHelper.b(bundle, "state_current_list");
        }
        this.f3550u = (Location) getIntent().getParcelableExtra("extra_location");
        this.f3555z = getIntent().getStringExtra("previously_tagged_location");
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(new C04491(this));
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = getResources().getString(2131235254);
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        this.f3548s = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
        this.f3549t = (EditText) ((FrameLayout) findViewById(2131560319)).findViewById(2131559133);
        this.f3549t.addTextChangedListener(this);
        this.f3547r = (BetterListView) findViewById(16908298);
        this.f3547r.setAdapter(this.f3545p);
        this.f3547r.setEmptyView(null);
        this.f3547r.setOnItemClickListener(this);
        this.f3545p.m3480a(this.f3551v);
        AdapterDetour.a(this.f3545p, 1610671261);
        if (this.f3551v.isEmpty()) {
            m3475j();
        }
        this.f3554y = new LazyView((ViewStub) a(2131560320), new C04512(this));
        if (this.f3555z != null) {
            m3476k();
        }
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 67919602);
        super.onPause();
        KeyboardUtils.a(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 948817872, a);
    }

    private void m3475j() {
        this.f3546q.m3487a();
        this.f3546q.m3488a(new FetchCityParam(this.f3552w, this.f3550u), this.f3544A);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("state_query", this.f3552w);
        FlatBufferModelHelper.a(bundle, "state_current_list", this.f3551v);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) this.f3547r.getAdapter().getItem(i);
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "selected_city", checkinPlaceModel);
        setResult(-1, intent);
        finish();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        this.f3552w = editable.toString();
        m3475j();
    }

    private void m3476k() {
        if (this.f3555z != null) {
            this.f3553x = (FrameLayout) this.f3554y.a();
            ((TextView) this.f3553x.findViewById(2131565968)).setText(getString(2131235214, new Object[]{this.f3555z}));
            this.f3553x.setVisibility(0);
            this.f3553x.bringToFront();
        }
    }

    final void m3478i() {
        Intent intent = new Intent();
        intent.putExtra("extra_cleared_location", true);
        setResult(-1, intent);
        finish();
    }
}

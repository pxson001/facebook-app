package com.facebook.places.create.privacypicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.PrivacyOptionsResult;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.model.User;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: caption_title_extra_large_style */
public class PrivacyPickerActivity extends FbFragmentActivity implements OnItemClickListener {
    private final ResultFutureCallback<PrivacyOptionsResult> f18395A = new C20153(this);
    @Inject
    public PrivacyPickerAdapter f18396p;
    @Inject
    @LoggedInUser
    public Provider<User> f18397q;
    @Inject
    public PrivacyOperationsClient f18398r;
    @Inject
    public DefaultAndroidThreadUtil f18399s;
    private ComposerTitleBar f18400t;
    private BetterListView f18401u;
    private GraphQLPrivacyOption f18402v;
    private List<PrivacyPickerRowData> f18403w;
    private PrivacyOptionsResult f18404x;
    private final OnToolbarButtonListener f18405y = new C20131(this);
    private final OnBackPressedListener f18406z = new C20142(this);

    /* compiled from: caption_title_extra_large_style */
    class C20131 extends OnToolbarButtonListener {
        final /* synthetic */ PrivacyPickerActivity f18392a;

        C20131(PrivacyPickerActivity privacyPickerActivity) {
            this.f18392a = privacyPickerActivity;
        }

        public final void m22332a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            PrivacyPickerActivity.m22342j(this.f18392a);
        }
    }

    /* compiled from: caption_title_extra_large_style */
    class C20142 implements OnBackPressedListener {
        final /* synthetic */ PrivacyPickerActivity f18393a;

        C20142(PrivacyPickerActivity privacyPickerActivity) {
            this.f18393a = privacyPickerActivity;
        }

        public final void m22333a() {
            this.f18393a.onBackPressed();
        }
    }

    /* compiled from: caption_title_extra_large_style */
    class C20153 extends ResultFutureCallback<PrivacyOptionsResult> {
        final /* synthetic */ PrivacyPickerActivity f18394a;

        C20153(PrivacyPickerActivity privacyPickerActivity) {
            this.f18394a = privacyPickerActivity;
        }

        protected final void m22335a(Object obj) {
            PrivacyOptionsResult privacyOptionsResult = (PrivacyOptionsResult) obj;
            this.f18394a.f18399s.a();
            this.f18394a.m22338a(privacyOptionsResult);
        }

        protected final void m22334a(ServiceException serviceException) {
        }
    }

    private static <T extends Context> void m22339a(Class<T> cls, T t) {
        m22340a((Object) t, (Context) t);
    }

    public static void m22340a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PrivacyPickerActivity privacyPickerActivity = (PrivacyPickerActivity) obj;
        PrivacyPickerAdapter privacyPickerAdapter = new PrivacyPickerAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector), PrivacyIcons.a(fbInjector));
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        PrivacyOperationsClient a2 = PrivacyOperationsClient.a(fbInjector);
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(fbInjector);
        privacyPickerActivity.f18396p = privacyPickerAdapter;
        privacyPickerActivity.f18397q = a;
        privacyPickerActivity.f18398r = a2;
        privacyPickerActivity.f18399s = b;
    }

    public final void m22343b(Bundle bundle) {
        Class cls = PrivacyPickerActivity.class;
        m22340a((Object) this, (Context) this);
        setContentView(2130906398);
        getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(-1));
        if (bundle == null) {
            this.f18402v = (GraphQLPrivacyOption) FlatBufferModelHelper.a(getIntent(), "extra_initial_privacy");
        } else {
            this.f18402v = (GraphQLPrivacyOption) bundle.getParcelable("state_current_privacy");
        }
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) a(2131560528);
        composerBaseTitleBar.setOnBackPressedListener(this.f18406z);
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.a = getResources().getString(2131235257);
        stateBuilder = stateBuilder;
        stateBuilder.d = HarrisonPlusIconType.c();
        this.f18400t = new ComposerTitleBar(composerBaseTitleBar, stateBuilder.a());
        ComposerTitleBar composerTitleBar = this.f18400t;
        StateBuilder a = this.f18400t.b.a();
        Builder a2 = TitleBarButtonSpec.a();
        a2.g = getString(2131230752);
        a.b = a2.a();
        a = a;
        a.c = this.f18405y;
        composerTitleBar.a(a.a());
        this.f18401u = (BetterListView) findViewById(16908298);
        this.f18401u.setAdapter(this.f18396p);
        this.f18401u.setEmptyView(null);
        this.f18401u.setOnItemClickListener(this);
        this.f18403w = Lists.a();
        this.f18396p.m22345a(this.f18403w);
        AdapterDetour.a(this.f18396p, 631363767);
        m22341i();
    }

    private void m22338a(PrivacyOptionsResult privacyOptionsResult) {
        this.f18404x = privacyOptionsResult;
        ImmutableList immutableList = this.f18404x.basicPrivacyOptions;
        int size = immutableList.size();
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            PrivacyPickerRowData privacyPickerRowData = new PrivacyPickerRowData((GraphQLPrivacyOption) immutableList.get(i));
            if (PrivacyOptionHelper.a(privacyPickerRowData.f18410a, this.f18402v)) {
                privacyPickerRowData.f18411b = true;
                z2 = true;
            } else {
                z2 = z;
            }
            this.f18403w.add(privacyPickerRowData);
            i++;
            z = z2;
        }
        if (!z) {
            PrivacyPickerRowData privacyPickerRowData2 = new PrivacyPickerRowData(this.f18402v);
            privacyPickerRowData2.f18411b = true;
            this.f18403w.add(this.f18404x.basicPrivacyOptions.size(), privacyPickerRowData2);
        }
        ImmutableList immutableList2 = this.f18404x.friendListPrivacyOptions;
        i = immutableList2.size();
        for (int i2 = 0; i2 < i; i2++) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) immutableList2.get(i2);
            if (!PrivacyOptionHelper.a(graphQLPrivacyOption, this.f18402v)) {
                this.f18403w.add(new PrivacyPickerRowData(graphQLPrivacyOption));
            }
        }
        this.f18396p.m22345a(this.f18403w);
        AdapterDetour.a(this.f18396p, 334983499);
    }

    private void m22341i() {
        this.f18399s.a(this.f18398r.a(DataFreshnessParam.STALE_DATA_OKAY), this.f18395A);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("state_current_privacy", this.f18402v);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PrivacyPickerRowData privacyPickerRowData = (PrivacyPickerRowData) this.f18401u.getAdapter().getItem(i);
        if (!PrivacyOptionHelper.a(privacyPickerRowData.f18410a, this.f18402v)) {
            for (PrivacyPickerRowData privacyPickerRowData2 : this.f18403w) {
                if (PrivacyOptionHelper.a(privacyPickerRowData2.f18410a, this.f18402v)) {
                    privacyPickerRowData2.f18411b = false;
                }
            }
            this.f18402v = privacyPickerRowData.f18410a;
            privacyPickerRowData.f18411b = true;
            AdapterDetour.a(this.f18396p, 1292856049);
        }
    }

    public static void m22342j(PrivacyPickerActivity privacyPickerActivity) {
        Intent intent = new Intent();
        FlatBufferModelHelper.a(intent, "selected_privacy", privacyPickerActivity.f18402v);
        privacyPickerActivity.setResult(-1, intent);
        privacyPickerActivity.finish();
    }
}

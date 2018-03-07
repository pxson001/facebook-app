package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.view.View;
import com.facebook.backstage.consumption.BackstageNavigatorApi;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.consumption.StatusBarColorChanger;
import com.facebook.backstage.consumption.importflow.ImportFlowDataProvider.CallBack;
import com.facebook.backstage.ui.LazyView;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.InjectorLike;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManager;
import com.facebook.runtimepermissions.RuntimePermissionsManager.RuntimePermissionsListener;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: risk_last_4_ssn_fragment_tag */
public class ImportFlowLauncher {
    public static final String f4762a = ImportFlowLauncher.class.getSimpleName();
    private static final String[] f4763b = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    private final CallBack f4764c = new C04881(this);
    public final Context f4765d;
    private final ImportFlowDataProvider f4766e;
    private final RuntimePermissionsUtil f4767f;
    public Tooltip f4768g;
    public View f4769h;
    public LazyView<ImportFlowGridView> f4770i;
    public BackstageNavigatorApi f4771j;
    public StatusBarColorChanger f4772k;

    /* compiled from: risk_last_4_ssn_fragment_tag */
    class C04881 implements CallBack {
        final /* synthetic */ ImportFlowLauncher f4755a;

        C04881(ImportFlowLauncher importFlowLauncher) {
            this.f4755a = importFlowLauncher;
        }

        public final void mo153a(@Nullable ImmutableList<ImportMedia> immutableList) {
            if (immutableList == null) {
                BLog.b(ImportFlowLauncher.f4762a, "Error null results.");
                throw new RuntimeException("Something went wrong while querying local medias.");
            } else if (immutableList.isEmpty()) {
                if (this.f4755a.f4768g == null) {
                    this.f4755a.f4768g = new Tooltip(this.f4755a.f4765d);
                    this.f4755a.f4768g.b(2131239916);
                }
                this.f4755a.f4768g.a(this.f4755a.f4769h);
                this.f4755a.f4771j.m4492a(NavigationState.IMPORT, NavigationState.MAIN_LIST);
            } else {
                ((ImportFlowGridView) this.f4755a.f4770i.m5715a()).m4641a(immutableList, this.f4755a.f4771j, this.f4755a.f4772k);
            }
        }
    }

    public static ImportFlowLauncher m4647a(InjectorLike injectorLike) {
        return new ImportFlowLauncher((Context) injectorLike.getInstance(Context.class), ImportFlowDataProvider.m4619b(injectorLike), RuntimePermissionsUtil.b(injectorLike));
    }

    @Inject
    public ImportFlowLauncher(Context context, ImportFlowDataProvider importFlowDataProvider, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.f4765d = context;
        this.f4766e = importFlowDataProvider;
        this.f4767f = runtimePermissionsUtil;
    }

    public final void m4648a(ActivityRuntimePermissionsManager activityRuntimePermissionsManager, BackstageNavigatorApi backstageNavigatorApi, StatusBarColorChanger statusBarColorChanger, LazyView<ImportFlowGridView> lazyView, View view) {
        if (this.f4767f.a(f4763b)) {
            this.f4771j = backstageNavigatorApi;
            this.f4772k = statusBarColorChanger;
            this.f4769h = view;
            this.f4770i = lazyView;
            this.f4766e.m4620a();
            this.f4766e.m4621a(this.f4764c, false);
            return;
        }
        final ActivityRuntimePermissionsManager activityRuntimePermissionsManager2 = activityRuntimePermissionsManager;
        final BackstageNavigatorApi backstageNavigatorApi2 = backstageNavigatorApi;
        final StatusBarColorChanger statusBarColorChanger2 = statusBarColorChanger;
        final LazyView<ImportFlowGridView> lazyView2 = lazyView;
        final View view2 = view;
        activityRuntimePermissionsManager.a(f4763b, new RuntimePermissionsListener(this) {
            final /* synthetic */ ImportFlowLauncher f4761f;

            public final void m4644a() {
                this.f4761f.m4648a(activityRuntimePermissionsManager2, backstageNavigatorApi2, statusBarColorChanger2, lazyView2, view2);
            }

            public final void m4645a(String[] strArr, String[] strArr2) {
                Tooltip tooltip = new Tooltip(this.f4761f.f4765d);
                tooltip.a(this.f4761f.f4765d.getResources().getString(2131239922));
                tooltip.c(view2);
                tooltip.d();
            }

            public final void m4646b() {
                Tooltip tooltip = new Tooltip(this.f4761f.f4765d);
                tooltip.a(this.f4761f.f4765d.getResources().getString(2131239922));
                tooltip.c(view2);
                tooltip.d();
            }
        });
    }
}

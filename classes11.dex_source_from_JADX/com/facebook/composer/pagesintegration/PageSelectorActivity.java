package com.facebook.composer.pagesintegration;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.invariants.Invariants;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerPageData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.pages.PageInfo;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.protocol.FetchAllPagesResult;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;

/* compiled from: foreground_location_pingback_success */
public class PageSelectorActivity extends FbFragmentActivity implements AnalyticsActivity, UsesSimpleStringTitle {
    public static String f6841p = "extra_go_to_composer_when_page_selected";
    public static final CallerContext f6842q = CallerContext.a(PageSelectorActivity.class);
    public EmptyListViewItem f6843r;
    public View f6844s;
    public PageSelectorAdapter f6845t;
    public ListenableFuture<OperationResult> f6846u;
    public DefaultBlueServiceOperationFactory f6847v;
    public DefaultAndroidThreadUtil f6848w;
    public ComposerLauncher f6849x;

    /* compiled from: foreground_location_pingback_success */
    class C08561 implements OnClickListener {
        final /* synthetic */ PageSelectorActivity f6833a;

        C08561(PageSelectorActivity pageSelectorActivity) {
            this.f6833a = pageSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1341368549);
            this.f6833a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1141046861, a);
        }
    }

    /* compiled from: foreground_location_pingback_success */
    class C08572 implements OnItemClickListener {
        final /* synthetic */ PageSelectorActivity f6834a;

        C08572(PageSelectorActivity pageSelectorActivity) {
            this.f6834a = pageSelectorActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f6834a.m8174b(i);
        }
    }

    /* compiled from: foreground_location_pingback_success */
    class C08583 extends OperationResultFutureCallback {
        final /* synthetic */ PageSelectorActivity f6835a;

        C08583(PageSelectorActivity pageSelectorActivity) {
            this.f6835a = pageSelectorActivity;
        }

        public final void m8161a(Object obj) {
            FetchAllPagesResult fetchAllPagesResult = (FetchAllPagesResult) ((OperationResult) obj).k();
            this.f6835a.f6843r.a(false);
            this.f6835a.f6843r.setVisibility(8);
            if (fetchAllPagesResult.a.size() > 0) {
                this.f6835a.f6845t.m8165a(PageSelectorActivity.m8169a(fetchAllPagesResult.a));
                return;
            }
            Context applicationContext = this.f6835a.getApplicationContext();
            Context context = applicationContext;
            Toaster.a(context, applicationContext.getString(2131237365), 17, null, null, Toaster.a());
            this.f6835a.finish();
        }

        protected final void m8160a(ServiceException serviceException) {
            this.f6835a.f6843r.setVisibility(8);
            this.f6835a.f6843r.a(false);
            if (this.f6835a.f6844s.getVisibility() != 0) {
                this.f6835a.f6844s.setVisibility(0);
            }
        }

        protected final void m8162a(CancellationException cancellationException) {
            this.f6835a.f6846u = null;
        }
    }

    /* compiled from: foreground_location_pingback_success */
    class C08594 implements OnClickListener {
        final /* synthetic */ PageSelectorActivity f6836a;

        C08594(PageSelectorActivity pageSelectorActivity) {
            this.f6836a = pageSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 623307868);
            this.f6836a.f6844s.setVisibility(8);
            PageSelectorActivity.m8178j(this.f6836a);
            Logger.a(2, EntryType.UI_INPUT_END, 172753291, a);
        }
    }

    /* compiled from: foreground_location_pingback_success */
    class PageListItemView extends CustomViewGroup {
        private final TextView f6837a = ((TextView) getView(2131560588));
        private final FbDraweeView f6838b = ((FbDraweeView) getView(2131560587));

        public PageListItemView(Context context) {
            super(context);
            setContentView(2130903711);
        }

        public final void m8163a(PageInfo pageInfo) {
            this.f6837a.setText(pageInfo.pageName);
            this.f6838b.a(Uri.parse(pageInfo.squareProfilePicUrl), PageSelectorActivity.f6842q);
        }
    }

    /* compiled from: foreground_location_pingback_success */
    class PageSelectorAdapter extends BaseAdapter {
        private List<PageInfo> f6839a = RegularImmutableList.a;
        private final Context f6840b;

        public /* synthetic */ Object getItem(int i) {
            return m8164a(i);
        }

        PageSelectorAdapter(Context context) {
            this.f6840b = context;
        }

        public final void m8165a(List<PageInfo> list) {
            this.f6839a = list;
            AdapterDetour.a(this, -654472635);
        }

        public int getCount() {
            return this.f6839a.size();
        }

        public final PageInfo m8164a(int i) {
            if (i < this.f6839a.size()) {
                return (PageInfo) this.f6839a.get(i);
            }
            return null;
        }

        public long getItemId(int i) {
            if (i < this.f6839a.size()) {
                return ((PageInfo) this.f6839a.get(i)).pageId;
            }
            return Long.MIN_VALUE;
        }

        public boolean hasStableIds() {
            return true;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            view = (PageListItemView) view;
            Invariants.a(i <= this.f6839a.size(), "index is a not list index");
            if (view == null) {
                view = new PageListItemView(this.f6840b);
            }
            view.m8163a(m8164a(i));
            return view;
        }
    }

    private static <T extends Context> void m8171a(Class<T> cls, T t) {
        m8172a((Object) t, (Context) t);
    }

    public static void m8172a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageSelectorActivity pageSelectorActivity = (PageSelectorActivity) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(fbInjector);
        DefaultAndroidThreadUtil b2 = DefaultAndroidThreadUtil.b(fbInjector);
        ComposerLauncher composerLauncher = (ComposerLauncher) ComposerLauncherImpl.a(fbInjector);
        pageSelectorActivity.f6847v = b;
        pageSelectorActivity.f6848w = b2;
        pageSelectorActivity.f6849x = composerLauncher;
    }

    public final void m8181b(Bundle bundle) {
        super.b(bundle);
        Class cls = PageSelectorActivity.class;
        m8172a((Object) this, (Context) this);
        setContentView(2130903712);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131560590);
        fb4aTitleBar.a(new C08561(this));
        fb4aTitleBar.setTitle(2131234547);
        ListView listView = (ListView) a(16908298);
        listView.setOnItemClickListener(new C08572(this));
        this.f6843r = (EmptyListViewItem) a(2131560591);
        m8179k();
        this.f6845t = new PageSelectorAdapter(getApplicationContext());
        listView.setAdapter(this.f6845t);
        m8178j(this);
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -366192245);
        super.onResume();
        if (this.f6846u == null) {
            m8178j(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -104042193, a);
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1068351248);
        super.onPause();
        ListenableFuture listenableFuture = this.f6846u;
        if (!(listenableFuture == null || listenableFuture.isDone())) {
            listenableFuture.cancel(false);
            this.f6843r.a(false);
            this.f6843r.setVisibility(8);
            this.f6846u = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1934398580, a);
    }

    public static void m8178j(PageSelectorActivity pageSelectorActivity) {
        pageSelectorActivity.f6843r.setVisibility(0);
        pageSelectorActivity.f6843r.a(true);
        pageSelectorActivity.f6846u = BlueServiceOperationFactoryDetour.a(pageSelectorActivity.f6847v, "fetch_all_pages", new Bundle(), -149412398).a();
        pageSelectorActivity.f6848w.a(pageSelectorActivity.f6846u, new C08583(pageSelectorActivity));
    }

    private static List<PageInfo> m8169a(List<PageInfo> list) {
        List<PageInfo> a = Lists.a();
        for (PageInfo pageInfo : list) {
            if (pageInfo.a == null) {
                pageInfo.a = new ProfilePermissions(pageInfo.permission);
            }
            if (pageInfo.a.a(Permission.CREATE_CONTENT)) {
                a.add(pageInfo);
            }
        }
        return a;
    }

    private void m8179k() {
        this.f6844s = findViewById(2131560592);
        this.f6844s.setOnClickListener(new C08594(this));
    }

    public final String am_() {
        return "composer";
    }

    public final String m8180a() {
        return getString(2131237366);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        setResult(i2, intent);
        finish();
    }

    private void m8174b(int i) {
        PageInfo a = this.f6845t.m8164a(i);
        Builder builder = new Builder(a.pageId, TargetType.PAGE);
        builder.c = a.pageName;
        builder = builder;
        builder.f = true;
        builder = builder;
        builder.d = a.squareProfilePicUrl;
        ComposerTargetData a2 = builder.a();
        ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
        newBuilder.d = true;
        newBuilder = newBuilder;
        newBuilder.a = String.valueOf(a.pageId);
        newBuilder = newBuilder;
        newBuilder.g = a.pageName;
        newBuilder = newBuilder;
        newBuilder.b = a.accessToken;
        ViewerContext h = newBuilder.h();
        Intent intent = getIntent();
        if (intent.getBooleanExtra(f6841p, false)) {
            this.f6849x.a(intent.getStringExtra("extra_composer_internal_session_id"), ComposerConfiguration.a((ComposerConfiguration) intent.getParcelableExtra("extra_composer_configuration")).setInitialTargetData(a2).setInitialPageData(ComposerPageData.newBuilder().setPostAsPageViewerContext(h).a()).a(), 1756, this);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_composer_target_data", a2);
        intent2.putExtra("extra_actor_viewer_context", h);
        setResult(-1, intent2);
        finish();
    }
}

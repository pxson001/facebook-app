package com.facebook.katana.activity.profilelist;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.graphql.calls.CanViewerPostInputCanPost;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.CanViewerPostQuery.FetchCanViewerPostString;
import com.facebook.katana.activity.profilelist.CanViewerPostQueryModels.FetchCanViewerPostModel;
import com.facebook.katana.activity.profilelist.CanViewerPostQueryModels.FetchCanViewerPostModel.FriendsModel.NodesModel;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.FriendsQuery;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.conversion.FriendSuggestionsRunner;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.LazyView;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: underline_style */
public class FriendSingleSelectorActivity extends ProfileListActivity implements AnalyticsActivity {
    @Inject
    FriendSuggestionsRunner f1226A;
    private final String f1227D = "STATE_KEY_LIST_VIEWERS_CANNOT_POST";
    private LazyView<ProgressBar> f1228E;
    public ImmutableSet<Long> f1229F = RegularImmutableSet.a;
    private TextView f1230G;
    private View f1231H;
    protected QueryHandler f1232p;
    protected int f1233q;
    protected ImageView f1234r;
    protected TextView f1235s;
    protected String f1236t;
    @Inject
    AddressBookPeriodicRunner f1237u;
    @Inject
    FriendTimelineWallPostPrivacyFetcher f1238v;
    @Inject
    NameNormalizer f1239w;
    @Inject
    QeAccessor f1240x;
    @Inject
    GraphQLQueryExecutor f1241y;
    @Inject
    TasksManager f1242z;

    /* compiled from: underline_style */
    class C01112 implements Callable<ListenableFuture> {
        final /* synthetic */ FriendSingleSelectorActivity f1219a;

        public Object call() {
            return this.f1219a.f1241y.a(GraphQLRequest.a((FetchCanViewerPostString) new FetchCanViewerPostString().a("canPost", CanViewerPostInputCanPost.FALSE)));
        }

        C01112(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1219a = friendSingleSelectorActivity;
        }
    }

    /* compiled from: underline_style */
    class C01123 extends AbstractDisposableFutureCallback<GraphQLResult<FetchCanViewerPostModel>> {
        final /* synthetic */ FriendSingleSelectorActivity f1220a;

        C01123(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1220a = friendSingleSelectorActivity;
        }

        protected final void m1467a(@Nullable Object obj) {
            ImmutableList a = ((FetchCanViewerPostModel) ((GraphQLResult) obj).e).m1420a().m1415a();
            Builder builder = new Builder();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(Long.valueOf(Long.parseLong(((NodesModel) a.get(i)).m1411j())));
            }
            this.f1220a.f1229F = builder.b();
            FriendSingleSelectorActivity.m1479c(this.f1220a, false);
            ((SelectableProfileListNaiveCursorAdapter) this.f1220a.f1192B).f1217k = this.f1220a.f1229F;
            FriendSingleSelectorActivity.m1480j(this.f1220a);
        }

        protected final void m1468a(Throwable th) {
            FriendSingleSelectorActivity.m1479c(this.f1220a, true);
        }
    }

    /* compiled from: underline_style */
    class C01134 extends AbstractDisposableFutureCallback<ImmutableList<SimpleUserToken>> {
        final /* synthetic */ FriendSingleSelectorActivity f1221a;

        C01134(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1221a = friendSingleSelectorActivity;
        }

        protected final void m1469a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            int a = this.f1221a.f1240x.a(ExperimentsForComposerAbTestModule.v, 5);
            ImmutableList.Builder builder = ImmutableList.builder();
            int i = 0;
            while (i < a && i < immutableList.size()) {
                builder.c(immutableList.get(i));
                i++;
            }
            SelectableProfileListNaiveCursorAdapter selectableProfileListNaiveCursorAdapter = (SelectableProfileListNaiveCursorAdapter) this.f1221a.f1192B;
            selectableProfileListNaiveCursorAdapter.f1213i = builder.b();
            selectableProfileListNaiveCursorAdapter.f1214j = selectableProfileListNaiveCursorAdapter.f1213i;
            selectableProfileListNaiveCursorAdapter.mo57a(selectableProfileListNaiveCursorAdapter.f1207d);
        }

        protected final void m1470a(Throwable th) {
            BLog.b(FriendSingleSelectorActivity.class, "failed to get list of suggested friends", th);
        }
    }

    /* compiled from: underline_style */
    class C01145 implements OnClickListener {
        final /* synthetic */ FriendSingleSelectorActivity f1222a;

        C01145(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1222a = friendSingleSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 90817163);
            this.f1222a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 2018143693, a);
        }
    }

    /* compiled from: underline_style */
    class C01156 implements TextWatcher {
        final /* synthetic */ FriendSingleSelectorActivity f1223a;

        C01156(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1223a = friendSingleSelectorActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f1223a.f1236t = charSequence.toString().trim();
            ((SelectableProfileListNaiveCursorAdapter) this.f1223a.f1192B).f1212h.filter(this.f1223a.f1236t);
            this.f1223a.f1193C.setFastScrollEnabled(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int i;
            CharSequence string;
            if (editable.length() > 0) {
                i = 17301594;
                string = this.f1223a.getString(2131234734);
            } else {
                i = 2130840885;
                string = this.f1223a.getString(2131234733);
            }
            this.f1223a.f1234r.setImageResource(i);
            this.f1223a.f1234r.setContentDescription(string);
        }
    }

    /* compiled from: underline_style */
    class C01167 implements OnClickListener {
        final /* synthetic */ FriendSingleSelectorActivity f1224a;

        C01167(FriendSingleSelectorActivity friendSingleSelectorActivity) {
            this.f1224a = friendSingleSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1176286136);
            if (this.f1224a.f1235s.length() > 0) {
                this.f1224a.f1235s.setText("");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1427874397, a);
        }
    }

    /* compiled from: underline_style */
    final class QueryHandler extends AsyncQueryHandler {
        final /* synthetic */ FriendSingleSelectorActivity f1225a;

        public QueryHandler(FriendSingleSelectorActivity friendSingleSelectorActivity, Context context) {
            this.f1225a = friendSingleSelectorActivity;
            super(context.getContentResolver());
        }

        protected final void onQueryComplete(int i, Object obj, Cursor cursor) {
            if (this.f1225a.isFinishing()) {
                cursor.close();
                return;
            }
            this.f1225a.startManagingCursor(cursor);
            ((SelectableProfileListNaiveCursorAdapter) this.f1225a.f1192B).f1207d = cursor;
            FriendSingleSelectorActivity.m1480j(this.f1225a);
        }
    }

    private static <T extends Context> void m1476a(Class<T> cls, T t) {
        m1477a((Object) t, (Context) t);
    }

    public static void m1477a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendSingleSelectorActivity) obj).m1474a(AddressBookPeriodicRunner.a(fbInjector), new FriendTimelineWallPostPrivacyFetcher(), NameNormalizer.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), FriendSuggestionsRunner.m10876b(fbInjector));
    }

    public final void mo55b(Bundle bundle) {
        super.mo55b(bundle);
        Class cls = FriendSingleSelectorActivity.class;
        m1477a((Object) this, (Context) this);
        this.B = new SelectableProfileListNaiveCursorAdapter(this, this, null, Sets.a(), this.f1239w, this.f1240x, this.f1229F) {
            final /* synthetic */ FriendSingleSelectorActivity f1218c;

            public final View mo59a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
                View a = super.mo59a(i, i2, z, view, viewGroup);
                ((CheckBox) a.findViewById(2131560310)).setVisibility(8);
                return a;
            }
        };
        this.f1232p = new QueryHandler(this, this);
        m1481k();
        this.f1235s.requestFocus();
        if (bundle != null) {
            ImmutableSet copyOf;
            long[] longArray = bundle.getLongArray("STATE_KEY_LIST_VIEWERS_CANNOT_POST");
            if (longArray != null) {
                copyOf = ImmutableSet.copyOf(Longs.a(longArray));
            } else {
                copyOf = RegularImmutableSet.a;
            }
            this.f1229F = copyOf;
        } else if (this.f1240x.a(ExperimentsForComposerAbTestModule.U, false)) {
            m1479c(this, false);
            this.f1242z.a("QUERY_VIEWER_CANNOT_POST_LIST_TASK_ID", new C01112(this), new C01123(this));
        }
    }

    private void m1474a(AddressBookPeriodicRunner addressBookPeriodicRunner, FriendTimelineWallPostPrivacyFetcher friendTimelineWallPostPrivacyFetcher, NameNormalizer nameNormalizer, QeAccessor qeAccessor, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, FriendSuggestionsRunner friendSuggestionsRunner) {
        this.f1237u = addressBookPeriodicRunner;
        this.f1238v = friendTimelineWallPostPrivacyFetcher;
        this.f1239w = nameNormalizer;
        this.f1240x = qeAccessor;
        this.f1241y = graphQLQueryExecutor;
        this.f1242z = tasksManager;
        this.f1226A = friendSuggestionsRunner;
    }

    public static void m1479c(FriendSingleSelectorActivity friendSingleSelectorActivity, boolean z) {
        if (!z && friendSingleSelectorActivity.f1229F.isEmpty()) {
            ((ProgressBar) friendSingleSelectorActivity.f1228E.a()).setVisibility(0);
        } else if (friendSingleSelectorActivity.f1228E.b()) {
            ((ProgressBar) friendSingleSelectorActivity.f1228E.a()).setVisibility(8);
        }
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1921810277);
        super.onResume();
        if (((SelectableProfileListNaiveCursorAdapter) this.f1192B).f1207d == null) {
            this.f1232p.startQuery(1, null, ContactsConnectionsContract.g, FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
        } else {
            ((SelectableProfileListNaiveCursorAdapter) this.f1192B).f1217k = this.f1229F;
        }
        if (this.f1240x.a(ExperimentsForComposerAbTestModule.u, false)) {
            this.f1226A.m10879a(new C01134(this), null);
        }
        m1480j(this);
        LogUtils.c(-815836330, a);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (!this.f1229F.isEmpty()) {
            bundle.putLongArray("STATE_KEY_LIST_VIEWERS_CANNOT_POST", Longs.a(this.f1229F));
        }
        super.onSaveInstanceState(bundle);
    }

    public final void mo54a(View view, int i) {
        Intent intent = new Intent();
        FacebookProfile facebookProfile = (FacebookProfile) this.f1192B.getItem(i);
        if (this.f1229F.contains(Long.valueOf(facebookProfile.mId))) {
            Tooltip tooltip = new Tooltip(this);
            tooltip.t = -1;
            tooltip.c(view);
            tooltip.b(this.f1240x.a(ExperimentsForComposerAbTestModule.V, 2131234752, getResources()));
            tooltip.d();
            return;
        }
        ComposerTargetData.Builder builder = new ComposerTargetData.Builder(facebookProfile.mId, TargetType.USER);
        builder.c = facebookProfile.mDisplayName;
        builder = builder;
        builder.d = facebookProfile.mImageUrl;
        intent.putExtra("extra_composer_target_data", builder.a());
        setResult(-1, intent);
        finish();
    }

    public void onBackPressed() {
        setResult(0);
        this.f1242z.c();
        finish();
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 288955560);
        if (this.f1242z != null) {
            this.f1242z.c();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -58642437, a);
    }

    public static void m1480j(FriendSingleSelectorActivity friendSingleSelectorActivity) {
        SelectableProfileListNaiveCursorAdapter selectableProfileListNaiveCursorAdapter = (SelectableProfileListNaiveCursorAdapter) friendSingleSelectorActivity.f1192B;
        if (selectableProfileListNaiveCursorAdapter.f1207d == null) {
            friendSingleSelectorActivity.m1473a(1, true);
            return;
        }
        friendSingleSelectorActivity.m1473a(1, false);
        selectableProfileListNaiveCursorAdapter.mo57a(selectableProfileListNaiveCursorAdapter.f1207d);
        if (friendSingleSelectorActivity.f1192B.getCount() == 0) {
            friendSingleSelectorActivity.f1237u.a();
            friendSingleSelectorActivity.m1473a(2, true);
        }
        friendSingleSelectorActivity.f1235s.setEnabled(true);
    }

    private void m1481k() {
        setContentView(2130903722);
        m1431i();
        m1482l();
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131560590);
        fb4aTitleBar.a(new C01145(this));
        fb4aTitleBar.setTitle(getString(2131237367));
        this.f1193C.setAdapter(this.f1192B);
        this.f1235s = (TextView) findViewById(2131566358);
        this.f1235s.setText(this.f1236t);
        this.f1235s.addTextChangedListener(new C01156(this));
        this.f1235s.setEnabled(false);
        this.f1234r = (ImageView) findViewById(2131566359);
        this.f1234r.setOnClickListener(new C01167(this));
        this.f1228E = new LazyView((ViewStub) findViewById(2131567305));
    }

    private void m1482l() {
        this.f1230G = (TextView) findViewById(2131561172);
        this.f1231H = findViewById(2131561173);
        this.f1230G.setText(2131234717);
    }

    private void m1473a(int i, boolean z) {
        int i2;
        if (z) {
            this.f1233q |= i;
        } else {
            this.f1233q &= i ^ -1;
        }
        if (this.f1233q != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i2 != 0) {
            this.f1230G.setVisibility(8);
            this.f1231H.setVisibility(0);
            return;
        }
        this.f1230G.setVisibility(0);
        this.f1231H.setVisibility(8);
    }

    public final String am_() {
        return "select_friends_view";
    }
}

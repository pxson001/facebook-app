package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.groups.groupsasprofiles.FetchGroupsRequest;
import com.facebook.groups.groupsasprofiles.FetchGroupsRequest.C00681;
import com.facebook.groups.groupsasprofiles.FetchGroupsRequest.GroupOrder;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQL;
import com.facebook.groups.groupsasprofiles.protocol.FetchGroupGraphQL.GroupsQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import javax.inject.Inject;

/* compiled from: uncheck_deeplink_box */
public class GroupSelectorActivity extends ProfileListActivity {
    protected TextView f1250p;
    protected ImageView f1251q;
    private FetchGroupsRequest f1252r;
    private TasksManager<String> f1253s;
    public Toaster f1254t;

    /* compiled from: uncheck_deeplink_box */
    class C01181 implements TextWatcher {
        final /* synthetic */ GroupSelectorActivity f1247a;

        C01181(GroupSelectorActivity groupSelectorActivity) {
            this.f1247a = groupSelectorActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f1247a.f1192B.getFilter().filter(charSequence);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: uncheck_deeplink_box */
    class C01192 implements OnClickListener {
        final /* synthetic */ GroupSelectorActivity f1248a;

        C01192(GroupSelectorActivity groupSelectorActivity) {
            this.f1248a = groupSelectorActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1321067553);
            this.f1248a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -725897536, a);
        }
    }

    /* compiled from: uncheck_deeplink_box */
    class C01203 extends AbstractDisposableFutureCallback<List<FacebookProfile>> {
        final /* synthetic */ GroupSelectorActivity f1249a;

        C01203(GroupSelectorActivity groupSelectorActivity) {
            this.f1249a = groupSelectorActivity;
        }

        protected final void m1485a(Object obj) {
            List list = (List) obj;
            GroupSelectorActivity.m1492c(this.f1249a, false);
            ((GroupSelectorAdapter) this.f1249a.f1192B).mo62a(list);
        }

        protected final void m1486a(Throwable th) {
            GroupSelectorActivity.m1492c(this.f1249a, false);
            this.f1249a.f1254t.b(new ToastBuilder(2131237362));
        }
    }

    private static <T extends Context> void m1490a(Class<T> cls, T t) {
        m1491a((Object) t, (Context) t);
    }

    public static void m1491a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GroupSelectorActivity) obj).m1488a(new FetchGroupsRequest(GraphQLQueryExecutor.a(fbInjector)), TasksManager.b(fbInjector), Toaster.b(fbInjector));
    }

    public final void mo55b(Bundle bundle) {
        super.mo55b(bundle);
        setContentView(2130903722);
        m1431i();
        m1493j();
        this.f1250p = (TextView) a(2131566358);
        this.f1251q = (ImageView) a(2131566359);
        this.f1250p.addTextChangedListener(new C01181(this));
        this.f1250p.requestFocus();
        this.B = new GroupSelectorAdapter(this);
        this.f1193C.setAdapter(this.f1192B);
        this.f1193C.setFastScrollEnabled(false);
        Class cls = GroupSelectorActivity.class;
        m1491a((Object) this, (Context) this);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) a(2131560590);
        fb4aTitleBar.a(new C01192(this));
        fb4aTitleBar.setTitle(getString(2131237364));
    }

    @Inject
    private void m1488a(FetchGroupsRequest fetchGroupsRequest, TasksManager tasksManager, Toaster toaster) {
        this.f1252r = fetchGroupsRequest;
        this.f1253s = tasksManager;
        this.f1254t = toaster;
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1551023496);
        super.onResume();
        m1492c(this, true);
        FetchGroupsRequest fetchGroupsRequest = this.f1252r;
        this.f1253s.a("fetchGroups", Futures.a(fetchGroupsRequest.f513a.a(GraphQLRequest.a(FetchGroupGraphQL.m498a()).a(new GroupsQueryString().a("group_order", GroupOrder.IMPORTANCE.getOrderList()).a("scale", GraphQlQueryDefaults.a()).a)), new C00681(fetchGroupsRequest), MoreExecutors.a()), new C01203(this));
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -634861953, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -442586507);
        super.onPause();
        this.f1253s.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 643498193, a);
    }

    private void m1493j() {
        ((TextView) findViewById(2131561172)).setText(2131237363);
    }

    public static void m1492c(GroupSelectorActivity groupSelectorActivity, boolean z) {
        if (z) {
            groupSelectorActivity.findViewById(2131561172).setVisibility(8);
            groupSelectorActivity.findViewById(2131561173).setVisibility(0);
        } else {
            groupSelectorActivity.findViewById(2131561172).setVisibility(0);
            groupSelectorActivity.findViewById(2131561173).setVisibility(8);
        }
        int i = 8;
        int i2 = z ? 0 : 8;
        if (!z) {
            i = 0;
        }
        groupSelectorActivity.findViewById(2131561173).setVisibility(i2);
        groupSelectorActivity.findViewById(2131561172).setVisibility(i);
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    public final void mo54a(View view, int i) {
        Intent intent = new Intent();
        FacebookProfile facebookProfile = (FacebookProfile) this.f1192B.getItem(i);
        Builder builder = new Builder(facebookProfile.mId, TargetType.GROUP);
        builder.c = facebookProfile.mDisplayName;
        intent.putExtra("extra_composer_target_data", builder.a());
        setResult(-1, intent);
        finish();
    }
}

package com.facebook.account.recovery.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.account.recovery.annotations.IsCaptchaEnabled;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger;
import com.facebook.account.recovery.logging.AccountRecoveryAnalyticsLogger$EventType;
import com.facebook.account.recovery.model.AccountCandidateModel;
import com.facebook.account.recovery.model.AccountSearchListHeader;
import com.facebook.account.recovery.model.AccountSearchListItem;
import com.facebook.account.recovery.model.AccountSearchNotInList;
import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethod.Result;
import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethodParams;
import com.facebook.account.recovery.ui.AccountCandidateListAdapter;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.growth.model.DeviceOwnerData;
import com.facebook.growth.util.DeviceOwnerDataFetcher;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.runtimepermissions.AbstractRuntimePermissionsListener;
import com.facebook.runtimepermissions.ActivityRuntimePermissionsManagerProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.text.watcher.BaseTextWatcher;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Collection;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: local_photo_metadata_photo_hash_idx */
public class AccountSearchFragment extends FbFragment {
    public static final String[] f10255a = new String[]{"android.permission.GET_ACCOUNTS", "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE"};
    public FrameLayout al;
    public AccountSearchListener am;
    public SearchEditText an;
    public TextView ao;
    public TextView ap;
    public Button aq;
    public View ar;
    public View as;
    public BetterListView at;
    public TextView au;
    public String av = "";
    public String aw = "";
    public String ax;
    public TriState ay = TriState.UNSET;
    public SearchType az = SearchType.CONTACT_POINT;
    @Inject
    public AccountCandidateListAdapter f10256b;
    @Inject
    public AccountRecoveryAnalyticsLogger f10257c;
    @Inject
    DefaultBlueServiceOperationFactory f10258d;
    @Inject
    TasksManager f10259e;
    @Inject
    DeviceOwnerDataFetcher f10260f;
    @Inject
    @ForUiThread
    Executor f10261g;
    @Inject
    @IsCaptchaEnabled
    Lazy<TriState> f10262h;
    @Inject
    public ActivityRuntimePermissionsManagerProvider f10263i;

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10701 implements OnClickListener {
        final /* synthetic */ AccountSearchFragment f10246a;

        public C10701(AccountSearchFragment accountSearchFragment) {
            this.f10246a = accountSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 136286056);
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger = this.f10246a.f10257c;
            String name = this.f10246a.az.name();
            AnalyticsLogger analyticsLogger = accountRecoveryAnalyticsLogger.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.CHANGE_SEARCH_TYPE_CLICK.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("search_type", name), 1);
            if (this.f10246a.az == SearchType.CONTACT_POINT) {
                AccountSearchFragment.m12035a(this.f10246a, SearchType.NAME);
            } else if (this.f10246a.az == SearchType.NAME) {
                AccountSearchFragment.m12035a(this.f10246a, SearchType.CONTACT_POINT);
            }
            this.f10246a.f10257c.b(this.f10246a.az.name());
            LogUtils.a(-1840794172, a);
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10712 implements OnSubmitListener {
        final /* synthetic */ AccountSearchFragment f10247a;

        public C10712(AccountSearchFragment accountSearchFragment) {
            this.f10247a = accountSearchFragment;
        }

        public final void m12032a() {
            Object obj = this.f10247a.an.getText().toString();
            if (!StringUtil.c(obj)) {
                this.f10247a.ao.setVisibility(8);
                this.f10247a.aq.setVisibility(8);
                this.f10247a.au.setVisibility(8);
                this.f10247a.as.setVisibility(0);
                this.f10247a.av = obj;
                AccountSearchFragment.at(this.f10247a);
            }
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10723 implements OnClickListener {
        final /* synthetic */ AccountSearchFragment f10248a;

        public C10723(AccountSearchFragment accountSearchFragment) {
            this.f10248a = accountSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1391943880);
            this.f10248a.an.onEditorAction(this.f10248a.an, 3, null);
            Logger.a(2, EntryType.UI_INPUT_END, 1802742626, a);
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10734 implements OnClickListener {
        final /* synthetic */ AccountSearchFragment f10249a;

        public C10734(AccountSearchFragment accountSearchFragment) {
            this.f10249a = accountSearchFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1606372315);
            AccountSearchFragment.m12038e(this.f10249a);
            this.f10249a.f10257c.b(this.f10249a.az.name());
            Logger.a(2, EntryType.UI_INPUT_END, 1124586648, a);
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10745 implements OnScrollListener {
        final /* synthetic */ AccountSearchFragment f10250a;

        public C10745(AccountSearchFragment accountSearchFragment) {
            this.f10250a = accountSearchFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                this.f10250a.an.c();
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10756 implements OnItemClickListener {
        final /* synthetic */ AccountSearchFragment f10251a;

        public C10756(AccountSearchFragment accountSearchFragment) {
            this.f10251a = accountSearchFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((AccountSearchListItem) this.f10251a.f10256b.getItem(i)).mo678j()) {
                case CANDIDATE:
                    this.f10251a.am.a((AccountCandidateModel) this.f10251a.f10256b.getItem(i), false);
                    return;
                case NOT_IN_LIST:
                    this.f10251a.am.b(this.f10251a.av);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public class C10767 extends BaseTextWatcher {
        final /* synthetic */ AccountSearchFragment f10252a;

        public C10767(AccountSearchFragment accountSearchFragment) {
            this.f10252a = accountSearchFragment;
        }

        public void afterTextChanged(Editable editable) {
            if (StringUtil.c(this.f10252a.an.getText())) {
                this.f10252a.aq.setVisibility(8);
                this.f10252a.ao.setVisibility(0);
                return;
            }
            this.f10252a.aq.setVisibility(0);
            this.f10252a.ao.setVisibility(8);
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    class C10778 extends OperationResultFutureCallback {
        final /* synthetic */ AccountSearchFragment f10253a;

        C10778(AccountSearchFragment accountSearchFragment) {
            this.f10253a = accountSearchFragment;
        }

        protected final void m12034a(Object obj) {
            Result result;
            OperationResult operationResult = (OperationResult) obj;
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger;
            String name;
            AnalyticsLogger analyticsLogger;
            HoneyClientEvent honeyClientEvent;
            if (StringUtil.a(this.f10253a.aw)) {
                accountRecoveryAnalyticsLogger = this.f10253a.f10257c;
                name = this.f10253a.az.name();
                analyticsLogger = accountRecoveryAnalyticsLogger.a;
                honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.SEARCH_PERFORMED.getEventName());
                honeyClientEvent.c = "account_recovery";
                analyticsLogger.b(honeyClientEvent.b("search_type", name), 1);
            } else {
                accountRecoveryAnalyticsLogger = this.f10253a.f10257c;
                name = this.f10253a.av;
                String name2 = this.f10253a.az.name();
                analyticsLogger = accountRecoveryAnalyticsLogger.a;
                honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.FRIEND_SEARCH_PERFORMED.getEventName());
                honeyClientEvent.c = "account_recovery";
                analyticsLogger.b(honeyClientEvent.b("account_name", name).b("search_type", name2), 1);
            }
            AccountSearchFragment accountSearchFragment = this.f10253a;
            if (operationResult == null) {
                result = null;
            } else {
                result = (Result) operationResult.k();
            }
            if (result == null) {
                AccountSearchFragment.au(accountSearchFragment);
                return;
            }
            ImmutableList b = result.m12110b();
            if (b == null || b.isEmpty()) {
                AccountSearchFragment.au(accountSearchFragment);
                return;
            }
            boolean asBoolean = accountSearchFragment.ay.asBoolean(false);
            if (asBoolean) {
                AnalyticsLogger analyticsLogger2 = accountSearchFragment.f10257c.a;
                HoneyClientEvent honeyClientEvent2 = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.AUTO_IDENTIFY_PERFORMED.getEventName());
                honeyClientEvent2.c = "account_recovery";
                analyticsLogger2.b(honeyClientEvent2, 1);
                AccountSearchFragment.ax(accountSearchFragment);
            }
            int a = result.m12109a();
            if (a == 1) {
                accountSearchFragment.am.a((AccountCandidateModel) b.get(0), asBoolean);
                return;
            }
            Collection a2 = Lists.a();
            a2.add(new AccountSearchListHeader());
            a2.addAll(b);
            if (a > 10) {
                a2.add(new AccountSearchNotInList());
            }
            BaseAdapter baseAdapter = accountSearchFragment.f10256b;
            baseAdapter.f10331b.clear();
            baseAdapter.f10331b.addAll(a2);
            AdapterDetour.a(baseAdapter, 427469146);
            AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger2 = accountSearchFragment.f10257c;
            String str = accountSearchFragment.av;
            String str2 = accountSearchFragment.aw;
            String name3 = accountSearchFragment.az.name();
            analyticsLogger2 = accountRecoveryAnalyticsLogger2.a;
            honeyClientEvent2 = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.LIST_SHOWN.getEventName());
            honeyClientEvent2.c = "account_recovery";
            analyticsLogger2.b(honeyClientEvent2.a("size", a).b("account_name", str).b("friend_name", str2).b("search_type", name3), 1);
            accountSearchFragment.aw = "";
        }

        protected final void m12033a(ServiceException serviceException) {
            Object obj;
            ApiException apiException = (ApiException) ExceptionUtil.a(serviceException, ApiException.class);
            if (apiException == null || apiException.b().mErrorSubCode != 1647002) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                if (((TriState) this.f10253a.f10262h.get()).asBoolean(false)) {
                    this.f10253a.f10257c.a(true);
                    this.f10253a.am.c(this.f10253a.av);
                    return;
                }
                this.f10253a.f10257c.a(false);
            }
            AccountSearchFragment.au(this.f10253a);
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    class C10789 implements DialogInterface.OnClickListener {
        final /* synthetic */ AccountSearchFragment f10254a;

        C10789(AccountSearchFragment accountSearchFragment) {
            this.f10254a = accountSearchFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10254a.an.a();
            this.f10254a.an.b();
            this.f10254a.aq.setVisibility(8);
            this.f10254a.ao.setVisibility(0);
            this.f10254a.au.setVisibility(0);
            this.f10254a.as.setVisibility(8);
            this.f10254a.f10256b.m12124a();
        }
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    public enum SearchType {
        CONTACT_POINT,
        NAME
    }

    /* compiled from: local_photo_metadata_photo_hash_idx */
    enum Tasks {
        ACCOUNT_SEARCH
    }

    public static void m12037a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AccountSearchFragment) obj).m12036a(new AccountCandidateListAdapter(ResourcesMethodAutoProvider.a(injectorLike)), AccountRecoveryAnalyticsLogger.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), TasksManager.b(injectorLike), DeviceOwnerDataFetcher.m17367a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 623), (ActivityRuntimePermissionsManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ActivityRuntimePermissionsManagerProvider.class));
    }

    private void m12036a(AccountCandidateListAdapter accountCandidateListAdapter, AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger, BlueServiceOperationFactory blueServiceOperationFactory, TasksManager tasksManager, DeviceOwnerDataFetcher deviceOwnerDataFetcher, Executor executor, Lazy<TriState> lazy, ActivityRuntimePermissionsManagerProvider activityRuntimePermissionsManagerProvider) {
        this.f10256b = accountCandidateListAdapter;
        this.f10257c = accountRecoveryAnalyticsLogger;
        this.f10258d = blueServiceOperationFactory;
        this.f10259e = tasksManager;
        this.f10260f = deviceOwnerDataFetcher;
        this.f10261g = executor;
        this.f10262h = lazy;
        this.f10263i = activityRuntimePermissionsManagerProvider;
    }

    public final void m12045c(Bundle bundle) {
        super.c(bundle);
        Class cls = AccountSearchFragment.class;
        m12037a((Object) this, getContext());
    }

    public final View m12042a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2095734826);
        View inflate = layoutInflater.inflate(2130903070, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2082822941, a);
        return inflate;
    }

    public final void m12044a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.al = (FrameLayout) e(2131559175);
        this.an = (SearchEditText) e(2131559176);
        this.ar = e(2131559177);
        this.at = (BetterListView) e(2131559178);
        this.ao = (TextView) e(2131559180);
        this.ap = (TextView) e(2131559184);
        this.aq = (Button) e(2131559181);
        this.as = e(2131559183);
        this.at.setEmptyView(e(2131559179));
        this.at.setAdapter(this.f10256b);
        this.at.setStickyHeaderEnabled(true);
        this.au = (TextView) e(2131559182);
        m12035a(this, this.az);
        Boolean valueOf = Boolean.valueOf(false);
        if (this.s != null) {
            this.av = this.s.getString("query");
            this.aw = this.s.getString("friend_name");
            valueOf = Boolean.valueOf(this.s.getBoolean("account_search_use_query_now"));
        }
        this.an.setText(this.av);
        this.au.setOnClickListener(new C10701(this));
        this.an.addTextChangedListener(new C10767(this));
        this.an.f = new C10712(this);
        this.aq.setOnClickListener(new C10723(this));
        this.ar.setOnClickListener(new C10734(this));
        this.at.setOnScrollListener(new C10745(this));
        this.at.setOnItemClickListener(new C10756(this));
        if (valueOf.booleanValue()) {
            this.an.onEditorAction(this.an, 3, null);
        } else if (this.ay != TriState.NO) {
            this.ay = TriState.YES;
            this.as.setVisibility(0);
            this.ap.setVisibility(0);
            this.al.setVisibility(8);
            this.ao.setVisibility(8);
            this.au.setVisibility(8);
            if (StringUtil.a(this.ax)) {
                AnalyticsLogger analyticsLogger = this.f10257c.a;
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.AUTO_IDENTIFY_STARTED.getEventName());
                honeyClientEvent.c = "account_recovery";
                analyticsLogger.b(honeyClientEvent, 1);
                this.f10263i.a(o()).a(f10255a, new AbstractRuntimePermissionsListener(this) {
                    final /* synthetic */ AccountSearchFragment f10243a;

                    /* compiled from: local_photo_metadata_photo_hash_idx */
                    class C10691 implements FutureCallback<DeviceOwnerData> {
                        final /* synthetic */ AnonymousClass10 f10242a;

                        C10691(AnonymousClass10 anonymousClass10) {
                            this.f10242a = anonymousClass10;
                        }

                        public void onSuccess(@Nullable Object obj) {
                            DeviceOwnerData deviceOwnerData = (DeviceOwnerData) obj;
                            this.f10242a.f10243a.ax = AccountRecoverySearchAccountMethodParams.m12113a(deviceOwnerData);
                            AccountSearchFragment.at(this.f10242a.f10243a);
                        }

                        public void onFailure(Throwable th) {
                            AccountSearchFragment.ax(this.f10242a.f10243a);
                        }
                    }

                    {
                        this.f10243a = r1;
                    }

                    public final void m12030a() {
                        Futures.a(this.f10243a.f10260f.m17374a(), new C10691(this), this.f10243a.f10261g);
                    }

                    public final void m12031a(String[] strArr, String[] strArr2) {
                        AccountSearchFragment.at(this.f10243a);
                    }
                });
            } else {
                at(this);
            }
        }
        this.f10257c.b(this.az.name());
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1810461945);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239682);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 335565721, a);
    }

    public final void m12039G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1700196335);
        super.G();
        this.an.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 280203525, a);
    }

    public final void m12040H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1037353508);
        this.an.c();
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1617010856, a);
    }

    public final void m12041I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2003097137);
        this.f10259e.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -432512419, a);
    }

    public final void m12043a(Activity activity) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1255552269);
        super.a(activity);
        try {
            this.am = (AccountSearchListener) activity;
            LogUtils.f(1810831102, a);
        } catch (ClassCastException e) {
            ClassCastException classCastException = new ClassCastException(activity.toString() + " must implement AccountSearchListener");
            LogUtils.f(1417610398, a);
            throw classCastException;
        }
    }

    public static void m12035a(AccountSearchFragment accountSearchFragment, SearchType searchType) {
        accountSearchFragment.az = searchType;
        switch (searchType) {
            case CONTACT_POINT:
                m12038e(accountSearchFragment);
                accountSearchFragment.an.setHint(2131239686);
                accountSearchFragment.ao.setText(2131239683);
                accountSearchFragment.au.setText(2131239687);
                return;
            case NAME:
                m12038e(accountSearchFragment);
                accountSearchFragment.an.setHint(2131239685);
                accountSearchFragment.ao.setText(2131239684);
                accountSearchFragment.au.setText(2131239688);
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void m12038e(AccountSearchFragment accountSearchFragment) {
        accountSearchFragment.an.a();
        accountSearchFragment.an.b();
        accountSearchFragment.ao.setVisibility(0);
        accountSearchFragment.au.setVisibility(0);
        accountSearchFragment.aq.setVisibility(8);
        accountSearchFragment.as.setVisibility(8);
        accountSearchFragment.f10256b.m12124a();
    }

    public static void at(AccountSearchFragment accountSearchFragment) {
        accountSearchFragment.f10256b.m12124a();
        Bundle bundle = new Bundle();
        bundle.putParcelable("accountRecoverySearchAccountParamsKey", new AccountRecoverySearchAccountMethodParams(accountSearchFragment.av, accountSearchFragment.aw, accountSearchFragment.ax));
        AccountRecoveryAnalyticsLogger accountRecoveryAnalyticsLogger;
        String name;
        AnalyticsLogger analyticsLogger;
        HoneyClientEvent honeyClientEvent;
        if (StringUtil.a(accountSearchFragment.aw)) {
            accountRecoveryAnalyticsLogger = accountSearchFragment.f10257c;
            name = accountSearchFragment.az.name();
            analyticsLogger = accountRecoveryAnalyticsLogger.a;
            honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.SEARCH_SENT.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("search_type", name), 1);
        } else {
            accountRecoveryAnalyticsLogger = accountSearchFragment.f10257c;
            name = accountSearchFragment.av;
            String name2 = accountSearchFragment.az.name();
            analyticsLogger = accountRecoveryAnalyticsLogger.a;
            honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.FRIEND_SEARCH_SENT.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent.b("account_name", name).b("search_type", name2), 1);
        }
        accountSearchFragment.f10259e.a(Tasks.ACCOUNT_SEARCH, BlueServiceOperationFactoryDetour.a(accountSearchFragment.f10258d, "account_recovery_search_account", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(AccountSearchFragment.class), -130989403).a(), new C10778(accountSearchFragment));
    }

    public static void au(AccountSearchFragment accountSearchFragment) {
        if (accountSearchFragment.ay == TriState.YES) {
            AnalyticsLogger analyticsLogger = accountSearchFragment.f10257c.a;
            HoneyClientEvent honeyClientEvent = new HoneyClientEvent(AccountRecoveryAnalyticsLogger$EventType.AUTO_IDENTIFY_FAILED.getEventName());
            honeyClientEvent.c = "account_recovery";
            analyticsLogger.b(honeyClientEvent, 1);
            ax(accountSearchFragment);
            return;
        }
        String b;
        Builder a = new Builder(accountSearchFragment.getContext()).a(accountSearchFragment.b(2131239698));
        if (accountSearchFragment.az == SearchType.CONTACT_POINT) {
            b = accountSearchFragment.b(2131239700);
        } else if (accountSearchFragment.az == SearchType.NAME) {
            b = accountSearchFragment.b(2131239701);
        } else {
            b = accountSearchFragment.b(2131239699);
        }
        a.b(b).a(accountSearchFragment.b(2131239702), new C10789(accountSearchFragment)).b();
        accountSearchFragment.as.setVisibility(8);
        accountSearchFragment.aw = "";
    }

    public static void ax(AccountSearchFragment accountSearchFragment) {
        accountSearchFragment.al.setVisibility(0);
        accountSearchFragment.ao.setVisibility(0);
        accountSearchFragment.au.setVisibility(0);
        accountSearchFragment.as.setVisibility(8);
        accountSearchFragment.ap.setVisibility(8);
        accountSearchFragment.ay = TriState.NO;
        accountSearchFragment.ax = null;
    }
}

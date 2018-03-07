package com.facebook.orca.threadview;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import com.facebook.actionbar.AppCompatActivityOverrider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow.PushableType;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.blocking.BlockingUtils;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.groups.admin.GroupAdminController;
import com.facebook.messaging.material.MessengerMaterialThemeUtil;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.omnipicker.abtest.ExperimentsForOmniPickerAbTestModule;
import com.facebook.messaging.service.model.AddMembersParams;
import com.facebook.messaging.users.MessengerUserCheckHelper;
import com.facebook.orca.contacts.picker.ContactPickerFragment;
import com.facebook.orca.contacts.picker.ContactPickerFragment.ListType;
import com.facebook.orca.contacts.picker.ContactPickerFragment.Mode;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.ActionBarBasedFbTitleBar;
import com.facebook.widget.titlebar.FbActionBarUtil;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Provider;

/* compiled from: multiway_join_thread_view_button */
public class AddMembersActivity extends FbFragmentActivity implements AnalyticsActivity {
    public static final Class<?> f6767p = AddMembersActivity.class;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<AnalyticsLogger> f6768A = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BlockingUtils> f6769B = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<BlueServiceOperationFactory> f6770C = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<ErrorDialogs> f6771D = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<InputMethodManager> f6772E = UltralightRuntime.b;
    private ContactPickerFragment f6773F;
    public ListenableFuture<OperationResult> f6774G;
    private ThreadSummary f6775H;
    private AppCompatActivityOverrider f6776I;
    public boolean f6777J;
    private AddMode f6778K;
    @Inject
    private Provider<AppCompatActivityOverrider> f6779q;
    @Inject
    private DataCache f6780r;
    @Inject
    private FbActionBarUtil f6781s;
    @Inject
    private GroupAdminController f6782t;
    @IsWorkBuild
    @Inject
    private Boolean f6783u;
    @Inject
    public MessengerUserCheckHelper f6784v;
    @Inject
    public DefaultPresenceManager f6785w;
    @Inject
    private QeAccessor f6786x;
    @Inject
    private ThreadViewTitleHelper f6787y;
    @Inject
    private UserCache f6788z;

    /* compiled from: multiway_join_thread_view_button */
    class C10141 implements OnClickListener {
        final /* synthetic */ AddMembersActivity f6764a;

        C10141(AddMembersActivity addMembersActivity) {
            this.f6764a = addMembersActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1040423244);
            AddMembersActivity.m6455j(this.f6764a);
            Logger.a(2, EntryType.UI_INPUT_END, 434762679, a);
        }
    }

    /* compiled from: multiway_join_thread_view_button */
    class C10152 implements RowCreator {
        final /* synthetic */ AddMembersActivity f6765a;

        C10152(AddMembersActivity addMembersActivity) {
            this.f6765a = addMembersActivity;
        }

        public final ContactPickerRow m6441a(Object obj) {
            if (obj instanceof User) {
                RowStyle rowStyle;
                boolean z;
                PushableType pushableType;
                User user = (User) obj;
                boolean b = this.f6765a.f6785w.b(user.T);
                boolean a = this.f6765a.f6784v.a(user);
                ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
                contactPickerUserRowBuilder.a = user;
                ContactPickerUserRowBuilder contactPickerUserRowBuilder2 = contactPickerUserRowBuilder;
                if (this.f6765a.f6777J) {
                    rowStyle = RowStyle.NEUE_PICKER;
                } else {
                    rowStyle = RowStyle.TWO_LINE;
                }
                contactPickerUserRowBuilder2.b = rowStyle;
                contactPickerUserRowBuilder = contactPickerUserRowBuilder2;
                contactPickerUserRowBuilder.e = b;
                ContactPickerUserRowBuilder contactPickerUserRowBuilder3 = contactPickerUserRowBuilder;
                if (this.f6765a.f6777J) {
                    z = false;
                } else {
                    z = true;
                }
                contactPickerUserRowBuilder3.h = z;
                contactPickerUserRowBuilder3 = contactPickerUserRowBuilder3;
                if (a) {
                    pushableType = PushableType.ON_MESSENGER;
                } else {
                    pushableType = PushableType.ON_FACEBOOK;
                }
                contactPickerUserRowBuilder3.l = pushableType;
                return contactPickerUserRowBuilder3.a();
            }
            BLog.a(AddMembersActivity.f6767p, "unexpected rowData of type: " + obj.getClass());
            throw new IllegalArgumentException();
        }
    }

    /* compiled from: multiway_join_thread_view_button */
    class C10163 extends OperationResultFutureCallback {
        final /* synthetic */ AddMembersActivity f6766a;

        C10163(AddMembersActivity addMembersActivity) {
            this.f6766a = addMembersActivity;
        }

        protected final void m6442a(ServiceException serviceException) {
            this.f6766a.f6774G = null;
            ErrorDialogs errorDialogs = (ErrorDialogs) this.f6766a.f6771D.get();
            ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f6766a.getResources()).a(2131230721);
            a.f = serviceException;
            errorDialogs.a(a.l());
        }

        protected final void m6443a(Object obj) {
            this.f6766a.f6774G = null;
            this.f6766a.finish();
        }
    }

    /* compiled from: multiway_join_thread_view_button */
    enum AddMode {
        ADD,
        INVITE
    }

    private static <T extends Context> void m6447a(Class<T> cls, T t) {
        m6448a((Object) t, (Context) t);
    }

    public static void m6448a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AddMembersActivity) obj).m6449a(IdBasedProvider.a(fbInjector, 4577), DataCache.a(fbInjector), FbActionBarUtil.a(fbInjector), GroupAdminController.m2341b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector), MessengerUserCheckHelper.b(fbInjector), DefaultPresenceManager.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), ThreadViewTitleHelper.m7934b(fbInjector), UserCache.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 175), IdBasedLazy.a(fbInjector, 7554), IdBasedLazy.a(fbInjector, 1144), IdBasedLazy.a(fbInjector, 3559), IdBasedLazy.a(fbInjector, 64));
    }

    public static Intent m6444a(Context context, ThreadKey threadKey) {
        return new Intent(context, AddMembersActivity.class).setAction("android.intent.action.VIEW").putExtra("thread_key", threadKey);
    }

    public final String am_() {
        return "add_members";
    }

    protected final void m6456a(Bundle bundle) {
        MessengerMaterialThemeUtil.a(this, 2131625175);
        getTheme().applyStyle(2131625141, true);
        Class cls = AddMembersActivity.class;
        m6448a((Object) this, (Context) this);
        this.f6775H = this.f6780r.a((ThreadKey) getIntent().getParcelableExtra("thread_key"));
        if (this.f6775H == null) {
            finish();
            return;
        }
        this.f6777J = this.f6781s.a();
        if (this.f6777J) {
            this.f6776I = (AppCompatActivityOverrider) this.f6779q.get();
            a(this.f6776I);
        }
    }

    public final void m6457b(Bundle bundle) {
        FbTitleBar actionBarBasedFbTitleBar;
        AddMode addMode;
        int i;
        super.b(bundle);
        setContentView(2130905558);
        if (this.f6777J) {
            actionBarBasedFbTitleBar = new ActionBarBasedFbTitleBar(this, this.f6776I.g());
        } else {
            FbTitleBarUtil.b(this);
            actionBarBasedFbTitleBar = (FbTitleBar) a(2131558563);
        }
        GroupAdminController groupAdminController = this.f6782t;
        ThreadSummary threadSummary = this.f6775H;
        Object obj = null;
        if (threadSummary != null && groupAdminController.m2344a(threadSummary) && threadSummary.Q && !groupAdminController.m2346c(threadSummary)) {
            obj = 1;
        }
        if (obj != null) {
            addMode = AddMode.INVITE;
        } else {
            addMode = AddMode.ADD;
        }
        this.f6778K = addMode;
        Button button = (Button) a(2131564428);
        if (this.f6778K == AddMode.INVITE) {
            button.setText(2131231156);
        }
        this.f6787y.m7938a(actionBarBasedFbTitleBar);
        actionBarBasedFbTitleBar.setHasFbLogo(false);
        this.f6787y.m7936a(this.f6775H);
        button.setOnClickListener(new C10141(this));
        this.f6773F = (ContactPickerFragment) kO_().a(2131564427);
        C10152 c10152 = new C10152(this);
        this.f6773F.m5774g(this.f6778K == AddMode.INVITE ? 2131231200 : 2131231199);
        this.f6773F.au = c10152;
        this.f6773F.m5755a(ListType.FACEBOOK_LIST);
        this.f6773F.aw();
        this.f6773F.m5756a(Mode.ADD_MEMBERS);
        this.f6773F.m5766a(getString(2131231202));
        if (this.f6786x.a(ExperimentsForOmniPickerAbTestModule.f3414a, false)) {
            this.f6773F.m5767a(true);
        }
        Collection a = Lists.a();
        ImmutableList immutableList = this.f6775H.h;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            ThreadParticipant threadParticipant = (ThreadParticipant) immutableList.get(i);
            if (threadParticipant.a.a()) {
                User a2 = this.f6788z.a(threadParticipant.b());
                if (a2 != null) {
                    a.add(a2);
                }
            }
        }
        this.f6773F.aA = ImmutableList.copyOf(a);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new TypedValue().data, new int[]{2130773178, 2130773179});
        i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        this.f6773F.m5776i(i);
        if (drawable != null) {
            this.f6773F.aH = drawable;
        }
    }

    private void m6449a(Provider<AppCompatActivityOverrider> provider, DataCache dataCache, FbActionBarUtil fbActionBarUtil, GroupAdminController groupAdminController, Boolean bool, MessengerUserCheckHelper messengerUserCheckHelper, PresenceManager presenceManager, QeAccessor qeAccessor, ThreadViewTitleHelper threadViewTitleHelper, UserCache userCache, com.facebook.inject.Lazy<AnalyticsLogger> lazy, com.facebook.inject.Lazy<BlockingUtils> lazy2, com.facebook.inject.Lazy<BlueServiceOperationFactory> lazy3, com.facebook.inject.Lazy<ErrorDialogs> lazy4, com.facebook.inject.Lazy<InputMethodManager> lazy5) {
        this.f6779q = provider;
        this.f6780r = dataCache;
        this.f6781s = fbActionBarUtil;
        this.f6782t = groupAdminController;
        this.f6783u = bool;
        this.f6784v = messengerUserCheckHelper;
        this.f6785w = presenceManager;
        this.f6786x = qeAccessor;
        this.f6787y = threadViewTitleHelper;
        this.f6788z = userCache;
        this.f6768A = lazy;
        this.f6769B = lazy2;
        this.f6770C = lazy3;
        this.f6771D = lazy4;
        this.f6772E = lazy5;
    }

    public void onBackPressed() {
        ((InputMethodManager) this.f6772E.get()).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        super.onBackPressed();
    }

    public static void m6455j(AddMembersActivity addMembersActivity) {
        if (addMembersActivity.f6774G == null) {
            if (!((BlockingUtils) addMembersActivity.f6769B.get()).a(addMembersActivity.f6788z.a(addMembersActivity.f6773F.ar()), addMembersActivity.kO_())) {
                ImmutableList e = addMembersActivity.f6773F.m5772e();
                List arrayList = new ArrayList(e.size());
                int size = e.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(((User) e.get(i)).U);
                }
                if (arrayList.isEmpty()) {
                    ErrorDialogParamsBuilder a = ErrorDialogParams.a(addMembersActivity);
                    if (addMembersActivity.f6783u.booleanValue()) {
                        a.a(2131230996).b(2131231153);
                    } else {
                        a.a(2131230721).b(addMembersActivity.f6778K == AddMode.INVITE ? 2131231157 : 2131231152);
                    }
                    ((ErrorDialogs) addMembersActivity.f6771D.get()).a(a.l());
                    return;
                }
                ((InputMethodManager) addMembersActivity.f6772E.get()).hideSoftInputFromWindow(addMembersActivity.getWindow().getDecorView().getWindowToken(), 0);
                HoneyClientEventFast a2 = ((AnalyticsLogger) addMembersActivity.f6768A.get()).a("add_member", false);
                if (a2.a()) {
                    a2.a("thread_fbid", addMembersActivity.f6775H.a.b).a(addMembersActivity.am_()).c("add_person");
                    a2.b();
                }
                AddMembersParams addMembersParams = new AddMembersParams(addMembersActivity.f6775H.a, arrayList);
                Bundle bundle = new Bundle();
                bundle.putParcelable("addMembersParams", addMembersParams);
                Operation a3 = BlueServiceOperationFactoryDetour.a((DefaultBlueServiceOperationFactory) addMembersActivity.f6770C.get(), "add_members", bundle, -984400019);
                a3.a(new DialogBasedProgressIndicator(addMembersActivity, addMembersActivity.f6778K == AddMode.INVITE ? 2131231158 : 2131231154));
                addMembersActivity.f6774G = a3.a();
                Futures.a(addMembersActivity.f6774G, new C10163(addMembersActivity));
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((InputMethodManager) this.f6772E.get()).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        finish();
        return true;
    }
}

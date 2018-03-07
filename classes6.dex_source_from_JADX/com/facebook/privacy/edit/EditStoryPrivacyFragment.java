package com.facebook.privacy.edit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.PrivacyOperationsClient;
import com.facebook.privacy.PrivacyOperationsClient.C09932;
import com.facebook.privacy.analytics.PrivacyPerformanceLogger;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyDataForEditStory;
import com.facebook.privacy.protocol.PrivacyMutationsModels.SetStoryPrivacyCoreMutationFieldsModel;
import com.facebook.privacy.protocol.PrivacyMutationsModels.SetStoryPrivacyStoryFieldsModel.PrivacyScopeModel;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.privacy.service.PrivacyAnalyticsLogger;
import com.facebook.privacy.service.PrivacyAnalyticsLogger.Events;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: fetch sticker metadata failed */
public final class EditStoryPrivacyFragment extends FbFragment {
    public DefaultAndroidThreadUtil f15050a;
    public EditStoryPrivacyParams al;
    public SelectablePrivacyDataForEditStory am;
    public GraphQLPrivacyOption an;
    public AudienceTypeaheadFragment ao;
    public DialogFragment ap;
    private boolean aq;
    public View ar;
    public View as;
    public View at;
    public final DataProvider au = new C10171(this);
    private AudienceSelectorPerformanceLogger f15051b;
    public AbstractFbErrorReporter f15052c;
    public PrivacyAnalyticsLogger f15053d;
    public PrivacyPerformanceLogger f15054e;
    private PrivacyOperationsClient f15055f;
    private TasksManager f15056g;
    public Toaster f15057h;
    private InputMethodManager f15058i;

    /* compiled from: fetch sticker metadata failed */
    class C10171 implements DataProvider {
        final /* synthetic */ EditStoryPrivacyFragment f15043a;

        C10171(EditStoryPrivacyFragment editStoryPrivacyFragment) {
            this.f15043a = editStoryPrivacyFragment;
        }

        public final SelectablePrivacyData mo1183a() {
            return this.f15043a.am.f15110a;
        }

        public final boolean mo1184b() {
            return this.f15043a.am.f15111b || this.f15043a.al.f15066d;
        }
    }

    /* compiled from: fetch sticker metadata failed */
    public class C10182 implements OnClickListener {
        final /* synthetic */ EditStoryPrivacyFragment f15044a;

        public C10182(EditStoryPrivacyFragment editStoryPrivacyFragment) {
            this.f15044a = editStoryPrivacyFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1320865921);
            EditStoryPrivacyFragment.as(this.f15044a);
            Logger.a(2, EntryType.UI_INPUT_END, 2119621646, a);
        }
    }

    /* compiled from: fetch sticker metadata failed */
    class C10193 extends ResultFutureCallback<SelectablePrivacyDataForEditStory> {
        final /* synthetic */ EditStoryPrivacyFragment f15045a;

        protected final void m22616a(ServiceException serviceException) {
            if (serviceException.errorCode == ErrorCode.API_ERROR) {
                this.f15045a.f15052c.a("edit_story_privacy_fragment_option_fetch_error", "Privacy options fetch failure", serviceException);
            }
            this.f15045a.as.setVisibility(0);
            m22615b();
        }

        C10193(EditStoryPrivacyFragment editStoryPrivacyFragment) {
            this.f15045a = editStoryPrivacyFragment;
        }

        protected final void m22617a(Object obj) {
            SelectablePrivacyDataForEditStory selectablePrivacyDataForEditStory = (SelectablePrivacyDataForEditStory) obj;
            this.f15045a.f15050a.a();
            this.f15045a.am = selectablePrivacyDataForEditStory;
            if (this.f15045a.am == null) {
                this.f15045a.f15052c.b("edit_story_privacy_fragment_no_selectable_privacy", "fetch successful but get a null SelectablePrivacyData");
                this.f15045a.as.setVisibility(0);
                return;
            }
            this.f15045a.an = this.f15045a.am.f15110a.f15109d;
            EditStoryPrivacyFragment editStoryPrivacyFragment = this.f15045a;
            if (editStoryPrivacyFragment.ao == null) {
                editStoryPrivacyFragment.ao = (AudienceTypeaheadFragment) editStoryPrivacyFragment.s().a(2131561139);
                if (editStoryPrivacyFragment.ao == null) {
                    editStoryPrivacyFragment.ao = new AudienceTypeaheadFragment();
                    FragmentTransaction a = editStoryPrivacyFragment.s().a();
                    a.a(2131561139, editStoryPrivacyFragment.ao);
                    a.c();
                }
            }
            editStoryPrivacyFragment.ao.m22843a(editStoryPrivacyFragment.au);
            editStoryPrivacyFragment.at.setVisibility(0);
            m22615b();
        }

        private void m22615b() {
            if (this.f15045a.ap != null) {
                this.f15045a.kO_().a().a(this.f15045a.ap).c();
            }
        }
    }

    /* compiled from: fetch sticker metadata failed */
    public class C10215 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditStoryPrivacyFragment f15048a;

        public C10215(EditStoryPrivacyFragment editStoryPrivacyFragment) {
            this.f15048a = editStoryPrivacyFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f15048a.f15053d.a(Events.EDIT_STORY_PRIVACY_DISCARD);
            EditStoryPrivacyFragment.ax(this.f15048a);
        }
    }

    /* compiled from: fetch sticker metadata failed */
    public class C10226 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditStoryPrivacyFragment f15049a;

        public C10226(EditStoryPrivacyFragment editStoryPrivacyFragment) {
            this.f15049a = editStoryPrivacyFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: fetch sticker metadata failed */
    enum PrivacyFragmentTask {
        FETCH_PRIVACY_FROM_ATF,
        SET_STORY_PRIVACY_FROM_ATF
    }

    public static void m22623a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((EditStoryPrivacyFragment) obj).m22620a(DefaultAndroidThreadUtil.b(injectorLike), AudienceSelectorPerformanceLogger.m22742a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), PrivacyAnalyticsLogger.b(injectorLike), PrivacyPerformanceLogger.m22571a(injectorLike), PrivacyOperationsClient.m22544a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike));
    }

    public final void m22627c(Bundle bundle) {
        super.c(bundle);
        Class cls = EditStoryPrivacyFragment.class;
        m22623a(this, getContext());
        Preconditions.checkNotNull(this.s);
        this.al = (EditStoryPrivacyParams) this.s.getParcelable("params");
    }

    @Inject
    private void m22620a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, AudienceSelectorPerformanceLogger audienceSelectorPerformanceLogger, AbstractFbErrorReporter abstractFbErrorReporter, PrivacyAnalyticsLogger privacyAnalyticsLogger, PrivacyPerformanceLogger privacyPerformanceLogger, PrivacyOperationsClient privacyOperationsClient, TasksManager tasksManager, Toaster toaster, InputMethodManager inputMethodManager) {
        this.f15050a = defaultAndroidThreadUtil;
        this.f15051b = audienceSelectorPerformanceLogger;
        this.f15052c = abstractFbErrorReporter;
        this.f15053d = privacyAnalyticsLogger;
        this.f15054e = privacyPerformanceLogger;
        this.f15055f = privacyOperationsClient;
        this.f15056g = tasksManager;
        this.f15057h = toaster;
        this.f15058i = inputMethodManager;
    }

    public final View m22625a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1463671759);
        this.f15051b.m22744a(Caller.EDIT_STORY_PRIVACY_FRAGMENT);
        this.f15053d.a(Events.EDIT_STORY_PRIVACY_OPEN);
        this.ar = layoutInflater.inflate(2130903959, null);
        this.at = this.ar.findViewById(2131561139);
        View view = this.ar;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1999083659, a);
        return view;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 98872170);
        super.mi_();
        this.ap = ProgressDialogFragment.a(2131234226, true, true, false);
        this.as = this.ar.findViewById(2131561140);
        this.as.setClickable(true);
        this.as.setOnClickListener(new C10182(this));
        as(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1223011666, a);
    }

    public final void m22624I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1794053335);
        this.f15056g.c();
        this.f15050a = null;
        this.f15052c = null;
        this.f15053d = null;
        this.f15054e = null;
        this.f15055f = null;
        this.f15056g = null;
        this.f15057h = null;
        this.am = null;
        this.an = null;
        this.ao = null;
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1020321691, a);
    }

    public final void m22626b() {
        this.f15056g.c(PrivacyFragmentTask.SET_STORY_PRIVACY_FROM_ATF);
        this.f15056g.c(PrivacyFragmentTask.FETCH_PRIVACY_FROM_ATF);
        if (this.ao == null) {
            ax(this);
        } else if (this.ao.m22846b()) {
            au();
            if (av()) {
                Builder builder = new Builder(getContext());
                builder.a(true);
                builder.a(b(2131234229));
                builder.b(b(2131234230));
                builder.a(b(2131234231), new C10215(this));
                builder.b(b(2131234232), new C10226(this));
                builder.a().show();
                return;
            }
            this.f15053d.a(Events.EDIT_STORY_PRIVACY_CANCEL);
            ax(this);
        }
    }

    public static void as(EditStoryPrivacyFragment editStoryPrivacyFragment) {
        editStoryPrivacyFragment.as.setVisibility(8);
        editStoryPrivacyFragment.ap.a(editStoryPrivacyFragment.kO_(), null);
        PrivacyOperationsClient privacyOperationsClient = editStoryPrivacyFragment.f15055f;
        String str = editStoryPrivacyFragment.al.f15064b;
        Iterable arrayList = new ArrayList();
        arrayList.add(privacyOperationsClient.m22551a(DataFreshnessParam.STALE_DATA_OKAY));
        arrayList.add(privacyOperationsClient.m22567c(str));
        editStoryPrivacyFragment.f15056g.a(PrivacyFragmentTask.FETCH_PRIVACY_FROM_ATF, Futures.a(Futures.a(arrayList), new C09932(privacyOperationsClient)), new C10193(editStoryPrivacyFragment));
    }

    private void au() {
        SelectablePrivacyData e = this.ao.m22848e();
        this.an = e.f15109d;
        this.aq = e.f15107b;
    }

    public final void m22628e() {
        this.f15058i.hideSoftInputFromWindow(this.T.getWindowToken(), 0);
        if (this.ao == null) {
            ax(this);
            return;
        }
        au();
        if (av()) {
            final DialogFragment a = ProgressDialogFragment.a(2131234227, true, true, false);
            a.a(kO_(), null);
            this.f15054e.f14972a.b(1441798);
            this.f15056g.a(PrivacyFragmentTask.SET_STORY_PRIVACY_FROM_ATF, this.f15055f.m22563a(this.al.f15064b, this.al.f15063a, this.al.f15065c, this.an), new AbstractDisposableFutureCallback<GraphQLVisitableModel>(this) {
                final /* synthetic */ EditStoryPrivacyFragment f15047b;

                protected final void m22618a(Object obj) {
                    GraphQLVisitableModel graphQLVisitableModel = (GraphQLVisitableModel) obj;
                    a.a();
                    this.f15047b.f15053d.a(Events.EDIT_STORY_PRIVACY_SAVED);
                    this.f15047b.f15054e.m22573a(true);
                    this.f15047b.m22621a(graphQLVisitableModel);
                }

                protected final void m22619a(Throwable th) {
                    a.a();
                    this.f15047b.f15053d.a(Events.EDIT_STORY_PRIVACY_SAVE_FAILED);
                    this.f15047b.f15054e.m22573a(false);
                    EditStoryPrivacyFragment editStoryPrivacyFragment = this.f15047b;
                    GraphQLPrivacyOption graphQLPrivacyOption = this.f15047b.an;
                    editStoryPrivacyFragment.f15052c.a("edit_privacy_fragment_set_api_error", StringFormatUtil.a("Error setting story privacy %s", new Object[]{graphQLPrivacyOption}), th);
                    editStoryPrivacyFragment.f15057h.b(new ToastBuilder(2131234237));
                }
            });
            return;
        }
        ax(this);
    }

    private boolean av() {
        SelectablePrivacyData selectablePrivacyData = this.am.f15110a;
        if (selectablePrivacyData.f15109d != null && PrivacyOptionHelper.a(selectablePrivacyData.f15109d, this.an) && this.aq == selectablePrivacyData.f15107b) {
            return false;
        }
        return true;
    }

    private void m22621a(GraphQLVisitableModel graphQLVisitableModel) {
        if (ao() != null && !ao().isFinishing()) {
            PrivacyScopeModel j = ((SetStoryPrivacyCoreMutationFieldsModel) graphQLVisitableModel).m6079a().m6100j();
            Intent intent = new Intent();
            if (!(j == null || j.m6090a() == null || j.m6090a().m6085a() == null)) {
                FlatBufferModelHelper.a(intent, "privacy_option_to_upsell", j.m6090a().m6085a());
            }
            ao().setResult(-1, intent);
            ax(this);
        }
    }

    public static void ax(EditStoryPrivacyFragment editStoryPrivacyFragment) {
        editStoryPrivacyFragment.o().finish();
    }
}

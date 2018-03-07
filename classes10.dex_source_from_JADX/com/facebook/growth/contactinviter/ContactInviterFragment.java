package com.facebook.growth.contactinviter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.locale.Locales;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.calls.FreeFbInvitableContactListTypeInputFreeFbInvitableContactListType;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.MobileContactInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.growth.contactinviter.PhoneContactFetcher.GetPhoneBookTask;
import com.facebook.growth.contactinviter.PhoneContactToken.State;
import com.facebook.growth.contactinviter.graphql.ContactInviter.UploadContactsQueryString;
import com.facebook.growth.contactinviter.graphql.ContactInviterLogger;
import com.facebook.growth.contactinviter.graphql.ContactInviterLogger.ActionType;
import com.facebook.growth.contactinviter.graphql.ContactInviterModels.UploadContactsQueryModel;
import com.facebook.growth.contactinviter.graphql.ContactInviterModels.UploadContactsQueryModel.FreeFbInvitableContactListModel.InvitableContactsModel;
import com.facebook.growth.util.PhonebookUtils;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBar.OnActionButtonClickListener;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.recyclerview.BetterLinearLayoutManager;
import com.facebook.widget.recyclerview.BetterRecyclerView;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TEXTURE_VIEW */
public class ContactInviterFragment extends FbFragment {
    @Inject
    ContactInviterAdapter f23277a;
    private OnCompleteListener al;
    private BetterRecyclerView am;
    private LinearLayout an;
    private FbButton ao;
    public LoadingIndicatorView ap;
    public List<PhoneContactToken> aq;
    @Inject
    SecureContextHelper f23278b;
    @Inject
    public TasksManager f23279c;
    @Inject
    PhoneContactFetcher f23280d;
    @Inject
    ContactInviterLogger f23281e;
    @Inject
    public ContactInviterPhoneFetcher f23282f;
    @Inject
    public FunnelLoggerImpl f23283g;
    public boolean f23284h;
    public int f23285i;

    /* compiled from: TEXTURE_VIEW */
    class C33541 implements OnClickListener {
        final /* synthetic */ ContactInviterFragment f23269a;

        C33541(ContactInviterFragment contactInviterFragment) {
            this.f23269a = contactInviterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -388350732);
            this.f23269a.m24614b();
            Logger.a(2, EntryType.UI_INPUT_END, -441462912, a);
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public class C33552 {
        final /* synthetic */ ContactInviterFragment f23270a;

        C33552(ContactInviterFragment contactInviterFragment) {
            this.f23270a = contactInviterFragment;
        }

        public final void m24600a(List<PhoneContactToken> list) {
            ContactInviterFragment contactInviterFragment = this.f23270a;
            contactInviterFragment.ap.a();
            ContactInviterPhoneFetcher contactInviterPhoneFetcher = contactInviterFragment.f23282f;
            GraphQlQueryString uploadContactsQueryString = new UploadContactsQueryString();
            uploadContactsQueryString.a("type", FreeFbInvitableContactListTypeInputFreeFbInvitableContactListType.INVITABLE);
            uploadContactsQueryString.a("meta_data", "");
            if (list != null) {
                List arrayList = new ArrayList();
                for (PhoneContactToken phoneContactToken : list) {
                    MobileContactInputData mobileContactInputData = new MobileContactInputData();
                    mobileContactInputData.a("name", phoneContactToken.f23315a);
                    GraphQlCallInput graphQlCallInput = mobileContactInputData;
                    graphQlCallInput.a("contact_point", phoneContactToken.f23316b);
                    arrayList.add(graphQlCallInput);
                }
                uploadContactsQueryString.a("list", arrayList);
            }
            contactInviterFragment.f23279c.a("upload_contacts_task", contactInviterPhoneFetcher.f23298a.a(GraphQLRequest.a(uploadContactsQueryString)), new C33563(contactInviterFragment));
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public class C33563 extends AbstractDisposableFutureCallback<GraphQLResult<UploadContactsQueryModel>> {
        final /* synthetic */ ContactInviterFragment f23271a;

        public C33563(ContactInviterFragment contactInviterFragment) {
            this.f23271a = contactInviterFragment;
        }

        protected final void m24601a(Object obj) {
            List list;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ContactInviterFragment contactInviterFragment = this.f23271a;
            ContactInviterPhoneFetcher contactInviterPhoneFetcher = this.f23271a.f23282f;
            if (graphQLResult == null || graphQLResult.e == null || ((UploadContactsQueryModel) graphQLResult.e).m24643a() == null || ((UploadContactsQueryModel) graphQLResult.e).m24643a().m24638a().isEmpty()) {
                list = null;
            } else {
                ImmutableList a = ((UploadContactsQueryModel) graphQLResult.e).m24643a().m24638a();
                contactInviterPhoneFetcher.f23299b.m24623a(((UploadContactsQueryModel) graphQLResult.e).m24643a().m24639j());
                List arrayList = new ArrayList();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    InvitableContactsModel invitableContactsModel = (InvitableContactsModel) a.get(i);
                    arrayList.add(new PhoneContactToken(invitableContactsModel.m24634j(), invitableContactsModel.m24633a()));
                }
                list = arrayList;
            }
            ContactInviterFragment.m24609b(contactInviterFragment, list);
        }

        protected final void m24602a(Throwable th) {
            ContactInviterFragment contactInviterFragment = this.f23271a;
            contactInviterFragment.f23283g.b(FunnelRegistry.E, "contact_invite_list_fetch_failed");
            contactInviterFragment.ap.a(contactInviterFragment.jW_().getString(2131230759), new C33574(contactInviterFragment));
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public class C33574 implements RetryClickedListener {
        final /* synthetic */ ContactInviterFragment f23272a;

        public C33574(ContactInviterFragment contactInviterFragment) {
            this.f23272a = contactInviterFragment;
        }

        public final void m24603a() {
            this.f23272a.m24614b();
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public class C33585 implements OnClickListener {
        final /* synthetic */ ContactInviterFragment f23273a;

        public C33585(ContactInviterFragment contactInviterFragment) {
            this.f23273a = contactInviterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 334645149);
            this.f23273a.f23283g.a(FunnelRegistry.E, "contact_invite_list_close", "title_bar_back");
            ContactInviterFragment.as(this.f23273a);
            Logger.a(2, EntryType.UI_INPUT_END, 978893135, a);
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public class C33596 implements OnActionButtonClickListener {
        final /* synthetic */ ContactInviterFragment f23274a;

        public C33596(ContactInviterFragment contactInviterFragment) {
            this.f23274a = contactInviterFragment;
        }

        public final void m24604a(View view) {
            this.f23274a.f23283g.a(FunnelRegistry.E, "contact_invite_list_close", "done_click");
            ContactInviterFragment.as(this.f23274a);
        }
    }

    /* compiled from: TEXTURE_VIEW */
    public interface OnCompleteListener {
        void m24605a(List<PhoneContactToken> list);
    }

    public static void m24608a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ContactInviterFragment) obj).m24606a(new ContactInviterAdapter(Locales.a(injectorLike), FreeFbJsonParams.m24621a(injectorLike)), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.b(injectorLike), new PhoneContactFetcher(PhonebookUtils.b(injectorLike)), new ContactInviterLogger(IdBasedSingletonScopeProvider.b(injectorLike, 175)), new ContactInviterPhoneFetcher(GraphQLQueryExecutor.a(injectorLike), FreeFbJsonParams.m24621a(injectorLike)), FunnelLoggerImpl.a(injectorLike));
    }

    private void m24606a(ContactInviterAdapter contactInviterAdapter, SecureContextHelper secureContextHelper, TasksManager tasksManager, PhoneContactFetcher phoneContactFetcher, ContactInviterLogger contactInviterLogger, ContactInviterPhoneFetcher contactInviterPhoneFetcher, FunnelLoggerImpl funnelLoggerImpl) {
        this.f23277a = contactInviterAdapter;
        this.f23278b = secureContextHelper;
        this.f23279c = tasksManager;
        this.f23280d = phoneContactFetcher;
        this.f23281e = contactInviterLogger;
        this.f23282f = contactInviterPhoneFetcher;
        this.f23283g = funnelLoggerImpl;
    }

    public final void a_(Context context) {
        super.a_(context);
        this.al = (OnCompleteListener) context;
    }

    public final void dE_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1367060608);
        super.dE_();
        this.al = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1742180438, a);
    }

    public final View m24611a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 191581699);
        Class cls = ContactInviterFragment.class;
        m24608a((Object) this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.f23284h = bundle2.getBoolean("has_title_bar", false);
            this.f23285i = bundle2.getInt("title_bar_title_string_id", 2131236381);
            ContactInviterLogger.f23318a = bundle2.getString("analytics_tag", "unknown");
        }
        View inflate = layoutInflater.inflate(2130903762, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1558106821, a);
        return inflate;
    }

    public final void m24612a(View view, @Nullable Bundle bundle) {
        super.c(bundle);
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) e(2131558563);
        if (this.f23284h) {
            fb4aTitleBar.setTitle(this.f23285i);
            fb4aTitleBar.setHasBackButton(true);
            fb4aTitleBar.a(new C33585(this));
            List arrayList = new ArrayList();
            Builder a = TitleBarButtonSpec.a();
            a.g = jW_().getString(2131230733);
            arrayList.add(a.a());
            fb4aTitleBar.setButtonSpecs(arrayList);
            fb4aTitleBar.setActionButtonOnClickListener(new C33596(this));
        } else {
            fb4aTitleBar.setVisibility(8);
        }
        this.aq = new ArrayList();
        this.am = (BetterRecyclerView) e(2131560708);
        this.ap = (LoadingIndicatorView) e(2131560407);
        this.an = (LinearLayout) e(2131560709);
        this.ao = (FbButton) e(2131560710);
        this.am.setLayoutManager(new BetterLinearLayoutManager(view.getContext()));
        this.f23277a.f23265a = this;
        this.am.setAdapter(this.f23277a);
        m24614b();
        this.ao.setOnClickListener(new C33541(this));
    }

    public final void m24610I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1538260707);
        this.f23279c.c();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -269959338, a);
    }

    public final void m24614b() {
        this.an.setVisibility(8);
        this.ap.a();
        PhoneContactFetcher phoneContactFetcher = this.f23280d;
        phoneContactFetcher.f23314b = new C33552(this);
        new GetPhoneBookTask(phoneContactFetcher).execute(new Void[0]);
    }

    public static void m24609b(@Nullable ContactInviterFragment contactInviterFragment, List list) {
        contactInviterFragment.ap.b();
        if (list == null) {
            contactInviterFragment.f23283g.a(FunnelRegistry.E, "contact_invite_list_fetch_success", "empty");
            contactInviterFragment.an.setVisibility(0);
            return;
        }
        contactInviterFragment.f23283g.a(FunnelRegistry.E, "contact_invite_list_fetch_success", Integer.toString(list.size()));
        ContactInviterAdapter contactInviterAdapter = contactInviterFragment.f23277a;
        contactInviterAdapter.f23267c = list;
        List list2 = contactInviterAdapter.f23267c;
        Collator.getInstance(contactInviterAdapter.f23266b.a()).setStrength(0);
        Collections.sort(list2);
        contactInviterAdapter.notifyDataSetChanged();
    }

    public static void as(ContactInviterFragment contactInviterFragment) {
        if (contactInviterFragment.al != null) {
            contactInviterFragment.al.m24605a(contactInviterFragment.aq);
        }
    }

    public final void m24613a(PhoneContactToken phoneContactToken) {
        phoneContactToken.f23317c = State.UNINVITED;
        Iterator it = this.aq.iterator();
        while (it.hasNext()) {
            if (((PhoneContactToken) it.next()).f23316b.equals(phoneContactToken.f23316b)) {
                it.remove();
            }
        }
        this.f23277a.notifyDataSetChanged();
        m24607a(ActionType.UNDO, phoneContactToken.f23316b);
        this.f23283g.b(FunnelRegistry.E, "contact_invite_list_item_undo_button_click");
    }

    public final void m24615b(PhoneContactToken phoneContactToken) {
        Uri parse = Uri.parse("smsto:" + phoneContactToken.f23316b);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(parse);
        intent.putExtra("sms_body", "fb.com/inv?r=" + phoneContactToken.m24625a());
        this.f23278b.b(intent, 199, o());
        m24607a(ActionType.SMS, phoneContactToken.f23316b);
        this.f23283g.b(FunnelRegistry.E, "contact_invite_list_item_add_sms_button_click");
    }

    public final void m24616c(final PhoneContactToken phoneContactToken) {
        this.aq.add(phoneContactToken);
        phoneContactToken.f23317c = State.PENDING;
        this.f23277a.notifyDataSetChanged();
        HandlerDetour.b(new Handler(), new Runnable(this) {
            final /* synthetic */ ContactInviterFragment f23276b;

            public void run() {
                if (phoneContactToken.f23317c == State.PENDING) {
                    phoneContactToken.f23317c = State.INVITED;
                    this.f23276b.f23277a.notifyDataSetChanged();
                }
            }
        }, 4000, -235174681);
        m24607a(ActionType.INVITE, phoneContactToken.f23316b);
        this.f23283g.b(FunnelRegistry.E, "contact_invite_list_item_invite_button_click");
    }

    private void m24607a(ActionType actionType, String str) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("contact_inviter_action_click");
        honeyClientEvent.a("action_type", actionType);
        honeyClientEvent.b("phone_number", str);
        ContactInviterLogger contactInviterLogger = this.f23281e;
        honeyClientEvent.b("tag", ContactInviterLogger.f23318a);
        honeyClientEvent.c = "CONTACT_INVITER";
        ((AnalyticsLogger) contactInviterLogger.f23319b.get()).a(honeyClientEvent);
    }
}

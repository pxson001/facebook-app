package com.facebook.events.invite;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import com.facebook.apptab.ui.chrome.FinishHandler;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.Tuple;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursors;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.module.ContactLinkQueryType;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.EventSpecificSuggestedInviteCandidatesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSpecificUninvitableFriendsAndInviteeLimitString;
import com.facebook.events.graphql.EventsGraphQL.EventsSuggestedInviteCandidatesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventsUninvitableFriendsAndInviteeLimitString;
import com.facebook.events.graphql.EventsGraphQL.GroupEventFriendInviteCandidatesQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificSuggestedInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificSuggestedInviteCandidatesQueryModel.InviteeCandidatesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificUninvitableFriendsAndInviteeLimitModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificUninvitableFriendsAndInviteeLimitModel.UninvitableFriendsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsSuggestedInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsSuggestedInviteCandidatesQueryModel.EventInviteeCandidatesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsUninvitableFriendsAndInviteeLimitModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventsUninvitableFriendsAndInviteeLimitModel.EventUninvitableFriendsModel;
import com.facebook.events.graphql.EventsGraphQLModels.GroupEventFriendInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.GroupEventFriendInviteCandidatesQueryModel.GroupMembersModel.EdgesModel;
import com.facebook.events.invite.InviteSubSession.InviteSubSessionTypes;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.graphql.enums.GraphQLEventInviteeStatusType;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.user.model.User;
import com.facebook.userfilter.TypeaheadUserSearchFilter;
import com.facebook.userfilter.TypeaheadUserSearchFilterProvider;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.friendselector.GenericFriendsSelectorFragment;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.android.externalstorage.documents */
public class CaspianFriendSelectorFragment extends GenericFriendsSelectorFragment {
    public static final String aF = CaspianFriendSelectorFragment.class.getSimpleName();
    @Inject
    public InviteSessionLogger aA;
    @Inject
    EventEventLogger aB;
    @ContactLinkQueryType
    @Inject
    ContactLinkType aC;
    @Inject
    @IsWorkBuild
    Boolean aD;
    @Inject
    TypeaheadUserSearchFilterProvider aE;
    public GraphQLBatchRequest aG;
    public ImmutableMap<String, EventInviteeToken> aH;
    public final ArrayList<String> aI = new ArrayList();
    public List<String> aJ;
    public List<String> aK;
    public List<String> aL;
    public String aM;
    public String aN;
    public int aO;
    public int aP = Integer.MAX_VALUE;
    public TypeaheadUserSearchFilter aQ;
    @Nullable
    private OnFriendsSelectedListener aR;
    @Inject
    GraphQLQueryExecutor au;
    @Inject
    @ForUiThread
    public ExecutorService av;
    @Inject
    ContactCursors aw;
    @Inject
    AbstractFbErrorReporter ax;
    @Inject
    InviteeIteratorProvider ay;
    @Inject
    InvitePickerPerformanceLogger az;

    /* compiled from: com.android.externalstorage.documents */
    class C24641 implements OnDrawListener {
        final /* synthetic */ CaspianFriendSelectorFragment f17481a;

        C24641(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17481a = caspianFriendSelectorFragment;
        }

        public final boolean gD_() {
            if (this.f17481a.aH == null) {
                return false;
            }
            this.f17481a.az.m18045c();
            this.f17481a.aA.m18052a(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
            this.f17481a.aA.m18052a(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
            return true;
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    class C24652 implements TextWatcher {
        final /* synthetic */ CaspianFriendSelectorFragment f17482a;

        C24652(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17482a = caspianFriendSelectorFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            switch (editable.length()) {
                case 0:
                    this.f17482a.aA.m18055b(InviteSubSessionTypes.INVITE_SEARCH);
                    return;
                case 1:
                    this.f17482a.aA.m18052a(InviteSubSessionTypes.INVITE_SEARCH);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public class C24663 implements FutureCallback<GroupEventFriendInviteCandidatesQueryModel> {
        final /* synthetic */ CaspianFriendSelectorFragment f17483a;

        public C24663(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17483a = caspianFriendSelectorFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            GroupEventFriendInviteCandidatesQueryModel groupEventFriendInviteCandidatesQueryModel = (GroupEventFriendInviteCandidatesQueryModel) obj;
            if (!this.f17483a.aw() && groupEventFriendInviteCandidatesQueryModel != null && groupEventFriendInviteCandidatesQueryModel.a() != null) {
                ImmutableList a = groupEventFriendInviteCandidatesQueryModel.a().a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EdgesModel edgesModel = (EdgesModel) a.get(i);
                    if (edgesModel.a() != null) {
                        this.f17483a.aI.add(edgesModel.a().j());
                        CaspianFriendSelectorFragment.m17855h(this.f17483a, true);
                    }
                }
            }
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17483a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch group invitees");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public class C24674 implements FutureCallback<EventSpecificSuggestedInviteCandidatesQueryModel> {
        final /* synthetic */ CaspianFriendSelectorFragment f17484a;

        public C24674(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17484a = caspianFriendSelectorFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            EventSpecificSuggestedInviteCandidatesQueryModel eventSpecificSuggestedInviteCandidatesQueryModel = (EventSpecificSuggestedInviteCandidatesQueryModel) obj;
            if (!this.f17484a.aw()) {
                List arrayList = new ArrayList();
                if (eventSpecificSuggestedInviteCandidatesQueryModel != null && eventSpecificSuggestedInviteCandidatesQueryModel.a() != null) {
                    ImmutableList a = eventSpecificSuggestedInviteCandidatesQueryModel.a().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        InviteeCandidatesModel.EdgesModel edgesModel = (InviteeCandidatesModel.EdgesModel) a.get(i);
                        if (edgesModel.a() != null) {
                            arrayList.add(edgesModel.a().j());
                        }
                    }
                    this.f17484a.aK = arrayList;
                    CaspianFriendSelectorFragment.aY(this.f17484a);
                }
            }
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17484a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch suggested facebook friends");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public class C24685 implements FutureCallback<EventSpecificUninvitableFriendsAndInviteeLimitModel> {
        final /* synthetic */ CaspianFriendSelectorFragment f17485a;

        public C24685(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17485a = caspianFriendSelectorFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            EventSpecificUninvitableFriendsAndInviteeLimitModel eventSpecificUninvitableFriendsAndInviteeLimitModel = (EventSpecificUninvitableFriendsAndInviteeLimitModel) obj;
            if (!this.f17485a.aw()) {
                Collection arrayList = new ArrayList();
                Collection arrayList2 = new ArrayList();
                if (!(eventSpecificUninvitableFriendsAndInviteeLimitModel == null || eventSpecificUninvitableFriendsAndInviteeLimitModel.j() == null)) {
                    ImmutableList a = eventSpecificUninvitableFriendsAndInviteeLimitModel.j().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        UninvitableFriendsModel.EdgesModel edgesModel = (UninvitableFriendsModel.EdgesModel) a.get(i);
                        if (CaspianFriendSelectorFragment.m17851c(edgesModel.j()) && edgesModel.a() != null) {
                            arrayList2.add(edgesModel.a().j());
                        } else if (CaspianFriendSelectorFragment.m17852d(edgesModel.j()) && edgesModel.a() != null) {
                            arrayList.add(edgesModel.a().j());
                        }
                    }
                }
                if (!(eventSpecificUninvitableFriendsAndInviteeLimitModel == null || eventSpecificUninvitableFriendsAndInviteeLimitModel.a() == null)) {
                    this.f17485a.aP = eventSpecificUninvitableFriendsAndInviteeLimitModel.a().a();
                }
                this.f17485a.aJ = arrayList;
                this.f17485a.aL = arrayList2;
                this.f17485a.aQ.b(arrayList);
                this.f17485a.aQ.a(arrayList2);
                CaspianFriendSelectorFragment.aW(this.f17485a);
            }
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17485a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch invitees restrictions");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public class C24696 implements FutureCallback<EventsSuggestedInviteCandidatesQueryModel> {
        final /* synthetic */ CaspianFriendSelectorFragment f17486a;

        public C24696(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17486a = caspianFriendSelectorFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            EventsSuggestedInviteCandidatesQueryModel eventsSuggestedInviteCandidatesQueryModel = (EventsSuggestedInviteCandidatesQueryModel) obj;
            if (!this.f17486a.aw()) {
                List arrayList = new ArrayList();
                if (eventsSuggestedInviteCandidatesQueryModel != null && eventsSuggestedInviteCandidatesQueryModel.a() != null) {
                    ImmutableList a = eventsSuggestedInviteCandidatesQueryModel.a().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EventInviteeCandidatesModel.EdgesModel edgesModel = (EventInviteeCandidatesModel.EdgesModel) a.get(i);
                        if (edgesModel.a() != null) {
                            arrayList.add(edgesModel.a().j());
                        }
                    }
                    this.f17486a.aK = arrayList;
                    CaspianFriendSelectorFragment.aY(this.f17486a);
                }
            }
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17486a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch suggested facebook friends");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public class C24707 implements FutureCallback<EventsUninvitableFriendsAndInviteeLimitModel> {
        final /* synthetic */ CaspianFriendSelectorFragment f17487a;

        public C24707(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17487a = caspianFriendSelectorFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            EventsUninvitableFriendsAndInviteeLimitModel eventsUninvitableFriendsAndInviteeLimitModel = (EventsUninvitableFriendsAndInviteeLimitModel) obj;
            if (!this.f17487a.aw()) {
                Collection arrayList = new ArrayList();
                Collection arrayList2 = new ArrayList();
                if (!(eventsUninvitableFriendsAndInviteeLimitModel == null || eventsUninvitableFriendsAndInviteeLimitModel.j() == null)) {
                    ImmutableList a = eventsUninvitableFriendsAndInviteeLimitModel.j().a();
                    int size = a.size();
                    for (int i = 0; i < size; i++) {
                        EventUninvitableFriendsModel.EdgesModel edgesModel = (EventUninvitableFriendsModel.EdgesModel) a.get(i);
                        if (CaspianFriendSelectorFragment.m17851c(edgesModel.j()) && edgesModel.a() != null) {
                            arrayList2.add(edgesModel.a().j());
                        } else if (CaspianFriendSelectorFragment.m17852d(edgesModel.j()) && edgesModel.a() != null) {
                            arrayList.add(edgesModel.a().j());
                        }
                    }
                }
                this.f17487a.aJ = arrayList;
                this.f17487a.aL = arrayList2;
                if (eventsUninvitableFriendsAndInviteeLimitModel != null) {
                    this.f17487a.aP = eventsUninvitableFriendsAndInviteeLimitModel.a();
                }
                this.f17487a.aQ.b(arrayList);
                this.f17487a.aQ.a(arrayList2);
                CaspianFriendSelectorFragment.aW(this.f17487a);
            }
        }

        public void onFailure(Throwable th) {
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17487a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch invitees restrictions");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    class C24729 extends AbstractDisposableFutureCallback<ImmutableMap<String, EventInviteeToken>> {
        final /* synthetic */ CaspianFriendSelectorFragment f17490a;

        C24729(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
            this.f17490a = caspianFriendSelectorFragment;
        }

        protected final void m17844a(Object obj) {
            ImmutableMap immutableMap = (ImmutableMap) obj;
            if (!this.f17490a.aw()) {
                this.f17490a.aH = immutableMap;
                this.f17490a.as.setEnabled(true);
                CaspianFriendSelectorFragment.aW(this.f17490a);
            }
        }

        protected final void m17845a(Throwable th) {
            this.f17490a.az.m18044b();
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17490a.ax;
            SoftErrorBuilder a = SoftError.a(CaspianFriendSelectorFragment.aF, "Failed to fetch facebook friends");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: com.android.externalstorage.documents */
    public interface OnFriendsSelectedListener {
        void mo805a(long[] jArr);
    }

    public static void m17849a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CaspianFriendSelectorFragment) obj).m17848a(GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ContactCursors.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (InviteeIteratorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(InviteeIteratorProvider.class), InvitePickerPerformanceLogger.m18041a(injectorLike), InviteSessionLogger.m18047a(injectorLike), EventEventLogger.m18119b(injectorLike), ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.b(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), (TypeaheadUserSearchFilterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TypeaheadUserSearchFilterProvider.class));
    }

    public final void m17861c(Bundle bundle) {
        super.c(bundle);
        Class cls = CaspianFriendSelectorFragment.class;
        m17849a((Object) this, getContext());
        this.aQ = this.aE.a(this.al.e());
    }

    public final void m17862d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -290037678);
        super.d(bundle);
        View view = this.T;
        this.aM = this.s.getString("event_id");
        this.aN = this.s.getString("group_id");
        this.aO = 7;
        this.aG = new GraphQLBatchRequest("CaspianFriendSelector");
        if (bundle == null) {
            long[] longArray = this.s.getLongArray("profiles");
            Iterable arrayList = new ArrayList();
            if (longArray != null) {
                for (long valueOf : longArray) {
                    arrayList.add(String.valueOf(valueOf));
                }
            }
            Builder builder = ImmutableSet.builder();
            builder.b(this.ap);
            builder.b(arrayList);
            this.ap = builder.b();
        }
        m17853e();
        this.ao.c(view).a(new C24641(this));
        this.as.addTextChangedListener(new C24652(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1329190738, a);
    }

    public final void a_(Context context) {
        super.a_(context);
        this.aR = (OnFriendsSelectedListener) a(OnFriendsSelectedListener.class);
    }

    protected final boolean aN() {
        return true;
    }

    protected final int m17860b(String str) {
        if ("all_friends_suggestion_section".equals(str)) {
            return 2131237174;
        }
        return super.b(str);
    }

    protected final ImmutableList<String> aD() {
        if (this.aD.booleanValue()) {
            return super.aD();
        }
        return ImmutableList.of("all_friends_suggestion_section", GenericFriendsSelectorFragment.a);
    }

    private void m17848a(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, ContactCursors contactCursors, AbstractFbErrorReporter abstractFbErrorReporter, InviteeIteratorProvider inviteeIteratorProvider, InvitePickerPerformanceLogger invitePickerPerformanceLogger, InviteSessionLogger inviteSessionLogger, EventEventLogger eventEventLogger, ContactLinkType contactLinkType, Boolean bool, TypeaheadUserSearchFilterProvider typeaheadUserSearchFilterProvider) {
        this.au = graphQLQueryExecutor;
        this.av = executorService;
        this.aw = contactCursors;
        this.ax = abstractFbErrorReporter;
        this.ay = inviteeIteratorProvider;
        this.az = invitePickerPerformanceLogger;
        this.aA = inviteSessionLogger;
        this.aB = eventEventLogger;
        this.aC = contactLinkType;
        this.aD = bool;
        this.aE = typeaheadUserSearchFilterProvider;
    }

    protected final Tuple<ImmutableSet<SimpleUserToken>, SectionedListSection<? extends BaseToken>> m17858a(String str, Map<String, ImmutableList<User>> map) {
        if (str.equals("all_friends_suggestion_section")) {
            ImmutableList immutableList;
            if (this.aH == null || this.aK == null || this.aK.isEmpty()) {
                immutableList = null;
            } else {
                ImmutableList.Builder builder = new ImmutableList.Builder();
                for (String str2 : this.aK) {
                    if (this.aH.get(str2) != null) {
                        builder.c(this.aH.get(str2));
                    }
                }
                immutableList = builder.b();
            }
            ImmutableList immutableList2 = immutableList;
            if (immutableList2 == null) {
                return null;
            }
            return new Tuple(null, new ImmutableSectionedListSection(jW_().getString(m17860b(str)), immutableList2));
        } else if ((!GenericFriendsSelectorFragment.a.equals(str) && !GenericFriendsSelectorFragment.b.equals(str)) || this.aH == null || this.aH.size() == 0) {
            return null;
        } else {
            return new Tuple(null, new ImmutableSectionedListSection(jW_().getString(m17860b(str)), ImmutableList.copyOf(this.aH.values())));
        }
    }

    protected final void aG() {
        if (this.aD.booleanValue()) {
            this.at.setVisibility(0);
        }
        this.aQ.a(this.as.getUserEnteredPlainText(), this.aN);
    }

    protected final void m17863g(int i) {
        BaseToken baseToken = (BaseToken) aq().getItem(i);
        if (baseToken != null && baseToken.a()) {
            if (a(baseToken)) {
                m17856i(i);
            } else if (aC() - this.ar.size() != 0) {
                m17854h(i);
                if (bd()) {
                    this.as.selectAll();
                    this.g.showSoftInput(this.as, 0);
                }
            }
            super.g(i);
        }
    }

    protected final void aH() {
        FinishHandler finishHandler = (FinishHandler) a(FinishHandler.class);
        if (finishHandler == null || this.aR == null) {
            Intent intent = new Intent();
            intent.putExtra("profiles", be());
            intent.putExtra("event_id", this.aM);
            intent.putExtra("extra_invite_action_mechanism", this.s.getString("extra_invite_action_mechanism"));
            o().setResult(-1, intent);
            o().finish();
            return;
        }
        this.aR.mo805a(be());
        finishHandler.b();
    }

    protected final int aC() {
        return this.aP;
    }

    protected final boolean m17859a(String str) {
        if (this.aL == null || !this.aL.contains(str)) {
            return true;
        }
        return false;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2001021455);
        super.mY_();
        this.az.m18046d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -165950028, a);
    }

    public final void m17857I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 403033397);
        this.aA.m18055b(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL);
        this.aA.m18055b(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED);
        this.aB.m18135a(this.aM, this.aA.m18051a());
        this.aA.m18054b();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1299018506, a);
    }

    private void m17853e() {
        if (this.aD.booleanValue() || this.aN == null) {
            m17855h(this, false);
        } else {
            GraphQlQueryString groupEventFriendInviteCandidatesQueryString = new GroupEventFriendInviteCandidatesQueryString();
            groupEventFriendInviteCandidatesQueryString.a("group_id", this.aN);
            Futures.a(GraphQLQueryExecutor.a(this.aG.b(GraphQLRequest.a(groupEventFriendInviteCandidatesQueryString).a(GraphQLCachePolicy.c))), new C24663(this), this.av);
        }
        if (this.aM != null) {
            EventSpecificSuggestedInviteCandidatesQueryString o = EventsGraphQL.o();
            o.a("event_id", this.aM).a("first_count", String.valueOf(this.aO));
            Futures.a(GraphQLQueryExecutor.a(this.aG.b(GraphQLRequest.a(o).a(GraphQLCachePolicy.c))), new C24674(this), this.av);
            EventSpecificUninvitableFriendsAndInviteeLimitString p = EventsGraphQL.p();
            p.a("event_id", this.aM);
            Futures.a(GraphQLQueryExecutor.a(this.aG.b(GraphQLRequest.a(p).a(GraphQLCachePolicy.c))), new C24685(this), this.av);
        } else {
            groupEventFriendInviteCandidatesQueryString = new EventsSuggestedInviteCandidatesQueryString();
            groupEventFriendInviteCandidatesQueryString.a("first_count", String.valueOf(this.aO));
            Futures.a(GraphQLQueryExecutor.a(this.aG.b(GraphQLRequest.a(groupEventFriendInviteCandidatesQueryString).a(GraphQLCachePolicy.c))), new C24696(this), this.av);
            Futures.a(GraphQLQueryExecutor.a(this.aG.b(GraphQLRequest.a(new EventsUninvitableFriendsAndInviteeLimitString()).a(GraphQLCachePolicy.c))), new C24707(this), this.av);
        }
        this.au.a(this.aG);
    }

    public static ImmutableList aV(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
        return ImmutableList.of(caspianFriendSelectorFragment.aC);
    }

    public static void m17855h(CaspianFriendSelectorFragment caspianFriendSelectorFragment, final boolean z) {
        caspianFriendSelectorFragment.d.a("setup_friends", caspianFriendSelectorFragment.c.a(new Callable<ImmutableMap<String, EventInviteeToken>>(caspianFriendSelectorFragment) {
            final /* synthetic */ CaspianFriendSelectorFragment f17489b;

            public Object call() {
                ContactCursorsQuery a;
                if (z) {
                    a = ContactCursorsQuery.b(this.f17489b.aI).d(CaspianFriendSelectorFragment.aV(this.f17489b)).a(SortKey.NAME);
                } else {
                    a = ContactCursorsQuery.a().d(CaspianFriendSelectorFragment.aV(this.f17489b)).a(SortKey.NAME);
                }
                InviteeIterator a2 = this.f17489b.ay.m18061a(this.f17489b.aw.a(a, QueryType.CONTACT));
                ImmutableMap.Builder builder = new ImmutableMap.Builder();
                while (a2.hasNext()) {
                    try {
                        Pair b = a2.m18060b();
                        if (b != null) {
                            Contact contact = (Contact) b.second;
                            BaseToken eventInviteeToken = new EventInviteeToken(contact, (String) b.first);
                            if (this.f17489b.ap.contains(contact.c()) && !this.f17489b.a(eventInviteeToken)) {
                                this.f17489b.a(eventInviteeToken, this.f17489b.as);
                            }
                            builder.b(contact.c(), eventInviteeToken);
                        }
                    } finally {
                        a2.close();
                    }
                }
                return builder.b();
            }
        }), new C24729(caspianFriendSelectorFragment));
    }

    public static void aW(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
        if (caspianFriendSelectorFragment.aH != null) {
            if (caspianFriendSelectorFragment.aJ != null || caspianFriendSelectorFragment.aL != null) {
                ImmutableMap.Builder builder = new ImmutableMap.Builder();
                Iterator it = caspianFriendSelectorFragment.aH.values().iterator();
                while (it.hasNext()) {
                    EventInviteeToken eventInviteeToken = (EventInviteeToken) it.next();
                    if (caspianFriendSelectorFragment.aL.contains(eventInviteeToken.g.b())) {
                        eventInviteeToken.i = false;
                    }
                    if (!caspianFriendSelectorFragment.aJ.contains(eventInviteeToken.g.b())) {
                        builder.b(eventInviteeToken.g.b(), eventInviteeToken);
                    }
                }
                caspianFriendSelectorFragment.aH = builder.b();
                caspianFriendSelectorFragment.a(null);
            }
        }
    }

    public static void aY(CaspianFriendSelectorFragment caspianFriendSelectorFragment) {
        if (caspianFriendSelectorFragment.aH != null && caspianFriendSelectorFragment.aK != null && !caspianFriendSelectorFragment.aK.isEmpty()) {
            caspianFriendSelectorFragment.a(null);
        }
    }

    private void m17854h(int i) {
        if (bd()) {
            this.aA.m18053a(InviteSubSessionTypes.INVITE_SEARCH, 1);
        } else if (i > this.aO) {
            this.aA.m18053a(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL, 1);
        } else {
            this.aA.m18053a(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED, 1);
        }
    }

    private void m17856i(int i) {
        if (bd()) {
            this.aA.m18056b(InviteSubSessionTypes.INVITE_SEARCH, 1);
        } else if (i > this.aO) {
            this.aA.m18056b(InviteSubSessionTypes.ALL_CANDIDATES_ALPHABETICAL, 1);
        } else {
            this.aA.m18056b(InviteSubSessionTypes.ALL_CANDIDATES_SUGGESTED, 1);
        }
    }

    private boolean bd() {
        return this.as.getText().length() > 0;
    }

    public static boolean m17851c(GraphQLEventInviteeStatusType graphQLEventInviteeStatusType) {
        return graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.INVITED || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.GOING || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.NOT_GOING || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.REMOVED || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.MAYBE;
    }

    public static boolean m17852d(GraphQLEventInviteeStatusType graphQLEventInviteeStatusType) {
        return graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.INELIGIBLE_FOR_EVENT;
    }

    private long[] be() {
        ImmutableList ax = ax();
        long[] jArr = new long[ax.size()];
        int size = ax.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3 = i2 + 1;
            jArr[i2] = Long.parseLong((String) ax.get(i));
            i++;
            i2 = i3;
        }
        return jArr;
    }

    protected final void aL() {
        super.aL();
        if (this.aR != null) {
            this.aR.mo805a(be());
        }
    }
}

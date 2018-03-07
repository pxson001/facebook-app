package com.facebook.tagging.conversion;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.composer.analytics.WithTagPerformanceLogger;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.contacts.background.AddressBookPeriodicRunner;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.contacts.module.ContactLinkType_ContactLinkQueryTypeMethodAutoProvider;
import com.facebook.contacts.provider.ContactsConnectionsContract.Selectors;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.TaggablePhotoGalleryFlowLogger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagScreen;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagSource;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.FaceBoxTagInfo;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.TagTarget;
import com.facebook.photos.base.util.PhotoHashUtil;
import com.facebook.photos.tagging.shared.FamilyTagTypeaheadUtil;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.photos.tagging.store.RemovedPrefilledTagsDataStore;
import com.facebook.photos.tagging.store.TagStore;
import com.facebook.places.checkin.composerflows.PlaceToPeopleController;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.user.model.Name;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.facebook.user.model.UserKey;
import com.facebook.userfilter.TypeaheadUserSearchAdapter;
import com.facebook.userfilter.TypeaheadUserSearchFilterProvider;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.ImmutableSectionedListSection;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenPickerTokenUtil;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.facebook.widget.tokenizedtypeahead.model.GroupTagToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadMatcherFilterProvider;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: max_lines */
public class FriendSuggestionsAndSelectorFragment extends FbFragment {
    private ImageView f9078a;
    private BaseTokenMatcher aA;
    private Lazy<UserTokenMatcher> aB;
    private Lazy<UserIncludingSelfTokenMatcher> aC;
    private boolean aD;
    public SecureContextHelper aE;
    public AbstractFbErrorReporter aF;
    private boolean aG;
    private boolean aH;
    private boolean aI;
    private PlaceToPeopleController aJ;
    public TasksManager<String> aK;
    private AnalyticsLogger aL;
    private TagStore aM;
    public WithTagPerformanceLogger aN;
    public FriendSuggestionAnalytics aO;
    private FaceBoxStore aP;
    private ContentResolver aQ;
    public boolean aR;
    private ContactLinkType aS;
    private FriendNameInputTextWatcher aT;
    private QeAccessor aU;
    private FriendStateFetcher aV;
    public FriendSuggestionsRunner aW;
    public ListeningExecutorService aX;
    private TokenPickerTokenUtil aY;
    public UserIterators aZ;
    public TypeaheadAdapter al;
    public BetterListView am;
    public BetterListView an;
    public TokenizedAutoCompleteTextView ao;
    public TextView ap;
    public View aq;
    private View ar;
    private LinearLayout as;
    private BaseToken at;
    private LoggedInUserSessionManager au;
    private int av;
    private int aw;
    public Fb4aTitleBar ax;
    public DefaultPhotoFlowLogger ay;
    public boolean az;
    public List<Long> f9079b;
    public boolean ba;
    public Set<SimpleUserToken> bb;
    public TypeaheadUserSearchAdapter bc;
    public TokenizedAutoCompleteTextView bd;
    public ArrayList<BaseToken> be;
    public Set<Long> bf;
    private FrameLayout bg;
    public List<GroupTagToken> bh;
    public boolean bi = false;
    public boolean bj;
    public final OnScrollListener bk = new C09371(this);
    private final ContentObserver bl = new ContentObserver(this, new Handler(Looper.getMainLooper())) {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9066a;

        public void onChange(boolean z) {
            this.f9066a.m10866a(this.f9066a.az);
        }
    };
    public Map<String, List<Long>> f9080c;
    public RemovedPrefilledTagsDataStore f9081d;
    private TaggablePhotoGalleryFlowLogger f9082e;
    public FamilyTagTypeaheadUtil f9083f;
    public List<TaggingProfile> f9084g;
    public DefaultUserInteractionController f9085h;
    private InputMethodManager f9086i;

    /* compiled from: max_lines */
    public class AnonymousClass14 extends AbstractDisposableFutureCallback<ImmutableList<SimpleUserToken>> {
        final /* synthetic */ ImmutableList f9062a;
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9063b;

        public AnonymousClass14(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, ImmutableList immutableList) {
            this.f9063b = friendSuggestionsAndSelectorFragment;
            this.f9062a = immutableList;
        }

        protected final void m10825a(Object obj) {
            int size;
            ImmutableList immutableList = (ImmutableList) obj;
            FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment = this.f9063b;
            ImmutableList immutableList2 = this.f9062a;
            Builder builder = ImmutableList.builder();
            if (immutableList2 == null) {
                size = immutableList.size();
                builder.b(immutableList);
            } else {
                size = immutableList2.size();
                builder.b(immutableList2);
                int size2 = immutableList.size();
                int i = 0;
                while (i < size2) {
                    SimpleUserToken simpleUserToken = (SimpleUserToken) immutableList.get(i);
                    long parseLong = Long.parseLong(simpleUserToken.g.b());
                    if (!friendSuggestionsAndSelectorFragment.f9079b.contains(Long.valueOf(parseLong))) {
                        size++;
                        builder.c(simpleUserToken);
                        friendSuggestionsAndSelectorFragment.f9079b.add(Long.valueOf(parseLong));
                    }
                    i++;
                    size = size;
                }
            }
            ImmutableList b = builder.b();
            FriendSuggestionsSection friendSuggestionsSection = new FriendSuggestionsSection(friendSuggestionsAndSelectorFragment.jW_().getString(2131234450), b, b.subList(0, Math.min(size, 10)));
            friendSuggestionsSection.a(false);
            friendSuggestionsAndSelectorFragment.bc.a(SectionType.SUGGESTIONS.ordinal(), friendSuggestionsSection);
            AdapterDetour.a(friendSuggestionsAndSelectorFragment.bc, 886164273);
        }

        protected final void m10826a(Throwable th) {
        }
    }

    /* compiled from: max_lines */
    class C09371 implements OnScrollListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9065a;

        C09371(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9065a = friendSuggestionsAndSelectorFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f9065a.f9085h.b(absListView);
                    return;
                case 1:
                case 2:
                    this.f9065a.f9085h.a(absListView);
                    FriendSuggestionsAndSelectorFragment.m10855c(this.f9065a, (View) absListView);
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: max_lines */
    class C09393 implements OnFocusChangeListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9067a;

        C09393(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9067a = friendSuggestionsAndSelectorFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f9067a.bj = true;
            }
        }
    }

    /* compiled from: max_lines */
    class C09404 implements TextWatcher {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9068a;

        C09404(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9068a = friendSuggestionsAndSelectorFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f9068a.al.a().a(this.f9068a.ao.getUserEnteredPlainText());
            TypeaheadAdapter typeaheadAdapter = this.f9068a.al;
            FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment = this.f9068a;
            typeaheadAdapter.i = FriendSuggestionsAndSelectorFragment.m10832a(this.f9068a.ao);
        }
    }

    /* compiled from: max_lines */
    class C09415 implements OnClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9069a;

        C09415(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9069a = friendSuggestionsAndSelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1503028243);
            this.f9069a.be.clear();
            this.f9069a.bd.b();
            Logger.a(2, EntryType.UI_INPUT_END, -1032526333, a);
        }
    }

    /* compiled from: max_lines */
    class C09426 implements OnClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9070a;

        C09426(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9070a = friendSuggestionsAndSelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 406996641);
            if (this.f9070a.aq.getVisibility() != 8) {
                Logger.a(2, EntryType.UI_INPUT_END, -445011589, a);
                return;
            }
            this.f9070a.ap.setVisibility(8);
            this.f9070a.bd.setVisibility(0);
            this.f9070a.bd.setEnabled(true);
            this.f9070a.bd.requestFocus();
            FriendSuggestionsAndSelectorFragment.m10852b(this.f9070a, this.f9070a.bd);
            LogUtils.a(-829958357, a);
        }
    }

    /* compiled from: max_lines */
    public class C09437 implements OnItemClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9071a;

        public C09437(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9071a = friendSuggestionsAndSelectorFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            BaseToken baseToken = (BaseToken) this.f9071a.bc.getItem(i);
            if (baseToken == null) {
                this.f9071a.aF.a("FriendSuggestionsAndSelectorFragment: null token", "Returned by getItem(" + i + "), row id(" + j + ")");
                return;
            }
            if (baseToken instanceof GroupTagToken) {
                FriendSuggestionsAndSelectorFragment.m10839a(this.f9071a, (GroupTagToken) baseToken);
                GroupTagToken groupTagToken = (GroupTagToken) baseToken;
                this.f9071a.aO.f9047a.a(FriendSuggestionAnalytics.m10802a("group_tag_suggestion_clicked", groupTagToken.f, FriendSuggestionsAndSelectorFragment.aB(this.f9071a).getStringExtra("extra_composer_internal_session_id")).a("index_clicked", i - 1));
            } else {
                FriendSuggestionsAndSelectorFragment.m10838a(this.f9071a, baseToken, this.f9071a.bd);
            }
            FriendSuggestionsAndSelectorFragment.au(this.f9071a);
        }
    }

    /* compiled from: max_lines */
    public class C09448 implements OnItemClickListener {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9072a;

        public C09448(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9072a = friendSuggestionsAndSelectorFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FriendSuggestionsAndSelectorFragment.m10859e(this.f9072a, (BaseToken) this.f9072a.al.getItem(i));
        }
    }

    /* compiled from: max_lines */
    class FriendNameInputTextWatcher implements TextWatcher {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9075a;

        public FriendNameInputTextWatcher(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9075a = friendSuggestionsAndSelectorFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            boolean z;
            if (this.f9075a.bd.hasFocus()) {
                int i;
                ArrayList arrayList = new ArrayList();
                int size = this.f9075a.be.size();
                for (i = 0; i < size; i++) {
                    arrayList.add((BaseToken) this.f9075a.be.get(i));
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    BaseToken baseToken = (BaseToken) arrayList.get(i);
                    if (!(baseToken instanceof GroupTagToken)) {
                        if (!editable.subSequence(0, editable.length()).toString().contains(baseToken.b())) {
                            this.f9075a.be.remove(baseToken);
                            FriendSuggestionsAndSelectorFragment.m10837a(this.f9075a, baseToken);
                        }
                    }
                }
            }
            this.f9075a.bc.a().a(this.f9075a.bd.getUserEnteredPlainText());
            FriendSuggestionsAndSelectorFragment.au(this.f9075a);
            AdapterDetour.a(this.f9075a.bc, -344276123);
            FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment = this.f9075a;
            if (editable.toString().isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            FriendSuggestionsAndSelectorFragment.m10863j(friendSuggestionsAndSelectorFragment, z);
        }
    }

    /* compiled from: max_lines */
    public enum SectionType {
        GROUP_SUGGESTIONS,
        SUGGESTIONS,
        ALL_FRIENDS,
        GOOD_FRIENDS
    }

    /* compiled from: max_lines */
    class TokensBuilder {
        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9076a;
        private final Map<Long, SimpleUserToken> f9077b = new LinkedHashMap();

        public TokensBuilder(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
            this.f9076a = friendSuggestionsAndSelectorFragment;
        }

        public final void m10830a(Long l, SimpleUserToken simpleUserToken) {
            if (this.f9077b.put(l, simpleUserToken) != null) {
                this.f9076a.aF.b("FriendSuggestionsAndSelectorFragment", "Duplicate token: " + simpleUserToken.g.toString());
            }
        }

        public final ImmutableMap<Long, SimpleUserToken> m10829a() {
            return ImmutableMap.copyOf(this.f9077b);
        }
    }

    private void m10857c(GroupTagToken groupTagToken) {
        for (SimpleUserToken d : groupTagToken.e) {
            if (m10858d(d) == 0) {
                this.be.remove(groupTagToken);
                return;
            }
        }
        this.be.add(groupTagToken);
    }

    private void m10844a(ImmutableMap<Long, SimpleUserToken> immutableMap, Builder<SimpleUserToken> builder, TaggingProfile taggingProfile, boolean z) {
        BaseToken baseToken = (SimpleUserToken) immutableMap.get(Long.valueOf(taggingProfile.b));
        if (baseToken != null && !this.f9079b.contains(Long.valueOf(taggingProfile.b))) {
            builder.c(baseToken);
            this.f9079b.add(Long.valueOf(taggingProfile.b));
            if (z) {
                m10842a(baseToken, this.bd, true);
            }
        }
    }

    public final void m10868c(Bundle bundle) {
        super.c(bundle);
        InjectorLike an = an();
        this.aN = WithTagPerformanceLogger.a(an);
        this.aN.d();
        this.aX = ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(an);
        this.aZ = UserIterators.a(an);
        this.f9085h = DefaultUserInteractionController.a(an);
        this.f9086i = InputMethodManagerMethodAutoProvider.b(an);
        this.au = LoggedInUserSessionManager.a(an);
        this.aY = TokenPickerTokenUtil.a(an);
        AddressBookPeriodicRunner.a(an).a();
        this.bb = Sets.a();
        this.be = new ArrayList();
        String string = this.s.getString("photo_upload_waterfall_id");
        if (string != null) {
            this.ay = DefaultPhotoFlowLogger.b(an);
            this.ay.a(string);
        }
        this.aB = IdBasedLazy.a(an, 11537);
        this.aC = IdBasedLazy.a(an, 11093);
        this.bc = new TypeaheadUserSearchAdapter(InputMethodManagerMethodAutoProvider.b(an), (TypeaheadMatcherFilterProvider) an.getOnDemandAssistedProviderForStaticDi(TypeaheadMatcherFilterProvider.class), (TypeaheadUserSearchFilterProvider) an.getOnDemandAssistedProviderForStaticDi(TypeaheadUserSearchFilterProvider.class));
        this.al = TypeaheadAdapter.b(an);
        this.aD = false;
        this.aE = (SecureContextHelper) DefaultSecureContextHelper.a(an);
        this.aF = (AbstractFbErrorReporter) FbErrorReporterImpl.a(an);
        this.aJ = PlaceToPeopleController.m3461b(an);
        this.aK = TasksManager.b(an);
        this.aL = AnalyticsLoggerMethodAutoProvider.a(an);
        this.aO = FriendSuggestionAnalytics.m10804a(an);
        this.aW = FriendSuggestionsRunner.m10876b(an);
        this.aM = TagStore.a(an);
        this.aP = FaceBoxStore.a(an);
        this.aR = Boolean_IsWorkBuildMethodAutoProvider.a(an).booleanValue();
        this.aS = ContactLinkType_ContactLinkQueryTypeMethodAutoProvider.b(an);
        this.f9082e = TaggablePhotoGalleryFlowLogger.b(an);
        this.f9082e.a = ao().getIntent().getStringExtra("extra_composer_internal_session_id");
        this.f9082e.l();
        this.f9081d = RemovedPrefilledTagsDataStore.a(an);
        this.f9083f = FamilyTagTypeaheadUtil.a(an);
        this.aU = (QeAccessor) QeInternalImplMethodAutoProvider.a(an);
        this.aV = FriendStateFetcher.b(an);
        this.aN.e();
    }

    private void as() {
        this.ax.setTitle(this.aw);
    }

    public final View m10864a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1470281379);
        this.aN.f();
        Intent aB = aB(this);
        String str = "custom_all_friends_res_id";
        if (this.aR) {
            i = 2131234448;
        } else {
            i = 2131234446;
        }
        this.av = aB.getIntExtra(str, i);
        aB = aB(this);
        str = "custom_title_res_id";
        if (this.aR) {
            i = 2131234444;
        } else {
            i = 2131234443;
        }
        this.aw = aB.getIntExtra(str, i);
        as();
        this.bg = (FrameLayout) layoutInflater.inflate(2130904501, null);
        this.as = (LinearLayout) this.bg.findViewById(2131562285);
        this.as.setVisibility(8);
        this.bd = (TokenizedAutoCompleteTextView) this.bg.findViewById(2131562296);
        this.bd.setOnFocusChangeListener(new C09393(this));
        this.bc.i = this.be;
        this.ao = (TokenizedAutoCompleteTextView) this.bg.findViewById(2131562288);
        this.ao.addTextChangedListener(new C09404(this));
        this.aQ = getContext().getApplicationContext().getContentResolver();
        this.aQ.registerContentObserver(Selectors.FRIENDS_CONTENT.getFullUri(), false, this.bl);
        this.ar = this.bg.findViewById(2131562294);
        this.ap = (TextView) this.bg.findViewById(2131562295);
        this.aq = this.bg.findViewById(2131562297);
        at();
        this.aA = this.ba ? (BaseTokenMatcher) this.aC.get() : (BaseTokenMatcher) this.aB.get();
        this.bc.a(this.aA);
        this.al.a(this.aA);
        FrameLayout frameLayout = this.bg;
        Builder builder = ImmutableList.builder();
        for (i = 0; i < SectionType.values().length; i++) {
            builder.c(new ImmutableSectionedListSection());
        }
        this.bc.a(builder.b());
        this.am = (BetterListView) frameLayout.findViewById(2131559373);
        this.am.setAdapter(this.bc);
        this.am.setOnScrollListener(this.bk);
        this.am.setOnItemClickListener(new C09437(this));
        frameLayout = this.bg;
        this.al.a(ImmutableList.of(new ImmutableSectionedListSection()));
        this.an = (BetterListView) frameLayout.findViewById(2131562291);
        this.an.setAdapter(this.al);
        this.an.setOnScrollListener(this.bk);
        this.an.setOnItemClickListener(new C09448(this));
        this.az = this.s.getBoolean("extras_has_faces_detected", false);
        this.aG = aB(this).hasExtra("tag_place_after_tag_people");
        m10866a(this.az);
        au(this);
        if (bundle != null) {
            this.aH = bundle.getBoolean("has_backed_out_of_place_picker");
        }
        if (av()) {
            this.aL.c(new HoneyClientEvent("place_picker_place_to_people_start").a("from_checkin", aB(this).getBooleanExtra("from_checkin", false)));
        }
        this.aU.a(ExperimentsForTaggingABTestModule.a, false);
        this.aN.g();
        View view = this.bg;
        LogUtils.f(-1436802616, a);
        return view;
    }

    public final void m10869e(Bundle bundle) {
        super.e(bundle);
        bundle.putBoolean("has_backed_out_of_place_picker", this.aH);
    }

    public final void m10866a(final boolean z) {
        this.f9079b = new ArrayList();
        this.f9080c = new HashMap();
        this.f9078a = (ImageView) this.bg.findViewById(2131562298);
        this.f9078a.setImageResource(2130843016);
        this.f9078a.setOnClickListener(new C09415(this));
        this.f9078a.setVisibility(0);
        final ArrayList parcelableArrayList = this.s.getParcelableArrayList("extra_media_items");
        if (z) {
            this.aK.a("query_removed_tag_store", this.aX.a(new Callable<Map<String, List<Long>>>(this) {
                final /* synthetic */ FriendSuggestionsAndSelectorFragment f9074b;

                public Object call() {
                    return this.f9074b.f9081d.a(this.f9074b.getContext(), parcelableArrayList);
                }
            }), new AbstractDisposableFutureCallback<Map<String, List<Long>>>(this) {
                final /* synthetic */ FriendSuggestionsAndSelectorFragment f9055c;

                protected final void m10819a(Object obj) {
                    Map map = (Map) obj;
                    if (map != null) {
                        this.f9055c.f9080c = map;
                    }
                    if (this.f9055c.bi) {
                        FriendSuggestionsAndSelectorFragment.ay(this.f9055c);
                    } else {
                        FriendSuggestionsAndSelectorFragment.m10841a(this.f9055c, this.f9055c.bf, parcelableArrayList, z);
                    }
                }

                protected final void m10820a(Throwable th) {
                    if (this.f9055c.bi) {
                        FriendSuggestionsAndSelectorFragment.ay(this.f9055c);
                    } else {
                        FriendSuggestionsAndSelectorFragment.m10841a(this.f9055c, this.f9055c.bf, parcelableArrayList, z);
                    }
                }
            });
        } else if (this.bi) {
            ay(this);
        } else {
            m10841a(this, this.bf, parcelableArrayList, z);
        }
        this.aT = new FriendNameInputTextWatcher(this);
        this.bd.addTextChangedListener(this.aT);
        this.f9084g = this.f9083f.a();
    }

    private void at() {
        this.aq.setVisibility(0);
        if (m10832a(this.bd).isEmpty()) {
            this.bd.setEnabled(false);
        } else {
            m10861h(true);
            this.bd.setVisibility(8);
            this.aI = true;
        }
        this.ar.setOnClickListener(new C09426(this));
    }

    public static void m10839a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, GroupTagToken groupTagToken) {
        Object obj = 1;
        for (BaseToken baseToken : groupTagToken.e) {
            if (friendSuggestionsAndSelectorFragment.m10858d(baseToken) == 0) {
                obj = null;
                m10838a(friendSuggestionsAndSelectorFragment, baseToken, friendSuggestionsAndSelectorFragment.bd);
            }
            obj = obj;
        }
        if (obj != null) {
            for (BaseToken a : groupTagToken.e) {
                m10838a(friendSuggestionsAndSelectorFragment, a, friendSuggestionsAndSelectorFragment.bd);
            }
        }
    }

    public static void au(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
        boolean z = true;
        if (friendSuggestionsAndSelectorFragment.av() && friendSuggestionsAndSelectorFragment.be.isEmpty()) {
            friendSuggestionsAndSelectorFragment.m10845a(friendSuggestionsAndSelectorFragment.b(2131230751), true);
        } else if (friendSuggestionsAndSelectorFragment.aG) {
            String b = friendSuggestionsAndSelectorFragment.b(2131230744);
            if (friendSuggestionsAndSelectorFragment.be.isEmpty()) {
                z = false;
            }
            friendSuggestionsAndSelectorFragment.m10845a(b, z);
        } else {
            friendSuggestionsAndSelectorFragment.m10845a(friendSuggestionsAndSelectorFragment.b(2131234445), true);
        }
    }

    private void m10845a(String str, boolean z) {
        Fb4aTitleBar fb4aTitleBar = this.ax;
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = str;
        a = a;
        a.q = true;
        a = a;
        a.d = z;
        fb4aTitleBar.setPrimaryButton(a.a());
    }

    public static List<BaseToken> m10832a(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        BaseTokenSpan[] baseTokenSpanArr = (BaseTokenSpan[]) tokenizedAutoCompleteTextView.getPickedTokenSpans();
        List<BaseToken> arrayList = new ArrayList();
        for (TokenSpan tokenSpan : baseTokenSpanArr) {
            arrayList.add(tokenSpan.f);
        }
        return arrayList;
    }

    private void m10846a(Set<SimpleUserToken> set) {
        for (BaseToken baseToken : ((SectionedListSection) this.bc.b(SectionType.SUGGESTIONS.ordinal())).b()) {
            BaseToken baseToken2;
            if ((baseToken2 instanceof SuggestionToken) && ((SuggestionToken) baseToken2).f9111e.a.f) {
                m10838a(this, baseToken2, this.bd);
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            baseToken2 = (SimpleUserToken) it.next();
            if (m10858d(baseToken2) == 0) {
                m10838a(this, baseToken2, this.bd);
            }
        }
        AdapterDetour.a(this.bc, 411211764);
    }

    public static void m10838a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, BaseToken baseToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        if (baseToken instanceof SimpleUserToken) {
            Object b = friendSuggestionsAndSelectorFragment.bc.b(SectionType.SUGGESTIONS.ordinal());
            if ((b instanceof FriendSuggestionsSection) || (b instanceof ImmutableSectionedListSection)) {
                friendSuggestionsAndSelectorFragment.m10842a(baseToken, tokenizedAutoCompleteTextView, true);
            }
            m10837a(friendSuggestionsAndSelectorFragment, baseToken);
        }
    }

    public static void m10837a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, BaseToken baseToken) {
        if (friendSuggestionsAndSelectorFragment.bh != null) {
            for (GroupTagToken groupTagToken : friendSuggestionsAndSelectorFragment.bh) {
                List list = groupTagToken.e;
                if (list != null && list.contains(baseToken)) {
                    friendSuggestionsAndSelectorFragment.m10857c(groupTagToken);
                }
            }
        }
    }

    private void m10842a(BaseToken baseToken, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, boolean z) {
        List a = m10832a(tokenizedAutoCompleteTextView);
        if (baseToken instanceof SuggestionToken) {
            this.aD = true;
        }
        if ((baseToken instanceof SuggestionToken) && baseToken.b() == null) {
            if (this.ay != null) {
                this.ay.b(baseToken.b() != null);
            }
            m10860f(baseToken);
            return;
        }
        if (a.contains(baseToken) || this.be.contains(baseToken)) {
            if (m10858d(baseToken) == 1) {
                tokenizedAutoCompleteTextView.a(m10851b(baseToken), true);
            }
            a.remove(m10851b(baseToken));
            if (baseToken instanceof SuggestionToken) {
                FaceBoxTagInfo faceBoxTagInfo = ((SuggestionToken) baseToken).f9111e;
                faceBoxTagInfo.b = null;
                faceBoxTagInfo.a.f = false;
            }
            if (a.isEmpty()) {
                m10861h(true);
            }
            if (z && this.ay != null) {
                if (baseToken instanceof SuggestionToken) {
                    this.ay.a(TagScreen.COMPOSER_TAGGING_XY_TAG);
                } else {
                    this.ay.a(TagScreen.COMPOSER_TAGGING_WITH_TAG);
                }
            }
            if (this.be.contains(baseToken)) {
                this.be.remove(baseToken);
            }
        } else if (a.size() < 50) {
            if (m10858d(baseToken) == 0) {
                tokenizedAutoCompleteTextView.a(baseToken);
            }
            tokenizedAutoCompleteTextView.clearComposingText();
            this.f9086i.restartInput(tokenizedAutoCompleteTextView);
            a.add(baseToken);
            if (baseToken instanceof SuggestionToken) {
                SuggestionToken suggestionToken = (SuggestionToken) baseToken;
                suggestionToken.f9111e.a(suggestionToken.f9112f, suggestionToken.f9113g);
            }
            if (a.size() == 1) {
                m10861h(false);
            }
            if (z && this.ay != null) {
                if (baseToken instanceof SuggestionToken) {
                    this.ay.a(true, 0, TagSource.FACEBOX, TagScreen.COMPOSER_TAGGING_XY_TAG);
                } else {
                    this.ay.a(true, 0, TagSource.UNSET, TagScreen.COMPOSER_TAGGING_WITH_TAG);
                }
            }
            this.be.add(baseToken);
        } else {
            return;
        }
        AdapterDetour.a(this.bc, -827979351);
    }

    private BaseToken m10851b(BaseToken baseToken) {
        List<BaseToken> a = m10832a(this.bd);
        String c = m10854c(baseToken);
        for (BaseToken baseToken2 : a) {
            if (m10854c(baseToken2).equals(c)) {
                return baseToken2;
            }
        }
        return baseToken;
    }

    private static String m10854c(BaseToken baseToken) {
        return baseToken.b();
    }

    private int m10858d(BaseToken baseToken) {
        long parseLong;
        int i = 0;
        if (baseToken instanceof SimpleUserToken) {
            parseLong = Long.parseLong(((UserKey) baseToken.d()).b());
        } else {
            parseLong = ((SuggestionToken) baseToken).f9113g;
        }
        int size = this.be.size();
        int i2 = 0;
        while (i < size) {
            BaseToken baseToken2 = (BaseToken) this.be.get(i);
            if (baseToken2 instanceof SimpleUserToken) {
                int i3;
                if (Long.parseLong(((UserKey) baseToken2.d()).b()) == parseLong) {
                    i3 = i2 + 1;
                } else {
                    i3 = i2;
                }
                i2 = i3;
            } else if ((baseToken2 instanceof SuggestionToken) && ((SuggestionToken) baseToken2).f9113g == parseLong) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    public static void m10859e(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, BaseToken baseToken) {
        UserKey userKey = (UserKey) baseToken.d();
        SuggestionToken suggestionToken = (SuggestionToken) friendSuggestionsAndSelectorFragment.at;
        String b = baseToken.b();
        long parseLong = Long.parseLong(userKey.b());
        suggestionToken.f9112f = b;
        suggestionToken.f9113g = parseLong;
        suggestionToken.f9111e.a(suggestionToken.f9112f, suggestionToken.f9113g);
        friendSuggestionsAndSelectorFragment.as.setVisibility(8);
        ((LinearLayout) friendSuggestionsAndSelectorFragment.e(2131562293)).setVisibility(0);
        m10838a(friendSuggestionsAndSelectorFragment, friendSuggestionsAndSelectorFragment.at, friendSuggestionsAndSelectorFragment.bd);
        friendSuggestionsAndSelectorFragment.as();
    }

    private void m10861h(boolean z) {
        if (!z || this.bj) {
            this.ap.setVisibility(8);
            this.bd.setVisibility(0);
            this.bd.setEnabled(true);
            return;
        }
        this.ap.setVisibility(0);
        this.bd.setVisibility(8);
    }

    private boolean av() {
        return aB(this).hasExtra("extra_place");
    }

    public final void m10867b() {
        m10855c(this, this.bd);
        if (this.as.getVisibility() != 8) {
            this.as.setVisibility(8);
            ((LinearLayout) e(2131562293)).setVisibility(0);
            as();
            this.aD = true;
            return;
        }
        m10862i(this.aG);
    }

    public final boolean m10870e() {
        this.aO.m10808a(this.be, this.aW.m10878a(), av(), this.aI, this.az, aB(this).getStringExtra("extra_composer_internal_session_id"));
        if (!this.aH) {
            return false;
        }
        m10862i(false);
        return true;
    }

    private void m10862i(boolean z) {
        Set a = Sets.a();
        Set<FacebookProfile> a2 = Sets.a();
        ArrayList parcelableArrayList = this.s.getParcelableArrayList("extra_media_items");
        this.aD = m10849a(parcelableArrayList, this.be.subList(0, this.be.size()), a, (Set) a2);
        if (z) {
            Builder builder = ImmutableList.builder();
            for (FacebookProfile facebookProfile : a2) {
                ComposerTaggedUser.Builder a3 = ComposerTaggedUser.a(facebookProfile.mId);
                a3.b = facebookProfile.mDisplayName;
                a3 = a3;
                a3.c = facebookProfile.mImageUrl;
                builder.c(a3.a());
            }
            PlacePickerConfiguration.Builder newBuilder = PlacePickerConfiguration.newBuilder();
            newBuilder.p = (SearchType) aB(this).getSerializableExtra("search_type");
            PlacePickerConfiguration.Builder builder2 = newBuilder;
            builder2.e = aB(this).getStringExtra("extra_composer_internal_session_id");
            builder2 = builder2;
            builder2.x = true;
            builder2 = builder2;
            builder2.q = builder.b();
            builder2 = builder2;
            builder2.r = ImmutableList.copyOf(a);
            this.aE.a(CheckinIntentCreator.a(getContext(), builder2.a()), 1, this);
            return;
        }
        m10847a((Set) a2, a, parcelableArrayList);
    }

    private boolean m10849a(ArrayList<MediaItem> arrayList, List<BaseToken> list, Set<Long> set, Set<FacebookProfile> set2) {
        boolean z;
        if (arrayList == null) {
            boolean z2 = false;
            for (BaseToken a : list) {
                if (!m10850a((Set) set, (Set) set2, a) || z2) {
                    z = z2;
                } else {
                    z = true;
                }
                z2 = z;
            }
            return z2;
        }
        List arrayList2 = new ArrayList();
        for (BaseToken a2 : list) {
            if (a2 instanceof SimpleUserToken) {
                arrayList2.add(Long.valueOf(Long.parseLong(((SimpleUserToken) a2).o().b())));
            }
        }
        z = m10848a((ArrayList) arrayList, arrayList2);
        boolean z3 = z;
        for (BaseToken a22 : list) {
            if (a22 instanceof SimpleUserToken) {
                SimpleUserToken simpleUserToken = (SimpleUserToken) a22;
                long parseLong = Long.parseLong(simpleUserToken.o().b());
                Object obj = null;
                int size = arrayList.size();
                boolean z4 = z3;
                for (int i = 0; i < size; i++) {
                    MediaItem mediaItem = (MediaItem) arrayList.get(i);
                    if (mediaItem instanceof PhotoItem) {
                        PhotoItem photoItem = (PhotoItem) mediaItem;
                        if (this.aM.b(photoItem) != null) {
                            for (Tag h : this.aM.b(photoItem)) {
                                if (h.h() == parseLong) {
                                    obj = 1;
                                    break;
                                }
                            }
                        }
                        String a3 = PhotoHashUtil.a(mediaItem);
                        if (!this.f9080c.containsKey(a3) || this.f9080c.get(a3) == null || !((List) this.f9080c.get(a3)).contains(Long.valueOf(parseLong))) {
                            LocalPhoto localPhoto = (LocalPhoto) photoItem.r();
                            if (this.aP.a(localPhoto) != null) {
                                for (FaceBox faceBox : this.aP.a(localPhoto)) {
                                    if (!faceBox.m() && faceBox.p() && faceBox.a(parseLong)) {
                                        m10834a(mediaItem, faceBox, simpleUserToken);
                                        obj = 1;
                                        z4 = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (obj == null) {
                    if (!set.contains(Long.valueOf(parseLong)) && m10850a((Set) set, (Set) set2, a22)) {
                        z3 = true;
                    }
                } else {
                    set2.add(new FacebookProfile(parseLong, a22.b(), a22.i(), 0));
                }
                z3 = z4;
            }
        }
        return z3;
    }

    private void m10847a(Set<FacebookProfile> set, Set<Long> set2, ArrayList<MediaItem> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("photo_tagged_set_modified", this.aD);
        intent.putExtra("extra_media_items", arrayList);
        intent.putExtra("profiles", Longs.a(set2));
        intent.putExtra("full_profiles", Lists.a(set));
        if (aB(this).getBooleanExtra("tag_people_after_checkin_button", false)) {
            intent.putExtra("extra_tagged_profiles", Lists.a(set));
        }
        FlatBufferModelHelper.a(intent, "extra_place", FlatBufferModelHelper.a(aB(this), "extra_place"));
        intent.putExtra("extra_implicit_location", aB(this).getParcelableExtra("extra_implicit_location"));
        if (aB(this).hasExtra("minutiae_object")) {
            intent.putExtra("minutiae_object", aB(this).getParcelableExtra("minutiae_object"));
        }
        if (av()) {
            HoneyClientEventFast a = this.aL.a(set2.isEmpty() ? "place_picker_place_to_people_skip" : "place_picker_place_to_people_select", true);
            if (a.a()) {
                a.a("from_checkin", aB(this).getBooleanExtra("from_checkin", false));
                a.b();
            }
        }
        PlaceToPeopleController placeToPeopleController = this.aJ;
        if (aB(this).hasExtra("extra_place")) {
            if (set2.isEmpty()) {
                placeToPeopleController.f3533c.m3466b();
            } else {
                placeToPeopleController.f3533c.m3464a();
            }
        }
        this.aO.m10809a(this.be, this.aW.m10878a(), av(), this.aI, this.az, this.bh, aB(this).getStringExtra("extra_composer_internal_session_id"));
        o().setResult(-1, intent);
        o().finish();
    }

    public final void m10865a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    intent.putExtra("tag_place_after_tag_people", true);
                    o().setResult(-1, intent);
                    o().finish();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 1:
                    this.aH = true;
                    return;
                default:
                    return;
            }
        }
    }

    public static SimpleUserToken aw(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
        return new SimpleUserToken(friendSuggestionsAndSelectorFragment.au.c());
    }

    private void m10843a(ImmutableList immutableList) {
        m10833a(this.av, SectionType.ALL_FRIENDS, immutableList);
        az();
    }

    private void m10860f(BaseToken baseToken) {
        ((ImageView) this.bg.findViewById(2131562287)).setBackgroundDrawable(new BitmapDrawable(baseToken.j()));
        if (baseToken instanceof SuggestionToken) {
            ImmutableSectionedListSection immutableSectionedListSection;
            List<TaggingProfile> n = ((SuggestionToken) baseToken).f9111e.a.n();
            if (n == null || n.isEmpty()) {
                immutableSectionedListSection = null;
            } else {
                List<BaseToken> arrayList = new ArrayList();
                List<BaseToken> b = ((ImmutableSectionedListSection) this.al.b(SectionType.SUGGESTIONS.ordinal())).b();
                for (TaggingProfile taggingProfile : n) {
                    for (BaseToken baseToken2 : b) {
                        if (baseToken2 != null && !Strings.isNullOrEmpty(baseToken2.b()) && taggingProfile != null && taggingProfile.a != null && baseToken2.b().equals(taggingProfile.a.i())) {
                            arrayList.add(baseToken2);
                            break;
                        }
                    }
                }
                Builder builder = ImmutableList.builder();
                for (BaseToken c : arrayList) {
                    builder.c(c);
                }
                for (BaseToken c2 : b) {
                    if (!arrayList.contains(c2)) {
                        builder.c(c2);
                    }
                }
                immutableSectionedListSection = new ImmutableSectionedListSection(null, builder.b());
            }
            SectionedListSection sectionedListSection = immutableSectionedListSection;
            if (sectionedListSection != null) {
                this.al.a(SectionType.SUGGESTIONS.ordinal(), sectionedListSection);
                AdapterDetour.a(this.al, 450943050);
            }
        }
        ((LinearLayout) e(2131562293)).setVisibility(8);
        this.an.setVisibility(0);
        this.ao.setEnabled(true);
        this.ao.requestFocus();
        m10852b(this, this.ao);
        this.at = baseToken;
        this.ax.setTitle(2131234454);
        this.as.setVisibility(0);
    }

    public static void m10852b(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, View view) {
        friendSuggestionsAndSelectorFragment.f9086i.showSoftInput(view, 0);
    }

    public static void m10855c(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, View view) {
        friendSuggestionsAndSelectorFragment.f9086i.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 193784665);
        this.aW.m10880b();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1231919463, a);
    }

    public static void m10863j(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, boolean z) {
        friendSuggestionsAndSelectorFragment.f9078a.setVisibility(z ? 0 : 4);
    }

    public static void ay(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
        friendSuggestionsAndSelectorFragment.aV.a(true, new Callback(friendSuggestionsAndSelectorFragment) {
            final /* synthetic */ FriendSuggestionsAndSelectorFragment f9056a;

            {
                this.f9056a = r1;
            }

            public final void m10821a(ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
                Builder builder = new Builder();
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    FriendData friendData = (FriendData) immutableList.get(i2);
                    UserBuilder userBuilder = new UserBuilder();
                    userBuilder.g = new Name(friendData.b);
                    userBuilder = userBuilder.a(Type.FACEBOOK, friendData.a);
                    userBuilder.n = friendData.c.toString();
                    SimpleUserToken simpleUserToken = new SimpleUserToken(userBuilder.aa());
                    builder.c(simpleUserToken);
                    if (this.f9056a.bf.contains(Long.valueOf(Long.parseLong(friendData.c())))) {
                        this.f9056a.bb.add(simpleUserToken);
                    }
                }
                this.f9056a.m10853b(builder.b());
            }

            public final void m10822a(Throwable th) {
                BLog.b("FriendSuggestionsAndSelectorFragment", "Failed to fetch good friends list", th);
            }
        }, -1);
    }

    private void m10853b(ImmutableList immutableList) {
        m10833a(2131234447, SectionType.GOOD_FRIENDS, immutableList);
        az();
    }

    private void m10833a(int i, SectionType sectionType, ImmutableList immutableList) {
        this.bc.a(sectionType.ordinal(), new ImmutableSectionedListSection(jW_().getString(i), immutableList));
        AdapterDetour.a(this.bc, -565870469);
    }

    private void az() {
        boolean z = true;
        this.am.setVisibility(0);
        this.aq.setVisibility(8);
        if (!this.bb.isEmpty()) {
            this.bd.setEnabled(true);
        }
        m10855c(this, this.bd);
        m10846a(this.bb);
        if (this.bb.isEmpty()) {
            z = false;
        }
        m10863j(this, z);
    }

    public static ImmutableList aA(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
        return friendSuggestionsAndSelectorFragment.ba ? ImmutableList.of(friendSuggestionsAndSelectorFragment.aS, ContactLinkType.ME) : ImmutableList.of(friendSuggestionsAndSelectorFragment.aS);
    }

    public static ImmutableList m10831a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, ArrayList arrayList, ImmutableMap immutableMap, SimpleUserToken simpleUserToken) {
        friendSuggestionsAndSelectorFragment.f9079b.clear();
        ArrayList arrayList2 = new ArrayList();
        Builder builder = ImmutableList.builder();
        ImmutableMap.Builder builder2 = ImmutableMap.builder();
        builder2.a(immutableMap);
        builder2.b(Long.valueOf(Long.parseLong(simpleUserToken.o().b())), simpleUserToken);
        ImmutableMap b = builder2.b();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) arrayList.get(i);
            if (mediaItem instanceof PhotoItem) {
                PhotoItem photoItem = (PhotoItem) mediaItem;
                LocalPhoto localPhoto = (LocalPhoto) photoItem.r();
                if (friendSuggestionsAndSelectorFragment.aP.b(localPhoto)) {
                    for (Tag tag : friendSuggestionsAndSelectorFragment.aM.b(photoItem)) {
                        if (tag.l()) {
                            BaseToken baseToken = (SimpleUserToken) b.get(Long.valueOf(tag.h()));
                            if (!(baseToken == null || friendSuggestionsAndSelectorFragment.f9079b.contains(Long.valueOf(tag.h())))) {
                                builder.c(baseToken);
                                friendSuggestionsAndSelectorFragment.m10842a(baseToken, friendSuggestionsAndSelectorFragment.bd, true);
                                friendSuggestionsAndSelectorFragment.f9079b.add(Long.valueOf(tag.h()));
                            }
                        }
                    }
                    arrayList2.addAll(friendSuggestionsAndSelectorFragment.aP.a(localPhoto));
                }
            }
        }
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            FaceBox faceBox = (FaceBox) arrayList2.get(i2);
            if (faceBox.p() && !faceBox.m()) {
                for (TaggingProfile a : faceBox.n()) {
                    friendSuggestionsAndSelectorFragment.m10844a(b, builder, a, false);
                }
            }
        }
        return builder.b();
    }

    private boolean m10848a(ArrayList<MediaItem> arrayList, List<Long> list) {
        boolean z = false;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            MediaItem mediaItem = (MediaItem) arrayList.get(i);
            if (mediaItem instanceof PhotoItem) {
                PhotoItem photoItem = (PhotoItem) mediaItem;
                if (photoItem.f instanceof LocalPhoto) {
                    boolean z2;
                    LocalPhoto localPhoto = (LocalPhoto) photoItem.r();
                    Collection arrayList2 = new ArrayList();
                    for (Tag tag : this.aM.a(localPhoto)) {
                        if (!list.contains(Long.valueOf(tag.h())) && ((tag.i().equals(TaggingProfile.Type.USER) || tag.i().equals(TaggingProfile.Type.FAMILY_NONUSER_MEMBER)) && tag.h() != Long.parseLong(aw(this).p()))) {
                            arrayList2.add(tag);
                            if (tag.d() instanceof FaceBox) {
                                ((FaceBox) tag.d()).f = false;
                            }
                        }
                    }
                    if (arrayList2.isEmpty()) {
                        z2 = z;
                    } else {
                        this.aM.b(photoItem).removeAll(arrayList2);
                        z2 = true;
                    }
                    List arrayList3 = new ArrayList();
                    for (Tag tag2 : this.aM.b(photoItem)) {
                        if (!list.contains(Long.valueOf(tag2.h()))) {
                            arrayList3.add(Long.valueOf(tag2.h()));
                        }
                    }
                    if (arrayList3.isEmpty()) {
                        z = z2;
                    } else {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void m10834a(MediaItem mediaItem, FaceBox faceBox, SimpleUserToken simpleUserToken) {
        if (mediaItem instanceof PhotoItem) {
            PhotoItem photoItem = (PhotoItem) mediaItem;
            if (photoItem.f instanceof LocalPhoto) {
                TagTarget tagTarget = faceBox;
                this.aM.b(photoItem).add(new Tag(tagTarget, simpleUserToken.e, Long.parseLong(simpleUserToken.g.b()), true, TaggingProfile.Type.USER, true));
                faceBox.f = true;
                this.f9082e.j();
            }
        }
    }

    private static boolean m10850a(Set<Long> set, Set<FacebookProfile> set2, BaseToken baseToken) {
        if (!(baseToken instanceof SimpleUserToken)) {
            return false;
        }
        long parseLong = Long.parseLong(((SimpleUserToken) baseToken).g.b());
        if (set.contains(Long.valueOf(parseLong))) {
            return false;
        }
        set.add(Long.valueOf(parseLong));
        set2.add(new FacebookProfile(parseLong, baseToken.b(), baseToken.i(), 0));
        return true;
    }

    private void m10835a(TokensBuilder tokensBuilder, Set<Long> set, boolean z) {
        if (this.f9084g != null && !this.f9084g.isEmpty()) {
            for (int i = 0; i < this.f9084g.size(); i++) {
                SimpleUserToken simpleUserToken = new SimpleUserToken(((TaggingProfile) this.f9084g.get(i)).a, ((TaggingProfile) this.f9084g.get(i)).c, new UserKey(Type.FACEBOOK_OBJECT, Long.toString(((TaggingProfile) this.f9084g.get(i)).b)));
                if (set.contains(Long.valueOf(((TaggingProfile) this.f9084g.get(i)).b))) {
                    tokensBuilder.m10830a(Long.valueOf(((TaggingProfile) this.f9084g.get(i)).b), simpleUserToken);
                    if (z) {
                        this.bb.add(simpleUserToken);
                    }
                }
            }
        }
    }

    public static void m10836a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, UserIterator userIterator, TokensBuilder tokensBuilder, Set set, boolean z) {
        friendSuggestionsAndSelectorFragment.m10835a(tokensBuilder, set, z);
        while (userIterator.hasNext()) {
            User a = TokenPickerTokenUtil.a((User) userIterator.next());
            SimpleUserToken simpleUserToken = new SimpleUserToken(a);
            tokensBuilder.m10830a(Long.valueOf(Long.parseLong(a.a)), simpleUserToken);
            if (z && set.contains(Long.valueOf(Long.parseLong(a.a)))) {
                friendSuggestionsAndSelectorFragment.bb.add(simpleUserToken);
            }
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -702291234);
        if (this.aK != null) {
            this.aK.c();
        }
        this.bd.removeTextChangedListener(this.aT);
        this.am = null;
        this.bc = null;
        this.aQ.unregisterContentObserver(this.bl);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1363972998, a);
    }

    public static Intent aB(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment) {
        return friendSuggestionsAndSelectorFragment.ao().getIntent();
    }

    public static void m10841a(FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment, final Set set, final ArrayList arrayList, final boolean z) {
        friendSuggestionsAndSelectorFragment.aK.a("setup_tag_suggestions", friendSuggestionsAndSelectorFragment.aX.a(new Callable<ImmutableMap<Long, SimpleUserToken>>(friendSuggestionsAndSelectorFragment) {
            final /* synthetic */ FriendSuggestionsAndSelectorFragment f9058b;

            public Object call() {
                this.f9058b.aN.h();
                UserIterator a = this.f9058b.aZ.a(ContactCursorsQuery.a().d(FriendSuggestionsAndSelectorFragment.aA(this.f9058b)).a(SortKey.NAME));
                TokensBuilder tokensBuilder = new TokensBuilder(this.f9058b);
                try {
                    FriendSuggestionsAndSelectorFragment.m10836a(this.f9058b, a, tokensBuilder, set, true);
                    ImmutableMap a2 = tokensBuilder.m10829a();
                    this.f9058b.aN.i();
                    return a2;
                } finally {
                    a.close();
                }
            }
        }), new AbstractDisposableFutureCallback<ImmutableMap<Long, SimpleUserToken>>(friendSuggestionsAndSelectorFragment) {
            final /* synthetic */ FriendSuggestionsAndSelectorFragment f9061c;

            protected final void m10823a(Object obj) {
                ImmutableMap immutableMap = (ImmutableMap) obj;
                this.f9061c.aN.k();
                ImmutableList immutableList = null;
                if (z) {
                    immutableList = FriendSuggestionsAndSelectorFragment.m10831a(this.f9061c, arrayList, immutableMap, FriendSuggestionsAndSelectorFragment.aw(this.f9061c));
                }
                FriendSuggestionsAndSelectorFragment friendSuggestionsAndSelectorFragment = this.f9061c;
                if (!(friendSuggestionsAndSelectorFragment.aR || friendSuggestionsAndSelectorFragment.bi)) {
                    friendSuggestionsAndSelectorFragment.aW.m10879a(new AnonymousClass14(friendSuggestionsAndSelectorFragment, immutableList), new AbstractDisposableFutureCallback<ImmutableList<GroupTagToken>>(friendSuggestionsAndSelectorFragment) {
                        final /* synthetic */ FriendSuggestionsAndSelectorFragment f9064a;

                        {
                            this.f9064a = r1;
                        }

                        protected final void m10827a(Object obj) {
                            ImmutableList immutableList = (ImmutableList) obj;
                            if (immutableList != null && !immutableList.isEmpty()) {
                                this.f9064a.bh = immutableList;
                                this.f9064a.bc.a(SectionType.GROUP_SUGGESTIONS.ordinal(), new GroupSuggestionsSection(this.f9064a.jW_().getString(2131234468), immutableList));
                                this.f9064a.aO.f9047a.a(FriendSuggestionAnalytics.m10802a("group_tag_suggestions_shown", ((GroupTagToken) immutableList.get(0)).f, FriendSuggestionsAndSelectorFragment.aB(this.f9064a).getStringExtra("extra_composer_internal_session_id")));
                            }
                        }

                        protected final void m10828a(Throwable th) {
                        }
                    });
                }
                this.f9061c.m10843a(immutableMap.values().asList());
                this.f9061c.aN.l();
                this.f9061c.aN.m();
            }

            protected final void m10824a(Throwable th) {
                this.f9061c.aF.a("FriendSuggestionsAndSelectorFragment contact fetch failed", th);
                String str = "QueryFriends";
                Sequence e = this.f9061c.aN.b.e(WithTagPerformanceLogger.a);
                if (e != null) {
                    SequenceLoggerDetour.c(e, str, 1979519215);
                }
                this.f9061c.aN.m();
            }
        });
    }
}

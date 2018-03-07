package com.facebook.privacy.selector;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.contacts.iterator.UserIterator;
import com.facebook.contacts.iterator.UserIterators;
import com.facebook.graphql.model.GraphQLPrivacyAudienceMember;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.model.PrivacyLoadingToken;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyAudienceMember;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.ui.FriendlistOptionsSection;
import com.facebook.user.model.User;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.tokenizedtypeahead.BaseTokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenPickerTokenUtil;
import com.facebook.widget.tokenizedtypeahead.TokenSpan;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter;
import com.facebook.widget.tokenizedtypeahead.ui.listview.UserSectionedListSection;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: fbhtml> */
public class AbstractCustomPrivacyTypeaheadFragment extends FbFragment {
    public DefaultAndroidThreadUtil f15135a;
    public AudienceTokenMatcher al;
    protected SelectedMembersUpdater am;
    public SelectedTokenUpdater an;
    protected View ao;
    protected View ap;
    public TokenizedAutoCompleteTextView aq;
    public BetterListView ar;
    public View as;
    protected View at;
    protected List<BaseToken> au = new ArrayList();
    public final OnScrollListener av = new C10251(this);
    public ListenableFuture<ImmutableList<SimpleUserToken>> aw;
    public AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>> ax;
    public AbstractProvider<ImmutableList<GraphQLPrivacyOption>> ay;
    public ListeningExecutorService f15136b;
    protected UserIterators f15137c;
    protected AudienceTypeaheadUtil f15138d;
    protected InputMethodManager f15139e;
    protected DefaultUserInteractionController f15140f;
    public TypeaheadAdapter f15141g;
    protected TokenPickerTokenUtil f15142h;
    public AbstractFbErrorReporter f15143i;

    /* compiled from: fbhtml> */
    class C10251 implements OnScrollListener {
        final /* synthetic */ AbstractCustomPrivacyTypeaheadFragment f15129a;

        C10251(AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment) {
            this.f15129a = abstractCustomPrivacyTypeaheadFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            switch (i) {
                case 0:
                    this.f15129a.f15140f.b(this.f15129a.T);
                    return;
                case 1:
                case 2:
                    this.f15129a.f15140f.a(this.f15129a.T);
                    this.f15129a.at();
                    return;
                default:
                    return;
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: fbhtml> */
    public class C10262 implements Callable<ImmutableList<SimpleUserToken>> {
        final /* synthetic */ AbstractCustomPrivacyTypeaheadFragment f15130a;

        public C10262(AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment) {
            this.f15130a = abstractCustomPrivacyTypeaheadFragment;
        }

        public Object call() {
            UserIterator a = this.f15130a.f15137c.a(ContactCursorsQuery.a().d(ContactLinkType.FRIENDS).a(SortKey.NAME).f(false));
            Builder builder = ImmutableList.builder();
            while (a.hasNext()) {
                try {
                    TokenPickerTokenUtil tokenPickerTokenUtil = this.f15130a.f15142h;
                    builder.c(new SimpleUserToken(TokenPickerTokenUtil.m28699a((User) a.next())));
                } finally {
                    a.close();
                }
            }
            return builder.b();
        }
    }

    /* compiled from: fbhtml> */
    public class C10273 extends AbstractDisposableFutureCallback<ImmutableList<SimpleUserToken>> {
        final /* synthetic */ AbstractCustomPrivacyTypeaheadFragment f15131a;

        public C10273(AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment) {
            this.f15131a = abstractCustomPrivacyTypeaheadFragment;
        }

        protected final void m22721a(Object obj) {
            this.f15131a.f15141g.m27104a(SelectionIndices.f15134b, new UserSectionedListSection(this.f15131a.b(2131234222), (ImmutableList) obj));
            this.f15131a.aq();
        }

        protected final void m22722a(Throwable th) {
        }
    }

    /* compiled from: fbhtml> */
    public class C10284 implements Runnable {
        final /* synthetic */ AbstractCustomPrivacyTypeaheadFragment f15132a;

        public C10284(AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment) {
            this.f15132a = abstractCustomPrivacyTypeaheadFragment;
        }

        public void run() {
            this.f15132a.f15139e.showSoftInput(this.f15132a.aq, 0);
        }
    }

    /* compiled from: fbhtml> */
    public interface SelectedMembersUpdater {
        void mo1199a(List<GraphQLPrivacyAudienceMember> list);
    }

    /* compiled from: fbhtml> */
    public interface SelectedTokenUpdater {
        void mo1214a(List<BaseToken> list);
    }

    /* compiled from: fbhtml> */
    class SelectionIndices {
        public static int f15133a = 0;
        public static int f15134b = 1;
    }

    public static void m22727a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AbstractCustomPrivacyTypeaheadFragment) obj).m22726a(DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), UserIterators.a(injectorLike), AudienceTokenMatcher.m22752c(injectorLike), AudienceTypeaheadUtil.m22864b(injectorLike), InputMethodManagerMethodAutoProvider.b(injectorLike), DefaultUserInteractionController.a(injectorLike), TypeaheadAdapter.m27098b(injectorLike), TokenPickerTokenUtil.m28700a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    private void m22726a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService, UserIterators userIterators, AudienceTokenMatcher audienceTokenMatcher, AudienceTypeaheadUtil audienceTypeaheadUtil, InputMethodManager inputMethodManager, DefaultUserInteractionController defaultUserInteractionController, TypeaheadAdapter typeaheadAdapter, TokenPickerTokenUtil tokenPickerTokenUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f15135a = defaultAndroidThreadUtil;
        this.f15136b = listeningExecutorService;
        this.f15137c = userIterators;
        this.f15138d = audienceTypeaheadUtil;
        this.f15139e = inputMethodManager;
        this.f15140f = defaultUserInteractionController;
        this.f15141g = typeaheadAdapter;
        this.f15142h = tokenPickerTokenUtil;
        this.f15143i = abstractFbErrorReporter;
        this.al = audienceTokenMatcher;
    }

    public void mo1216c(Bundle bundle) {
        super.c(bundle);
        Class cls = AbstractCustomPrivacyTypeaheadFragment.class;
        m22727a(this, getContext());
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1291504654);
        if (this.aw != null) {
            this.aw.cancel(true);
            this.aw = null;
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2132452806, a);
    }

    public final void m22730a(SelectedMembersUpdater selectedMembersUpdater) {
        Preconditions.checkNotNull(selectedMembersUpdater);
        this.am = selectedMembersUpdater;
    }

    public final void m22732b() {
        this.aq.m28737b();
        this.aq.m28732a(new PrivacyLoadingToken(getContext()));
        this.aq.setEnabled(false);
        this.aq.setVisibility(0);
        this.aq.setAlpha(0.5f);
        this.ao.setVisibility(0);
    }

    public final void m22731a(BaseToken baseToken) {
        this.aq.m28733a((Token) baseToken, false);
    }

    public final void m22729a(GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember) {
        this.aq.m28733a(m22728b(graphQLPrivacyAudienceMember), false);
    }

    public final void m22734e() {
        au();
        if (!as()) {
            this.aw = this.f15136b.a(new C10262(this));
            this.f15135a.a(this.aw, new C10273(this));
        }
        if (this.aq.requestFocus()) {
            this.aq.postDelayed(new C10284(this), 100);
        }
    }

    private void au() {
        int i;
        AudienceTypeaheadUtil audienceTypeaheadUtil = this.f15138d;
        List<PrivacyOptionFieldsForComposer> list = (List) this.ay.get();
        List<PrivacyAudienceMember> list2 = (List) this.ax.get();
        HashSet a = Sets.a();
        for (PrivacyAudienceMember c : list2) {
            a.add(c.c());
        }
        Builder builder = ImmutableList.builder();
        Builder builder2 = ImmutableList.builder();
        int i2 = 3;
        for (PrivacyOptionFieldsForComposer a2 : list) {
            SimpleFriendlistToken a3 = audienceTypeaheadUtil.m22871a(a2);
            if (a3 != null) {
                builder.c(a3);
                if (a.contains(a3.f20117e)) {
                    builder2.c(a3);
                    i = i2 - 1;
                    i2 = i;
                }
            }
            i = i2;
            i2 = i;
        }
        ImmutableList b = builder.b();
        int size = b.size();
        int i3 = 0;
        while (i3 < size) {
            a3 = (SimpleFriendlistToken) b.get(i3);
            if (i2 <= 0) {
                break;
            }
            if (a.contains(a3.f20117e)) {
                i = i2;
            } else {
                builder2.c(a3);
                i = i2 - 1;
            }
            i3++;
            i2 = i;
        }
        this.f15141g.m27104a(SelectionIndices.f15133a, new FriendlistOptionsSection(b, builder2.b()));
    }

    protected final void aq() {
        this.aq.m28737b();
        this.aq.setEnabled(true);
        this.aq.setAlpha(1.0f);
        if (this.ax != null) {
            for (GraphQLPrivacyAudienceMember b : (List) this.ax.get()) {
                Token b2 = m22728b(b);
                if (b2 != null) {
                    this.aq.m28732a(b2);
                }
            }
        }
        this.ao.setVisibility(8);
        ar();
    }

    public void ar() {
        List<BaseToken> a = m22725a(this.aq);
        if (as()) {
            List arrayList = new ArrayList();
            for (BaseToken baseToken : a) {
                Object a2;
                if (baseToken.f15080a == Type.USER) {
                    a2 = AudienceTypeaheadUtil.m22859a((SimpleUserToken) baseToken);
                } else if (baseToken.f15080a == Type.FRIENDLIST) {
                    a2 = AudienceTypeaheadUtil.m22858a((SimpleFriendlistToken) baseToken);
                } else {
                    a2 = null;
                }
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            if (this.am != null) {
                this.am.mo1199a(arrayList);
            }
            if (this.an != null) {
                this.an.mo1214a(a);
            }
        }
    }

    private BaseToken m22728b(GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember) {
        if (graphQLPrivacyAudienceMember.b() == null) {
            return null;
        }
        if (graphQLPrivacyAudienceMember.b().g() == 2645995) {
            UserSectionedListSection userSectionedListSection = (UserSectionedListSection) this.f15141g.mo1060b(SelectionIndices.f15134b);
            if (userSectionedListSection == null) {
                return null;
            }
            return (SimpleUserToken) userSectionedListSection.f20156a.get(graphQLPrivacyAudienceMember.c());
        } else if (graphQLPrivacyAudienceMember.b().g() != 236555388) {
            return null;
        } else {
            FriendlistOptionsSection friendlistOptionsSection = (FriendlistOptionsSection) this.f15141g.mo1060b(SelectionIndices.f15133a);
            if (friendlistOptionsSection == null) {
                return null;
            }
            String c = graphQLPrivacyAudienceMember.c();
            for (BaseToken baseToken : friendlistOptionsSection.f15301a) {
                if (Objects.equal(baseToken.f20117e, c)) {
                    break;
                }
            }
            BaseToken baseToken2 = null;
            return baseToken2;
        }
    }

    public static List<BaseToken> m22725a(TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
        BaseTokenSpan[] baseTokenSpanArr = (BaseTokenSpan[]) tokenizedAutoCompleteTextView.getPickedTokenSpans();
        List<BaseToken> arrayList = new ArrayList();
        for (TokenSpan tokenSpan : baseTokenSpanArr) {
            arrayList.add(tokenSpan.f19988f);
        }
        return arrayList;
    }

    protected final boolean as() {
        return this.ao != null && this.ao.getVisibility() == 8;
    }

    protected final void at() {
        this.f15139e.hideSoftInputFromWindow(this.aq.getWindowToken(), 0);
    }
}

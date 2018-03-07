package com.facebook.privacy.selector;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
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
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsForComposer;
import com.facebook.privacy.selector.AbstractCustomPrivacyTypeaheadFragment.SelectedMembersUpdater;
import com.facebook.privacy.selector.AbstractCustomPrivacyTypeaheadFragment.SelectedTokenUpdater;
import com.facebook.privacy.selector.CustomPrivacyAdapter.RemoveTokensUpdater;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.model.User;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.tokenizedtypeahead.TokenPickerTokenUtil;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.model.SimpleFriendlistToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: fb4a_tagging_group_members_query */
public class CustomPrivacyFragment extends FbFragment {
    protected DefaultAndroidThreadUtil f15228a;
    public View al;
    private View am;
    private View an;
    public BetterListView ao;
    public BetterListView ap;
    private View aq;
    private View ar;
    private ListenableFuture<ImmutableList<BaseToken>> as;
    public SpecificFriendsTypeaheadFragment at;
    public SelectedMembersUpdater au;
    public AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>> av;
    public FriendsExceptTypeaheadFragment aw;
    public SelectedMembersUpdater ax;
    public AbstractProvider<ImmutableList<GraphQLPrivacyAudienceMember>> ay;
    public AbstractProvider<ImmutableList<GraphQLPrivacyOption>> az;
    protected ListeningExecutorService f15229b;
    protected UserIterators f15230c;
    protected TokenPickerTokenUtil f15231d;
    private AudienceTypeaheadUtil f15232e;
    public CustomPrivacyAdapter f15233f;
    public CustomPrivacyAdapter f15234g;
    private View f15235h;
    public View f15236i;

    /* compiled from: fb4a_tagging_group_members_query */
    public class C10431 implements RemoveTokensUpdater {
        final /* synthetic */ CustomPrivacyFragment f15215a;

        public C10431(CustomPrivacyFragment customPrivacyFragment) {
            this.f15215a = customPrivacyFragment;
        }

        public final void mo1213a(List<BaseToken> list, BaseToken baseToken) {
            if (this.f15215a.at != null) {
                this.f15215a.at.m22731a(baseToken);
            } else {
                this.f15215a.au.mo1199a(CustomPrivacyFragment.m22895d(list));
            }
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    public class C10442 implements RemoveTokensUpdater {
        final /* synthetic */ CustomPrivacyFragment f15216a;

        public C10442(CustomPrivacyFragment customPrivacyFragment) {
            this.f15216a = customPrivacyFragment;
        }

        public final void mo1213a(List<BaseToken> list, BaseToken baseToken) {
            if (this.f15216a.aw != null) {
                this.f15216a.aw.m22731a(baseToken);
            } else {
                this.f15216a.ax.mo1199a(CustomPrivacyFragment.m22895d(list));
            }
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    public class C10453 implements OnClickListener {
        final /* synthetic */ CustomPrivacyFragment f15217a;

        public C10453(CustomPrivacyFragment customPrivacyFragment) {
            this.f15217a = customPrivacyFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1031167839);
            CustomPrivacyFragment.ar(this.f15217a);
            Logger.a(2, EntryType.UI_INPUT_END, -649957831, a);
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    public class C10464 implements OnClickListener {
        final /* synthetic */ CustomPrivacyFragment f15218a;

        public C10464(CustomPrivacyFragment customPrivacyFragment) {
            this.f15218a = customPrivacyFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 362208192);
            CustomPrivacyFragment.as(this.f15218a);
            Logger.a(2, EntryType.UI_INPUT_END, 923819142, a);
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    class C10475 implements SelectedMembersUpdater {
        final /* synthetic */ CustomPrivacyFragment f15219a;

        C10475(CustomPrivacyFragment customPrivacyFragment) {
            this.f15219a = customPrivacyFragment;
        }

        public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
            this.f15219a.au.mo1199a(list);
            CustomPrivacyFragment.m22894b(list, (List) this.f15219a.ay.get(), this.f15219a.aw, this.f15219a.f15234g, this.f15219a.ax);
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    class C10486 implements SelectedTokenUpdater {
        final /* synthetic */ CustomPrivacyFragment f15220a;

        C10486(CustomPrivacyFragment customPrivacyFragment) {
            this.f15220a = customPrivacyFragment;
        }

        public final void mo1214a(List<BaseToken> list) {
            this.f15220a.m22897a(list);
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    class C10497 implements SelectedMembersUpdater {
        final /* synthetic */ CustomPrivacyFragment f15221a;

        C10497(CustomPrivacyFragment customPrivacyFragment) {
            this.f15221a = customPrivacyFragment;
        }

        public final void mo1199a(List<GraphQLPrivacyAudienceMember> list) {
            this.f15221a.ax.mo1199a(list);
            CustomPrivacyFragment.m22894b(list, (List) this.f15221a.av.get(), this.f15221a.at, this.f15221a.f15233f, this.f15221a.au);
        }
    }

    /* compiled from: fb4a_tagging_group_members_query */
    class C10508 implements SelectedTokenUpdater {
        final /* synthetic */ CustomPrivacyFragment f15222a;

        C10508(CustomPrivacyFragment customPrivacyFragment) {
            this.f15222a = customPrivacyFragment;
        }

        public final void mo1214a(List<BaseToken> list) {
            this.f15222a.m22899b(list);
        }
    }

    public static void m22893a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((CustomPrivacyFragment) obj).m22891a(DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), UserIterators.a(injectorLike), AudienceTypeaheadUtil.m22864b(injectorLike), TokenPickerTokenUtil.m28700a(injectorLike), CustomPrivacyAdapter.m22877b(injectorLike), CustomPrivacyAdapter.m22877b(injectorLike));
    }

    @Inject
    private void m22891a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService, UserIterators userIterators, AudienceTypeaheadUtil audienceTypeaheadUtil, TokenPickerTokenUtil tokenPickerTokenUtil, CustomPrivacyAdapter customPrivacyAdapter, CustomPrivacyAdapter customPrivacyAdapter2) {
        this.f15228a = defaultAndroidThreadUtil;
        this.f15229b = listeningExecutorService;
        this.f15230c = userIterators;
        this.f15232e = audienceTypeaheadUtil;
        this.f15231d = tokenPickerTokenUtil;
        this.f15233f = customPrivacyAdapter;
        this.f15234g = customPrivacyAdapter2;
    }

    public final void m22900c(Bundle bundle) {
        super.c(bundle);
        Class cls = CustomPrivacyFragment.class;
        m22893a((Object) this, getContext());
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2075008304);
        if (this.as != null) {
            this.as.cancel(true);
            this.as = null;
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 106006685, a);
    }

    public void onConfigurationChanged(Configuration configuration) {
        Object obj = null;
        super.onConfigurationChanged(configuration);
        FragmentManager s = s();
        FragmentTransaction a = s.a();
        if (this.at != null) {
            a.a(this.at);
            this.at = null;
        }
        if (this.aw != null) {
            a.a(this.aw);
            this.aw = null;
        }
        a.b();
        s.b();
        Object obj2 = (this.aq == null || this.aq.getVisibility() != 0) ? null : 1;
        if (this.ar != null && this.ar.getVisibility() == 0) {
            obj = 1;
        }
        this.aq = null;
        this.ar = null;
        m22890a(LayoutInflater.from(getContext()), (ViewGroup) this.T);
        if (obj2 != null) {
            ar(this);
        } else if (obj != null) {
            as(this);
        }
    }

    public final View m22896a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1538833397);
        ViewGroup frameLayout = new FrameLayout(getContext());
        m22890a(layoutInflater, frameLayout);
        this.f15236i.setEnabled(false);
        this.al.setEnabled(false);
        this.am.setVisibility(0);
        this.an.setVisibility(0);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1139528868, a);
        return frameLayout;
    }

    private void m22890a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        this.f15235h = layoutInflater.inflate(2130906389, viewGroup);
        this.am = this.f15235h.findViewById(2131566254);
        this.an = this.f15235h.findViewById(2131566260);
        this.f15236i = this.f15235h.findViewById(2131566256);
        this.al = this.f15235h.findViewById(2131566262);
        View view = this.f15235h;
        this.f15233f.f15210d = new C10431(this);
        this.ao = (BetterListView) view.findViewById(2131566255);
        this.ao.setAdapter(this.f15233f);
        this.f15234g.f15210d = new C10442(this);
        this.ap = (BetterListView) view.findViewById(2131566261);
        this.ap.setAdapter(this.f15234g);
        this.f15236i.setOnClickListener(new C10453(this));
        this.al.setOnClickListener(new C10464(this));
    }

    public static List<GraphQLPrivacyAudienceMember> m22895d(List<BaseToken> list) {
        List<GraphQLPrivacyAudienceMember> arrayList = new ArrayList();
        for (BaseToken baseToken : list) {
            Object a;
            if (baseToken.f15080a == Type.USER) {
                a = AudienceTypeaheadUtil.m22859a((SimpleUserToken) baseToken);
            } else if (baseToken.f15080a == Type.FRIENDLIST) {
                a = AudienceTypeaheadUtil.m22858a((SimpleFriendlistToken) baseToken);
            } else {
                a = null;
            }
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public static void ar(CustomPrivacyFragment customPrivacyFragment) {
        FragmentManager s = customPrivacyFragment.s();
        if (s.a(2131566249) == null) {
            customPrivacyFragment.at = new SpecificFriendsTypeaheadFragment();
            FragmentTransaction a = customPrivacyFragment.s().a();
            a.a(2131566249, customPrivacyFragment.at);
            a.b();
            s.b();
        } else {
            customPrivacyFragment.at = (SpecificFriendsTypeaheadFragment) s.a(2131566249);
        }
        if (customPrivacyFragment.au != null) {
            customPrivacyFragment.at.m22730a(new C10475(customPrivacyFragment));
        }
        customPrivacyFragment.at.ax = customPrivacyFragment.av;
        customPrivacyFragment.at.ay = customPrivacyFragment.az;
        customPrivacyFragment.at.an = new C10486(customPrivacyFragment);
        customPrivacyFragment.at.m22734e();
        customPrivacyFragment.aq = customPrivacyFragment.f15235h.findViewById(2131566249);
        customPrivacyFragment.aq.setVisibility(0);
        if (customPrivacyFragment.ar != null) {
            customPrivacyFragment.ar.setVisibility(8);
        }
    }

    public static void as(CustomPrivacyFragment customPrivacyFragment) {
        FragmentManager s = customPrivacyFragment.s();
        if (s.a(2131566250) == null) {
            customPrivacyFragment.aw = FriendsExceptTypeaheadFragment.m22905a(true);
            FragmentTransaction a = customPrivacyFragment.s().a();
            a.a(2131566250, customPrivacyFragment.aw);
            a.b();
            s.b();
        } else {
            customPrivacyFragment.aw = (FriendsExceptTypeaheadFragment) s.a(2131566250);
        }
        if (customPrivacyFragment.ax != null) {
            customPrivacyFragment.aw.m22730a(new C10497(customPrivacyFragment));
        }
        customPrivacyFragment.aw.ax = customPrivacyFragment.ay;
        customPrivacyFragment.aw.ay = customPrivacyFragment.az;
        customPrivacyFragment.aw.an = new C10508(customPrivacyFragment);
        customPrivacyFragment.aw.m22734e();
        customPrivacyFragment.ar = customPrivacyFragment.f15235h.findViewById(2131566250);
        customPrivacyFragment.ar.setVisibility(0);
        if (customPrivacyFragment.aq != null) {
            customPrivacyFragment.aq.setVisibility(8);
        }
    }

    public static void m22894b(List<GraphQLPrivacyAudienceMember> list, List<GraphQLPrivacyAudienceMember> list2, AbstractCustomPrivacyTypeaheadFragment abstractCustomPrivacyTypeaheadFragment, CustomPrivacyAdapter customPrivacyAdapter, SelectedMembersUpdater selectedMembersUpdater) {
        if (abstractCustomPrivacyTypeaheadFragment != null) {
            HashMap hashMap = new HashMap();
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember : list2) {
                hashMap.put(graphQLPrivacyAudienceMember.c(), graphQLPrivacyAudienceMember);
            }
            for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember2 : list) {
                if (hashMap.containsKey(graphQLPrivacyAudienceMember2.c())) {
                    abstractCustomPrivacyTypeaheadFragment.m22729a(graphQLPrivacyAudienceMember2);
                }
            }
            return;
        }
        HashMap hashMap2 = new HashMap();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember22 : list) {
            hashMap2.put(graphQLPrivacyAudienceMember22.c(), graphQLPrivacyAudienceMember22);
        }
        List arrayList = new ArrayList();
        List<BaseToken> a = customPrivacyAdapter.m22879a();
        for (GraphQLPrivacyAudienceMember graphQLPrivacyAudienceMember222 : list2) {
            if (hashMap2.containsKey(graphQLPrivacyAudienceMember222.c())) {
                for (BaseToken baseToken : a) {
                    String str = null;
                    if (baseToken.f15080a == Type.USER) {
                        str = ((SimpleUserToken) baseToken).f20125g.b();
                    } else if (baseToken.f15080a == Type.FRIENDLIST) {
                        str = ((SimpleFriendlistToken) baseToken).m28768c();
                    }
                    if (str != null && str.equals(graphQLPrivacyAudienceMember222.c())) {
                        a.remove(baseToken);
                        break;
                    }
                }
            } else {
                arrayList.add(graphQLPrivacyAudienceMember222);
            }
        }
        customPrivacyAdapter.m22881a(a);
        AdapterDetour.a(customPrivacyAdapter, 2055777578);
        selectedMembersUpdater.mo1199a(arrayList);
    }

    public final void m22898b() {
        List<PrivacyOptionFieldsForComposer> list = (List) this.az.get();
        List<GraphQLPrivacyAudienceMember> list2 = (List) this.av.get();
        final HashSet hashSet = new HashSet();
        for (GraphQLPrivacyAudienceMember c : list2) {
            hashSet.add(c.c());
        }
        list2 = (List) this.ay.get();
        final HashSet hashSet2 = new HashSet();
        for (GraphQLPrivacyAudienceMember c2 : list2) {
            hashSet2.add(c2.c());
        }
        final Builder builder = ImmutableList.builder();
        final Builder builder2 = ImmutableList.builder();
        for (PrivacyOptionFieldsForComposer privacyOptionFieldsForComposer : list) {
            ImmutableList F_ = privacyOptionFieldsForComposer.F_();
            if (F_.size() == 1) {
                if (hashSet.contains(((GraphQLPrivacyAudienceMember) F_.get(0)).c())) {
                    hashSet.remove(((GraphQLPrivacyAudienceMember) F_.get(0)).c());
                    builder.c(this.f15232e.m22871a(privacyOptionFieldsForComposer));
                }
                if (hashSet2.contains(((GraphQLPrivacyAudienceMember) F_.get(0)).c())) {
                    hashSet2.remove(((GraphQLPrivacyAudienceMember) F_.get(0)).c());
                    builder2.c(this.f15232e.m22871a(privacyOptionFieldsForComposer));
                }
            }
        }
        if (hashSet.isEmpty() && hashSet2.isEmpty()) {
            m22892a(this, builder.b(), builder2.b());
            return;
        }
        this.as = this.f15229b.a(new Callable<ImmutableList<BaseToken>>(this) {
            final /* synthetic */ CustomPrivacyFragment f15227e;

            public Object call() {
                UserIterator a = this.f15227e.f15230c.a(ContactCursorsQuery.a().d(ContactLinkType.FRIENDS).a(SortKey.NAME).f(false));
                while (a.hasNext()) {
                    try {
                        TokenPickerTokenUtil tokenPickerTokenUtil = this.f15227e.f15231d;
                        User a2 = TokenPickerTokenUtil.m28699a((User) a.next());
                        if (hashSet.contains(a2.d())) {
                            builder.c(new SimpleUserToken(a2));
                        }
                        if (hashSet2.contains(a2.d())) {
                            builder2.c(new SimpleUserToken(a2));
                        }
                    } finally {
                        a.close();
                    }
                }
                return null;
            }
        });
        this.f15228a.a(this.as, new AbstractDisposableFutureCallback<ImmutableList<BaseToken>>(this) {
            final /* synthetic */ CustomPrivacyFragment f15214c;

            protected final void m22882a(Object obj) {
                CustomPrivacyFragment.m22892a(this.f15214c, builder.b(), builder2.b());
            }

            protected final void m22883a(Throwable th) {
            }
        });
    }

    public static void m22892a(CustomPrivacyFragment customPrivacyFragment, List list, List list2) {
        customPrivacyFragment.am.setVisibility(8);
        customPrivacyFragment.an.setVisibility(8);
        customPrivacyFragment.m22897a(list);
        customPrivacyFragment.m22899b(list2);
        customPrivacyFragment.f15236i.setEnabled(true);
        customPrivacyFragment.al.setEnabled(true);
    }

    public final boolean m22901e() {
        if (this.aq != null && this.aq.getVisibility() == 0) {
            this.aq.setVisibility(8);
            return false;
        } else if (this.ar == null || this.ar.getVisibility() != 0) {
            return true;
        } else {
            this.ar.setVisibility(8);
            return false;
        }
    }

    public final void m22897a(List<BaseToken> list) {
        this.f15233f.m22881a(list);
    }

    public final void m22899b(List<BaseToken> list) {
        this.f15234g.m22881a(list);
    }
}

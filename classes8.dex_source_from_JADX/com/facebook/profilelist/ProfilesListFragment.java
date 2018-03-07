package com.facebook.profilelist;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profilelist.ProfilesListAdapter.Header;
import com.facebook.profilelist.ProfilesListAdapter.Profile;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;

/* compiled from: relevance */
public class ProfilesListFragment extends FbFragment {
    public static final Class<?> f4589a = ProfilesListFragment.class;
    public String al;
    public ProfilesSupplier am;
    private int an;
    private int ao;
    private ProfilesSupplierFactory ap;
    private final DataSetObserver aq = new C06021(this);
    public ComposerAnalyticsLogger f4590b;
    public ProfilesListAdapter f4591c;
    public BetterListView f4592d;
    public ImageView f4593e;
    public TextView f4594f;
    private TextView f4595g;
    public String f4596h;
    private TasksManager<Void> f4597i;

    /* compiled from: relevance */
    class C06021 extends DataSetObserver {
        final /* synthetic */ ProfilesListFragment f4584a;

        C06021(ProfilesListFragment profilesListFragment) {
            this.f4584a = profilesListFragment;
        }

        public void onChanged() {
            if (this.f4584a.f4590b != null) {
                this.f4584a.f4590b.a(Events.COMPOSER_FRIEND_TAG_READY, this.f4584a.al);
            }
        }
    }

    /* compiled from: relevance */
    class C06032 implements TextWatcher {
        final /* synthetic */ ProfilesListFragment f4585a;

        C06032(ProfilesListFragment profilesListFragment) {
            this.f4585a = profilesListFragment;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f4585a.f4596h = charSequence.toString().trim();
            if (this.f4585a.am.mo214a() || !TextUtils.isEmpty(this.f4585a.f4596h)) {
                ProfilesListFragment.ar(this.f4585a);
            } else {
                this.f4585a.m4462a(false, false);
            }
            this.f4585a.f4592d.setFastScrollEnabled(false);
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            int i = editable.length() > 0 ? 17301594 : 2130840885;
            int i2 = editable.length() > 0 ? 2131237369 : 2131237368;
            this.f4585a.f4593e.setImageResource(i);
            this.f4585a.f4593e.setContentDescription(this.f4585a.jW_().getString(i2));
        }
    }

    /* compiled from: relevance */
    class C06043 implements OnClickListener {
        final /* synthetic */ ProfilesListFragment f4586a;

        C06043(ProfilesListFragment profilesListFragment) {
            this.f4586a = profilesListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1345088752);
            if (this.f4586a.f4594f.length() > 0) {
                this.f4586a.f4594f.setText("");
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1735993536, a);
        }
    }

    /* compiled from: relevance */
    class C06054 implements OnItemClickListener {
        final /* synthetic */ ProfilesListFragment f4587a;

        C06054(ProfilesListFragment profilesListFragment) {
            this.f4587a = profilesListFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f4587a.f4591c.m4439a(view, i);
        }
    }

    /* compiled from: relevance */
    class C06065 extends AbstractDisposableFutureCallback<List<FacebookProfile>> {
        final /* synthetic */ ProfilesListFragment f4588a;

        C06065(ProfilesListFragment profilesListFragment) {
            this.f4588a = profilesListFragment;
        }

        protected final void m4440a(Object obj) {
            boolean z;
            List<FacebookProfile> list = (List) obj;
            BaseAdapter baseAdapter = this.f4588a.f4591c;
            String str = null;
            baseAdapter.f4580c.clear();
            for (FacebookProfile facebookProfile : list) {
                String a = baseAdapter.f4578a.a(ProfilesListAdapter.m4438b(facebookProfile));
                if (baseAdapter.f4583f && (r4 == null || !r4.equals(a))) {
                    baseAdapter.f4580c.add(new Header(baseAdapter, ProfilesListAdapter.m4438b(facebookProfile)));
                    str = a;
                }
                baseAdapter.f4580c.add(new Profile(baseAdapter, facebookProfile));
            }
            AdapterDetour.a(baseAdapter, -48133047);
            ProfilesListFragment profilesListFragment = this.f4588a;
            if (this.f4588a.f4591c.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            profilesListFragment.m4462a(false, z);
        }

        protected final void m4441a(Throwable th) {
            BLog.b(ProfilesListFragment.f4589a, "Failure fetching contacts", th);
        }
    }

    private static <T extends InjectableComponentWithContext> void m4445a(Class<T> cls, T t) {
        m4446a((Object) t, t.getContext());
    }

    private static void m4446a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfilesListFragment) obj).m4444a(ComposerAnalyticsLogger.a(fbInjector), TasksManager.b(fbInjector), ProfilesSupplierFactory.m4466a(fbInjector), new ProfilesListAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector), NameNormalizer.b(fbInjector), (Context) fbInjector.getInstance(Context.class)));
    }

    public final void m4464c(Bundle bundle) {
        super.c(bundle);
        m4445a(ProfilesListFragment.class, (InjectableComponentWithContext) this);
    }

    @Inject
    private void m4444a(ComposerAnalyticsLogger composerAnalyticsLogger, TasksManager tasksManager, ProfilesSupplierFactory profilesSupplierFactory, ProfilesListAdapter profilesListAdapter) {
        this.f4590b = composerAnalyticsLogger;
        this.f4597i = tasksManager;
        this.ap = profilesSupplierFactory;
        this.f4591c = profilesListAdapter;
    }

    public final View m4458a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 65909174);
        View inflate = layoutInflater.inflate(2130906443, viewGroup);
        this.f4592d = (BetterListView) inflate.findViewById(16908298);
        if (bundle != null) {
            Iterable parcelableArrayList = bundle.getParcelableArrayList("full_profiles");
            this.f4591c.f4582e = Sets.b(parcelableArrayList);
        }
        aq();
        this.f4594f = (TextView) inflate.findViewById(2131566358);
        this.f4594f.setText(this.f4596h);
        this.f4594f.addTextChangedListener(new C06032(this));
        this.f4593e = (ImageView) inflate.findViewById(2131566359);
        this.f4593e.setOnClickListener(new C06043(this));
        this.f4595g = (TextView) inflate.findViewById(2131561172);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 596116726, a);
        return inflate;
    }

    private void aq() {
        this.f4591c.registerDataSetObserver(this.aq);
        this.f4592d.setAdapter(this.f4591c);
        this.f4592d.setOnItemClickListener(new C06054(this));
    }

    public final void m4465e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelableArrayList("full_profiles", Lists.a(this.f4591c.f4582e));
    }

    public final void m4456G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1610958484);
        super.G();
        as();
        if (this.f4591c.isEmpty()) {
            ar(this);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2002042701, a);
    }

    public static void ar(ProfilesListFragment profilesListFragment) {
        profilesListFragment.m4462a(true, !profilesListFragment.f4591c.isEmpty());
        profilesListFragment.f4597i.b(null, profilesListFragment.am.mo213a(Optional.fromNullable(profilesListFragment.f4596h)), new C06065(profilesListFragment));
    }

    public final void m4457H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1698910433);
        super.H();
        this.f4597i.c();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -435657886, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 927848514);
        super.mY_();
        this.f4591c.unregisterDataSetObserver(this.aq);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -682211344, a);
    }

    public final void m4461a(HashSet<FacebookProfile> hashSet) {
        this.f4591c.f4582e = hashSet;
    }

    public final void m4460a(String str) {
        this.al = str;
    }

    private void as() {
        ((TextView) e(2131561172)).setText(this.ao);
    }

    public final void m4462a(boolean z, boolean z2) {
        int i;
        Object obj = 1;
        int i2 = 8;
        Object obj2 = (z || z2) ? null : 1;
        if (!z || z2) {
            obj = null;
        }
        int i3 = !TextUtils.isEmpty(this.f4596h) ? this.an : this.ao;
        BetterListView betterListView = this.f4592d;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        betterListView.setVisibility(i);
        TextView textView = this.f4595g;
        if (obj2 != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        this.f4595g.setText(i3);
        View e = e(2131561173);
        if (obj != null) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        e.setVisibility(i3);
        View e2 = e(16908292);
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        e2.setVisibility(i2);
    }

    public final void m4463b() {
        KeyboardUtils.a(o());
        Intent intent = new Intent();
        intent.putExtra("full_profiles", Lists.a(this.f4591c.f4582e));
        o().setResult(-1, intent);
        o().finish();
    }

    public final void m4459a(ProfilesListActivityConfig profilesListActivityConfig) {
        ProfilesSupplier profilesSupplier;
        ProfilesSupplierFactory profilesSupplierFactory = this.ap;
        long j = profilesListActivityConfig.f4572d;
        if (j == 0) {
            profilesSupplier = (ProfilesSupplier) profilesSupplierFactory.f4599a.get();
        } else {
            GroupMembersSupplier groupMembersSupplier = (GroupMembersSupplier) profilesSupplierFactory.f4600b.get();
            groupMembersSupplier.f4561c = j;
        }
        this.am = profilesSupplier;
        this.f4591c.f4583f = profilesListActivityConfig.f4573e;
        this.an = profilesListActivityConfig.f4570b;
        this.ao = profilesListActivityConfig.f4571c;
    }
}

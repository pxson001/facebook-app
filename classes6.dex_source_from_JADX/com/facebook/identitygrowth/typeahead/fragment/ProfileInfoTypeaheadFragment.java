package com.facebook.identitygrowth.typeahead.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.typeahead.TypeaheadInteractionsEventBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoCurrentCityFetcher;
import com.facebook.identitygrowth.protocol.ProfileInfoCurrentCityFetcher.C06881;
import com.facebook.identitygrowth.protocol.ProfileInfoCurrentCityFetcher.C06892;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadFetcher;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceFetcher;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadInferenceGraphQL.ProfileInfoCurrentCityPredictionQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchFetcher;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchFetcher.C06922;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQL.ProfileInfoTypeaheadSearchQueryString;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLInterfaces.TypeaheadResultPage;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.TypeaheadResultPageModel;
import com.facebook.inject.FbInjector;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mConstructorArgs */
public class ProfileInfoTypeaheadFragment extends FbFragment implements TextWatcher, OnItemClickListener {
    private ListView f11207a;
    public AnalyticsLogger al;
    private final Handler am = new Handler();
    private Runnable an;
    private String ao;
    private boolean ap;
    public String aq;
    public int ar;
    private ArrayList<Bundle> as;
    public volatile boolean at;
    private View f11208b;
    public EditText f11209c;
    private AbstractFbErrorReporter f11210d;
    public ProfileInfoCurrentCityFetcher f11211e;
    public ProfileInfoTypeaheadAdapter f11212f;
    private ProfileInfoTypeaheadInferenceFetcher f11213g;
    private ProfileInfoTypeaheadSearchFetcher f11214h;
    public Toaster f11215i;

    /* compiled from: mConstructorArgs */
    class C06941 implements Runnable {
        final /* synthetic */ ProfileInfoTypeaheadFragment f11203a;

        C06941(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment) {
            this.f11203a = profileInfoTypeaheadFragment;
        }

        public void run() {
            ProfileInfoTypeaheadFragment.m18101b(this.f11203a, this.f11203a.f11209c.getText().toString());
        }
    }

    /* compiled from: mConstructorArgs */
    public class C06952 implements FutureCallback<List<TypeaheadResultPage>> {
        final /* synthetic */ ProfileInfoTypeaheadFragment f11204a;

        public C06952(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment) {
            this.f11204a = profileInfoTypeaheadFragment;
        }

        public void onSuccess(Object obj) {
            List list = (List) obj;
            if (StringUtil.c(this.f11204a.f11209c.getText().toString())) {
                ProfileInfoTypeaheadFragment.m18098a(this.f11204a, list);
            }
        }

        public void onFailure(Throwable th) {
            ProfileInfoTypeaheadFragment.ar(this.f11204a);
        }
    }

    /* compiled from: mConstructorArgs */
    class C06963 implements FutureCallback<List<TypeaheadResultPage>> {
        final /* synthetic */ ProfileInfoTypeaheadFragment f11205a;

        C06963(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment) {
            this.f11205a = profileInfoTypeaheadFragment;
        }

        public void onSuccess(Object obj) {
            List list = (List) obj;
            if (StringUtil.c(this.f11205a.f11209c.getText().toString())) {
                ProfileInfoTypeaheadFragment.m18098a(this.f11205a, list);
                this.f11205a.at = false;
            }
        }

        public void onFailure(Throwable th) {
            this.f11205a.f11215i.b(new ToastBuilder(2131230759));
            this.f11205a.at = false;
        }
    }

    /* compiled from: mConstructorArgs */
    class C06974 implements FutureCallback<List<TypeaheadResultPage>> {
        final /* synthetic */ ProfileInfoTypeaheadFragment f11206a;

        C06974(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment) {
            this.f11206a = profileInfoTypeaheadFragment;
        }

        public void onSuccess(Object obj) {
            ProfileInfoTypeaheadFragment.m18098a(this.f11206a, (List) obj);
        }

        public void onFailure(Throwable th) {
            this.f11206a.f11215i.b(new ToastBuilder(2131230759));
        }
    }

    public static void m18099a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileInfoTypeaheadFragment) obj).m18097a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), new ProfileInfoCurrentCityFetcher(SimpleExecutor.m22275b(fbInjector), GraphQLQueryExecutor.a(fbInjector), FbLocationCache.b(fbInjector), Toaster.b(fbInjector)), ProfileInfoTypeaheadAdapter.m18094b(fbInjector), ProfileInfoTypeaheadInferenceFetcher.m17852b(fbInjector), ProfileInfoTypeaheadSearchFetcher.m17899b(fbInjector), Toaster.b(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    private boolean m18100a(String str) {
        Object obj;
        if ("high_school".equals(str) || "college".equals(str) || "work_history".equals(str) || "current_city".equals(str) || "hometown".equals(str)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return true;
        }
        this.f11210d.a("identitygrowth", "Failed to fetch typeahead results because of invalid profile section");
        return false;
    }

    @Inject
    private void m18097a(AbstractFbErrorReporter abstractFbErrorReporter, ProfileInfoCurrentCityFetcher profileInfoCurrentCityFetcher, ProfileInfoTypeaheadAdapter profileInfoTypeaheadAdapter, ProfileInfoTypeaheadInferenceFetcher profileInfoTypeaheadInferenceFetcher, ProfileInfoTypeaheadSearchFetcher profileInfoTypeaheadSearchFetcher, Toaster toaster, AnalyticsLogger analyticsLogger) {
        this.f11210d = abstractFbErrorReporter;
        this.f11211e = profileInfoCurrentCityFetcher;
        this.f11212f = profileInfoTypeaheadAdapter;
        this.f11213g = profileInfoTypeaheadInferenceFetcher;
        this.f11214h = profileInfoTypeaheadSearchFetcher;
        this.f11215i = toaster;
        this.at = false;
        this.al = analyticsLogger;
    }

    public final void m18106c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileInfoTypeaheadFragment.class;
        m18099a((Object) this, getContext());
    }

    public final void m18103H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 615379968);
        KeyboardUtils.a(ao());
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 781259364, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 13856339);
        HandlerDetour.a(this.am, this.an);
        this.f11213g.mo1069a();
        this.f11214h.mo1069a();
        this.f11211e.mo1069a();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1462038925, a);
    }

    public final View m18104a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 907961572);
        View inflate = layoutInflater.inflate(2130906440, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1150454276, a);
        return inflate;
    }

    public final void m18105a(View view, Bundle bundle) {
        this.f11208b = view.findViewById(2131566355);
        this.f11209c = (EditText) this.f11208b.findViewById(2131566356);
        this.f11209c.setText("");
        this.f11209c.addTextChangedListener(this);
        this.f11207a = (ListView) view.findViewById(16908298);
        this.f11207a.setOnItemClickListener(this);
        this.f11207a.setAdapter(this.f11212f);
        this.ao = this.s.getString("profile_section");
        this.as = this.s.getParcelableArrayList("typeahead_existing_fields");
        this.ap = this.s.getBoolean("typeahead_use_current_city_inference");
        this.aq = this.s.getString("logging_surfaces");
        this.ar = new Random().nextInt();
        m18102e();
    }

    public void afterTextChanged(Editable editable) {
        if (this.an != null) {
            HandlerDetour.a(this.am, this.an);
        }
        this.an = new C06941(this);
        HandlerDetour.b(this.am, this.an, 300, -1638582501);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        TypeaheadResultPageModel a = this.f11212f.m18095a(i);
        this.al.a(new TypeaheadInteractionsEventBuilder("profile_question_object_selected", "profile_experience_picker").m11075h(this.aq).m11065a(this.f11212f.m18096a()).m11070c(this.f11209c.getText().toString()).m11071d(String.valueOf(this.ar)).m11068b(a.m17933d()).m11069c(i).f7751a);
        Intent intent = new Intent();
        intent.putExtra("typeahead_selected_page_name", a.dj_());
        intent.putExtra("typeahead_selected_page_id", a.m17933d());
        intent.putExtra("profile_section", this.ao);
        ao().setResult(-1, intent);
        ao().finish();
    }

    private void m18102e() {
        if (!m18100a(this.ao)) {
            return;
        }
        if ("current_city".equals(this.ao) && this.ap) {
            ProfileInfoTypeaheadFetcher profileInfoTypeaheadFetcher = this.f11211e;
            C06952 c06952 = new C06952(this);
            Preconditions.checkNotNull(c06952);
            if (!profileInfoTypeaheadFetcher.f11109c) {
                profileInfoTypeaheadFetcher.f11109c = true;
                ImmutableLocation a = profileInfoTypeaheadFetcher.f11107a.a();
                if (a == null) {
                    profileInfoTypeaheadFetcher.f11109c = false;
                    c06952.onFailure(null);
                } else {
                    C06881 c06881 = new C06881(profileInfoTypeaheadFetcher, c06952);
                    GraphQlQueryString profileInfoCurrentCityPredictionQueryString = new ProfileInfoCurrentCityPredictionQueryString();
                    profileInfoCurrentCityPredictionQueryString.a("user_latitude", Double.toString(a.a())).a("user_longitude", Double.toString(a.b())).a("results_num", Integer.toString(5));
                    profileInfoTypeaheadFetcher.m17848a(profileInfoCurrentCityPredictionQueryString, c06881, new C06892(profileInfoTypeaheadFetcher));
                }
            }
            return;
        }
        ar(this);
    }

    public static void ar(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment) {
        if (profileInfoTypeaheadFragment.as == null || profileInfoTypeaheadFragment.as.isEmpty()) {
            m18098a(profileInfoTypeaheadFragment, null);
            return;
        }
        profileInfoTypeaheadFragment.f11214h.mo1069a();
        profileInfoTypeaheadFragment.at = true;
        profileInfoTypeaheadFragment.f11213g.m17853a(profileInfoTypeaheadFragment.ao, profileInfoTypeaheadFragment.as, new C06963(profileInfoTypeaheadFragment));
    }

    public static void m18101b(ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment, String str) {
        if (StringUtil.c(str)) {
            if (!profileInfoTypeaheadFragment.at) {
                profileInfoTypeaheadFragment.m18102e();
            }
        } else if (profileInfoTypeaheadFragment.m18100a(profileInfoTypeaheadFragment.ao)) {
            profileInfoTypeaheadFragment.f11214h.mo1069a();
            ProfileInfoTypeaheadFetcher profileInfoTypeaheadFetcher = profileInfoTypeaheadFragment.f11214h;
            String str2 = profileInfoTypeaheadFragment.ao;
            int i = profileInfoTypeaheadFragment.ar;
            C06974 c06974 = new C06974(profileInfoTypeaheadFragment);
            GraphQlQueryString profileInfoTypeaheadSearchQueryString = new ProfileInfoTypeaheadSearchQueryString();
            profileInfoTypeaheadSearchQueryString.a("search_query", str).a("profile_section", str2).a("typeahead_session_id", String.valueOf(i)).a("results_num", Integer.toString(10));
            profileInfoTypeaheadFetcher.m17849a(profileInfoTypeaheadSearchQueryString, c06974, new C06922(profileInfoTypeaheadFetcher), profileInfoTypeaheadFetcher.f11122a);
        }
    }

    public static void m18098a(@Nullable ProfileInfoTypeaheadFragment profileInfoTypeaheadFragment, List list) {
        boolean z;
        if (list == null) {
            list = Lists.a();
        }
        ProfileInfoTypeaheadAdapter profileInfoTypeaheadAdapter = profileInfoTypeaheadFragment.f11212f;
        String str = profileInfoTypeaheadFragment.ao;
        if ("current_city".equals(str) || "hometown".equals(str)) {
            z = true;
        } else {
            z = false;
        }
        profileInfoTypeaheadAdapter.f11201c = z;
        profileInfoTypeaheadFragment.f11212f.f11200b = ImmutableList.copyOf(list);
        AdapterDetour.a(profileInfoTypeaheadFragment.f11212f, -968775340);
    }
}

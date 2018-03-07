package com.facebook.places.suggestions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.util.StringUtil;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.PageTopic;
import com.facebook.location.ImmutableLocation;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.common.MockDeps;
import com.facebook.places.common.PlacesMapFragment;
import com.facebook.places.common.PlacesMapFragment.MapListener;
import com.facebook.places.common.SelectPageTopicActivity;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.places.graphql.PlacesGraphQL.PlaceDetailsQueryString;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.PlaceDetails;
import com.facebook.places.graphql.PlacesGraphQLModels.PlaceDetailsModel;
import com.facebook.places.graphql.PlacesGraphQLModels.PlaceDetailsModel.AddressModel;
import com.facebook.places.graphql.PlacesGraphQLModels.PlaceDetailsModel.AllPhonesModel;
import com.facebook.places.pagetopics.FetchPageTopicsResult;
import com.facebook.places.pagetopics.FetchPageTopicsRunner;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import com.facebook.places.suggestions.common.SuggestPlaceInfoParams;
import com.facebook.places.suggestions.common.SuggestPlaceInfoParams.Builder;
import com.facebook.places.suggestions.common.SuggestPlaceInfoRunner;
import com.facebook.places.suggestions.common.SuggestProfilePicFragment;
import com.facebook.places.suggestions.common.SuggestProfilePicFragment.PhotoListener;
import com.facebook.survey.util.SurveyUtil;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: secondary_action_label */
public class SuggestPlaceInfoActivity extends FbFragmentActivity implements UsesSimpleStringTitle, MapListener, PhotoListener {
    public static final Class<?> f3677p = SuggestPlaceInfoActivity.class;
    private FbTitleBar f3678A;
    private PlacesMapFragment f3679B;
    private SuggestProfilePicFragment f3680C;
    private Builder f3681D;
    public State f3682E;
    public DialogFragment f3683F;
    private CrowdsourcingSource f3684G;
    private CrowdEntryPoint f3685H;
    public Toaster f3686I;
    private SuggestPlaceInfoRunner f3687J;
    private FetchPlaceDetailsRunner f3688K;
    private FetchPageTopicsRunner f3689L;
    private SimpleExecutor f3690M;
    public SuggestPlaceInfoSurveys f3691N;
    private FutureCallback<PlaceDetails> f3692O = new C04691(this);
    private final OnToolbarButtonListener f3693P = new C04757(this);
    private CategoryListAdapter f3694q;
    private long f3695r;
    private String f3696s;
    public PlaceDetailsModel f3697t;
    public List<PageTopic> f3698u;
    private TextView f3699v;
    private TextView f3700w;
    private TextView f3701x;
    private TextView f3702y;
    private TextView f3703z;

    /* compiled from: secondary_action_label */
    class C04691 implements FutureCallback<PlaceDetails> {
        final /* synthetic */ SuggestPlaceInfoActivity f3661a;

        C04691(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3661a = suggestPlaceInfoActivity;
        }

        public void onSuccess(Object obj) {
            PlaceDetailsModel placeDetailsModel = (PlaceDetailsModel) obj;
            Preconditions.checkState(this.f3661a.f3682E == State.FETCHING);
            this.f3661a.f3697t = placeDetailsModel;
            SuggestPlaceInfoActivity.m3613k(this.f3661a);
        }

        public void onFailure(Throwable th) {
            this.f3661a.f3686I.b(new ToastBuilder(2131230758));
            BLog.a(SuggestPlaceInfoActivity.f3677p, "Error loading Page information", th);
            this.f3661a.finish();
        }
    }

    /* compiled from: secondary_action_label */
    class C04702 implements FutureCallback<FetchPageTopicsResult> {
        final /* synthetic */ SuggestPlaceInfoActivity f3662a;

        C04702(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3662a = suggestPlaceInfoActivity;
        }

        public void onSuccess(Object obj) {
            FetchPageTopicsResult fetchPageTopicsResult = (FetchPageTopicsResult) obj;
            this.f3662a.f3698u = fetchPageTopicsResult.a();
            SuggestPlaceInfoActivity.m3613k(this.f3662a);
        }

        public void onFailure(Throwable th) {
            this.f3662a.f3698u = new ArrayList();
        }
    }

    /* compiled from: secondary_action_label */
    class C04713 implements OnClickListener {
        final /* synthetic */ SuggestPlaceInfoActivity f3663a;

        C04713(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3663a = suggestPlaceInfoActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 843056617);
            SuggestPlaceInfoActivity.m3620r(this.f3663a);
            Logger.a(2, EntryType.UI_INPUT_END, -2065786450, a);
        }
    }

    /* compiled from: secondary_action_label */
    class C04724 implements TextWatcher {
        final /* synthetic */ SuggestPlaceInfoActivity f3664a;

        C04724(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3664a = suggestPlaceInfoActivity;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SuggestPlaceInfoActivity.m3615m(this.f3664a);
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: secondary_action_label */
    class C04735 extends DataSetObserver {
        final /* synthetic */ SuggestPlaceInfoActivity f3665a;

        C04735(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3665a = suggestPlaceInfoActivity;
        }

        public void onChanged() {
            SuggestPlaceInfoActivity.m3615m(this.f3665a);
        }
    }

    /* compiled from: secondary_action_label */
    class C04746 implements FutureCallback<Void> {
        final /* synthetic */ SuggestPlaceInfoActivity f3666a;

        C04746(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3666a = suggestPlaceInfoActivity;
        }

        public void onSuccess(Object obj) {
            Preconditions.checkState(this.f3666a.f3682E == State.SAVING);
            this.f3666a.f3682E = State.NONE;
            this.f3666a.f3683F.b();
            this.f3666a.f3686I.b(new ToastBuilder(2131237625));
            SuggestPlaceInfoSurveys suggestPlaceInfoSurveys = this.f3666a.f3691N;
            Object obj2 = this.f3666a;
            if (suggestPlaceInfoSurveys.f3714e != null) {
                suggestPlaceInfoSurveys.f3712c.m10801a(suggestPlaceInfoSurveys.f3714e.longValue(), obj2);
            }
            Intent intent = new Intent();
            intent.putExtra("extra_place_suggestion_complete", true);
            this.f3666a.setResult(-1, intent);
            this.f3666a.finish();
        }

        public void onFailure(Throwable th) {
            BLog.a(SuggestPlaceInfoActivity.f3677p, "Failure to save place suggestions");
            Preconditions.checkState(this.f3666a.f3682E == State.SAVING);
            this.f3666a.f3682E = State.NONE;
            this.f3666a.f3683F.b();
            this.f3666a.f3686I.b(new ToastBuilder(2131237626));
        }
    }

    /* compiled from: secondary_action_label */
    class C04757 extends OnToolbarButtonListener {
        final /* synthetic */ SuggestPlaceInfoActivity f3667a;

        C04757(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
            this.f3667a = suggestPlaceInfoActivity;
        }

        public final void m3592a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f3667a.m3626i();
        }
    }

    /* compiled from: secondary_action_label */
    class CategoryListAdapter extends ArrayAdapter<PageTopic> {
        final /* synthetic */ SuggestPlaceInfoActivity f3673a;
        private Context f3674b;
        private int f3675c;
        private Set<PageTopic> f3676d = new HashSet();

        /* compiled from: secondary_action_label */
        class ViewHolder {
            ImageButton f3670a;
            TextView f3671b;
            final /* synthetic */ CategoryListAdapter f3672c;

            public ViewHolder(CategoryListAdapter categoryListAdapter) {
                this.f3672c = categoryListAdapter;
            }
        }

        public /* synthetic */ void add(Object obj) {
            m3593a((PageTopic) obj);
        }

        public /* synthetic */ void remove(Object obj) {
            m3594b((PageTopic) obj);
        }

        public CategoryListAdapter(SuggestPlaceInfoActivity suggestPlaceInfoActivity, Context context, int i) {
            this.f3673a = suggestPlaceInfoActivity;
            super(context, i);
            this.f3674b = context;
            this.f3675c = i;
        }

        public final void m3593a(PageTopic pageTopic) {
            if (!this.f3676d.contains(pageTopic)) {
                this.f3676d.add(pageTopic);
                super.add(pageTopic);
            }
        }

        public final void m3594b(PageTopic pageTopic) {
            this.f3676d.remove(pageTopic);
            super.remove(pageTopic);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = ((Activity) this.f3674b).getLayoutInflater().inflate(this.f3675c, viewGroup, false);
                viewHolder = new ViewHolder(this);
                viewHolder.f3671b = (TextView) view.findViewById(2131560268);
                viewHolder.f3670a = (ImageButton) view.findViewById(2131566014);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            PageTopic pageTopic = (PageTopic) getItem(i);
            viewHolder.f3670a.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CategoryListAdapter f3669b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1077599338);
                    SuggestPlaceInfoActivity.m3605b(this.f3669b.f3673a, i);
                    Logger.a(2, EntryType.UI_INPUT_END, -354125257, a);
                }
            });
            viewHolder.f3670a.setContentDescription(this.f3673a.getString(2131235205, new Object[]{pageTopic.displayName}));
            viewHolder.f3671b.setText(pageTopic.displayName);
            return view;
        }
    }

    /* compiled from: secondary_action_label */
    enum State {
        NONE,
        FETCHING,
        SAVING
    }

    public final void m3624b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906270);
        FbTitleBarUtil.b(this);
        this.f3678A = (FbTitleBar) a(2131558563);
        getWindow().setSoftInputMode(3);
        Intent intent = getIntent();
        this.f3695r = intent.getLongExtra("place_id", 0);
        this.f3696s = intent.getStringExtra("place_pic_url");
        this.f3681D = SuggestPlaceInfoParams.m3645a(Long.toString(this.f3695r));
        this.f3684G = (CrowdsourcingSource) intent.getSerializableExtra("source");
        this.f3685H = (CrowdEntryPoint) intent.getSerializableExtra("entry_point");
        FbInjector hz_ = hz_();
        this.f3686I = Toaster.b(hz_);
        this.f3688K = (FetchPlaceDetailsRunner) MockDeps.a(FetchPlaceDetailsRunner.class, new FetchPlaceDetailsRunner(SimpleExecutor.b(hz_), GraphQLQueryExecutor.a(hz_)));
        this.f3687J = (SuggestPlaceInfoRunner) MockDeps.a(SuggestPlaceInfoRunner.class, SuggestPlaceInfoRunner.m3646b(hz_));
        this.f3689L = (FetchPageTopicsRunner) MockDeps.a(FetchPageTopicsRunner.class, FetchPageTopicsRunner.b(hz_));
        this.f3690M = SimpleExecutor.b(hz_);
        this.f3691N = new SuggestPlaceInfoSurveys(GraphQLQueryExecutor.a(hz_), TasksManager.b(hz_), SurveyUtil.m10800b(hz_));
        m3618p();
        this.f3679B = (PlacesMapFragment) Preconditions.checkNotNull(kO_().a(2131566023));
        PlacesMapFragment.g = this;
        this.f3683F = ProgressDialogFragment.a(2131233366, true, false);
        this.f3683F.a(kO_(), "dialog");
        this.f3682E = State.FETCHING;
        m3614l();
        this.f3691N.m3630a();
    }

    public static void m3613k(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
        if (suggestPlaceInfoActivity.f3697t != null && suggestPlaceInfoActivity.f3698u != null) {
            suggestPlaceInfoActivity.f3683F.b();
            suggestPlaceInfoActivity.m3619q();
            m3615m(suggestPlaceInfoActivity);
        }
    }

    private void m3614l() {
        FetchPlaceDetailsRunner fetchPlaceDetailsRunner = this.f3688K;
        Long valueOf = Long.valueOf(this.f3695r);
        FutureCallback futureCallback = this.f3692O;
        GraphQlQueryString placeDetailsQueryString = new PlaceDetailsQueryString();
        placeDetailsQueryString.a("node", valueOf.toString());
        fetchPlaceDetailsRunner.f3622a.a(GraphQLQueryExecutor.a(fetchPlaceDetailsRunner.f3623b.a(GraphQLRequest.a(placeDetailsQueryString))), futureCallback);
        this.f3689L.a(new C04702(this));
    }

    public static void m3615m(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = suggestPlaceInfoActivity.getString(2131230752);
        a = a;
        a.d = suggestPlaceInfoActivity.m3616n();
        suggestPlaceInfoActivity.f3678A.setButtonSpecs(ImmutableList.of(a.a()));
        suggestPlaceInfoActivity.f3678A.setOnToolbarButtonListener(suggestPlaceInfoActivity.f3693P);
    }

    private boolean m3616n() {
        if (m3603a(this.f3699v) || m3603a(this.f3700w) || m3603a(this.f3703z) || m3603a(this.f3701x) || m3603a(this.f3702y) || this.f3680C.aq() || m3617o() || this.f3679B.b()) {
            return true;
        }
        return false;
    }

    private static boolean m3603a(TextView textView) {
        return !textView.getText().toString().equals(textView.getTag());
    }

    private boolean m3617o() {
        List a = m3600a(m3598a(this.f3697t));
        if (this.f3694q.getCount() != a.size()) {
            return true;
        }
        for (int i = 0; i < this.f3694q.getCount(); i++) {
            if (((PageTopic) this.f3694q.getItem(i)).id != ((PageTopic) a.get(i)).id) {
                return true;
            }
        }
        return false;
    }

    public final void m3623b() {
        m3615m(this);
    }

    public final void mo195c() {
        m3615m(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        CharSequence text = this.f3699v.getText();
        if (text != null) {
            bundle.putString("name", text.toString());
        }
        text = this.f3700w.getText();
        if (text != null) {
            bundle.putString("address", text.toString());
        }
        text = this.f3701x.getText();
        if (text != null) {
            bundle.putString("phone", text.toString());
        }
        text = this.f3702y.getText();
        if (text != null) {
            bundle.putString("website", text.toString());
        }
        text = this.f3703z.getText();
        if (text != null) {
            bundle.putString("city", text.toString());
        }
        FlatBufferModelHelper.a(bundle, "place", this.f3697t);
        ArrayList a = Lists.a(this.f3694q.getCount());
        for (int i = 0; i < this.f3694q.getCount(); i++) {
            a.add(this.f3694q.getItem(i));
        }
        bundle.putParcelableArrayList("topics", a);
    }

    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        if (bundle != null) {
            CharSequence string = bundle.getString("name");
            if (string != null) {
                this.f3699v.setText(string);
                bundle.remove("name");
            }
            string = bundle.getString("address");
            if (string != null) {
                this.f3700w.setText(string);
                bundle.remove("address");
            }
            string = bundle.getString("phone");
            if (string != null) {
                this.f3701x.setText(string);
                bundle.remove("phone");
            }
            string = bundle.getString("website");
            if (string != null) {
                this.f3702y.setText(string);
                bundle.remove("website");
            }
            string = bundle.getString("city");
            if (string != null) {
                this.f3703z.setText(string);
                bundle.remove("city");
            }
            PlaceDetailsModel placeDetailsModel = (PlaceDetailsModel) FlatBufferModelHelper.a(bundle, "place");
            if (placeDetailsModel != null) {
                this.f3697t = placeDetailsModel;
                bundle.remove("place");
            }
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("topics");
            if (parcelableArrayList != null) {
                int size = parcelableArrayList.size();
                for (int i = 0; i < size; i++) {
                    this.f3694q.m3593a((PageTopic) parcelableArrayList.get(i));
                }
            }
        }
    }

    private void m3618p() {
        ListView listView = (ListView) findViewById(2131566022);
        View inflate = getLayoutInflater().inflate(2130906272, listView, false);
        View inflate2 = getLayoutInflater().inflate(2130906271, listView, false);
        listView.addHeaderView(inflate);
        listView.addFooterView(inflate2);
        inflate2.setOnClickListener(new C04713(this));
        TextWatcher c04724 = new C04724(this);
        this.f3699v = (TextView) findViewById(2131562901);
        this.f3700w = (TextView) findViewById(2131566024);
        this.f3701x = (TextView) findViewById(2131566026);
        this.f3702y = (TextView) findViewById(2131566027);
        this.f3703z = (TextView) findViewById(2131564224);
        this.f3700w.addTextChangedListener(c04724);
        this.f3699v.addTextChangedListener(c04724);
        this.f3701x.addTextChangedListener(c04724);
        this.f3702y.addTextChangedListener(c04724);
        this.f3703z.addTextChangedListener(c04724);
        this.f3694q = new CategoryListAdapter(this, this, 2130906264);
        this.f3694q.registerDataSetObserver(new C04735(this));
        listView.setAdapter(this.f3694q);
        this.f3680C = (SuggestProfilePicFragment) kO_().a(2131566025);
        this.f3680C.aq = this.f3684G;
        this.f3680C.ar = this.f3685H;
        this.f3680C.as = CrowdEndpoint.SUGGEST_EDITS;
        this.f3680C.f3788b = this;
        this.f3680C.f3795i = true;
        if (!StringUtil.c(this.f3696s)) {
            this.f3680C.m3661a(Uri.parse(this.f3696s));
        }
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1625158124);
        super.onResume();
        m3615m(this);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -448667112, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -675002375);
        super.onDestroy();
        this.f3680C.f3788b = null;
        this.f3688K.f3622a.c();
        this.f3687J.m3647a();
        this.f3689L.a();
        this.f3690M.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1776384189, a);
    }

    @VisibleForTesting
    public final void m3626i() {
        CharSequence text = this.f3699v.getText();
        if (text != null) {
            if (!StringUtil.c(text.toString())) {
                this.f3681D.m3636a(text.toString());
            } else {
                return;
            }
        }
        text = this.f3700w.getText();
        if (text != null) {
            this.f3681D.m3639b(text.toString());
        }
        text = this.f3701x.getText();
        if (text != null) {
            this.f3681D.m3641f(text.toString());
        }
        text = this.f3702y.getText();
        if (text != null) {
            this.f3681D.f3729j = (String) Preconditions.checkNotNull(text.toString());
        }
        text = this.f3703z.getText();
        if (text != null) {
            this.f3681D.f3723d = (String) Preconditions.checkNotNull(text.toString());
        }
        if (this.f3684G != null) {
            this.f3681D.f3715A = this.f3684G;
        }
        this.f3681D.f3718D = this.f3685H;
        this.f3681D.f3719E = CrowdEndpoint.SUGGEST_EDITS;
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f3694q.getCount(); i++) {
            builder.c(Long.valueOf(((PageTopic) this.f3694q.getItem(i)).id));
        }
        this.f3681D.m3638b(builder.b());
        if (this.f3679B.b()) {
            this.f3681D.f3732m = (ImmutableLocation) Preconditions.checkNotNull(this.f3679B.c);
        }
        this.f3682E = State.SAVING;
        this.f3683F = ProgressDialogFragment.a(2131230757, true, false);
        this.f3683F.a(kO_(), "dialog");
        m3621s();
        this.f3687J.m3648a(this.f3681D.m3637a(), new C04746(this));
        this.f3680C.m3659a(this.f3695r);
    }

    private void m3619q() {
        if (this.f3697t != null) {
            List<PageTopic> a = m3598a(this.f3697t);
            m3606b((List) a);
            if (a.size() > 0) {
                ImmutableList.Builder builder = ImmutableList.builder();
                for (PageTopic pageTopic : a) {
                    builder.c(Long.valueOf(pageTopic.id));
                }
                this.f3681D.m3640e(builder.b());
            }
            this.f3699v.setText(this.f3697t.g());
            this.f3681D.m3642i(this.f3697t.g());
            AddressModel b = this.f3697t.b();
            if (b != null) {
                Object b2 = b.b();
                if (b2 != null) {
                    this.f3700w.setText(b2);
                    this.f3681D.m3643j(b2);
                }
                CharSequence a2 = b.a();
                if (a2 != null) {
                    this.f3703z.setText(a2);
                    this.f3681D.f3737r = (String) Preconditions.checkNotNull(a2);
                }
            } else {
                this.f3700w.setVisibility(8);
                ((ViewGroup) this.f3701x.getParent()).removeView(this.f3701x);
                ((ViewGroup) this.f3700w.getParent()).addView(this.f3701x);
                this.f3703z.setVisibility(8);
            }
            ImmutableList c = this.f3697t.c();
            if (c != null && c.size() > 0) {
                Object a3 = ((AllPhonesModel) c.get(0)).a().a();
                if (a3 != null) {
                    this.f3701x.setText(a3);
                    this.f3681D.m3644n(a3);
                }
            }
            ImmutableList ck_ = this.f3697t.ck_();
            if (ck_ != null && ck_.size() > 0) {
                this.f3702y.setText((CharSequence) ck_.get(0));
                this.f3681D.f3743x = (String) Preconditions.checkNotNull((String) ck_.get(0));
            }
            this.f3679B.a(ImmutableLocation.a(this.f3697t.cl_().a(), this.f3697t.cl_().b()).a());
            this.f3699v.setTag(this.f3699v.getText().toString());
            this.f3700w.setTag(this.f3700w.getText().toString());
            this.f3701x.setTag(this.f3701x.getText().toString());
            this.f3702y.setTag(this.f3702y.getText().toString());
            this.f3703z.setTag(this.f3703z.getText().toString());
        }
    }

    private static List<PageTopic> m3600a(List<PageTopic> list) {
        List<PageTopic> a = Lists.a();
        for (PageTopic pageTopic : list) {
            if (pageTopic.id > 100000) {
                a.add(pageTopic);
            }
        }
        return a;
    }

    private void m3606b(List<PageTopic> list) {
        for (PageTopic a : m3600a((List) list)) {
            this.f3694q.m3593a(a);
        }
        AdapterDetour.a(this.f3694q, 1342119821);
    }

    private void m3601a(PageTopic pageTopic) {
        List arrayList = new ArrayList(1);
        arrayList.add(pageTopic);
        m3606b(arrayList);
    }

    public static void m3605b(SuggestPlaceInfoActivity suggestPlaceInfoActivity, int i) {
        suggestPlaceInfoActivity.f3694q.m3594b((PageTopic) suggestPlaceInfoActivity.f3694q.getItem(i));
        AdapterDetour.a(suggestPlaceInfoActivity.f3694q, 1408460220);
    }

    public static void m3620r(SuggestPlaceInfoActivity suggestPlaceInfoActivity) {
        if (suggestPlaceInfoActivity.f3694q.getCount() >= 3) {
            Toaster.a(suggestPlaceInfoActivity, 2131235198);
        } else {
            suggestPlaceInfoActivity.startActivityForResult(new Intent(suggestPlaceInfoActivity, SelectPageTopicActivity.class), 1);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0) {
            switch (i) {
                case 1:
                    if (i2 == -1 && intent.hasExtra("object")) {
                        m3601a((PageTopic) intent.getParcelableExtra("object"));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final String m3622a() {
        return getString(2131235189);
    }

    private List<PageTopic> m3598a(PlaceDetails placeDetails) {
        ImmutableList d = placeDetails.d();
        List<PageTopic> arrayList = new ArrayList();
        int size = d.size();
        for (int i = 0; i < size; i++) {
            String str = (String) d.get(i);
            for (PageTopic pageTopic : this.f3698u) {
                if (str.equals(pageTopic.displayName)) {
                    arrayList.add(pageTopic);
                }
            }
        }
        return arrayList;
    }

    public void onBackPressed() {
        m3621s();
        SuggestPlaceInfoSurveys suggestPlaceInfoSurveys = this.f3691N;
        if (suggestPlaceInfoSurveys.f3713d != null) {
            suggestPlaceInfoSurveys.f3712c.m10801a(suggestPlaceInfoSurveys.f3713d.longValue(), this);
        }
        super.onBackPressed();
    }

    private void m3621s() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(findViewById(16908290).getWindowToken(), 0);
    }
}

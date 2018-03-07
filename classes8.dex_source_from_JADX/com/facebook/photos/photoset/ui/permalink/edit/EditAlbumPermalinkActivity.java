package com.facebook.photos.photoset.ui.permalink.edit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.auth.annotations.ViewerContextUserId;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.build.IsWorkBuild;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.TriState;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentConnection;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.method.UpdatePhotoAlbumParams.ConversionType;
import com.facebook.photos.futures.PhotosFuturesGenerator;
import com.facebook.photos.photoset.ui.permalink.GraphQLAlbumUtils;
import com.facebook.places.checkin.ipc.CheckinIntentCreator;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration;
import com.facebook.places.checkin.ipc.PlacePickerConfiguration.Builder;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.privacy.edit.EditPrivacyActivity;
import com.facebook.privacy.edit.EditPrivacyIntentBuilder;
import com.facebook.privacy.edit.EditPrivacyParams;
import com.facebook.privacy.edit.EditPrivacyParams.Type;
import com.facebook.privacy.gating.IsATFForEditStoryPrivacyEnabled;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.tagging.conversion.FriendSuggestionsAndSelectorActivity;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.FbScrollView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: close_activity_after_finish */
public class EditAlbumPermalinkActivity extends FbFragmentActivity {
    private static final String f17839x = EditAlbumPermalinkActivity.class.getSimpleName();
    public CheckBox f17840A;
    private TextView f17841B;
    private TextView f17842C;
    private TextView f17843D;
    private View f17844E;
    private View f17845F;
    private View f17846G;
    private View f17847H;
    private View f17848I;
    private View f17849J;
    private View f17850K;
    private View f17851L;
    public FbScrollView f17852M;
    public ArrayList<GraphQLPrivacyOption> f17853N;
    private String f17854O;
    public GraphQLPrivacyOption f17855P;
    private GraphQLPrivacyOption f17856Q;
    private Boolean f17857R;
    public GraphQLAlbum f17858S;
    private Set<String> f17859T;
    private Set<String> f17860U;
    public Set<Long> f17861V;
    public List<FacebookProfile> f17862W;
    public CheckinPlaceModel f17863X;
    public boolean f17864Y;
    private boolean f17865Z;
    @Inject
    Lazy<PhotosFuturesGenerator> f17866p;
    @Inject
    Lazy<TasksManager> f17867q;
    @Inject
    @IsATFForEditStoryPrivacyEnabled
    Provider<TriState> f17868r;
    @Inject
    Lazy<SecureContextHelper> f17869s;
    @Inject
    Lazy<PrivacyMapping> f17870t;
    @Inject
    Lazy<FbErrorReporter> f17871u;
    @Inject
    @ViewerContextUserId
    String f17872v;
    @Inject
    @IsWorkBuild
    Boolean f17873w;
    public EditText f17874y;
    public EditText f17875z;

    /* compiled from: close_activity_after_finish */
    class C19111 extends OnToolbarButtonListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17828a;

        C19111(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17828a = editAlbumPermalinkActivity;
        }

        public final void m21796a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            if (this.f17828a.f17874y) {
                this.f17828a.f17875z;
            } else {
                this.f17828a.finish();
            }
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19122 implements OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17829a;

        C19122(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17829a = editAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 990411720);
            this.f17829a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 707910776, a);
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19133 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17830a;

        C19133(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17830a = editAlbumPermalinkActivity;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            super.onBackPressed();
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19155 implements OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17833a;

        C19155(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17833a = editAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -606136836);
            Builder newBuilder = PlacePickerConfiguration.newBuilder();
            newBuilder.p = SearchType.PHOTO;
            Builder builder = newBuilder;
            if (!this.f17833a.f17864Y) {
                if (this.f17833a.f17863X != null) {
                    builder.a = CheckinPlaceModel.a(this.f17833a.f17863X);
                } else if (this.f17833a.f17858S.s() != null) {
                    GraphQLPlace s = this.f17833a.f17858S.s();
                    if (!(s == null || s.B() == null)) {
                        CheckinPlaceModel.Builder builder2 = new CheckinPlaceModel.Builder();
                        builder2.f = s.x();
                        builder2 = builder2;
                        builder2.h = s.B();
                        builder.a = builder2.a();
                    }
                }
            }
            ((SecureContextHelper) this.f17833a.f17869s.get()).a(CheckinIntentCreator.a(this.f17833a, builder.a()), 3, this.f17833a);
            LogUtils.a(1043669299, a);
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19176 implements OnCheckedChangeListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17835a;

        /* compiled from: close_activity_after_finish */
        class C19161 implements Runnable {
            final /* synthetic */ C19176 f17834a;

            C19161(C19176 c19176) {
                this.f17834a = c19176;
            }

            public void run() {
                this.f17834a.f17835a.f17852M.fullScroll(130);
            }
        }

        C19176(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17835a = editAlbumPermalinkActivity;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            EditAlbumPermalinkActivity.m21841w(this.f17835a);
            EditAlbumPermalinkActivity.m21813c(this.f17835a, z);
            this.f17835a.m21811b(z);
            this.f17835a.f17852M.post(new C19161(this));
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19187 implements OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17836a;

        C19187(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17836a = editAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -479615022);
            this.f17836a.f17840A.toggle();
            Logger.a(2, EntryType.UI_INPUT_END, 1305088141, a);
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19198 implements OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17837a;

        C19198(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17837a = editAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            Set set;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2138516945);
            if (this.f17837a.f17861V == null || this.f17837a.f17861V.isEmpty()) {
                Set a2 = Sets.a();
                ImmutableList q = this.f17837a.f17858S.q();
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    a2.add(Long.valueOf(Long.parseLong(((GraphQLActor) q.get(i)).H())));
                }
                set = a2;
            } else {
                set = this.f17837a.f17861V;
            }
            ((SecureContextHelper) this.f17837a.f17869s.get()).a(FriendSuggestionsAndSelectorActivity.m10812a(this.f17837a, set, 2131234379), 2, this.f17837a);
            LogUtils.a(-1261574573, a);
        }
    }

    /* compiled from: close_activity_after_finish */
    class C19209 implements OnClickListener {
        final /* synthetic */ EditAlbumPermalinkActivity f17838a;

        C19209(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
            this.f17838a = editAlbumPermalinkActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1368539722);
            if (this.f17838a.f17840A.isChecked()) {
                Intent intent = new Intent(this.f17838a, EditSharedAlbumPrivacyActivity.class);
                FlatBufferModelHelper.a(intent, "input_album", this.f17838a.f17853N);
                FlatBufferModelHelper.a(intent, "selected_album_privacy", this.f17838a.f17855P);
                ((SecureContextHelper) this.f17838a.f17869s.get()).a(intent, 1, this.f17838a);
            } else {
                EditPrivacyIntentBuilder editPrivacyIntentBuilder = new EditPrivacyIntentBuilder(this.f17838a, this.f17838a.f17868r);
                GraphQLAlbum graphQLAlbum = this.f17838a.f17858S;
                GraphQLPrivacyOption graphQLPrivacyOption = this.f17838a.f17855P;
                Intent intent2 = new Intent(editPrivacyIntentBuilder.a, EditPrivacyActivity.class);
                EditPrivacyParams.Builder builder = new EditPrivacyParams.Builder(Type.ALBUM);
                builder.e = graphQLAlbum.u();
                builder = builder;
                if (graphQLPrivacyOption != null) {
                    builder.g = graphQLPrivacyOption;
                }
                intent2.putExtra("params", builder.a());
                ((SecureContextHelper) this.f17838a.f17869s.get()).a(intent2, 1, this.f17838a);
            }
            LogUtils.a(-430041431, a);
        }
    }

    private static <T extends Context> void m21803a(Class<T> cls, T t) {
        m21804a((Object) t, (Context) t);
    }

    public static void m21804a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EditAlbumPermalinkActivity) obj).m21801a(IdBasedLazy.a(fbInjector, 9334), IdBasedLazy.a(fbInjector, 3561), IdBasedProvider.a(fbInjector, 740), IdBasedSingletonScopeProvider.b(fbInjector, 968), IdBasedSingletonScopeProvider.b(fbInjector, 9413), IdBasedSingletonScopeProvider.b(fbInjector, 494), String_ViewerContextUserIdMethodAutoProvider.b(fbInjector), Boolean_IsWorkBuildMethodAutoProvider.a(fbInjector));
    }

    public static Intent m21797a(Context context, GraphQLAlbum graphQLAlbum) {
        Intent intent = new Intent(context, EditAlbumPermalinkActivity.class);
        Preconditions.checkNotNull(graphQLAlbum);
        Preconditions.checkState(!Strings.isNullOrEmpty(graphQLAlbum.u()));
        FlatBufferModelHelper.a(intent, "album", graphQLAlbum);
        return intent;
    }

    public final void m21844a(Bundle bundle) {
        super.a(bundle);
        Class cls = EditAlbumPermalinkActivity.class;
        m21804a((Object) this, (Context) this);
    }

    public final void m21845b(Bundle bundle) {
        boolean z;
        super.b(bundle);
        setContentView(2130903933);
        if (FbTitleBarUtil.b(this)) {
            FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
            fbTitleBar.setTitle(getString(2131234365));
            TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
            a.g = getString(2131234366);
            a = a;
            a.h = -2;
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            fbTitleBar.setOnToolbarButtonListener(new C19111(this));
            fbTitleBar.setHasBackButton(false);
            fbTitleBar.a(new C19122(this));
        }
        this.f17874y = (EditText) findViewById(2131559541);
        this.f17875z = (EditText) findViewById(2131559542);
        this.f17842C = (TextView) findViewById(2131560821);
        this.f17840A = (CheckBox) findViewById(2131561092);
        this.f17841B = (TextView) findViewById(2131561087);
        this.f17844E = findViewById(2131561094);
        this.f17845F = findViewById(2131561095);
        this.f17843D = (TextView) findViewById(2131561096);
        this.f17846G = findViewById(2131561084);
        this.f17850K = findViewById(2131561085);
        this.f17847H = findViewById(2131561086);
        this.f17851L = findViewById(2131561088);
        this.f17848I = findViewById(2131561093);
        this.f17849J = findViewById(2131561090);
        this.f17852M = (FbScrollView) findViewById(2131561083);
        this.f17858S = (GraphQLAlbum) FlatBufferModelHelper.a(getIntent(), "album");
        Preconditions.checkNotNull(this.f17858S);
        Preconditions.checkNotNull(this.f17858S.u());
        Preconditions.checkNotNull(this.f17858S.D());
        Preconditions.checkNotNull(this.f17858S.E());
        Preconditions.checkNotNull(this.f17858S.B());
        Preconditions.checkNotNull(this.f17858S.B().H());
        Preconditions.checkNotNull(this.f17858S.B().b());
        if (this.f17858S.B().b().g() == 2479791) {
            z = true;
        } else {
            z = false;
        }
        this.f17865Z = z;
        m21820i();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) FlatBufferModelHelper.a(intent, "privacy_option");
            if (graphQLPrivacyOption != null) {
                this.f17855P = graphQLPrivacyOption;
                if (this.f17840A.isChecked()) {
                    this.f17841B.setText(((PrivacyMapping) this.f17870t.get()).m21853b(this.f17855P));
                } else {
                    this.f17841B.setText(this.f17855P.d());
                }
            } else {
                return;
            }
        }
        if (i == 2 && i2 == -1) {
            int i3;
            if (this.f17859T == null) {
                this.f17859T = new HashSet();
            } else {
                this.f17859T.clear();
            }
            if (this.f17860U == null) {
                this.f17860U = new HashSet();
            } else {
                this.f17860U.clear();
            }
            List parcelableArrayListExtra = intent.getParcelableArrayListExtra("full_profiles");
            this.f17862W = parcelableArrayListExtra;
            if (this.f17861V == null) {
                this.f17861V = Sets.a();
            } else {
                this.f17861V.clear();
            }
            int size = parcelableArrayListExtra.size();
            for (i3 = 0; i3 < size; i3++) {
                this.f17861V.add(Long.valueOf(((FacebookProfile) parcelableArrayListExtra.get(i3)).mId));
            }
            Set<String> hashSet = new HashSet();
            Set<String> hashSet2 = new HashSet();
            ImmutableList q = this.f17858S.q();
            int size2 = q.size();
            for (i3 = 0; i3 < size2; i3++) {
                hashSet.add(((GraphQLActor) q.get(i3)).H());
            }
            int size3 = parcelableArrayListExtra.size();
            for (i3 = 0; i3 < size3; i3++) {
                hashSet2.add(m21799a((FacebookProfile) parcelableArrayListExtra.get(i3)));
            }
            for (String str : hashSet2) {
                if (!hashSet.contains(str)) {
                    this.f17859T.add(str);
                }
            }
            for (String str2 : hashSet) {
                if (!(hashSet2.contains(str2) || str2.equals(this.f17858S.B().H()))) {
                    this.f17860U.add(str2);
                }
            }
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                m21843y();
                this.f17840A.setChecked(false);
            } else {
                m21810b(m21800a(parcelableArrayListExtra));
            }
        }
        if (i == 3 && i2 == -1) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(intent, "extra_place");
            this.f17863X = checkinPlaceModel;
            if (checkinPlaceModel != null) {
                this.f17854O = checkinPlaceModel.cf_();
                this.f17842C.setText(checkinPlaceModel.j());
                this.f17864Y = false;
                return;
            }
            this.f17854O = null;
            this.f17863X = null;
            this.f17864Y = true;
            this.f17842C.setText("");
        }
    }

    private void m21801a(Lazy<PhotosFuturesGenerator> lazy, Lazy<TasksManager> lazy2, Provider<TriState> provider, Lazy<SecureContextHelper> lazy3, Lazy<PrivacyMapping> lazy4, Lazy<FbErrorReporter> lazy5, String str, Boolean bool) {
        this.f17866p = lazy;
        this.f17867q = lazy2;
        this.f17868r = provider;
        this.f17869s = lazy3;
        this.f17870t = lazy4;
        this.f17871u = lazy5;
        this.f17872v = str;
        this.f17873w = bool;
    }

    public void onBackPressed() {
        if (this.f17874y) {
            final AlertDialog a = new AlertDialog.Builder(this).a();
            a.setTitle(getResources().getString(2131234361));
            a.a(getResources().getString(2131234381));
            DialogInterface.OnClickListener c19133 = new C19133(this);
            DialogInterface.OnClickListener c19144 = new DialogInterface.OnClickListener(this) {
                final /* synthetic */ EditAlbumPermalinkActivity f17832b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    a.dismiss();
                }
            };
            a.a(-1, getResources().getString(2131234382), c19133);
            a.a(-2, getResources().getString(2131234361), c19144);
            a.show();
            return;
        }
        super.onBackPressed();
    }

    private void m21820i() {
        m21822j();
        m21826l();
        m21824k();
    }

    private void m21822j() {
        boolean z = false;
        if (!GraphQLAlbumUtils.m21793b(this.f17858S, this.f17872v)) {
            this.f17874y.setEnabled(false);
            this.f17875z.setEnabled(false);
            this.f17846G.setEnabled(false);
        }
        this.f17874y.setText(this.f17858S.E().a());
        if (this.f17858S.y() != null) {
            this.f17875z.setText(this.f17858S.y().a());
        }
        if (this.f17858S.s() != null) {
            this.f17842C.setText(this.f17858S.s().B());
        }
        if (this.f17858S.k() != null) {
            if (this.f17858S.k() == GraphQLPhotosAlbumAPIType.SHARED) {
                z = true;
            }
            this.f17857R = Boolean.valueOf(z);
        }
        this.f17846G.setOnClickListener(new C19155(this));
    }

    private void m21824k() {
        GraphQLAlbum graphQLAlbum = this.f17858S;
        Object obj = null;
        Preconditions.checkNotNull(graphQLAlbum);
        if (graphQLAlbum.w() != null) {
            int a = graphQLAlbum.w().a();
            int i;
            if (graphQLAlbum.C() == null) {
                if (a > 0) {
                    i = 1;
                }
            } else if (a != graphQLAlbum.C().a()) {
                i = 1;
            }
        }
        if (obj != null) {
            this.f17851L.setVisibility(8);
            this.f17849J.setVisibility(8);
        } else if (this.f17873w.booleanValue() || this.f17855P == null) {
            this.f17851L.setVisibility(8);
        } else if (!GraphQLAlbumUtils.m21793b(this.f17858S, this.f17872v)) {
            this.f17849J.setVisibility(8);
            m21810b(m21798a(this.f17858S));
        } else if (this.f17865Z) {
            this.f17851L.setVisibility(8);
            this.f17849J.setVisibility(8);
        } else {
            m21811b(this.f17858S.l());
            this.f17840A.setChecked(this.f17858S.l());
            this.f17840A.setOnCheckedChangeListener(new C19176(this));
            this.f17840A.setClickable(false);
            this.f17849J.setOnClickListener(new C19187(this));
            OnClickListener c19198 = new C19198(this);
            this.f17844E.setOnClickListener(c19198);
            this.f17845F.setOnClickListener(c19198);
        }
    }

    private void m21826l() {
        if (this.f17865Z || this.f17858S.D() == null || this.f17858S.D().p() == null || this.f17858S.D().p().a() == null || this.f17858S.D().p().a().isEmpty()) {
            this.f17850K.setVisibility(8);
            return;
        }
        this.f17853N = Lists.a();
        ImmutableList a = this.f17858S.D().p().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge = (GraphQLPrivacyOptionsContentEdge) a.get(i);
            if (((PrivacyMapping) this.f17870t.get()).m21852a(graphQLPrivacyOptionsContentEdge.j())) {
                this.f17853N.add(graphQLPrivacyOptionsContentEdge.j());
            }
            if (graphQLPrivacyOptionsContentEdge.a()) {
                this.f17856Q = graphQLPrivacyOptionsContentEdge.j();
                this.f17855P = this.f17856Q;
            }
        }
        if (this.f17858S.D().q() != null) {
            this.f17856Q = ((GraphQLPrivacyOptionsContentEdge) this.f17858S.D().q().a().get(0)).j();
            this.f17855P = this.f17856Q;
        }
        m21813c(this, this.f17858S.l());
        this.f17847H.setOnClickListener(new C19209(this));
    }

    private void m21811b(boolean z) {
        Object obj = null;
        Preconditions.checkNotNull(this.f17858S.k());
        if (z) {
            Object obj2;
            if (this.f17862W == null || this.f17862W.isEmpty()) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (z && obj2 != null) {
                m21810b(m21800a(this.f17862W));
                return;
            } else if (this.f17858S.q().size() < 2) {
                m21842x();
                return;
            } else {
                if ((this.f17857R.booleanValue() && this.f17858S.q().size() > 1) || obj2 != null) {
                    obj = 1;
                }
                String a = obj2 != null ? m21800a(this.f17862W) : m21798a(this.f17858S);
                if (obj != null) {
                    m21810b(a);
                    return;
                } else {
                    m21842x();
                    return;
                }
            }
        }
        m21843y();
    }

    public static GraphQLActor m21828m(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
        ImmutableList q = editAlbumPermalinkActivity.f17858S.q();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            GraphQLActor graphQLActor = (GraphQLActor) q.get(i);
            if (graphQLActor.H().equals(editAlbumPermalinkActivity.f17858S.B().H())) {
                return graphQLActor;
            }
        }
        return editAlbumPermalinkActivity.f17858S.B();
    }

    public static void m21830n(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
        GraphQLPhotosAlbumAPIType graphQLPhotosAlbumAPIType;
        String str;
        String obj;
        String c;
        Set set;
        Set set2 = null;
        final ProgressDialog progressDialog = new ProgressDialog(editAlbumPermalinkActivity);
        progressDialog.a(editAlbumPermalinkActivity.getResources().getString(2131234380));
        progressDialog.setCancelable(false);
        progressDialog.show();
        ConversionType conversionType = (!editAlbumPermalinkActivity.f17840A.isChecked() || editAlbumPermalinkActivity.f17857R.booleanValue()) ? ConversionType.NO_CONVERSION : ConversionType.NORMAL_TO_SHARED;
        if (conversionType == ConversionType.NORMAL_TO_SHARED) {
            graphQLPhotosAlbumAPIType = GraphQLPhotosAlbumAPIType.SHARED;
        } else {
            graphQLPhotosAlbumAPIType = editAlbumPermalinkActivity.f17858S.k();
        }
        AnonymousClass10 anonymousClass10 = new AbstractDisposableFutureCallback<OperationResult>(editAlbumPermalinkActivity) {
            final /* synthetic */ EditAlbumPermalinkActivity f17827c;

            protected final void m21794a(Object obj) {
                GraphQLPrivacyScope a;
                OperationResult operationResult = (OperationResult) obj;
                GraphQLPlace graphQLPlace = null;
                progressDialog.dismiss();
                String str = operationResult.c;
                GraphQLTextWithEntities.Builder a2 = GraphQLTextWithEntities.Builder.a(this.f17827c.f17858S.E());
                a2.i = this.f17827c.f17874y.getText().toString();
                GraphQLTextWithEntities a3 = a2.a();
                a2 = GraphQLTextWithEntities.Builder.a(new GraphQLTextWithEntities());
                a2.i = this.f17827c.f17875z.getText().toString();
                GraphQLTextWithEntities a4 = a2.a();
                if (this.f17827c.f17855P != null) {
                    GraphQLPrivacyOptionsContentEdge.Builder a5 = GraphQLPrivacyOptionsContentEdge.Builder.a((GraphQLPrivacyOptionsContentEdge) this.f17827c.f17858S.D().p().a().get(0));
                    a5.e = this.f17827c.f17855P;
                    a5 = a5;
                    a5.d = true;
                    GraphQLPrivacyOptionsContentEdge a6 = a5.a();
                    GraphQLPrivacyOptionsContentConnection.Builder a7 = GraphQLPrivacyOptionsContentConnection.Builder.a(this.f17827c.f17858S.D().p());
                    a7.d = ImmutableList.of(a6);
                    GraphQLPrivacyOptionsContentConnection a8 = a7.a();
                    GraphQLPrivacyScope.Builder a9 = GraphQLPrivacyScope.Builder.a(this.f17827c.f17858S.D());
                    a9.e = this.f17827c.f17855P.j();
                    a9 = a9;
                    a9.i = this.f17827c.f17855P.d();
                    a9 = a9;
                    a9.h = this.f17827c.f17855P.l();
                    a9 = a9;
                    a9.l = a8;
                    a = a9.a();
                } else {
                    a = null;
                }
                Collection a10 = Lists.a();
                a10.add(this.f17827c.f17874y);
                if (this.f17827c.f17862W != null) {
                    for (FacebookProfile facebookProfile : this.f17827c.f17862W) {
                        GraphQLActor.Builder a11 = GraphQLActor.Builder.a(this.f17827c.f17858S.B());
                        a11.B = String.valueOf(facebookProfile.mId);
                        a11 = a11;
                        a11.V = facebookProfile.mDisplayName;
                        a11 = a11;
                        GraphQLImage.Builder a12 = GraphQLImage.Builder.a(new GraphQLImage());
                        a12.g = facebookProfile.mImageUrl;
                        a11.ad = a12.a();
                        a10.add(a11.a());
                    }
                }
                if (this.f17827c.f17863X != null) {
                    graphQLPlace = GraphQLPlace.Builder.a(new GraphQLPlace()).c(this.f17827c.f17863X.j()).a();
                } else if (!this.f17827c.f17864Y) {
                    graphQLPlace = this.f17827c.f17858S.s();
                }
                ImmutableList immutableList = RegularImmutableList.a;
                if (this.f17827c.f17840A.isChecked()) {
                    if (this.f17827c.f17862W == null) {
                        immutableList = this.f17827c.f17858S.q();
                    } else {
                        immutableList = ImmutableList.copyOf(a10);
                    }
                }
                GraphQLAlbum.Builder a13 = GraphQLAlbum.Builder.a(this.f17827c.f17858S);
                a13.o = str;
                GraphQLAlbum.Builder builder = a13;
                builder.z = a3;
                builder = builder;
                builder.t = a4;
                builder = builder;
                builder.f = this.f17827c.f17840A.isChecked();
                builder = builder;
                if (a == null) {
                    a = this.f17827c.f17858S.D();
                }
                builder.y = a;
                GraphQLAlbum.Builder builder2 = builder;
                builder2.e = graphQLPhotosAlbumAPIType;
                builder2 = builder2;
                builder2.k = immutableList;
                GraphQLAlbum.Builder builder3 = builder2;
                builder3.m = graphQLPlace;
                builder3 = builder3;
                builder3.f = this.f17827c.f17840A.isChecked();
                GraphQLAlbum a14 = builder3.a();
                Intent intent = new Intent();
                FlatBufferModelHelper.a(intent, "Updated_ALBUM", a14);
                this.f17827c.setResult(-1, intent);
                this.f17827c.finish();
            }

            protected final void m21795a(Throwable th) {
                progressDialog.dismiss();
                Toast.makeText(this.f17827c, th.getLocalizedMessage(), 0).show();
            }
        };
        if (editAlbumPermalinkActivity.m21837s()) {
            str = editAlbumPermalinkActivity.f17854O == null ? "null" : editAlbumPermalinkActivity.f17854O;
        } else {
            str = null;
        }
        String obj2 = editAlbumPermalinkActivity.f17874y.getText().toString();
        if (Strings.isNullOrEmpty(obj2) || Strings.isNullOrEmpty(obj2.trim())) {
            obj2 = editAlbumPermalinkActivity.getString(2131236720);
        }
        PhotosFuturesGenerator photosFuturesGenerator = (PhotosFuturesGenerator) editAlbumPermalinkActivity.f17866p.get();
        String u = editAlbumPermalinkActivity.f17858S.u();
        if (editAlbumPermalinkActivity.m21836r()) {
            obj = editAlbumPermalinkActivity.f17875z.getText().toString();
        } else {
            obj = null;
        }
        if (editAlbumPermalinkActivity.m21838t()) {
            c = editAlbumPermalinkActivity.f17855P.c();
        } else {
            c = null;
        }
        Boolean valueOf = Boolean.valueOf(editAlbumPermalinkActivity.f17840A.isChecked());
        GraphQLPhotosAlbumAPIType k = editAlbumPermalinkActivity.f17858S.k();
        if (editAlbumPermalinkActivity.f17840A.isChecked()) {
            set = editAlbumPermalinkActivity.f17859T;
        } else {
            set = null;
        }
        if (editAlbumPermalinkActivity.f17840A.isChecked()) {
            set2 = editAlbumPermalinkActivity.f17860U;
        }
        ((TasksManager) editAlbumPermalinkActivity.f17867q.get()).a("tasks-updatePhotoAlbum:" + editAlbumPermalinkActivity.f17858S.u(), photosFuturesGenerator.a(u, obj2, str, obj, c, conversionType, valueOf, k, set, set2), anonymousClass10);
    }

    public static boolean m21832o(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
        return editAlbumPermalinkActivity.m21835q() || editAlbumPermalinkActivity.m21836r() || editAlbumPermalinkActivity.m21837s() || editAlbumPermalinkActivity.m21838t() || editAlbumPermalinkActivity.m21839u() || editAlbumPermalinkActivity.m21840v();
    }

    private boolean m21834p() {
        return this.f17857R.booleanValue() != this.f17840A.isChecked();
    }

    private boolean m21835q() {
        return !m21805a(this.f17874y, this.f17858S.E().a());
    }

    private boolean m21836r() {
        return !m21805a(this.f17875z, this.f17858S.y() == null ? null : this.f17858S.y().a());
    }

    private boolean m21837s() {
        if (this.f17864Y) {
            return true;
        }
        if (this.f17854O == null) {
            return false;
        }
        if (Objects.equal(this.f17854O, this.f17858S.s() == null ? null : this.f17858S.s().x())) {
            return false;
        }
        return true;
    }

    private boolean m21838t() {
        return m21834p() || !Objects.equal(this.f17855P, this.f17856Q);
    }

    private boolean m21839u() {
        return ((this.f17859T == null || this.f17859T.isEmpty()) && (this.f17860U == null || this.f17860U.isEmpty())) ? false : true;
    }

    private boolean m21840v() {
        return this.f17858S.l() != this.f17840A.isChecked();
    }

    private static boolean m21805a(TextView textView, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return Strings.isNullOrEmpty(textView.getText().toString());
        }
        return textView.getText().toString().equals(str);
    }

    private static String m21799a(FacebookProfile facebookProfile) {
        return String.valueOf(facebookProfile.mId);
    }

    private String m21798a(GraphQLAlbum graphQLAlbum) {
        List arrayList = new ArrayList();
        ImmutableList q = graphQLAlbum.q();
        int size = q.size();
        for (int i = 0; i < size; i++) {
            GraphQLActor graphQLActor = (GraphQLActor) q.get(i);
            if (!graphQLActor.H().equals(graphQLAlbum.B().H())) {
                arrayList.add(GraphQLActorUtil.a(graphQLActor));
            }
        }
        return m21807b(arrayList);
    }

    private String m21800a(List<FacebookProfile> list) {
        List arrayList = new ArrayList();
        for (FacebookProfile facebookProfile : list) {
            arrayList.add(facebookProfile.mDisplayName);
        }
        return m21807b(arrayList);
    }

    private String m21807b(List<String> list) {
        boolean z = list != null && list.size() > 0;
        Preconditions.checkState(z);
        String str = (String) list.get(0);
        StringBuffer stringBuffer = new StringBuffer();
        if (list.size() > 1) {
            stringBuffer.append(getResources().getQuantityString(2131689587, r4, new Object[]{str, Integer.valueOf(list.size() - 1)}));
        } else {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static void m21841w(EditAlbumPermalinkActivity editAlbumPermalinkActivity) {
        GraphQLPrivacyOptionType a = PrivacyOptionHelper.a(editAlbumPermalinkActivity.f17855P);
        if (editAlbumPermalinkActivity.f17855P == null || !(a == GraphQLPrivacyOptionType.EVERYONE || a == GraphQLPrivacyOptionType.FACEBOOK || a == GraphQLPrivacyOptionType.ONLY_ME || a == GraphQLPrivacyOptionType.FRIENDS)) {
            boolean z;
            if (editAlbumPermalinkActivity.f17853N.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkState(z);
            int size = editAlbumPermalinkActivity.f17853N.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                int i3;
                GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) editAlbumPermalinkActivity.f17853N.get(i);
                if (PrivacyOptionHelper.a(graphQLPrivacyOption) == GraphQLPrivacyOptionType.ONLY_ME) {
                    editAlbumPermalinkActivity.f17855P = graphQLPrivacyOption;
                    i3 = 1;
                } else {
                    i3 = i2;
                }
                i++;
                i2 = i3;
            }
            if (i2 == 0) {
                ((AbstractFbErrorReporter) editAlbumPermalinkActivity.f17871u.get()).b(f17839x, "The 'Only Me' option is missing in the privacy option list!");
                editAlbumPermalinkActivity.f17855P = (GraphQLPrivacyOption) editAlbumPermalinkActivity.f17853N.get(0);
            }
            Preconditions.checkNotNull(editAlbumPermalinkActivity.f17855P);
        }
    }

    public static void m21813c(EditAlbumPermalinkActivity editAlbumPermalinkActivity, boolean z) {
        String str;
        TextView textView = editAlbumPermalinkActivity.f17841B;
        PrivacyMapping privacyMapping = (PrivacyMapping) editAlbumPermalinkActivity.f17870t.get();
        GraphQLPrivacyOption graphQLPrivacyOption = editAlbumPermalinkActivity.f17855P;
        if (z) {
            if (privacyMapping.f17885b.containsKey(graphQLPrivacyOption.b().d())) {
                str = (String) privacyMapping.f17885b.get(graphQLPrivacyOption.b().d());
            } else {
                str = privacyMapping.f17884a.getString(2131236729);
            }
        } else if (privacyMapping.f17886c.containsKey(graphQLPrivacyOption.b().d())) {
            str = (String) privacyMapping.f17886c.get(graphQLPrivacyOption.b().d());
        } else {
            str = graphQLPrivacyOption.d();
        }
        textView.setText(str);
    }

    private void m21842x() {
        this.f17848I.setVisibility(0);
        this.f17844E.setVisibility(0);
        this.f17845F.setVisibility(8);
    }

    private void m21810b(String str) {
        this.f17848I.setVisibility(0);
        this.f17844E.setVisibility(8);
        this.f17845F.setVisibility(0);
        this.f17843D.setText(str);
    }

    private void m21843y() {
        this.f17848I.setVisibility(8);
    }
}

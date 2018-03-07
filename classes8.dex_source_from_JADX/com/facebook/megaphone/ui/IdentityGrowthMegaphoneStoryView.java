package com.facebook.megaphone.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.identitygrowth.profilequestion.data.ProfileQuestionFetcher;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionOptionListView;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionOptionListView.OnSelectionChangedListener;
import com.facebook.identitygrowth.profilequestion.ui.ProfileQuestionPrivacySelectorView;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionHelper;
import com.facebook.identitygrowth.profilequestion.utils.ProfileQuestionSaveController;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel.ProfileQuestionsModel.EdgesModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.megaphone.data.IdentityGrowthMegaphoneStoryData;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.handler.IdentityGrowthMegaphoneHandler;
import com.facebook.megaphone.handler.IdentityGrowthMegaphoneHandlerProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.FacebookProgressCircleView;
import com.facebook.widget.OverlayableRelativeLayout;
import com.google.common.annotations.VisibleForTesting;
import java.text.NumberFormat;
import javax.annotation.Nonnull;

/* compiled from: triggered_by_nux */
public class IdentityGrowthMegaphoneStoryView extends OverlayableRelativeLayout {
    public IdentityGrowthMegaphoneStoryData f1336a;
    public AbstractFbErrorReporter f1337b;
    public ProfileQuestionHelper f1338c;
    public IdentityGrowthMegaphoneHandlerProvider f1339d;
    private GraphQLMegaphone f1340e;
    private ProfileQuestionFragmentModel f1341f;
    private String f1342g;
    private int f1343h = 100;
    public IdentityGrowthMegaphoneHandler f1344i;
    private final TextView f1345j = ((TextView) a(2131563037));
    private final TextView f1346k = ((TextView) a(2131563039));
    private final ImageButton f1347l = ((ImageButton) a(2131563038));
    private final FbButton f1348m = ((FbButton) a(2131563044));
    public final FbButton f1349n = ((FbButton) a(2131563045));
    private final ProfileQuestionOptionListView f1350o = ((ProfileQuestionOptionListView) a(2131563040));
    private final FacebookProgressCircleView f1351p = ((FacebookProgressCircleView) a(2131563036));
    private final View f1352q = a(2131563046);
    private final ProfileQuestionPrivacySelectorView f1353r = ((ProfileQuestionPrivacySelectorView) a(2131563043));
    private final OnClickListener f1354s;
    private final OnClickListener f1355t;

    /* compiled from: triggered_by_nux */
    class C01341 implements OnClickListener {
        final /* synthetic */ IdentityGrowthMegaphoneStoryView f1331a;

        C01341(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView) {
            this.f1331a = identityGrowthMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 152287664);
            this.f1331a.f1344i.m1538d();
            IdentityGrowthMegaphoneStoryView.m1550a(this.f1331a, "HIDE");
            Logger.a(2, EntryType.UI_INPUT_END, -661190647, a);
        }
    }

    /* compiled from: triggered_by_nux */
    class C01352 implements OnClickListener {
        final /* synthetic */ IdentityGrowthMegaphoneStoryView f1332a;

        C01352(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView) {
            this.f1332a = identityGrowthMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -278846363);
            IdentityGrowthMegaphoneStoryView.m1550a(this.f1332a, "SAVE");
            Logger.a(2, EntryType.UI_INPUT_END, 105547454, a);
        }
    }

    /* compiled from: triggered_by_nux */
    class C01363 implements OnClickListener {
        final /* synthetic */ IdentityGrowthMegaphoneStoryView f1333a;

        C01363(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView) {
            this.f1333a = identityGrowthMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1122528874);
            IdentityGrowthMegaphoneStoryView.m1550a(this.f1333a, "SKIP");
            Logger.a(2, EntryType.UI_INPUT_END, 1482798955, a);
        }
    }

    /* compiled from: triggered_by_nux */
    class C01374 implements OnClickListener {
        final /* synthetic */ IdentityGrowthMegaphoneStoryView f1334a;

        C01374(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView) {
            this.f1334a = identityGrowthMegaphoneStoryView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1485763588);
            this.f1334a.f1344i.m1537c();
            Logger.a(2, EntryType.UI_INPUT_END, -45806966, a);
        }
    }

    /* compiled from: triggered_by_nux */
    class C01385 implements OnSelectionChangedListener {
        final /* synthetic */ IdentityGrowthMegaphoneStoryView f1335a;

        C01385(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView) {
            this.f1335a = identityGrowthMegaphoneStoryView;
        }

        public final void m1548a(String str) {
            this.f1335a.f1349n.setEnabled(str != null);
        }
    }

    public static void m1551a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView = (IdentityGrowthMegaphoneStoryView) obj;
        IdentityGrowthMegaphoneStoryData a = IdentityGrowthMegaphoneStoryData.m1517a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        ProfileQuestionHelper a2 = ProfileQuestionHelper.a(injectorLike);
        IdentityGrowthMegaphoneHandlerProvider identityGrowthMegaphoneHandlerProvider = (IdentityGrowthMegaphoneHandlerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(IdentityGrowthMegaphoneHandlerProvider.class);
        identityGrowthMegaphoneStoryView.f1336a = a;
        identityGrowthMegaphoneStoryView.f1337b = abstractFbErrorReporter;
        identityGrowthMegaphoneStoryView.f1338c = a2;
        identityGrowthMegaphoneStoryView.f1339d = identityGrowthMegaphoneHandlerProvider;
    }

    public IdentityGrowthMegaphoneStoryView(Context context) {
        super(context);
        Class cls = IdentityGrowthMegaphoneStoryView.class;
        m1551a((Object) this, getContext());
        setContentView(2130904831);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361940)));
        int dimension = (int) getResources().getDimension(2131429818);
        setPadding(dimension, dimension, dimension, dimension);
        this.f1347l.setOnClickListener(new C01341(this));
        this.f1349n.setOnClickListener(new C01352(this));
        this.f1354s = new C01363(this);
        this.f1355t = new C01374(this);
    }

    public final void m1553a(@Nonnull GraphQLMegaphone graphQLMegaphone) {
        this.f1340e = graphQLMegaphone;
        InjectorLike injectorLike = this.f1339d;
        this.f1344i = new IdentityGrowthMegaphoneHandler(this.f1340e, IdentityGrowthMegaphoneStoryData.m1517a(injectorLike), MegaphoneStore.a(injectorLike), new ProfileQuestionSaveController(ProfileQuestionFetcher.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), ProfileQuestionHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)));
        if (this.f1336a.f1294i) {
            this.a = new ColorDrawable(getResources().getColor(2131361971));
            this.f1352q.setVisibility(0);
        } else {
            this.a = null;
            this.f1352q.setVisibility(8);
        }
        setVisibility(0);
        if (this.f1336a.f1295j) {
            m1549a();
        } else {
            m1552b();
        }
    }

    @VisibleForTesting
    private void m1549a() {
        this.f1345j.setText(2131234853);
        this.f1346k.setVisibility(8);
        this.f1351p.setVisibility(8);
        this.f1350o.removeAllViews();
        this.f1353r.setVisibility(8);
        a(2131563042).setVisibility(8);
        a(2131563041).setVisibility(8);
        this.f1347l.setVisibility(8);
    }

    private void m1552b() {
        ProfileQuestionsModel profileQuestionsModel = this.f1336a.f1286a;
        if (this.f1338c.a(profileQuestionsModel)) {
            this.f1337b.a("identitygrowth", "The profileQuestions argument of this function should not be null or empty, please check getShouldDisplayIdentityGrowthMegaphone or manually check itbefore passing in");
            this.f1344i.m1538d();
            return;
        }
        this.f1343h = profileQuestionsModel.a();
        this.f1341f = ((EdgesModel) profileQuestionsModel.b().get(0)).a();
        this.f1342g = ((EdgesModel) profileQuestionsModel.b().get(0)).b();
        this.f1345j.setText(this.f1340e.s());
        this.f1346k.setVisibility(0);
        TextView textView = this.f1346k;
        Context context = getContext();
        Object[] objArr = new Object[1];
        int i = this.f1343h;
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        percentInstance.setMaximumFractionDigits(0);
        objArr[0] = percentInstance.format((double) (((float) i) / 100.0f));
        textView.setText(context.getString(2131234850, objArr));
        this.f1351p.setVisibility(0);
        this.f1351p.setProgress((long) this.f1343h);
        this.f1350o.a(this.f1341f, this.f1336a, true, true);
        this.f1350o.g = new C01385(this);
        this.f1350o.setOnShowMoreClickListener(this.f1355t);
        a(2131563042).setVisibility(0);
        a(2131563041).setVisibility(0);
        this.f1353r.setVisibility(0);
        this.f1353r.a(this.f1336a, this.f1341f.dl_());
        this.f1348m.setEnabled(true);
        if (this.f1336a.m1523a() || ProfileQuestionHelper.b(this.f1341f)) {
            this.f1348m.setText(2131234852);
            this.f1348m.setOnClickListener(this.f1354s);
            this.f1349n.setText(2131230729);
            this.f1349n.setEnabled(this.f1336a.m1524b() != null);
            return;
        }
        this.f1348m.setText(2131230736);
        this.f1348m.setOnClickListener(this.f1355t);
        this.f1349n.setText(2131230735);
        this.f1349n.setEnabled(true);
    }

    public static void m1550a(IdentityGrowthMegaphoneStoryView identityGrowthMegaphoneStoryView, String str) {
        identityGrowthMegaphoneStoryView.f1344i.m1534a(identityGrowthMegaphoneStoryView.f1341f, identityGrowthMegaphoneStoryView.f1342g, identityGrowthMegaphoneStoryView.f1353r.getSelectedPrivacyJson(), str, "android_feed_megaphone", "native_megaphone");
    }
}

package com.facebook.rapidfeedback;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.TriState;
import com.facebook.fbui.draggable.AdvancedDragDetector;
import com.facebook.fbui.draggable.Direction;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.rapidfeedback.RapidFeedbackDialogFragment.DialogState;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionExtra;
import com.facebook.structuredsurvey.StructuredSurveyConstants.ImpressionType;
import com.facebook.structuredsurvey.StructuredSurveyController;
import com.facebook.structuredsurvey.StructuredSurveyFlowController;
import com.facebook.structuredsurvey.StructuredSurveyFlowController.2;
import com.facebook.structuredsurvey.SurveyListAdapter;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyConfiguredQuestionFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: photo_upload */
public class RapidFeedbackController {
    private static final String f9957a = ("NaRF:" + RapidFeedbackController.class.getSimpleName());
    public String f9958b;
    public long f9959c;
    public Lazy<StructuredSurveyController> f9960d;
    public RapidFeedbackDialogFragment f9961e;
    private RapidFeedbackLCAUDialogFragment f9962f;
    private AbstractFbErrorReporter f9963g;
    private final Provider<TriState> f9964h;
    public final ScheduledExecutorService f9965i;
    public final Runnable f9966j = new C04191(this);
    public boolean f9967k;
    private final Runnable f9968l = new C04202(this);
    private final AdvancedDragDetector f9969m;
    private final FbSharedPreferences f9970n;
    public final Clock f9971o;

    /* compiled from: photo_upload */
    class C04191 implements Runnable {
        final /* synthetic */ RapidFeedbackController f9992a;

        C04191(RapidFeedbackController rapidFeedbackController) {
            this.f9992a = rapidFeedbackController;
        }

        public void run() {
            if (this.f9992a.f9961e != null) {
                Object obj;
                if (this.f9992a.f9961e.ar == DialogState.INTRO_COLLAPSED) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f9992a.f9961e.a(Direction.DOWN, false);
                    ((StructuredSurveyController) this.f9992a.f9960d.get()).m22649l();
                }
            }
        }
    }

    /* compiled from: photo_upload */
    class C04202 implements Runnable {
        final /* synthetic */ RapidFeedbackController f9993a;

        C04202(RapidFeedbackController rapidFeedbackController) {
            this.f9993a = rapidFeedbackController;
        }

        public void run() {
            this.f9993a.f9967k = true;
        }
    }

    public static RapidFeedbackController m14989b(InjectorLike injectorLike) {
        return new RapidFeedbackController(FbErrorReporterImpl.m2317a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3480), AdvancedDragDetector.m15012b(injectorLike), IdBasedProvider.m1811a(injectorLike, 755), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.m1951a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    public static RapidFeedbackController m14984a(InjectorLike injectorLike) {
        return m14989b(injectorLike);
    }

    @Inject
    public RapidFeedbackController(FbErrorReporter fbErrorReporter, Lazy<StructuredSurveyController> lazy, AdvancedDragDetector advancedDragDetector, Provider<TriState> provider, ScheduledExecutorService scheduledExecutorService, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f9963g = fbErrorReporter;
        this.f9960d = lazy;
        this.f9969m = advancedDragDetector;
        this.f9964h = provider;
        this.f9965i = scheduledExecutorService;
        this.f9967k = false;
        this.f9970n = fbSharedPreferences;
        this.f9971o = clock;
    }

    public static boolean m14991p(RapidFeedbackController rapidFeedbackController) {
        return ((TriState) rapidFeedbackController.f9964h.get()).asBoolean(false);
    }

    private void m14988a(final String str, Context context, final int i) {
        try {
            if (((StructuredSurveyController) this.f9960d.get()).m22641a()) {
                ((StructuredSurveyController) this.f9960d.get()).m22633a(context);
                final FragmentManagerHost a = m14983a(context);
                this.f9958b = str;
                this.f9967k = false;
                this.f9959c = this.f9971o.mo211a();
                this.f9965i.schedule(this.f9968l, 10, TimeUnit.SECONDS);
                ((StructuredSurveyController) this.f9960d.get()).m22638a(this.f9958b, new Runnable(this) {
                    final /* synthetic */ RapidFeedbackController f16042d;

                    public void run() {
                        RapidFeedbackController rapidFeedbackController = this.f16042d;
                        ((StructuredSurveyController) rapidFeedbackController.f9960d.get()).m22637a("survey_requested", rapidFeedbackController.f9959c);
                        ((StructuredSurveyController) rapidFeedbackController.f9960d.get()).m22637a("survey_ready", rapidFeedbackController.f9971o.mo211a());
                        if (!a.kO_().mo851c()) {
                            throw new IllegalArgumentException("Cannot complete fragment transaction");
                        } else if (this.f16042d.f9967k) {
                            throw new IllegalArgumentException("Fetch timed out");
                        } else {
                            if (this.f16042d.f9958b.equals("1565141090400626") && RapidFeedbackController.m14991p(this.f16042d)) {
                                RapidFeedbackController.m14985a(this.f16042d, a);
                            } else {
                                RapidFeedbackController.m14986a(this.f16042d, a, i);
                            }
                            this.f16042d.f9965i.schedule(this.f16042d.f9966j, 15, TimeUnit.SECONDS);
                            this.f16042d.m14994a(StructuredSurveyController.f15887c, str);
                        }
                    }
                });
            }
        } catch (Throwable e) {
            this.f9963g.m2343a(f9957a, "NaRF:tryShow Failed", e);
            ((StructuredSurveyController) this.f9960d.get()).m22649l();
        }
    }

    public final void m14997a(String str, Context context) {
        m14998a(str, context, RapidFeedbackConstants$RapidFeedbackTheme.TRANSPARENT);
    }

    public final void m14998a(String str, Context context, RapidFeedbackConstants$RapidFeedbackTheme rapidFeedbackConstants$RapidFeedbackTheme) {
        m14988a(str, context, rapidFeedbackConstants$RapidFeedbackTheme.getThemeId());
    }

    public final void m14999a(String str, String str2) {
        ((StructuredSurveyController) this.f9960d.get()).m22640a(str, str2);
    }

    public final void m14993a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            ((StructuredSurveyController) this.f9960d.get()).m22640a(str, bundle.getString(str));
        }
    }

    public final SurveyListAdapter m15002c() {
        return ((StructuredSurveyController) this.f9960d.get()).m22645d();
    }

    public final boolean m15004d() {
        boolean z;
        StructuredSurveyController structuredSurveyController = (StructuredSurveyController) this.f9960d.get();
        if (structuredSurveyController.f15919z) {
            StructuredSurveyFlowController structuredSurveyFlowController = structuredSurveyController.f15910q;
            Iterable arrayList = new ArrayList();
            for (String str : structuredSurveyFlowController.d.keySet()) {
                if (structuredSurveyFlowController.e.contains(str)) {
                    arrayList.add(structuredSurveyFlowController.d.get(str));
                }
            }
            List a = Lists.m1298a(Iterables.m966c(arrayList, new 2(structuredSurveyFlowController)));
            int i = (a.size() == 1 && ((StructuredSurveyConfiguredQuestionFragmentModel) a.get(0)).m() == GraphQLStructuredSurveyQuestionType.RADIO && !((StructuredSurveyConfiguredQuestionFragmentModel) a.get(0)).a()) ? 1 : 0;
            if (i != 0) {
                z = true;
                return z;
            }
        }
        z = false;
        return z;
    }

    public final void m14996a(ImpressionType impressionType) {
        m14987a(impressionType, null);
    }

    public final void m14995a(ImpressionExtra impressionExtra) {
        Map hashMap = new HashMap();
        hashMap.put(ImpressionExtra.ACTION.getImpressionExtra(), impressionExtra.getImpressionExtra());
        m14987a(ImpressionType.SKIP, hashMap);
    }

    private void m14987a(ImpressionType impressionType, @Nullable Map<String, String> map) {
        ((StructuredSurveyController) this.f9960d.get()).m22634a(impressionType, (Map) map);
    }

    public final int m15005e() {
        return ((StructuredSurveyController) this.f9960d.get()).m22647h();
    }

    public final void m15006g() {
        ((StructuredSurveyController) this.f9960d.get()).m22646f();
    }

    public final void m15007h() {
        ((StructuredSurveyController) this.f9960d.get()).m22648k();
    }

    public final void m15008j() {
        ((StructuredSurveyController) this.f9960d.get()).m22649l();
    }

    public final void m15003c(String str, Context context) {
        m14990c(str, context, 2131625665);
    }

    public final void m15001b(String str, Context context, RapidFeedbackConstants$RapidFeedbackTheme rapidFeedbackConstants$RapidFeedbackTheme) {
        m14990c(str, context, rapidFeedbackConstants$RapidFeedbackTheme.getThemeId());
    }

    private void m14990c(String str, Context context, int i) {
        Preconditions.checkArgument(m15000a(str));
        ((StructuredSurveyController) this.f9960d.get()).f15894E = context;
        this.f9958b = str;
        m14986a(this, m14983a(context), i);
        this.f9965i.schedule(this.f9966j, 15, TimeUnit.SECONDS);
    }

    public final boolean m15000a(String str) {
        return ((StructuredSurveyController) this.f9960d.get()).m22643b(str);
    }

    public static void m14986a(RapidFeedbackController rapidFeedbackController, FragmentManagerHost fragmentManagerHost, int i) {
        boolean z = ((StructuredSurveyController) rapidFeedbackController.f9960d.get()).f15918y;
        Bundle bundle = new Bundle();
        bundle.putBoolean("skip_intro_toast_arg", z);
        bundle.putInt("survey_theme_arg", i);
        RapidFeedbackDialogFragment rapidFeedbackDialogFragment = new RapidFeedbackDialogFragment();
        rapidFeedbackDialogFragment.m271g(bundle);
        rapidFeedbackController.f9961e = rapidFeedbackDialogFragment;
        RapidFeedbackDialogFragment rapidFeedbackDialogFragment2 = rapidFeedbackController.f9961e;
        rapidFeedbackDialogFragment2.au = rapidFeedbackController;
        rapidFeedbackDialogFragment2.aL = true;
        rapidFeedbackController.f9961e.aH = rapidFeedbackController.f9969m;
        rapidFeedbackController.f9961e.m213a(fragmentManagerHost.kO_(), RapidFeedbackDialogFragment.am);
    }

    public static void m14985a(RapidFeedbackController rapidFeedbackController, FragmentManagerHost fragmentManagerHost) {
        rapidFeedbackController.f9962f = new RapidFeedbackLCAUDialogFragment();
        rapidFeedbackController.f9962f.av = rapidFeedbackController;
        rapidFeedbackController.f9962f.m213a(fragmentManagerHost.kO_(), RapidFeedbackDialogFragment.am);
    }

    public static FragmentManagerHost m14983a(Context context) {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.m2500a(context, FragmentManagerHost.class);
        Preconditions.checkNotNull(fragmentManagerHost, "RapidFeedback Needs A FragmentManager To Launch");
        return fragmentManagerHost;
    }

    public final List<String> m14992a(PrefKey prefKey) {
        String a = this.f9970n.mo278a(prefKey, null);
        if (a != null) {
            return new ArrayList(Arrays.asList(a.split(",")));
        }
        return null;
    }

    public final void m14994a(PrefKey prefKey, String str) {
        Iterable a = m14992a(prefKey);
        if (a == null) {
            a = new ArrayList();
        }
        a.remove(str);
        a.add(0, str);
        if (a.size() > 3) {
            a.remove(3);
        }
        this.f9970n.edit().mo1276a(prefKey, TextUtils.join(",", a)).commit();
    }
}

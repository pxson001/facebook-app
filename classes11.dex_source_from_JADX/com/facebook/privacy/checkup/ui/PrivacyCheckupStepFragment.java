package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.analytics.PrivacyCheckupPerformanceLogger;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.C12923;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.C12944;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.FetchDataCallback;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.Task;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow.Builder;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepAdapter.PrivacyCheckupActionCallbackInterface;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.spinner.AudienceSpinnerData;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: See More Apps */
public class PrivacyCheckupStepFragment extends FbFragment {
    public GlyphColorizer f11122a;
    protected final OnScrollListener al = new C13412(this);
    public PrivacyCheckupManager f11123b;
    public PrivacyCheckupStepAdapterProvider f11124c;
    public PrivacyCheckupPerformanceLogger f11125d;
    public PrivacyCheckupStepType f11126e;
    public ListView f11127f;
    public StepByStepCircleProgressBar f11128g;
    protected PrivacyCheckupStepAdapter f11129h;
    protected final PrivacyCheckupActionCallbackInterface f11130i = new C13401(this);

    /* compiled from: See More Apps */
    class C13401 implements PrivacyCheckupActionCallbackInterface {
        final /* synthetic */ PrivacyCheckupStepFragment f11198a;

        C13401(PrivacyCheckupStepFragment privacyCheckupStepFragment) {
            this.f11198a = privacyCheckupStepFragment;
        }

        public final void mo297a(String str, PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation) {
            PrivacyCheckupManager privacyCheckupManager = this.f11198a.f11123b;
            PrivacyCheckupStepType privacyCheckupStepType = this.f11198a.f11126e;
            Preconditions.checkArgument(!TextUtils.isEmpty(str));
            Preconditions.checkNotNull(privacyOptionFieldsWithExplanation);
            PrivacyCheckupStepData b = privacyCheckupManager.m11344b(privacyCheckupStepType);
            int i = 0;
            GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType = null;
            while (i < b.f10965a.size()) {
                if (b.f10965a.get(i) instanceof PrivacyCheckupItemRow) {
                    PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) b.f10965a.get(i);
                    if (Objects.equal(str, privacyCheckupItemRow.f10956a)) {
                        graphQLEditablePrivacyScopeType = privacyCheckupItemRow.f10957b;
                        AudienceSpinnerData audienceSpinnerData = new AudienceSpinnerData(privacyCheckupItemRow.f10961f.a, privacyOptionFieldsWithExplanation);
                        ArrayList arrayList = b.f10965a;
                        Builder builder = new Builder(privacyCheckupItemRow);
                        builder.f10952f = audienceSpinnerData;
                        Builder builder2 = builder;
                        builder2.f10953g = audienceSpinnerData.b().d();
                        builder2 = builder2;
                        builder2.f10954h = audienceSpinnerData.b().b();
                        arrayList.set(i, builder2.m11367a());
                    }
                }
                i++;
                graphQLEditablePrivacyScopeType = graphQLEditablePrivacyScopeType;
            }
            if (graphQLEditablePrivacyScopeType == null) {
                BLog.c("Didn't find a privacy type for id %s", str);
            } else {
                privacyCheckupManager.f10898e.m11360a(str, graphQLEditablePrivacyScopeType, privacyOptionFieldsWithExplanation);
            }
            AdapterDetour.a(this.f11198a.f11129h, 61610183);
        }

        public final void mo298a(String str, boolean z) {
            PrivacyCheckupManager privacyCheckupManager = this.f11198a.f11123b;
            PrivacyCheckupStepData b = privacyCheckupManager.m11344b(this.f11198a.f11126e);
            for (int i = 0; i < b.f10965a.size(); i++) {
                if (b.f10965a.get(i) instanceof PrivacyCheckupItemRow) {
                    PrivacyCheckupItemRow privacyCheckupItemRow = (PrivacyCheckupItemRow) b.f10965a.get(i);
                    if (privacyCheckupItemRow.f10956a.equals(str)) {
                        ArrayList arrayList = b.f10965a;
                        Builder builder = new Builder(privacyCheckupItemRow);
                        builder.f10955i = true;
                        arrayList.set(i, builder.m11367a());
                        break;
                    }
                }
            }
            privacyCheckupManager.f10898e.m11361a(str, z);
            AdapterDetour.a(this.f11198a.f11129h, -79624814);
        }

        public final boolean mo299a() {
            return this.f11198a.f11123b.f10903j;
        }

        public final void mo300b() {
            this.f11198a.f11123b.f10903j = true;
        }

        public final SelectablePrivacyData mo301c() {
            return this.f11198a.f11123b.f10904k;
        }
    }

    /* compiled from: See More Apps */
    class C13412 implements OnScrollListener {
        final /* synthetic */ PrivacyCheckupStepFragment f11199a;

        C13412(PrivacyCheckupStepFragment privacyCheckupStepFragment) {
            this.f11199a = privacyCheckupStepFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if ((i + i2) + 8 > i3 && this.f11199a.f11123b.m11344b(this.f11199a.f11126e).f10975k) {
                this.f11199a.mo296e();
            }
        }
    }

    /* compiled from: See More Apps */
    public class StepDataFetchedListener {
        final /* synthetic */ PrivacyCheckupStepFragment f11201a;
        private boolean f11202b;

        public StepDataFetchedListener(PrivacyCheckupStepFragment privacyCheckupStepFragment, boolean z) {
            this.f11201a = privacyCheckupStepFragment;
            this.f11202b = z;
        }

        public final void m11582a() {
            AdapterDetour.a(this.f11201a.f11129h, -1238311892);
            if (this.f11202b) {
                PrivacyCheckupPerformanceLogger privacyCheckupPerformanceLogger;
                Sequence e;
                switch (this.f11201a.f11126e) {
                    case COMPOSER_STEP:
                        privacyCheckupPerformanceLogger = this.f11201a.f11125d;
                        e = privacyCheckupPerformanceLogger.f4418d.e(PrivacyCheckupPerformanceLogger.f4414a);
                        if (e != null) {
                            SequenceLoggerDetour.b(e, "PrivacyCheckupComposerDataFetch", 1056281501);
                        }
                        privacyCheckupPerformanceLogger.f4418d.b(PrivacyCheckupPerformanceLogger.f4414a);
                        return;
                    case PROFILE_STEP:
                        privacyCheckupPerformanceLogger = this.f11201a.f11125d;
                        e = privacyCheckupPerformanceLogger.f4418d.e(PrivacyCheckupPerformanceLogger.f4415b);
                        if (e != null) {
                            SequenceLoggerDetour.b(e, "PrivacyCheckupProfileDataFetch", 17023790);
                        }
                        privacyCheckupPerformanceLogger.f4418d.b(PrivacyCheckupPerformanceLogger.f4415b);
                        return;
                    case APPS_STEP:
                        privacyCheckupPerformanceLogger = this.f11201a.f11125d;
                        e = privacyCheckupPerformanceLogger.f4418d.e(PrivacyCheckupPerformanceLogger.f4416c);
                        if (e != null) {
                            SequenceLoggerDetour.b(e, "PrivacyCheckupAppsDataFetch", -135019981);
                        }
                        privacyCheckupPerformanceLogger.f4418d.b(PrivacyCheckupPerformanceLogger.f4416c);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static void m11510a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        PrivacyCheckupStepFragment privacyCheckupStepFragment = (PrivacyCheckupStepFragment) obj;
        GlyphColorizer a = GlyphColorizer.a(injectorLike);
        PrivacyCheckupManager a2 = PrivacyCheckupManager.m11335a(injectorLike);
        PrivacyCheckupStepAdapterProvider privacyCheckupStepAdapterProvider = (PrivacyCheckupStepAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PrivacyCheckupStepAdapterProvider.class);
        PrivacyCheckupPerformanceLogger a3 = PrivacyCheckupPerformanceLogger.m5405a(injectorLike);
        privacyCheckupStepFragment.f11122a = a;
        privacyCheckupStepFragment.f11123b = a2;
        privacyCheckupStepFragment.f11124c = privacyCheckupStepAdapterProvider;
        privacyCheckupStepFragment.f11125d = a3;
    }

    public void mo295c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PrivacyCheckupStepFragment.class;
        m11510a((Object) this, getContext());
        this.f11126e = (PrivacyCheckupStepType) this.s.getSerializable("extra_privacy_checkup_step");
        if (this.f11126e == null) {
            throw new IllegalArgumentException("No PCU step provided, cannot create fragment");
        }
        switch (this.f11126e) {
            case COMPOSER_STEP:
                SequenceLoggerDetour.a(this.f11125d.f4418d.a(PrivacyCheckupPerformanceLogger.f4414a), "PrivacyCheckupComposerViewCreation", -13076449);
                return;
            case PROFILE_STEP:
                SequenceLoggerDetour.a(this.f11125d.f4418d.a(PrivacyCheckupPerformanceLogger.f4415b), "PrivacyCheckupProfileViewCreation", 1021300294);
                return;
            case APPS_STEP:
                SequenceLoggerDetour.a(this.f11125d.f4418d.a(PrivacyCheckupPerformanceLogger.f4416c), "PrivacyCheckupAppsViewCreation", 983984117);
                return;
            default:
                return;
        }
    }

    public final View m11511a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -539001026);
        View inflate = layoutInflater.inflate(2130906387, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2008747933, a);
        return inflate;
    }

    public final void m11512a(View view, @Nullable Bundle bundle) {
        String b;
        super.a(view, bundle);
        this.f11127f = (ListView) view.findViewById(2131566246);
        View inflate = LayoutInflater.from(getContext()).inflate(2130906388, this.f11127f, false);
        this.f11128g = (StepByStepCircleProgressBar) inflate.findViewById(2131566247);
        StepByStepCircleProgressBar stepByStepCircleProgressBar = this.f11128g;
        int i = 0;
        switch (this.f11126e) {
            case COMPOSER_STEP:
                break;
            case PROFILE_STEP:
                i = 1;
                break;
            case APPS_STEP:
                i = 2;
                break;
            default:
                BLog.c(PrivacyCheckupStepFragment.class, "Unexpected step in PCM!");
                break;
        }
        stepByStepCircleProgressBar.setCurrentStep(i);
        TextView textView = (TextView) inflate.findViewById(2131559441);
        switch (this.f11126e) {
            case COMPOSER_STEP:
                b = b(2131242286);
                break;
            case PROFILE_STEP:
                b = b(2131242289);
                break;
            case APPS_STEP:
                b = b(2131242292);
                break;
            default:
                b = null;
                break;
        }
        textView.setText(b);
        textView = (TextView) inflate.findViewById(2131566248);
        int[] iArr = C13423.f11200a;
        this.f11126e.ordinal();
        CharSequence charSequence = null;
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        this.f11127f.addHeaderView(inflate);
        ar();
        mo294b();
        Sequence e;
        switch (this.f11126e) {
            case COMPOSER_STEP:
                e = this.f11125d.f4418d.e(PrivacyCheckupPerformanceLogger.f4414a);
                if (e != null) {
                    SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "PrivacyCheckupComposerViewCreation", -1013899793), "PrivacyCheckupComposerDataFetch", -552107777);
                }
                break;
            case PROFILE_STEP:
                e = this.f11125d.f4418d.e(PrivacyCheckupPerformanceLogger.f4415b);
                if (e != null) {
                    SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "PrivacyCheckupProfileViewCreation", 286211785), "PrivacyCheckupProfileDataFetch", 444951943);
                }
                break;
            case APPS_STEP:
                e = this.f11125d.f4418d.e(PrivacyCheckupPerformanceLogger.f4416c);
                if (e != null) {
                    SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "PrivacyCheckupAppsViewCreation", 1475591762), "PrivacyCheckupAppsDataFetch", 838469167);
                }
                break;
        }
        mo296e();
    }

    protected void mo294b() {
        this.f11129h = this.f11124c.m11576a(this.f11130i, this.f11123b.m11344b(this.f11126e));
        this.f11127f.setAdapter(this.f11129h);
        this.f11127f.setOnScrollListener(this.al);
    }

    private void ar() {
        String b;
        switch (this.f11126e) {
            case COMPOSER_STEP:
                b = b(2131242288);
                break;
            case PROFILE_STEP:
                b = a(2131242290, new Object[]{b(2131242291)});
                break;
            case APPS_STEP:
                b = a(2131242293, new Object[]{b(2131242294)});
                break;
            default:
                b = null;
                break;
        }
        String str = b;
        if (!TextUtils.isEmpty(str)) {
            View inflate = LayoutInflater.from(getContext()).inflate(2130906386, this.f11127f, false);
            ((TextView) inflate.findViewById(2131566245)).setText(str);
            this.f11127f.addFooterView(inflate);
        }
    }

    protected void mo296e() {
        PrivacyCheckupManager privacyCheckupManager;
        StepDataFetchedListener stepDataFetchedListener;
        PrivacyCheckupStepData b;
        switch (this.f11126e) {
            case PROFILE_STEP:
                privacyCheckupManager = this.f11123b;
                stepDataFetchedListener = new StepDataFetchedListener(this, true);
                b = privacyCheckupManager.m11344b(PrivacyCheckupStepType.PROFILE_STEP);
                if (b.f10975k) {
                    privacyCheckupManager.f10895b.a(Task.FETCH_PROFILE_INFO, new C12944(privacyCheckupManager, b), new FetchDataCallback(privacyCheckupManager, stepDataFetchedListener));
                }
                return;
            case APPS_STEP:
                privacyCheckupManager = this.f11123b;
                stepDataFetchedListener = new StepDataFetchedListener(this, true);
                b = privacyCheckupManager.m11344b(PrivacyCheckupStepType.APPS_STEP);
                if (b.f10975k) {
                    privacyCheckupManager.f10895b.a(Task.FETCH_APP_INFO, new C12923(privacyCheckupManager, b), new FetchDataCallback(privacyCheckupManager, stepDataFetchedListener));
                }
                return;
            default:
                BLog.c(getClass().getSimpleName(), "PrivacyCheckupStepFragment: Unhandled fetch for step: %s", new Object[]{this.f11126e.toString()});
                return;
        }
    }
}

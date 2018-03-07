package com.facebook.privacy.checkup.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.enums.GraphQLEditablePrivacyScopeType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.C12902;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.FetchDataCallback;
import com.facebook.privacy.checkup.manager.PrivacyCheckupManager.Task;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.service.PrivacyCheckupAnalyticsLogger;
import com.facebook.privacy.checkup.ui.PrivacyCheckupStepFragment.StepDataFetchedListener;
import com.facebook.privacy.model.SelectablePrivacyData;
import com.facebook.privacy.model.SelectablePrivacyData.Builder;
import com.facebook.privacy.selector.AudienceFragmentDialog;
import com.facebook.privacy.selector.AudienceFragmentDialog.OnAudienceSelectedListener;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger;
import com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.Caller;
import com.facebook.privacy.selector.AudienceTypeaheadFragment.DataProvider;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import javax.annotation.Nullable;

/* compiled from: See Other */
public class PrivacyCheckupComposerStepFragment extends PrivacyCheckupStepFragment {
    public PrivacyCheckupComposerStepAdapterProvider am;
    public AudienceSelectorPerformanceLogger an;
    private final OnClickListener ao = new C13241(this);
    public AudienceFragmentDialog ap;
    public DataProvider aq;
    public OnAudienceSelectedListener ar;

    /* compiled from: See Other */
    class C13241 implements OnClickListener {
        final /* synthetic */ PrivacyCheckupComposerStepFragment f11119a;

        C13241(PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment) {
            this.f11119a = privacyCheckupComposerStepFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -365418905);
            PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment = this.f11119a;
            privacyCheckupComposerStepFragment.ap = new AudienceFragmentDialog();
            privacyCheckupComposerStepFragment.aq = new AudienceDataProvider(privacyCheckupComposerStepFragment);
            privacyCheckupComposerStepFragment.ar = new AudienceSelectorListener(privacyCheckupComposerStepFragment);
            privacyCheckupComposerStepFragment.ap.ao = privacyCheckupComposerStepFragment.aq;
            privacyCheckupComposerStepFragment.ap.a(privacyCheckupComposerStepFragment.ar);
            privacyCheckupComposerStepFragment.ap.aq = privacyCheckupComposerStepFragment.b(2131242295);
            privacyCheckupComposerStepFragment.an.a(Caller.PRIVACY_CHECKUP_STEP_FRAGMENT);
            privacyCheckupComposerStepFragment.ap.a(privacyCheckupComposerStepFragment.D, "PRIVACY_CHECKUP_AUDIENCE_FRAGMENT_TAG");
            Logger.a(2, EntryType.UI_INPUT_END, 1829726413, a);
        }
    }

    /* compiled from: See Other */
    public class AudienceDataProvider implements DataProvider {
        final /* synthetic */ PrivacyCheckupComposerStepFragment f11120a;

        public AudienceDataProvider(PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment) {
            this.f11120a = privacyCheckupComposerStepFragment;
        }

        public final SelectablePrivacyData m11507a() {
            return this.f11120a.f11123b.f10904k;
        }

        public final boolean m11508b() {
            return false;
        }
    }

    /* compiled from: See Other */
    public class AudienceSelectorListener implements OnAudienceSelectedListener {
        final /* synthetic */ PrivacyCheckupComposerStepFragment f11121a;

        public AudienceSelectorListener(PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment) {
            this.f11121a = privacyCheckupComposerStepFragment;
        }

        public final void m11509a(SelectablePrivacyData selectablePrivacyData) {
            GraphQLPrivacyOption graphQLPrivacyOption = selectablePrivacyData.d;
            String str = ((PrivacyCheckupComposerStepAdapter) this.f11121a.f11129h).f11117d;
            GraphQLEditablePrivacyScopeType graphQLEditablePrivacyScopeType = ((PrivacyCheckupComposerStepAdapter) this.f11121a.f11129h).f11118e;
            if (str == null || graphQLEditablePrivacyScopeType == null) {
                BLog.c(getClass(), "Why would we close a selector when composer info isn't even ready?");
            }
            PrivacyCheckupManager privacyCheckupManager = this.f11121a.f11123b;
            Builder builder = new Builder();
            builder.a = privacyCheckupManager.f10904k.a;
            privacyCheckupManager.f10904k = builder.a(graphQLPrivacyOption).b();
            privacyCheckupManager.f10898e.m11360a(str, graphQLEditablePrivacyScopeType, graphQLPrivacyOption);
            privacyCheckupManager.f10900g.a(graphQLPrivacyOption);
            AdapterDetour.a(this.f11121a.f11129h, 1998847063);
        }
    }

    public static void m11516a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PrivacyCheckupComposerStepFragment privacyCheckupComposerStepFragment = (PrivacyCheckupComposerStepFragment) obj;
        PrivacyCheckupComposerStepAdapterProvider privacyCheckupComposerStepAdapterProvider = (PrivacyCheckupComposerStepAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(PrivacyCheckupComposerStepAdapterProvider.class);
        AudienceSelectorPerformanceLogger a = AudienceSelectorPerformanceLogger.a(fbInjector);
        privacyCheckupComposerStepFragment.am = privacyCheckupComposerStepAdapterProvider;
        privacyCheckupComposerStepFragment.an = a;
    }

    public final void mo295c(@Nullable Bundle bundle) {
        super.mo295c(bundle);
        Class cls = PrivacyCheckupComposerStepFragment.class;
        m11516a(this, getContext());
    }

    public final void m11517I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1750027929);
        super.I();
        this.ap = null;
        this.aq = null;
        this.ar = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1136998215, a);
    }

    protected final void mo294b() {
        PrivacyCheckupComposerStepAdapterProvider privacyCheckupComposerStepAdapterProvider = this.am;
        PrivacyCheckupStepAdapter privacyCheckupComposerStepAdapter = new PrivacyCheckupComposerStepAdapter(LayoutInflaterMethodAutoProvider.b(privacyCheckupComposerStepAdapterProvider), ResourcesMethodAutoProvider.a(privacyCheckupComposerStepAdapterProvider), (Context) privacyCheckupComposerStepAdapterProvider.getInstance(Context.class), PrivacyCheckupAnalyticsLogger.m11461b(privacyCheckupComposerStepAdapterProvider), this.f11130i, this.f11123b.m11344b(this.f11126e));
        this.h = privacyCheckupComposerStepAdapter;
        privacyCheckupComposerStepAdapter.f11116c = this.ao;
        this.f11127f.setAdapter(privacyCheckupComposerStepAdapter);
    }

    protected final void mo296e() {
        PrivacyCheckupManager privacyCheckupManager = this.f11123b;
        StepDataFetchedListener stepDataFetchedListener = new StepDataFetchedListener(this, true);
        if (privacyCheckupManager.m11344b(PrivacyCheckupStepType.COMPOSER_STEP).f10975k) {
            privacyCheckupManager.f10895b.a(Task.FETCH_COMPOSER_INFO, new C12902(privacyCheckupManager), new FetchDataCallback(privacyCheckupManager, stepDataFetchedListener));
        }
        this.f11123b.m11342a(new StepDataFetchedListener(this, false), true);
    }
}

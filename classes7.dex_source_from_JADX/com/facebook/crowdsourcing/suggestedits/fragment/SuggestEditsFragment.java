package com.facebook.crowdsourcing.suggestedits.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FindViewUtil;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.CrowdsourcingContext;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController.C14747;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController.C14758;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/* compiled from: close_friend */
public class SuggestEditsFragment extends FbFragment implements CanHandleBackPressed {
    private static final String f17677d = SuggestEditsFragment.class.getSimpleName();
    @Inject
    public AbstractFbErrorReporter f17678a;
    private CrowdsourcingContext al;
    @Inject
    public SuggestEditsAnalyticsLogger f17679b;
    @Inject
    public SuggestEditsController f17680c;
    private boolean f17681e;
    public String f17682f;
    public String f17683g;
    private LinearLayout f17684h;
    private ProgressBar f17685i;

    /* compiled from: close_friend */
    class C14811 implements OnClickListener {
        final /* synthetic */ SuggestEditsFragment f17676a;

        C14811(SuggestEditsFragment suggestEditsFragment) {
            this.f17676a = suggestEditsFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 809832133);
            SuggestEditsFragment.aq(this.f17676a);
            Logger.a(2, EntryType.UI_INPUT_END, 1065083249, a);
        }
    }

    public static void m21518a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        SuggestEditsFragment suggestEditsFragment = (SuggestEditsFragment) obj;
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        SuggestEditsAnalyticsLogger a = SuggestEditsAnalyticsLogger.a(injectorLike);
        SuggestEditsController b = SuggestEditsController.m21469b(injectorLike);
        suggestEditsFragment.f17678a = abstractFbErrorReporter;
        suggestEditsFragment.f17679b = a;
        suggestEditsFragment.f17680c = b;
    }

    public final void m21525c(Bundle bundle) {
        super.c(bundle);
        Class cls = SuggestEditsFragment.class;
        m21518a((Object) this, getContext());
        this.f17682f = this.s.getString("com.facebook.katana.profile.id");
        this.f17683g = this.s.getString("profile_name");
        this.f17681e = false;
    }

    public final View m21521a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1452690822);
        View inflate = layoutInflater.inflate(2130907296, viewGroup, false);
        this.f17684h = (LinearLayout) FindViewUtil.b(inflate, 2131567741);
        this.f17685i = (ProgressBar) FindViewUtil.b(inflate, 2131567742);
        Serializable serializableExtra = ao().getIntent().getSerializableExtra("entry_point");
        CrowdEntryPoint crowdEntryPoint = null;
        if (serializableExtra instanceof CrowdEntryPoint) {
            crowdEntryPoint = (CrowdEntryPoint) serializableExtra;
        } else if (serializableExtra instanceof String) {
            crowdEntryPoint = CrowdEntryPoint.fromFullName((String) serializableExtra);
        }
        if (crowdEntryPoint == null) {
            this.f17678a.a(f17677d, "Suggest Edits launched with unknown entrypoint: " + serializableExtra);
            crowdEntryPoint = CrowdEntryPoint.UNKNOWN;
        }
        this.al = new CrowdsourcingContext(crowdEntryPoint, CrowdEndpoint.SUGGEST_EDITS_V2);
        this.f17679b.a(this.al, this.f17682f);
        LogUtils.f(293019646, a);
        return inflate;
    }

    public final void m21523a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f17680c.m21475a(bundle, this.al, this.f17682f, this.f17683g, this.f17684h, this.f17685i, this);
        this.f17684h.setOnClickListener(new C14811(this));
    }

    public final void m21527h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 140106042);
        super.h(bundle);
        this.f17680c.m21474a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -172676622, a);
    }

    public final void m21520H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2134824520);
        super.H();
        aq(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 962429464, a);
    }

    public final void m21519G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1509507925);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            this.f17680c.m21476a(hasTitleBar);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1842111280, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -981887436);
        super.mY_();
        this.f17679b.d(this.al, this.f17682f);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1702886720, a);
    }

    public final void m21526e(Bundle bundle) {
        super.e(bundle);
        SuggestEditsController suggestEditsController = this.f17680c;
        bundle.putString("state_caller_field_type", suggestEditsController.f17614b.f17459e);
        bundle.putParcelable("state_header", suggestEditsController.f17635w.f17669e);
        FlatBufferModelHelper.a(bundle, "state_original_sections", suggestEditsController.f17634v);
        if (suggestEditsController.f17636x != null) {
            List a = Lists.a();
            int size = suggestEditsController.f17636x.size();
            for (int i = 0; i < size; i++) {
                a.add(((SuggestEditsFieldHolder) suggestEditsController.f17636x.get(i)).f17664i);
            }
            FlatBufferModelHelper.a(bundle, "state_sections", a);
        }
    }

    public final void m21522a(int i, int i2, Intent intent) {
        SuggestEditsController suggestEditsController = this.f17680c;
        suggestEditsController.f17614b.m21361a(suggestEditsController.f17635w, suggestEditsController.f17636x, i, i2, intent, suggestEditsController.f17631s);
    }

    public static void aq(SuggestEditsFragment suggestEditsFragment) {
        View currentFocus = suggestEditsFragment.o().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
        KeyboardUtils.a(suggestEditsFragment.o());
    }

    public final void m21524b() {
        Activity ao = ao();
        if (ao != null) {
            this.f17681e = true;
            ao.onBackPressed();
        }
    }

    public final boolean O_() {
        if (this.f17681e) {
            return false;
        }
        SuggestEditsController suggestEditsController = this.f17680c;
        boolean z = true;
        if (suggestEditsController.f17613A) {
            new FbAlertDialogBuilder(suggestEditsController.f17616d).a(2131239159).b(2131239160).a(true).a(2131239161, new C14758(suggestEditsController)).b(2131239162, new C14747(suggestEditsController)).a().show();
        } else {
            z = false;
        }
        return z;
    }
}

package com.facebook.iorg.common.zero.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.KeyEvent;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.iorg.common.zero.IorgDialogDisplayContext;
import com.facebook.iorg.common.zero.constants.ZeroDialogState;
import com.facebook.iorg.common.zero.eventbus.ZeroEventBus;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent;
import com.facebook.iorg.common.zero.eventbus.events.ZeroDialogActionEvent.ActionType;
import com.facebook.iorg.common.zero.interfaces.UpsellsAnalyticsEvent;
import com.facebook.iorg.fb4acommon.IorgFb4aAnalyticsLogger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: TOPICAL */
public abstract class ZeroDialogFragment extends IorgDialogFragment implements AnalyticsFragment {
    @Inject
    public IorgFb4aAnalyticsLogger an;
    @Inject
    public ZeroEventBus ao;
    protected String ap;
    protected String aq;
    public ZeroFeatureKey ar;
    public ZeroDialogState as;
    public Object at;
    protected String au;

    /* compiled from: TOPICAL */
    class C13241 implements OnKeyListener {
        final /* synthetic */ ZeroDialogFragment f13911a;

        C13241(ZeroDialogFragment zeroDialogFragment) {
            this.f13911a = zeroDialogFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (keyEvent.isCanceled() || i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            this.f13911a.ar();
            return true;
        }
    }

    public static void m23276a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ZeroDialogFragment zeroDialogFragment = (ZeroDialogFragment) obj;
        IorgFb4aAnalyticsLogger a = IorgFb4aAnalyticsLogger.m23281a(injectorLike);
        ZeroEventBus a2 = ZeroEventBus.a(injectorLike);
        zeroDialogFragment.an = a;
        zeroDialogFragment.ao = a2;
    }

    protected abstract String au();

    protected abstract String av();

    protected abstract String aw();

    public void mo1278a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -166974993);
        super.mo1278a(bundle);
        Class cls = ZeroDialogFragment.class;
        m23276a(this, getContext());
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ar = (ZeroFeatureKey) bundle2.getSerializable("dialogName");
            this.as = (ZeroDialogState) bundle2.getSerializable("dialogState");
            this.ap = bundle2.getString("dialogTitle");
            this.aq = bundle2.getString("dialogContent");
            if (bundle2.getBoolean("dialogExtraDataFlattenable", false)) {
                this.at = FlatBufferModelHelper.m4281a(bundle2, "dialogExtraData");
            } else {
                this.at = bundle2.getParcelable("dialogExtraData");
            }
        }
        if (bundle != null) {
            this.au = bundle.getString("uuid");
        } else {
            this.au = SafeUUIDGenerator.a().toString();
        }
        LogUtils.f(220585886, a);
    }

    public static Bundle m23275a(ZeroFeatureKey zeroFeatureKey, @Nullable String str, @Nullable String str2, @Nullable Object obj, ZeroDialogState zeroDialogState, @Nullable IorgDialogDisplayContext iorgDialogDisplayContext) {
        Bundle bundle = new Bundle();
        if (iorgDialogDisplayContext != null) {
            bundle.putParcelable("dialog_context", iorgDialogDisplayContext);
        }
        Bundle bundle2 = bundle;
        bundle2.putSerializable("dialogName", zeroFeatureKey);
        bundle2.putSerializable("dialogState", zeroDialogState);
        bundle2.putString("dialogTitle", str);
        bundle2.putString("dialogContent", str2);
        if (obj != null) {
            if (obj instanceof Flattenable) {
                bundle2.putBoolean("dialogExtraDataFlattenable", true);
                FlatBufferModelHelper.m4286a(bundle2, "dialogExtraData", obj);
            } else {
                bundle2.putParcelable("dialogExtraData", (Parcelable) obj);
            }
        }
        return bundle2;
    }

    public Dialog mo1280c(Bundle bundle) {
        Dialog c = super.mo1280c(bundle);
        c.setOnKeyListener(new C13241(this));
        m23277a(au());
        return c;
    }

    public void m23280e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("uuid", this.au);
    }

    public void onCancel(DialogInterface dialogInterface) {
        ar();
    }

    public final void aq() {
        m23277a(av());
        this.ao.a(new ZeroDialogActionEvent(this.ar, ActionType.CONFIRM, this.at, this.as));
        ap();
    }

    public final void ar() {
        m23277a(aw());
        this.ao.a(new ZeroDialogActionEvent(this.ar, ActionType.CANCEL, this.at, this.as));
        ap();
        KeyboardUtils.a(ao());
    }

    protected UpsellsAnalyticsEvent at() {
        return UpsellsAnalyticsEvent.f13905k;
    }

    public final String am_() {
        return (String) Preconditions.checkNotNull(at().f13893o);
    }

    private void m23277a(String str) {
        this.an.m23284a(at(), "button", this.au, str, ImmutableMap.of("dialogName", this.ar.toString(), "dialogState", this.as.toString()));
    }
}

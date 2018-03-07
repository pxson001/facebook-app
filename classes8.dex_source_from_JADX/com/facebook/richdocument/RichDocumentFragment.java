package com.facebook.richdocument;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;

/* compiled from: product_document */
public abstract class RichDocumentFragment extends FbDialogFragment {
    public RichDocumentDelegate am;
    private Context an;

    /* compiled from: product_document */
    public class C06811 {
        public final /* synthetic */ RichDocumentFragment f5110a;

        C06811(RichDocumentFragment richDocumentFragment) {
            this.f5110a = richDocumentFragment;
        }
    }

    public abstract RichDocumentDelegate aq();

    public void m5098a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 466569950);
        super.a(bundle);
        this.am.mo249a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1432121268, a);
    }

    public final View m5097a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1359690414);
        View a2 = this.am.mo247a(layoutInflater, viewGroup, bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 673242778, a);
        return a2;
    }

    public final void m5099a(View view, @Nullable Bundle bundle) {
        this.am.mo250a(view, bundle);
        this.am.mo252a(new C06811(this));
    }

    public final Context getContext() {
        if (this.an == null) {
            Context richDocumentContextWrapper = new RichDocumentContextWrapper(super.getContext());
            richDocumentContextWrapper.m5025a((Object) "loggingClass", (Object) getClass());
            this.an = richDocumentContextWrapper;
        }
        return this.an;
    }

    public final Dialog m5100c(Bundle bundle) {
        return this.am.mo262j();
    }

    public final void a_(Context context) {
        super.a_(context);
        this.am = aq();
        this.am.mo248a(getContext());
        this.am.mo259g();
        this.am.mo255c(this.s);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1269037826);
        super.mY_();
        this.am.mo260h();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -276368887, a);
    }

    public final void m5095G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -714844548);
        super.G();
        this.am.mo257e();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2054614226, a);
    }

    public final void m5096H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 838296961);
        super.H();
        this.am.mo258f();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -17655267, a);
    }

    public final void m5101e(Bundle bundle) {
        super.e(bundle);
        this.am.mo254b(bundle);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.am.mo261i();
    }

    public final boolean O_() {
        return this.am.mo253a();
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1640428765);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1491958066, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1508687696);
        super.mi_();
        this.am.mo256d();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 745604542, a);
    }
}

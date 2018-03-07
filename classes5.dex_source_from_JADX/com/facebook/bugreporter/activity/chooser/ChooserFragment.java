package com.facebook.bugreporter.activity.chooser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.bugreporter.analytics.BugReporterAnalyticsLogger;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: android.media.metadata.ALBUM_ART_URI */
public class ChooserFragment extends FbDialogFragment {
    @Inject
    public BugReporter am;
    @Inject
    public SecureContextHelper an;
    @Inject
    public BugReporterAnalyticsLogger ao;
    public ChooserAdapter ap;

    /* compiled from: android.media.metadata.ALBUM_ART_URI */
    class C10331 implements OnClickListener {
        final /* synthetic */ ChooserFragment f10715a;

        C10331(ChooserFragment chooserFragment) {
            this.f10715a = chooserFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f10715a.b();
            Context an = this.f10715a.an();
            if (an != null) {
                ChooserOption a = this.f10715a.ap.m18736a(i);
                this.f10715a.ao.m18746a(a.f10725e);
                String str = a.f10724d;
                if (ChooserOption.f10721a.equals(str)) {
                    this.f10715a.am.m18644a(BugReportFlowStartParams.newBuilder().m18546a(BugReportSource.SETTINGS_REPORT_PROBLEM).m18545a(an).m18549a());
                    return;
                }
                this.f10715a.an.a(new Intent("android.intent.action.VIEW", Uri.parse(str)), an);
            }
        }
    }

    /* compiled from: android.media.metadata.ALBUM_ART_URI */
    class ChooserAdapter extends BaseAdapter {
        private ImmutableList<ChooserOption> f10716a;

        public /* synthetic */ Object getItem(int i) {
            return m18736a(i);
        }

        public ChooserAdapter(ImmutableList<ChooserOption> immutableList) {
            this.f10716a = immutableList;
        }

        public int getCount() {
            return this.f10716a.size();
        }

        public final ChooserOption m18736a(int i) {
            return (ChooserOption) this.f10716a.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (view == null) {
                view = from.inflate(2130903570, viewGroup, false);
            }
            ChooserOption a = m18736a(i);
            view.setTag(a);
            TextView textView = (TextView) view.findViewById(2131560318);
            ((TextView) view.findViewById(2131558927)).setText(a.f10722b);
            int i2 = a.f10723c;
            if (i2 != 0) {
                textView.setVisibility(0);
                textView.setText(i2);
            } else {
                textView.setText("");
                textView.setVisibility(8);
            }
            return view;
        }
    }

    public static void m18737a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ChooserFragment chooserFragment = (ChooserFragment) obj;
        BugReporter a = BugReporter.m18632a(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        BugReporterAnalyticsLogger b = BugReporterAnalyticsLogger.m18744b(injectorLike);
        chooserFragment.am = a;
        chooserFragment.an = secureContextHelper;
        chooserFragment.ao = b;
    }

    public final void m18738a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 784724748);
        super.a(bundle);
        Class cls = ChooserFragment.class;
        m18737a(this, getContext());
        this.ap = new ChooserAdapter(ImmutableList.copyOf(this.s.getParcelableArrayList("CHOOSER_OPTIONS")));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1563680315, a);
    }

    public final Dialog m18739c(Bundle bundle) {
        return new Builder(getContext()).a(2131235816).a(this.ap, new C10331(this)).a();
    }
}

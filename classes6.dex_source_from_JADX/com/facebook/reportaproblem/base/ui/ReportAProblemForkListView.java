package com.facebook.reportaproblem.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.reportaproblem.base.ReportAProblemForkOption;
import java.util.List;

/* compiled from: setPostAsPageViewerContext */
public class ReportAProblemForkListView extends ListView {
    public List<ReportAProblemForkOption> f4602a;

    /* compiled from: setPostAsPageViewerContext */
    class Adapter extends BaseAdapter {
        final /* synthetic */ ReportAProblemForkListView f4601a;

        public Adapter(ReportAProblemForkListView reportAProblemForkListView) {
            this.f4601a = reportAProblemForkListView;
        }

        public /* synthetic */ Object getItem(int i) {
            return m7105a(i);
        }

        public int getCount() {
            return this.f4601a.f4602a.size();
        }

        private ReportAProblemForkOption m7105a(int i) {
            return (ReportAProblemForkOption) this.f4601a.f4602a.get(i);
        }

        public long getItemId(int i) {
            return (long) ((ReportAProblemForkOption) this.f4601a.f4602a.get(i)).f4540d;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = View.inflate(this.f4601a.getContext(), 2130906822, null);
            } else {
                inflate = view;
            }
            m7106a((TextView) inflate, m7105a(i));
            return inflate;
        }

        private static void m7106a(TextView textView, ReportAProblemForkOption reportAProblemForkOption) {
            textView.setText(reportAProblemForkOption.f4537a);
            textView.setCompoundDrawablesWithIntrinsicBounds(reportAProblemForkOption.f4540d, 0, 0, 0);
        }
    }

    public ReportAProblemForkListView(Context context) {
        super(context);
    }

    public ReportAProblemForkListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected ReportAProblemForkListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setForkOptions(List<ReportAProblemForkOption> list) {
        this.f4602a = list;
        setAdapter(new Adapter(this));
    }
}

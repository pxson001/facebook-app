package com.facebook.reportaproblem.base.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import com.facebook.reportaproblem.base.bugreport.BugReportCategoryInfo;
import java.util.List;

/* compiled from: setReactionSurface */
public class BugReportCategoryChooserListView extends ListView {
    public List<BugReportCategoryInfo> f4594a;

    /* compiled from: setReactionSurface */
    class Adapter extends BaseAdapter {
        final /* synthetic */ BugReportCategoryChooserListView f4593a;

        public Adapter(BugReportCategoryChooserListView bugReportCategoryChooserListView) {
            this.f4593a = bugReportCategoryChooserListView;
        }

        public /* synthetic */ Object getItem(int i) {
            return m7094a(i);
        }

        public int getCount() {
            return this.f4593a.f4594a.size();
        }

        private BugReportCategoryInfo m7094a(int i) {
            return (BugReportCategoryInfo) this.f4593a.f4594a.get(i);
        }

        public long getItemId(int i) {
            return ((BugReportCategoryInfo) this.f4593a.f4594a.get(i)).f4542b;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = View.inflate(this.f4593a.getContext(), 2130903451, null);
            } else {
                inflate = view;
            }
            m7095a((RadioButton) inflate, m7094a(i));
            return inflate;
        }

        private static void m7095a(RadioButton radioButton, BugReportCategoryInfo bugReportCategoryInfo) {
            radioButton.setText(bugReportCategoryInfo.f4541a);
            radioButton.setCompoundDrawablesWithIntrinsicBounds(bugReportCategoryInfo.f4543c, 0, 0, 0);
        }
    }

    public BugReportCategoryChooserListView(Context context) {
        super(context);
    }

    public BugReportCategoryChooserListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected BugReportCategoryChooserListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCategoryInfos(List<BugReportCategoryInfo> list) {
        this.f4594a = list;
        setAdapter(new Adapter(this));
    }
}

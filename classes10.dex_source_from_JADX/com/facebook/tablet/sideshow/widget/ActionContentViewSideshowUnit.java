package com.facebook.tablet.sideshow.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.ListExpansionListener;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterTextView;

/* compiled from: gwggzezzovfrexkejapaarigntonhuheuturum */
public abstract class ActionContentViewSideshowUnit implements SideshowUnit {
    protected SideshowUtils f10133a;

    public ActionContentViewSideshowUnit(SideshowUtils sideshowUtils) {
        this.f10133a = sideshowUtils;
    }

    protected static void m10190a(LayoutInflater layoutInflater, SideshowExpandableListView sideshowExpandableListView, ViewGroup viewGroup, int i) {
        View inflate = layoutInflater.inflate(2130903081, viewGroup, false);
        ((BetterTextView) inflate.findViewById(2131559201)).setText(i);
        sideshowExpandableListView.m10206a(inflate);
    }

    protected final void m10191a(final Context context, final SideshowExpandableListView sideshowExpandableListView) {
        View c = sideshowExpandableListView.m10209c(2130907095);
        final TextView textView = (TextView) c.findViewById(2131567444);
        this.f10133a.m10212a(textView.getText(), textView);
        c.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionContentViewSideshowUnit f10129b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 343321315);
                if (sideshowExpandableListView.f10147k) {
                    sideshowExpandableListView.m10207a();
                } else {
                    sideshowExpandableListView.m10208b();
                }
                LogUtils.a(-788689081, a);
            }
        });
        sideshowExpandableListView.f10144h = new ListExpansionListener(this) {
            final /* synthetic */ ActionContentViewSideshowUnit f10132c;

            public final void mo14a() {
                this.f10132c.f10133a.m10212a(context.getString(2131241381), textView);
            }

            public final void mo15b() {
                this.f10132c.f10133a.m10212a(context.getString(2131241382), textView);
            }
        };
    }
}

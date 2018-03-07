package com.facebook.feed.topicfeeds.switcher;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.device.ScreenUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.diode.nux.FeedDiodeSwitcherInterstitialController;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment;
import com.facebook.feed.topicfeeds.NewsFeedSwitcherFragment.C29542;
import com.facebook.feed.topicfeeds.TopicFeedsNavigationLogger.NavigationEventType;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.InterstitialStartHelper;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ultralight.Inject;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TR */
public class FeedSwitcherAdapter extends Adapter<ViewHolder> {
    private final boolean f24626a;
    private final boolean f24627b;
    private final boolean f24628c;
    private final GlyphColorizer f24629d;
    private final ScreenUtil f24630e;
    public final C29542 f24631f;
    private List<FeedSwitcherItem> f24632g = new ArrayList();
    public int f24633h = -1;

    @Inject
    public FeedSwitcherAdapter(@Assisted boolean z, @Assisted boolean z2, @Assisted boolean z3, @Assisted C29542 c29542, GlyphColorizer glyphColorizer, ScreenUtil screenUtil) {
        this.f24626a = z;
        this.f24627b = z2;
        this.f24628c = z3;
        this.f24631f = c29542;
        this.f24629d = glyphColorizer;
        this.f24630e = screenUtil;
    }

    public final ViewHolder m26531a(ViewGroup viewGroup, int i) {
        return new ViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(2130905456, viewGroup, false)) {
            final /* synthetic */ FeedSwitcherAdapter f24621l;
        };
    }

    public final void m26532a(final ViewHolder viewHolder, int i) {
        TextView textView = (TextView) viewHolder.a;
        FeedSwitcherItem feedSwitcherItem = (FeedSwitcherItem) this.f24632g.get(i);
        textView.setText(feedSwitcherItem.f24535c);
        boolean z = i == this.f24633h;
        textView.setSelected(z);
        if (feedSwitcherItem.f24533a > 0) {
            textView.setCompoundDrawablesWithIntrinsicBounds(this.f24629d.a(feedSwitcherItem.f24533a, z ? -1 : 1728053247), null, null, null);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        textView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FeedSwitcherAdapter f24623b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -713951781);
                int e = viewHolder.e();
                if (e == -1) {
                    Logger.a(2, EntryType.UI_INPUT_END, 957910302, a);
                    return;
                }
                C29542 c29542 = this.f24623b.f24631f;
                View view2 = viewHolder.a;
                NewsFeedSwitcherFragment.m26463a(c29542.f24539a, e, NavigationEventType.TOPIC_TAB);
                c29542.f24539a.m26461a(e, view2);
                LogUtils.a(6381603, a);
            }
        });
        textView.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
            final /* synthetic */ FeedSwitcherAdapter f24625b;

            public void onViewAttachedToWindow(View view) {
                view.setSelected(viewHolder.e() == this.f24625b.f24633h);
            }

            public void onViewDetachedFromWindow(View view) {
            }
        });
        C29542 c29542 = this.f24631f;
        NewsFeedSwitcherFragment.m26470c(c29542.f24539a, textView);
        NewsFeedSwitcherFragment newsFeedSwitcherFragment = c29542.f24539a;
        if (textView instanceof TextView) {
            Object obj;
            TextView textView2 = textView;
            if (newsFeedSwitcherFragment.aA && newsFeedSwitcherFragment.aH.f24535c.equals(textView2.getText())) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && newsFeedSwitcherFragment.aJ) {
                ((InterstitialStartHelper) newsFeedSwitcherFragment.f24555e.get()).a(newsFeedSwitcherFragment.getContext(), new InterstitialTrigger(Action.FEED_STORY_LOADED), FeedDiodeSwitcherInterstitialController.class, textView);
            }
        }
    }

    public final int aZ_() {
        return this.f24632g.size();
    }

    public final void m26533a(List<FeedSwitcherItem> list) {
        this.f24632g = list;
        notifyDataSetChanged();
    }
}

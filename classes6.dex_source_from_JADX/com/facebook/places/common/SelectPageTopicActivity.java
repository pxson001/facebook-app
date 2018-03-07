package com.facebook.places.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.ipc.model.PageTopic;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.pagetopics.FetchPageTopicsResult;
import com.facebook.places.pagetopics.FetchPageTopicsRunner;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: frameRate */
public class SelectPageTopicActivity extends FbFragmentActivity implements OnItemClickListener, AnalyticsActivity, UsesSimpleStringTitle {
    @VisibleForTesting
    SelectPageTopicAdapter f14688p;
    @VisibleForTesting
    FetchPageTopicsRunner f14689q;
    @VisibleForTesting
    BetterListView f14690r;
    @VisibleForTesting
    AbstractDisposableFutureCallback<FetchPageTopicsResult> f14691s = new C09391(this);
    private int f14692t;
    private long f14693u;
    private View f14694v;

    /* compiled from: frameRate */
    class C09391 extends AbstractDisposableFutureCallback<FetchPageTopicsResult> {
        final /* synthetic */ SelectPageTopicActivity f14687a;

        C09391(SelectPageTopicActivity selectPageTopicActivity) {
            this.f14687a = selectPageTopicActivity;
        }

        public final void m22242a(Object obj) {
            this.f14687a.f14688p.m22260a(((FetchPageTopicsResult) obj).m22296a());
            AdapterDetour.a(this.f14687a.f14688p, 551967951);
        }

        public final void m22243a(Throwable th) {
            this.f14687a.m22250b(false);
            ((TextView) this.f14687a.a(2131561172)).setText(2131230764);
            final View b = this.f14687a.a(16908292);
            b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ C09391 f14686b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -394407629);
                    b.setOnClickListener(null);
                    this.f14686b.f14687a.m22251i();
                    Logger.a(2, EntryType.UI_INPUT_END, -438349968, a);
                }
            });
        }
    }

    private BetterListView m22246j() {
        return (BetterListView) a(16908298);
    }

    public final void m22248a(Bundle bundle) {
        this.f14689q = (FetchPageTopicsRunner) MockDeps.m22224a(FetchPageTopicsRunner.class, FetchPageTopicsRunner.m22304b(hz_()));
    }

    protected final void m22249b(Bundle bundle) {
        super.b(bundle);
        setContentView(2130906086);
        FbTitleBarUtil.m8799b(this);
        this.f14694v = a(2131561173);
        this.f14693u = getIntent().getLongExtra("extra_topic_id", 0);
        this.f14692t = getIntent().getIntExtra("extra_category_level", 0);
        this.f14688p = new SelectPageTopicAdapter(this, this.f14692t, this.f14693u);
        this.f14690r = m22246j();
        this.f14690r.setAdapter(this.f14688p);
        this.f14690r.setOnItemClickListener(this);
        this.f14690r.setEmptyView(a(16908292));
        m22250b(true);
        this.f14688p.m22260a(Lists.a());
        AdapterDetour.a(this.f14688p, 328262687);
        m22251i();
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 1982504203);
        super.onDestroy();
        this.f14689q.m22305a();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 633895243, a);
    }

    public final void m22250b(boolean z) {
        this.f14694v.setVisibility(z ? 0 : 8);
    }

    @VisibleForTesting
    final void m22251i() {
        this.f14689q.m22306a(this.f14691s);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PageTopic pageTopic = (PageTopic) this.f14688p.getItem(i);
        List a = SelectPageTopicAdapter.m22252a(pageTopic.id);
        if (a == null || a.size() <= 0 || pageTopic.id == this.f14693u) {
            Intent intent = new Intent();
            intent.putExtra("object", pageTopic);
            setResult(-1, intent);
            finish();
            return;
        }
        intent = new Intent(this, SelectPageTopicActivity.class);
        intent.putExtra("extra_topic_id", pageTopic.id);
        intent.putExtra("extra_topic_name", pageTopic.displayName);
        intent.putExtra("extra_category_level", this.f14692t + 1);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != 0) {
            switch (i) {
                case 1:
                    if (i2 == -1 && intent.hasExtra("object")) {
                        setResult(-1, intent);
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final String m22247a() {
        return getString(2131235138);
    }

    public final String am_() {
        return "add_location_category_module";
    }
}

package com.facebook.backstage.consumption.reply;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.data.ReplyThread;
import com.facebook.backstage.data.ReplyThreadSummary;
import com.facebook.backstage.util.LocaleNameUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: ride_invite */
public class BackstageReplyThreadViewController {
    private static final String f4922c = BackstageReplyThreadViewController.class.getSimpleName();
    BackstageReplyThreadRecyclerViewAdapter f4923a;
    ReplyDataProvider f4924b;
    private final BackstageReplyThreadView f4925d;
    public final RecyclerView f4926e = ((RecyclerView) this.f4925d.findViewById(2131559884));
    private final GlyphView f4927f = ((GlyphView) this.f4925d.findViewById(2131559883));
    private final FbTextView f4928g = ((FbTextView) this.f4925d.findViewById(2131559882));
    private final String f4929h;
    private ReplyThreadSummary f4930i;
    private LocalObserver f4931j;

    /* compiled from: ride_invite */
    class C05141 implements OnClickListener {
        final /* synthetic */ BackstageReplyThreadViewController f4919a;

        C05141(BackstageReplyThreadViewController backstageReplyThreadViewController) {
            this.f4919a = backstageReplyThreadViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1735163693);
            this.f4919a.m4776a();
            Logger.a(2, EntryType.UI_INPUT_END, 125562174, a);
        }
    }

    /* compiled from: ride_invite */
    public class LocalObserver {
        final /* synthetic */ BackstageReplyThreadViewController f4920a;
        public final String f4921b;

        public LocalObserver(BackstageReplyThreadViewController backstageReplyThreadViewController, String str) {
            this.f4920a = backstageReplyThreadViewController;
            this.f4921b = str;
        }

        public final void m4774a(ReplyThread replyThread) {
            this.f4920a.f4923a.f4894f = replyThread;
            this.f4920a.f4926e.setAdapter(this.f4920a.f4923a);
        }

        public final String m4773a() {
            return this.f4921b;
        }
    }

    @Inject
    public BackstageReplyThreadViewController(BackstageReplyThreadRecyclerViewAdapter backstageReplyThreadRecyclerViewAdapter, ReplyDataProvider replyDataProvider, @Assisted BackstageReplyThreadView backstageReplyThreadView) {
        this.f4925d = backstageReplyThreadView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f4925d.getContext());
        linearLayoutManager.a(true);
        this.f4926e.setLayoutManager(linearLayoutManager);
        this.f4924b = replyDataProvider;
        this.f4923a = backstageReplyThreadRecyclerViewAdapter;
        this.f4927f.setOnClickListener(new C05141(this));
        this.f4927f.setGlyphColor(this.f4925d.getContext().getResources().getColor(17170443));
        this.f4929h = this.f4925d.getResources().getString(2131239927);
    }

    public final void m4778a(ReplyThreadSummary replyThreadSummary) {
        this.f4930i = replyThreadSummary;
        this.f4925d.setVisibility(0);
        this.f4931j = new LocalObserver(this, replyThreadSummary.f5139a);
        ReplyDataProvider replyDataProvider = this.f4924b;
        replyDataProvider.f4960f.m4902a(this.f4931j);
        this.f4924b.m4806a(false, this.f4931j.f4921b);
        this.f4928g.setText(StringLocaleUtil.a(this.f4929h, new Object[]{LocaleNameUtil.m5776a(this.f4930i.m4918a())}));
    }

    public final void m4777a(CameraHolder cameraHolder, CameraFlowLauncher cameraFlowLauncher) {
        BackstageReplyThreadRecyclerViewAdapter backstageReplyThreadRecyclerViewAdapter = this.f4923a;
        backstageReplyThreadRecyclerViewAdapter.f4892d = cameraHolder;
        backstageReplyThreadRecyclerViewAdapter.f4893e = cameraFlowLauncher;
    }

    public final void m4776a() {
        this.f4930i = null;
        this.f4926e.setAdapter(null);
        BackstageReplyThreadRecyclerViewAdapter backstageReplyThreadRecyclerViewAdapter = this.f4923a;
        backstageReplyThreadRecyclerViewAdapter.f4892d.m4320a();
        backstageReplyThreadRecyclerViewAdapter.f4894f = null;
        ReplyDataProvider replyDataProvider = this.f4924b;
        replyDataProvider.f4960f.m4903b(this.f4931j);
        this.f4931j = null;
        this.f4925d.setVisibility(8);
    }

    public final boolean m4779b() {
        if (this.f4925d.getVisibility() == 8) {
            return false;
        }
        m4776a();
        return true;
    }
}

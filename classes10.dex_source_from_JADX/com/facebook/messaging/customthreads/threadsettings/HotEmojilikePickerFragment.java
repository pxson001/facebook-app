package com.facebook.messaging.customthreads.threadsettings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.LikeIconEmojiOptions;
import com.facebook.messaging.emoji.EmojiOptionsAdapter;
import com.facebook.messaging.emoji.EmojiOptionsAdapter.Config;
import com.facebook.messaging.emoji.EmojiOptionsAdapter.OnEmojiClickListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.widget.dialog.SlidingSheetDialogFragment;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass12;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.model.Emoji;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: start_day_of_month */
public class HotEmojilikePickerFragment extends SlidingSheetDialogFragment {
    @Inject
    public CustomThreadsTextHelper am;
    @Inject
    public EmojiOptionsAdapter an;
    @Inject
    public EmojiUtil ao;
    @Inject
    public LikeIconEmojiOptions ap;
    private ThreadKey aq;
    private Context ar;
    public int as;
    private TextView at;
    @Nullable
    private String au;
    @Nullable
    public Emoji av;
    @Nullable
    private String aw;
    public AnonymousClass12 ax;
    @Nullable
    public String ay;

    /* compiled from: start_day_of_month */
    class C03721 implements OnEmojiClickListener {
        final /* synthetic */ HotEmojilikePickerFragment f2268a;

        C03721(HotEmojilikePickerFragment hotEmojilikePickerFragment) {
            this.f2268a = hotEmojilikePickerFragment;
        }

        public final void m2129a(@Nullable Emoji emoji) {
            this.f2268a.av = emoji;
            this.f2268a.an.a(this.f2268a.av != null ? this.f2268a.av.f() : null);
            if (this.f2268a.ax != null) {
                this.f2268a.ax.m7403a(emoji);
            }
        }
    }

    /* compiled from: start_day_of_month */
    class C03732 extends ItemDecoration {
        final /* synthetic */ HotEmojilikePickerFragment f2269a;

        C03732(HotEmojilikePickerFragment hotEmojilikePickerFragment) {
            this.f2269a = hotEmojilikePickerFragment;
        }

        public final void m2130a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.top = this.f2269a.as;
            rect.left = this.f2269a.as;
        }
    }

    public static void m2132a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        HotEmojilikePickerFragment hotEmojilikePickerFragment = (HotEmojilikePickerFragment) obj;
        CustomThreadsTextHelper a = CustomThreadsTextHelper.m2126a(injectorLike);
        EmojiOptionsAdapter b = EmojiOptionsAdapter.b(injectorLike);
        EmojiUtil a2 = EmojiUtil.a(injectorLike);
        LikeIconEmojiOptions b2 = LikeIconEmojiOptions.b(injectorLike);
        hotEmojilikePickerFragment.am = a;
        hotEmojilikePickerFragment.an = b;
        hotEmojilikePickerFragment.ao = a2;
        hotEmojilikePickerFragment.ap = b2;
    }

    public final void m2135a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -773553508);
        super.a(bundle);
        this.ar = new ContextThemeWrapper(getContext(), 2131625138);
        Class cls = HotEmojilikePickerFragment.class;
        m2132a((Object) this, this.ar);
        Resources jW_ = jW_();
        this.as = jW_.getDimensionPixelOffset(2131428657);
        this.an.a(new Config(true, false));
        this.an.e(jW_.getColor(2131362310), jW_.getColor(2131362241));
        this.an.a(this.ap.D);
        this.an.i = new C03721(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 35792592, a);
    }

    public final void m2137a(ThreadSummary threadSummary) {
        this.aq = threadSummary.a;
        String str = threadSummary.D.f;
        this.au = str;
        m2133b(str);
    }

    public final View m2134a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -492592898);
        View inflate = layoutInflater.cloneInContext(this.ar).inflate(2130905315, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1269584292, a);
        return inflate;
    }

    public final void m2136a(View view, @Nullable Bundle bundle) {
        this.at = (TextView) e(2131560868);
        RecyclerView recyclerView = (RecyclerView) e(2131559427);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 0, false));
        recyclerView.a(new C03732(this));
        recyclerView.setAdapter(this.an);
    }

    public final void m2138d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1230436796);
        super.d(bundle);
        if (bundle != null) {
            this.aq = (ThreadKey) bundle.getParcelable("thread_key");
            this.au = bundle.getString("original_emoji");
            m2131a((Emoji) bundle.getParcelable("selected_emoji"));
        } else if (this.aw != null) {
            m2133b(this.aw);
            this.aw = null;
        }
        this.at.setText(this.am.m2128a(this.aq));
        LogUtils.f(1690486721, a);
    }

    private void m2133b(@Nullable String str) {
        if (this.ao == null || !mx_()) {
            this.aw = str;
        } else {
            m2131a(this.ao.a(str));
        }
    }

    private void m2131a(@Nullable Emoji emoji) {
        this.av = emoji;
        this.an.a(emoji != null ? emoji.f() : null);
    }

    public final void m2139e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("thread_key", this.aq);
        bundle.putString("original_emoji", this.au);
        bundle.putParcelable("selected_emoji", this.av);
    }
}

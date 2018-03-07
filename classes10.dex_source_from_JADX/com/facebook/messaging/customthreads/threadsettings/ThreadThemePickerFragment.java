package com.facebook.messaging.customthreads.threadsettings;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.customthreads.CustomThreadTheme;
import com.facebook.messaging.customthreads.CustomThreadThemeManager;
import com.facebook.messaging.customthreads.ThreadThemeOptionsAdapter;
import com.facebook.messaging.customthreads.ThreadThemeOptionsAdapter.OnThreadThemeClickListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.widget.dialog.SlidingSheetDialogFragment;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.AnonymousClass11;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: startSyncFriends */
public class ThreadThemePickerFragment extends SlidingSheetDialogFragment {
    @Inject
    public CustomThreadsTextHelper am;
    @Inject
    public CustomThreadThemeManager an;
    @Inject
    public DataCache ao;
    @Inject
    public ThreadThemeOptionsAdapter ap;
    public ThreadKey aq;
    public int ar;
    private TextView as;
    public AnonymousClass11 at;
    @Nullable
    public String au;

    /* compiled from: startSyncFriends */
    class C03771 implements OnThreadThemeClickListener {
        final /* synthetic */ ThreadThemePickerFragment f2274a;

        C03771(ThreadThemePickerFragment threadThemePickerFragment) {
            this.f2274a = threadThemePickerFragment;
        }

        public final void m2145a(@Nullable CustomThreadTheme customThreadTheme) {
            if (this.f2274a.at != null) {
                this.f2274a.at.m7402a(customThreadTheme);
            }
        }
    }

    /* compiled from: startSyncFriends */
    class C03782 extends ItemDecoration {
        final /* synthetic */ ThreadThemePickerFragment f2275a;

        C03782(ThreadThemePickerFragment threadThemePickerFragment) {
            this.f2275a = threadThemePickerFragment;
        }

        public final void m2146a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.top = this.f2275a.ar;
            rect.left = this.f2275a.ar;
        }
    }

    public static void m2147a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ThreadThemePickerFragment threadThemePickerFragment = (ThreadThemePickerFragment) obj;
        CustomThreadsTextHelper a = CustomThreadsTextHelper.m2126a(injectorLike);
        CustomThreadThemeManager a2 = CustomThreadThemeManager.a(injectorLike);
        DataCache a3 = DataCache.a(injectorLike);
        ThreadThemeOptionsAdapter b = ThreadThemeOptionsAdapter.b(injectorLike);
        threadThemePickerFragment.am = a;
        threadThemePickerFragment.an = a2;
        threadThemePickerFragment.ao = a3;
        threadThemePickerFragment.ap = b;
    }

    public final void m2149a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1888998287);
        super.a(bundle);
        Class cls = ThreadThemePickerFragment.class;
        m2147a((Object) this, getContext());
        this.ar = jW_().getDimensionPixelOffset(2131428657);
        this.ap.a(ImmutableList.copyOf(this.an.n));
        this.ap.b = new C03771(this);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1510956787, a);
    }

    public final View m2148a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 348241715);
        View inflate = layoutInflater.inflate(2130905349, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2125614437, a);
        return inflate;
    }

    public final void m2150a(View view, @Nullable Bundle bundle) {
        this.as = (TextView) e(2131560868);
        RecyclerView recyclerView = (RecyclerView) e(2131559427);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 0, false));
        recyclerView.a(new C03782(this));
        recyclerView.setAdapter(this.ap);
    }

    public final void m2151d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2016700159);
        super.d(bundle);
        if (bundle != null) {
            this.aq = (ThreadKey) bundle.getParcelable("thread_key");
        }
        ThreadSummary a2 = this.ao.a(this.aq);
        this.ap.a(a2 != null ? a2.D : null);
        this.as.setText(this.am.m2128a(this.aq));
        LogUtils.f(-371055555, a);
    }

    public final void m2152e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("thread_key", this.aq);
    }
}

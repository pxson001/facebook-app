package com.facebook.widget.listview;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.dispose.Disposable;
import com.facebook.feedplugins.placetips.PlaceTipsInjectedFeedAdapter.C05401;
import com.facebook.inject.Assisted;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: method_args */
public class PreconditionedListAdapter extends FbBaseAdapter implements Disposable {
    public final DelegateObserver f13541a = new DelegateObserver(this);
    private final int f13542b = 1;
    public FbListAdapter f13543c = new EmptyListAdapter();
    public boolean f13544d = false;

    /* compiled from: method_args */
    class DelegateObserver extends DataSetObserver {
        final /* synthetic */ PreconditionedListAdapter f13545a;

        public DelegateObserver(PreconditionedListAdapter preconditionedListAdapter) {
            this.f13545a = preconditionedListAdapter;
        }

        public void onChanged() {
            PreconditionedListAdapter.m19918b(this.f13545a);
        }

        public void onInvalidated() {
            PreconditionedListAdapter.m19919d(this.f13545a);
        }
    }

    /* compiled from: method_args */
    class EmptyListAdapter extends FbBaseAdapter {
        public final View mo1985a(int i, ViewGroup viewGroup) {
            return null;
        }

        public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        }

        public int getCount() {
            return 0;
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }
    }

    @Inject
    public PreconditionedListAdapter(Executor executor, @Assisted final C05401 c05401) {
        Futures.m2458a((ListenableFuture) c05401.f13540a.f10375b.get(), new FutureCallback<Boolean>(this) {
            final /* synthetic */ PreconditionedListAdapter f13554b;

            public void onSuccess(Object obj) {
                if (((Boolean) obj).booleanValue() && !this.f13554b.f13544d) {
                    this.f13554b.f13543c = (FbListAdapter) c05401.f13540a.f10374a.get();
                    this.f13554b.f13543c.registerDataSetObserver(this.f13554b.f13541a);
                    PreconditionedListAdapter.m19918b(this.f13554b);
                }
            }

            public void onFailure(Throwable th) {
                throw new Error(th);
            }
        }, executor);
    }

    public final View mo1985a(int i, ViewGroup viewGroup) {
        return this.f13543c.mo1985a(i, viewGroup);
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f13543c.mo1986a(i, obj, view, i2, viewGroup);
    }

    public int getCount() {
        return this.f13543c.getCount();
    }

    public Object getItem(int i) {
        return this.f13543c.getItem(i);
    }

    public long getItemId(int i) {
        return this.f13543c.getItemId(i);
    }

    public void notifyDataSetChanged() {
        this.f13543c.notifyDataSetChanged();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.f13543c.getView(i, view, viewGroup);
    }

    public boolean hasStableIds() {
        return this.f13543c.hasStableIds();
    }

    public boolean areAllItemsEnabled() {
        return this.f13543c.areAllItemsEnabled();
    }

    public boolean isEnabled(int i) {
        return this.f13543c.isEnabled(i);
    }

    public int getItemViewType(int i) {
        return this.f13543c.getItemViewType(i);
    }

    public int getViewTypeCount() {
        return this.f13542b;
    }

    public static void m19918b(PreconditionedListAdapter preconditionedListAdapter) {
        if (preconditionedListAdapter.f13543c.getViewTypeCount() != preconditionedListAdapter.f13542b) {
            throw new InconsistentViewTypeCountError();
        }
        super.notifyDataSetChanged();
    }

    public static void m19919d(PreconditionedListAdapter preconditionedListAdapter) {
        super.notifyDataSetInvalidated();
    }

    public final void jc_() {
        if (!this.f13544d) {
            if (this.f13543c instanceof Disposable) {
                ((Disposable) this.f13543c).jc_();
            }
            this.f13544d = true;
        }
    }

    public final boolean ba_() {
        return this.f13544d;
    }
}

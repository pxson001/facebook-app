package com.facebook.widget.listview;

import android.widget.Adapter;
import com.facebook.common.dispose.Disposable;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: removeFriendListMember */
public class AdapterListCursor implements Disposable {
    public final AdapterCursor f5994a;
    private final ImmutableList<FbListAdapter> f5995b;
    public int f5996c = -1;
    public int f5997d = -1;
    private boolean f5998e = false;

    /* compiled from: removeFriendListMember */
    public class AdapterCursor {
        int f5982a = -1;
        int f5983b = -1;
        int f5984c = -1;
        int f5985d = -1;
        int f5986e = -1;
        int f5987f = -1;
        int f5988g = -1;
        public boolean f5989h = false;
        boolean f5990i = false;
        private final ImmutableList<FbListAdapter> f5991j;
        private final int[] f5992k;
        private final boolean f5993l;

        public String toString() {
            return Objects.toStringHelper(AdapterCursor.class).add("index", this.f5982a).add("localItemCount", this.f5983b).add("localViewTypeCount", this.f5984c).add("positionOffset", this.f5985d).add("viewTypeOffset", this.f5986e).add("totalItemCount", this.f5987f).add("totalViewTypeCount", this.f5988g).add("totalAllItemsEnabled", this.f5989h).add("totalHasStableIds", this.f5990i).toString();
        }

        AdapterCursor(boolean z, ImmutableList<FbListAdapter> immutableList) {
            this.f5991j = immutableList;
            this.f5993l = z;
            this.f5992k = new int[immutableList.size()];
        }

        final FbListAdapter m8564a() {
            return (FbListAdapter) this.f5991j.get(this.f5982a);
        }

        private int m8563h() {
            return this.f5991j.size();
        }

        final void m8566b() {
            this.f5982a = 0;
            this.f5985d = 0;
            this.f5986e = 0;
            FbListAdapter a = m8564a();
            this.f5983b = a.getCount();
            this.f5984c = m8562a(a);
        }

        final void m8565a(@Nullable OnBeforeAdapterUpdateCallback onBeforeAdapterUpdateCallback) {
            this.f5982a = 0;
            this.f5985d = 0;
            this.f5986e = 0;
            this.f5989h = true;
            this.f5990i = true;
            for (int i = 0; i < m8563h(); i++) {
                boolean z;
                this.f5982a = i;
                FbListAdapter a = m8564a();
                if (onBeforeAdapterUpdateCallback != null) {
                    onBeforeAdapterUpdateCallback.mo437a(a, i);
                }
                this.f5983b = a.getCount();
                this.f5992k[i] = a.getCount();
                this.f5984c = m8562a(a);
                if (this.f5989h && a.areAllItemsEnabled()) {
                    z = true;
                } else {
                    z = false;
                }
                this.f5989h = z;
                if (this.f5990i && a.hasStableIds()) {
                    z = true;
                } else {
                    z = false;
                }
                this.f5990i = z;
                this.f5985d += this.f5983b;
                this.f5986e += this.f5984c;
            }
            this.f5987f = this.f5985d;
            this.f5988g = this.f5986e;
        }

        final boolean m8567c() {
            return this.f5982a >= 0 && this.f5982a < m8563h();
        }

        final boolean m8568d() {
            this.f5982a++;
            if (!m8567c()) {
                return false;
            }
            this.f5985d += this.f5983b;
            this.f5986e += this.f5984c;
            FbListAdapter a = m8564a();
            this.f5983b = a.getCount();
            this.f5984c = m8562a(a);
            return true;
        }

        final boolean m8569e() {
            this.f5982a--;
            if (!m8567c()) {
                return false;
            }
            FbListAdapter a = m8564a();
            this.f5983b = a.getCount();
            this.f5984c = m8562a(a);
            this.f5985d -= this.f5983b;
            this.f5986e -= this.f5984c;
            return true;
        }

        final void m8570f() {
            for (int i = 0; i < m8563h(); i++) {
                FbListAdapter fbListAdapter = (FbListAdapter) this.f5991j.get(i);
                if (fbListAdapter instanceof Disposable) {
                    ((Disposable) fbListAdapter).jc_();
                }
            }
        }

        final void m8571g() {
            for (int i = 0; i < this.f5991j.size(); i++) {
                if (((FbListAdapter) this.f5991j.get(i)).getCount() != this.f5992k[i]) {
                    throw new IllegalStateException(((FbListAdapter) this.f5991j.get(i)).getClass().getSimpleName() + " changed its itemCount without calling notifyDataSetChanged");
                }
            }
        }

        private int m8562a(FbListAdapter fbListAdapter) {
            return this.f5993l ? 1000000 : fbListAdapter.getViewTypeCount();
        }
    }

    /* compiled from: removeFriendListMember */
    public interface OnBeforeAdapterUpdateCallback {
        void mo437a(FbListAdapter fbListAdapter, int i);
    }

    public AdapterListCursor(boolean z, ImmutableList<FbListAdapter> immutableList) {
        this.f5995b = immutableList;
        this.f5994a = new AdapterCursor(z, immutableList);
    }

    public final void m8574a(@Nullable OnBeforeAdapterUpdateCallback onBeforeAdapterUpdateCallback) {
        this.f5996c = -1;
        this.f5997d = -1;
        this.f5994a.m8565a(onBeforeAdapterUpdateCallback);
        this.f5996c = -1;
        this.f5997d = -1;
    }

    public final void m8573a(int i) {
        if (i >= this.f5994a.f5987f) {
            m8574a(null);
        }
        if (i < 0 || i >= this.f5994a.f5987f) {
            throw new IndexOutOfBoundsException("Could not find position " + i + " from totalCount " + this.f5994a.f5987f + "\n" + toString());
        }
        if (this.f5996c < 0 || !this.f5994a.m8567c()) {
            this.f5994a.m8566b();
        }
        while (this.f5994a.m8567c()) {
            int i2 = i - this.f5994a.f5985d;
            if (i2 < 0) {
                this.f5994a.m8569e();
            } else if (i2 >= this.f5994a.f5983b) {
                this.f5994a.m8568d();
            } else {
                this.f5996c = i;
                this.f5997d = i2;
                return;
            }
        }
        this.f5994a.m8571g();
        throw new RuntimeException("Could not find valid position in adapters." + " Ensure adapters are only accessed from the UI thread.\nPosition: " + i + toString());
    }

    public final void m8575a(FbListAdapter fbListAdapter) {
        this.f5994a.m8566b();
        this.f5997d = 0;
        this.f5996c = 0;
        while (this.f5994a.m8564a() != fbListAdapter) {
            if (this.f5994a.m8568d()) {
                this.f5996c = this.f5994a.f5985d;
            } else {
                throw new IllegalStateException("Adapter " + fbListAdapter + " was not found");
            }
        }
    }

    public final void m8577b(int i) {
        if (i < 0 || i >= this.f5994a.f5988g) {
            throw new IndexOutOfBoundsException("Could not find viewType " + i + " from totalCount " + this.f5994a.f5988g);
        }
        if (this.f5996c < 0 || !this.f5994a.m8567c()) {
            this.f5994a.m8566b();
        }
        while (this.f5994a.m8567c()) {
            int i2 = i - this.f5994a.f5986e;
            if (i2 < 0) {
                this.f5994a.m8569e();
            } else if (i2 >= this.f5994a.f5984c) {
                this.f5994a.m8568d();
            } else if (this.f5994a.f5983b > 0) {
                this.f5996c = this.f5994a.f5985d;
                this.f5997d = 0;
                return;
            } else {
                this.f5996c = -1;
                this.f5997d = -1;
                return;
            }
        }
    }

    public final int m8578c(int i) {
        return i - this.f5994a.f5986e;
    }

    public final int m8576b() {
        return this.f5994a.f5986e;
    }

    public final FbListAdapter m8579f() {
        return this.f5994a.m8564a();
    }

    public final int m8580g() {
        return this.f5994a.f5987f;
    }

    public final int m8581h() {
        return this.f5994a.f5988g;
    }

    public final boolean m8582i() {
        return this.f5994a.f5990i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" CurrentViewTypeOffset: ").append(m8576b()).append(" CurrentPosition: ").append(this.f5996c).append(" LocalPosition: ").append(this.f5997d).append(" Count: ").append(m8580g()).append(" ViewTypeCount: ").append(m8581h()).append(" AreAllItemsEnabled: ").append(this.f5994a.f5989h).append(" HasStableIds: ").append(m8582i()).append("\n Cursor: ").append(this.f5994a.toString()).append("\nAdapters: ");
        int size = this.f5995b.size();
        for (int i = 0; i < size; i++) {
            Adapter adapter = (Adapter) this.f5995b.get(i);
            stringBuilder.append("\n    Class: ").append(adapter.getClass().getSimpleName()).append(" Count: ").append(adapter.getCount()).append(" HasStableIds: ").append(adapter.hasStableIds()).append(" ViewTypeCount: ").append(adapter.getViewTypeCount());
        }
        return stringBuilder.toString();
    }

    public final void jc_() {
        this.f5994a.m8570f();
        this.f5998e = true;
    }

    public final boolean ba_() {
        return this.f5998e;
    }
}

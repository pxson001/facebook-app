package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;

/* compiled from: ttl_after_first_use */
public class DefaultItemAnimator$ChangeInfo {
    public ViewHolder f1357a;
    public ViewHolder f1358b;
    public int f1359c;
    public int f1360d;
    public int f1361e;
    public int f1362f;

    private DefaultItemAnimator$ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
        this.f1357a = viewHolder;
        this.f1358b = viewHolder2;
    }

    private DefaultItemAnimator$ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        this(viewHolder, viewHolder2);
        this.f1359c = i;
        this.f1360d = i2;
        this.f1361e = i3;
        this.f1362f = i4;
    }

    public String toString() {
        return "ChangeInfo{oldHolder=" + this.f1357a + ", newHolder=" + this.f1358b + ", fromX=" + this.f1359c + ", fromY=" + this.f1360d + ", toX=" + this.f1361e + ", toY=" + this.f1362f + '}';
    }
}

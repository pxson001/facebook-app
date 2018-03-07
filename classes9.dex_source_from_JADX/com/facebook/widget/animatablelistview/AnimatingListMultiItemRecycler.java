package com.facebook.widget.animatablelistview;

import android.util.SparseArray;
import android.view.View;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.WeakHashMap;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: android.permission.BLUETOOTH */
public class AnimatingListMultiItemRecycler<T> {
    public final ItemBasedListAdapter<T> f20481a;
    public final SparseArray<List<View>> f20482b = new SparseArray();
    public final WeakHashMap<View, Integer> f20483c = new WeakHashMap();
    public int f20484d;

    public AnimatingListMultiItemRecycler(ItemBasedListAdapter<T> itemBasedListAdapter) {
        this.f20481a = itemBasedListAdapter;
    }

    public final void m20044a(AnimatingListMultiItemContainerView animatingListMultiItemContainerView) {
        for (int i = 0; i < animatingListMultiItemContainerView.getChildCount(); i++) {
            View childAt = animatingListMultiItemContainerView.getChildAt(i);
            Integer num = (Integer) this.f20483c.get(childAt);
            if (num != null) {
                List list = (List) this.f20482b.get(num.intValue());
                if (list == null) {
                    list = Lists.b(2);
                    this.f20482b.put(num.intValue(), list);
                }
                if (list.size() < 2) {
                    this.f20484d++;
                    list.add(childAt);
                }
            }
        }
        animatingListMultiItemContainerView.removeAllViews();
    }
}

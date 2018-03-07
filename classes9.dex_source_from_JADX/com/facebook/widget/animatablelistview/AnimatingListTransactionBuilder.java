package com.facebook.widget.animatablelistview;

import android.view.animation.Interpolator;
import com.facebook.widget.animatablelistview.AnimatingListMutation.MutationType;
import com.facebook.widget.animatablelistview.custom.AnimatingListViewCustomAnimation;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: android.media.property.OUTPUT_FRAMES_PER_BUFFER */
public class AnimatingListTransactionBuilder<T> {
    private static final Class<?> f20495a = AnimatingListTransactionBuilder.class;
    private final AnimatingListAdapter<T> f20496b;
    private final ImmutableList<T> f20497c;
    public final List<T> f20498d;
    public final List<AnimatingListMutation<T>> f20499e = Lists.a();
    public final Set<T> f20500f;
    public final Map<T, T> f20501g;
    public final long f20502h;
    @Nullable
    public final Interpolator f20503i;

    public AnimatingListTransactionBuilder(AnimatingListAdapter<T> animatingListAdapter) {
        this.f20496b = animatingListAdapter;
        this.f20497c = ImmutableList.copyOf(animatingListAdapter.f20471o);
        this.f20498d = new ArrayList(this.f20497c);
        this.f20500f = Sets.a();
        this.f20501g = Maps.c();
        this.f20502h = animatingListAdapter.f20475s;
        this.f20503i = animatingListAdapter.f20476t;
    }

    public final int m20046a(int i) {
        for (AnimatingListMutation animatingListMutation : this.f20499e) {
            switch (animatingListMutation.f20485a) {
                case ADD:
                case ADD_WITH_ANIMATION_UP:
                case ADD_WITH_ANIMATION_DOWN:
                    if (i < animatingListMutation.f20488d) {
                        break;
                    }
                    i += animatingListMutation.m20045c();
                    break;
                case REMOVE:
                    if (i <= animatingListMutation.f20488d) {
                        break;
                    }
                    i -= animatingListMutation.m20045c();
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public final int m20053b(int i) {
        for (AnimatingListMutation animatingListMutation : this.f20499e) {
            switch (animatingListMutation.f20485a) {
                case REMOVE_WITH_ANIMATION_UP:
                case REMOVE_WITH_ANIMATION_DOWN:
                    if (i < animatingListMutation.f20488d) {
                        break;
                    }
                    i += animatingListMutation.m20045c();
                    break;
                default:
                    break;
            }
        }
        return i;
    }

    public final void m20052a(Collection<? extends T> collection) {
        Integer.valueOf(collection.size());
        int i = 0;
        for (Object of : collection) {
            this.f20499e.add(new AnimatingListMutation(ImmutableList.of(of), MutationType.ADD, this.f20498d.size() + i));
            i++;
        }
        this.f20498d.addAll(collection);
    }

    public final void m20049a(int i, Collection<? extends T> collection) {
        Integer.valueOf(i);
        Integer.valueOf(collection.size());
        int i2 = 0;
        for (Object of : collection) {
            this.f20499e.add(new AnimatingListMutation(ImmutableList.of(of), MutationType.ADD, i + i2));
            i2++;
        }
        this.f20498d.addAll(i, collection);
    }

    public final void m20050a(int i, List<? extends T> list) {
        Integer.valueOf(i);
        this.f20499e.add(new AnimatingListMutation(list, MutationType.ADD_WITH_ANIMATION_DOWN, i));
        this.f20498d.addAll(i, list);
    }

    public final void m20056b(int i, List<? extends T> list) {
        Integer.valueOf(i);
        this.f20499e.add(new AnimatingListMutation(list, MutationType.ADD_WITH_ANIMATION_UP, i));
        this.f20498d.addAll(i, list);
    }

    public final void m20059c(int i, List<? extends T> list) {
        this.f20499e.add(new AnimatingListMutation(list, MutationType.FADE_IN, i));
    }

    public final void m20057c(int i) {
        Integer.valueOf(i);
        Object obj = this.f20498d.get(i);
        this.f20498d.remove(i);
        this.f20499e.add(new AnimatingListMutation(ImmutableList.of(obj), MutationType.REMOVE, i));
    }

    public final void m20048a(int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Collection a = Lists.a(this.f20498d.subList(i, i + i2));
        this.f20499e.add(new AnimatingListMutation(a, MutationType.REMOVE_WITH_ANIMATION_DOWN, i));
        this.f20500f.addAll(a);
    }

    public final void m20054b(int i, int i2) {
        Integer.valueOf(i);
        Integer.valueOf(i2);
        Collection a = Lists.a(this.f20498d.subList(i, i + i2));
        this.f20499e.add(new AnimatingListMutation(a, MutationType.REMOVE_WITH_ANIMATION_UP, i));
        this.f20500f.addAll(a);
    }

    public final void m20058c(int i, int i2) {
        this.f20499e.add(new AnimatingListMutation(Lists.a(this.f20498d.subList(i, i + i2)), MutationType.FADE_OUT, i));
    }

    public final void m20055b(int i, T t) {
        Integer.valueOf(i);
        this.f20498d.set(i, t);
        this.f20499e.add(new AnimatingListMutation(ImmutableList.of(t), MutationType.REPLACE, i));
    }

    public final void m20051a(Supplier<AnimatingListViewCustomAnimation> supplier) {
        this.f20499e.add(new AnimatingListMutation(supplier));
    }

    public final T m20060d(int i) {
        return this.f20498d.get(i);
    }

    public final void m20047a() {
        ImmutableList copyOf = ImmutableList.copyOf(this.f20498d);
        Builder builder = ImmutableList.builder();
        for (Object next : copyOf) {
            if (!this.f20500f.contains(next)) {
                if (this.f20501g.containsKey(next)) {
                    builder.c(this.f20501g.get(next));
                } else {
                    builder.c(next);
                }
            }
        }
        this.f20496b.m20036a(this, copyOf, builder.b(), ImmutableList.copyOf(this.f20499e));
    }
}

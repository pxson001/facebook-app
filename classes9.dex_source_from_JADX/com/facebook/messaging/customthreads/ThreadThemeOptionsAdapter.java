package com.facebook.messaging.customthreads;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mediaAttachments.count */
public class ThreadThemeOptionsAdapter extends Adapter<ViewHolder> {
    @Nullable
    private ImmutableList<CustomThreadTheme> f10327a;
    @Nullable
    public OnThreadThemeClickListener f10328b;
    private ThreadCustomization f10329c;
    private int f10330d;
    private int f10331e = this.f10330d;

    /* compiled from: mediaAttachments.count */
    public interface OnThreadThemeClickListener {
        void m10913a(@Nullable CustomThreadTheme customThreadTheme);
    }

    /* compiled from: mediaAttachments.count */
    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public final ImageView f10325l;
        public final ImageView f10326m;

        public ViewHolder(View view) {
            super(view);
            this.f10325l = (ImageView) view.findViewById(2131560317);
            this.f10326m = (ImageView) view.findViewById(2131560870);
        }
    }

    public static ThreadThemeOptionsAdapter m10915b(InjectorLike injectorLike) {
        return new ThreadThemeOptionsAdapter(ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final void m10917a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Preconditions.checkNotNull(this.f10327a);
        final CustomThreadTheme customThreadTheme = (CustomThreadTheme) this.f10327a.get(i);
        ThreadCustomization threadCustomization = this.f10329c;
        Object obj = (threadCustomization != null && threadCustomization.c == customThreadTheme.f10235b && threadCustomization.d == customThreadTheme.f10236c && threadCustomization.b == customThreadTheme.f10234a) ? 1 : null;
        viewHolder2.f10325l.setVisibility(obj != null ? 0 : 8);
        viewHolder2.f10326m.setColorFilter(customThreadTheme.m10851d());
        viewHolder2.f10326m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ThreadThemeOptionsAdapter f10324b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2043972986);
                if (this.f10324b.f10328b != null) {
                    this.f10324b.f10328b.m10913a(customThreadTheme);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1933574955, a);
            }
        });
    }

    @Inject
    public ThreadThemeOptionsAdapter(Resources resources) {
        this.f10330d = resources.getDimensionPixelSize(2131427839);
        a(true);
    }

    public final int aZ_() {
        return this.f10327a == null ? 0 : this.f10327a.size();
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m10916a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130903832, viewGroup, false);
        m10914a(viewGroup, inflate);
        return new ViewHolder(inflate);
    }

    private void m10914a(ViewGroup viewGroup, View view) {
        LayoutManager layoutManager = ((RecyclerView) viewGroup).getLayoutManager();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = layoutManager.b();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.width = this.f10330d;
        layoutParams.height = this.f10331e;
    }

    public final void m10919a(List<CustomThreadTheme> list) {
        this.f10327a = ImmutableList.copyOf(list);
        notifyDataSetChanged();
    }

    public final void m10918a(@Nullable ThreadCustomization threadCustomization) {
        if (!Objects.equal(threadCustomization, this.f10329c)) {
            this.f10329c = threadCustomization != null ? ThreadCustomization.newBuilder().a(threadCustomization).g() : null;
            notifyDataSetChanged();
        }
    }
}

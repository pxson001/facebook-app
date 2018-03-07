package com.facebook.messaging.emoji;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.bugreporter.BugReportCategory;
import com.facebook.bugreporter.BugReportOperationLogger;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.common.util.ContextUtils;
import com.facebook.inject.Assisted;
import com.facebook.messaging.emoji.EmojiKeyboardView.C12032;
import com.facebook.messaging.tabbedpager.ItemBasedTabbedPagerAdapter;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.ui.emoji.model.EmojiSet;
import com.facebook.ui.emoji.model.EmojiSet.Type;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mangle_empty_salamanders */
public class EmojiPageAdapter implements ItemBasedTabbedPagerAdapter<EmojiSet> {
    private final BugReportOperationLogger f10957a;
    private final Context f10958b;
    private final EmojiGridViewAdapterProvider f10959c;
    private final Sizes f10960d;
    public final Set<EmojiGridViewAdapter> f10961e = new HashSet();
    @Nullable
    public C12032 f10962f;
    @Nullable
    public RecentEmojiView f10963g;
    public String f10964h;

    /* compiled from: mangle_empty_salamanders */
    public class C12071 {
        public final /* synthetic */ EmojiPageAdapter f10954a;

        C12071(EmojiPageAdapter emojiPageAdapter) {
            this.f10954a = emojiPageAdapter;
        }
    }

    /* compiled from: mangle_empty_salamanders */
    class C12082 implements Listener {
        final /* synthetic */ EmojiPageAdapter f10955a;

        C12082(EmojiPageAdapter emojiPageAdapter) {
            this.f10955a = emojiPageAdapter;
        }

        public final void mo426a(Emoji emoji) {
            if (this.f10955a.f10962f != null) {
                this.f10955a.f10962f.m11332a(emoji);
            }
        }

        public final void mo425a() {
            if (this.f10955a.f10962f != null) {
                this.f10955a.f10962f.m11331a();
            }
        }
    }

    /* compiled from: mangle_empty_salamanders */
    class EmojiTabViewHolder extends ViewHolder {
        public final ImageView f10956l;

        EmojiTabViewHolder(ImageView imageView) {
            super(imageView);
            this.f10956l = imageView;
        }
    }

    public final View m11371a(Object obj, @Nullable View view, ViewGroup viewGroup, boolean z) {
        EmojiSet emojiSet = (EmojiSet) obj;
        if (emojiSet.d == Type.RECENTLY_USED) {
            return m11367a(view);
        }
        return m11368b(emojiSet, view);
    }

    public final String m11372a(Object obj) {
        return String.valueOf(((EmojiSet) obj).a);
    }

    public final void m11373a(ViewHolder viewHolder, Object obj) {
        EmojiSet emojiSet = (EmojiSet) obj;
        EmojiTabViewHolder emojiTabViewHolder = (EmojiTabViewHolder) viewHolder;
        emojiTabViewHolder.f10956l.setImageResource(emojiSet.a);
        emojiTabViewHolder.f10956l.setContentDescription(this.f10958b.getString(emojiSet.b));
    }

    public final int m11375b(Object obj) {
        return ((EmojiSet) obj).d.ordinal();
    }

    public final void m11377d(Object obj) {
        EmojiSet emojiSet = (EmojiSet) obj;
        this.f10957a.a("Tab switched", BugReportCategory.COMPOSE_MESSAGE_FLOW);
        this.f10964h = String.valueOf(emojiSet.a);
        if (emojiSet.d == Type.RECENTLY_USED && this.f10963g != null) {
            RecentEmojiView recentEmojiView = this.f10963g;
            if (recentEmojiView.f10997m != null) {
                recentEmojiView.f10997m.m11322a(recentEmojiView.f10996l.f11009a);
            }
        }
    }

    private View m11368b(EmojiSet emojiSet, @Nullable View view) {
        ImmutableList copyOf = ImmutableList.copyOf(emojiSet.c);
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView == null) {
            view = new RecyclerView(this.f10958b);
            view.setLayoutManager(new GridLayoutManager(this.f10958b, this.f10960d.a));
            EmojiGridViewAdapter a = this.f10959c.m11325a(this.f10960d);
            this.f10961e.add(a);
            a.f10919k = new C12082(this);
            view.setAdapter(a);
            a.m11322a(copyOf);
            return view;
        }
        ((EmojiGridViewAdapter) recyclerView.o).m11322a(copyOf);
        return recyclerView;
    }

    @Inject
    public EmojiPageAdapter(BugReportOperationLogger bugReportOperationLogger, Context context, EmojiGridViewAdapterProvider emojiGridViewAdapterProvider, @Assisted Sizes sizes) {
        this.f10957a = bugReportOperationLogger;
        this.f10958b = context;
        this.f10959c = emojiGridViewAdapterProvider;
        this.f10960d = sizes;
    }

    public final int m11369a() {
        return -1;
    }

    public final int m11376c(Object obj) {
        return 0;
    }

    public final ViewHolder m11370a(ViewGroup viewGroup, int i) {
        View imageView = new ImageView(this.f10958b);
        CustomViewUtils.b(imageView, ContextUtils.f(this.f10958b, 2130772800, 2130842164));
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        return new EmojiTabViewHolder(imageView);
    }

    private View m11367a(@Nullable View view) {
        this.f10963g = (RecentEmojiView) view;
        if (this.f10963g == null) {
            this.f10963g = new RecentEmojiView(this.f10958b, this.f10960d);
            this.f10963g.f11000p = new C12071(this);
        }
        return this.f10963g;
    }

    public final boolean m11378e(Object obj) {
        return true;
    }

    public final void m11374a(C12032 c12032) {
        this.f10962f = c12032;
    }
}

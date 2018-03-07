package com.facebook.messaging.emoji;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.threadview.EmojilikePickerView.3;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mangle_id_key */
public class EmojiOptionsAdapter extends Adapter<ViewHolder> {
    private static final Config f10942a = new Config(false, false);
    public final DownloadableEmojiButtonBuilder f10943b;
    private final EmojiUtil f10944c;
    private final List<Emoji> f10945d = new ArrayList();
    private int f10946e;
    private int f10947f;
    public Config f10948g = f10942a;
    @Nullable
    public Emoji f10949h;
    public OnEmojiClickListener f10950i;
    public 3 f10951j;
    public ColorStateList f10952k = new ColorStateList(new int[0][], new int[0]);
    public int f10953l;

    /* compiled from: mangle_id_key */
    public class C12041 implements OnClickListener {
        final /* synthetic */ EmojiOptionsAdapter f10934a;

        public C12041(EmojiOptionsAdapter emojiOptionsAdapter) {
            this.f10934a = emojiOptionsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 884047494);
            if (this.f10934a.f10950i != null) {
                this.f10934a.f10950i.mo427a(null);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1033732565, a);
        }
    }

    /* compiled from: mangle_id_key */
    public class C12063 implements OnClickListener {
        final /* synthetic */ EmojiOptionsAdapter f10937a;

        public C12063(EmojiOptionsAdapter emojiOptionsAdapter) {
            this.f10937a = emojiOptionsAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2141889143);
            if (this.f10937a.f10951j != null) {
                this.f10937a.f10951j.a.k.a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1253228625, a);
        }
    }

    /* compiled from: mangle_id_key */
    public class Config {
        public final boolean f10938a;
        public final boolean f10939b;

        public Config(boolean z, boolean z2) {
            this.f10938a = z;
            this.f10939b = z2;
        }
    }

    /* compiled from: mangle_id_key */
    public class GlyphButtonViewHolder extends ViewHolder {
        final /* synthetic */ EmojiOptionsAdapter f10940l;
        public final GlyphButton f10941m;

        public GlyphButtonViewHolder(EmojiOptionsAdapter emojiOptionsAdapter, GlyphButton glyphButton) {
            this.f10940l = emojiOptionsAdapter;
            super(glyphButton);
            this.f10941m = glyphButton;
        }
    }

    /* compiled from: mangle_id_key */
    public interface OnEmojiClickListener {
        void mo427a(@Nullable Emoji emoji);
    }

    public static EmojiOptionsAdapter m11355b(InjectorLike injectorLike) {
        return new EmojiOptionsAdapter(ResourcesMethodAutoProvider.a(injectorLike), DownloadableEmojiButtonBuilder.m11311a(injectorLike), EmojiUtil.a(injectorLike));
    }

    @Inject
    public EmojiOptionsAdapter(Resources resources, DownloadableEmojiButtonBuilder downloadableEmojiButtonBuilder, EmojiUtil emojiUtil) {
        this.f10943b = downloadableEmojiButtonBuilder;
        this.f10944c = emojiUtil;
        this.f10946e = resources.getDimensionPixelSize(2131427865);
        this.f10947f = this.f10946e;
        a(true);
    }

    public final void m11362a(List<String> list) {
        Builder builder = ImmutableList.builder();
        for (String a : list) {
            Emoji a2 = this.f10944c.a(a);
            if (a2 != null) {
                builder.c(a2);
            }
        }
        m11363b(builder.b());
    }

    public final void m11363b(List<Emoji> list) {
        this.f10945d.clear();
        this.f10945d.addAll(list);
        notifyDataSetChanged();
    }

    public final void m11361a(@Nullable String str) {
        m11360a(this.f10944c.a(str));
    }

    public final void m11360a(@Nullable Emoji emoji) {
        this.f10949h = emoji;
        notifyDataSetChanged();
    }

    public final void m11364e(int i, int i2) {
        r1 = new int[3][];
        r1[0] = new int[]{16842919};
        r1[1] = new int[]{16842913};
        r1[2] = new int[0];
        this.f10952k = new ColorStateList(r1, new int[]{i2, i2, i});
        notifyDataSetChanged();
    }

    public final void m11359a(Config config) {
        this.f10948g = config;
        notifyDataSetChanged();
    }

    public final int aZ_() {
        return (this.f10948g.f10939b ? 1 : 0) + (this.f10945d.size() + m11356e());
    }

    private int m11356e() {
        return this.f10948g.f10938a ? 1 : 0;
    }

    public int getItemViewType(int i) {
        if (i == 0 && this.f10948g.f10938a) {
            return 0;
        }
        if (this.f10948g.f10939b && i == aZ_() - 1) {
            return 2;
        }
        return 1;
    }

    public final long H_(int i) {
        return (long) i;
    }

    public final ViewHolder m11357a(ViewGroup viewGroup, int i) {
        ViewHolder glyphButtonViewHolder;
        GlyphButton glyphButton;
        switch (i) {
            case 0:
                glyphButton = (GlyphButton) LayoutInflater.from(viewGroup.getContext()).inflate(2130905318, viewGroup, false);
                glyphButton.setOnClickListener(new C12041(this));
                glyphButtonViewHolder = new GlyphButtonViewHolder(this, glyphButton);
                break;
            case 1:
                final EmojiViewHolder a = this.f10943b.m11313a(viewGroup);
                a.a.setBackgroundResource(2130841460);
                a.a.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ EmojiOptionsAdapter f10936b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 659698871);
                        if (this.f10936b.f10950i != null) {
                            this.f10936b.f10950i.mo427a(a.f10892m);
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, -32610278, a);
                    }
                });
                glyphButtonViewHolder = a;
                break;
            case 2:
                glyphButton = (GlyphButton) LayoutInflater.from(viewGroup.getContext()).inflate(2130905319, viewGroup, false);
                glyphButton.setOnClickListener(new C12063(this));
                glyphButtonViewHolder = new GlyphButtonViewHolder(this, glyphButton);
                break;
            default:
                throw new IllegalStateException("EmojilikePickerView onCreateViewHolder with unknown view type");
        }
        m11354a(viewGroup, glyphButtonViewHolder);
        return glyphButtonViewHolder;
    }

    private void m11354a(ViewGroup viewGroup, ViewHolder viewHolder) {
        LayoutManager layoutManager = ((RecyclerView) viewGroup).getLayoutManager();
        LayoutParams layoutParams = (LayoutParams) viewHolder.a.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = layoutManager.b();
            viewHolder.a.setLayoutParams(layoutParams);
        }
        layoutParams.width = this.f10946e;
        layoutParams.height = this.f10947f;
    }

    public final void m11358a(ViewHolder viewHolder, int i) {
        View view = viewHolder.a;
        Drawable c = DrawableCompat.c(view.getBackground());
        CustomViewUtils.b(view, c);
        DrawableCompat.a(c, this.f10952k);
        switch (getItemViewType(i)) {
            case 0:
                boolean z;
                View view2 = ((GlyphButtonViewHolder) viewHolder).a;
                if (this.f10949h == null) {
                    z = true;
                } else {
                    z = false;
                }
                view2.setSelected(z);
                return;
            case 1:
                Emoji emoji = (Emoji) this.f10945d.get(i - m11356e());
                EmojiViewHolder emojiViewHolder = (EmojiViewHolder) viewHolder;
                emojiViewHolder.m11309b(emoji);
                emojiViewHolder.a.setSelected(emoji.equals(this.f10949h));
                return;
            case 2:
                GlyphButtonViewHolder glyphButtonViewHolder = (GlyphButtonViewHolder) viewHolder;
                glyphButtonViewHolder.f10941m.setGlyphColor(this.f10953l);
                return;
            default:
                throw new IllegalStateException("EmojilikePickerView onBindViewHolder with unknown view type");
        }
    }
}

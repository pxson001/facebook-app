package com.facebook.messaging.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.BigEmojis;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mangle_salamander_no_body */
public class EmojiGridViewAdapter extends Adapter<EmojiViewHolder> {
    private final Context f10909a;
    private final Lazy<BigEmojis> f10910b;
    private final DownloadableEmojiButtonBuilder f10911c;
    public final Emojis f10912d;
    private final Lazy<FbSharedPreferences> f10913e;
    public final Lazy<GlobalEmojiSkinToneHelper> f10914f;
    private final Sizes f10915g;
    public final MessagingEmojiGatingUtil f10916h;
    @Nullable
    public EmojiSkinTonesPopoverWindow f10917i;
    private ImmutableList<Emoji> f10918j = RegularImmutableList.a;
    @Nullable
    public Listener f10919k;

    /* compiled from: mangle_salamander_no_body */
    interface Listener {
        void mo425a();

        void mo426a(Emoji emoji);
    }

    public final void m11320a(ViewHolder viewHolder, int i) {
        ((EmojiViewHolder) viewHolder).m11309b((Emoji) this.f10918j.get(i));
    }

    @Inject
    public EmojiGridViewAdapter(Context context, Lazy<BigEmojis> lazy, EmojiButtonBuilder emojiButtonBuilder, Emojis emojis, Lazy<FbSharedPreferences> lazy2, Lazy<GlobalEmojiSkinToneHelper> lazy3, @Assisted Sizes sizes, MessagingEmojiGatingUtil messagingEmojiGatingUtil) {
        this.f10909a = context;
        this.f10910b = lazy;
        this.f10911c = emojiButtonBuilder;
        this.f10912d = emojis;
        this.f10913e = lazy2;
        this.f10914f = lazy3;
        this.f10915g = sizes;
        this.f10916h = messagingEmojiGatingUtil;
    }

    public final void m11322a(ImmutableList<Emoji> immutableList) {
        this.f10918j = immutableList;
        notifyDataSetChanged();
    }

    public final int aZ_() {
        return this.f10918j.size();
    }

    public final ViewHolder m11319a(ViewGroup viewGroup, int i) {
        final EmojiViewHolder a = this.f10911c.m11313a(viewGroup);
        a.a.setLayoutParams(new LayoutParams(-1, this.f10915g.j));
        a.a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiGridViewAdapter f10903b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -101242932);
                Emoji emoji = a.f10892m;
                if (this.f10903b.f10916h.m11394c() && this.f10903b.f10912d.a(emoji)) {
                    this.f10903b.m11321a(view, emoji);
                    Logger.a(2, EntryType.UI_INPUT_END, 1790562598, a);
                    return;
                }
                if (this.f10903b.f10919k != null) {
                    this.f10903b.f10919k.mo426a(emoji);
                }
                LogUtils.a(104893299, a);
            }
        });
        if (this.f10916h.m11393b()) {
            a.a.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ EmojiGridViewAdapter f10905b;

                public boolean onLongClick(View view) {
                    this.f10905b.m11321a(view, a.f10892m);
                    return true;
                }
            });
        }
        return a;
    }

    public final void m11321a(View view, Emoji emoji) {
        if (this.f10912d.a(emoji)) {
            final boolean c = this.f10916h.m11394c();
            this.f10917i = new EmojiSkinTonesPopoverWindow(this.f10909a, c);
            this.f10917i.c(view);
            ImmutableList b = this.f10912d.b(emoji);
            for (int i = 0; i < b.size(); i++) {
                final Emoji emoji2 = (Emoji) b.get(i);
                OnClickListener c12013 = new OnClickListener(this) {
                    final /* synthetic */ EmojiGridViewAdapter f10908c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1036198628);
                        if (this.f10908c.f10919k != null) {
                            this.f10908c.f10919k.mo426a(emoji2);
                        }
                        if (c) {
                            ((GlobalEmojiSkinToneHelper) this.f10908c.f10914f.get()).m11384a(emoji2.c);
                            if (this.f10908c.f10919k != null) {
                                this.f10908c.f10919k.mo425a();
                            }
                        }
                        this.f10908c.f10917i.l();
                        Logger.a(2, EntryType.UI_INPUT_END, -2011637893, a);
                    }
                };
                Drawable a = ContextCompat.a(this.f10909a, ((BigEmojis) this.f10910b.get()).a());
                EmojiSkinTonesPopoverWindow emojiSkinTonesPopoverWindow = this.f10917i;
                int i2 = emoji.d;
                ImageView imageView = (ImageView) emojiSkinTonesPopoverWindow.f10969n.getChildAt(i);
                imageView.setOnClickListener(c12013);
                imageView.setImageDrawable(a);
                imageView.setContentDescription(emojiSkinTonesPopoverWindow.f10966a.getString(i2));
            }
            this.f10917i.d();
            if (c) {
                ((FbSharedPreferences) this.f10913e.get()).edit().putBoolean(EmojiPrefKeys.e, true).putBoolean(EmojiPrefKeys.f, false).commit();
            }
        }
    }

    public final boolean m11323d() {
        return this.f10917i != null && this.f10917i.r;
    }

    public final void m11324e() {
        if (this.f10917i != null) {
            this.f10917i.l();
        }
    }
}

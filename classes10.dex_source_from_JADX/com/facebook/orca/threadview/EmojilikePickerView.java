package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.LikeIconEmojiOptions;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper;
import com.facebook.messaging.emoji.EmojiOptionsAdapter;
import com.facebook.messaging.emoji.EmojiOptionsAdapter.Config;
import com.facebook.messaging.emoji.EmojiOptionsAdapter.OnEmojiClickListener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.EmojilikePickerViewListener;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: momihihori0306040508woig54exuc65oloworarkekipabyungegugggogh3330lelo8685huhepo44 */
public class EmojilikePickerView extends CustomLinearLayout {
    @Inject
    public CustomThreadsTextHelper f6901a;
    @Inject
    public EmojiOptionsAdapter f6902b;
    @Inject
    public LikeIconEmojiOptions f6903c;
    private final Listener f6904d = new C10371(this);
    public TextView f6905e;
    public TextView f6906f;
    public int f6907g;
    private ThreadKey f6908h;
    public String f6909i;
    private DefaultThreadViewTheme f6910j;
    public EmojilikePickerViewListener f6911k;

    /* compiled from: momihihori0306040508woig54exuc65oloworarkekipabyungegugggogh3330lelo8685huhepo44 */
    class C10371 implements Listener {
        final /* synthetic */ EmojilikePickerView f6897a;

        C10371(EmojilikePickerView emojilikePickerView) {
            this.f6897a = emojilikePickerView;
        }

        public final void m6537a() {
            EmojilikePickerView.m6541b(this.f6897a);
        }
    }

    /* compiled from: momihihori0306040508woig54exuc65oloworarkekipabyungegugggogh3330lelo8685huhepo44 */
    public class C10382 implements OnEmojiClickListener {
        final /* synthetic */ EmojilikePickerView f6898a;

        public C10382(EmojilikePickerView emojilikePickerView) {
            this.f6898a = emojilikePickerView;
        }

        public final void m6538a(@Nullable Emoji emoji) {
            this.f6898a.f6911k.m7496a(emoji, this.f6898a.f6909i);
        }
    }

    /* compiled from: momihihori0306040508woig54exuc65oloworarkekipabyungegugggogh3330lelo8685huhepo44 */
    public class C10393 {
        public final /* synthetic */ EmojilikePickerView f6899a;

        public C10393(EmojilikePickerView emojilikePickerView) {
            this.f6899a = emojilikePickerView;
        }
    }

    /* compiled from: momihihori0306040508woig54exuc65oloworarkekipabyungegugggogh3330lelo8685huhepo44 */
    public class C10404 extends ItemDecoration {
        final /* synthetic */ EmojilikePickerView f6900a;

        public C10404(EmojilikePickerView emojilikePickerView) {
            this.f6900a = emojilikePickerView;
        }

        public final void m6539a(Rect rect, View view, RecyclerView recyclerView, State state) {
            if (RecyclerView.e(view) > 0) {
                rect.left = this.f6900a.f6907g;
            }
        }
    }

    public static void m6540a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EmojilikePickerView emojilikePickerView = (EmojilikePickerView) obj;
        CustomThreadsTextHelper a = CustomThreadsTextHelper.m2126a(injectorLike);
        EmojiOptionsAdapter b = EmojiOptionsAdapter.b(injectorLike);
        LikeIconEmojiOptions b2 = LikeIconEmojiOptions.b(injectorLike);
        emojilikePickerView.f6901a = a;
        emojilikePickerView.f6902b = b;
        emojilikePickerView.f6903c = b2;
    }

    public EmojilikePickerView(Context context) {
        super(context);
        Class cls = EmojilikePickerView.class;
        m6540a(this, getContext());
        this.f6907g = getResources().getDimensionPixelOffset(2131428657);
        setOrientation(1);
        setContentView(2130905317);
        this.f6905e = (TextView) a(2131560867);
        this.f6906f = (TextView) a(2131560868);
        RecyclerView recyclerView = (RecyclerView) a(2131563964);
        this.f6902b.a(this.f6903c.D);
        this.f6902b.a(new Config(true, true));
        this.f6902b.i = new C10382(this);
        this.f6902b.j = new C10393(this);
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        recyclerView.a(new C10404(this));
        recyclerView.setAdapter(this.f6902b);
    }

    public void setThreadKey(ThreadKey threadKey) {
        if (!Objects.equal(this.f6908h, threadKey)) {
            this.f6908h = threadKey;
            this.f6906f.setText(this.f6901a.m2128a(threadKey));
        }
    }

    public void setThreadViewTheme(DefaultThreadViewTheme defaultThreadViewTheme) {
        if (this.f6910j != null) {
            this.f6910j.b(this.f6904d);
        }
        this.f6910j = defaultThreadViewTheme;
        if (this.f6910j != null) {
            this.f6910j.a(this.f6904d);
            m6541b(this);
        }
    }

    public static void m6541b(EmojilikePickerView emojilikePickerView) {
        int d = emojilikePickerView.f6910j.d();
        emojilikePickerView.f6905e.setTextColor(d);
        emojilikePickerView.f6906f.setTextColor(d);
        emojilikePickerView.f6902b.a(emojilikePickerView.f6910j.g());
        emojilikePickerView.f6902b.e(emojilikePickerView.f6910j.a(BubbleType.NORMAL, SenderType.OTHER), emojilikePickerView.f6910j.a(BubbleType.NORMAL, SenderType.ME));
        EmojiOptionsAdapter emojiOptionsAdapter = emojilikePickerView.f6902b;
        emojiOptionsAdapter.l = emojilikePickerView.f6910j.d();
        if (emojiOptionsAdapter.g.b) {
            emojiOptionsAdapter.j_(emojiOptionsAdapter.aZ_() - 1);
        }
    }
}

package com.facebook.messaging.emoji;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.emoji.Emojis;
import com.facebook.ui.emoji.model.Emoji;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: main_location_sending */
public class MessengerEmojiColorPickerView extends CustomFrameLayout {
    @Inject
    EmojiOptionsAdapter f10986a;
    @Inject
    Emojis f10987b;
    public int f10988c;
    private OnEmojiClickListener f10989d;

    /* compiled from: main_location_sending */
    class C12121 implements com.facebook.messaging.emoji.EmojiOptionsAdapter.OnEmojiClickListener {
        final /* synthetic */ MessengerEmojiColorPickerView f10984a;

        C12121(MessengerEmojiColorPickerView messengerEmojiColorPickerView) {
            this.f10984a = messengerEmojiColorPickerView;
        }

        public final void mo427a(@Nullable Emoji emoji) {
            this.f10984a.f10986a.m11360a(emoji);
        }
    }

    /* compiled from: main_location_sending */
    class C12132 extends ItemDecoration {
        final /* synthetic */ MessengerEmojiColorPickerView f10985a;

        C12132(MessengerEmojiColorPickerView messengerEmojiColorPickerView) {
            this.f10985a = messengerEmojiColorPickerView;
        }

        public final void m11402a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.top = this.f10985a.f10988c;
            rect.left = this.f10985a.f10988c;
        }
    }

    /* compiled from: main_location_sending */
    interface OnEmojiClickListener {
    }

    private static <T extends View> void m11406a(Class<T> cls, T t) {
        m11407a((Object) t, t.getContext());
    }

    private static void m11407a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((MessengerEmojiColorPickerView) obj).m11405a(EmojiOptionsAdapter.m11355b(injectorLike), Emojis.a(injectorLike));
    }

    public MessengerEmojiColorPickerView(Context context) {
        super(context);
        m11404a();
    }

    public MessengerEmojiColorPickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m11404a();
    }

    public MessengerEmojiColorPickerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11404a();
    }

    private void m11404a() {
        m11406a(MessengerEmojiColorPickerView.class, (View) this);
        setContentView(2130905246);
        Resources resources = getResources();
        this.f10986a.m11364e(resources.getColor(2131362310), resources.getColor(2131362241));
        this.f10986a.m11363b(m11408b());
        this.f10986a.f10950i = new C12121(this);
        this.f10988c = resources.getDimensionPixelOffset(2131427871);
        RecyclerView recyclerView = (RecyclerView) c(2131559427);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, 1, false));
        recyclerView.a(new C12132(this));
        recyclerView.setAdapter(this.f10986a);
    }

    private ImmutableList<Emoji> m11408b() {
        Builder builder = ImmutableList.builder();
        builder.b(this.f10987b.b(this.f10987b.a(128077, 0)));
        return builder.b();
    }

    public void setOnEmojiClickListener(OnEmojiClickListener onEmojiClickListener) {
        this.f10989d = onEmojiClickListener;
    }

    public int getSelectedEmojiColor() {
        Emoji emoji = this.f10986a.f10949h;
        return emoji != null ? emoji.c : -1;
    }

    private void m11405a(EmojiOptionsAdapter emojiOptionsAdapter, Emojis emojis) {
        this.f10986a = emojiOptionsAdapter;
        this.f10987b = emojis;
    }

    public void setSelectedEmojiColor(int i) {
        if (i == -1) {
            this.f10986a.m11360a(null);
            return;
        }
        this.f10986a.m11360a(this.f10987b.a(128077, i));
    }
}

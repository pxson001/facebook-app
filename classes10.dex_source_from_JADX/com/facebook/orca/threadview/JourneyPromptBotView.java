package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.view.DraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.model.messages.GenericAdminMessageInfo.BotChoice;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.BotPromptViewListener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mfacewebversion */
public class JourneyPromptBotView extends CustomLinearLayout {
    public static final CallerContext f6988c = CallerContext.a(JourneyPromptBotView.class);
    @Inject
    public FbDraweeControllerBuilder f6989a;
    @Inject
    public LayoutInflater f6990b;
    public final BotAdapter f6991d = new BotAdapter(this);
    public final ThreadViewThemeListener f6992e = new ThreadViewThemeListener(this);
    public TextView f6993f;
    public TextView f6994g;
    public RecyclerView f6995h;
    @Nullable
    public ImmutableList<BotChoice> f6996i;
    @Nullable
    public BotPromptViewListener f6997j;
    @Nullable
    public DefaultThreadViewTheme f6998k;

    /* compiled from: mfacewebversion */
    public class BotAdapter extends Adapter<BotViewHolder> implements OnClickListener {
        final /* synthetic */ JourneyPromptBotView f6981a;
        public ColorStateList f6982b = new ColorStateList(new int[0][], new int[0]);

        public BotAdapter(JourneyPromptBotView journeyPromptBotView) {
            this.f6981a = journeyPromptBotView;
        }

        public final void m6576a(ViewHolder viewHolder, int i) {
            BotViewHolder botViewHolder = (BotViewHolder) viewHolder;
            Preconditions.checkNotNull(this.f6981a.f6996i);
            Preconditions.checkNotNull(this.f6981a.f6998k);
            BotChoice botChoice = (BotChoice) this.f6981a.f6996i.get(i);
            botViewHolder.f6984m.setController(((FbDraweeControllerBuilder) botViewHolder.f6983l.f6989a.a(JourneyPromptBotView.f6988c).b(botViewHolder.f6984m.getController())).a(botChoice.iconUri).s());
            botViewHolder.f6985n.setText(botChoice.title);
            botViewHolder.f6985n.setTextColor(this.f6981a.f6998k.d());
            View view = botViewHolder.a;
            Drawable c = DrawableCompat.c(view.getBackground());
            CustomViewUtils.b(view, c);
            DrawableCompat.a(c, this.f6982b);
        }

        public final int aZ_() {
            return this.f6981a.f6996i == null ? 0 : this.f6981a.f6996i.size();
        }

        public final ViewHolder m6575a(ViewGroup viewGroup, int i) {
            ViewGroup viewGroup2 = (ViewGroup) this.f6981a.f6990b.inflate(2130905316, viewGroup, false);
            viewGroup2.setOnClickListener(this);
            return new BotViewHolder(this.f6981a, viewGroup2);
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 309752081);
            if (this.f6981a.f6997j != null) {
                Preconditions.checkNotNull(this.f6981a.f6996i);
                this.f6981a.f6997j.m7494a((BotChoice) this.f6981a.f6996i.get(this.f6981a.f6995h.c(view)));
            }
            Logger.a(2, EntryType.UI_INPUT_END, -653260233, a);
        }
    }

    /* compiled from: mfacewebversion */
    public class BotViewHolder extends ViewHolder {
        public final /* synthetic */ JourneyPromptBotView f6983l;
        public final DraweeView f6984m;
        public final TextView f6985n;

        public BotViewHolder(JourneyPromptBotView journeyPromptBotView, ViewGroup viewGroup) {
            this.f6983l = journeyPromptBotView;
            super(viewGroup);
            this.f6984m = (DraweeView) viewGroup.findViewById(2131559122);
            this.f6985n = (TextView) viewGroup.findViewById(2131560883);
        }
    }

    /* compiled from: mfacewebversion */
    public class SpacingDecoration extends ItemDecoration {
        private final int f6986a;

        public SpacingDecoration(int i) {
            this.f6986a = i;
        }

        public final void m6577a(Rect rect, View view, RecyclerView recyclerView, State state) {
            if (RecyclerView.e(view) > 0) {
                rect.left = this.f6986a;
            }
        }
    }

    /* compiled from: mfacewebversion */
    class ThreadViewThemeListener implements Listener {
        final /* synthetic */ JourneyPromptBotView f6987a;

        public ThreadViewThemeListener(JourneyPromptBotView journeyPromptBotView) {
            this.f6987a = journeyPromptBotView;
        }

        public final void m6578a() {
            JourneyPromptBotView.m6580f(this.f6987a);
        }
    }

    public static void m6579a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        JourneyPromptBotView journeyPromptBotView = (JourneyPromptBotView) obj;
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(fbInjector);
        LayoutInflater b2 = LayoutInflaterMethodAutoProvider.b(fbInjector);
        journeyPromptBotView.f6989a = b;
        journeyPromptBotView.f6990b = b2;
    }

    public JourneyPromptBotView(Context context) {
        super(context);
        Class cls = JourneyPromptBotView.class;
        m6579a(this, getContext());
        setContentView(2130904991);
        setOrientation(1);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131428657);
        this.f6993f = (TextView) a(2131558927);
        this.f6994g = (TextView) a(2131559627);
        this.f6995h = (RecyclerView) a(2131563332);
        this.f6995h.a(new SpacingDecoration(dimensionPixelOffset));
        this.f6995h.setAdapter(this.f6991d);
        RecyclerView recyclerView = this.f6995h;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
    }

    public static void m6580f(JourneyPromptBotView journeyPromptBotView) {
        Preconditions.checkNotNull(journeyPromptBotView.f6998k);
        int d = journeyPromptBotView.f6998k.d();
        journeyPromptBotView.f6993f.setTextColor(d);
        journeyPromptBotView.f6994g.setTextColor(d);
        d = journeyPromptBotView.f6998k.a(BubbleType.NORMAL, SenderType.OTHER);
        int a = journeyPromptBotView.f6998k.a(BubbleType.NORMAL, SenderType.ME);
        BotAdapter botAdapter = journeyPromptBotView.f6991d;
        r5 = new int[3][];
        r5[0] = new int[]{16842919};
        r5[1] = new int[]{16842913};
        r5[2] = new int[0];
        botAdapter.f6982b = new ColorStateList(r5, new int[]{a, a, d});
        botAdapter.notifyDataSetChanged();
    }
}

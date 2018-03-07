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
import android.widget.Button;
import android.widget.TextView;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.BubbleType;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.ThreadViewTheme.SenderType;
import com.facebook.messaging.customthreads.threadsettings.CustomThreadsTextHelper;
import com.facebook.orca.threadview.ThreadViewMessagesFragment.NicknamePromptViewListener;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: messages_sync_montage_fetch_error */
public class NicknamePromptView extends CustomLinearLayout {
    @Inject
    public CustomThreadsTextHelper f7325a;
    @Inject
    public UserCache f7326b;
    @Inject
    @ViewerContextUser
    public Provider<User> f7327c;
    public TextView f7328d;
    public TextView f7329e;
    public RecyclerView f7330f;
    public int f7331g;
    public NicknameAdapter f7332h;
    public DefaultThreadViewTheme f7333i;
    public User f7334j;
    public ImmutableList<String> f7335k;
    public NicknamePromptViewListener f7336l;
    public final Listener f7337m = new C10971(this);

    /* compiled from: messages_sync_montage_fetch_error */
    class C10971 implements Listener {
        final /* synthetic */ NicknamePromptView f7317a;

        C10971(NicknamePromptView nicknamePromptView) {
            this.f7317a = nicknamePromptView;
        }

        public final void m6971a() {
            NicknamePromptView.m6977b(this.f7317a);
        }
    }

    /* compiled from: messages_sync_montage_fetch_error */
    public class C10982 extends ItemDecoration {
        final /* synthetic */ NicknamePromptView f7318a;

        public C10982(NicknamePromptView nicknamePromptView) {
            this.f7318a = nicknamePromptView;
        }

        public final void m6972a(Rect rect, View view, RecyclerView recyclerView, State state) {
            rect.right = this.f7318a.f7331g;
        }
    }

    /* compiled from: messages_sync_montage_fetch_error */
    public class NicknameAdapter extends Adapter<NicknameViewHolder> {
        final /* synthetic */ NicknamePromptView f7321a;
        public ColorStateList f7322b = new ColorStateList(new int[0][], new int[0]);

        /* compiled from: messages_sync_montage_fetch_error */
        class C10991 implements OnClickListener {
            final /* synthetic */ NicknameAdapter f7319a;

            C10991(NicknameAdapter nicknameAdapter) {
                this.f7319a = nicknameAdapter;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -2103084275);
                NicknamePromptView nicknamePromptView = this.f7319a.f7321a;
                if (nicknamePromptView.f7336l != null) {
                    nicknamePromptView.f7336l.m7502a(nicknamePromptView.f7334j);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -2140245833, a);
            }
        }

        /* compiled from: messages_sync_montage_fetch_error */
        class C11002 implements OnClickListener {
            final /* synthetic */ NicknameAdapter f7320a;

            C11002(NicknameAdapter nicknameAdapter) {
                this.f7320a = nicknameAdapter;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 496603596);
                int d = RecyclerView.d(view);
                NicknamePromptView nicknamePromptView = this.f7320a.f7321a;
                String str = (String) this.f7320a.f7321a.f7335k.get(d - 1);
                if (nicknamePromptView.f7336l != null) {
                    nicknamePromptView.f7336l.m7503a(nicknamePromptView.f7334j, str);
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1583133570, a);
            }
        }

        public NicknameAdapter(NicknamePromptView nicknamePromptView) {
            this.f7321a = nicknamePromptView;
        }

        public final void m6974a(ViewHolder viewHolder, int i) {
            NicknameViewHolder nicknameViewHolder = (NicknameViewHolder) viewHolder;
            if (getItemViewType(i) == 0) {
                nicknameViewHolder.m6975a(this.f7321a.getResources().getString(2131231858));
            } else {
                nicknameViewHolder.m6975a((String) this.f7321a.f7335k.get(i - 1));
            }
            nicknameViewHolder.f7324m.setTextColor(this.f7321a.f7333i.d());
            View view = nicknameViewHolder.a;
            Drawable c = DrawableCompat.c(view.getBackground());
            CustomViewUtils.b(view, c);
            DrawableCompat.a(c, this.f7322b);
        }

        public final int aZ_() {
            return (this.f7321a.f7335k != null ? this.f7321a.f7335k.size() : 0) + 1;
        }

        public int getItemViewType(int i) {
            return i == 0 ? 0 : 1;
        }

        public final ViewHolder m6973a(ViewGroup viewGroup, int i) {
            Button button = (Button) LayoutInflater.from(viewGroup.getContext()).inflate(2130905321, viewGroup, false);
            if (i == 0) {
                button.setOnClickListener(new C10991(this));
            } else {
                button.setOnClickListener(new C11002(this));
            }
            return new NicknameViewHolder(this.f7321a, button);
        }
    }

    /* compiled from: messages_sync_montage_fetch_error */
    public class NicknameViewHolder extends ViewHolder {
        final /* synthetic */ NicknamePromptView f7323l;
        public final TextView f7324m;

        public NicknameViewHolder(NicknamePromptView nicknamePromptView, TextView textView) {
            this.f7323l = nicknamePromptView;
            super(textView);
            this.f7324m = textView;
        }

        public final void m6975a(String str) {
            this.f7324m.setText(str);
        }
    }

    public static void m6976a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        NicknamePromptView nicknamePromptView = (NicknamePromptView) obj;
        CustomThreadsTextHelper a = CustomThreadsTextHelper.m2126a(injectorLike);
        UserCache a2 = UserCache.a(injectorLike);
        Provider a3 = IdBasedProvider.a(injectorLike, 3596);
        nicknamePromptView.f7325a = a;
        nicknamePromptView.f7326b = a2;
        nicknamePromptView.f7327c = a3;
    }

    public NicknamePromptView(Context context) {
        super(context);
        Class cls = NicknamePromptView.class;
        m6976a(this, getContext());
        this.f7331g = getResources().getDimensionPixelOffset(2131428657);
        setOrientation(1);
        setContentView(2130905320);
        this.f7328d = (TextView) a(2131560867);
        this.f7329e = (TextView) a(2131560868);
        this.f7330f = (RecyclerView) a(2131563964);
        this.f7332h = new NicknameAdapter(this);
        RecyclerView recyclerView = this.f7330f;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(0, false));
        this.f7330f.a(new C10982(this));
        this.f7330f.setAdapter(this.f7332h);
    }

    public static void m6977b(NicknamePromptView nicknamePromptView) {
        int d = nicknamePromptView.f7333i.d();
        nicknamePromptView.f7328d.setTextColor(d);
        nicknamePromptView.f7329e.setTextColor(d);
        d = nicknamePromptView.f7333i.a(BubbleType.NORMAL, SenderType.OTHER);
        int a = nicknamePromptView.f7333i.a(BubbleType.NORMAL, SenderType.ME);
        NicknameAdapter nicknameAdapter = nicknamePromptView.f7332h;
        r5 = new int[3][];
        r5[0] = new int[]{16842919};
        r5[1] = new int[]{16842913};
        r5[2] = new int[0];
        nicknameAdapter.f7322b = new ColorStateList(r5, new int[]{a, a, d});
        nicknameAdapter.notifyDataSetChanged();
    }
}

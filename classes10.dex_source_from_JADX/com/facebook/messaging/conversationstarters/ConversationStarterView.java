package com.facebook.messaging.conversationstarters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.auth.annotations.IsPartialAccount;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemUserModel;
import com.facebook.messaging.presence.LastActiveHelper;
import com.facebook.messaging.presence.LastActiveHelper.TextFormat;
import com.facebook.messaging.ui.threaditem.ThreadItemDividerDrawer;
import com.facebook.presence.Availability;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager;
import com.facebook.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.presence.PresenceState;
import com.facebook.user.model.LastActive;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: state_buy_ticket_model */
public class ConversationStarterView extends CustomRelativeLayout {
    @Inject
    DefaultPresenceManager f2244a;
    @Inject
    LastActiveHelper f2245b;
    @Inject
    FbDraweeControllerBuilder f2246c;
    @Inject
    @IsPartialAccount
    Provider<Boolean> f2247d;
    @Inject
    ThreadItemDividerDrawer f2248e;
    private UserTileView f2249f;
    private TextView f2250g;
    private TextView f2251h;
    private TextView f2252i;
    private ImageView f2253j;
    private View f2254k;
    private DraweeHolder<GenericDraweeHierarchy> f2255l;
    private DraweeController f2256m;
    private int f2257n;
    @Nullable
    public UserKey f2258o;
    private final OnContactPresenceStateChangedListener f2259p = new C03711(this);

    /* compiled from: state_buy_ticket_model */
    class C03711 extends OnContactPresenceStateChangedListener {
        final /* synthetic */ ConversationStarterView f2243a;

        C03711(ConversationStarterView conversationStarterView) {
            this.f2243a = conversationStarterView;
        }

        public final void m2111a(UserKey userKey, PresenceState presenceState) {
            if (userKey != null && userKey.equals(this.f2243a.f2258o)) {
                ConversationStarterView.setPresenceFromUserKey(this.f2243a, userKey);
            }
        }
    }

    private static <T extends View> void m2118a(Class<T> cls, T t) {
        m2119a((Object) t, t.getContext());
    }

    private static void m2119a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ConversationStarterView) obj).m2117a(DefaultPresenceManager.a(fbInjector), LastActiveHelper.a(fbInjector), FbDraweeControllerBuilder.b(fbInjector), IdBasedProvider.a(fbInjector, 3902), ThreadItemDividerDrawer.m4412a(fbInjector));
    }

    private void m2117a(PresenceManager presenceManager, LastActiveHelper lastActiveHelper, FbDraweeControllerBuilder fbDraweeControllerBuilder, Provider<Boolean> provider, ThreadItemDividerDrawer threadItemDividerDrawer) {
        this.f2244a = presenceManager;
        this.f2245b = lastActiveHelper;
        this.f2246c = fbDraweeControllerBuilder;
        this.f2247d = provider;
        this.f2248e = threadItemDividerDrawer;
    }

    public ConversationStarterView(Context context) {
        super(context, null, 2130773031);
        m2115a(context, null, 2130773031);
    }

    public ConversationStarterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 2130773031);
        m2115a(context, attributeSet, 2130773031);
    }

    protected ConversationStarterView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2115a(context, attributeSet, i);
    }

    private void m2115a(Context context, @Nullable AttributeSet attributeSet, int i) {
        m2118a(ConversationStarterView.class, (View) this);
        setContentView(2130903806);
        this.f2249f = (UserTileView) a(2131560802);
        this.f2250g = (TextView) a(2131560804);
        this.f2251h = (TextView) a(2131560807);
        this.f2252i = (TextView) a(2131560805);
        this.f2253j = (ImageView) a(2131560806);
        this.f2254k = a(2131560803);
        this.f2248e.m4413a(context, attributeSet, i);
        setWillNotDraw(!this.f2248e.m4415a());
        Resources resources = getResources();
        this.f2257n = this.f2251h.getLineHeight() - resources.getDimensionPixelSize(2131433597);
        Drawable drawable = resources.getDrawable(2130838391);
        drawable.setBounds(0, 0, this.f2257n, this.f2257n);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(resources);
        genericDraweeHierarchyBuilder.f = drawable;
        this.f2255l = DraweeHolder.a(genericDraweeHierarchyBuilder.u(), context);
        this.f2255l.h().setCallback(this);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2248e.m4414a(canvas, getWidth(), getHeight());
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1202498306);
        super.onAttachedToWindow();
        this.f2255l.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1342918488, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1787518508);
        super.onDetachedFromWindow();
        this.f2255l.d();
        if (!(this.f2258o == null || this.f2259p == null)) {
            this.f2244a.b(this.f2258o, this.f2259p);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 78268379, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f2255l.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f2255l.b();
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2255l.h();
    }

    public void setConversationStarterData(ConversationStartersFields conversationStartersFields) {
        Preconditions.checkNotNull(conversationStartersFields);
        if (!(conversationStartersFields.lK_() == null || StringUtil.a(conversationStartersFields.lK_().a()))) {
            this.f2250g.setText(conversationStartersFields.lK_().a());
        }
        if (conversationStartersFields.c() != null) {
            m2122a(conversationStartersFields.c().a(), conversationStartersFields.d() == null ? null : conversationStartersFields.d().a());
        }
        if (!(conversationStartersFields.lL_() == null || StringUtil.a(conversationStartersFields.lL_().a()))) {
            m2121a(conversationStartersFields.lL_().a(), m2113a(conversationStartersFields));
        }
        if (conversationStartersFields.lJ_() && conversationStartersFields.g() != null) {
            setAndSubscribeToPresenceFromUserId(conversationStartersFields.g().b());
        }
    }

    private void m2122a(@Nullable String str, @Nullable String str2) {
        if (StringUtil.a(str)) {
            this.f2251h.setVisibility(8);
            m2123b();
            return;
        }
        this.f2251h.setText(str);
        this.f2251h.setVisibility(0);
        if (!StringUtil.a(str2)) {
            this.f2256m = ((FbDraweeControllerBuilder) this.f2246c.b(Uri.parse(str2)).a(CallerContext.a(ConversationStarterView.class, "messenger_conversation_starters")).b(this.f2255l.f)).s();
            this.f2255l.a(this.f2256m);
            Drawable h = this.f2255l.h();
            if (h != null) {
                h.setBounds(0, 0, this.f2257n, this.f2257n);
                int dimensionPixelSize = getResources().getDimensionPixelSize(2131433598);
                Drawable insetDrawable = new InsetDrawable(h, 0, 0, dimensionPixelSize, 0);
                insetDrawable.setBounds(0, 0, this.f2257n + dimensionPixelSize, this.f2257n);
                ImageSpan imageSpan = new ImageSpan(insetDrawable, 1);
                CharSequence spannableString = new SpannableString(" " + str);
                spannableString.setSpan(imageSpan, 0, 1, 33);
                this.f2251h.setText(spannableString, BufferType.SPANNABLE);
            }
        }
    }

    private TileBadge m2113a(ConversationStartersFields conversationStartersFields) {
        ItemUserModel g = conversationStartersFields.g();
        if (g == null) {
            return TileBadge.NONE;
        }
        if (g.c()) {
            return TileBadge.MESSENGER;
        }
        if (g.d() || ((Boolean) this.f2247d.get()).booleanValue()) {
            return TileBadge.NONE;
        }
        return TileBadge.FACEBOOK;
    }

    private void m2121a(String str, TileBadge tileBadge) {
        this.f2249f.setParams(UserTileViewParams.a(new PicSquare(ImmutableList.of(new PicSquareUrlWithSize(getResources().getDimensionPixelSize(2131428608), str))), tileBadge));
    }

    private void setAndSubscribeToPresenceFromUserId(String str) {
        m2114a();
        if (!StringUtil.a(str)) {
            UserKey b = UserKey.b(str);
            if (!b.equals(this.f2258o)) {
                if (!(this.f2258o == null || this.f2259p == null)) {
                    this.f2244a.b(this.f2258o, this.f2259p);
                }
                this.f2258o = b;
                this.f2244a.a(this.f2258o);
                setPresenceFromUserKey(this, this.f2258o);
                this.f2244a.a(this.f2258o, this.f2259p);
            }
        }
    }

    public static void setPresenceFromUserKey(ConversationStarterView conversationStarterView, UserKey userKey) {
        Object obj;
        PresenceState c = conversationStarterView.f2244a.c(userKey);
        if (c.b != Availability.AVAILABLE || (c.f & 12) == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            conversationStarterView.m2120a(conversationStarterView.getResources().getString(2131231604), 2131362396, 2130842729);
            return;
        }
        if (c.b != Availability.AVAILABLE || (c.f & 2) == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            conversationStarterView.m2120a(conversationStarterView.getResources().getString(2131231605), 2131362396, 2130842729);
            return;
        }
        LastActive d = conversationStarterView.f2244a.d(userKey);
        if (d != null) {
            long a = LastActiveHelper.a(d.a, c.b);
            if (a > 0) {
                conversationStarterView.m2120a(conversationStarterView.f2245b.b(a, TextFormat.UPPER_CASE), 2131362397, 2130842730);
            }
        }
    }

    private void m2120a(String str, int i, int i2) {
        this.f2252i.setText(str);
        this.f2252i.setTextColor(getResources().getColor(i));
        this.f2252i.setVisibility(0);
        this.f2253j.setImageDrawable(getResources().getDrawable(i2));
        this.f2253j.setVisibility(0);
    }

    private void m2114a() {
        this.f2252i.setVisibility(8);
        this.f2253j.setVisibility(8);
    }

    private void m2123b() {
        int i;
        if (this.f2251h.getVisibility() == 8) {
            i = -1;
        } else {
            i = 0;
        }
        LayoutParams layoutParams = (LayoutParams) this.f2254k.getLayoutParams();
        layoutParams.addRule(15, i);
        this.f2254k.setLayoutParams(layoutParams);
    }
}

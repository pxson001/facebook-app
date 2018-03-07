package com.facebook.photos.consumptiongallery.snowflake;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.friendsharing.souvenirs.fragment.SouvenirsFragment.7;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.DefaultShareComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.consumptiongallery.Feedback;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.springbutton.TouchSpring;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: state_loading_view */
public class SnowflakeDefaultFooterView extends BaseSnowflakeFooter {
    @Inject
    GlyphColorizer f2130a;
    @Inject
    Provider<TouchSpring> f2131b;
    private final ImmutableSet<FeedbackCustomPressStateButton> f2132c;
    private final View f2133d;
    private final FeedbackCustomPressStateButton f2134e;
    private final FeedbackCustomPressStateButton f2135f;
    private final FeedbackCustomPressStateButton f2136g;
    private final String f2137h;
    private final String f2138i;
    private final Drawable f2139j;
    private final Drawable f2140k;
    public 7 f2141l;
    public SnowflakeDefaultBlingBarView f2142m;
    public Feedback f2143n;
    private GraphQLStory f2144o;

    /* compiled from: state_loading_view */
    class C02441 implements OnClickListener {
        final /* synthetic */ SnowflakeDefaultFooterView f2127a;

        C02441(SnowflakeDefaultFooterView snowflakeDefaultFooterView) {
            this.f2127a = snowflakeDefaultFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1970468987);
            if (this.f2127a.f2141l != null) {
                this.f2127a.f2141l.a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -404639994, a);
        }
    }

    /* compiled from: state_loading_view */
    class C02452 implements OnClickListener {
        final /* synthetic */ SnowflakeDefaultFooterView f2128a;

        C02452(SnowflakeDefaultFooterView snowflakeDefaultFooterView) {
            this.f2128a = snowflakeDefaultFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 796405451);
            if (this.f2128a.f2141l != null) {
                7 7 = this.f2128a.f2141l;
                if (7.a.aL != null) {
                    Builder a2 = ((IFeedIntentBuilder) 7.a.av.get()).a(GraphQLStoryUtil.o(7.a.aL), ComposerSourceType.SOUVENIR);
                    a2.setNectarModule("newsfeed_ufi").setReactionSurface(Surface.ANDROID_COMPOSER);
                    Activity activity = (Activity) ContextUtils.a(7.a.getContext(), Activity.class);
                    if (activity != null) {
                        ((DefaultShareComposerLauncher) 7.a.aw.get()).a(a2.a(), 1756, activity);
                    }
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1280450374, a);
        }
    }

    /* compiled from: state_loading_view */
    class C02463 implements OnClickListener {
        final /* synthetic */ SnowflakeDefaultFooterView f2129a;

        C02463(SnowflakeDefaultFooterView snowflakeDefaultFooterView) {
            this.f2129a = snowflakeDefaultFooterView;
        }

        public void onClick(View view) {
            boolean z = true;
            int a = Logger.a(2, EntryType.UI_INPUT_START, 510284714);
            if (this.f2129a.f2142m.f2126l) {
                boolean z2;
                boolean z3;
                if (this.f2129a.f2143n.f2107f > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.f2129a.f2143n.f2108g > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (this.f2129a.f2143n.f2111j) {
                    z = false;
                }
                int i = this.f2129a.f2143n.f2107f;
                this.f2129a.m2328a(z2, z3, z ? i + 1 : i - 1);
                this.f2129a.setIsLiked(z);
                if (this.f2129a.f2141l != null) {
                    this.f2129a.f2141l.a(this.f2129a.f2143n, z);
                }
                LogUtils.a(1387598713, a);
                return;
            }
            Logger.a(2, EntryType.UI_INPUT_END, 585447475, a);
        }
    }

    private static <T extends View> void m2326a(Class<T> cls, T t) {
        m2327a((Object) t, t.getContext());
    }

    private static void m2327a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((SnowflakeDefaultFooterView) obj).m2324a(GlyphColorizer.a(fbInjector), IdBasedProvider.a(fbInjector, 3736));
    }

    private void m2324a(GlyphColorizer glyphColorizer, Provider<TouchSpring> provider) {
        this.f2130a = glyphColorizer;
        this.f2131b = provider;
    }

    public SnowflakeDefaultFooterView(Context context) {
        this(context, null);
    }

    public SnowflakeDefaultFooterView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2326a(SnowflakeDefaultFooterView.class, (View) this);
        setContentView(2130907148);
        setOrientation(1);
        this.f2133d = a(2131567505);
        this.f2137h = getResources().getString(2131233608);
        this.f2138i = getResources().getString(2131233607);
        this.f2139j = m2321a(2130843790, -7235677);
        this.f2140k = m2321a(2130843790, -10972929);
        this.f2134e = m2322a(this.f2139j, 2131233267, 2131560943);
        this.f2134e.setOnClickListener(m2329b());
        setButtonSpring(this.f2134e);
        this.f2135f = m2322a(m2321a(2130843788, -7235677), 2131233269, 2131560944);
        this.f2135f.setOnClickListener(new C02441(this));
        setButtonSpring(this.f2135f);
        this.f2136g = m2322a(m2321a(2130843792, -7235677), 2131233280, 2131560945);
        this.f2136g.setOnClickListener(new C02452(this));
        setButtonSpring(this.f2136g);
        this.f2132c = ImmutableSet.of(this.f2134e, this.f2135f, this.f2136g);
        setButtonsEqualWeight(this.f2132c);
    }

    private FeedbackCustomPressStateButton m2322a(Drawable drawable, int i, int i2) {
        FeedbackCustomPressStateButton feedbackCustomPressStateButton = (FeedbackCustomPressStateButton) a(i2);
        feedbackCustomPressStateButton.setText(i);
        feedbackCustomPressStateButton.setSoundEffectsEnabled(false);
        feedbackCustomPressStateButton.setImageDrawable(drawable);
        return feedbackCustomPressStateButton;
    }

    private OnClickListener m2329b() {
        return new C02463(this);
    }

    private void m2328a(boolean z, boolean z2, int i) {
        if (z2 || (z && i > 0)) {
            this.f2142m.setLikesCount(i);
        } else if (z && i == 0) {
            this.f2142m.setIsExpanded(false);
        } else if (i > 0) {
            this.f2142m.setIsExpanded(true);
            this.f2142m.setLikesCount(i);
        }
    }

    private Drawable m2321a(int i, int i2) {
        return this.f2130a.a(i, i2);
    }

    public void setBlingBar(SnowflakeDefaultBlingBarView snowflakeDefaultBlingBarView) {
        this.f2142m = snowflakeDefaultBlingBarView;
    }

    public final void mo106a() {
        this.f2133d.setVisibility(0);
    }

    public void setListener(7 7) {
        this.f2141l = 7;
    }

    public final void mo107a(Feedback feedback, GraphQLStory graphQLStory) {
        this.f2143n = feedback;
        this.f2144o = graphQLStory;
        if (this.f2143n == null) {
            setVisibility(8);
            this.f2142m.m2319a(null);
            return;
        }
        m2332c();
        this.f2142m.m2319a(this.f2143n);
    }

    private void m2332c() {
        List buttonsSet = getButtonsSet();
        if (buttonsSet.isEmpty()) {
            setVisibility(8);
            return;
        }
        Iterator it = this.f2132c.iterator();
        while (it.hasNext()) {
            FeedbackCustomPressStateButton feedbackCustomPressStateButton = (FeedbackCustomPressStateButton) it.next();
            if (buttonsSet.contains(feedbackCustomPressStateButton)) {
                feedbackCustomPressStateButton.setVisibility(0);
            } else {
                feedbackCustomPressStateButton.setVisibility(8);
            }
        }
        if (buttonsSet.contains(this.f2134e)) {
            setIsLiked(this.f2143n.f2111j);
        }
        setVisibility(0);
    }

    private List<FeedbackCustomPressStateButton> getButtonsSet() {
        List<FeedbackCustomPressStateButton> arrayList = new ArrayList();
        if (this.f2143n.f2109h) {
            arrayList.add(this.f2134e);
        }
        if (this.f2143n.f2110i) {
            arrayList.add(this.f2135f);
        }
        if (this.f2144o != null && StorySharingHelper.b(this.f2144o)) {
            arrayList.add(this.f2136g);
        }
        return arrayList;
    }

    private static void setButtonsEqualWeight(ImmutableSet<FeedbackCustomPressStateButton> immutableSet) {
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            ((LayoutParams) ((FeedbackCustomPressStateButton) it.next()).getLayoutParams()).weight = 1.0f;
        }
    }

    public void setIsLiked(boolean z) {
        this.f2134e.setText(2131233267);
        this.f2134e.setTextColor(z ? -10972929 : -7235677);
        this.f2134e.setImageDrawable(z ? this.f2140k : this.f2139j);
        this.f2134e.setContentDescription(z ? this.f2137h : this.f2138i);
    }

    private void setButtonSpring(FeedbackCustomPressStateButton feedbackCustomPressStateButton) {
        feedbackCustomPressStateButton.setSpring((TouchSpring) this.f2131b.get());
    }
}

package com.facebook.facecastdisplay;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.controller.mutation.FeedbackMutationHelper;
import com.facebook.facecastdisplay.LiveCommentEventView.LiveCommentEventViewClickListener;
import com.facebook.facecastdisplay.LiveCommentLikeHelper.C02481;
import com.facebook.facecastdisplay.LiveCommentsMenuHelper.C02521;
import com.facebook.facecastdisplay.LiveCommentsMenuHelper.C02532;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import com.facebook.facecastdisplay.LiveEventsTickerView.Mode;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.model.GraphQLFeedback.Builder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.video.player.Utils;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: story_like_history */
public class LiveEventsListAdapter extends Adapter<ViewHolder> implements LiveCommentEventViewClickListener {
    @Inject
    public QeAccessor f2934a;
    public final Resources f2935b;
    public final LiveCommentLikeHelper f2936c;
    public final LiveScribeMutator f2937d;
    public final List<LiveEventModel> f2938e = new ArrayList();
    private final String f2939f;
    private final LiveEventsLogger f2940g;
    private final Lazy<LiveCommentsMenuHelper> f2941h;
    private final String f2942i;
    @Nullable
    public LiveEventsListAdapterListener f2943j;
    @Nullable
    public String f2944k;
    @Nullable
    public Mode f2945l;
    @Nullable
    public CharSequence f2946m;
    @Nullable
    public CharSequence f2947n;
    @ColorRes
    public int f2948o;

    /* compiled from: story_like_history */
    public interface LiveEventsListAdapterListener {
        void mo145a(String str);
    }

    public static LiveEventsListAdapter m3217b(InjectorLike injectorLike) {
        LiveEventsListAdapter liveEventsListAdapter = new LiveEventsListAdapter(ResourcesMethodAutoProvider.a(injectorLike), new LiveCommentLikeHelper(FeedbackMutationHelper.m2217b(injectorLike)), LiveScribeMutator.b(injectorLike), LiveEventsLogger.b(injectorLike), IdBasedLazy.a(injectorLike, 5737), String_ViewerContextUserIdMethodAutoProvider.b(injectorLike));
        liveEventsListAdapter.f2934a = (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike);
        return liveEventsListAdapter;
    }

    @Inject
    public LiveEventsListAdapter(Resources resources, LiveCommentLikeHelper liveCommentLikeHelper, LiveScribeMutator liveScribeMutator, LiveEventsLogger liveEventsLogger, Lazy<LiveCommentsMenuHelper> lazy, String str) {
        this.f2935b = resources;
        this.f2936c = liveCommentLikeHelper;
        this.f2937d = liveScribeMutator;
        this.f2940g = liveEventsLogger;
        this.f2941h = lazy;
        this.f2942i = str;
        this.f2939f = resources.getString(2131232691);
    }

    public int getItemViewType(int i) {
        return ((LiveEventModel) this.f2938e.get(i)).mo118a().ordinal();
    }

    public final ViewHolder m3221a(ViewGroup viewGroup, int i) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        switch (LiveEventType.values()[i]) {
            case LIVE_COMMENT_EVENT:
                LiveCommentEventView liveCommentEventView = (LiveCommentEventView) from.inflate(2130905067, viewGroup, false);
                if (m3220h()) {
                    liveCommentEventView.setListener(this);
                }
                return liveCommentEventView.f2861a;
            case LIVE_WATCH_EVENT:
                return new LiveHighlightedEventViewHolder((LiveHighlightedEventView) from.inflate(2130905082, viewGroup, false));
            case LIVE_SUBSCRIBE_EVENT:
                return new LiveSubscribeEventViewHolder((LiveSubscribeEventView) from.inflate(2130905090, viewGroup, false));
            case LIVE_LIKE_EVENT:
                return new LiveHighlightedEventViewHolder((LiveHighlightedEventView) from.inflate(2130905082, viewGroup, false));
            case LIVE_INFO_EVENT:
                return new LiveInfoEventViewHolder((LiveInfoEventView) from.inflate(2130905084, viewGroup, false));
            case LIVE_ANNOUNCEMENT_EVENT:
                return new LiveAnnouncementEventViewHolder((LiveAnnouncementEventView) from.inflate(2130905064, viewGroup, false));
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
    }

    public final void m3222a(ViewHolder viewHolder, int i) {
        LiveEventModel liveEventModel = (LiveEventModel) this.f2938e.get(i);
        switch (liveEventModel.mo118a()) {
            case LIVE_COMMENT_EVENT:
                m3212a((LiveCommentEventModel) liveEventModel, (LiveCommentEventViewHolder) viewHolder);
                return;
            case LIVE_WATCH_EVENT:
                m3216a((LiveWatchEventModel) liveEventModel, (LiveHighlightedEventViewHolder) viewHolder);
                return;
            case LIVE_SUBSCRIBE_EVENT:
                m3215a((LiveSubscribeEventModel) liveEventModel, (LiveSubscribeEventViewHolder) viewHolder);
                return;
            case LIVE_LIKE_EVENT:
                m3214a((LiveLikeEventModel) liveEventModel, (LiveHighlightedEventViewHolder) viewHolder);
                return;
            case LIVE_INFO_EVENT:
                ((LiveInfoEventViewHolder) viewHolder).m22499w().setInfoType(((LiveInfoEventModel) liveEventModel).f18891a);
                return;
            case LIVE_ANNOUNCEMENT_EVENT:
                ((LiveAnnouncementEventViewHolder) viewHolder).m3131w().setAnnouncementEvent((LiveAnnouncementEventModel) liveEventModel);
                return;
            default:
                throw new IllegalArgumentException("Unsupported type");
        }
    }

    public final int aZ_() {
        return this.f2938e.size();
    }

    public final void m3226a(List<LiveEventModel> list) {
        if (!list.isEmpty()) {
            this.f2938e.addAll(list);
            m3219g();
            c(this.f2938e.size() - list.size(), list.size());
        }
    }

    public final void m3224a(LiveEventModel liveEventModel) {
        this.f2938e.add(liveEventModel);
        m3219g();
        k_(this.f2938e.size() - 1);
    }

    private void m3219g() {
        int size = this.f2938e.size() - 75;
        if (size > 0) {
            this.f2938e.subList(0, size).clear();
            d(0, size);
        }
    }

    public final void m3227d() {
        int size = this.f2938e.size();
        this.f2938e.clear();
        d(0, size);
    }

    public final boolean m3228f() {
        if (m3220h()) {
            LiveCommentsMenuHelper liveCommentsMenuHelper = (LiveCommentsMenuHelper) this.f2941h.get();
            Object obj = (liveCommentsMenuHelper.f2900f == null || !liveCommentsMenuHelper.f2900f.r) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final void mo129a(View view, int i) {
        LiveCommentsMenuHelper liveCommentsMenuHelper = (LiveCommentsMenuHelper) this.f2941h.get();
        LiveCommentEventModel liveCommentEventModel = (LiveCommentEventModel) this.f2938e.get(i);
        Context context = view.getContext();
        liveCommentsMenuHelper.f2901g = this;
        liveCommentsMenuHelper.f2900f = new FigPopoverMenuWindow(context, 1);
        PopoverMenu c = liveCommentsMenuHelper.f2900f.c();
        c.a(context.getString(2131232696)).setOnMenuItemClickListener(new C02521(liveCommentsMenuHelper, this, liveCommentEventModel));
        c.a(context.getResources().getString(2131232697, new Object[]{liveCommentEventModel.f2848k.f2902a})).setOnMenuItemClickListener(new C02532(liveCommentsMenuHelper, this, liveCommentEventModel));
        c.a(context.getString(2131230727));
        liveCommentsMenuHelper.f2900f.a(view, view.getWidth(), 0, view.getWidth(), view.getHeight());
        liveCommentsMenuHelper.f2900f.d();
    }

    public final void m3225a(String str, boolean z) {
        for (int i = 0; i < this.f2938e.size(); i++) {
            LiveEventModel liveEventModel = (LiveEventModel) this.f2938e.get(i);
            if (liveEventModel.mo118a() == LiveEventType.LIVE_COMMENT_EVENT && ((LiveCommentEventModel) liveEventModel).f2848k.f2903b.equals(str)) {
                ((LiveCommentEventModel) liveEventModel).f2857i = z;
                j_(i);
            }
        }
        if (z && this.f2943j != null) {
            this.f2943j.mo145a(str);
        }
    }

    private void m3212a(final LiveCommentEventModel liveCommentEventModel, final LiveCommentEventViewHolder liveCommentEventViewHolder) {
        m3213a((LiveEventWithAuthorModel) liveCommentEventModel, (LiveEventAvatarViewHolder) liveCommentEventViewHolder);
        CharSequence a = m3210a(liveCommentEventModel, this.f2945l != Mode.WATCHING_VOD);
        if (liveCommentEventModel.f2858j) {
            liveCommentEventViewHolder.f2867l.setText(TextUtils.concat(new CharSequence[]{a, liveCommentEventModel.f2849a}));
            liveCommentEventViewHolder.f2867l.setOnClickListener(null);
            liveCommentEventViewHolder.f2867l.setClickable(false);
        } else {
            liveCommentEventViewHolder.f2867l.setText(TextUtils.concat(new CharSequence[]{a, liveCommentEventModel.f2850b, "… ", this.f2939f}));
            liveCommentEventViewHolder.f2867l.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LiveEventsListAdapter f2926c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 2007531767);
                    liveCommentEventModel.f2858j = true;
                    this.f2926c.j_(liveCommentEventViewHolder.e());
                    Logger.a(2, EntryType.UI_INPUT_END, -1310310542, a);
                }
            });
        }
        if (!liveCommentEventModel.f2854f || liveCommentEventModel.f2857i) {
            liveCommentEventViewHolder.f2868m.setOnClickListener(null);
            liveCommentEventViewHolder.f2868m.setVisibility(8);
        } else {
            liveCommentEventViewHolder.f2868m.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LiveEventsListAdapter f2929c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1876753294);
                    liveCommentEventViewHolder.m3155w().m3154a(!liveCommentEventModel.f2853e);
                    LiveCommentLikeHelper liveCommentLikeHelper = this.f2929c.f2936c;
                    LiveCommentEventModel liveCommentEventModel = liveCommentEventModel;
                    Preconditions.a(liveCommentEventModel.f2851c);
                    Preconditions.a(liveCommentEventModel.f2852d);
                    Builder builder = new Builder();
                    builder.v = liveCommentEventModel.f2851c;
                    builder = builder;
                    builder.A = liveCommentEventModel.f2852d;
                    liveCommentLikeHelper.f2873b.m2218a(builder.j(liveCommentEventModel.f2853e).f(liveCommentEventModel.f2854f).a(), liveCommentLikeHelper.f2874c, false, new C02481(liveCommentLikeHelper, liveCommentEventModel));
                    LogUtils.a(1569931971, a);
                }
            });
            liveCommentEventViewHolder.m3155w().m3154a(liveCommentEventModel.f2853e);
            liveCommentEventViewHolder.f2868m.setVisibility(0);
        }
        if (m3220h()) {
            liveCommentEventViewHolder.m3155w().setIsBlocked(liveCommentEventModel.f2857i);
            liveCommentEventViewHolder.m3155w().setIsBroadcaster(liveCommentEventModel.f2848k.f2903b.equals(this.f2944k));
        }
    }

    private void m3216a(LiveWatchEventModel liveWatchEventModel, LiveHighlightedEventViewHolder liveHighlightedEventViewHolder) {
        m3213a((LiveEventWithAuthorModel) liveWatchEventModel, (LiveEventAvatarViewHolder) liveHighlightedEventViewHolder);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f2935b);
        if (liveWatchEventModel.f18988b) {
            switch (liveWatchEventModel.f18987a.size()) {
                case 1:
                    styledStringBuilder.a(this.f2935b.getString(2131232680));
                    m3211a(1, liveWatchEventModel.f18987a, styledStringBuilder);
                    break;
                case 2:
                    styledStringBuilder.a(this.f2935b.getString(2131232681));
                    m3211a(1, liveWatchEventModel.f18987a, styledStringBuilder);
                    m3211a(2, liveWatchEventModel.f18987a, styledStringBuilder);
                    break;
                default:
                    int size = liveWatchEventModel.f18987a.size() - 2;
                    styledStringBuilder.a(this.f2935b.getQuantityString(2131689511, size));
                    m3211a(1, liveWatchEventModel.f18987a, styledStringBuilder);
                    m3211a(2, liveWatchEventModel.f18987a, styledStringBuilder);
                    if (size != 1) {
                        styledStringBuilder.a("%3$d", m3218b(String.valueOf(size)));
                        break;
                    } else {
                        m3211a(3, liveWatchEventModel.f18987a, styledStringBuilder);
                        break;
                    }
            }
        }
        styledStringBuilder.a(this.f2935b.getString(2131232679));
        m3211a(1, liveWatchEventModel.f18987a, styledStringBuilder);
        liveHighlightedEventViewHolder.f18890l.setText(styledStringBuilder.b());
    }

    private void m3215a(final LiveSubscribeEventModel liveSubscribeEventModel, final LiveSubscribeEventViewHolder liveSubscribeEventViewHolder) {
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f2935b);
        if (this.f2934a.a(ExperimentsForVideoHomeAbTestModule.p, false)) {
            styledStringBuilder.a(this.f2935b.getString(2131232690));
        } else {
            styledStringBuilder.a(this.f2935b.getString(2131232689));
        }
        m3211a(1, ImmutableList.of(liveSubscribeEventModel.f2848k), styledStringBuilder);
        liveSubscribeEventViewHolder.f18940l.setText(styledStringBuilder.b());
        liveSubscribeEventViewHolder.m22535w().m22534a(liveSubscribeEventModel.f18935b);
        liveSubscribeEventViewHolder.f18941m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LiveEventsListAdapter f2932c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1914834608);
                liveSubscribeEventModel.f18935b = !liveSubscribeEventModel.f18935b;
                this.f2932c.f2937d.a(liveSubscribeEventModel.f18934a, liveSubscribeEventModel.f2848k.f2903b, liveSubscribeEventModel.f18935b, "in_live_experience");
                this.f2932c.j_(liveSubscribeEventViewHolder.e());
                LogUtils.a(1370551088, a);
            }
        });
        this.f2940g.a(liveSubscribeEventModel.f18934a, liveSubscribeEventModel.f2848k.f2903b, "in_live_experience", true);
    }

    private void m3214a(LiveLikeEventModel liveLikeEventModel, LiveHighlightedEventViewHolder liveHighlightedEventViewHolder) {
        m3213a((LiveEventWithAuthorModel) liveLikeEventModel, (LiveEventAvatarViewHolder) liveHighlightedEventViewHolder);
        boolean equals = this.f2942i.equals(liveLikeEventModel.f18895b.f2848k.f2903b);
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f2935b);
        ImmutableList of = ImmutableList.of(liveLikeEventModel.f18894a, liveLikeEventModel.f18895b.f2848k);
        if (equals) {
            styledStringBuilder.a(this.f2935b.getString(2131232682));
            m3211a(1, of, styledStringBuilder);
            styledStringBuilder.a("%2$s", liveLikeEventModel.f18895b.f2849a);
        } else {
            styledStringBuilder.a(this.f2935b.getString(2131232683));
            m3211a(1, of, styledStringBuilder);
            m3211a(2, of, styledStringBuilder);
            styledStringBuilder.a("%3$s", liveLikeEventModel.f18895b.f2849a);
        }
        liveHighlightedEventViewHolder.f18890l.setText(styledStringBuilder.b());
    }

    private void m3213a(LiveEventWithAuthorModel liveEventWithAuthorModel, LiveEventAvatarViewHolder liveEventAvatarViewHolder) {
        UserKey b = UserKey.b(liveEventWithAuthorModel.f2848k.f2903b);
        TileBadge tileBadge = TileBadge.NONE;
        if (liveEventWithAuthorModel.f2848k.f2903b.equals(this.f2944k)) {
            tileBadge = TileBadge.BROADCASTER;
        } else if (liveEventWithAuthorModel.f2848k.f2904c) {
            tileBadge = TileBadge.VERIFIED;
        }
        liveEventAvatarViewHolder.f2866o.setParams(UserTileViewParams.a(b, tileBadge));
    }

    private CharSequence m3218b(String str) {
        CharSequence spannableString = new SpannableString(str);
        for (Object span : FacecastUiUtil.m3102a(this.f2935b, this.f2948o)) {
            spannableString.setSpan(span, 0, spannableString.length(), 33);
        }
        return spannableString;
    }

    private CharSequence m3210a(LiveCommentEventModel liveCommentEventModel, boolean z) {
        if (z) {
            return TextUtils.concat(new CharSequence[]{m3218b(liveCommentEventModel.f2848k.f2902a), " "});
        }
        CharSequence charSequence;
        CharSequence[] charSequenceArr = new CharSequence[5];
        charSequenceArr[0] = m3218b(liveCommentEventModel.f2848k.f2902a);
        charSequenceArr[1] = " ";
        boolean z2 = liveCommentEventModel.f2855g;
        if (this.f2946m == null) {
            this.f2946m = FacecastUiUtil.m3099a(true, this.f2935b);
        }
        if (this.f2947n == null) {
            this.f2947n = FacecastUiUtil.m3099a(false, this.f2935b);
        }
        if (z2) {
            charSequence = this.f2946m;
        } else {
            charSequence = this.f2947n;
        }
        charSequenceArr[2] = charSequence;
        charSequence = new SpannableString(Utils.a(((long) liveCommentEventModel.f2856h) * 1000));
        charSequence.setSpan(new ForegroundColorSpan(this.f2935b.getColor(2131362613)), 0, charSequence.length(), 33);
        charSequenceArr[3] = charSequence;
        charSequenceArr[4] = "\n";
        return TextUtils.concat(charSequenceArr);
    }

    private void m3211a(int i, List<LiveEventAuthor> list, StyledStringBuilder styledStringBuilder) {
        FacecastUiUtil.m3103a(i, ((LiveEventAuthor) list.get(i - 1)).f2902a, FacecastUiUtil.m3102a(this.f2935b, this.f2948o), styledStringBuilder);
    }

    private boolean m3220h() {
        return this.f2945l == Mode.BROADCASTING || this.f2942i.equals(this.f2944k);
    }
}

package com.facebook.facecastdisplay;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.util.ContextUtils;
import com.facebook.facecastdisplay.LiveEventCommentDialogFragment.CommentDialogFragmentListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feedback.ui.FeedbackControllerParams;
import com.facebook.feedback.ui.FeedbackControllerProvider;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterEditTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: story_permalink_opened */
public class LiveEventCommentComposer extends CustomLinearLayout {
    @Inject
    public FeedbackControllerProvider f2907a;
    @Nullable
    private final Activity f2908b;
    private final CommentDialogFragmentListener f2909c;
    @Nullable
    private GraphQLFeedback f2910d;
    @Nullable
    private FeedbackLoggingParams f2911e;
    @Nullable
    public LiveEventCommentComposerListener f2912f;
    @Nullable
    private LiveEventCommentDialogFragment f2913g;
    @Nullable
    public boolean f2914h;
    @Nullable
    public float f2915i;
    private int f2916j;
    private BetterEditTextView f2917k;

    /* compiled from: story_permalink_opened */
    class C02551 implements CommentDialogFragmentListener {
        final /* synthetic */ LiveEventCommentComposer f2905a;

        C02551(LiveEventCommentComposer liveEventCommentComposer) {
            this.f2905a = liveEventCommentComposer;
        }

        public final void mo128a(String str) {
            this.f2905a.m3198a(str);
            if (this.f2905a.f2912f != null) {
                this.f2905a.f2912f.mo1443a(str);
            }
        }

        public final void mo127a() {
            if (this.f2905a.f2912f != null) {
                this.f2905a.f2912f.mo1444b();
            }
        }
    }

    /* compiled from: story_permalink_opened */
    class C02562 implements OnClickListener {
        final /* synthetic */ LiveEventCommentComposer f2906a;

        C02562(LiveEventCommentComposer liveEventCommentComposer) {
            this.f2906a = liveEventCommentComposer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 939633639);
            this.f2906a.m3199a();
            Logger.a(2, EntryType.UI_INPUT_END, 1875505835, a);
        }
    }

    /* compiled from: story_permalink_opened */
    public interface LiveEventCommentComposerListener {
        void mo1442a();

        void mo1443a(String str);

        void mo1444b();
    }

    private static <T extends View> void m3196a(Class<T> cls, T t) {
        m3197a((Object) t, t.getContext());
    }

    private static void m3197a(Object obj, Context context) {
        ((LiveEventCommentComposer) obj).f2907a = (FeedbackControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(FeedbackControllerProvider.class);
    }

    private void m3195a(FeedbackControllerProvider feedbackControllerProvider) {
        this.f2907a = feedbackControllerProvider;
    }

    public LiveEventCommentComposer(Context context) {
        this(context, null);
    }

    public LiveEventCommentComposer(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveEventCommentComposer(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2909c = new C02551(this);
        m3196a(LiveEventCommentComposer.class, (View) this);
        setContentView(2130905071);
        setOrientation(1);
        this.f2908b = m3192a(getContext());
        this.f2917k = (BetterEditTextView) findViewById(2131563463);
        this.f2917k.setOnClickListener(new C02562(this));
    }

    public void setStory(FeedProps<GraphQLStory> feedProps) {
        this.f2910d = ((GraphQLStory) feedProps.a).l();
        this.f2911e = new FeedbackLoggingParams(TrackableFeedProps.a(feedProps), "newsfeed_ufi", "video_fullscreen_player");
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 531421075);
        super.onAttachedToWindow();
        if (this.f2908b != null) {
            Window window = this.f2908b.getWindow();
            this.f2916j = window.getAttributes().softInputMode;
            window.setSoftInputMode(3);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -883263409, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -426067332);
        super.onDetachedFromWindow();
        if (this.f2908b != null) {
            this.f2908b.getWindow().setSoftInputMode(this.f2916j);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1438360852, a);
    }

    @Nullable
    private static Activity m3192a(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext instanceof Activity) {
                return (Activity) baseContext;
            }
        }
        return null;
    }

    public final void m3199a() {
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(getContext(), FragmentManagerHost.class);
        if (fragmentManagerHost != null && fragmentManagerHost.kO_().a("live_event_comment_dialog") == null) {
            if (this.f2913g == null) {
                this.f2913g = new LiveEventCommentDialogFragment();
                this.f2913g.as = this.f2909c;
            }
            this.f2913g.a(fragmentManagerHost.kO_().a(), "live_event_comment_dialog", true);
            if (this.f2912f != null) {
                this.f2912f.mo1442a();
            }
        }
    }

    public final void m3200b() {
        if (this.f2913g != null) {
            this.f2913g.b();
        }
    }

    public void setListener(LiveEventCommentComposerListener liveEventCommentComposerListener) {
        this.f2912f = liveEventCommentComposerListener;
    }

    public void setIsLiveStreaming(boolean z) {
        this.f2914h = z;
    }

    public void setTimeInVideo(float f) {
        this.f2915i = f;
    }

    private void m3198a(String str) {
        if (this.f2910d != null && this.f2911e != null) {
            this.f2907a.m5074a(FeedbackControllerParams.f4498a).m5068a(new PendingCommentInputEntry(this.f2910d.z_(), this.f2910d.j(), str, false, false, null, null, this.f2914h, (int) this.f2915i), this.f2910d, this.f2911e);
        }
    }
}

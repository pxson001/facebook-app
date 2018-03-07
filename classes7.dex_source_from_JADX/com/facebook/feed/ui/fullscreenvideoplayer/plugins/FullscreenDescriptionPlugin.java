package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import com.facebook.content.event.FbEvent;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPChromeVisibilityChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

@TargetApi(14)
/* compiled from: Timeline - internal */
public class FullscreenDescriptionPlugin extends RichVideoPlayerPlugin {
    private View f22118a;
    public FbTextView f22119b;
    private View f22120c;
    public boolean f22121d;
    private String f22122l;
    private DescriptionOnLayoutChangeListener f22123m;

    /* compiled from: Timeline - internal */
    class C18881 implements OnClickListener {
        final /* synthetic */ FullscreenDescriptionPlugin f22115a;

        C18881(FullscreenDescriptionPlugin fullscreenDescriptionPlugin) {
            this.f22115a = fullscreenDescriptionPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -150772770);
            this.f22115a.f22121d = true;
            FullscreenDescriptionPlugin.m24747e(this.f22115a);
            Logger.a(2, EntryType.UI_INPUT_END, 1023082191, a);
        }
    }

    /* compiled from: Timeline - internal */
    class ChromeVisibilityChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPChromeVisibilityChangedEvent> {
        final /* synthetic */ FullscreenDescriptionPlugin f22116a;

        public ChromeVisibilityChangedEventSubscriber(FullscreenDescriptionPlugin fullscreenDescriptionPlugin) {
            this.f22116a = fullscreenDescriptionPlugin;
        }

        public final void m24740b(FbEvent fbEvent) {
            if (!((RVPChromeVisibilityChangedEvent) fbEvent).a) {
                this.f22116a.f22121d = false;
                FullscreenDescriptionPlugin.m24747e(this.f22116a);
            }
        }

        public final Class<RVPChromeVisibilityChangedEvent> m24739a() {
            return RVPChromeVisibilityChangedEvent.class;
        }
    }

    /* compiled from: Timeline - internal */
    class DescriptionOnLayoutChangeListener implements OnLayoutChangeListener {
        final /* synthetic */ FullscreenDescriptionPlugin f22117a;

        public DescriptionOnLayoutChangeListener(FullscreenDescriptionPlugin fullscreenDescriptionPlugin) {
            this.f22117a = fullscreenDescriptionPlugin;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f22117a.f22119b.removeOnLayoutChangeListener(this);
            FullscreenDescriptionPlugin.m24745c(this.f22117a, this.f22117a.f22119b.getLineCount());
        }
    }

    public FullscreenDescriptionPlugin(Context context) {
        this(context, null);
    }

    public FullscreenDescriptionPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullscreenDescriptionPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904551);
        m24746d();
        this.f22120c.setOnClickListener(new C18881(this));
        this.f.add(new ChromeVisibilityChangedEventSubscriber(this));
    }

    private void m24746d() {
        this.f22118a = a(2131562429);
        this.f22119b = (FbTextView) a(2131560983);
        this.f22120c = a(2131562430);
    }

    protected final void m24748a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (z) {
            FeedProps feedProps = (FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps");
            int i;
            if (richVideoPlayerParams.a == null || !richVideoPlayerParams.a.f) {
                i = 0;
            } else {
                i = 1;
            }
            if (feedProps == null || r1 != 0) {
                this.f22118a.setVisibility(8);
                return;
            }
            this.f22118a.setVisibility(0);
            setDescription((GraphQLStory) feedProps.a);
            m24747e(this);
        }
    }

    public static void m24747e(FullscreenDescriptionPlugin fullscreenDescriptionPlugin) {
        if (fullscreenDescriptionPlugin.f22121d) {
            fullscreenDescriptionPlugin.f22119b.setMaxLines(Integer.MAX_VALUE);
            fullscreenDescriptionPlugin.f22120c.setVisibility(8);
        } else if (TextUtils.isEmpty(fullscreenDescriptionPlugin.f22122l)) {
            fullscreenDescriptionPlugin.f22119b.setVisibility(8);
            fullscreenDescriptionPlugin.f22120c.setVisibility(8);
        } else {
            fullscreenDescriptionPlugin.f22119b.setVisibility(0);
            fullscreenDescriptionPlugin.f22119b.setMaxLines(1);
            int lineCount = fullscreenDescriptionPlugin.f22119b.getLineCount();
            if (lineCount == 0) {
                if (fullscreenDescriptionPlugin.f22123m == null) {
                    fullscreenDescriptionPlugin.f22123m = new DescriptionOnLayoutChangeListener(fullscreenDescriptionPlugin);
                }
                fullscreenDescriptionPlugin.f22119b.addOnLayoutChangeListener(fullscreenDescriptionPlugin.f22123m);
            }
            m24745c(fullscreenDescriptionPlugin, lineCount);
        }
    }

    public static void m24745c(FullscreenDescriptionPlugin fullscreenDescriptionPlugin, int i) {
        fullscreenDescriptionPlugin.f22120c.setVisibility(i > 1 ? 0 : 8);
    }

    private void setDescription(GraphQLStory graphQLStory) {
        this.f22122l = graphQLStory == null ? null : StoryTextHelper.a(graphQLStory);
        this.f22119b.setText(this.f22122l);
    }
}

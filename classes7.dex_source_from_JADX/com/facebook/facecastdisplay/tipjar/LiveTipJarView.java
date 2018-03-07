package com.facebook.facecastdisplay.tipjar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;

/* compiled from: asset */
public class LiveTipJarView extends CustomRelativeLayout {
    private final GlyphView f19103a;
    private final LiveTipJarMetadataView f19104b;
    public final LiveTipJarDollarIconText f19105c;
    private final FbTextView f19106d;
    public LiveTipJarViewListener f19107e;

    /* compiled from: asset */
    public interface LiveTipJarViewListener {
        void mo1452d();
    }

    /* compiled from: asset */
    class C16641 implements OnClickListener {
        final /* synthetic */ LiveTipJarView f19101a;

        C16641(LiveTipJarView liveTipJarView) {
            this.f19101a = liveTipJarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1396381800);
            this.f19101a.f19105c.m22651a("USD", "0");
            Logger.a(2, EntryType.UI_INPUT_END, 632025718, a);
        }
    }

    /* compiled from: asset */
    class C16652 implements OnClickListener {
        final /* synthetic */ LiveTipJarView f19102a;

        C16652(LiveTipJarView liveTipJarView) {
            this.f19102a = liveTipJarView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1948488803);
            if (this.f19102a.f19107e != null) {
                this.f19102a.f19107e.mo1452d();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1834184035, a);
        }
    }

    public LiveTipJarView(Context context) {
        this(context, null);
    }

    public LiveTipJarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveTipJarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905091);
        this.f19104b = (LiveTipJarMetadataView) a(2131563504);
        this.f19105c = (LiveTipJarDollarIconText) a(2131563505);
        this.f19105c.m22651a("USD", "0");
        this.f19106d = (FbTextView) a(2131563506);
        this.f19106d.setOnClickListener(new C16641(this));
        this.f19103a = (GlyphView) findViewById(2131563511);
        this.f19103a.setOnClickListener(new C16652(this));
    }

    public void setListener(LiveTipJarViewListener liveTipJarViewListener) {
        this.f19107e = liveTipJarViewListener;
    }

    public void setMetadata(FeedProps<GraphQLStory> feedProps) {
        GraphQLActor b = StoryActorHelper.b((GraphQLStory) feedProps.a);
        this.f19104b.setTitle(feedProps);
        LiveTipJarMetadataView liveTipJarMetadataView = this.f19104b;
        String c = (b == null || !GraphQLActorUtil.b(b)) ? null : GraphQLActorUtil.c(b);
        liveTipJarMetadataView.setProfilePicture(c);
    }
}

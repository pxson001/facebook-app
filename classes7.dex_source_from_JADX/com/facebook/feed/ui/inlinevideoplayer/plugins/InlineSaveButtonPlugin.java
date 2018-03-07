package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.video.util.RichVideoPlayerParamsUtil;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.player.RichVideoPlayerParams;
import javax.inject.Inject;

/* compiled from: The comment could not be found */
public class InlineSaveButtonPlugin extends BaseInlineButtonPlugin {
    @Inject
    public SaveButtonUtils f22253n;

    public static void m24892a(Object obj, Context context) {
        ((InlineSaveButtonPlugin) obj).f22253n = SaveButtonUtils.a(FbInjector.get(context));
    }

    public InlineSaveButtonPlugin(Context context) {
        this(context, null);
    }

    private InlineSaveButtonPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private InlineSaveButtonPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = InlineSaveButtonPlugin.class;
        m24892a((Object) this, getContext());
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
        this.d.setImageResource(2130843226);
        this.c.setText(2131232816);
        this.b.setContentDescription(getResources().getString(2131232815));
    }

    protected final int m24894b(boolean z) {
        return z ? 2131232817 : 2131232816;
    }

    protected final void m24893a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        final FeedProps f = RichVideoPlayerParamsUtil.f(richVideoPlayerParams);
        if (f == null) {
            this.m = false;
            g();
            return;
        }
        this.m = true;
        if (d()) {
            this.b.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ InlineSaveButtonPlugin f22252b;

                public void onClick(View view) {
                    Object obj;
                    boolean z;
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 680198375);
                    InlineSaveButtonPlugin inlineSaveButtonPlugin = this.f22252b;
                    FeedProps feedProps = f;
                    if (((GraphQLStory) feedProps.a).as().m() == GraphQLSavedState.SAVED) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        inlineSaveButtonPlugin.f22253n.b(feedProps, CurationMechanism.OVERLAY_TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
                    } else {
                        inlineSaveButtonPlugin.f22253n.a(feedProps, CurationMechanism.OVERLAY_TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
                    }
                    inlineSaveButtonPlugin.k();
                    if (obj == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    inlineSaveButtonPlugin.a(z);
                    Logger.a(2, EntryType.UI_INPUT_END, 1701983487, a);
                }
            });
            if (z) {
                this.b.setVisibility(0);
                this.c.setVisibility(0);
            }
            a(((GraphQLStory) f.a).as().m() == GraphQLSavedState.SAVED);
        }
    }
}

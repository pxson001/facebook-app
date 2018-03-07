package com.facebook.feed.ui.inlinevideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.feed.ui.fullscreenvideoplayer.plugins.CallToActionEndscreenBasePlugin;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: default_image_scale */
public class InlineCallToActionEndscreenPlugin extends CallToActionEndscreenBasePlugin {
    @Inject
    public CallToActionUtil f14132m;
    private final OnClickListener f14133n;
    public OnClickListener f14134o;

    /* compiled from: default_image_scale */
    class C06541 implements OnClickListener {
        final /* synthetic */ InlineCallToActionEndscreenPlugin f14156a;

        C06541(InlineCallToActionEndscreenPlugin inlineCallToActionEndscreenPlugin) {
            this.f14156a = inlineCallToActionEndscreenPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2008053271);
            this.f14156a.m14960k();
            if (this.f14156a.f14134o != null) {
                this.f14156a.f14134o.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1438967026, a);
        }
    }

    public static void m14945a(Object obj, Context context) {
        ((InlineCallToActionEndscreenPlugin) obj).f14132m = CallToActionUtil.b(FbInjector.get(context));
    }

    public InlineCallToActionEndscreenPlugin(Context context) {
        this(context, null);
    }

    private InlineCallToActionEndscreenPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private InlineCallToActionEndscreenPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14133n = new C06541(this);
        Class cls = InlineCallToActionEndscreenPlugin.class;
        m14945a(this, getContext());
        this.f14134o = null;
    }

    protected final boolean mo1010a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        return graphQLStoryAttachment != null && this.f14132m.c(graphQLStoryAttachment);
    }

    protected OnClickListener getCallToActionEndscreenReplayClickListener() {
        return this.f14133n;
    }

    protected final boolean mo1011f() {
        return false;
    }
}

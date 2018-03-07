package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecastdisplay.streamingreactions.StreamingReactionsView;
import javax.annotation.Nullable;

/* compiled from: bookmark_add_to_favorites */
public class FacecastStreamingReactionsPlugin extends FacecastBasePlugin {
    public final StreamingReactionsView f18522c;

    public FacecastStreamingReactionsPlugin(Context context) {
        this(context, null);
    }

    private FacecastStreamingReactionsPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastStreamingReactionsPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904230);
        this.f18522c = (StreamingReactionsView) a(2131561710);
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        this.f18522c.m4152g();
    }
}

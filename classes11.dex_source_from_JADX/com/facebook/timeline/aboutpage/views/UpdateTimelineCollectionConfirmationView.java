package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces.SavableTimelineAppCollection;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.privacy.ui.DefaultPrivacyScopeResourceResolver;
import com.facebook.story.UpdateTimelineAppCollectionParams.Action;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Object; */
public class UpdateTimelineCollectionConfirmationView extends CustomLinearLayout {
    @Inject
    public DefaultPrivacyScopeResourceResolver f13954a;
    @Inject
    public GlyphColorizer f13955b;
    private final TextView f13956c;
    private final TextView f13957d;
    private final ImageView f13958e;

    private static <T extends View> void m15073a(Class<T> cls, T t) {
        m15074a((Object) t, t.getContext());
    }

    private static void m15074a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        UpdateTimelineCollectionConfirmationView updateTimelineCollectionConfirmationView = (UpdateTimelineCollectionConfirmationView) obj;
        DefaultPrivacyScopeResourceResolver a = DefaultPrivacyScopeResourceResolver.a(fbInjector);
        GlyphColorizer a2 = GlyphColorizer.a(fbInjector);
        updateTimelineCollectionConfirmationView.f13954a = a;
        updateTimelineCollectionConfirmationView.f13955b = a2;
    }

    public UpdateTimelineCollectionConfirmationView(Context context) {
        this(context, null);
    }

    public UpdateTimelineCollectionConfirmationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15073a(UpdateTimelineCollectionConfirmationView.class, (View) this);
        setContentView(2130904287);
        setOrientation(0);
        setVisibility(8);
        setGravity(16);
        this.f13956c = (TextView) a(2131561887);
        this.f13957d = (TextView) a(2131561888);
        this.f13958e = (ImageView) a(2131561889);
        TrackingNodes.a(this, TrackingNode.COLLECTION_ACTION_LINK);
    }

    public final void m15075a(SavableTimelineAppCollection savableTimelineAppCollection, Action action) {
        if (this.f13956c != null && this.f13957d != null && this.f13958e != null && savableTimelineAppCollection != null && savableTimelineAppCollection.d() != null && !Strings.isNullOrEmpty(savableTimelineAppCollection.d().k())) {
            CharSequence a;
            if (action == Action.ADD) {
                a = StringFormatUtil.a(getContext().getString(2131233588), new Object[]{savableTimelineAppCollection.c()});
                this.f13958e.setBackgroundDrawable(this.f13955b.a(this.f13954a.a(savableTimelineAppCollection.d().k()), -7235677));
                this.f13957d.setVisibility(0);
                this.f13958e.setVisibility(0);
            } else if (action == Action.REMOVE) {
                a = StringFormatUtil.a(getContext().getString(2131233589), new Object[]{savableTimelineAppCollection.c()});
                this.f13957d.setVisibility(8);
                this.f13958e.setVisibility(8);
            } else {
                return;
            }
            this.f13956c.setText(a);
            setVisibility(0);
        }
    }

    public final void m15076a(Action action) {
        int i = action == Action.ADD ? 2131233590 : 2131233591;
        this.f13957d.setVisibility(8);
        this.f13958e.setVisibility(8);
        this.f13956c.setText(getContext().getString(i));
        setVisibility(0);
    }
}

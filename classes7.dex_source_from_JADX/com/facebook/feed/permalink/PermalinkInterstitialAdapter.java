package com.facebook.feed.permalink;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.feed.nux.PrivacyEducationInterstitialController;
import com.facebook.feedback.ui.Bindable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.privacy.ui.PrivacyEducationBannerView;
import com.facebook.story.GraphQLStoryHelper;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.inject.Inject;

/* compiled from: after_cursor */
public class PermalinkInterstitialAdapter extends FbBaseAdapter implements Bindable<GraphQLStory> {
    private InterstitialManager f19592a;
    private GraphQLStory f19593b;
    private PrivacyEducationInterstitialController f19594c;

    /* compiled from: after_cursor */
    enum InterstitialRowType {
        PRIVACY_EDUCATION,
        UNKNOWN
    }

    public static PermalinkInterstitialAdapter m22892a(InjectorLike injectorLike) {
        return new PermalinkInterstitialAdapter(InterstitialManager.a(injectorLike));
    }

    @Inject
    public PermalinkInterstitialAdapter(InterstitialManager interstitialManager) {
        this.f19592a = interstitialManager;
    }

    public final View m22893a(int i, ViewGroup viewGroup) {
        switch (InterstitialRowType.values()[i]) {
            case PRIVACY_EDUCATION:
                if (this.f19594c != null) {
                    return new PrivacyEducationBannerView(viewGroup.getContext());
                }
                break;
        }
        return null;
    }

    public final void m22894a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        switch (InterstitialRowType.values()[i2]) {
            case PRIVACY_EDUCATION:
                if (GraphQLStoryHelper.c(this.f19593b) != null) {
                    ((PrivacyEducationBannerView) view).a(GraphQLStoryHelper.c(this.f19593b).k(), this.f19593b.c());
                    return;
                }
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int i) {
        if (this.f19594c != null) {
            return InterstitialRowType.PRIVACY_EDUCATION.ordinal();
        }
        return InterstitialRowType.UNKNOWN.ordinal();
    }

    public int getViewTypeCount() {
        return InterstitialRowType.values().length;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return this.f19594c == null ? 0 : 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m22895a(com.facebook.graphql.model.GraphQLStory r6) {
        /*
        r5 = this;
        r1 = r5.getCount();
        r5.f19593b = r6;
        r0 = r5.f19592a;
        r2 = new com.facebook.interstitial.manager.InterstitialTrigger;
        r3 = com.facebook.interstitial.manager.InterstitialTrigger.Action.PERMALINK_STORY_OPEN;
        r2.<init>(r3);
        r3 = com.facebook.feed.nux.PrivacyEducationInterstitialController.class;
        r0 = r0.a(r2, r3);
        r0 = (com.facebook.feed.nux.PrivacyEducationInterstitialController) r0;
        r5.f19594c = r0;
        r0 = r5.f19594c;
        if (r0 == 0) goto L_0x0026;
    L_0x001d:
        r0 = r5.f19594c;
        r4 = com.facebook.privacy.nux.PrivacyEducationBannerController.a(r6);
        r0 = r4;
        if (r0 != 0) goto L_0x0029;
    L_0x0026:
        r0 = 0;
        r5.f19594c = r0;
    L_0x0029:
        r0 = r5.getCount();
        if (r1 == r0) goto L_0x0035;
    L_0x002f:
        r0 = -1588635119; // 0xffffffffa14f5a11 float:-7.025353E-19 double:NaN;
        com.facebook.tools.dextr.runtime.detour.AdapterDetour.a(r5, r0);
    L_0x0035:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.permalink.PermalinkInterstitialAdapter.a(com.facebook.graphql.model.GraphQLStory):void");
    }
}

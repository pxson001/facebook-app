package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.CallToActionWrapper;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CallToActionChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.CreativeChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UrlVisibilityEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.CreativeAdModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.ui.EditableRadioGroup.OnCheckedChangeRadioGroupListener;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: VALID_FBID_RETURNED */
public class AdInterfacesCallToActionViewController extends BaseAdInterfacesViewController<AdInterfacesCallToActionView, AdInterfacesLocalAwarenessDataModel> {
    private static final ImmutableList<GraphQLCallToActionType> f22620a = ImmutableList.of(GraphQLCallToActionType.GET_DIRECTIONS, GraphQLCallToActionType.CALL_NOW, GraphQLCallToActionType.MESSAGE_PAGE, GraphQLCallToActionType.LEARN_MORE, GraphQLCallToActionType.NO_BUTTON);
    private Context f22621b;
    public AdInterfacesCardLayout f22622c;
    private AdInterfacesCallToActionView f22623d;
    public GraphQLCallToActionType f22624e;
    public AdInterfacesLocalAwarenessDataModel f22625f;
    public AdInterfacesContext f22626g;
    private CreativeChangedEvent f22627h;

    /* compiled from: VALID_FBID_RETURNED */
    class C25971 implements OnCheckedChangeRadioGroupListener {
        final /* synthetic */ AdInterfacesCallToActionViewController f22618a;

        C25971(AdInterfacesCallToActionViewController adInterfacesCallToActionViewController) {
            this.f22618a = adInterfacesCallToActionViewController;
        }

        public final void mo1006a(EditableRadioGroup editableRadioGroup, int i) {
            this.f22618a.m24550a((GraphQLCallToActionType) editableRadioGroup.findViewById(i).getTag());
        }
    }

    /* compiled from: VALID_FBID_RETURNED */
    class C25982 extends TargetingChangedSubscriber {
        final /* synthetic */ AdInterfacesCallToActionViewController f22619a;

        C25982(AdInterfacesCallToActionViewController adInterfacesCallToActionViewController) {
            this.f22619a = adInterfacesCallToActionViewController;
        }

        public final void m24546b(FbEvent fbEvent) {
            AdInterfacesCallToActionViewController.m24551a(this.f22619a.f22626g, this.f22619a.f22624e, this.f22619a.f22622c, this.f22619a.f22625f);
        }
    }

    private static AdInterfacesCallToActionViewController m24552b() {
        return new AdInterfacesCallToActionViewController();
    }

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesCallToActionView adInterfacesCallToActionView = (AdInterfacesCallToActionView) view;
        super.mo982a(adInterfacesCallToActionView, adInterfacesCardLayout);
        this.f22621b = adInterfacesCallToActionView.getContext();
        this.f22623d = adInterfacesCallToActionView;
        int size = f22620a.size();
        for (int i = 0; i < size; i++) {
            GraphQLCallToActionType graphQLCallToActionType = (GraphQLCallToActionType) f22620a.get(i);
            if (CallToActionWrapper.fromGraphQLTypeCallToAction(graphQLCallToActionType).isAvailable(this.f22625f)) {
                this.f22623d.m24543a(graphQLCallToActionType);
            }
        }
        this.f22622c = adInterfacesCardLayout;
        adInterfacesCallToActionView.setOnCheckedChangeListener(new C25971(this));
        this.f22626g = this.f22440b;
        this.f22623d.setCallToActionType(this.f22625f.mo951C().f21774g);
        this.f22626g.m22430a(new C25982(this));
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22625f = (AdInterfacesLocalAwarenessDataModel) baseAdInterfacesData;
        Preconditions.checkNotNull(this.f22625f.mo951C());
    }

    public static AdInterfacesCallToActionViewController m24548a(InjectorLike injectorLike) {
        return m24552b();
    }

    public final void mo981a() {
        super.mo981a();
        this.f22621b = null;
        this.f22622c = null;
        this.f22623d = null;
        this.f22626g = null;
    }

    public final void mo984a(Bundle bundle) {
        bundle.putSerializable("cta", this.f22624e);
    }

    public final void mo985b(Bundle bundle) {
        if (bundle != null) {
            GraphQLCallToActionType graphQLCallToActionType = (GraphQLCallToActionType) bundle.getSerializable("cta");
            if (graphQLCallToActionType != null) {
                this.f22623d.setCallToActionType(graphQLCallToActionType);
            }
        }
    }

    private void m24550a(GraphQLCallToActionType graphQLCallToActionType) {
        this.f22624e = graphQLCallToActionType;
        this.f22626g.m22429a(new CallToActionChangedEvent(graphQLCallToActionType));
        if (m24551a(this.f22626g, this.f22624e, this.f22622c, this.f22625f) && this.f22622c != null) {
            CallToActionWrapper fromGraphQLTypeCallToAction = CallToActionWrapper.fromGraphQLTypeCallToAction(graphQLCallToActionType);
            Spanned descriptionText = fromGraphQLTypeCallToAction.getDescriptionText(this.f22621b);
            CreativeAdModel C = this.f22625f.mo951C();
            String uri = fromGraphQLTypeCallToAction.getUri(this.f22625f);
            boolean z = graphQLCallToActionType == GraphQLCallToActionType.LEARN_MORE;
            C.f21775h = uri;
            C.f21774g = graphQLCallToActionType;
            if (!z) {
                uri = this.f22625f.f21808b;
            }
            C.f21771d = uri;
            this.f22626g.m22429a(new UrlVisibilityEvent(z));
            this.f22627h = new CreativeChangedEvent();
            this.f22626g.m22429a(this.f22627h);
            this.f22622c.setFooterSpannableText(descriptionText);
        }
    }

    public static boolean m24551a(AdInterfacesContext adInterfacesContext, GraphQLCallToActionType graphQLCallToActionType, AdInterfacesCardLayout adInterfacesCardLayout, AdInterfacesLocalAwarenessDataModel adInterfacesLocalAwarenessDataModel) {
        if (graphQLCallToActionType != GraphQLCallToActionType.CALL_NOW || adInterfacesLocalAwarenessDataModel.f21754j.f21722b >= 18) {
            adInterfacesContext.m22431a(AdInterfacesDataValidation.CALL_NOW_MIN_AGE, true);
            if (adInterfacesCardLayout != null) {
                adInterfacesCardLayout.setFooterSpannableText(null);
            }
            return true;
        }
        adInterfacesContext.m22431a(AdInterfacesDataValidation.CALL_NOW_MIN_AGE, false);
        adInterfacesCardLayout.setFooterSpannableText(Html.fromHtml(adInterfacesCardLayout.getResources().getString(2131234063)));
        return false;
    }
}

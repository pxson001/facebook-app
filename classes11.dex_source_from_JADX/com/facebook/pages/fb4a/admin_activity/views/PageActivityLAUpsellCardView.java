package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: quicksilver_extra_game_url */
public class PageActivityLAUpsellCardView extends CustomFrameLayout {
    private FbButton f2835a;
    public UriIntentMapper f2836b;
    public SecureContextHelper f2837c;
    private AdInterfacesExternalLogger f2838d;

    /* compiled from: quicksilver_extra_game_url */
    /* synthetic */ class C03792 {
        static final /* synthetic */ int[] f2834a = new int[GraphQLBoostedComponentStatus.values().length];

        static {
            try {
                f2834a[GraphQLBoostedComponentStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2834a[GraphQLBoostedComponentStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2834a[GraphQLBoostedComponentStatus.INACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m3806a(Class<T> cls, T t) {
        m3807a((Object) t, t.getContext());
    }

    private static void m3807a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageActivityLAUpsellCardView) obj).m3805a((UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), AdInterfacesExternalLogger.a(fbInjector));
    }

    public PageActivityLAUpsellCardView(Context context) {
        super(context);
        m3804a();
    }

    public PageActivityLAUpsellCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3804a();
    }

    public PageActivityLAUpsellCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3804a();
    }

    private void m3804a() {
        setContentView(2130905952);
        m3806a(PageActivityLAUpsellCardView.class, (View) this);
        ((ImageView) c(2131565313)).setImageResource(2130842433);
        ((FbTextView) c(2131565314)).setText(2131235090);
        ((FbTextView) c(2131565315)).setText(2131235091);
        this.f2835a = (FbButton) c(2131565316);
    }

    @Inject
    private void m3805a(UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, AdInterfacesExternalLogger adInterfacesExternalLogger) {
        this.f2836b = uriIntentMapper;
        this.f2837c = secureContextHelper;
        this.f2838d = adInterfacesExternalLogger;
    }

    public final void m3810a(final long j, @Nullable GraphQLBoostedComponentStatus graphQLBoostedComponentStatus) {
        m3809b(j, graphQLBoostedComponentStatus);
        this.f2835a.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageActivityLAUpsellCardView f2833b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1621575217);
                Intent a2 = this.f2833b.f2836b.a(this.f2833b.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.g, String.valueOf(j), "", "pages_manager_activity_tab"));
                if (a2 != null) {
                    this.f2833b.f2837c.a(a2, view.getContext());
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1022630479, a);
            }
        });
    }

    public void setPromoteLabel(String str) {
        this.f2835a.setText(str);
    }

    private void m3809b(long j, @Nullable GraphQLBoostedComponentStatus graphQLBoostedComponentStatus) {
        if (graphQLBoostedComponentStatus != null) {
            try {
                Event event;
                switch (C03792.f2834a[graphQLBoostedComponentStatus.ordinal()]) {
                    case 1:
                    case 2:
                        event = Event.EVENT_RENDER_FAIL_ENTRY_POINT;
                        break;
                    case 3:
                        event = Event.EVENT_RENDER_CREATE_ENTRY_POINT;
                        break;
                    default:
                        event = Event.EVENT_RENDER_EDIT_ENTRY_POINT;
                        break;
                }
                this.f2838d.a(BoostedComponentModule.BOOSTED_EVENT_MOBILE_MODULE, event, String.valueOf(j), "pages_manager_activity_tab");
            } catch (Exception e) {
            }
        }
    }
}

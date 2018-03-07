package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionCurationClickEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.CollectionTitleClickEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.RedirectToUriEvent;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldSectionInfoModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionWithItemsOrRequestablesModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory.ItemData;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: Ljava/util/List */
public class CollectionTitleBarView extends CustomLinearLayout {
    @Inject
    public CollectionsEventBus f13769a;
    public boolean f13770b;
    public boolean f13771c;
    public boolean f13772d;
    private final TextView f13773e;
    private final TextView f13774f;
    private final ImageView f13775g;
    private final View f13776h;
    private final View f13777i;
    private final ImageView f13778j;
    private final FbTextView f13779k;

    private static <T extends View> void m14929a(Class<T> cls, T t) {
        m14930a((Object) t, t.getContext());
    }

    private static void m14930a(Object obj, Context context) {
        ((CollectionTitleBarView) obj).f13769a = CollectionsEventBus.m13930a(FbInjector.get(context));
    }

    public CollectionTitleBarView(Context context) {
        this(context, null);
    }

    public CollectionTitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13770b = false;
        this.f13771c = false;
        this.f13772d = true;
        m14929a(CollectionTitleBarView.class, (View) this);
        setContentView(2130903603);
        this.f13773e = (TextView) findViewById(2131560398);
        this.f13774f = (TextView) findViewById(2131560399);
        this.f13775g = (ImageView) findViewById(2131560400);
        this.f13776h = findViewById(2131560397);
        this.f13777i = findViewById(2131560401);
        this.f13778j = (ImageView) findViewById(2131560402);
        this.f13779k = (FbTextView) a(2131560403);
    }

    public void setHasCurateButton(boolean z) {
        this.f13770b = z;
    }

    public void setHasEditButton(boolean z) {
        this.f13771c = z;
    }

    public void setTitleIsLink(boolean z) {
        this.f13772d = z;
    }

    private void m14931a(String str, String str2, final String str3, String str4, String str5, Bundle bundle, String str6, DefaultImageFields defaultImageFields, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions) {
        MarginLayoutParams marginLayoutParams;
        int dimension;
        if (str != null) {
            this.f13773e.setVisibility(0);
            this.f13773e.setText(str);
        } else {
            this.f13773e.setVisibility(4);
            this.f13773e.setText("");
        }
        if (this.f13773e.getVisibility() == 0 && graphQLTimelineAppSectionType != null) {
            if (graphQLTimelineAppSectionType.equals(GraphQLTimelineAppSectionType.ABOUT)) {
                this.f13773e.setTextSize((float) SizeUtil.c(getResources(), 2131427402));
                this.f13773e.setTypeface(Typeface.DEFAULT_BOLD);
                if (str2 == null) {
                    this.f13774f.setVisibility(0);
                    this.f13774f.setText(str2);
                } else {
                    this.f13774f.setVisibility(8);
                    this.f13774f.setText("");
                }
                if (this.f13772d || str5 == null) {
                    this.f13775g.setVisibility(8);
                    this.f13776h.setBackgroundColor(getResources().getColor(2131361864));
                    this.f13776h.setOnClickListener(null);
                } else {
                    this.f13775g.setVisibility(0);
                    this.f13776h.setBackgroundResource(2130843621);
                    final String str7 = str5;
                    final Bundle bundle2 = bundle;
                    final String str8 = str;
                    final CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions2 = collectionWithItemsAndSuggestions;
                    final GraphQLTimelineAppSectionType graphQLTimelineAppSectionType2 = graphQLTimelineAppSectionType;
                    final DefaultImageFields defaultImageFields2 = defaultImageFields;
                    final String str9 = str4;
                    this.f13776h.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ CollectionTitleBarView f13764h;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 618674177);
                            this.f13764h.f13769a.a(new CollectionTitleClickEvent(str7, bundle2, str8, collectionWithItemsAndSuggestions2, graphQLTimelineAppSectionType2, defaultImageFields2, str9));
                            Logger.a(2, EntryType.UI_INPUT_END, -1818201425, a);
                        }
                    });
                }
                if (this.f13770b || str6 == null) {
                    this.f13777i.setVisibility(8);
                    this.f13778j.setVisibility(8);
                    this.f13778j.setOnClickListener(null);
                } else {
                    this.f13777i.setVisibility(0);
                    this.f13778j.setVisibility(0);
                    final String str10 = str6;
                    this.f13778j.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ CollectionTitleBarView f13766b;

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 434359620);
                            this.f13766b.f13769a.a(new CollectionCurationClickEvent(str10));
                            Logger.a(2, EntryType.UI_INPUT_END, 1001367899, a);
                        }
                    });
                }
                marginLayoutParams = (MarginLayoutParams) this.f13775g.getLayoutParams();
                dimension = (int) getResources().getDimension(2131434526);
                if (this.f13778j.getVisibility() == 0) {
                    MarginLayoutParamsCompat.b(marginLayoutParams, dimension);
                } else if (this.f13774f.getVisibility() != 0) {
                    MarginLayoutParamsCompat.a(marginLayoutParams, dimension);
                } else {
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                }
                if (this.f13771c) {
                    this.f13779k.setVisibility(8);
                    this.f13779k.setOnClickListener(null);
                    return;
                }
                this.f13779k.setVisibility(0);
                this.f13779k.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ CollectionTitleBarView f13768b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -2008124398);
                        this.f13768b.f13769a.a(new RedirectToUriEvent(str3));
                        Logger.a(2, EntryType.UI_INPUT_END, 1194112921, a);
                    }
                });
            }
        }
        this.f13773e.setTextSize((float) SizeUtil.c(getResources(), 2131427404));
        this.f13773e.setTypeface(Typeface.DEFAULT);
        if (str2 == null) {
            this.f13774f.setVisibility(8);
            this.f13774f.setText("");
        } else {
            this.f13774f.setVisibility(0);
            this.f13774f.setText(str2);
        }
        if (this.f13772d) {
        }
        this.f13775g.setVisibility(8);
        this.f13776h.setBackgroundColor(getResources().getColor(2131361864));
        this.f13776h.setOnClickListener(null);
        if (this.f13770b) {
        }
        this.f13777i.setVisibility(8);
        this.f13778j.setVisibility(8);
        this.f13778j.setOnClickListener(null);
        marginLayoutParams = (MarginLayoutParams) this.f13775g.getLayoutParams();
        dimension = (int) getResources().getDimension(2131434526);
        if (this.f13778j.getVisibility() == 0) {
            MarginLayoutParamsCompat.b(marginLayoutParams, dimension);
        } else if (this.f13774f.getVisibility() != 0) {
            marginLayoutParams.setMargins(0, 0, 0, 0);
        } else {
            MarginLayoutParamsCompat.a(marginLayoutParams, dimension);
        }
        if (this.f13771c) {
            this.f13779k.setVisibility(8);
            this.f13779k.setOnClickListener(null);
            return;
        }
        this.f13779k.setVisibility(0);
        this.f13779k.setOnClickListener(/* anonymous class already generated */);
    }

    public final void m14934a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, String str, String str2, String str3, String str4, Bundle bundle, String str5, DefaultImageFields defaultImageFields, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        String str6;
        if (str != null || collectionWithItemsAndSuggestions.nS_() == null) {
            str6 = str;
        } else {
            str6 = collectionWithItemsAndSuggestions.nS_();
        }
        String str7 = null;
        if (this.f13771c && collectionWithItemsAndSuggestions.mo402o() != null) {
            str7 = collectionWithItemsAndSuggestions.mo402o();
        }
        m14931a(str6, str2, str7, str3, str4, bundle, str5, defaultImageFields, graphQLTimelineAppSectionType, collectionWithItemsAndSuggestions);
    }

    public final void m14935a(ItemData itemData) {
        String str;
        if (itemData.f13783c != null) {
            str = itemData.f13783c;
        } else {
            str = itemData.f13782b;
        }
        m14931a(str, itemData.f13784d, itemData.f13786f, itemData.f13790j, itemData.f13791k, itemData.f13792l, itemData.f13793m, itemData.f13785e, itemData.f13794n, itemData.f13787g);
    }

    public final void m14932a(ProfileFieldSectionInfoModel profileFieldSectionInfoModel) {
        m14931a(profileFieldSectionInfoModel.m14086b() == null ? null : profileFieldSectionInfoModel.m14086b().m14076a(), null, profileFieldSectionInfoModel.m14085a(), null, null, null, null, null, null, null);
    }

    public final void m14933a(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
        m14931a(collectionWithItemsOrRequestablesModel.nS_(), null, collectionsAppSectionWithItemsOrRequestablesModel.nR_(), null, collectionsAppSectionWithItemsOrRequestablesModel.mo391g(), null, null, null, collectionsAppSectionWithItemsOrRequestablesModel.nP_(), collectionWithItemsOrRequestablesModel);
    }

    public final void m14936b(CollectionsAppSectionWithItemsOrRequestablesModel collectionsAppSectionWithItemsOrRequestablesModel) {
        CollectionWithItemsOrRequestablesModel collectionWithItemsOrRequestablesModel = (CollectionWithItemsOrRequestablesModel) collectionsAppSectionWithItemsOrRequestablesModel.m14583j().m14562a().get(0);
        m14931a(collectionsAppSectionWithItemsOrRequestablesModel.m14587n() == null ? null : collectionsAppSectionWithItemsOrRequestablesModel.m14587n().m14392a(), collectionsAppSectionWithItemsOrRequestablesModel.m14586m() == null ? null : collectionsAppSectionWithItemsOrRequestablesModel.m14586m().m14387a(), collectionsAppSectionWithItemsOrRequestablesModel.nR_(), null, collectionsAppSectionWithItemsOrRequestablesModel.mo391g(), null, collectionWithItemsOrRequestablesModel.mo397b(), null, collectionsAppSectionWithItemsOrRequestablesModel.nP_(), collectionWithItemsOrRequestablesModel);
    }

    private void m14928a(CollectionsEventBus collectionsEventBus) {
        this.f13769a = collectionsEventBus;
    }
}

package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView.BufferType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.graphql.enums.GraphQLProfileFieldTextListItemHeadingType;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.DeleteExperienceEvent;
import com.facebook.timeline.aboutpage.events.CollectionsClickEvents.RedirectToUriEvent;
import com.facebook.timeline.aboutpage.events.CollectionsEventBus;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldInfoModel.MenuOptionsModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldTextListItemGroupInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.ProfileFieldTextListItemGroupInfoModel.ListItemsModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.TextWithEntitiesInfoModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.TextWithEntitiesInfoModel.RangesModel;
import com.facebook.timeline.aboutpage.protocol.AboutFieldGraphQLModels.TextWithEntitiesInfoModel.RangesModel.EntityModel;
import com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIcon;
import com.facebook.widget.popovermenuitemwithuriicon.PopoverMenuItemWithUriIconProvider;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: Ljava/lang/Throwable; */
public class ProfileExperienceView extends CustomFrameLayout {
    private static final CallerContext f13910f = CallerContext.a(ProfileExperienceView.class);
    @Inject
    LinkifyUtil f13911a;
    @Inject
    ItemLinkMovementMethod f13912b;
    @Inject
    CollectionsEventBus f13913c;
    @Inject
    PopoverMenuItemWithUriIconProvider f13914d;
    @Inject
    GraphQLLinkExtractor f13915e;
    public ContentView f13916g;
    private FbTextView f13917h;
    private FbTextView f13918i;
    private LinearLayout f13919j;
    private ImageView f13920k;
    private FbDraweeView f13921l;

    /* compiled from: Ljava/lang/Throwable; */
    /* synthetic */ class C16225 {
        static final /* synthetic */ int[] f13909a = new int[GraphQLProfileFieldTextListItemHeadingType.values().length];

        static {
            try {
                f13909a[GraphQLProfileFieldTextListItemHeadingType.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13909a[GraphQLProfileFieldTextListItemHeadingType.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13909a[GraphQLProfileFieldTextListItemHeadingType.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private static <T extends View> void m15040a(Class<T> cls, T t) {
        m15041a((Object) t, t.getContext());
    }

    private static void m15041a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ProfileExperienceView) obj).m15039a(LinkifyUtil.a(injectorLike), ItemLinkMovementMethod.m14862a(injectorLike), CollectionsEventBus.m13930a(injectorLike), (PopoverMenuItemWithUriIconProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(PopoverMenuItemWithUriIconProvider.class), GraphQLLinkExtractor.a(injectorLike));
    }

    public ProfileExperienceView(Context context) {
        super(context);
        m15037a();
    }

    public ProfileExperienceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m15037a();
    }

    public ProfileExperienceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15037a();
    }

    private void m15037a() {
        m15040a(ProfileExperienceView.class, (View) this);
        setContentView(2130906433);
        this.f13916g = (ContentView) c(2131566345);
        this.f13917h = (FbTextView) c(2131566346);
        this.f13918i = (FbTextView) c(2131566347);
        this.f13919j = (LinearLayout) c(2131566348);
        this.f13920k = (ImageView) c(2131566349);
        this.f13921l = new FbDraweeView(getContext());
        this.f13916g.setThumbnailSize(ThumbnailSize.LARGE);
        this.f13916g.setMaxLinesFromThumbnailSize(false);
        this.f13916g.setThumbnailView(this.f13921l);
        this.f13917h.setMovementMethod(this.f13912b);
    }

    public final void m15043a(final ProfileFieldInfoModel profileFieldInfoModel) {
        OnClickListener c16181 = new OnClickListener(this) {
            final /* synthetic */ ProfileExperienceView f13901b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1787562055);
                this.f13901b.f13913c.a(new RedirectToUriEvent(profileFieldInfoModel.m14049o()));
                Logger.a(2, EntryType.UI_INPUT_END, 637915013, a);
            }
        };
        this.f13916g.setOnClickListener(c16181);
        CharSequence valueOf = SpannableString.valueOf(profileFieldInfoModel.m14058x().m14031a());
        this.f13911a.a(profileFieldInfoModel.m14049o(), 0, valueOf.length(), valueOf, false, 2131363996, true, null, null);
        this.f13917h.setText(valueOf, BufferType.SPANNABLE);
        if (profileFieldInfoModel.m14048n() == null) {
            this.f13921l.setVisibility(8);
        } else {
            this.f13921l.setVisibility(0);
            this.f13921l.a(Uri.parse(profileFieldInfoModel.m14048n().m13982a()), f13910f);
        }
        this.f13919j.removeAllViews();
        StringBuilder stringBuilder = new StringBuilder();
        if (!profileFieldInfoModel.m14051q().isEmpty()) {
            int size = profileFieldInfoModel.m14051q().size();
            for (int i = 0; i < size; i++) {
                FbTextView fbTextView = new FbTextView(this.f13916g.getContext());
                CharSequence spannableStringBuilder = new SpannableStringBuilder("\n");
                int size2 = ((ProfileFieldTextListItemGroupInfoModel) profileFieldInfoModel.m14051q().get(i)).m14099a().size();
                int i2 = 0;
                while (i2 < size2) {
                    ListItemsModel listItemsModel = (ListItemsModel) ((ProfileFieldTextListItemGroupInfoModel) profileFieldInfoModel.m14051q().get(i)).m14099a().get(i2);
                    if (listItemsModel.m14095j() != null) {
                        Object j = listItemsModel.m14095j().m14141j();
                        switch (C16225.f13909a[listItemsModel.m14093a().ordinal()]) {
                            case 1:
                            case 2:
                                if (i == 0) {
                                    stringBuilder.append(listItemsModel.m14095j().m14141j());
                                    if (m15042a(i2, size2)) {
                                        stringBuilder.append("\n");
                                    }
                                }
                                SpannableString spannableString = new SpannableString(j);
                                if (!listItemsModel.m14095j().m14140a().isEmpty()) {
                                    m15038a(spannableString, listItemsModel.m14095j());
                                    spannableStringBuilder.append(spannableString);
                                    if (m15042a(i2, size2)) {
                                        spannableStringBuilder.append("\n");
                                        break;
                                    }
                                }
                                spannableStringBuilder.append(j);
                                break;
                                break;
                            case 3:
                                spannableStringBuilder.append(j.toUpperCase(Locale.getDefault()));
                                break;
                            default:
                                spannableStringBuilder.append(j);
                                break;
                        }
                        if (m15042a(i, size) || m15042a(i2, size2)) {
                            spannableStringBuilder.append("\n");
                        }
                    }
                    i2++;
                }
                if (i > 0) {
                    fbTextView.setText(spannableStringBuilder, BufferType.SPANNABLE);
                    fbTextView.setMovementMethod(this.f13912b);
                    fbTextView.setTextColor(getResources().getColor(2131361932));
                    fbTextView.setOnClickListener(c16181);
                    this.f13919j.addView(fbTextView);
                    if (m15042a(i, size)) {
                        this.f13919j.addView(getHorizontalDivider());
                    }
                }
            }
        }
        this.f13918i.setText(stringBuilder.toString());
        final ImageView imageView = (ImageView) findViewById(2131566349);
        if (profileFieldInfoModel.m14052r() == null || profileFieldInfoModel.m14052r().isEmpty()) {
            imageView.setVisibility(8);
            return;
        }
        this.f13920k.setVisibility(0);
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProfileExperienceView f13904c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1445147984);
                this.f13904c.m15035a(profileFieldInfoModel.m14052r(), this.f13904c.f13916g.getContext()).f(imageView);
                Logger.a(2, EntryType.UI_INPUT_END, 832731281, a);
            }
        });
    }

    private PopoverMenuWindow m15035a(ImmutableList<MenuOptionsModel> immutableList, Context context) {
        PopoverMenuWindow popoverMenuWindow = new PopoverMenuWindow(context);
        PopoverMenu c = popoverMenuWindow.c();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MenuOptionsModel menuOptionsModel = (MenuOptionsModel) immutableList.get(i);
            if (menuOptionsModel.m14008k() != null) {
                PopoverMenuItemWithUriIcon a = this.f13914d.a(c, menuOptionsModel.m14008k().m14003a());
                final String l = menuOptionsModel.m14009l();
                if (menuOptionsModel.m14007j() == null || menuOptionsModel.m14007j().m13997j() == null) {
                    a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ ProfileExperienceView f13908b;

                        public boolean onMenuItemClick(MenuItem menuItem) {
                            this.f13908b.f13913c.a(new RedirectToUriEvent(l));
                            return true;
                        }
                    });
                } else {
                    l = menuOptionsModel.m14007j().m13997j();
                    a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ ProfileExperienceView f13906b;

                        public boolean onMenuItemClick(MenuItem menuItem) {
                            this.f13906b.f13913c.a(new DeleteExperienceEvent(l));
                            return true;
                        }
                    });
                }
                if (menuOptionsModel.m14006a() == null || menuOptionsModel.m14006a().m13988a() == null) {
                    a.a("");
                } else {
                    a.a(menuOptionsModel.m14006a().m13988a().toString());
                }
                c.a(a);
            }
        }
        return popoverMenuWindow;
    }

    private void m15039a(LinkifyUtil linkifyUtil, ItemLinkMovementMethod itemLinkMovementMethod, CollectionsEventBus collectionsEventBus, PopoverMenuItemWithUriIconProvider popoverMenuItemWithUriIconProvider, GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f13911a = linkifyUtil;
        this.f13912b = itemLinkMovementMethod;
        this.f13913c = collectionsEventBus;
        this.f13914d = popoverMenuItemWithUriIconProvider;
        this.f13915e = graphQLLinkExtractor;
    }

    private static boolean m15042a(int i, int i2) {
        return i < i2 + -1;
    }

    private View getHorizontalDivider() {
        return LayoutInflater.from(getContext()).inflate(2130906432, this.f13919j, false);
    }

    private void m15038a(SpannableString spannableString, TextWithEntitiesInfoModel textWithEntitiesInfoModel) {
        ImmutableList a = textWithEntitiesInfoModel.m14140a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            RangesModel rangesModel = (RangesModel) a.get(i);
            EntityModel a2 = rangesModel.m14133a();
            String a3 = this.f13915e.a(a2.m14127j(), new Object[]{a2.m14128k(), null});
            LinkifyUtil linkifyUtil = this.f13911a;
            if (a3 == null) {
                a3 = a2.m14129l();
            }
            linkifyUtil.a(a3, rangesModel.m14136k(), rangesModel.m14135j() + rangesModel.m14136k(), spannableString, false, 2131363996, true, null, null);
        }
    }
}

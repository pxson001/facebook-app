package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.graphql.enums.GraphQLTimelineContactItemType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.inforequest.event.InfoRequestEventBus;
import com.facebook.profile.inforequest.event.InfoRequestEvents.SendInfoRequestEvent;
import com.facebook.profile.inforequest.services.InfoRequestHelper;
import com.facebook.profile.inforequest.services.InfoRequestHelper.Callback;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomRelativeLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Ljava/util/HashMap */
public class ContactListCollectionItemView extends CustomRelativeLayout implements ICollectionItemView {
    public InfoRequestEventBus f13813a;
    private SecureContextHelper f13814b;
    private Provider<BlueServiceOperationFactory> f13815c;
    public Toaster f13816d;
    private Executor f13817e;
    public CollectionsAppSectionRequestableFieldModel f13818f;
    public ProfileViewerContext f13819g;
    public GraphQLTimelineAppSectionType f13820h;
    private final OnClickListener f13821i;
    private final OnClickListener f13822j;

    /* compiled from: Ljava/util/HashMap */
    class C16051 implements OnClickListener {
        final /* synthetic */ ContactListCollectionItemView f13804a;

        C16051(ContactListCollectionItemView contactListCollectionItemView) {
            this.f13804a = contactListCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2014015752);
            this.f13804a.f13813a.a(new SendInfoRequestEvent(this.f13804a.f13819g.e, this.f13804a.f13818f.m14547a()));
            Logger.a(2, EntryType.UI_INPUT_END, 569317439, a);
        }
    }

    /* compiled from: Ljava/util/HashMap */
    class C16062 implements OnClickListener {
        final /* synthetic */ ContactListCollectionItemView f13805a;

        C16062(ContactListCollectionItemView contactListCollectionItemView) {
            this.f13805a = contactListCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1218260925);
            this.f13805a.f13813a;
            Logger.a(2, EntryType.UI_INPUT_END, 457895995, a);
        }
    }

    /* compiled from: Ljava/util/HashMap */
    class C16105 implements Callback {
        final /* synthetic */ ContactListCollectionItemView f13812a;

        C16105(ContactListCollectionItemView contactListCollectionItemView) {
            this.f13812a = contactListCollectionItemView;
        }

        public final void m14956a() {
            this.f13812a.f13816d.b(new ToastBuilder(this.f13812a.getContext().getString(2131234857)).a());
            this.f13812a.f13818f.m14552j().a(GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            this.f13812a.mo425a(this.f13812a.f13818f, this.f13812a.f13819g, this.f13812a.f13820h);
        }

        public final void m14957b() {
        }
    }

    private static <T extends View> void m14963a(Class<T> cls, T t) {
        m14964a((Object) t, t.getContext());
    }

    private static void m14964a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContactListCollectionItemView) obj).m14962a(InfoRequestEventBus.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), IdBasedProvider.a(fbInjector, 1144), Toaster.b(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    public ContactListCollectionItemView(Context context) {
        this(context, null);
    }

    public ContactListCollectionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContactListCollectionItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13821i = new C16051(this);
        this.f13822j = new C16062(this);
        m14963a(ContactListCollectionItemView.class, (View) this);
    }

    @Inject
    private void m14962a(InfoRequestEventBus infoRequestEventBus, SecureContextHelper secureContextHelper, Provider<BlueServiceOperationFactory> provider, Toaster toaster, Executor executor) {
        this.f13813a = infoRequestEventBus;
        this.f13814b = secureContextHelper;
        this.f13815c = provider;
        this.f13816d = toaster;
        this.f13817e = executor;
    }

    public final void mo424a(final AppCollectionItemModel appCollectionItemModel) {
        TextView textView;
        a(2131560344).setVisibility(8);
        if (appCollectionItemModel.m14299l() != null) {
            textView = (TextView) a(2131560347);
            if (appCollectionItemModel.m14299l().m14277a() != null) {
                textView.setVisibility(0);
                textView.setText(appCollectionItemModel.m14299l().m14277a());
            } else {
                textView.setVisibility(8);
                setOnClickListener(null);
            }
        }
        textView = (TextView) a(2131560348);
        if (appCollectionItemModel.m14297j() == null || appCollectionItemModel.m14297j().a() == null) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(appCollectionItemModel.m14297j().a());
        }
        if (m14975c(appCollectionItemModel)) {
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactListCollectionItemView f13807b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1410004850);
                    GraphQLTimelineContactItemType nN_ = appCollectionItemModel.nH_().nN_();
                    if (GraphQLTimelineContactItemType.ADDRESS.equals(nN_)) {
                        String a2 = appCollectionItemModel.m14297j().a();
                        if (!(appCollectionItemModel.nH_().m14372c() == null || StringUtil.a(appCollectionItemModel.nH_().m14372c().m14355a()))) {
                            a2 = appCollectionItemModel.nH_().m14372c().m14355a();
                        }
                        this.f13807b.m14968b(ContactListCollectionItemView.m14961a(a2));
                    } else if (GraphQLTimelineContactItemType.PHONE.equals(nN_)) {
                        this.f13807b.m14974c(appCollectionItemModel.m14297j().a());
                    } else if (GraphQLTimelineContactItemType.EMAIL.equals(nN_)) {
                        this.f13807b.m14978d(appCollectionItemModel.m14297j().a());
                    }
                    LogUtils.a(-1562253745, a);
                }
            });
            setBackgroundResource(2130843621);
        } else {
            setOnClickListener(null);
            setBackgroundColor(getResources().getColor(2131361864));
        }
        if (m14970b(appCollectionItemModel)) {
            final String[] strArr = new String[]{getContext().getString(2131234858)};
            setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ ContactListCollectionItemView f13811c;

                /* compiled from: Ljava/util/HashMap */
                class C16081 implements DialogInterface.OnClickListener {
                    final /* synthetic */ C16094 f13808a;

                    C16081(C16094 c16094) {
                        this.f13808a = c16094;
                    }

                    public void onClick(DialogInterface dialogInterface, int i) {
                        ClipboardUtil.a(this.f13808a.f13811c.getContext(), appCollectionItemModel.m14297j().a());
                        this.f13808a.f13811c.f13816d.b(new ToastBuilder(2131234859));
                    }
                }

                public boolean onLongClick(View view) {
                    new Builder(this.f13811c.getContext()).a(appCollectionItemModel.m14297j().a()).a(strArr, new C16081(this)).b();
                    return true;
                }
            });
        }
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        this.f13818f = CollectionsAppSectionRequestableFieldModel.m14545a(collectionsAppSectionRequestableFieldModel);
        this.f13819g = profileViewerContext;
        this.f13820h = graphQLTimelineAppSectionType;
        setOnClickListener(null);
        TextView textView = (TextView) a(2131560348);
        ((TextView) a(2131560347)).setVisibility(8);
        textView.setVisibility(8);
        View a = a(2131560344);
        a.setVisibility(0);
        ((TextView) a.findViewById(2131560351)).setText(collectionsAppSectionRequestableFieldModel.m14549b());
        Button button = (Button) a(2131560352);
        View a2 = a(2131560353);
        ImageView imageView = (ImageView) a(2131560355);
        if (m14958a(this.f13818f).equals(GraphQLInfoRequestFieldStatus.REQUESTABLE)) {
            button.setVisibility(0);
            button.setOnClickListener(this.f13821i);
            a2.setVisibility(8);
            imageView.setOnClickListener(null);
            return;
        }
        button.setVisibility(8);
        button.setOnClickListener(null);
        a2.setVisibility(0);
        imageView.setOnClickListener(this.f13822j);
    }

    private static GraphQLInfoRequestFieldStatus m14958a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel) {
        GraphQLInfoRequestFieldStatus graphQLInfoRequestFieldStatus = collectionsAppSectionRequestableFieldModel.m14552j().a;
        return (graphQLInfoRequestFieldStatus == null || graphQLInfoRequestFieldStatus.equals(GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) ? collectionsAppSectionRequestableFieldModel.m14550c() : graphQLInfoRequestFieldStatus;
    }

    private boolean m14965a() {
        return IntentResolver.a(getContext(), "android.intent.action.DIAL");
    }

    private boolean m14969b() {
        return IntentResolver.b(getContext(), new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0")));
    }

    private static boolean m14970b(AppCollectionItemModel appCollectionItemModel) {
        return (appCollectionItemModel.m14297j() == null || appCollectionItemModel.m14297j().a() == null) ? false : true;
    }

    private boolean m14975c(AppCollectionItemModel appCollectionItemModel) {
        if (appCollectionItemModel.nH_() == null || !m14970b(appCollectionItemModel)) {
            return false;
        }
        GraphQLTimelineContactItemType nN_ = appCollectionItemModel.nH_().nN_();
        if ((GraphQLTimelineContactItemType.ADDRESS.equals(nN_) && m14969b()) || ((GraphQLTimelineContactItemType.PHONE.equals(nN_) && m14965a()) || GraphQLTimelineContactItemType.EMAIL.equals(nN_))) {
            return true;
        }
        return false;
    }

    private static String m14961a(String str) {
        return str.replace('\n', ',');
    }

    private void m14968b(String str) {
        try {
            str = URLEncoder.encode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
        }
        this.f13814b.b(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + str)), getContext());
    }

    private void m14974c(String str) {
        try {
            str = URLEncoder.encode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
        }
        this.f13814b.b(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)), getContext());
    }

    private void m14978d(String str) {
        try {
            str = URLEncoder.encode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
        }
        Uri parse = Uri.parse("mailto:" + str);
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(parse);
        this.f13814b.b(Intent.createChooser(intent, null), getContext());
    }

    public static void m14972c(ContactListCollectionItemView contactListCollectionItemView) {
        contactListCollectionItemView.f13818f.m14552j().a(GraphQLInfoRequestFieldStatus.REQUESTABLE);
        contactListCollectionItemView.mo425a(contactListCollectionItemView.f13818f, contactListCollectionItemView.f13819g, contactListCollectionItemView.f13820h);
        InfoRequestHelper.a(contactListCollectionItemView.f13818f.m14547a(), contactListCollectionItemView.f13819g.a, (DefaultBlueServiceOperationFactory) contactListCollectionItemView.f13815c.get(), new C16105(contactListCollectionItemView), contactListCollectionItemView.f13817e);
    }
}

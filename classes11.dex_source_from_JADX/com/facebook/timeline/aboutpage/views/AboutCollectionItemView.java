package com.facebook.timeline.aboutpage.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldStatus;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.profile.inforequest.event.InfoRequestEventBus;
import com.facebook.profile.inforequest.event.InfoRequestEvents.SendInfoRequestEvent;
import com.facebook.profile.inforequest.services.InfoRequestHelper;
import com.facebook.profile.inforequest.services.InfoRequestHelper.Callback;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLModels.AppCollectionItemModel;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineAppSectionsGraphQLModels.CollectionsAppSectionRequestableFieldModel;
import com.facebook.timeline.aboutpage.util.ItemLinkMovementMethod;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Strings;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: Ljava/util/concurrent/ExecutorService; */
public class AboutCollectionItemView extends CustomRelativeLayout implements ICollectionItemView {
    private static final CallerContext f13683i = CallerContext.a(AboutCollectionItemView.class, "collections_collection", "about");
    @Inject
    LinkifyUtil f13684a;
    @Inject
    ItemLinkMovementMethod f13685b;
    @Inject
    Provider<IFeedIntentBuilder> f13686c;
    @Inject
    Provider<InfoRequestEventBus> f13687d;
    @Inject
    Provider<BlueServiceOperationFactory> f13688e;
    @Inject
    @ForUiThread
    Provider<Executor> f13689f;
    @Inject
    Provider<Toaster> f13690g;
    @Inject
    Provider<CollectionsUriIntentBuilder> f13691h;
    private TextView f13692j;
    private TextView f13693k;
    private FbDraweeView f13694l;
    private View f13695m;
    private TextView f13696n;
    private Button f13697o;
    private View f13698p;
    private ImageView f13699q;
    public CollectionsAppSectionRequestableFieldModel f13700r;
    public ProfileViewerContext f13701s;
    public GraphQLTimelineAppSectionType f13702t;
    private final OnClickListener f13703u = new C15781(this);
    private final OnClickListener f13704v = new C15792(this);
    private final Callback f13705w = new C15803(this);

    /* compiled from: Ljava/util/concurrent/ExecutorService; */
    class C15781 implements OnClickListener {
        final /* synthetic */ AboutCollectionItemView f13678a;

        C15781(AboutCollectionItemView aboutCollectionItemView) {
            this.f13678a = aboutCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -779271808);
            ((InfoRequestEventBus) this.f13678a.f13687d.get()).a(new SendInfoRequestEvent(this.f13678a.f13701s.e, this.f13678a.f13700r.m14547a()));
            Logger.a(2, EntryType.UI_INPUT_END, -1033505825, a);
        }
    }

    /* compiled from: Ljava/util/concurrent/ExecutorService; */
    class C15792 implements OnClickListener {
        final /* synthetic */ AboutCollectionItemView f13679a;

        C15792(AboutCollectionItemView aboutCollectionItemView) {
            this.f13679a = aboutCollectionItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 106273742);
            this.f13679a.f13700r;
            Logger.a(2, EntryType.UI_INPUT_END, -171674200, a);
        }
    }

    /* compiled from: Ljava/util/concurrent/ExecutorService; */
    class C15803 implements Callback {
        final /* synthetic */ AboutCollectionItemView f13680a;

        C15803(AboutCollectionItemView aboutCollectionItemView) {
            this.f13680a = aboutCollectionItemView;
        }

        public final void m14873a() {
            ((Toaster) this.f13680a.f13690g.get()).b(new ToastBuilder(this.f13680a.getContext().getString(2131234857)).a());
            this.f13680a.f13700r.m14552j().a(GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            this.f13680a.mo425a(this.f13680a.f13700r, this.f13680a.f13701s, this.f13680a.f13702t);
        }

        public final void m14874b() {
        }
    }

    private static <T extends View> void m14881a(Class<T> cls, T t) {
        m14882a((Object) t, t.getContext());
    }

    private static void m14882a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AboutCollectionItemView) obj).m14880a(LinkifyUtil.a(injectorLike), ItemLinkMovementMethod.m14862a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2347), IdBasedSingletonScopeProvider.a(injectorLike, 9732), IdBasedProvider.a(injectorLike, 1144), IdBasedSingletonScopeProvider.a(injectorLike, 3863), IdBasedProvider.a(injectorLike, 3588), IdBasedSingletonScopeProvider.a(injectorLike, 11130));
    }

    public AboutCollectionItemView(Context context) {
        super(context);
        m14879a();
    }

    public AboutCollectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14879a();
    }

    private void m14879a() {
        m14881a(AboutCollectionItemView.class, (View) this);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 445958811);
        super.onFinishInflate();
        this.f13692j = (TextView) a(2131560341);
        this.f13693k = (TextView) a(2131560342);
        this.f13694l = (FbDraweeView) a(2131560339);
        this.f13695m = a(2131560344);
        this.f13696n = (TextView) a(2131560351);
        this.f13697o = (Button) a(2131560352);
        this.f13698p = a(2131560353);
        this.f13699q = (ImageView) a(2131560355);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -391534365, a);
    }

    public final void mo424a(AppCollectionItemModel appCollectionItemModel) {
        String str;
        this.f13695m.setVisibility(8);
        if (appCollectionItemModel.m14299l() == null || appCollectionItemModel.m14299l().m14277a() == null) {
            this.f13692j.setVisibility(4);
            str = null;
        } else {
            if (appCollectionItemModel.m14299l().m14278b() == null || appCollectionItemModel.m14299l().m14278b().size() <= 0) {
                this.f13692j.setTextColor(getResources().getColor(appCollectionItemModel.m14300m() != null ? 2131363996 : 2131363998));
                this.f13692j.setText(appCollectionItemModel.m14299l().m14277a());
                str = appCollectionItemModel.m14300m();
            } else {
                str = appCollectionItemModel.m14300m();
                this.f13692j.setTextColor(getResources().getColor(2131363998));
                this.f13692j.setText(this.f13684a.a(appCollectionItemModel.m14299l(), false, null), BufferType.SPANNABLE);
                this.f13692j.setTag(this);
                this.f13692j.setMovementMethod(this.f13685b);
            }
            this.f13692j.setVisibility(0);
        }
        if (str != null) {
            setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AboutCollectionItemView f13682b;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1517338212);
                    ((IFeedIntentBuilder) this.f13682b.f13686c.get()).a(this.f13682b.getContext(), str);
                    Logger.a(2, EntryType.UI_INPUT_END, 1064019570, a);
                }
            });
            setBackgroundResource(2130843621);
        } else {
            setOnClickListener(null);
            setBackgroundColor(getResources().getColor(2131361864));
        }
        if (appCollectionItemModel.m14297j() == null || Strings.isNullOrEmpty(appCollectionItemModel.m14297j().a())) {
            this.f13693k.setVisibility(8);
        } else {
            this.f13693k.setVisibility(0);
            this.f13693k.setText(appCollectionItemModel.m14297j().a());
        }
        if (appCollectionItemModel.m14294c() == null || appCollectionItemModel.m14294c().b() == null) {
            this.f13694l.a(null, f13683i);
            this.f13694l.setVisibility(4);
            return;
        }
        this.f13694l.a(Uri.parse(appCollectionItemModel.m14294c().b()), f13683i);
        this.f13694l.setVisibility(0);
    }

    public final void mo425a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel, ProfileViewerContext profileViewerContext, GraphQLTimelineAppSectionType graphQLTimelineAppSectionType) {
        this.f13700r = CollectionsAppSectionRequestableFieldModel.m14545a(collectionsAppSectionRequestableFieldModel);
        this.f13701s = profileViewerContext;
        this.f13702t = graphQLTimelineAppSectionType;
        setOnClickListener(null);
        this.f13692j.setVisibility(8);
        this.f13693k.setVisibility(8);
        this.f13694l.setVisibility(8);
        this.f13695m.setVisibility(0);
        this.f13696n.setText(collectionsAppSectionRequestableFieldModel.m14549b());
        if (m14877a(this.f13700r).equals(GraphQLInfoRequestFieldStatus.REQUESTABLE)) {
            this.f13697o.setVisibility(0);
            this.f13697o.setOnClickListener(this.f13703u);
            this.f13698p.setVisibility(8);
            this.f13699q.setOnClickListener(null);
            return;
        }
        this.f13697o.setVisibility(8);
        this.f13697o.setOnClickListener(null);
        this.f13698p.setVisibility(0);
        this.f13699q.setOnClickListener(this.f13704v);
    }

    private static GraphQLInfoRequestFieldStatus m14877a(CollectionsAppSectionRequestableFieldModel collectionsAppSectionRequestableFieldModel) {
        GraphQLInfoRequestFieldStatus graphQLInfoRequestFieldStatus = collectionsAppSectionRequestableFieldModel.m14552j().a;
        return (graphQLInfoRequestFieldStatus == null || graphQLInfoRequestFieldStatus.equals(GraphQLInfoRequestFieldStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) ? collectionsAppSectionRequestableFieldModel.m14550c() : graphQLInfoRequestFieldStatus;
    }

    public static void m14884b(AboutCollectionItemView aboutCollectionItemView) {
        aboutCollectionItemView.f13700r.m14552j().a(GraphQLInfoRequestFieldStatus.REQUESTABLE);
        aboutCollectionItemView.mo425a(aboutCollectionItemView.f13700r, aboutCollectionItemView.f13701s, aboutCollectionItemView.f13702t);
        InfoRequestHelper.a(aboutCollectionItemView.f13700r.m14547a(), aboutCollectionItemView.f13701s.a, (DefaultBlueServiceOperationFactory) aboutCollectionItemView.f13688e.get(), aboutCollectionItemView.f13705w, (Executor) aboutCollectionItemView.f13689f.get());
    }

    private void m14880a(LinkifyUtil linkifyUtil, ItemLinkMovementMethod itemLinkMovementMethod, Provider<IFeedIntentBuilder> provider, Provider<InfoRequestEventBus> provider2, Provider<BlueServiceOperationFactory> provider3, Provider<Executor> provider4, Provider<Toaster> provider5, Provider<CollectionsUriIntentBuilder> provider6) {
        this.f13684a = linkifyUtil;
        this.f13685b = itemLinkMovementMethod;
        this.f13686c = provider;
        this.f13687d = provider2;
        this.f13688e = provider3;
        this.f13689f = provider4;
        this.f13690g = provider5;
        this.f13691h = provider6;
    }
}

package com.facebook.feed.rows.sections.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.facebook.attachments.photos.PhotoAttachmentInfo;
import com.facebook.attachments.photos.PhotoAttachmentLayoutHelper;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition;
import com.facebook.multirow.parts.ViewDimensionsPartDefinition.DimensionData;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.photos.warning.ObjectionableContentView;
import com.facebook.photos.warning.ObjectionableContentView.State;
import com.facebook.widget.images.DrawableUtil;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hideReplyButton */
public class ObjectionableContentPhotoAttachmentPartDefinition<E extends HasInvalidate & HasFeedListType & HasPositionInformation & HasPrefetcher & HasImageLoadListener> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, ObjectionableContentView> {
    public static final ViewType f21056a = new C08391();
    private static final CallerContext f21057b = CallerContext.m9061a(ObjectionableContentPhotoAttachmentPartDefinition.class, "native_newsfeed");
    private static ObjectionableContentPhotoAttachmentPartDefinition f21058n;
    private static final Object f21059o = new Object();
    private final PhotoAttachmentLayoutHelper f21060c;
    private final Rect f21061d;
    private final BasePaddingStyleResolver f21062e;
    public final ObjectionableContentController f21063f;
    private final float f21064g;
    private final BackgroundPartDefinition f21065h;
    private final TextPartDefinition f21066i;
    private final ClickListenerPartDefinition f21067j;
    private final ViewDimensionsPartDefinition f21068k;
    private final Context f21069l;
    private final PhotoAttachmentUtil f21070m;

    /* compiled from: hideReplyButton */
    final class C08391 extends ViewType {
        C08391() {
        }

        public final View mo1995a(Context context) {
            return new ObjectionableContentView(context);
        }
    }

    private static ObjectionableContentPhotoAttachmentPartDefinition m28789b(InjectorLike injectorLike) {
        return new ObjectionableContentPhotoAttachmentPartDefinition(ResourcesMethodAutoProvider.m6510a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), TextPartDefinition.m19379a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), ViewDimensionsPartDefinition.m28737a(injectorLike), PhotoAttachmentLayoutHelper.m28742a(injectorLike), DrawableUtil.m28756a(injectorLike), DefaultPaddingStyleResolver.m19157a(injectorLike), ObjectionableContentController.m27812a(injectorLike), (Context) injectorLike.getInstance(Context.class), PhotoAttachmentUtil.m28776b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        FeedProps e = AttachmentProps.m28715e(feedProps);
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
        PaddingStyle a = this.f21070m.m28777a(feedProps, (HasPositionInformation) hasInvalidate);
        subParts.mo2756a(this.f21065h, new StylingData(e, a));
        subParts.mo2755a(2131564316, this.f21066i, this.f21063f.m27817a(this.f21069l));
        subParts.mo2755a(2131564317, this.f21067j, new 2(this, r, hasInvalidate, feedProps));
        PhotoAttachmentInfo a2 = this.f21060c.m28745a(r, this.f21061d, this.f21062e.m19174a(a, e, this.f21064g), 0.0f);
        int i = a2.f21997g;
        int i2 = a2.f21998h;
        subParts.mo2755a(2131564312, this.f21068k, new DimensionData(i, i2));
        subParts.mo2755a(2131564311, this.f21068k, new DimensionData(i, i2));
        subParts.mo2755a(2131564313, this.f21068k, new DimensionData(i, i2));
        return this.f21063f.m27818a(feedProps, a2.m29775a(), (HasPrefetcher) hasInvalidate, f21057b);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 920681237);
        ObjectionableContentView objectionableContentView = (ObjectionableContentView) view;
        this.f21063f.m27819a(objectionableContentView, (State) obj2);
        Logger.a(8, EntryType.MARK_POP, -651546340, a);
    }

    public final boolean m28793a(Object obj) {
        return this.f21063f.m27823a(((GraphQLStoryAttachment) ((FeedProps) obj).f13444a).m23979r());
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ObjectionableContentController.m27813a((ObjectionableContentView) view);
    }

    public static ObjectionableContentPhotoAttachmentPartDefinition m28788a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ObjectionableContentPhotoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21059o) {
                ObjectionableContentPhotoAttachmentPartDefinition objectionableContentPhotoAttachmentPartDefinition;
                if (a2 != null) {
                    objectionableContentPhotoAttachmentPartDefinition = (ObjectionableContentPhotoAttachmentPartDefinition) a2.mo818a(f21059o);
                } else {
                    objectionableContentPhotoAttachmentPartDefinition = f21058n;
                }
                if (objectionableContentPhotoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28789b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21059o, b3);
                        } else {
                            f21058n = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = objectionableContentPhotoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ObjectionableContentPhotoAttachmentPartDefinition(Resources resources, BackgroundPartDefinition backgroundPartDefinition, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ViewDimensionsPartDefinition viewDimensionsPartDefinition, PhotoAttachmentLayoutHelper photoAttachmentLayoutHelper, DrawableUtil drawableUtil, BasePaddingStyleResolver basePaddingStyleResolver, ObjectionableContentController objectionableContentController, Context context, PhotoAttachmentUtil photoAttachmentUtil) {
        this.f21065h = backgroundPartDefinition;
        this.f21066i = textPartDefinition;
        this.f21067j = clickListenerPartDefinition;
        this.f21068k = viewDimensionsPartDefinition;
        this.f21060c = photoAttachmentLayoutHelper;
        this.f21062e = basePaddingStyleResolver;
        this.f21063f = objectionableContentController;
        this.f21069l = context;
        this.f21070m = photoAttachmentUtil;
        this.f21061d = drawableUtil.m28758a(2130840254);
        this.f21064g = (float) resources.getDimensionPixelSize(2131427380);
    }

    public final ViewType mo2547a() {
        return f21056a;
    }
}

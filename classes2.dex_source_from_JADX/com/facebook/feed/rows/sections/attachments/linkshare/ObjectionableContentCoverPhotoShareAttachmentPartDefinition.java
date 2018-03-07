package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.photos.warning.ObjectionableContentAttachmentView;
import com.facebook.photos.warning.ObjectionableContentController;
import com.facebook.photos.warning.ObjectionableContentView.State;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_bootstrapping_delivery_receipts */
public class ObjectionableContentCoverPhotoShareAttachmentPartDefinition<E extends HasImageLoadListener & HasInvalidate & HasPositionInformation & HasPrefetcher & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, State, E, ObjectionableContentAttachmentView> {
    private static final String f24141a = ObjectionableContentCoverPhotoShareAttachmentPartDefinition.class.getName();
    private static final CallerContext f24142b = CallerContext.m9061a(ObjectionableContentCoverPhotoShareAttachmentPartDefinition.class, "native_newsfeed");
    private static ObjectionableContentCoverPhotoShareAttachmentPartDefinition f24143k;
    private static final Object f24144l = new Object();
    private final BaseShareAttachmentPartDefinition f24145c;
    public final ObjectionableContentController f24146d;
    private final ClickListenerPartDefinition f24147e;
    private final CoverPhotoShareAttachmentBinderFactory f24148f;
    private final LegacyAngoraAttachmentUtil f24149g;
    private final TextPartDefinition f24150h;
    private final AbstractFbErrorReporter f24151i;
    private final Context f24152j;

    private static ObjectionableContentCoverPhotoShareAttachmentPartDefinition m32511b(InjectorLike injectorLike) {
        return new ObjectionableContentCoverPhotoShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition.m32218a(injectorLike), ObjectionableContentController.m27812a(injectorLike), ClickListenerPartDefinition.m19353a(injectorLike), CoverPhotoShareAttachmentBinderFactory.m32330a(injectorLike), LegacyAngoraAttachmentUtil.m28831a(injectorLike), TextPartDefinition.m19379a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasImageLoadListener hasImageLoadListener = (HasImageLoadListener) anyEnvironment;
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        GraphQLMedia r = ((GraphQLStoryAttachment) feedProps.f13444a).m23979r();
        if (r != null || c == null) {
            subParts.mo2756a(this.f24145c, feedProps);
            subParts.mo2756a(this.f24147e, null);
            subParts.mo2755a(2131564316, this.f24150h, this.f24146d.m27817a(this.f24152j));
            subParts.mo2755a(2131564317, this.f24147e, new 1(this, c, hasImageLoadListener, feedProps));
            String a = BaseAttachmentCoverPhotoPartDefinition.m32337a(r, 1.9318181f, AttachmentCoverPhotoPartDefinition.m32327a(this.f24149g));
            if (a == null) {
                return null;
            }
            return this.f24146d.m27818a(feedProps, Uri.parse(a), (HasPrefetcher) hasImageLoadListener, f24142b);
        }
        this.f24151i.m2350b(f24141a, "Story attachment without media " + c.S_());
        return null;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 677478853);
        State state = (State) obj2;
        ObjectionableContentAttachmentView objectionableContentAttachmentView = (ObjectionableContentAttachmentView) view;
        objectionableContentAttachmentView.b.b.setAspectRatio(1.9318181f);
        this.f24146d.m27819a(objectionableContentAttachmentView.b, state);
        Logger.a(8, EntryType.MARK_POP, 30127616, a);
    }

    public final boolean m32515a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return CoverPhotoShareAttachmentPartDefinition.m32518a(feedProps, this.f24148f) && this.f24146d.m27822a(feedProps);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ObjectionableContentController.m27813a(((ObjectionableContentAttachmentView) view).b);
    }

    public static ObjectionableContentCoverPhotoShareAttachmentPartDefinition m32510a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ObjectionableContentCoverPhotoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24144l) {
                ObjectionableContentCoverPhotoShareAttachmentPartDefinition objectionableContentCoverPhotoShareAttachmentPartDefinition;
                if (a2 != null) {
                    objectionableContentCoverPhotoShareAttachmentPartDefinition = (ObjectionableContentCoverPhotoShareAttachmentPartDefinition) a2.mo818a(f24144l);
                } else {
                    objectionableContentCoverPhotoShareAttachmentPartDefinition = f24143k;
                }
                if (objectionableContentCoverPhotoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32511b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24144l, b3);
                        } else {
                            f24143k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = objectionableContentCoverPhotoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public ObjectionableContentCoverPhotoShareAttachmentPartDefinition(BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, ObjectionableContentController objectionableContentController, ClickListenerPartDefinition clickListenerPartDefinition, CoverPhotoShareAttachmentBinderFactory coverPhotoShareAttachmentBinderFactory, LegacyAngoraAttachmentUtil legacyAngoraAttachmentUtil, TextPartDefinition textPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter, Context context) {
        this.f24145c = baseShareAttachmentPartDefinition;
        this.f24146d = objectionableContentController;
        this.f24147e = clickListenerPartDefinition;
        this.f24149g = legacyAngoraAttachmentUtil;
        this.f24150h = textPartDefinition;
        this.f24151i = abstractFbErrorReporter;
        this.f24148f = coverPhotoShareAttachmentBinderFactory;
        this.f24152j = context;
    }

    public final ViewType mo2547a() {
        return ObjectionableContentAttachmentView.a;
    }
}

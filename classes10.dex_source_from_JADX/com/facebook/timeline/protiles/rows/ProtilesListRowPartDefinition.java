package com.facebook.timeline.protiles.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileItemFieldsModel;
import com.facebook.timeline.protiles.util.ProtilesClickHandler;
import com.facebook.timeline.protiles.util.ProtilesFriendSubtitleUtil;
import com.facebook.timeline.protiles.util.ProtilesImageUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: fbe7645de0e56185bedf3158b649c3df */
public class ProtilesListRowPartDefinition<E extends HasImageLoadListener & CanFriendPerson & HasPrefetcher> extends MultiRowSinglePartDefinition<Props, Void, E, ImageBlockLayout> {
    public static final ViewType f12276a = new C17411();
    public static final ViewType f12277b = new C17422();
    private static ProtilesListRowPartDefinition f12278l;
    private static final Object f12279m = new Object();
    private final ProtilesSmallProfilePicturePartDefinition f12280c;
    private final TextOrHiddenPartDefinition f12281d;
    private final Provider<TextIconPartDefinition> f12282e;
    private final ProtilesFriendButtonPartDefinition f12283f;
    private final ProtilesFriendIconPartDefinition f12284g;
    private final ClickListenerPartDefinition f12285h;
    private final ProtilesFriendSubtitleUtil f12286i;
    public final ProtilesClickHandler f12287j;
    private final QeAccessor f12288k;

    /* compiled from: fbe7645de0e56185bedf3158b649c3df */
    final class C17411 extends ViewType {
        C17411() {
        }

        public final View m12337a(Context context) {
            ImageBlockLayout imageBlockLayout = (ImageBlockLayout) LayoutInflater.from(context).inflate(2130906501, null);
            LayoutInflater.from(context).inflate(2130906503, imageBlockLayout);
            return imageBlockLayout;
        }
    }

    /* compiled from: fbe7645de0e56185bedf3158b649c3df */
    final class C17422 extends ViewType {
        C17422() {
        }

        public final View m12338a(Context context) {
            ImageBlockLayout imageBlockLayout = (ImageBlockLayout) LayoutInflater.from(context).inflate(2130906501, null);
            LayoutInflater.from(context).inflate(2130906504, imageBlockLayout);
            return imageBlockLayout;
        }
    }

    /* compiled from: fbe7645de0e56185bedf3158b649c3df */
    public class Props {
        public final ProtileModel f12274a;
        public final ProtileItemFieldsModel f12275b;

        public Props(ProtileModel protileModel, ProtileItemFieldsModel protileItemFieldsModel) {
            this.f12274a = protileModel;
            this.f12275b = protileItemFieldsModel;
        }
    }

    private static ProtilesListRowPartDefinition m12340b(InjectorLike injectorLike) {
        return new ProtilesListRowPartDefinition(ProtilesSmallProfilePicturePartDefinition.m12386a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), IdBasedProvider.a(injectorLike, 8643), ProtilesFriendButtonPartDefinition.m12292a(injectorLike), ProtilesFriendIconPartDefinition.m12296a(injectorLike), ClickListenerPartDefinition.a(injectorLike), ProtilesFriendSubtitleUtil.m12404a(injectorLike), ProtilesClickHandler.m12399a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m12343a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        C17433 c17433;
        Props props = (Props) obj;
        final String a = props.f12275b.m12182d() != null ? props.f12275b.m12182d().m12176a() : null;
        subParts.a(2131566438, this.f12281d, a);
        subParts.a(2131566439, this.f12281d, this.f12286i.m12408a(props.f12275b));
        int c = ProtilesFriendSubtitleUtil.m12406c(props.f12275b);
        if (c > 0) {
            subParts.a(2131566439, (SinglePartDefinition) this.f12282e.get(), new IconData(c, null, null));
        }
        final DefaultImageFields a2 = ProtilesImageUtil.m12422a(props.f12275b, props.f12274a.m12109b());
        if (!(a2 == null || a2.b() == null)) {
            subParts.a(2131566437, this.f12280c, new com.facebook.timeline.protiles.rows.ProtilesSmallProfilePicturePartDefinition.Props(ImageRequest.a(a2.b()), props.f12274a.f12105a));
        }
        if (m12341c()) {
            subParts.a(2131558479, this.f12283f, props);
        } else {
            subParts.a(2131558479, this.f12284g, props);
        }
        ClickListenerPartDefinition clickListenerPartDefinition = this.f12285h;
        final ProtileItemFieldsModel protileItemFieldsModel = props.f12275b;
        if (protileItemFieldsModel.m12180b() == null) {
            c17433 = null;
        } else {
            c17433 = new OnClickListener(this) {
                final /* synthetic */ ProtilesListRowPartDefinition f12273d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, 1236583875);
                    String d = protileItemFieldsModel.m12180b().m12151d();
                    boolean z = protileItemFieldsModel.m12180b() != null && protileItemFieldsModel.m12180b().m12158o() > 0;
                    this.f12273d.f12287j.m12402a(view.getContext(), d, a2, a, protileItemFieldsModel.m12180b().m12156m(), z);
                    LogUtils.a(-323573003, a);
                }
            };
        }
        subParts.a(clickListenerPartDefinition, c17433);
        return null;
    }

    public static ProtilesListRowPartDefinition m12339a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProtilesListRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12279m) {
                ProtilesListRowPartDefinition protilesListRowPartDefinition;
                if (a2 != null) {
                    protilesListRowPartDefinition = (ProtilesListRowPartDefinition) a2.a(f12279m);
                } else {
                    protilesListRowPartDefinition = f12278l;
                }
                if (protilesListRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12340b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12279m, b3);
                        } else {
                            f12278l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = protilesListRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ProtilesListRowPartDefinition(ProtilesSmallProfilePicturePartDefinition protilesSmallProfilePicturePartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, Provider<TextIconPartDefinition> provider, ProtilesFriendButtonPartDefinition protilesFriendButtonPartDefinition, ProtilesFriendIconPartDefinition protilesFriendIconPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, ProtilesFriendSubtitleUtil protilesFriendSubtitleUtil, ProtilesClickHandler protilesClickHandler, QeAccessor qeAccessor) {
        this.f12280c = protilesSmallProfilePicturePartDefinition;
        this.f12281d = textOrHiddenPartDefinition;
        this.f12282e = provider;
        this.f12283f = protilesFriendButtonPartDefinition;
        this.f12284g = protilesFriendIconPartDefinition;
        this.f12285h = clickListenerPartDefinition;
        this.f12286i = protilesFriendSubtitleUtil;
        this.f12287j = protilesClickHandler;
        this.f12288k = qeAccessor;
    }

    public final ViewType m12342a() {
        return m12341c() ? f12276a : f12277b;
    }

    public final boolean m12344a(Object obj) {
        return true;
    }

    private boolean m12341c() {
        return this.f12288k.a(ExperimentsForTimelineAbTestModule.aY, false);
    }
}

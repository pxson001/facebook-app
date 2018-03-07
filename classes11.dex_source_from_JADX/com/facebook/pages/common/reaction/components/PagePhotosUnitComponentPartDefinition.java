package com.facebook.pages.common.reaction.components;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.pages.common.reaction.ui.PagePhotosComponentView;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: serviceAddEditAndroidPhotoPicked */
public class PagePhotosUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, PagePhotosComponentView> {
    public static final ViewType f2033a = new C02631();
    private static PagePhotosUnitComponentPartDefinition f2034c;
    private static final Object f2035d = new Object();
    public final ReactionIntentFactory f2036b;

    /* compiled from: serviceAddEditAndroidPhotoPicked */
    final class C02631 extends ViewType {
        C02631() {
        }

        public final View m3060a(Context context) {
            return new PagePhotosComponentView(context);
        }
    }

    /* compiled from: serviceAddEditAndroidPhotoPicked */
    public class Photo {
        public final String f2028a;
        public final String f2029b;
        public final String f2030c;
        public final OnClickListener f2031d;

        public Photo(String str, String str2, String str3, OnClickListener onClickListener) {
            this.f2028a = str;
            this.f2029b = str2;
            this.f2030c = str3;
            this.f2031d = onClickListener;
        }
    }

    /* compiled from: serviceAddEditAndroidPhotoPicked */
    public class State {
        public final List<Photo> f2032a;

        public State(List<Photo> list) {
            this.f2032a = list;
        }
    }

    private static PagePhotosUnitComponentPartDefinition m3064b(InjectorLike injectorLike) {
        return new PagePhotosUnitComponentPartDefinition(ReactionIntentFactory.a(injectorLike));
    }

    public final Object m3066a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new State(m3063a((ReactionUnitComponentNode) obj, 3, (CanLaunchReactionIntent) anyEnvironment));
    }

    public final /* bridge */ /* synthetic */ void m3067a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 802041018);
        ((PagePhotosComponentView) view).m3184a(((State) obj2).f2032a);
        Logger.a(8, EntryType.MARK_POP, 1421654292, a);
    }

    public final boolean m3068a(Object obj) {
        ImmutableList bO = ((ReactionUnitComponentNode) obj).b.bO();
        if (bO.size() <= 0) {
            return false;
        }
        int size = bO.size();
        for (int i = 0; i < size; i++) {
            SizeAwareMedia sizeAwareMedia = (SizeAwareMedia) bO.get(i);
            if (Strings.isNullOrEmpty(sizeAwareMedia.d()) || sizeAwareMedia.bd_() == null || Strings.isNullOrEmpty(sizeAwareMedia.bd_().b()) || sizeAwareMedia.bc_() == null || Strings.isNullOrEmpty(sizeAwareMedia.bc_().b())) {
                return false;
            }
        }
        return true;
    }

    public final void m3069b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        for (View onClickListener : ((PagePhotosComponentView) view).f2223c) {
            onClickListener.setOnClickListener(null);
        }
    }

    public static PagePhotosUnitComponentPartDefinition m3062a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagePhotosUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2035d) {
                PagePhotosUnitComponentPartDefinition pagePhotosUnitComponentPartDefinition;
                if (a2 != null) {
                    pagePhotosUnitComponentPartDefinition = (PagePhotosUnitComponentPartDefinition) a2.a(f2035d);
                } else {
                    pagePhotosUnitComponentPartDefinition = f2034c;
                }
                if (pagePhotosUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m3064b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2035d, b3);
                        } else {
                            f2034c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagePhotosUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PagePhotosUnitComponentPartDefinition(ReactionIntentFactory reactionIntentFactory) {
        this.f2036b = reactionIntentFactory;
    }

    public final ViewType m3065a() {
        return f2033a;
    }

    private List<Photo> m3063a(ReactionUnitComponentNode reactionUnitComponentNode, int i, E e) {
        ImmutableList bO = reactionUnitComponentNode.f().bO();
        int min = Math.min(bO.size(), i);
        List<Photo> arrayList = new ArrayList();
        long[] jArr = new long[bO.size()];
        for (int i2 = 0; i2 < min; i2++) {
            jArr[i2] = Long.parseLong(((SizeAwareMedia) bO.get(i2)).d());
        }
        for (int i3 = 0; i3 < min; i3++) {
            String d = ((SizeAwareMedia) bO.get(i3)).d();
            String b = ((SizeAwareMedia) bO.get(i3)).bc_().b();
            String b2 = ((SizeAwareMedia) bO.get(i3)).bd_().b();
            String str = b;
            String str2 = b2;
            arrayList.add(new Photo(d, str, str2, m3061a(reactionUnitComponentNode.k(), reactionUnitComponentNode.l(), e, Long.parseLong(d), ((SizeAwareMedia) bO.get(i3)).bd_().b(), jArr)));
        }
        return arrayList;
    }

    private OnClickListener m3061a(String str, String str2, E e, long j, String str3, long[] jArr) {
        final E e2 = e;
        final long j2 = j;
        final long[] jArr2 = jArr;
        final String str4 = str3;
        final String str5 = str;
        final String str6 = str2;
        return new OnClickListener(this) {
            final /* synthetic */ PagePhotosUnitComponentPartDefinition f2027g;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1955396676);
                ReactionIntentFactory reactionIntentFactory = this.f2027g.f2036b;
                e2.a(str5, str6, ReactionIntentFactory.a(((HasContext) e2).getContext(), j2, jArr2, str4));
                Logger.a(2, EntryType.UI_INPUT_END, -228571938, a);
            }
        };
    }
}

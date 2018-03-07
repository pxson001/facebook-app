package com.facebook.feedplugins.attachments.poll;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLQuestionOption;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TILE_COUNT */
public class DefaultPollDisplayAndClickListenerBuilder<E extends HasFeedListType> {
    private static DefaultPollDisplayAndClickListenerBuilder f22636d;
    private static final Object f22637e = new Object();
    public final Context f22638a;
    public final IFeedIntentBuilder f22639b;
    public final SecureContextHelper f22640c;

    /* compiled from: TILE_COUNT */
    public class C19732 implements OnClickListener {
        final /* synthetic */ FeedProps f22634a;
        final /* synthetic */ DefaultPollDisplayAndClickListenerBuilder f22635b;

        public C19732(DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder, FeedProps feedProps) {
            this.f22635b = defaultPollDisplayAndClickListenerBuilder;
            this.f22634a = feedProps;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1825387493);
            this.f22635b.f22640c.a(this.f22635b.f22639b.a(AttachmentProps.c(this.f22634a)), this.f22635b.f22638a);
            Logger.a(2, EntryType.UI_INPUT_END, -1728026637, a);
        }
    }

    private static DefaultPollDisplayAndClickListenerBuilder m25296b(InjectorLike injectorLike) {
        return new DefaultPollDisplayAndClickListenerBuilder((Context) injectorLike.getInstance(Context.class), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    public final String m25298a(boolean z, boolean z2, String str, String str2, AnyEnvironment anyEnvironment, FeedProps feedProps) {
        if (((HasFeedListType) anyEnvironment).c().a().equals(FeedListName.PERMALINK)) {
            return null;
        }
        if (z) {
            return str;
        }
        if (z2) {
            return str2;
        }
        return null;
    }

    @Inject
    public DefaultPollDisplayAndClickListenerBuilder(Context context, IFeedIntentBuilder iFeedIntentBuilder, SecureContextHelper secureContextHelper) {
        this.f22638a = context;
        this.f22640c = secureContextHelper;
        this.f22639b = iFeedIntentBuilder;
    }

    public final boolean m25299a(FeedProps feedProps, AnyEnvironment anyEnvironment) {
        return false;
    }

    public final OnClickListener m25297a(final GraphQLQuestionOption graphQLQuestionOption, final String str) {
        return new OnClickListener(this) {
            final /* synthetic */ DefaultPollDisplayAndClickListenerBuilder f22633c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1596181380);
                Intent b = this.f22633c.f22639b.b(graphQLQuestionOption.j());
                if (!StringUtil.a(str)) {
                    b.putExtra("fragment_title", str);
                }
                this.f22633c.f22640c.a(b, this.f22633c.f22638a);
                Logger.a(2, EntryType.UI_INPUT_END, -957744299, a);
            }
        };
    }

    public static DefaultPollDisplayAndClickListenerBuilder m25295a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultPollDisplayAndClickListenerBuilder b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22637e) {
                DefaultPollDisplayAndClickListenerBuilder defaultPollDisplayAndClickListenerBuilder;
                if (a2 != null) {
                    defaultPollDisplayAndClickListenerBuilder = (DefaultPollDisplayAndClickListenerBuilder) a2.a(f22637e);
                } else {
                    defaultPollDisplayAndClickListenerBuilder = f22636d;
                }
                if (defaultPollDisplayAndClickListenerBuilder == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25296b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22637e, b3);
                        } else {
                            f22636d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultPollDisplayAndClickListenerBuilder;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

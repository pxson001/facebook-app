package com.facebook.groups.composer.groupspollcomposer;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewStub;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.PollUploadParams;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.common.PublishPostParams.Builder;
import com.facebook.composer.publish.helpers.OptimisticPostHelper;
import com.facebook.composer.publish.helpers.OptimisticPostHelperProvider;
import com.facebook.composer.publish.helpers.PublishAttachmentsHelperProvider;
import com.facebook.composer.publish.helpers.PublishStatusHelper;
import com.facebook.composer.publish.helpers.PublishStatusHelperProvider;
import com.facebook.groups.composer.groupspollcomposer.view.GroupsPollComposerFooterView;
import com.facebook.inject.Assisted;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.SerializedComposerPluginConfig;
import com.facebook.ipc.composer.plugin.ComposerPlugin$InstanceState;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginSession;
import com.facebook.ipc.composer.plugin.impl.ComposerPluginDefault;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: view_group_tap */
public final class GroupsPollComposerPlugin extends ComposerPluginDefault {
    public static final String f464a = GroupsPollComposerPlugin.class.getSimpleName();
    public static String f465h;
    public GroupsPollDataModel f466b;
    public final OptimisticPostHelperProvider f467c;
    public final PublishAttachmentsHelperProvider f468d;
    public final PublishStatusHelperProvider f469e;
    private final FbObjectMapper f470f;
    private final AbstractFbErrorReporter f471g;
    public Context f472i;

    /* compiled from: view_group_tap */
    class C00541 implements Getter<String> {
        final /* synthetic */ GroupsPollComposerPlugin f457a;

        C00541(GroupsPollComposerPlugin groupsPollComposerPlugin) {
            this.f457a = groupsPollComposerPlugin;
        }

        public final Object m439a() {
            return this.f457a.b.getResources().getString(2131238475);
        }
    }

    /* compiled from: view_group_tap */
    class C00552 implements BooleanGetter {
        final /* synthetic */ GroupsPollComposerPlugin f458c;

        C00552(GroupsPollComposerPlugin groupsPollComposerPlugin) {
            this.f458c = groupsPollComposerPlugin;
        }

        public final boolean m440a() {
            return this.f458c.f466b != null && CollectionUtil.b(this.f458c.f466b.m463b());
        }
    }

    /* compiled from: view_group_tap */
    class C00563 implements BooleanGetter {
        final /* synthetic */ GroupsPollComposerPlugin f459c;

        C00563(GroupsPollComposerPlugin groupsPollComposerPlugin) {
            this.f459c = groupsPollComposerPlugin;
        }

        public final boolean m441a() {
            CharSequence string;
            GroupsPollComposerPlugin groupsPollComposerPlugin = this.f459c;
            Object obj = null;
            String a = groupsPollComposerPlugin.E().f1139a.ae().a();
            int length = a != null ? a.length() : 0;
            if (length < 3) {
                string = groupsPollComposerPlugin.b.getString(2131238476);
            } else if (length > 500) {
                string = groupsPollComposerPlugin.b.getString(2131238477);
            } else {
                if (!(groupsPollComposerPlugin.f466b == null || groupsPollComposerPlugin.f466b.m465c() || groupsPollComposerPlugin.f466b.m463b().size() >= 2)) {
                    string = groupsPollComposerPlugin.b.getString(2131238478);
                }
                if (obj == null) {
                    return true;
                }
                return false;
            }
            if (groupsPollComposerPlugin.f472i instanceof Activity) {
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(groupsPollComposerPlugin.f472i);
                fbAlertDialogBuilder.b(string).a(17039370, new C00585(groupsPollComposerPlugin));
                fbAlertDialogBuilder.a().show();
            }
            obj = 1;
            if (obj == null) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: view_group_tap */
    class C00574 implements Getter<Intent> {
        final /* synthetic */ GroupsPollComposerPlugin f460a;

        C00574(GroupsPollComposerPlugin groupsPollComposerPlugin) {
            this.f460a = groupsPollComposerPlugin;
        }

        public final Object m442a() {
            OptimisticPostHelper a = this.f460a.f467c.a(this.f460a.E().f1139a, this.f460a.q);
            PublishStatusHelper a2 = this.f460a.f469e.a(this.f460a.E().f1139a, this.f460a.f468d.a(this.f460a.E().f1139a), a);
            PublishPostParams a3 = a2.a();
            PollUploadParams pollUploadParams = new PollUploadParams(String.valueOf(a3.targetId), a3.rawMessage, this.f460a.f466b.m463b(), this.f460a.f466b.m465c(), this.f460a.f466b.m466d(), false);
            Builder builder = new Builder(a2.a());
            builder.al = pollUploadParams;
            return a2.a(builder.a(), false);
        }
    }

    /* compiled from: view_group_tap */
    public class C00585 implements OnClickListener {
        final /* synthetic */ GroupsPollComposerPlugin f461a;

        public C00585(GroupsPollComposerPlugin groupsPollComposerPlugin) {
            this.f461a = groupsPollComposerPlugin;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    }

    @UserScoped
    /* compiled from: view_group_tap */
    public class Factory implements com.facebook.ipc.composer.plugin.ComposerPlugin.Factory {
        private static final Object f462b = new Object();
        private final GroupsPollComposerPluginProvider f463a;

        private static Factory m444b(InjectorLike injectorLike) {
            return new Factory((GroupsPollComposerPluginProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GroupsPollComposerPluginProvider.class));
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin.Factory m443a(com.facebook.inject.InjectorLike r7) {
            /*
            r2 = com.facebook.inject.ScopeSet.a();
            r0 = com.facebook.auth.userscope.UserScope.class;
            r0 = r7.getInstance(r0);
            r0 = (com.facebook.auth.userscope.UserScope) r0;
            r1 = r7.getScopeAwareInjector();
            r1 = r1.b();
            if (r1 != 0) goto L_0x001e;
        L_0x0016:
            r0 = new com.facebook.inject.ProvisioningException;
            r1 = "Called user scoped provider outside of context scope";
            r0.<init>(r1);
            throw r0;
        L_0x001e:
            r3 = r0.a(r1);
            r4 = r3.b();	 Catch:{ all -> 0x006c }
            r1 = f462b;	 Catch:{ all -> 0x006c }
            r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
            r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
            if (r1 != r5) goto L_0x0035;
        L_0x0030:
            r3.c();
            r0 = 0;
        L_0x0034:
            return r0;
        L_0x0035:
            if (r1 != 0) goto L_0x007c;
        L_0x0037:
            r1 = 4;
            r5 = r2.b(r1);	 Catch:{  }
            r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
            r0 = r6.e();	 Catch:{ all -> 0x0062 }
            r1 = m444b(r0);	 Catch:{ all -> 0x0062 }
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            if (r1 != 0) goto L_0x0071;
        L_0x004d:
            r0 = f462b;	 Catch:{  }
            r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
            r0 = (com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin.Factory) r0;	 Catch:{  }
        L_0x0057:
            if (r0 == 0) goto L_0x007a;
        L_0x0059:
            r2.c(r5);	 Catch:{  }
        L_0x005c:
            r0 = (com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin.Factory) r0;	 Catch:{  }
            r3.c();
            goto L_0x0034;
        L_0x0062:
            r0 = move-exception;
            com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x0067:
            r0 = move-exception;
            r2.c(r5);	 Catch:{  }
            throw r0;	 Catch:{  }
        L_0x006c:
            r0 = move-exception;
            r3.c();
            throw r0;
        L_0x0071:
            r0 = f462b;	 Catch:{  }
            r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
            r0 = (com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin.Factory) r0;	 Catch:{  }
            goto L_0x0057;
        L_0x007a:
            r0 = r1;
            goto L_0x0059;
        L_0x007c:
            r0 = r1;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin.Factory.a(com.facebook.inject.InjectorLike):com.facebook.groups.composer.groupspollcomposer.GroupsPollComposerPlugin$Factory");
        }

        @Inject
        public Factory(GroupsPollComposerPluginProvider groupsPollComposerPluginProvider) {
            this.f463a = groupsPollComposerPluginProvider;
        }

        public final String m446b() {
            return "GroupsPollComposerPluginConfig";
        }

        public final ComposerPluginDefault m445a(SerializedComposerPluginConfig serializedComposerPluginConfig, ComposerPluginSession composerPluginSession, @Nullable ComposerPlugin$InstanceState composerPlugin$InstanceState) {
            if (composerPlugin$InstanceState != null) {
                GroupsPollComposerPlugin.f465h = composerPlugin$InstanceState.f1138b;
            }
            GroupsPollComposerPluginProvider groupsPollComposerPluginProvider = this.f463a;
            return new GroupsPollComposerPlugin(composerPluginSession, (Context) groupsPollComposerPluginProvider.getInstance(Context.class), (OptimisticPostHelperProvider) groupsPollComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(OptimisticPostHelperProvider.class), (PublishAttachmentsHelperProvider) groupsPollComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishAttachmentsHelperProvider.class), (PublishStatusHelperProvider) groupsPollComposerPluginProvider.getOnDemandAssistedProviderForStaticDi(PublishStatusHelperProvider.class), FbObjectMapperMethodAutoProvider.a(groupsPollComposerPluginProvider), (AbstractFbErrorReporter) FbErrorReporterImpl.a(groupsPollComposerPluginProvider));
        }
    }

    @Nullable
    public final ComposerPlugin$InstanceState m456a() {
        if (this.f466b != null) {
            try {
                return ComposerPlugin$InstanceState.m1366a(this.f470f.a(this.f466b));
            } catch (Throwable e) {
                this.f471g.a(f464a, e);
            }
        }
        return ComposerPlugin$InstanceState.f1137a;
    }

    @Inject
    public GroupsPollComposerPlugin(@Assisted ComposerPluginSession composerPluginSession, Context context, OptimisticPostHelperProvider optimisticPostHelperProvider, PublishAttachmentsHelperProvider publishAttachmentsHelperProvider, PublishStatusHelperProvider publishStatusHelperProvider, FbObjectMapper fbObjectMapper, AbstractFbErrorReporter abstractFbErrorReporter) {
        super(context, composerPluginSession);
        this.f467c = optimisticPostHelperProvider;
        this.f468d = publishAttachmentsHelperProvider;
        this.f469e = publishStatusHelperProvider;
        this.f472i = context;
        this.f470f = fbObjectMapper;
        this.f471g = abstractFbErrorReporter;
    }

    @Nullable
    protected final BooleanGetter m454T() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<String> aB() {
        return new C00541(this);
    }

    @Nullable
    protected final BooleanGetter m450N() {
        return new C00552(this);
    }

    @Nullable
    protected final BooleanGetter m447H() {
        return BooleanGetter.b;
    }

    @Nullable
    public final BooleanGetter m458r() {
        return new C00563(this);
    }

    @Nullable
    protected final BooleanGetter m448L() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter ac() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m451P() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter m452Q() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m453R() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aA() {
        return BooleanGetter.a;
    }

    public final void m457b(ViewStub viewStub) {
        viewStub.setLayoutResource(2130904735);
        GroupsPollComposerFooterView groupsPollComposerFooterView = (GroupsPollComposerFooterView) viewStub.inflate();
        this.f472i = groupsPollComposerFooterView.getContext();
        if (StringUtil.a(f465h)) {
            this.f466b = new GroupsPollDataModel();
        } else {
            try {
                this.f466b = (GroupsPollDataModel) this.f470f.a(f465h, GroupsPollDataModel.class);
            } catch (Throwable e) {
                this.f471g.a(f464a, e);
                this.f466b = new GroupsPollDataModel();
            } finally {
                f465h = null;
            }
        }
        groupsPollComposerFooterView.m487a(this.f466b);
    }

    @Nullable
    protected final BooleanGetter aD() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter aK() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aF() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final Getter<Intent> m455V() {
        return new C00574(this);
    }

    protected final BooleanGetter aM() {
        return BooleanGetter.b;
    }

    protected final BooleanGetter aL() {
        return BooleanGetter.b;
    }

    @Nullable
    protected final BooleanGetter m449M() {
        return BooleanGetter.b;
    }
}

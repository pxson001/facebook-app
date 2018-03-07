package com.facebook.platform.composer.titlebar;

import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.funnellogger.FunnelLoggerImpl;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.platform.composer.composer.PlatformComposerFragment;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05317;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;
import com.google.common.collect.Sets;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: result_index */
public class PlatformComposerTargetSelectorController {
    private final WeakReference<TargetSelectorClient> f4425a;
    private final WeakReference<DataProvider> f4426b;
    private final PlatformComposerTargetTypesBuilder f4427c;
    public final Resources f4428d;
    public final Boolean f4429e;
    private final ImmutableMap<TargetType, PlatformComposerTargetSelectionInfo> f4430f;
    public final FunnelLoggerImpl f4431g;
    public final ComposerMultimediaCapability f4432h;

    /* compiled from: result_index */
    class TargetState {
        public final boolean f4424a;

        /* compiled from: result_index */
        public class Builder {
            public boolean f4423a = false;

            public final TargetState m4291a() {
                return new TargetState(this);
            }
        }

        public TargetState(Builder builder) {
            this.f4424a = builder.f4423a;
        }

        public String toString() {
            return "(isHidden=" + this.f4424a + ")";
        }
    }

    @Inject
    public PlatformComposerTargetSelectorController(PlatformComposerTargetTypesBuilder platformComposerTargetTypesBuilder, FunnelLoggerImpl funnelLoggerImpl, Resources resources, Boolean bool, ComposerMultimediaCapability composerMultimediaCapability, @Assisted PlatformComposerFragment platformComposerFragment, @Assisted C05317 c05317) {
        this.f4427c = platformComposerTargetTypesBuilder;
        this.f4432h = composerMultimediaCapability;
        Builder builder = ImmutableMap.builder();
        for (PlatformComposerTargetSelectionInfo platformComposerTargetSelectionInfo : PlatformComposerTargetInfoProvider.m4289a()) {
            builder.b(platformComposerTargetSelectionInfo.f4413a, platformComposerTargetSelectionInfo);
        }
        this.f4430f = builder.b();
        this.f4425a = new WeakReference(Preconditions.checkNotNull(platformComposerFragment));
        this.f4426b = new WeakReference(Preconditions.checkNotNull(c05317));
        this.f4428d = resources;
        this.f4431g = funnelLoggerImpl;
        this.f4429e = bool;
    }

    public final void m4295a(PopoverMenu popoverMenu) {
        ImmutableMap b = m4293b();
        final PlatformComposerFragment platformComposerFragment = (PlatformComposerFragment) Preconditions.checkNotNull(this.f4425a.get(), "targetSelectorClient was garbage collected");
        popoverMenu.clear();
        Iterator it = b.keySet().iterator();
        while (it.hasNext()) {
            final TargetType targetType = (TargetType) it.next();
            if (!((TargetState) b.get(targetType)).f4424a) {
                PlatformComposerTargetSelectionInfo platformComposerTargetSelectionInfo = (PlatformComposerTargetSelectionInfo) this.f4430f.get(targetType);
                if (platformComposerTargetSelectionInfo != null) {
                    String string;
                    Preconditions.checkNotNull(targetType);
                    Preconditions.checkNotNull(platformComposerTargetSelectionInfo);
                    if (targetType == TargetType.UNDIRECTED) {
                        string = this.f4428d.getString(this.f4429e.booleanValue() ? 2131234524 : 2131234523);
                    } else {
                        string = this.f4428d.getString(platformComposerTargetSelectionInfo.f4415c);
                    }
                    MenuItemImpl a = popoverMenu.a(0, platformComposerTargetSelectionInfo.f4414b, string);
                    a.setIcon(platformComposerTargetSelectionInfo.f4416d);
                    a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ PlatformComposerTargetSelectorController f4420c;

                        public boolean onMenuItemClick(MenuItem menuItem) {
                            platformComposerFragment.m4080a(targetType);
                            this.f4420c.f4431g.b(FunnelRegistry.l, "launch_target_selection_clicked");
                            return true;
                        }
                    });
                }
            }
        }
    }

    public final boolean m4296a() {
        C05317 c05317 = (C05317) Preconditions.checkNotNull(this.f4426b.get(), "dataProvider was garbage collected");
        if (c05317.f4104a.aO.f4188c.m4152d()) {
            return false;
        }
        return (c05317.f4104a.aO.f4190e.targetType == TargetType.UNDIRECTED && ImmutableSet.of(TargetType.UNDIRECTED).equals(m4292a(m4293b()))) ? false : true;
    }

    private ImmutableMap<TargetType, TargetState> m4293b() {
        Map hashMap = new HashMap();
        final C05317 c05317 = (C05317) Preconditions.checkNotNull(this.f4426b.get(), "dataProvider was garbage collected");
        Iterable iterable;
        if (this.f4427c.f4435c) {
            iterable = PlatformComposerTargetTypesBuilder.f4434b;
        } else {
            iterable = PlatformComposerTargetTypesBuilder.f4433a;
        }
        for (TargetType put : Sets.a(r5, TargetType.class)) {
            hashMap.put(put, new Builder());
        }
        ImmutableMap copyOf = ImmutableMap.copyOf(Maps.a(hashMap, new EntryTransformer<TargetType, Builder, TargetState>(this) {
            final /* synthetic */ PlatformComposerTargetSelectorController f4422b;

            public final Object m4290a(Object obj, Object obj2) {
                TargetType targetType = (TargetType) obj;
                Builder builder = (Builder) obj2;
                if (!AttachmentUtils.l(c05317.f4104a.aO.f4188c.m4153e()) || this.f4422b.f4432h.a(targetType, false)) {
                    if (PlatformComposerFragment.aJ(c05317.f4104a)) {
                        Object obj3;
                        PlatformComposerTargetSelectorController platformComposerTargetSelectorController = this.f4422b;
                        if (targetType == TargetType.UNDIRECTED) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            builder.f4423a = true;
                            return builder.m4291a();
                        }
                    }
                    return builder.m4291a();
                }
                builder.f4423a = true;
                return builder.m4291a();
            }
        }));
        Preconditions.checkState(!m4292a(copyOf).isEmpty(), "No active targets! Target states: " + copyOf);
        return copyOf;
    }

    private static ImmutableSet<TargetType> m4292a(ImmutableMap<TargetType, TargetState> immutableMap) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator it = immutableMap.keySet().iterator();
        while (it.hasNext()) {
            TargetType targetType = (TargetType) it.next();
            if (!((TargetState) immutableMap.get(targetType)).f4424a) {
                builder.c(targetType);
            }
        }
        return builder.b();
    }

    public final Class m4294a(TargetType targetType) {
        return ((PlatformComposerTargetSelectionInfo) this.f4430f.get(targetType)).f4417e;
    }
}

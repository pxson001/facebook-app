package com.facebook.messaging.composershortcuts;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.composershortcuts.ComposerShortcutsContainer.ComposerShortcutState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: messaging_emoji_schema */
public class DefaultComposerShortcutsContainerMeasurer {
    private final int f10059a;
    private ImmutableList<ComposerShortcutItem> f10060b;
    private Map<String, ComposerShortcutState> f10061c;
    private boolean f10062d;
    private int f10063e;
    public ComposerShortcutState f10064f;
    public ComposerShortcutsContainerMeasurer$Result f10065g = new ComposerShortcutsContainerMeasurer$Result();

    public static DefaultComposerShortcutsContainerMeasurer m10571b(InjectorLike injectorLike) {
        return new DefaultComposerShortcutsContainerMeasurer(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    DefaultComposerShortcutsContainerMeasurer(Resources resources) {
        this.f10059a = resources.getDimensionPixelSize(2131427826);
    }

    public final ComposerShortcutsContainerMeasurer$Result m10574a(ImmutableList<ComposerShortcutItem> immutableList, ComposerShortcutItem composerShortcutItem, Map<String, ComposerShortcutState> map, boolean z, boolean z2, int i) {
        this.f10063e = i / this.f10059a;
        this.f10064f = null;
        this.f10060b = immutableList;
        this.f10061c = map;
        this.f10062d = z;
        this.f10065g.f10051c.clear();
        this.f10065g.f10049a.clear();
        if (z2) {
            m10568a();
        } else {
            m10572b();
        }
        if (this.f10064f != null) {
            if (this.f10065g.f10051c.isEmpty()) {
                this.f10065g.f10049a.add(this.f10064f.f10012a);
            } else {
                this.f10065g.f10051c.add(0, this.f10064f.f10012a);
            }
        }
        if (!this.f10065g.f10051c.isEmpty()) {
            this.f10065g.f10049a.add(composerShortcutItem);
        }
        return this.f10065g;
    }

    private void m10568a() {
        UnmodifiableIterator it = this.f10060b.iterator();
        while (it.hasNext()) {
            ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) it.next();
            boolean z = composerShortcutItem.f9981j || composerShortcutItem.f9982k;
            m10570a(composerShortcutItem, z);
        }
    }

    private void m10572b() {
        UnmodifiableIterator it = this.f10060b.iterator();
        while (it.hasNext()) {
            ComposerShortcutItem composerShortcutItem = (ComposerShortcutItem) it.next();
            if (composerShortcutItem.f9981j) {
                m10569a(composerShortcutItem);
            } else {
                m10573b(composerShortcutItem);
            }
        }
    }

    private void m10569a(ComposerShortcutItem composerShortcutItem) {
        Preconditions.checkArgument(composerShortcutItem.f9981j);
        m10570a(composerShortcutItem, true);
    }

    private void m10573b(ComposerShortcutItem composerShortcutItem) {
        boolean z;
        if (composerShortcutItem.f9981j) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        m10570a(composerShortcutItem, false);
    }

    private void m10570a(ComposerShortcutItem composerShortcutItem, boolean z) {
        ComposerShortcutState composerShortcutState = (ComposerShortcutState) this.f10061c.get(composerShortcutItem.f9973b);
        if (!composerShortcutState.f10013b) {
            return;
        }
        if (this.f10062d && !composerShortcutItem.f9981j) {
            return;
        }
        if (this.f10063e == 0 || !z) {
            this.f10065g.f10051c.add(composerShortcutItem);
        } else if (this.f10063e == 1) {
            this.f10064f = composerShortcutState;
            this.f10063e--;
        } else {
            this.f10065g.f10049a.add(composerShortcutItem);
            this.f10063e--;
        }
    }
}

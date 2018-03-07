package com.facebook.groups.staticadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: www.dev.facebook.com */
public class StaticAdapter {

    /* compiled from: www.dev.facebook.com */
    public interface Section<V extends View> {
        ViewType<V> mo10a();

        void mo11a(V v);
    }

    /* compiled from: www.dev.facebook.com */
    public abstract class AbstractSection<V extends View> implements Section<V> {
        private final ViewType<V> f268a;

        public AbstractSection(ViewType<V> viewType) {
            this.f268a = viewType;
        }

        public final ViewType<V> mo10a() {
            return this.f268a;
        }
    }

    /* compiled from: www.dev.facebook.com */
    public interface ViewType<V extends View> {
        V mo12a(ViewGroup viewGroup);
    }

    /* compiled from: www.dev.facebook.com */
    public interface Bindable<M> {
        void mo758a(M m);
    }

    /* compiled from: www.dev.facebook.com */
    public class BindableSection<V extends View, M> implements Section<V> {
        private final ViewType<V> f353a;
        private final M f354b;

        public BindableSection(ViewType<V> viewType, M m) {
            this.f353a = viewType;
            this.f354b = m;
        }

        public final void mo11a(V v) {
            if (v instanceof Bindable) {
                ((Bindable) v).mo758a(this.f354b);
            }
        }

        public final ViewType<V> mo10a() {
            return this.f353a;
        }
    }

    /* compiled from: www.dev.facebook.com */
    public class InflatingViewType<T extends View> implements ViewType<T> {
        private final int f355a;

        public InflatingViewType(int i) {
            this.f355a = i;
        }

        public final T mo12a(ViewGroup viewGroup) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(this.f355a, viewGroup, false);
        }
    }

    /* compiled from: www.dev.facebook.com */
    public final class StaticSection<V extends View> extends AbstractSection<V> {
        public StaticSection(ViewType<V> viewType) {
            super(viewType);
        }

        public final void mo11a(V v) {
        }
    }
}

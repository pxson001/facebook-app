package com.facebook.controller.connectioncontroller;

import android.annotation.SuppressLint;
import com.facebook.controller.connectioncontroller.common.ConnectionChunk;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionListenerAnnouncer;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation.LocationType;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionState;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

/* compiled from: min_webrtc_version */
public class PiecemealConnectionController<TEdge, TUserInfo> implements ConnectionController<TEdge, TUserInfo> {
    public final ConnectionController<TEdge, TUserInfo> f7639a;
    public final ConnectionListenerAnnouncer<TEdge> f7640b;
    public PiecemealConnectionState<TEdge> f7641c;

    /* compiled from: min_webrtc_version */
    public class PiecemealConnectionState<TEdge> implements ConnectionState<TEdge> {
        private static final ConnectionLocation f7936e = new ConnectionLocation(null, LocationType.AFTER, true);
        public ConnectionState<TEdge> f7937a;
        public int f7938b;
        public final int f7939c;
        private final int f7940d;

        PiecemealConnectionState(ConnectionState<TEdge> connectionState, int i, int i2) {
            this.f7937a = connectionState;
            this.f7939c = i;
            this.f7940d = i2;
            int d = this.f7937a.mo625d();
            if (d < this.f7939c) {
                this.f7938b = d;
            } else {
                this.f7938b = this.f7939c;
            }
        }

        final int m8258f() {
            return this.f7937a.mo625d() - this.f7938b;
        }

        final int m8259g() {
            int f = m8258f();
            int i = this.f7938b > 0 ? this.f7940d : this.f7939c;
            if (i <= f) {
                this.f7938b += i;
                return i;
            }
            this.f7938b += f;
            return f;
        }

        public final int mo625d() {
            return this.f7938b;
        }

        public final TEdge mo622a(int i) {
            Preconditions.checkArgument(i < this.f7938b);
            return this.f7937a.mo622a(i);
        }

        public final ImmutableList<ConnectionChunk> mo626e() {
            return this.f7937a.mo626e();
        }

        public final ConnectionLocation mo621a() {
            return this.f7937a.mo621a();
        }

        public final ConnectionLocation mo623b() {
            return this.f7937a.mo623b();
        }

        public final ConnectionLocation mo624c() {
            if (this.f7938b < this.f7937a.mo625d()) {
                return f7936e;
            }
            return this.f7937a.mo624c();
        }
    }

    /* compiled from: min_webrtc_version */
    class C03861 implements ConnectionListener<TEdge> {
        final /* synthetic */ PiecemealConnectionController f7945a;

        C03861(PiecemealConnectionController piecemealConnectionController) {
            this.f7945a = piecemealConnectionController;
        }

        public final void mo627a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f7945a.f7640b.mo627a(connectionLocation, connectionOrder);
        }

        public final void mo630b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f7945a.f7640b.mo630b(connectionLocation, connectionOrder);
        }

        public final void mo628a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            this.f7945a.f7640b.mo628a(connectionLocation, connectionOrder, th);
        }

        public final void mo633a(int i, int i2, boolean z) {
            PiecemealConnectionController.m7996g(this.f7945a);
            if (i < this.f7945a.f7641c.mo625d()) {
                PiecemealConnectionState piecemealConnectionState = this.f7945a.f7641c;
                piecemealConnectionState.f7938b += i2;
                this.f7945a.f7640b.mo633a(i, i2, z);
                return;
            }
            this.f7945a.f7640b.mo633a(this.f7945a.f7641c.mo625d(), this.f7945a.f7641c.m8259g(), z);
        }

        public final void mo632a(int i, int i2) {
            PiecemealConnectionController.m7996g(this.f7945a);
            if (i < this.f7945a.f7641c.mo625d()) {
                if (i2 > this.f7945a.f7641c.mo625d() - i) {
                    i2 = this.f7945a.f7641c.mo625d() - i;
                }
                this.f7945a.f7640b.mo632a(i, i2);
            }
        }

        public final void mo634b(int i, int i2) {
            PiecemealConnectionController.m7996g(this.f7945a);
            if (i < this.f7945a.f7641c.mo625d()) {
                if (i2 > this.f7945a.f7641c.mo625d() - i) {
                    i2 = this.f7945a.f7641c.mo625d() - i;
                }
                PiecemealConnectionState piecemealConnectionState = this.f7945a.f7641c;
                piecemealConnectionState.f7938b -= i2;
                this.f7945a.f7640b.mo634b(i, i2);
            }
        }

        public final void mo631a() {
            PiecemealConnectionController.m7996g(this.f7945a);
            this.f7945a.f7640b.mo631a();
        }
    }

    public PiecemealConnectionController(ConnectionController<TEdge, TUserInfo> connectionController) {
        this(connectionController, 6, 6);
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private PiecemealConnectionController(ConnectionController<TEdge, TUserInfo> connectionController, int i, int i2) {
        this.f7639a = connectionController;
        this.f7641c = new PiecemealConnectionState(this.f7639a.mo644d(), i, i2);
        this.f7640b = new ConnectionListenerAnnouncer();
        this.f7639a.mo637a(new C03861(this));
    }

    public final void mo636a(int i, TUserInfo tUserInfo) {
        this.f7639a.mo636a(i, (Object) tUserInfo);
    }

    public final void mo641b(int i, TUserInfo tUserInfo) {
        int f = this.f7641c.m8258f();
        if (f > 0) {
            this.f7640b.mo633a(this.f7641c.mo625d(), this.f7641c.m8259g(), false);
        }
        if (f < i) {
            this.f7639a.mo641b(i, tUserInfo);
        }
    }

    public final void mo638a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, int i, TUserInfo tUserInfo) {
        this.f7639a.mo638a(connectionLocation, connectionOrder, i, tUserInfo);
    }

    public final void mo635a() {
        this.f7639a.mo635a();
    }

    public final void mo640b() {
        this.f7639a.mo640b();
    }

    public final void mo643c() {
        this.f7639a.mo643c();
    }

    public final void mo637a(ConnectionListener<TEdge> connectionListener) {
        this.f7640b.m8246a(connectionListener);
    }

    public final void mo642b(ConnectionListener<TEdge> connectionListener) {
        this.f7640b.m8250b(connectionListener);
    }

    public final ConnectionState<TEdge> mo644d() {
        m7996g(this);
        return this.f7641c;
    }

    public static void m7996g(PiecemealConnectionController piecemealConnectionController) {
        PiecemealConnectionState piecemealConnectionState = piecemealConnectionController.f7641c;
        ConnectionState d = piecemealConnectionController.f7639a.mo644d();
        if (piecemealConnectionState.f7937a != d) {
            piecemealConnectionState.f7937a = d;
        }
        if (piecemealConnectionState.f7937a.mo625d() < piecemealConnectionState.f7938b) {
            piecemealConnectionState.f7938b = piecemealConnectionState.f7937a.mo625d();
        }
    }

    public final MutationControllerManager mo645e() {
        return this.f7639a.mo645e();
    }

    public final void mo639a(String str, Predicate<TEdge> predicate) {
        this.f7639a.mo639a(str, (Predicate) predicate);
    }
}

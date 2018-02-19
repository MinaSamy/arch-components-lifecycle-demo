package com.lifecycledemo.minawissa.lifecycledemo

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log


class MyLifeCycleObserver(val lifeCycle: Lifecycle) : LifecycleObserver {

    companion object {
        private const val TAG = "MyObserver"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logCreate() {
        Log.d(TAG, "Activity created")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logStart() {
        if (lifeCycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            Log.d(TAG, "Activity started")
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logResume() {
        Log.d(TAG, "Activity resumed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logStop() {
        Log.d(TAG, "Activity will stop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logPause() {
        Log.d(TAG, "Activity will pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logDestroy() {
        if(lifeCycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)){
            Log.d(TAG, "Activity will be destroyed")
        }
    }
}
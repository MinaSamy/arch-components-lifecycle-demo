package com.lifecycledemo.minawissa.lifecycledemo
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MyLifeCycleObserver(private val lifeCycle: Lifecycle, private val logger: MyLogger) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logCreate() {
        logger.logCreate()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logStart() {
        if (lifeCycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            logger.logStart()
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logResume() {
        logger.logResume()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logPause() {
        logger.logPause()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logStop() {
        logger.logStop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logDestroy() {
        if (lifeCycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)) {
            logger.logDestroy()
        }
    }
}
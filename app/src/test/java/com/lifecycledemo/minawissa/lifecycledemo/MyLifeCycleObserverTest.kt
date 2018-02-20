package com.lifecycledemo.minawissa.lifecycledemo

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LifecycleRegistry
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class MyLifeCycleObserverTest {

    lateinit var lifeCycleObserver: MyLifeCycleObserver
    lateinit var lifeCycle: LifecycleRegistry
    val logger = mock(MyLogger::class.java)

    @Before
    fun setUp() {
        val lifeCycleOwner: LifecycleOwner = mock(LifecycleOwner::class.java)
        lifeCycle = LifecycleRegistry(lifeCycleOwner)
        lifeCycleObserver = MyLifeCycleObserver(lifeCycle, logger)
        lifeCycle.addObserver(lifeCycleObserver)

        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    @Test
    fun shouldLogCreate() {
        lifeCycle.markState(Lifecycle.State.CREATED)
        verify(logger).logCreate()
    }

    @Test
    fun shouldLogStart() {
        lifeCycle.markState(Lifecycle.State.STARTED)
        verify(logger).logStart()
    }

    @Test
    fun shouldLogResume() {
        lifeCycle.markState(Lifecycle.State.RESUMED)
        verify(logger).logResume()
    }

    @Test
    fun shouldLogPause() {
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        verify(logger).logPause()
    }

    @Test
    fun shouldLogStop() {
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        verify(logger).logStop()
    }

    @Test
    fun shouldLogDestroy() {
        lifeCycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        verify(logger).logDestroy()
    }

}
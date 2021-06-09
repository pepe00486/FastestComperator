package com.edge.fastestcomperator;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class ExecutionListener extends RunListener
{
    /**
     *  Called when an atomic test is about to be started.
     * */
    public void testStarted(final Description description)
    {
        System.out.println("Test case : "+ description.getMethodName());
    }
}
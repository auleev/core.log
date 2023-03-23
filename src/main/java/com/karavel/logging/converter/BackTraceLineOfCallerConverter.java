package com.karavel.logging.converter;

import ch.qos.logback.classic.pattern.LineOfCallerConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;


public class BackTraceLineOfCallerConverter extends LineOfCallerConverter {
    // ************************************************************************************
    // CONSTANTES
    // ************************************************************************************

    // ************************************************************************************
    // ATTRIBUTS
    // ************************************************************************************

    // ************************************************************************************
    // CONSTRUCTEURS
    // ************************************************************************************

    // ************************************************************************************
    // METHODES PUBLIQUES
    // ************************************************************************************
    /**
     * An override of the original logback implementation to get the line number
     * of the calling class.
     *
     * @param event
     *            The logging event.
     * @return The calling classe's line number
     */
    @Override
    public String convert(ILoggingEvent event) {
        // we assume the logger name is the FQN of the class which it belongs to
        String originalLoggerCallerClassName = event.getLoggerName();
        StackTraceElement[] callerData = event.getCallerData();
        if (callerData != null && callerData.length > 0) {
            // dig into the stacktrace to find the correct class name from which
            // to get the line number from.
            for (StackTraceElement element : callerData) {
                String stackClass = element.getClassName();
                if (stackClass != null && stackClass.startsWith(originalLoggerCallerClassName)) {
                    return Integer.toString(element.getLineNumber());
                }
            }
        }
        // In case we didn't find the right line number from the caller, fall
        // back to logback's solution.
        return super.convert(event);
    }
    // ************************************************************************************
    // METHODES PRIVEES
    // ************************************************************************************

    // ************************************************************************************
    // ACCESSEURS
    // ************************************************************************************
}

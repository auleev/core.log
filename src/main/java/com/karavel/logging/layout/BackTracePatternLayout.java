package com.karavel.logging.layout;

import java.util.Map;
import ch.qos.logback.classic.PatternLayout;
import com.karavel.logging.converter.BackTraceLineOfCallerConverter;


public class BackTracePatternLayout extends PatternLayout {
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
     * Get the default converter map and replace the line number attribute
     * (namely "L" and "line") from the default converter to Artifactory's
     *
     * @return The default modified converter map.
     */
    @Override
    public Map<String, String> getDefaultConverterMap() {
        Map<String, String> map = super.getDefaultConverterMap();
        map.put("L", BackTraceLineOfCallerConverter.class.getName());
        map.put("line", BackTraceLineOfCallerConverter.class.getName());
        return map;
    }
    // ************************************************************************************
    // METHODES PRIVEES
    // ************************************************************************************

    // ************************************************************************************
    // ACCESSEURS
    // ************************************************************************************
}

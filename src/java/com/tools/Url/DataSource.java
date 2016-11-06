/*
 * This code was developed by Edmundo Carrillo on java technologies.
 * Contact: edmundodev@gmail.com
 * Hope you'll find it useful.
 */
package com.tools.Url;

public enum DataSource {
    METAR {
        @Override
        public String toString() {
            return "metars";
        }
    },
    TAF {
        @Override
        public String toString() {
            return "tafs";
        }
    },
    ACCESSKEY {
        @Override
        public String toString() {
            return "5b6df701c02c630d";
        }
    },
    BFCONDITIONS {
        @Override
        public String toString() {
            return "conditions";
        }
    },
    BFORECAST {
        @Override
        public String toString() {
            return "forecast";
        }

    },
    LANGUAGE {
        @Override
        public String toString() {
            return "lang:SP";
        };

    }

}

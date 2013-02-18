/*
 *  Copyright 2010-2013, Plutext Pty Ltd.
 *   
 *  This file is part of xlsx4j, a component of docx4j.

    docx4j is licensed under the Apache License, Version 2.0 (the "License"); 
    you may not use this file except in compliance with the License. 

    You may obtain a copy of the License at 

        http://www.apache.org/licenses/LICENSE-2.0 

    Unless required by applicable law or agreed to in writing, software 
    distributed under the License is distributed on an "AS IS" BASIS, 
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
    See the License for the specific language governing permissions and 
    limitations under the License.

 */
package org.xlsx4j.sml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ST_Axis.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ST_Axis">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="axisRow"/>
 *     &lt;enumeration value="axisCol"/>
 *     &lt;enumeration value="axisPage"/>
 *     &lt;enumeration value="axisValues"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ST_Axis")
@XmlEnum
public enum STAxis {

    @XmlEnumValue("axisRow")
    AXIS_ROW("axisRow"),
    @XmlEnumValue("axisCol")
    AXIS_COL("axisCol"),
    @XmlEnumValue("axisPage")
    AXIS_PAGE("axisPage"),
    @XmlEnumValue("axisValues")
    AXIS_VALUES("axisValues");
    private final String value;

    STAxis(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static STAxis fromValue(String v) {
        for (STAxis c: STAxis.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

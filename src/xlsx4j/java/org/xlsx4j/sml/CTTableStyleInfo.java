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

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.ppp.Child;


/**
 * <p>Java class for CT_TableStyleInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CT_TableStyleInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" type="{http://schemas.openxmlformats.org/officeDocument/2006/sharedTypes}ST_Xstring" />
 *       &lt;attribute name="showFirstColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="showLastColumn" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="showRowStripes" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="showColumnStripes" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_TableStyleInfo")
public class CTTableStyleInfo implements Child
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "showFirstColumn")
    protected Boolean showFirstColumn;
    @XmlAttribute(name = "showLastColumn")
    protected Boolean showLastColumn;
    @XmlAttribute(name = "showRowStripes")
    protected Boolean showRowStripes;
    @XmlAttribute(name = "showColumnStripes")
    protected Boolean showColumnStripes;
    @XmlTransient
    private Object parent;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the showFirstColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowFirstColumn() {
        return showFirstColumn;
    }

    /**
     * Sets the value of the showFirstColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowFirstColumn(Boolean value) {
        this.showFirstColumn = value;
    }

    /**
     * Gets the value of the showLastColumn property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowLastColumn() {
        return showLastColumn;
    }

    /**
     * Sets the value of the showLastColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowLastColumn(Boolean value) {
        this.showLastColumn = value;
    }

    /**
     * Gets the value of the showRowStripes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowRowStripes() {
        return showRowStripes;
    }

    /**
     * Sets the value of the showRowStripes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowRowStripes(Boolean value) {
        this.showRowStripes = value;
    }

    /**
     * Gets the value of the showColumnStripes property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isShowColumnStripes() {
        return showColumnStripes;
    }

    /**
     * Sets the value of the showColumnStripes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setShowColumnStripes(Boolean value) {
        this.showColumnStripes = value;
    }

    /**
     * Gets the parent object in the object tree representing the unmarshalled xml document.
     * 
     * @return
     *     The parent object.
     */
    public Object getParent() {
        return this.parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    /**
     * This method is invoked by the JAXB implementation on each instance when unmarshalling completes.
     * 
     * @param parent
     *     The parent object in the object tree.
     * @param unmarshaller
     *     The unmarshaller that generated the instance.
     */
    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        setParent(parent);
    }

}

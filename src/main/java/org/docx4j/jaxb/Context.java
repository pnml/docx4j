/*
 *  Copyright 2007-2008, Plutext Pty Ltd.
 *   
 *  This file is part of docx4j.

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
package org.docx4j.jaxb;


import org.apache.log4j.Logger;
import org.docx4j.utils.Log4jConfigurator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class Context {
	
	public static JAXBContext jc;
	public static JAXBContext jcThemePart;
	public static JAXBContext jcDocPropsCore;
	public static JAXBContext jcDocPropsCustom;
	public static JAXBContext jcDocPropsExtended;
	public static JAXBContext jcRelationships;
	public static JAXBContext jcCustomXmlProperties;
	public static JAXBContext jcContentTypes;

	public static JAXBContext jcXmlPackage;
	
	private static JAXBContext jcXslFo;
	public static JAXBContext jcSectionModel;

	public static JAXBContext jcXmlDSig;
	
	private static Logger log = Logger.getLogger(Context.class);
	
	private static boolean MOXy_intended = false;
	
	static {
	  
		Log4jConfigurator.configure();
		
		// Display diagnostic info about version of JAXB being used.
/*
		Object namespacePrefixMapper;
		try {
			namespacePrefixMapper = NamespacePrefixMapperUtils.getPrefixMapper();
			try {
				File f = new File("src/main/java/org/docx4j/wml/jaxb.properties");
				if (f.exists() ) {
					log.info("MOXy JAXB implementation intended..");
					MOXy_intended = true;
				} else {
					InputStream is = ResourceUtils.getResource("org/docx4j/wml/jaxb.properties");
					log.info("MOXy JAXB implementation intended..");
					MOXy_intended = true;
				}
			} catch (Exception e2) {
				log.error(e2.getMessage());
				try {
					InputStream is = ResourceUtils.getResource("org/docx4j/wml/jaxb.properties");
					log.info("MOXy JAXB implementation intended..");
					MOXy_intended = true;
				} catch (Exception e3) {
					log.error(e3.getMessage());
					if ( namespacePrefixMapper.getClass().getName().equals("org.docx4j.jaxb.NamespacePrefixMapperSunInternal") ) {
						// Java 6
						log.info("Using Java 6/7 JAXB implementation");
					} else {
						log.info("Using JAXB Reference Implementation");			
					}
				}
			}
		} catch (JAXBException e) {
			log.error("PANIC! No suitable JAXB implementation available");
			e.printStackTrace();
		}
*/

      try { 
			
			// JBOSS might use a different class loader to load JAXBContext, which causes problems,
			// so explicitly specify our class loader.
			Context tmp = new Context();
			java.lang.ClassLoader classLoader = tmp.getClass().getClassLoader();
			//log.info("\n\nClassloader: " + classLoader.toString() );			
			
			log.info("loading Context jc");		
						
			jc = JAXBContext.newInstance("org.docx4j.wml:" +
					"org.docx4j.dml:org.docx4j.dml.chart:org.docx4j.dml.chartDrawing:org.docx4j.dml.compatibility:org.docx4j.dml.diagram:org.docx4j.dml.lockedCanvas:org.docx4j.dml.picture:org.docx4j.dml.wordprocessingDrawing:org.docx4j.dml.spreadsheetdrawing:org.docx4j.dml.diagram2008:" +
					// All VML stuff is here, since compiling it requires WML and DML (and MathML), but not PML or SML
					"org.docx4j.vml:org.docx4j.vml.officedrawing:org.docx4j.vml.wordprocessingDrawing:org.docx4j.vml.presentationDrawing:org.docx4j.vml.spreadsheetDrawing:org.docx4j.vml.root:" +
					"org.opendope.xpaths:org.opendope.conditions:org.opendope.questions:org.opendope.answers:org.opendope.components:org.opendope.SmartArt.dataHierarchy:" +
					"org.docx4j.math:" +
					"org.docx4j.sharedtypes:org.docx4j.bibliography",classLoader );
			String jcImplementation = jc.getClass().getName();
			log.info("loaded " + jcImplementation + " .. loading others ..");
			if (MOXy_intended) {
				if (jcImplementation.contains("org.eclipse.persistence.jaxb.JAXBContext")) {
					log.info("MOXy is being used.");
				} else {
					log.warn("MOXy is not being used, for some reason.");					
				}
			}
			
			jcThemePart = jc; //JAXBContext.newInstance("org.docx4j.dml",classLoader );
			jcDocPropsCore = JAXBContext.newInstance("org.docx4j.docProps.core:org.docx4j.docProps.core.dc.elements:org.docx4j.docProps.core.dc.terms",classLoader );
			jcDocPropsCustom = JAXBContext.newInstance("org.docx4j.docProps.custom",classLoader );
			jcDocPropsExtended = JAXBContext.newInstance("org.docx4j.docProps.extended",classLoader );
			jcXmlPackage = JAXBContext.newInstance("org.docx4j.xmlPackage",classLoader );
			jcRelationships = JAXBContext.newInstance("org.docx4j.relationships",classLoader );
			jcCustomXmlProperties = JAXBContext.newInstance("org.docx4j.customXmlProperties",classLoader );
			jcContentTypes = JAXBContext.newInstance("org.docx4j.openpackaging.contenttype",classLoader );
			
			jcSectionModel = JAXBContext.newInstance("org.docx4j.model.structure.jaxb",classLoader );
			
			jcXmlDSig = JAXBContext.newInstance("org.plutext.jaxb.xmldsig",classLoader );
			
			log.info(".. others loaded ..");
			
		} catch (Exception ex) {
			log.error("Cannot initialize context", ex);
		}				
	}
	
	private static org.docx4j.wml.ObjectFactory wmlObjectFactory;
	
	public static org.docx4j.wml.ObjectFactory getWmlObjectFactory() {
		
		if (wmlObjectFactory==null) {
			wmlObjectFactory = new org.docx4j.wml.ObjectFactory();
		}
		return wmlObjectFactory;
		
	}

	public static JAXBContext getXslFoContext() {
		if (jcXslFo==null) {
			try {	
				Context tmp = new Context();
				java.lang.ClassLoader classLoader = tmp.getClass().getClassLoader();

				jcXslFo = JAXBContext.newInstance("org.plutext.jaxb.xslfo",classLoader );
				
			} catch (JAXBException ex) {
	      log.error("Cannot determine XSL-FO context", ex);
			}						
		}
		return jcXslFo;		
	}
}

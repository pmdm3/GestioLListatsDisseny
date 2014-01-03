package Model;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXML {

	private DocumentBuilderFactory docFactory;
	private DocumentBuilder docBuilder;
	private Document doc;
	private Element rootElement;

	/**
	 * Constructor de la clase
	 */
	public CrearXML() {

		try {
			this.docFactory = DocumentBuilderFactory.newInstance();
			this.docBuilder = docFactory.newDocumentBuilder();

			// element arrel
			// es crea un objecte DOM
			this.doc = docBuilder.newDocument();
			// es crea un element arrel
			this.rootElement = doc.createElement("llistes");
			// el afegim perquè pengi del fitxer com arrel
			doc.appendChild(rootElement);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mètode per crear nodes de materias amb alumnes dins
	 * 
	 * @param materias
	 *            TreeSet de materias
	 * @param alumnes
	 *            TreeSet d'alumnes
	 */
	public void llistatMateria(Set<String> materias, TreeSet<Alumne> alumnes) {

		for (String auxMateria : materias) {
			// creació de l'element llista
			Element llistaMateria = this.doc.createElement("llista");
			// creació d'un atribut
			Attr attrLlista = this.doc.createAttribute("materia");
			attrLlista.setValue(auxMateria);
			// afegim l'atribut a l'element llista
			llistaMateria.setAttributeNode(attrLlista);

			for (Alumne auxAlumne : alumnes) {
				if (auxAlumne.getMateria().toString().contains(auxMateria)) {
					// creació de l'element alumne
					Element alu = this.doc.createElement("alumne");
					// el afegim perquè pengi del node llista
					llistaMateria.appendChild(alu);

					// creació de l'element cognomsNom
					Element noms = this.doc.createElement("cognomsNom");
					// creem un node de tipus text i li afegim el valor
					noms.appendChild(this.doc.createTextNode(auxAlumne.getCognoms() + ", " + auxAlumne.getNom()));
					// el afegim perquè pengi del node alumne
					alu.appendChild(noms);

					// creació de l'element grup
					Element group = this.doc.createElement("grup");
					// creem un node de tipus text i li afegim el valor
					group.appendChild(this.doc.createTextNode(auxAlumne.getGrup()));
					// el afegim perquè pengi del node alumne
					alu.appendChild(group);
				}
			}
			// afegir tot al node llista
			rootElement.appendChild(llistaMateria);
		}
	}

	/**
	 * Métode per enregistrar l'objecte DOM a disc
	 * 
	 * @param pathname
	 *            path on es vol desar el fitxer
	 */
	public void desarFitxer(String pathname) {

		try {
			// Enregistrar el contingut a disc
			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer trans = transFactory.newTransformer();
			// forma del document
			DOMSource source = new DOMSource(this.doc);
			StreamResult result = new StreamResult(new File(pathname));
			// Les següents línies són per indentar
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
                        //trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                        trans.setOutputProperty(OutputKeys.STANDALONE, "yes");
			trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                        trans.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			trans.transform(source, result);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public DocumentBuilderFactory getDocFactory() {
		return docFactory;
	}

	public void setDocFactory(DocumentBuilderFactory docFactory) {
		this.docFactory = docFactory;
	}

	public DocumentBuilder getDocBuilder() {
		return docBuilder;
	}

	public void setDocBuilder(DocumentBuilder docBuilder) {
		this.docBuilder = docBuilder;
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public Element getRootElement() {
		return rootElement;
	}

	public void setRootElement(Element rootElement) {
		this.rootElement = rootElement;
	}
}

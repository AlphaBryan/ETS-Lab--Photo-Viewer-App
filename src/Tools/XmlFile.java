package Tools;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

/**
 * reference : https://stackoverflow.com/questions/7373567/how-to-read-and-write-xml-files
 *
 */
public class XmlFile {
    private String path = null;
    private String sizeX = null;
    private String sizeY = null;
    private String positionX = null ;
    private String positionY = null ;


    public   Hashtable<String,String> readXML(String xml) {

        Hashtable<String,String> param=new Hashtable<String,String>();
        Document dom;
        // Make an  instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use the factory to take an instance of the document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // parse using the builder to get the DOM mapping of the
            // XML file
            dom = db.parse(xml);

            Element doc = dom.getDocumentElement();

            setPath(getTextValue(getPath(), doc, "path"));
            if (getPath() != null) {
                if (!getPath().isEmpty())
                    param.put("path", getPath());
            }
            setSizeX(getTextValue(getSizeX(), doc, "sizeX"));
            if (getSizeX() != null) {
                if (!getSizeX().isEmpty())
                    param.put("sizeX", getSizeX());
            }
            setSizeY(getTextValue(getSizeY(), doc, "sizeY"));
            if (getSizeY() != null) {
                if (!getSizeY().isEmpty())
                    param.put("sizeY", getSizeY());
            }
            setPositionX(getTextValue(getPositionX(), doc, "positionX"));
            if (getPositionX() != null) {
                if (!getPositionX().isEmpty())
                    param.put("positionX", getPositionX());
            }
            setPositionY(getTextValue(getPositionY(), doc, "positionY"));
            if (getPositionY() != null) {
                if (!getPositionY().isEmpty())
                    param.put("positionY", getPositionY());
            }

            return param;

        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        } catch (SAXException se) {
            System.out.println(se.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        return null;
    }
    public void saveToXML(String xml) {
        Document dom;
        Element e = null;

        // instance of a DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // use factory to get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();
            // create instance of DOM
            dom = db.newDocument();

            // create the root element
            Element rootEle = dom.createElement("parametres");

            // create data elements and place them under root
            e = dom.createElement("path");
            e.appendChild(dom.createTextNode(getPath()));
            rootEle.appendChild(e);

            e = dom.createElement("sizeX");
            e.appendChild(dom.createTextNode(getSizeX()));
            rootEle.appendChild(e);

            e = dom.createElement("sizeY");
            e.appendChild(dom.createTextNode(getSizeY()));
            rootEle.appendChild(e);

            e = dom.createElement("positionX");
            e.appendChild(dom.createTextNode(getPositionX()));
            rootEle.appendChild(e);

            e = dom.createElement("positionY");
            e.appendChild(dom.createTextNode(getPositionY()));
            rootEle.appendChild(e);


            dom.appendChild(rootEle);

            try {
                Transformer tr = TransformerFactory.newInstance().newTransformer();


                // send DOM to file
                tr.transform(new DOMSource(dom),
                        new StreamResult(new FileOutputStream(xml)));

            } catch (TransformerException te) {
                System.out.println(te.getMessage());
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        } catch (ParserConfigurationException pce) {
            System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
        }
    }

    private String getTextValue(String def, Element doc, String tag) {
        String value = def;
        NodeList nl;
        nl = doc.getElementsByTagName(tag);
        if (nl.getLength() > 0 && nl.item(0).hasChildNodes()) {
            value = nl.item(0).getFirstChild().getNodeValue();
        }
        return value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSizeX() {
        return sizeX;
    }

    public void setSizeX(String sizeX) {
        this.sizeX = sizeX;
    }

    public String getSizeY() {
        return sizeY;
    }

    public void setSizeY(String sizeY) {
        this.sizeY = sizeY;
    }

    public String getPositionX() {
        return positionX;
    }

    public void setPositionX(String positionX) {
        this.positionX = positionX;
    }

    public String getPositionY() {
        return positionY;
    }

    public void setPositionY(String positionY) {
        this.positionY = positionY;
    }
}

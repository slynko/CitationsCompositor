package com.khai.xmlnew.standard.base;

import com.khai.xmlnew.standard.model.MultipartSeparator;
import com.khai.xmlnew.standard.model.Separator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public abstract class BaseStandard implements StandardContract {

    protected Document xmlDocument;

    protected Map<String, Separator> separators;
    protected Map<String, MultipartSeparator> multipartSeparatorsBefore;
    protected Map<String, MultipartSeparator> multipartSeparatorsAfter;

    public BaseStandard(String standardPath) {
        separators = new HashMap();
        multipartSeparatorsBefore = new HashMap();
        multipartSeparatorsAfter = new HashMap();
        initStandard(standardPath);
    }

    @Override
    public void make() {
        fillSeparators();
        fillMultipartSeparators(Constants.XmlPathToNode.MULTIPART_SEPARATORS_BEFORE, multipartSeparatorsBefore);
        fillMultipartSeparators(Constants.XmlPathToNode.MULTIPART_SEPARATORS_AFTER, multipartSeparatorsAfter);
        fillCitationParts();
    }

    @Override
    public List<String> getTypes() {
        final List<String> types = new ArrayList<>();
        final List<Node> typesNodes = xmlDocument.selectNodes(Constants.XmlPathToNode.TYPES);
        for (Node typeNode : typesNodes) {
            final String typeTitle = typeNode.valueOf(Constants.XmlAttribute.TITLE);
            types.add(typeTitle);
        }
        return types;
    }

    private void initStandard(String standardPath) {
        final URL path = getClass().getClassLoader().getResource(standardPath);
        if (path == null) {
            throw new IllegalArgumentException("Something is wrong with standard's file path");
        }
        final File xmlSource = new File(path.getFile());
        final SAXReader reader = new SAXReader();
        try {
            xmlDocument = reader.read(xmlSource);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String getStringOfSingleNode(Node parentNode, String nodeName) {
        final Node singleNode = parentNode.selectSingleNode(nodeName);
        return singleNode != null ? singleNode.getStringValue() : null;
    }

    private void fillSeparators() {
        final List<Node> separators = xmlDocument.selectNodes(Constants.XmlPathToNode.SEPARATORS);
        for (Node node : separators) {
            final Separator separator = new Separator();
            final String name = node.valueOf(Constants.XmlAttribute.NAME);
            final String def = getStringOfSingleNode(node, Constants.XmlNode.DEFAULT);
            final String ru = getStringOfSingleNode(node, Constants.XmlNode.RU);
            final String ua = getStringOfSingleNode(node, Constants.XmlNode.UA);
            final String en = getStringOfSingleNode(node, Constants.XmlNode.EN);
            separator.setSymbolDef(def);
            separator.setSymbolRu(ru);
            separator.setSymbolUa(ua);
            separator.setSymbolEn(en);
            this.separators.put(name, separator);
        }
    }

    private void fillMultipartSeparators(String type, Map<String, MultipartSeparator> multipartSeparators) {
        final List<Node> multipartSeparatorsNodes = xmlDocument.selectNodes(type);
        final StringBuilder builder = new StringBuilder();
        for (Node nodeMultipartSeparator : multipartSeparatorsNodes) {
            final List<Node> separators = nodeMultipartSeparator.selectNodes(
                    Constants.XmlNode.SEPARATOR);
            builder.setLength(0);
            for (Node nodeSeparator : separators) {
                final String separatorName = nodeSeparator.valueOf(Constants.XmlAttribute.NAME);
                builder.append(this.separators.get(separatorName).getSymbolDef());
            }
            final MultipartSeparator multipartSeparator = new MultipartSeparator();
            multipartSeparator.setName(nodeMultipartSeparator.valueOf(Constants.XmlAttribute.NAME));
            multipartSeparator.setType(nodeMultipartSeparator.valueOf(Constants.XmlAttribute.TYPE));
            multipartSeparator.setValue(builder.toString());
            multipartSeparators.put(multipartSeparator.getName() + multipartSeparator.getType(),
                    multipartSeparator);
        }
    }

    protected abstract void fillCitationParts();

}
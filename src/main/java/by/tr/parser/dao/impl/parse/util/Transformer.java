package by.tr.parser.dao.impl.parse.util;

import by.tr.parser.dao.impl.parse.xml_namespace.TariffAttrName;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffTagName;

public class Transformer {
    private static final String XML_DELIMITER = "-";
    public static final String ENUM_DELIMITER = "_";


    public static TariffTagName getTagEnum(String tag){
        return TariffTagName.valueOf(tag.toUpperCase().replace(XML_DELIMITER,ENUM_DELIMITER));
    }

    public static String getTagString(TariffTagName tag){
        return String.valueOf(tag).toLowerCase().replace(ENUM_DELIMITER,XML_DELIMITER);
    }

    public static String getAttrString(TariffAttrName attrName){
        return String.valueOf(attrName).toLowerCase().replace(ENUM_DELIMITER,XML_DELIMITER);
    }
}

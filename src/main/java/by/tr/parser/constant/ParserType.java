package by.tr.parser.constant;

public enum ParserType {
    SAX, STAX, DOM;

    public static boolean contains(String command){
        for (ParserType parser:values()){
            if (command.toUpperCase().equals(parser.name())){
                return true;
            }
        }
        return false;
    }
}

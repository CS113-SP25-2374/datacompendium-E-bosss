package CS113.interfaces;

public class assembler7HW {

    public enum commandType {
        A_COMMAND,
        L_COMMAND,
        C_COMMAND,
        NO_COMMAND,
    }

    //DESCRIPTION: cleans raw instruction by removing non-essential parts
    //PRECONDITION: String parameter given (not null)
    //POSTCONDITION: returned without comments and whitespace

    public String cleanLine(String rawLine) {
        if(rawLine != null && rawLine.contains("//")) {
            rawLine = rawLine.substring(0, rawLine.indexOf("//")).trim();
        } else {
            rawLine = rawLine.trim();
        }

        return rawLine;
    }

    //DESCRIPTION: determines command type from parameter
//PRECONDITION: String parameter is clean instruction
//POSTCONDITION: returns A_COMMAND (A-instruction),
// C_COMMAND (C-instruction), L_COMMAND (Label) or
// NO_COMMAND (no command)

//    public Command parseCommandType(String cleanLine) {
//        if(cleanLine.contains("(") || cleanLine.contains(")")) {
//            return commandType = Command.L_COMMAND;
//        } else if(cleanLine.startsWith("@")) {
//            return commandType = Command.A_COMMAND;
//        } else if(cleanLine.startsWith("=") || cleanLine.contains(";")) {
//            return commandType = Command.C_COMMAND;
//        }
//
//        return commandType = Command.NO_COMMAND;
//    }
//

}

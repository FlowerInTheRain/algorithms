package al.go.heuristique.csvcalc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser implements Parsers {
    private static final Integer ALLOWED_STRING_LENGTH = 1;
    private static final List<String> allowedOperators = List.of("+", "-","*","/");
    private static boolean isFileAcceptable(String path) {
        int i = path.lastIndexOf('.');
        if (i > 0) {
            System.out.println(path.substring(i + 1));
            return path.substring(i + 1).equals("csv");
        }
        return false;
    }

    private static boolean isOperatorAcceptable(String operator){
        return operator != null && allowedOperators.contains(operator);
    }

    @Override
    public List<String> getFileContent(String path) throws FileNotFoundException {
        if (isFileAcceptable(path)) {
            List<String> instructions = new ArrayList<>();
            File inputFile = new File(path);
            Scanner myReader = new Scanner(inputFile);
            while (myReader.hasNextLine()) {
                instructions.add(myReader.nextLine());
            }
            myReader.close();
            return instructions;
        }
        throw new RuntimeException("Invalid file");
    }

    @Override
    public List<Integer> parse(List<String> lines) {
        if (lines.size() < 2) {
            throw new RuntimeException();
        }
        Character parsedOperator = lines.get(0).charAt(0);
        List<Integer> computableData = new ArrayList<>();
        for (String line : lines) {
            if (line.length() != ALLOWED_STRING_LENGTH) {
                throw new RuntimeException();
            } else {
                try {
                    computableData.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    throw new RuntimeException();
                }
            }
        }
        return computableData;
    }
}

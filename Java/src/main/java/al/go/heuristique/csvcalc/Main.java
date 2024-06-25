package al.go.heuristique.csvcalc;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        final String separator = "------";
        if(args.length != 2) {
            throw new RuntimeException("Invalid number of arguments, program will exit");
        }
        var fileName = args[0];
        var operator = args[1];
        System.out.println(fileName);
        Parsers parser = new Parser();
        try {
            var instructions = parser.getFileContent(fileName);
            var calculatorData = parser.parse(instructions);
            if(calculatorData.size() <2){
                throw new RuntimeException();
            } else {
                var currentSum = calculatorData.get(0);
                System.out.println(currentSum);
                for(int i = 0; i < calculatorData.size(); i++){
                    currentSum += calculatorData.get(i);
                    System.out.println(String.format("%s%d (=%d)", operator, calculatorData.get(i), currentSum));
                }
                System.out.println(separator);
                System.out.println(String.format("total = %d (%s)", currentSum, operator));
            }
        } catch (FileNotFoundException E){
            throw new RuntimeException("File does not exist, program will exit.");
        }
    }
}

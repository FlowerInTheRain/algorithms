package al.go.heuristique.csvcalc;

import java.io.FileNotFoundException;
import java.util.List;

public interface Parsers {
    List<String> getFileContent(String path) throws FileNotFoundException;
    List<Integer> parse(List<String> lines);
}

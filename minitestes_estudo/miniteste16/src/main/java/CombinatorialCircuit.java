import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    private List<LogicVariable> vars;

    public CombinatorialCircuit() {
        vars = new ArrayList<>();
    }

    public boolean addVariable(LogicVariable var) {
        for (LogicVariable v : vars) {
            if (v.getName().equals(var.getName())) {
                return false;
            }
        }
        vars.add(var);
        return true;
    }

    public LogicVariable getVariableByName(String name) {
        for (LogicVariable var : vars) {
            if (name.equals(var.getName())) {
                return var;
            }
        }
        return null;
    }
}

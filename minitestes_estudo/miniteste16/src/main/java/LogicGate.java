public abstract class LogicGate {
    private LogicVariable output;
    private LogicVariable[] inputs;
    private String formula;

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        return inputs;
    }

    public String getFormula() {
        return formula;
    }

    public void setOutput(LogicVariable output) {
        this.output = output;
    }

    public void setInputs(LogicVariable[] inputs) {
        this.inputs = inputs;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public abstract String getSymbol();

    public abstract boolean outputValue();
}

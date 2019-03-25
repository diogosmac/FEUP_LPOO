public class GateOr extends LogicGate {
    public GateOr(LogicVariable out, LogicVariable firstIn, LogicVariable secondIn) throws ColisionException {
        if (out.getCalculatedBy() != null) {
            throw new ColisionException();
        }
        this.setInputs(new LogicVariable[]{firstIn, secondIn});
        this.setOutput(out);
        this.setFormula(this.getSymbol() + "(" + firstIn.getFormula() + "," + secondIn.getFormula() + ")");
        out.setCalculatedBy(this);
        out.setValue(firstIn.getValue() || secondIn.getValue());
    }

    public String getSymbol() {
        return "OR";
    }

    public boolean outputValue() {
        return (getInputs()[0].getValue() || getInputs()[1].getValue());
    }
}

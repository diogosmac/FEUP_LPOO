public class GateNot extends LogicGate {
    public GateNot(LogicVariable out, LogicVariable in) throws Exception {
        if (out.getCalculatedBy() != null) {
            throw new ColisionException();
        }
        else if (in.getCalculatedBy() != null) {
            for (int i = 0; i < in.getCalculatedBy().getInputs().length; i++) {
                if (in.getCalculatedBy().getInputs()[i].equals(out)) {
                    throw new CycleException();
                }
            }
        }
        this.setInputs(new LogicVariable[]{in});
        this.setOutput(out);
        this.setFormula(this.getSymbol() + "(" + in.getFormula() + ")");
        out.setCalculatedBy(this);
        out.setValue(!in.getValue());
    }

    public String getSymbol() {
        return "NOT";
    }

    public boolean outputValue() {
        return (!getInputs()[0].getValue());
    }
}

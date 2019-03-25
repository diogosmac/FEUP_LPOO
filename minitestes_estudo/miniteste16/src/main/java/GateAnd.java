public class GateAnd extends LogicGate {
    public GateAnd(LogicVariable out, LogicVariable firstIn, LogicVariable secondIn) throws Exception {
        if (out.getCalculatedBy() != null) {
            throw new ColisionException();
        }
        else if (firstIn.getCalculatedBy() != null) {
            for (int i = 0; i < firstIn.getCalculatedBy().getInputs().length; i++) {
                if (firstIn.getCalculatedBy().getInputs()[i].equals(out)) {
                    throw new CycleException();
                }
            }
        }
        else if (secondIn.getCalculatedBy() != null) {
            for (int i = 0; i < secondIn.getCalculatedBy().getInputs().length; i++) {
                if (secondIn.getCalculatedBy().getInputs()[i].equals(out)) {
                    throw new CycleException();
                }
            }
        }
        this.setInputs(new LogicVariable[]{firstIn, secondIn});
        this.setOutput(out);
        this.setFormula(this.getSymbol() + "(" + firstIn.getFormula() + "," + secondIn.getFormula() + ")");
        out.setCalculatedBy(this);
        out.setValue(firstIn.getValue() && secondIn.getValue());
    }

    public String getSymbol() {
        return "AND";
    }

    public boolean outputValue() {
        return (getInputs()[0].getValue() && getInputs()[1].getValue());
    }

}

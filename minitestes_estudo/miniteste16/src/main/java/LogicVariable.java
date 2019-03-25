public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy;
    private String formula;

    public LogicVariable(String name) {
        this(name, true);
    }

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.calculatedBy = null;
        this.formula = name;
    }

    public String getName() {
        return name;
    }
    public boolean getValue() {
        if (calculatedBy != null) {
            value = calculatedBy.outputValue();
        }
        return value;
    }
    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean equals(LogicVariable var) {
        return this.name.equals(var.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        LogicVariable var = (LogicVariable) obj;
        return this.equals(var);
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
        this.formula = calculatedBy.getFormula();
    }

    public String getFormula() {
        return formula;
    }
}

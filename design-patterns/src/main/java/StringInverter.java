public class StringInverter implements StringTransformer {
    private StringDrink drink;

    public StringInverter(StringDrink drink) {
        this.drink = drink;
    }

    public void execute() {
        StringBuffer buff = new StringBuffer(drink.getText());
        buff.reverse();
        drink.setText(buff.toString());
    }

    public void undo() {
        execute();
    }
}

public class StringCaseChanger implements StringTransformer {
    private StringDrink drink;

    public StringCaseChanger(StringDrink drink) {
        this.drink = drink;
    }

    public void execute() {
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char c = drink.getText().charAt(i);
            if (Character.isLowerCase(c)) {
                c = Character.toUpperCase(c);
            }
            else {
                c = Character.toLowerCase(c);
            }

            buff.append(c);
        }
        drink.setText(buff.toString());
    }

    public void undo() {
        execute();
    }
}

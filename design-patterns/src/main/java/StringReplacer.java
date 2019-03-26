public class StringReplacer implements StringTransformer {
    private StringDrink drink;
    private char in;
    private char out;

    public StringReplacer(StringDrink drink, char in, char out) {
        this.drink = drink;
        this.in = in;
        this.out = out;
    }

    public void execute() {
        /*
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < drink.getText().length(); i++) {
            char c = drink.getText().charAt(i);
            if (c == in) buff.append(out);
            else buff.append(c);
        }
        drink.setText(buff.toString());
        */

        drink.setText(drink.getText().replace(in, out));
    }

    public void undo() {
        drink.setText(drink.getText().replace(out, in));
    }
}
